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
               
              
 
               function calfee()
               {
               var cfine=document.formfee.curfine.value;
               var pfine=document.formfee.pfine.value;
               var pendamount=document.formfee.pamount.value;
             
               var eamount=document.formfee.eamount.value;
      var tfee=document.formfee.tfee.value;
       var tcfee=document.formfee.tcfee.value;
      
    
               
       var paying=0.0;
               if(document.formfee.paid.value!="")
               {
paying=document.formfee.paid.value;
}else{
paying=0.0;
}
               var feam=document.formfee.finalEamount.value;
               var fdam=document.formfee.finalDamount.value;
             
               var totalfee=((parseInt(cfine)+parseInt(pfine)+parseInt(pendamount)+parseInt(tcfee))-(parseInt(eamount)));
               document.formfee.finalfee.value=parseInt(totalfee);
                              
               if(parseInt(paying)>parseInt(totalfee))
               {
               var efee=parseInt(paying)-parseInt(totalfee);
               var dfee=0.0;
              
               document.formfee.finalEamount.value=parseInt(efee);
               document.formfee.finalDamount.value=parseInt(dfee);
               
               }
               else
               {
               var dfee=parseInt(totalfee)-parseInt(paying);
               var efee=0.0;             
               
               document.formfee.finalDamount.value=parseInt(dfee);
               document.formfee.finalEamount.value=parseInt(efee);
              
               }
               }
               
           </script>   
    </head>
    <body onload="calfee()">
    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Submit Fee</u></font></center></td></tr></table>
<form  method="post" action="<%=request.getContextPath()%>/dispsfee.do?dis=disp">
<table width="100%">
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<%       
     if((String)request.getAttribute("notpaid")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("notpaid")+"</b></font>"); %>
 
<tr><td><font color="red" size="2">Please enter the Registration Number</font></td></tr>
<tr><td>Scholar Number:<input type="text" size="20" name="srnum" value="">
<input type="hidden" size="20" name="sfeebook" value="0"></td></tr>
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
<form action="<%=request.getContextPath()%>/feesub.do" method="post" name="formfee" onsubmit="return chkvalidate()">
       
       <%  //String fromdate= (String)request.getParameter("fromdate"); 
         //  String todate= (String)request.getParameter("todate");   
        //   String srnum= (String)request.getParameter("srnum");   
        
      String month= (String)request.getAttribute("month"); 
      String lfsubdate= (String)request.getAttribute("fsubdate");   
      String feesubdate= (String)request.getAttribute("feesubdate"); 
      Double totalfee=(Double)request.getAttribute("Totalfee");
      Double eamount=(Double)request.getAttribute("eamount"); 
      Double pamount=(Double)request.getAttribute("pamount"); 
      Double lstdate=(Double)request.getAttribute("lstdate");   
      Integer pday=(Integer)request.getAttribute("pday");   
      Double finestatus=(Double)request.getAttribute("finestatus"); 
      Double lastrecfine=(Double)request.getAttribute("lastrecfine");
   //   Double total=(Double)request.getAttribute("total"); 
      Integer nom=(Integer)request.getAttribute("nom"); 
      Double tcfee=(Double)request.getAttribute("TCFee"); 
      String todate= (String)request.getAttribute("todate");   
      String fromdate= (String)request.getAttribute("fromdate");   
      String sesdate= (String)request.getAttribute("sesdate");   
      String head=(String)request.getAttribute("head");  
      Double concamt=(Double)request.getAttribute("concamt");
 /*     double rrt=0.0;
      double rrt1=0.0; 
      double cmt=0.0;
      if(request.getAttribute("Totalfee")!=null){
      rrt=totalfee.doubleValue();
      }
      if(request.getAttribute("TCFee")!=null){
      rrt1=tcfee.doubleValue();
      }
   //   if(request.getAttribute("concamt")!=null){
   //   cmt=concamt.doubleValue();
    //  }*/
    %>
 </td></tr>
    <tr><td valign="top">
    
      <input type="hidden" name="tdate" value="<%=todate%>">
      <input type="hidden" name="fdate" value="<%=fromdate%>">
      <input type="hidden" name="nom" value="<%=nom%>">
      <input type="hidden" name="head" value="<%=head%>">
      <input type="hidden" name="concamt" value="<%=concamt%>">
      
      <input type="hidden" name="sesdate" value="<%=sesdate%>">
  
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
<input type="hidden" name="sfeebook" value="<%=seo.getSfeebooknum()%>">


                </tr> </table>   </td></tr>
            <tr><td>
  <table width="100%" cellpadding="0" cellspacing="0" border="1" align="center">
   <tr><td>     
 
   <tr><td>         
  <table align="left" width="100%" cellpadding="1" cellspacing="0" >
    
 <tr><td height="10"></td></tr> 
<tr><td>Student Name:</td><td><input type="text" name="sname" value="<%=seo.getSname()%>"></td></tr>
<tr><td>Class:</td><td><input type="text" size="3" name="classes" value="<%=seo.getClasses()%>">
Sec:<input type="text" size="7" name="section" value="<%=seo.getSection()%>"></td></tr>
<tr><td>Total Fee :</td><td><input type="text" name="tfee" value="<%=totalfee%>" onblur="calfee()"></td>

</tr>
<%if(pday.intValue()>lstdate.intValue())     
         {
%>
     <tr><td>fine:</td><td><input type="text" name="curfine" value="<%=finestatus%>" onblur="calfee()"></td></tr>
   <%      }
         else
         {
   %>
 <tr><td>fine:</td><td><input type="text" name="curfine" value="0" onblur="calfee()"></td></tr>
        <%
         }  %>

<tr><td>Fee after Concession:<font color="red">(<%=seo.getHeads()%>--<%=seo.getConcession()%>%)(<%=concamt%>Rs)</font></td><td><input type="text" name="conc" value="<%=tcfee%>" onblur="calfee()"></td></tr>         
<tr><td>Bank Cheque/Draft Number:</td><td><input type="text" name="dnum" value=""></td></tr>
<tr><td>Cheque/Draft Amount:</td><td><input type="text" name="damount" value="0.0"></td></tr>
<tr><td>Dated:</td><td><script>DateInput('ddate', true, 'dd/mm/yyyy')</script></td></tr>
<tr><td>Name of Bank:</td><td><input type="text" name="bankname" value=""></td></tr>
  </table></td>

<td valign="top">
 <table align="left" width="100%" cellpadding="1" cellspacing="0">
<tr><td height="5"></td></tr>

<tr><td height="5" valign="top"><b>LAST MONTH RECORDS</b></td></tr>
<tr><td height="5"></td></tr>
<tr><td>Last Fee Paid On</td><td><input type="text" name="lfsubdate" value="<%=lfsubdate%>" ></td></tr>
<tr><td>Previous Fine:</td><td><input type="text" name="pfine" value="<%=lastrecfine%>" onblur="calfee()"></td></tr>
<tr><td>Extra Amount:</td><td><input type="text"  name="eamount" value="<%=eamount%>" onblur="calfee()"></td></tr>
<tr><td>Pending Amount :</td><td><input type="text"  name="pamount" value="<%=pamount%>" onblur="calfee()"></td></tr>

   </tr></table></td></tr>
</td></tr>
  </table>  </td></tr>
<tr><td><table align="left" width="100%" border=1>
<tr><td><font color="red" size="2">* Total Fee=(Current fine + Previous Fine + Pending Amount + Fee)-(Extra Amount + Concession)</font></td></tr>
</table></td></tr>
<tr><td><table align="left" width="80%" cellpadding="1" cellspacing="0" >
    
<tr><td>Fee:</td><td><input type="text" name="tcfee" value="<%=tcfee%>" onblur="calfee()"></td></tr>
<tr><td>Net Fee:</td><td><input type="text" name="finalfee" value="0.0" onblur="calfee()"></td></tr>
<tr><td>Amount Paying:</td><td><input type="text" name="paid" value="<%=tcfee%>" onblur="calfee()"></td></tr>
<tr><td>Extra amount:</td><td><input type="text" name="finalEamount" value="0.0" onblur="calfee()"></td></tr>
<tr><td>Due amount:</td><td><input type="text" name="finalDamount" value="0.0" onblur="calfee()"></td></tr>
   
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table></td></tr>
   
       <%
   } }
   }catch(Exception e)
       {}%>
       
   </form>   
  
</td></tr></table>

     <tr><td valign="top">
<table width="100%" bgcolor="#34689A"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>
