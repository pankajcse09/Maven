<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*,ActionClass.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@ page import="AO.*,java.io.*,java.util.*,java.text.*" %> 
<%@page import="EO.SchoolEO"%>

<%
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    Statement stmt3=null;
    ResultSet rs3=null;
     try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e){}
 SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
 java.util.Date dat=new java.util.Date();
       String Syear1=sdf.format(dat);
       int Syear=Integer.parseInt(Syear1);
       int Eyear=Syear+1;
    String classes="";    
//try{
SchoolEO seo=new SchoolEO();    
String sr="";
String sy="";
if(request.getAttribute("sr")!=null){
sr=(String)request.getAttribute("sr");  
}if(request.getAttribute("session")!=null){
sy=(String)request.getAttribute("session");  //InputStream sImage; 
}
List ar2=new ArrayList();
try{
String sq="select class from classes";
stmt2=cn.createStatement();
rs2=stmt2.executeQuery(sq);
while(rs2.next()){
ar2.add(rs2.getString("class"));
}
}catch(SQLException e){}

if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar=(ArrayList)seo.getDataArray();
%>
<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="calendarDateInput.js"></script>         
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<script language="javascript">
function classType(){
document.studre.method="post";
document.studre.action="<%=request.getContextPath()%>/EditStudAdmin.do?method=typeAction3";
document.studre.submit();
}
</script>
   
    </head>
    <body>    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#A89263" align="center">
<tr><td><jsp:include page="/fee/toplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#A89263" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
 <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
 <table width="100%" align="center"><tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Edit Student Record</b></font></td></tr></table>

<form name="studre" action="<%=request.getContextPath()%>/EditStudAdmin2.do?method=editClassSubAct" method="post" onsubmit="return chkvalidate()">
 <input type="hidden" name="session" value="<%=seo.getSession()%>">
 <input type="hidden" name="srnum" value="<%=seo.getSrnum()%>">
 <input type="hidden" name="sname" value="<%=seo.getSname()%>">
 <input type="hidden" name="gender" value="<%=seo.getGender()%>">
 <table width="99%" cellpadding="0" cellspacing="0"  align="center">
 <%if(request.getAttribute("sub")!=null){%>
 <tr><td><font color='red'><b><%=request.getAttribute("sub")%></b></font></td></tr> 
 <%}%>
 <tr><td>
 <table width="100%" cellpadding="0" cellspacing="0"  align="center">
 <tr><td><font color="red" size="2"><b>* Fields are mandatory</b></font></td></tr>
<tr><td height=20></td></tr>
<tr><td valign="top">
<tr><td><table width="70%" align="center" border="2" style="border-collapse:collapse"> 
<tr><td width="20%"><font color="white" size="2"><b>&nbsp;Session</b></td>
<td><font style="font-size:12" color="white"><b><%=seo.getSession()%></b></td></tr> 
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Scholars Number</b></font></td>
<td><font style="font-size:12" color="white"><b><%=seo.getSrnum()%></b></font></td></tr>
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Student Name</b></font></td>
<td><%=seo.getSname()%></td></tr> 
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Class</b></font></td>
<td><select name="seekadd" onblur="classType();">
<%if(seo.getSeekadd().equals("")){%>
<option value="">SELECT</option>   
<%}else{%>
<option value="<%=seo.getSeekadd()%>"><%=seo.getSeekadd()%></option>   
<%}for(int i=0;i<ar2.size();i++){
if(ar2.get(i).equals(seo.getSeekadd())){continue;}
%>  
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select></td></tr>
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Subject</b></font></td>
<td>
<%for(int i=0;i<ar.size();i++){%>
<input type="checkbox" name="sub" value="<%=ar.get(i)%>"><%=ar.get(i)%>    
<%}%>     
</td></tr>
</table></td></tr>
<tr><td><table width="100%" align="center">     
<tr><td></td><td align="center"><input type="submit" value="Edit Class"></td></tr>
 </table></td></tr>
 </td></tr></table>
 </form> 
 
 </td></tr></table>
  </td></tr></table>
   </td></tr></table></td></tr>    
<tr><td width="100%" align="center" valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>   
</body>
</html>
<%//}catch(Exception e){}%>