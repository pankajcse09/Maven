<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

  <%!

   Connection cn=null;
   Statement stmt=null;
   ResultSet rs=null;%> 

<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="calendarDateInput.js"></script>  
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>  
        
          <script language="javascript">
          function validate()
          {
        if(document.upsr.cls.value==""){
          alert("Please Enter Class ");
          document.upsr.cls.focus();
          return false;
          }
          else{
          var k=validint(0);
          if(k==false){return false;}
          }
        if(document.upsr.Syear.value==""){
          alert("Please Enter Starting Year of Session ");
          document.upsr.Syear.focus();
          return false;
          }
          else{
          var k=validint(1);
          if(k==false){return false;}
          }
        if(document.upsr.Eyear.value==""){
          alert("Please Enter Ending Year of Session  ");
          document.upsr.Eyear.focus();
          return false;
          }
          else{
          var k=validint(2);
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
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Display List Of Students</u></font></center></td></tr></table>
    <form  method="post" action="<%=request.getContextPath()%>/usrc.do" name="upsr" onsubmit="return validate()">
<table cellpadding="0" cellspacing="0" width="100%" height=450><tr><td valign="top">  
<table>
    <%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>  
<tr><td><font color="red" size="2">Please enter the following detail</font></td></tr>
<tr><td><B>Class:</b><input type="text" name="cls" size="15" value=""></td></tr>
<tr>  <td><b>Session:</b><select name="Syear">
 
           <option value="">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select>
     <select name="Eyear"> -
 
           <option value="">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select></td>
</tr>
<td><input type="submit" value="Display"></td></tr> 

</table>
    </form>
  <form name="form1" method="post" action="<%=request.getContextPath()%>/updatesrc.do">
      <table width="100%" align="center" >
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
      <tr><td><HR></td></tr>
      <tr><td  valign="top">
      <% int Syr=0;
         int Syear=0;
         int Eyr=0;
         int Eyear=0;
         int clas=0;
         int cl=0;
      String classes=(String)request.getParameter("cls");
      if(request.getParameter("cls")!=null){
             clas=Integer.parseInt(classes);  
             cl=clas+1;
      }   
      String Syear1=(String)request.getParameter("Syear");
      if(request.getParameter("Syear")!=null){
             Syr=Integer.parseInt(Syear1);  
             Syear=Syr+1;
      }           
       String Eyear1=(String)request.getParameter("Eyear");
       if(request.getParameter("Eyear")!=null){
           Eyr = Integer.parseInt(Eyear1);  
           Eyear=Eyr+1;
       } 
if(Syear1==null)
{Syear1="";}
if(Eyear1==null)
{Eyear1="";}
       

%>
<%
  if(classes==null)
{
classes="";
}
       
%>


 <table align="center">
     <tr><td align="left">List of Class <%=classes%></td></tr>
<tr><td align="center"><b><%=Syear%>-<%=Eyear%></b></td></tr>

<input type="hidden" name="Syear" value="<%=Syear%>">
<input type="hidden" name="Eyear" value="<%=Eyear%>">
<input type="hidden" name="PSyear" value="<%=Syear1%>">
<input type="hidden" name="PEyear" value="<%=Eyear1%>">
<input type="hidden" name="cls" value="<%=classes%>">
<input type="hidden" name="sesdate" value="01/07/<%=Syear%>">
 </table></td></tr>
 <tr><td height="10"></td></tr>
        <tr><td><table width="45%" align="center" >

<tr><td align="left">Promote Passed Students to Class:<%=cl%></td>
<input type="hidden" name="classes"  value="<%=cl%>">
</tr>            
        </table></td></tr>    
  <tr><td>
<table border="1" width="45%" align="center" > 
 <tr>
 
 <td><font size="2">Left</font></td>
 <td><font size="2">Pass</font></td>
  <td><font size="2">Fail</font></td>
<td><font size="2"><b>SR Number</b></font></td>
<td><font size="2"><b>Student Name</b></font></td>
</tr>
    
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
<tr><td><input type="radio" value="left" name="st<%=i%>"></td>
<td><input type="radio" value="pass" name="st<%=i%>" checked></td>
<td><input type="radio" value="fail" name="st<%=i%>"></td>
<td><%=seo.getSrnum()%><input type="hidden" value="<%=seo.getSrnum()%>" name="re<%=i%>"></td>
<td><%=seo.getSname()%></td>
</tr>
 <%
   } }%>
</table>
  </td></tr>
  
  <tr><td valign="top"><table align="center">
<tr><td valign="top"><input type="submit" value="update"></td></tr>
       <%
   }catch(Exception e)
       {}%>
  </table></td></tr>
      </td></tr>
</table> 
</form>   
 </td></tr></table></td></tr>       
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>     
    
    </body>
</html>
