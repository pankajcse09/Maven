
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
public class ClsWTransFee {
     
    public ClsWTransFee() {
    }
  
    Connection cn=null;
    Statement stmt=null;
    Statement stmt1=null;
    ResultSet rs3=null;  
    
    public SchoolEO feeResult(String month,String sr,String classes, String sec, String syr,String eyr)
    {
        
        EO.SchoolEO gt=null;
        ArrayList arr=null;
        try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        try {
     String qry1="select amount,fsubdate from feedetailreport where mnt='"+month+"' and srnum='"+sr+"' and classes="+classes+"' and section='"+sec+"' and syear='"+syr+"' and eyear='"+eyr+"'";
     System.out.println(qry1); 
     
               
            stmt=cn.createStatement();
            rs3=stmt.executeQuery(qry1);  
            rs3.next();
               gt=new EO.SchoolEO();
               gt.setTfee(rs3.getInt("amount"));
               gt.setFeesubdate(rs3.getString("fsubdate"));
               
              // arr.add(gt);
              
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
     
        return gt;
    }
    

// public int returnFine(String month, String syr,String eyr)   
// {
//     int due=0;
//  try
//       {
//           DataConnection dc=new DataConnection();
//           cn=(Connection)dc.Dataconnect();
//          }catch(Exception e)
//          {}
//     try {   
// String qry2="select sum(due) as due from finerecord where mnt='"+month+"' and exemptby='NotExempted' and syear='"+syr+"' and eyear='"+eyr+"'"; 
//
//            stmt=cn.createStatement();
//            ResultSet  rs=stmt.executeQuery(qry2);  
//            rs.next();
//            due=rs.getInt("due");  
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//   return due;  
// 
// } 
//  public int returnOther(String month, String syr,String eyr)   
// {
//     int other=0;
//  try
//       {
//           DataConnection dc=new DataConnection();
//           cn=(Connection)dc.Dataconnect();
//          }catch(Exception e)
//          {}
//     try {   
// String qry2="select sum(amount) as amount from additionalfee where mnt='"+month+"' and syear='"+syr+"' and eyear='"+eyr+"'"; 
//
//            stmt1=cn.createStatement();
//            ResultSet rs1=stmt1.executeQuery(qry2);  
//            rs1.next();
//             other=rs1.getInt("amount");  
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//   return other;  
// 
// } 
  
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