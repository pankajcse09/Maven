package schedule;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
import java.util.*;

public class EnterInternship extends HttpServlet {
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
       PreparedStatement stmt2=null; 
       ArrayList ar1=new ArrayList();
       ArrayList ar2=new ArrayList();
       ArrayList ar3=new ArrayList();
       ArrayList ar4=new ArrayList();
      
       double jk1=0.0;
       double jk2=0.0;
       double jk3=0.0;
       String csts="";
       String qrs="";
       String stid="";
       String cstatus="";
       String cstatus1="";
       
       String enu="";
       //int pp=Integer.parseInt(req.getParameter("pr"));
       String sn=(String)req.getParameter("sesn");       
       String sm=(String)req.getParameter("sem");
       String dg=(String)req.getParameter("degree");
               
       Enumeration e=req.getParameterNames();      
        while(e.hasMoreElements()){
        enu=(String)e.nextElement();  
        if(enu.substring(0,2).equals("st")){
            ar1.add(enu);
        }
        if(enu.substring(0,2).equals("rk")){
         ar2.add(enu);   
        }        
       }
       for(int i=0;i<ar1.size();i++){
        ar3.add(req.getParameter("st"+i));   
        ar4.add(req.getParameter("rk"+i));                  
        }                       
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }         
           int n=0;
           String qry="";      
         try { 
           for(int k=0;k<ar3.size();k++){
            qry="insert into internship(studid,remarks,sessions,sem,degree)values(?,?,?,?,?)";
             stmt1=con.prepareStatement(qry);
             if(ar3.get(k)!=null && ar4.get(k)!=null && req.getParameter("sesn")!=null && req.getParameter("sem")!=null && req.getParameter("degree")!=null){
             stmt1.setString(1,ar3.get(k).toString());
             stmt1.setString(2,ar4.get(k).toString());
             stmt1.setString(3,sn);
             stmt1.setString(4,sm);
             stmt1.setString(5,dg);
             stmt1.executeUpdate();
           } 
           }
           req.setAttribute("msg","Submitted");
           RequestDispatcher rd=req.getRequestDispatcher("/Internship.jsp?degree="+dg+"&sesn="+sn+"&sem="+sm);
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

