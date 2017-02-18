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
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu1.css">
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
  <form  method="post" action="<%=request.getContextPath()%>/studtransfee.do">
<table align="center" width="100%" cellpadding="2" cellspacing="0" >          

    </td></tr>
    <tr><td valign="top">
   <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Transport Fee Record</u></font></center></td></tr></table>    
       <%  
        
      Integer amount=(Integer)request.getAttribute("amount"); 
     
      HashSet hs=(HashSet)request.getAttribute("hs");
      Iterator ir=(Iterator)hs.iterator(); 
   
         %>
      
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

  <table width="60%" cellpadding="0" cellspacing="0"  align="center" height=450>
       <tr><td valign="top">     
            <table width="100%" cellpadding="1" cellspacing="0"  align="center">
 
<tr><td><b>Session:</b></td><td><%=seo.getSyear()%>-<%=seo.getEyear()%></td></tr>
<tr><td><b>Registration Number:</b></td><td><%=seo.getSrnum()%></td></tr>
<tr><td><b>Student Name:</b></td><td><%=seo.getSname()%></td></tr><input type="hidden" name="sname" value="<%=seo.getSname()%>">
<tr><td><b>Class:</b></td><td><%=seo.getClasses()%></td></tr><input type="hidden" name="classes" value="<%=seo.getClasses()%>">
<tr><td><b>Months:</b></td><td>
<% while(ir.hasNext()){%>
<%=ir.next().toString()%>,
<%}%></td></tr>
<tr><td><b>Total Amount Paid:</b></td><td><%=amount%></td></tr><input type="hidden" name="status" value="<%=amount%>">

  
  </table>
       </td></tr></table>
       <%
   } }
   }catch(Exception e)
       {}%>
       </td></tr></table> 
</form>   
  </td></tr></table>
  
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    
    </body>
</html>
