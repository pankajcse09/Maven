<%-- 
    Document   : SelfFinanceAmountTransfer
    Created on : Nov 10, 2014, 10:38:04 AM
    Author     : kapil
--%>

<%@page import="ActionClass.DataObj"%>
<%@page import="Beans.JavaBean"%>
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
    SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    ArrayList ar=new ArrayList();
    ArrayList ar2=new ArrayList();
    
    ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
    
   
ReportsEO reo=new ReportsEO(); 
if(request.getAttribute("jbean")!=null){
    reo=(ReportsEO)request.getAttribute("jbean");   
}
double total_selfF=0;
if(request.getAttribute("total_selfF")!=null){
    total_selfF=Double.parseDouble(request.getAttribute("total_selfF").toString());   
}
ArrayList transferlist=new ArrayList();
if(request.getAttribute("list")!=null){
    transferlist=(ArrayList)request.getAttribute("list");   
}
DataObj dob=new DataObj(); 
JavaBean de;
ArrayList degreelist=dob.getFinancialDegree();
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
<title>Self Finance Amount Transfer</title>
<script language="javascript">
   function chkSubmittedAmount(a)
   {
       if(document.f2.amount.value==""||document.f2.amount.value=="0"){
           alert("Please enter the amount.");
           document.f2.amount.focus();
           return false;
       }
       var b=document.f2.amount.value;
       //alert(parseFloat(b));
       //alert(a);
       if(parseFloat(b)>parseFloat(a)){
           alert("Amount should not be greater than total remaining amount.");
           document.f2.amount.focus();
           return false;
       }
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
    
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left">
         </td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left" style=" padding-top: 20px">
<table>
    <tr><td style="padding-left: 390px"><font color="darkblue" size="3"><u><b>Self Finance Amount Transfer</b></u></font></td></tr> 
</table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/totalSelfFinanAmount.do?method=retSelfFinanAmount">
<table width="60%" align="center" border="1" style="border-collapse:collapse;">
<tr><td width="25%"><font style="font-size:12;font-weight:bold">Session</font><br>
<select name="session">
<%if(!reo.getSession().equals("")){%>   
<option value="<%=reo.getSession()%>"><%=reo.getSession()%></option>
<%}if(!reo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!reo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
<select name="session_sem">
<%if(!reo.getSession().equals("")){%>   
<option value="<%=reo.getSession_sem()%>"><%=reo.getSession_sem()%></option>
<%}%> 
<%for(int i=0;i<ar4.size();i++){
if(ar4.get(i).equals(reo.getSession_sem())){continue;}
%>    
<option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>    
<%}%>
</select>
    </td>     
<td ><font style="font-size:12;font-weight:bold">Self Finance Programme</font><br>
<select name="degree">
<%if(reo.getDegree().equals("")){%>  
    <option value="select one">select one</option>
    <%}%>
    <%if(!reo.getDegree().equals("")){%>    
<option value="<%=reo.getDegree()%>"><%=reo.getDegree()%></option> 
<%}%>
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(reo.getDegree())){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
</select>
<input type="submit" value="Submit"></td></tr></table>
</form>
<table width="60%" align="center" border="1" style="border-collapse:collapse" style="padding-top: 20px">
<tr><td width="25%"><font style="font-size:15;color:darkblue"><b>Session</b></font></td>
<td><font style="font-size:12"><b><%=reo.getSession()%> -<%=reo.getSession_sem()%></b></font></td></tr>
<tr><td width="25%"><font style="font-size:15;color:darkblue"><b>Self Finance Programme</b></font></td>
    <td><font style="font-size:12"><b><%=reo.getDegree()%></b></font></td></tr>
<tr><td width="25%"><font style="font-size:15;color:darkblue"><b>Total Fee(in Rs.)</b></font></td>
<td><font style="font-size:12"><b><%=df.format(total_selfF)%></b></font></td></tr>  
</table>
<%

ReportsEO re=null;
//out.println(ftrn);
%>
<%if(total_selfF!=0){%>
<table width="100%" align="center">
    <%if(request.getAttribute("msg")!=null){%>
    <tr><td align="center"><font color="yellow" size="2"><b><%=request.getAttribute("msg")%> </b></font></td></tr>
    <%}%>
    <tr><td align="right"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
    </tr></table>
    <div id="printit">
    <table width="100%">
       <tr><td align="center" valign="top"><b>SELF FINANCE AMOUNT SUMMARY OF <i><%=reo.getDegree()%></i> FOR THE SESSION <%=reo.getSession()%> -<%=reo.getSession_sem()%></b></td>
           <td align="center" valign="top"><b>SELF FINANCE AMOUNT TRANSFER DETAILS OF <i><%=reo.getDegree()%></i></b></td>
    </tr> 
        <tr>
            <td width="55%" align="center" valign="top">    
<table width="100%" border="1" style="border-collapse: collapse" align="left">
    <tr>
        <td><b>Self Finance Programme</b></td>
        <td align="right"><b></b></td>
    </tr>
    
    <tr><td><%=reo.getDegree()%></td><td align="right"><%=df.format(total_selfF)%> </td></tr>
     
    <tr><td><b>TOTAL</b></td>
        <td align="right"><b><%=df.format(total_selfF)%></b></td>
    </tr>
</table>
            </td>
            <td width="45%" align="center" valign="top">
                <table width="100%" border="1" style="border-collapse: collapse">
                    <tr><td><b>Sr. No.</b></td><td><b>Transfer Date</b></td><td align="right"><b>Amount</b></td></tr>
                    <%
                    double tt1=total_selfF;
                    double ttref=0;
                    if(transferlist.size()!=0)
                      {
                        for(int i=0;i<transferlist.size();i++)
                         {
                            re=(ReportsEO)transferlist.get(i);
                            ttref=ttref+re.getTransfered_fund();
                        %>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=sdf1.format(re.getDate1())%></td>
                            <td align="right"><%=df.format(re.getTransfered_fund())%></td>
                        </tr>
                        <%}
                        tt1=tt1-ttref;
%>
                    <tr><td colspan="2" align="right"><b>Total Transfered</b></td><td align="right"><%=df.format(ttref)%></td></tr>
                    <tr><td colspan="2" align="right"><b>Total Remaining</b></td><td align="right"><%=df.format(tt1)%></td></tr>
                        <%}%>
                </table>  
            </td>
        </tr></table>       
        </div>
<%if(urb.getUr_create().equals(s)){%>                       
 <form name="f2" action="<%=request.getContextPath()%>/selfFinanAmountTransfer.do?method=selfFinanAmountTransfer" method="post" onsubmit="return chkSubmittedAmount('<%=tt1%>')">
  <table border="1" width="40%" align="center" style="border-collapse: collapse">
        <tr><td colspan="2" align="center" height="30"><b>Self Finance Amount Transfer</b></td></tr>
        <tr><td><b>Self Finance Programme</b></td><td><%=reo.getDegree()%><input type="hidden" name="degree" value="<%=reo.getDegree()%>"></td></tr>
        <tr><td><b>Amount</b></td><td><input type="text" name="amount"><input type="hidden" name="tt" value="<%=tt1%>"></td></tr>
        <input type="hidden" name="session" value="<%=reo.getSession()%>"><input type="hidden" name="session_sem" value="<%=reo.getSession_sem()%>">
        <tr><td colspan="2" align="center"><input type="submit" name="transfer" value="Transfer"></td></tr>
    </table>       
        </form>
        <%}%>
<%}%>
    
        
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e)
{
    System.out.println("kp: "+e.getMessage());
}%>
