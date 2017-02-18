
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

public class HouseWiseReport extends Action {
    
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
           String house=request.getParameter("house");    
           String syear=request.getParameter("syear");
           String eyear=request.getParameter("eyear");
           String hs="";
           
       String qry="Select sname,srnum,classes,section,house from studacaddetail where house='"+house+"' and syear='"+syear+"' and eyear='"+eyear+"'";        
       out.println(qry);  
       stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
          EO.SchoolEO gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("sname"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setHouse(rs3.getString("house"));
           hs=gt.getHouse();    
          arr.add(gt);
          }
       out.println(arr);
          request.setAttribute("arr",arr);
          request.setAttribute("hs",hs);
             
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
