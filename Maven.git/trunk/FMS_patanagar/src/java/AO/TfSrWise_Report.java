
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
public class TfSrWise_Report {
     
    public TfSrWise_Report() {
    }
  
    Connection cn=null;
    Statement stmt=null;
    Statement stmt1=null;
    ResultSet rs3=null;  
    
    public int tfeeResult(String dt,String sr, String syr, String eyr)
    {
      
        int am=0;
        try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        try {
     String qry1="select sum(paying) as amount from transfeerecord where fsubdate='"+dt+"' and srnum='"+sr+"' and syear='"+syr+"' and eyear='"+eyr+"'";
     System.out.println(qry1); 
             
            stmt=cn.createStatement();
            rs3=stmt.executeQuery(qry1);  
            rs3.next();
               am=rs3.getInt("amount");
              // arr.add(gt);
              
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
     
        return am;
    }
    

 public int returnTFine(String dt,String sr, String syr,String eyr)   
 {
     int due=0;
  try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     try {   
 String qry2="select sum(due) as due from transfinerecord where fsubdate='"+dt+"' and srnum='"+sr+"' and exemptby='NotExempted' and syear='"+syr+"' and eyear='"+eyr+"'"; 
     System.out.println(qry2); 
            stmt=cn.createStatement();
            ResultSet  rs=stmt.executeQuery(qry2);  
            rs.next();
            due=rs.getInt("due");         System.out.println(due); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   return due;  
 
 } 
 
  
//      public static void main(String aa[])
//    {
//          SfDateWise_Report rp=new SfDateWise_Report();
//  
//int ui=rp.returnFine("11/01/2010","2009","2010");
// //      Report rr= new Report();
//  //     EO.SchoolEO aa1=rp.feeResult("11/01/2010","2009","2010");
//      //for(int i=0;i<aa1.size();i++)
//     // {
//      //   SchoolEO pp=(SchoolEO)aa1.get(i);
//           
//           System.out.println(ui);
//  //   }
//  
//      }  
}