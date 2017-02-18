<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import ="AO.*"%> 
<%@page import ="EO.SchoolEO"%>


<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
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
	var dt=document.studre.dt;
	if (isDate(dt.value)==false){
		dt.focus()
		return false;
	}
        }
 
function chkvalidate()
{
if(document.studre.dt.value=="")
{
alert("Please enter Date");
document.studre.dt.focus();
return (false);
}
if(document.studre.dt.value!="" )
{
 var k=ValidateForm();
          if(k==false)
          return false;
     
}return true;
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
    </head>
    <body>
  
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Per Day Report</u></font></center></td></tr></table>
   
<form name="studre" method="post" action="<%=request.getContextPath()%>/pdsfreport.do" onsubmit="return chkvalidate()">
<table>
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color=red size="2">Enter date to view the report</font></td></tr>
<td><input type="text" name="dt" size="12" value="">
<font color=red size="2">(dd/mm/yyyy)</font></td></tr>

</td><td><input type="submit" value="Display"></td></tr> 
</table>
<hr>
</form>
   
 <div id="printit">
<table><td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></table>     

<form  method="post" >
     <table align="center" cellpadding="0" cellspacing="0" width="70%" border=1>
            <thead width=50%>
        
               <tr>
         <th align="left"><B><font size="2">SRNUM</font></B></th>
         <th align="left"><B><font size="2">STUDENT</font></B></th><th align="left"><B><font size="2">CLASS</font></B></th>
         <th align="center"><B><font size="2">TOTAL</font></B></th>
         <th align="center"><B><font size="2">ADM</font></B></th><th align="center"><B><font size="2">WELF</font></B></th>
         <th align="center"><B><font size="2">EXAM</font></B></th><th align="center"><B><font size="2">TUTION</font></B></th>
         <th align="center"><B><font size="2">COMP</font></B></th><th align="center"><B><font size="2">SCI</font></B></th>
         <th align="center"><B><font size="2">GAMES</font></B></th>
         <th align="center"><B><font size="2">LIB</font></B></th><th align="center"><B><font size="2">OTHER</font></B></th>
         <th align="center"><B><font size="2">READM</font></B></th>
         <th align="center"><B><font size="2">LATEFEE</font></B></th>
              </tr>
            </thead>
             <tbody>
    <%
     String dt=request.getParameter("dt");

PerDayR rp=new PerDayR();

    Connection cn=null;
    Statement stmt3=null;
    ResultSet rs3=null;
    EO.SchoolEO aa1=null;
    int fn1=0;

try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     try
        {
         String qry="select fsubdate,srnum,studentname,class,section from feerecord where fsubdate='"+dt+"' union select fi.fsubdate,fi.srnum,fe.studentname,fi.classes,fi.section from finerecord fi inner join feerecord fe on fe.fsubdate=fi.fsubdate where fe.fsubdate='"+dt+"'"; 

  
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
           String fsubdate=rs3.getString("fsubdate");
           String srnum=rs3.getString("srnum");
           String sname=rs3.getString("studentname");
           String classes=rs3.getString("class");
           String section=rs3.getString("section");
         

         
aa1=rp.feeResult(dt,srnum);
fn1=rp.returnFine(dt,srnum); 

int total1=fn1+aa1.getAdmission()+aa1.getWelfare()+aa1.getExam()+aa1.getTution()+aa1.getComputer()+aa1.getScience()+aa1.getGames()+aa1.getLib()+aa1.getOther()+aa1.getRedm(); 

%>
        <tr>
               <td align="left"><font color=black size="2"><%=srnum%></font></a></td>
               <td align="left"><font color=black size="2"><%=sname%></font></a></td>
               <td align="center"><font color=black size="2"><%=classes%>-<%=section%></font></a></td>
               <td align="center"><font color=black size="2"><%=total1%></font></td>
               <td align="center"><font color=black size="2"><%=aa1.getAdmission()%></font></td><td align="center"><font color=black size="2"><%=aa1.getWelfare()%></font></td>
               <td align="center"><font color=black size="2"><%=aa1.getExam()%></font></td><td align="center"><font color=black size="2"><%=aa1.getTution()%></font></td>
               <td align="center"><font color=black size="2"><%=aa1.getComputer()%></font></td><td align="center"><font color=black size="2"><%=aa1.getScience()%></font></td>
               <td align="center"><font color=black size="2"><%=aa1.getGames()%></font></td>
               <td align="center"><font color=black size="2"><%=aa1.getLib()%></font></td><td align="center"><font color=black size="2"><%=aa1.getOther()%></font></td>
               <td align="center"><font color=black size="2"><%=aa1.getRedm()%></font></td><td align="center"><font color=black size="2"><%=fn1%></font></td>
             </tr>
            
   <%}} catch(SQLException e)
          {}%>         

               
            </tbody>
        </table>
</form>
    </td></tr></table>
   </div>      
   
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    </body>
</html>
