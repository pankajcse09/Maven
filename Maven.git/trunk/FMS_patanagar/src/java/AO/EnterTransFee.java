
package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import java.text.SimpleDateFormat;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sonal
 * @version
 */

public class EnterTransFee extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt=null;
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         PrintWriter out= response.getWriter();
         
         
/********************************* Insert Fee Chart****************************************/
     
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
          
       String route=request.getParameter("route");  
       double busfee=Double.parseDouble(request.getParameter("busfee").toString());       
   try
   {    
       
  String sq="insert into transportfee(route,busfee)values(?,?)";  
  
            pstmt=cn.prepareStatement(sq); 
            pstmt.setString(1,route); 
            pstmt.setDouble(2,busfee); 
                     
            pstmt.executeUpdate();
     
           String msg=new String(""+route+" bus fee is entered");

               request.setAttribute("msg",msg);
               RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/entertransfee.jsp"); 
               rd1.forward(request,response);          
            
           }
        catch(SQLException e)
        {
         out.println(e.getMessage());
       
        }
     
       try
           {
             if(pstmt!=null)
             {pstmt.close();}
              if(cn!=null)
             {
                 cn.close();
             }   
           }catch(SQLException e){}  
      
   return mapping.findForward("");   
         
}
      
    }