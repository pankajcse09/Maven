<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <title>JSP Page</title>
    </head>
    <body bgcolor="#999933">

    <!--1--><table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
           <tr><td valign="top" height="250" bgcolor="">  
               <table height="" align="center" width="100%" border="0" bgcolor="#A89263">
                   <tr><td width="100%"  colspan="2"><%@include file="/fee/feeHomeLink.jsp"%></td></tr> 
                   <tr><td valign="top"  colspan="2">
                          <!--3--><table width="100%" align="center" >
                                   <tr><td width="100%" align="center"><font color="#34282C" size="4"><b>Registration of Students and Employee</b></font></td></tr>
                                    <tr><td width="100%" align="center">&nbsp;</td></tr>
                          <!--3--></table>
                  </td></tr>
                 <tr>
                  <td align="center" height="200" valign="top">
                 <!--4--><table border="0" align="center">
                          <tr><td><font color="yellow" size="3"><b><u>Student Utilities</u></b></font></td></tr>
                          <!--<tr><td><html:link action="/set"><font color="white">Set SR.Number</font></html:link></td></tr>-->
                          <tr><td><html:link action="/streg"><font color="white">Student Registration</font></html:link></td></tr>
                          <tr><td><html:link action="/OldStudentRegis"><font color="white">Old Student Registration</font></html:link></td></tr>
                    <!--  <tr><td><html:link action="/esrec"><font color="blue">Edit Student Record</font></html:link></td></tr>-->
                          <tr><td><html:link action="/los"><font color="white">Update Students</font></html:link></td></tr>
                          <tr><td><html:link action="/ClasswiseStudList"><font color="white">Classwise Student List</font></html:link></td></tr>
                          <tr><td><html:link action="/EditClass_AfterSub"><font color="white">Edit Class After Fee Submission</font></html:link></td></tr>                
                     <!--4--></table></td> 
                     <td align="center" height="200" valign="top">
                          <table border="0" align="center">        
                          <tr><td><font color="yellow" size="3"><b><u>Employee Utilities</u></b></font></td></tr>
                          <tr><td><html:link action="/emp_regist"><font color="white">Register Employee</font></html:link></td></tr>
                          <tr><td><html:link action="/EditEmployee"><font color="white">Edit Employee</font></html:link></td></tr>
                          <tr><td><html:link action="/loe"><font color="white">Employee List</font></html:link></td></tr>
                          <tr><td>&nbsp;</td></tr>
                          <tr><td>&nbsp;</td></tr>                  
                          </table> 
</td></tr></table>
</td></tr>
<tr><td width="100%" align="center" valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
