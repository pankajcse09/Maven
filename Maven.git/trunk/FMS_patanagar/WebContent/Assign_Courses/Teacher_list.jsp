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
    </head>
    <script language="javascript">
        function getcourse() 
      {
document.forms[0].method="POST";
document.forms[0].action="a_find_course.do";
document.forms[0].submit();
       }
function view(){
document.forms[0].method="POST";
document.forms[0].action="a_find_course.do";
document.forms[0].submit();
       } 
       function validate(){
       for(i=0;i<document.f1.elements.length;i++){    
       if(document.f1.elements[i].value=="select" || document.f1.elements[i].value==""){
       alert("Select Value");
       document.f1.elements[i].focus();
       return false;
       }  
       }
       return true;
       }
        </script>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">
<table width="100%" align="center"><tr><td width="100%" align="center"><font size="3" color="blue"><b>Schedule Teacher's Timetable</b></font></td></tr></table>
       <form name="f1" action="class_tab.do" method="post" onsubmit="return validate();">
       <table align="center" width="80%" border="1">  
       <tr><td>Session:<select name="session" onchange="getcourse()"> 
       <%if(request.getParameter("session")!=null){
          %>
           <option value=<%=request.getParameter("session")%>><%=request.getParameter("session")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select></td><td>Classes:<select name="class" onchange="getcourse()"> 
          <% if(request.getParameter("session")!=null)
            {
          %>
           <option value=<%=request.getParameter("class")%>><%=request.getParameter("class")%></option>
          <%}else{%>
           <option value="select">select</option>
       <%}for(int m=0;m<lasses.size();m++){
       %>
      <option value="<%=lasses.get(m)%>"><%=lasses.get(m)%></option>
      <%}%>
     </select></td>     
      <td>Section:<select name="sec" onchange="getcourse()">           
           <% if(request.getParameter("session")!=null)
            {
          %>
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
   <tr><td colspan="3">
   <table><tr><td>Subjects:</td>
     <%
    String ses=request.getParameter("session");
    String cl=request.getParameter("class");
    course_list=(ArrayList)th.select_courses(ses,cl);
   
      for(int k=0;k<course_list.size();k++)
      {
      cb=(Course_bean)course_list.get(k);
     %>     
     <td><input type="radio" name="subject" value="<%=cb.getSub()%>"><%=cb.getSub()%></td>
     <%}%>
   </tr></table> 
   </td></tr>   
     <%}%>
         <tr><td colspan="3">Teacher List:<select name="teach">           
            <% if(request.getParameter("session")!=null)
            {
          %>
          <option value=<%=request.getParameter("teach")%>><%=request.getParameter("teach")%></option>
          <%}%>
           <option value="select">select</option>
           <%for(int i=0;i<list.size();i++){
           je=(JavaBeanEmp)list.get(i);
             %>
           <option value="<%=je.getLoginId()%>"><%=je.getLoginId()%></option>           
           <%}%>
       </select>
       </td></tr>  
<tr><td>Day:<select name="day">
 <option value="select">select</option>
<option value="Monday">Monday</option>
<option value="Tuesday">Tuesday</option>
<option value="Wednesday">Wednesday</option>
<option value="Thursday">Thursday</option>
<option value="Friday">Friday</option>
<option value="Saturday">Saturday</option>
<option value="Sunday">Sunday</option>
</select>
</td>     
      <td colspan="2">Period:<select name="period">
         <option value="select">select</option>
       <%     
       for(int i=1;i<=8;i++){%>     
       <option value="<%=th.inRoman(i)%>"><%=th.inRoman(i)%></option>    
      <%}%>
      </select></td>
      </tr>
      <tr><td colspan="4" align="center"><input type="submit" value="Submit"></td></tr>
      </table>
     </form>
   </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>  
    </body>
</html>
