<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

   
<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script> 
    </head>
    <body>
    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Display List Of Students</u></font></center></td></tr></table>
    <form  method="post" action="<%=request.getContextPath()%>/clswise.do?dispcls=dispcls">
<table cellpadding="0" cellspacing="0" width="100%" height=450><tr><td valign="top">  
<table>
    <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color="red" size="2">Please enter the following detail</font></td></tr>
<tr><td>Class:<input type="text" name="cls" size="15" value=""></td>
</td><td><input type="submit" value="Display"></td></tr> 
 </table>
 </form>

<form name="formfine" >
<table border="1" width="80%" align="center"> 
 <tr>
<td><font size="2"><b>Registration Number</b></font></td>
<td><font size="2"><b>Student Name</b></font></td>
<td><font size="2"><b>Class</b></font></td>
<td><font size="2"><b>Section</b></font></td>
<td><font size="2"><b>Status</b></font></td>
<td><font size="2"><b>Todate</b></font></td>
</tr>
    
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 SchoolEO seo=null;
  %>
  <% if(request.getAttribute("arr")!=null)
 {%>           
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>

<tr>
<td><%=seo.getRegisnum()%></td>
<td><%=seo.getSname()%></td>
<td><%=seo.getClasses()%></td>
<td><%=seo.getSection()%></td>
<td><%=seo.getStatus()%></td>
<td><%=seo.getTodate()%></td>
</tr>
       
       <%
   }   }%>
</table>

       <%
        
   }catch(Exception e)
       {}%>
  </td></tr></table> 
</form>   
  </td></tr></table>
  
    <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>      
    </body>
</html>
