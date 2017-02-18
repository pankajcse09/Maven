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
import java.sql.SQLException;

/**
 *
 * @author Sonal
 * @version
 */
public class valid_group_usr extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
   String subject="";

String from="";
String assign_name="";
String assign_group="";
int count;
String assign_date="";
 
  String validusername ="";
         
          Connection vg_con=null;//vg=valid_group_member
          PreparedStatement vg_prep=null;
         
           ResultSet vg_rs=null;
          
        
          
         
         
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
    res.setContentType("text/html");
    HttpSession session=req.getSession();
    PrintWriter out = res.getWriter();     

    try{
    Dataconnectivity validmem=new Dataconnectivity();
     vg_con =(Connection)validmem.Dataconnect();
    }
    catch(Exception e){out.println(e.getMessage());}
     String assign_name=(String)req.getParameter("assigname");
     String assign_group=(String)req.getParameter("groupassig");
      String assign_date=(String)req.getParameter("subendate");
     
         validusername =(String)session.getAttribute("forwardname");
        // out.println(validusername);
                 
       
         
                try{  
                     String chkvalidusr="select members,group_name,assign_name from ex_assignment_group";
                     vg_prep= vg_con.prepareStatement(chkvalidusr);
 		      vg_rs=vg_prep.executeQuery();
                
                        while(vg_rs.next())
                         {
                               count=0;
                               String assigname =(String)vg_rs.getString("assign_name");
                               String  gname=(String)vg_rs.getString("group_name");
                               String  mem=(String)vg_rs.getString("members");
                
                                  if(assign_name.equals(assigname)&&assign_group.equals(gname)&&validusername.equals(mem))
                                       
                                        {                         
                                                     
     
                                               try {
      
                                                         req.setAttribute("name_assig",assign_name);
                                                          req.setAttribute("name_group",assign_group);
                                                           req.setAttribute("date_assig",assign_date);
                                                         RequestDispatcher rd1=req.getRequestDispatcher("/College_Files/Assigto_Group_File.jsp");
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
                      
                      
                      String chkmem="Sorry!You Are Invalid Member of This Project ";
    req.setAttribute("invalidmem",chkmem);
   out.println(chkmem);
      //RequestDispatcher rd1=getServletContext().getNamedDispatcher("Search_Pro");
    RequestDispatcher rd1=req.getRequestDispatcher("/College_Files/Assig_to.jsp");
    rd1.forward(req,res);
                      
                      }   
                      
                }//try ends
                catch(SQLException e)
                {
                out.println("DatabaseDown");
                
                }
                    
  }
}
         
         
         
         
         
         
                    
                
                
               
         