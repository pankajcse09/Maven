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
public class EntExtMarks extends HttpServlet {
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
       PreparedStatement stmt2=null; 
       ArrayList ar1=new ArrayList();
       ArrayList ar2=new ArrayList();
       ArrayList ar3=new ArrayList();
       ArrayList ar4=new ArrayList();
       ArrayList ar5=new ArrayList();
       ArrayList ar6=new ArrayList();    
       double nm=0.0;
       double nm1=0.0;
       String csts="";
       String qrs="";
       String stid="";
       String cstatus="";
       String cstatus1="";
       String enu="";   
       String st="";      
       String qr1="";
       String st1="";      
       String qr2="";
       String qr3="";
       try{
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
        if(enu.substring(0,2).equals("cr")){
         ar2.add(enu);   
        }  
        }       
       for(int i=0;i<ar1.size();i++){
        ar3.add(req.getParameter("ro"+(i+pp-1)));
       }
         for(int i=0;i<ar2.size();i++){
        ar4.add(req.getParameter("cr"+(i+pp-1)));        
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
       if(et.equals("EXTERNAL")){  
      for(int k=0;k<ar3.size();k++){
      for(int m=0;m<ar4.size();m++){
      st=ar3.get(k)+"_"+ar4.get(m);       
      if(req.getParameter(st)!=null && !req.getParameter(st).equals("")){
      nm=Double.parseDouble(req.getParameter(st).toString());       
      //cstatus=extn.checkStatus(dg,yr,sm,stid,cs,nm);    
      qr1="insert into extmarks(studid,course_id,years,semester,degree,external)values(?,?,?,?,?,?)"; 
      stmt=con.prepareStatement(qr1);
      stmt.setString(1,ar3.get(k).toString());
      stmt.setString(2,ar4.get(m).toString());
      stmt.setString(3,yr);
      stmt.setString(4,sm);
      stmt.setString(5,dg);
      stmt.setDouble(6,nm);
      stmt.executeUpdate();      
      }
      st1="em_"+ar3.get(k)+"_"+ar4.get(m);
      if(req.getParameter(st1)!=null && !req.getParameter(st1).equals("")){        
      nm1=Double.parseDouble(req.getParameter(st1).toString());       
      qr2="insert into extprmarks(studid,course_id,years,semester,degree,extpractical)values(?,?,?,?,?,?)"; 
      stmt1=con.prepareStatement(qr2);
      stmt1.setString(1,ar3.get(k).toString());
      stmt1.setString(2,ar4.get(m).toString());
      stmt1.setString(3,yr);
      stmt1.setString(4,sm);
      stmt1.setString(5,dg);
      stmt1.setDouble(6,nm1);      
      stmt1.executeUpdate();      
      cstatus=extn.checkStatus(dg,yr,sm,ar3.get(k).toString(),ar4.get(m).toString(),nm1);      
      qr3="update extprmarks set status='"+cstatus+"' where studid='"+ar3.get(k)+"' and course_id='"+ar4.get(m)+"' and years='"+yr+"' and semester='"+sm+"' and degree='"+dg+"'";
      stmt2=con.prepareStatement(qr3);
      stmt2.executeUpdate();
      }
      }     
      }
      }
       if(et.equals("EXTPRACTICAL")){  
      for(int k=0;k<ar3.size();k++){
      for(int m=0;m<ar4.size();m++){
      st=ar3.get(k)+"_"+ar4.get(m);
      nm=Double.parseDouble(req.getParameter(st).toString());
      if(req.getParameter(st)!=null && !req.getParameter(st).equals("")){
      cstatus=extn.checkStatus(dg,yr,sm,ar3.get(k).toString(),ar4.get(m).toString(),nm);
      qr1="insert into extprmarks(studid,course_id,years,semester,degree,extpractical)values(?,?,?,?,?,?)"; 
      stmt=con.prepareStatement(qr1);
      stmt.setString(1,ar3.get(k).toString());
      stmt.setString(2,ar4.get(m).toString());
      stmt.setString(3,yr);
      stmt.setString(4,sm);
      stmt.setString(5,dg);
      stmt.setDouble(6,nm);      
      stmt.executeUpdate();
      }
      st1="em_"+ar3.get(k)+"_"+ar4.get(m);      
      if(req.getParameter(st1)!=null && !req.getParameter(st1).equals("")){
      nm1=Double.parseDouble(req.getParameter(st1).toString());      
      qr2="insert into extmarks(studid,course_id,years,semester,degree,external)values(?,?,?,?,?,?)"; 
      stmt1=con.prepareStatement(qr2);
      stmt1.setString(1,ar3.get(k).toString());
      stmt1.setString(2,ar4.get(m).toString());
      stmt1.setString(3,yr);
      stmt1.setString(4,sm);
      stmt1.setString(5,dg);
      stmt1.setDouble(6,nm1);     
      stmt1.executeUpdate();      
      }
      cstatus=extn.checkStatus(dg,yr,sm,ar3.get(k).toString(),ar4.get(m).toString(),nm);
      qr3="update extprmarks set status='"+cstatus+"' where studid='"+ar3.get(k)+"' and course_id='"+ar4.get(m)+"' and years='"+yr+"' and semester='"+sm+"' and degree='"+dg+"'";
      stmt2=con.prepareStatement(qr3);
      stmt2.executeUpdate();
      }     
      }
       }
       req.setAttribute("result","Marks has been Submitted");          
           
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/EnterExtMarks.jsp?pr="+pp);
       rd.forward(req,res); 
       }
       catch(SQLException se){
        out.println(se.getMessage());   
       }
         finally {
      try {
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
   catch(NullPointerException ne){
   }
   }   
   }
     
        
//        if(et.equals("EXTERNAL")) {
//        if(ar8.size()>0){    
//        ar4.add(req.getParameter("cr"+(i+pp-1)));
//        }
//         else{
//        ar15.add("-1");    
//        }
//        if(ar9.size()>0){
//        ar16.add(req.getParameter("ep"+(i+pp-1)));         
//        }
//         else{
//        ar16.add("-1");    
//        }
//        }
//        if(et.equals("EXTPRACTICAL")){    
//        if(ar10.size()>0){    
//        ar18.add(req.getParameter("ep"+(i+pp-1)));              
//        }
//         else{
//        ar18.add("-1");    
//        }
//        }
                   
          
//       try { 
//           int n=0;
//           String qry="";
//        for(int k=0;k<ar3.size();k++){
//         jk1=0;   
//         jk2=0;
//         jk3=0;
//        if(et.equals("INTERNAL")){          
//        qry="insert into addmarks(studid,course_id,years,semester,degree,midterm,endterm,intpractical,attendance,permission)values(?,?,?,?,?,?,?,?,?,?)"; 
//        stmt1 = con.prepareStatement(qry);
//         try {
//          if(ar4.get(k)!=null && ar11.get(k)!=null && ar12.get(k)!=null && ar13.get(k)!=null && cs!=null && !cs.equals(""))
//          {                                 
//        jk1=Double.parseDouble(ar4.get(k).toString());
//        jk2=Double.parseDouble(ar11.get(k).toString());
//        jk3=Double.parseDouble(ar12.get(k).toString());
//        stmt1.setString(1,ar3.get(k).toString());
//        stmt1.setString(2,cs);        
//        stmt1.setString(3,yr);
//        stmt1.setString(4,sm);
//        stmt1.setString(5,dg);
//        stmt1.setDouble(6,jk1);
//        stmt1.setDouble(7,jk2);
//        stmt1.setDouble(8,jk3);
//        stmt1.setString(9,ar13.get(k).toString());     
//        if(Double.parseDouble(ar13.get(k).toString())>=85.00){
//        stmt1.setString(10,"y");   
//        }
//        else{
//        stmt1.setString(10,"n");    
//        }
//        stmt1.executeUpdate(); 
//          }
//         }
//         catch (NumberFormatException ex){
//         ex.printStackTrace();
//         }                
//        }
//        if(et.equals("EXTERNAL")){              
//        qry="insert into extmarks(studid,course_id,years,semester,degree,external,extpractical,status)values(?,?,?,?,?,?,?,?)"; 
//        stmt1 = con.prepareStatement(qry);  
//        try {            
//       
//            if(ar15.get(k)!=null && ar16.get(k)!=null && cs!=null && !cs.equals(""))
//          { 
//        stid=ar3.get(k).toString();   
//        jk1=Double.parseDouble(ar15.get(k).toString());  
//        jk2=Double.parseDouble(ar16.get(k).toString());
//        cstatus=extn.checkStatus(dg,yr,sm,stid,cs,jk1,jk2);  
//        stmt1.setString(1,ar3.get(k).toString());
//        stmt1.setString(2,cs);        
//        stmt1.setString(3,yr);
//        stmt1.setString(4,sm);
//        stmt1.setString(5,dg);
//        stmt1.setDouble(6,jk1);
//        stmt1.setDouble(7,jk2);
//        stmt1.setString(8,cstatus);
//        stmt1.executeUpdate(); 
//        }}
//        catch (NumberFormatException nfe){
//         nfe.printStackTrace();
//         } 
//        }           
//         if(et.equals("COMPARTMENT")){ 
//        qry="insert into compmarks(studid,course_id,years,semester,degree,compartment,status)values(?,?,?,?,?,?,?)";               
//        stmt1 = con.prepareStatement(qry);  
//        try {            
//        if(ar18.get(k)!=null && cs!=null && !cs.equals("")){ 
//        stid=ar3.get(k).toString();    
//        jk1=Double.parseDouble(ar18.get(k).toString());  
//        csts=cmpt.checkStatus1(dg,yr,sm,stid,cs,jk1);        
//        stmt1.setString(1,ar3.get(k).toString());
//        stmt1.setString(2,cs);        
//        stmt1.setString(3,yr);
//        stmt1.setString(4,sm);
//        stmt1.setString(5,dg);
//        stmt1.setDouble(6,jk1);    
//        stmt1.setString(7,csts);
//        stmt1.executeUpdate(); 
//        }}
//        catch (NumberFormatException nfe){
//         nfe.printStackTrace();
//         } 
//        }  
//        }    
//       if(et.equals("EXTERNAL")){    
//       req.setAttribute("result","Marks has been Submitted");
//       }
//        if(et.equals("EXTPRACTICAL")){    
//       req.setAttribute("result","Marks has been Submitted");
//       }   
//           
//       RequestDispatcher rd=getServletContext().getRequestDispatcher("/EnterExtMarks.jsp?pr="+pp);
//       rd.forward(req,res);          
//    } 
//   catch (SQLException se){
//     out.println("<h4>Error=" + se.getMessage() + "</h4>");
//         }        
//    finally {
//      try {
//          if(stmt1!=null){
//       stmt1.close();
//          }
//          if(con!=null){
//       con.close();
//          }
//      } 
//      catch (SQLException se){
//        se.printStackTrace();
//      }
//    }       
//         
//   }   


