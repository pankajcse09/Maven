<%-- 
    Document   : nuduesed_list_to
    Created on : Dec 18, 2014, 4:33:47 PM
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

SchoolEO seo=new SchoolEO();  
String filename="";
if(request.getAttribute("filename")!=null){
    filename=(String)request.getAttribute("filename");
}


  
  ArrayList list=new ArrayList();
  if(request.getAttribute("list")!=null)
   {
   list=(ArrayList)request.getAttribute("list");
    }
  
 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
try{

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
<tr bgcolor="#FFFFCC"><td align="center" width="100%" style="padding-top:0px" height="100">
        <table border="0" bgcolor="#FFFFCC" width="100%" style="padding-left: 130px">       
<tr><td align="center"><font color="#99990" style="font-family:Comic Sans MS; font-weight: bold" size="5">G. B. Pant University of Agriculture & Technology, Pantnagar, Uttarakhand</font></td></tr> 
        </table>
    </td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr>
<td valign="top" align="left" > 

    <table width="30%" align="center" valign="top" style="padding-top: 20px;"><tr>
            <td colspan="2" align="center" valign="top">
                <font color="darkred" size="3"><b>Today's Nodues Student List</b></font></td></tr></table>
<hr color="maroon">

<% if(list.size()!=0)
{%>
<table border="1" style="border-collapse: collapse" width="60%" align="center">
    <table border="1" style="border-collapse: collapse" width="80%" align="center">
    <tr><td><b>Sr. no</b></td>
        <td align="center"><b>Student Name</b></td>
        <td align="center"><b>Student Id</b></td><td><b>Session</b></td>
        <td align="center"><b>Submitted Amount</b></td><td align="center"><b>Nodues Date</b></td>
    <td align="center"><b>Programme</b></td>
    <td align="center"><b>Transaction Id</b></td>
    <td align="center"><b>Contact</b></td>
    </tr>
    <%for(int i=0;i<list.size();i++)
        {
           seo=(SchoolEO)list.get(i); 
         %>
    <tr><td>
           <%=i+1%>
         </td>
         <td><%=seo.getSname()%></td>
        <td><%=seo.getStud_id()%></td>
        <td><%=seo.getSession()+"-"+seo.getSession_sem()%></td>
        <td align="right"><%=df.format(seo.getFeeTotal())%></td>
        <td align="left"><%=sdf.format(seo.getDate())%> </td>
         <td align="left"><%=seo.getDegree()%> </td>
         <td align="left"><%=seo.getTransaction_id()%>
             <%if("".equals(seo.getTransaction_id()))out.print("NA");%>
         </td>
         <td align="left"><%=seo.getMobile()%> 
             <%if("".equals(seo.getMobile()))out.print("NA");%>
         </td>
     </tr>
      <%}%>
</table>
     <table width="60%" align="center">
          <tr><td align="right"><a href="<%=request.getContextPath()%>/noduesed_excel/<%=filename%>"><%=filename%></a></td></tr>
      </table>
<%}
       else{
    %>
    <table width="30%" align="center" valign="top" style="padding-top: 20px;padding-bottom: 20px"><tr>
            <td colspan="2" align="center" valign="top">
    <b>No student found for today. </b>
            </td></tr></table>
    <%}%>
           </td></tr>      
</table></td></tr>
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
//out.println("Exc: "+e.getMessage());
}%>
