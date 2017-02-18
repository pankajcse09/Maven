<%-- 
    Document   : NewAdminNodues
    Created on : Jul 22, 2014, 1:59:09 PM
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

double tt=0.0;
if(request.getAttribute("tt")!=null){
tt=Double.parseDouble(request.getAttribute("tt").toString());   
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
<title>New Admission Nodues</title>
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
<body onload="focusField('stud_id');" bgcolor="#999933">
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
         ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/newAdminNodues.do?method=newAdminNodues" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top"><font color="darkred" size="3">New Adminssion No Dues</font></td></tr></table>
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
 <select name="session_sem">
    <%
    if(!seo.getSession_sem().equals("")){%>
    <option value="<%=seo.getSession_sem()%>"><%=seo.getSession_sem()%></option>
    <%}%>
    <option value="">select</option>
    <%for(int i=0;i<ar4.size();i++)
    {
if(!seo.getSession_sem().equals(ar4.get(i).toString())){
%>
    <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>
    <%}}%>
</select> 
        </td>
<td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font><br>
<input type="text" name="stud_id" value="" size="10">
<input type="submit" value="Show"></td></tr>    
</table>  
</form>
<hr color="maroon">
<table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
 <%if(request.getAttribute("msg1")!=null){%>
    <table width="45%" align="center">
           <tr><td align="left" widht="100%"><font color="yellow" size="2"><%=request.getAttribute("msg1")%></font></td></tr>
      </table>
    <%}%>
<form method="post" action="<%=request.getContextPath()%>/newProvideNodues.do?method=noduesProcessing">
<div id="printit">
    <%if(request.getAttribute("msg")!=null){%>
    <table width="45%" align="center">
           <tr><td align="left" widht="100%"><font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
      </table>
    <%}%>
    <%if(!seo.getStud_id().equals("")){%>
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
<font style="font-size:10"><b>Student Id:&nbsp;<%=seo.getStud_id().toUpperCase()%></b></font></td>
                </tr> 
             </table>
                <table>
                    <tr><td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Roll No:&nbsp;<%=seo.getRegistNo()%></b></font></td>
<td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Name:&nbsp;<%=seo.getSname().toUpperCase()%></b></font></td>
<td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Category:&nbsp;&nbsp;<%=seo.getCategory().toUpperCase()%></b></font></td>
</tr>
                </table>

<table>
    <tr>
    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Father's Name:&nbsp;<%=seo.getFname().toUpperCase()%></b></font></td>
    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>&nbsp;Programme:
  <%=seo.getDegree().toUpperCase()%></b></font></td>
    <!--<td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Gender:&nbsp;<%=seo.getGender().toUpperCase()%></b></font></td>-->

</tr> 

 <tr>
    <td align="left" height="10"></td>
</tr> 
<tr>
    <td style="border-collapse:collapse;border:0px solid black" align="left">
<font style="font-size:10"><b>Total Submitted:&nbsp;<%=tt%></b></font>
<% session.setAttribute("total_amount", Double.toString(tt));%>
    </td>
</tr> 
</table>
         </td></tr>
    
     <tr><td align="center" height="10"></td></tr>
     <tr><td border="1">
             <table>
                  <tr><td><hr></td></tr>
                 <tr><td align="center"><font style="size:24px"><b>Office Of The Comptroller</b></font></td></tr>
                 <tr><td align="center"><font style="size:16px"><b>No Dues outstanding. All fees and food charges paid.</b></font></td></tr>
                 
                 <tr><td align="center" height="15"></td></tr>
                 <tr><td align="right"><font style="size:16px"><b>For Comptroller</b></font></td></tr>
                 
                 <tr><td align="center" height="15"></td></tr>
                 <tr><td align="left"><font style="size:16px"><b>Date</b></font></td></tr>
                 
          <tr><td align="center"><font style="size:14px">No-Dues Stamp</td></tr>
          
          <tr><td align="center" height="25"></td></tr>
                 
                 
             </table>
         </td></tr>
</table>

</div>
<input type="hidden" name="session" value="<%=seo.getSession()%>">
<input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
<input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
<%if(seo.getCounter()!=2){%>
<%if(urb.getUr_update().equals(s)||urb.getUr_create().equals(s)){%>  
<table width="100%" align="left" border="0" style="border-collapse: collapse;" valign="top" cellpadding="0" cellspacing="0">
    <tr><td><input type="submit" name="nd" value="No Dues"></td></tr>
</table>
<%}%>
<%}}%>
</form>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>


