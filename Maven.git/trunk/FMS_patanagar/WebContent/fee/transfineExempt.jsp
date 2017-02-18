<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

<%
  String uid=""; 
  if(session.getAttribute("loginid")!=null){
  uid=(String)session.getAttribute("loginid");
  } 
%>
   <%
    response.setHeader("Cache-Control","no cache");  
    JavaBean jb=new JavaBean();   
    MyMeth mm=new MyMeth();
     int stssn=0;
     int endssn=0;
     String etype="";
     String clas="";
     ArrayList ar1=new ArrayList();     
     ar1=(ArrayList)mm.retriveAllClass();     
     if(request.getAttribute("jbean")!=null){
     jb=(JavaBean)request.getAttribute("jbean");
     stssn=jb.getFrom();
     endssn=jb.getTo();
     etype=jb.getExtype();
     clas=jb.getClas();
    }  
   %>

<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
<script language="javascript">
       
 function chkvalidate()
{
if(document.formfine.ate.value==""){
          alert("Enter the Amount to be Exempted ");
          document.formfine.ate.focus();
          return false;
          }
        
}

  function calfee()
               {
               var ate=document.formfine.ate.value;
               var due=document.formfine.due.value;
           
               var remain=(parseInt(due)-parseInt(ate));
               document.formfine.remaindue.value=parseInt(remain); 
               }
   </script>
    
    </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Exempt Due Amount</u></font></center></td></tr></table>
   
<form  method="post" action="<%=request.getContextPath()%>/tfnex.do?disp=disp">
<table cellpadding="0" cellspacing="0" width="100%" height=400><tr><td valign="top">  
<table>
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  

<tr><td>Scholars Number:<input type="text" name="srnum" size="15" value=""></td>
<input type="hidden" name="uid" size="15" value="<%=uid%>">
</td><td><input type="submit" value="Display"></td></tr> 
</table>
<hr>
</form>
<form name="formfine" action="<%=request.getContextPath()%>/tfnex.do?enter=enter" method="post" onsubmit="return chkvalidate()">
<table border="1" width="50%" align="center">
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 SchoolEO seo=null;
%>
<% if(request.getAttribute("arr")!=null)
 {%>           
<% for(int i=0;i<arr1.size();i++)
{ seo=(SchoolEO)arr1.get(i);
%>
<tr><td><font size="2"><b>Sr.Number:</b></font></td><td><%=seo.getSrnum()%></td></tr>
<tr><td><font size="2"><b>Student Name:</b></font></td><td><%=seo.getSname()%></td></tr>
<tr><td><font size="2"><b>Class:</b></font></td><td><%=seo.getClasses()%>
<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<b>Section:&nbsp;</b></font><%=seo.getSection()%></td></tr>
<tr><td><font size="2"><b>Route Area:</b></font></td><td><%=seo.getRoute()%></td></tr>
<tr><td><font size="2"><b>Buscode:</b></font></td><td><%=seo.getBuscode()%></td></tr>
<tr><td><font size="2"><b>Trip No.</b></font></td><td><%=seo.getTripnum()%></td></tr>
<tr><td><font size="2"><b>Due:</b></font></td><td><%=seo.getDue()%></td></tr>
<input type=hidden name="due" value="<%=seo.getDue()%>" onblur="calfee()">
<tr><td><font size="2"><b>Amount to exempt:</b></font></td><td><input type=text name="ate" value="" size="8" onblur="calfee()"></td></tr>
<tr><td><font size="2"><b>Due Remain:</b></font></td><td><input type=text name="remaindue" value="" size="8" onblur="calfee()"></td></tr>
<input type=hidden name="rowid" value="<%=seo.getRowid()%>" onblur="calfee()">  
<input type=hidden name="uid" value="<%=uid%>" onblur="calfee()"> 
<input type=hidden name="srnum1" value="<%=seo.getSrnum()%>" onblur="calfee()"> 
</table>
<table align="center"><tr> </td><td><input type="submit" value="Exempt Due"></td></tr></table>
<%
   } }%>
<%
  }catch(Exception e)
  {}%>
  </td></tr></table> 
</form>   
  </td></tr></table>
    
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>     
    
    </body>
</html>
