<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
 
<title>Home</title>
<base target="_parent"><link rel="stylesheet" type="text/css" href="/Exam/mystyle1.css">
<link rel="stylesheet"  href="/Exam/menu.css">
<script language="javascript" src="/Exam/menu.js"></SCRIPT>
</head>
<%
String img=(String)request.getContextPath();
%>
<body>
<table border=0 class="navbar" width="100%" cellspacing="0"><tr>    
    <td><%@include file="/Wlcmusr.jsp" %></td>
       <td><%=session.getAttribute("forwardname")%> </td>
     <td align="left"> 
      <span><img  border="0" 
src="<%=img%>/image/search1.jpg" vspace="0" hspace="0" style="margin:0;" width="68" 
height="16"></span></td>
<td align="left" valign="bottom"> 
     <span><img  border="0" 
src="<%=img%>/image/blank.png" vspace="0" hspace="0" style="margin:0;" width="100" 
height="24"></span></td>              
        <td valign="bottom" class="menuNormal" width="68" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
    <span> <img  border="0" src="<%=img%>/image/colleges11.jpg" 
vspace="0" hspace="0" style="display: block; margin:0;" width="68" height="16"></span>
        <div class="menuNormal" width="100">
          <table class="menu" width="100">
            <tr><td class="menuNormal" bgcolor="#993333">
              <html:link action="/Agri" styleClass="menuitem">Agriculture</html:link>
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/Agro" styleClass="menuitem">Agrobusiness</html:link>
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/Mgm" styleClass="menuitem">Management</html:link>
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/Bsh" styleClass="menuitem">Basic Sciences & 
Humanities</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/Fsh" styleClass="menuitem">Fishery Sciences</html:link>  
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/Fores" styleClass="menuitem">Hill Agriculture & 
Forestry</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/Hc" styleClass="menuitem">Home Science</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
               <html:link action="/Tech" styleClass="menuitem">Technology</html:link>
            </td></tr>
            <tr><td class="menuNormal">
               <html:link action="/Vs" styleClass="menuitem">Vetenary & Animal 
Sciences</html:link>
            </td></tr>
            <tr><td class="menuNormal">
               <html:link action="/Pgs" styleClass="menuitem">P.G Studies</html:link>
            </td></tr>
            </table>
        </div>
      </td>   
   <td class="menuNormal" width="80" onmouseover="expand(this);" onmouseout="collapse(this);" >
      <span><img border="0" src="<%=img%>/image/quicklinks11.jpg"  vspace="0" 
hspace="0" style="display: block; margin:0;" width="80" height="16" ></span> 
        <div class="menuNormal" width="87">
          <table class="menu" width="87">
            <tr ><td class="menuNormal" >
              <a href="AcademicCal.do" class="menuitem">Academic:Calendar</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">College Spotrs</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Career Development</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <html:link action="/Lib" styleClass="menuitem">Library</html:link>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">University Help</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Vice Chancellor</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Registrar</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Administrative Setup</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Student Resource Center</a>
            </td></tr>
             <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Student Housing</a>
            </td></tr>
             <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Hospitals</a>
            </td></tr>
            <tr ><td class="menuNormal">
             <html:link action="/jobs" styleClass="menuitem">Jobs at GBPUAT</html:link>
            </td></tr>
             <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Public affairs</a>
            </td></tr>
             <tr> <td class="menuNormal">
              <a href="#" class="menuitem">Healthy Education</a>
            </td></tr>
             <tr ><td class="menuNormal">
              <a href="#" class="menuitem">GBPUAT MAP</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Transportation</a>
            </td></tr>
             <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Airport</a>
            </td></tr>
            <tr ><td class="menuNormal">
              <a href="#" class="menuitem">Public Article</a>
            </td></tr>
          </table>
        </div>
      </td>   
     </tr>
          </table> 
</body>
</html>
  