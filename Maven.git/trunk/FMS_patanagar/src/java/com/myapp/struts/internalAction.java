/*
 * InternalAction.java
 *
 * Created on May 10, 2008, 2:55 PM
 */

package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

public class internalAction extends Action {
    
         
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
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
   
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      //  DynaActionForm df=(DynaActionForm)form;
      
        PrintWriter out=response.getWriter();
        
       String course=(String)request.getParameter("course");
       String session=request.getParameter("session");
       String stud=request.getParameter("stud");
       
       if(stud !=null)
       {
           ArrayList arr=new ArrayList();
           String ss="select * from addmarks where studid='"+stud+"' and course_id='"+course+"' and years='"+session+"'";
         try{
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
       }
        catch(SQLException se){
        out.println(se.getMessage());    
        } 
          request.setAttribute("data",arr); 
       }        
        
        return mapping.findForward("success");
        
    }
}
