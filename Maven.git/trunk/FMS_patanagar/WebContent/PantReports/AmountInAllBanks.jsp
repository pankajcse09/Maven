<%-- 
    Document   : AmountInAllBanks
    Created on : Sep 13, 2014, 1:16:49 PM
    Author     : kapil
--%>

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
 Calendar cal = Calendar.getInstance();
    
if(request.getAttribute("date1")!=null)
         {
    dt1=(String)request.getAttribute("date1");
    cal.setTime(sdf1.parse(dt1));
 }
 if(request.getAttribute("date2")!=null)
         {
    dt2=(String)request.getAttribute("date2");
 }
 if(request.getAttribute("ambnklist")!=null)
         {
     al=(ArrayList)request.getAttribute("ambnklist");
 }
 int days=0;
    if(request.getAttribute("days")!=null)
               {
        days=Integer.parseInt(request.getAttribute("days").toString());
    }
    
 HashMap hm=new HashMap();
 if(request.getAttribute("map")!=null)
         {
     hm=(HashMap)request.getAttribute("map");
 }
 HashMap hm1[]=new HashMap[hm.size()];
 
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
<title>ALL Amount Received</title>
<script language="javascript">

function validate()
{
    if(document.f1.elements["bank"].value=="")
        {
            alert("Please Enter Bank name");
            document.f1.elements["bank"].focus();
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
    if(request.getAttribute("bnklist")!=null)
               {
        banklist=(ArrayList)request.getAttribute("bnklist");
    }
    String kinds="";
    if(request.getAttribute("kinds")!=null)
               {
        kinds=(String)request.getAttribute("kinds");
    }
    
    //out.println("days: "+kinds);
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

<form name="f1" method="post" action="<%=request.getContextPath()%>/bankamount.do?method=allbankamount" onsubmit="return validate()">
<table width="75%" align="center" border="0" style="border-collapse:collapse">
    <tr><td colspan="5" align="center"><font color="darkblue" size="3"><u><b>Amount In All Banks</b></u></font></td></tr>
            <tr><td colspan="2"><input type="radio" name="kinds" value="Receiving" checked="checked">Draft Receiving Date</td>
        <td colspan="3"><input type="radio" name="kinds" value="Processing">Draft Processing Date</td></tr>
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
<td align="left" style="padding-right: 20px"><font style="font-size:12" color="white"><b>Date1</b></font>
    <br><script>DateInput('d1',true,'dd/mm/yyyy')</script></td>
                <td align="left" style="padding-right: 20px"><font style="font-size:12" color="white"><b>Date2</b></font>
                    <br><script>DateInput('d2',true,'dd/mm/yyyy')</script></td>
                <td align="left"><font style="font-size:12" color="white"><b>Processing Bank</b></font><br>
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
    <table width="70%" align="center">
       <tr><td style="padding-left: 0px" aligm="left">
               <h2><font color="darkblue" size="3"><u><b>Amount In All Banks</b></u></font></h2></td></tr> 
</table>
<table width="70%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td colspan="<%=al.size()+3%>">
            <font style="font-size:14;font-weight:bold">Session:</font>&nbsp;&nbsp;<%=ssn%> -<%=ssnm%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <font style="font-size:14;font-weight:bold"><%=kinds%> Date :</font>&nbsp;&nbsp;<%=dt1%> to <%=dt2%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <font style="font-size:14;font-weight:bold">Processing Bank:</font>&nbsp;&nbsp;<%=bnk%>
            </td></tr>

<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">Date</font></td>
    <%for(int i=0;i<al.size();i++)
       {
    hm1[i]=(HashMap)hm.get(al.get(i));
%>
    <td><font style="font-size:12;font-weight:bold"><%=al.get(i)%> </font></td>
<%}%>
<td align="right"><font style="font-size:12;font-weight:bold">Total Submitted</font></td></tr>
<% 
double tt[]=new double[al.size()];
double inv=0;
for(int i=0;i<days;i++)
  {
    dt=cal.getTime();
    double ttinv=0;
    %>
<tr><td><%=(i+1)%></td><td><%=sdf1.format(dt)%> </td>
<%    for(int j=0;j<al.size();j++){
        if(hm1[j].containsKey(dt)){
            inv=Double.parseDouble(hm1[j].get(dt).toString());
            tt[j]=tt[j]+inv;
            ttinv=ttinv+inv;
            %>
<td align="right"><%=df.format(inv)%></td>
<%}else
{
        tt[j]=tt[j]+0;    
%>
<td align="right">0.00</td>
   <%}}%>
<td align="right"><%=df.format(ttinv)%></td></tr> 
<%
cal.add(Calendar.DATE, 1);
}%>
<tr><td colspan="2" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td>
    <%    double gr_tt=0;
    for(int j=0;j<al.size();j++)
{
   gr_tt=gr_tt+tt[j];     
%>
<td align="right"><b><%=df.format(tt[j])%></b></td>
<%}%>
<td align="right"><%=df.format(gr_tt)%></td>
</tr>
</table>
<table width="70%" align="center">
    <tr><td colspan="2" height="10"></td></tr>
    </table>
</div>                 
  <%}else
  {
  if(request.getParameter("bank")!=null){
  %>
<table width="70%" align="center"><tr><td width="100%" align="center">
            <font color="yellow" size="2"><b>Details is not found for <%=ssn%> -<%=ssnm%> and from date <%=dt1%> to <%=dt2%> and bank <%=bnk%></b></font></td></tr></table>   
<%}}%>           
        
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
    //out.println("EXC: "+e.getMessage());
}%>