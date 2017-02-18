<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO"%>
<%@page import="AO.*,ActionClass.FeeMethod"%>

   <%! 
    Connection con=null;
    PreparedStatement psmt2=null;   
    PreparedStatement psmt3=null; 
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
   %>             
       <%      
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){}
      FeeMethod fm=new FeeMethod();
         ArrayList ar1=new ArrayList();
         ArrayList ar2=new ArrayList();
         
         String mth="";
         if(request.getParameter("month")!=null && !request.getParameter("month").equals("")){
         mth=(String)request.getParameter("month");         
        
             String qr1="select distinct class from classes ";
             psmt2=con.prepareStatement(qr1);
             rs2=psmt2.executeQuery();
             while(rs2.next()){
             ar1.add(rs2.getString("class"));   
             }
             String qr2="select distinct heads from feeheads order by heads";   
             psmt3=con.prepareStatement(qr2);
             rs3=psmt3.executeQuery();
             while(rs3.next()){
             ar2.add(rs3.getString("heads"));     
             }
        %>

<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>          
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>        
 <script language="javascript">
 function noBlank(a){
 var cnt=0;
 var m=0; 
  var b=document.form5.elements[a].value;  
  var c=document.form5.elements[a].value.length;
  if(document.form5.elements[a].value==""){
  document.form5.elements[a].value="0.0";
  }
  else{
  for(n=0;n<c;n++){  
  if(b.charCodeAt(n)>47 && b.charCodeAt(n)<58){ 
  continue;
  } 
  else{  
  if(b.charCodeAt(0)==46){ 
  cnt=1;
  break;}
  if(b.charCodeAt(n)==46){
  m=m+1;
  if(m>1){
  cnt=1;
  break;
  }
  }
  else{
  cnt=1;
  break; 
  }  
  }
  }
  }
  if(cnt==1){
  document.form5.elements[a].value="0.0";
  document.form5.elements[a].focus();
  }
 }
 </script>   
    </head>
    <body>    
 <table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
   <%String month=request.getParameter("month");%> 
 <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
 <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Update Fee Chart of <%=month%></u></font></center></td></tr></table>
  <form name="form5" action="<%=request.getContextPath()%>/upchart.do" method="post" onsubmit="return chkvalidate()">
  <input type="hidden" name="month" value="<%=mth%>">      
<table cellpadding="0" cellspacing="0" border="0" width="30%" align="left">
</table>
 </td><tr>
 <tr><td valign="top">
<table cellpadding="0" cellspacing="2" border="2" width="60%" align="center">
<table border="2" bordercolor="#34689A" style="border-collapse:collapse">
<tr><td width="9%" align="center"><b>Classes</b></td>
<%for(int i=0;i<ar2.size();i++){%>
<td width="9%" align="center"><input type="hidden" name="heads" value="<%=ar2.get(i)%>"><b><%=ar2.get(i)%></b></td>
<%}%>
</tr>
<%for(int j=0;j<ar1.size();j++){%>
<tr><td width="9%" align="center"><input type="hidden" name="classes<%=j%>" value="<%=ar1.get(j)%>">
<b><%=ar1.get(j)%></b></td>
<%for(int i=0;i<ar2.size();i++){%>
<td width="9%" align="center"><input type="text" size="5" name="classes<%=j%>_<%=ar2.get(i)%>" value="<%=fm.retriveFees(mth,ar1.get(j),ar2.get(i))%>" onblur="noBlank('classes<%=j%>_<%=ar2.get(i)%>')"></td>
<%}%>
</tr>
<%}%>
</table></td></tr>  
<tr><td align="center"><input type="submit" value="Update"></td></tr>
</table>
</td></tr></table>   
 
<tr><td valign="top">
<table width="100%" bgcolor="#34689A" border="0"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</form>
</table>     
</body>
</html>
<%}else{
request.setAttribute("msg1","Select Month");             
RequestDispatcher rd=request.getRequestDispatcher("/fee/feechart.jsp");
rd.forward(request,response);
}%>

    
    
    














