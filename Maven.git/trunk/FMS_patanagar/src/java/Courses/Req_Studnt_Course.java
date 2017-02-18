/*
 * Req_Studnt_Course.java
 *
 * Created on March 24, 2008, 4:01 AM
 */

package Courses;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.myapp.struts.Dataconnectivity;
import java.sql.SQLException;

public class Req_Studnt_Course extends HttpServlet {
    Connection course_con=null;
    PreparedStatement course_pstmt=null;
    PreparedStatement course_pstmt1=null;
    PreparedStatement course_pstmt2=null;
    ResultSet course_rs=null;
    ResultSet course_rs1=null;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] c_id=(String[])request.getParameterValues("c_id");
        HttpSession ses=request.getSession();        
        String studnt_id=(String)ses.getAttribute("forwardname");
         try{
         Dataconnectivity addcourse=new Dataconnectivity();
        course_con=(Connection)addcourse.Dataconnect();
    }
       catch(Exception e)
       {
       out.println("DatabaseDown1");
       }
        
        for(int i=0;i<c_id.length;i++)
        {
        
         String sel_emp= "select emp_id ,c_id from ex_emp_course where c_id='"+c_id[i]+"'";
         try
{
course_pstmt=course_con.prepareStatement(sel_emp);
course_rs=course_pstmt.executeQuery();
         
while(course_rs.next())
{
   
    String insert_course="insert into ex_stdnt_req_course(c_id,emp_id,studnt_id,approve)values(?,?,?,?)";
            course_pstmt1=course_con.prepareStatement(insert_course);
            course_pstmt1.setString(1,(String)course_rs.getString("c_id"));
            course_pstmt1.setString(2,(String)course_rs.getString("emp_id"));
             course_pstmt1.setString(3,studnt_id);
             course_pstmt1.setString(4,"p");
            
             
             
              course_pstmt1.executeUpdate();
              
            // String request_course="update course_req set req=? where studnt_id='"+studnt_id+"' and c_id='"+(String)course_rs.getString("c_id")+"'";
            //course_pstmt2=course_con.prepareStatement(request_course);
            //course_pstmt2.setString(1,"r");
            
            
             
             // course_pstmt2.executeUpdate();              
            
            String request_course="insert into ex_course_req(c_id,studnt_id,req)values(?,?,?)";
            course_pstmt2=course_con.prepareStatement(request_course);
            course_pstmt2.setString(1,(String)course_rs.getString("c_id"));
           
             course_pstmt2.setString(2,studnt_id);
             course_pstmt2.setString(3,"r");            
              course_pstmt2.executeUpdate();            
              
}    
         }
         catch(SQLException e)
{
out.println(e.getMessage());
}

        }
        
       
        String cor_data="Your Request of Courses Submitted Successfully ";
            request.setAttribute("course_success",cor_data);
            RequestDispatcher rf=request.getRequestDispatcher("/Courses_Detail/Courses_Student_Available.jsp");
            rf.forward(request,response);
        
        out.close();  
    
    }
   }
