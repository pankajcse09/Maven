<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*,ActionClass.MyMethods,Beans.JavaBean"%>
<%@page import="ActionClass.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="java.sql.*"%>
<% 
  response.setHeader("Cache-Control","no cache");   
 int p=0;
 int stssn=0;
 int endssn=0;
 String mon="";
 String clas="";
JavaBean jb=new JavaBean();
JavaBean jb1=new JavaBean();
ArrayList ar=new ArrayList();
ArrayList ar1=new ArrayList();
HashMap hm=new HashMap();
MyMethods mm=new MyMethods();
hm=(HashMap)mm.months();
ar=(ArrayList)mm.retriveAllClass();
if(request.getAttribute("arr")!=null){
ar1=(ArrayList)request.getAttribute("arr");    
}
if(request.getAttribute("jbean")!=null){
jb1=(JavaBean)request.getAttribute("jbean");
stssn=jb1.getFrom();
endssn=jb1.getTo();
mon=jb1.getMonth();
clas=jb1.getClas();
}
%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>School Management System</title>
     <script type="text/javascript" src="calendarDateInput.js"></script>  
     <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
     <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
     <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
     <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
     <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>  
    </head>
    <body>
 
  <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>List Of Pending Fee</u></font></center></td></tr></table>
    <table width="100%" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC" height=450> 
 <tr><td height="20"></td></tr>      
 <tr><td valign="top">
 <form name="f1" method="post" action="StudNotSubmitFee.do?method=studName">
    <table align="center" width="100%">
         <%
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    String Syear1="";
    int Syr=0;
    int Eyr=0;    
try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         
           String sql="select DATE_FORMAT(current_date,'%Y')as year";
             
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sql);
         
        rs.next();
          Syear1=(String)rs.getString("year"); 
          Syr=Integer.parseInt(Syear1);  
             Eyr=Syr+1;
         
       
} catch(Exception e){}%> 
    <tr><td>Session            
            <select name="syear">
                 <option value="<%=Syr%>"><%=Syr%></option>
              <%if(stssn!=0){%>
             <option value="<%=stssn%>"><%=stssn%></option>
             <%}
             for(int i=2000;i<2200;i++){
              if(i==stssn){continue;}   
             %>  
             <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>   
            <select name="eyear">
                 <option value="<%=Eyr%>"><%=Eyr%></option>
             <%if(endssn!=0){%>
             <option value="<%=endssn%>"><%=endssn%></option>
             <%}
             for(int j=2001;j<=2200;j++){
             if(j==endssn){continue;}     
             %> 
             <option value="<%=j%>"><%=j%></option>
             <%}%>                 
            </select> 
            </td>
     <td>Month<select name="months">
      <%if(!mon.equals("")){%>
      <option value="<%=mon%>"><%=hm.get(new Integer(mon))%></option>
      <%}    
    for(int i=1;i<=hm.size();i++){
    if(mon.equals(new Integer(i).toString())){continue;}  
    Integer in=new Integer(i);    
    %>    
    <option value="<%=in%>"><%=hm.get(in)%></option>        
    <%}%>
    </select>
    </td><td>Class<select name="classes">
      <%if(!clas.equals("")){%>
      <option value="<%=clas%>"><%=clas%></option>
      <%}
      if(!clas.equals("All")){%>        
    <option value="All">All</option> 
    <%}
    for(int j=0;j<ar.size();j++){ 
    if(clas.equals(ar.get(j).toString())){continue;} 
    %>    
    <option value="<%=ar.get(j)%>"><%=ar.get(j)%></option>        
    <%}%>   
    </select>
    </td>
    <td><input type="submit" value="Submit"></td></tr>    
    </table>  
    <hr>
    </form> 
  <%if(request.getAttribute("arr")!=null){%>
   <table align="center" width="60%" border="1">
    <tr><tr><td>SNo.</td><td>Regist. No.</td><td>Name</td></tr></tr> 
    <%
    for(int k=0;k<ar1.size();k++){
    jb=(JavaBean)ar1.get(k);
    %>
    <tr><td><%=++p%></td><td><%=jb.getRegisno()%></td><td><%=jb.getStudname()%></td><td><%=jb.getClas()%></td></tr>
   <%}%>
   </table>
   <%}%>
   </form> 
   </td></tr></table>
</td></tr></table>

  <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>
