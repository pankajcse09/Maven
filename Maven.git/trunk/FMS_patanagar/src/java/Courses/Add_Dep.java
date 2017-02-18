/*
 * Add_Dep1.java
 *
 * Created on March 28, 2008, 11:32 PM
 */

package Courses;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.myapp.struts.Dataconnectivity;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Add_Dep extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    Connection dep_con=null;
    PreparedStatement dep_pstmt=null;
    java.util.Date nd =null;
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
          try{
         Dataconnectivity addep=new Dataconnectivity();
        dep_con=(Connection)addep.Dataconnect();
    }
       catch(Exception e)
       {
      response.sendRedirect(request.getContextPath()+"/error.jsp");
       }
        
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        
       String college=(String)request.getParameter("college1");
       String dep=(String)request.getParameter("dep");       
       
      //java.sql.Timestamp sq =new java.sql.Timestamp(nd.getTime());
       
        try{
             String insert_course="insert into ex_add_dep(college,dep)values(?,?)";
            dep_pstmt=dep_con.prepareStatement(insert_course);
            dep_pstmt.setString(1,college);
            dep_pstmt.setString(2,dep);
                        
            dep_pstmt.executeUpdate();
            String dep_data="Department Added Successfully ";
            getServletContext().setAttribute("dep_success",dep_data);
            response.sendRedirect(request.getContextPath()+"/Add_Dep/Enter_Dep.jsp");
            
         }
        catch(SQLException e)
        {
        
       out.println(e.getMessage());
        }
       
       finally {           
                        try{
                  
           if(dep_pstmt!=null)dep_pstmt.close();
           if(dep_con!=null)dep_con.close();
           
          
              }catch(SQLException se)
              {
              out.println(se.getMessage());
              }
               
          }
        out.close();
    }
    
}

   