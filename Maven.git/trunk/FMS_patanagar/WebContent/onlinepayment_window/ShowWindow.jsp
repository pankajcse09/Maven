<%-- 
    Document   : ShowWindow
    Created on : May 25, 2015, 12:39:16 AM
    Author     : kapil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.JavaBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="onlinepayment.OnlinePaymentWindow"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf1.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
List<OnlinePaymentWindow> list=null;
if(request.getAttribute("list")!=null){
    list=(List)request.getAttribute("list");
}

JavaBean de=new JavaBean();
   List degreelist=new ArrayList();
if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
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
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/jquery.min.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
         <script language="javascript">
             function validate(){
                 if(document.f1.session.value==""){
                     alert("Please select session.");
                     document.f1.session.focus();
                     return false;
                 }
                 if(document.f1.session_sem.value==""){
                     alert("Please select session semester.");
                     document.f1.session_sem.focus();
                     return false;
                 }
                 if(document.f1.degree.value==""){
                     alert("Please select degree.");
                     document.f1.degree.focus();
                     return false;
                 }
                 if(document.f1.from.value==""){
                     alert("Please choose from date.");
                     document.f1.from.focus();
                     return false;
                 }
                 if(document.f1.to.value==""){
                     alert("Please choose to date.");
                     document.f1.to.focus();
                     return false;
                 }                
             }
         </script>
         <script language="javascript">
             function editWindow(a){
                 var fm=document.getElementById("submitForm");
                 document.getElementById("windowId").value=a;
                 fm.submit();
                 
             }
         </script>
<title>Online Payment Window</title>
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
 <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/utility/rolesmenu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
                 <table width="60%" align="center">
                     <tr><td height="40" ></td></tr>
                      <%if(request.getAttribute("msg")!=null){%>
                     <tr><td align="left"><font color="yellow" size="3"><b>
                                <%=request.getAttribute("msg")%>  </b></font></td></tr>
                     <%}%>
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">Online Payment Window For Degree</font></td></tr>
                 </table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/saveWinData.do?method=saveWindowData" onsubmit="return validate();">
<table width="70%" align="center" bgcolor="lightyellow" border="0">
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Session</td>
    <td>
        <select name="session">  
            <option value="">Select one</option>
            <option value="<%=next%>"><%=next%></option>
            <option value="<%=prev%>"><%=prev%></option>
        </select>
    </td></tr>
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Session Semester</td>
    <td>
        <select name="session_sem"> 
            <option value="">Select one</option>
            <option value="I">I</option>
            <option value="II">II</option>
        </select>
    </td></tr>
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Degree</td>
    <td>
       <select name="degree"> 
<option value="">Select one</option> 
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}%>
</select>
    </td></tr>
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">From Date</td>
    <td>
       <script>DateInput('from',true,'dd/mm/yyyy')</script>
    </td></tr>
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">To Date</td>
    <td>
       <script>DateInput('to',true,'dd/mm/yyyy')</script>
    </td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
</table>   


</form> 
<table>
   <tr><td height="20"></td></tr> 
</table>
<table width="70%" align="center" border="1" style="border-collapse: collapse">
    <tr>
        <td><b>Sr.No.</b></td>
        <td><b>Session</b></td>
        <td><b>Session Semester</b></td>
        <td><b>Degree</b></td>
        <td><b>From Date</b></td>
        <td><b>To Date</b></td>
        <td><b>Edit</b></td>
        <td><b></b></td>
    </tr>
    <%
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    int index=1;
    if(list!=null&&list.size()>0){
        for(OnlinePaymentWindow onlinePaymentWindow : list){
            %>
            <tr>
                <td><%=index%></td>
                <td><%=onlinePaymentWindow.getSession()%></td>
                <td align="center"><%=onlinePaymentWindow.getSession_sem()%></td>
                <td><%=onlinePaymentWindow.getDegree()%></td>
                <td><%=sdf.format(onlinePaymentWindow.getFrom())%> </td>
                <td><%=sdf.format(onlinePaymentWindow.getTo())%> </td>
                <td align="center"><a href="javascript:;" onclick="editWindow('<%=onlinePaymentWindow.getRowid()%>')">edit</a></td>
                <td></td>
            </tr>
       <%}
        index++;
    }%>
</table>
</td></tr></table>
<form id="submitForm" action="editWindowDetail.do?method=windowData" method="post">
    <input type="hidden" id="windowId" name="windowId">
</form>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>

