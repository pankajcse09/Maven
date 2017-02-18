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
   
<form  method="post" action="<%=request.getContextPath()%>/sdf.do" onsubmit="return chkvalidate()">
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
<form name="update" action="<%=request.getContextPath()%>/editacdet.do?enter=enter" method="post" onsubmit="return chkvalidate()">

  <%String syear=request.getParameter("syear");
     String eyear=request.getParameter("eyear");

Day_Report rp=new Day_Report();
  
EO.SchoolEO aa1=rp.feeResult("01",syear,eyear);
EO.SchoolEO aa2=rp.feeResult("02",syear,eyear);
EO.SchoolEO aa3=rp.feeResult("03",syear,eyear);
EO.SchoolEO aa4=rp.feeResult("04",syear,eyear);
EO.SchoolEO aa5=rp.feeResult("05",syear,eyear);
EO.SchoolEO aa6=rp.feeResult("06",syear,eyear);
EO.SchoolEO aa7=rp.feeResult("07",syear,eyear);
EO.SchoolEO aa8=rp.feeResult("08",syear,eyear);
EO.SchoolEO aa9=rp.feeResult("09",syear,eyear);
EO.SchoolEO aa10=rp.feeResult("10",syear,eyear);
EO.SchoolEO aa11=rp.feeResult("11",syear,eyear);
EO.SchoolEO aa12=rp.feeResult("12",syear,eyear);

int fn1=rp.returnFine("01",syear,eyear); 
int fn2=rp.returnFine("02",syear,eyear); 
int fn3=rp.returnFine("03",syear,eyear); 
int fn4=rp.returnFine("04",syear,eyear); 
int fn5=rp.returnFine("05",syear,eyear); 
int fn6=rp.returnFine("06",syear,eyear); 
int fn7=rp.returnFine("07",syear,eyear); 
int fn8=rp.returnFine("08",syear,eyear); 
int fn9=rp.returnFine("09",syear,eyear); 
int fn10=rp.returnFine("10",syear,eyear); 
int fn11=rp.returnFine("11",syear,eyear);
int fn12=rp.returnFine("12",syear,eyear); 


int total1=fn1+aa1.getAdmission()+aa1.getWelfare()+aa1.getExam()+aa1.getTution()+aa1.getComputer()+aa1.getScience()+aa1.getGames()+aa1.getLib()+aa1.getOther()+aa1.getRedm(); 
int total2=fn2+aa2.getAdmission()+aa2.getWelfare()+aa2.getExam()+aa2.getTution()+aa2.getComputer()+aa2.getScience()+aa2.getGames()+aa2.getLib()+aa2.getOther()+aa2.getRedm(); 
int total3=fn3+aa3.getAdmission()+aa3.getWelfare()+aa3.getExam()+aa3.getTution()+aa3.getComputer()+aa3.getScience()+aa3.getGames()+aa3.getLib()+aa3.getOther()+aa3.getRedm(); 
int total4=fn4+aa4.getAdmission()+aa4.getWelfare()+aa4.getExam()+aa4.getTution()+aa4.getComputer()+aa4.getScience()+aa4.getGames()+aa4.getLib()+aa4.getOther()+aa4.getRedm(); 
int total5=fn5+aa5.getAdmission()+aa5.getWelfare()+aa5.getExam()+aa5.getTution()+aa5.getComputer()+aa5.getScience()+aa5.getGames()+aa5.getLib()+aa5.getOther()+aa5.getRedm(); 
int total6=fn6+aa6.getAdmission()+aa6.getWelfare()+aa6.getExam()+aa6.getTution()+aa6.getComputer()+aa6.getScience()+aa6.getGames()+aa6.getLib()+aa6.getOther()+aa6.getRedm(); 
int total7=fn7+aa7.getAdmission()+aa7.getWelfare()+aa7.getExam()+aa7.getTution()+aa7.getComputer()+aa7.getScience()+aa7.getGames()+aa7.getLib()+aa7.getOther()+aa7.getRedm(); 
int total8=fn8+aa8.getAdmission()+aa8.getWelfare()+aa8.getExam()+aa8.getTution()+aa8.getComputer()+aa8.getScience()+aa8.getGames()+aa8.getLib()+aa8.getOther()+aa8.getRedm(); 
int total9=fn9+aa9.getAdmission()+aa9.getWelfare()+aa9.getExam()+aa9.getTution()+aa9.getComputer()+aa9.getScience()+aa9.getGames()+aa9.getLib()+aa9.getOther()+aa9.getRedm(); 
int total10=fn10+aa10.getAdmission()+aa10.getWelfare()+aa10.getExam()+aa10.getTution()+aa10.getComputer()+aa10.getScience()+aa10.getGames()+aa10.getLib()+aa10.getOther()+aa10.getRedm(); 
int total11=fn11+aa11.getAdmission()+aa11.getWelfare()+aa11.getExam()+aa11.getTution()+aa11.getComputer()+aa11.getScience()+aa11.getGames()+aa11.getLib()+aa11.getOther()+aa11.getRedm(); 
int total12=fn12+aa12.getAdmission()+aa12.getWelfare()+aa12.getExam()+aa12.getTution()+aa12.getComputer()+aa12.getScience()+aa12.getGames()+aa12.getLib()+aa12.getOther()+aa12.getRedm(); 


%>
     <div id="printit">
<table><td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></table>     
<table width="100%"><tr>
<td><b>JAYCEES PUBLIC SCHOOL,GANGAPUR ROAD</b></td></TR>
<TR><TD><b>RUDRAPUR (U.S.NAGAR)</b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
<TR><TD><b>DAY BOOK SUMMARY - FEES</b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
</TABLE>
        <table align="center" cellpadding="0" cellspacing="0" border=1 >
            <thead width=100%>
        
                <tr>
         <th align="left"><B>MONTH</B></th><th align="center"><B>TOTAL</B></th>
         <th align="center"><B>ADM</B></th><th align="center"><B>WELF</B></th>
         <th align="center"><B>EXAM</B></th><th align="center"><B>TUTION</B></th>
         <th align="center"><B>COMP</B></th><th align="center"><B>SCI</B></th>
         <th align="center"><B>GAMES</B></th>
         <th align="center"><B>LIB</B></th><th align="center"><B>OTHER</B></th>
         <th align="center"><B>READM</B></th>
         <th align="center"><B>LATEFEE</B></th>
              </tr>
          
            </thead>
            <tbody>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=01&mon=January&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>January</font></a></td><td align="center"><%=total1%></td>
               <td align="center"><%=aa1.getAdmission()%></td><td align="center"><%=aa1.getWelfare()%></td>
               <td align="center"><%=aa1.getExam()%></td><td align="center"><%=aa1.getTution()%></td>
               <td align="center"><%=aa1.getComputer()%></td><td align="center"><%=aa1.getScience()%></td>
                <td align="center"><%=aa1.getGames()%></td>
               <td align="center"><%=aa1.getLib()%></td><td align="center"><%=aa1.getOther()%></td>
               <td align="center"><%=aa1.getRedm()%></td><td align="center"><%=fn1%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=02&mon=February&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>February</font></a></td><td align="center"><%=total2%></td>
               <td align="center"><%=aa2.getAdmission()%></td><td align="center"><%=aa2.getWelfare()%></td>
               <td align="center"><%=aa2.getExam()%></td><td align="center"><%=aa2.getTution()%></td>
               <td align="center"><%=aa2.getComputer()%></td><td align="center"><%=aa2.getScience()%></td>
               <td align="center"><%=aa2.getGames()%></td>
               <td align="center"><%=aa2.getLib()%></td><td align="center"><%=aa2.getOther()%></td>
               <td align="center"><%=aa2.getRedm()%></td><td align="center"><%=fn2%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=03&mon=March&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>March</font></a></td><td align="center"><%=total3%></td>
               <td align="center"><%=aa3.getAdmission()%></td><td align="center"><%=aa3.getWelfare()%></td>
               <td align="center"><%=aa3.getExam()%></td><td align="center"><%=aa3.getTution()%></td>
               <td align="center"><%=aa3.getComputer()%></td><td align="center"><%=aa3.getScience()%></td>
               <td align="center"><%=aa3.getGames()%></td>
               <td align="center"><%=aa3.getLib()%></td><td align="center"><%=aa3.getOther()%></td>
               <td align="center"><%=aa3.getRedm()%></td></td><td align="center"><%=fn3%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=04&mon=April&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>April</font></a></td><td align="center"><%=total4%></td>
               <td align="center"><%=aa4.getAdmission()%></td><td align="center"><%=aa4.getWelfare()%></td>
               <td align="center"><%=aa4.getExam()%></td><td align="center"><%=aa4.getTution()%></td>
               <td align="center"><%=aa4.getComputer()%></td><td align="center"><%=aa4.getScience()%></td>
                <td align="center"><%=aa4.getGames()%></td>
               <td align="center"><%=aa4.getLib()%></td><td align="center"><%=aa4.getOther()%></td>
               <td align="center"><%=aa4.getRedm()%></td><td align="center"><%=fn4%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=05&mon=May&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>May</font></a></td><td align="center"><%=total5%></td>
               <td align="center"><%=aa5.getAdmission()%></td><td align="center"><%=aa5.getWelfare()%></td>
               <td align="center"><%=aa5.getExam()%></td><td align="center"><%=aa5.getTution()%></td>
               <td align="center"><%=aa5.getComputer()%></td><td align="center"><%=aa5.getScience()%></td>
               <td align="center"><%=aa5.getGames()%></td>
               <td align="center"><%=aa5.getLib()%></td><td align="center"><%=aa5.getOther()%></td>
               <td align="center"><%=aa5.getRedm()%></td><td align="center"><%=fn5%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=06&mon=June&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>June</font></a></td><td align="center"><%=total6%></td>
               <td align="center"><%=aa6.getAdmission()%></td><td align="center"><%=aa6.getWelfare()%></td>
               <td align="center"><%=aa6.getExam()%></td><td align="center"><%=aa6.getTution()%></td>
               <td align="center"><%=aa6.getComputer()%></td><td align="center"><%=aa6.getScience()%></td>
               <td align="center"><%=aa6.getGames()%></td>
               <td align="center"><%=aa6.getLib()%></td><td align="center"><%=aa6.getOther()%></td>
               <td align="center"><%=aa6.getRedm()%></td><td align="center"><%=fn6%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=07&mon=July&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>July</font></a></td><td align="center"><%=total7%></td>
               <td align="center"><%=aa7.getAdmission()%></td><td align="center"><%=aa7.getWelfare()%></td>
               <td align="center"><%=aa7.getExam()%></td><td align="center"><%=aa7.getTution()%></td>
               <td align="center"><%=aa7.getComputer()%></td><td align="center"><%=aa7.getScience()%></td>
                <td align="center"><%=aa7.getGames()%></td>
               <td align="center"><%=aa7.getLib()%></td><td align="center"><%=aa7.getOther()%></td>
               <td align="center"><%=aa7.getRedm()%></td><td align="center"><%=fn7%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=08&mon=August&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>August</font></a></td><td align="center"><%=total8%></td>
               <td align="center"><%=aa8.getAdmission()%></td><td align="center"><%=aa8.getWelfare()%></td>
               <td align="center"><%=aa8.getExam()%></td><td align="center"><%=aa8.getTution()%></td>
               <td align="center"><%=aa8.getComputer()%></td><td align="center"><%=aa8.getScience()%></td>
               <td align="center"><%=aa8.getGames()%></td>
               <td align="center"><%=aa8.getLib()%></td><td align="center"><%=aa8.getOther()%></td>
               <td align="center"><%=aa8.getRedm()%></td><td align="center"><%=fn8%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=09&mon=September&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>September</font></a></td><td align="center"><%=total9%></td>
               <td align="center"><%=aa9.getAdmission()%></td><td align="center"><%=aa9.getWelfare()%></td>
               <td align="center"><%=aa9.getExam()%></td><td align="center"><%=aa9.getTution()%></td>
               <td align="center"><%=aa9.getComputer()%></td><td align="center"><%=aa9.getScience()%></td>
               <td align="center"><%=aa9.getGames()%></td>
               <td align="center"><%=aa9.getLib()%></td><td align="center"><%=aa9.getOther()%></td>
               <td align="center"><%=aa9.getRedm()%></td><td align="center"><%=fn9%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=10&mon=October&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>October</font></a></td><td align="center"><%=total10%></td>
               <td align="center"><%=aa10.getAdmission()%></td><td align="center"><%=aa10.getWelfare()%></td>
               <td align="center"><%=aa10.getExam()%></td><td align="center"><%=aa10.getTution()%></td>
               <td align="center"><%=aa10.getComputer()%></td><td align="center"><%=aa10.getScience()%></td>
               <td align="center"><%=aa10.getGames()%></td>
               <td align="center"><%=aa10.getLib()%></td><td align="center"><%=aa10.getOther()%></td>
               <td align="center"><%=aa10.getRedm()%></td><td align="center"><%=fn10%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=11&mon=November&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>November</font></a></td><td align="center"><%=total11%></td>
               <td align="center"><%=aa11.getAdmission()%></td><td align="center"><%=aa11.getWelfare()%></td>
               <td align="center"><%=aa11.getExam()%></td><td align="center"><%=aa11.getTution()%></td>
               <td align="center"><%=aa11.getComputer()%></td><td align="center"><%=aa11.getScience()%></td>
               <td align="center"><%=aa11.getGames()%></td>
               <td align="center"><%=aa11.getLib()%></td><td align="center"><%=aa11.getOther()%></td>
               <td align="center"><%=aa11.getRedm()%></td><td align="center"><%=fn11%></td>
             </tr>
             <tr>
               <td align="left"><a href="dtsfr.do?dt=12&mon=December&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black>December</font></a></td><td align="center"><%=total12%></td>
               <td align="center"><%=aa12.getAdmission()%></td><td align="center"><%=aa12.getWelfare()%></td>
               <td align="center"><%=aa12.getExam()%></td><td align="center"><%=aa12.getTution()%></td>
               <td align="center"><%=aa12.getComputer()%></td><td align="center"><%=aa12.getScience()%></td>
               <td align="center"><%=aa12.getGames()%></td>
               <td align="center"><%=aa12.getLib()%></td><td align="center"><%=aa12.getOther()%></td>
               <td align="center"><%=aa12.getRedm()%></td><td align="center"><%=fn12%></td>
             </tr>

               
            </tbody>
        </table>
</form>
    </td></tr></table>
     </div>           
     
    <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>
