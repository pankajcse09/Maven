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
              String del="delete from loginrecord ";
               pstmt=cn.prepareStatement(del);                      
               pstmt.executeUpdate();
              
        }catch(SQLException p)
        {p.printStackTrace();}
         
      String sub=new String("Record is deleted!");

              request.setAttribute("sub",sub);
         RequestDispatcher rd2  =request.getRequestDispatcher("/loginrecord.jsp"); 
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
