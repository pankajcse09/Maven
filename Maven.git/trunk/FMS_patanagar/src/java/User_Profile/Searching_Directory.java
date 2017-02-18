/*
 * Searching_Directory.java
 *
 * Created on January 28, 2008, 11:04 AM
 */


 package User_Profile;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import com.myapp.struts.Dataconnectivity;
public class Searching_Directory extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
   Connection search_con=null;
  PreparedStatement search_pstmt=null; 
   ResultSet rs=null;
  PreparedStatement search_stmt=null;
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException { 
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
        
       
  String sfname=(String)request.getParameter("sfn");
   String slname=(String)request.getParameter("sln");
   //out.println(search_str);
    //out.println(search_dep);
   // out.println("search_str");
  //username =(String)session.getAttribute("forwardname");
  
  try{
     
Dataconnectivity searchcon=new Dataconnectivity();
search_con=(Connection)searchcon.Dataconnect();
  }
  catch(Exception e)
  {
  
  out.println("DatabaseDown");
  
  }



String search_info="select emp_fname,emp_lname,emp_email, emp_homephon,emp_mobile,emp_officphon,emp_college,emp_dep from ex_emp_reg where emp_fname like '"+sfname+"%' "; 
//out.println(search_info);
ArrayList a1=new ArrayList();
ArrayList a2=new ArrayList();
ArrayList a3=new ArrayList();
ArrayList a4=new ArrayList();
ArrayList a5=new ArrayList();
ArrayList a6=new ArrayList();
ArrayList a7=new ArrayList();
ArrayList a8=new ArrayList();

try{
    search_stmt=search_con.prepareStatement(search_info);
    rs=search_stmt.executeQuery();
      
       while(rs.next())
{
 a1.add((String)rs.getString("emp_fname"));
 a2.add((String)rs.getString("emp_lname")); 
 a3.add((String)rs.getString("emp_email")); 
 a4.add((String)rs.getString("emp_homephon"));
 a5.add((String)rs.getString("emp_mobile"));
 a6.add((String)rs.getString("emp_officphon"));
 a7.add((String)rs.getString("emp_college"));
 a8.add((String)rs.getString("emp_dep"));
 
} 
    
    ServletContext ctx=getServletContext();
   ctx.setAttribute("reqname",a1);
   //request.setAttribute("forsearmidname",a1);
  
  // request.setAttribute("reqlastname",a2);
  // request.setAttribute("reqemail",a3);
 //  request.setAttribute("reqhomphon",a4);
  // request.setAttribute("reqmobile",a5); 
  // request.setAttribute("reqoffice",a6);
  // request.setAttribute("reqcollege",a7);
    //  request.setAttribute("reqdep",a8);   
    
    ctx.setAttribute("reqlastname",a2);
 ctx.setAttribute("reqemail",a3);
  ctx.setAttribute("reqhomphon",a4);
 ctx.setAttribute("reqmobile",a5); 
  ctx.setAttribute("reqoffice",a6);
  ctx.setAttribute("reqcollege",a7);
   ctx.setAttribute("reqdep",a8);   
       
       
RequestDispatcher  rd  = ctx.getRequestDispatcher("/College_Files/Display_Detail.jsp"); 
rd.forward(request,response);
                                                          // rd.forward(request,response);
   
         }
         catch(SQLException e)
        {
            e.printStackTrace();
        }


        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Searching_Pro</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Searching_Pro at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
        
  
           out.close();
    }
    
    
   
  
}
