<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse;border-color:lightblue}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
      <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
          <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
      </head>      
    <body>
    <table border="0" bordercolor="" background="<%=request.getContextPath()%>/image/header.jpg" width="817" height="271">
    <tr><td align="center"><font color="Yellow" style="font-family:Comic Sans MS" size="5">Fee Management System</font></td></tr> 
    <tr><td align="center"><font color="Yellow" style="font-family:Times New Roman" size="5"> College</font></td></tr>
    <tr>
    <td colspan="2">&nbsp;</td>
    </tr>
     <tr>
    <td colspan="2">&nbsp;</td>
    </tr>
     <tr>
    <td colspan="2">&nbsp;</td>
    </tr>

    <tr>
    <td><font color="white" style="font-family:TimesNewRoman" size="3">IntelMind Information Technology Private Limited, Rudrapur</font></td> 
    <td align="center"><a href="<%=request.getContextPath()%>/Logout.do?method=logout">
    <font color="white" style="font-family:TimesNewRoman" size="3">Logout</font></a></td>
    </tr>
</table>
</body>
</html>
