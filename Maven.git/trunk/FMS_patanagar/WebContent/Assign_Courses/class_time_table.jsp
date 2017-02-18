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
<%@page import="Assign_courses.class_tab_bean"%>

<%
 Teacher_list th  =new Teacher_list();   

JavaBeanEmp je=new JavaBeanEmp();
class_tab_bean cb=new class_tab_bean();
ArrayList list=new ArrayList();

ArrayList table_list=new ArrayList();
ArrayList classes=new ArrayList();
ArrayList lasses=new ArrayList();
classes=(ArrayList)th.allClasses();
list=(ArrayList)th.select_teach_course();
ArrayList days=new ArrayList(); 
days=(ArrayList)th.select_day();
String teach="";
String teach_subj="";
String studnt_class="";
String studnt_sec="";
String sess="";
String teach_id="";
lasses=(ArrayList)th.allClasses();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript">
             function get_tt() 
      {

document.forms[0].method="POST";
document.forms[0].action="class_time_table.do";
document.forms[0].submit();


       }
            </script>
    </head>
    <body>
    <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td valign="top" height="5%"><jsp:include page="/CommonLinks.jsp"/></td></tr> 
<tr><td valign="top">
<table width="20%" align="center">
    <form name="tt">
        
        <tr><td>Session</td><td colspan="3"><select name="sess"> 
     
           <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select></td></tr>
    <tr>
<td colspan="2">Classes<select name="class"> 
         
           <option value="select">select</option>
       <%for(int m=0;m<lasses.size();m++){
       %>
      <option value="<%=lasses.get(m)%>"><%=lasses.get(m)%></option>
      <%}%>
     </select></td>     
      <td colspan="2">Section:<select name="sec"> 
          
           
           <option value="select">select</option>
          <%for(int m=65;m<=74;m++){
    char ch = (char)m; 
       %>
      <option value="<%=ch%>"><%=ch%></option>
      <%}%>
     </select></td>

<td><input type="submit"  value="submit" onclick="get_tt()"></td></tr>
    </form>
  
</table>    

</td></tr>
<tr><td valign="top">
<table width="100%" align="center"><tr><td width="100%" align="center"><font size="3" color="blue"><b>Class Timetable</b></font></td></tr></table>
      <table border=1 width="100%">
      <tr><td colspan="10" align="center"><b><%
      
      if(request.getParameter("sess")!=null){

 studnt_class=request.getParameter("class") ;  
studnt_sec=request.getParameter("sec");
 sess=request.getParameter("sess");
      }%>
          

      </b></td></tr>
      <tr><td colspan="2" rowspan="2" align="center" width="30%"><b>Days</b></td><td colspan="8" align="center" width="70%"><b>Periods</b></td></tr>
      <tr><%for(int i=1;i<=8;i++){%>     
  <td align="center" width=""><b><%=th.inRoman(i)%></b></td>
      <%}%>
     </tr>

    
     <%for(int k=0;k<days.size();k++){
    cb=(class_tab_bean)days.get(k);
  
     %>

     <tr><td align="center"><%=k+1%></td><td><%=cb.getDay()%></td>
 <% String nodays=cb.getDay();
  
      
  
 //out.println(table_list);

%>

<%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"I",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 
 <%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"II",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 
<%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"III",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 

 <%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"IV",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 

 
 <%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"V",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 
<%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"VI",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 
<%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"VII",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 
 <%
       cb=(class_tab_bean)th.class_table(sess,studnt_class,studnt_sec,"VIII",nodays);
     
    
    teach_subj=cb.getSubject();
   teach_id=cb.getTeach_id();
%>
   <%if(!teach_subj.equals("") && !teach_id.equals("")){%>
 <td><%=teach_subj%>/<%=teach_id%></td>
 <%}%>
 <%if(teach_subj.equals("") && teach_id.equals("")){%>
 <td>Free Period</td>
 <%}%>
 
 
   </tr>
   
   
   
     
     <%
     }%>
      </table>   
       </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>     
    </body>
</html>
