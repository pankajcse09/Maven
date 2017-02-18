<%-- 
    Document   : toplook_1
    Created on : Mar 22, 2013, 3:30:06 PM
    Author     : kapil
--%>



<%@page import="User_Role.User_role_bean"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<style type="text/css">.t{border-collapse:collapse;border-color:green}</style>
</head>      
<body>
<table border="0" bgcolor="#FFFFCC" width="100%" style="padding-left: 130px">       
 <!--<tr><td align="center"><font color="#666600" style="font-family:Times New Roman" size="5">Surajmal Laxmi Devi Sawarthia Educational Trusts </font></td></tr>
 <tr><td align="center"><font color="#666600" style="font-family:Times New Roman" size="5">Group of Instiutions </font></td></tr>
 <tr><td align="center"><font color="#666600" style="font-family:Times New Roman" size="5">(Surajmal college of Engineering & Management , kichha) </font></td></tr>
-->
<tr><td style="padding-left: 300px"><font color="#99990" style="font-family:Comic Sans MS; font-weight: bold" size="5">Admission/Fee Management System</font></td></tr> 

<tr><td style="padding-top: 30px; padding-left: 270px">
        <% 
        
 if(session.getAttribute("loginid")!=null&&session.getAttribute("user_auth")!=null){
     User_role_bean urb=(User_role_bean)session.getAttribute("user_auth");
        String role=(String)session.getAttribute("userrole");
 String s="yes";
 %>
        <table>
            <tr>
                <td valign="top"><a href="<%=request.getContextPath()%>/fee/FeeMainPage.jsp">
<font color="green" style="font-family:Times New Roman" size="4"><strong>Home</strong></font></a></td>
<%if(role.equals("Admin")){%>
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/user_role.do">
<font color="green" style="font-family:Times New Roman" size="4"><strong>User Role</strong></font></a></td>
<%}%>
<%if(urb.getUr_create().equals("yes")){%>
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/stregistration.do">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Registration</strong></font></a></td>
        <%}%>
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/utility.do?ab=uvc">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></a></td>
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/DisplayFeeStruct.do?method=Branchpage">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Fee Structure</strong></font></a></td>
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/studentP.do?ac=srt">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Students</strong></font></a></td>
<!--<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/feeScrollExcel.do?method=Branchpage">
<font color="green" style="font-family:Times New Roman" size="4"><strong>Old Student</strong></font></a></td>-->
        <%if(urb.getUr_update().equals(s)||urb.getUr_create().equals(s)||urb.getUr_delete().equals(s)){%>           
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/stud_ladder.do">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Student Ledger</strong></font></a></td>
<!--<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/Enter_All_Expenses.do">
<font color="green" style="font-family:Times New Roman" size="4"><strong>Expenses</strong></font></a></td>-->
  
<td valign="top" style="padding-left: 20px"><a href="<%=request.getContextPath()%>/PantReports/fundwisereport.jsp">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Reports</strong></font></a></td>
        <%}%>
 <!--<td valign="top" style="padding-left: 20px"><a href="<%//=request.getContextPath()%>/payment.do">
        <font color="green" style="font-family:Times New Roman" size="4"><strong>Online Payment</strong></font></a></td>   -->    
          </tr>
        </table>
<%}else{%>
<jsp:forward page="/logout.jsp"/>
<%}%>
    </td>
<td align="right" style="padding-top: 32px"><a href="<%=request.getContextPath()%>/Logout.do?method=logout">
<font color="white" style="font-family:TimesNewRoman; color: black" size="2"><b>Logout</b></font></a></td></tr>


</td></tr></table>
</body>
</html>
