<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

  <%
    response.setHeader("Cache-Control","no cache");  
    JavaBean jb=new JavaBean();   
    MyMethods mm=new MyMethods(); 
     int stssn=0;
     int endssn=0;
     String etype="";
     String clas="";
     ArrayList ar1=new ArrayList();     
     ar1=(ArrayList)mm.retriveAllClass();     
     if(request.getAttribute("jbean")!=null){
     jb=(JavaBean)request.getAttribute("jbean");
     stssn=jb.getFrom();
     endssn=jb.getTo();
     etype=jb.getExtype();
     clas=jb.getClas();
    }  
   %>

<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
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
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Display Fine Record</u></font></center></td></tr></table>
    <form  method="post" action="<%=request.getContextPath()%>/dispfinerec.do">
        
 <table align="center" width="100%" cellpadding="2" cellspacing="0" height=450>         
    </td></tr>
    <tr><td valign="top"> 
<table>
    <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %> 
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
<tr><td><font color="red" size="2">Please enter the Session</font></td></tr>


            <tr><td>Session
            
            <select name="Syear">
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
            <select name="Eyear">
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
            </td><td><input type="submit" value="Display"></td></tr> 
 
</table>
    </form>

  <form name="formfine" >
<table border="1" width="80%" align="center"> 
 <tr>
<td><font size="2"><b>Session</b></font></td>
<td><font size="2"><b>Registration Number</b></font></td>
<td><font size="2"><b>FromDate</b></font></td>
<td><font size="2"><b>ToDate</b></font></td>
<td><font size="2"><b>Fee Submitted On</b></font></td>
<td><font size="2"><b>fine</b></font></td>
</tr>
       
       <%  
       Integer totfine=(Integer)request.getAttribute("totfine"); 
        %>
      
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
  
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>

<tr><td><%=seo.getSyear()%>-<%=seo.getEyear()%></td>
<td><%=seo.getRegisnum()%></td>
<td><%=seo.getTodate()%></td>
<td><%=seo.getFromdate()%></td>
<td><%=seo.getFeesubdate()%></td>
<td><%=seo.getPfine()%></td>
</tr>
       
       <%
   } }%>
</table>
   <table align="right" border="0" >
       <%// if(totfine==null)
       //{ totfine=0;
      // }%>
       <tr><td><b>Total Fine Paid:</b></td><td><%=totfine%></td><td width="100"></td></tr>
   </table></td></tr>
       <%
   }catch(Exception e)
       {}%>
   </td></tr></table>
</form>   
  </td></tr></table>
  
    <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    
    </body>
</html>
