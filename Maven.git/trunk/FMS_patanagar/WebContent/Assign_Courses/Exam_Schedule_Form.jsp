<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="ActionClass.JavaBeanEmp"%>
<%@page import="Assign_courses.Teacher_list"%>
<%@page import="Assign_courses.Course_bean"%>
<%@page import="java.util.*"%>

 <%
Teacher_list th  =new Teacher_list();   

JavaBeanEmp je=new JavaBeanEmp();
Course_bean cb=new Course_bean();
ArrayList list=new ArrayList();
ArrayList course_list=new ArrayList();
ArrayList lasses=new ArrayList();

list=th.select_teach();
lasses=(ArrayList)th.allClasses();

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript" src="./calendarDateInput.js"></script>    
    <script language="javascript">
    function getcourse() 
      {
document.forms[0].method="POST";
document.forms[0].action="exam_course.do";
document.forms[0].submit();
      }        
  </script>
  </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top"> 
<table width="100%" align="center"><tr><td width="100%" align="center"><font size="3" color="blue"><b>Schedule Exam Timetable</b></font></td></tr></table>   
       <form action="_exam_schedule.do" method="post">
       <table width="70%" align="center" border="1">  
       <tr><td>Session:<select name="session" onchange="getcourse()"> 
            <% if(request.getParameter("session")!=null){%>
           <option value="<%=request.getParameter("session")%>"><%=request.getParameter("session")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select></td>
       <td>ExamType:<select name="examtype">              
              <% if(request.getParameter("session")!=null){%>
           <option value="<%=request.getParameter("examtype")%>"><%=request.getParameter("examtype")%></option>
          <%}%>
           <option value="select">select</option>
           <option value="UNIT TEST ONE">UNIT TEST ONE</option>
           <option value="UNIT TEST TWO">UNIT TEST TWO</option>
           <option value="HALF YEARLY">HALF YEARLY</option>
           <option value="FINAL">FINAL</option>                
       </select>
       </td></tr>     
       <tr><td>Classes:<select name="class" onchange="getcourse()"> 
          <% if(request.getParameter("session")!=null)
            {
          %>
           <option value=<%=request.getParameter("class")%>><%=request.getParameter("class")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int m=0;m<lasses.size();m++){
       %>
      <option value="<%=lasses.get(m)%>"><%=lasses.get(m)%></option>
      <%}%>
     </select></td>     
      <td>Section:<select name="sec" onchange="getcourse()">           
           <% if(request.getParameter("session")!=null){%>
           <option value="<%=request.getParameter("sec")%>"><%=request.getParameter("sec")%></option>
          <%}%>
           <option value="select">select</option>
          <%for(int m=65;m<=74;m++){
          char ch = (char)m; 
          %>
      <option value="<%=ch%>"><%=ch%></option>
      <%}%>
     </select></td></tr>   
    
    <%
      if(request.getParameter("session")!=null)
    {%>
   <tr><td>Subjects:</td><td>
   <table><tr>
     <%
    String ses=request.getParameter("session");
    String cl=request.getParameter("class");
//out.println(ses);
course_list=(ArrayList)th.select_courses(ses,cl);
//out.println(course_list);
   
      for(int k=0;k<course_list.size();k++)
      {
      cb=(Course_bean)course_list.get(k);
     %>
     
     <td><input type="radio" name="subject" value="<%=cb.getSub()%>"><%=cb.getSub()%></td>
     <%}%>
   </tr></table>
   </td></tr>
     <%}%>    
      <tr>
<td><table><tr><td>Date:</td><td><script>DateInput('dates', true, 'dd/mm/yyyy')</script></td></tr></table></td>
<td>Time From:<select name="from_time">
         <option value="select">select</option>
       <%for(int i=0;i<=23;i++){
for(int j=0;j<=60;j+=5)
{
%>          
       <option value="<%=i%>:<%=j%>"><%=i%>:<%=j%></option>    
      <%}}%>
      </select>
To:<select name="to_time">
         <option value="select">select</option>
       <%for(int i=0;i<=23;i++){
for(int j=0;j<=60;j+=5)
{
%>  
        
       <option value="<%=i%>:<%=j%>"><%=i%>:<%=j%></option>    
      <%}}%>
      </select></td></tr>    
      <tr><td colspan="2" align="center"><input type="submit" value="submit"></td></tr>
       </table>
     </form>   
    </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
