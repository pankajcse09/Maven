<%-- 
    Document   : AddHostel
    Created on : Mar 1, 2015, 12:54:04 PM
    Author     : kapil
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
try{
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hostel</title>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<script language="JavaScript">     
function validate(){
    if(document.f1.elements["hostel_name"].value==""){
alert("Please Enter Hostel Name");
document.f1.elements["hostel_name"].focus();
return false;
 }

if(document.f1.elements["hostel_code"].value==""){
alert("Please Enter Hostel Code");
document.f1.elements["hostel_code"].focus();
return false;
 }
return true;
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
    height: 947px;
    left:300px;
}
         </style>   
         
         <% String sess="";
         if(request.getAttribute("session")!=null){
             sess=(String)request.getAttribute("session");
         }%>
        
<table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
<tr><td>
<table style="padding-left: 350px">
    <tr><td colspan="2" align="center"><font style="font-size:16;font-weight:bold;color:darkblue">Add Hostel</font></td></tr>
</table></td></tr>
<tr><td style="padding-left: 200px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/addHostel.do?method=addHostel" onsubmit="return validate();">
<table  align="center" border="1" style="border-collapse:collapse" width="500" bordercolor="black">
<%if(request.getAttribute("msg")!=null){%>  
<tr><td colspan="2"><font color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
<tr><td><font style="font-size:12;color:black"><b>Hostel Name</b></font></td>
       <td><input type="text" name="hostel_name"></td></tr>
<tr><td><font style="font-size:12;color:black"><b>Hostel Code</b></font></td>
       <td><input type="text" name="hostel_code"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
</table>
</form>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>

