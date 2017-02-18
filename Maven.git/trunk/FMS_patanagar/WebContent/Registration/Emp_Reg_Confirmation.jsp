<%-- 
    Document   : Emp_Reg_Confirmation
    Created on : Oct 20, 2014, 6:51:26 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="java.util.ArrayList" %>

<%@page import ="ActionClass.JavaBean1"%>

<html>
  <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>Employee/User Registration Confirmation</title>
<body style="margin-left:20;margin-right:20">
<%
JavaBean1 jb=new JavaBean1();
ArrayList ud=(ArrayList)request.getAttribute("userdetail");
//out.println(ud);

for(int i=0;i<ud.size();i++)
{

jb=(JavaBean1)ud.get(i);

}
%>

<body bgcolor="#999933">
    <style>
             input[type=button] {
                 cursor: pointer;
    
    background-color: #A89263;
    color: #333333;
    padding: 2px 6px 2px 6px;
    border-top: 1px solid #CCCCCC;
    border-right: 1px solid #333333;
    border-bottom: 1px solid #333333;
    border-left: 1px solid #CCCCCC;
   }
   
   input[type=button]:hover {
       background-color: #EEEEEE;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 447px;
    left:300px;
}
         </style>  

 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/utility/rolesmenu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
                 <table width="60%" align="center">
                     <tr><td height="40" ></td></tr>
                     <tr><td align="left"><font color="yellow" size="3"><b>
                                 <%if(request.getAttribute("msg")!=null){%><%=request.getAttribute("msg")%><%}%>  </b></font></td></tr>
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">Employee/User Registration Confirmation</font></td></tr>
                 </table>
<table align="center" border="0" width="60%">
      <tr><td><table width="40%" align="left">
       <tr><td>User </td><td><%=jb.getUserType()%></td></tr>     
       <tr><td>Name:</td><td><%=jb.getName()%></td></tr>
       <tr><td>UserID:</td><td><%=jb.getLoginid()%></td></tr>
        <!--<tr><td>Password:</td><td><%=jb.getPassword()%></td></tr>-->
         <tr><td>Secret Question:</td><td><%=jb.getSecretques()%></td></tr>
          <tr><td>Secret Answer:</td><td><%=jb.getSecretans()%></td></tr>
              </table></td></tr>
      </table>
 <table>
   <tr><td height="20"></td></tr> 
</table>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
