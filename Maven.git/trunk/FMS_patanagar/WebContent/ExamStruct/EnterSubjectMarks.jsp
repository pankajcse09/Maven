<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*,schedule.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
 <%response.setHeader("Cache-Control","no-cache");%>
  <%    
     ArrayList ar=new ArrayList();
     ArrayList ar1=new ArrayList();   
     ArrayList ar2=new ArrayList();
     ArrayList ar3=new ArrayList();
     ArrayList ar4=new ArrayList();
     HashMap hm1=new HashMap();
     HashMap hm2=new HashMap();   
     HashMap hm3=new HashMap();
     JavaBeanExam jb=new JavaBeanExam();
     try{
     if(request.getAttribute("jbean")!=null){
     jb=(JavaBeanExam)request.getAttribute("jbean");    
     }
     MyMethods mm=new MyMethods();  
     ar1=(ArrayList)mm.allClasses();
     ar2=(ArrayList)jb.getExamTypeList();  
     ar3=(ArrayList)jb.getSubList();
     ar4=(ArrayList)jb.getExamList();
  %>
<html>
    <head>
    <script language="javascript" src="<%=request.getContextPath()%>/CheckNumericData.js"></script>
    <script language="javascript">
    function submitData(){
    document.f1.method="post";
    document.f1.action="<%=request.getContextPath()%>/RetriveExam1.do?method=retriveExamType";
    document.f1.submit();
    }
    
    function submitData1(){
    document.f1.method="post";
    document.f1.action="<%=request.getContextPath()%>/RetriveExam1.do?method=retriveExam";
    document.f1.submit();
    }
</script>
    </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding="0" cellspacing="0" width="100%" height="330"> 
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr>    
<tr><td valign="top">  
<form name="f1" method="post" action="<%=request.getContextPath()%>/SubmitSubjectMarks.do?method=subSubjectMarksAct">
 <table align="center">
 <%if(request.getAttribute("msg")!=null){%>  
 <tr><td colspan="2"><font color="red"><%=request.getAttribute("msg")%></font></td></tr>
  <%}%>     
    <tr><td>Session:</td><td><select name="sessions">
      <%if(!jb.getSessions().equals("")){%>
      <option value="<%=jb.getSessions()%>"><%=jb.getSessions()%></option> 
      <%}else{%>
       <option value="">Select</option> 
       <%}for(int i=2000;i<=2020;i++){
        if(jb.getSessions().equals(i+"-"+(i+1))){continue;} 
       %>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
       <%}%>
       </select>
       </td></tr> 
         <tr><td>Class</td>
        <td><select name="classes" onchange="submitData()">
           <%if(!jb.getClasses().equals("")){%>
           <option value="<%=jb.getClasses()%>"><%=jb.getClasses()%></option>
           <%}else{%> 
           <option value="">Select</option>
                <%}for(int i=0;i<ar1.size();i++){
                 if(jb.getClasses().equals(ar1.get(i).toString())){continue;}
                 %>
                <option value="<%=ar1.get(i).toString()%>"><%=ar1.get(i).toString()%></option>
                <%}%>
        </select>              
        </td></tr>     
    <tr><td>Exam Type:</td><td>
    <select name="examtype" onchange="submitData1()">  
    <%if(!jb.getExamType().equals("")){%>
    <option value="<%=jb.getExamType()%>"><%=jb.getExamType()%></option>
    <%}else{%> 
    <option value="">Select</option>
    <%}for(int i=0;i<ar2.size();i++){
    if(jb.getExamType().equals(ar2.get(i).toString())){continue;}
    %>
    <option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
    <%}%>
    </select> 
    </td></tr>   
    <tr><td>Subject:</td><td>
    <select name="subject">        
    <%if(!jb.getSubject().equals("")){%>
    <option value="<%=jb.getSubject()%>"><%=jb.getSubject()%></option>
    <%}else{%> 
    <option value="">Select</option>
    <%}for(int i=0;i<ar3.size();i++){
    if(jb.getSubject().equals(ar3.get(i).toString())){continue;}
    %>
    <option value="<%=ar3.get(i)%>"><%=ar3.get(i)%></option>   
    <%}%>
    </select> 
    </td></tr>  
    <%for(int i=0;i<ar4.size();i++){%>
    <tr><td><%=ar4.get(i).toString().toUpperCase()%></td><td><input type="text" name="exm_<%=ar4.get(i)%>" onkeypress="return checkNumeric();"></td></tr>
    <%}%>
    <tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
    </table>
    </form>
</td></tr></table>        
</td></tr><tr><td valign="bottom">
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
<%}catch(Exception e){out.println(e.getMessage());}%>