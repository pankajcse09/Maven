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
import java.util.*;
/**
 *
 * @author kanchan
 * @version
 */

public class StudCompartUpdate extends HttpServlet {
    
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
       PreparedStatement psmt5=null;
       PreparedStatement psmt6=null;
       ResultSet rs1=null;
       ResultSet rs4=null;
       String eo="";  
       InfoUpdate iu=new InfoUpdate();
       HashMap hm=new HashMap();
       int s=0;
       int cy=0;
       String yyy="";
       String dts=(String)req.getParameter("dated");
       String yrs=(String)req.getParameter("yrs");             
       List ar=new ArrayList();
       //Calendar cal = Calendar.getInstance();
       String dg=(String)req.getParameter("deg");   
       String qr2="";   
       String qr3="";
       String qr4="";
       String qr5="";
       String qr6="";
       int yrpsd=0;
       int yrrmn=0;
       int yrtot=0;
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
       String sid="";    
       String sm="";
       String eyr="";
       String cyr="";
       String ssn="";       
       String qr1="select studid,eyear,currentyr,sessions,max(TO_NUMBER(sem)) as sem  from studinfo where status='N' and degree='"+dg+"' and TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4)))-1 from studinfo  where degree='"+dg+"') group by studid,eyear,currentyr,sessions";
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();       
       while(rs1.next()){                     
       sm=rs1.getString("sem"); 
       sid=rs1.getString("studid");        
       eyr=rs1.getString("eyear");
       cyr=rs1.getString("currentyr");
       ssn=rs1.getString("sessions");         
       hm=iu.upCompart(dg,sid,sm,cyr,ssn);      
       qr2="update studinfo set status='"+hm.get("status").toString()+"' where status='N' and studid='"+sid+"' and degree='"+dg+"' and sessions='"+ssn+"'";    
       psmt2=con.prepareStatement(qr2);         
       psmt2.executeUpdate();  
       qr3="insert into studinfo(studid,eyear,sem,currentyr,sessions,degree,status,dated)values(?,?,?,?,?,?,?,?)";    
       psmt3=con.prepareStatement(qr3);
       psmt3.setString(1,sid);
       psmt3.setString(2,eyr);        
       psmt3.setString(3,hm.get("semes").toString());
       psmt3.setString(4,hm.get("crntyr").toString());
       psmt3.setString(5,hm.get("sesn").toString());
       psmt3.setString(6,dg);
       psmt3.setString(7,"N");
       psmt3.setString(8,dts);
       psmt3.executeUpdate();   
       yrrmn=5-Integer.parseInt(hm.get("crntyr").toString());
       qr4="select count(distinct sessions)as sessions from studinfo where studid='"+sid+"'";
       psmt4=con.prepareStatement(qr4);
       rs4=psmt4.executeQuery(); 
       if(rs4.next()==true){
       yrpsd=Integer.parseInt(rs4.getString("sessions"));
       }
       yrtot=yrrmn+yrpsd;
       if(yrtot>7){ 
       qr5="insert into dropped_stud(stid,sfname,smname,slname,sdobirth,stdgender,fname,mname,shomeadd1,stustate,stdcoun,scty,scolge,sdntdeg,sentyear,sadvisor)" +
              "values((select stid from studnt_reg where stid='"+sid+"'),"+
              "(select sfname from studnt_reg where stid='"+sid+"'),"+
              "(select smname from studnt_reg where stid='"+sid+"'),"+
              "(select slname from studnt_reg where stid='"+sid+"'),"+
              "(select sdobirth from studnt_reg where stid='"+sid+"'),"+
              "(select stdgender from studnt_reg where stid='"+sid+"'),"+
              "(select fname from studnt_reg where stid='"+sid+"'),"+
              "(select mname from studnt_reg where stid='"+sid+"'),"+
              "(select shomeadd1 from studnt_reg where stid='"+sid+"'),"+
              "(select stustate from studnt_reg where stid='"+sid+"'),"+
              "(select stdcoun from studnt_reg where stid='"+sid+"'),"+
              "(select scty from studnt_reg where stid='"+sid+"'),"+
              "(select scolge from studnt_reg where stid='"+sid+"'),"+
              "(select sdntdeg from studnt_reg where stid='"+sid+"'),"+
              "(select sentyear from studnt_reg where stid='"+sid+"'),"+
              "(select sadvisor from studnt_reg where stid='"+sid+"'))";            
       psmt5=con.prepareStatement(qr5);
       psmt5.executeUpdate();     
       qr6="delete from studnt_reg where stid='"+sid+"'";   
       psmt6=con.prepareStatement(qr6);
       psmt6.executeUpdate();
       }
        }
       ServletContext context=getServletContext();
       context.setAttribute("msg","Updated"); 
       res.sendRedirect(req.getContextPath()+"/UpdateCompartStud.jsp");          
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
           if(psmt3!=null){
               psmt3.close();
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
