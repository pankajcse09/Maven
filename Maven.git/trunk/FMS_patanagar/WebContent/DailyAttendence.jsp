<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClassAttend.*,java.util.*,Beans.JavaBean,java.text.*"%>

   <%  
   response.setHeader("Cache-Control","no cache");    
   char ch;
   int k=0;
   JavaBean jb=new JavaBean();   
   String dt1="";
   int stssn=0;
   int endssn=0;
   String clas="";  
   String sec="";  
   java.util.Date dt=new java.util.Date();
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
   String dst=sdf.format(dt);   
    if(request.getParameter("dated")!=null){
    dt1=(String)request.getParameter("dated");    
   }
   if(request.getParameter("from")!=null){
    stssn=Integer.parseInt(request.getParameter("from").toString());    
   }
   if(request.getParameter("to")!=null){
    endssn=Integer.parseInt(request.getParameter("to").toString());    
   }
   if(request.getParameter("class")!=null){
   clas=request.getParameter("class").toString();   
    }  
   if(request.getParameter("section")!=null){
   sec=request.getParameter("section").toString();   
    }
   ArrayList ar1=new ArrayList();
   ArrayList ar2=new ArrayList();
   MyMethodsAttend mm=new MyMethodsAttend();     
   ar1=(ArrayList)mm.retriveAllClass(); 
   ar2=(ArrayList)mm.selectStudSec(stssn,clas,sec,dt1);   
   %>
<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>  
        <script language="javascript" src="<%=request.getContextPath()%>/calendarDateInput.js"></script>       
        <title>School Management System</title>
    </head>
    <body>
    <table width="800" class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">
 <tr><td><%@include file="/toplook.jsp"%></td></tr>
 <tr><td valign="top">  
 <table height="330" align="center" width="100%" border="0">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">
     <table width="100%" align="center"><tr><td width="100%" align="center"><font color="#34282C" size="4"><b>Student Daily Attendence</b></font></td></tr></table>
    <hr>    
    <table><tr><td><font color="#34282C" size="4"><b>Dated: <%=dst%></b></font></td></tr></table>     
    <hr>
         <form name="f1" method="post" action="<%=request.getContextPath()%>/DailyAttendence.jsp">       
         <table border="1" class="t" align="center">
         <tr><td colspan="4"><table><tr><td>For Date:</td><td><script>DateInput('dated',true,'dd/mm/yyyy')</script></td></tr></table></td></tr>     
         <tr><td>Session
           <select name="from">              
             <%if(stssn!=0){%>
             <option value="<%=stssn%>"><%=stssn%></option>
             <%}
             for(int i=2000;i<2020;i++){
              if(i==stssn){continue;}   
             %>  
             <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
             <select name="to">              
             <%if(endssn!=0){%>
             <option value="<%=endssn%>"><%=endssn%></option>
             <%}
             for(int i=2001;i<2021;i++){
              if(i==endssn){continue;}   
             %>  
             <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
            </td>
           <td>Class<select name="class">
           <% if(!clas.equals("")){%>
                 <option value="<%=clas%>"><%=clas%></option>
                 <%}%>    
                <%for(int i=0;i<ar1.size();i++){
                 if(clas.equals(ar1.get(i).toString())){continue;}
                 %>
                <option value="<%=ar1.get(i).toString()%>"><%=ar1.get(i).toString()%></option>
                <%}%>
       </select></td>
           <td>Section<select name="section">
           <% if(!sec.equals("")){%>
                 <option value="<%=sec%>"><%=sec%></option>
                 <%}   
        for(int i=65;i<75;i++){
        if(sec.equals(new Character((char)i).toString())){continue;}
         ch=(char)i;
        %> 
         <option value="<%=ch%>"><%=ch%></option>   
         <%}%>     
       </select></td>
         <td><input type="submit" value="Submit"></td></tr></table>
         </form>
         <hr color="green">  
    <form name="f2" method="post" action="DailyAttendAction.do?method=dailyAttendence">  
    <input type="hidden" name="dated" value="<%=dt1%>">    
    <input type="hidden" name="from" value="<%=stssn%>">
    <input type="hidden" name="to" value="<%=endssn%>">
    <input type="hidden" name="class" value="<%=clas%>">
    <input type="hidden" name="section" value="<%=sec%>">
    <table align="center" width="40%"><tr><td>
    <%if(request.getAttribute("msg")!=null){%>
    <font color="red"><b><%=request.getAttribute("msg")%></b></font>   
    <%}%>       
    <table width="100%" border="1" class="t" align="center">         
    <tr><td width="25%" align="center"><b>SNo</b></td><td width="25%" align="center"><b>Student Name</b></td><td width="25%" align="center"><b>Attendence</b></td></tr>
     <%for(int i=0;i<ar2.size();i++){%>    
     <tr><td align="center"><%=++k%></td>
     <td align="left"><%=ar2.get(i)%><input type="hidden" name="stu<%=i%>" value="<%=ar2.get(i)%>"></td>
     <td align="center"><select name="sts<%=i%>"> 
     <option value="P">P</option>
     <option value="A">A</option>
     </select></td></tr>     
     <%}%>
     <tr><td colspan="4" align="center"><input type="submit" value="Submit"></td></tr>
     </table>
     </td></tr></table>
     </form>
     </td></tr></table></td></tr>       
     <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>   
    </body>
</html>
