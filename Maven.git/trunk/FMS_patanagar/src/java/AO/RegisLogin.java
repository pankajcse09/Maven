
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
public class RegisLogin extends Action {
    
  
        Connection cn;
        PreparedStatement pstmt1,pstmt2=null;
        Statement stmt=null;
        ResultSet rs=null;
        int count=0;
       // String username="";
    
     private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();
        
        SimpleDateFormat df=new SimpleDateFormat("dd/mm/yyyy");
        
          try
         {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
        
        try{
        
        String userid=request.getParameter("userid");       
        userid=userid.trim();
                
        String password=request.getParameter("password");        
        password=password.trim();
        
        Common comLogin = new Common();
        String pwd = (String)comLogin.encrypt(password);
        pwd=pwd.trim();
         
        String desig=request.getParameter("desig");      
        String sq=request.getParameter("secretquestion");        
        String ans=request.getParameter("answere");         
        String name=request.getParameter("name");      
        String dob=request.getParameter("dob");              
        String gender=request.getParameter("gender");           
        String contactno=request.getParameter("contactno");      
        String address=request.getParameter("address");       
        String email=request.getParameter("email");     
        String usertype=request.getParameter("usertype");     
        
         
           
            String sql="select userid from login";

            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);

             while(rs.next())
             {     
             count=0;
             
                   String aduser=(String)rs.getString("userid");
                   aduser=aduser.trim();
                  
                    if(aduser.equals(userid))
                    {
                       String existuser=new String(" "+aduser+" userid already exist");

                       request.setAttribute("existuser",existuser);
                       RequestDispatcher  rd1  = request.getRequestDispatcher("/fee/RegisLogin.jsp"); 
                       rd1.forward(request,response); 


                    count=1;
                     break; 

         }

        }

         if(count==0)
         {
            String sql1="insert into RegisLogin(userid,password,secret,answere,name,dob,gender,contact,address,email,desig,usertype)values(?,?,?,?,?,?,?,?,?,?,?,?)";
           out.println(sql1);

            pstmt1=cn.prepareStatement(sql1);
           
            pstmt1.setString(1,userid);
            pstmt1.setString(2,pwd);
            pstmt1.setString(3,sq);
            pstmt1.setString(4,ans);
            pstmt1.setString(5,name);
            pstmt1.setString(6,dob);
            pstmt1.setString(7,gender);
            pstmt1.setString(8,contactno);
            pstmt1.setString(9,address); 
            pstmt1.setString(10,email);
            pstmt1.setString(11,desig);
            pstmt1.setString(12,usertype);
            pstmt1.executeUpdate();


            String sql2="insert into login(userid,password,secretquestion,answer,usertype)values(?,?,?,?,?)";
            //out.println(sql2);

            pstmt2=cn.prepareStatement(sql2);
            pstmt2.setString(1,userid);     
            pstmt2.setString(2,pwd);            
            pstmt2.setString(3,sq);               
            pstmt2.setString(4,ans);   
            pstmt2.setString(5,usertype);  
            
            pstmt2.executeUpdate();
            
                RequestDispatcher rd  = request.getRequestDispatcher("/fee/continue.jsp"); 
               rd.forward(request,response); 

             }
        }
        catch(SQLException e)
        {
            out.println(e.getMessage());
        }
     return mapping.findForward("success");
             
        
    }
}
