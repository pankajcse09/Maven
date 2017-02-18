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
<title>Advance Report</title>

<script language="javascript">

function validate()
{
    
        if(document.f1.elements["bnk_name"].value=="")
        {
            alert("Please Enter Bank name");
           document.f1.elements["bnk_name"].focus();
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
    <% 
    String bnk="";
    if(request.getAttribute("bnk")!=null)
               {
        bnk=(String)request.getAttribute("bnk");
    }
    ArrayList banklist=new ArrayList();
    if(request.getAttribute("bnklist")!=null)
               {
        banklist=(ArrayList)request.getAttribute("bnklist");
    }
    String ssn=request.getParameter("session");
    String kinds="";
    if(request.getAttribute("kinds")!=null)
               {
        kinds=(String)request.getAttribute("kinds");
    }
    %>
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
<table>
    <tr><td style="padding-left: 390px"><h2><font color="darkblue" size="3"><u><b>BankWise Advance Amount List</b></u></font></h2></td></tr> 
</table>
 
<form name="f1" method="post" action="<%=request.getContextPath()%>/retBankWiseAdv.do?method=retBankWiseAdv" onsubmit="return validate()">
<table width="60%" align="center"><tr><td width="100%" align="center">
       <tr><td colspan="2"><input type="radio" name="kinds" value="Receiving" checked="checked">Draft Receiving Date</td>
        <td colspan="3"><input type="radio" name="kinds" value="Processing">Draft Processing Date</td></tr>     
            <tr>
                <td><font style="font-size:12;font-weight:bold" color="white">Session</font><br>
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
    </td>
                <td width="40%" align="left" style="padding-right: 20px"><font style="font-size:12" color="white"><b>Date1</b></font><br><script>DateInput('dated1',true,'dd/mm/yyyy')</script></td>
                <td width="40%" align="left" style="padding-right: 20px"><font style="font-size:12" color="white"><b>Date2</b></font><br><script>DateInput('dated2',true,'dd/mm/yyyy')</script></td>
                <td align="left"><font style="font-size:12" color="white"><b>Bank</b></font><br>
                    <select name="bnk_name">
                <option value="">select</option>
                <option value="ALL">ALL</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td>
                
                <td><br><input type="submit" value="Submit"></td>
            </tr>   
</table>    
</form> 
<hr color="maroon"> 
<%if(al.size()!=0){%>
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
    <table width="70%" align="center">
    <tr><td style="padding-left: 0px" align="center"><h2><font color="darkblue" size="3"><u><b>BankWise Advance Amount List</b></u></font></h2></td></tr> 
</table>
     <% bd=new BigDecimal(total);
        bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat df = new DecimalFormat("#.00");
        %>
 <table width="90%" align="left" style="">
       <tr><td colspan="9"><font style="font-size:16;font-weight:bold">Total Received:</font>&nbsp;&nbsp;
               <font style="font-size:14;font-weight:bold"><%=bd%></font></td></tr>     
</table> 
<table width="90%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
    <tr><td colspan="11">
            <font style="font-size:14;font-weight:bold">Session:</font>&nbsp;&nbsp;<%=ssn%>&nbsp;&nbsp;
            <font style="font-size:14;font-weight:bold"><%=kinds%>  Date:</font>&nbsp;&nbsp;<%=dt1%>&nbsp;&nbsp;
            <font style="font-size:14;font-weight:bold">To</font>&nbsp;&nbsp;<%=dt2%>&nbsp;&nbsp;&nbsp;&nbsp;
            <font style="font-size:14;font-weight:bold">Bank:</font>&nbsp;&nbsp;<%=bnk%></td></tr>
    
<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">NAME</font></td>
<td><font style="font-size:12;font-weight:bold">ROLL NO.</font></td>
<td><font style="font-size:12;font-weight:bold">STUDENT ID</font></td>
    <td><font style="font-size:12;font-weight:bold">DRAFT</font></td>
    <td><font style="font-size:12;font-weight:bold">DRAFT DATE</font></td>
<td><font style="font-size:12;font-weight:bold">BANK</font></td>
<td><font style="font-size:12;font-weight:bold">RECEIVE DATE</font></td>
<td><font style="font-size:12;font-weight:bold">PROCESSING DATE</font></td>
<td><font style="font-size:12;font-weight:bold">AMOUNT</font></td></tr> 

   
<% 
double tt=0;
for(int i=0;i<al.size();i++)
       {
    reo1=(ReportsEO)al.get(i);
    tt=tt+reo1.getAmount();
%>
<tr><td><%=++offset%></td>
    <td><%=reo1.getSname()%></td>
<td><%=reo1.getSrnum()%></td>
<% if(reo1.getStud_id()!=null&&!reo1.getStud_id().equals("")){%>
<td><%=reo1.getStud_id()%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td><%=reo1.getNumber()%></td>
<td><%=reo1.getDate()%></td>
<td><%=reo1.getBank()%></td>
<td><%=sdf1.format(reo1.getDate1())%> </td>
<% if(reo1.getDate2()!=null){%>
<td><%=sdf1.format(reo1.getDate2())%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td align="right"><%=df.format(reo1.getAmount())%></td></tr> 
<%}%>
<tr><td colspan="9" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td><td align="right"><b><%=df.format(tt)%></b></td></tr>
</table>
<table width="90%" align="center">
    <tr><td colspan="2" height="10"></td></tr>
    <tr>
           <%if(noOfPages>=1){%>
           <td width="50%" align="left">
                 <%if(curpage<noOfPages){%>
                 <a href="./retBankWiseAdv.do?method=retBankWiseAdv&page=<%=curpage+1%>&session=<%=ssn%>&dated1=<%=dt1%>&dated2=<%=dt2%>&bnk_name=<%=bnk%>&kinds=<%=kinds%>">
                     <strong>Older</strong>
                          </a>
                 <%}%>
        </td>
        <td width="50%" align="right">
                <%if(curpage>1){%>
                 <a href="./retBankWiseAdv.do?method=retBankWiseAdv&page=<%=curpage-1%>&session=<%=ssn%>&dated1=<%=dt1%>&dated2=<%=dt2%>&bnk_name=<%=bnk%>&kinds=<%=kinds%>">
                     <strong>Newer</strong>
                     </a>
                 <%}%>
        </td>
        
                 <%}%>
            </tr></table>
</div>
<%}else{%>
<table width="70%" align="center"><tr><td width="100%" align="center">
            <font color="yellow" size="2"><b><%=kinds%> Details is not found</b></font></td></tr></table>   
<%}%>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>