<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" src="<%=request.getContextPath()%>/calendarDateInput.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <title>JSP Page</title>
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
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td align="left"  valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration/Student Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left" valign="top" style="padding-left: 5px;" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left" style="padding-left: 10px;">
    <table width="100%"><tr><td width="100%"><font size="4"><b>Edit Employee Details :-</b></font></td></tr></table>
    <table width="100%" height="150" border="0" style="border-collapse:collapse">
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp7.do?method=allEmpIdAction"><font color="white"><u>Employee Login Details</u></font></a></td></tr>    
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp1.do?method=allEmpIdAction"><font color="white"><u>Employee Personal Details</u></font></a></td></tr>
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp2.do?method=allEmpIdAction"><font color="white"><u>Employee Education Details</u></font></a></td></tr>
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp3.do?method=allEmpIdAction"><font color="white"><u>Employee Previous Employment Details</u></font></a></td></tr>
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp4.do?method=allEmpIdAction"><font color="white"><u>Employee Proficiency Details</u></font></a></td></tr>
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp5.do?method=allEmpIdAction"><font color="white"><u>Employee Cultural Details</u></font></a></td></tr>
    <tr><td width="100%" height="15" class="tdcolor"><a href="Emp6.do?method=allEmpIdAction"><font color="white"><u>Employee references Detail</u></font></a></td></tr>    
    </table>
 </td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
