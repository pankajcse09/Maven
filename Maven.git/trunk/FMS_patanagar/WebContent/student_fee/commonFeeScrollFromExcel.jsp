<%-- 
    Document   : commonFeeScrollFromExcel
    Created on : Jul 16, 2014, 12:27:21 PM
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
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
  
  String pdf="";
  
  if(request.getAttribute("pdf")!=null)
   {
   pdf=(String)request.getAttribute("pdf");
    }
  
  ArrayList scrollList=new ArrayList();
  if(request.getAttribute("scrollList")!=null)
   {
   scrollList=(ArrayList)request.getAttribute("scrollList");
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
<title>Fee Scroll</title>
<script language="javascript">
    function validate()
    {
        if(document.f1.degree.value==""){
            alert("Please select degree");
            document.f1.degree.focus();
            return false;
        }
        
        if(document.f1.uploads1.value==""){
            alert("Please choose excel sheet for the programme");
            document.f1.uploads1.focus();
            return false;
        }
        return true;
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/genCmn_FeeScrollExcel.do?method=gen_CmnFeeScrollUsingExcel" enctype="multipart/form-data" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top">
                <font color="darkred" size="3">Generate Fee Scroll</font></td></tr></table>
<table width="35%" align="center">
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
</select></td>
  <!-- <td valign="top"><font style="font-size:12;color:white"><b>Batch</b></font><br>
<select name="batch">
    <%if(seo.getBatch().equals("")){%>  
    <option value="">select one</option>
    <%}%>
<%if(!seo.getBatch().equals("")){%>   
<option value="<%=seo.getBatch()%>"><%=seo.getBatch()%></option>
<%}for(int i=7;i>=0;i--)
{
    if(!seo.getBatch().equals(Syear-i)){
        %>
<option value="<%=Syear-i%>"><%=Syear-i%></option>
<%}}%>
</select></td>-->
<td valign="top"><font style="font-size:12;color:white"><b>Degree</b></font><br>
<select name="degree">
<%if(seo.getDegree().equals("")){%>  
    <option value="">select one</option>
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
 <td><font style="font-size:12;color:white"><b>Upload Excel</b></font> <input type="file" name="uploads1"></td></tr>
 <tr><td valign="bottom" colspan="3"><input type="submit" name="submit" value="Generate"></td></tr>    
</table>  
</form>
<hr color="maroon">
<% if(request.getAttribute("err")!=null){%>
<table align="left" width="100%">
    <tr><td><span style="color: yellow"><b><%=request.getAttribute("err")%></b></span></td></tr>
</table>
<%}%>
<% if(request.getAttribute("msg")!=null){%>
<table align="left" width="100%">
    <tr><td><span style="color: yellow"><b><%=request.getAttribute("msg")%></b></span></td></tr>
    
</table>
<%}%>
<% if(request.getAttribute("msg1")!=null){%>
<form name="f2" action="<%=request.getContextPath()%>/genCmn_FeeScrollExcel.do?method=gen_CmnFeeScrollUsingExcel" method="post">
<table align="left" width="100%">
    <tr><td><span style="color: yellow"><b><%=request.getAttribute("msg1")%></b></span></td></tr>
    <input type="hidden" name="session" value="<%=seo.getSession()%>">
    <input type="hidden" name="degree" value="<%=seo.getDegree()%>">
    <tr><td><input type="submit" name="click" value="Click"></td></tr>
</table>
</form>
<%}%>

<% if(request.getAttribute("generated")!=null){%>
<table align="left" width="100%">
    <tr><td colspan="3"><span style="color: yellow"><b><%=request.getAttribute("generated")%></b></span></td></tr>
    <tr><td><table><tr>
        <td width="80">
            <a href="<%=request.getContextPath()%>/viewfile?fl=<%=pdf%>" target="_blank">
                <span title="<%=pdf%>"><img src="<%=request.getContextPath()%>/image/Pdf_ic.png" width="25">View</span>
            </a>
        </td>
        <td width="80" valign="bottom"><a href="<%=request.getContextPath()%>/ScrollInPDF/<%=pdf%>">download</a></td>
        <td width="80" valign="bottom"></td>
                </tr></table></td>
    </tr>
</table>
<%}%>

<% if(scrollList.size()!=0)
{%>
<table align="left">
    <tr><td height="20" colspan="3"></td></tr>
    <tr><td colspan="3"><b><u>List Of Rest Fee Scroll Files <i><%=seo.getSession()%> -<%=seo.getSemester()%></i></u></b></td></tr>
    <%for(int i=0;i<scrollList.size();i++)
        {
           seo=(SchoolEO)scrollList.get(i); 
         %>
    <tr><td>
           <%=i+1%>. Fee Scroll for <%=seo.getDegree()%> ( <%=seo.getBatch()%> batch )
           <a href="<%=request.getContextPath()%>/viewfile?fl=<%=seo.getFilename()%>" target="_blank">
               <span title="<%=pdf%>"><img src="<%=request.getContextPath()%>/image/Pdf_ic.png" width="25">View</span>
           </a>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
        <td valign="bottom"><a href="<%=request.getContextPath()%>/ScrollInPDF/<%=seo.getFilename()%>">download</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="bottom"><a href="<%=request.getContextPath()%>/delPdfScroll.do?method=delScroll&id=<%=seo.getRowid()%>&session=<%=request.getParameter("session")%>">delete</a></td>
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

