<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.io.*,java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>   
<%@page import="schedule.*"%>  
<% 
   ArrayList ar=new ArrayList();
   ArrayList ar1=new ArrayList();
   HashMap hm1=new HashMap();
   HashMap hm2=new HashMap();
   HashMap hm3=new HashMap();
   
   JavaBeanExam jb=new JavaBeanExam();
   try{  
   if(request.getAttribute("jbean")!=null){
    jb=(JavaBeanExam)request.getAttribute("jbean");   
     }
   %>
    <html>
    <head>  
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>        
     <script language="javascript"></script>
    </head>
    <body>     
<table width="900" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td>
<table width="100%"><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr></table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">
    <table width="100%" height="500" border="1" valign="top"><tr>
    <td width="20%" valign="top">
    <center><font color="blue" size="3"><b>Update Marks</b></font></center>
     <form method="post" action="<%=request.getContextPath()%>/SelectStudentAct1.do?method=updateMarks">
     <input type="hidden" name="rowid" value="<%=jb.getRowid()%>"> 
     <input type="hidden" name="exam" value="<%=jb.getExam()%>"> 
  <table width="40%" align="center">
  <tr><td width="50%">Sr.No.</td><td width="50%">Marks</td></tr>
  <tr><td width="50%"><input type="hidden" name="srno" value="<%=jb.getStudId()%>"><%=jb.getStudId()%></td><td width="50%"><input type="text" name="marks" value="<%=jb.getMarks()%>"></td></tr>
  <tr><td align="center" colspan="2"><input type="submit" value="Submit"></td></tr>
  </table>
  </form>
  </td></tr></table>      
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</td></tr></table>
    </body>
</html>
<%}catch(NullPointerException ne){}%>

