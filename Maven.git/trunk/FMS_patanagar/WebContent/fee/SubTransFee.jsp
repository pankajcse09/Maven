<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>School Management System</title>
          <script type="text/javascript" src="calendarDateInput.js"></script>  
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
          <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
          <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>          
 <script language="javascript">
               
               function chkvalidate()
{
if(document.formfee.damount.value==""){
          alert("Please Enter the Amount ");
          document.formfee.damount.focus();
          return false;
          }
          
                    
          if(document.formfee.paid.value==""){
          alert("Please Enter the amount paying ");
          document.formfee.paid.focus();
          return false;
          }
          
          
}
 
               function calfee()
               {
               var cfine=document.formfee.curfine.value;
               var pfine=document.formfee.pfine.value;
               var pendamount=document.formfee.pamount.value;
             
               var eamount=document.formfee.eamount.value;
      var tfee=document.formfee.tfee.value;
       var tcfee=document.formfee.tcfee.value;
      
    
               
       var paying=0;
               if(document.formfee.paid.value!="")
               {
paying=document.formfee.paid.value;
}else{
paying=0;
}
               var feam=document.formfee.finalEamount.value;
               var fdam=document.formfee.finalDamount.value;
             
               var totalfee=((parseInt(cfine)+parseInt(pfine)+parseInt(pendamount)+parseInt(tcfee))-(parseInt(eamount)));
               document.formfee.finalfee.value=parseInt(totalfee);
                              
               if(parseInt(paying)>parseInt(totalfee))
               {
               var efee=parseInt(paying)-parseInt(totalfee);
               
               var dfee=0;
              
               document.formfee.finalEamount.value=parseInt(efee);
               document.formfee.finalDamount.value=parseInt(dfee);
               
               }
               else
               {
               var dfee=parseInt(totalfee)-parseInt(paying);
               var efee=0;             
               
               document.formfee.finalDamount.value=parseInt(dfee);
               document.formfee.finalEamount.value=parseInt(efee);
              
               }
               }
               
           </script>   
    </head>
    <body onload="calfee()">
 <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Submit Tranport Fee</u></font></center></td></tr></table>
<form  method="post" action="<%=request.getContextPath()%>/disptfee.do?dis=disp">
<table width="100%">
 <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
     <%       
     if((String)request.getAttribute("notpaid")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("notpaid")+"</b></font>"); %>
    

<tr><td><font color="red" size="2">Please enter the Registration Number</font></td></tr>
<tr>
<td>Scholar Number:<input type="text" size="20" name="srnum1" value="">
Fee Book Number:<input type="text" size="20" name="tfeebook" value=""></td></tr>
<tr><td valign="top">
<table>
    <tr><td height="5"></td></tr>
<tr>
<td align="left">Fee Submission Date :</td>
<td align="left"><script>DateInput('feesubdate', true, 'dd/mm/yyyy')</script></td>    
<tr>
<td align="left">From Date:</td>
<td align="left"><script>DateInput('fromdate', true, 'dd/mm/yyyy')</script></td>
<td width="10"></td>
<td align="left">ToDate :</td>
<td align="left"> <script>DateInput('todate', true, 'dd/mm/yyyy')</script> </td>

  </tr> 
  <tr><td height="5"></td></tr>
<tr><td>
<input type="submit" value="Display">
</td></tr>
</tr>
</table>
</td>
</tr>  
</table>
</form>   
  
   <form action="<%=request.getContextPath()%>/transfeesub.do" method="post" name="formfee" onsubmit="return chkvalidate()">
       
<%  String fromdate= (String)request.getParameter("fromdate"); 
           String todate= (String)request.getParameter("todate");   
         //  String srnum= (String)request.getParameter("srnum");   
        
      String month= (String)request.getAttribute("month"); 
      String lfsubdate= (String)request.getAttribute("fsubdate");   
      String feesubdate= (String)request.getAttribute("feesubdate"); 
      Integer totalfee=(Integer)request.getAttribute("Totalfee");
      Integer eamount=(Integer)request.getAttribute("eamount"); 
      Integer pamount=(Integer)request.getAttribute("pamount"); 
      Integer lstdate=(Integer)request.getAttribute("lstdate");   
      Integer pday=(Integer)request.getAttribute("pday");   
      Integer finestatus=(Integer)request.getAttribute("finestatus"); 
      Integer lastrecfine=(Integer)request.getAttribute("lastrecfine");
      Integer total=(Integer)request.getAttribute("total"); 
      Integer nom=(Integer)request.getAttribute("nom"); 
      Integer busfee=(Integer)request.getAttribute("busfee"); 
      String sesdate= (String)request.getParameter("sesdate");   
      
    %>
 </td></tr>
    <tr><td valign="top">     
    
      <input type="hidden" name="tdate" value="<%=todate%>">
      <input type="hidden" name="fdate" value="<%=fromdate%>">
      <input type="hidden" name="nom" value="<%=nom%>">
      
   
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("array");
 
SchoolEO seo=null;
  %>
  <% if(request.getAttribute("array")!=null)
 {%>           
  
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>

<table width="40%" cellpadding="1" cellspacing="0"  align="center" >
                <tr>
                <tr><td height=4></td></tr>
  
<td><b>Registration Number:</b></td><td><%=seo.getSrnum()%></td><td width="15"></td>
<input type="hidden" name="srnum" value="<%=seo.getSrnum()%>">
<tr><td><b>Fee Submitted On:</b></td><td><%=feesubdate%></td></tr>
<input type="hidden" name="feesubdate" value="<%=feesubdate%>">
<input type="hidden" name="Syear" value="<%=seo.getSyear()%>">
<input type="hidden" name="Eyear" value="<%=seo.getEyear()%>">
<input type="hidden" name="tfeebook" value="<%=seo.getTfeebooknum()%>">
            </table>   </td></tr>
            <tr><td>
  <table width="100%" cellpadding="0" cellspacing="0" border="1" align="center">
   <tr><td>     
 
   <tr><td>         
  <table align="left" width="100%" cellpadding="1" cellspacing="0" >
    
 <tr><td height="10"></td></tr> 
<tr><td><b>Student Name:</b></td><td><%=seo.getSname()%></td></tr>
<tr><td><b>Class:</b></td><td><%=seo.getClasses()%>
<b>Sec:</b><%=seo.getSection()%></td></tr>
<tr><td><b>Route:</b></td><td><%=seo.getRoute()%></td></tr>
<tr><td><b>Buscode:</b></td><td><%=seo.getBuscode()%>
<b>Trip No.:</b><%=seo.getTripnum()%></td></tr>
<tr><td><b>Total Fee :<b></td><td><input type="text" name="tfee" value="<%=totalfee%>" onblur="calfee()"></td>
<input type="hidden" name="sname" value="<%=seo.getSname()%>">
<input type="hidden" size="3" name="classes" value="<%=seo.getClasses()%>">
<input type="hidden" size="7" name="section" value="<%=seo.getSection()%>">
<input type="hidden" size="7" name="route" value="<%=seo.getRoute()%>">
<input type="hidden" size="7" name="buscode" value="<%=seo.getBuscode()%>">
<input type="hidden" size="7" name="tripnum" value="<%=seo.getTripnum()%>">
</tr>
<%if(pday.intValue()>lstdate.intValue())     
         {
%>
     <tr><td><b>fine:</b></td><td><input type="text" name="curfine" value="<%=finestatus%>" onblur="calfee()"></td></tr>
   <%      }
         else
         {
   %>
 <tr><td><b>fine:</b></td><td><input type="text" name="curfine" value="0" onblur="calfee()"></td></tr>
        <%
         }  %>

<tr><td><b>Fee after Concession:</b><font color="red">(<%=seo.getConcession()%>)</font></td><td><input type="text" name="conc" value="<%=busfee%>" onblur="calfee()"></td></tr>         
<tr><td><b>Bank Cheque/Draft Number:</b></td><td><input type="text" name="dnum" value=""></td></tr>
<tr><td><b>Cheque/Draft Amount:</b></td><td><input type="text" name="damount" value="0"></td></tr>
<tr><td><b>Dated:</b></td><td><script>DateInput('ddate', true, 'dd/mm/yyyy')</script></td></tr>
<tr><td><b>Name of Bank:</b></td><td><input type="text" name="bankname" value=""></td></tr>
  </table></td>

<td valign="top">
<table align="left" width="100%" cellpadding="1" cellspacing="0">
<tr><td height="5"></td></tr>

<tr><td height="5" valign="top"><b><u>LAST MONTH RECORDS</u></b></td></tr>
<tr><td height="5"></td></tr>
<tr><td><b>Last Fee Paid On</b></td><td><input type="text" name="lfsubdate" value="<%=lfsubdate%>" ></td></tr>
<tr><td><b>Previous Fine:</b></td><td><input type="text" name="pfine" value="<%=lastrecfine%>" onblur="calfee()"></td></tr>
<tr><td><b>Extra Amount:</b></td><td><input type="text"  name="eamount" value="<%=eamount%>" onblur="calfee()"></td></tr>
<tr><td><b>Pending Amount :</b></td><td><input type="text"  name="pamount" value="<%=pamount%>" onblur="calfee()"></td></tr>

</tr></table></td></tr>
</td></tr>
</table></td></tr>
<tr><td><table align="left" width="100%" border=1>
<tr><td><font color="red" size="2">* Total Fee=(Current fine + Previous Fine + Pending Amount + Fee+ Computer Fee)-(Extra Amount + Concession)</font></td></tr>
</table></td></tr>
<tr><td><table align="left" width="80%" cellpadding="1" cellspacing="0" >
 
<tr><td><b>Fee:</b></td><td><input type="text" name="tcfee" value="<%=busfee%>" onblur="calfee()"></td></tr>
<tr><td><b>Total Fee:</b></td><td><input type="text" name="finalfee" value="" onblur="calfee()"></td></tr>
<tr><td><b>Amount Paying:</b></td><td><input type="text" name="paid" value="" onblur="calfee()"></td></tr>
<tr><td><b>Extra amount:</b></td><td><input type="text" name="finalEamount" value="" onblur="calfee()"></td></tr>
<tr><td><b>Due amount:</b></td><td><input type="text" name="finalDamount" value="" onblur="calfee()"></td></tr>
   
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table></td></tr>
<%
   } }
   }catch(Exception e)
       {}%>
   </form>   
  </td></tr></table>
  
    <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>
