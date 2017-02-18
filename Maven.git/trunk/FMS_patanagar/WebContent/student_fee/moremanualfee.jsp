<%-- 
    Document   : moremanualfee
    Created on : Sep 30, 2014, 6:57:23 PM
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
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    

FeeMath fm=new FeeMath();
ArrayList banklist=fm.bankList();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList list=new ArrayList();
if(request.getAttribute("list")!=null)
    list=(ArrayList)request.getAttribute("list");
SchoolEO seo1=null;  
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
<title>Manual Entry/Edit Of Fee</title>
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
         
    ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
    %>
         
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
<!--<form name="f1" method="post" action="<%=request.getContextPath()%>/feeprocess.do?method=feeprocessing" onsubmit="return validate()">-->
<form name="f1" method="post" action="<%=request.getContextPath()%>/manualfeeprocess.do?method=ManualFee_Processing" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Manual Entry/Edit Of Fee</font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
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
        </td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td>
       <td><input type="text" name="stud_id" value="<%=seo.getStud_id()%>" size="10"><input type="submit" name="submit" value="Check"></td></tr>
    <tr><td colspan="2" height="10"><hr></td></tr>
</table>  

    <hr color="maroon">
   <table width="80%" align="center">
           <tr><td align="left" widht="100%"><font color="yellow" size="3">
                   Fee can not be edit for this student because fee is submitted more than one times for this student for session (<%=seo.getSession()%> -<%=seo.getSession_sem()%>).
                   </font></td></tr>
      </table>
    
    <%if(request.getAttribute("msg1")!=null){%>
    <table width="60%" align="center">
           <tr><td align="left" widht="100%"><font color="yellow" size="2"><%=request.getAttribute("msg1")%></font></td></tr>
      </table>
    <%}%>
    <%if(!seo.getStud_id().equals("")){%>
    <table width="90%" align="center" border="1" style="border-collapse: collapse;">
        <tr>
          <%for(int k=0;k<list.size();k++)
          {
             seo1=(SchoolEO)list.get(k); 
             ArrayList heads=(ArrayList)seo1.getDataArray();
             HashMap hm=(HashMap)seo1.getDataMap();
             double tt=seo1.getFeeTotal();
            %>  
            <td><table>
        <tr><td height="20" colspan="2" align="center"><b style="font-size: 20px;">Fee Details</b></td></tr>
        <tr><td colspan="2"><b>Fee Scroll (<%=seo.getSession()%> -<%=seo.getSession_sem()%>)</b></td></tr>
        <tr><td width="50%"><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr>
        <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td></tr>
        <tr><td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <%if(k==0)
        {
            tt=seo.getFine()+tt;
        %>
        <tr><td align="left"><b>Fine</b></td><td> <%=seo.getFine()%></td></tr>
        <%}%>
        <tr><td><b>Total Fee Submitted</b></td><td><%=df.format(tt)%></td></tr>
         
        <tr><td colspan="2"><hr></td></tr>
        <%if(!seo1.getBankname().equals("")){%>
        <tr><td align="left"><b>Bank</b></td>
        <td align="right"> <%=seo1.getBankname()%>
                </td></tr>
        <%}%>
    <tr><td align="left"><b>Deposit Date</b>(dd/mm/yyyy)</td>
        <td align="right"><%=sde.format(seo1.getDeposite_date())%></td></tr>
        
                  <%for(int i=0;i<heads.size();i++){%>
                  <tr><td align="left"><%=heads.get(i)%></td>
                      <td align="right"><%=df.format(Double.parseDouble(hm.get(heads.get(i)).toString()))%></td></tr>
                  <%}%>
                  <tr><td align="left">PROGRAMME FEE</td>
                      <td align="right"><%=df.format(seo1.getPamount())%></td></tr>
                  <tr><td align="left">EXTRA</td>
                      <td align="right"><%=df.format(seo1.getEamount())%></td></tr>
                  <tr><td colspan="2"><hr></td></tr>
                 
                </table></td>
             <%}%>   
        </tr>
         <tr><td colspan="3" align="right">
                    <a href="./addManualMore.do?method=moreMaualFee&session=<%=seo.getSession()%>&stud_id=<%=seo.getStud_id()%>&session_sem=<%=seo.getSession_sem()%>">Add more fee</a>          
                </td></tr> 
     </table>
               
                
                
             <%}%>   
             </form>
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
out.println("kapil: "+e.getMessage());
}%>
