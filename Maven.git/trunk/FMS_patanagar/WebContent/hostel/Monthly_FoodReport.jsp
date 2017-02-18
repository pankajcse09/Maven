<%-- 
    Document   : Monthly_FoodReport
    Created on : Mar 7, 2015, 10:26:02 PM
    Author     : kapil
--%>
<%@page import="pant.hostel.student.HostelDB"%>
<%@page import="pant.common.UtilityDB"%>
<%
String loginfor="";
if(session.getAttribute("loginfor")!=null){
    loginfor=(String)session.getAttribute("loginfor");
}
SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    String ss[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
%>
<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<%     
SchoolEO seo=null;  
int curpage=1;
 int noOfPages=1;
 int offset=0;
if(request.getAttribute("currentPage")!=null)
    {
       curpage=Integer.parseInt(request.getAttribute("currentPage").toString());
     }
if(request.getAttribute("noOfPages")!=null)
    {
       noOfPages=Integer.parseInt(request.getAttribute("noOfPages").toString());
  }
 if(request.getAttribute("offset")!=null)
     {
       offset=Integer.parseInt(request.getAttribute("offset").toString());
   }

 String ssn=request.getParameter("session");
 String month=request.getParameter("month");
 String hostel_code="";
 if(request.getAttribute("hostel_code")!=null){
     hostel_code=(String)request.getAttribute("hostel_code");
 }
 HostelBean hb=new HostelBean();
 if(!hostel_code.equals("ALL")){
     HostelDB hdb=new HostelDB();
        hb=hdb.hostelByCode(hostel_code);
 }
 else{
     hb.setHostelCode(hostel_code);
     hb.setHostelName(hostel_code);
 }
 
 ArrayList al=new ArrayList();
 if(request.getAttribute("list")!=null){
     al=(ArrayList)request.getAttribute("list");
 }
 SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
 DecimalFormat df = new DecimalFormat("0.00");
try{
    
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
<title>Hostel Food Bill</title>
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
<tr><td align="center" width="100%" style="padding-top:0px" height="100">
 <%if(loginfor.equals("hostel")){%>
     <%@include file="/hostel/HostelToplook.jsp"%>   
  <%}else{%>
  <%@include file="/fee/toplook_1.jsp"%>
  <%}%>
    </td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
          <% if(loginfor.equals("hostel")){     %>
     <%@include file="/hostel/Hostel_ReportMenu.jsp"%>   
  <%}else{%>
  <%@include file="/fee/reports.jsp" %>
  <%}%>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
 <form name="f1" method="post" action="<%=request.getContextPath()%>/monthlyFoodBillReport.do?method=monthlyFoodBill">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Food Bill Report</font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
 <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>   
<table width="35%" align="center">
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
                <option value="<%=next%>"><%=next%></option>
                <option value="<%=prev%>"><%=prev%></option>
            </select></td>
    <td valign="top"><font style="font-size:12;color:white"><b>Month</b></font></td>
        <td>
            <select name="month">
                <option value="ALL">ALL</option>
                <%for(int i=0;i<ss.length;i++)
                {
                %>
                <option value="<%=ss[i]%>"><%=ss[i]%></option>
                <%}%>
             </select> 
        </td></tr>
    
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Hostel</b></font></td>
       <% if(loginfor.equals("hostel")){
        %>
        <td><input type="text" name="hcode" value="<%=session.getAttribute("hostel_name")%>" readonly style="background-color: #DCBEBA"></td>
    
    <%}else
        {
           UtilityDB udb=new UtilityDB();
           ArrayList list=udb.hostelList(); 
           %>
           <td><select name="hcode">
                   <option value="ALL">ALL</option>
           <%for(int i=0;i<list.size();i++){
               HostelBean hb1=(HostelBean)list.get(i);
        %>
        <option value="<%=hb1.getHostelCode()%>"><%=hb1.getHostelName()%></option>
            <%}%>
                </select></td>
                <%}%></tr>
    <tr><td></td><td><input type="submit" value="Go"></td></tr>    
</table> 
</form>
    <hr color="maroon">
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>    
<%if(al.size()!=0){%>
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
    <table width="97%" align="center">
       <tr><td style="padding-left: 0px" aligm="left">
               <h2><font color="darkblue" size="3"><u><b>Total Food Bill Posted</b></u></font></h2></td></tr> 
</table>
<table width="97%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td colspan="9">
            <font style="font-size:14;font-weight:bold">Session:</font>&nbsp;&nbsp;<%=ssn%> 
            <font style="font-size:14;font-weight:bold">Month :</font>&nbsp;&nbsp;<%=month%> 
            <font style="font-size:14;font-weight:bold">Hostel:</font>&nbsp;&nbsp;<%=hb.getHostelName()%>
            </td></tr>

<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">Batch</font></td>
<td><font style="font-size:12;font-weight:bold">Student Id</font></td>
<td><font style="font-size:12;font-weight:bold">Student Name</font></td>
<td><font style="font-size:12;font-weight:bold">Programme</font></td>
<td><font style="font-size:12;font-weight:bold">Hostel</font></td> 
<td><font style="font-size:12;font-weight:bold">Month</font></td> 
<td><font style="font-size:12;font-weight:bold">Bill Generation Date</font></td> 
<td align="right"><font style="font-size:12;font-weight:bold">Amount</font></td></tr>
<% 
double tt=0;
for(int i=0;i<al.size();i++)
       {
    seo=(SchoolEO)al.get(i);
    tt=tt+seo.getMonthlyFood();
    hb=seo.getHostelBean();
%>
<tr><td><%=++offset%></td>
<td>
    <%if(seo.getBatch()!=null){%>
    <%=seo.getBatch()%>
<%}else{%>NA<%}%></td>
<td><%=seo.getStud_id()%></td>
<td><%=seo.getSname()%></td>
<td><%=seo.getDegree()%></td>
<td><%=hb.getHostelName()%></td>
<td><%=seo.getMonth()%></td>
<td><%=sdf1.format(seo.getDate())%></td>
<td align="right"><%=df.format(seo.getMonthlyFood())%></td>
<%}%>
<tr><td colspan="8" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td>
<td align="right"><b><%=df.format(tt)%></b></td></tr>
</table>
<table width="70%" align="center">
    <tr><td colspan="2" height="10"></td></tr>
    <tr>
           <%if(noOfPages>=1){%>
           <td width="50%" align="left">
              <%if(curpage<noOfPages){%>
                <a href="./monthlyFoodBillReport.do?method=monthlyFoodBill&page=<%=curpage+1%>&session=<%=ssn%>&month=<%=month%>&hcode=<%=hostel_code%>">
                     <strong>Older</strong>
                          </a>
                 <%}%>
        </td>
        <td width="50%" align="right">
            <%if(curpage>1){%>
              <a href="./monthlyFoodBillReport.do?method=monthlyFoodBill&page=<%=curpage-1%>&session=<%=ssn%>&month=<%=month%>&hcode=<%=hostel_code%>">
                     <strong>Newer</strong>
                     </a>
                 <%}%>
        </td>
        
                 <%}%>
            </tr></table>
</div>                 
  <%}else
  {
  if(request.getParameter("bank")!=null){
  %>
<table width="70%" align="center"><tr><td width="100%" align="center">
            <font color="yellow" size="2"><b>Details is not found </b></font></td></tr></table>   
<%}}%>
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>


