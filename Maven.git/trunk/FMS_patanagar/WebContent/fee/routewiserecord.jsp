<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
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
if(document.update.route.value=="")
{
alert("Enter Route/Area");
document.update.route.focus();
return false;
}
if(document.update.syear.value=="")
{
alert("Enter Starting Year of Session ");
document.update.syear.focus();
return false;
}
if(document.update.eyear.value=="")
{
alert("Enter Ending Year of Session ");
document.update.eyear.focus();
return false;
}

}

 function Clickheretoprint()
 { 
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
  disp_setting+="scrollbars=yes,width=650, height=600, left=100, top=25"; 
  var content_vlue = document.getElementById("printit").innerHTML;   
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><style type="text/css">.table1{border-collapse:collapse}</style>'); 
   docprint.document.write('</head><body onLoad="self.print()"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus();
  }   
   </script>
       <style type="text/css">.t{border-collapse:collapse;
                 border:1px solid black
                   }</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body>
   
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Route Wise Student's Record</u></font></center></td></tr></table>

<form name="update" method="post" action="<%=request.getContextPath()%>/rwrec.do?disp=disp" onsubmit="return chkvalidate()">
<table cellpadding="0" cellspacing="0" width="100%" height=400><tr><td valign="top">  
<table>
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color=red size="2">Please enter the following detail</font></td></tr>
<tr>
<td><b>Route/Area:</b><select name="route">
    <option value="">-select-</option>
   
<% 
Connection cn=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    String route="";

try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
             
             String sql="select route from transportfee";
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
</select></td></tr>
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

</td><td><input type="submit" value="Display"></td></tr> 
</table>
<hr>
</form>
<form name="ud">
<%String rt=(String)request.getAttribute("rt");
String syear=(String)request.getParameter("syear");
String eyear=(String)request.getParameter("eyear");
if(rt==null)
{ rt="";
}
if(syear==null)
{
syear="";    
}
if(eyear==null)
{
eyear="";    
}
%>
   <div id="printit">
<table><td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></table>     
<table align="center"><tr><td><b><%=rt%></b></td></tr>
<tr><td><b><%=syear%>-<%=eyear%></b></td></tr></table>
 <table align="center" cellpadding="2" cellspacing="2" border="1"><tr>
 <td align="center"><b>SR.</b></td> <td align="center"><b>Scholars No.</b></td> <td align="center"><b>Student Name</b></td>
<td align="center"><b>Class</b></td> <td align="center"><b>Buscode</b></td> <td align="center"><b>Trip No.</b></td>
 </tr>
<% 
   int k=0;
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
<tr><td><%=++k%></td><td><%=seo.getSrnum()%></td><td><%=seo.getSname()%></td>
<td><%=seo.getClasses()%>-<%=seo.getSection()%></td><td><%=seo.getBuscode()%></td>
<td><%=seo.getTripnum()%></td>
</tr>


  <%
   } }
   }catch(Exception e)
       {}%>
</form>   
  </td></tr></table>
   </div> 
   
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    </body>
</html>
