<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page language="java"%>
<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*,EO.*"%>
<!DOCTYPE html>
<% 
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    Statement stmt3=null;
    ResultSet rs3=null;
    
    int srnum=0;
    int srnum1=0;
    String classes="";
    String Eyear="";
    int Syear=0;
    String sesdate="";
    String prev="";
    String next="";
    SchoolEO seo=new SchoolEO();   
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String dat=sdf.format(dt);
    String Styear=sdf2.format(dt);
    Syear=Integer.parseInt(Styear);    
    Eyear=new Integer(Syear+1).toString(); 
    prev=(Syear-1)+"-"+Syear;
    next=Syear+"-"+(Syear+1);
    seo.setSyear(Styear);
    seo.setEyear(Eyear);
    
    try{                   
     DataConnection dc=new DataConnection();
     cn=(Connection)dc.Dataconnect();
    }catch(Exception e){}
  
         try{           
             String qry="Select * from setsrnum";        
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(qry);
             while(rs3.next())
             {
              srnum=rs3.getInt("srnum");
              // srnum=srnum1+1;                 
             }             
  } catch(SQLException e){}    
 
   ArrayList ar2=new ArrayList();
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="calendarDateInput.js"></script>         
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/ajaxxml.js"></script>
 <title>School Management System</title>
<script language="JavaScript"> 
function prevPer(){
try{
document.studre.elements["prevper"].value=(parseFloat(document.studre.elements["prevobt"].value)*100)/parseFloat(document.studre.elements["prevmm"].value);
}catch(e){
document.studre.elements["prevper"].value=0.0;
}
}
 </script> 
  <script language="JavaScript">    
 function showStudSub(){ 
 var ss=document.getElementById("seekadd").value;
 xmlHttp=getXmlHttpObject();
 if (xmlHttp==null){
 alert ("Browser does not support HTTP Request");
 return;
 }
var url="<%=request.getContextPath()%>/RetrivedData/RetStudSub.jsp";
url=url+"?cls="+ss;
xmlHttp.onreadystatechange=stateChanged2;
xmlHttp.open("POST",url,true);
xmlHttp.send(null);
} 
function stateChanged2(){ 
var str='';
var obj='';
obj=document.getElementById('sp');
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 	
    var showdata = xmlHttp.responseText;  
    var strar = showdata.split(":");  
    if(strar.length>1){
    for(i=1;i<strar.length;i++){
    str+='<input type=\"checkbox\" name=\"sub\" value=\"'+strar[i]+'\"><font style=\"font-size:12;color:white\"><b>'+strar[i]+'</b></font>';
    }    
    obj.innerHTML=str;
    }else{
    obj.innerHTML='';
    }
 } 
}  
 </script>
 <script language="JavaScript">    
 function showStudData(en){ 
 xmlHttp=getXmlHttpObject();
 if (xmlHttp==null){
 alert ("Browser does not support HTTP Request");
 return;
 }
var url="<%=request.getContextPath()%>/fee/RetStudData.jsp";
url=url+"?en="+en;
xmlHttp.onreadystatechange=stateChanged;
xmlHttp.open("POST",url,true);
xmlHttp.send(null);
}     

function stateChanged(){ 
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 	
    var showdata = xmlHttp.responseText;  
    var strar = showdata.split(":");
    if(strar.length>1){
    document.getElementById("sname").value=strar[3];
    document.getElementById("dob").value=strar[4];
    document.getElementById("gender").value=strar[6];
    document.getElementById("nationality").value=strar[7];
    document.getElementById("fname").value=strar[8];
    document.getElementById("year_regist").value=strar[11];
    document.getElementById("class_regist").value=strar[12]; 
    document.getElementById("standard").value=strar[13]; 
    document.getElementById("pnum").value=strar[14]; 
    document.getElementById("pmob").value=strar[15];
    document.getElementById("padd").value=strar[16]; 
    document.getElementById("domicile").value=strar[17];     
    if(strar[10]=="GENERAL"){document.getElementById("cat1").checked=1;}
    if(strar[10]=="SC"){document.getElementById("cat2").checked=1;}
    if(strar[10]=="ST"){document.getElementById("cat3").checked=1;}
    if(strar[10]=="OBC"){document.getElementById("cat4").checked=1;}    
    if(strar[18]=="REGULAR"){document.getElementById("adm1").checked=1;}
    if(strar[18]=="PRIVATE"){document.getElementById("adm2").checked=1;}
    }else{
    document.getElementById("sname").value="";
    document.getElementById("dob").value="";
    document.getElementById("gender").value="";
    document.getElementById("nationality").value="";
    document.getElementById("fname").value="";
    document.getElementById("year_regist").value="";
    document.getElementById("class_regist").value=""; 
    document.getElementById("standard").value=""; 
    document.getElementById("pnum").value=""; 
    document.getElementById("pmob").value=""; 
    document.getElementById("padd").value=""; 
    document.getElementById("cat1").checked=1;
    document.getElementById("ad1").checked=1;
   }
 } 
}    
     
function classType(){
document.studre.method="post";
document.studre.action="<%=request.getContextPath()%>/Stud_Regis_3.do?method=typeAction";
document.studre.submit();
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

if(document.studre.fname.value=="")
{
alert("Please Enter Father's Name");
document.studre.fname.focus();
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration/Student Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left"  valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 300px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Old Student Registration</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 100px">
   
<%if(request.getAttribute("msg")!=null){%>
<font color='red'><b><%=request.getAttribute("msg")%></b></font>
<%}%> 
<form method="post" name="studre" action="<%=request.getContextPath()%>/oldstregis.do" onsubmit="return chkvalidate();">
<table width="100%" cellpadding="0" cellspacing="0"  align="left" border=0>
<tr><td><font color="red" size="2"><b>*Fields are Mandatory</b></font></td></tr>
<tr><td valign="top">
<input type="hidden" name="Syear" value="<%=seo.getSyear()%>">
<input type="hidden" name="Eyear" value="<%=seo.getEyear()%>">
<input type="hidden" name="sesdate" value="01/07/<%=seo.getSyear()%>">
<table width="100%" cellpadding="0" cellspacing="0" align="center">
<tr><td>
<table width="100%" align="center" border="0" style="border-collapse:collapse"> 
<tr><td width="20%"><font color=red>*</font><font color="white" size="2"><b>Admission No:</td><td width="30%"><input type="text" name="srnum" id="enrol_no" value="<%=seo.getSrnum()%>" onblur="showStudData(this.value);"></td>   
 <td width="20%"><font color=red>*</font><font color="white" size="2"><b>Session:</td>
<td width="30%"><select name="session">
 <%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select></td></tr>
<tr><td width="20%"><font color=red>*</font><font color="white" size="2"><b>Student Name:</td>
<td colspan="3"><input type="text" name="sname" id="sname" value="<%=seo.getSname()%>" size="40"><font color=red size="2">Enter Full Name</font></td></tr>
<tr><td width="20%"><font color=red>*</font><font color="white" size="2"><b>Gender:</td><td width="30%"><select name="gender" id="gender">
<option value="<%=seo.getGender()%>"><%=seo.getGender()%></option>
<option value="MALE"><font color="white" size="2"><b>MALE</option>
<option value="FEMALE"><font color="white" size="2"><b>FEMALE</option>
</select></td>
<td width="20%"><font color=red>*</font><font color="white" size="2"><b>Father's Name:</td><td width="30%"><input type="text" name="fname" id="fname" value="<%=seo.getFname()%>" size="30%"></td></tr>
<tr><td><font color=red>*</font><font color="white" size="2"><b>Year of Registration:</td><td><input type="text" name="year_regist" value="<%=seo.getYearRegist()%>"></td>
<td width="20%"><font color=red>*</font><font color="white" size="2"><b>Class of Registration:</td><td width="30%"><input type="text" name="class_regist" value="<%=seo.getClassRegist()%>"></td></tr>
<tr><td><font color=red>*</font><font color="white" size="2"><b>PG/UG/DIPLOMA:</td>
<td><select name="standard" id="standard">    
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
</select></td>
<td><font color=red>*</font><font color="white" size="2"><b>Class:</td>
<td><select name="seekadd" id="seekadd" onchange="showStudSub();">
<%if(seo.getSeekadd().equals("")){%>
<option value="">SELECT</option>     
<%}else{%>
<option value="<%=seo.getSeekadd()%>"><%=seo.getSeekadd()%></option>      
<%}for(int i=0;i<ar2.size();i++){
if(seo.getSeekadd().equals(ar2.get(i))){continue;}
%>
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select></td></tr>
<tr><td><font color=red>*</font><font style="font-size:12" color="white"><b>Subject:</b></font></td><td colspan="3">
<span id="sp"></span>    
</td></tr>
<tr><td><font color=red>*</font><font color="white" size="2"><b>Category:</td>
<td colspan="3"><table><tr>
<td><input type="radio" name="category" id="cat1" value="GENERAL"><font color="white" size="2"><b>GENERAL</font></td>
<td><input type="radio" name="category" id="cat2" value="SC"><font color="white" size="2"><b>SC</font></td>
<td><input type="radio" name="category" id="cat3" value="ST"><font color="white" size="2"><b>ST</font></td>
<td><input type="radio" name="category" id="cat4" value="OBC"><font color="white" size="2"><b>OBC</font></td>
</tr></table>
</td></tr>
<!--<tr><td width="20%"><font color="white" size="2"><b>Image:</td><td colspan="3"><input type="file" name="pic" value=""></td></tr>-->
<tr><td><font color="white" size="2"><b>Date of Birth:</td><td><input type="text" name="dob" id="dob"><font color="red" size="1">(dd/mm/yyyy)</font></td>
<td><font color="white" size="2"><b>Nationality:</td><td><input type="text" name="nationality" id="nationality"><font color="red" size="1">(dd/mm/yyyy)</font></td></tr>
<tr><td width="20%"><font style="font-size:12" color="white"><b>Domicile:</b></font></td><td width="30%"><input type="text" name="domicile" id="domicile"></td>
<td width="20%"><font style="font-size:12" color="white"><b>Regular/Private:</b></font></td>
<td width="30%"><table><tr>
<td><input type="radio" name="admin_type" id="adm1" value="REGULAR"><font style="font-size:12" color="white">REGULAR</font></td>
<td><input type="radio" name="admin_type" id="adm2" value="PRIVATE"><font style="font-size:12" color="white">PRIVATE</font></td>
</tr></table></td></tr>
<tr><td><font color="white" size="2"><b>Phone No:</td><td><input type="text" name="pnum" id="pnum"></td>
<td><font color="white" size="2"><b>Mobile:</td><td><input type="text" name="pmobile" id="pmob"></td></tr>
<tr><td><font color="white" size="2"><b>Address:</td><td colspan="3"><textarea rows="3" cols="40" name="padd" id="padd"></textarea></td></tr>

<tr><td colspan="4"><table width="100%" align="left" border="0" style="border-collapse:collapse">
<tr><td width="20%" bgcolor="black"><font style="font-size:12" color="white"><b>Class</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Max. Marks</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Obt. Marks</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>(%)</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Board/University</b></font></td></tr>

<tr><td width="20%" bgcolor="black"><font style="font-size:12" color="white"><b>Previous Year</b></font></td>
<td><input type="text" name="prevmm" value="" onkeyup="prevPer();"></td>
<td><input type="text" name="prevobt" value="" onkeyup="prevPer();"></td>
<td><input type="text" name="prevper" value=""></td>
<td><input type="text" name="prevboard" value=""></td></tr>
</table></td></tr>

</table></td></tr>
 <tr><td><table width="100%" align="center">
<tr><td height="5"></td></tr>
<tr><td></td><td align="center"><input type="submit" value="Register"></td></tr>
 </table></td></tr>
 </td></tr></table>
</form> 
</td></tr></table>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
