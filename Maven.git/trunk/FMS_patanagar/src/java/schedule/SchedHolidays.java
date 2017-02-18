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
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
/**
 *
 * @author kanchan
 * @version
 */
public class SchedHolidays extends HttpServlet {
    
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
       ResultSet rs1=null;
       int k=0;   
       String d1=(String)req.getParameter("session"); 
       String d2=(String)req.getParameter("dated"); 
       String d3=(String)req.getParameter("holiday");  
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }       
    try { 
        int count=0;
        String qr1="select count(dated) as cnt from holidaylist where dated='"+d2+"' and sessions='"+d1+"'";
        stmt1=con.prepareStatement(qr1);
        rs1=stmt1.executeQuery();
        rs1.next();
        count=rs1.getInt("cnt");
        String query="insert into holidaylist(sessions,dated,holiday)values(?,?,?)";       
        stmt = con.prepareStatement(query); 
        if(count==0){
        stmt.setString(1,d1);
        stmt.setString(2,d2);
        stmt.setString(3,d3);
        stmt.executeUpdate();            
        req.setAttribute("result","Submitted");
        }
        else{
        req.setAttribute("result","Date Already Exists");    
        }
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/ScheduleHolidays.jsp");
       rd.forward(req,res);          
    } 
     catch (SQLException se){
     out.println(se.getMessage());
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
