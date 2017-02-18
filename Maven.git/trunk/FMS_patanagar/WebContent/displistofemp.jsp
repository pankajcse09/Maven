<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="java.util.*"%>

   

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
             <td valign="top" align="left"><table>
                <tr><td>
     <table width="100%" align="center">
         <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>List Of Employees</b></font></td></tr>
     </table></td></tr>
                <tr><td style="padding-left: 50px">
 
    <form  method="post" action="listofstud.do">
<table cellpadding="0" cellspacing="0" width="800" height=180><tr><td valign="top">  
<table>

   
  <%int k=0;%>  
 
<table border="1" width="80%" align="center" bgcolor="#FFFFCC"> 
 <tr>
<td class="tdcolor1"><font size="2" ><b>SR.No.</b></font></td>
<td class="tdcolor1"><font size="2" ><b>Emp Code</b></font></td>
<td  class="tdcolor1"><font size="2"><b>Name</b></font></td>

</tr>
    
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 JBeanEmp seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
  
   <% for(int i=0;i<arr1.size();i++)
   { seo=(JBeanEmp)arr1.get(i);
%>

<tr>
<td><%=++k%></td>
<td><%=seo.getEmpId()%></td>
<td><%=seo.getEmpName()%></td>
</tr>
       
       <%
   } }%>
</table>

       <%
   }catch(Exception e)
       {}%>
  </td></tr></table> 
</form>   
  </td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
