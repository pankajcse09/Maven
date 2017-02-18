<%-- 
    Document   : StudentID
    Created on : Jul 9, 2013, 1:22:53 AM
    Author     : kapil
--%>

<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
MyMeth mm=new MyMeth();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}

//double tt=0.0;
ArrayList ar=new ArrayList();
ArrayList ar1=new ArrayList();
ArrayList ar2=new ArrayList();
ArrayList ar3=new ArrayList();
ArrayList ar4=new ArrayList();
String icar="";
String gate="";
if(request.getParameter("icar")!=null)
               {
    icar=(String)request.getParameter("icar");
}
if(request.getParameter("gate")!=null)
               {
    gate=(String)request.getParameter("gate");
}
ArrayList al=new ArrayList();
  SchoolEO seo1=new SchoolEO();
    if(request.getAttribute("list")!=null)
   {
   al=(ArrayList)request.getAttribute("list");
    }

try{
%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="<%=request.getContextPath()%>/JSF/jquery.min.js"></script>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>Student ID</title>
<script language="javascript">
 function genFeeScroll(){
 var ssn=document.f3.session.value;
 var ssem=document.f3.session_sem.value;
 var rno=document.f3.srnum.value;
var deg=document.f3.degree.value;
var stdid=document.f3.stud_id.value;
window.open('<%=request.getContextPath()%>/gen_FeeScroll.do?method=genFeeScrol&rn='+rno+'&stud_id='+stdid+'&ssn='+ssn+'&ssem='+ssem+'&degree='+deg,'trace','width=1260,height=650,toolbar=no,scrollbars=yes,resizable=no');
 }
 function focusField(a){
 document.f1.elements[a].focus();
 }
function validate()
{
   var session_sem=document.f1.elements["session_sem"];
        if(session_sem.value=="")
        {
            alert("Please Session Semester");
            session_sem.focus();
            return false;
        }
        if(document.f1.elements["regist_no"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["regist_no"].focus();
            return false;
        }
         if(document.f1.elements["stud_id"].value=="")
        {
            alert("Please Enter Studen Id");
           document.f1.elements["stud_id"].focus();
            return false;
        }
        return true;
}
function validate1()
{
         if(document.f2.elements["stud_id"].value=="")
        {
            alert("Please Enter Studen Id");
           document.f2.elements["stud_id"].focus();
            return false;
        }
        return true;
}
</script>
<script language="javascript">
    function checkId(a){
        document.getElementById("show").innerHTML="Please wait!!!";
        var button=document.getElementById("submitShow");
        button.style.display="none";
        var form=document.getElementById("studId");
        form.action="";
        form.method="";
        $.get("<%=request.getContextPath()%>/students/studentIdCheck.jsp?stud_id="+a.value, function(data){
            document.getElementById("show").innerHTML="";
            if(data==0){
                form.action="<%=request.getContextPath()%>/enterStudentId.do";
                form.method="post";
                button.style.display="block";
                return false;
            }
            else if(data==-1){
                alert("error");
                return false;
            }
            else{
                var r = confirm(data);
                if (r == true) {
                    form.action="<%=request.getContextPath()%>/enterStudentId.do";
                    form.method="post";
                    form.submit();
                } else {
                    return false;
                }
            }
        });
    }
</script>
</head>
<body onload="focusField('regist_no');" bgcolor="#999933">
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
         
         <% 
         double regis_fee=0.0;
         
         String message="";
         if(request.getAttribute("message")!=null)
                         {
             message=(String)request.getAttribute("message");
         }
         
         Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int month = cal.get(Calendar.MONTH);

        String[] ssn_sm=new String[2];
        if(month>=0&&month<4){ 
            ssn_sm[0]="II";
            ssn_sm[1]="I";
        }
        if(month>=4&&month<=11){ 
            ssn_sm[0]="I";
            ssn_sm[1]="II";
        }
         %>
       
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
          <table width="70%" align="center" border="0" cellpadding="5"><tr><td align="center"><font  color="darkblue" size="3"><b><u>Check Student Detail</u></b></font></td></tr>
                 </table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/checkStudentDetail.do?method=checkStudentDetail" onsubmit="return validate()">
<table width="40%" align="center">
<tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
    <select name="session_sem" id="session_sem">
                <%for(int i=0;i<ssn_sm.length;i++){%>   
                    <option value="<%=ssn_sm[i]%>"><%=ssn_sm[i]%></option>
                <%}%>
                <option value="">Session Semester</option>
             </select>
    </td>


<td valign="top"><font style="font-size:12;color:white"><b>Roll No</b></font><br>
<input type="text" name="regist_no" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="check">
</td>
</tr>    
</table>  
</form>
<hr color="maroon"> 
<%if(request.getAttribute("msg")!=null){%>  
<table width="50%" align="center"><tr><td colspan="2"><font color="darkred"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>
<%}%>

<%
if(al.size()!=0)
       {
    seo1=(SchoolEO)al.get(0);
    ar=seo1.getDataArray();
    ar1=seo1.getDataArray1();
    ar2=seo1.getDataArray2();
    ar3=seo1.getDataArray3();
    ar4=seo1.getDataArray4();
    
%>

<%if(request.getAttribute("edit")!=null){%>
<form name="f2" id="studId" onsubmit="return validate1()">
    <table width="70%" align="center" border="0" cellpadding="5">
        <tr><td align="center">
                <font  color="darkblue" size="3"><b><u>Enter Student Id</u></b></font></td></tr>
        <tr><td align="center">
                <font  color="darkred" size="3" id="show"></font></td></tr>
                 </table>
     <table width="100%" valign="middle" border="0" height="100">
         <tr><td valign="top" align="center">
                 <input type="hidden" name="session" value="<%=seo1.getSession()%>">
                 <input type="hidden" name="session_sem" value="<%=seo1.getSession_sem()%>">
                 <input type="hidden" name="regist_no" value="<%=seo1.getSrnum()%>">
                 <font style="font-size:12;color:white"><b>Student Id</b></font><br>
                 <input type="text" name="stud_id" value="<%=seo1.getStud_id()%>" size="10" onblur="return checkId(this)">
             <span id="submitShow" style="display:none"><input type="submit" value="Submit"></span>
</tr>    
                   </table>
</form>  
<%}else{%>
<form name="f3">
    <input type="hidden" name="session" value="<%=seo1.getSession()%>">
    <input type="hidden" name="session_sem" value="<%=seo1.getSession_sem()%>">
    <input type="hidden" name="srnum" value="<%=seo1.getSrnum()%>">
    <input type="hidden" name="degree" value="<%=seo1.getDegree()%>">
    <input type="hidden" name="stud_id" value="<%=seo1.getStud_id()%>">
</form>
<table width="100%" align="center"><tr>
<td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
<td width="50%" align="right"><a href="#" onclick="genFeeScroll()">Generate Fee Scroll</a></td>
</tr></table>
<%}%>
<div id="printit">
    <table width="100%" valign="top" border="0">
                         <tr><td valign="top">
                                 <img src="<%=request.getContextPath()%>/image/pant_logo.png" width="90" height="90"> 
                             </td>
                             <td valign="top" style="padding-top: 5px"><table>
                         <tr><td align="center"><font size="4"><b>Govind Ballabh Pant University of Agriculture & Technology </b></font></td></tr>
                         <tr><td align="center"><font size="4"><b>Pantnagar- 263145(Uttarakhand) <b></font></td></tr>
                                         </table>
                             <table style="padding-left: 120px;padding-top: 5px">
                         <tr><td align="center"><font size="3">OFFICE OF THE COMPTROLLER</font></td></tr>
                         <tr><td align="center"><font size="3">STATEMENT OF ACCOUNT </font></td></tr>
                     </table>
                             </td></tr>
                     </table>
<table width="80%" align="center" cellspacing="5" cellpadding="5" style="padding-top:20px">
    <tr><td><font style="font-size: 16px"><b>Course Name:</b></font>&nbsp;&nbsp;<font style="font-size: 15px"><b><%=seo1.getDegree()%></b></td></tr>
    <tr>
        <td width="100%">
            <table width="80%">
                <tr><td><b>Student Rollno:</b>&nbsp;<%=seo1.getSrnum()%></td><input type="hidden" name="srnum" value="<%=seo1.getSrnum()%>">
                    <td><b>Student Id:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seo1.getStud_id()%></td></tr><input type="hidden" name="stud_id" value="<%=seo1.getStud_id()%>">
                <tr><td><b>Student Name:&nbsp;&nbsp;</b><%=seo1.getSname()%></td><td><b>Father Name:&nbsp;&nbsp;</b><%=seo1.getFname()%></td></tr>
               <tr><td><b>Category:&nbsp;&nbsp;&nbsp;</b><%=seo1.getCategory()%></td></tr><input type="hidden" name="degree" value="<%=seo1.getDegree()%>">
                <input type="hidden" name="session" value="<%=seo1.getSession()%>">
            </table>
        
        </td></tr></table>
               <% for(int i=0;i<ar.size();i++)
          {
      if(ar4.get(i).toString().equals("counselling"))
             {
%>
               <table width="80%" align="center">
                   <tr><td><font style="font-size: 14px"><b>Advance:</b></font></td></tr>
                   <tr>
                       <td>
                           <table border="1" style="border-collapse: collapse" width="80%">
                               <tr><td><b>DD No</b></td><td><b>DD Date</b></td><td><b>Bank</b></td><td><b>Amount</b></td></tr>
                               
      
                            <tr>
                                   <td><%=ar.get(i)%></td>
                                   <td><%=ar1.get(i)%></td>
                                   <td><%=ar2.get(i)%></td>
                                   <td><%=ar3.get(i)%></td>
                               </tr>
                              
                           </table>
                       </td>
                   </tr>
               </table>
                                <%}}%>
                  <table width="80%" align="center">
                   <tr><td><font style="font-size: 14px"><b>Total Fee:</b></font></td></tr>
                   <tr>
                       <td>
                           <table border="1" style="border-collapse: collapse" width="80%">
                               <tr><td><b>DD No</b></td><td><b>DD Date</b></td><td><b>Bank</b></td><td><b>Amount</b></td></tr>
                             
      <% for(int i=0;i<ar.size();i++)
          {
      if(ar4.get(i).toString().equals("addmission fee"))
             {
%>
                            <tr>
                                   <td><%=ar.get(i)%></td>
                                   <td><%=ar1.get(i)%></td>
                                   <td><%=ar2.get(i)%></td>
                                   <td><%=ar3.get(i)%></td>
                               </tr>
                               <%}}%>
                           </table>
                       </td>
                   </tr>
               </table>         
                           
               </div>
<%}%>
    </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>