<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>
<%@page import="java.util.*,java.text.*"%>
<!DOCTYPE html>
 <%
    Connection cn=null;
    Statement stmt1=null;
    Statement stmt2=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    
    try{
    DataConnection dc=new DataConnection();
    cn=(Connection)dc.Dataconnect();
    }catch(Exception e){}
     
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);  
    int Eyear=Syear+1;
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);      

ArrayList ar=new ArrayList();    
try{
String sq="select class from classes";
stmt2=cn.createStatement();
rs2=stmt2.executeQuery(sq);
while(rs2.next()){
ar.add(rs2.getString("class")); 
}
}catch(SQLException e){}
ArrayList arr1=null;
if(request.getAttribute("arr")!=null){      
arr1=(ArrayList)request.getAttribute("arr");
}
SchoolEO seo=null;
%>    

<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
 <script language="javascript">     
function validate(){
if(document.ent.classes.value==""){
alert("Select Class");
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
</script>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration/Student Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left"  valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 310px">
    <tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Edit Class After Fee Submission</b></font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 50px">
 
<form  method="post" name="ent" action="<%=request.getContextPath()%>/listofstud2.do" onsubmit="return validate()">
<table cellpadding="0" cellspacing="0" width="800"><tr><td valign="top">   
<table align="center">
<%if((String)request.getAttribute("sub")!=null)
 out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>");%>  
<tr><td><font color="red" size="2">Select Following Details:</font></td></tr>
<tr><td><font color="white"><b>Class:<select name="classes">
<option value="">Select</option>      
<option value="All">All</option>      
<%for(int i=0;i<ar.size();i++){%>
<option value="<%=ar.get(i)%>"><%=ar.get(i)%></option>
<%}%>
</select>
<font color="white"><b>Session:<select name="session">    
<option value="<%=prev%>"><%=prev%></option>
<option value="<%=next%>"><%=next%></option>
</select>                       
<input type="submit" value="Display"></td></tr>
</table>
</form>
<hr>
<form name="formfine">
      <%String sr=request.getParameter("session");
    //   String er=request.getParameter("eyear");
       String cl=request.getParameter("classes"); 
int k=0;
       if(sr==null)
       { sr="";}
       
        if(cl==null)
       { cl="";}
 %>    
<table align="center">
<tr><td><font style="font-size:12" color="white"><b>Class:&nbsp;<%=cl%>&nbsp;|&nbsp;Session:&nbsp;<%=sr%></b></font></td></tr></table>
<table width="90%" align="center" border="1" bordercolor="blue" style="border-collapse:collapse" bgcolor="#FFFFCC"> 
 <tr> 
<td align="center" bgcolor="black"><font style="font-size:12" color="white"><b>SR.NO.</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Scholars Number</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Student Name</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Gender</b></font></td>
<td bgcolor="black"><font style="font-size:12" color="white"><b>Class</b></font></td>
<td bgcolor="black">&nbsp;</td>
</tr>    
<% 
try{
 for(int i=0;i<arr1.size();i++){ 
 seo=(SchoolEO)arr1.get(i);
%>
<tr>
<td align="center"><%=++k%></td>
<td><%=seo.getSrnum()%></td>
<td><%=seo.getSname()%></td>
<td><%=seo.getGender()%></td>
<td><%=seo.getClasses()%></td>
<td><a href="<%=request.getContextPath()%>/EditStud_ClassSub.do?disp=disp&srnum=<%=seo.getSrnum()%>&gnd=<%=seo.getGender()%>&session=<%=sr%>"><font color="darkblue"><b>Edit Class</b></font></td>
</tr>
<%}%>
</table>
<%}catch(Exception e){}%>
  </td></tr></table> 
</form>   
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>