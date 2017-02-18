<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <% 
	
	String  user=(String)session.getAttribute("username");
        String  uty=(String)session.getAttribute("usertype");
	
	if(user == null)
	{
		response.sendRedirect("logout.jsp");
		return;
	}

     //session.putValue("uid",uid);
%>
   <table width=100% cellpadding="0" cellspacing="0" align="center" bgcolor="#34689A" >
   <tr><td bgcolor="#A52A2A"><img src="<%=request.getContextPath()%>/image/sms.jpg" wmode="transparent" width="100%" height="80"></td></tr>
  <tr><td><table width="100%" cellpadding="0" cellspacing="0" align="right" bgcolor="#A52A2A" height=28><tr><td bgcolor="#A52A2A">
<table width="100%" cellpadding="0" cellspacing="0" bgcolor="#A52A2A" align="right"><tr><td valign="top" bgcolor="#A52A2A">
<table cellpadding="0" cellspacing="0" align="right"><tr bgcolor="#A52A2A">
<td align="left" valign="bottom"><font color=white>Welcome <%=user%></font></td> </tr></table>
</td>
<td>
<table width="40%" cellpadding="0" cellspacing="0" align="right"><tr bgcolor="#A52A2A">
<td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="center"><a href="logregis.do"><font size=2 color="white">New User</font></a></div>
</td>
<td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="center"><a href="logout.jsp"><font size=2 color="white">Logout</font></a></div>
</td>
</tr>
</table></td></tr></table></td></tr>
   </table>
    </body>
</html>
