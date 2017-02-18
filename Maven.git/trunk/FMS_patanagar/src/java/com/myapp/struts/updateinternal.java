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
import java.util.ArrayList;
/**
 *
 * @author Rock
 * @version
 */
public class updateinternal extends HttpServlet {
       
     static Connection con=null;
    static Statement stmt=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
    ArrayList arr=new ArrayList();
   
  static
  {
   try{   
   Dataconnectivity dcc=new Dataconnectivity();
   con=(Connection)dcc.Dataconnect();
   }
   catch(Exception e){ }
  } 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
        PrintWriter out=response.getWriter();
       String course=(String)request.getParameter("course");
       String session=request.getParameter("session");
       String stud=request.getParameter("stud");
       out.println(course);
       out.println(session);
       out.println(stud);
       if(stud !=null)
       {
           ArrayList arr=new ArrayList();
           try{
           String ss="select * from addmarks where studid='"+stud+"' and course_id='"+course+"' and years='"+session+"'";
           pstmt=con.prepareStatement(ss);
           rs=pstmt.executeQuery();
           while(rs.next())
           {
               examEO obj=new examEO();
              obj.setStudid((String)rs.getString("studid"));
              obj.setSession((String)rs.getString("years"));
              obj.setSemester((String)rs.getString("semester"));
              obj.setDegree((String)rs.getString("degree"));
              obj.setCourseid((String)rs.getString("course_id"));
              obj.setMidterm(rs.getDouble("midterm"));
              obj.setEndterm(rs.getDouble("endterm"));
              obj.setInternalpractical(rs.getDouble("intpractical"));
              obj.setAttendance(rs.getString("attendance"));
              arr.add(obj);
                     
           }
           }catch(SQLException rr)
           {
            out.println(rr.getMessage());    
           }
          request.setAttribute("data",arr); 
        RequestDispatcher dd=request.getRequestDispatcher("/Reports/InternalmarksEntry.jsp");
        dd.forward(request,response);
        out.print("servlet data");
       }}
        
        
    
    
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
