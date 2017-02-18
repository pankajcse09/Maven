<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.myapp.struts.examEO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
     <style type="text/css">
    .t{border-collapse:collapse}    
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>External Marks Report</title>
        <script language="javascript">
            function disp(a,b,c)
            {var stud=a;
            var session=b;
            var course=c;
            document.f1.method="POST";
document.f1.action="updateExternal?course="+b+"&stud="+a+"&session="+c;            
document.f1.submit();
            
            }
            
        </script>
    </head>
    <body>
<table width="80%" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%" align="center"><tr><td width="100%" valign="top" align="center"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330" align="center">
 <tr><td valign="top" height="5%"><jsp:include page="/CommonLinks.jsp"/></td></tr> 
 <tr><td valign="top" valign="top" align="center">
    <h1><font color="green">External Marks Report</font></h1>
    <form  name=f1 action="" method="post">
    <table width="50%" border="1" class="t" align="center">  
 <%

  
   examEO bb1=new examEO();
   ArrayList arr1=(ArrayList)request.getAttribute("data");
   for(int i=0;i <1;i++)
  {
  bb1 =(examEO)arr1.get(i);
  %>   
   <tr><td width="30%" align="left">Stud id</td><td width="70%" align="left"><%=bb1.getStudid()%></td></tr>
   <tr><td width="30%" align="left">Year</td><td width="70%" align="left"><%=bb1.getSession()%></td></tr> 
   <tr><td width="30%" align="left">Semester</td><td width="70%" align="left"><%=bb1.getSemester()%></td></tr>
   <tr><td width="30%" align="left">Degree</td><td width="70%" align="left"><%=bb1.getDegree()%></td></tr>  
   <tr><td width="30%" align="left">Course ID</td><td width="70%" align="left">External Marks</td></tr>
   <%
     }
    String st;  
   examEO bb=new examEO();
   ArrayList arr=(ArrayList)request.getAttribute("data");
   for(int i=0;i < arr.size();i++)
  {
  bb =(examEO)arr.get(i);
  %>    
<tr><td width="30%" align="left"><%=bb.getCourseid()%></td><td width="70%" align="left"><%=bb.getExternal()%></td></tr>
<tr><td width="50%" colspan="2" align="center"><a  href="#" onclick="disp('<%=bb.getStudid()%>','<%=bb.getSession()%>','<%=bb.getCourseid()%>')"><font color="blue">Update</font></a></td></tr>     
   <%}%>   
  </table>   
  </form>
  </td></tr></table></td></tr> 
  <tr><td valign="top"><%@include file="/btmnavi.jsp"%></td></tr>
  </td></tr></table> 
  </body>
  </html>
