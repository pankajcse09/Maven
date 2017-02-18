<%-- 
    Document   : ViewEditHostel
    Created on : Mar 1, 2015, 12:54:19 PM
    Author     : kapil
--%>

<%@page import="EO.HostelBean"%>
<%@page import="EO.CollegeBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*" %>
<%@page import="com.myapp.struts.Dataconnectivity,EO.SchoolEO"%>

<!DOCTYPE html>
<html>  
<head>
<style type="text/css">.t{border-collapse:collapse}</style>
<script language="javascript" src="<%=request.getContextPath()%>/UnitTest/printData.js"></script>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <title>Hostel</title>
</head>
<body bgcolor="#999933">
    <%  
 ArrayList al=new ArrayList();
 HostelBean hb=new HostelBean();
 HostelBean hb1=new HostelBean();
 if(request.getAttribute("list")!=null){
     al=(ArrayList)request.getAttribute("list");
 }
 if(request.getAttribute("hostelbean")!=null){
     hb1=(HostelBean)request.getAttribute("hostelbean");
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
   
   input[type=button]:visited {
       background-color: green;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 664px;
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
<table style="padding-left: 350px">
<tr><td  valign="top" colspan="100%" align="center"><font style="font-size:18;font-weight:bold;color:darkblue">Update Last Date Of Fee Submission</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px"> 
  <form action="updateHostel.do?method=updateHostel" method="post">
       <table  align="center" border="1" style="border-collapse:collapse" width="500" bgcolor="#FFFFCC">
 <%if(request.getAttribute("msg")!=null){%>
 <tr><td colspan="4" align="center"><font color='red'><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
     <tr>
         <td class="tdcolor1" colspan="1"><b>Hostel Name</b></td>
         <td class="tdcolor1" colspan="1"><b>Hostel Code</b></td>
         <td class="tdcolor1"></td>
     </tr>    
<%for(int i=0;i<al.size();i++){
hb=(HostelBean)al.get(i);

if(hb1.getRid()==hb.getRid())
       {
%>
<tr><td colspan="5">
        <table border="0" align="center">
            <tr><td>Hostel Name</td><td><input type="text" name="hostel_name" value="<%=hb1.getHostelName()%>"></td></tr>
                <tr><td>Hostel Code</td><td><input type="text" name="hostel_code" value="<%=hb1.getHostelCode()%>"></td></tr>
                <input type="hidden" name="id" value="<%=hb1.getRid()%>">
                <tr><td colspan="2" align="center"><input type="submit" value="update"></td></tr>
         </table>
    </td></tr>
<%}else{%>
<tr>
    <td><%=hb.getHostelName()%></td>
<td><%=hb.getHostelCode()%></td>
<td align="center">
    <%if(urb.getUr_update().equals(s)){%>
    <a href="<%=request.getContextPath()%>/editHostel.do?method=viewHostel&id=<%=hb.getRid()%>">
        <font style="font-size:12;color:blue"><b>Edit</b></font></a>&nbsp;&nbsp;&nbsp;
        <%}if(urb.getUr_delete().equals(s)){%>
<a href="<%=request.getContextPath()%>/delHostel.do?method=delHostel&id=<%=hb.getRid()%>">
    <font style="font-size:12;color:blue"><b>Delete</b></font></a>
<%}%>
</td>
</tr>
<%}}%>
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

