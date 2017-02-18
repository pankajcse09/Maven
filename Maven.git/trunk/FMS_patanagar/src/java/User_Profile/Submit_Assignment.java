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
 *check user before submit of assignment
 * @author Sonal
 * @version
 */
public class Submit_Assignment extends HttpServlet {
    
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
 
  String memname ="";
         
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
    }catch(Exception e){
    out.println(e.getMessage());    
    }
     String assign_name=(String)req.getParameter("assigname");
     String assign_group=(String)req.getParameter("groupname");
      String assign_date=(String)req.getParameter("sub_date");
     out.println((String)req.getParameter("assigname"));
     out.println((String)req.getParameter("groupname"));
      out.println((String)req.getParameter("sub_date"));
     
         memname =(String)session.getAttribute("forwardname");
         out.println(memname);                 
       
         
               try{  
                   // String view_assign_qry="select members,group_name,assign_name from assignment_group";
     String view_assign_qry="select members,assign_sub,assign_mesg,assign_filename,assign_group,assign_end_date,assignment_file.assign_name from ex_assignment_file  join ex_assignment_group  on ex_assignment_file.assign_group=ex_assignment_group.group_name where ex_assignment_group.members='"+memname+"' and status=0";
                    
                     vg_prep= vg_con.prepareStatement(view_assign_qry);
 		      vg_rs=vg_prep.executeQuery();
                
                        while(vg_rs.next())
                         {
                               count=0;
                               String assigname =(String)vg_rs.getString("assign_name");
                               String  gname=(String)vg_rs.getString("assign_group");
                               String  mem=(String)vg_rs.getString("members");
                               out.println(mem);
                               out.println(assigname);
                               out.println(gname);
                               String end_date=(String)vg_rs.getString("assign_end_date");
                               
                               
                               
                                
                                  if((assign_name.equals(assigname))&&(assign_group.equals(gname))&&(memname.equals(mem)))
                                       // if((assign_name.equals(assigname)))
                                        {                         
                                                     
     
                                              
                                                   out.println(mem);
                                                          req.setAttribute("assig_end_date",end_date); 
                                                         req.setAttribute("name_assig",assign_name);
                                                          req.setAttribute("name_group",assign_group);
                                                           req.setAttribute("date_assig",assign_date);
                                                        RequestDispatcher rd1=req.getRequestDispatcher("/College_Files/Assignment_Submit_fileup.jsp");
                                                          rd1.forward(req,res);   
     
     
     
     
     
                                                           
           
                                                   
    
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
   // RequestDispatcher rd1=req.getRequestDispatcher("/College_Files/Submit_Assig.jsp");
    //rd1.forward(req,res);
          
                      
                      
                      }     
                          
                          
                          
                      
                }//try ends
                catch(SQLException e)
                {
                out.println("DatabaseDown");
                
                }
                    
  }
}
         
         
         
         
         
         
                    
                
                
               
         