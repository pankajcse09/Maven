/*
 * User_File_Information.java
 *
 * Created on January 15, 2008, 1:25 PM
 */

package User_Profile;
import com.myapp.struts.Dataconnectivity;
//import  User_Profile.OrdersServlet;
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
public class User_File_Information extends HttpServlet {
    
    
    
String msg=null;
String subject="";
String to="";
String from="";

String msg1="";
 String filename ="";
          String filetype=""; 
          Connection uploadcon=null;
          PreparedStatement fileup_prep=null;
          Statement fileup_stmt=null;
          long flength;
           String aaa="";
             int maxSize=5*1024*1024;
             boolean poolingEnabled =true;
             String success="";
         
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
     String path1="/aa";
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
        //String aa="file limit exceeded";
        msg1="file exeed lenghth";
    req.setAttribute("largefile",msg1);
      //RequestDispatcher rd=getServletContext().getNamedDispatcher("Search_Pro");
    RequestDispatcher rda=req.getRequestDispatcher("/College_Files/College_File.jsp");
    rda.forward(req,res);
    
  }      
           
           
       
 		
           
        
        
     
     
     
  try {
      
      MultipartRequest multi =
        new MultipartRequest(req, path1, 5 * 1024 * 1024);

  
       
      subject=multi.getParameter("sub");
      to=multi.getParameter("to");
      from=multi.getParameter("fro");
      msg=multi.getParameter("message");
     
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
       
      }
  } catch(Exception e)
      {
      out.println("Multipart problem");
      
      
      }
      
    try
    {
    Dataconnectivity upload=new Dataconnectivity();   
    uploadcon =(Connection)upload.Dataconnect();
    }
    catch(Exception e){
    out.println(e.getMessage());
    }
    try{
     //uploadcon =(Connection)upload.getConnection(poolingEnabled);
      String file_data="insert into ex_user_send_file_info(subject,filename,sender,reciver,message,f_type)values(?,?,?,?,?,?)";
      fileup_prep=uploadcon.prepareStatement(file_data);
      fileup_prep.setString(1,subject);
      
       fileup_prep.setString(2,filename);
        fileup_prep.setString(3,from);
         fileup_prep.setString(4,to);
          fileup_prep.setString(5,msg);
           fileup_prep.setString(6,filetype);
          // fileup_prep.setLong(7,flength);
           fileup_prep.executeUpdate();
           
           
    
           
    }
  
    catch(SQLException e)
    {
        out.println("inset error");
     
    }   
   
    success="Your Message Has Been Sending Successfully";
   
          req.setAttribute("success_msg",success);
   RequestDispatcher rd=req.getRequestDispatcher("/College_Files/College_File.jsp");
 
  rd.forward(req,res); 
    
   
  }
}
         
    