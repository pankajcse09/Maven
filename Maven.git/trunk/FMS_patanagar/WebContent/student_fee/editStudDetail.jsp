<%-- 
    Document   : editStudDetail
    Created on : Aug 8, 2013, 10:51:19 AM
    Author     : kapil
--%>

<%@page import="Fee.FeeMath"%>
<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
ArrayList ddlist=new ArrayList();
if(request.getAttribute("ddlist")!=null)
   {
   ddlist=(ArrayList)request.getAttribute("ddlist");
    }
String changeToDegree="";
double submittedFee=0;
double nowSubmitFee=0;
double self_finan_fee=0;
String prv_stud_type="";
if(request.getAttribute("self_finan_fee")!=null)
       {
    self_finan_fee=Double.parseDouble(request.getAttribute("self_finan_fee").toString());
}
if(request.getAttribute("nowSubmitFee")!=null)
       {
    nowSubmitFee=Double.parseDouble(request.getAttribute("nowSubmitFee").toString());
}
if(request.getAttribute("submittedFee")!=null)
       {
    submittedFee=Double.parseDouble(request.getAttribute("submittedFee").toString());
}
if(request.getAttribute("changeToDegree")!=null)
       {
    changeToDegree=(String)request.getAttribute("changeToDegree");
}
if(request.getAttribute("prv_stud_type")!=null)
       {
    prv_stud_type=(String)request.getAttribute("prv_stud_type");
}

double adjustment=(nowSubmitFee+self_finan_fee)-submittedFee;


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
if(request.getAttribute("jbean1")!=null){
seo1=(SchoolEO)request.getAttribute("jbean1");   
}
ArrayList ar=(ArrayList)seo.getDataArray2();
HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;

ArrayList degreelist=new ArrayList();
  JavaBean de=new JavaBean();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
  ArrayList al=new ArrayList();
  al.add("Hosteller");
  al.add("Day Scholar");
  al.add("Staff");
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
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>Edit Student Details</title>
<script language="javascript">
 function checkDegree(){
 document.f2.method="post";
 document.f2.action="<%=request.getContextPath()%>/checkDegreeChangeFee.do?method=checkAmount";
 document.f2.submit();
 }

 function focusField(a){
 document.f1.elements[a].focus();
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

function validate1()
{
    
        if(document.f2.elements["dd_1"].value=="")
        {
            alert("Please Draft no for 1");
           document.f2.elements["dd_1"].focus();
            return false;
        }
        if(document.f2.elements["damnt_1"].value=="")
        {
            alert("Please Amount for 1");
           document.f2.elements["damnt_1"].focus();
            return false;
        }
        if(document.f2.elements["bnk_1"].value=="")
        {
            alert("Please Bank name for 1");
           document.f2.elements["bnk_1"].focus();
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/getStudent.do?method=getStudentDetail" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top"><font color="darkred" size="3">Edit Student Details</font></td></tr></table>
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
</select></td>
<td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font><br>
<input type="text" name="stud_id" value="<%=seo.getStud_id()%>" size="10">
<input type="submit" value="Show"></td></tr>    
</table>  
</form>
<hr color="maroon">

<table width="80%" ><tr>
                         <td align="center"><font color="yellow" size="4">
                             <% if(request.getAttribute("msg")!=null){%>
                             <%=request.getAttribute("msg")%></font>
                         <%}%></td>
                     </tr></table>
<form name="f2" method="post" action="<%=request.getContextPath()%>/updateStud.do?method=updateStudDetail">
<!--<form name="f2" method="post" action="<%=request.getContextPath()%>/updateStud.do?method=updateStudDetail1" onsubmit="return validate1()">-->                         
<% if(seo1!=null)
       {
    
%>

<table border="1" style="border-collapse: collapse" align="center" width="80%">
    <tr><td>
<table>
    <tr><td colspan="4"><font style="font-size: 16px"><b>Student Details</b></font></td>
        
    <tr><td colspan="1"><b>Session:</b></td><td colspan="2"><%=seo1.getSession()%></td></tr>
    <input type="hidden" name="session" value="<%=seo1.getSession()%>">
    <tr><td colspan="1"><b>Student Id:</b></td><td colspan="2"><%=seo1.getStud_id()%></td></tr>
    <input type="hidden" name="stud_id" value="<%=seo1.getStud_id()%>">
    <tr><td colspan="1"><b>Student Name:</b></td><td colspan="2"><%=seo1.getSname()%></td></tr>
    <input type="hidden" name="sname" value="<%=seo1.getSname()%>">
    <tr><td colspan="1"><b>Father Name:</b></td><td colspan="2"><%=seo1.getFname()%></td></tr>
    <input type="hidden" name="fname" value="<%=seo1.getFname()%>">
    
    <tr><td colspan="1"><b>Programee:</b></td><td colspan="2"><%=seo1.getDegree()%></td></tr>
    
<input type="hidden" name="prev_degree" value="<%=seo1.getDegree()%>">  

<%if(!prv_stud_type.equals("")){%>
<input type="hidden" name="prev_stud_type" value="<%=prv_stud_type%>">
<%}else{%>
<input type="hidden" name="prev_stud_type" value="<%=seo1.getStud_type()%>">
<%}%>
    <tr><td colspan="5"></td></tr>
    <tr><td colspan="5"></td></tr>
     <%if(!changeToDegree.equals("")){%>
    <tr><td colspan="1"><b>Previous Programme Fee:</b></td><td colspan="2"><%=submittedFee%></td></tr>
    <tr><td colspan="1"><b>New Programme Fee:</b></td><td colspan="2"><%=nowSubmitFee%><input type="hidden" name="npfee" value="<%=nowSubmitFee%>"></td></tr>
    <tr><td colspan="1"><b>Self Finance Fee:</b></td><td colspan="2"><%=self_finan_fee%></td></tr>
    <tr><td colspan="1"><b>Adjustment:</b></td><td colspan="2"><%=adjustment%></td></tr>
    <tr><td><font style="font-size: 10px"><b>DD no</b></font></td><td><font style="font-size: 10px"><b>Date</b></font></td>
     <td><font style="font-size: 10px"><b>Bank</b></font></td><td><font style="font-size: 10px"><b>Amount (Rs.)</b></font></td></tr>
    <tr><td colspan="5" height="10"></td></tr>
 <tr><td colspan="4" align="left"><font style="font-size: 10px"><b>Details of Deposited Amount / Adjusted Amount</b></font></tr>
  <%
  DecimalFormat df = new DecimalFormat("0.00");
  ReportsEO reo=null;
 for(int l=0;l<ddlist.size();l++)
                            {
                            reo=(ReportsEO)ddlist.get(l);
                                %>
  <tr><td style="font-size: 10px"><%=reo.getDraft_no()%></td><td style="font-size: 10px"><%=reo.getDate()%></td>
      <td style="font-size: 10px"><%=reo.getBank()%></td>
      <td style="font-size: 10px"><%=df.format(reo.getAmount())%></td></tr>
  <%}%>
    <%}%>
    
    
    <input type="hidden" name="adjustment" value="<%=adjustment%>">
    <tr><td colspan="5"></td></tr>
    <tr><td colspan="5"></td></tr>
    <%if(request.getAttribute("chk").equals("edit")){%>
    <% if(seo1.getDegree()!=null){%>
    <tr><td colspan="5" height="15"><hr></td></tr>
    <tr><td colspan="5"><font style="font-size: 16px"><b>Updation Fields</b></font></td></tr>
    
       <tr align="left">
           <td><b>Degree</b></td><td>
           <select name="degree" onchange="checkDegree()">
           <!--<select name="degree">-->
               <%if(changeToDegree.equals("")){%>
    <option value="<%=seo1.getDegree()%>"><%=seo1.getDegree()%></option>
    <%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(seo1.getDegree())){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
    <%}else{%>
        <option value="<%=changeToDegree%>"><%=changeToDegree%></option>
        <%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(changeToDegree)){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
    <%}%>

</select>
           </td>
           <td></td>
            <td><b>Student Type</b></td><td>
                <select name="stud_type" onchange="checkDegree()">
                    <option value="<%=seo1.getStud_type()%>"><%=seo1.getStud_type()%></option>
                    <%for(int i=0;i<al.size();i++){
                        if(!al.get(i).toString().equals(seo1.getStud_type())){
                    %>
                        <option value="<%=al.get(i)%>"><%=al.get(i)%></option>
                    <%}}%>
                </select>
            </td>
       </tr>
       <tr align="left">
           <td><b>ICAR</b></td><td>
               <select name="icar">
                    <option value="<%=seo1.getIcar()%>"><%=seo1.getIcar()%></option>
    <option value="NO">No</option>
<option value="YES">Yes</option>
</select>
           </td>
           <td></td>
           <% if(seo1.getDegree()!=null&&seo1.getDegree().equals("M.Tech"))
                                       {%>
            <td><b>Gate</b></td><td>
                <select name="gate">
                           <option value="<%=seo1.getGate()%>"><%=seo1.getGate()%></option>
                           <option value="NO">NO</option>
                                <option value="YES">YES</option>
                         </select>
            </td>
            <%}%>
       </tr>
       <%} else{%>
        <tr><td colspan="5"><font style="font-size: 16px" color="yellow"><b>Seat is not alloted.</b></font></td></tr>
       <%}%>
       
     <%} else{%>
     <tr><td colspan="5" height="15"><hr></td></tr>
     <tr><td colspan="5"><font style="font-size: 16px"><b>Updated Fields</b></font></td></tr>
    
       <tr align="left">
           <td><b>Degree:</b></td><td><%=seo1.getDegree()%></option></td>
           <td></td>
            <td><b>Student Type:</b></td><td><%=seo1.getStud_type()%></td>
       </tr>
       <tr align="left">
           <td><b>ICAR: </b></td><td><%=seo1.getIcar()%></td>
           <td></td>
           <% if(seo1.getDegree().equals("M.Tech"))
                                       {%>
            <td><b>Gate: </b></td><td><%=seo1.getGate()%></td>
            <%}%>
       </tr>
     
     <%}%>
     <%if(adjustment>0)
     {
     FeeMath fm=new FeeMath();
     ArrayList banklist=fm.bankList();
%>
     <tr><td colspan="5" height="15"><hr></td></tr>
     <tr><td colspan="5"><font style="font-size: 16px"><b>Receive Adjustment Amount</b></font></td></tr>
    
       <tr align="center"><td></td><td><b>DD no</b></td><td><b>Date<font color="red">(dd/mm/yyyy)</font></b></td><td><b>Amount</b></td><td><b>Bank</b></td></tr>
     <% for(int j=0;j<2;j++){%>
                            <tr><td><b>Cash Receipt #<%=j+1%></b></td><td><input type="text" name="dd_<%=j+1%>" value=""></td><td style="padding-right: 10px"><script>DateInput('dddate_<%=j+1%>',true,'dd/mm/yyyy')</script><!--<input type="text" name="dddate_<%=j+1%>" value="">--></td>
                                <td><input type="text" name="damnt_<%=j+1%>" value=""></td><td><% if(banklist.size()!=0){%>
            <select name="bnk_<%=j+1%>">
                <option value="">select</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select>
        <%}%></td>
                            </tr>
                            <%}%>
      <%}%>
     
</table>  
        </td></tr>
    <%if(request.getAttribute("chk").equals("edit")){%>
    <tr><td align="center"><input type="submit" value="Submit"></td></tr>
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


