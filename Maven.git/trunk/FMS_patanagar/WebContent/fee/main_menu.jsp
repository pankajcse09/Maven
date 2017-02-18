<%-- 
    Document   : main_menu
    Created on : Mar 22, 2013, 4:16:11 PM
    Author     : kapil
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <!--<tr><td><a href="<%=request.getContextPath()%>/fee/FeeMainPage.jsp">
<font color="green" style="font-family:Times New Roman" size="4"><strong>Home</strong></font></a></td></tr>-->
            <tr><td><input type="button" value="home"></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/fee/regis.jsp"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration</strong></font></a></td></tr>
            <tr><td valign="top"><a href="<%=request.getContextPath()%>/fee/utilities.jsp"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></a></td></tr>
            <tr><td valign="top" width="100"><font color="green" style="font-family:Times New Roman" size="4"><strong>Fee</strong></font></td>
            <tr><td valign="top" width="100" height="18"><font color="green" style="font-family:Times New Roman" size="4"><strong>Expenses</strong></font></td></tr>
            <tr><td valign="top" width="100" height="18"><font color="green" style="font-family:Times New Roman" size="4"><strong>Reports</strong></font></td></tr>
        </table>
    </body>
</html>
