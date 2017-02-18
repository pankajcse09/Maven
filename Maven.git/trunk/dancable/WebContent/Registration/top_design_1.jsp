<html>
<% 
  String username="";
 
 if(session.getAttribute("loginid")!=null){

username=(String)session.getAttribute("loginid");
%>
<body>
<table width="100%" align="center" height="100" bgcolor="black">
<tr>
<td width="100%" align="center" valign="top"><font style="font-size:20;font-weight:bold;color:white">DANCEABLES CONTENT MANAGEMENT SYSTEM</font></td>

</tr>

<tr><td align="center"  bgcolor="" valign="top">
<table>
    <tr><td align="center"  bgcolor="">
  

    

<font style="color:white;font-weight:bold;font-size:15">Welcome&nbsp;</font>
<font style="color:white;font-weight:bold;font-size:15">'<%=username%>'</b></font></td>
<td><font color="#1C6BA6"><b>&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;</b></font>
<a href="<%=request.getContextPath()%>/goto_home.do"><font style="color:white;font-weight:bold;font-size:15"><b>Home</b></font></a>
</td>
    
    <td><font color="#1C6BA6"><b>&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;</b></font>
<a href="<%=request.getContextPath()%>/logout.do?method=logout"><font style="color:white;font-weight:bold;font-size:15"><b>Logout</b></font></a>
</td>
    </tr>
</table>
</td></tr>
</table>
<%}else{%>
<jsp:forward page="../Registration/UserLogin.jsp"/>
<%}%>
</body>
</html>