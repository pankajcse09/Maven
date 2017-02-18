<%-- 
    Document   : slip
    Created on : Jun 16, 2014, 8:41:52 AM
    Author     : kapil
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="Fee.FeeMath"%>
<%@page import="EO.SchoolEO"%>
<%
String stud_id=request.getParameter("stud_id");
String ssn=request.getParameter("ssn");
String session_sem=request.getParameter("ssnm");
SchoolEO seo=new SchoolEO();
seo.setStud_id(stud_id);

FeeMath fm=new FeeMath();
seo=fm.getStudentDetails(seo);
seo.setSession(ssn);

       seo.setSession_sem(session_sem);     
seo=fm.calFineOnLateFeeSubm(seo);

double fine=0;
                    if(seo.getTot_days()==1)
                        fine=seo.getMin_fine();
                    else{ 
                        fine=seo.getMin_fine()+(seo.getTot_days()-1)*seo.getPfine();
                        if(fine>seo.getMax_fine())
                            fine=seo.getMax_fine();
                      }
DecimalFormat df = new DecimalFormat("0.00");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>Fine</title>
    </head>
    <body bgcolor="#999933">
        <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Fine Slip</strong></font></td>    
            </tr>
            <tr><td valign="top" align="left" width="100%"> 
                 <table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<div id="printit">  
<table width="95%" align="center" cellspacing="0" cellpadding="0" valign="top" border="0"><tr>    
        
        <td width="48%" align="center" valign="top" style="padding-right: 5px; padding-left: 5px">
 <table width="100%" align="center" border="0" style="border-collapse: collapse;" valign="top" cellspacing="0" cellpadding="0">
     <tr>
         <td colspan="2" width="100%" align="center">
<font style="font-size:14px"><b>G.B. Pant University of Agriculture & Technology </b></font>
  <font style="font-size:14px"><b>Pantnagar- 263145(India)
 </b></font>
  </td></tr>
     <tr><td align="center" colspan="2"><b>University Copy</b></td></tr>
     <tr><td colspan="2" height="10"></td></tr>
     <tr><td colspan="2"><b>Bank Name: </b>........................................................................................ </td></tr>
     <tr><td><b>Name: </b><%=seo.getSname()%></td><td><b>Student Id: </b><%=seo.getStud_id()%></td></tr>
     <tr><td colspan="2"><b>College: </b><%=seo.getCollege()%></td></tr>
     <tr><td><b>Programme: </b><%=seo.getDegree()%></td><td><b>Batch: </b><%=seo.getBatch()%></td></tr>
     <tr><td><b>Hostel: </b>......................................... </td><td><b>Room No.: </b>......................................... </td></tr>
     <tr><td colspan="2" height="5"></td></tr>
     <tr><td colspan="2"><b>Date: </b></td>....................</tr>
                
<tr><td colspan="2" height="5"><hr></td></tr>

<tr><td colspan="2" width="100%">
        <table width="100%">
            <tr><td><b>University Dues</b></td><td><b>Rupee</b></td></tr>
            <tr>
                <td>Late Fine</td><td><%=df.format(fine)%></td>
            </tr>
            <tr><td colspan="2" height="15"></td></tr>
            <tr><td><b>Total</b></td><td><b><%=df.format(fine)%></b></td></tr>
        </table>
    </td></tr>
<tr><td colspan="2" height="5"><hr></td></tr>
<tr><td colspan="2" height="5"><hr></td></tr>
<tr><td>Signature of accountant</td><td>Signature of depositer</td></tr>
</table> 




  
  
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
