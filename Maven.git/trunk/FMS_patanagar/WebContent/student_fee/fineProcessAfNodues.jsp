<%-- 
    Document   : fineProcessAfNodues
    Created on : Sep 2, 2014, 6:30:08 PM
    Author     : kapil
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Fee.FeeMath"%>
<%@page import="EO.SchoolEO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%try{%>
<html>
    <head>
        <title>Fine Processing</title>
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
    </head>
  <%  SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
  FeeMath fm=new FeeMath();
ArrayList bnklist=fm.bankList();
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
<tr><td align="center" width="100%" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
<%if(request.getAttribute("msg1")!=null){%>
    <table width="45%" align="center">
           <tr><td align="left" widht="100%"><font color="yellow" size="2"><%=request.getAttribute("msg1")%></font></td></tr>
      </table>
    <%}%>
    <form name="f2" method="post" action="<%=request.getContextPath()%>/processLateFn.do?method=lateFineProcessing">
<%
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                    double fine=0;
                    if(seo.getCounter()==0){
                    if(seo.getTot_days()==1)
                        fine=seo.getMin_fine();
                    else if(seo.getTot_days()!=0){ 
                        fine=seo.getMin_fine()+(seo.getTot_days()-1)*seo.getPfine();
                        if(fine>seo.getMax_fine())
                            fine=seo.getMax_fine();
                      }
                                       
                %>
                
                <table width="35%" align="center">
                    <tr><td colspan="2" height="10"></td></tr>
                    <tr><td colspan="2">
                            <table width="100%"><tr>
                                    <td><b>Process Fine On Late Fee Submission</b></td>
                                 </tr></table>
                                    </td></tr>
                    <input type="hidden" name="session" value="<%=seo.getSession()%>">
                    <input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
                    <input type="hidden" name="deposit_date" value="<%=seo.getDeposite_date()%>">
                    <input type="hidden" name="last_date" value="<%=seo.getLastdate()%>">
                    <tr><td><font style="font-size:12" color="white"><b>Student Id</b></font></td>
                        <td><input type="text" name="stud_id" value="<%=seo.getStud_id()%>" readonly></td></tr>
                    <tr><td><font style="font-size:12" color="white"><b>Fine</b></font></td>
                        <td><input type="text" name="latefine" value="<%=fine%>"></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Bank</b></font></td>
                        <td><select name="bank">
                <% for(int i=0;i<bnklist.size();i++){%>
               <option value="<%=bnklist.get(i)%>"><%=bnklist.get(i)%></option>
               <%}%>
            </select></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Receipt No</b></font></td>
                        <td><input type="text" name="receipt"></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Deposit Date</b></font></td>
                <td align="left"><script>DateInput('date2',true,'dd/mm/yyyy')</script></td></tr>
                    <tr><td align="center" colspan="2"><input type="submit" name="fine" value="Process Fine"></td></tr>
                </table>
            <%}else{%>
            <table width="35%" align="center">
                    <tr><td colspan="2" height="10"></td></tr>
                    <tr><td colspan="2">
                            <table width="100%"><tr>
                                    <td><b>Update Fine On Late Fee Submission</b></td>
                                 </tr></table>
                                    </td></tr>
                    <input type="hidden" name="session" value="<%=seo.getSession()%>">
                    <input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
                    <input type="hidden" name="deposit_date" value="<%=seo.getDeposite_date()%>">
                    <input type="hidden" name="last_date" value="<%=seo.getLastdate()%>">
                    <input type="hidden" name="rid" value="<%=seo.getRowid()%>">
                    <tr><td><font style="font-size:12" color="white"><b>Student Id</b></font></td>
                        <td><input type="text" name="stud_id" value="<%=seo.getStud_id()%>" readonly></td></tr>
                    <tr><td><font style="font-size:12" color="white"><b>Fine</b></font></td>
                        <td><input type="text" name="latefine" value="<%=seo.getFine()%>"></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Bank</b></font></td>
                        <td><select name="bank">
               <option value="<%=seo.getBankname()%>"><%=seo.getBankname()%></option>
                <%for(int j=0;j<bnklist.size();j++)
                {
    if(!seo.getBankname().equals(bnklist.get(j).toString())){
%>
               <option value="<%=bnklist.get(j)%>"><%=bnklist.get(j)%></option>
               <%}}%>
            </select></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Deposit Date</b></font>(dd/mm/yyyy)</td>
                        <td align="left"><input type="text" name="date2" value="<%=sdf.format(seo.getDate())%>"></td></tr>
                    <tr><td align="center" colspan="2"><input type="submit" name="fine" value="Update"></td></tr>
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
}%>
    