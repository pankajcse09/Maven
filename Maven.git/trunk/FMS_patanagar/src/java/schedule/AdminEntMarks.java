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
public class AdminEntMarks extends HttpServlet {
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
       int jk=0;
       String en="";    
       String dg="";
       String yr="";
       String sm="";
       String et="";
       String sd="";
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
       dg=req.getParameter("deg");
       yr=req.getParameter("yrs");
       sm=req.getParameter("sem");
       et=req.getParameter("exmtyp");
       sd=req.getParameter("sid");
       out.println(dg+":"+yr+":"+sm+":"+et+":"+sd); 
       String ef="";
       if(et.equals("MIDTERM")){
        ef="midterm";   
       }
       if(et.equals("ENDTERM")){
        ef="endterm";   
       }
       if(et.equals("INTPRACTICAL")){
        ef="intpractical";   
       }
       if(et.equals("EXTERNAL")){
       ef="external";    
       }
       if(et.equals("EXTPRACTICAL")){
        ef="extpractical";   
       }
       if(et.equals("COMPARTMENT")){
        ef="compartment";   
       }       
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
         catch (Exception se) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + se.getMessage() + "</h5>");
          }        
       try { 
           int n=0;
           String qry="";
        for(int k=0;k<ar3.size();k++){
        jk=0;        
        if(ef.equals("midterm")){        
        qry="insert into addmarks(studid,course_id,midterm,years,semester,degree,endterm,intpractical,external,extpractical,compartment,examtype)values(?,?,?,?,?,?,?,?,?,?,?,?)";       
        stmt1 = con.prepareStatement(qry); 
        try {
         if(ar4.get(k)!=null)
        {  
        jk=Integer.parseInt(ar4.get(k).toString());
        stmt1.setString(1,sd);
        stmt1.setString(2,ar3.get(k).toString());
        stmt1.setInt(3,jk);
        stmt1.setString(4,yr);
        stmt1.setString(5,sm);
        stmt1.setString(6,dg);
        stmt1.setInt(7,n);
        stmt1.setInt(8,n);
        stmt1.setInt(9,n);
        stmt1.setInt(10,n);
        stmt1.setInt(11,n);     
        stmt1.setString(12,et);
        stmt1.executeUpdate();   
         }
           }
         catch (NumberFormatException ex){
         ex.printStackTrace();
         }  
        }
            else{
        qry="update addmarks set "+ef+"=?,examtype=? where course_id='"+ar3.get(k).toString()+"' and studid='"+sd+"' and years='"+yr+"' and semester='"+sm+"' and degree='"+dg+"'";     
        stmt1 = con.prepareStatement(qry);  
        try {
        if(ar4.get(k)!=null)
        { 
        jk=Integer.parseInt(ar4.get(k).toString());    
        stmt1.setInt(1,jk);
        stmt1.setString(2,et);
        stmt1.executeUpdate(); 
        }}
        catch (NumberFormatException ex){
         ex.printStackTrace();
         } 
        }
        }            
       req.setAttribute("result","Marks has been Submitted");
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/AdminMarksEnter.jsp");
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
