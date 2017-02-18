<%-- 
    Document   : refundCounsFree
    Created on : Jul 3, 2013, 4:05:59 PM
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
seo1=(SchoolEO)al.get(0);}
}
ArrayList ar=(ArrayList)seo.getDataArray2();
HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;

String msg="";
 if(request.getAttribute("msg")!=null){
     msg=(String)request.getAttribute("msg");
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
function validate()
{
    
        if(document.f1.elements["regist_no"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["regist_no"].focus();
            return false;
        }
        return true;
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
          java.util.Date rtdt=new java.util.Date();
          String rtrndt="";
          try{
          rtrndt=sde.format(rtdt);
                   }catch(Exception ee){}
         double regis_fee=0.0;
         Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int month = cal.get(Calendar.MONTH);

        String[] ssn_sm=new String[2];
        if(month>=0&&month<4){ 
            ssn_sm[0]="II";
            ssn_sm[1]="I";
        }
        if(month>=4&&month<=11){ 
            ssn_sm[0]="I";
            ssn_sm[1]="II";
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
                 <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top">
                             <font color="darkred" size="3">Refund Advance Fee</font></td></tr></table>

<form name="f1" method="post" action="<%=request.getContextPath()%>/checkref.do?method=retCounsDetail" onsubmit="return validate()">
<table width="35%" align="center">
<tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
<select name="session_sem" id="session_sem" style="width:50px">
                <%for(int i=0;i<ssn_sm.length;i++){%>   
                    <option value="<%=ssn_sm[i]%>"><%=ssn_sm[i]%></option>
                <%}%>
             </select>
    </td>
<td valign="top"><font style="font-size:12;color:white"><b>Roll No</b></font><br>
<input type="text" name="regist_no" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="Show"></td></tr>    
</table>  
</form>
<hr color="maroon" width="90%">
<%if(request.getAttribute("msg")!=null){%>
<font color="yellow" size="3"><b><%=request.getAttribute("msg")%></b></font>
<%}%>
<form name="f2" method="post" action="<%=request.getContextPath()%>/refCounsFee.do?method=refCounsFee">
<% if(!check.equals(""))
       {
    banklist=(ArrayList)seo.getDataArray();
%>
<table border="0" style="border-collapse: collapse" align="center" width="90%">
    
    <tr>
        <td>
            <table><tr><td colspan="2"><font style="font-size: 16px"><b>Student Details</b></font></td></tr>
    <tr><td>Session:</td><td><%=seo.getSession()%>
        <%if(!seo.getSession_sem().equals("")){%>
                            -<%=seo.getSession_sem()%>
                        <%}%>
        </td></tr><input type="hidden" name="session" value="<%=seo.getSession()%>"><input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
    <tr><td>Roll no.:</td><td><%=seo.getSrnum()%></td></tr><input type="hidden" name="srnum" value="<%=seo.getSrnum()%>">
    <tr><td>Student Name:</td><td><%=seo.getSname()%></td></tr><input type="hidden" name="sname" value="<%=seo.getSname()%>">
    <tr><td>Father Name:</td><td><%=seo.getFname()%></td></tr>
    <!--<tr><td>DOB:</td><td><%=seo.getDob()%></td></tr>-->
    <tr><td>Gender:</td><td><%=seo.getGender()%></td></tr></table>
        </td>
    </tr>
    
    <% if(al.size()!=0){%>
     <tr>
        <td width="80%">
            <table width="100%">
                <tr><td colspan="2" align="center"><font color="darkred"><b><%=msg%></b></font></td></tr>
              
            </table>
            <table width="100%">
                <tr><td colspan="2" align="center"><font style="font-size: 16px"><b>COUNSELLING FEE DETAILS</b></font></td></tr>
                <tr><td width="30%">Receipt No:<%=seo1.getFeeReceipt()%> &nbsp;</td><td>Date: &nbsp;<%=seo1.getDateofadd()%></td></tr>
            </table>
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
    
    
    
    <tr><td>Sr No.</td><td><b>Demand Draft No(s)</b></td><td><b>Issuing Bank</b></td>
        <td><b>Date</b></td><td><b>Amount(Rs.)</b></td></tr>
    <tr>
    <% int i=0;
    double tot=0.0;
%>
<td><table>
        <% while(i<al.size()){%>
        <tr><td><%=i+1%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td><%=seo1.getDdno()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td><%=seo1.getBankname()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td><%=seo1.getDdate()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
             tot=tot+seo1.getDdamount();
        %>
        <tr><td><%=seo1.getDdamount()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
</tr>
<tr><td colspan="4" align="right"><b>Total</b></td><td><b><%=tot%></b></td></tr>
</table>  
        </td></tr>
     <tr><td width="80%" style="padding-top: 20px">
             <table>
                 <tr><td><b>Received the above Bank Draft</b></td></tr>
                  <tr><td height="15"></td></tr>
                  <tr><td><b>For Comptroller</b></td></tr>
                  <tr><td height="20"></td></tr>
                  <tr><td height="20"><%=rtrndt%></td></tr>
             </table>
         </td></tr>
     <tr><td align="center"><input type="submit" value="Refund"></td></tr>
     <%} else{%>
     <tr><td><font color="darkred">Fee Record is not found!</font></td></tr>
     <%}%>

    
</table>
<%}%>
</form>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>

