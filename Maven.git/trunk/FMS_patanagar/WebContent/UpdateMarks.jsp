<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.io.*,java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>   
<%@page import="schedule.*"%>  
<% 
   ArrayList ar=new ArrayList();
   ArrayList ar1=new ArrayList();
   HashMap hm1=new HashMap();
   HashMap hm2=new HashMap();
   HashMap hm3=new HashMap();
   
   JavaBeanExam jb=new JavaBeanExam();
   try{  
   if(request.getAttribute("jbean")!=null){
    jb=(JavaBeanExam)request.getAttribute("jbean");   
    ar=(ArrayList)jb.getSubList();
    hm1=(HashMap)jb.getMarksType();
    ar1=(ArrayList)jb.getRowidList();      
    hm2=(HashMap)jb.getStudListMap();
    hm3=(HashMap)jb.getMarksList();
    }
   %>
    <html>
    <head>  
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>        
     <script language="javascript"></script>
    </head>
    <body>     
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><%@include file="/toplook.jsp"%></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr>   
<tr><td valign="top">
    <table width="100%" height="500" border="1" valign="top"><tr>
    <td width="20%" valign="top">
     <form method="post" action="<%=request.getContextPath()%>/UpdateMarksAct.do?method=updateMarksAction">
     <input type="hidden" name="sessions" value="<%=jb.getSessions()%>"> 
     <input type="hidden" name="classes" value="<%=jb.getClasses()%>">
     <input type="hidden" name="section" value="<%=jb.getSection()%>">
     <input type="hidden" name="examtype" value="<%=jb.getExamType()%>">    
     <table align="center" border="1">
      <tr><td>Subject</td><td align="right"><select name="subject">
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
            </td></tr> 
       <%if(!jb.getExamType().equals("UNIT TEST ONE") && !jb.getExamType().equals("UNIT TEST TWO")){%>    
       <tr><td>&nbsp;</td><td>
        <select name="exam">
        <%if(!jb.getExam().equals("")){%>
        <option value="<%=jb.getExam()%>"><%=jb.getExam()%>
        <%}%>
       <%if(!jb.getExam().equals("THEORY")){%>
       <option value="THEORY">THEORY</option>
       <%}if(!jb.getExam().equals("PRACTICAL")){%>  
       <option value="PRACTICAL">PRACTICAL</option>
       <%}if(!jb.getExam().equals("MCQ")){%>
       <option value="MCQ">MCQ</option>
       <%}%>
      </select>
      </td></tr> 
      <%}%>
           <tr><td align="right" colspan="2"><input type="submit" value="submit"></td></tr>
        </table>        
     </form>   
    </td>
    <td width="60%" valign="top">
    <hr color="green">
    <center><table border="0" width="100%" valign="top">
    <tr><td align="left" valign="top"><b>Session:</b>&nbsp;<%=jb.getSessions()%></td>
    <td align="left"><b>Class:</b>&nbsp;<%=jb.getClasses()%></td>
    <td align="left"><b>Section:</b>&nbsp;<%=jb.getSection()%></td></tr>
    <tr><td align="left"><b><%=jb.getExamType()%></b></td><td align="left" colspan="2"><b>Subject:</b>&nbsp;<%=jb.getSubject()%></td></tr>
    </table></center>
     <hr color="green">  
<%
if((String)request.getAttribute("msg")!=null){
out.println("<center><font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font></center>");
}
%>
<table width="60%" border="1" style="border-collapse:collapse">
<tr><td><b>SR No.</b></td>
<%if(jb.getExamType().equals("UNIT TEST ONE") || jb.getExamType().equals("UNIT TEST TWO")){%>
<%if(!hm1.get("unittest").toString().equals("0")){%><td>Marks(<%=hm1.get("unittest")%>)</td><%}%>
<%}else{%>
<%if(!hm1.get(jb.getExam()).toString().equals("0")){%><td><b><%=jb.getExam()%>(<%=hm1.get(jb.getExam())%>)</b></td><%}%>
<%}%>
<td>&nbsp;</td>
</tr>
<%for(int i=0;i<ar1.size();i++){%>
<tr><td><input type="hidden" name="rid<%=i%>" value="<%=ar1.get(i)%>"><b><%=hm2.get(ar1.get(i))%><input type="hidden" name="srn<%=i%>" value="<%=ar1.get(i)%>"></b></td>
<%if(jb.getExamType().equals("UNIT TEST ONE") || jb.getExamType().equals("UNIT TEST TWO")){%>
<%if(!hm1.get("unittest").toString().equals("0")){%><td><font color="blue" size="3"><%=hm3.get(ar1.get(i))%></font></td><%}%>
<%}else{%>
<%if(!hm1.get(jb.getExam()).toString().equals("0")){%><td><font color="blue" size="3"><%=hm3.get(ar1.get(i))%></font></td><%}%>
<%}%>
<td><a href="<%=request.getContextPath()%>/SelectStudentAct.do?method=selectStudentAction&exam=<%=jb.getExam()%>&rid=<%=ar1.get(i)%>"><font color="blue"><u>Update</u></font></a></td>
</tr>
<%}%>
</table>
</td></tr></table>    
  </td></tr></table></td></tr> 
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</table>
</body>
</html>
<%}catch(NullPointerException ne){}%>
