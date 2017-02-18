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
public class SchedExm11 extends HttpServlet {
    
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
       PreparedStatement psmt1=null;   
       PreparedStatement psmt2=null;
       ResultSet rs1=null;
       String eo="";     
       //Calendar cal = Calendar.getInstance();
       String ch=(String)req.getParameter("chc"); 
       String dg1=(String)req.getParameter("degree");         
       String yr1=(String)req.getParameter("yrs");
       String et=(String)req.getParameter("exmtyp");
       String v1=(String)req.getParameter("v");
       String dt1=(String)req.getParameter("dt");      
       String cf=(String)req.getParameter("cfield");
       String sth=(String)req.getParameter("stimeh");
       String stm=(String)req.getParameter("stimem");
       String sap=(String)req.getParameter("sap");       
       String tt=sth+":"+stm+" "+sap;
       int dg= dt1.lastIndexOf("-");
       int ln= dt1.length();      
       String yr=dt1.substring(dg+1,ln);     
       String qr2="";      
           try
    {
    Dataconnectivity newsdc=new  Dataconnectivity();
    con=(Connection)newsdc.Dataconnect();
    } 
    catch(Exception e) 
       {
       out.println("<h4>Database Connection Problem.</h4>");
       e.printStackTrace();
          }             
       try{
           String sm="";
       String qr1="select semester,id from ex_course_detail where id='"+v1+"' and degree='"+dg1+"'";       
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();       
       rs1.next();      
       sm=rs1.getString("semester");       
       if(Integer.parseInt(sm)%2==0){
           eo="even";
       }
       else{
           eo="odd";
       }
       qr2="update scheduleexam"+ch+" set times=?,cours_id=? where dated='"+dt1+"' and yrs='"+yr1+"' and exam='"+et+"' and degree='"+dg1+"'";       
       psmt2=con.prepareStatement(qr2);
       psmt2.setString(1,tt);
       psmt2.setString(2,rs1.getString("id"));        
       psmt2.executeUpdate();   
       con.commit();
       req.setAttribute("msg",v1+" is set on "+dt1);         
       RequestDispatcher rd=req.getRequestDispatcher("/SchedExm1.jsp?pr="+eo+"&n="+sm+"&degree="+dg1+"&yrs="+yr1+"&exmtyp="+et);
       rd.forward(req,res);         
       }
       catch(SQLException e){
          out.println(e.getMessage()); 
       }
       finally{
       try{
           if(rs1!=null){
               rs1.close();
           }
         if(psmt1!=null){
               psmt1.close();
           }
           if(psmt2!=null){
               psmt2.close();
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
