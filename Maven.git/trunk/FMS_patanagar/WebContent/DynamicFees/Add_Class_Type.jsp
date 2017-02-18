<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>

<%!  
 Connection con=null; 
 PreparedStatement psmt1=null; 
 PreparedStatement psmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
%>
<% 
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
  java.util.Date dt=new java.util.Date();
  String dat=sdf.format(dt);
  ArrayList ar2=new ArrayList();
     try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){} 
   try{   
   String sq2="select class from classes";
   psmt2=con.prepareStatement(sq2);
   rs2=psmt2.executeQuery();
   while(rs2.next()){ 
   ar2.add(rs2.getString("class"));
   } 
   }catch(SQLException se){}
   finally{
       try{
         if(rs2!=null){rs2.close();}  
         if(psmt2!=null){psmt2.close();}
         if(con!=null){con.close();}
       }
       catch(SQLException se){}
   }
   
SchoolEO seo=new SchoolEO();  
seo.setSession(dat);
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <title>JSP Page</title>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<script language="JavaScript">     
function validate(){
if(document.f1.elements["session"].value==""){
alert("Enter Session");
document.f1.elements["session"].focus();
return false;
 }
if(document.f1.elements["classes"].value==""){
alert("Select Class");
document.f1.elements["classes"].focus();
return false;
 }
if(document.f1.elements["type"].value==""){
alert("Select Type");
document.f1.elements["type"].focus();
return false;
 }
return true;
}
</script>        
</head>
<body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#A89263" align="center">
<tr><td width="100%" align="center"><jsp:include page="/toplook.jsp"/></td></tr>
<tr><td width="100%" align="center">
<table border="0" bgcolor="#A89263" cellpadding=0 cellspacing=0 width="100%" height="250">    
<tr><td width="100%" align="right"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>
<tr><td valign="top">    
 
<table width="100%" align="center">
<tr><td colspan="2" align="center"><font style="font-size:16;font-weight:bold;color:blue">Enter Type for Class</font></td></tr></table>     
<form name="f1" method="post" action="<%=request.getContextPath()%>/SubmitClassType.do?method=subClassType" onsubmit="return validate();">
<table width="30%" align="center" border="0" style="border-collapse:collapse">
<%if(request.getAttribute("msg")!=null){%>  
<tr><td colspan="2"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
<tr><td width="50%" class="tdcolor" align="right"><font style="font-size:12;font-weight:bold">Class</font></td>
<td width="50%">
<select name="classes">
<%if(seo.getClasses().equals("")){%>    
<option value="">Select</option>     
 <%}else{%>
 <option value="<%=seo.getClasses()%>"><%=seo.getClasses()%></option> 
<%}for(int i=0;i<ar2.size();i++){
if(seo.getClasses().equals(ar2.get(i))){continue;}
%>
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select>
</td></tr>
<tr><td width="50%" class="tdcolor" align="right"><font style="font-size:12;font-weight:bold">Type</font></td>
<td width="50%"><input type="text" name="type"></td></tr> 
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
</table>    
</form>

</td></tr></table>
</td></tr> 
<tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
