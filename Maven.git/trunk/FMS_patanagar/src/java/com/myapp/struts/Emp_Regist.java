/*
 * Emp_Regist.java
 *
 * Created on November 6, 2007, 2:42 PM
 */

package com.myapp.struts;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.sql.*;
/**
 *
 * @author IntelMind
 * @version
 */
public class Emp_Regist extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
     Connection cn;
    Statement stmt=null;
    ResultSet rs=null;
    int count=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
          HttpSession session=request.getSession();
           Common comLogin = new Common();
       SimpleDateFormat df=new SimpleDateFormat("dd/mm/yyyy");
        
       /* ServletContext context=getServletContext();*/
        
       //name=name.trim();
      // passwd=passwd.trim();
           
        String eid=request.getParameter("empid");
        String eusername=request.getParameter("loginid");
        eusername=eusername.trim();
        String emppasswd=request.getParameter("password");
        emppasswd.trim();
        String epasswd = (String)comLogin.encrypt(emppasswd);
        epasswd=epasswd.trim();
        
        String efname=request.getParameter("firstname");
        String elastname=request.getParameter("lastname");
        String emidname=request.getParameter("middlename");
       String edob=request.getParameter("dob");
       
       
      String egender=request.getParameter("gender");
          String ehomadd1=request.getParameter("homeadd1");
       
        String estate=request.getParameter("state");
        String ehomadd2=request.getParameter("homeadd2");
         String ecountry=request.getParameter("country");
       String ecity=request.getParameter("city");
        String eemail=request.getParameter("email");
        String ecollege=request.getParameter("college");
      
      
        String eofficephone=request.getParameter("officephone");
        String ehomephone=request.getParameter("homephone");
      
        
        String edep=request.getParameter("department");
      
        String emobile=request.getParameter("mobile");
          String edesignation =request.getParameter("designation");
       String eimmedsupervisor=request.getParameter("immedsupervisor");
        String sq=request.getParameter("secretquestion");
        String sa=request.getParameter("answer");
        
        String ehod=request.getParameter("hod");
        
        try{
            Dataconnectivity dc2=new Dataconnectivity();
       cn=(Connection)dc2.Dataconnect();
        }
        catch(Exception e){
        out.println(e.getMessage());    
        }
        try{
        stmt=cn.createStatement();
       String qu1="select username from loginn"; //where username='"+ eusername+"'";
       rs=stmt.executeQuery(qu1);
       
       while(rs.next())
       {      count=0;
              String  duname=(String)rs.getString("username");
        
         if(eusername.equals(duname))
        {
                   String existuser=new String("this username already exist");
                   
                     request.setAttribute("exist",existuser);
             RequestDispatcher  rd  = getServletContext().getRequestDispatcher("/Emp_Registration.jsp"); 
               rd.forward(request,response);                     
       
                    count=1;
                    break;
         }
            
        }
         if(count==0)
         {         
                    
         String stmta ="insert into ex_emp_reg(Emp_id,Emp_username,Emp_pswd,Emp_fname,Emp_mname,Emp_lname,Emp_dob,Emp_gender,Emp_homeadd1,Emp_state,Emp_homeadd2,Emp_country,Emp_city,Emp_email,Emp_college,Emp_officphon,Emp_Dep,Emp_homephon,Emp_mobile,Emp_Desig,Emp_supervisior,Emp_hod)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement insertstmt  =cn.prepareStatement(stmta);
       
        insertstmt.setString(1,eid);
        insertstmt.setString(2,eusername);
        insertstmt.setString(3,epasswd);
        insertstmt.setString(4,efname);
         
        insertstmt.setString(5,emidname);
        insertstmt.setString(6,elastname);
       insertstmt.setString(7,edob);
      
       
           
        
     
       
        insertstmt.setString(8,egender);
         insertstmt.setString(9,ehomadd1);
          insertstmt.setString(10,estate);
       insertstmt.setString(11,ehomadd2);
        insertstmt.setString(12,ecountry);
        
        insertstmt.setString(13,ecity);
        insertstmt.setString(14,eemail);
      
       
        insertstmt.setString(15,ecollege);
        insertstmt.setString(16,eofficephone);
        insertstmt.setString(17,edep);
        
        insertstmt.setString(18,ehomephone);
        insertstmt.setString(19,emobile);
             insertstmt.setString(20,edesignation);
        
         
       
         
         insertstmt.setString(21,eimmedsupervisor);
         insertstmt.setString(22,ehod);
        
        
     
                insertstmt.executeUpdate();
                String stmt1 ="insert into loginn(username,password,user_type,secret_question,answer)values(?,?,?,?,?)";
                   PreparedStatement irtstmt=cn.prepareStatement(stmt1) ;
                  
                           
                   irtstmt.setString(1,eusername);
                 irtstmt.setString(2,epasswd);
                  irtstmt.setString(3,"e");
                   irtstmt.setString(4,sq);
                    irtstmt.setString(5,sa);
                  
                irtstmt.executeUpdate();
                out.println("Now you  are Registered user! Please login again");
                out.println("<form method=\"post\" action=\"Cs\">");
        out.println("<input type=\"submit\" name=\"login\" "
            + "value=\"Login\">");
        out.println("</form>");
              
        
         }           
                // out.println("check2");
       
          
        }
       
        catch(SQLException se)
        {
         out.println(se.getMessage());
        }       
         finally {           
          
                if(cn!=null)
                    
                  try{  
                    cn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
         }   
       
        out.close();
    }
    
}

     