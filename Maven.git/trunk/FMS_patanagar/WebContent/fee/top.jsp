<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<table width="100%" height=30 bgcolor="#696969">
 <tr><td align="center" width="100%"><font color="white" size="4">School Management System</font></td>
  <td><% if(ut.equals("Admin")){%>
 <a href="main.jsp"><font color="white" size="3">Home</font></a>

<%} else if(ut.equals("Super")){%>
 <a href="Supermain.jsp"><font color="white" size="3">Home</font></a>
<%}%>
  </td>
 </tr>
</table>
    
    </body>
</html>
