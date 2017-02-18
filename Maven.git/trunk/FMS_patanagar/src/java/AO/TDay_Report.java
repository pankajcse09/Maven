

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
public class TDay_Report {
     
    public TDay_Report() {
    }
  
    Connection cn=null;
    Statement stmt=null;
    Statement stmt1=null;
    ResultSet rs3=null;  
    
    public int tfeeResult(String month, String syr, String eyr)
    {
        
      
       int amt=0;
        try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        try {
     String qry1="select sum(amount) as amount from transfeedetailreport where mnt='"+month+"' and syear='"+syr+"' and eyear='"+eyr+"'";
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
    

 public int returnTFine(String month, String syr,String eyr)   
 {
     int due=0;
  try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     try {   
 String qry2="select sum(due) as due from transfinerecord where mnt='"+month+"' and exemptby='NotExempted' and syear='"+syr+"' and eyear='"+eyr+"'"; 

            stmt=cn.createStatement();
            ResultSet  rs=stmt.executeQuery(qry2);  
            rs.next();
            due=rs.getInt("due");  
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   return due;  
 
 } 
 
  
//      public static void main(String aa[])
//    {
//          Day_Report rp=new Day_Report();
//  
//int ui=rp.returnFine("10","2009","2010");
////        Report rr= new Report();
////        EO.SchoolEO aa1=rr.feeResult("01","2009","2010");
////       for(int i=0;i<aa1.size();i++)
////       {
////           SchoolEO pp=(SchoolEO)aa1.get(i);
//           
//           System.out.println(ui);
////      }
//  
//      }  
}