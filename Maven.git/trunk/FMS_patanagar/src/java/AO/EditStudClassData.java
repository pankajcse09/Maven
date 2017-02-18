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

public class EditStudClassData extends Action {
    
    Connection cn=null;
    Statement stmt1=null;
    Statement stmt3=null;  
    PreparedStatement pst=null;
    ResultSet rs3=null;
    
   private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//          PrintWriter out=response.getWriter();
          ArrayList arr=new ArrayList();   
          SchoolEO seo=new SchoolEO();
          try{
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e){}  
 /******************************Displaying Detail of fees *************************/ 
          String disp=request.getParameter("disp");
          if(disp!=null){
           try{  
           String srnum=request.getParameter("srnum");      
           String sesn=request.getParameter("session");    
           String gend=request.getParameter("gnd"); 
           seo.setGender(gend);
           String sr="";        
        String qry="select * from studentregis where srnum='"+srnum+"' and session='"+sesn+"'";        
        stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          if(rs3.next()){    
          seo.setSession(rs3.getString("session"));    
          seo.setSrnum(rs3.getString("srnum"));
          seo.setSname(rs3.getString("studname"));
          seo.setSeekadd(rs3.getString("seekadd"));          
          }         
          }catch(SQLException ee){}          
           try{
             if(rs3!=null){rs3.close();}
             if(stmt3!=null){stmt3.close();}
             if(cn!=null){cn.close();}
            }catch(SQLException e){}          
            }
          request.setAttribute("jbean",seo);
          return mapping.findForward(SUCCESS);       
    }
}
