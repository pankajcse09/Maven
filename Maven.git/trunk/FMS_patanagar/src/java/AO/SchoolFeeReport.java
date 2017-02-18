

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

public class SchoolFeeReport extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    Statement stmt1=null;
    Statement stmt=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    ResultSet rs=null;
    ResultSet rs3=null;
    ResultSet rs1=null;
    String srnum="";
    String sname="";
    String month="";
    
   private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
          PrintWriter out= response.getWriter();
          ArrayList arr=new ArrayList();
           ArrayList arrs=new ArrayList();
            
          
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
           String syear=request.getParameter("syear");     out.println(syear);  
           String eyear=request.getParameter("eyear");      out.println(eyear);  
           String classes=request.getParameter("classes");    out.println(classes);  
          
           if(classes.equals("All"))
           {  out.println("hi");  
               EO.SchoolEO gt=null;
               EO.SchoolEO st=null;
            String qry="Select distinct(srnum),sname from feedetailreport where syear='"+syear+"' and eyear='"+eyear+"'";        
             out.println(qry);  
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
         while(rs3.next())
         {
             st=new EO.SchoolEO();
          st.setSrnum(rs3.getString("srnum"));
          st.setSname(rs3.getString("sname"));
                   
          String qry2="Select distinct(month) from feedetailreport where syear='"+syear+"' and eyear='"+eyear+"' and srnum='"+st.getSrnum()+"'";        
          
          stmt2=cn.createStatement();
          rs2=stmt2.executeQuery(qry2);  
          while(rs2.next())
          {
          month=rs2.getString("month");   
          
          String qry3="Select month,amount,fsubdate,sname from feedetailreport where srnum='"+st.getSrnum()+"' and syear='"+syear+"' and eyear='"+eyear+"' and month='"+month+"'";         
           out.println(qry3);
          stmt=cn.createStatement();
          rs=stmt.executeQuery(qry3);  
          while(rs.next())
          {
             gt=new EO.SchoolEO();
             
//             String month=rs.getString("month");   out.println("month"+month);
//              String amount=rs.getString("amount");   out.println("amount"+amount);
//               String fsubdate=rs.getString("fsubdate");   out.println("fsubdate"+fsubdate);
         
          gt.setMonth(rs.getString("month"));
          gt.setAmountpaid(rs.getInt("amount"));
          gt.setFeesubdate(rs.getString("fsubdate"));
          gt.setSname(rs.getString("sname"));       
          arr.add(gt);
       
          } 
          }
              arrs.add(st);
//       out.println("arr"+arr);
//        out.println("arrs"+arrs);    
           request.setAttribute("arr",arr);
          request.setAttribute("arrs",arrs);    
           }     
           
        }
          
          }catch(SQLException ee)
          {
          
                ee.getStackTrace();
            }
          
             try
           {
             if(rs3!=null)
             {rs3.close();}
              if(rs2!=null)
             {rs2.close();}
              if(rs!=null)
             {rs.close();}
             if(rs1!=null)
             {rs1.close();}
             if(stmt3!=null)
             {stmt3.close();}
             if(stmt2!=null)
             {stmt2.close();}
             if(stmt!=null)
             {stmt.close();}
             if(stmt1!=null)
             {stmt1.close();}
             if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
    
          }
        
             return mapping.findForward("");
             
 
    }
}
