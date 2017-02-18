<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
String ssn="";
String clas="";
String sec="";
String sm="";
String extp="";
String p=(String)request.getParameter("pr");
if(request.getParameter("sessions")!=null){
ssn=(String)request.getParameter("sessions");    
}
if(request.getParameter("section")!=null){
sec=(String)request.getParameter("section");    
}
if(request.getParameter("classes")!=null){
clas=(String)request.getParameter("classes");    
}
if(request.getParameter("examtype")!=null){
extp=(String)request.getParameter("examtype");   
}
%> 
 <jsp:forward page="/EnterMarks.jsp">
 <jsp:param name="pr" value="1"/>   
 <jsp:param name="sessions" value="<%=ssn%>"/>   
 <jsp:param name="section" value="<%=sec%>"/>
 <jsp:param name="examtype" value="<%=extp%>"/>
</jsp:forward> 