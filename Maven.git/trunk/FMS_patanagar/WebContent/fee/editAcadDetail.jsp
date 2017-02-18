<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="java.util.*"%>
<%@page import="EO.SchoolEO"%>

 <%
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
     try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     
 String sqlv="select year(current_date) as year";
       stmt=cn.createStatement();
       rs=stmt.executeQuery(sqlv);
       rs.next();
       String Syear1=(String)rs.getString("year");
       int Syear=Integer.parseInt(rs.getString("year"));
       int Eyear=Syear+1;
%>  
<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
   <script language="javascript">
       
 function chkvalidate()
{
if(document.update.classes.value=="")
{
alert("Please Enter Class");
document.update.classes.focus();
return false;
}
if(document.update.section.value=="")
{
alert("Please Enter Section");
document.update.section.focus();
return false;
}
if(document.update.house.value=="")
{
alert("Please Enter House name");
document.update.house.focus();
return false;
}
if(document.update.head.value=="")
{
alert("Please Enter Head on which concession is applied");
document.update.head.focus();
return false;
}
if(document.update.concession.value=="")
{
alert("Please Enter Percent of Concession applying");
document.update.concession.focus();
return false;
}
}
   </script>
    
    </head>
    <body>
  
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%" align="right"><a href="<%=request.getContextPath()%>/regis.jsp"><font color="#000080">Home</font></a></td></tr>      
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Enter/Edit Academic Detail</u></font></center></td></tr></table>

<form name="update" action="<%=request.getContextPath()%>/editacdet.do?enter=enter" method="post" onsubmit="return chkvalidate()">
 <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>   
<% 
try
{ 
ArrayList arr1=(ArrayList)request.getAttribute("arr");  
 String sr=(String)request.getAttribute("sr");
 String sy=(String)request.getAttribute("syear");

SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
   
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>
<tr><td valign="top">
<table width="15%" align=center><tr><td><b><%=seo.getSyear()%>-<%=seo.getEyear()%></b></td></tr></table>
</td></tr>
<tr><td valign="top">
  <table width="100%" cellpadding="0" cellspacing="0" border="1" align="center">
<tr><td>     
<table width="100%" cellpadding="1" cellspacing="0"  align="center" >
<input type=hidden name=syear value="<%=seo.getSyear()%>">
<input type=hidden name=eyear value="<%=seo.getEyear()%>">
<tr><td><img src="<%=request.getRealPath("/image")%>\\pic.jpg" height="100" width="85"></td></tr>
<tr>
<td><b>SR.Number:</b></td><td><%=seo.getSrnum()%></td> 

<input type=hidden name="srnum" value="<%=seo.getSrnum()%>">
</tr>   
<tr>
<tr><td><b>UploadNewPic:</b></td><td><input type="file" name="pic" value=""></td></tr>
<td><b>Name:</b></td><td><%=seo.getSname()%></td>
<input type=hidden name="sname" value="<%=seo.getSname()%>">
</tr>   
<tr> 
<td><b>Gender:</b></td><td><%=seo.getGender()%></td> 
<input type=hidden name="gender" value="<%=seo.getGender()%>">
</tr>
<tr>
<td><b>DOB:</b></td><td><%=seo.getDob()%></td>
<input type=hidden name="dob" value="<%=seo.getDob()%>">
</tr>
<tr>
<td><b>DOJ:</b></td><td><%=seo.getDoj()%></td>
<input type=hidden name="doj" value="<%=seo.getDoj()%>">
</tr>

 
<tr><td><b>Class:</b></td><td><select name="classes">
    <option value="<%=seo.getClasses()%>"><%=seo.getClasses()%></option>      
<%
    
    Statement stmt2=null;
    ResultSet rs2=null;
    String classes="";
    String route="";

try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         String sq="select class from classes";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sq);
             while(rs2.next())
             {
             classes=(String)rs2.getString("class"); 
%>
<option value="<%=classes%>"><%=classes%></option>
<%}
stmt2=null;
rs2=null;
%>
</select></td>
<td><b>Section:</b></td><td><select name="section">
                        <option value="<%=seo.getSection()%>"><%=seo.getSection()%></option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="F">F</option>
                        <option value="G">G</option>
                        <option value="H">H</option>
                        <option value="I">I</option>
                        <option value="J">J</option>
                        <option value="K">K</option>
                                              
</td></tr>
<tr>
<td><b>House:</b></td><td><input type="text" name="house" value="<%=seo.getHouse()%>"></td></tr>          
           

<td><b>Route/Area:</b></td><td><select name="route">
    <option value="<%=seo.getRoute()%>"><%=seo.getRoute()%></option>
   
<%         String sql="select route from transportfee";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sql);
             while(rs2.next())
             {
             route=(String)rs2.getString("route"); 
%>
<option value="<%=route%>"><%=route%></option>
<%}
stmt2=null;
rs2=null;
}catch(Exception e)
       {}%>
</select></td>
<td><b>Bus Code:</b></td><td><input type="text" value="<%=seo.getBuscode()%>" name="buscode"></td>
<td><b>TripNo.:</b></td><td><input type="text" value="<%=seo.getTripnum()%>" name="tripnum"></td>
</tr>       
<tr>
<td><b>Apply Concession On:</b></td><td><select name="head">
    <option value="<%=seo.getHeads()%>"><%=seo.getHeads()%></option>
    <option value=""></option>
    <option value="NoConcession">No Concession</option>
    <option value="TotalFee">Total Fee</option>
   
<%    String heads="";
try{
            String sql="select heads from feeheads";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sql);
             while(rs2.next())
             {
             heads=(String)rs2.getString("heads"); 
%>
<option value="<%=heads%>"><%=heads%></option>

<%}
stmt2=null;
rs2=null;
}catch(Exception e)
       {}%>
</select></td>
<td><B>Percent of Concession:</b></td><td><input type="text" name="concession" value="<%=seo.getConcession()%>">%</td>
</tr> 
  </table>
  </td></tr>
  <tr><td><table align="center"><tr><td><input type="submit" value="Submit"></td></tr></table></td></tr>
</table>
</td></tr>  
  <%
   } }
   }catch(Exception e)
       {}%>
</form>   
  </td></tr></table>
 
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    
    </body>
</html>
