///*
// * Day_Report.java
// *
// * Created on February 19, 2009, 5:40 PM
// *
// * To change this template, choose Tools | Template Manager
// * and open the template in the editor.
// */
//
//
//package AO;
//import java.sql.*;
//import java.util.*;
//import AO.datediff.*;
//import EO.SchoolEO;
//import com.myapp.struts.DataConnection;
//
///**
// *
// * @author kanchan
// */
//public class PerDayR {
//     
//    public PerDayR() {
//    }
//  
//    Connection cn=null;
//    Statement stmt=null;
//    Statement stmt1=null;
//    ResultSet rs3=null;  
//    
//    public SchoolEO feeResult(String dt,String sr)
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
//     String qry1="select sum(adm) as adm,sum(tution) as tution,sum(welfare) as welfare,sum(exam) as exam,sum(comp) as comp,sum(games) as games,sum(lib) as lib,sum(redm) as redm,sum(other) as other,sum(sci) as sci from feerecord where fsubdate='"+dt+"' and srnum='"+sr+"'";
//     System.out.println(qry1); 
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
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//     
//        return gt;
//    }
//
// public int returnFine(String dt,String sr)   
// {
//     int due=0;
//  try
//       {
//           DataConnection dc=new DataConnection();
//           cn=(Connection)dc.Dataconnect();
//          }catch(Exception e)
//          {}
//     try {   
// String qry2="select sum(due) as due from finerecord where fsubdate='"+dt+"' and srnum='"+sr+"' and exemptby='NotExempted'"; 
//     System.out.println(qry2); 
//            stmt=cn.createStatement();
//            ResultSet  rs=stmt.executeQuery(qry2);  
//            rs.next();
//            due=rs.getInt("due");      System.out.println("due"+due);  
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//   return due;  
// 
// } 
// 
// 
// 
////      public static void main(String aa[])
////    {
////          PerDayR rp=new PerDayR();
////  
////EO.SchoolEO aa1=rp.feeResult("11/01/2010","1242");
//// //      Report rr= new Report();
////  //     EO.SchoolEO aa1=rp.feeResult("11/01/2010","2009","2010");
////      //for(int i=0;i<aa1.size();i++)
////     // {
////      //   SchoolEO pp=(SchoolEO)aa1.get(i);
////           
////           System.out.println(aa1.getTution());
////  //   }
////  
////      }  
//}