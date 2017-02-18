


package AO;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import com.myapp.struts.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.*;

/**
 *
 * @author sonal
 * @version
 */
public class changepass extends HttpServlet {
    
        Connection cn=null; 
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(); 
        String uid=(String)session.getAttribute("forwardid"); 
     
         String opass=request.getParameter("opass");
          opass=opass.trim();
          
         String npass=request.getParameter("npass");
         npass=npass.trim();
        
        Common comLogin = new Common();
        String npwd = (String)comLogin.encrypt(npass);
        npwd=npwd.trim();
         String sq=request.getParameter("sq");
          String ans=request.getParameter("ans");
        
               try{
        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            String sql1="update regislogin set password='"+npwd+"',secret='"+sq+"',answere='"+ans+"' where userid='"+uid+"'";
            
            pstmt=cn.prepareStatement(sql1);         
            pstmt.executeUpdate();
        
               RequestDispatcher rd=request.getRequestDispatcher("/fee/continue.jsp"); 
             rd.forward(request,response); 

             }
        catch(SQLException e)
        {
         out.println(e.getMessage());
        }
        
        out.close();
    }
    

}
