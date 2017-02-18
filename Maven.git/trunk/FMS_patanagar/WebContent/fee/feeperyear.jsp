<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>School Management System</title>
    </head>
    <body>

    <%
    Connection cn=null;
    Statement stmt3=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ResultSet rs3=null;
    
    
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
    try
    {
    String sm="select sum(amountpaid)as amount from feerecord where Syear='"+Syear+"' or Eyear='"+Syear+"' "
            
            pstmt=cn.prepareStatement(sm);
            rs=pstmt.executeQuery();
            rs.next();
            
             amount=rs.getInt("amount");
           
    }
    %>
    </body>
</html>
