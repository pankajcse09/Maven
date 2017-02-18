<%-- 
    Document   : AllRegisteredStud
    Created on : Aug 29, 2014, 10:47:01 AM
    Author     : kapil
--%>

<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>
<%@page import="java.util.*,java.text.*"%>
<!DOCTYPE html>
 <%
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);  
    int Eyear=Syear+1;
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);      


ArrayList arr1=null;
if(request.getAttribute("arr")!=null){      
arr1=(ArrayList)request.getAttribute("arr");
}
SchoolEO seo=new SchoolEO();
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
%> 
<%String sr=request.getParameter("batch");
  String dg=request.getParameter("degree");

int k=0;
       if(sr==null)
       { sr="";}
       if(dg==null)
       { dg="";}
%>
 
 <%
    ArrayList DegreeList=new ArrayList();
    
          DataObj fun=new DataObj();
          DegreeList=(ArrayList)fun.getDegree();
           JavaBean jbb=new JavaBean();
           JavaBean jbb1=new JavaBean();
        %>

<html>
    <head>
     <title>College Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
 <script language="javascript">    
     function retBranch(){
         document.ent.method="POST";
document.ent.action="<%=request.getContextPath()%>/ttsd.do";
document.ent.submit();
}
     
function validate(){
    if(document.ent.degree.value==""){
alert("Select Degree");
document.ent.degree.focus();
return false;
}
if(document.ent.batch.value==""){
alert("Select Batch");
document.ent.batch.focus();
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Reports/Display Fee Headwise</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left"  valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table width="95%">
                <tr><td>
<table style="padding-left: 310px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>List Of Registered Students</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 50px" width="100%">
   

<table cellpadding="0" cellspacing="0" width="100%"><tr><td valign="top">  
<form  method="post" name="ent" action="<%=request.getContextPath()%>/listofstud3.do" onsubmit="return validate()">
<table align="center">
<%if(request.getAttribute("sub")!=null){
out.println("<font color='red'><b>"+request.getAttribute("sub")+"</b></font>");
}%>  
<tr><td colspan="3"><font color="red" size="2">Select Following Details:</font></td></tr>
<tr>
    <td><font color="white"><b>Program:
            <select name="degree">
<%if(!dg.equals("")){%>   
<option value="<%=dg%>"><%=dg%></option>
<%}%>
<% if(!dg.equals("ALL")){%>
<option value="ALL">ALL</option>
<%}%> 
<%if(DegreeList.size()!=0)
{
    for(int i=0;i<DegreeList.size();i++)
    {
     jbb=(JavaBean)DegreeList.get(i);
     if(!dg.equals(jbb.getDegree())){
%>  
<option value="<%=jbb.getDegree()%>"><%=jbb.getDegree()%></option>
<%}
    }}%>
            </select></td>
            
    <td>
<font color="white"><b>Session:<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
                      
</td>
<td>
    <!--<font color="white"><b>Year:<select name="year">  
            <option value="">select one</option>
            <option value="1">1st Year</option>
            <option value="2">2nd Year</option>
            <option value="3">3rd Year</option>
            <option value="4">4th Year</option>
        </select>-->
            <input type="submit" name="ret" value="Show">
            </td>
</tr>
</table>
</form>
<hr>
<form name="formfine">    
    <table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                    <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
<table align="center">
<%if(request.getAttribute("msg")!=null){%>    
<tr><td><font style="font-size:12" color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr> 
<%}%>   
<tr><td><font style="font-size:14px" color="black"><b>Registered Student List of Degree <span style="color:darkblue;"><%=dg%></span>
            , Session  <span style="color:darkblue;"><%=seo.getSession()%></span>
            </b></font>
    </td></tr>
</table>
<table width="100%" align="center" border="1" bordercolor="blue" style="border-collapse:collapse" bgcolor="#FFFFCC"> 
<tr> 
<td align="center" bgcolor=""><font color="darkblue"><b>SR.NO.</b></font></td>
<td align="center" bgcolor=""><font color="darkblue"><b>Session Semester</b></font></td>
<td align="" bgcolor=""><font color="darkblue"><b>Batch</b></font></td>
<td align="" bgcolor=""><font color="darkblue"><b>ROLL NO.</b></font></td>
<td align="" bgcolor=""><font color="darkblue"><b>Student Id</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Student Name</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Father Name</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Program</b></font></td>
<!--<td bgcolor=""><font color="darkblue"><b>Branch</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Semester</b></font></td>
<td bgcolor="">&nbsp;</td>-->
</tr>    
<% 
try{
 for(int i=0;i<arr1.size();i++){ 
 seo=(SchoolEO)arr1.get(i);
%>
<tr>
<td align="center"><%=++k%></td>
<td align="center"><%=seo.getSession_sem()%></td>
<td align=""><%=seo.getBatch()%></td>
<td align="">
<% if(seo.getSrnum()!=null&&!seo.getSrnum().equals("")){%>
<%=seo.getSrnum()%>
<%} else{%>
NA
<%}%>
</td>
<% if(seo.getStud_id()!=null&&!seo.getStud_id().equals("")){%>
<td><%=seo.getStud_id()%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td><%=seo.getSname()%></td>
<td><%=seo.getFname()%></td>
<td><%=seo.getDegree()%></td>
<!--<td><%=seo.getBranch()%></td>
<td><%=seo.getClasses()%></td>
<td><a href="<%=request.getContextPath()%>/srecrd.do?disp=disp&srnum=<%=seo.getSrnum()%>&session=<%=sr%>&degree=<%=seo.getDegree()%>
&sem=<%=seo.getClasses()%>&enr=<%=seo.getEnrolNo()%>"><font color="darkblue"><b>Details</b></font></td>-->
    </tr>
<%}%>
</table>
</div>
</form>
<%}catch(Exception e){}%>
</td></tr></table> 
   
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>