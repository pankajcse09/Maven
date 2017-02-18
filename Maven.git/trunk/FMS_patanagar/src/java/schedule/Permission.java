/*
 * ScheduleDate.java
 *
 * Created on April 3, 2008, 2:36 PM
 */

package schedule;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
/**
 *
 * @author kanchan
 * @version
 */
public class Permission extends HttpServlet {
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) 
    throws IOException,ServletException {
         doPost(req,res);
     }    
   public void doPost(HttpServletRequest req,HttpServletResponse res) 
   throws IOException,ServletException 
   { 
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       Connection con=null;
       PreparedStatement stmt=null;   
       PreparedStatement stmt1=null; 
       int k=0;   
       String sid=(String)req.getParameter("sd");       
       String y=(String)req.getParameter("yr");       
       String cid=(String)req.getParameter("cd");                       
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }        
       try { 
        String qry="update addmarks set permission=? where studid='"+sid+"' and course_id='"+cid+"' and years='"+y+"'";       
        stmt1 = con.prepareStatement(qry);             
        stmt1.setString(1,"y");        
        stmt1.executeUpdate();       
             
       req.setAttribute("msg",sid+" is Permitted for Exam "+cid);
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/CheckAttendence.jsp");
       rd.forward(req,res);          
    } 
   catch (SQLException se){
     out.println("<h4>Error=" + se.getMessage() + "</h4>");
         }        
    finally {
      try {
          if(stmt!=null){
       stmt.close();
          }
          if(con!=null){
       con.close();
          }
      } 
      catch (SQLException se) {
        se.printStackTrace();
      }
    }         
   }
}
