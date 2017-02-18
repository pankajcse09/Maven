<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>
<%@page import="java.util.*"%>

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
if(document.update.syear.value=="")
{
alert("Please Enter Staring Year of Session");
document.update.syear.focus();
return false;
}
if(document.update.eyear.value=="")
{
alert("Please Enter Ending Year of Session");
document.update.eyear.focus();
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
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Edit Academic Detail</u></font></center></td></tr></table>
   
<form  method="post" action="<%=request.getContextPath()%>/sfdbk.do?disp=disp">
<table cellpadding="0" cellspacing="0" width="100%" height=400><tr><td valign="top">  
<table>
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color=red size="2">Please enter the Session</font></td></tr>
<tr><td><input type="text" name="syear" size="5" value="">-<input type="text" name="eyear" size="5" value="">
<font color=red size="2">(dddd-dddd)</font></td></tr>

</td><td><input type="submit" value="Display"></td></tr> 
</table>
<hr>
</form>
<form name="update" action="<%=request.getContextPath()%>/editacdet.do?enter=enter" method="post" onsubmit="return chkvalidate()">
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
<tr><td valign="top">
<table width="15%" align=center><tr><td><b><%=seo.getSyear()%>-<%=seo.getEyear()%></b></td></tr></table>
</td></tr>
<tr><td valign="top">
  <table width="90%" cellpadding="0" cellspacing="0" border="1" align="center">
       <tr><td>     
            <table width="100%" cellpadding="1" cellspacing="0"  align="center">
<input type=hidden name=syear value="<%=seo.getSyear()%>">
<input type=hidden name=eyear value="<%=seo.getEyear()%>">
<tr>
<td><b>SR.Number:</b></td><td><%=seo.getSrnum()%></td> 
<input type=hidden name="srnum" value="<%=seo.getSrnum()%>">
</tr>   
<tr>
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
      
    Connection cn=null;
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
                        <option value="K">K</option></td>
                       
</tr>
<tr>
<td><b>House:</b></td><td><select name="house">
                        <option value="<%=seo.getHouse()%>"><%=seo.getHouse()%></option>
                        <option value="Gandhi">Gandhi House</option>
                        <option value="Tilak">Tilak House</option>
                        <option value="Nehru">Nehru House</option>
                        <option value="Subhash">Subhash House</option></td>
</tr>
 <tr>
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
<td><b>Concession:</b></td><td><select name="concession">
                        <option value="<%=seo.getConcession()%>"><%=seo.getConcession()%></option>
                        <option value="NoConcession">No Concession</option>
                        <option value="SchoolWard">School Ward</option>
                        <option value="Sibling">Sibling</option></td>
</tr> 
  </table>
       </td></tr>
       <tr><td><table align="center"><tr><td><input type="submit" value="Edit Academic Detail"></td></tr></table></td></tr>
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
