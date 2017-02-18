package schedule;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;

public class EnterInternshipDate extends HttpServlet {
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
       PreparedStatement stmt1=null;        
     
       String sn=(String)req.getParameter("sesn");       
       String fd=(String)req.getParameter("fromdate");
       String td=(String)req.getParameter("todate");         
       String sm=(String)req.getParameter("sem"); 
       String dg=(String)req.getParameter("degree");                
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }              
            try{
            String qry="insert into internshipdate(sessions,fromdate,todate,sem,degree)values(?,?,?,?,?)";
            stmt1=con.prepareStatement(qry);            
             stmt1.setString(1,sn);
             stmt1.setString(2,fd);
             stmt1.setString(3,td);
             stmt1.setString(4,sm);
             stmt1.setString(5,dg);
             stmt1.executeUpdate();     
         
           req.setAttribute("msg","Submitted");
           RequestDispatcher rd=req.getRequestDispatcher("/EnterInternshipDat.jsp?degree="+dg+"&sesn="+sn+"&sem="+sm);
           rd.forward(req,res); 
         } 
   catch (SQLException se){
     out.println("<h4>Error=" + se.getMessage() + "</h4>");
         }        
    finally {
      try {
          if(stmt1!=null){
       stmt1.close();
          }
          if(con!=null){
       con.close();
          }
      } 
      catch (SQLException se){
        se.printStackTrace();
      }
    }      
      
   }         
}

