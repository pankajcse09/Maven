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
     ArrayList ar1=new ArrayList();
     ArrayList ar2=new ArrayList();
     ArrayList ar3=new ArrayList();   
     HashMap hm1=new HashMap();
     HashMap hm2=new HashMap();   
     HashMap hm3=new HashMap();
     String ssn="";
     String clas="";
     JavaBeanExam jb=new JavaBeanExam();
     if(request.getAttribute("jbean")!=null){
     jb=(JavaBeanExam)request.getAttribute("jbean");    
     }
     MyMethods mm=new MyMethods();  
     ar1=(ArrayList)mm.allClasses();
  %>
<html>
    <head>
    <script language="javascript" src="<%=request.getContextPath()%>/CheckNumericData.js"></script>
    </head>
    <body>
    <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding="0" cellspacing="0" width="100%" height="330"> 
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr>    
<tr><td valign="top">  
<form name="f1" method="post" action="<%=request.getContextPath()%>/SubmitExamType.do?method=subExamTypeAct">
    <table align="center">
 <%if(request.getAttribute("msg")!=null){%>  
 <tr><td colspan="2"><font color="red"><%=request.getAttribute("msg")%></font></td></tr>
  <%}%>     
      <tr><td>Session:</td><td><select name="sessions">
      <%if(!jb.getSessions().equals("")){%>
      <option value="<%=jb.getSessions()%>"><%=jb.getSessions()%></option> 
      <%
       }
      else{
       %>
       <option value="">Select</option> 
       <%}for(int i=2000;i<=2020;i++){
       if(jb.getSessions().equals(i+"-"+(i+1))){continue;} 
       %>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
       </select>
     </td></tr> 
        <tr><td>Class</td>
        <td><select name="classes" onchange="submit1()">
                 <%if(!jb.getClasses().equals("")){%>
                 <option value="<%=jb.getClasses()%>"><%=jb.getClasses()%></option>
                 <%}%>    
                <%for(int i=0;i<ar1.size();i++){
                 if(jb.getClasses().equals(ar1.get(i).toString())){continue;}
                 %>
                <option value="<%=ar1.get(i).toString()%>"><%=ar1.get(i).toString()%></option>
                <%}%>
       </select>              
        </td></tr>     
    <tr><td>Exam Type</td><td><input type="text" name="examtype" value="<%=jb.getExamType()%>"></td></tr>
    <tr><td>Percent Added in Final</td><td><input type="text" name="percentadd" value="<%=jb.getPerAdd()%>" onkeypress="return checkNumeric();"></td></tr>
    <tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
    </table>
    </form>
        </td></tr></table>        
</td></tr><tr><td valign="bottom">
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
