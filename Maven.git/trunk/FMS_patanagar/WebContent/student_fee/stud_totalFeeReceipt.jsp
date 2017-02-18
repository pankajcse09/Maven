<%-- 
    Document   : totalFeeReceipt
    Created on : Jul 10, 2013, 10:09:58 AM
    Author     : kapil
--%>

<%-- 
    Document   : StudentID
    Created on : Jul 9, 2013, 1:22:53 AM
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

//double tt=0.0;
ArrayList ar=new ArrayList();
ArrayList ar1=new ArrayList();
ArrayList ar2=new ArrayList();
ArrayList ar3=new ArrayList();
ArrayList ar4=new ArrayList();
String icar="";
String gate="";
if(request.getParameter("icar")!=null)
               {
    icar=(String)request.getParameter("icar");
}
if(request.getParameter("gate")!=null)
               {
    gate=(String)request.getParameter("gate");
}
ArrayList al=new ArrayList();
  SchoolEO seo1=new SchoolEO();
    if(request.getAttribute("list")!=null)
   {
   al=(ArrayList)request.getAttribute("list");
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
 
 function changefee()
 {
    document.f2.method="post";
 document.f2.action="<%=request.getContextPath()%>/retChangeFeeRecDetail.do?method=retChangeFeeDetail";
 document.f2.submit(); 
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

function validate()
{
   
        if(document.f1.elements["regist_no"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["regist_no"].focus();
            return false;
        }
         if(document.f1.elements["stud_id"].value=="")
        {
            alert("Please Enter Studen Id");
           document.f1.elements["stud_id"].focus();
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
           SimpleDateFormat sde=new SimpleDateFormat("EEEEEEEE, d MMMMMMMMM, yyyy");
          java.util.Date rtdt=new java.util.Date();
          String rtrndt="";
          try{
          rtrndt=sde.format(rtdt);
                   }catch(Exception ee){}
         double regis_fee=0.0;
         
         String message="";
         if(request.getAttribute("message")!=null)
                         {
             message=(String)request.getAttribute("message");
         }
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
          <table width="70%" align="center" border="0" cellpadding="5"><tr><td align="center"><font  color="darkblue" size="3"><b><u>Student Fee Receipt</u></b></font></td></tr>
                 </table>



<%if(request.getAttribute("msg")!=null){%>  
<table width="50%" align="center"><tr><td colspan="2"><font color="darkred"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>
<%}%>

<%

    seo1=(SchoolEO)al.get(0);
    ar=seo1.getDataArray();
    ar1=seo1.getDataArray1();
    ar2=seo1.getDataArray2();
    ar3=seo1.getDataArray3();
    ar4=seo1.getDataArray4();
    
%>
<table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<div id="printit">
    <% for(int k=0;k<2;k++){%>
    <table width="100%" valign="top" border="0">
                         <tr><td valign="top">
                                 <img src="<%=request.getContextPath()%>/image/pant_logo.png" width="90" height="90"> 
                             </td>
                             <td valign="top" style="padding-top: 5px"><table>
                         <tr><td align="center"><font size="4"><b>Govind Ballabh Pant University of Agriculture & Technology </b></font></td></tr>
                         <tr><td align="center"><font size="4"><b>Pantnagar- 263145(Uttarakhand) <b></font></td></tr>
                                         </table>
                             <table style="padding-left: 120px;padding-top: 5px">
                         <tr><td align="center"><font size="3">OFFICE OF THE COMPTROLLER</font></td></tr>
                         <tr><td align="center"><font size="3">STATEMENT OF ACCOUNT </font></td></tr>
                     </table>
                             </td></tr>
                     </table>
<table width="80%" align="center" cellspacing="0" cellpadding="0">
    <tr><td><font style="font-size: 16px"><b>Course Name:</b></font>&nbsp;&nbsp;<font style="font-size: 15px"><b><%=seo1.getDegree()%></b></td></tr>
    <tr>
        <td width="100%">
            <table width="80%">
                <tr>
                    <td colspan="2"><b>Fee Receipt No.&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getFeeReceipt()%></b></td></tr>
                <tr><td><b>Student Rollno:</b>&nbsp;<%=seo1.getSrnum()%></td>
                    <td><b>Student Id:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.............</td></tr>
                <tr><td><b>Student Name:&nbsp;&nbsp;</b><%=seo1.getSname()%></td><td><b>Father Name:&nbsp;&nbsp;</b><%=seo1.getFname()%></td></tr>
                <tr><td><b>Category:&nbsp;&nbsp;&nbsp;</b><%=seo1.getCategory()%></td>
                    <% if(seo1.getGen_rank()!=null&&!seo1.getGen_rank().equals("")){%>
                    <td><b>Rank:&nbsp;&nbsp;<%=seo1.getGen_rank()%></b></td>
                <%} else{%>
                <td><b>Rank:&nbsp;&nbsp;NA</b></td>
                <%}%>
                </tr>
                
            </table>
        
        </td></tr></table>
                
 <table width="80%" align="center">
                   <tr><td><font style="font-size: 14px"><b>Advance:</b></font></td></tr>
                   <tr>
                       <td>
                           <table border="1" style="border-collapse: collapse" width="80%">
                               <tr><td><b>DD No</b></td><td><b>DD Date</b></td><td><b>Bank</b></td><td><b>Amount</b></td></tr>               
      <% for(int i=0;i<ar.size();i++)
          {
      if(ar4.get(i).toString().equals("counselling"))
             {
%>
                                <tr>
                                   <td><%=ar.get(i)%></td>
                                   <td><%=ar1.get(i)%></td>
                                   <td><%=ar2.get(i)%></td>
                                   <td><%=ar3.get(i)%></td>
                               </tr>
                              <%}}%>
                           </table>
                       </td>
                   </tr>
               </table>
                  <table width="80%" align="center">
                   <tr><td><font style="font-size: 14px"><b>Total Fee:</b></font></td></tr>
                   <tr>
                       <td>
                           <table border="1" style="border-collapse: collapse" width="80%">
                               <tr><td><b>DD No</b></td><td><b>DD Date</b></td><td><b>Bank</b></td><td><b>Amount</b></td></tr>
                             
      <% for(int i=0;i<ar.size();i++)
          {
      if(ar4.get(i).toString().equals("addmission fee"))
             {
%>
                            <tr>
                                   <td><%=ar.get(i)%></td>
                                   <td><%=ar1.get(i)%></td>
                                   <td><%=ar2.get(i)%></td>
                                   <td><%=ar3.get(i)%></td>
                               </tr>
                               <%}}%>
                           </table>
                       </td>
                   </tr>
               </table> 
    <table width="80%" align="center">
                 <tr><td style="font-size: 12px"><b>Received the above Bank Draft</b></td></tr>
                  <tr><td height="25"></td></tr>
                  <tr><td style="font-size: 12px"><b>For Comptroller</b></td></tr>
                  <tr><td height="3"></td></tr>
                  <tr><td style="font-size: 10px"><%=rtrndt%></td></tr>
             </table>
             <% if(k<1){%>
             <hr color="maroon">
                 <%}}%>          
               </div>

    </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>
