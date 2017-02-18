/*
 * RajeshReport.java
 *
 * Created on July 7, 2008, 5:32 PM
 */

package com.myapp.struts;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Rajesh
 * @version
 */
public class storedata extends HttpServlet {
       
     static Connection con=null;
    static Statement stmt=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
 
  // ArrayList arr=new ArrayList();
    // CategoryActionForm frm=null;
  static
  {
      try{
  Dataconnectivity dcc=new Dataconnectivity();
   con=(Connection)dcc.Dataconnect();
      }
      catch(Exception e){}
  } 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
   
        PrintWriter out=response.getWriter();
       
      
        
        
       String course_id=(String)request.getParameter("course");
       String years=request.getParameter("session");
       String studid=request.getParameter("studid");
       String semester=request.getParameter("semester");
       String degree=request.getParameter("degree");
       double midterm=Double.parseDouble(request.getParameter("midterm").toString());
       double endterm=Double.parseDouble(request.getParameter("endterm").toString());
       double intpractical=Double.parseDouble(request.getParameter("practical").toString());
       String attendance=request.getParameter("attendance");
      out.println(course_id);
      out.println(years);
      out.println(studid);
      out.println(semester);
      out.println(degree);
      out.println(midterm);
      out.println(endterm);
      out.println(intpractical);
      out.println(attendance);
      
       if(studid !=null)
       {
          
           try{
           String ss="update addmarks set studid=?,years=?,semester=?,degree=?,course_id=?,midterm=?,endterm=?,intpractical=?,attendance=? where studid='"+studid+"' and course_id='"+course_id+"' and years='"+years+"'";
           pstmt=con.prepareStatement(ss);
           pstmt.setString(1,studid);
           pstmt.setString(2,years);
           pstmt.setString(3,semester);
           pstmt.setString(4,degree);
           pstmt.setString(5,course_id);
           pstmt.setDouble(6,midterm);
           pstmt.setDouble(7,endterm);
           pstmt.setDouble(8,intpractical);
           pstmt.setString(9,attendance);
           pstmt.executeUpdate();
                             
           }
           catch(SQLException rr)
           {
           out.println(rr.getMessage());    
           }        
        RequestDispatcher dd=request.getRequestDispatcher("/Reports/success.jsp");
        dd.forward(request,response);    
       }
    }
 
        
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
