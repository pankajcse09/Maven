/*
 * Insert_Courses_Details.java
 *
 * Created on March 14, 2008, 4:02 PM
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

/**
 *
 * @author piyushrastogi
 * @version
 */
public class AssignCourse extends HttpServlet {
    Connection con=null;     
    PreparedStatement psmt=null;    
    ResultSet rs=null;   
    public  void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String ssn=(String)request.getParameter("session");                 
         String cid=(String)request.getParameter("csid");
         String ename=(String)request.getParameter("e_name");
         int in1=ename.indexOf("(");
         int in2=ename.indexOf(")");
         String enm=ename.substring(0,in1);
         String eid=ename.substring(in1+1,in2);
         String cc="";
         int count=0;
         String qr1="";
         int count1=0;
                   try{
         Dataconnectivity corse=new Dataconnectivity();
         con=(Connection)corse.Dataconnect();
    }
       catch(Exception e)
       {
       out.println(e.getMessage());
       }
         try{
          qr1="insert into ex_assigncourses(course_id,prof_id,prof_name,sessions)values(?,?,?,?)"; 
          psmt=con.prepareStatement(qr1);
          psmt.setString(1,cid);
          psmt.setString(2,eid);
          psmt.setString(3,enm);
          psmt.setString(4,ssn);
          psmt.executeUpdate();  
          request.setAttribute("msg","Course "+cid+" Assigned to "+enm);
          RequestDispatcher rd=request.getRequestDispatcher("/Courses_Detail/Courses_Assign_Teacher.jsp");
          rd.forward(request,response);
          }
        catch(SQLException e){           
          RequestDispatcher r=request.getRequestDispatcher("/Courses_Detail/Courses_Assign_Teacher.jsp");
          r.forward(request,response);
        } 
        finally{
        try{
         if(rs!=null){rs.close();}
         if(psmt!=null){psmt.close();}
         if(con!=null){con.close();}
        }   
        catch(Exception se){
         out.println(se.getMessage());   
        }
         }
        out.close();
    }
}
