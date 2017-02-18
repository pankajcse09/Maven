package Courses;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
import java.util.*;
/**
 *
 * @author kanchan
 * @version
 */
public class UpdateAvailability extends HttpServlet {
    
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
       PreparedStatement psmt3=null;   
       PreparedStatement psmt4=null;
       ResultSet rs1=null;
       ResultSet rs2=null;
       
       String ssn="";    
       String clas="";
       String sub="";
       String th="";
       String pr="";
       String mcq=""; 
       String unit=""; 
       String ex=""; 
       String ssn1="";
       int sn1=0;
       int sn2=0; 
           
       HashMap hm=new HashMap();
       int s=0;
       int cy=0;
       String yyy="";
       String yrs=(String)req.getParameter("yrs");             
       List ar=new ArrayList();
       //Calendar cal = Calendar.getInstance();
       String dg=(String)req.getParameter("deg");   
       String qr2="";      
    try
    {
    Dataconnectivity newsdc=new  Dataconnectivity();
    con=(Connection)newsdc.Dataconnect();
    } 
    catch(Exception e){
       out.println("<h4>Database Connection Problem.</h4>");
       e.printStackTrace();
          }             
       try{             
       String qr1="select * from ex_course_detail where convert(substring(sessions,1,4),UNSIGNED)=(select max(convert(substring(sessions,1,4),UNSIGNED)) from ex_course_detail)";
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();       
       while(rs1.next()){                     
       ssn=rs1.getString("sessions"); 
       clas=rs1.getString("class");  
       sub=rs1.getString("subject"); 
       th=rs1.getString("theory");
       pr=rs1.getString("practical");
       mcq=rs1.getString("mcq");
       unit=rs1.getString("unittest");
       ex=rs1.getString("exist");
       int in=ssn.length();
       int in1=ssn.indexOf("-");
       try{
       sn1=Integer.parseInt(ssn.substring(0,in1))+1;
       sn2=Integer.parseInt(ssn.substring(in1+1,in))+1;
       }
       catch(StringIndexOutOfBoundsException si){
       out.println(si.getMessage());    
       }
       ssn1=sn1+"-"+sn2;
       qr2="insert into ex_course_detail(sessions,class,subject,theory,practical,mcq,unittest,exist)values(?,?,?,?,?,?,?,?)";    
       psmt2=con.prepareStatement(qr2);
       psmt2.setString(1,ssn1);
       psmt2.setString(2,clas); 
       psmt2.setString(3,sub);
       psmt2.setString(4,th);
       psmt2.setString(5,pr);
       psmt2.setString(6,mcq);
       psmt2.setString(7,unit);
       psmt2.setString(8,ex);       
       psmt2.executeUpdate();        
       }              
       ServletContext context=getServletContext();
       context.setAttribute("msg","Updated");         
       res.sendRedirect(req.getContextPath()+"/Courses_Detail/UpCourseSession.jsp");       
       }
       catch(SQLException e){
       out.println(e.getMessage()); 
       }
       finally{
       try{
           if(rs1!=null){rs1.close();}         
           if(psmt1!=null){psmt1.close();}
           if(psmt2!=null){psmt2.close();}
           if(con!=null){con.close();}           
         }
       catch(SQLException e){out.println(e.getMessage());}
       }        
   }   
}
