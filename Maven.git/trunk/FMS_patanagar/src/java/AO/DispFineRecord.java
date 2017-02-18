
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

public class DispFineRecord extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
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
          EO.SchoolEO gt=new EO.SchoolEO();
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
           
           String Syear=request.getParameter("Syear");    out.println(Syear);
           String Eyear=request.getParameter("Eyear");    out.println(Eyear);
 
       String qry="Select regisnum,todate,fromdate,fsubdate,fine,Syear,Eyear from finerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"')";        
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
         // gt.setRegisnum(rs3.getString("regisnum"));
          gt.setTodate(rs3.getString("todate"));
          gt.setFromdate(rs3.getString("fromdate"));
          gt.setPfine(rs3.getInt("fine"));
          gt.setFeesubdate(rs3.getString("fsubdate"));
          gt.setSyear(rs3.getString("Syear"));
          gt.setEyear(rs3.getString("Eyear"));
          
          arr.add(gt);
          }
          String sm="select sum(fine)as totfine from finerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"')";
            
            pstmt=cn.prepareStatement(sm);
            rs=pstmt.executeQuery();
            rs.next();
            totfine=rs.getInt("totfine");
       
      
/***********************************Forwarding Data*****************************************/    
          request.setAttribute("arr",arr);
          request.setAttribute("totfine",new Integer(totfine));
        
          }catch(SQLException ee)
          {
          
                ee.getStackTrace();
            }
          
             try
           {
             if(rs!=null)
             {rs.close();}
              if(rs3!=null)
             {rs3.close();}
             if(pstmt!=null)
             {pstmt.close();}
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
