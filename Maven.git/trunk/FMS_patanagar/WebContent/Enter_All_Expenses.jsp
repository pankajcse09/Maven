<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
        <script language="javascript">  
        function validate(){  
          if(document.forms[0].elements["details"].value==""){
          alert("Enter Details of Expenses");
          document.forms[0].elements["details"].focus();
          return false;
          }                    
          if(document.forms[0].elements["amount"].value=="" || document.forms[0].elements["amount"].value==0.0){
          alert("Enter Blank and Zero Valued Field");
          document.forms[0].elements["amount"].focus();
          return false;
          }
          else{
          var k=validno("amount");
          if(k==false){return false;}
          }                           
          if(document.forms[0].elements["empname"].value==""){
          alert("Enter Paid By");
          document.forms[0].elements["empname"].focus();
          return false;
          }   
          return true;
          }
          
          function toAllUpper(n){                   
          document.forms[0].elements[n].value=document.forms[0].elements[n].value.toUpperCase();   
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
    
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Expenses/Enter Expenses</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/expenses.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
    <html:form method="post" action="allexpenses?method=enterAllExpenses" onsubmit="return validate();">
    <table width="100%" class="res"  cellpadding="0" cellspacing="0" align="center" bgcolor="#A89263">
   <tr><td align="center" style="padding-left: 80px"><h2><font color="darkblue" size="3"><u>Enter All Expenses</u></font></h2></td></tr>  
   <tr><td>    
<table width="100%" align="center" height="200" ><tr><td valign="top">   
<table width="40%" align="center" border="0" style="border-collapse:collapse">  
    <%if(request.getAttribute("msg")!=null){%>
    <tr><td colspan="2"><font color="red" style="font-size:12"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
    <%}%>
    <tr><td width="40%" align="right"><font style="font-size:12" color="white"><b>Date</b></font></td><td width="60%"><script>DateInput('dated',true,'dd/mm/yyyy')</script></td></tr>   
    <tr><td width="40%" align="right"><font style="font-size:12" color="white"><b>Details</b></font></td><td width="60%"><html:text property="details" onblur="toAllUpper('details')"/></td></tr>
    <tr><td width="40%" align="right"><font style="font-size:12" color="white"><b>Amount(in Rs.)</b></font></td><td width="60%"><html:text property="amount"/></td></tr>
    <tr><td width="40%" align="right"><font style="font-size:12" color="white"><b>Paid By</b></font></td><td width="60%"><html:text property="empname" onblur="toAllUpper('empname')"/></td></tr> 
    <tr><td colspan="2" align="center"><html:submit property="allexpense" value="Submit"/></td></tr>
    </table>   
    </td></tr></table>
    </td></tr></table>
</html:form>
    
  </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>

