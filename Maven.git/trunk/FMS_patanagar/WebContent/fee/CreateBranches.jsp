<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*,Beans.*"%>
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
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>       
       <script>
           function validate(){    
           if(document.forms[0].elements["stream"].value=="SELECT"){
           alert("Enter Stream");
           document.forms[0].elements["stream"].focus();
           return false;
           }
           if(document.forms[0].elements["class"].value==""){
           alert("Enter class");
           document.forms[0].elements["class"].focus();
           return false;
           }
           return true;
           }    
        </script>    
     </head>
    <body onload="document.forms[0].elements[0].focus();" bgcolor="#999933">
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
    <tr><td align="center"><font style="font-size:16;font-weight:bold" color="darkblue">Create Branches</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px">
<form method="post" action="<%=request.getContextPath()%>/BranchAction.do?method=branchAction" onsubmit="return validate();">   
<table  align="center" border="1" style="border-collapse:collapse" width="500">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>   

<tr><td><font style="font-size:12;color:black"><b>Select Degree</b></font></td><td>
<select name="degree" style="width: 106px">
    <option value="select one">select one</option>
    <%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}%>
 <!--<option value="BTECH">BTECH</option>-->   


</select>   
</td></tr>    
   

<tr><td><font style="font-size:12;color:black"><b>Select Course Semester/Yearly</b></font></td><td>
<select name="duration">
    <option value="Four Year">select one</option>
   <option value="I Semester">I Semester</option>
<option value="II Semester">II Semester</option>
<option value="III Semester">III Semester</option>
<option value="IV Semester">IV Semester</option>
<option value="V Semester">V Semester</option>
<option value="VI Semester">VI Semester</option>
<option value="VII Semester">VII Semester</option>
<option value="VIII Semester">VIII Semester</option>
<option value="IX Semester">IX Semester</option>
<option value="X Semester">X Semester</option>

<option value="One Year">One Year</option>

<option value="Two Year">Two Year</option>

<option value="Three Year">Three Year</option>
<option value="Four Year">Four Year</option>
<option value="Five Year">Five Year</option>



</select>   
</td></tr>    
<tr><td><font style="font-size:12;color:black"><b>Create Branch</b></font></td><td><input type="text" name="branch" size="40"></td></tr>   
<tr><td align="center" colspan="2"><input type="submit" value="Submit"></td></tr> 
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

