<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%
   
    Connection cn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
 String feeid=request.getParameter("feeid");  out.println(feeid);
  String pageforward=request.getParameter("page");  out.println(page);
        try
        {   DataConnection c=new DataConnection();
            cn=c.Dataconnect(); 
              String del="delete from tempfee where feeid='"+feeid+"' ";
               pstmt=cn.prepareStatement(del);                      
               pstmt.executeUpdate();
              
   
        }catch(SQLException p)
        {p.printStackTrace();}
         
         RequestDispatcher  rd2  =request.getRequestDispatcher(""+pageforward+""); 
         rd2.forward(request,response); 
        
        try
           {
             if(pstmt!=null)
             {pstmt.close();}
              if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
 
   %>
    
    </body>
</html>
