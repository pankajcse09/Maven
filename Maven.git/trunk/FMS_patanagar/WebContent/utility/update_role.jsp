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
String msg="";
 if(request.getAttribute("msg")!=null){
     msg=(String)request.getAttribute("msg");
 }
 
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
                     <tr><td align="left"><font color="yellow" size="3"><b><%=msg%></b></font></td></tr>
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">UPDATE USER ROLE</font></td></tr>
                 </table>

<form  method="post" action="<%=request.getContextPath()%>/Update_Roles.do?method=update_User_Roles_Save">
<table align="center" WIDTH="60%" valign="top" border="1" style="border-collapse:collapse">
<tr><td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">Level</font></td><td><font style="font-size:14;font-weight:bold">Create</font></td>
<td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">View</font></td><td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">Delete</font></td>
<td ALIGN="CENTER"><font style="font-size:14;font-weight:bold">Update</font></td></tr>
<%
if(rolelist.size()!=0){
for(int i=0;i<rolelist.size();i++){
user_role=(User_role_bean)rolelist.get(i);
%>

<TR><td align="center"><font style="font-size:14;font-weight:bold"><%=user_role.getUr_level()%></font></td>
<input type="hidden" name="id<%=i%>" value="<%=user_role.getId()%>">
<TD><input type="checkbox" name="create<%=i%>" value="yes"
<%if(user_role.getUr_create().equalsIgnoreCase("yes")){%>
checked
<%}%>
></TD>
<TD><input type="checkbox" name="view<%=i%>" value="yes"
<%if(user_role.getUr_read().equalsIgnoreCase("yes")){%>
checked
<%}%>
></TD><TD><input type="checkbox" name="delete<%=i%>" value="yes"
<%if(user_role.getUr_delete().equalsIgnoreCase("yes")){%>
checked
<%}%>

></TD>
<TD><input type="checkbox" name="update<%=i%>" value="yes"
<%if(user_role.getUr_update().equalsIgnoreCase("yes")){%>
checked
<%}%>
></TD>
</tr>
<%}%>
<tr><td align="center" height="50" colspan="6"><input type="submit" value="Update"></td></tr>
<%}else{%>
<tr><td colspan="6" align="center" valign="middle" height="40"><b>User roles are not defined</b></td></tr>
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