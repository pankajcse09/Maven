/*
 * Insert_Courses_Details.java
 *
 * Created on March 14, 2008, 4:02 PM
 */
package Courses;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.myapp.struts.Dataconnectivity;
import java.sql.SQLException;

public class Insert_Courses_Details extends HttpServlet {
    
    Connection course_con=null;
    PreparedStatement course_pstmt=null;
    Statement stmt=null;
    PreparedStatement psmt=null;
    ResultSet rs1=null;
    ResultSet rs=null;
   
    public  void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         String ch=(String)request.getParameter("p");                 
         String ssn=(String)request.getParameter("session");
         String clas=(String)request.getParameter("class");
         String sub=(String)request.getParameter("subject"); 
         String theory=(String)request.getParameter("theory");
         String prac=(String)request.getParameter("practical");
         String mcq=(String)request.getParameter("mcq");
         String unit=(String)request.getParameter("unittest");
     
         String cor_data="";
         String cc="";
         int count=0;
         int count1=0;         
        
                   try{
         Dataconnectivity corse=new Dataconnectivity();
        course_con=(Connection)corse.Dataconnect();
    }
       catch(Exception e)
       {
       out.println("DatabaseDown");
       }
         try{
//             String check="select count(sessions) as cnt from studinfo where sessions='"+ssn+"'";            
//             psmt=course_con.prepareStatement(check);  
//             rs1=psmt.executeQuery();             
//             
//             count1=rs1.getInt("cnt");
//             
//             String ms="";
//             if(count1!=0){
//             ms="Course Already Exist";                        
//            request.setAttribute("msg",ms);
//            RequestDispatcher rf=request.getRequestDispatcher("/Courses_Detail/Courses_Detail.jsp");
//            rf.forward(request,response); 
//             }
             if(count1==0){
             String insert_course="";
             
             cc="select count(subject) as cnt from ex_course_detail where subject='"+sub+"' and class='"+clas+"' and sessions='"+ssn+"'";
             stmt=course_con.createStatement();
             rs=stmt.executeQuery(cc);
             while(rs.next()){
             count=rs.getInt("cnt");    
             }
             if(count>0){
             cor_data="Subject "+sub+" Already Exists";    
             request.setAttribute("course_success",cor_data);
             RequestDispatcher r=request.getRequestDispatcher("/Courses_Detail/Courses_Detail.jsp");
             r.forward(request,response);    
             }
             else{
             insert_course="insert into ex_course_detail(sessions,class,subject,theory,practical,mcq,unittest,exist)values(?,?,?,?,?,?,?,?)";
             }
             course_pstmt=course_con.prepareStatement(insert_course);
             course_pstmt.setString(1,ssn);
             course_pstmt.setString(2,clas);
             course_pstmt.setString(3,sub);
             course_pstmt.setString(4,theory);
             course_pstmt.setString(5,prac);             
             course_pstmt.setString(6,mcq);      
             course_pstmt.setString(7,unit); 
             course_pstmt.setString(8,"y");            
            
             course_pstmt.executeUpdate();              
            
             cor_data="Subject Added Successfully";           
         
            request.setAttribute("course_success",cor_data);
            
            RequestDispatcher rd=request.getRequestDispatcher("/Courses_Detail/Courses_Detail.jsp");      
            rd.forward(request,response);           
           }
          }
         catch(SQLException e){           
         request.setAttribute("course_success","DataBase Error");    
         RequestDispatcher rd1=request.getRequestDispatcher("/Courses_Detail/Courses_Detail.jsp");
         rd1.forward(request,response);          
        } 
         finally{
         try{
         if(rs!=null){}
         if(rs1!=null){}        
         if(stmt!=null){}
         if(psmt!=null){}
         if(course_pstmt!=null){course_pstmt.close();}
         if(course_con!=null){course_con.close();}
        }
        catch(SQLException se){
        out.println(se.getMessage());    
        }
         }
        out.close();
    }
}
