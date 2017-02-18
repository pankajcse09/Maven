package schedule;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
import java.util.*;

/**
 *
 * @author kanchan
 * @version
 */
public class Ent_Total_Attend extends HttpServlet {
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
       ArrayList ar1=new ArrayList();
       ArrayList ar2=new ArrayList();
       ArrayList ar3=new ArrayList();
       ArrayList ar4=new ArrayList();
       String en="";    
       Enumeration e=req.getParameterNames();
       while(e.hasMoreElements()){
        en=(String)e.nextElement();  
        if(en.substring(0,1).equals("r")){
            ar1.add(en);
        }
        else{
         ar2.add(en);   
        }        
       }
       for(int i=0;i<ar1.size();i++){
        ar3.add(req.getParameter("r"+i));
        ar4.add(req.getParameter("m"+i));
       }
       for(int j=0;j<ar3.size();j++){
           out.println(ar3.get(j)+" : "+ar4.get(j));
       }
       String dg=req.getParameter("deg");
       String yr=req.getParameter("yrs");
       String sm=req.getParameter("sem");
       out.println(dg+":"+yr+":"+sm);      
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }        
       try { 
           String qry="";
        for(int k=0;k<ar3.size();k++){
        qry="insert into course_attend(course_id,total_attend,years,sem,degree)values(?,?,?,?,?)";       
        stmt1 = con.prepareStatement(qry);          
        stmt1.setString(1,ar3.get(k).toString());
        stmt1.setString(2,ar4.get(k).toString());
        stmt1.setString(3,yr);
        stmt1.setString(4,sm);
        stmt1.setString(5,dg);
        stmt1.executeUpdate();         
        }            
       req.setAttribute("result","Attendance has been Submitted");
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/Enter_Attend.jsp");
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
      catch (SQLException se) {
        se.printStackTrace();
      }
    }    
         
   }   
}
