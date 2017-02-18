package Courses;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.myapp.struts.Dataconnectivity;
import java.sql.SQLException;

/**
 *
 * @author piyushrastogi
 * @version
 */
public class CheckEntry extends HttpServlet {    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    Connection course_con=null;
    PreparedStatement psmt=null;
    ResultSet rs=null;   
    public  void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        int count=0;
        String ssn=(String)request.getParameter("session");
         try{
         Dataconnectivity corse=new Dataconnectivity();
         course_con=(Connection)corse.Dataconnect();
         }
       catch(Exception e)
       {
       out.println("DatabaseDown1");
       }
         try{
             String insert_course="select count(sessions) as cnt from studinfo where sessions='"+ssn+"'";            
             psmt=course_con.prepareStatement(insert_course);  
             rs=psmt.executeQuery();             
             if(rs.next()){
             count=rs.getInt("cnt");
             }    
             String cor_data="";
             if(count>0){
             cor_data="Courses not Added or Modified for this Session";  
             }
            request.setAttribute("msg",cor_data);
            RequestDispatcher rf=request.getRequestDispatcher("/Courses_Detail/Courses_Detail.jsp");
            rf.forward(request,response);                              
          }
        catch(SQLException e)
        {        
       out.println(e.getMessage());
        } 
        finally{
        try{
         if(course_con!=null){course_con.close();}
         if(psmt!=null){psmt.close();}
         if(rs!=null){rs.close();}
        }   
        catch(SQLException se){
        out.println(se.getMessage());    
        }
        }
        out.close();
    }
}
