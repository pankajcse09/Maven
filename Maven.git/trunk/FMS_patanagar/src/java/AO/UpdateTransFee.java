
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

public class UpdateTransFee extends Action {
    
            Connection cn=null;
            PreparedStatement pstmt=null;
            Statement stmt=null;
            ResultSet rs=null;
       
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out= response.getWriter();
        
      
        
        try{
          DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            }
               catch(Exception e){
             
            }
     try
    { 
        String qry="Select count(*) as cid from transportfee ";
             out.println(qry);
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qry);
             rs.next();
             int cid=rs.getInt("cid");
            
          ArrayList rt=new ArrayList();
          ArrayList bsf=new ArrayList();
          
             for(int i=0;i<cid;i++){
          rt.add(request.getParameter("route"+i));
          bsf.add(request.getParameter("busfee"+i));
                   
            }
     
        String del="delete from transportfee";
               pstmt=cn.prepareStatement(del);                      
               pstmt.executeUpdate();
       pstmt=null;
       String sq="insert into transportfee(route,busfee)values(?,?)";  
    out.println(sq);
                
     
    for(int m=0;m<cid;m++){         
          
            pstmt=cn.prepareStatement(sq); 
            pstmt.setString(1,rt.get(m).toString()); 
            pstmt.setDouble(2,Double.parseDouble(bsf.get(m).toString())); 
                                
            pstmt.executeUpdate();
       }
            rt.clear();
            bsf.clear();
           
          String msg=new String("Bus Fee is Updated");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/dutf.do?dispfee=dispfee"); 
                       rd1.forward(request,response);          
           
           }
        catch(SQLException e)
        {
         out.println(e.getMessage());
       
        }
    
       try
           {
           
             if(rs!=null)
             {rs.close();}
             if(stmt!=null)
             {stmt.close();}
             if(pstmt!=null)
             {pstmt.close();}
             if(cn!=null)
             {cn.close();}   
           }catch(SQLException e){
           out.println(e.getMessage());
           }  
    
        return mapping.findForward("");
        
    }
}
