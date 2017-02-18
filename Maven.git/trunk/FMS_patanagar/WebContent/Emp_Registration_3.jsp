<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="java.sql.SQLException,ActionClass.JBeanEmp"%>
<%@ page language="java"%>
<!DOCTYPE html>
<%
Connection con=null;
PreparedStatement psmt=null;
ResultSet rs=null;
String eid="";
String status="";  
if(request.getParameter("eid")!=null){
eid=(String)request.getParameter("eid");
}
if(request.getParameter("status")!=null){
status=(String)request.getParameter("status");
}
JBeanEmp jb=new JBeanEmp();
if(request.getAttribute("jbean")!=null){
jb=(JBeanEmp)request.getAttribute("jbean");  
eid=jb.getEmpId();
}
int count=0;
try      
{  
 Dataconnectivity dc=new  Dataconnectivity();
 con=(Connection)dc.Dataconnect();
}
catch(Exception e){}
if(!status.equals("old")){
try{
 String qr="select count(emp_id) as cnt from loginn where emp_id='"+eid+"'";
 psmt=con.prepareStatement(qr);
 rs=psmt.executeQuery();
 rs.next();
 count=rs.getInt("cnt"); 
 }
catch(SQLException se){out.println(se.getMessage());}
finally{
 try{
 if(rs!=null){rs.close();}
 if(psmt!=null){psmt.close();}
 if(con!=null){con.close();}
 }   
 catch(SQLException se){}
}
if(count==0){
response.sendRedirect(request.getContextPath()+"/Emp_Registration.jsp");      
}
}
%>
<html>
  <head>
  <title>Employee Registration Form</title>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
<script language="javascript" src="<%=request.getContextPath()%>/calendarDateInput.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
  <script language="javascript"></script>  
  </head>
        <body bgcolor="#999933">
    <style>
             input[type=button] {
                 cursor: pointer;
    
    background-color: #A89263;
    color: #333333;
    padding: 2px 6px 2px 6px;
    border-top: 1px solid #CCCCCC;
    border-right: 1px solid #333333;
    border-bottom: 1px solid #333333;
    border-left: 1px solid #CCCCCC;
   }
   
   input[type=button]:hover {
       background-color: #EEEEEE;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 447px;
    left:300px;
}
         </style> 
 
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td align="left"  valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration/Student Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left" valign="top" style="padding-left: 5px;" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td>    
<%if(request.getAttribute("msg")!=null){%>
<table width="100%"><tr><td width="100%" align="center"><font color="red" size="3"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>  
<%}%> 

<hr color="maroon">
 <table align="center" width="100%" border="0">
     <tr><td align="left" valign="middle"><font size="2" color="maroon"><b>Co-curricular and Extra curricular activities</b></font></td></tr>
 </table>
             <hr color="maroon">
                    </td></tr>
                  <tr><td>

 <form method="post" onSubmit="return validate(this.form)" action="<%=request.getContextPath()%>/UserRegist3.do?method=registUserAction4">
 <table align="center" width="100%" style="padding-left: 50px"><tr><td align="left" class="tdcolor">Unique Employee ID<input type="text" name="empid" value="<%=eid%>"></td>
 </tr></table>
<table align="center" width="100%" border="0" style="padding-left: 50px">
<tr><td align="center" valign="middle" class="tdcolor1">Activity</td>
<td align="center" valign="middle" class="tdcolor1">Representation level<br>(College/Univ./State)</td>
<td align="center" valign="middle" class="tdcolor1">Year</td><td align="center" valign="middle" class="tdcolor1">Position took/Stood</td></tr> 
<tr><td align="left" class="tdcolor1">Games<input type="hidden" name="games" value="Games"></td>
<td align="center"><textarea name="games1" cols="25" rows="3"></textarea></td>
<td align="center"><textarea name="games2" cols="25" rows="3"></textarea></td>
<td align="center"><textarea name="games3" cols="25" rows="3"></textarea></td></tr> 
<tr><td align="left" class="tdcolor1">Literary & Cultural<input type="hidden" name="lc" value="Literary and Culture"></td>
<td align="center"><textarea name="lc1" cols="25" rows="3"></textarea></td>
<td align="center"><textarea name="lc2" cols="25" rows="3"></textarea></td>
<td align="center"><textarea name="lc3" cols="25" rows="3"></textarea></td></tr>
</table>
 <hr color="maroon">
 <table align="center" width="100%" border="0">
<tr><td align="left" valign="middle"><font size="2" color="maroon" ><b>References Name & Address of three persons by whom you are well known</b></font></td></tr></table>
 <hr color="maroon">
<table align="center" width="100%" border="0" style="padding-left: 50px">    
<tr><td align="left" valign="middle" colspan="4" class="tdcolor"><b>Give Three References with Telephone Nos.</b></td></tr> 
<tr><td align="center" valign="middle" width="10%" class="tdcolor1">1.</td>
<td align="left" valign="middle" width="90%"><textarea name="refer1" cols="75" rows="2"></textarea></td></tr> 
<tr><td align="center" valign="middle" width="10%" class="tdcolor1">2.</td>
<td align="left" valign="middle" width="90%"><textarea name="refer2" cols="75" rows="2"></textarea></td></tr>
<tr><td align="center" valign="middle" width="10%" class="tdcolor1">3.</td>
<td align="left" valign="middle" width="90%"><textarea name="refer3" cols="75" rows="2"></textarea></td></tr>
</table>
<table align="center" width="100%" border="0">
<tr><td width="33%"></td>
<td align="center" width="34%"><input type="submit" value="Submit"></td>
<td align="right" width="33%"><a href="<%=request.getContextPath()%>/Emp_Registration.jsp?eid=<%=eid%>"><font color="blue" size="2"><b>Next >>></b></font></a></td>
</tr></table>    
</form>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
