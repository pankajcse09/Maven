<%-- 
    Document   : additionalFee
    Created on : Aug 8, 2013, 10:52:20 AM
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
  String edit="done";
  String edit1="edit";
          if(request.getAttribute("edit")!=null)
               {
    edit=(String)request.getAttribute("edit");
}
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
        return true;
}

function validate1()
{
    if(document.f2.elements["dd_2"].value=="")
        {
            alert("Please Draft no  Cash Receipt 1");
           document.f2.elements["dd_2"].focus();
            return false;
        }
        if(document.f2.elements["damnt_2"].value=="")
        {
            alert("Please Amount Cash Receipt 1");
           document.f2.elements["damnt_2"].focus();
            return false;
        }
        if(document.f2.elements["bnk_2"].value=="")
        {
            alert("Please Bank name Cash Receipt 1");
           document.f2.elements["bnk_2"].focus();
            return false;
        }
        if(document.f2.elements["dd_3"].value.length!=0)
        {
            if(document.f2.elements["damnt_3"].value=="")
        {
            alert("Please Amount Cash Receipt for 2");
           document.f2.elements["damnt_3"].focus();
            return false;
        }
            if(document.f2.elements["bnk_3"].value=="")
        {
            alert("Please Bank name Cash Receipt for 2");
           document.f2.elements["bnk_3"].focus();
            return false;
        }
           
        }
        if(document.f2.elements["dd_4"].value.length!=0)
        {
            if(document.f2.elements["damnt_4"].value=="")
        {
            alert("Please Amount Cash Receipt for 3");
           document.f2.elements["damnt_4"].focus();
            return false;
        }
            if(document.f2.elements["bnk_4"].value=="")
        {
            alert("Please Bank name for Cash Receipt 3");
           document.f2.elements["bnk_4"].focus();
            return false;
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
        SchoolEO seo1=new SchoolEO(); 
         SchoolEO seo2=new SchoolEO(); 
          ArrayList al=new ArrayList();
          ArrayList al1=new ArrayList();
    if(request.getAttribute("list")!=null){
al=(ArrayList)request.getAttribute("list");
}
        
          if(request.getAttribute("list1")!=null){
al1=(ArrayList)request.getAttribute("list1");
seo2=(SchoolEO)al1.get(1);  
}
          ArrayList banklist=new ArrayList();
if(request.getAttribute("bnklist")!=null)
       {
    banklist=(ArrayList)request.getAttribute("bnklist");
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/getStudentFeeRecord.do?method=retFeeData" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top"><font color="darkred" size="3">Additional Fee</font></td></tr></table>
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
<td valign="top"><font style="font-size:12;color:white"><b>Roll No</b></font><br>
<input type="text" name="regist_no" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="Show"></td></tr>    
</table>  
</form>
<hr color="maroon">

<table width="80%" ><tr><td>
                         <td align="center"><font color="yellow" size="4">
                             <% if(request.getAttribute("msg")!=null){%>
                             <%=request.getAttribute("msg")%></font>
                         <%}%></td>
                     </tr></table>
<form name="f2" method="post" action="<%=request.getContextPath()%>/updateStudentFeeRecord.do?method=updStudentFeeRecord" onsubmit="return validate1()">
<table width="80%" align="center" cellspacing="5" cellpadding="5"><tr>
        <td width="60%">
            <table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black">
                 <tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Fee Receipt No.&nbsp;&nbsp;&nbsp;&nbsp;<%=seo2.getFeeReceipt()%></b></font></td></tr>
 <tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%=seo.getSname().toUpperCase()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Category:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getCategory().toUpperCase()%></b></font></td>
</tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Gender:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getGender().toUpperCase()%></b></font></td></tr> 
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Father's Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getFname().toUpperCase()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Roll No:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo.getSrnum()%></b></font></td></tr>
<tr><td style="border-collapse:collapse;border:1px solid black">
<font style="font-size:12"><b>Programme:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;<%=seo.getDegree().toUpperCase()%>&nbsp;&nbsp;</b></font></td></tr>
 <input type="hidden" name="session" value="<%=seo.getSession()%>">
  <input type="hidden" name="regist_no" value="<%=seo.getSrnum()%>">
 <input type="hidden" name="fee_rcpt" value="<%=seo2.getFeeReceipt()%>">
 <input type="hidden" name="sname" value="<%=seo.getSname().toUpperCase()%>">
<input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
</table> 
<%
long n=0;
 double adjst=0.0;
 double ftotal=0.0;
 double submitedfee=0.0;
 //if(seo.getDataArray5().size()!=0&&seo.getDataArray7().size()!=0)
//{
%>

<table width="100%" align="center" border="0" style="border-collapse:collapse;border:1px solid black">
    <tr>
        <td><table border="0" style="padding-top: 20px">
                
                <tr><td colspan="2"><table width="100%">
                            
                            <tr align="center"><td></td><td><b>DD no</b></td><td><b>Date<font color="red">(dd/mm/yyyy)</font></b></td><td><b>Amount</b></td><td><b>Bank</b></td></tr>
                            <% for(int i=0;i<al.size();i++){
         seo1=(SchoolEO)al.get(i);
    %>

                            <tr><td><b>Advance Fee</b></td><td><input type="text" value="<%=seo1.getDdno()%>" disabled></td><td><input type="text" value="<%=seo1.getDdate()%>" disabled></td>
                                <td><input type="text" value="<%=seo1.getDdamount()%>" disabled></td><td><input type="text" value="<%=seo1.getBankname()%>" disabled></td>
                            </tr>
<%}%>

 <% for(int j=1;j<al1.size();j++){
         seo2=(SchoolEO)al1.get(j);
    %>

                            <tr><td><b>Program Fee</b></td><td><input type="text" value="<%=seo2.getDdno()%>" disabled></td><td><input type="text" value="<%=seo2.getDdate()%>" disabled></td>
                                <td><input type="text" value="<%=seo2.getDdamount()%>" disabled></td><td><input type="text" value="<%=seo2.getBankname()%>" disabled></td>
                            </tr>
<%}%>

                            <%if(!edit.equals("done")&&edit1.equals("edit")){%>
                            <% for(int k=0;k<3;k++){%>
                            <tr><td><b>Cash Receipt #<%=k+1%></b></td><td><input type="text" name="dd_<%=k+2%>" value=""></td>
    <td><!--<input type="text" name="dddate_<%=k+2%>" value="">--><script>DateInput('dddate_<%=k+2%>',true,'dd/mm/yyyy')</script></td>
                                <td><input type="text" name="damnt_<%=k+2%>" value=""></td>
                                <td>
                                     <% if(banklist.size()!=0){%>
                                    <select name="bnk_<%=k+2%>">
                                        <option value="">Select</option>
                                     <% for(int i=0;i<banklist.size();i++){
                   SchoolEO sco=(SchoolEO)banklist.get(i);
               %>
               <option value="<%=sco.getBankname()%>"><%=sco.getBankname()%></option>
               <%}%>
            </select>
        <%}%></td>
                            </tr><input type="hidden" name="feeType_<%=k+2%>" value="addmission fee">
                            <input type="hidden" name="rowid_<%=k+2%>" value="<%=n%>">
                            <%}%>
                         <%}%>  
                        </table>
               </td></tr>
            </table></td>
    </tr>
    <%if(!edit.equals("done")&&edit1.equals("edit")){%>
    <tr><td align="center"><input type="submit" value="Submit Fee"></td></tr>
     <%}%>
</table>

   </td></tr></table>
</form>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){out.println("'<b>'Program fee is not submitted'</b>'");
}%>



