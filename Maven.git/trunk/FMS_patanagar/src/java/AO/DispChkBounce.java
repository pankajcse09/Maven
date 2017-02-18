

package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;

/**
 *
 * @author sonal
 * @version
 */

public class DispChkBounce extends Action {
    
    Connection cn=null;
    Statement stmt=null;
    Statement stmt3=null;
   
    ResultSet rs2=null;
    ResultSet rs3=null;
    
    String Syear="";
    String StYear="";
    String EdYear="";
    double remain=0;

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
  
          
          
 /***************************************************************************************/   
          
          String disp=request.getParameter("dis"); out.println(disp);
       
          if(disp!=null)
          {
          try
          {
           String chknum=request.getParameter("checknumber"); out.println(chknum);
           
 /******************************************************************************************/
          
       
       String tfn="Select * from feerecord where dnum='"+chknum+"' ";
       out.println(tfn);
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(tfn);
    
//         
         while(rs3.next())
         {
                 EO.SchoolEO seo=new EO.SchoolEO();
                  
                  seo.setSrnum(rs3.getString("srnum"));
                  seo.setSname(rs3.getString("studentname"));
                  seo.setClasses(rs3.getString("class"));
                  seo.setStatus(rs3.getString("feestatus"));
                  seo.setFee(rs3.getDouble("amountpaid"));
                  seo.setDname(rs3.getString("dnum"));
                  seo.setDdate(rs3.getString("ddate"));
                  seo.setBankname(rs3.getString("bankname"));
                  seo.setFeesubdate(rs3.getString("fsubdate"));
                  seo.setTodate(rs3.getString("todate")); 
                  seo.setFromdate(rs3.getString("fromdate"));
                  seo.setEamount(rs3.getDouble("eamount"));
                  seo.setPamount(rs3.getDouble("pamount"));
                  seo.setSyear(rs3.getString("Syear"));
                  seo.setEyear(rs3.getString("Eyear"));
                  seo.setCurfine(rs3.getDouble("totfine"));
                  seo.setPaying(rs3.getDouble("paying"));
                  seo.setChkamount(rs3.getDouble("chkamount"));
                  seo.setSection(rs3.getString("section"));
                 
                 
          seo.setRemain(seo.getPaying()-seo.getChkamount()); 
          out.println(seo.getPaying()-seo.getChkamount());
          arr.add(seo);
         }  out.println(arr);
          request.setAttribute("arr",arr);
        
          stmt3=null;
          rs3=null;   

        RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/chkbounce.jsp?remain="+remain); 
        rd2.forward(request,response); 
          }catch(SQLException ee)
          {
         
                ee.getStackTrace();
            }
          }
          try
           {
               if(rs2!=null)
             {rs2.close();}
              if(rs3!=null)
             {rs3.close();}
             if(stmt!=null)
             {stmt.close();}
              if(stmt3!=null)
             {stmt3.close();}
             if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
     
        return mapping.findForward("");
        
    }
}
