package AO;
import java.sql.*;
import java.util.*;
import AO.datediff.*;
import EO.SchoolEO;
import com.myapp.struts.DataConnection;

///**
// *
// * @author kanchan
// */
public class Day_Report {
//     
//    public Day_Report() {
//    }
//  
//    Connection cn=null;
//    Statement stmt=null;
//    Statement stmt1=null;
//    ResultSet rs3=null;  
//    
//    public SchoolEO feeResult(String month, String syr, String eyr)
//    {
//        
//        EO.SchoolEO gt=null;
//        ArrayList arr=null;
//        try
//       {
//           DataConnection dc=new DataConnection();
//           cn=(Connection)dc.Dataconnect();
//          }catch(Exception e)
//          {}
//        try {
//     String qry1="select sum(adm) as adm,sum(tution) as tution,sum(welfare) as welfare,sum(exam) as exam,sum(comp) as comp,sum(games) as games,sum(lib) as lib,sum(redm) as redm,sum(other) as other,sum(sci) as sci from feedetailreport where mnt='"+month+"' and syear='"+syr+"' and eyear='"+eyr+"'";
//     System.out.println(qry1); 
//     
//               
//            stmt=cn.createStatement();
//            rs3=stmt.executeQuery(qry1);  
//            rs3.next();
//               gt=new EO.SchoolEO();
//               gt.setAdmission(rs3.getInt("adm"));
//               gt.setTution(rs3.getInt("tution"));
//               gt.setExam(rs3.getInt("exam"));
//               gt.setComputer(rs3.getInt("comp"));
//               gt.setGames(rs3.getInt("games"));
//               gt.setLib(rs3.getInt("lib"));
//               gt.setRedm(rs3.getInt("redm"));
//               gt.setOther(rs3.getInt("other"));
//               gt.setScience(rs3.getInt("sci"));
//      
//              // arr.add(gt);
//              
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//       
//     
//        return gt;
//    }
//    
//
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
////  public int returnOther(String month, String syr,String eyr)   
//// {
////     int other=0;
////  try
////       {
////           DataConnection dc=new DataConnection();
////           cn=(Connection)dc.Dataconnect();
////          }catch(Exception e)
////          {}
////     try {   
//// String qry2="select sum(amount) as amount from additionalfee where mnt='"+month+"' and syear='"+syr+"' and eyear='"+eyr+"'"; 
////
////            stmt1=cn.createStatement();
////            ResultSet rs1=stmt1.executeQuery(qry2);  
////            rs1.next();
////             other=rs1.getInt("amount");  
////        } catch (SQLException ex) {
////            ex.printStackTrace();
////        }
////   return other;  
//// 
//// } 
//  
////      public static void main(String aa[])
////    {
////          Day_Report rp=new Day_Report();
////  
////int ui=rp.returnFine("10","2009","2010");
//////        Report rr= new Report();
//////        EO.SchoolEO aa1=rr.feeResult("01","2009","2010");
//////       for(int i=0;i<aa1.size();i++)
//////       {
//////           SchoolEO pp=(SchoolEO)aa1.get(i);
////           
////           System.out.println(ui);
//////      }
////  
////      }  
}