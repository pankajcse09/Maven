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
public class EntMarks extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) 
    throws IOException,ServletException {
         doPost(req,res);
     }    
   public void doPost(HttpServletRequest req,HttpServletResponse res) 
   throws IOException,ServletException 
   { 
       External extn=new External();
       Compartment cmpt=new Compartment();
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
       ArrayList ar6=new ArrayList();
       ArrayList ar7=new ArrayList();
       ArrayList ar8=new ArrayList();
       ArrayList ar9=new ArrayList();
       ArrayList ar10=new ArrayList();       
       ArrayList ar11=new ArrayList();
       ArrayList ar12=new ArrayList();
       ArrayList ar13=new ArrayList();       
       ArrayList ar15=new ArrayList();
       ArrayList ar16=new ArrayList();       
       ArrayList ar18=new ArrayList();
       ArrayList ar19=new ArrayList();
       ArrayList ar20=new ArrayList();
       double jk1=0.0;
       double jk2=0.0;
       double jk3=0.0;
       double jk4=0.0;
       String csts="";
       String qrs="";
       String stid="";
       String cstatus="";
       String cstatus1="";
       String enu="";   
       int pp=Integer.parseInt(req.getParameter("pr"));
       String dg=(String)req.getParameter("deg");
       
       String yr=(String)req.getParameter("yrs");
       String sm=(String)req.getParameter("sem");
       String et=(String)req.getParameter("emxtyp");
       String cs=(String)req.getParameter("cid");          
       Enumeration e=req.getParameterNames();      
        while(e.hasMoreElements()){
        enu=(String)e.nextElement();  
        if(enu.substring(0,2).equals("ro")){
            ar1.add(enu);
        }
        if(enu.substring(0,2).equals("mi")){
         ar2.add(enu);   
        }  
        if(enu.substring(0,2).equals("en")){
         ar5.add(enu);   
        } 
        if(enu.substring(0,2).equals("in")){
         ar6.add(enu);   
        } 
         if(enu.substring(0,2).equals("at")){
         ar7.add(enu);   
        }
          if(enu.substring(0,2).equals("ex")){
         ar8.add(enu);   
        }
          if(enu.substring(0,2).equals("ep")){
         ar9.add(enu);   
        }
          if(enu.substring(0,2).equals("cm")){
         ar10.add(enu);   
        }
         if(enu.substring(0,2).equals("wp")){
         ar19.add(enu);   
        }
       }
        for(int i=0;i<ar1.size();i++){
        ar3.add(req.getParameter("ro"+(i+pp-1)));
        if(et.equals("INTERNAL")) {  
        if(ar2.size()>0){    
        ar4.add(req.getParameter("mi"+(i+pp-1))); 
        }
        else{
        ar4.add("-1");    
        }
        if(ar5.size()>0){
        ar11.add(req.getParameter("en"+(i+pp-1)));
        }
         else{
        ar11.add("-1");    
        }
        if(ar6.size()>0){
        ar12.add(req.getParameter("in"+(i+pp-1)));
        }
        else{
        ar12.add("-1");    
        }
        if(ar19.size()>0){
        ar20.add(req.getParameter("wp"+(i+pp-1)));
        }
        else{
        ar20.add("-1");    
        }
        if(ar7.size()>0){
        ar13.add(req.getParameter("at"+(i+pp-1)));  
        }
        }
        if(et.equals("EXTERNAL")) {
        if(ar8.size()>0){    
        ar15.add(req.getParameter("ex"+(i+pp-1)));
        }
         else{
        ar15.add("-1");    
        }
        if(ar9.size()>0){
        ar16.add(req.getParameter("ep"+(i+pp-1)));         
        }
         else{
        ar16.add("-1");    
        }
        }
        if(et.equals("COMPARTMENT")) {    
        if(ar10.size()>0){    
        ar18.add(req.getParameter("cm"+(i+pp-1)));              
        }
         else{
        ar18.add("-1");    
        }
        }
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
         jk1=0.0;   
         jk2=0.0;
         jk3=0.0;
         jk4=0.0;
        if(et.equals("INTERNAL")){          
        qry="insert into addmarks(studid,course_id,years,semester,degree,midterm,endterm,intpractical,attendance,permission,extra)values(?,?,?,?,?,?,?,?,?,?,?)"; 
        stmt1 = con.prepareStatement(qry);
         try {
          if(ar4.get(k)!=null && ar11.get(k)!=null && ar12.get(k)!=null && ar20.get(k)!=null && ar13.get(k)!=null && cs!=null && !cs.equals("")){                                 
        jk1=Double.parseDouble(ar4.get(k).toString());
        jk2=Double.parseDouble(ar11.get(k).toString());
        jk3=Double.parseDouble(ar12.get(k).toString());
        jk4=Double.parseDouble(ar20.get(k).toString());
        stmt1.setString(1,ar3.get(k).toString());
        stmt1.setString(2,cs);        
        stmt1.setString(3,yr);
        stmt1.setString(4,sm);
        stmt1.setString(5,dg);
        stmt1.setDouble(6,jk1);
        stmt1.setDouble(7,jk2);
        stmt1.setDouble(8,jk3);
        stmt1.setString(9,ar13.get(k).toString());     
        if(Double.parseDouble(ar13.get(k).toString())>=85.00){
        stmt1.setString(10,"y");   
        }
        else{
        stmt1.setString(10,"n");    
        }
        stmt1.setDouble(11,jk4);
        stmt1.executeUpdate(); 
          }
         }
         catch (NumberFormatException ex){
         ex.printStackTrace();
         }                
        }       
         if(et.equals("COMPARTMENT")){ 
        qry="insert into compmarks(studid,course_id,years,semester,degree,compartment,status)values(?,?,?,?,?,?,?)";               
        stmt1 = con.prepareStatement(qry);  
        try {            
        if(ar18.get(k)!=null && cs!=null && !cs.equals("")){ 
        stid=ar3.get(k).toString();    
        jk1=Double.parseDouble(ar18.get(k).toString());  
        csts=cmpt.checkStatus1(dg,yr,sm,stid,cs,jk1);        
        stmt1.setString(1,ar3.get(k).toString());
        stmt1.setString(2,cs);        
        stmt1.setString(3,yr);
        stmt1.setString(4,sm);
        stmt1.setString(5,dg);
        stmt1.setDouble(6,jk1);    
        stmt1.setString(7,csts);
        stmt1.executeUpdate(); 
        }}
        catch (NumberFormatException nfe){
         nfe.printStackTrace();
         } 
        }  
        }    
       if(et.equals("INTERNAL")){    
       req.setAttribute("result","Marks and Attendence has been Submitted");
       }
        if(et.equals("EXTERNAL")){    
       req.setAttribute("result","Marks has been Submitted");
       }
        if(et.equals("COMPARTMENT")){    
       req.setAttribute("result","Marks has been Submitted");
       }   
           
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/EnterMarks.jsp?pr="+pp);
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

