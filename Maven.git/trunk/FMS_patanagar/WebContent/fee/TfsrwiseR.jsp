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

<form  method="post" action="<%=request.getContextPath()%>/tfswr.do" >
    <%String syear=request.getParameter("syear");
     String eyear=request.getParameter("eyear");
     String dt=request.getParameter("dt");%>
      <table width="100%"><tr>
<td><b>JAYCEES PUBLIC SCHOOL,GANGAPUR ROAD</b></td></TR>
<TR><TD><b>RUDRAPUR (U.S.NAGAR)</b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
<TR><TD><b>DAY BOOK SUMMARY - TRANSPORT FEES FOR DATE :-<%=dt%></b></TD></TR>
<TR><TD HEIGHT="10"></TD></TR>
</TABLE>
     <table align="center" cellpadding="0" cellspacing="0" width="80%" border="1">
            <thead width=100%>
        
               <tr>
            <th align="left"><B>NO.</B></th>
             <th align="center"><B>SRNUM</B></th>
             <th align="center"><B>STUDENT</B></th>
             <th align="center"><B>CLASS</B></th>
             <th align="center"><B>TOTAL</B></th>
             <th align="center"><B>TR.FEES</B></th>
             <th align="center"><B>LATEFEE</B></th>
        </tr>  
          
            </thead>
             <tbody>
    <%
int k=0;
TfSrWise_Report rp=new TfSrWise_Report();

    Connection cn=null;
    Statement stmt3=null;
    ResultSet rs3=null;
 
    int fn1=0;
    int am1=0;
try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     try
        {
         String qry="select fsubdate,srnum,studentname,class,section from transfeerecord where fsubdate='"+dt+"' union select fi.fsubdate,fi.srnum,fe.studentname,fi.classes,fi.section from transfinerecord fi inner join feerecord fe on fe.fsubdate=fi.fsubdate where fe.fsubdate='"+dt+"'"; 

  
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next())
          {
           String fsubdate=rs3.getString("fsubdate");
           String srnum=rs3.getString("srnum");
           String sname=rs3.getString("studentname");
           String classes=rs3.getString("class");
           String section=rs3.getString("section");
         
         
am1=rp.tfeeResult(fsubdate,srnum,syear,eyear);
fn1=rp.returnTFine(fsubdate,srnum,syear,eyear); 
//am1=rp.returnOther(fsubdate,syear,eyear); 


int total1=fn1+am1; 

%>
       
           
             <tr>
               <td align="left"><font color=black><b><%=++k%></b></font></a></td>
                <td align="center"><font color=black><%=srnum%></font></a></td>
               <td align="center"><font color=black><%=sname%></font></a></td>
               <td align="center"><font color=black><%=classes%>-<%=section%></font></a></td>
               <td align="center"><%=total1%></td>
               <td align="center"><%=am1%></td>
               <td align="center"><%=fn1%></td>
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
