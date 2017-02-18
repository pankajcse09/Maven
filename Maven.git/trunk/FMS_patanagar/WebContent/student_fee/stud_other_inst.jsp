<%-- 
    Document   : stud_other_inst
    Created on : Oct 2, 2014, 1:32:56 PM
    Author     : kapil
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="EO.ReportsEO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Fee.FeeMath"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
ReportsEO reo=new ReportsEO();  

 SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
   try{
    DecimalFormat df = new DecimalFormat("0.00");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>College Management System</title>
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

if(document.f1.elements["amount"].value==""){
alert("Enter Amount");
document.f1.elements["amount"].focus();
return false;
 }
if(document.f1.elements["bnk_name"].value==""){
alert("Please select bank.");
document.f1.elements["bnk_name"].focus();
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
         String trans="";
         if(request.getAttribute("trans")!=null)
             trans=(String)request.getAttribute("trans");
        ArrayList list=new ArrayList();
        if(request.getAttribute("list")!=null)
        list=(ArrayList)request.getAttribute("list");
        int curpage=1;
        int noOfPages=1;
        int offset=0;
          if(request.getAttribute("currentPage")!=null)
           {
              curpage=Integer.parseInt(request.getAttribute("currentPage").toString());
           }
          if(request.getAttribute("noOfPages")!=null)
           {
              noOfPages=Integer.parseInt(request.getAttribute("noOfPages").toString());
           }
          if(request.getAttribute("offset")!=null)
           {
              offset=Integer.parseInt(request.getAttribute("offset").toString());
           }
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/othercollegestud.do?method=othercollegestud" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkblue" size="4"><b>Student Details Of Other College</b></font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>
<table width="35%" align="center">
    <tr><td colspan="2" align="left"><font color="darkred" size="2"><b>* Fields are mandatory</b></font></td></tr>
    <tr><td valign="top"><font color="darkred">*</font><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
<%if(!reo.getSession().equals("")){%>   
<option value="<%=reo.getSession()%>"><%=reo.getSession()%></option>
<%}if(!reo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!reo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
 <select name="session_sem">
    <%
    if(!reo.getSession_sem().equals("")){%>
    <option value="<%=reo.getSession_sem()%>"><%=reo.getSession_sem()%></option>
    <%}%>
    <option value="">select</option>
    <%for(int i=0;i<ar4.size();i++)
    {
if(!reo.getSession_sem().equals(ar4.get(i).toString())){
%>
    <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>
    <%}}%>
</select> 
        </td></tr>
   <tr><td valign="top"><font color="darkred">*</font><font style="font-size:12;color:white"><b>Student Id</b></font></td>
       <td><input type="text" name="stud_id" value="" size="20"></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Name</b></font></td>
       <td><input type="text" name="sname" value="" size="20"></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Programme</b></font></td>
       <td><input type="text" name="degree" value="" size="20"></td></tr>
   <tr><td valign="top"><font color="darkred">*</font><font style="font-size:12;color:white"><b>Amount</b></font></td>
       <td><input type="text" name="amount" value="" size="20"></td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Receipt No</b></font></td>
       <td><input type="text" name="receipt_no" value="" size="20"></td></tr>
    <tr><td align="left"><font color="darkred">*</font><font style="font-size:12" color="white"><b>Bank</b></font></td>
        <td> <select name="bnk_name">
                <option value="">select</option>
                <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td></tr>
     <tr><td align="left"><font style="font-size:12" color="white"><b>Deposit Date</b></font></td>
                <td align="left"><script>DateInput('date1',true,'dd/mm/yyyy')</script></td></tr>
    <tr><td></td><td><input type="submit" name="type" value="Submit"></td></tr>
  </table>  
</form>
    <hr color="maroon">
    <form name="f2" method="post" action="<%=request.getContextPath()%>/othercollegestud.do?method=othercollegestud">
                <table width="70%" align="left">
                    <tr><td width="100%" align="left">
                            <b>Transfered</b>
                            <select name="trans">
                                <option value="Both">Both</option>
                                <option value="Yes">Yes</option>
                                <option value="No">No</option>
                            </select>
                        </td></tr>
                    <tr><td><input type="submit" name="type" value="View List"></td></tr>
                </table>   
            </form>
    <%
    if(list.size()!=0){
                int size=list.size();
                double total=0;
            %>
            <table width="85%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
            <div id="printit">
            <table width="100%" border="1" style="border-collapse: collapse;">
                <tr><td colspan="12" style="font-family: Arial, Helvetica, sans-serif;font-size: 14px;" align="center">
                        <b>List Of Other College Student Details</b></td></tr>
                        <tr style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;">
                            <th>Sr. No.</th>
                            <th>Session</th>
                            <th>Student Id</th>
                            <th>Student Name</th>
                            <th>Programme</th>
                            <th>Bank</th>
                            <th>Receipt No</th>
                            <th>Deposit Date</th>
                            <th>Transfered Date</th>
                            <th>Transfered To</th>
                            <th align="right">Amount</th>
                            <th>Transfer</th>
                         </tr>
               <%for(int i=0;i<size;i++){
                        reo=(ReportsEO)list.get(i);
                        total=total+reo.getAmount();
                         %>
                         <tr>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%=++offset%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%=reo.getSession()%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%=reo.getStud_id()%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%if(reo.getSname()!=null){%>
                                 <%=reo.getSname()%>
                                 <%}else{%>
                                    NA
                                    <%}%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%if(reo.getDegree()!=null){%>
                                 <%=reo.getDegree()%>
                                 <%}else{%>
                                    NA
                                    <%}%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%=reo.getBank()%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%if(reo.getNumber()!=null){%>
                                 <%=reo.getNumber()%>
                                 <%}else{%>
                                    NA
                                    <%}%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%=sde.format(reo.getDate1())%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;">
                                 <%if(reo.getDate2()!=null){%>
                                 <%=sde.format(reo.getDate2())%>
                                 <%}else{%>
                                    NA
                                    <%}%>
                             </td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%if(reo.getTransfered_to()!=null){%>
                                 <%=reo.getTransfered_to()%>
                                 <%}else{%>
                                    NA
                                    <%}%></td>
                             <td align="right" style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><%=df.format(reo.getAmount())%></td>
                             <td style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;">
                                 <%if(reo.getStatus().equals("No")){%>
                                 <a href="./student_fee/stud_other_inst_trans.jsp?rid=<%=reo.getRwid()%>&trans=<%=trans%>&page=<%=curpage%>">
                                     Transfer</a>
                             <%}else{%>
                                <%=reo.getStatus()%>
                             <%}%>
                             </td>
                         </tr>
                         <%}%>
                         <tr>
                             <td colspan="10" align="right" style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><b>Total</b></td>
                             <td align="right" style="font-family: Arial, Helvetica, sans-serif;font-size: 12px;"><b><%=df.format(total)%></b></td></tr>
                    </table>
            </div>
             <table width="90%" align="center">
    <tr><td colspan="2" height="10"></td></tr>
    <tr>
           <%if(noOfPages>=1){%>
           <td width="50%" align="left">
              <%if(curpage<noOfPages){%>
                <a href="./othercollegestud.do?method=othercollegestud&page=<%=curpage+1%>&type=vv&trans=<%=trans%>">
                     <strong>Older</strong>
                          </a>
                 <%}%>
        </td>
        <td width="50%" align="right">
            <%if(curpage>1){%>
              <a href="./othercollegestud.do?method=othercollegestud&page=<%=curpage-1%>&type=vv&trans=<%=trans%>">
                     <strong>Newer</strong>
                     </a>
                 <%}%>
        </td>
        
                 <%}%>
            </tr></table>       
            <%}%>
   </td></tr>
            
</table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>
