/*
 * RajeshReport.java
 *
 * Created on July 7, 2008, 5:32 PM
 */

package com.myapp.struts;

import java.io.*;
import java.util.ArrayList;
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
public class storedata1 extends HttpServlet {
       
    static Connection con=null;
    static Statement stmt=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
 
     // ArrayList arr=new ArrayList();
    // CategoryActionForm frm=null;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");    
        PrintWriter out=response.getWriter();
        try{    
   Dataconnectivity dcc=new Dataconnectivity();
   con=(Connection)dcc.Dataconnect();
  }
  catch(Exception e){} 
       //DataMethods dm=new DataMethods(); 
       //ArrayList arr=new ArrayList();        
       String course_id=(String)request.getParameter("course");
       String years=(String)request.getParameter("session");
       String studid=(String)request.getParameter("studid");
       String semester=(String)request.getParameter("semester");
       String degree=(String)request.getParameter("degree");
       String endterm=(String)request.getParameter("endterm");
       //arr=(ArrayList)dm.updateData(course_id,years,studid);
       if(studid!=null){          
           try{
           String ss="update extmarks set studid=?,years=?,semester=?,degree=?,course_id=?,external=? where studid='"+studid+"' and course_id='"+course_id+"' and years='"+years+"'";
           pstmt=con.prepareStatement(ss);
           pstmt.setString(1,studid);
           pstmt.setString(2,years);
           pstmt.setString(3,semester);
           pstmt.setString(4,degree);
           pstmt.setString(5,course_id);
           pstmt.setString(6,endterm);
           pstmt.executeUpdate();                             
           }
           catch(SQLException rr){}
           
           //request.setAttribute("data",arr);
         // request.setAttribute("data1","DATA UPDATED"); 
        RequestDispatcher dd=request.getRequestDispatcher("/Reports/success.jsp");
        dd.forward(request,response);    
       } }
}
