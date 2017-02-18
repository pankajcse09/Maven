/*
 * Share_Project.java
 *
 * Created on February 4, 2008, 6:35 PM
 */

package User_Profile;

import com.myapp.struts.Dataconnectivity;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import java.sql.SQLException;

/**
 *
 * @author Sonal
 * @version
 */
public class Share_Project extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
   String subject="";
   String msg="";

String from="";
String pn="";
String tn="";
int count;

 String filename ="";
  String username ="";
          String filetype=""; 
          Connection uploadcon=null;
          PreparedStatement fileup_prep=null;
          PreparedStatement chk_pstmt=null;
           ResultSet chk_rs=null;
          
          Statement fileup_stmt=null;
          Statement chk_stmt=null;
          long flength;
           String aaa="";
             int maxSize=5*1024*1024;
         
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
    res.setContentType("text/html");
    HttpSession session=req.getSession();
    PrintWriter out = res.getWriter();
     String path1="/sharedproject";
     // ServletContext ctx=getServletContext();
     //aaa=ctx.getRealPath( path1);
//out.println(path1);
     
     
     String type = req.getContentType();
     
    if(type == null || 
        !type.toLowerCase().startsWith("multipart/form-data")) {
      throw new IOException("Posted content type isn't multipart/form-data");
    }
  
			

     
     
     
     
     
     
    // Check the content length to prevent denial of service attacks
    int length = req.getContentLength();
      if(length > maxSize)
                           {
                             String aa="file limit exceeded";
                              req.setAttribute("largefile",aa);
      //RequestDispatcher rd=getServletContext().getNamedDispatcher("Search_Pro");
                       RequestDispatcher rd=req.getRequestDispatcher("/College_Files/shared_proj.jsp");
                        rd.forward(req,res);
    
                               }      
           
   
 //out.println(length);
    try{
    Dataconnectivity upload=new Dataconnectivity();
     uploadcon =(Connection)upload.Dataconnect();
    }
    catch(Exception e){
    out.println(e.getMessage());
    }
     
         username =(String)session.getAttribute("forwardname");
         //out.println(username);
                 
       
         
                try{  
                     String chkvalidusr="select members,project_name,team_name from ex_project_team";
                     chk_pstmt= uploadcon.prepareStatement(chkvalidusr);
 		      chk_rs=chk_pstmt.executeQuery();
                
                        while(chk_rs.next())
                         {
                               count=0;
                               String  validusr=(String)chk_rs.getString("members");
                               String  validproj=(String)chk_rs.getString("project_name");
                               String  validteam=(String)chk_rs.getString("team_name");
                
                                  if(username.equals(validusr))
                                       
                                        {                         
                                                     
     
                                               try {
      
                                                     MultipartRequest multi = new MultipartRequest(req, path1, 5 * 1024 * 1024);

                                                      out.println("<HTML>");
                                                       out.println("<HEAD><TITLE>UploadTest</TITLE></HEAD>");
                                                      out.println("<BODY>");            
                                                       subject=multi.getParameter("sub");
                                                     msg=multi.getParameter("projmesg");
                                                             //from=multi.getParameter("fro");
                                                               pn=multi.getParameter("pn");
                                                              tn=multi.getParameter("tn");
      
     
                                                           Enumeration files = multi.getFileNames();
                                                            while (files.hasMoreElements()) 
                                                            {
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
      
      
     
     
     
     
     
                                                            String file_data="insert into ex_common_project(subject,f_name,sender,f_type,f_length,proj_name,team_name,message)values(?,?,?,?,?,?,?,?)";
                                                            fileup_prep=uploadcon.prepareStatement(file_data);
                                                            fileup_prep.setString(1,subject);
      
                                                              fileup_prep.setString(2,filename);
                                                               fileup_prep.setString(3,username);
         
         
                                                              fileup_prep.setString(4,filetype);
                                                             fileup_prep.setLong(5,flength);
                                                                fileup_prep.setString(6,pn);
                                                              fileup_prep.setString(7,tn);
                                                                 fileup_prep.setString(8,msg);
                                                               fileup_prep.executeUpdate();
           
                                                     }
                                                     catch (Exception e) {
                                                        out.println("<PRE>");
                                                         e.printStackTrace(out);
                                                       out.println("</PRE>");
                                                                          }
                                                    out.println("</BODY></HTML>");
    
                                       count=1;
                                        break; 
    
    
                                           }
                                            
                      }//wilelops ends
                      
                      if(count==0)
                      {
                      
                      
                      String chkmsg="Sorry!You Are Invalid Member of This Project ";
    req.setAttribute("invalidmsg",chkmsg);
   out.println(chkmsg);
      //RequestDispatcher rd1=getServletContext().getNamedDispatcher("Search_Pro");
    RequestDispatcher rd1=req.getRequestDispatcher("/College_Files/shared_proj.jsp");
    rd1.forward(req,res);
          
                      
                      
                      }     
                          
                          
                          
                      
                }//try ends
                catch(SQLException e)
                {
                out.println("DatabaseDown");
                
                }
                    
  }
}
         
         
         
         
         
         
                    
                
                
               
         