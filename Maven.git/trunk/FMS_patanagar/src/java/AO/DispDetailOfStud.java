

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

public class DispDetailOfStud extends Action {
    
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
          HashSet hs=new HashSet();   
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Detail of fees *************************/
        try
        {
           String cls=request.getParameter("cls");
           String Syear=request.getParameter("Syear");    
           String Eyear=request.getParameter("Eyear");    
           String section=request.getParameter("section"); 
         
       String qry="Select studname,srnum,Syear,Eyear,classes,section,admstatus from oldstudregis where Syear='"+Syear+"' and classes='"+cls+"' and section ='"+section+"'";        
       
       stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
               EO.SchoolEO gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("studname"));
          gt.setSyear(rs3.getString("Syear"));
          gt.setEyear(rs3.getString("Eyear"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setAdmstatus(rs3.getString("admstatus"));
          
          arr.add(gt);
          } 
        
/***********************************Forwarding Data*****************************************/    
          request.setAttribute("arr",arr);
             
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
