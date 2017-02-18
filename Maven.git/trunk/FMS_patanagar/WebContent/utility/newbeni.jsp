<%-- 
    Document   : newbeni
    Created on : May 23, 2014, 12:38:25 PM
    Author     : kapil
--%>

<%@page import="EO.SchoolEO"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*,Beans.*"%>
<!DOCTYPE html>
<%response.setHeader("Cache-Control","no cache");%>
<% 
SchoolEO seo=new SchoolEO();

if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");    
}
ArrayList heads=seo.getDataArray();
HashMap hm=seo.getDataMap();
%>
<html>
    <head>
     <title>College Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>       
       <script>
           function validate(){    
           if(document.forms[0].elements["degree"].value==""){
           alert("Enter Degree");
           document.forms[0].elements["degree"].focus();
           return false;
           }
           if(document.forms[0].elements["degcode"].value==""){
           alert("Enter Degree Code");
           document.forms[0].elements["degcode"].focus();
           return false;
           }
           return true;
           }    
        </script>    
     </head>
    <body bgcolor="#999933">
    <%
       JavaBean de=new JavaBean();
   ArrayList degreelist=new ArrayList();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
    %>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                     
                <tr><td>
<table style="padding-left: 400px">
    <tr><td align="center"><font style="font-size:16;font-weight:bold" color="darkblue">Add New Beni Details</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 220px">
<form method="post" action="<%=request.getContextPath()%>/newbeni.do?method=NewBeniDetail">   
<table  align="center" border="1" style="border-collapse:collapse" width="500">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>   

<tr><td><font style="font-size:12;color:black"><b>Room Rent:</b></font>
        <input type="hidden" name="hd0" value="ROOM RENT"></td>
    <td><input type="text" name="amount0" value="0.00"></td></tr>    
<tr><td><font style="font-size:12;color:black"><b>Hostel Maintenance Fee:</b></font>
    <input type="hidden" name="hd1" value="HOSTEL MAINTENANCE FEE"></td>
    <td><input type="text" name="amount1" value="0.00"></td></tr>
<tr><td><font style="font-size:12;color:black"><b>Electric Charges:</b></font>
    <input type="hidden" name="hd2" value="ELECTRIC CHARGES"></td>
    <td><input type="text" name="amount2" value="0.00"></td></tr>   
<tr><td><font style="font-size:12;color:black"><b>Utensil Fee:</b></font>
    <input type="hidden" name="hd3" value="UTENSIL FEE"></td>
    <td><input type="text" name="amount3" value="0.00"></td></tr>    
<tr><td><font style="font-size:12;color:black"><b>Food Advance:</b></font>
    <input type="hidden" name="hd4" value="FOOD ADVANCE"></td>
    <td><input type="text" name="amount4" value="0.00"></td></tr>    
<tr><td><font style="font-size:12;color:black"><b>Monthly Food Bill:</b></font>
    <input type="hidden" name="hd5" value="MONTHLY FOOD BILL"></td>
    <td><input type="text" name="amount5" value="0.00"></td></tr>    
<input type="hidden" name="type" value="add">
<tr><td align="center" colspan="2"><input type="submit" value="Submit"></td></tr> 
</table>       
</form>   
</td></tr>
            </table>
<hr color="maroon"> 
<form name="f2" method="post" action="<%=request.getContextPath()%>/newbeni.do?method=NewBeniDetail"> 
<table align="left">
    <tr><td align="center"><font style="font-size:16;font-weight:bold" color="darkblue">Update New Beni Details</font></td></tr>
    <tr>
        <td style="padding-left: 220px">
            <% if(heads.size()!=0){%>
            <table border="1" style="border-collapse: collapse" width="500">
               <%if(request.getAttribute("msg1")!=null){%>
                <tr><td colspan="2"><font color="yellow"><b><%=request.getAttribute("msg1")%></b></font></td></tr>   
                <%}%>
                <%
                    for(int i=0;i<heads.size();i++)
                        {
                        
                %>
                <tr><td><font style="font-size:12;color:black"><b><%=heads.get(i)%>:</b></font>
                        <input type="hidden" name="hd<%=i%>" value="<%=heads.get(i)%>"></td>
                    <td><input type="text" name="amount<%=i%>" value="<%=hm.get(heads.get(i).toString())%>"></td></tr> 
                <%}%>
                <input type="hidden" name="type" value="update">
                <tr><td colspan="2"><input type="submit" name="update" value="update"></td></tr>
            </table>
        <%}%>
        </td>
    </tr>
</table>
</form> 
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>


