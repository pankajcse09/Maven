<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%response.setHeader("Cache-Control","no-cache");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript">   
        </script>
    </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
 <tr><td valign="top" height="5%"><jsp:include page="/CommonLinks.jsp"/></td></tr> 
<tr><td valign="top">

<form name="addep" method="post" action="<%=request.getContextPath()%>/Add_Dep">
<table align="center"><tr><td valign="top">*College
<select name="college1"> 
<option value="College of Vetenary & Animal Sciences">College of Veterinary & Animal Sciences</option>
</select>
</td></tr>       
<tr><td valign="top">*Enter Dep<input type='text' name='dep'></td></tr>
<tr><td align="center" valign="top"><input type= "submit" value="ADD"></td></tr>     
<tr><td valign="top">             
         <%
if(application.getAttribute("dep_success")!=null){
%>
<font color="red" size=3><%=application.getAttribute("dep_success")%></font>
<%}
application.removeAttribute("dep_success");
%>
 </td></tr></table> 
   </form>
   </td></tr></table>

<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
