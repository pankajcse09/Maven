<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
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
   
     <div id="printit">
<table><td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></table>     

<form  method="post" action="<%=request.getContextPath()%>/dtsfr.do" >
    <%String syear=request.getParameter("syear");
     String eyear=request.getParameter("eyear");
     String mnt=request.getParameter("dt");
    String mon=request.getParameter("mon");
if(mon==null){
        mon="";
}
%>

    <table width="100%"><tr>
<td><b>JAYCEES PUBLIC SCHOOL,GANGAPUR ROAD</b></td></TR>
<TR><TD><b>RUDRAPUR (U.S.NAGAR)</b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
<TR><TD><b>DAY BOOK SUMMARY - FEES FOR THE MONTH OF :-<%=mon%></b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
</TABLE>
     <table align="center" cellpadding="0" cellspacing="0" border=1 >
            <thead width=100%>
        
                <tr>
         <th align="left"><B>DATE</B></th><th align="center"><B>TOTAL</B></th>
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
    <%

SfDateWise_Report rp=new SfDateWise_Report();

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
         String qry="select fsubdate from feerecord where mnt='"+mnt+"' and syear='"+syear+"' and eyear='"+eyear+"' union select fsubdate from finerecord where mnt='"+mnt+"' and syear='"+syear+"' and eyear='"+eyear+"'"; 
  
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
           String fsubdate=rs3.getString("fsubdate");
         
         
aa1=rp.feeResult(fsubdate,syear,eyear);
fn1=rp.returnFine(fsubdate,syear,eyear); 

int total1=fn1+aa1.getAdmission()+aa1.getWelfare()+aa1.getExam()+aa1.getTution()+aa1.getComputer()+aa1.getScience()+aa1.getGames()+aa1.getLib()+aa1.getOther()+aa1.getRedm(); 

%>
       
           
             <tr>
               <td align="left"><a href="sfswr.do?dt=<%=fsubdate%>&syear=<%=syear%>&eyear=<%=eyear%>"><font color=black><%=fsubdate%></font></a></td><td align="center"><%=total1%></td>
               <td align="center"><%=aa1.getAdmission()%></td><td align="center"><%=aa1.getWelfare()%></td>
               <td align="center"><%=aa1.getExam()%></td><td align="center"><%=aa1.getTution()%></td>
               <td align="center"><%=aa1.getComputer()%></td><td align="center"><%=aa1.getScience()%></td>
               <td align="center"><%=aa1.getGames()%></td>
               <td align="center"><%=aa1.getLib()%></td><td align="center"><%=aa1.getOther()%></td>
               <td align="center"><%=aa1.getRedm()%></td><td align="center"><%=fn1%></td>
             </tr>
            
   <%} }catch(SQLException e)
          {}%>         

               
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
