<%-- 
    Document   : utilitypage
    Created on : Oct 20, 2014, 3:54:52 PM
    Author     : kapil
--%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Change Password</title>
<script language="javascript">
    function validate(){
        if(document.f1.oldpass.value==""){
            alert("Enter your current password.");
            document.f1.oldpass.focus();
            return false;
        }
        if(document.f1.newpass.value==""){
            alert("Enter your new password.");
            document.f1.newpass.focus();
            return false;
        }
        if(document.f1.cnewpass.value==""){
            alert("Enter your confimation password.");
            document.f1.cnewpass.focus();
            return false;
        }
        if(document.f1.cnewpass.value!=document.f1.newpass.value){
            alert("New password and new confirmation password is not matching.");
            document.f1.cnewpass.focus();
            return false;
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
            <%@include file="/fee/edituser_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"> 
                 <form  name="f1"  method="post" action="<%=request.getContextPath()%>/update_pass.do?method=Edit_user_pass" onsubmit="return validate()">
                 <table width="60%" align="center">
                     <tr><td height="40" colspan="2"></td></tr>
                     <% 
loginid=(String)session.getAttribute("loginid");
%>
                 <tr><td colspan="2"><font color="yellow"><%if(request.getAttribute("msg")!=null){%><%=request.getAttribute("msg")%><%}%></font></td></tr> 
                 <tr>
                    <td align="center" colspan="2"><b>CHANGE PASSWORD</b></td>
                </tr>
                <tr>
                    <td height="10" colspan="2"></td>
                </tr>
                 <tr>
                    <td>Old Password:</td>
                    <td><input type ="password" size=30  name ="oldpass"> </td>
                </tr>
                <tr>
                    <td>New Password: </td>
                   <td> <input type ="password" size=30  name ="newpass"> </td>
                </tr>
                <tr>
                    <td>Confirm New Password: </td>
                   <td> <input type ="password" size=30  name ="cnewpass"></td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><input type ="submit" size=30  value= "submit"> </td>
                </tr>
                </table>
 </form> 
</td></tr></table>
               
<tr><td valign="top">
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</td></tr>

</td></tr></table>
</body>
</html>

