/*
 * RajeshReport.java
 *
 * Created on July 7, 2008, 5:32 PM
 */

package com.myapp.struts;

import java.io.*;
import java.net.*;

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
public class updateExternal extends HttpServlet {
       
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
       {examEO obj=new examEO();
           ArrayList arr=new ArrayList();
           try{
           String ss="select * from extmarks where studid='"+stud+"' and years='"+course+"' and course_id='"+session+"'";
          
          
           pstmt=con.prepareStatement(ss);
           rs=pstmt.executeQuery();
           rs.next();
         
               
             obj.setStudid(rs.getString("studid"));
              
              obj.setSession(rs.getString("years"));
                
              obj.setSemester(rs.getString("semester"));
               
              obj.setDegree(rs.getString("degree"));
                
              obj.setCourseid(rs.getString("course_id"));
                
              obj.setExternal(rs.getDouble("external"));                
           
              arr.add(obj);                  
           
           }catch(SQLException rr)
           {
           out.println(rr.getMessage());    
           }
        request.setAttribute("data",arr); 
        RequestDispatcher dd=request.getRequestDispatcher("/Reports/Externalmarksupdate.jsp");
        dd.forward(request,response);
       
       }
    }
        
}   
    
    
  
  

