<%-- 
    Document   : refundFeeReceipt
    Created on : Jul 8, 2013, 11:15:42 AM
    Author     : kapil
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
ArrayList banklist=new ArrayList();
String check="";
if(request.getAttribute("chk")!=null)
       {
    check=(String)request.getAttribute("chk");
}
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
MyMeth mm=new MyMeth();
SchoolEO seo=new SchoolEO();
SchoolEO seo1=null;   
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}

    ArrayList al=null;
    if(request.getAttribute("list")!=null){
al=(ArrayList)request.getAttribute("list");
if(al.size()!=0){ 
seo1=(SchoolEO)al.get(al.size()-1);

}
}
ArrayList ar=(ArrayList)seo.getDataArray2();
HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;

String rtn="";
if(request.getAttribute("rtn")!=null){
    rtn=(String)request.getAttribute("rtn");
}
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
<script language="javascript">
 function enrollStud(){
 document.f2.method="post";
 document.f2.action="<%=request.getContextPath()%>/Enr_Stud.do?method=genIdCard";
 document.f2.submit();
 }
 function genIdCard(){
 var ssn=document.f1.elements["session"].value;
 var rno=document.f1.elements["regist_no"].value; 
 window.open('<%=request.getContextPath()%>/Disp_IdCard.do?method=retIdCardAct&rn='+rno+'&ssn='+ssn,'trace','height=230,width=350,toolbar=no,scrollbars=yes,resizable=no');
 }
 function focusField(a){
 document.f1.elements[a].focus();
 }
 
 function cal_tot(){
      //alert(documnet.f2.elements["feetotal"].value);
     var reg=document.f2.elements["reg_fee"].value;
     var sem=document.f2.elements["sem_totfee"].value;
     
     var fn=document.f2.elements["fine"].value;
     //alert(fn);
     document.f2.elements["feetotal"].value=parseFloat(sem)+parseFloat(fn)-parseFloat(reg);
     //document.f2.elements["feetotal"].value=fn+sem;
     //alert('documnet.f2.elements["feetotal"].value');
}
</script>
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
         SimpleDateFormat sde=new SimpleDateFormat("EEEEEEEE, d MMMMMMMMM, yyyy");
         SimpleDateFormat sdee=new SimpleDateFormat("dd/MMM/yyyy");
          java.util.Date rtdt=new java.util.Date();
          String rtrndt="";
          try{
          rtrndt=sde.format(rtdt);
                   }catch(Exception ee){}
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
             <td valign="top" align="left">  
<table width="80%" ><tr><td><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
                         <td align="center"> </td>
                     </tr></table>
                     
                      <div id="printit">
                     
                     <table width="100%" valign="top">
                         <tr><td align="center"><font size="4">Govind Ballabh Pant University of Agriculture & Technology </font></td></tr>
                         <tr><td align="center"><font size="4">Pantnagar- 263145(India) </font></td></tr>
                     </table>
                     <table width="100%" valign="top">
                         <tr><td align="center"><font size="3">OFFICE OF THE COMPTROLLER</font></td></tr>
                         <tr><td align="center"><font size="3">STATEMENT OF ACCOUNT </font></td></tr>
                     </table>

<% if(!check.equals(""))
       {
    banklist=(ArrayList)seo.getDataArray();
%>
<table border="0" style="border-collapse: collapse" align="center" width="90%">
    <tr>
        <td valign="top">
            <table><tr><td colspan="4" style="font-size: 14px"><font><b>Student Details</b></font></td></tr>
                <tr><td style="font-size: 12px"><b>Session</b>:</td><td style="font-size: 12px"><%=seo.getSession()%>-<%=seo.getSession_sem()%>
                        &nbsp;&nbsp;</td>
                    <td style="font-size: 12px"><b>Roll no.</b>:</td><td style="font-size: 12px"><%=seo.getSrnum()%></td></tr>
    
    <tr><td style="font-size: 12px"><b>Student Name</b>:</td><td style="font-size: 12px"><%=seo.getSname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Father Name</b>:</td><td style="font-size: 12px"><%=seo.getFname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Gender</b>:</td><td style="font-size: 12px"><%=seo.getGender()%></td></tr>
    
    <!--<tr><td>DOB:</td><td><%=seo.getDob()%></td></tr>-->
    <tr></tr></table>
        </td>
    </tr>
    

     <tr>
        <td width="80%">
            <table width="100%">
                <tr><td colspan="2" align="center" style="font-size: 12px"><font><b>DETAILS OF THE DEPOSITED AMOUNT</b></font></td></tr>
                <tr><td width="30%">Receipt No:<%=seo1.getFeeReceipt()%> &nbsp;</td><td>Date: &nbsp;<%=seo1.getDateofadd()%></td></tr>
            </table>
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
  <tr><td style="font-size: 12px"><b>Sr No.</b></td><td style="font-size: 12px"><b>Demand Draft No(s)</b></td><td style="font-size: 12px"><b>Issuing Bank</b></td>
        <td style="font-size: 12px"><b>Date</b></td><td style="font-size: 12px"><b>Amount(Rs.)</b></td></tr>
<tr>
    <% int i=0;
    double tot=0.0;
%>
<td><table>
        <% while(i<al.size()){%>
        <tr><td style="font-size: 12px"><%=i+1%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdno()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getBankname()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdate()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
             tot=tot+seo1.getDdamount();
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdamount()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
</tr>
<tr><td colspan="4" align="right" style="font-size: 12px"><b>Total</b></td><td style="font-size: 12px"><b><%=tot%></b></td></tr>
</table> 

<table width="100%">
                <tr><td colspan="2" align="center" style="font-size: 12px"><font><b>DETAILS OF THE AMOUNT REFUNDED</b></font></td></tr>
                <tr><td width="30%">Receipt No:<%=rtn%> &nbsp;</td><td>Date: &nbsp;<%=sdee.format(rtdt)%></td></tr>
            </table>

<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
   <tr><td style="font-size: 12px"><b>Sr No.</b></td><td style="font-size: 12px"><b>Demand Draft No(s)</b></td><td style="font-size: 12px"><b>Issuing Bank</b></td>
        <td style="font-size: 12px"><b>Date</b></td><td style="font-size: 12px"><b>Amount(Rs.)</b></td></tr>
    <tr>
<td><table>
        <%
        tot=0.0;
       while(i<al.size()){%>
        <tr><td style="font-size: 12px"><%=i+1%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdno()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getBankname()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdate()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
             tot=tot+seo1.getDdamount();
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdamount()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
</tr>
<tr><td colspan="4" align="right" style="font-size: 12px"><b>Total</b></td><td style="font-size: 12px"><b><%=tot%></b></td></tr>
</table>


        </td></tr>
     <tr><td width="80%" style="padding-top: 10px">
             <table width="100%">
                 <tr><td colspan="2" style="font-size: 12px"><b>Received the above Bank Draft</b></td></tr>
                  <tr><td height="10" colspan="2"></td></tr>
                  <tr><td style="font-size: 12px"><b>Signature of the Candidate</b></td><td style="font-size: 12px"><b>For Comptroller</b></td></tr>
                  <tr><td height="15" colspan="2"></td></tr>
                  <tr><td colspan="2" style="font-size: 12px"><%=rtrndt%></td></tr>
             </table>
         </td></tr>
     

   
</table>
<%}%>

                      </div>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>


