<%-- 
    Document   : dateWiseAmount
    Created on : Jul 8, 2013, 12:22:38 PM
    Author     : kapil
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.*,ActionClass.*,EO.*"%>
 <!DOCTYPE html>
<% 
BigDecimal bd = new BigDecimal(0.00);
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
 int k=0;
 MyMeth mm=new MyMeth();
 ArrayList ar2=(ArrayList)mm.retriveAllClass();
 SchoolEO seo=new SchoolEO();
  SchoolEO seo1=new SchoolEO();
 if(request.getAttribute("seo")!=null){
 seo=(SchoolEO)request.getAttribute("seo");    
 }
 String total="";
 String dt1="";
 String dt2="";
 ArrayList al=new ArrayList();
 if(request.getAttribute("total")!=null)
         {
     total=(String)request.getAttribute("total");
 }
 if(request.getAttribute("date1")!=null)
         {
    dt1=(String)request.getAttribute("date1");
 }
 if(request.getAttribute("date2")!=null)
         {
    dt2=(String)request.getAttribute("date2");
 }
 if(request.getAttribute("list")!=null)
         {
     al=(ArrayList)request.getAttribute("list");
 }
 try{
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Reports/Fee Reports</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<table>
    <tr><td style="padding-left: 390px"><h2><font color="darkblue" size="3"><u><b>DataWise Advance Amount List</b></u></font></h2></td></tr> 
</table>
 
<form name="f1" method="post" action="<%=request.getContextPath()%>/retDateWiseAdv.do?method=retDateWiseAdv">
<table width="30%" align="center"><tr><td width="100%" align="center">
            <tr><td align="left"><font style="font-size:12" color="white"><b>Date1</b></font></td>
                <td align="left"><script>DateInput('dated1',true,'dd/mm/yyyy')</script></td>
                <td align="right"><font style="font-size:12" color="white"><b>&nbsp;&nbsp;&nbsp;Date2</b></font></td>
                <td align="right"><script>DateInput('dated2',true,'dd/mm/yyyy')</script></td>
                <td><input type="submit" value="Submit"></td>
            </tr>    
</table>    
</form> 
<hr color="maroon"> 
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
    <table width="70%" align="center">
    <tr><td style="padding-left: 0px" align="center"><h2><font color="darkblue" size="3"><u><b>DataWise Advance Amount List</b></u></font></h2></td></tr> 
</table>
     <% bd=new BigDecimal(total);
        bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat df = new DecimalFormat("#.00");
        %>
<table width="90%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
    <tr><td colspan="9"><font style="font-size:12;font-weight:bold">Date:&nbsp;&nbsp;<%=dt1%>&nbsp;&nbsp;To&nbsp;&nbsp;<%=dt2%></font></td></tr>
<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">DRAFT</font></td>
     <td><font style="font-size:12;font-weight:bold">DRAFT DATE</font></td>
<td><font style="font-size:12;font-weight:bold">BANK</font></td>
<td><font style="font-size:12;font-weight:bold">RECEIVE DATE</font></td>
<td><font style="font-size:12;font-weight:bold">NAME</font></td>
<td><font style="font-size:12;font-weight:bold">STUDENT ID</font></td>
<td><font style="font-size:12;font-weight:bold">ROLL NO.</font></td>
<td><font style="font-size:12;font-weight:bold">AMOUNT</font></td></tr>    
<% 

for(int i=0;i<al.size();i++)
       {
    seo1=(SchoolEO)al.get(i);
%>
<tr><td><%=++k%></td>
<td><%=seo1.getDdno()%></td>
<td><%=seo1.getDdate()%></td>
<td><%=seo1.getBankname()%></td>
<td><%=sdf.format(seo1.getDeposite_date())%> </td>
<td><%=seo1.getSname()%></td>
<% if(seo1.getStud_id()!=null&&!seo1.getStud_id().equals("")){%>
<td><%=seo1.getStud_id()%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td><%=seo1.getSrnum()%></td>
<td align="right"><%=df.format(seo1.getDdamount())%></td></tr> 
   <%}%>
<tr><td colspan="8" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td><td><b><%=bd%></b></td></tr>
</table>
</div>
<%}catch(Exception e){}%>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
