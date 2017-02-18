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
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Day Report</u></font></center></td></tr></table>
   
<form  method="post" action="<%=request.getContextPath()%>/tdf.do" onsubmit="return chkvalidate()">
<table>
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color=red size="2">Please enter the Session</font></td></tr>
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
<form name="update">
    <%String syear=request.getParameter("syear");
     String eyear=request.getParameter("eyear");

TDay_Report rp=new TDay_Report();
  
int am1=rp.tfeeResult("01",syear,eyear);
int am2=rp.tfeeResult("02",syear,eyear);
int am3=rp.tfeeResult("03",syear,eyear);
int am4=rp.tfeeResult("04",syear,eyear);
int am5=rp.tfeeResult("05",syear,eyear);
int am6=rp.tfeeResult("06",syear,eyear);
int am7=rp.tfeeResult("07",syear,eyear);
int am8=rp.tfeeResult("08",syear,eyear);
int am9=rp.tfeeResult("09",syear,eyear);
int am10=rp.tfeeResult("10",syear,eyear);
int am11=rp.tfeeResult("11",syear,eyear);
int am12=rp.tfeeResult("12",syear,eyear);

int fn1=rp.returnTFine("01",syear,eyear); 
int fn2=rp.returnTFine("02",syear,eyear); 
int fn3=rp.returnTFine("03",syear,eyear); 
int fn4=rp.returnTFine("04",syear,eyear); 
int fn5=rp.returnTFine("05",syear,eyear); 
int fn6=rp.returnTFine("06",syear,eyear); 
int fn7=rp.returnTFine("07",syear,eyear); 
int fn8=rp.returnTFine("08",syear,eyear); 
int fn9=rp.returnTFine("09",syear,eyear); 
int fn10=rp.returnTFine("10",syear,eyear); 
int fn11=rp.returnTFine("11",syear,eyear);
int fn12=rp.returnTFine("12",syear,eyear); 


int total1=fn1+am1; 
int total2=fn2+am2; 
int total3=fn3+am3; 
int total4=fn4+am4; 
int total5=fn5+am5; 
int total6=fn6+am6; 
int total7=fn7+am7; 
int total8=fn8+am8; 
int total9=fn9+am9; 
int total10=fn10+am10; 
int total11=fn11+am11; 
int total12=fn12+am12; 


%>
<div id="printit">
<table><td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></table>     
<table width="100%"><tr>
<td><b>JAYCEES PUBLIC SCHOOL,GANGAPUR ROAD</b></td></TR>
<TR><TD><b>RUDRAPUR (U.S.NAGAR)</b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
<TR><TD><b>DAY BOOK SUMMARY - TRANSPORT FEE</b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
</TABLE>
        <table align="center" cellpadding="0" cellspacing="0" border="1" >
            <thead>
        
                <tr>
         <th align="left"><B>MONTH</B></th><th align="center"><B>TOTAL</B></th>
         <th align="center"><B>TR.FEES</B></th>
        <th align="center"><B>LATEFEE</B></th>
              </tr>
          
            </thead>
            <tbody>
             <tr>
               <td align="left"><a href="dttfr.do?dt=01&mon=January&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>January</font></a></td>
              <td align="center"><%=total1%></td>
              <td align="center"><%=am1%></td><td align="center"><%=fn1%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=02&mon=February&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>February</font></a></td>
               <td align="center"><%=total2%></td>
               <td align="center"><%=am2%></td><td align="center"><%=fn2%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=03&mon=March&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>March</font></a></td>
               <td align="center"><%=total3%></td>
               <td align="center"><%=am3%></td><td align="center"><%=fn3%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=04&mon=April&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>April</font></a></td>
              <td align="center"><%=total4%></td>
              <td align="center"><%=am4%></td><td align="center"><%=fn4%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=05&mon=May&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>May</font></a></td>
              <td align="center"><%=total5%></td>
              <td align="center"><%=am5%></td><td align="center"><%=fn5%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=06&mon=June&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>June</font></a></td>
              <td align="center"><%=total6%></td>
               <td align="center"><%=am6%></td><td align="center"><%=fn6%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=07&mon=July&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>July</font></a></td>
               <td align="center"><%=total7%></td>
               <td align="center"><%=am7%></td><td align="center"><%=fn7%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=08&mon=August&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>August</font></a></td>
              <td align="center"><%=total8%></td>
              <td align="center"><%=am8%></td><td align="center"><%=fn8%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=09&mon=September&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>September</font></a></td>
               <td align="center"><%=total9%></td>
              <td align="center"><%=am9%></td><td align="center"><%=fn9%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=10&mon=October&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>October</font></a></td>
              <td align="center"><%=total10%></td>
             <td align="center"><%=am10%></td><td align="center"><%=fn10%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=11&mon=November&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>November</font></a></td>
               <td align="center"><%=total11%></td>
               <td align="center"><%=am11%></td><td align="center"><%=fn11%></td>
             </tr>
             <tr>
               <td align="left"><a href="dttfr.do?dt=12&mon=December&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>December</font></a></td>
               <td align="center"><%=total12%></td>
               <td align="center"><%=am12%></td><td align="center"><%=fn12%></td>
             </tr>

               
            </tbody>
        </table>
</form>
    </td></tr></table>
    </DIV>   
 
   <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>
