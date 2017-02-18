<%-- 
    Document   : testing
    Created on : May 28, 2013, 6:49:51 PM
    Author     : kapil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="css/menu.js"></script>
    </head>
    <body>
        <table>
            <tr>
                <td class="chang" onclick="change(this)" align="center">
                    <a class="b" href="#">CDs FOR BALLET</a>
                </td>
            </tr>
             <tr>
                <td class="chng" onclick="change1(this)" align="center">
                    <a class="b" href="#">CDs FOR PRE-BALLET</a>
                </td>
            </tr>
        </table>
    </body>
</html>
