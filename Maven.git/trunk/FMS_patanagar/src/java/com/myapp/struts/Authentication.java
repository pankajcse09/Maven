/*
 * Authentication.java
 *
 * Created on November 6, 2007, 1:30 PM
 */

package com.myapp.struts;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Authentication extends HttpServlet {
    
    int count;
    Connection cc=null;
    Statement stmt=null;
    ResultSet rs=null;
    String sda=null;      
    String cga=null;
    String usna=null;
     String stu_colg=null;
     String sd=null;
     String cg=null;
     String usn=null;
     String dep="";
     String st_dep="";
     String desig="";
     String col=null;
     String stid="";
      String empdep="";
     PreparedStatement pstmt=null;
     String us="";
   String college=null;
   String eid="";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Common comLogin = new Common();        
        HttpSession session=request.getSession();       
        try{
       Dataconnectivity dc1=new Dataconnectivity();
       cc=(Connection)dc1.Dataconnect();  
        }
        catch(Exception e){
        out.println(e.getMessage());    
        }
         
           String usnme=request.getParameter("username");
     String passwd=request.getParameter("password");
            usnme=usnme.trim();
          passwd = passwd.trim();         

         try{
          stmt=cc.createStatement();
         }
         catch(SQLException e)
        {
            e.printStackTrace();
        }       
     
        String qu="select * from loginn";
        
       //out.println("check1");
        try{
       rs=stmt.executeQuery(qu);
         }
         catch(SQLException e)
        {
            e.printStackTrace();
        }
        try{
                   while(rs.next())
         
                        {       count=0;
                                String  duname=(String)rs.getString("username");
                                duname=duname.trim();
                                String  apasswd=(String)rs.getString("password");
                                apasswd=apasswd.trim();
                          String     dpasswd = (String)comLogin.decrypt(apasswd);

                                          dpasswd=dpasswd.trim();
     
            
                                   if(duname.equals(usnme) && dpasswd.equals(passwd))
                                                    
                                            {
                                                synchronized(session)
                                                { session.setAttribute("forwardname",usnme);
                                                us=(String)rs.getString("user_type");
                                                session.setAttribute("logintype",us);
                                                
                                                
                                                  if(us.equals("s"))                                                                                         
                                                {
                                                  sd="ex_studnt_reg";
                                                  cg="scolge";
                                                 usn="susername";
                                                 college= "select stid,"+cg+" from "+sd+" where "+usn+"='"+usnme+"'";
                                                 }                                              
                                                  if(us.equals("e"))
                                                  {
                                                   sd="ex_emp_reg";
                                                  cg="emp_college";
                                                 usn="emp_username";
                                                 dep="emp_dep";
                                                 desig="emp_desig";                                                 
                                                 college="select emp_id,"+cg+","+dep+","+desig+" from "+sd+" where "+usn+"='"+usnme+"'";                                                 
                                                  }     
                                                }                                            
                                            pstmt=cc.prepareStatement(college);
                                            rs=pstmt.executeQuery();                            
                                            
                                            //session.setAttribute("e_desig",(String)rs.getString("emp_desig"));
                                            if(us.equals("e"))
                                            {
                                                   while(rs.next())
                                                     {
                                                         col =(String)rs.getString(cg);
                                                         empdep=(String)rs.getString(dep);
                                                         eid=(String)rs.getString("emp_id");                                                         
                                                     }                                                                     
                                                         session.setAttribute("e_dep",empdep);
                                                         session.setAttribute("user_college",col);
                                                         session.setAttribute("emp_id",eid);
                                            if(col.equalsIgnoreCase("College of Veterinary & Animal Sciences"))
                                              {               
                                              RequestDispatcher  rd  = getServletContext().getRequestDispatcher("/MainPage.jsp"); 
                                              rd.forward(request,response);
                                               }              
                                              }       
                                            
                                            if(us.equals("s"))
                                            {
                                                   while(rs.next())
                                                     {
                                                         stid=(String)rs.getString("stid"); 
                                                         col =(String)rs.getString(cg);                                                         
                                                      }   
                                                         session.setAttribute("studid",stid); 
                                                         session.setAttribute("user_college",col);                                                      
                                             if(col.equalsIgnoreCase("College of Veterinary & Animal Sciences"))
                                             {               
                                               RequestDispatcher  rd  = getServletContext().getRequestDispatcher("/MainPage.jsp"); 
                                               rd.forward(request,response);
                                              }       
                                            }                                                          
                                      
                                             count=1;
                                             break;
                                             }
                                
                                           }                   
                                         if(count==0)
                                             { 
                                                   String userinfo=new String("enter the correct username and password");
                                                   ServletContext context=getServletContext();         
           
                                                  request.setAttribute("userdata",userinfo);
                                                  RequestDispatcher rd  = getServletContext().getRequestDispatcher("/index.jsp"); 
                                                   rd.forward(request,response);
                                               }
                   
        }
     
       catch(SQLException e)
           {
            e.printStackTrace();
           }
     finally {
            
          
                
                    
                  try{  
                    cc.close();
                    rs.close();
                    
                    }catch(SQLException e) 
                    {
                      e.printStackTrace();
                     }
         }
        
           
        out.close();
      
        }
    }

    
   