<%-- 
    Document   : StudentFee_ToPay
    Created on : Apr 19, 2013, 10:17:35 AM
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
ArrayList ar3=new ArrayList();
ar3.add("Day Scholar");
ar3.add("Hosteller");
ar3.add("Staff");

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
ArrayList degreelist=new ArrayList();
  JavaBean de=new JavaBean();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
  
  String dg="";
  if(request.getParameter("degree")!=null)
               {
    dg=request.getParameter("degree");
    }
  String college=mm.college_Degree(dg);

try{
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
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
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
    var session_sem=document.f1.elements["session_sem"];
        if(session_sem.value=="")
        {
            alert("Please Session Semester");
            session_sem.focus();
            return false;
        }
    if(document.f1.elements["degree"].value=="")
        {
            alert("Please select programme");
           document.f1.elements["degree"].focus();
            return false;
        }
        if(document.f1.elements["regist_no"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["regist_no"].focus();
            return false;
        }
        return true;
}

function validate1()
{
    var dd2=document.f2.elements["dd_2"].value;
    var bank2=document.f2.elements["bnk_2"].value;
    if(document.f2.elements["dd_2"].value=="")
        {
            alert("Please Draft no  Cash Receipt 2");
           document.f2.elements["dd_2"].focus();
            return false;
        }
        if(document.f2.elements["damnt_2"].value=="")
        {
            alert("Please Amount Cash Receipt 2");
           document.f2.elements["damnt_2"].focus();
            return false;
        }
        if(document.f2.elements["bnk_2"].value=="")
        {
            alert("Please Bank name Cash Receipt 2");
           document.f2.elements["bnk_2"].focus();
            return false;
        }
        
        var dd3=document.f2.elements["dd_3"].value;
        var bank3=document.f2.elements["bnk_3"].value;
        if(document.f2.elements["dd_3"].value.length!=0)
        {
            if(document.f2.elements["damnt_3"].value=="")
        {
            alert("Please Amount Cash Receipt for 3");
           document.f2.elements["damnt_3"].focus();
            return false;
        }
            if(document.f2.elements["bnk_3"].value=="")
        {
            alert("Please Bank name Cash Receipt for 3");
           document.f2.elements["bnk_3"].focus();
            return false;
        }
        else{
            if(bank2==bank3&&dd2==dd3){
                    alert("Draft number can not be same for the same bank "+bank3);
                    document.f2.elements["dd_3"].focus();
                    return false;
                }
        }
        }
        
        var dd4=document.f2.elements["dd_4"].value;
        var bank4=document.f2.elements["bnk_4"].value;
        if(document.f2.elements["dd_4"].value.length!=0)
        {
            if(document.f2.elements["damnt_4"].value=="")
        {
            alert("Please Amount Cash Receipt for 4");
           document.f2.elements["damnt_4"].focus();
            return false;
        }
            if(document.f2.elements["bnk_4"].value=="")
        {
            alert("Please Bank name for Cash Receipt 4");
           document.f2.elements["bnk_4"].focus();
            return false;
        }
         else{
             if((bank3==bank4&&dd3==dd4)||(bank2==bank4&&dd2==dd4)){
                    alert("Draft number can not be same for the same bank "+bank4);
                    document.f2.elements["dd_4"].focus();
                    return false;
                }
         }  
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
         double regis_fee=0.0;
         
         String message="";
         if(request.getAttribute("message")!=null)
                         {
             message=(String)request.getAttribute("message");
         }
         
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
                 <table width="70%" align="center" border="0" cellpadding="5"><tr><td align="center"><font  color="darkblue" size="3"><b><u>Submit Programme Fee</u></b></font></td></tr>
                 </table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/retFeeRecDetail.do?method=retFeeDetail" onsubmit="return validate()">
<table width="60%" align="center">
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
    <select name="session_sem" id="session_sem">
                <%for(int i=0;i<ssn_sm.length;i++){%>   
                    <option value="<%=ssn_sm[i]%>"><%=ssn_sm[i]%></option>
                <%}%>
                <option value="">Session Semester</option>
             </select>
    </td>

<td valign="top"><font style="font-size:12;color:white"><b>Programme</b></font><br>
<select name="degree">
    <option value="">Select</option>
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}%>
</select></td>

<td valign="top"><font style="font-size:12;color:white"><b>ICAR</b></font><br>
<select name="icar">
    <option value="NO">No</option>
    <option value="YES">Yes</option>
</select></td>

<td valign="top"><font style="font-size:12;color:white"><b>Roll No</b></font><br>
<input type="text" name="regist_no" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="Submit"></td></tr>    
</table>  
</form>

<form name="f2" method="post" action="<%=request.getContextPath()%>/subStudentFeeDetail.do?method=subStudentFeeData" onsubmit="return validate1()">


<hr color="maroon"> 
<%if(request.getAttribute("msg")!=null){%>  
<table width="50%" align="center"><tr><td colspan="2"><font color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>
<%}%>

<table width="80%" align="center" cellspacing="5" cellpadding="5"><tr>
        <td width="60%">
            <table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
                <tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Fee Receipt No.&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getFeeReceipt()%></b></font></td></tr>    
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getSname().toUpperCase()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Category:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%if(seo.getCategory()!=null){%>
    <%=seo.getCategory().toUpperCase()%></b></font>
    <%}%>
    </td>
</tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Gender:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%if(seo.getGender()!=null){%>
    <%=seo.getGender().toUpperCase()%>
<%}%></b></font></td></tr> 
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Father's Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%if(seo.getFname()!=null){%>
    <%=seo.getFname().toUpperCase()%>
<%}%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Roll No:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getRegistNo()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Programme:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;<%=seo.getDegree().toUpperCase()%>&nbsp;&nbsp;</b></font></td></tr>
</table> 
<%
long n=0;
 double adjst=0.0;
 double ftotal=0.0;
 double submitedfee=0.0;
 //if(seo.getDataArray5().size()!=0&&seo.getDataArray7().size()!=0)
//{
if(ar.size()!=0){%>

<table width="100%" align="center" border="0" style="border-collapse:collapse;border:1px solid black">
    <tr>
        <td><table border="0" style="padding-top: 20px">
                <tr><td width="35%"><b>Student Type:</b>&nbsp;
                        <select name="stud_type" onchange="changefee()">
                            <option value="<%=seo.getStud_type()%>"><%=seo.getStud_type()%></option>
                            <%for(int i=0;i<ar3.size();i++){
                                if(!seo.getStud_type().equals(ar3.get(i).toString())){
                            %>
                            <option value="<%=ar3.get(i)%>"><%=ar3.get(i)%></option>
                               <%}}%>
                        </select>
                    </td>
                <% if(seo.getDegree().equals("M.Tech"))
                                       {%>
                                       <td width="65%" align="left"><b>Gate:</b>&nbsp;
                        <select name="gate" onchange="changefee()">
                            <% if(!gate.equals(""))
                                   {%>
                            <option value="<%=gate%>"><%=gate%></option>
                            <% if(!gate.equals("YES")){%>
                             <option value="YES">YES</option>
                             <%} else{%>
                             <option value="NO">NO</option>
                             <%}%>
                            <%} else{%>
                              <option value="NO">NO</option>
                                <option value="YES">YES</option>
                                <%}%>
                        </select>
                    </td>  
                    <%}%>
                </tr>
 <tr><td colspan="2"><table width="100%">
     <tr align="center"><td></td><td><b>DD no</b></td><td><b>Date<font color="darkred">(dd/mm/yyyy)</font></b></td>
          <td><b>Amount</b></td><td><b>Bank</b></td></tr>
        <% for(int k=0;k<seo.getDataArray5().size();k++)
          { adjst=adjst+Double.parseDouble(seo.getDataArray7().get(k).toString());
            %>
           <tr><td><b>Cash Receipt #<%=k+1%></b></td>
            <td><input type="text" value="<%=seo.getDataArray5().get(k)%>" disabled></td>
            <td><input type="text" value="<%=seo.getDataArray6().get(k)%>" disabled></td>
            <td><input type="text" value="<%=seo.getDataArray7().get(k)%>" disabled></td>
            <td><input type="text" value="<%=seo.getDataArray4().get(k)%>" disabled></td>
                            </tr>
<input type="hidden" name="dd<%=k+1%>" value="<%=seo.getDataArray5().get(k)%>">
<input type="hidden" name="dddate<%=k+1%>" value="<%=seo.getDataArray6().get(k)%>">
<input type="hidden" name="bnk<%=k+1%>" value="<%=seo.getDataArray4().get(k)%>">
<input type="hidden" name="damnt<%=k+1%>" value="<%=seo.getDataArray7().get(k)%>">
<input type="hidden" name="feeType<%=k+1%>" value="<%=seo.getDataArray8().get(k)%>">
<input type="hidden" name="rowid<%=k+1%>" value="<%=seo.getDataArray9().get(k)%>">
<%}%>
           <input type="hidden" name="sz" value="<%=seo.getDataArray5().size()%>">  
<% if(seo.getDataArray5().size()==0){%>
<tr><td colspan="5" style="border: 1px solid black;text-align: center;height: 30px">
        <span style="color:yellow;text-align:center; vertical-align: middle">No advance fee record is available for this student.</span>
    </td></tr>
<%}%>
                            <% for(int j=0;j<3;j++){%>
                            <tr><td><b>Cash Receipt #<%=seo.getDataArray5().size()+j+1%></b></td><td><input type="text" name="dd_<%=j+2%>" value=""></td>
    <td><!--<input type="text" name="dddate_<%=j+2%>" value="">--><script>DateInput('dddate_<%=j+2%>',true,'dd/mm/yyyy')</script></td>
                                <td><input type="text" name="damnt_<%=j+2%>" value=""></td><td><select name="bnk_<%=j+2%>">
                                        <option value="">Select</option>
                                        <%for(int i=0;i<seo.getDataArray3().size();i++){%>
                                        <option value="<%=seo.getDataArray3().get(i)%>"><%=seo.getDataArray3().get(i)%></option>
                                        <%}%>
                                    </select></td>
                            </tr><input type="hidden" name="feeType_<%=j+2%>" value="addmission fee">
                            <input type="hidden" name="rowid_<%=j+2%>" value="<%=n%>">
                            <%}%>
                            <!--<tr><td><b>Cash Receipt #3</b></td><td><input type="text" name="dd3" value=""></td><td><input type="text" name="dddate3" value=""></td>
                                <td><input type="text" name="damnt3" value=""></td><td><select name="bnk3">
                                        <option name="">Select</option>
                                        <%for(int i=0;i<seo.getDataArray3().size();i++){%>
                                        <option value="<%=seo.getDataArray3().get(i)%>"><%=seo.getDataArray3().get(i)%></option>
                                        <%}%>
                                    </select></td>
                            </tr>
                            <tr><td><b>Cash Receipt #4</b></td><td><input type="text" name="dd4" value=""></td><td><input type="text" name="dddate4" value=""></td>
                                <td><input type="text" name="damnt4" value=""></td><td><select name="bnk4">
                                        <option name="">Select</option>
                                        <%for(int i=0;i<seo.getDataArray3().size();i++){%>
                                        <option value="<%=seo.getDataArray3().get(i)%>"><%=seo.getDataArray3().get(i)%></option>
                                        <%}%>
                                    </select></td>
                            </tr>-->
                        </table>
               </td></tr>
            </table></td>
    </tr>
    <tr><td align="center"><input type="submit" value="Submit Fee"></td></tr>
</table>
   <%}%>
   <br><br><br>
     
   <% 
   
   if(ar1.size()!=0)
               {%>
<table width="100%" align="center" border="0" style="border-collapse:collapse;border:1px solid black">
    <tr><td><b>Particulars</b></td><td><b>Amounts(Rs.)</b></td><td><b>Particulars</b></td><td><b>Amounts(Rs.)</b></td></tr>
    <% 
    int m=0;
    int x=0;
    int y=0;
    int totl=0;
    double total=0.0;
    
    
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
    <tr><td colspan="4" align="left" height="18">
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
<tr><td><%=ar.get(m)%></td>
    <td align="right" style="padding-right:25px"><%=df.format(Double.parseDouble(hm.get(ar.get(m)).toString()))%></td>
    <%
    if(m<totl-1){
    m++; %>
   
    <td><%=ar.get(m)%></td>
    <td align="right" style="padding-right:25px"><%=df.format(Double.parseDouble(hm.get(ar.get(m)).toString()))%></td></tr>
    
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
<tr><td>Advance</td><td align="right" style="padding-right:25px"><%=df.format(adjst)%><input type="hidden" name="adv" value="<%=adjst%>"></td></tr>
               <%} }
    ftotal=ftotal+total;
%>
<tr><td colspan="3" align="right"><b>Total</b></td>
    <td align="right" style="padding-right:25px"><b><%=df.format(total)%></b></td></tr>      
               
               <%}%>
               <tr><td>Self Financing Fee</td><td align="right" style="padding-right:25px"><%=df.format(seo.getPamount())%></td></tr>
               <%
               ftotal=ftotal+seo.getPamount();
                       %>
               
               <tr><td colspan="3" align="right"><b>G. Total</b></td>
                   <td align="right" style="padding-right:25px"><b><%=df.format(ftotal)%></b></td></tr>
<%if(seo.getDataArray5().size()!=0){%>
 <tr><td colspan="4" align="left"><b>Details of Deposited Amount / Adjusted Amount</b></tr>
 <tr><td><b>DD no</b></td><td><b>Date</b></td><td><b>Bank</b></td><td><b>Amount (Rs.)</b></td></tr>
 <%
 for(int k=0;k<seo.getDataArray5().size();k++)
                            {
                                %>
  <tr><td><%=seo.getDataArray5().get(k)%></td><td><%=seo.getDataArray6().get(k)%></td>
      <td><%=seo.getDataArray4().get(k)%></td><td><%=df.format(Double.parseDouble(seo.getDataArray7().get(k).toString()))%></td></tr>
  <%}%>
  <tr><td colspan="3" align="right" style="padding-right: 20px"><b>Total</b></td><td><b><%=df.format(adjst)%></b></td></tr>
 <%}%>
  <tr><td colspan="4" height="10"></td></tr>
  <tr><td style="padding-left: 20px"><b>TOTAL PAYABLE AMOUNT</b></td><td align="right"><b><%=df.format(ftotal)%></b></td></tr>
  <tr><td style="padding-left: 20px"><b>ADJUSTABLE AMOUNT</b></td><td align="right"><b><%=df.format(adjst)%></b></td></tr>
  <% 
  submitedfee=ftotal;
 ftotal=ftotal-adjst;
 %>
   <% if(icar.equals("YES")){
       ftotal=ftotal-2000;
       //submitedfee=submitedfee-2000;
       %>
  <tr><td style="padding-left: 20px"><b>ADJUSTABLE AMOUNT(ICAR)</b></td><td align="right"><b>2000.00</b>
          <input type="hidden" name="icar_am" value="2000"></td></tr>
  <!--<tr><td style="padding-left: 20px"><font style=" font-size: 10px"><b>(Total-ICAR)</b></font></td><td align="right"><font style=" font-size: 10px"><b><%=submitedfee%></b></font></td></tr>-->
  <%}%>
  <% if(gate.equals("YES")){
       ftotal=ftotal-5000;
       //submitedfee=submitedfee-5000;
       %>
  <tr><td style="padding-left: 20px"><b>ADJUSTABLE AMOUNT(Gate)</b></td><td align="right"><b>5000.0</b></td></tr>
    <!--<tr><td style="padding-left: 20px"><font style=" font-size: 10px"><b>(Total-Gate)</b></font></td><td align="right"><font style=" font-size: 10px"><b><%=submitedfee%></b></font></td></tr>-->
  <%}%>
  <tr><td style="padding-left: 20px"><b>AMOUNT TO BE PAID</b></td>
      <td border="1" style="border: 1px solid black" align="right"><b><%=df.format(ftotal)%></b></td></tr>
  <tr><td colspan="4" height="10"></td></tr>
  <tr><td>[A/C Assistant]</td><td>[Depositor]</td></tr>
 <tr><td colspan="4" height="40"></td></tr>
</table>
<%}%> 
 <% //}else{%>
  <!--<table width="100%" align="center" border="0"><tr><td><font color="darkred" size="3"><%=message%></td></tr></table>-->
  <%//}%>
</td></tr></table>
<input type="hidden" name="icar" value="<%=icar%>">
<input type="hidden" name="gate" value="<%=gate%>">
<input type="hidden" name="fee_total" value="<%=ftotal%>">
<input type="hidden" name="fee_rcpt" value="<%=seo.getFeeReceipt()%>">
<input type="hidden" name="reg_fee" value="<%=regis_fee%>">
<input type="hidden" name="session" value="<%=seo.getSession()%>">
<input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
<input type="hidden" name="regist_no" value="<%=seo.getRegistNo()%>">
<input type="hidden" name="sname" value="<%=seo.getSname()%>">  
<input type="hidden" name="fname" value="<%=seo.getFname()%>">  
<input type="hidden" name="type" value="<%=seo.getType()%>"> 
<input type="hidden" name="classes" value="<%=seo.getClasses()%>">
<input type="hidden" name="gender" value="<%=seo.getGender()%>">
<input type="hidden" name="freceipt" value="<%=seo.getFeeReceipt()%>">
<input type="hidden" name="degree" value="<%=seo.getDegree()%>">
<input type="hidden" name="branch" value="<%=seo.getBranch()%>">
<input type="hidden" name="l_date" value="<%=seo.getLastdate()%>">
<input type="hidden" name="m_fine" value="<%=seo.getMax_fine()%>">
<input type="hidden" name="semester" value="<%=seo.getSemester()%>">
<input type="hidden" name="college" value="<%=college%>">
</form> 
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
    out.println("EXC: "+e.getLocalizedMessage());
}%>

