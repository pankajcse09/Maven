/*
 * Assign_File_Up.java
 *
 * Created on February 15, 2008, 9:29 AM
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
public class Assign_File_Up extends HttpServlet {
    
    String subject="";


String msg="";
 String filename ="";
 String assign_name="";
String group_name="";
String assign_date="";
          String filetype=""; 
          Connection assigup_con=null;
          PreparedStatement assigup_prep=null;
          Statement assigup_stmt=null;
          long flength;
           String aaa="";
             int maxSize=5*1024*1024;
             String prof_assign_name="";
            // boolean poolingEnabled =true;
         
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
     String path1="/Assign";
     HttpSession  session =req.getSession();
     prof_assign_name=(String)session.getAttribute("forwardname");
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
    RequestDispatcher rd=req.getRequestDispatcher("/Assigto_Group_File/Assigto_Group_File.jsp");
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
     
       
      subject=multi.getParameter("assig_sub");
      msg=multi.getParameter("assmesg");
        assign_name=multi.getParameter("assigname");
      group_name=multi.getParameter("groupname");
      assign_date=multi.getParameter("assigndate"); 
      
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
     
  assigup_con =(Connection)upload.Dataconnect();
     
      String file_data="insert into ex_assignment_file(assign_sub,assign_mesg,assign_name,assign_group,assign_end_date,assign_file_length,assign_filename,status,assign_prof_name)values(?,?,?,?,?,?,?,?,?)";
      assigup_prep=assigup_con.prepareStatement(file_data);
      assigup_prep.setString(1,subject);
      
       assigup_prep.setString(2,msg);
      
         assigup_prep.setString(3,assign_name);
          assigup_prep.setString(4,group_name);
           assigup_prep.setString(5,assign_date);
           assigup_prep.setLong(6,flength);
            assigup_prep.setString(7,filename);
             assigup_prep.setString(8,"0");
            assigup_prep.setString(9,prof_assign_name);
           assigup_prep.executeUpdate();
           
           String assign_group="your Assignment Uploaded Successfully";
           req.setAttribute("groupassign",assign_group);
           RequestDispatcher rg=req.getRequestDispatcher("/College_Files/Assigto_Group_File.jsp");
           rg.forward(req,res);
           
           
           
    }
    catch (Exception e) {
      out.println("<PRE>");
      e.printStackTrace(out);
      out.println("</PRE>");
    }
    out.println("</BODY></HTML>");
   
  }
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
      
    