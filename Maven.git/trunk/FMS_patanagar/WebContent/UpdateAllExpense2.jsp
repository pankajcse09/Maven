<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.myapp.struts.JavaBean,java.util.*"%>

 <%
   String dt1="";
   String dt2="";
   JavaBean jb=new JavaBean(); 
   ArrayList ar=new ArrayList();
   ArrayList ar1=new ArrayList();
  if(request.getAttribute("arr")!=null){
  ar=(ArrayList)request.getAttribute("arr");
  }
  if(request.getAttribute("dated1")!=null){
  dt1=(String)request.getAttribute("dated1");
  }
  if(request.getAttribute("dated2")!=null){
  dt2=(String)request.getAttribute("dated2");
  } 
  %>   
<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu1.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>   
         <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
     <script language="javascript">  
        function validate(){  
          if(document.forms[0].elements[0].value==""){
          alert("Please Enter Date in format DD/MM/YYYY");
          document.forms[0].elements[0].focus();
          return false;
          }
          if(document.forms[0].elements[1].value==""){
          alert("Please Enter Details of Expenses");
          document.forms[0].elements[1].focus();
          return false;
          }                    
          if(document.forms[0].elements[2].value=="" || document.forms[0].elements[2].value==0.0){
          alert("Please Enter Blank and Zero Valued Field");
          document.forms[0].elements[2].focus();
          return false;
          }
          else{
          var k=validno(2);
          if(k==false){return false;}
          }                           
          if(document.forms[0].elements[3].value==""){
          alert("Please Enter Paid By");
          document.forms[0].elements[3].focus();
          return false;
          }   
          return true;
          }
    </script>
    </head>
    <body> 
      <table class=res cellpadding="0" cellspacing="0" align="center">
      <tr><td><jsp:include page="/fee/toplook.jsp"/></td></tr>
      <tr><td><table border="0"  bgcolor="#A89263" cellpadding=0 cellspacing =0 width="100%"  height="230">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">  
<center><h2><font color="darkblue" size="3"><u><b>Update All Expenses</b></u></font></h2></center>     
<%if(request.getParameter("method").equals("updateAllExp2")){%>
 <table  width="80%" align="center" height="200" cellpadding="0" cellspacing="0"><tr><td> 
<form name="f1" method="post" action="UpdateAllExp3.do?method=updateAllExp3&pr=1" onsubmit="return validate();">  
<table  width="40%" align="center" border="0" style="border-collapse:collapse">
<%for(int i=0;i<ar.size();i++){
jb=(JavaBean)ar.get(i);
%>     
<tr><td class="tdcolor"><b>Date</b></font></td><td><input type="text" name="dated" value="<%=jb.getDated()%>" style="width:150"></td></tr>
<tr><td class="tdcolor"><b>Details</b></font></td><td><input type="text" name="detail" value="<%=jb.getDetails()%>" style="width:150"></td></tr>
<tr><td class="tdcolor"><b>Amount</b></font></td><td><input type="text" name="amount" value="<%=jb.getAmount()%>" style="width:150"></td></tr>
<tr><td class="tdcolor"><b>Paid By</b></font></td><td><input type="text" name="ename" value="<%=jb.getEmpname()%>" style="width:150"></td></tr>
<tr><td colspan="2" align="center"><input type="hidden" name="pid" value="<%=jb.getId()%>"><input type="submit" value="submit"></td></tr>  
  <%}%> 
  </table>
 <input type="hidden" name="dated1" value="<%=dt1%>">
 <input type="hidden" name="dated2" value="<%=dt2%>"> 
 </form>
  <%}%> 
  </td></tr>
<table width="100%" bgcolor="#A89263"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
  </body>
</html>
