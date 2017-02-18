<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

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
   

<table cellpadding="0" cellspacing="0" width="100%" height=400 align="center"><tr><td valign="top">  
<tr><td height=40></td></tr>
<tr><td valign="top">
<table width="60%" align="center">
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td align="right"><a href="<%=request.getContextPath()%>/fee/schoolfineExempt.jsp"><font color="maroon"><b>Exempt School Due</b></font></a></td>
<td width=30></td>
<td><a href="<%=request.getContextPath()%>/fee/transfineExempt.jsp"><font color="maroon"><b>Exempt Transport Due</b></font></a></td>
</tr>
</table>  
</td></tr></table>

     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    </body>
</html>
