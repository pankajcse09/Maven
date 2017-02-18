<%-- 
    Document   : nodues_receipt
    Created on : Jul 10, 2014, 12:29:36 PM
    Author     : kapil
--%>

<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
    
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar=(ArrayList)seo.getDataArray();
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
<title>Fee Receipt</title>
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
         SimpleDateFormat sde=new SimpleDateFormat("EEEEEEEE, d MMMMMMMMM, yyyy");
          java.util.Date rtdt=new java.util.Date();
          String rtrndt="";
          try{
          rtrndt=sde.format(rtdt);
                   }catch(Exception ee){}
         
         %>       
     
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<!--<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%//@include file="/fee/toplook_1.jsp"%></td></tr>-->
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Fees/Generate Fee Receipt</strong></font></td>
     <!--<td width="2" bgcolor="#000000"></td><td></td>-->
            </tr>
            <tr><td valign="top" align="left" width="100%"> 
                 <table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<div id="printit">  
<table width="95%" align="center" cellspacing="0" cellpadding="0" valign="top" border="0"><tr>    
        
        <td width="100%" align="center" valign="top" style="padding-right: 5px; padding-left: 5px">
 <table width="100%" align="center" border="0" style="border-collapse: collapse;" valign="top" cellspacing="0" cellpadding="0">
     <tr>
         <td colspan="5" width="100%"><table width="100%"><tr>
         <td valign="top" width="10%"><img src="<%=request.getContextPath()%>/image/pant_logo.png" width="50" height="50"></td>
         <td><table valign="top" width="90%" cellspacing="0" cellpadding="0">
  <tr><td align="center" style="border-collapse:collapse;border:0px solid black" colspan="2">
<font style="font-size:12x"><b>G.B. Pant University of Agriculture & Technology </b></font><br>
  <font style="font-size:12px"><b>Pantnagar- 263145(India)
 </b></font><br>
 <font style="font-size:14px"><b>OFFICE OF THE COMPTROLLER  
 </b></font>
  </td></tr>     
 
             </table></td>
                 </tr></table></td></tr>
     <tr>
        <td valign="top">
            <table><tr><td colspan="4" style="font-size: 14px"><font><b>Student Details Of Nodues</b></font></td></tr>
                
    
    <tr><td style="font-size: 12px"><b>Student Name</b>:</td><td style="font-size: 12px"><%=seo.getSname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Student Id</b>:</td><td style="font-size: 12px"><%=seo.getStud_id()%>&nbsp;&nbsp;</td>
        </tr>
    <tr><td style="font-size: 12px"><b>Father Name</b>:</td><td style="font-size: 12px"><%=seo.getFname()%>&nbsp;&nbsp;</td>
                    <td style="font-size: 12px"><b>Programme</b>:</td><td style="font-size: 12px"><%=seo.getDegree()%></td>
                </tr>
    <tr><td style="font-size: 12px"><b>Reason</b>:</td><td style="font-size: 12px"><%=seo.getReason()%>&nbsp;&nbsp;</td>
                    <td style="font-size: 12px"><b>Total Amount</b>:</td><td style="font-size: 12px"><%=seo.getTfee()%></td>
                </tr>            
    
    
    <tr></tr></table>
                <table border="1" style="border-collapse: collapse"><tr>
                    <tr><td><b>Draft No</b></td><td><b>Draft Date</b></td><td><b>Bank</b><td><b>Amount</b></td><td><b>Submit Date</b></td></td></tr>
                    <%for(int i=0;i<ar.size();i++)
                    {
                           seo=(SchoolEO)ar.get(i);
                    %>
                <tr><td><%=seo.getDdno()%></td>
                        <td><%=seo.getDdate()%></td>
                        <td><%=seo.getBankname()%></td>
                        <td><%=seo.getDdamount()%></td>
                        <td><%=seo.getDateofadd()%></td></tr>
                <%}%>
                    </table>
        </td>
    </tr>
    <tr><td width="80%" style="padding-top: 0px" valign="top">
             <table valign="top">
                 <tr><td style="font-size: 12px"><b>Received the above Bank Draft</b></td></tr>
                  <tr><td height="25"></td></tr>
                  <tr><td style="font-size: 12px"><b>For Comptroller</b></td></tr>
                  <tr><td height="3"></td></tr>
                  <tr><td style="font-size: 10px"><%=rtrndt%></td></tr>
             </table>
         </td></tr>
</table> 
<table border="1" style="border-collapse:collapse"></table>
</td>
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