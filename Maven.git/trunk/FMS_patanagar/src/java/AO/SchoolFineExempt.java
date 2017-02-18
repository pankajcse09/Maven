
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

public class SchoolFineExempt extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    Statement stmt1=null;
    ResultSet rs3=null;
    
   private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
          PrintWriter out= response.getWriter();
          ArrayList arr=new ArrayList();
          
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
           String srnum=request.getParameter("srnum");       out.println(srnum); 
           String uid=request.getParameter("uid");       out.println(uid); 
 
       String qry="Select srnum,sname,classes,section,due,rowid from finerecord where srnum='"+srnum+"' order by rowid desc";        
       out.println(qry);  
       stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          rs3.next();
          {
               EO.SchoolEO gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("sname"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setDue(rs3.getInt("due"));
          gt.setRowid(rs3.getInt("rowid"));
                   
          arr.add(gt);
          }
       out.println(arr);
          request.setAttribute("arr",arr);
             
          }catch(SQLException ee)
          {
          
                ee.getStackTrace();
            }
          
             try
           {
             if(stmt3!=null)
             {stmt3.close();}
             if(rs3!=null)
             {rs3.close();}
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
           String rid=request.getParameter("rowid"); out.println(rid);  
           String remaindue=request.getParameter("remaindue"); out.println(remaindue);  
           String uid=request.getParameter("uid"); out.println(uid);  
           String srnum1=request.getParameter("srnum1"); 
          
  String sql1="update finerecord set status='Exempted',exemptby='"+uid+"',due='"+remaindue+"' where rowid='"+rid+"'";
  out.println(sql1);    
  stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);
 
         stmt1=null;
 String sql="update feerecord set pamount='"+remaindue+"' where srnum='"+srnum1+"' order by rowid desc";
  out.println(sql);    
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql);
  
    String sub=new String(" "+srnum1+" due is Exempted");

                       request.setAttribute("sub",sub);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/schoolfineExempt.jsp"); 
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
