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
HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;
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
 document.f1.method="post";
 document.f1.action="<%=request.getContextPath()%>/Enroll_Stud.do?method=genIdCard";
 document.f1.submit();
 }
 function genIdCard(){
 var ssn=document.f1.elements["session"].value;
 var rno=document.f1.elements["regist_no"].value; 
 window.open('<%=request.getContextPath()%>/Disp_IdCard.do?method=retIdCardAct&rn='+rno+'&ssn='+ssn,'trace','height=230,width=350,toolbar=no,scrollbars=yes,resizable=no');
 }
 function focusField(a){
 document.f1.elements[a].focus();
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/RetFeeReceipt.do?method=retFeeReceiptAct">
<table width="35%" align="center">
<tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select></td>
<td valign="top"><font style="font-size:12;color:white"><b>Admin.Form No</b></font><br>
<input type="text" name="regist_no" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="Submit"></td></tr>    
</table>     
<table width="50%" align="center"><tr>
<td width="33%" align="left" valign="top"><a href="#" onclick="enrollStud();"><font color="yellow" size="2"><u><b>CHECK SUBMIT</b></u></font></a></td>
<td width="34%" align="center" valign="top"><a href="#" onclick="genIdCard();"><font color="yellow" size="2"><u><b>GENERATE ICARD</b></u></font></a></td>
<td width="33%" align="right" valign="top"><a href="javascript:printIdCard('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<hr color="maroon"> 
<%if(request.getAttribute("msg")!=null){%>  
<table width="50%" align="center"><tr><td colspan="2"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>
<%}%>
<input type="hidden" name="sname" value="<%=seo.getSname()%>">  
<input type="hidden" name="type" value="<%=seo.getType()%>"> 
<input type="hidden" name="classes" value="<%=seo.getClasses()%>">
<input type="hidden" name="gender" value="<%=seo.getGender()%>">
<input type="hidden" name="freceipt" value="<%=seo.getFeeReceipt()%>">
<div id="printit">  
<table width="90%" align="center" cellspacing="5" cellpadding="5"><tr>    
<%for(int k=0;k<2;k++){%>  
<td width="80%">
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
<tr><td align="center" style="border-collapse:collapse;border:1px solid black">
<font style="font-size:15"><b>Surajmal Laxmi Devi Sawarthia Educational Trusts  
Group of Instiutions  
 </b></font></td></tr>     
 <tr><td align="center" style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>ISO CERTIFIED INSTIUTE
 </b></font></td></tr> 
 <tr><td align="center" style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>SIROLLY ,KICHHA,DISTT.-U.S.NAGAR, UTTRAKHAND-263148  
 </b></font></td></tr> 
 
 <tr><td align="center" style="border-collapse:collapse;border:1px solid black">
<font style="font-size:14"><b>Tel/Fax:-05944-263022,263024,Mob:9410334141.Website:www.surajmalkichha.com Email:slsetgroup@gmail.com
 </b></font></td></tr> 
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Fee Receipt No.&nbsp;<%=seo.getFeeReceipt()%></b></font></td></tr>    
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Name:&nbsp;<%=seo.getSname().toUpperCase()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Gender:&nbsp;<%=seo.getGender().toUpperCase()%></b></font></td></tr> 
<tr><td style="border-collapse:collapse;border:1px solid black"><font style="font-size:12"><b>Father's Name:&nbsp;<%=seo.getFname().toUpperCase()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Admin.Form No:&nbsp;<%=seo.getRegistNo()%>&nbsp;(<%=seo.getSession()%>)</b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Class:&nbsp;<%=seo.getDegree().toUpperCase()%>,&nbsp;<%=seo.getBranch().toUpperCase()%>,&nbsp;<%=seo.getClasses().toUpperCase()%>&nbsp;(<%=seo.getType().toUpperCase()%>)</b></font></td></tr>
</table>    
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
<%for(int i=0;i<ar.size();i++){%>    
<tr><td width="50%" style="border-collapse:collapse;border:1px solid black"><font style="font-size:12"><b><%=ar.get(i).toString().toUpperCase()%>(<%=mm.retAcNo(ar.get(i))%>)</b></font></td>
    <% if(ar.get(i).toString().equalsIgnoreCase("REGISTRATION FEE")){regis_fee=Double.parseDouble(hm.get(ar.get(i)).toString());}%>
<td width="50%" style="border-collapse:collapse;border:1px solid black"><font face="Rupee Foradian" size="3">`</font><!--<img height="10" width="10" src="./image/rupee1.JPG"></img>-->&nbsp;<%if(hm.get(ar.get(i))!=null){%><%=hm.get(ar.get(i))%><%}%></td></tr>
<%}%>
<tr><td width="50%" style="border-collapse:collapse;border:1px solid black"><font style="font-size:12"><b>FEE TOTAL</b></font></td>
<td width="50%" style="border-collapse:collapse;border:1px solid black"><font face="Rupee Foradian" size="3">`</font><!--<img height="10" width="10" src="./image/rupee1.JPG"></img>-->&nbsp;<b><%=seo.getFeeTotal()%>&nbsp;-&nbsp;<%=regis_fee%>&nbsp;=&nbsp;<%=seo.getFeeTotal()-regis_fee%><input type="hidden" name="feetotal" value="<%=seo.getFeeTotal()-regis_fee%>"></b></td></tr>
</table>  
</td>
<%}%>
</tr></table>
</div> 
</form> 

</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>
