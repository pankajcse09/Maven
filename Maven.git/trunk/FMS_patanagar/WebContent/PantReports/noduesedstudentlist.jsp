<%-- 
    Document   : noducedstudentlist
    Created on : Jun 11, 2014, 11:50:26 AM
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

ArrayList degreelist=new ArrayList();
  JavaBean de=new JavaBean();
    MyMeth fun=new MyMeth();
     degreelist=(ArrayList)fun.Degree_list();
  
  ArrayList list=new ArrayList();
  if(request.getAttribute("list")!=null)
   {
   list=(ArrayList)request.getAttribute("list");
    }
  
 SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String ddate="";
try{
    ddate=(String)sde.format(dt1);
    DecimalFormat df = new DecimalFormat("0.00");
%>
<html>
    <head>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>Noduesed Student</title>
<script language="javascript">
    function validate()
    {
        if(document.form[0].degree.value=""){
            alert("Please select degree");
            document.form[0].degree.focus();
            return false;
        }
        return true;
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
          
         %>
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
            <td valign="top" align="left" > 
<form name="f1" method="post" action="<%=request.getContextPath()%>/noduesedstudentlist.do?method=noduesedstudent" onsubmit="return validate()">
    <table width="30%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Noduesed Student List</font></td></tr></table>
<table width="30%" align="center">
 <tr>
     <td valign="top"><font style="font-size:12;color:white">Session</font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select>
 <select name="session_sem">
<%if(!seo.getSession_sem().equals("")){%>   
<option value="<%=seo.getSession_sem()%>"><%=seo.getSession_sem()%></option>
<%}%>
<option value="I">I</option>
<option value="II">II</option>
</select>
     </td>
     
<td valign="top"><font style="font-size:12;color:white"><b>Degree</b></font><br>
<select name="degree">
<%if(seo.getDegree().equals("")){%>  
    <option value="select one">select one</option>
    <%}%>
    <%if(!seo.getDegree().equals("")){%>    
<option value="<%=seo.getDegree()%>"><%=seo.getDegree()%></option> 
<%}%>
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(seo.getDegree())){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
</select></td>
<td valign="bottom"><input type="submit" value="Go"></td></tr>    
</table>  
</form>
<hr color="maroon">


<table align="left" width="100%" align="center">
    <tr><td align="center"><b><u>List Of Noduesed Student for <i><%=seo.getDegree()%> (<%=seo.getSession()%> -<%=seo.getSession_sem()%>)</i></u></b></td></tr>
</table>

<% if(list.size()!=0)
{%>
<table border="1" style="border-collapse: collapse" width="60%" align="center">
    <tr><td><b>Sr. no</b></td><td><b>Student Id</b></td><td><b>Student Name</b></td><td><b>Submitted Amount</b></td><td><b>Late Fine</b></td></tr>
    <%for(int i=0;i<list.size();i++)
        {
           seo=(SchoolEO)list.get(i); 
         %>
    <tr><td>
           <%=i+1%>. 
         </td>
        <td><%=seo.getStud_id()%></td>
        <td><%=seo.getSname()%></td>
        <td align="right"><%=seo.getFeeTotal()%></td>
        <td align="right"><%=seo.getFine()%></td>
     </tr>
      <%}%>
</table>
<%}%>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
//out.println("Exc: "+e.getMessage());
}%>
