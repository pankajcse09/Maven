<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClassAttend.*,java.util.*,Beans.JavaBean,java.text.*"%>
<%@page import="schedule.*"%> 
   <%  
   response.setHeader("Cache-Control","no cache");    
   char ch;
   int k=0;
   String ssn="";
   String clas="";  
   String sec="";  
   String sub=""; 
   JavaBeanExam jb1=new JavaBeanExam();
   java.util.Date dt=new java.util.Date();
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
   String dst=sdf.format(dt);  
   
   if(request.getParameter("session")!=null){
    ssn=(String)request.getParameter("session");    
    jb1.setSessions(ssn);
   }
   
   if(request.getParameter("class")!=null){
   clas=request.getParameter("class").toString();   
    jb1.setClasses(clas);
    }
  
   if(request.getParameter("section")!=null){
   sec=request.getParameter("section").toString();   
    jb1.setSection(sec);
    }
    
     if(request.getParameter("subject")!=null){
     sub=request.getParameter("subject").toString();  
     jb1.setSubject(sub);
    }   
   ArrayList ar=new ArrayList();
   ArrayList ar1=new ArrayList();
   ArrayList ar2=new ArrayList();
   ArrayList ar3=new ArrayList();
   MyMethodsAttend mm=new MyMethodsAttend();     
   ar1=(ArrayList)mm.retriveAllClass();    
   DataObject1 dataobj=new DataObject1();    
   JavaBeanExam jb=(JavaBeanExam)dataobj.retriveSubjects(jb1);
   ar=(ArrayList)jb.getSubList();
   ar3=(ArrayList)dataobj.allStudList1(jb1);
 
   %>
<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>  
 <script language="javascript">
  function submit1(){  
   document.f1.method="POST";
   document.f1.action="<%=request.getContextPath()%>/ExamAttendence.jsp";
   document.f1.submit();
  }
 </script>              
 <title>School Management System</title>
    </head>
    <body>
    <table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">
<tr><td><%@include file="/toplook.jsp"%></td></tr>
 <tr><td valign="top">  
 <table height="330" align="center" width="100%" border="0">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">
    <table width="100%" align="center"><tr><td width="100%" align="center"><font color="#34282C" size="4"><b>Student Exam Attendence</b></font></td></tr></table>
    <hr>    
    <table><tr><td><font color="#34282C" size="4"><b>Dated: <%=dst%></b></font></td></tr></table>     
    <hr>
         <form name="f1" method="post" action="<%=request.getContextPath()%>/ExamAttendence.jsp">       
         <table border="1" class="t" align="center"><tr>
         <td>Session:<select name="session" onchange="submit1()">
 
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
           <td>Class<select name="class" onchange="submit1()">
           <% if(!clas.equals("")){%>
                 <option value="<%=clas%>"><%=clas%></option>
                 <%}%>    
                <%for(int i=0;i<ar1.size();i++){
                 if(clas.equals(ar1.get(i).toString())){continue;}
                 %>
                <option value="<%=ar1.get(i).toString()%>"><%=ar1.get(i).toString()%></option>
                <%}%>
       </select></td>
           <td>Section<select name="section" onchange="submit1()">
           <% if(!sec.equals("")){%>
                 <option value="<%=sec%>"><%=sec%></option>
                 <%}   
        for(int i=65;i<74;i++){
        if(sec.equals(new Character((char)i).toString())){continue;}
         ch=(char)i;
        %> 
         <option value="<%=ch%>"><%=ch%></option>   
         <%}%>     
       </select></td>
         <td>Subject:<select name="subject">
            <%             
            if(jb.getSubject()!=null && !jb.getSubject().equals("")){
            %>
                <option value="<%=jb.getSubject()%>"><%=jb.getSubject()%>
                <% 
                  }
                for(int i=0;i<ar.size();i++){
                if(ar.get(i).toString().equals(jb.getSubject())){continue;}
                %>                  
                <option value="<%=ar.get(i)%>"><%=ar.get(i)%></option>
                <%}%>
            </select>
            </td>
         <td><input type="submit" value="Submit"></td></tr></table>
         </form>
         <hr color="green">  
    <form name="f2" method="post" action="ExamAttendAction.do?method=examAttendence">  
    <input type="hidden" name="dated" value="<%=dst%>">
    <input type="hidden" name="session" value="<%=ssn%>">
    <input type="hidden" name="class" value="<%=clas%>">
    <input type="hidden" name="section" value="<%=sec%>">
    <input type="hidden" name="subject" value="<%=sub%>">
    <table align="center" width="40%"><tr><td>
    <%if(request.getAttribute("msg")!=null){%>
    <font color="red"><b><%=request.getAttribute("msg")%></b></font>   
    <%}%> 
    <table><tr> <tr><td>Exam Type</td><td align="left" colspan="3">
    <%if(!clas.equals("10") && !clas.equals("12")){%>
     <select name="examtype">                
     <option value="UNIT TEST ONE">UNIT TEST ONE</option>
     <option value="HALF YEARLY">HALF YEARLY</option>    
     <option value="UNIT TEST TWO">UNIT TEST TWO</option>
     <option value="FINAL">FINAL</option>
     </select> 
     <%}else{%>
     <select name="examtype"><option value="MOCK TEST ONE">MOCK TEST ONE</option>
     <option value="MOCK TEST TWO">MOCK TEST TWO</option><option value="MOCK TEST THREE">MOCK TEST THREE</option>
     <option value="FIRST PREBOARD">FIRST PREBOARD</option><option value="SECOND PREBOARD">SECOND PREBOARD</option></select> 
     <%}%>
    </td></tr>
    </tr></table>
    <table width="100%" border="1" class="t" align="center"> 
    <td width="25%" align="right"><b>SNo</b></td><td width="25%" align="right"><b>Student Name</b></td><td width="25%" align="right"><b>Attendence</b></td></tr>
     <%for(int i=0;i<ar3.size();i++){%>    
     <tr><td align="right"><%=++k%></td>
     <td align="right"><%=ar3.get(i)%><input type="hidden" name="stu<%=i%>" value="<%=ar3.get(i)%>"></td>
     <td align="right"><select name="sts<%=i%>"> 
     <option value="P">P</option>
     <option value="A">A</option>
     </select></td></tr>     
     <%}%>
     <tr><td colspan="4" align="center"><input type="submit" value="Submit"></td></tr>
     </table>
     </td></tr></table>
     </td></tr></table>
     </td></tr></table>
    </form>
    </body>
</html>
