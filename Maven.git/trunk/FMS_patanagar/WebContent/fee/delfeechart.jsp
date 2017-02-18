<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>

<%   
    Connection con=null;
    PreparedStatement pstmt=null;
    PreparedStatement psmt1=null;
    ResultSet rs=null;
    ResultSet rs1=null;
String mon="";    
if(request.getParameter("month")!=null && !request.getParameter("month").equals("")){    
mon=request.getParameter("month");  

        try
        {   DataConnection c=new DataConnection();
            con=c.Dataconnect(); 
        }
        catch(Exception e){} 
         try
        {
              String del="delete from feechartdyna where month='"+mon+"'";
               pstmt=con.prepareStatement(del);                      
               pstmt.executeUpdate();
               
               String de="delete from feestructdyna where month='"+mon+"'";
               psmt1=con.prepareStatement(de);                      
               psmt1.executeUpdate();    
              
        }
        catch(SQLException p){p.printStackTrace();}          
       finally{
        try
           {
             if(pstmt!=null){pstmt.close();}
             if(con!=null){con.close();}
           }catch(SQLException e){} 
         }
        
        request.setAttribute("msg",mon+" Fee Chart is Deleted");      
   %>    
    </body>
</html>
<%}else{
request.setAttribute("msg","Select Month");
}
RequestDispatcher rd2=request.getRequestDispatcher("/fee/feechart.jsp"); 
rd2.forward(request,response); 
%>
