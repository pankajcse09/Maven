<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="ActionClass.JavaBeanEmp,schedule.MyMethods"%>
<%@page import="Assign_courses.Teacher_list"%>
<%@page import="Assign_courses.Course_bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Assign_courses.class_tab_bean"%>
<%@page import="java.util.HashMap"%>
<%
MyMethods mm=new MyMethods();
Teacher_list th  =new Teacher_list();    
class_tab_bean ct=new class_tab_bean();
JavaBeanEmp je=new JavaBeanEmp();
Course_bean cb=new Course_bean();
ArrayList list=new ArrayList();
ArrayList unittest=new ArrayList();
ArrayList courselist=new ArrayList();
ArrayList lasses=new ArrayList();
ArrayList sub_marks=new ArrayList();

HashMap hm2=new HashMap();

list=th.select_teach();
lasses=(ArrayList)th.allClasses();
try{
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script language="javascript"></script>
        <title>JSP Page</title>
    </head>  
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td width="100%" height="5" valign="top"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">   
       <form method="post" action="unit_test_report.do">
        <table><tr><td valign="top">    
       <table><tr><td valign="middle"> 
           ExamType:</td><td valign="middle"><select name="examtype">            
          <% if(request.getParameter("session")!=null){%>
          <option value="<%=request.getParameter("examtype")%>"><%=request.getParameter("examtype")%></option>
          <%}%>
            <option value="select">select</option>
            <option value="UNIT TEST ONE">UNIT TEST ONE</option>
            <option value="UNIT TEST TWO">UNIT TEST TWO</option>
           </select>
       </td>
      <td valign="middle">Classes:</td><td valign="middle"><select name="class"> 
          <% if(request.getParameter("session")!=null)
            {
          %>
           <option value="<%=request.getParameter("class")%>"><%=request.getParameter("class")%></option>
           <%}%>
           <option value="select">select</option>
       <%for(int m=0;m<lasses.size();m++){
       %>
      <option value="<%=lasses.get(m)%>"><%=lasses.get(m)%></option>
      <%}%>
     </select></td>     
      <td valign="middle">Section:</td><td valign="middle"><select name="sec"> 
          
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
     </select></td>
     <td valign="middle">Session</td><td valign="middle"><select name="session">
 
            <% if(request.getParameter("session")!=null)
            {
          %>
           <option value="<%=request.getParameter("session")%>"><%=request.getParameter("session")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select></td>
<td valign="middle"><input type="submit" value="Submit"></td></tr>
        </td></tr></table>
    
    <%
      if(request.getParameter("session")!=null)
    {
  
    String studnt_exam_type=request.getParameter("examtype");
    String  studnt_classes=request.getParameter("class");
    String studnt_sec=request.getParameter("sec");
    String studnt_session=request.getParameter("session");
      
    unittest=(ArrayList)th.select_unit_test_details();  
   courselist=(ArrayList)th.select_courses(studnt_session,studnt_classes);
    %> 
    <tr><td>
        <table border="1">
             <tr><th>sno.</th><th>SRNO</th><th>Name</th>             
              <%
      for(int k=0;k<courselist.size();k++)
      {
      cb=(Course_bean)courselist.get(k);
     %>
     
     <th><%=cb.getSub()%></th>
     <%
      
      }
      
     %><th>Total</th><th>Percent</th></tr>
        <%for(int i=0;i<unittest.size();i++)  
           {
             HashMap hm1=new HashMap();  
     ct=(class_tab_bean)unittest.get(i);
    
String ser_no=ct.getSrno();//serial no.

sub_marks=th.select_sub_marks(ser_no);

for(int j=0;j<sub_marks.size();j++)  
           {
     ct=(class_tab_bean)sub_marks.get(j);//subject_marks
  
     
    // out.println(ct);
hm1.put(ct.getSubject(),ct.getMarks());
}
 hm2.put(ser_no,hm1) ;     
} 
for(int i=0;i<unittest.size();i++){
        
     ct=(class_tab_bean)unittest.get(i);
  
  HashMap hh=(HashMap)hm2.get(ct.getSrno());    
       %>
       <tr><td><%=i+1%></td><td><%=ct.getSrno()%> </td>
       <td><%=ct.getStudent_name()%></td>       
    <%
  courselist=(ArrayList)th.select_courses(studnt_session,studnt_classes);
  double from=0.0;
  double total=0.0; 
    for(int m=0;m<courselist.size();m++){          
         cb=(Course_bean)courselist.get(m);
  from=from+25;     
//if(!hh.get(cb.getSub()).toString().equals("A") && !hh.get(cb.getSub()).toString().equals("")){
  total=total+Double.parseDouble(hh.get(cb.getSub()).toString());
if(mm.unitTest(hh.get(cb.getSub()).toString()).equals("P")){ 
  %>
<td><%=hh.get(cb.getSub())%></td>
<%}else{%>
<td bgcolor="red"><font color="white"><%=hh.get(cb.getSub())%></font></td>
<%}}%> 
       <td><%=total%></td>
       <td><%=(total*100)/from%></td></tr>
       <%}%>
      <tr><td colspan="3">Total</td>
<% for(int m=0;m<courselist.size();m++){          
cb=(Course_bean)courselist.get(m);%>
<td><%=unittest.size()%></td>
      <%}%></tr>
      <tr><td colspan="3">Appeared</td><% for(int m=0;m<courselist.size();m++){          
cb=(Course_bean)courselist.get(m);%>
<td><%=mm.appeared(studnt_session,studnt_classes,studnt_sec,studnt_exam_type,cb.getSub())%></td>
      <%}%></tr>
      <tr><td colspan="3">Pass</td><% for(int m=0;m<courselist.size();m++){          
cb=(Course_bean)courselist.get(m);%>
<td><%=mm.unitTestPass(studnt_session,studnt_classes,studnt_sec,studnt_exam_type,cb.getSub())%></td>
      <%}%></tr>
      <tr><td colspan="3">Fail</td><% for(int m=0;m<courselist.size();m++){          
cb=(Course_bean)courselist.get(m);%>
<td><%=mm.unitTestFail(studnt_session,studnt_classes,studnt_sec,studnt_exam_type,cb.getSub())%></td>
      <%}%></tr>
       </table>    
    </td></tr>
     <%}%>
     </table>  
     </form>   
    </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
<%}catch(Exception e){out.println(e.getMessage());}%>
