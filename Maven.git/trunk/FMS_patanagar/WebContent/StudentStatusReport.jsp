<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page language="java"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%!  
 Connection con=null; 
 PreparedStatement stmt1=null; 
 PreparedStatement stmt2=null;
 PreparedStatement stmt3=null;
 PreparedStatement stmt4=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
 ResultSet rs3=null;
 ResultSet rs4=null;
 %>
 <%
    List ar1=new ArrayList();
    List ar2=new ArrayList();
    List ar3=new ArrayList();    
    HashMap hm=new HashMap();    
    HashMap hm1=new HashMap();
    HashMap hm2=new HashMap();
    String nm="";
    String ss="";
    String dg="";
    String ssn="";
    String sts="";   
    String qr4="";
    if(request.getParameter("degree")!=null){ dg=request.getParameter("degree");}
    if(request.getParameter("session")!=null){ ssn=request.getParameter("session");}
    if(request.getParameter("status")!=null){ sts=request.getParameter("status");   
    }   
    if(sts.equals("P")){ss="Pass";}
    if(sts.equals("F")){ss="Fail";}
    if(sts.equals("C")){ss="Compartment";}
    if(sts.equals("D")){ss="Drop";}
   try{
    Dataconnectivity newsdc=new  Dataconnectivity();
    con=(Connection)newsdc.Dataconnect();
    } 
    catch(Exception e) 
       {
       out.println("<h4>Database Connection Problem.</h4>");
       e.printStackTrace();
          } 
    try{
      String qr1="select distinct sessions from studinfo";
      stmt1=con.prepareStatement(qr1);
      rs1=stmt1.executeQuery();
      while(rs1.next()){
      ar2.add(rs1.getString("sessions"));    
      }
      String qr2="select deg_name from degree_details";
      stmt2=con.prepareStatement(qr2);
      rs2=stmt2.executeQuery();
      while(rs2.next()){
       ar1.add(rs2.getString("deg_name"));   
      }
       String qr3="select stid,sfname,smname,slname from ex_studnt_reg where stid in (select studid from studinfo where sessions='"+ssn+"' and degree='"+dg+"' and status='"+sts+"' and (sem='2' or sem='4' or sem='6' or sem='8' or sem='10'))";
      stmt3=con.prepareStatement(qr3);
      rs3=stmt3.executeQuery();
      while(rs3.next()){
      ar3.add(rs3.getString("stid"));  
      if(rs3.getString("smname")!=null){
      nm=rs3.getString("sfname")+" "+rs3.getString("smname")+" "+rs3.getString("slname");
      }
      else{
      nm=rs3.getString("sfname")+" "+rs3.getString("slname");
      }
      hm1.put(rs3.getString("stid"),nm);
      }
      for(int i=0;i<ar3.size();i++){          
      qr4="select sem from studinfo where studid='"+ar3.get(i)+"' and sessions='"+ssn+"' and degree='"+dg+"' and status='"+sts+"' and (sem='2' or sem='4' or sem='6' or sem='8' or sem='10')"; 
      stmt4=con.prepareStatement(qr4);
      rs4=stmt4.executeQuery();
      while(rs4.next()){
      hm2.put(ar3.get(i),rs4.getString("sem"));    
      }
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
         
 <title>Home</title>
<base target="_parent"><link rel="stylesheet" type="text/css" href="/Exam/mystyle1.css">
<met<base target="_para name="Microsoft Theme" content="journal 1111, default">
<meta name="Microsoft Border" content="tlb, default">
        <title>Display Exam Schedule</title>                
    </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B"  align="center"><tr><td align="center">
<table width="100%" ><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">

<table width="100%" valign="top"><tr><td height="45" valign="top"></td></tr>
<tr><td valign="top"><center><h4><font color="#000080">Student Status</font></h4></center></td></tr></table>
    
<table width="100%" valign="top" ><tr><td width="100%" valign="top">
<form name="data" method="post" action="<%=request.getContextPath()%>/StudentStatusReport.jsp">
<table width="80%" align="center">
<tr><td valign="top" width="10%" align="right"><b>Degree:</b></td>
<td valign="top" width="30%">
<select name="degree">
 <%
for(int i=0;i<ar1.size();i++){
%> 
<option value="<%=ar1.get(i)%>"><%=ar1.get(i)%></option>
<%}%>
</select>
</td>
<td valign="top" width="10%" align="right"><b>Session:</b></td>
<td valign="top" width="30%">
<select name="session">
 <%
for(int i=0;i<ar2.size();i++){
%> 
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select>
</td>
<td valign="top" width="30%">
<select name="status">
<option value="P">Pass</option>
<option value="F">Fail</option>
<option value="C">Compartment</option>
<option value="D">Drop</option>
</select>
</td>
<td valign="top" width="15%"><input type="submit" value="submit"></td></tr></table>
</form>
</td></tr></table>
<hr>
 <table width="100%" align="center"><tr><td width="100%" height="20"></td></tr></table>
 <table width="60%" align="center"><tr><td width="36%"> 
   <%
    if(dg!=null){
    %>
    <font color="blue"><b><%=dg%></b></font>
   <%}%>    
 </td><td width="12%"><font color="blue"><b><%=ssn%></b></font></td><td width="12%"><font color="blue"><b><%=ss%></b></font></td></tr></table>        
    <%
        }
catch(SQLException e){
    out.println(e.getMessage());
}
 finally{
       try{
           if(rs1!=null){
               rs1.close();
           }
            if(rs2!=null){
               rs2.close();
           }
              if(rs3!=null){
               rs3.close();
           }
         if(stmt1!=null){
               stmt1.close();
           }
           if(stmt2!=null){
               stmt2.close();
           }
             if(stmt3!=null){
               stmt3.close();
           }
           if(con!=null){
               con.close();
           }
           
       }
       catch(SQLException e){
          out.println(e.getMessage()); 
       }
       }
%>  
<table width="60%" align="center" border="1">
<tr><th width="30%" align="center">Student ID</th><th width="60%" align="left">Name</th><th width="10%" align="left">Semester</th></tr>    
<%for(int j=0;j<ar3.size();j++){
%>
<tr><td width="30%" align="center"><%=ar3.get(j)%></td><td width="70%" align="left"><%=hm1.get(ar3.get(j))%></td><td width="70%" align="center"><%=hm2.get(ar3.get(j))%></td></tr>
<%}%>
</table>   
</td></tr></table>
<br>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</td></tr></table>
    </body>
</html>