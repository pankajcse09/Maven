<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.myapp.struts.examEO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <style type="text/css">
    .t{border-collapse:collapse}    
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internal Marks Entryt</title>
    </head>
    <body>
<table width="800" align="center"><tr><td align="center">       
<table width="100%" valign="top"><tr><td>
<jsp:include page="/toplook.jsp"/>
</td></tr></table>
<table bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%" height="350">
 <tr><td valign="top" align="center"><jsp:include page="/CommonLinks.jsp"/></td></tr>
 <tr><td valign="top" align="center">
    <h1><font color="green">Internal Marks Entry</font></h1>
    <form action="storedata" method="post">
    <table width="50%" border="1" class="t">
   <%
    String st;
  
   examEO bb=new examEO();
   ArrayList arr=new ArrayList();
   if(request.getAttribute("data") !=null)
   {
      arr=(ArrayList)request.getAttribute("data");
   
   }
  
   %>
   
  <%
  for(int i=0;i < arr.size();i++)
  {
  bb =(examEO)arr.get(i);
  %>
  <tr><td width="30%" align="left">Stud id</td><td width="70%" align="left"><%=bb.getStudid()%><input type="hidden" name="studid" value="<%=bb.getStudid()%>"></td></tr>
  <tr><td width="30%" align="left">Year</td><td width="70%" align="left"><%=bb.getSession()%><input type="hidden" name="session" value="<%=bb.getSession()%>"></td></tr>
 
  <tr><td width="30%" align="left">Semester</td><td width="70%" align="left"><%=bb.getSemester()%><input type="hidden" name="semester" value="<%=bb.getSemester()%>" name="semester"></td></tr>
  <tr><td width="30%" align="left">Degree</td><td width="70%" align="left"><%=bb.getDegree()%><input type="hidden" value="<%=bb.getDegree()%>" name="degree" size="40"></td></tr>
   <tr><td width="30%" align="left">Course_id</td><td width="70%" align="left"><%=bb.getCourseid()%><input type="hidden" name="course" value="<%=bb.getCourseid()%>"></td></tr>
  
    <tr><td width="30%" align="left">MidTerm</td><td width="70%" align="left"><input type="text" name="midterm" value="<%=bb.getMidterm()%>"></td></tr>
    <tr><td width="30%" align="left">EndTerm</td><td width="70%" align="left"><input type="text" name="endterm" value="<%=bb.getEndterm()%>"></td></tr>
    <tr><td width="30%" align="left">Practical</td><td width="70%" align="left"><input type="text" name="practical" value="<%=bb.getInternalpractical()%>"></td></tr>
    <tr><td width="30%" align="left">Attendance</td><td width="70%" align="left"><input type="text" name="attendance" value="<%=bb.getAttendance()%>"></td></tr>
   <%}%>
  <tr><td colspan="2" align="right"><input type="submit" value="Save"></td></tr> 
  </table> 
    </form>
       </td></tr></table> 
   <table width="100%"><tr><td valign="top"><%@include file="/btmnavi.jsp"%></td></tr></table>
 </td></tr></table> 
    </body>
</html>