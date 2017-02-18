<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page language="java"%>
<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*,EO.*"%>
<%@page import="Beans.JavaBean"%>
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
 <title>College Management System</title>
 <script language="JavaScript">    
function classType(){
document.studre.method="post";
document.studre.action="<%=request.getContextPath()%>/Stud_Regis_1.do?method=typeAction";
document.studre.submit();
}

function highPer(){
if(parseFloat(document.studre.elements["highmm"].value)!=0.0){
try{
document.studre.elements["highper"].value=(parseFloat(document.studre.elements["highobt"].value)*100)/parseFloat(document.studre.elements["highmm"].value);
}catch(e){
document.studre.elements["highper"].value=0.0;
}
}
}

function interPer(){
if(parseFloat(document.studre.elements["intermm"].value)!=0.0){
try{
document.studre.elements["interper"].value=(parseFloat(document.studre.elements["interobt"].value)*100)/parseFloat(document.studre.elements["intermm"].value);
}catch(e){
document.studre.elements["interper"].value=0.0;
}
}
}

function prevPer(){
if(parseFloat(document.studre.elements["prevmm"].value)!=0.0){
try{
document.studre.elements["prevper"].value=(parseFloat(document.studre.elements["prevobt"].value)*100)/parseFloat(document.studre.elements["prevmm"].value);
}catch(e){
document.studre.elements["prevper"].value=0.0;
}
}
}

function retBlock(){
  document.forms[0].method="post";
  document.forms[0].action="<%=request.getContextPath()%>/RtBran.do?method=rtBran";
  document.forms[0].submit();
  }

function chkvalidate()
{
if(document.studre.srnum.value=="")
{
alert("Please Enter Scholars Number");
document.studre.srnum.focus();
return false;
}
//if(!document.studre.degree.checked)
//{
//alert("Please Enter degree Number");
//return false;
//}
if(document.studre.seekadd.value=="")
{
alert("Please Enter Semester of Student");
document.studre.seekadd.focus();
return false;
}
if(document.studre.sname.value=="")
{
alert("Please Enter Student Name");
document.studre.sname.focus();
return false;
}
if(document.studre.fname.value=="")
{
alert("Please Enter Father Name");
document.studre.fname.focus();
return false;
}
if(document.studre.year_regist.value=="")
{
alert("Please Enter Year of Registration");
document.studre.year_regist.focus();
return false;
}

if(document.studre.gender.value=="")
{
alert("Please Enter Gender of Student");
document.studre.gender.focus();
return false;
}
if(document.studre.dob.value=="")
{
alert("Please Enter Date of Birth of Student");
document.studre.dob.focus();
return false;
}
if(!document.studre.category.checked){
var radios = document.getElementsByName("category");
    var formValid = false;
    var i = 0;
    while (!formValid && i < radios.length) {
        if (radios[i].checked) formValid = true;
        i++;        
    }

    if (!formValid) alert("Please Select Category!");
    return formValid;
     }



}
     </script>
     <script>
         
//function retBlock(deg){
    //document.getElementById("here").innerHTML=deg;
    //var xmlhttp;
    //if(window.XMLHttpRequest){
        //xmlhttp=new XMLHttpRequest;
    //}
    //else{
       // xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    //}
    //xmlhtt.onreadychangestate=function()
    //{
        //if(xmlhttp.readystate==4 && xmlhttp.status==200)
            //{
                
   //         }
   // }
  //  xmlhttp.open("GET","<%=request.getContextPath()%>/RtBran.do?method=rtBran");
  //  xmlhttp.send();
  //document.forms[0].method="post";
  //document.forms[0].action="<%=request.getContextPath()%>/RetBranch.do?method=retBranch";
  //document.forms[0].submit();
 // }
     </script>
     </head>
    <body bgcolor="#999933">
        <%
        String obtain="";
        String sess="";
        String sr_no="";
        if(request.getAttribute("session")!=null){
        sess=(String)request.getAttribute("session");
               }
        if(request.getAttribute("obtain")!=null){
        obtain=(String)request.getAttribute("obtain");
               }
        if(request.getAttribute("ser_num")!=null){
        sr_no=(String)request.getAttribute("ser_num");
               }
        JavaBean jb=new JavaBean();
        
        ArrayList BranchList=new ArrayList();
        if(request.getAttribute("branchlist")!=null)
   {
   BranchList=(ArrayList)request.getAttribute("branchlist");
    }
        %>
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
            <tr><td align="left" valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 300px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Student Registration</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 50px">
   
 <%if(request.getAttribute("existnum")!=null)
   out.println("<font color='red'><b>"+request.getAttribute("existnum")+"</b></font>");  
  if(request.getAttribute("msg")!=null)
   out.println("<font color='red'><b>"+request.getAttribute("msg")+"</b></font>");
   %>    
<table width="99%" cellpadding="0" cellspacing="0"  align="left" border=0>
<tr><td><font color="red" size="2"><b>* Fields are mandatory</b></font></td></tr>
<tr><td valign="top">
<form method="post" name="studre" action="<%=request.getContextPath()%>/sregis.do" onsubmit="return chkvalidate();">
<input type="hidden" name="Syear" value="<%=seo.getSyear()%>">
<input type="hidden" name="Eyear" value="<%=seo.getEyear()%>">
<input type="hidden" name="sesdate" value="01/07/<%=seo.getSyear()%>"> 
<table width="100%" align="center" border="0" style="border-collapse:collapse"> 
<tr><td width="20%"><font color=red>*</font><font color="black" style="font-size:12"><b>Session:</b></font></td>
    <% if(sess!=null&&sess!=""){%>
    <td width="30%"><select name="session">
   
<option value="<%=sess%>"><%=sess%></option>
<%if(!seo.getSession().equals(prev)&&!prev.equals(sess)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)&&!next.equals(sess)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select></td>  
    <%} else{%>
<td width="30%"><select name="session">
 <%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select></td> 
<%}%>
<% if(sr_no!=null&&sr_no!=""){%>
<td width="20%"><font color=red>*</font><font color="black" style="font-size:12"><b>Admission Form No:</b></font></td>
<td width="30%"><input type="text" name="srnum" value="<%=sr_no%>"></td>
<%} else{ %>
<td width="20%"><font color=red>*</font><font color="black" style="font-size:12"><b>Admission Form No:</b></font></td>
<td width="30%"><input type="text" name="srnum" value="<%=seo.getSrnum()%>"></td>
<%}%>
</tr>
<tr>
<div id="here"></div>
 <td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Degree:</b></font></td>
<% if(obtain.equals("BTECH")){%>
        <td align="left"><input type="radio" value="BTECH" name="degree" checked="checked"><font color="black" style="font-size:12"><b>B.Tech</b></font></td>
    <%} else{%>
    <td  align="left"><input type="radio" value="BTECH" name="degree" onclick="retBlock();"><font color="black" style="font-size:12"><b>B.Tech</b></font></td>
    <%}%>
    <% if(obtain.equals("MBA")){%>
    <td  align="left"><input type="radio" value="MBA" name="degree" checked="checked"><font color="black" style="font-size:12"><b>MBA</b></font></td>
    <%} else{%>
    <td  align="left"><input type="radio" value="MBA" name="degree" onclick="retBlock();"><font color="black" style="font-size:12"><b>MBA</b></font></td>
    <%}%>
</tr>
<% for(int k=0; k<BranchList.size();k++)
{
    jb=(JavaBean)BranchList.get(k);
%>
<tr>
    <td colspan="2"><input type="radio" value="<%=jb.getBranch()%>" name="branch"><font color="black" style="font-size:12"><b><%=jb.getBranch()%></b></font></td>
    <% k++;
        if(k<BranchList.size()){
        jb=(JavaBean)BranchList.get(k);
    %>
<td colspan="2"><input type="radio" value="<%=jb.getBranch()%>" name="branch"><font color="black" style="font-size:12"><b><%=jb.getBranch()%></b></font></td>
</tr>
<%}}%>
<tr>
    <td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Semester:</b></font></td>
    <td ><select name="seekadd"><!--<select name="seekadd" onblur="classType();">-->
<%if(seo.getSeekadd().equals("")){%>
<option value="">SELECT</option>     
<%}else{%>
<option value="<%=seo.getSeekadd()%>"><%=seo.getSeekadd()%></option>      
<%}for(int i=0;i<ar2.size();i++){
if(seo.getSeekadd().equals(ar2.get(i))){continue;}
%>
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select></td>
<td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Registration Fee:</b></font></td>
<td width="30%"><input type="text" name="regis_fee" value="10000"></td></tr>
</tr>
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Student Name:</b></font></td>
<td colspan="3"><input type="text" name="sname" value="<%=seo.getSname()%>" size="40"><font color=red size="2" color="black">Enter full name</font></td></tr>

<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Father's Name:</b></font></td>
<td width="30%"><input type="text" name="fname" value="<%=seo.getFname()%>"></td>
<td width="20%"><font style="font-size:12" color="black"><b>Father's Occupation:</b></font></td>
<td width="30%"><input type="text" name="foccup" value=""></td></tr>
<tr><td width="20%"><font style="font-size:12" color="black"><b>Mothers's Name:</b></font></td>
<td width="30%"><input type="text" name="mname" value="<%=seo.getMname()%>"></td>
<td width="25%"><font style="font-size:12" color="black"><b>Mothers's Occupation:</b></font></td>
<td width="30%"><input type="text" name="moccup" value=""></td></tr>

<tr><td width="25%"><font color=red>*</font><font style="font-size:12" color="black"><b>Year of Registration:</b></font></td><td><input type="text" name="year_regist" value="<%=seo.getYearRegist()%>"></td>
<!--<td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Class of Registration:</b></font></td><td width="30%"><input type="text" name="class_regist" value="<%=seo.getClassRegist()%>"></td>-->
    <td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Gender:</b></font></td>
<td width="30%"><select name="gender">
<option value="<%=seo.getGender()%>"><%=seo.getGender()%></option>
<option value="MALE">MALE</option>
<option value="FEMALE">FEMALE</option>
</select></td>
</tr>

<!--<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Gender:</b></font></td>
<td width="30%"><select name="gender">
<option value="<%=seo.getGender()%>"><%=seo.getGender()%></option>
<option value="MALE">MALE</option>
<option value="FEMALE">FEMALE</option>
</select></td>
<td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>PG / UG / DIPLOMA :</b></font></td>
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
</select></td>-->
</tr>

<!--<tr><td><font color=red>*</font><font style="font-size:12" color="black"><b>Class:</b></font></td>
<td colspan="3"><select name="seekadd">
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
<tr><td><font color=red>*</font><font style="font-size:12" color="black"><b>Subject:</b></font></td><td colspan="3">
<%for(int i=0;i<ar.size();i++){%>
<input type="checkbox" name="sub" value="<%=ar.get(i)%>"><%=ar.get(i)%>    
<%}%>     
</td></tr>-->
<tr><td><font color=red>*</font><font style="font-size:12" color="black"><b>Category:</b></font></td>
<td colspan="3"><table><tr>
<td><input type="radio" name="category" value="GENERAL"><font style="font-size:12" color="black">GENERAL</td>
<td><input type="radio" name="category" value="SC"><font style="font-size:12" color="black">SC</td>
<td><input type="radio" name="category" value="ST"><font style="font-size:12" color="black">ST</td>
<td><input type="radio" name="category" value="OBC"><font style="font-size:12" color="black">OBC</td>
</tr></table></td></tr>
<!--<tr><td width="20%"><font style="font-size:12" color="white"><b>Image:</b></font></td><td colspan="3"><input type="file" name="pic" value=""></td></tr>-->
<tr><td width="20%"><font color=red>*</font><font style="font-size:12" color="black"><b>Date of Birth:</b></font></td><td width="35%"><input type="text" name="dob" value=""><font color="red" size="1">(dd/mm/yyyy)</font></td>
<td width="20%"><font style="font-size:12" color="black"><b>Nationality:</b></font></td><td width="30%"><input type="text" name="nationality" value=""></td></tr>
<!--<tr><td width="20%"><font style="font-size:12" color="black"><b>Domicile:</b></font></td><td width="30%"><input type="text" name="domicile" value=""></td>
<td width="20%"><font style="font-size:12" color="black"><b>Regular/Private:</b></font></td>
<td width="30%"><table><tr>
<td><input type="radio" name="admin_type" value="REGULAR"><font style="font-size:12" color="black">REGULAR</td>
<td><input type="radio" name="admin_type" value="PRIVATE"><font style="font-size:12" color="black">PRIVATE</td>
</tr></table></td></tr>-->
<tr>
    <td width="20%"><font style="font-size:12" color="black"><b>Blood Group:</b></font></td><td width="30%"><input type="text" name="bld_grp" value=""></td>
    <td width="20%"><font style="font-size:12" color="black"><b>Marital Status:</b></font></td>
    <td width="30%"><select name="marital">
            <option value="">Select</option>
            <option value="married">Married</option>
            <option value="unmarried">Unmarried</option>
        </select></td>
</tr>
<tr><td><font style="font-size:12" color="black"><b>Phone No:</b></font></td><td><input type="text" name="pnum" value=""></td>
<td><font style="font-size:12" color="black"><b>Mobile:</b></font></td><td><input type="text" name="pmobile" value=""></td></tr>
<tr><td><font style="font-size:12" color="black"><b>Facility to be availed:</b></font></td>
    <td><select name="facility">
            <option value="none">None</option>
            <option value="hostel">Hostel</option>
            <option value="transport">Transport</option>
        </select></td></tr>
<tr><td><font style="font-size:12" color="black"><b>Address:</b></font></td><td colspan="3"><textarea rows="3" cols="40" name="padd"></textarea></td></tr>
<tr><td colspan="4"><table width="100%" align="left" border="0" style="border-collapse:collapse">
<tr><td bgcolor="black"><font style="font-size:15" color="white"><b>Class</b></font></td>
    <td bgcolor="black"><font style="font-size:12px" color="white"><b>Institution</b></font></td>
    <td  bgcolor="black"><font style="font-size:12px" color="white"><b>Board/University</b></font></td>
    <td bgcolor="black"><font style="font-size:12px" color="white"><b>Year of Passing</b></font></td>
<td  bgcolor="black"><font style="font-size:12px" color="white"><b>Max. Marks</b></font></td>
<td  bgcolor="black"><font style="font-size:12px" color="white"><b>Obt. Marks</b></font></td>
<td  bgcolor="black"><font style="font-size:12px" color="white"><b>(%)</b></font></td>
</tr>

<tr><td  bgcolor="black"><font style="font-size:12" color="white"><b>HighSchool</b></font></td>
    <td><input type="text" name="highins" value="" size="12"></td>
    <td><input type="text" name="highboard" value="" size="12"></td>
    <td><input type="text" name="highyr" value="" size="12"></td>
<td><input type="text" name="highmm" value="0.0" size="12" onkeyup="highPer();"></td>
<td><input type="text" name="highobt" value="0.0" size="12" onkeyup="highPer();"></td>
<td><input type="text" name="highper" value="0.0" size="12"></td>
</tr>

<tr><td  bgcolor="black"><font style="font-size:12" color="white"><b>Intermediate</b></font></td>
    <td><input type="text" name="interins" value="" size="12"></td>
    <td><input type="text" name="interboard" value="" size="12"></td>
    <td><input type="text" name="interyr" value="" size="12"></td>
<td><input type="text" name="intermm" value="0.0" size="12" onkeyup="interPer();"></td>
<td><input type="text" name="interobt" value="0.0" size="12" onkeyup="interPer();"></td>
<td><input type="text" name="interper" value="0.0" size="12"></td>
</tr>

<tr><td width="20%" bgcolor="black"><font style="font-size:12" color="white"><b>Previous Year</b></font></td>
    <td valign="top"><input type="text" name="previns" value="" size="12"></td>
    <td valign="top"><input type="text" name="prevboard" value="" size="12"></td>
    <td valign="top"><input type="text" name="prevyr" value="" size="12"></td>
<td valign="top"><input type="text" name="prevmm" value="0.0" size="12" onkeyup="prevPer();"></td>
<td valign="top"><input type="text" name="prevobt" value="0.0" size="12" onkeyup="prevPer();"></td>
<td valign="top"><input type="text" name="prevper" value="0.0" size="12"></td>
</tr>
</table></td></tr>

<tr><td colspan="4"><table width="100%" align="left" border="0" style="border-collapse:collapse">
            <tr><td><font style="font-size:15px" color="black"><b><u>Ranking:</u></b></font></td></tr>
            <tr><td><font style="font-size:12" color="black"><b>AIEEE Rank:</b></font></td><td><input type="text" name="airank" value=""></td></tr>
    <tr><td><font style="font-size:12" color="black"><b>CAT Rank:</b></font></td><td><input type="text" name="catrank" value=""></td>
    <td><font style="font-size:12" color="black"><b>Month/Year:</b></font></td><td><input type="text" name="ca_mon_year" value=""></td>
    </tr>
    <tr><td><font style="font-size:12" color="black"><b>MAT Rank:</b></font></td><td><input type="text" name="matrank" value=""></td>
    <td><font style="font-size:12" color="black"><b>Month/Year:</b></font></td><td><input type="text" name="ma_mon_year" value=""></td>
            </tr>
        </table></td></tr>

<tr><td colspan="4">
<table width="100%" align="center"><tr><td></td><td align="center"><input type="submit" value="Register"></td></tr></table>
</td></tr>
</table>
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
