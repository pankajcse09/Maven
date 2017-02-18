///*
// * Dispregforfee.java
// *
// * Created on August 22, 2008, 4:57 PM
// */
//
//package AO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.DynaActionForm;
//import com.myapp.struts.DataConnection;
//import java.sql.*;
//import java.util.*;
//import AO.datediff.*;
//import EO.SchoolEO;
//import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpSession;
//import java.lang.NullPointerException;
//import java.text.SimpleDateFormat;
///**
// *
// * @author sonal
// * @version
// */
//
//public class SchoolFeeDayBook extends Action {
//    
//    Connection cn=null;
//    Statement stmt=null;
//    Statement stmt1=null;
//    Statement stmt2=null;
//    Statement stmt3=null;
//    ResultSet rs=null;
//    ResultSet rs1=null;
//    ResultSet rs2=null;
//    ResultSet rs3=null;
// 
//   private final static String SUCCESS = "success";
//    
//    public ActionForward execute(ActionMapping mapping, ActionForm  form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//       
//          PrintWriter out= response.getWriter();
//          ArrayList arr=new ArrayList();
//          ArrayList arr1=new ArrayList();
//          ArrayList arr2=new ArrayList();
//          
//          try
//       {
//           DataConnection dc=new DataConnection();
//           cn=(Connection)dc.Dataconnect();
//          }catch(Exception e)
//          {}
//  
// /******************************Displaying Detail of fees *************************/
//          String disp=request.getParameter("disp");
//          if(disp!=null)
//          {
//        
//       try
//        {
//       
//           String syear=request.getParameter("syear");    
//           String eyear=request.getParameter("eyear");   
//           EO.SchoolEO gt=null;
//           EO.SchoolEO gt1=null;
//           EO.SchoolEO gt2=null;
//           
//   String qry="Select mntnum from allmonth";        
//       out.println(qry);  
//       stmt3=cn.createStatement();
//          rs3=stmt3.executeQuery(qry);  
//         while(rs3.next())
//         { 
//         String mon=rs3.getString("mntnum");
//         String qry1="select sum(adm),sum(tution),sum(welfare),sum(exam),sum(comp),sum(games),sum(lib),sum(redm),sum(other),sum(sci) from feedetailreport where mnt='"+mon+"'";        
//         out.println(qry1);  
//           stmt=cn.createStatement();
//           rs=stmt.executeQuery(qry1);  
//           while(rs.next())
//             {
//              gt=new EO.SchoolEO();
//              gt.setAdmission(rs3.getInt("adm"));
//              gt.setTution(rs3.getInt("tution"));
//              gt.setExam(rs3.getInt("exam"));
//              gt.setComputer(rs3.getInt("comp"));
//              gt.setGames(rs3.getInt("games"));
//              gt.setLib(rs3.getInt("lib"));
//              gt.setRedm(rs3.getInt("redm"));
//              gt.setOther(rs3.getInt("other"));
//              gt.setScience(rs3.getInt("sci"));
//      
//              arr.add(gt);
//             }
//           
//           String qry2="select sum(due) from finerecord where mnt='"+mon+"' and status='NotExempted'";        
//           out.println(qry2);  
//           stmt1=cn.createStatement();
//           rs1=stmt1.executeQuery(qry2);  
//           while(rs1.next())
//             {
//              gt1=new EO.SchoolEO();
//              gt1.setDue(rs3.getInt("due"));
//                   
//              arr1.add(gt1);
//             }
//           
//            String qry3="select sum(amount) from additionalfee where mnt='"+mon+"'";        
//         out.println(qry3);  
//           stmt2=cn.createStatement();
//           rs2=stmt2.executeQuery(qry3);  
//           while(rs2.next())
//             {
//              gt2=new EO.SchoolEO();
//              gt2.setOther(rs3.getInt("amount"));
//                   
//              arr2.add(gt2);
//             }
//           
//              
//         }
//       
//          request.setAttribute("arr",arr);
//          request.setAttribute("arr1",arr1);
//          request.setAttribute("arr2",arr2);
//             
//          }catch(SQLException ee)
//          {
//          
//                ee.getStackTrace();
//            }
//          
//             try
//           {
//             if(stmt3!=null)
//             {stmt3.close();}
//             if(rs3!=null)
//             {rs3.close();}
//              if(cn!=null)
//             {
//                 cn.close();
//              } 
//               }catch(SQLException e){}
// 
//             
//               
//          }  
//             return mapping.findForward("success");
//        
//       
//    }
//}
