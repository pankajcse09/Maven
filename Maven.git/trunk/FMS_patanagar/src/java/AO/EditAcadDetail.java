
package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import java.io.*;
import AO.datediff.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;
import schedule.*;
/**
 *
 * @author sonal
 * @version
 */

public class EditAcadDetail extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    Statement stmt1=null;
    ResultSet rs3=null;
   PreparedStatement pstmt=null;
    ResultSet rs=null;
    
   private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
          PrintWriter out= response.getWriter();
          ArrayList arr=new ArrayList();
          UpdateMethods upd=new UpdateMethods();
          JavaBeanExam jb=new JavaBeanExam(); 
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Detail of fees *************************/
          String disp=request.getParameter("disp");
          if(disp!=null)
          {
        try
        {
           String srnum=request.getParameter("srnum");       
           String syear=request.getParameter("syear");  
           String sr="";
          // String eyear=request.getParameter("eyear");   
        
       String qry="Select * from studacaddetail where srnum='"+srnum+"' and syear='"+syear+"'";        
       out.println(qry);  
       stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          rs3.next();
          {
           EO.SchoolEO gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("sname"));
          gt.setDob(rs3.getString("dob"));
          gt.setDoj(rs3.getString("doj"));
          gt.setGender(rs3.getString("gender"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setHouse(rs3.getString("house"));
          gt.setRoute(rs3.getString("route"));
          gt.setBuscode(rs3.getString("buscode"));
          gt.setTripnum(rs3.getString("tripnum"));
          gt.setConcession(rs3.getDouble("concession"));
          gt.setSyear(rs3.getString("syear"));
          gt.setEyear(rs3.getString("eyear"));
          gt.setHeads(rs3.getString("head"));
          
         
          sr=gt.getSrnum();
          arr.add(gt);
          
          
          }
   
          request.setAttribute("arr",arr);
          request.setAttribute("sr",sr);
          request.setAttribute("syear",syear);
          
          
          /////////////////////////////////
          
            try 
{

int returnValue = 0;

InputStream in = null;
OutputStream os = null;
Blob blob = null;

String path=request.getRealPath("/image")+"\\pic.jpg"; 
out.println(path);
 String query = "SELECT pic FROM studacaddetail WHERE srnum='"+srnum+"' and syear='"+syear+"' ";        
out.println(query);
 cn.setAutoCommit(false);
Statement stmt = cn.createStatement();
ResultSet rs = stmt.executeQuery(query);
int i=1;
if(rs.next()) 
{
String len1 = rs.getString("pic");
int len = len1.length();
byte [] b = new byte[len];
in = rs.getBinaryStream("pic");
int index = in.read(b, 0, len);
OutputStream outImej = new FileOutputStream(path);

while (index != -1)
{
outImej.write(b, 0, index);
index = in.read(b, 0, len);
}
outImej.close();
i++;
}
else
{
returnValue = 1;
}
}
catch(Exception e)
{
out.println("SQLEXCEPTION : " +e);
}
          
         /////////////////////////////////    
          }catch(SQLException ee)
          {
          
                ee.getStackTrace();
            }
          
             try
           {
             if(rs3!=null)
             {rs3.close();}
             if(stmt3!=null)
             {stmt3.close();}
            
              if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
        
          
             return mapping.findForward("success");
             }
 /***********************************Insert Data*****************************************/          
         
           String enter=request.getParameter("enter");
          if(enter!=null)
          {
        try
        {
           String srnum=request.getParameter("srnum"); 
           String sname=request.getParameter("sname"); 
           String gender=request.getParameter("gender"); 
           String doj=request.getParameter("doj"); 
           String dob=request.getParameter("dob");
           String classes=request.getParameter("classes");
           String section=request.getParameter("section");
           String house=request.getParameter("house");
           String route=request.getParameter("route");
           String buscode=request.getParameter("buscode");
           String tripnum=request.getParameter("tripnum");
           double concession=Double.parseDouble(request.getParameter("concession").toString());
           double totconc=concession/100;
           String syear=request.getParameter("syear"); 
           String eyear=request.getParameter("eyear"); 
           String head=request.getParameter("head");
        // int fpstatus=Integer.parseInt(request.getParameter("fpstatus").toString());
           double imgsize=0.0;
               
   String img5= request.getParameter("pic");
     
       
if(img5.equals(""))
{ imgsize=0.0;       
          
  String sql1="update studacaddetail set sname='"+sname+"',gender='"+gender+"',doj='"+doj+"',dob='"+dob+"',classes='"+classes+"',section='"+section+"',house='"+house+"',route='"+route+"',buscode='"+buscode+"',tripnum='"+tripnum+"',concession='"+concession+"',head='"+head+"' where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'";
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql1);
  stmt1=null;
  
   String sql2="update oldstudregis set studname='"+sname+"',classes='"+classes+"',section='"+section+"' where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'";
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql2);
  stmt1=null;
  
  
}
else
{
        String img1= request.getParameter("pic");
        int a=img1.length();
        int b=img1.lastIndexOf("\\"); 
       String path=request.getParameter("pic"); 
        
       String f1=img1.substring(b+1,a);           
       StringBuffer sb=new StringBuffer();
       File imgfile = new File(path);  
       imgsize=imgfile.length();   
       FileInputStream fin = new FileInputStream(imgfile);  
       FileInputStream fin2 = new FileInputStream(imgfile);   
       
     if(imgsize>100000){
           String sub=new String("Image Size Should not be greater than 100 KB");
             request.setAttribute("sub",sub);
             RequestDispatcher  rd1  =request.getRequestDispatcher("dacd.do?disp=disp&srnum="+srnum+"&syear="+syear+""); 
             rd1.forward(request,response); 
       }
       else
       {  

 String qry2= "update studacaddetail set pic=? where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'";
    PreparedStatement pst2= cn.prepareStatement(qry2); 
    pst2.setBinaryStream(1,fin2,(int)imgfile.length()); 
    pst2.executeUpdate();
    pst2=null;
   
 String qry1= "update oldstudregis set pic=? where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'"; 
    PreparedStatement pst1= cn.prepareStatement(qry1);
    pst1.setBinaryStream(1,fin,(int)imgfile.length());
    pst1.executeUpdate();
    pst1=null;
  
 String sql1="update studacaddetail set sname='"+sname+"',gender='"+gender+"',doj='"+doj+"',dob='"+dob+"',classes='"+classes+"',section='"+section+"',house='"+house+"',route='"+route+"',buscode='"+buscode+"',tripnum='"+tripnum+"',concession='"+concession+"',head='"+head+"' where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'";
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql1);
  stmt1=null;
  
 String sql2="update oldstudregis set studname='"+sname+"',classes='"+classes+"',section='"+section+"' where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'";
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql2);
  stmt1=null;
  
} 
}
    int bn=upd.updateAll(jb); 
    String sub=new String(" "+srnum+" record is entered");
     request.setAttribute("sub",sub);
     RequestDispatcher  rd1  =request.getRequestDispatcher("dacd.do?disp=disp&srnum="+srnum+"&syear="+syear+""); 
     rd1.forward(request,response); 
             
          }catch(SQLException ee)
          {
          
                ee.getStackTrace();
            }
          
             try
           {
             if(rs3!=null)
             {rs3.close();}
             if(stmt3!=null)
             {stmt3.close();}
             if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
        
          }
          
                 return mapping.findForward("success");
       
    }
}
