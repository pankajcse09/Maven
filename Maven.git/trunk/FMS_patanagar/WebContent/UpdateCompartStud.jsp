<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>

   <%!
      Connection con=null;
      PreparedStatement psmt1=null;
      PreparedStatement psmt2=null;
      PreparedStatement psmt3=null;
      Statement stmt=null;
      ResultSet rs1=null;
      ResultSet rs2=null;
      ResultSet rs3=null;
      ResultSet rs=null;
      %>
   <% 
      String ud="";
      String yr="";
      String ext="";
      String mx="";
      String pth="";
      String p="a";   
      if(p.equals("a")){
      pth="AdminMarksEnter.jsp";        
      }
      else{
      pth="EnterMarks.jsp";  
      }
      ArrayList ar1=new ArrayList();     
      ArrayList ar4=new ArrayList();
      
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      java.util.Date dt=new java.util.Date();
      String dts=sdf.format(dt);
             try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
          catch (Exception e) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + e.getMessage() + "</h5>");
          } 
          try{
           String qr3="select distinct dated from studinfo where TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4))) from studinfo) order by TO_DATE(dated,'dd/mm/yyyy')";   
           psmt3=con.prepareStatement(qr3);
           rs3=psmt3.executeQuery();
           if(rs3.next()){
           ud=rs3.getString("dated");    
           }
           if(ud==null){
           ud="";    
           }   
           String qr1="select distinct sessions from studinfo where status='C' and TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4)))-1 from studinfo)";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
            yr=rs1.getString("sessions");             
           }          
           String qr2="select deg_name from degree_details";
           psmt2=con.prepareStatement(qr2);
           rs2=psmt2.executeQuery();
           while(rs2.next()){
            ar4.add(rs2.getString("deg_name"));           
           }
          }   
          catch(SQLException se){
              out.println(se.getMessage());              
          }  
      finally{
          try{      
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}
           if(rs2!=null){rs2.close();}  
           if(stmt!=null){stmt.close();}
           if(psmt1!=null){psmt1.close();}
           if(psmt2!=null){psmt2.close();}
           if(con!=null){con.close();}
          }
          catch(SQLException se){
              out.println(se.getMessage());
          }
      }
   %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></SCRIPT>          
         <script language="javascript" src="/Exam/resolution.js"></script>
         
 <title>Home</title>
<base target="_parent">
<meta name="Microsoft Border" content="tlb, default">
        <title>Select</title>
        <script language="javascript"></script>
        </head>        
 <body bgcolor="white" onload="semester()">    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top" align="left"><font color="green"><b>Last Updated Date:<%=ud%></b></font></td><td valign="top" align="right"><font color="green"><b><%=dts%></b></font></td></tr> 
<tr><td valign="top">   
    <table width="100%" height="20"><tr><td></td></tr></table>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/StudCompartUpdate">
        <center><font color="#000080" size="3"><b>Update Academic Information with Compartment</b></font></center><br>
        <table align="center" border="0">  
            <tr><td><input type="hidden" name="dated" value="<%=dts%>"></td></tr> 
            <tr><td>Current Year</td><td align="left"><select name="yrs">                               
                <option value="<%=yr%>"><%=yr%>               
            </select></td></tr>   
            <tr><td>Degree</td><td align="right"><select name="deg">
                <% 
                   for(int i=0;i<ar4.size();i++){
                %>                  
                <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%>
                <%}%>
            </select></td></tr>            
            <tr><td align="center" colspan="2"><input type="submit" value="submit"></td></tr></table>           
       <table align="center"><tr><td><b><font color=red style="TimesRoman" size="2">
 <%
if((String)application.getAttribute("msg")!=null)
{ %>
<%=(String)application.getAttribute("msg")%>
<%}
application.removeAttribute("msg");
%>             
     </td></tr></table>        
    </form>   
 </td></tr></table>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</td></tr></table>
    </body>
</html>
