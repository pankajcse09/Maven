<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean,javax.servlet.http.HttpServletResponse"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*,EO.SchoolEO,ActionClass.MyMeth"%>
<%@ page import="java.io.*,java.util.*,java.text.*"%> 

<%response.setHeader("Cache-Control","no-cache");%>
<%
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    Statement stmt3=null;
    ResultSet rs3=null;
    MyMeth mm=new MyMeth();
      try{
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e){}
 SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
 java.util.Date dat=new java.util.Date();
       String Syear1=sdf.format(dat);
       int Syear=Integer.parseInt(Syear1);
       int Eyear=Syear+1;

    String classes="";    

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

if(request.getAttribute("arr")!=null){
seo=(SchoolEO)request.getAttribute("arr");   
}
//mm.upPicFile(seo);
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
document.studre.action="<%=request.getContextPath()%>/Stud_Regis_2.do?method=typeUpAction";
document.studre.submit();
}

function prevPer(){
try{
document.studre.elements["prevper"].value=(parseFloat(document.studre.elements["prevobt"].value)*100)/parseFloat(document.studre.elements["prevmm"].value);
}catch(e){
document.studre.elements["prevper"].value=0.0;
}
}

function highPer(){
try{
document.studre.elements["highper"].value=(parseFloat(document.studre.elements["highobt"].value)*100)/parseFloat(document.studre.elements["highmm"].value);
}catch(e){
document.studre.elements["highper"].value=0.0;
}
}
function interPer(){
try{
document.studre.elements["interper"].value=(parseFloat(document.studre.elements["interobt"].value)*100)/parseFloat(document.studre.elements["intermm"].value);
}catch(e){
document.studre.elements["interper"].value=0.0;
}
}
       
function validate()
{
if(document.ent.srnum.value=="")
{
alert("Please Enter Scholars Number");
document.ent.srnum.focus();
return false;
}
if(document.ent.syear.value=="")
{
alert("Please Enter Starting Year of Session");
document.ent.syear.focus();
return false;
}
if(document.ent.eyear.value=="")
{
alert("Please Enter Ending Year of Session");
document.ent.eyear.focus();
return false;
}
}
       
function chkvalidate()
{
if(document.studre.srnum.value=="")
{
alert("Please Enter Scholars Number");
document.studre.srnum.focus();
return false;
}

if(document.studre.sname.value=="")
{
alert("Please Enter Student Name");
document.studre.sname.focus();
return false;
}
if(document.studre.gender.value=="")
{
alert("Please Enter Gender of Student");
document.studre.gender.focus();
return false;
}



if(document.studre.seekadd.value=="")
{
alert("Please Enter Class");
document.studre.seekadd.focus();
return false;
}
if(document.studre.section.value=="")
{
alert("Please Enter Section");
document.studre.section.focus();
return false;
}
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
  <table width="100%" align="center" ><tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Edit Student Record</b></font></td></tr></table>
<form name="studre" action="<%=request.getContextPath()%>/insstudrec.do?enter=enter" method="post" onsubmit="return chkvalidate()">
  <input type="hidden" name="session" value="<%=seo.getSession()%>">
  <input type="hidden" name="eyear" value="<%=seo.getEyear()%>">
  <input type="hidden" name="srnum" value="<%=seo.getSrnum()%>">
 <table width="99%" cellpadding="0" cellspacing="0"  align="center">
 <%if(request.getAttribute("sub")!=null){
 out.println("<font color='red'><b>"+request.getAttribute("sub")+"</b></font>");} %>  
<table width="100%" cellpadding="0" cellspacing="0"  align="center" >
 <tr><td><font color="red" size="2"><b>*Fields are mandatory</b></font></td></tr>
<tr><td height=20></td></tr>
<tr><td valign="top">
 <tr><td><table width="100%" align="center" border="0" style="border-collapse:collapse"> 
<tr><td><font color="white" size="2"><b>Session:</b></td><td colspan="3"><font style="font-size:12" color="white"><b><%=sy%></b></td></tr> 
<tr><td><font color=red>*</font><font style="font-size:12" color="white"><b>Admission No:</b></font></td><td colspan="3">&nbsp;&nbsp;<font style="font-size:12" color="white"><b><%=seo.getSrnum()%></b></font></td></tr>
<tr><td><font color=red>*</font><font style="font-size:12" color="white"><b>Student Name:</b></font></td><td colspan="3"><input type="text" name="sname" value="<%=seo.getSname()%>" size="40"></td></tr> 

<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Mothers's Name:</b></font></td><td width="30%"><input type="text" name="mname" value="<%=seo.getMname()%>"></td>
<td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Father's Name:</b></font></td><td width="30%"><input type="text" name="fname" value="<%=seo.getFname()%>" size="30%"></td></tr>
                       
<tr><td><font color=red>*</font><font style="font-size:12" color="white"><b>Year of Registration:</b></font></td>
<td><input type="text" name="year_regist" value="<%=seo.getYearRegist()%>"></td>
<td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Class of Registration:</b></font></td>
<td width="30%"><input type="text" name="class_regist" value="<%=seo.getClassRegist()%>"></td></tr>     
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>Gender:</b></font></td>
<td width="30%"><select name="gender">
<%if(!seo.getGender().equals("")){%>
<option value="<%=seo.getGender()%>"><%=seo.getGender()%></option>
<%}if(!seo.getGender().equals("MALE")){%>
<option value="MALE">MALE</option>
<%}if(!seo.getGender().equals("FEMALE")){%>
<option value="FEMALE">FEMALE</option>
<%}%>
</select></td>
<td width="20%"><font color=red>*</font><font style="font-size:12" color="white"><b>PG/UG/DIPLOMA:</b></font></td>
<td width="30%"><select name="standard">    
<%if(seo.getStandard().equals("")){%>
<option value="">SELECT</option>   
<%}else{%>
<option value="<%=seo.getStandard()%>"><%=seo.getStandard()%></option>   
<%}if(!seo.getStandard().equals("PG")){%>  
<option value="PG">PG</option>  
<%}if(!seo.getStandard().equals("UG")){%> 
<option value="UG">UG</option> 
<%}if(!seo.getStandard().equals("DIPLOMA")){%> 
<option value="DIPLOMA">DIPLOMA</option>   
<%}%>
</select></td></tr>
<tr><td><font color=red>*</font><font style="font-size:12" color="white"><b>Class:</b></font></td>
<td colspan="3"><select name="seekadd">
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

<tr><td><font color=red>*</font><font style="font-size:12" color="white"><b>Category:</b></font></td>
<td colspan="3"><table><tr>
<td><input type="radio" name="category" value="GENERAL" <%if(seo.getCategory().equals("GENERAL")){%>checked<%}%>><font style="font-size:12" color="white"><b>GENERAL</td>
<td><input type="radio" name="category" value="SC" <%if(seo.getCategory().equals("SC")){%>checked<%}%>><font style="font-size:12" color="white"><b>SC</td>
<td><input type="radio" name="category" value="ST" <%if(seo.getCategory().equals("ST")){%>checked<%}%>><font style="font-size:12" color="white"><b>ST</td>
<td><input type="radio" name="category" value="OBC" <%if(seo.getCategory().equals("OBC")){%>checked<%}%>><font style="font-size:12" color="white"><b>OBC</td>
</tr></table>
</td></tr>
<!--<tr><td><font style="font-size:12" color="white"><b>Upload New Pic:</b></font></td><td colspan="3"><input type="file" name="pic" value=""></td></tr>-->
<tr><td><font style="font-size:12" color="white"><b>Date of Birth:</b></font></td><td><input type="text" name="dob" value="<%=seo.getDob()%>"><font color=red>(dd/mm/yyyy)</font></td>
<td><font style="font-size:12" color="white"><b>Nationality:</b></font></td><td><input type="text" name="nationality" value="<%=seo.getNationality()%>"></td></tr>
<tr><td width="20%"><font style="font-size:12" color="white"><b>Domicile:</b></font></td><td width="30%"><input type="text" name="domicile" value="<%=seo.getDomicile()%>"></td>
<td width="20%"><font style="font-size:12" color="white"><b>Regular/Private:</b></font></td>
<td width="30%"><table><tr>
<td><input type="radio" name="admin_type" value="REGULAR" <%if(seo.getAdminType().equals("REGULAR")){%>checked<%}%>><font style="font-size:12" color="white"><b>REGULAR</td>
<td><input type="radio" name="admin_type" value="PRIVATE" <%if(seo.getAdminType().equals("PRIVATE")){%>checked<%}%>><font style="font-size:12" color="white"><b>PRIVATE</td>
</tr></table></td></tr>
<tr><td><font style="font-size:12" color="white"><b>Residence Number:</b></font></td><td><input type="text" name="pnum" value="<%=seo.getRnum()%>"></td>
<td><font style="font-size:12" color="white"><b>Mobile:</b></font></td><td><font style="font-size:12" color="white"><b>+91<input type="text" name="pmobile" value="<%=seo.getMobile()%>"></td></tr>
<tr><td><font style="font-size:12" color="white"><b>Address:</b></font></td><td colspan="3"><textarea rows="3" cols="40" name="padd"><%=seo.getAddress()%></textarea></td></tr>

<tr><td colspan="4"><table width="100%" align="left" border="0" style="border-collapse:collapse">
<tr><td bgcolor="black"><font style="font-size:12" color="white"><b>Class</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Max. Marks</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Obt. Marks</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>(%)</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Board/University</b></font></td></tr>
<%//if(seo.getHighMm()!=0.0 && seo.getInterMm()!=0.0){%>
<tr><td bgcolor="black"><font style="font-size:12" color="white"><b>HighSchool</b></font></td>
<td><input type="text" name="highmm" value="<%=seo.getHighMm()%>" onkeyup="highPer();"></td>
<td><input type="text" name="highobt" value="<%=seo.getHighObt()%>" onkeyup="highPer();"></td>
<td><input type="text" name="highper" value="<%=seo.getHighSchool()%>"></td>
<td><input type="text" name="highboard" value="<%=seo.getHighBoard()%>"></td></tr>

<tr><td bgcolor="black"><font style="font-size:12" color="white"><b>Intermediate</b></font></td>
<td><input type="text" name="intermm" value="<%=seo.getInterMm()%>" onkeyup="interPer();"></td>
<td><input type="text" name="interobt" value="<%=seo.getInterObt()%>" onkeyup="interPer();"></td>
<td><input type="text" name="interper" value="<%=seo.getIntermediate()%>"></td>
<td><input type="text" name="interboard" value="<%=seo.getInterBoard()%>"></td></tr>
<%//}else{%>
<tr><td width="20%" bgcolor="black"><font style="font-size:12" color="white"><b>Previous Year</b></font></td>
<td><input type="text" name="prevmm" value="<%=seo.getPrevMm()%>" onkeyup="prevPer();"></td>
<td><input type="text" name="prevobt" value="<%=seo.getPrevObt()%>" onkeyup="prevPer();"></td>
<td><input type="text" name="prevper" value="<%=seo.getPpercent()%>"></td>
<td><input type="text" name="prevboard" value="<%=seo.getPrevBoard()%>"></td></tr>
<%//}%>
</table></td></tr>
</table></td></tr>
<tr><td><table width="100%" align="center">     
<tr><td></td><td align="center"><input type="submit" value="Edit Record"></td></tr>
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