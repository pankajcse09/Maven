<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java"%>
        <html>
            <head>
                
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
  <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></SCRIPT>          
         <script language="javascript" src="/Exam/resolution.js"></script>


    <title>Registration Form</title>
    <script language="javascript">
     function go(f1)
     {
     if(document.forms[0].elements[0][0].selected)
     {
        document.forms[0].method="POST";
document.forms[0].action="studnt_regist.do?para=s";
document.forms[0].submit();
}

     if(document.forms[0].elements[0][1].selected)
     {
     document.forms[0].method="POST";
document.forms[0].action="emp_regist.do?p1=e";
document.forms[0].submit();
     }
            
         
                          }
    </script>
  </head>
    <body >
   
 <table width="100%" cellpadding="0" cellspacing="0" bgcolor="#455A8B"><tr><td>
<table width="100%" ><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">

<tr><td valign="top">    

    <form method="post">
 <table align="center" width="100%"><tr><td align="right" width="100%">
 <table width="100%"><tr><td width="100%" align="right"><a href="<%=request.getContextPath()%>/regis.jsp"><font color="#000080">Home</font></a></td></tr></table>     
<tr><td align="center"><font color="#000080" size="3"><b>Please select your type for the registration</b></font></td></tr>
<tr><td height="25"></td></tr>
<tr><td><table align="center"><tr>
<td><select name="user">
<option value="EMPLOYEE">EMPLOYEE</option>
</select></td><td><input type="button" value="Go" onClick="go(this.form)"></td></tr></table></td></tr>
</form>

 
 </td></tr></table>
</td></tr></table>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>


 </td></tr></table>
</body>
</html>