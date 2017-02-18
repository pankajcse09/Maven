package Courses;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.myapp.struts.Dataconnectivity;
import java.util.*;
/**
 *
 * @author kanchan
 * @version
 */
public class CourseMark extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) 
    throws IOException,ServletException {
         doPost(req,res);
     }    
   public void doPost(HttpServletRequest req,HttpServletResponse res) 
   throws IOException,ServletException{ 
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       Connection con=null;
       Statement stmt=null;   
       PreparedStatement stmt1=null; 
       ResultSet rs=null;
       ArrayList ar1=new ArrayList();
       ArrayList ar2=new ArrayList();
       ArrayList ar3=new ArrayList();      
       ArrayList ar7=new ArrayList();
       ArrayList ar8=new ArrayList();
       ArrayList ar9=new ArrayList();              
       String en="";         
       String dg=(String)req.getParameter("degree"); 
       String ssn=(String)req.getParameter("session"); 
       String sm=(String)req.getParameter("sem");              
       Enumeration e=req.getParameterNames();      
        while(e.hasMoreElements()){
        en=(String)e.nextElement();  
        if(en.substring(0,2).equals("cd")){
            ar1.add(en);
        }
        if(en.substring(0,2).equals("th")){
         ar2.add(en);   
        }  
        if(en.substring(0,2).equals("pr")){
         ar3.add(en);   
        }            
       }
       for(int i=0;i<ar1.size();i++){
        ar7.add(req.getParameter("cd"+(i)));       
        ar8.add(req.getParameter("th"+(i)));        
        ar9.add(req.getParameter("pr"+(i)));                  
        }                 
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }        
       try{   
        String qr="select sysdate as sd from dual";
        stmt=con.createStatement();
        rs=stmt.executeQuery(qr);
        rs.next();
        String qry="";
        for(int k=0;k<ar1.size();k++){
        qry="insert into coursemarks(course_id,theory,practical,degree,sem,updatedate,sessions)values(?,?,?,?,?,?,?)"; 
        stmt1 = con.prepareStatement(qry); 
        if(ar8.get(k)!=null && ar9.get(k)!=null){
        stmt1.setString(1,ar7.get(k).toString());
        stmt1.setString(2,ar8.get(k).toString());
        stmt1.setString(3,ar9.get(k).toString());         
        stmt1.setString(4,dg);
        stmt1.setString(5,sm);
        stmt1.setString(6,rs.getString("sd"));
        stmt1.setString(7,ssn);
        stmt1.executeUpdate(); 
        }
        }
       req.setAttribute("result","Courses Marks has been Submitted");
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/Courses_Detail/CourseMarks.jsp");
       rd.forward(req,res);    
        } 
     catch (SQLException se){
     out.println("<h4>Error=" + se.getMessage() + "</h4>");
         }        
    finally {
      try {
      if(rs!=null){
       rs.close();
          }
       if(stmt!=null){
       stmt.close();
          }
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
