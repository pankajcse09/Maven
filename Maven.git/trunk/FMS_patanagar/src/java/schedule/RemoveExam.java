/*
 * RemoveExam.java
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

public class RemoveExam extends HttpServlet {
    
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
       PreparedStatement psmt=null;   
       String eo="";   
       String dg=(String)req.getParameter("degree");         
       String yr=(String)req.getParameter("yrs");
       String et=(String)req.getParameter("exmtyp");
       String nm=(String)req.getParameter("n");
       String rid=(String)req.getParameter("rd");  
     try
    {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e) 
       {
       out.println("<h4>Database Connection Problem.</h4>");
       e.printStackTrace();
          }             
       try{           
       String qr1="update scheduleexam"+nm+" set times=?,cours_id=? where rowid='"+rid+"'";       
       psmt=con.prepareStatement(qr1);
       psmt.setString(1,"");
       psmt.setString(2,"n");
       psmt.executeUpdate();            
       con.commit();       
       req.setAttribute("del","Exam Removed"); 
       if(Integer.parseInt(nm)%2==0){
           eo="even";
       }
       else{
           eo="odd";
       }       
       RequestDispatcher rd=req.getRequestDispatcher("/SchedExm1.jsp?pr="+eo+"&n="+nm+"&degree="+dg+"&yrs="+yr+"&exmtyp="+et);              
       rd.forward(req,res);         
       }
       catch(SQLException e){
          out.println(e.getMessage()); 
       }
       finally{
       try{
           if(psmt!=null){
               psmt.close();
           }
         if(con!=null){
               con.close();
           }           
       }
       catch(SQLException e){
          out.println(e.getMessage()); 
       }
       }
          
   }   
}
