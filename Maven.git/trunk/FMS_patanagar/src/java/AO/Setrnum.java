
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

public class Setrnum extends Action {
    
    private final static String SUCCESS = "success";
   
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          Connection cn=null;    
          PreparedStatement pstmt=null;
          Statement stmt=null;
          ResultSet rs=null;
          PrintWriter out= response.getWriter();

        try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
           out.println(cn);
          }catch(Exception e)
          {}
       
          int rnum=Integer.parseInt(request.getParameter("rnum").toString());
          String enter=request.getParameter("enter");
          
     try
      {
         if( enter!=null)
           {
            String gety="select rnum from setrnum";
           
             stmt=cn.createStatement();
             rs=stmt.executeQuery(gety);
             if(rs.next()==false){
             
            String sql1="insert into setrnum(rnum)values(?)";
            out.println(sql1);
            pstmt=cn.prepareStatement(sql1); 
            pstmt.setInt(1,rnum);
           
                               
          pstmt.executeUpdate();
          pstmt=null;
          
          String msg=new String(" Receipt Number is Entered");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/rnum.jsp"); 
                       rd1.forward(request,response);  
        }
             else
             {
       
          String msg=new String(" Receipt Number is already entered");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/rnum.jsp"); 
                       rd1.forward(request,response);       
             }
         }
          }catch(SQLException e)
        {
         out.println(e.getMessage());
        
       }
         /***************************************************************************/
          
          String update=request.getParameter("update");
         try
          {
          
          if(update!=null)
          {
             String rnum1=request.getParameter("rnum");   
            
         String sql ="update setrnum set rnum='"+rnum1+"'";
        out.println(sql); 
          pstmt=cn.prepareStatement(sql);
          pstmt.executeUpdate();
          pstmt=null;
                 String msg=new String("Receipt Number is updated");
                  request.setAttribute("msg",msg);
                 RequestDispatcher  rd1  =request.getRequestDispatcher("/rnum.jsp"); 
                rd1.forward(request,response);       

          }
           }catch(SQLException p)
          {p.printStackTrace();}
    
  /*****************************************************************************************/        
  
         try
           {
              if(rs!=null)
             {rs.close();}
             if(pstmt!=null)
             {pstmt.close();}
             if(stmt!=null)
             {stmt.close();}
             if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
    
    return mapping.findForward("");
}
     
    }