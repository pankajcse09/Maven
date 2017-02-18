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
import java.sql.SQLException;

/**
 *
 * @author Sonal
 * @version
 */
public class Check_Valid_Member extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
   String subject="";

String from="";
String pn="";
String tn="";
int count;
String msg="";
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
        
   
 //out.println(length);
    try{
    Dataconnectivity upload=new Dataconnectivity();
     uploadcon =(Connection)upload.Dataconnect();
    }
    catch(Exception e){
    out.println(e.getMessage());    
    }
     String pn=(String)req.getParameter("pn");
     String tn=(String)req.getParameter("tn");
     
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
                
                                  if(username.equals(validusr)&&pn.equals(validproj)&&tn.equals(validteam))
                                       
                                        {                         
                                                     
     
                                               try {
      
                                                     req.setAttribute("proj_name",validproj);
                                                     req.setAttribute("proj_team",validteam);
                                                     
                                                         RequestDispatcher rd1=req.getRequestDispatcher("/College_Files/Proj_shaerd_Team.jsp");
                                                          rd1.forward(req,res);   
     
     
     
     
     
                                                           
           
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
         
         
         
         
         
         
                    
                
                
               
         