
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

public class EnterAdditionalFee extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ResultSet rs3=null;
   
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
          PrintWriter out= response.getWriter();
          EO.SchoolEO gt=new EO.SchoolEO();
          ArrayList arr=new ArrayList();
          
        SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf=new SimpleDateFormat("MM"); 
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
 
/******************************Displaying Employee Profile *************************/
      
          String enter=request.getParameter("enter");
          try
          {
          
          if(enter!=null)
          {
             String feesubdate=request.getParameter("feesubdate"); 
             java.util.Date fsb=sdf2.parse(feesubdate);
             String mn=sdf.format(fsb);
             
             String syear=request.getParameter("syear");  
             String eyear=request.getParameter("eyear");  
             String classes=request.getParameter("classes");  
             String section=request.getParameter("section");  
             String cby=request.getParameter("cby"); 
             String cfor=request.getParameter("cfor");  
             int amount=Integer.parseInt(request.getParameter("amount").toString());  
                                      
          String qry="insert into additionalfee(syear,eyear,classes,section,collectby,collectfor,amount,fsubdate,mnt)values(?,?,?,?,?,?,?,?,?)";
             out.println(qry);
            pstmt=cn.prepareStatement(qry); 
            pstmt.setString(1,syear);
            pstmt.setString(2,eyear);
            pstmt.setString(3,classes);
            pstmt.setString(4,section);
            pstmt.setString(5,cby);
            pstmt.setString(6,cfor);
            pstmt.setInt(7,amount);
            pstmt.setString(8,feesubdate);
            pstmt.setString(9,mn);
                 
            pstmt.executeUpdate();
        
                 String sub=new String("Detail is entered");
                 request.setAttribute("sub",sub);
      RequestDispatcher rd2 =request.getRequestDispatcher("/fee/AdditionalFee.jsp"); 
      rd2.forward(request,response); 

          }
           }catch(SQLException p)
          {p.printStackTrace();}
          
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
         
                 return mapping.findForward("");
             
        
    }
}
