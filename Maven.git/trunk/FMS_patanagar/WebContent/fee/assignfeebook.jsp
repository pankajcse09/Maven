<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="java.util.*"%>
<%@page import="EO.SchoolEO"%>
   
<html>
    <head>
     <title>JPS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>      
    </head>
            <script language="JavaScript">

                function validate()
{
if(document.ent.classes.value=="")
{
alert("Please Enter Class");
document.ent.classes.focus();
return false;
}
if(document.ent.section.value=="")
{
alert("Please Enter Section");
document.ent.section.focus();
return false;
}
if(document.ent.syear.value=="")
{
alert("Please Enter Starting Year of Session");
document.ent.syear.focus();
return false;
}
if(document.ent.eyear.value=="")
{
alert("Please Enter Ending Year of Session");
document.ent.eyear.focus();
return false;
}
}


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
if(document.update.route.value=="")
{
alert("Please Enter Route Area");
document.update.route.focus();
return false;
}
if(document.update.buscode.value=="")
{
alert("Please Enter Buscode");
document.update.buscode.focus();
return false;
}
if(document.update.tripnum.value=="")
{
alert("Please Enter Trip Number");
document.update.tripnum.focus();
return false;
}
if(document.update.concession.value=="")
{
alert("Please Enter Concession Type");
document.update.concession.focus();
return false;
}
}
     </script>
    <body>
      
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u><b>Assign FeeBook</b></u></font></center></td></tr></table>
    <form  method="post" name="ent" action="<%=request.getContextPath()%>/dasfb.do?display=display" onsubmit="return validate()">
  
<table width="100%" align="center">
    
<tr><td valign="top"><b>Class:</b><select name="classes">
    <option value="">-select-</option>
<% 
    Connection cn=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    String classes="";
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
<%}}catch(SQLException e){}
stmt2=null;
rs2=null;%>
</select>
<b>Section:</b><select name="section">
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
                       
 </td></tr>

<tr>  <td><b>Session:</b><select name="syear">
 
           <option value="">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select>
     <select name="eyear"> -
 
           <option value="">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select></td>
</tr>
<td><input type="submit" value="Display"></td></tr>
</table>
 </td></tr>
<tr><td><hr></td></tr>
 
    </form>
<tr><td valign="top" height=20></td></tr>
  <form name="update" action="<%=request.getContextPath()%>/entfeb.do?uprofile=uprofile" method="post" onsubmit="return chkvalidate()">

      <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<% 
try
{ 
ArrayList arr1=(ArrayList)request.getAttribute("arr");  
 

SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
   
   <% for(int i=0;i<1;i++)
   { seo=(SchoolEO)arr1.get(i);
%>
<tr><td valign="top">

<table width="15%" align=center><tr><td><b><%=seo.getSyear()%>-<%=seo.getEyear()%></b></td></tr></table>
<input type=hidden name="classes" value="<%=seo.getClasses()%>">
<input type=hidden name="section" value="<%=seo.getSection()%>">
</td></tr>
<%
   } }
   }catch(Exception e)
       {}%>
       
<tr><td valign="top">
<table border=1 align=center><tr><td><b>SR.No.</b></td><td><b>Class</b></td> 
      <td><b>School FeeBook No.</b></td><td><b>Transport FeeBook No.</b></td></tr>
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


<input type=hidden name=syear value="<%=seo.getSyear()%>">
<input type=hidden name=eyear value="<%=seo.getEyear()%>">
<tr>
<td><%=seo.getSrnum()%></td> 
<input type=hidden name="srnum<%=i%>" value="<%=seo.getSrnum()%>">
<td><%=seo.getClasses()%>-<%=seo.getSection()%></td>
<input type=hidden name="classes<%=i%>" value="<%=seo.getClasses()%>">
<input type=hidden name="section<%=i%>" value="<%=seo.getSection()%>">
<td><input type="text" value="" name="sfbnum<%=i%>"></td>
<td><input type="text" value="" name="tfbnum<%=i%>"></td></tr> 


  <%
   } }
   }catch(Exception e)
       {}%>
       </table>
       </td></tr>
<tr><td><table align="center"><tr><td><input type="submit" value="Submit Detail"></td></tr></table></td></tr>
</table>
</td></tr>  

</form>   
  </td></tr></table>
  
     <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>      
    </body>
</html>
