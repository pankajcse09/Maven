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
 * @author Rajesh
 * @version
 */
public class extshowreport extends HttpServlet {
       
    static Connection con=null;
    static Statement stmt=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
   ArrayList arr=new ArrayList();
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
    throws ServletException,IOException {
       response.setContentType("text/html;charset=UTF-8");   
       PrintWriter out=response.getWriter();
       //DataMethods dm=new DataMethods(); 
       String course=(String)request.getParameter("course");
       String session=(String)request.getParameter("session");
       String stud=(String)request.getParameter("stud");
       //ArrayList arr=(ArrayList)dm.updateData(course,session,stud);
       
           try{             
           String st="select * from extmarks where studid='"+stud+"' and years='"+session+"' and course_id='"+course+"'";
           //in(select id from ex_course_detail where title='"+course+"')";         
           pstmt=con.prepareStatement(st);
           
           rs=pstmt.executeQuery();         
          
           while(rs.next())
           {
               examEO obj=new examEO();
              obj.setStudid((String)rs.getString("studid"));
              obj.setSession((String)rs.getString("years"));
              obj.setSemester((String)rs.getString("semester"));
              obj.setDegree((String)rs.getString("degree"));
              obj.setCourseid((String)rs.getString("course_id"));
              obj.setExternal(rs.getDouble("external"));
              arr.add(obj);                  
           }           
           }
           catch(SQLException rr)
           {
           out.println(rr.getMessage());    
           }         
       request.setAttribute("data",arr); 
       RequestDispatcher dd=request.getRequestDispatcher("/Reports/ExternalmarksReport.jsp");
       dd.forward(request,response);
           
            }
       }
        
        
    
    
  
   