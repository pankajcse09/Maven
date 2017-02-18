<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>
   
<html>
    <head>
     <title>JPS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="calendarDateInput.js"></script>         
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
    <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
    <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>  
    
    
       <script language="javascript">
   
  function chkvalidate()
{
if(document.con.classes.value=="")
{
alert("Enter Class");
document.con.classes.focus();
return (false);
}

if(document.con.section.value=="")
{
alert("Enter Section");
document.con.section.focus();
return (false);
}
if(document.con.cby.value=="")
{
alert("Enter Collected By");
document.con.cby.focus();
return (false);
}
if(document.con.cfor.value=="")
{
alert("Enter Collected for");
document.con.cfor.focus();
return (false);
}

if(document.con.amount.value==""){
          alert("Please Enter Amount ");
          document.con.amount.focus();
          return false;
          }
          else{
          var k=validint(10);
          if(k==false){return false;}
          }
}
 </script>
 
    </head>
    <body>
       
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u><b>Enter Addtional Fee</b></u></font></center></td></tr></table>
  
   <form name="con" action="<%=request.getContextPath()%>/entadnfee.do?enter=enter" method="post" onsubmit="return chkvalidate()">
       
<table width=80% cellpadding="0" cellspacing="0" align="center" height=380>
    <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<%      
    Connection cn=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    String classes="";
    String Styear="";
    int Syear=0;
    int Eyear=0;

try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
             
             String sql1="select DATE_FORMAT(current_date,'%Y')as year";
             stmt1=cn.createStatement();
             rs1=stmt1.executeQuery(sql1);
             rs1.next();
             Styear=(String)rs1.getString("year"); 
             Syear = Integer.parseInt(Styear);    
             Eyear=Syear+1; %>
           
<tr><td valign="top">
<table width="15%" align=center><tr><td><b><%=Syear%>-<%=Eyear%></b></td></tr></table>
</td></tr>
<tr><td valign="top">
  <table width="90%" cellpadding="0" cellspacing="0" border="1" align="center">
       <tr><td>     
            <table width="100%" cellpadding="1" cellspacing="0"  align="center">
<input type=hidden name=syear value="<%=Syear%>">
<input type=hidden name=eyear value="<%=Eyear%>">
<tr>
<td align="left"><b>Date :</b></td>
<td align="left"><script>DateInput('feesubdate', true, 'dd/mm/yyyy')</script></td>    
<tr>
<tr><td><b>Class:</b></td><td><select name="classes">
    <option value="">-select-</option>      
              <%

             
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
}catch(SQLException e){}%>
</select></td>

<td><b>Section:</b></td><td><select name="section">
                        <option value="">-Select-</option>
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
                        <option value="K">K</option></td>
                       
</tr><td><b>Collected By:</b></td><td><input type="text" value="" name="cby"></td></tr>
<tr><td><b>Collected For:</b></td><td><input type="text" value="" name="cfor"></td></tr>
<tr><td><b>Amount:</b></td><td><input type="text" value="" name="amount"></td></tr>
</tr>       

  </table>
       </td></tr>
       <tr><td><table align="center"><tr><td><input type="submit" value="Submit"></td></tr></table></td></tr>
     </table>
</td></tr>  
 
</form>   
  </td></tr></table>
  </td></tr></table></td></tr>       
     <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>     
    </body>
</html>
