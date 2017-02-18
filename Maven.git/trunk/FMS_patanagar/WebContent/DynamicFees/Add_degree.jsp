<%-- 
    Document   : Add_degree
    Created on : Jul 5, 2013, 3:33:51 PM
    Author     : kapil
--%>

<%@page import="EO.CollegeBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*,Beans.*"%>
<%@page import="User_Role.User_role_bean"%>
<!DOCTYPE html>
<%response.setHeader("Cache-Control","no cache");%>
<% 
JavaBean jb=new JavaBean();
jb.setStream("SELECT");
if(request.getAttribute("jbean")!=null){
jb=(JavaBean)request.getAttribute("jbean");    
}
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
           if(document.forms[0].elements["college"].value==""){
           alert("Select College.");
           document.forms[0].elements["college"].focus();
           return false;
           }
           return true;
           }    
        </script>    
     </head>
    <body onload="document.forms[0].elements['degree'].focus();" bgcolor="#999933">
    <%
        JavaBean de=new JavaBean();
        ArrayList degreelist=new ArrayList();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
        
     ArrayList al=new ArrayList();
      CollegeBean cb=null;
    if(request.getAttribute("list")!=null){
        al=(ArrayList)request.getAttribute("list");
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
 <%
if(urb.getUr_create().equals(s)){%>
                 <table><tr><td>
<table style="padding-left: 400px">
    <tr><td align="center"><font style="font-size:16;font-weight:bold" color="darkblue">Add Degree</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 220px">
<form method="post" action="<%=request.getContextPath()%>/degreeAction.do?method=addDegree" onsubmit="return validate();">   
<table  align="center" border="1" style="border-collapse:collapse" width="500">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>   

<tr><td><font style="font-size:12;color:black"><b>Enter Degree:</b></font></td>
    <td><input type="text" name="degree">  
</td></tr>    
   

<tr><td><font style="font-size:12;color:black"><b>Enter Degree Code:</b></font></td>
    <td><input type="text" name="degcode"></td></tr>    
<tr><td><font style="font-size:12;color:black"><b>Select College:</b></font></td>
    <td>
        <select name="college">
            <option value="">Select One</option>
            <% for(int i=0;i<al.size();i++){
                cb=(CollegeBean)al.get(i);
            %>
            <option value="<%=cb.getCollegeCode()%>"><%=cb.getCollegeName()%></option>
            <%}%>
        </select>
    </td></tr>
<tr><td><font style="font-size:12;color:black"><b>Self Finance Degree:</b></font></td>
    <td><input type="radio" name="self" value="No" checked>No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="self" value="Yes">Yes</td></tr>    

<tr><td align="center" colspan="2"><input type="submit" value="Submit"></td></tr> 
</table>       
</form>   
</td></tr>
            </table>
<hr color="maroon"> 
<%}%>

<table align="center">
    <tr><td>
<table style="padding-left: 300px">
    <tr><td align="center"><font style="font-size:16;font-weight:bold" color="darkblue">View Degree</font></td></tr>
</table></td></tr>
    <tr>
        <td><table border="1" style="border-collapse: collapse">
                <tr align="center"><td width="40"><b>Sr no.</b></td><td width="100"><b>Degree Code</b></td><td width="200"><b>Degree</b></td>
                    <td width="150"><b>Self Finance Degree</b></td><td width="200"><b>College</b></td><td width="80"><b></b></td></tr>
                <% if(degreelist.size()!=0){
                    for(int i=0;i<degreelist.size();i++)
                        {
                        de=(JavaBean)degreelist.get(i);
                %>
                <tr align="center"><td><%=i+1%></td><td><%=de.getDegcode()%></td><td><%=de.getDegree()%></td><td><%=de.getType()%></td>
                    <td><%=de.getCollege()%></td>
                    <td>
                    <%if(urb.getUr_delete().equals(s)){%>
                    <a href="<%=request.getContextPath()%>/delDgree.do?method=deldegree&id=<%=de.getRwid()%>">Delete</a>
                    <%}%>
                    </td>
                </tr>
                <%}}%>
            </table></td>
    </tr>
</table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>


