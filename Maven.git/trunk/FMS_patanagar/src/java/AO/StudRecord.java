/*
 * StudRegisAO.java
 *
 * Created on August 15, 2009, 12:14 AM
 */
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
import java.io.PrintWriter;
import java.io.*;
import EO.SchoolEO;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
/**
 *
 * @author sonal
 * @version
 */

public class StudRecord extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    ResultSet rs1=null;
    Statement stmt=null;
    ResultSet rs=null;
    int count=0;
        
    private final static String SUCCESS = "success";
    
  
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();
          SchoolEO seo=new SchoolEO();
          DynaActionForm df=(DynaActionForm)form;
         ArrayList arr=new ArrayList();
         
 /*******************************Displaying student record*******************************/
         
            String srnum=request.getParameter("srnum"); 
            String classes=request.getParameter("classes"); 
            String section=request.getParameter("section"); 
            
       
       try{
        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
            
           
            String sql="select sg.srnum,sg.doj,sg.studname,sg.dob,sg.gender,sg.fname,sg.mname,sg.paddress,sg.pphone,sg.pmobile,sg.seekadd,sg.section,sa.classes,sa.section from studentregis sg inner join studacaddetail sa on sg.srnum=sa.srnum where sa.srnum='"+srnum+"' and sa.classes='"+classes+"' and sa.section='"+section+"'";
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);

            rs.next();
                   seo.setSrnum(rs.getString("srnum"));
                   seo.setDateofadd(rs.getString("doj"));
                   seo.setSname(rs.getString("studname"));
                   seo.setGender(rs.getString("gender"));
                   seo.setDob(rs.getString("dob"));
                   seo.setFname(rs.getString("fname"));
                   seo.setMname(rs.getString("mname"));
                   seo.setAddress(rs.getString("paddress"));
                   seo.setRnum(rs.getString("pphone"));
                   seo.setMobile(rs.getString("pmobile"));
                   seo.setSeekadd(rs.getString("seekadd"));
                   seo.setSection(rs.getString("section"));
                   seo.setClasses(rs.getString("classes"));
                   seo.setStatus(rs.getString("section"));
               arr.add(seo);  
          
              request.setAttribute("arr",arr);
       
         }catch(SQLException e)
         {e.printStackTrace();}
    
           try 
{

int returnValue = 0;

InputStream in = null;
OutputStream os = null;
Blob blob = null;

//String path2=request.getContextPath()+("/image")+"/pic.jpg";
String path=request.getRealPath("/image")+"\\pic.jpg"; 

 String query = "SELECT pic FROM studacaddetail WHERE srnum='"+srnum+"'";        
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
              

    return mapping.findForward("success");
}
}    
  