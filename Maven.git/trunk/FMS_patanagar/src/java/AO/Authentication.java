
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
public class Authentication extends Action {
    
    Statement stmt = null;
    PreparedStatement pstmt2 = null;
    Connection cn=null;
    ResultSet rs=null;
    int count=0;
    
       public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();
          HttpSession session=request.getSession();
        
        SimpleDateFormat df=new SimpleDateFormat("dd/mm/yyyy");
       
          try
         {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
         try
         {
             String sqlt="Select date_format(current_date,'%d/%M/%Y') as dt";
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sqlt);
             rs.next();
            String dt=rs.getString("dt");
           stmt=null;
           rs=null;
           
           String sqly="Select (current_time) as tm";
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sqly);
             rs.next();
            String tm=rs.getString("tm");
           stmt=null;
           rs=null;
           
//            String usertype=request.getParameter("usertype");
//            usertype=usertype.trim();
            String username=request.getParameter("userid");
            username=username.trim();
            String password=request.getParameter("password");
            password=password.trim();
            Common comLogin = new Common();
            String pwd = (String)comLogin.encrypt(password);
            pwd=pwd.trim();
            
           String sql3="Select usertype from login where userid='"+username+"'";
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sql3);
            
            rs.next();
            String ut=rs.getString("usertype");
            ut=ut.trim();
        
            stmt=null;
            rs=null;
             
            String sql="Select userid,password,usertype from login";
               
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
                        
            while(rs.next())
             {     
             count=0;
                  
                       String log=rs.getString("userid");
                         log=log.trim();
                       String pass=rs.getString("password");
                         pass=pass.trim();
                         
                  if(log.equals(username)&&pass.equals(pwd))
                    {
                                         synchronized(session){
                                     session.setAttribute("username",log);    
                                     session.setAttribute("usertype",ut);    
                                         
                  if(ut.equalsIgnoreCase("Admin"))   
                     {
           String sqlr="insert into loginrecord(username,type,dt,time)values(?,?,?,?)";
            //out.println(sql2);

            pstmt2=cn.prepareStatement(sqlr);
            pstmt2.setString(1,log);     
            pstmt2.setString(2,ut);            
            pstmt2.setString(3,dt);     
            pstmt2.setString(4,tm);         
            pstmt2.executeUpdate();
                pstmt2=null;                         
                   RequestDispatcher rd1= request.getRequestDispatcher("/fee/main.jsp");                       
                  rd1.forward(request,response);
                     }                                            
                            
                 else if(ut.equalsIgnoreCase("Super"))   
                  {
            String sqlr="insert into loginrecord(username,type,dt,time)values(?,?,?,?)";
            //out.println(sql2);

            pstmt2=cn.prepareStatement(sqlr);
            pstmt2.setString(1,log);     
            pstmt2.setString(2,ut);            
            pstmt2.setString(3,dt);     
            pstmt2.setString(4,tm);         
            pstmt2.executeUpdate();
                pstmt2=null;         
                  RequestDispatcher rd2= request.getRequestDispatcher("/fee/Supermain.jsp");                     
                  rd2.forward(request,response);
                   }
                 
             }
               count=1;
               break;  
         }
                        
         }
         if(count==0)
         {     
               String incorrect=new String("Please check Username and Password !");         
               request.setAttribute("check",incorrect);
              
               RequestDispatcher rd= request.getRequestDispatcher("/fee/login.jsp");
               rd.forward(request,response); 
                     
                    }
            
                }catch(Exception e)
                {
                   e.printStackTrace();
                }
 return mapping.findForward("success");
        
    }
}
