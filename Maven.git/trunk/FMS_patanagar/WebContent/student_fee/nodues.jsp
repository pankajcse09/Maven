<%-- 
    Document   : nodues
    Created on : May 24, 2014, 11:58:48 AM
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
<script language="javascript">
function changeCSS()
{
      document.f2.method="post";
      document.f2.action="<%=request.getContextPath()%>/checkNoduesed.do?method=checkNoduesProcess";
      document.f2.submit();
}
  </script>
<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    
MyMeth mm=new MyMeth();
FeeMath fm=new FeeMath();
ArrayList banklist=fm.bankList();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar=seo.getDataArray();
ArrayList ar1=seo.getDataArray1();
ArrayList ar5=seo.getDataArray5();
HashMap hm=seo.getDataMap();
HashMap hm1=seo.getDataMap1();
 SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String ddate="";
try{
    ddate=(String)sde.format(dt1);
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
<title>No Dues</title>
<script language="JavaScript">     
function validate(){
    if(document.f1.elements["session_sem"].value==""){
alert("Please select semester of this session.");
document.f1.elements["session_sem"].focus();
return false;
 }
    if(document.f1.elements["stud_id"].value==""){
alert("Enter Student Id");
document.f1.elements["stud_id"].focus();
return false;
 }

if(document.f1.elements["famount"].value==""){
alert("Enter Amount");
document.f1.elements["famount"].focus();
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
        if(document.f2.nod[0].checked==false&&document.f2.nod[1].checked==false){    
        alert("Please check the button for receive or refund.");
        //document.f1.kind[0].focus();
        return false;        
    } 
        return true;
}

 function genReceipt(stdid){
window.open('<%=request.getContextPath()%>/gen_NoduesReceipt.do?method=noduesReceipt&stud_id='+stdid,'trace','width=1260,height=650,toolbar=no,scrollbars=yes,resizable=no');
 }
</script>
<script language="JavaScript">     
function calTot(a){
    var tt=0;
    var ffield=document.getElementById("field18").value;
    var sz=document.f2.sz.value;
    for(var i=0;i<sz;i++){
        tt=parseFloat(tt)+parseFloat(document.f2.elements["fee"+i].value);
    }
    tt=2*parseFloat(ffield)-parseFloat(tt);
    document.f2.ttamnt.value=tt;
    document.getElementById("tt").innerHTML=tt;
   // alert(tt);
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
.displayno{display: none;}
.displayes{display: block;}
         </style>   

          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
<form name="f1" method="post" action="<%=request.getContextPath()%>/checkNoduesed.do?method=checkNoduesProcess" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Final No Dues</font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    
<table width="35%" align="center">
    <!--<tr><td valign="top"><font style="font-size:12;color:white"><b>Batch</b></font></td>
        <td><select name="batch">
<%if(!seo.getBatch().equals("")){%>   
<option value="<%=seo.getBatch()%>"><%=seo.getBatch()%></option>
<%}for(int i=7;i>=0;i--)
{
    if(!seo.getBatch().equals(Syear-i)){
        %>
<option value="<%=Syear-i%>"><%=Syear-i%></option>
<%}}%>
</select></td></tr>-->
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select>
<select name="session_sem">
    <option value="">select</option>
    <option value="I">I</option>
    <option value="II">II</option>
</select>        
        </td></tr>
    <!--<tr><td valign="top"><font style="font-size:12;color:white"><b>For</b></font></td>
    <td><select name="session_sem">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}%> 
<option value="I">I</option>
<option value="II">II</option>
</select></td></tr>-->
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td>
        <td><input type="text" name="stud_id" value="<%=seo.getStud_id()%>" size="10"><input type="submit" name="submit" value="Check"></td></tr>
    <tr><td></td><td></td></tr> 
</table>  
</form>
    <hr color="maroon">
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>
    <form name="f2" action="<%=request.getContextPath()%>/noduesed.do?method=studentnodues" method="post" onsubmit="return validate1()">
    <table width="90%" align="center">
        <tr><td width="40%">
                <table width="100%">
                    <%if(ar.size()!=0){%>
        <tr><td colspan="4">
                <table border="1" style="border-collapse: collapse" width="100%">
                    <tr><td><b>Sr No.</b></td><td align="center"><b>Heads</b></td><td align="right"><b>Amount</b></td></tr>
                    <%
                    double tt=0.0;
                    for(int i=0;i<ar.size();i++){
                        double ttinv=Double.parseDouble(hm.get(ar.get(i)).toString());
                        tt=tt+ttinv;
                    %>
                    <tr><td><%=i+1%>.</td><td align="left"><%=ar.get(i)%></td>
                        <td align="right"><%=df.format(ttinv)%></td></tr>
                    
                        <%}%>
                    <tr><td colspan="2" align="right"><b>Total</b></td><td align="right"><%=df.format(tt)%> </td></tr>
                </table>
            </td></tr>
        <%}%>
        <%
        //out.println("kapil: "+seo.getCautionMoney());
        ArrayList al=new ArrayList();
        al.add("Degree Complete");
        al.add("Before Registration");
        al.add("After Registration");
        double tt=0.0;
        if(hm1.size()!=0){%>
        <tr><td colspan="4">
                
                    <table border="1" style="border-collapse: collapse" width="100%">
                        <tr><td align="left"><b>Reason: </b></td>
                            <td>
                                <select name="reason" onchange="changeCSS()">
                                    <option value="<%=seo.getReason()%>"><%=seo.getReason()%></option>
                                    <%for(int i=0;i<al.size();i++)
                                         {
                                        if(!al.get(i).toString().equals(seo.getReason())){%>
                                            <option value="<%=al.get(i)%>"><%=al.get(i)%> </option>
                                    <%}}%>
                                    <!--<option value="Other">Other</option>-->
                                </select>
                            </td></tr>
                        <tr id="rsn" class="displayno"><td></td>
                            <td>
                                <input type="text" name="other">
                            </td></tr>
                    </table>
                <table border="1" style="border-collapse: collapse" width="100%">
                    <tr><td align="center"><b>Heads</b></td><td align="right"><b>Amount</b></td></tr>
                    <%
                    double mthfdbill=Double.parseDouble(hm1.get("MONTHLY FOOD BILL").toString());
                    for(int i=0;i<ar1.size();i++){
                        //if(!ar1.get(i).equals("FOOD ADVANCE")&&!ar1.get(i).equals("CAUTION MONEY")){
                           //out.println("kapil: "+(ar1.get(i).toString().equals("CAUTION MONEY")));
                            tt=tt+Double.parseDouble(hm1.get(ar1.get(i)).toString());
                    %>
                    <tr><td align="left"><%=ar1.get(i)%><input type="hidden" name="field<%=i%>" value="<%=ar5.get(i)%>"></td>
                       <td align="right"><input type="text" name="fee<%=i%>" value="<%=hm1.get(ar1.get(i)).toString()%>" onblur="calTot(this.value)" id="<%=ar5.get(i)%>"></td></tr>
                    
                        <%}//out.println(tt);
                            tt=(2*mthfdbill)-tt;
                                %>
                        <input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
                        <input type="hidden" name="session" value="<%=seo.getSession()%>">
                        <input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
                        <input type="hidden" name="ttamnt" value="<%=tt%>">
                        <input type="hidden" name="sz" value="<%=ar1.size()%>">
                </table>
                
            </td></tr>
        <%}%>
                </table>
            </td>
            <td valign="top" width="60%">
                <%if(!seo.getSname().equals("")){%>
                <table width="90%">
                    <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td>
            <td><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td>
        <td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <tr><td><b>Registration: </b></td><td><%=seo.getReg()%></td>
        <%if(!seo.getReason().equals("")){%>
        <td><b>Reason: </b></td><td><%=seo.getReason()%></td>
        <%}%></tr>
        
        <%if(hm.size()!=0)
        {%>
        <tr><td><b>Status</b></td><td><%=seo.getStatus()%></td><td><b>Total Amount: </b></td><td><%=seo.getTfee()%></td></tr>
        <%}%>
        <tr>
            <%if(hm.size()==0){%>
            <td><b>Total Amount: </b></td><td id="tt"><%=tt%></td>
            <%}%>
            <td><b>Session: </b></td><td><%=seo.getSession()%>-<%=seo.getSession_sem()%></td></tr>
        <%
               if(seo.getStatus().equals("receive")){%>
        <tr><td colspan="4"><a href="#" onclick="genReceipt('<%=seo.getStud_id()%>')">Receipt</a></td></tr>
        <%}%>
        <tr><td colspan="4"><hr></td></tr>
        <%if(hm.size()==0){%>
        <tr><td colspan="4"><table>
        <tr align="center"><td></td><td><b>DD/Check no</b></td><td><b>Date<font color="red">(dd/mm/yyyy)</font></b></td><td><b>Amount</b></td>
            <td><b>Bank</b></td></tr>
     <% for(int j=0;j<1;j++){%>
                            <tr><td><b>Cash Receipt #<%=j+1%></b></td><td><input type="text" name="dd_<%=j+1%>" value="" size="10"></td>
                                 <td style="padding-right: 10px"><script>DateInput('dddate_<%=j+1%>',true,'dd/mm/yyyy')</script><!--<input type="text" name="dddate_<%=j+1%>" value="">--></td>
                                <td><input type="text" name="damnt_<%=j+1%>" value="" size="10"></td>
          <td><% if(banklist.size()!=0){%>
            <select name="bnk_<%=j+1%>">
                <option value="">select</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select>
        <%}%></td>
                            </tr>
                            <%}%>
                </table></td></tr>  
        <tr><td colspan="4"><font style="color: yellow"><b>Please check the button for receive or refund.</b></font></td></tr>
        <tr><td>Receive <input type="radio" name="nod" value="receive"></td>
            <td>Refund <input type="radio" name="nod" value="refund"></td></tr>
        <tr><td align="left" colspan="4"><button name="subm" value="receive" onclick="">Submit</button></td></tr>
        <%}%>
                </table>
            <%}%>
            </td>
        </tr>
        
        
    </table>
        </form>            
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
 
}%>

