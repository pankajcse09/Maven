<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>

<%
   
    Connection cn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    

        try
        {   DataConnection c=new DataConnection();
            cn=c.Dataconnect(); 
              String del="delete from feestructure ";
               pstmt=cn.prepareStatement(del);                      
               pstmt.executeUpdate();
              
        }catch(SQLException p)
        {p.printStackTrace();}
         
    String msg=new String("Fee Structure is deleted");

             request.setAttribute("msg",msg);
         RequestDispatcher rd2  =request.getRequestDispatcher("/enterfeestruct.jsp"); 
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