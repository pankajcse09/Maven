<%-- 
    Document   : LateFineReceived
    Created on : Jul 2, 2014, 5:32:10 PM
    Author     : kapil
--%>

<%@page import="Fee.FeeMath"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<!DOCTYPE html>

<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
BigDecimal bd = new BigDecimal(0.00);
SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");

 ReportsEO reo1=new ReportsEO();
 String dt1="";
 String dt2="";
 ArrayList al=new ArrayList();
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
 
    ArrayList ar4=new ArrayList();
    ar4.add("Both");
    ar4.add("I");
    ar4.add("II");
    
 String ssn=request.getParameter("session");
String ssnm=request.getParameter("ssnm");
   

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
         <script type="text/javascript" src="<%=request.getContextPath()%>/JSF/jquery.min.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>Late Fine Report</title>

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

.bt{background-color: green;
    color: #333333;}
         </style> 
 <% 
    String bnk="";
    if(request.getAttribute("bnk")!=null)
               {
        bnk=(String)request.getAttribute("bnk");
    }
   ArrayList banklist=new ArrayList();
        FeeMath fm=new FeeMath();
        banklist=fm.bankList();
    
    %>   
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

<form name="f1" method="post" action="<%=request.getContextPath()%>/lfinereceived.do?method=lfine_received" onsubmit="return validate()">
<table width="65%" align="center" border="0" style="border-collapse:collapse">
    <tr><td><h2><font color="darkblue" size="3"><u><b>Total Late Fine Received</b></u></font></h2></td></tr>
<tr><td><font style="font-size:12;font-weight:bold" color="white">Session</font><br>
<select name="session">
<%
int ss=0;
for(int i=0;i<=7;i++)
{
    ss=Syear-i;
    %>
<option value="<%=ss%>-<%=ss+1%>"><%=ss%>-<%=ss+1%></option>
<%}%>
</select>
<select name="ssnm"> 
<%for(int i=0;i<ar4.size();i++){
%>    
<option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>    
<%}%>
</select>
    </td>     
<td align="left"><font style="font-size:12" color="white"><b>Bank</b></font><br>
                    <select name="bank">
                <option value="">select</option>
                <option value="ALL">ALL</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td>
    <td><br><input type="submit" value="Submit"></td></tr></table>
</form>
<hr color="maroon">  
<%if(al.size()!=0){%>
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
    <table width="97%" align="center">
       <tr><td style="padding-left: 0px" aligm="left">
               <h2><font color="darkblue" size="3"><u><b>Total Late Fine Received</b></u></font></h2></td></tr> 
</table>
<table width="97%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td colspan="8">
            <font style="font-size:14;font-weight:bold">Session:</font>&nbsp;&nbsp;<%=ssn%> -<%=ssnm%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <font style="font-size:14;font-weight:bold">Bank:</font>&nbsp;&nbsp;<%=bnk%>
            </td></tr>

<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">Batch</font></td>
<td><font style="font-size:12;font-weight:bold">Student Id</font></td>
<td><font style="font-size:12;font-weight:bold">Student Name</font></td>
<td><font style="font-size:12;font-weight:bold">Programme</font></td>
<td><font style="font-size:12;font-weight:bold">Deposit Date</font></td> 
<td><font style="font-size:12;font-weight:bold">Bank</font></td> 
<td align="right"><font style="font-size:12;font-weight:bold">Fine</font></td></tr>
<% 
double tt=0;
for(int i=0;i<al.size();i++)
       {
    reo1=(ReportsEO)al.get(i);
    tt=tt+reo1.getFine();
%>
<tr><td><%=++offset%></td>
<td><%=reo1.getBatch()%></td>
<td><%=reo1.getStud_id()%></td>
<td><%=reo1.getSname()%></td>
<td><%=reo1.getDegree()%></td>
<td><%if(reo1.getDate1()!=null){%>
    <%=sdf1.format(reo1.getDate1())%>
<%}else{%>
NA
<%}%>
</td>
<td><%=reo1.getBank()%></td>
<td align="right"><%=df.format(reo1.getFine())%></td></tr> 
   <%}%>
<tr><td colspan="7" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td>
<td align="right"><b><%=df.format(tt)%></b></td></tr>
</table>

</div>                 
  <%}else
  {
  if(request.getParameter("bank")!=null){
  %>
<table width="70%" align="center"><tr><td width="100%" align="center">
            <font color="yellow" size="2"><b>Details is not found for <%=ssn%> -<%=ssnm%> and bank <%=bnk%></b></font></td></tr></table>   
<%}}%>           
        
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>