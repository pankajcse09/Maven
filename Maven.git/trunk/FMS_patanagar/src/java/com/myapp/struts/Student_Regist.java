/*
 * Student_Regist.java
 *
 * Created on November 6, 2007, 3:03 PM
 */
package com.myapp.struts;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author IntelMind
 * @version
 */
public class Student_Regist extends HttpServlet {
 
    Connection cc;
    Statement stmt;
    int count;
    ResultSet rs;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
         ServletContext context=getServletContext();
        
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Student_Regist</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Student_Regist at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
     SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
     java.util.Date dd=new java.util.Date();
     String ud=df.format(dd);
       /* ServletContext context=getServletContext();*/
        /*String username=(String)context.getAttribute("uname");
        String password=(String)context.getAttribute("passwd");*/
        //String name=(String)request.getAttribute("uname");
        //String passwd=(String)request.getAttribute("passwd");
       //name=name.trim();
      // passwd=passwd.trim();
       
        
            // String sid=request.getParameter("stuid");
        String suername=request.getParameter("logname");
        suername=suername.trim();
        String sname="";
        String apasswd=request.getParameter("password");
         apasswd=apasswd.trim();
          Common comLogin = new Common();
          String spasswd = (String)comLogin.encrypt(apasswd);
          spasswd=spasswd.trim();
                String sid=request.getParameter("stuid");
         //String spasswd=request.getParameter("password");
        
        String sfname=request.getParameter("firstname");
        String slastname=request.getParameter("lastname");        
        String smidname=request.getParameter("middlename");
        
        /**
         if(smidname!=null && !smidname.equals("")){
        sname=sfname+" "+smidname+" "+slastname;   
        }
        else{
        sname=sfname+" "+slastname;    
        }    
         */   
        String sdob=request.getParameter("dob");
       // Date date=new Date(dateFormat.parse(sdob).getTime());        
      String sgender=request.getParameter("gender");
      String ftname=request.getParameter("fthname");
      String mtname=request.getParameter("mthname");
      String shomadd1=request.getParameter("homeadd1");
       
        String sstate=request.getParameter("state");
        String shomadd2=request.getParameter("homeadd2");
        String scountry=request.getParameter("country");
        String scity=request.getParameter("city");
        String semail=request.getParameter("email");
        String scollege=request.getParameter("college");
        String sdegree=request.getParameter("degree");
      
        String sofficephone=request.getParameter("officephone");
        String shomephone=request.getParameter("homephone");
        String smobile=request.getParameter("mobile");        
        
        String scurrentadd=request.getParameter("curlivat");        
        
        String syear=request.getParameter("entryyear");           
        String sadvisor=request.getParameter("advisor");
        String lia=request.getParameter("lastinst");     
        String emername=request.getParameter("name");
        String emerno=request.getParameter("contactno");
        String emeradd=request.getParameter("address");
        String sq=request.getParameter("secretquestion");
        String sa=request.getParameter("answer");
        String pylia=request.getParameter("lastattend");        
        String wnm=request.getParameter("wname");
        String hostel=request.getParameter("hostel");
        String rno=request.getParameter("roomno");
        String wcno=request.getParameter("wcontno");          
           
        try{
            Dataconnectivity dc1=new Dataconnectivity();
            cc=(Connection)dc1.Dataconnect();
        }
        catch(Exception e){
        out.println(e.getMessage());
        }    
       
     try{
        stmt=cc.createStatement();
       String qu1="select username from loginn"; //where username='"+ eusername+"'";
        //String qu1="select susername from studnt_reg";
       rs=stmt.executeQuery(qu1);
       
       while(rs.next())
       {      count=0;
              String  duname=(String)rs.getString("username");
              duname=duname.trim();
         if(suername.equals(duname))
        {
                   String existuser=new String("this username already exist");
          
         
           // String  path=   context.getRealPath("/image"); 
           // context.setAttribute("way",path);
         
        // String path= context.getResourcePaths("");
          // out.println(path);
        request.setAttribute("exist",existuser);
             RequestDispatcher  rd  = getServletContext().getRequestDispatcher("/StudRegForm.jsp"); 
               rd.forward(request,response); 
                   count=1;
                    break;
         }
            
        }
         if(count==0)
         {     
      
        String stmt ="insert into ex_studnt_reg(SUSERNAME,SPASSWD,STID,SFNAME,SLNAME,SMNAME,SDOBIRTH,STDGENDER,SHOMEADD1,STUSTATE,STDHOMEAD2,STDCOUN,SCTY,SEMAL,SCOLGE,SOFCEPHON,SDNTDEG,SDNTHOMPHON,SDNTMOBLE,SENTYEAR,SCURNTADD,lapyear,SADVISIOR,EMNAME,EMNO,EMADD,fname,mname,last_attend,hostel,roomno,warden,wardenno)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
         PreparedStatement insertstmt=cc.prepareStatement(stmt);       
        insertstmt.setString(1,suername);
        insertstmt.setString(2,spasswd);
        insertstmt.setString(3,sid);
        insertstmt.setString(4,sfname);       
        insertstmt.setString(5,slastname);
        insertstmt.setString(6,smidname);
      
        insertstmt.setString(7,sdob);
       
        insertstmt.setString(8,sgender);
       insertstmt.setString(9,shomadd1);
       insertstmt.setString(10,sstate);
       insertstmt.setString(11,shomadd2);
        insertstmt.setString(12,scountry);
        
        insertstmt.setString(13,scity);
        insertstmt.setString(14,semail);
        
        insertstmt.setString(15,scollege);
        insertstmt.setString(16,sofficephone);
        insertstmt.setString(17,sdegree);        
        insertstmt.setString(18,shomephone);
        insertstmt.setString(19,smobile); 
        insertstmt.setString(20,syear);
         insertstmt.setString(21,scurrentadd);
         insertstmt.setString(22,pylia);
         insertstmt.setString(23,sadvisor);
          insertstmt.setString(24,emername);
           insertstmt.setString(25,emerno);
            insertstmt.setString(26,emeradd);
            insertstmt.setString(27,ftname);
            insertstmt.setString(28,mtname);
            insertstmt.setString(29,lia);
            insertstmt.setString(30,hostel);
            insertstmt.setString(31,rno);
            insertstmt.setString(32,wnm);
            insertstmt.setString(33,wcno);
            insertstmt.executeUpdate();
            
           String stmt1 ="insert into loginn(username,password,user_type,secret_question,answer)values(?,?,?,?,?)";
                   PreparedStatement irtstmt=cc.prepareStatement(stmt1) ;
                   //out.println("check1");                           
                 irtstmt.setString(1,suername);
                 irtstmt.setString(2,spasswd);
                 irtstmt.setString(3,"s"); 
                 irtstmt.setString(4,sq); 
                 irtstmt.setString(5,sa);
                 irtstmt.executeUpdate();  
                 
                 int in1=syear.lastIndexOf("/");
                 int in2=syear.length();
                 String sey=syear.substring(in1+1,in2);
                 int nx=Integer.parseInt(sey)+1;
                 String ssn=sey+"-"+nx;
                 String psm="insert into studinfo(studid,eyear,currentyr,sem,sessions,degree,status,dated)values(?,?,?,?,?,?,?,?)";
                 PreparedStatement psmt=cc.prepareStatement(psm);
                 psmt.setString(1,sid);
                 psmt.setString(2,syear);   
                 psmt.setString(3,"1");
                 psmt.setString(4,"1");
                 psmt.setString(5,ssn);
                 psmt.setString(6,sdegree);
                 psmt.setString(7,"N");
                 psmt.setString(8,ud);
                 psmt.executeUpdate();
                                       
                out.println("Now you  are Registered user! Please login again");
                out.println("<form method=\"post\" action=\"Cs\">");
        out.println("<input type=\"submit\" name=\"login\" "+ "value=\"Login\">");
        out.println("</form>");
         }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }       
         finally {                   
                  try{  
             if(cc!=null){cc.close();}
            }catch(SQLException e) {
                e.printStackTrace();
            }
         } 
   
        out.close();  

    }
   
}
 
  
