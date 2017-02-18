

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
import AO.datediff.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;
/**
 *
 * @author sonal
 * @version
 */

public class DispStudDetail extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    ResultSet rs3=null;
    
    String Syear="";
    String status="";
    int totfine=0;
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
         datediff dd=new datediff();    
          
          PrintWriter out= response.getWriter();
          ArrayList arr=new ArrayList();
       
           EO.SchoolEO gt=null;
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Detail of fees *************************/
        try
        {
           String cls=request.getParameter("classes"); 
           String Syear=request.getParameter("syear");   
          // String Eyear=request.getParameter("eyear");      
           String section=request.getParameter("section"); 
            
  if(cls.equals("All"))
 {
               
       String qry="select sa.srnum,sa.sname,sa.classes,sa.section,sd.fname,sd.mname,sd.gender,sd.paddress,sd.pmobile,sd.dob from studacaddetail sa inner join studentregis sd where sa.srnum=sd.srnum and sa.syear='"+Syear+"' and sa.section='"+section+"'";        
         out.println("hello1"+qry);  
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
               gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("sname"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setFname(rs3.getString("fname"));
          gt.setMname(rs3.getString("mname"));
          gt.setGender(rs3.getString("gender"));
          gt.setAddress(rs3.getString("paddress"));
          gt.setMobile(rs3.getString("pmobile"));
          gt.setDob(rs3.getString("dob"));
          
          arr.add(gt);
          }
         
        request.setAttribute("arr",arr);    
               
 
 }else
 {
     if(section.equals("All"))     
     {
       String qry="select sa.srnum,sa.sname,sa.classes,sa.section,sd.fname,sd.mname,sd.gender,sd.paddress,sd.pmobile,sd.dob from studacaddetail sa inner join studentregis sd where sa.srnum=sd.srnum and sa.syear='"+Syear+"' and sa.classes='"+cls+"'";        
       out.println("hello2"+qry);  
       stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
             gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("sname"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setFname(rs3.getString("fname"));
          gt.setMname(rs3.getString("mname"));
          gt.setGender(rs3.getString("gender"));
          gt.setAddress(rs3.getString("paddress"));
          gt.setMobile(rs3.getString("pmobile"));
          gt.setDob(rs3.getString("dob"));
          
          arr.add(gt);
          }
     }
     else
     {
         String qry="select sa.srnum,sa.sname,sa.classes,sa.section,sd.fname,sd.mname,sd.gender,sd.paddress,sd.pmobile,sd.dob from studacaddetail sa inner join studentregis sd where sa.srnum=sd.srnum and sa.syear='"+Syear+"' and sa.classes='"+cls+"' and sa.section='"+section+"'";        
          out.println("hello3"+qry);  
         stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
             gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("sname"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setFname(rs3.getString("fname"));
          gt.setMname(rs3.getString("mname"));
          gt.setGender(rs3.getString("gender"));
          gt.setAddress(rs3.getString("paddress"));
          gt.setMobile(rs3.getString("pmobile"));
          gt.setDob(rs3.getString("dob"));
          
          arr.add(gt);
          }
         
     }
       
/***********************************Forwarding Data*****************************************/    
         request.setAttribute("arr",arr);
 }       
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
}
