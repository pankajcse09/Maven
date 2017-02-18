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

/**
 *
 * @author piyushrastogi
 * @version
 */
public class RemoveCours extends HttpServlet {
    
    Connection course_con=null;
    PreparedStatement course_pstmt=null;
    ResultSet course_rs=null;
   
    public  void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        String ssn=(String)request.getParameter("session");
        String clas=(String)request.getParameter("class");
        String sub=(String)request.getParameter("subject");
         try{
         Dataconnectivity corse=new Dataconnectivity();
         course_con=(Connection)corse.Dataconnect();
         }
       catch(Exception e)
       {
       out.println("DatabaseDown1");
       }
         try{
             String insert_course="delete from ex_course_detail where sessions='"+ssn+"' and class='"+clas+"' and subject='"+sub+"'";            
             course_pstmt=course_con.prepareStatement(insert_course);             
             course_pstmt.executeUpdate();
             String cor_data=sub+" Removed Successfully";             
            request.setAttribute("course_success",cor_data);
            RequestDispatcher rf=request.getRequestDispatcher("/Courses_Detail/RemoveCourse.jsp");
            rf.forward(request,response);                              
          }
        catch(SQLException e)
        {        
       out.println(e.getMessage());
        } 
        out.close();
    }
}
