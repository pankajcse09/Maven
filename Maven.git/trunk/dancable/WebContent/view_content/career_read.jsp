 <%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.Im_ResumeUtilty"%>
<%@page import="Feedback.feedbean"%>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/style.css">
     <title>Home</title>
<base target="_parent">
<meta name="Microsoft Border" content="tlb, default">
</head>
<body bgcolor="">
    <%!
Im_ResumeUtilty rp=new Im_ResumeUtilty();
ArrayList detail= new ArrayList();
feedbean dd=new feedbean();
%>
<%
detail=(ArrayList)rp.view_career();
//out.println("detail"+detail);

%>
  <!--1--><TABLE borderColor=#000000 cellSpacing=0 cellPadding=0 width=200 align=center border="1">
        <TBODY>
        <TR><TD vAlign=top align=left height=230>
<!--2--><TABLE height=733 cellSpacing=0 cellPadding=0 width=876 align=center border="0" bordercolor="blue">
        <TBODY>
        <TR><TD vAlign=top align=left colSpan=2 height=165><%@include file="/header.jsp"%></TD></TR>
        <TR><TD vAlign=top align=left colSpan=2 height=28><%@include file="/menu_logout.jsp"%></TD></TR>
        <TR><TD vAlign=top align=left width="19%" height=467 bgcolor=""><%@include file="/Registration/links.jsp"%></TD>
 <!--text start from here-->   
<%String username= (String)session.getAttribute("loginid");%>
<td width="72%" align="left" valign="top">       
<table width="100%" border="0" cellpadding="0" cellspacing="5">
<tr><td align="right"><font color="maroon" size="4">Welcome&nbsp;</font><font color="darkblue" size="4">'<%=username%>'</font></td></tr>
<tr><td colspan="0" width="50%">
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
        <tr><td> 
    
        </td></tr>
       
        
        <tr>
     <td>
  <table border="1" width=100%>
       
  <%
if(!detail.isEmpty())
{
        
  %>
   <h3>List of FeedBack Detail...</h3>
  <tr>
  <td>Name</td>
    <td>EmailId:</td>
      <td>Contact no.</td>
        <td> Post Applied For</td>

<td>why do you join us</td>
<td>Detail</td>
    </tr> 
  <%
//out.println((ArrayList)request.getAttribute("customer"));

for(int i=0;i<detail.size();i++)
{
dd=(feedbean)detail.get(i);
//out.println("filename"+dd.getName());

  %>
  <tr>
<td><%=dd.getName()%></td><td><%=dd.getEmailid()%></td><td><%=dd.getContactno()%></td><td><%=dd.getAddress()%></td>
</td><td><%=dd.getMsg()%></td>
<%if(dd.getFilename().equals("")){%>
<td>No File  Attached </td>
 
  <%}else{%>
  <td><a href="Detail_career.do?para=<%=dd.getFilename()%>"><font color="blue">Details</font></a> </td>
 
  <%}%>
 </tr>
  
  <%
} 
    
}


%>
      
            
    </table> 
  
     </td>
        
        </tr>
    
   </table>
</tr>
</table></td>
  <!--text end from here-->  
 </tr>
        <TR>
          <TD vAlign=center align=middle bgColor=#b7b7b7 colSpan=2 height=37>
<%@include file="../footer.jsp"%>
          </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>