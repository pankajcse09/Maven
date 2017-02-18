<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>
<%@page import="java.util.*,java.text.*"%>
<!DOCTYPE html>
 <%
    Connection cn=null;
    Statement stmt1=null;
    Statement stmt2=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    
    try{
    DataConnection dc=new DataConnection();
    cn=(Connection)dc.Dataconnect();
    }catch(Exception e){}
     
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);  
    int Eyear=Syear+1;
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);      

ArrayList ar=new ArrayList();    
try{
String sq="select class from classes";
stmt2=cn.createStatement();
rs2=stmt2.executeQuery(sq);
while(rs2.next()){
ar.add(rs2.getString("class")); 
}
}catch(SQLException e){}
SchoolEO seo2=new SchoolEO();
SchoolEO seo=new SchoolEO();
if(request.getAttribute("jbean")!=null){      
seo=(SchoolEO)request.getAttribute("jbean");
}
ArrayList ar2=(ArrayList)seo.getDataArray();
ArrayList ar3=(ArrayList)seo.getDataArray2();
%>    
<html>
<head>
<style type="text/css">
.font{font-size:10;font-weight:bold}    
.font2{font-size:12;font-weight:bold} 
</style>
<title>College Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/ajaxxml.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<script language="javascript">   
 function dataBy(){
  document.f1.method="post";
  document.f1.action="<%=request.getContextPath()%>/RetDataBy.do?method=retByData";
  document.f1.submit();
 }

function validate(){
if(document.ent.classes.value==""){
alert("Please Enter Class");
document.ent.classes.focus();
return false;
}
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Reports/Classwise Stud. Detail</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 400px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>List Of Students</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 100px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/Ret_StudListData.do?method=studListAct">
<%if(request.getAttribute("sub")!=null)
 out.println("<font color='red'><b>"+request.getAttribute("sub")+"</b></font>");%> 
<table width="800" align="center"> 
<tr><td><font color="red" size="2">Select Following Details:</font></td></tr>
<tr><td colspan="3" class="tdcolor"><b>Session:</b><select name="session" id="ssn">    
<%if(!seo.getSession().equals("")){%>  
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%>    
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%>  
<option value="<%=next%>"><%=next%></option>
<%}%>  
</select>  
<b>Class:</b><select name="cls" id="cls" onblur="dataBy();">
<%if(!seo.getClasses().equals("")){%>  
<option value="<%=seo.getClasses()%>"><%=seo.getClasses()%></option>   
<%}for(int i=0;i<ar.size();i++){
if(ar.get(i).equals(seo.getClasses())){continue;}%>
<option value="<%=ar.get(i)%>"><%=ar.get(i)%></option>
<%}%>
</select></td></tr>                     
<tr><td><table><tr><td class="tdcolor">
<b>By:</b><select name="by" id="by" onblur="dataBy();">   
<%if(seo.getBy().equals("")){%>      
<option value="">SELECT</option> 
<%}else{%> 
<option value="<%=seo.getBy()%>"><%=seo.getBy()%></option> 
<%}if(!seo.getBy().equals("CATEGORY")){%>
<option value="CATEGORY">CATEGORY</option>
<%}if(!seo.getBy().equals("GENDER")){%>
<option value="GENDER">GENDER</option>
<%}if(!seo.getBy().equals("SUBJECT")){%>
<option value="SUBJECT">SUBJECT</option>
<%}%>
</select></td>
<td><select name="databy" id="databy">
<%if(!seo.getDataBy().equals("")){%>      
<option value="<%=seo.getDataBy()%>"><%=seo.getDataBy()%></option> 
<%}if(!seo.getDataBy().equals("ALL") && !seo.getBy().equals("SUBJECT")){%>      
<option value="ALL">ALL</option> 
<%}for(int i=0;i<ar2.size();i++){
if(ar2.get(i).equals(seo.getDataBy())){continue;}%>
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select></td>
<td><input type="submit" value="Display"></td></tr></table>
</td></tr></table>
</form>
<table width="100%" align="center"><tr>
<td width="100%" align="right" valign="middle"><a href="javascript:printIdCard('printit')"><font color="blue" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<hr color="darkblue">
<div id="printit"> 
<table width="100%" align="center">
<tr><td width="100%" align="center" class="tdcolor">Session:<%=seo.getSession()%>&nbsp;&nbsp;&nbsp;Class:<%=seo.getClasses()%>&nbsp;&nbsp;&nbsp;<%=seo.getBy()%>:<%=seo.getDataBy()%></font></td></table>    
<table width="100%" align="center" border="1" bordercolor="black" style="border:1px solid black;border-collapse:collapse" bgcolor="#FFFFCC">
<tr>
<td class="tdcolor1">Regist No.</font></td>
<td class="tdcolor1">Enroll No.</font></td>
<td class="tdcolor1">Stud Name</font></td>
<td class="tdcolor1">Gender</font></td>
<td class="tdcolor1">DOB</font></td>
<td class="tdcolor1">Fath Name</font></td>
<td class="tdcolor1">Moth Name</font></td>
<td class="tdcolor1">Category</font></td>
<td class="tdcolor1">Class</font></td>
<td class="tdcolor1">Domicile</font></td>
<td class="tdcolor1">Admin Type</font></td></tr>    
<%for(int i=0;i<ar3.size();i++){
seo2=(SchoolEO)ar3.get(i);    
%>
<tr><td><font style="font-size:10"><%=seo2.getRegistNo()%></font></td>
<td><font style="font-size:10"><%=seo2.getEnrolNo()%></font></td>
<td><font style="font-size:10"><%=seo2.getSname()%></font></td>
<td><font style="font-size:10"><%=seo2.getGender()%></font></td>
<td><font style="font-size:10"><%=seo2.getDob()%></font></td>
<td><font style="font-size:10"><%=seo2.getFname()%></font></td>
<td><font style="font-size:10"><%=seo2.getMname()%></font></td>
<td><font style="font-size:10"><%=seo2.getCategory()%></font></td>
<td><font style="font-size:10"><%=seo2.getSeekadd()%></font></td>
<td><font style="font-size:10"><%=seo2.getDomicile()%></font></td>
<td><font style="font-size:10"><%=seo2.getAdminType()%></font></td></tr>    
<%}%>
</table>
</div>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
