/*
 * Add_Courser_To_Prof.java
 *
 * Created on March 19, 2008, 12:42 PM
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


/**
 *
 * @author piyushrastogi
 * @version
 */
public class Add_Courser_To_Prof extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
     Connection course_con=null;
    PreparedStatement course_pstmt=null;
    ResultSet course_rs=null;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        String fname=(String)request.getParameter("fname");
        String lname=(String)request.getParameter("lname");
        String mname=(String)request.getParameter("mname");
        String id=(String)request.getParameter("id");
        String dep =(String)request.getParameter("dep");
        String[] cid=(String[])request.getParameterValues("c_id");
         try{
         Dataconnectivity addmemcon=new Dataconnectivity();
        course_con=(Connection)addmemcon.Dataconnect();
    }
       catch(Exception e)
       {
       out.println("DatabaseDown1");
       }
        
        
        String add_mem="insert into ex_emp_course(emp_id,emp_fname,emp_mname,emp_lname,emp_dep,c_id)values(?,?,?,?,?,?)"; 
     try{   
     course_pstmt=course_con.prepareStatement(add_mem);
     
    // ArrayList memname=(ArrayList)request.getParameterValues("memname");
     // ArrayList memmidname=(ArrayList)request.getParameterValues("memmidname");
     // ArrayList memlastname=(ArrayList)request.getParameterValues("memlastname");
     // Object[] fname = memname.toArray();
    //Object[] mname =memmidname.toArray();
    //Object[] lname = memlastname.toArray();
     //out.println(mem_type);
     for (int i = 0; i <cid.length; i++)
     {
     course_pstmt.setString(1,id);
     course_pstmt.setString(2,fname);          
      course_pstmt.setString(3,mname);
      course_pstmt.setString(4,lname);
      course_pstmt.setString(5,dep);
      course_pstmt.setString(6,cid[i]);
      // memadd_pstmt.setObject(5,fname[i]);
       // memadd_pstmt.setObject(6,mname[i]);
        // memadd_pstmt.setObject(7,lname[i]);
      
       course_pstmt.executeUpdate();
  }
     }
     catch(SQLException e)
     {
     out.println(e.getMessage());
     }
    String success="Courses Added Successfully";
    request.setAttribute("addmemsuc",success);
    RequestDispatcher rf=request.getRequestDispatcher("/Courses_Detail/Courses_Assign_Prof_req.jsp?para="+id+"&p1="+fname+"&p2="+mname+"&p3="+lname);
    rf.forward(request,response);
     out.close();
    }
}
