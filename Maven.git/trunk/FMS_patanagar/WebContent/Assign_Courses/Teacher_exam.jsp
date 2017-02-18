<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="ActionClass.JavaBeanEmp"%>
<%@page import="Assign_courses.Teacher_list"%>
<%@page import="Assign_courses.Course_bean"%>
<%@page import="Assign_courses.class_tab_bean"%>
<%@page import="java.util.*"%>

<%
 Teacher_list th=new Teacher_list();    

JavaBeanEmp je=new JavaBeanEmp();
class_tab_bean cb=new class_tab_bean();
ArrayList list=new ArrayList();
ArrayList teach_list=new ArrayList();
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
    function view()
    {
   document.location.href="view_duties.do?para=view";
    }
function er_det(){
document.teachh.method="POST";
document.teachh.action="get_details_room.do?para=view";
document.teachh.submit();
}
       function validate(){
       for(i=0;i<document.f1.elements.length;i++){    
       if(document.f1.elements[i].value=="select"){
       alert("Select Value");
       document.f1.elements[i].focus();
       return false;
       }  
       }
</script>
    </head>    
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top"> 
<table width="100%" align="center"><tr><td width="100%" align="center"><font size="3" color="blue"><b>Schedule Teacher's Exam Timetable</b></font></td></tr></table>
       <form name="f1" action="exam_teach.do" method="post" onsubmit="return validate();">
       <table width="70%" align="center" border="1">    
        <tr><td>Session:<select name="session" onchange="getcourse()">          
        <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
      </select></td><td>ExamType:<select name="examtype">              
           <%if(request.getParameter("examtype")!=null){%>
           <option value="<%=request.getParameter("examtype")%>"><%=request.getParameter("examtype")%></option>
          <%}%>
           <option value="select">select</option>
           <option value="UnitTest-1">UNIT TEST ONE</option>
           <option value="UnitTest-2">UNIT TEST TWO</option>
           <option value="Half-Yearly">HALFYEARLY</option>
           <option value="Final">FINAL</option>                
       </select>
       </td></tr> 
    <tr><td><table><tr><td>Date:</td><td><script>DateInput('dates',true,'dd/mm/yyyy')</script></td></tr></table></td>  
    <td colspan="2">Time From:<select name="from_time">
    <option value="select">select</option>
<%for(int i=0;i<=23;i++){
for(int j=0;j<=60;j+=5){%>         
<option value="<%=i%>:<%=j%>"><%=i%>:<%=j%></option>    
<%}}%>
</select>
To:<select name="to_time">
<option value="select">select</option>
<%for(int i=0;i<=23;i++){
for(int j=0;j<=60;j+=5)
{%>         
       <option value="<%=i%>:<%=j%>"><%=i%>:<%=j%></option>    
      <%}}%>
      </select></td></tr>
       <tr><td>Teacher List:<select name="teach_id">         
       <option value="select">select</option>
<%for(int i=0;i<list.size();i++){
je=(JavaBeanEmp)list.get(i);
%>
<option value="<%=je.getLoginId()%>"><%=je.getLoginId()%></option>           
<%}%>
       </select>
       </td>   
       <td>Room No:<select name="room">
         <option value="select">select</option>
       <%for(int i=1;i<=50;i++){%>     
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
      </select></td></tr>
      <tr>    
      <tr><td colspan="2" align="center"><input type="submit" value="submit"></td></tr>
      </table>
     </form>    
   <form name="teachh">
   <table width="70%" align="center">        
   <tr><td><input type="button" value="View" onclick=view()></td></tr>  
   <%if((String)request.getParameter("para")!=null){%>    
    <tr><td><select name="tid" onchange="er_det()">
     <%if((request.getParameter("tid")!=null)){ %>
      <option value="<%=request.getParameter("tid")%>"><%=request.getParameter("tid")%></option>
      <%}%>
     <option value="select">select</option>
<%  
teach_list=(ArrayList)th.select_teach_exam();
for(int i=0;i<teach_list.size();i++)
{
    cb=(class_tab_bean)teach_list.get(i);
%>
  <option value="<%=cb.getTeach_id()%>"><%=cb.getTeach_id()%></option>   
   <%}%>
   </select></td></tr>    
   <%}%>
   </table>
   </form>             
</td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>        
</body>
</html>
