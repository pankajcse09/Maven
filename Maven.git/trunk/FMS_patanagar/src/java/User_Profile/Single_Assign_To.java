/*
 * User_File_Information.java
 *
 * Created on January 15, 2008, 1:25 PM
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
 * @author Arjun
 * @version
 */
public class Single_Assign_To extends HttpServlet {
    
    
    

String subject="";
String to="";
String from="";

String msg="";
 String filename ="";
          String filetype=""; 
          Connection uploadcon=null;
          PreparedStatement fileup_prep=null;
          Statement fileup_stmt=null;
          long flength;
           String aaa="";
             int maxSize=5*1024*1024;
             String due_date="";
            
         
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
     String path1="/singassign";
     // ServletContext ctx=getServletContext();
     //aaa=ctx.getRealPath( path1);
//out.println(path1);
     
     HttpSession session =req.getSession();
    from=(String)session.getAttribute("forwardname");
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
        String aa="File limit should not be exceeded more then 5 MB";
    req.setAttribute("largefile",aa);
      //RequestDispatcher rd=getServletContext().getNamedDispatcher("Search_Pro");
    RequestDispatcher rd=req.getRequestDispatcher("/College_Files/Single_assign_user.jsp");
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
     
       
      subject=multi.getParameter("sing_sub");
      to=multi.getParameter("single_list");
     msg=multi.getParameter("sing_message");
     due_date=multi.getParameter("duedate");
     
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
  uploadcon =(Connection)upload.Dataconnect();
     //uploadcon =(Connection)upload.getConnection(poolingEnabled);
      String file_data="insert into ex_assignment(assign_sub,assign_filename,prof_name,studnt_name,message,f_type,due_date,status)values(?,?,?,?,?,?,?,?)";
      fileup_prep=uploadcon.prepareStatement(file_data);
      fileup_prep.setString(1,subject);
      
       fileup_prep.setString(2,filename);
        fileup_prep.setString(3,from);
         fileup_prep.setString(4,to);
          fileup_prep.setString(5,msg);
           fileup_prep.setString(6,filetype);
           fileup_prep.setString(7,due_date);
            fileup_prep.setString(8,"0");
           fileup_prep.executeUpdate();
            String asign="Your Assignment Uploaded Successfully ";
            req.setAttribute("Assignsuccess",asign);
            RequestDispatcher rf=req.getRequestDispatcher("/College_Files/Single_assign_user.jsp");
            rf.forward(req,res);
    }
 
  
    catch (Exception e) {
      out.println("<PRE>");
      e.printStackTrace(out);
      out.println("</PRE>");
    }
    out.println("</BODY></HTML>");
   
  }
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet User_File_Information</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet User_File_Information at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
      
    