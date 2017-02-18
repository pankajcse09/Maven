<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

 <% 
 String st="";
 if(session.getAttribute("loginid")!=null && session.getAttribute("password")!=null){
 %>
<table align="center" height=20 bgcolor="#B0C4DE" width="100%">
<tr><td><jsp:include page="/TopLinks.jsp"/></td></tr></table>
<%}else{%>
<jsp:forward page="/logout.jsp"/>
<%}%>
