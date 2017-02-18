<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="ActionClass.JavaBeanEmp"%>
<%@page import="Assign_courses.*"%>
<%@page import="java.util.*,schedule.MyMethods"%>

<%
MyMethods mm=new MyMethods();   
String ut1="UNIT TEST ONE";
String ut2="UNIT TEST TWO";
ArrayList srno=new ArrayList();
ArrayList allsub=new ArrayList();
Teacher_list th  =new Teacher_list();

class_tab_bean ct=new class_tab_bean();
    
class_tab_bean ca=new class_tab_bean();
JavaBeanEmp je=new JavaBeanEmp();
Course_bean cb=new Course_bean();
ArrayList list=new ArrayList();
ArrayList unittest=new ArrayList();
ArrayList courselist=new ArrayList();
ArrayList lasses=new ArrayList();
ArrayList sub_marks=new ArrayList();
ArrayList sub_list=new ArrayList();
ArrayList marks_list=new ArrayList();
ArrayList test_type=new ArrayList();
ArrayList details=new ArrayList();
HashMap hm2=new HashMap();
ArrayList total=new ArrayList();

list=th.select_teach();
lasses=(ArrayList)th.allClasses();

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
<tr><td width="100%" height="5" align="top"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top"> 
  <form method="post" action="unit_test_record.do">
   <table width="100%" align="center"><tr><td width="100%" align="center"> 
   <table>
   <tr><td>Classes:</td><td><select name="class"> 
          <% if(request.getParameter("session")!=null){%>
           <option value=<%=request.getParameter("class")%>><%=request.getParameter("class")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int m=0;m<lasses.size();m++){
       %>
      <option value="<%=lasses.get(m)%>"><%=lasses.get(m)%></option>
      <%}%>
     </select></td>
     
      <td>Section:</td><td><select name="sec"> 
          
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
     <td>Session</td><td><select name="session">
 
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
     <td><input type="submit" value="Submit"></td>
     </tr></table>
    
    <%
      if(request.getParameter("session")!=null)
    {
  
   
    String  studnt_classes=request.getParameter("class");
    String studnt_sec=request.getParameter("sec");
    String studnt_session=request.getParameter("session");
       
    unittest=(ArrayList)th.select_unit_test_details();   
    courselist=(ArrayList)th.select_courses(studnt_session,studnt_classes);      
    %>  
   </td></tr><tr><td>
        <table border="1" style="border-collapse:collapse" align="center">
             <tr><th rowspan="2">SNO</th><th rowspan="2" >SRNO</th><th rowspan="2">Name</th>
             
              <%
      for(int k=0;k<courselist.size();k++)
      {
      cb=(Course_bean)courselist.get(k);
      allsub.add(cb.getSub());
     %>
     
     <th  colspan="4"><%=cb.getSub()%></th>
     <%
      
      }
      
     %></tr>
     <tr>
     <%for(int k=0;k<courselist.size();k++)
     {%>
     <td>I</td><td>II</td><td bgcolor="red">Total</td><td>20%</td>
     
       <%}%></tr>
<%for(int i=0;i<unittest.size();i++)  //seraila no loop
           {
            
     ct=(class_tab_bean)unittest.get(i);
    
String ser_no=ct.getSrno();//serial no.
srno.add(ser_no);
test_type=(ArrayList)th.select_examtype(ser_no);

marks_list=(ArrayList)th.select_marks(ser_no);
      // total.add() ;
        
        
//out.println(test_type);
       } %>  
<%
String u1="";
String u2="";
int y=0;
double totalm=0.0;
double per2=0.0;
for(int a=0;a<srno.size();a++){
%>
 <tr><td><%=++y%></td><td><%=srno.get(a)%></td><td><%=mm.retriveStudName(srno.get(a).toString())%></td>       
<%   
for(int k=0;k<allsub.size();k++){
 u1=mm.unitTest(new Double(th.select_exam_detail(srno.get(a).toString(),studnt_session,ut1,studnt_classes,allsub.get(k).toString())).toString());  
 u2=mm.unitTest(new Double(th.select_exam_detail(srno.get(a).toString(),studnt_session,ut2,studnt_classes,allsub.get(k).toString())).toString()); 
totalm=th.select_exam_detail(srno.get(a).toString(),studnt_session,ut1,studnt_classes,allsub.get(k).toString())+th.select_exam_detail(srno.get(a).toString(),studnt_session,ut2,studnt_classes,allsub.get(k).toString());
per2=(totalm*2*20)/100;
if(u1.equals("P")){
%>
 <td><%=th.select_exam_detail(srno.get(a).toString(),studnt_session,ut1,studnt_classes,allsub.get(k).toString())%></td>
 <%}else{%>
 <td bgcolor="red"><%=th.select_exam_detail(srno.get(a).toString(),studnt_session,ut1,studnt_classes,allsub.get(k).toString())%></td>
 <%}if(u2.equals("P")){%>
 <td><%=th.select_exam_detail(srno.get(a).toString(),studnt_session,ut2,studnt_classes,allsub.get(k).toString())%></td>
 <%}else{%>
 <td bgcolor="red"><%=th.select_exam_detail(srno.get(a).toString(),studnt_session,ut2,studnt_classes,allsub.get(k).toString())%></td>
 <%}%>
 <td bgcolor="red"><%=totalm%></td><td><%=per2%></td>
     <%}%></tr>
       <%}%>           
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
