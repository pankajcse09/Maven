<%-- 
    Document   : feeScrollRc
    Created on : Jul 11, 2013, 11:40:35 PM
    Author     : kapil
--%>

<%-- 
    Document   : StudentFee_receipt
    Created on : Jul 7, 2013, 10:52:35 PM
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
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
MyMeth mm=new MyMeth();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar=(ArrayList)seo.getDataArray2();
ArrayList ar1=(ArrayList)seo.getDataArray();
ArrayList ar2=(ArrayList)seo.getDataArray1();
HashMap hm=(HashMap)seo.getDataMap();
HashMap hm1=(HashMap)seo.getDataMap1();
HashMap hm2=(HashMap)seo.getDataMap2();

//double tt=0.0;
String icar="";
String gate="";
icar=seo.getIcar();
gate=seo.getGate();
//if(request.getParameter("icar")!=null)
        //       {
   // icar=(String)request.getParameter("icar");
//}
//if(request.getParameter("gate")!=null)
  //             {
 //   gate=(String)request.getParameter("gate");
//}
ArrayList ddlist=new ArrayList();
if(request.getAttribute("ddlist")!=null)
   {
   ddlist=(ArrayList)request.getAttribute("ddlist");
    }
ArrayList degreelist=new ArrayList();
  JavaBean de=new JavaBean();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
  
 SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String ddate="";
try{
    ddate=(String)sde.format(dt1);
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
<title>Fee Receipt</title>
    </head>
<body onload="focusField('regist_no');" bgcolor="#999933">
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
         double regis_fee=0.0;
          
         %>
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
            <td valign="top" align="left" width="100%"> 
                 <table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<div id="printit">  
<table width="95%" align="center" cellspacing="0" cellpadding="0" valign="top" border="0"><tr>    
        <%for(int k=0;k<2;k++){%>  
        <td width="48%" align="center" valign="top" style="padding-right: 5px; padding-left: 5px">
 <table width="100%" align="center" border="0" style="border-collapse: collapse;" valign="top" cellpadding="0" cellspacing="0">
     <tr>
         <td colspan="5" width="100%"><table width="100%"><tr>
         <td valign="top" width="10%"><img src="<%=request.getContextPath()%>/image/pant_logo.png" width="50" height="50"></td>
         <td><table valign="top" width="90%" cellpadding="0" cellspacing="0">
  <tr><td align="center" style="border-collapse:collapse;border:0px solid black" colspan="2">
<font style="font-size:12x"><b>G.B. Pant University of Agriculture & Technology </b></font><br>
  <font style="font-size:12px"><b>Pantnagar- 263145(India)
 </b></font><br>
 <font style="font-size:14px"><b>OFFICE OF THE COMPTROLLER  
 </b></font>
  </td></tr>     
 
             </table></td>
                 </tr></table></td></tr>
     <tr><td><table>
                <tr>
                    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Date&nbsp;<%=ddate%></b></font></td>
                    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Student Id:&nbsp;<%=seo.getStud_id().toUpperCase()%></b></font></td>
                </tr> 
             </table>
                <table>
                    <tr><td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Roll No:&nbsp;<%=seo.getRegistNo()%></b></font></td>
<td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Name:&nbsp;<%=seo.getSname().toUpperCase()%></b></font></td>
<td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Category:&nbsp;&nbsp; <%if(seo.getCategory()!=null){%>
    <%=seo.getCategory().toUpperCase()%>
    <%}%></b></font></td>
</tr>
                </table>

<table>
    <tr>
    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Father's Name:&nbsp;<%if(seo.getFname()!=null){%>
    <%=seo.getFname().toUpperCase()%>
<%}%></b></font></td>
    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>&nbsp;Programme:
  <%=seo.getDegree().toUpperCase()%></b></font></td>
    <!--<td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Gender:&nbsp;<%=seo.getGender().toUpperCase()%></b></font></td>-->

</tr> 
</table>
         </td></tr>
                
     <tr><td><hr></td></tr>




</table> 

<%if(hm.size()!=0){%>
<%
double adjst=0.0;
 double submitedfee=0.0;
for(int l=0;l<seo.getDataArray5().size();l++)
                            {
adjst=adjst+Double.parseDouble(seo.getDataArray7().get(l).toString());
}
%>
   <% if(ar1.size()!=0)
               {%>
<table width="100%" align="center" border="0" style="border-collapse:collapse;border:0px solid black" valign="top" cellpadding="0" cellspacing="0">
    <tr><td><font style="font-size: 12px"><b>Particulars</b></font></td>
        <td><font style="font-size: 12px"><b>Amounts(Rs.)</b></font>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><font style="font-size: 12px"><b>Particulars</b></font></td>
        <td><font style="font-size: 12px"><b>Amounts(Rs.)</b></font></td></tr>
    <% 
    int m=0;
    int x=0;
    int y=0;
    int totl=0;
    double total=0.0;
    double ftotal=0.0;
    
     for(int j=ar1.size()-1;j>=0;j--)
                    { 
                     totl=0;
                     m=0;
                      
                     for(int t=j;t>=0;t--)
                     {
                         totl=totl+Integer.parseInt(ar2.get(t).toString());
                                                    }
                      for(int t=j-1;t>=0;t--){
                          m=m+Integer.parseInt(ar2.get(t).toString());
                                                   }
                     
    %>
    <tr><td colspan="4" align="left" height="18" style="font-size: 10px">
            <% if(ar1.get(j)!=null){%>
            <b><%=ar1.get(j)%></b>
        <%} else{}%>
        </td></tr>
    <% 
    x=Integer.parseInt(ar2.get(j).toString());
    if(j==0){
        y=0;
    }else{
     y=Integer.parseInt(ar2.get(j-1).toString());
         }
    total=0.0;
    while(m>=y&&m<totl)
    {
        total=total+Double.parseDouble(hm.get(ar.get(m)).toString());
                        
     %>
               <tr><td style="font-size: 10px"><%=ar.get(m)%></td>
    <td style="font-size: 10px" align="right"><%=df.format(Double.parseDouble(hm.get(ar.get(m)).toString()))%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <%
    if(m<totl-1){
    m++; %>
    
    <td style="font-size: 10px"><%=ar.get(m)%></td>
    <td style="font-size: 10px" align="right"><%=df.format(Double.parseDouble(hm.get(ar.get(m)).toString()))%></td></tr>
    
               <%
               total=total+Double.parseDouble(hm.get(ar.get(m)).toString());
                }
              m++; 
}
%>
               <% if(ar1.get(j)!=null)
                     {
                   if(ar1.get(j).toString().equals("UNIVERSITY DUES"))
                   {
//total=total+adjst;    
%>
               <tr><td style="font-size: 12px">Advance</td><td style="font-size: 12px" align="right"><%=df.format(adjst)%>&nbsp;&nbsp;&nbsp;</td></tr>
               <%} }
    ftotal=ftotal+total;
%>
<tr><td colspan="3" align="right" style="padding-right:10px">
        <font style="font-size: 10px"><b>Total</b></font></td>
    <td align="right"><font style="font-size: 12px"><b><%=df.format(total)%></b></font></td></tr>      
               
               <%}%>
               <tr><td style="font-size: 10px">Self Financing Fee</td>
                   <td align="right" style="font-size: 10px"><%=df.format(seo.getPamount())%>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
               <%
               ftotal=ftotal+seo.getPamount();
                       %>
               
               <tr><td colspan="3" align="right" style="padding-right:10px"><font style="font-size: 12px"><b>G. Total</b></font></td>
                   <td><font style="font-size: 12px" align="right"><b><%=df.format(ftotal)%></b></font></td></tr>

 <tr><td colspan="4" align="left"><font style="font-size: 10px"><b>Details of Deposited Amount / Adjusted Amount</b></font></tr>
 <tr><td><font style="font-size: 10px"><b>DD no</b></font></td><td><font style="font-size: 10px"><b>Date</b></font></td>
     <td><font style="font-size: 10px"><b>Bank</b></font></td><td><font style="font-size: 10px"><b>Amount (Rs.)</b></font></td></tr>
 <%
  double draftSum=0;
 for(int l=0;l<seo.getDataArray5().size();l++)
    {
        draftSum=draftSum+(Double)seo.getDataArray7().get(l);
    %>
  <tr><td style="font-size: 10px"><%=seo.getDataArray5().get(l)%></td><td style="font-size: 10px"><%=seo.getDataArray6().get(l)%></td>
      <td style="font-size: 10px"><%=seo.getDataArray4().get(l)%></td>
      <td style="font-size: 10px"><%=df.format(Double.parseDouble(seo.getDataArray7().get(l).toString()))%></td></tr>
  <%}%>
  <%
  ReportsEO reo=null;
 for(int l=0;l<ddlist.size();l++)
    {
      reo=(ReportsEO)ddlist.get(l);
      draftSum=draftSum+reo.getAmount();
           %>
  <tr><td style="font-size: 10px"><%=reo.getDraft_no()%></td><td style="font-size: 10px"><%=reo.getDate()%></td>
      <td style="font-size: 10px"><%=reo.getBank()%></td>
      <td style="font-size: 10px"><%=df.format(reo.getAmount())%></td></tr>
  <%}%>
  <tr><td colspan="3" align="right" style="padding-right: 10px"><font style="font-size: 10px"><b>Total</b></font></td>
      <td><font style="font-size: 10px"><b><%=df.format(draftSum)%></b></font></td></tr>
 
  <tr><td colspan="4" height="15"></td></tr>
  <tr><td colspan="2"><font style="font-size: 10px">TOTAL PAYABLE AMOUNT</b></td>
      <td colspan="2" style="font-size: 10px; padding-right: 10px" align="right"><b><%=df.format(ftotal)%></b></td></tr>
  <tr><td colspan="2"><font style="font-size: 10px">ADJUSTABLE AMOUNT</b></td>
      <td colspan="2" align="right" style="padding-right: 10px"><b style="font-size: 10px"><%=df.format(adjst)%></b></td></tr>
 <% 
  submitedfee=ftotal;
 ftotal=ftotal-adjst;
 %>
  <% if(icar.equals("YES")){
       ftotal=ftotal-2000;
       submitedfee=submitedfee-2000;
       %>
  <tr><td colspan="2"><font style="font-size: 10px">ADJUSTABLE AMOUNT(ICAR)</b></td>
      <td colspan="2" align="right" style="padding-right: 10px"><b style="font-size: 10px">2000.0</b></td></tr>
  <!--<tr><td colspan="2"><font style=" font-size: 10px"><b>(Total-ICAR)</b></font></td>
      <td colspan="2" align="right" style="padding-right: 10px"><font style=" font-size: 10px"><b><%=submitedfee%></b></font></td></tr>-->
  <%}%>
  <% if(gate.equals("YES")){
       ftotal=ftotal-5000;
       submitedfee=submitedfee-5000;
       %>
  <tr><td colspan="2"><font style="font-size: 10px"><b>ADJUSTABLE AMOUNT(Gate)</b></font></td>
      <td colspan="2" align="right" style="padding-right: 10px"><b style="font-size: 10px">5000.0</b></td></tr>
  <!--<tr><td colspan="2"><font style=" font-size: 10px"><b>(Total-Gate)</b></font></td>
      <td colspan="2" align="right" style="padding-right: 10px"><font style=" font-size: 10px"><b><%=submitedfee%></b></font></td></tr>-->
  <%}%>
  <tr><td style="padding-left: 10px" colspan="2"><font style="font-size: 10px"><b>AMOUNT Received</b></font></td>
      <td colspan="2" border="1" style="border: 1px solid black; padding-right: 10px" align="right">
          <font style="font-size: 10px"><b><%=df.format(ftotal)%></b></font></td></tr>
  <tr><td colspan="4" height="10"></td></tr>
  <tr><td colspan="2">[A/C Assistant]</td><td colspan="2">[Depositor]</td></tr>
 
</table>
  <input type="hidden" name="fee_total" value="<%=ftotal%>">
  <%}%>
 <%}else{%>
 <table><tr><td><font color="yellow" size="2"><b>Fee data is not found</b></font></td></tr></table>
 <%}%>
</td>
<% if(k!=1){%>
<td align="center" width="1%" style="border-right: 1px solid #000000; border-right-style: dotted"></td>
    <%}}%>
    </tr></table>
</div>
    <table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>
