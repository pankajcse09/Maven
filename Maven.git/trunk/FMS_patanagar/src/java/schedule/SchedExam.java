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
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
import java.util.*;
import java.text.*;
import schedule.dateDiff.*;

/**
 *
 * @author kanchan
 * @version
 */
public class SchedExam extends HttpServlet {
    
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
       PreparedStatement stmt2=null;
       PreparedStatement stmt3=null;
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
       ResultSet rs=null;  
       InsertDates ind=new InsertDates();
       String rn="";
       ArrayList ar=new ArrayList();
       
       String dg=(String)req.getParameter("degree");
       String yr=(String)req.getParameter("yrs");
       String eo=(String)req.getParameter("evenodd");       
       String extp=(String)req.getParameter("extype");
       int k=0;
       int m=0;
       if(eo.equals("odd")){
        k=1; 
        m=9;
       }
       if(eo.equals("even")){
        k=2; 
        m=10;
       }
       int d1=Integer.parseInt((String)req.getParameter("d").toString());
       int m1=Integer.parseInt((String)req.getParameter("m").toString());
       int y1=Integer.parseInt((String)req.getParameter("y").toString());       
       java.util.Date dt1=new java.util.Date(y1-1900,m1-1,d1);  
       String fd=sdf.format(dt1);
       int ld1=Integer.parseInt((String)req.getParameter("ld").toString());
       int lm1=Integer.parseInt((String)req.getParameter("lm").toString());
       int ly1=Integer.parseInt((String)req.getParameter("ly").toString());       
       java.util.Date dt2=new java.util.Date(ly1-1900,lm1-1,ld1);
       String td=sdf.format(dt2);
       ar=new dateDiff().getDatesBetween(dt1,dt2);              
             try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
               catch (Exception e) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + e.getMessage() + "</h5>");
          } 
       try {  
           String qr="select sysdate as es from dual";
           Statement stm=con.createStatement();
           ResultSet rst=stm.executeQuery(qr);
           while(rst.next()){
           rn=rst.getString("es");
           }
           String qry1="insert into examdate(years,evenodd,examtype,from_date,to_date,degree,datetime)values(?,?,?,?,?,?,?)";
           stmt3=con.prepareStatement(qry1);
           stmt3.setString(1,yr);
           stmt3.setString(2,eo);          
           stmt3.setString(3,extp);
           stmt3.setString(4,fd);
           stmt3.setString(5,td);
           stmt3.setString(6,dg);
           stmt3.setString(7,rn);
           stmt3.executeUpdate();   
           
           for(int j=k;j<=m;j+=2){
           ind.insert(j,ar,yr,extp,eo,dg);
           }     
      
       getServletContext().setAttribute("result","Your Request has been Submitted");
       res.sendRedirect(req.getContextPath()+"/ScheduleExam.jsp");            
       }
   catch (SQLException e) {
     out.println("<h4>Error=" + e.getMessage() + "</h4>");
         }        
    finally {
      try {
           if(stmt1!=null){
       stmt1.close();
          }
            if(stmt2!=null){
       stmt2.close();
          }
            if(stmt3!=null){
       stmt3.close();
          }
          if(stmt!=null){
       stmt.close();
          }
          if(con!=null){
       con.close();
          }
      } 
      catch (SQLException e) {
        e.printStackTrace();
      }
    }    
           
   }   
}
