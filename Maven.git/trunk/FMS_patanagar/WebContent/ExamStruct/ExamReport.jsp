<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClassAttend.*,java.util.*,Beans.JavaBean,java.text.*"%>
<%@page import="schedule.*"%> 
   <%  
   response.setHeader("Cache-Control","no cache");   
   java.util.Date dt=new java.util.Date();
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
   String dst=sdf.format(dt);  
   char ch;
   int k=0;
   String ssn="";
   String clas="";  
   String sec="";  
   String sub=""; 
   ArrayList ar1=new ArrayList();
   ArrayList ar2=new ArrayList();
   ArrayList ar3=new ArrayList(); 
   DataObject1 dataobj=new DataObject1();  
   DataObject2 dobj2=new DataObject2();  
   JavaBeanExam jb=new JavaBeanExam();  
   MyMethodsDyna md=new MyMethodsDyna(); 
   MyMethods mym=new MyMethods(); 
   if(request.getAttribute("jbean")!=null){
   jb=(JavaBeanExam)request.getAttribute("jbean");    
   }     
   MyMethods mm=new MyMethods();     
   ArrayList ar4=(ArrayList)mm.allClasses();      
   //JavaBeanExam jb1=(JavaBeanExam)dataobj.retriveSubjects(jb);   
   //ArrayList ar=(ArrayList)jb.getSubList();
   ArrayList ar5=(ArrayList)jb.getExamTypeList();   
   //ArrayList ar6=(ArrayList)jb.getStudList();
   ar1=(ArrayList)jb.getSubList();
   ar2=(ArrayList)jb.getStudList();  
   %>
<html>
    <head>
      <style type="text/css">
     .t{border-collapse:collapse},
     .font{font-size:12}
      </style>
    <script language="javascript" src="<%=request.getContextPath()%>/UnitTest/printData.js"></script>     
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>  
 <script language="javascript">
   function submitData(){
   document.f1.method="post";
   document.f1.action="<%=request.getContextPath()%>/ExamReportAct.do?method=retriveExamType1";
   document.f1.submit();
   }     
   function submit1(){  
   document.f1.method="POST";
   document.f1.action="<%=request.getContextPath()%>/ExamReport.jsp";
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
<tr><td width="100%"><table align="left" width="100%"><tr><td width="100%" align="left" valign="top"><a href="javascript:Clickheretoprint('printit')"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></tr></table></td></tr>       
<tr><td valign="top">
    <table width="100%" align="center"><tr><td width="100%" align="center"><font color="#34282C" size="4"><b>Report</b></font></td></tr></table>
    <hr>    
    <table><tr><td><font color="#34282C" size="4"><b>Dated: <%=dst%></b></font></td></tr></table>     
    <hr>
         <form name="f1" method="post" action="<%=request.getContextPath()%>/ExamReportAct.do?method=examMarks">       
         <table border="1" class="t" align="center"><tr>
         <td>Session:<select name="sessions" onchange="submitData()"> 
          <% if(!jb.getSessions().equals("")){%>
          <option value="<%=jb.getSessions()%>"><%=jb.getSessions()%></option>
          <%}else{%>
          <option value="">Select</option>
          <%}for(int i=2000;i<=2020;i++){
         if(jb.getSessions().equals(i+"-"+(i+1))){continue;}
         %>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
      </select></td>
           <td>Class:<select name="classes" onchange="submitData()">
           <% if(!jb.getClasses().equals("")){%>
           <option value="<%=jb.getClasses()%>"><%=jb.getClasses()%></option>
           <%}else{%>
           <option value="">Select</option>
           <%}for(int i=0;i<ar4.size();i++){
           if(jb.getClasses().equals(ar4.get(i).toString())){continue;}
            %>
            <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>
            <%}%>
            </select></td>
           <td>Section<select name="section">
           <% if(!jb.getSection().equals("")){%>
           <option value="<%=jb.getSection()%>"><%=jb.getSection()%></option>
           <%}for(int i=65;i<74;i++){
         if(jb.getSection().equals(new Character((char)i).toString())){continue;}
         ch=(char)i;
        %> 
         <option value="<%=ch%>"><%=ch%></option>   
         <%}%>     
       </select></td>     
           <td>Exam Type:</td><td>
           <select name="examtype">  
           <%if(!jb.getExamType().equals("")){%>
           <option value="<%=jb.getExamType()%>"><%=jb.getExamType()%></option>
           <%}else{%> 
           <option value="">Select</option>
           <%}for(int i=0;i<ar5.size();i++){
           if(jb.getExamType().equals(ar5.get(i).toString())){continue;}
           %>
           <option value="<%=ar5.get(i)%>"><%=ar5.get(i)%></option>
           <%}%>
           </select></td>
         <td><input type="submit" value="Submit"></td></tr></table>
         </form>         
         <hr color="green">         
    <table align="center" width="100%"><tr><td>    
    <div id="printit">   
    <table align="center" width="100%" style="border-collapse:collapse">
     <tr><td width="100%" align="center"><font style="font-size:15"><b><%@include file="/UnitTest/SchoolName.jsp"%></b><font></td></tr> 
     <tr><td width="100%" align="center"><b>MASTER CHART</b></td></tr> 
     </table> 
     <table align="center" width="100%" border="1" style="border-collapse:collapse">
     <tr><td width="4%" align="center" rowspan="2"><font class="font"><b>SNO</b></font></td><td width="8%" align="center" rowspan="2"><font class="font"><b>SRNO</b></font></td><td width="18%" align="center" rowspan="2"><font class="font"><b>NAME</b></font></td>
    <%
     double mt=0.0;  
     int z=0;   
     int m=0;     
     if(ar1.size()!=0){m=(50/ar1.size());}
     for(int i=0;i<ar1.size();i++){  
     //ArrayList ar7=(ArrayList)md.examDistribute(jb,ar1.get(i));  
     //z=ar7.size();
     %>    
     <td width="<%=m%>%" align="center"><font class="font"><b><%=ar1.get(i)%></b></font></td><%}%><td width="10%" align="center" rowspan="2"><font class="font"><b>Total</b></font></td><td width="10%" align="center" rowspan="2"><font class="font"><b>Percent</b></font></td></tr>
     <tr><%for(int i=0;i<ar1.size();i++){
     ArrayList ar6=(ArrayList)md.examDistribute(jb,ar1.get(i)); 
     for(int p=0;p<ar6.size();p++){
     mt=md.examDistMarks(jb,ar1.get(i),ar6.get(p));    
     if(mt==0.0){continue;}
     %>    
     <td width="<%=m%>%" align="center"><font class="font"><b><%=ar6.get(p)%></b></font></td><%}%>
     <%}%></tr>
     <%for(int j=0;j<ar2.size();j++){%> 
     <tr><td align="center"><font class="font"><%=++k%></font></td><td align="center"><font class="font"><%=ar2.get(j)%></font></td><td><font class="font"><%=md.retriveStudName1(ar2.get(j))%></font></td>
     <%for(int y=0;y<ar1.size();y++){
     ArrayList ar8=(ArrayList)md.examDistribute(jb,ar1.get(y));
     for(int p=0;p<ar8.size();p++){
     mt=md.examDistMarks(jb,ar1.get(y),ar8.get(p));    
     if(mt==0.0){continue;}    
     if(md.examMarks(jb,ar2.get(j),ar1.get(y),ar8.get(p))==-1){%>
     <td align="center"><font class="font">A</font></td>
     <%}else{%>
     <%if(md.examMarks(jb,ar2.get(j),ar1.get(y),ar8.get(p))>=9){%>
     <td align="center"><font class="font"><%=md.examMarks(jb,ar2.get(j),ar1.get(y),ar8.get(p))%></font></td>
     <%}else{%>
     <td align="center" bgcolor="yellow"><font class="font"><%=md.examMarks(jb,ar2.get(j),ar1.get(y),ar8.get(p))%></font></td>
     <%}}%>     
     <%}}%>
     <td align="center"><font class="font"><%=md.examTotalMarks(jb,ar2.get(j))%></font></td>
     <td align="center"><font class="font"><%=md.examTotalPercent(jb,ar2.get(j))%></font></td>
     </tr>    
     <%}%>
     <tr><td colspan="3" align="center"><font class="font"><b>Total</b></font></td>
     <%for(int i=0;i<ar1.size();i++){
     ArrayList ar8=(ArrayList)md.examDistribute(jb,ar1.get(i));
     for(int p=0;p<ar8.size();p++){
     mt=md.examDistMarks(jb,ar1.get(i),ar8.get(p));    
     if(mt==0.0){continue;}  
     %>    
     <td align="center"><font class="font"><%=md.examTestTotal(jb,ar1.get(i),ar8.get(p))%></font></td>
     <%}}%><td></td><td></td></tr>     
     <tr><td colspan="3" align="center"><b>Appeared</b></td>
     <%for(int i=0;i<ar1.size();i++){
     ArrayList ar8=(ArrayList)md.examDistribute(jb,ar1.get(i));
     for(int p=0;p<ar8.size();p++){
     mt=md.examDistMarks(jb,ar1.get(i),ar8.get(p));    
     if(mt==0.0){continue;}  
     %>    
     <td align="center"><font class="font"><%=md.examTestAppear(jb,ar1.get(i),ar8.get(p))%></font></td>
     <%}}%><td></td><td></td></tr>     
     <tr><td colspan="3" align="center"><b>Pass</b></td>
     <%for(int i=0;i<ar1.size();i++){
     ArrayList ar8=(ArrayList)md.examDistribute(jb,ar1.get(i));
     for(int p=0;p<ar8.size();p++){
     mt=md.examDistMarks(jb,ar1.get(i),ar8.get(p));    
     if(mt==0.0){continue;}  
     %>    
     <td align="center"><font class="font"><%=md.examTestPass(jb,ar1.get(i),ar8.get(p))%></font></td>
     <%}}%><td></td><td></td></tr>     
     <tr><td colspan="3" align="center"><b>Fail</b></td>
     <%for(int i=0;i<ar1.size();i++){
     ArrayList ar8=(ArrayList)md.examDistribute(jb,ar1.get(i));
     for(int p=0;p<ar8.size();p++){
     mt=md.examDistMarks(jb,ar1.get(i),ar8.get(p));    
     if(mt==0.0){continue;}  
     %>    
     <td align="center"><font class="font"><%=md.examTestFail(jb,ar1.get(i),ar8.get(p))%></font></td>
     <%}}%><td></td><td></td></tr>
     </table>  
     </div>
     </td></tr></table>   
     </td></tr></table>  
    </td></tr><tr><td valign="bottom"><%@include file="/btmnavi.jsp"%></td></tr></table>
    </body>
</html>
