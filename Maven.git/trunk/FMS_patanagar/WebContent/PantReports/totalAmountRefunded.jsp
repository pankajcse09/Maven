<%-- 
    Document   : totalAmountRefunded
    Created on : Jul 8, 2013, 2:24:06 PM
    Author     : kapil
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.*,ActionClass.*,EO.*"%>
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
 String total="";

 ArrayList al=new ArrayList();
 if(request.getAttribute("total")!=null)
         {
     total=(String)request.getAttribute("total");
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
 String ssn=request.getParameter("session");
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
<title>Draft Refund</title>
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
    <tr><td style="padding-left: 390px"><h2><font color="darkblue" size="3"><u><b>Total Refunded Draft Amount</b></u></font></h2></td></tr> 
</table>
     <form name="f1" method="post" action="<%=request.getContextPath()%>/totalAmountRef.do?method=totalRefund">
<table width="20%" align="center"><tr><td width="100%" align="center">
            
            <tr>
                <td><font style="font-size:12;font-weight:bold" color="white">Session</font>
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
    </td><td><input type="submit" value="Submit"></td>
            </tr>   
</table>    
</form> 
<hr color="maroon">  
<%if(al.size()!=0){%>
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
    <table width="70%" align="center">
       <tr><td style="padding-left: 0px" aligm="left"><h2><font color="darkblue" size="3"><u><b>Total Refunded Amount:</b></u></font>&nbsp;&nbsp; <font size="3"><%=total%></font></h2></td></tr> 
</table> 
<% bd=new BigDecimal(total);
        bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat df = new DecimalFormat("#.00");
        %>
<table width="70%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td colspan="6">
            <font style="font-size:14;font-weight:bold">Session:</font>&nbsp;&nbsp;<%=ssn%>&nbsp;&nbsp;
            </td></tr>

<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">DRAFT</font></td>
<td><font style="font-size:12;font-weight:bold">BANK</font></td>

<td><font style="font-size:12;font-weight:bold">NAME</font></td>
<td><font style="font-size:12;font-weight:bold">ROLL NO.</font></td> 
<td><font style="font-size:12;font-weight:bold">AMOUNT</font></td></tr>
<% 
double tt=0;
for(int i=0;i<al.size();i++)
       {
    reo1=(ReportsEO)al.get(i);
    tt=tt+reo1.getAmount();
%>
<tr><td><%=++offset%></td>
<td><%=reo1.getNumber()%></td>
<td><%=reo1.getBank()%></td>

<td><%=reo1.getSname()%></td>
<td><%=reo1.getSrnum()%></td>
<td align="right"><%=df.format(reo1.getAmount())%></td></tr> 
   <%}%>
<tr><td colspan="5" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td><td align="right"><b><%=df.format(tt)%></b></td></tr>
</table>
<table width="70%" align="center">
    <tr><td colspan="2" height="10"></td></tr>
    <tr>
           <%if(noOfPages>=1){%>
           <td width="50%" align="left">
                 <%if(curpage<noOfPages){%>
                 <a href="./totalAmountRef.do?method=totalRefund&page=<%=curpage+1%>&session=<%=ssn%>">
                     <strong>Older</strong>
                          </a>
                 <%}%>
        </td>
        <td width="50%" align="right">
                <%if(curpage>1){%>
                 <a href="./totalAmountRef.do?method=totalRefund&page=<%=curpage-1%>&session=<%=ssn%>">
                     <strong>Newer</strong>
                     </a>
                 <%}%>
        </td>
        
                 <%}%>
            </tr></table>
</div>                 
 <%}else{%>
<table width="70%" align="center"><tr><td width="100%" align="center">
            <font color="yellow" size="2"><b>Details is not found</b></font></td></tr></table>   
<%}%>             
        
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>