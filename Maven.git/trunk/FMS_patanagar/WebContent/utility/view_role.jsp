<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="User_Role.User_role_bean"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<% 
   
User_role_bean user_role=new User_role_bean();
HashMap roleMap=new HashMap();
List rolelist=new ArrayList();
%>

<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>User Roles</title>
</head>
 <%

 
 if(request.getAttribute("rolelist")!=null){
rolelist=(List)request.getAttribute("rolelist");   

 }%>
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
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">VIEW USER ROLE</font></td></tr>
                 </table>
<form  method="post" action="<%=request.getContextPath()%>/save_Rule.do?method=save_Rule">
<table align="center" WIDTH="60%" valign="top" border="1" style="border-collapse:collapse">
<tr><td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">Level</font></td><td><font style="font-size:14;font-weight:bold">Create</font></td>
<td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">View</font></td><td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">Delete</font></td>
<td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">Update</font></td></tr>
<%for(int i=0;i<rolelist.size();i++){
user_role=(User_role_bean)rolelist.get(i);
%>

<TR><td align="center"><font style="font-size:14;font-weight:bold">
        <%=user_role.getUr_level()%></font></td><input type="hidden" name="level<%=i%>" value="Normal">
<TD><%if(user_role.getUr_create().equalsIgnoreCase("yes")){%><img src="<%=request.getContextPath()%>/image/tick.png" width="40">
    <%}else{%><img src="<%=request.getContextPath()%>/image/x.png" width="35"><%}%></TD>
<TD><%if(user_role.getUr_read().equalsIgnoreCase("yes")){%><img src="<%=request.getContextPath()%>/image/tick.png" width="40">
    <%}else{%><img src="<%=request.getContextPath()%>/image/x.png" width="35"><%}%></TD>
<TD><%if(user_role.getUr_delete().equalsIgnoreCase("yes")){%><img src="<%=request.getContextPath()%>/image/tick.png" width="40">
    <%}else{%><img src="<%=request.getContextPath()%>/image/x.png" width="35"><%}%></TD>
<TD><%if(user_role.getUr_update().equalsIgnoreCase("yes")){%><img src="<%=request.getContextPath()%>/image/tick.png" width="40">
    <%}else{%><img src="<%=request.getContextPath()%>/image/x.png" width="35"><%}%></TD>
</tr>
<%}%>
</table>
</form>
<table>
   <tr><td height="20"></td></tr> 
</table>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
