<%-- 
    Document   : NodusedExcelData
    Created on : Jan 21, 2015, 12:39:06 PM
    Author     : kapil
--%>
<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 

SchoolEO seo=new SchoolEO();  
String filename="";
if(request.getAttribute("filename")!=null){
    filename=(String)request.getAttribute("filename");
}
int listSize=-1;
  ArrayList list=new ArrayList();
  if(request.getAttribute("list")!=null)
   {
    list=(ArrayList)request.getAttribute("list");
    listSize=list.size();
    }
 String date1="";
 if(request.getAttribute("date1")!=null){
    date1=(String)request.getAttribute("date1");
}
 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
try{

    DecimalFormat df = new DecimalFormat("0.00");
%>
<html>
    <head>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>Noduesed Student</title>
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
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Reports/Fee Reports</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<form name="f1" method="post" action="<%=request.getContextPath()%>/noduesExcelData.do?method=neList">
    <table width="30%" align="center" valign="top" style="padding-top: 0px;">
        <tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3"><b>Nodues Student List</b></font></td></tr>
        <tr><td align="left" style="padding-right: 20px">
                <font style="font-size:12" color="white"><b>Date</b></font><script>DateInput('dated1',true,'dd/mm/yyyy')</script></td></tr>
        <tr><td><input type="submit" name="submit" value="Retreive"></td></tr>
    </table>
</form>
<hr color="maroon">

<% if(listSize!=0&&listSize!=-1)
{%>
<table border="1" style="border-collapse: collapse" width="80%" align="center">
    <tr><td><b>Sr. no</b></td>
        <td align="center"><b>Student Name</b></td>
        <td align="center"><b>Student Id</b></td><td><b>Session</b></td>
        <td align="center"><b>Submitted Amount</b></td><td align="center"><b>Nodues Date</b></td>
    <td align="center"><b>Programme</b></td>
    <td align="center"><b>Transaction Id</b></td>
    <td align="center"><b>Contact</b></td>
    </tr>
    <%for(int i=0;i<listSize;i++)
        {
           seo=(SchoolEO)list.get(i); 
         %>
    <tr><td>
           <%=i+1%>
         </td>
         <td><%=seo.getSname()%></td>
        <td><%=seo.getStud_id()%></td>
        <td><%=seo.getSession()+"-"+seo.getSession_sem()%></td>
        <td align="right"><%=df.format(seo.getFeeTotal())%></td>
        <td align="left"><%=sdf.format(seo.getDate())%> </td>
         <td align="left"><%=seo.getDegree()%> </td>
         <td align="left"><%=seo.getTransaction_id()%>  <%if("".equals(seo.getTransaction_id()))out.print("NA");%>
         </td>
         <td align="left"><%=seo.getMobile()%> 
             <%if("".equals(seo.getMobile()))out.print("NA");%>
         </td>
     </tr>
      <%}%>
</table>
      <table width="60%" align="center">
          <tr><td align="right"><a href="<%=request.getContextPath()%>/noduesed_excel/<%=filename%>"><%=filename%></a></td></tr>
      </table>
<%}
          else if(listSize==0){
    %>
    <table width="30%" align="center" valign="top" style="padding-top: 20px;padding-bottom: 20px"><tr>
            <td colspan="2" align="center" valign="top">
    <b>No student found for date <%=date1%>. </b>
            </td></tr></table>
    <%}%>
           </td></tr>      
</table></td></tr>
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
//out.println("Exc: "+e.getMessage());
}%>
