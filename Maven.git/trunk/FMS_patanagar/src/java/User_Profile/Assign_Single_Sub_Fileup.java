/*
 * Assign_Submit_fileup.java
 *submit of assignment file
 * Created on February 19, 2008, 4:45 PM
 */

package User_Profile;

import com.myapp.struts.Dataconnectivity;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Sonal
 * @version
 */
public class Assign_Single_Sub_Fileup extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    

String fsender="";
String filename=""; 
String filetype="";
         String assign_file=""; 
          Connection sub_final_con=null;
          PreparedStatement sub_final_prep=null;
          Statement sub_final_stmt=null;
          long flength;
           String aaa="";
             int maxSize=5*1024*1024;
            // boolean poolingEnabled =true;
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
         PrintWriter out = res.getWriter();
      String path1="/singassign";
      HttpSession session=req.getSession();
                   fsender=(String)session.getAttribute("forwardname");
     // ServletContext ctx=getServletContext();
     //aaa=ctx.getRealPath( path1);
//out.println(path1);
     
     
     String type = req.getContentType();
     
    if (type == null || 
        !type.toLowerCase().startsWith("multipart/form-data")) {
      throw new IOException("Posted content type isn't multipart/form-data");
    }
  
			

     
     
     
     
     
     
    // Check the content length to prevent denial of service attacks
    int length = req.getContentLength();
   
 //out.println(length);
           
  
   if(length > maxSize)
           {
        String aa="file limit exceeded";
    req.setAttribute("largefile",aa);
      //RequestDispatcher rd=getServletContext().getNamedDispatcher("Search_Pro");
    RequestDispatcher rd=req.getRequestDispatcher("/College_Files/Single_Assign_Validate.jsp");
    rd.forward(req,res);
    
  }         
     
  try {
      
      MultipartRequest multi =
        new MultipartRequest(req, path1, 5 * 1024 * 1024);

      out.println("<HTML>");
      out.println("<HEAD><TITLE>UploadTest</TITLE></HEAD>");
      out.println("<BODY>");
      //out.println("<H1>UploadTest</H1>");

    
      //out.println("<H3>Params:</H3>");
     // out.println("<PRE>");
     
          assign_file=multi.getParameter("f_name");
      
      
     
      Enumeration files = multi.getFileNames();
      while (files.hasMoreElements()) {
        String name = (String)files.nextElement();
       
        filename = multi.getFilesystemName(name);
        filetype = multi.getContentType(name);
        File f = multi.getFile(name);
      
        if (f != null)
        
        
        {
            
            
        flength=f.length();
        
            
          
        }
        
        out.println("</PRE>");
      }
      
      
    Dataconnectivity upload=new Dataconnectivity();
     //OrdersServlet upload=new OrdersServlet();
  sub_final_con =(Connection)upload.Dataconnect();
     //uploadcon =(Connection)upload.getConnection(poolingEnabled);
        String qu1=" update ex_assignment set submit_file=?,status=? where assign_filename='"+assign_file+"'";
      //String file_data="insert into user_send_file_info(subject,filename,sender,reciver,message,f_type,f_length)values(?,?,?,?,?,?,?)";
      sub_final_prep=sub_final_con.prepareStatement(qu1);
     sub_final_prep.setString(1,filename);
     
        sub_final_prep.setString(2,"1");
       sub_final_prep.executeUpdate();
           
    }
    catch (Exception e) {
      out.println("<PRE>");
      e.printStackTrace(out);
      out.println("</PRE>");
    }
    out.println("</BODY></HTML>");
   
  }
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
      
    