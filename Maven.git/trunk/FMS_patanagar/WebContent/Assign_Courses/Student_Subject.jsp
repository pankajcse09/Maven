<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="ActionClass.JavaBeanEmp"%>
<%@page import="Assign_courses.Teacher_list"%>
<%@page import="Assign_courses.Course_bean"%>
<%@page import="java.util.ArrayList"%>

    <%!
    Teacher_list th  =new Teacher_list();
    

JavaBeanEmp je=new JavaBeanEmp();
Course_bean cb=new Course_bean();
ArrayList list=new ArrayList();
ArrayList course_list=new ArrayList();
ArrayList lasses=new ArrayList();
ArrayList student_list=new ArrayList();
ArrayList detail=new ArrayList();
%>
    <%
list=th.select_teach();
lasses=(ArrayList)th.allClasses();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script language="javascript">
      function getstu_sub() 
      {

document.forms[0].method="POST";
document.forms[0].action="get_stu_sub.do";
document.forms[0].submit();


       }
       function get_subdetail()
      {

document.forms[0].method="POST";
document.forms[0].action="get_subdetail.do?para=para1";
document.forms[0].submit();


       } 
        function get_stu() 
      {

document.forms[0].method="POST";
document.forms[0].action="get_stu.do?para=para";
document.forms[0].submit();


       }
        
        </script>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top"> 
<table width="100%" align="center"><tr><td width="100%" align="center"><font size="3" color="blue"><b>Assign Subject to Student</b></font></td></tr></table>
       <form action="stdnt_sub.do" method="post">
         <table width="60%" align="center">
         <tr><td>Session:<select name="session" onchange="getstu_sub()">
 
            <% if(request.getParameter("session")!=null)
            {
          %>
           <option value=<%=request.getParameter("session")%>><%=request.getParameter("session")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select></td>
     
     <td>Classes:<select name="classes" onchange="getstu_sub()"> 
          <% if(request.getParameter("session")!=null)
            {
          %>
           <option value=<%=request.getParameter("classes")%>><%=request.getParameter("classes")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int m=0;m<lasses.size();m++){
       %>
      <option value="<%=lasses.get(m)%>"><%=lasses.get(m)%></option>
      <%}%>
     </select></td>
     
      <td>Section:<select name="sec" onchange="getstu_sub()"> 
          
           <% if(request.getParameter("session")!=null)
            {
          %>
           <option value=<%=request.getParameter("sec")%>><%=request.getParameter("sec")%></option>
          <%}%>
           <option value="select">select</option>
          <%for(int m=65;m<=74;m++){
    char ch = (char)m; 
       %>
      <option value="<%=ch%>"><%=ch%></option>
      <%}%>
     </select></td>
      
      </tr> 
    
    <%
      if(request.getParameter("session")!=null)
    {%>
   
     <%
    String ses=request.getParameter("session");
    String cl=request.getParameter("classes");
    String sec=request.getParameter("sec");
course_list=(ArrayList)th.select_courses(ses,cl);
student_list=(ArrayList)th.select_student_name(ses,cl);
     %>
     <tr><td>Subjects:</td>
     <%
      for(int k=0;k<course_list.size();k++)
      {
      cb=(Course_bean)course_list.get(k);
     %>
     
     <td><input type="checkbox" name="subject" value="<%=cb.getSub()%>"><%=cb.getSub()%></td>
     <%
      
      }
      
     %>
     </tr>
     
     <tr><td>Student Name:</td><td><select name="student" multiple>
     <%
      for(int k=0;k<student_list.size();k++)
      {
      cb=(Course_bean)student_list.get(k);
     %>
     
   <option  value="<%=cb.getStudent_id()%>" SELECTED><%=cb.getStudent_id()%></option>
     <%
      
      }
      
     %>
     </select></td></tr>
     <tr><td><input type="submit" value="save"></td></tr>
     
      <tr><td><input type="button" value="view" onclick="get_stu()"></td></tr>
      <%
   if(request.getParameter("session")!=null&request.getParameter("para")!=null)
   {
   
    String ses1=request.getParameter("session");
    String cl1=request.getParameter("classes");
    String sec1=request.getParameter("sec");
  student_list=(ArrayList)th._student_name(ses,cl,sec);
  
      %>
    <tr><td>Student Name:<select name="student" onchange="get_subdetail()">
         
          <option  value="select">select</option>
          
     <%
      for(int k=0;k<student_list.size();k++)
      {
      cb=(Course_bean)student_list.get(k);
     %>
     
   <option  value="<%=cb.getStudent_id()%>"><%=cb.getStudent_id()%></option>
     <%
      
      }
      
     %>
     </select></td></tr>
     <%if(request.getParameter("student")!=null&request.getParameter("para")!=null){
      
     String stdid=request.getParameter("student");
 detail=(ArrayList)th.all_student_name(stdid);
     %>
     <tr><td>
         
     <table border="1">
         <tr><th>Session</th><th>Student</th><th>Class</th><th>Section</th><th>Subject</th></tr>
         <%
  for(int k=0;k<detail.size();k++)
      {
      cb=(Course_bean)detail.get(k);
 
%>     
    <tr><td><%=cb.getSession()%></td><td><%=cb.getStudent_id()%></td><td><%=cb.getClasses()%></td><td><%=cb.getSec()%></td><td><%=cb.getSub()%></td></tr>
     
          <%}%>
           </table>
     </td></tr>
     <%}%>
   
  <%} %>
     
     <%      
      }%>        
    </table>     
     </form>   
  </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
