<%-- 
    Document   : dancable_Review_Order_connect2
    Created on : Oct 6, 2014, 12:07:27 PM
    Author     : kapil
--%>


<%@page import="java.util.Random"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.*,java.util.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<HTML> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
        <title>Online Fee Payment</title>
        <script language="JavaScript">     
function validate(){
    if(document.f1.elements["stud_id"].value==""){
alert("Enter Student Id");
document.f1.elements["stud_id"].focus();
return false;
 }
// if(document.f1.elements["stud_email"].value==""){
//alert("Enter Your Email Address to get your payment receipt at your mail.");
//document.f1.elements["stud_email"].focus();
//return false;
 //}
return true;
}
function validate1(){
    if(document.mainform.elements["fname"].value==""){
        alert("Please Enter Your First Name.");
        document.mainform.elements["fname"].focus();
        return false;
    }
    if(document.mainform.elements["email_ad"].value==""){
        alert("Please Enter Your Email Address.");
        document.mainform.elements["email_ad"].focus();
        return false;
    }
    if(document.mainform.elements["mob"].value==""){
        alert("Please Enter Your Mobile Number.");
        document.mainform.elements["mob"].focus();
        return false;
    }
    else if(document.mainform.elements["mob"].value.length>12){
        alert("Please Enter Valid Mobile Number.");
        document.mainform.elements["mob"].focus();
        return false;
    }
    return true;
}
</script> 
    </head> 
    
    <%
    SimpleDateFormat sde=new SimpleDateFormat("yyyy");
    SimpleDateFormat sde1=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String Styear=sde.format(dt1);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    
DecimalFormat df = new DecimalFormat("0.00");
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
%>

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

 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td bgcolor="#FFFFCC" align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_payment.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
           
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
                 <table width="100%" align="center">
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">Online Fee Payment</font></td>
                         <td align="right" valign="bottom"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></td>
                     </tr>
                 </table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/chkPayment.do?method=chk_payment" onsubmit="return validate()">
    <%if(request.getAttribute("msg")!=null){%>
        <table width="100%" align="center" valign="top">
            <tr><td colspan="2" align="center" valign="top">
            <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
        </table>
    <%}%>
<table width="35%" align="center">
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td>
       <td><input type="text" name="stud_id" value="" size="10"></td></tr>
   
   <tr><td colspan="2" align="center"><input type="submit" name="submit" value="Check"></td></tr>
   </table>  
</form>

<%if(seo.getCounter()!=2&&!seo.getSname().equals("")){%>
<table width="80%" align="center"><tr><td><hr></td></tr></table>
<table width="80%" align="center">
    <tr><td colspan="2"><b>Session (<%=seo.getSession()%> -<%=seo.getSession_sem()%>)</b></td></tr>
        <tr><td width="40%"><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr>
        <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td></tr>
        <tr><td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <%if(seo.getCounter()!=3){%>
        <tr><td align="left"><b>Fine</b></td><td> <%=seo.getFine()%></td></tr>
        <tr><td><b>Total Fee Submitted</b></td><td><%=df.format(seo.getFeeTotal())%></td></tr>
        <tr><td><b>Deposit Date</b></td><td><%=sde1.format(seo.getDeposite_date())%></td></tr>
        <!--<tr><td><b>Transaction Id</b></td><td><%=seo.getTransaction_id()%></td></tr>-->
        <%}%>
</table>

<%}%>
<table width="80%" align="center"><tr><td>
<%if(seo.getCounter()==2){%>

<%
double tot_amount=seo.getFeeTotal();
 tot_amount=seo.getFine()+tot_amount;   
session.setAttribute("seobean", seo);
String x_amount       = Double.toString(tot_amount);
     %>  
     <table width="100%" align="center"><tr><td><hr></td></tr></table>
		
<form name="mainform" method="post" action="<%=request.getContextPath()%>/next.do?method=checkDate" onsubmit="return validate1()">
<!--<form name="mainform" method="post" action="<%=request.getContextPath()%>/paymentresult.do">-->
<table width="100%" border="0" align="center">                 
<tr>
					
<td valign="top" width="100%">
      <table border="0" width="100%">
       <tr>
        <%
             ArrayList heads=(ArrayList)seo.getDataArray();
             HashMap hm=(HashMap)seo.getDataMap();
             
            %>  
            <td><table width="70%">
                    <tr><td colspan="2"><b>Fee Scroll for(<%=seo.getSession()%> -<%=seo.getSession_sem()%>)</b></td></tr>
        <tr><td width="40%"><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr>
        <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td></tr>
        <tr><td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <tr><td><b>Fee To Pay</b></td><td><%=df.format(tot_amount)%></td></tr>
        <tr><td><b>Date</b></td><td><%=sde1.format(seo.getDeposite_date())%></td></tr>
         <%if(hm!=null&&heads.size()!=0){%> 
         
        <tr><td colspan="2"><hr></td></tr>
        <tr><td colspan="2">
               <table width="90%">
                  <%for(int i=0;i<heads.size();i++){%>
                  <tr><td align="left"><%=heads.get(i)%></td><td align="right"><%=df.format(Double.parseDouble(hm.get(heads.get(i)).toString()))%></td></tr>
                  <%}%>
                  <tr><td align="left">PROGRAMME FEE</td><td align="right"><%=df.format(seo.getPamount())%></td></tr>
                  <tr><td align="left">Fine</td><td align="right"><%=df.format(seo.getFine())%></td></tr>
                  <tr><td colspan="2"><hr></td></tr>
                  <tr><td align="left"><b>Total</b></td><td align="right"><%=df.format(seo.getFeeTotal()+seo.getFine())%></td></tr>
                </table>
            </td></tr>
        <%}%>
        </table></td>
        <td valign="top">
            <table>
                <tr><td><font style="color: red">*</font><b>First Name</b></td><td><input type="text" name="fname"></td></tr>
                <tr><td><b>Last Name</b></td><td><input type="text" name="lname"></td></tr>
                <tr><td><font style="color: red">*</font><b>Email</b></td><td><input type="text" name="email_ad"></td></tr>
                <tr><td><font style="color: red">*</font><b>Mobile Number</b></td><td><input type="text" name="mob"  maxlength="12"></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit" id="button"></td></tr>
            </table>
        </td>     
        </tr>                    
</table></td></tr>

 </table>
     </form>
<%}%>
        </td>
        <td>
           <table>
               
                                                                                                                                          
             
              </table> 
        </td>
    </tr></table>
<table>
   <tr><td height="20"></td></tr> 
</table>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
