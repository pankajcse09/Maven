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
import java.sql.PreparedStatement;
import com.myapp.struts.Dataconnectivity;
import java.sql.SQLException;

public class Edit_Course_Detail extends HttpServlet {
    
    Connection course_con=null;
    PreparedStatement course_pstmt=null;
    PreparedStatement psmt=null;
    ResultSet rs1=null;      
   
    public  void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
         String ssn=(String)request.getParameter("session");
         String clas=(String)request.getParameter("class");
         String sub=(String)request.getParameter("subject");
         String th=(String)request.getParameter("theory");
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
       out.println("DatabaseDown1");
       }
         try{
//             String check="select count(sessions) as cnt from studinfo where sessions='"+ssn+"'";            
//             psmt=course_con.prepareStatement(check);  
//             rs1=psmt.executeQuery();             
//             if(rs1.next()){
//             count1=rs1.getInt("cnt");
//             }    
//             String ms="";
//             if(count1>0){
//             ms="Session Going On Updation not Allowed";  
//             
//            request.setAttribute("msg",ms);
//            RequestDispatcher rf=request.getRequestDispatcher("/Courses_Detail/EditCourseDetail.jsp");
//            rf.forward(request,response); 
//            }
//             if(count1==0){
             String insert_course="";
                     
             insert_course="update ex_course_detail set theory=?,practical=?,mcq=?,unittest=? where sessions='"+ssn+"' and class='"+clas+"' and subject='"+sub+"'";            
             
             course_pstmt=course_con.prepareStatement(insert_course);
             course_pstmt.setString(1,th);
             course_pstmt.setString(2,prac);
             course_pstmt.setString(3,mcq);   
             course_pstmt.setString(4,unit); 
         
             course_pstmt.executeUpdate();  
             
             cor_data=sub+" UpDated";    
             
            request.setAttribute("msg",cor_data);         
            RequestDispatcher r=request.getRequestDispatcher("/Courses_Detail/EditCourseDetail.jsp?session="+ssn+"&class="+clas+"&subject="+sub);
            r.forward(request,response);             
             //}
          }
         catch(SQLException e){        
         RequestDispatcher r1=request.getRequestDispatcher("/Courses_Detail/EditCourse.jsp");
         r1.forward(request,response);                  
        } 
         finally{
        try{        
         if(rs1!=null){}                
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

