<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java"%>
        <html>
            <head>
                <title>Student Registration Forms</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
  <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></script>          
         <script language="javascript" src="/Exam/resolution.js"></script>
<base target="_parent">

                <script language="javascript">  
                    
var dtCh= "/";
     var minYear=1900;
     var maxYear=2100;

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		alert("The date format should be : dd/mm/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day")
		return false
	}
	if (strYear.length != 4 || year==0 || year < minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date")
		return false
	}
return true
}

function ValidateForm(){
	var dt=document.forms[0].dob;
	if (isDate(dt.value)==false){
		dt.focus()
		return false;
	}
        }
        
        function Validentryyear(){
	var ey=document.forms[0].entryyear;
	if (isDate(ey.value)==false){
		ey.focus()
		return false;
	}
        }
       
 function validate_email(form1)
{
apos=document.forms[0].elements[18].value.indexOf("@");
dotpos=document.forms[0].elements[18].value.lastIndexOf(".");
if (apos<1||dotpos-apos<2) 
  {
alert("please fill valid email address");
document.forms[0].elements[18].focus();
          return (false);
                }
          }

 function validate(form1)
{
for(i=0;i<=2;i++)
{
if(document.forms[0].elements[i].value=="")
{
alert("please enter "+document.forms[0].elements[i].name+" field");
document.forms[0].elements[i].focus();
return (false);
}
}
var secqu=document.forms[0].elements[2].value;
 if(secqu.length>70){
  alert(document.forms[0].elements[2].name+" should not greater than 70 characters"); 
 document.forms[0].elements[2].focus();
 return (false);
 }

if(document.forms[0].elements[3].value=="")
{
alert("please enter "+document.forms[0].elements[3].name+" field");
document.forms[0].elements[3].focus();
return (false);
}
if(document.forms[0].elements[3].value==document.forms[0].elements[1].value){
alert("Password shoud be Different from LoginID");
document.forms[0].elements[3].value="";
document.forms[0].elements[3].focus();
return (false);
}
var passwstr=document.forms[0].elements[3].value;
 if(passwstr.length<6) {
 alert(document.forms[0].elements[3].name+" should not less than 6 characters"); 
 document.forms[0].elements[3].focus();
 return (false);}
if(passwstr.length>16){
  alert(document.forms[0].elements[3].name+" should not greater than 16 characters"); 
 document.forms[0].elements[3].focus();
 return (false);
 }
 
 if(document.forms[0].elements[4].value=="")
{
alert("enter "+document.forms[0].elements[4].name+" field");
document.forms[0].elements[4].focus();
return (false);
}

 if(document.forms[0].elements[5].value!=document.forms[0].elements[3].value){
  alert("Password Mismatch");
  document.forms[0].elements[5].focus();
  return (false);
  }
      
 for(i=6;i<=7;i++)
{
if(document.forms[0].elements[i].value=="")
{
alert("please enter "+document.forms[0].elements[i].name+" field");
document.forms[0].elements[i].focus();
return (false);
}
}
if(document.forms[0].elements[9].value=="" || document.forms[0].elements[9].value=="dd/mm/yyyy")
{
alert("please enter "+document.forms[0].elements[9].name+" field");
document.forms[0].elements[9].focus();
return (false);
}
if(document.forms[0].elements[9].value!="" || document.forms[0].elements[9].value!="dd/mm/yyyy")
{
 var k=ValidateForm();
          if(k==false)
            return false;
          }    
          
 for(i=10;i<=23;i++)
{
var fieldno=i;
switch( fieldno )
        {
         case 11:
         {
         if(document.forms[0].elements[11].value=="")
          {
          alert("Enter Father's Name");
          document.forms[0].elements[11].focus();
          return (false);
          }
          }
        case 12:
        {
        if(document.forms[0].elements[12].value==""){
        alert("Enter Mother's Name");
        document.forms[0].elements[12].focus();
        return (false);
        }
        }
          case 15:
           continue;
                case 18:
         {
          if(document.forms[0].elements[18].value!="")
          {
          var k=validate_email(form1);
          if(k==false)
            return false;
            else
            continue;
                    }
          else
          continue;
          } 
          case 19:
          continue;
          case 20:
          continue;       
          case 23:
            continue;         
        }
 if(document.forms[0].elements[i].value=="")
 {
 alert("Please fill in the "+document.forms[0].elements[i].name+" field");
 document.forms[0].elements[i].focus();
 return (false);
 }
  }  
  if(document.forms[0].elements[24].value=="" || document.forms[0].elements[24].value=="dd/mm/yyyy")
{
alert("please enter "+document.forms[0].elements[24].name+" field");
document.forms[0].elements[24].focus();
return (false);
}
if(document.forms[0].elements[24].value!="" || document.forms[0].elements[24].value!="dd/mm/yyyy")
{
 var kk=Validentryyear();
          if(kk==false)
            return false;
          } 
        
  for(i=25;i<=35;i++)
  { 
  if(i==26){
   if(document.forms[0].elements[26].value=="")
 {
 alert("Enter the Last Institution Attended Field");
 document.forms[0].elements[26].focus();
 return (false);
 }
  } 
   if(i==28){
   if(document.forms[0].elements[28].value=="")
 {
 alert("Enter the Passed Year of Last Institution Attended");
 document.forms[0].elements[28].focus();
 return (false);
 }
  }
   if(i==31){
   if(document.forms[0].elements[31].value=="")
 {
 alert("Enter Warden Name");
 document.forms[0].elements[31].focus();
 return (false);
 }
  } 
   if(i==32){
   if(document.forms[0].elements[32].value=="")
 {
 alert("Enter Warden's Contact No.");
 document.forms[0].elements[32].focus();
 return (false);
 }
  } 
  if(document.forms[0].elements[i].value=="")
 {
 alert("Please fill in the "+document.forms[0].elements[i].name+" field");
 document.forms[0].elements[i].focus();
 return (false);
 }
  }
 return (true);
   }
                </script>  
            </head> 
            <body>
  <form action="reg" method="post" onSubmit="return validate(this.form)" >              
  <table width="100%" cellpadding="0" cellspacing="0" bgcolor="#455A8B"><tr><td>
<table width="100%" ><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding="0" cellspacing="0" width="100%" height="350">
<tr><td valign="top">     
            <%!
                  String suername="";
                  
       
        String studnt_dep="";

	
        String apasswd="";
         
   
        
                String sid="";
        
        String sfname="";
       String slastname="";
        String smidname="";
        String sdob="";
       // Date date=new Date(dateFormat.parse(sdob).getTime());
        
        String sgender="";
        String ftname="";
        String mtname="";
        String shomadd1="";
       
          String sstate="";
          String shomadd2="";
          String scountry="";
         String scity="";
         String semail="";
         String scollege="";
       
      
        String sofficephone="";
        String shomephone="";
        String smobile="";
        
        String sdep="";
        String sdegree="";
        String scurrentadd="";
        String wname="";
        String wcontno="";
        String syear="";
        String pylia="";
        String hostel="";
        String roomno="";
        String sadvisor="";
        String lia="";
        String emername="";
        String emerno="";
        String emeradd="";
        String sq="";
        String sa="";
        String repasswd="";
           
            
            %>
            <%
Connection dep_con=null;
PreparedStatement dep_pstmt=null;
ResultSet dep_rs=null;
String studnt_college=null;
String college="";
String co="";
     %>
            
    
 <table width="100%"><tr><td width="100%" align="right"><font color="#000080"><a href="<%=request.getContextPath()%>/index.jsp">Home</font></a></td></tr></table>     
   
    <center><font color="#000080" size="3"><b>Student Registration Form</b></font></center>
             <%
             String chkreq=request.getParameter("para");
             if(chkreq==null){
               
                 
                   suername=request.getParameter("logname");
                  
                 
        suername=suername.trim();
        

	
         apasswd=request.getParameter("password");
         repasswd=request.getParameter("password1");
         
                sid=request.getParameter("stuid");
         //String spasswd=request.getParameter("password");
        
         sfname=request.getParameter("firstname");
        slastname=request.getParameter("lastname");
         smidname=request.getParameter("middlename");
         sdob=request.getParameter("dob");
       // Date date=new Date(dateFormat.parse(sdob).getTime());
        
       sgender=request.getParameter("gender");
       ftname=request.getParameter("fthname");
       mtname=request.getParameter("mthname");
           shomadd1=request.getParameter("homeadd1");
       
         sstate=request.getParameter("state");
         shomadd2=request.getParameter("homeadd2");
           scountry=request.getParameter("country");
       scity=request.getParameter("city");
          semail=request.getParameter("email");
         scollege=request.getParameter("college");
       
      
         sofficephone=request.getParameter("officephone");
         shomephone=request.getParameter("homephone");
         smobile=request.getParameter("mobile");
        
         sdep=request.getParameter("department");
         sdegree=request.getParameter("degree");
        scurrentadd=request.getParameter("curlivat");        
        
         syear=request.getParameter("entryyear");
        
         pylia=request.getParameter("lastattend");
         sadvisor=request.getParameter("advisor");
         lia=request.getParameter("lastinst");
         hostel=request.getParameter("hostel");
         roomno=request.getParameter("roomno");
         wname=request.getParameter("wname");
         wcontno=request.getParameter("wcontno");
      /*  String semname=request.getParameter("name");
        String semeno=request.getParameter("contactno");
        String semeadd=request.getParameter("address");*/
          emername=request.getParameter("name");
           emerno=request.getParameter("contactno");
           emeradd=request.getParameter("address");
         sq=request.getParameter("secretquestion");
         sa=request.getParameter("answer");
           
                 
             } 
                               
            
             %>              
                <hr>
                <b><font color="#000080">Login Information</font></b>
                <hr>
                <table align="center" width="100%"><tr><td align="right" width="65%">*Please Enter your Student ID(Issued by GBPUAT)</td><td align="left" width="35%"><input type="text" name="stuid" value="<%=sid%>"></td></tr></table>  
                <table align="center" width="100%">
                <tr><td align="right" width="25%">*LoginID</td><td width="25%"><input type="text" name="logname" value="<%=suername%>"></td>
                        <td align="right" width="15%">*Secret Question </td><td width="35%"><input type="text" name="secretquestion" value="<%=sq%>"></td></tr>
               <tr><td width="25%"></td><td width="25%"><font size="1" color="red"><% if((String)request.getAttribute("exist")!=null)
               out.println("<font color='red'><b>"+(String)request.getAttribute("exist")+"</b></font>");%>ID may consist of a-z, underscores and a single dot (.)</font></td><td width="15%"></td><td width="35%"></td></tr>
                <tr><td align="right" width="25%">*Password</td><td width="25%"><input type="password" name="password" value="<%=apasswd%>"></td>
                         <td align="right" width="15%">*Answer </td><td width="35%"><input type="text" name="answer" value="<%=sa%>"></td></tr>
                <tr><td width="25%"></td><td width="25%"><font size="1" color="red">Six characters and more ; capitalization matters</font></td><td width="15%"></td><td width="35%"></td></tr>
                <tr><td align="right" width="25%">*Reenter Password</td><td width="25%"><input type="password" name="password1" value="<%=repasswd%>"></td><td width="15%"></td><td width="35%"></td></tr></table>
                <hr>
                <b><font color="#000080">Personal Information</font></b>
                <hr>
                <table width="100%" align="center">
                <tr><td align="right" width="25%">*First Name</td><td width="25%"><input type="text" name="firstname" value="<%=sfname%>"></td>
                <td align="right" width="15%">*Last Name</td><td width="35%"><input type="text" name="lastname" value="<%=slastname%>"></td></tr>
                <td align="right" width="25%">Middle Name</td><td width="25%"><input type="text" name="middlename" value="<%=smidname%>"></td><td width="15%"></td><td width="35%"></td></tr>
                <tr><td align="right" width="25%">*Date of Birth</td><td width="25%"><input type="text" name="dob" value="<%=sdob%>"><br><font size="1" color="red">eg:(dd/mm/yyyy)</font></td><td align="right" width="15%">*Gender</td>
  <%
  if(request.getParameter("para")!=null)
  {
  %>  
<td width="35%"><select name="gender"><option value="M">Male<option value="F">Female</select></td></tr>
<%
  }%>
<%
if(request.getParameter("para")==null) 
{  
    if(request.getParameter("gender").equals("M"))
    {
%>
<td width="35%"><select name="gender"><option value="M">Male
<option value="F">Female</select></td></tr>
<%}%>
<%
if(request.getParameter("gender").equals("F"))
    {
%>
<td width="35%"><select name="gender"><option value="F">Female
<option value="M">Male</select></td></tr>
<%}}
  //if(request.getParameter("para")!=null)
  //{
  %> 
<tr><td align="right" width="25%">*Father's Name</td><td width="25%"><input type="text" name="fthname" value="<%=ftname%>"></td>
<td align="right" width="15%">*Mother's Name</td><td width="35%"><input type="text" name="mthname" value="<%=mtname%>"></td></tr>
     </table>          
      <hr>  
      <b><font color="#000080">Address & Contacts Information</font></b>
      <hr>
      <table width="100%" align="center" border="0">
                <tr><td align="right" width="25%">*Home Address Line1</td><td width="25%"><input type="text" name="homeadd1" value="<%=shomadd1%>"></td><td align="right" width="15%">*State</td><td width="35%"><input type="text" name="state" value="<%=sstate%>"></td></tr>
                <tr><td align="right" width="25%">Home Address Line2</td><td width="25%"><input type="text" name="homeadd2" value="<%=shomadd2%>"></td><td align="right" width="15%">*Country</td><td width="35%"><input type="text" name="country" value="<%=scountry%>"></td></tr>
                <tr><td align="right" width="25%">*City</td><td width="25%"><input type="text" name="city" value="<%=scity%>"></td><td align="right" width="15%">Email</td><td width="35%"><input type="text" name="email" value="<%=semail%>"></td></tr>
                <tr><td align="right" width="25%">Home Phone</td><td width="25%"><input type="text" name="homephone" value="<%=shomephone%>"></td><td align="right" width="15%">Mobile</td><td width="35%"><input type="text" name="mobile" value="<%=smobile%>"></td></tr></table>
                <hr>
                <b><font color="#000080">Official Information</font></b>
                <hr>
               <table width="100%" align="center">                         
                <tr><td align="right" width="25%">*College</td><td width="25%"><select name="college">
                <option value="College of Veterinary & Animal Sciences">College of Veterinary & Animal Sciences</option>
                </select>
 <td align="right" width="15%">*Degree</td><td width="35%"><select name="degree">
 <%
   try         
{    
    Dataconnectivity con=new  Dataconnectivity();
    dep_con=(Connection)con.Dataconnect();          
       studnt_dep="select distinct deg_name from degree_details"; 
dep_pstmt=dep_con.prepareStatement(studnt_dep);
dep_rs=dep_pstmt.executeQuery();
while(dep_rs.next())
{  
%>
 <option value="<%=(String)dep_rs.getString("deg_name")%>"><%=(String)dep_rs.getString("deg_name")%>              
<%
}
}

catch(SQLException e)
{
out.println(e.getMessage());
}
%>
 </select></td></tr>
 <tr><td align="right" width="25%">Office Phone</td><td width="25%" colspan="3"><input type="text" name="officephone" value="<%=sofficephone%>"></td></tr> 
 <tr><td align="right" width="25%">*Entry Year in GBPUAT</td><td width="25%"><input type="text" name="entryyear" value="<%=syear%>"><br><font size="1" color="red">eg:(dd/mm/yyyy)</font></td><td align="right" width="15%">*Currently living at</td><td width="35%"><input type="text" name="curlivat" value="<%=scurrentadd%>"></td></tr>
                <tr><td align="right" width="25%">*Last Institution Attended</td><td width="25%"><input type="text" name="lastinst" value="<%=lia%>"></td><td align="right" width="15%">*Advisor</td><td width="35%"><input type="text" name="advisor" value="<%=sadvisor%>"></td></tr>
                <tr><td align="right" width="25%">*Passed Year<br>(Last Institution Attended)</td><td width="25%"><input type="text" name="lastattend" value="<%=pylia%>"><br><font size="1" color="red">(yyyy)</font></td><td width="15%"></td><td width="35%"></td></tr>
                <tr><td align="right" width="25%">*Hostel Name</td><td width="25%"><input type="text" name="hostel" value="<%=hostel%>"></td><td width="15%">*Room No.</td><td width="35%"><input type="text" name="roomno" value="<%=roomno%>"></td></tr>
                <tr><td align="right" width="25%">*Warden Name</td><td width="25%"><input type="text" name="wname" value="<%=wname%>"></td><td width="15%">*Warden Cont. No.</td><td width="35%"><input type="text" name="wcontno" value="<%=wcontno%>"></td></tr>
                </table>
                <hr>
                <b><font color="#000080">Emergency Contact</font></b>
                <hr>
                <table width="100%" border="0" align="left"><tr><td align="right" width="25%">*Name</td><td width="25%"><input type="text" name="name" value="<%=emername%>"></td><td width="15%"></td><td width="35%"></td></tr>
                <tr><td align="right" width="25%">*Contact No.</td><td width="25%"><input type="text" name="contactno" value="<%=emerno%>"></td><td width="15%"></td><td width="35%"></td></tr>
                <tr><td align="right" width="25%">*Address</td><td width="25%"><input type="text" name="address" value="<%=emeradd%>"></td><td width="15%"></td><td width="35%"></td></tr></table>
                </td></tr><tr><td>              
                <table align="center" width="100%"><tr><td align="right">
                <input type="reset" value="Reset">
                <input type="submit" value="Submit">
                </td></tr></table>              
             </td></tr><tr><td></td></tr></table>             
             </td></tr></table>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</td></tr></table>
</form>
 </body>
 </html>
