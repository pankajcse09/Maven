
package AO;
import java.sql.*;
import java.util.*;
import AO.datediff.*;
import EO.SchoolEO;
import com.myapp.struts.DataConnection;

/**
 *
 * @author Sonal
 */
public class TfDateWise_Report {
     
    public TfDateWise_Report() {
    }
  
    Connection cn=null;
    Statement stmt=null;
    Statement stmt1=null;
    ResultSet rs3=null;  
    
    public int tfeeResult(String dt, String syr, String eyr)
    {
        
     int amt=0; 
        try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        try {
     String qry1="select sum(paying) as amount from transfeerecord where fsubdate='"+dt+"' and syear='"+syr+"' and eyear='"+eyr+"'";
     System.out.println(qry1); 
             
            stmt=cn.createStatement();
            rs3=stmt.executeQuery(qry1);  
            rs3.next();
              amt=rs3.getInt("amount");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
     
        return amt;
    }
    

 public int returnTFine(String dt, String syr,String eyr)   
 {
     int due=0;
  try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     try {   
 String qry2="select sum(due) as due from transfinerecord where fsubdate='"+dt+"' and exemptby='NotExempted' and syear='"+syr+"' and eyear='"+eyr+"'"; 
  
            stmt=cn.createStatement();
            ResultSet  rs=stmt.executeQuery(qry2);  
            rs.next();
            due=rs.getInt("due");       
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   return due;  
 
 } 
 
  
      public static void main(String aa[])
    {
          TfDateWise_Report rp=new TfDateWise_Report();
  
int ui=rp.tfeeResult("13/01/2010","2009","2010");
 //      Report rr= new Report();
  //     EO.SchoolEO aa1=rp.feeResult("11/01/2010","2009","2010");
      //for(int i=0;i<aa1.size();i++)
     // {
      //   SchoolEO pp=(SchoolEO)aa1.get(i);
           
           System.out.println(ui);
  //   }
  
      }  
}