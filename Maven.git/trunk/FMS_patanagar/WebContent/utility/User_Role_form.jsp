<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 

String msg="";
 if(request.getAttribute("msg")!=null){
     msg=(String)request.getAttribute("msg");
 }
try{
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
<script language="javascript">
function selectALL(i)
{
    if(document.f.elements["all"+i].checked==true)
        {
           document.f.elements["create"+i].checked=true;
           document.f.elements["view"+i].checked=true;
           document.f.elements["delete"+i].checked=true;
           document.f.elements["update"+i].checked=true;
       }
    else{
        document.f.elements["create"+i].checked=false;
           document.f.elements["view"+i].checked=false;
           document.f.elements["delete"+i].checked=false;
           document.f.elements["update"+i].checked=false;
    }    
}
</script>
</head>
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
    <font style="font-size:15;color:black;font-weight:bold">DEFINE USER ROLE</font></td></tr>
                 </table>
<form name="f"  method="post" action="<%=request.getContextPath()%>/save_Rule.do?method=save_Rule">                 
<table align="center" WIDTH="60%" valign="top" border="1" style="border-collapse:collapse">
 
    <tr><td><font style="font-size:12;font-weight:bold">Level</font></td><td><font style="font-size:12;font-weight:bold">Add</font></td>
<td><font style="font-size:14;font-weight:bold">View</font></td><td><font style="font-size:14;font-weight:bold">Delete</font></td>
<td><font style="font-size:14;font-weight:bold">Update</font></td><td><font style="font-size:14;font-weight:bold">All</font></td></tr>
    
   

<TR><td><font style="font-size:14;font-weight:bold">Normal User</font></td><input type="hidden" name="level1" value="Normal">
<TD><input type="checkbox" name="create1" value="yes"></TD>
<TD><input type="checkbox" name="view1" value="yes"></TD><TD><input type="checkbox" name="delete1" value="yes"></TD>
<TD><input type="checkbox" name="update1" value="yes"></TD><td><input type="checkbox" name="all1" onclick="selectALL('1')"></td>
</tr>

    <TR><td><font style="font-size:14;font-weight:bold">Employee</font></td><input type="hidden" name="level2" value="Employee">
<TD><input type="checkbox" name="create2" value="yes"></TD>
<TD><input type="checkbox" name="view2" value="yes"></TD><TD><input type="checkbox" name="delete2" value="yes"></TD>
<TD><input type="checkbox" name="update2" value="yes"></TD><td><input type="checkbox" name="all2" onclick="selectALL('2')"></td>
</tr>


<TR><td><font style="font-size:14;font-weight:bold">Manager</font></td><input type="hidden" name="level3" value="Manager">
<TD><input type="checkbox" name="create3" value="yes"></TD>
<TD><input type="checkbox" name="view3" value="yes"></TD><TD><input type="checkbox" name="delete3" value="yes"></TD>
<TD><input type="checkbox" name="update3" value="yes"></TD><td><input type="checkbox" name="all3" onclick="selectALL('3')"></td>
</tr>


<TR><td><font style="font-size:14;font-weight:bold">Admin</font></td><input type="hidden" name="level4" value="Admin">
<TD><input type="checkbox" name="create4" value="yes"></TD>
<TD><input type="checkbox" name="view4" value="yes"></TD><TD><input type="checkbox" name="delete4" value="yes"></TD>
<TD><input type="checkbox" name="update4" value="yes"></TD><td><input type="checkbox" name="all4" onclick="selectALL('4')"></td>
</tr>

<TR><TD colspan="6" align="center"><input type="submit" name="" value="submit"></TD></tr>
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
<%}catch(Exception e){}%>