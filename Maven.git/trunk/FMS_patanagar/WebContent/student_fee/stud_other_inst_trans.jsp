<%-- 
    Document   : stud_other_inst_trans
    Created on : Oct 7, 2014, 11:48:05 AM
    Author     : kapil
--%>

<%@page import="EO.ReportsEO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Reports.Reports_DB"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);

    String trans=request.getParameter("trans");
    String pg=request.getParameter("page");
    int rid=0;
    try{
        rid=Integer.parseInt(request.getParameter("rid"));
    }catch(NumberFormatException nf){}
         ArrayList ar4=new ArrayList();
         ar4.add("I");
         ar4.add("II");
    ReportsEO reo=new ReportsEO();  
    Reports_DB rdb=new Reports_DB();
    reo=rdb.getOtherCollegeStudent(rid);
    SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    try{
        DecimalFormat df = new DecimalFormat("0.00");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
        <title>College Management System</title>
<script language="JavaScript">     
function validate(){
    if(document.f1.elements["session_sem"].value==""){
alert("Please select semester of this session.");
document.f1.elements["session_sem"].focus();
return false;
 }
return true;
}
</script> 
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
<tr><td align="center" width="100%" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
<form name="f1" method="post" action="<%=request.getContextPath()%>/TrStudAmount.do?method=tranfserStudAm" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkblue" size="4"><b>Transfer Student Details Of Other College</b></font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>
<table width="35%" align="center">
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td><td><%=reo.getStud_id()%></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Name</b></font></td><td><%=reo.getSname()%></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Programme</b></font></td><td><%=reo.getDegree()%></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Amount</b></font></td><td><%=reo.getAmount()%></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Deposit Date</b></font></td><td><%=sde.format(reo.getDate1())%></td></tr>
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td><td><%=reo.getSession()%> (<%=reo.getSession_sem()%>)</td></tr>
   <tr><td align="left"><font style="font-size:12" color="white"><b>Transfer To</b></font></td>
        <td><input type="text" name="trans_to"> </td></tr>
    <input type="hidden" name="trans" value="<%=trans%>">
    <input type="hidden" name="page" value="<%=pg%>">
    <input type="hidden" name="rid" value="<%=reo.getRwid()%>">
    <tr><td></td><td><input type="submit" name="type" value="Transfer"></td></tr>
  </table>  
</form>
    <hr color="maroon">
    
    
   </td></tr>
            
</table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>
