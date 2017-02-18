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
public class Ent_Attend_Stud extends HttpServlet {
     
   public double roundoff(double d){       
      Double net1= new Double(d);      
      //System.out.println(net1.valueOf());
     Double net  =new Double(Math.rint(Double.parseDouble(net1.toString())*100.0)/100); 
     double dbvalue= net.doubleValue() ;     
     return dbvalue;
   }    
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
       ArrayList ar5=new ArrayList();
       String en="";  
       double ft=0.0;
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
       String dg=(String)req.getParameter("deg");
       String yr=(String)req.getParameter("yrs");
       String sm=(String)req.getParameter("sem");
       String cd=(String)req.getParameter("cid");
       int ta=Integer.parseInt(req.getParameter("toattend"));
       double ia=0.0;
       for(int j=0;j<ar3.size();j++){
           ia=Double.parseDouble(ar4.get(j).toString());
           ft=100*(ia/ta);          
           ar5.add(new Double(roundoff(ft)));
           }  
        //for(int k=0;k<ar3.size();k++){
       //    ft=Double.parseDouble(ar5.get(k));
       //} 
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
        qry="insert into stud_attend(stud_id,years,sem,degree,course_id,periodattend,percent_attend)values(?,?,?,?,?,?,?)";       
        stmt1 = con.prepareStatement(qry);          
        stmt1.setString(1,ar3.get(k).toString());
        stmt1.setString(2,yr);
        stmt1.setString(3,sm);
        stmt1.setString(4,dg);
        stmt1.setString(5,cd);
        stmt1.setString(6,ar4.get(k).toString());      
        stmt1.setString(7,ar5.get(k).toString()); 
        stmt1.executeUpdate();         
        }            
       req.setAttribute("result","Attendance has been Submitted for course Id "+cd);
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/Ent_Stud_Attend.jsp");
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
