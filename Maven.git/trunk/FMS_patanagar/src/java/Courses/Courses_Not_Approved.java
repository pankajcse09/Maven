/*
 * Courses_Not_Approved.java
 *
 * Created on March 25, 2008, 11:55 AM
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

public class Courses_Not_Approved extends HttpServlet {

    Connection app_con=null;
    PreparedStatement app_pstmt=null;
    PreparedStatement app_pstmt1=null;
    ResultSet app_rs=null;
    public void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String c_id=request.getParameter("co_id");
        String[] studnt_id=(String[])request.getParameterValues("studnt_id");        
        try{
         Dataconnectivity addcourse=new Dataconnectivity();
        app_con=(Connection)addcourse.Dataconnect();
    }
       catch(Exception e)
       {
       out.println("DatabaseDown1");
       }
        try{
        for(int i=0;i<studnt_id.length;i++)
        {
    String insert_course="update ex_stdnt_req_course set disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";
            app_pstmt1=app_con.prepareStatement(insert_course);
            app_pstmt1.setString(1,"d");
            
              app_pstmt1.executeUpdate();
         
}
         }
         catch(SQLException e)
{
out.println(e.getMessage());
}   
        }
    }
    
    