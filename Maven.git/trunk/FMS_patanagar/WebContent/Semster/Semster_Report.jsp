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
<%@page import="java.util.HashMap"%>
<%
String ut1="UNIT TEST ONE";
String ut2="UNIT TEST TWO";
ArrayList srno=new ArrayList();
ArrayList allsub=new ArrayList();
Teacher_list th  =new Teacher_list();

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
document.forms[0].action="sem_report.do";
document.forms[0].submit();
       }
      
        
        </script>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="330">
<tr><td valign="top" height="5%"><jsp:include page="/CommonLinks.jsp"/></td></tr> 
<tr><td valign="top"> 
    <%!
    
    
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
ArrayList prac=new ArrayList();
ArrayList theory=new ArrayList();
 ArrayList theory_mark= new ArrayList();

%>
    <%
       String subj="";
       String srn="";
list=th.select_teach();
lasses=(ArrayList)th.allClasses();

%>
 <%
        
%>
   <table>
       <form action="_exam_schedule.do" method="post">
      
     
      <tr><td>Classes:</td><td><select name="class"> 
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
      
      </tr>
       
       
       <tr><td>Session</td><td><select name="session" onchange="getcourse()">
 
            <% if(request.getParameter("session")!=null)
            {
          %>
           <option value=<%=request.getParameter("session")%>><%=request.getParameter("session")%></option>
          <%}%>
           <option value="select">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select></td></tr>
    
    <%
      if(request.getParameter("session")!=null)
    {
  
   
    String  studnt_classes=request.getParameter("class");
    String studnt_sec=request.getParameter("sec");
    String studnt_session=request.getParameter("session");
  
     out.println(studnt_classes);  
      out.println(studnt_sec); 
      
       out.println(studnt_session);
       
    unittest=(ArrayList)th.select_unit_test_details();
    //out.println(unittest);
       courselist=(ArrayList)th.select_courses(studnt_session,studnt_classes);
       
       theory=(ArrayList)th.select_theorey(studnt_session,studnt_classes);
       out.println("theoryyyy"+theory);
       prac=(ArrayList)th.select_prac(studnt_session,studnt_classes);
        //out.println("courselistvbbbbbbbbbbbbbbbbbb"+courselist);
              out.println("prac"+prac);
      
       
    %> 
       
    
    
    <tr><td>
        <table border="1">
             <tr><th rowspan="2">sno.</th><th rowspan="2" >SRNO</th><th rowspan="2">Name</th>
             
              <%
      for(int k=0;k<theory.size();k++)
      {
      ct=(class_tab_bean)theory.get(k);
    //  allsub.add(cb.getSub());
      //out.println(cb)
     %>
     
     <th colspan="2"><%=ct.getSubject()%></th>
     <%
      
      }
            
      for(int k=0;k<prac.size();k++)
      {
      ct=(class_tab_bean)prac.get(k);
    //  allsub.add(cb.getSub());
      //out.println(cb)
     %>
     
     <th colspan="4"><%=ct.getSubject()%></th>
     <%
      
      }  
           
              
              
      
     %><th>Total</th></tr>
    
<tr>
     <%for(int k=0;k<theory.size();k++)
     {
  ct=(class_tab_bean)theory.get(k);%>
     <td><%=ct.getTheory()%></td><td>40%</td>
     
       <%}%>

<%for(int k1=0;k1<prac.size();k1++)
     {
  ct=(class_tab_bean)prac.get(k1);
int a=0;
int b=0;
int c=0;
a=Integer.parseInt(ct.getTheory());
b=Integer.parseInt(ct.getPrac());
c=a+b;
%>
     <td>Th(<%=ct.getTheory()%>)</td><td>Pr(<%=ct.getPrac()%>)</td>
<td><%=new Integer(c).toString()%></td>

<td>40%</td>
     
       <%}%>

</tr>


 


   
     
      
     
<%
for(int i=0;i<unittest.size();i++)  
           {
        
     ct=(class_tab_bean)unittest.get(i);
       srn=ct.getSrno();
       
      
  
       %>
      <tr> <td><%=i+1%></td><td><%=ct.getSrno()%> </td>
       <td><%=ct.getStudent_name()%></td>
       <%
         for(int k=0;k<theory.size();k++)
         {
       
  ca=(class_tab_bean)theory.get(k);
    subj=ca.getSubject();
    String tm=th.select_theory_mark(subj,srn);
     
       %>
        <td><%=tm%></td><td>a</td>
       <%
       }
       
       %>
       
       
       <%
         for(int k=0;k<prac.size();k++)
         {
       
  ca=(class_tab_bean)prac.get(k);
   subj=ca.getSubject();
  String tm=th.select_theory_mark(subj,srn);
  String pr= th.select_pr_mark(subj,srn);
  //print of theory and practical marks
       %>
        <td><%=tm%></td><td><%=pr%></td><td>100</td><td>40%</td>
       <%
       }
       
       %>
       
       
      
       <%}

%>
      
      
      
      </tr>  
       
    
    
      
     
  
    
        
           
   
       
      
      

     
     
      



        
        
           
    
    
      
        </table>
    
    </td></tr>
    
   
     <%}%>
      
     </form>
   </table>
    
    </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
