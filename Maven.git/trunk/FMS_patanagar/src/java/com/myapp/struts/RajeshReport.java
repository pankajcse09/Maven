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
public class RajeshReport extends HttpServlet {
       
     static Connection con=null;
    static Statement stmt=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
   ArrayList arr=new ArrayList();
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
   
        PrintWriter out=response.getWriter();
       
      
        
        
       String course=(String)request.getParameter("course");
       String session=request.getParameter("session");
       String stud=request.getParameter("stud");
       
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
           }catch(SQLException rr){}
          request.setAttribute("data",arr); 
        RequestDispatcher dd=request.getRequestDispatcher("/Reports/InternalmarksReport.jsp");
        dd.forward(request,response);
       }
    }  
}
