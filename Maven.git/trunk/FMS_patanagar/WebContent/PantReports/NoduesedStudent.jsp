<%-- 
    Document   : NoduesedStudent
    Created on : Jul 13, 2014, 11:38:28 AM
    Author     : kapil
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="Beans.JavaBean"%>
<%@page import="ActionClass.DataObj"%>
<%@page import="EO.ReportsEO"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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

ArrayList ar=new ArrayList();    
if(request.getAttribute("list")!=null){      
ar=(ArrayList)request.getAttribute("list");
}
ReportsEO reo=new ReportsEO();
%> 
<%String sr=request.getParameter("session");
       String dg=request.getParameter("degree");
       String sessn_sm="";
       if(request.getParameter("session_sem")!=null)
         {
           sessn_sm=request.getParameter("session_sem");
       }
       
   int k=0;
       if(sr==null)
       { sr="";}
       if(dg==null)
       { dg="";}
        
 ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");       
 %>
 
 <%
 BigDecimal bd=new BigDecimal(0.00);
    ArrayList DegreeList=new ArrayList();
    
          DataObj fun=new DataObj();
          DegreeList=(ArrayList)fun.getDegree();
           JavaBean jbb=new JavaBean();
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
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
 <script language="javascript">    
function validate(){
    if(document.ent.degree.value==""){
alert("Select Degree");
document.ent.degree.focus();
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
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 310px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Noduesed Students</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 50px">
   

<table cellpadding="0" cellspacing="0" width="800"><tr><td valign="top">  
<form  method="post" name="ent" action="<%=request.getContextPath()%>/NoduesedStudent.do?method=Noduesed_Student" onsubmit="return validate()">
<table align="center">
<tr><td colspan="3"><font color="red" size="2">Select Following Details:</font></td></tr>
<tr>
    <td><font color="white"><b>Program:
            <select name="degree">
<%if(!dg.equals("")){%>    
<option value="<%=dg%>"><%=dg%></option>   
<%}%>
<option value="ALL">ALL</option> 
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
<%if(!sr.equals("")){%>
<option value="<%=sr%>"><%=sr%></option>
<%}if(!sr.equals(prev)){%>
<option value="<%=prev%>"><%=prev%></option>
<%}if(!sr.equals(next)){%>
<option value="<%=next%>"><%=next%></option>
<%}%>
</select>   
<select name="session_sem">
<%if(!reo.getSession_sem().equals("")){%>   
<option value="<%=reo.getSession_sem()%>"><%=reo.getSession_sem()%></option>
<%}%> 
<%for(int i=0;i<ar4.size();i++){
if(ar4.get(i).equals(reo.getSession_sem())){continue;}
%>    
<option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>    
<%}%>
</select></td></tr>
<tr><td colspan="2">
        <table>
            <tr><td>
        <font color="white"><b>Reason:</b></font></td>
                <td> <input type="radio" name="reason" value="Degree Complete">Degree Complete
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="radio" name="reason" value="Before Registration">Before Registration
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="radio" name="reason" value="After Registration">After Registration</td>
            </tr>
<tr><td>
        <font color="white"><b>Status:</b></font></td>
    <td><input type="radio" name="status" value="receive">receive
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td><input type="radio" name="status" value="refund">refund</td>
</tr>
        </table></td></tr>
<tr><td><input type="submit" value="Display"></td></tr>
</table>
</form>
<hr>
<form name="formfine">    
    <table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
<table align="center">
<%if(request.getAttribute("msg")!=null){%>    
<tr><td><font style="font-size:12" color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr> 
<%}%>   
<tr><td><font style="font-size:14px" color="black"><b>Noduesed Student List of <span style="color:darkblue;"><%=dg%>, <%=sr%>, <%=sessn_sm%>
                </span>
            </b></font>
    </td></tr>
</table>
<table width="100%" align="center" border="1" bordercolor="blue" style="border-collapse:collapse" bgcolor="#FFFFCC"> 
<tr> 
<td align="center" bgcolor=""><font color="darkblue"><b>SR.NO.</b></font></td>
<td align="" bgcolor=""><font color="darkblue"><b>Batch</b></font></td>
<td align="" bgcolor=""><font color="darkblue"><b>Student Id</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Student Name</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Father Name</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Programme</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Reason</b></font></td>
<td bgcolor=""><font color="darkblue"><b>Status</b></font></td>
<td bgcolor="" align="right"><font color="darkblue"><b>Amount</b></font></td>
</tr>    
<%
try{
    double tt=0;
 for(int i=0;i<ar.size();i++){ 
 reo=(ReportsEO)ar.get(i);
 tt=tt+reo.getAmount();
%>
<tr>
<td align="center"><%=++k%></td>
<td align=""><%=reo.getBatch()%></td>
<% if(reo.getStud_id()!=null&&!reo.getStud_id().equals("")){%>
<td><%=reo.getStud_id()%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td><%=reo.getSname()%></td>
<td><%=reo.getFname()%></td>
<td><%=reo.getDegree()%></td>
<td><%=reo.getReason()%></td>
<td><%=reo.getStatus()%></td>
<td align="right"><%=reo.getAmount()%></td>
</tr>
<%}%>
<%bd=new BigDecimal(tt);
        bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        %>
<tr><td colspan="8" align="right"><b>Total</b></td><td align="right"><%=tt%></td></tr>
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
