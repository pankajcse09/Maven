<%-- 
    Document   : StudentRegistration
    Created on : Sep 4, 2014, 10:56:43 AM
    Author     : kapil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ActionClass.MyMeth"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="Beans.JavaBean"%>
<!DOCTYPE html>
<% 
    
    String Eyear="";
    int Syear=0;
    
    String prev="";
    String next="";
     
    
    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    
    String Styear=sdf2.format(dt);
    Syear=Integer.parseInt(Styear);    
    Eyear=new Integer(Syear+1).toString(); 
    prev=(Syear-1)+"-"+Syear;
    next=Syear+"-"+(Syear+1);
    
    


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
if(document.studre.batch.value=="")
{
alert("Please Select Bacth");
document.studre.batch.focus();
return false;
}

if(document.studre.sname.value=="")
{
alert("Please Enter Student Name");
document.studre.sname.focus();
return false;
}


//if(!document.studre.category.checked){
//var radios = document.getElementsByName("category");
//    var formValid = false;
//    var i = 0;
//    while (!formValid && i < radios.length) {
//        if (radios[i].checked) formValid = true;
//        i++;        
//    }

//    if (!formValid) alert("Please Select Category!");
//    return formValid;
//     }

}
     </script>
    
     </head>
    <body bgcolor="#999933">
        <%
        
        JavaBean jb=new JavaBean();
        ArrayList degreelist=new ArrayList();
        MyMeth fun=new MyMeth();
         degreelist=(ArrayList)fun.Degree_list();
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
             <td valign="top" align="left"><table width="80%">
                <tr><td>
<table style="padding-left: 300px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Student Registration</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 50px" width="100%">
   
 <%if(request.getAttribute("existnum")!=null)
   out.println("<font color='yellow'><b>"+request.getAttribute("existnum")+"</b></font>");  
  if(request.getAttribute("msg")!=null)
   out.println("<font color='yellow'><b>"+request.getAttribute("msg")+"</b></font>");
   %>    
<table width="99%" cellpadding="0" cellspacing="0"  align="left" border=0>
<tr><td><font color="darkred" size="2"><b>* Fields are mandatory</b></font></td></tr>
<tr><td valign="top">
        
<form method="post" name="studre" action="<%=request.getContextPath()%>/registaction.do?method=reg" onsubmit="return chkvalidate();">
<table width="100%" align="center" border="0" style="border-collapse:collapse"> 
<tr>
<td width="20%"><font color="darkred">*</font><font color="black" style="font-size:12"><b>Batch</b></font></td>
    <td><select name="batch">
            <option value="">Select</option>
<%for(int i=0;i<=7;i++)
{
    %>
<option value="<%=Syear-i%>"><%=Syear-i%></option>
<%}%>
</select></td>
<td width="20%"><font color="black" style="font-size:12"><b>Roll No:</b></font></td>
<td width="30%"><input type="text" name="srnum" value=""></td>
</tr>
<tr>
<td width="20%"><font color="black" style="font-size:12"><b>Student Id:</b></font></td>
<td><input type="text" name="stud_id" value="" ></td>
 <td width="20%"><font style="font-size:12" color="black"><b>Programme:</b></font></td>
    <td align="left" style="padding-left: 3px;">
     <select name="degree" style="width:173px;">
    <option value="">None</option>
<%for(int i=0;i<degreelist.size();i++){
jb=(JavaBean)degreelist.get(i);
%>
<option value="<%=jb.getDegree()%>"><%=jb.getDegree()%></option>
<%}%>
</select>       
        </td>
</tr>
<tr><td width="20%"><font color="darkred">*</font><font style="font-size:12" color="black"><b>Student Name:</b></font></td>
<td colspan="3"><input type="text" name="sname" value="" size="40"><font color="darkred" size="2">Enter full name</font></td></tr>

<tr><td width="20%"><font style="font-size:12" color="black"><b>Father's Name:</b></font></td>
<td width="30%"><input type="text" name="fname" value=""></td>
<td width="20%"><font style="font-size:12" color="black"><b>Father's Occupation:</b></font></td>
<td width="30%"><input type="text" name="foccup" value=""></td></tr>
<!--<tr><td width="20%"><font style="font-size:12" color="black"><b>Mothers's Name:</b></font></td>
<td width="30%"><input type="text" name="mname" value=""></td>
<td width="25%"><font style="font-size:12" color="black"><b>Mothers's Occupation:</b></font></td>
<td width="30%"><input type="text" name="moccup" value=""></td></tr>-->

<tr><td width="20%"><font style="font-size:12" color="black"><b>Gender:</b></font></td>
<td width="30%" style="padding-left: 3px;"><select name="gender" style="width:173px;">
        <option value="">Select</option>
<option value="MALE">MALE</option>
<option value="FEMALE">FEMALE</option>
</select></td>
<td width="20%"><font style="font-size:12" color="black"><b>Date of Birth:</b></font></td>
    <td width="35%"><input type="text" name="dob" value=""><font color="darkred" size="1">(dd/mm/yyyy)</font></td>
</tr>
<tr><td><font style="font-size:12" color="black"><b>Category:</b></font></td>
<td colspan="3"><table><tr>
<td><input type="radio" name="category" value="GENERAL"><font style="font-size:12" color="black">GENERAL</td>
<td><input type="radio" name="category" value="SC"><font style="font-size:12" color="black">SC</td>
<td><input type="radio" name="category" value="ST"><font style="font-size:12" color="black">ST</td>
<td><input type="radio" name="category" value="OBC"><font style="font-size:12" color="black">OBC</td>
</tr></table></td></tr>
<tr>
    <td><font style="font-size:12" color="black"><b>Student Type:</b></font></td>
    <td><select name="stud_type">
           <option value="Hosteller">Hosteller</option>
           <option value="Day Scholar">Day Scholar</option>
           <option value="Staff">Staff</option>
       </select></td>
    <td><font style="font-size:12" color="black"><b>New Beni:</b></font></td>
    <td><select name="new_beni">
           <option value="NO">NO</option>
           <option value="Yes">YES</option>
        </select></td>
</tr>
<tr><td><font style="font-size:12" color="black"><b>ICAR:</b></font></td>
    <td><select name="icar">
            <option value="NO">NO</option>
            <option value="YES">YES</option>
         </select></td>
   <td><font style="font-size:12" color="black"><b>Gate:</b></font></td>
    <td><select name="gate">
            <option value="NO">NO</option>
            <option value="YES">YES</option>
         </select></td>      
</tr>
<tr><td colspan="4"><hr></td></tr>
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

