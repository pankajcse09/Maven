<%-- 
    Document   : EditStudentRegistration
    Created on : Nov 5, 2014, 10:41:30 AM
    Author     : kapil
--%>

<%@page import="EO.SchoolEO"%>
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
    SchoolEO seo=new SchoolEO();
    if(request.getAttribute("jbean")!=null){
        seo=(SchoolEO)request.getAttribute("jbean");
    }
    
    SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
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

function chkvalidate()
{
if(document.f1.batch.value=="")
{
alert("Please Select Bacth");
document.f1.batch.focus();
return false;
}
var stid=document.f1.stud_id.value;
var srnum=document.f1.srnum.value;
if(stid==""&&srnum=="")
{
alert("Please Enter Student Id or Student Roll number.");
document.f1.stud_id.focus();
return false;
}
}

function chkvalidate1()
{
if(document.f2.sname.value=="")
{
alert("Please enter student name");
document.f1.batch.focus();
return false;
}
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
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Edit Student Registration</b></font></td></tr>
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
<form method="post" name="f1" action="<%=request.getContextPath()%>/retRegisDt.do?method=retSt" onsubmit="return chkvalidate();">
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
</tr>
<tr>
<td width="20%"><font color="black" style="font-size:12"><b>Student Id:</b></font></td>
<td><input type="text" name="stud_id" value="" ></td>
 <td width="20%"><font color="black" style="font-size:12"><b>Roll No:</b></font></td>
<td width="30%"><input type="text" name="srnum" value=""></td>
</tr>

<tr><td colspan="4">
<table width="100%" align="center"><tr><td></td><td align="center"><input type="submit" value="Check"></td></tr></table>
</td></tr>
</table>
</form> 
<%if(!seo.getSname().equals("")){%>        
<form method="post" name="f2" action="<%=request.getContextPath()%>/updRegisDt.do?method=updSt" onsubmit="return chkvalidate1();">
<table width="100%" align="center" border="0" style="border-collapse:collapse"> 
    <tr><td colspan="4"><hr></td></tr>
<tr>
<td width="20%"><font color="darkred">*</font><font color="black" style="font-size:12"><b>Batch</b></font></td>
<td><%=seo.getBatch()%><input type="hidden" name="batch" value="<%=seo.getBatch()%>"></td>
<td width="20%"><font color="black" style="font-size:12"><b>Roll No:</b></font></td>
<td width="30%"><%=seo.getSrnum()%><input type="hidden" name="srnum" value="<%=seo.getSrnum()%>"></td>
</tr>
<tr>
<td width="20%"><font color="black" style="font-size:12"><b>Student Id:</b></font></td>
<td><%=seo.getStud_id()%><input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>"></td>
 <td width="20%"><font style="font-size:12" color="black"><b>Programme:</b></font></td>
    <td align="left" style="padding-left: 3px;">
     <select name="degree" style="width:173px;">
    
<%if(!seo.getDegree().equals("")){%>    
<option value="<%=seo.getDegree()%>"><%=seo.getDegree()%></option>   
<%}else{%>
<option value="">Select</option> 
<%}if(degreelist.size()!=0)
{
    for(int i=0;i<degreelist.size();i++)
    {
     jb=(JavaBean)degreelist.get(i);
     if(!seo.getDegree().equals(jb.getDegree())){
%>  
<option value="<%=jb.getDegree()%>"><%=jb.getDegree()%></option>
<%}
    }}%>
</select>       
        </td>
</tr>
<tr><td width="20%"><font color="darkred">*</font><font style="font-size:12" color="black"><b>Student Name:</b></font></td>
<td colspan="3"><input type="text" name="sname" value="<%=seo.getSname()%>" size="40"><font color="darkred" size="2">Enter full name</font></td></tr>

<tr><td width="20%"><font style="font-size:12" color="black"><b>Father's Name:</b></font></td>
<td width="30%"><input type="text" name="fname" value="<%=seo.getFname()%>"></td>
<td width="20%"><font style="font-size:12" color="black"><b>Father's Occupation:</b></font></td>
<td width="30%"><input type="text" name="foccup" value="<%=seo.getFprof()%>"></td></tr>


<tr><td width="20%"><font style="font-size:12" color="black"><b>Gender:</b></font></td>
<td width="30%" style="padding-left: 3px;"><select name="gender" style="width:173px;">
        <%if(!seo.getGender().equals("")){%>
<option value="<%=seo.getGender()%>"><%=seo.getGender()%></option>
<%}if(!seo.getGender().equals("MALE")){%>
<option value="MALE">MALE</option>
<%}if(!seo.getGender().equals("FEMALE")){%>
<option value="FEMALE">FEMALE</option>
<%}%>
</select></td>

</tr>
<tr><td><font style="font-size:12" color="black"><b>Category:</b></font></td>
<td colspan="3"><table><tr>
<td><input type="radio" name="category" value="GENERAL" <%if(seo.getCategory().equals("GENERAL")){%>checked<%}%>>
    <font style="font-size:12" color="white"><b>GENERAL</td>
<td><input type="radio" name="category" value="SC" <%if(seo.getCategory().equals("SC")){%>checked<%}%>>
    <font style="font-size:12" color="white"><b>SC</td>
<td><input type="radio" name="category" value="ST" <%if(seo.getCategory().equals("ST")){%>checked<%}%>>
    <font style="font-size:12" color="white"><b>ST</td>
<td><input type="radio" name="category" value="OBC" <%if(seo.getCategory().equals("OBC")){%>checked<%}%>>
    <font style="font-size:12" color="white"><b>OBC</td>
</tr></table></td></tr>
<tr>
    <td><font style="font-size:12" color="black"><b>Student Type:</b></font></td>
    <td><select name="stud_type">
             <option value="<%=seo.getStud_type()%>"><%=seo.getStud_type()%></option>
           <option value="Hosteller">Hosteller</option>
           <option value="Day Scholar">Day Scholar</option>
           <option value="Staff">Staff</option>
       </select></td>
    <td><font style="font-size:12" color="black"><b>New Beni:</b></font></td>
    <td><select name="new_beni">
            <option value="<%=seo.getNewBeni()%>"><%=seo.getNewBeni()%></option>
           <option value="NO">NO</option>
           <option value="Yes">YES</option>
        </select></td>
</tr>
<tr><td><font style="font-size:12" color="black"><b>ICAR:</b></font></td>
    <td><select name="icar">
            <option value="<%=seo.getIcar()%>"><%=seo.getIcar()%></option>
            <option value="NO">NO</option>
            <option value="YES">YES</option>
         </select></td>
   <td><font style="font-size:12" color="black"><b>Gate:</b></font></td>
    <td><select name="gate">
            <option value="<%=seo.getGate()%>"><%=seo.getGate()%></option>
            <option value="NO">NO</option>
            <option value="YES">YES</option>
         </select></td>      
</tr>
<tr><td colspan="4"><hr></td></tr>
<input type="hidden" name="rid" value="<%=seo.getRwid()%>">
<tr><td colspan="4">
<table width="100%" align="center"><tr><td></td><td align="center"><input type="submit" value="Update"/></td></tr></table>
</td></tr>
</table>
</form> 
<%}%>
</td></tr></table>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>


