

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
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
/**
 *
 * @author sonal
 * @version
 */
public class EnterConc extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet rs=null;
    String tp="";
            
    private final static String SUCCESS = "success";
   
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();
              
       try{
        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
            
            String type=request.getParameter("type");   out.println(type);
            String tutfee=request.getParameter("tutfee");    
            String transfee=request.getParameter("transfee");   
            
             String sql="select type from concession where type='"+type+"'";

            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
            
            
           if(rs.next()==true)  
           {
          
          
                 String msg=new String(" Data is Already Entered");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/concession.jsp"); 
                       rd1.forward(request,response); 
       
       } else
             {
            
            String sql1="insert into concession(type,tutconc,transconc)values(?,?,?)";
            out.println(sql1);
            pstmt=cn.prepareStatement(sql1); 
            pstmt.setString(1,type);
            pstmt.setString(2,tutfee);
            pstmt.setString(3,transfee);
                                 
          pstmt.executeUpdate();
          pstmt=null;
         
          String msg=new String(" Data is Entered");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/concession.jsp"); 
                       rd1.forward(request,response); 

       }
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