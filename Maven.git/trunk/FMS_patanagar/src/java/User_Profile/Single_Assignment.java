/*
 * Single_Assignment.java
 *
 * Created on February 27, 2008, 11:44 AM
 */

package User_Profile;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.myapp.struts.Dataconnectivity;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
/**
 *
 * @author Sonal
 * @version
 */
public class Single_Assignment extends HttpServlet {
     Connection singleass_con=null;
    ResultSet singleass_rs=null;
    String type="";
    String   tcollege ="";
    String   tdep ="";
       String tname="";
       PreparedStatement singleass_tpsmt=null;
       
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
         HttpSession session=request.getSession();
        type=(String)request.getParameter("projecteam");
       tcollege =(String)request.getParameter("usercollege");
       tdep =(String)request.getParameter("userdept");
       tname =(String)request.getParameter("searchname");
       //out.println(type);
       // out.println(tcollege); out.println(tdep); out.println(tname);
        
        
       
        
       try{
         Dataconnectivity tcon=new Dataconnectivity();
        singleass_con=(Connection)tcon.Dataconnect();
    }
       catch(Exception e)
       {
       out.println("DatabaseDown1");
       }
        
        ArrayList a1=new ArrayList();
        ArrayList a2=new ArrayList();
         ArrayList a3=new ArrayList();
          ArrayList a4=new ArrayList();
           
        
                                
                                     if(type.equals("s"))                                                                                         
                                     {
                                        // String studnt_name= "select "+cg+" from "+sd+" where "+usn+"='"+usnme+"'";
         String search_team_name="select susername,sfname,slname,smname  from ex_studnt_reg where sdntdep='"+tdep+"'and scolge='"+tcollege+"' and susername like '"+tname+"%'";     
                                        try
                                        {singleass_tpsmt=singleass_con.prepareStatement(search_team_name);
                                            singleass_rs=singleass_tpsmt.executeQuery();
                                        
                                 
                                 
                                            while(singleass_rs.next())
                                          {
                                                
                                                
                                                a1.add((String)singleass_rs.getString("susername"));
                                                a2.add((String)singleass_rs.getString("sfname")); 
                                                if((String)singleass_rs.getString("smname")==null)
                                                {
                                                a3.add("");
                                                }else if((String)singleass_rs.getString("smname")!=null) 
                                                {
                                                  a3.add((String)singleass_rs.getString("smname"));   
                                                }
                                            
                                            
                                            
                                             a4.add((String)singleass_rs.getString("slname")); 
                                             
                                             
                                              //out.println((String)teamrs.getString("susername"));
                                         } 
                                            } catch(SQLException e)
                                 
                                        {
                                 
                                  out.println("DatabaseDown");
                                        }
                                            
                                             //ServletContext ctx=getServletContext();
                                          
                                           // out.println("hello");
                                           request.setAttribute("team_mem_userid",a1);
                                             request.setAttribute("team_mem_name",a2);
                                                  request.setAttribute("team_mem_midname",a3);
                                                  request.setAttribute("team_mem_lastname",a4);
                                                 request.setAttribute("memtype","s");
                                                  
                                       RequestDispatcher  rd  = request.getRequestDispatcher("/College_Files/Single_assign_user.jsp"); 
                                         rd.forward(request,response); 
                                            
                                            
                                      }                                                                         
                                    
                                
          
          
          
          
          if(type.equals("e"))                                                                                         
                                     {
                                        // String studnt_name= "select "+cg+" from "+sd+" where "+usn+"='"+usnme+"'";
         String search_team_name="select emp_username,emp_fname,emp_mname,emp_lname  from ex_emp_reg where emp_dep='"+tdep+"' and emp_college='"+tcollege+"' and emp_username like '"+tname+"%'";     
                                        try
                                        {
                                            singleass_tpsmt=singleass_con.prepareStatement(search_team_name);
                                            singleass_rs=singleass_tpsmt.executeQuery();
                                        
                                 
                                 
                                            while(singleass_rs.next())
                                          {
                                               // out.println("arjun");
                                                
                                            a1.add((String)singleass_rs.getString("emp_username"));
                                            a2.add((String)singleass_rs.getString("emp_fname")); 
                                            
                                            a3.add((String)singleass_rs.getString("emp_mname")); 
                                             a4.add((String)singleass_rs.getString("emp_lname"));
                                             
                                             
                                             // out.println((String)teamrs.getString("emp_username"));
                                         } 
                                            } catch(SQLException e)
                                 
                                        {
                                 
                                  out.println("DatabaseDown");
                                        }
                                            
                                             //ServletContext ctx=getServletContext();
                                          
                                           // out.println("hello");
                                             request.setAttribute("team_mem_userid",a1);
                                             request.setAttribute("team_mem_name",a2);
                                                  request.setAttribute("team_mem_midname",a3);
                                                  request.setAttribute("team_mem_lastname",a4);
                                                  request.setAttribute("memtype","e");
                                      RequestDispatcher  rd  = request.getRequestDispatcher("/College_Files/Single_assign_user.jsp"); 
                                         rd.forward(request,response); 
                                            
                                            
                                      }    
        
        out.close();
    }
}
    


   