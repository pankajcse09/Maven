<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="com.myapp.struts.MyMethods"%>
<%@page import="EO.SchoolEO"%>


   <!-- Developed by : Sonal Sharma
          Company      : IntelMind     -->
<%
       MyMethods mm=new MyMethods(); 
       Converter cnvrt=new Converter();
       Round rnd=new Round();
    
ArrayList ar1=new ArrayList();
HashMap hm1=new HashMap();
String rnum="";
Double paying=new Double(0.0);
String syear="";
String eyear="";
String sname="";
String classes="";
String feesubdate="";
String sec="";
String tmon="";
String fmon="";
if(request.getAttribute("rnum")!=null){
rnum=(String)request.getAttribute("rnum");
}
if(request.getAttribute("paying")!=null){
paying=(Double)request.getAttribute("paying");
}
if(request.getAttribute("Syear")!=null){
syear=(String)request.getAttribute("Syear");
}
if(request.getAttribute("Eyear")!=null){
eyear=(String)request.getAttribute("Eyear");
}
if(request.getAttribute("sname")!=null){
sname=(String)request.getAttribute("sname");
}
if(request.getAttribute("classes")!=null){
classes=(String)request.getAttribute("classes");
}
if(request.getAttribute("fsubdate")!=null){
feesubdate=(String)request.getAttribute("fsubdate");
}
if(request.getAttribute("section")!=null){
sec=(String)request.getAttribute("section");
}
if(request.getAttribute("arr")!=null){
ar1=(ArrayList)request.getAttribute("arr");   
}
if(request.getAttribute("hmap")!=null){
hm1=(HashMap)request.getAttribute("hmap");    
}
if(request.getAttribute("tmon")!=null){
tmon=(String)request.getAttribute("tmon");
}
if(request.getAttribute("fmon")!=null){
fmon=(String)request.getAttribute("fmon");
}
int k=1;
%>
 <%try{%> 
<html>
    <head>
     <title></title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script type="text/javascript" src="calendarDateInput.js"></script>  
     <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
    <script language="JavaScript">
        
 function seldata()
{
document.pb.method="post";
document.pb.action="prntbill.do?disp=disp";
document.pb.submit();
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

    </head>
    <body >

<table width="800" class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="#FFB76F">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
 <tr><td valign="top">  
 <table width="100%"><tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   </table>     
 <table align="center" width="100%" border="0">
<tr><td width="100%"></td></tr> 
<tr><td valign="top">
<form name="pb">
 <%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>  
<table cellpadding="0" cellspacing="0" width="50%" bgcolor="#FFB76F" align="center" height=40>
  
    <tr><td>Enter SR.Number:</td>
    <td><input type="text" name="srnum" value=""></td></tr>
<tr><td>Fee Submission Date:</td><td align="left"><script>DateInput('fsubdate', true, 'dd/mm/yyyy')</script></td></tr> 
 <td><input type="button" value="Display" name="sub" onclick="seldata()"></td></tr>
</table>
  </td></tr>
  <tr><td><hr></td></tr>
    <tr><td height=25></td></tr>
  </table>

 <table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
 <tr><td valign="top">
      <table border="0"><td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></table>            
<div id="printit">

<!--main--><table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">
                <tr><td valign="top">
        
                 <table width=100%  align="center" border="0">
    <tr><td align="left" rowspan="6" width="20"><img src="<%=request.getContextPath()%>/image/Sacred1.jpg" height="80" width="85">
    <td align="right"><b><font size="3">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<u>Fee Receipt</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="<%=request.getContextPath()%>/image/phone.gif">&nbsp;&nbsp;281672,222137</font></b></td></tr>
   <td align="center" colspan="2"><b><left><font size ="6">Queen's Sr. Sec. School</font></center</b></td></tr>
   <td align="center" colspan="2"><b><left><font size ="3" face="Monotype Corsiva">[Affiliated To C.B.S.E. Delhi]</font></center</b></td></tr>
   <td align="center" colspan="2"><b><left><font size =3>1, Civil Lines, Nainital Road, HALDWANI (Nainital) U.K.</font></center</b></td></tr>
   
   </table>
    </td></tr>
     <tr><td valign="top">
 <table width="100%" align="right" border="0" bordercolor="">
 <tr><td align="left"><b>SI.No.</b>&nbsp;&nbsp;<%=rnum%></td><td align="right" colspan="2"><b>Date:</b>&nbsp;<%=feesubdate%></td></tr>
<tr><td align="left" colspan="3"><b>Name of Student:</b>&nbsp;<%=sname%></td></tr>
<tr><td align="left"><b>Class:</b>&nbsp;<%=classes%></td><td align="right"><b>Section:</b>&nbsp;<%=sec%></td>
<td align="right"><b>Month:</b>&nbsp;<%=fmon%> to <%=tmon%></td></tr>
</table></td></tr>
<tr><td valign="top">
<table width=100% align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td align="left" width="5%" style="border:1px solid black"><b>S.L.</b></td>
<td align="center" width="65%" style="border:1px solid black"><B>PARTICULARS</B></td>
<td align="center" width="30%" style="border:1px solid black"><b>AMOUNT</b></td></tr>    
<%for(int i=0;i<ar1.size();i++){%>    
<tr><td width="5%" style="border:1px solid black"><b><%=k++%></b></td>
<td align="center" width="65%" style="border:1px solid black"><b><%=ar1.get(i)%></b></td>
<td align="center" width="30%" style="border:1px solid black"><%=hm1.get(ar1.get(i))%></td></tr>
<%}%>
<tr><td align="left" width="5%" style="border:1px solid black"></td>
<td align="right" width="65%" style="border:1px solid black"><b>TOTAL</b></td>
<td align="center" style="border:1px solid black"><%=paying%></td></tr>
<tr><td align="left" width="5%" style="border:1px solid black"></td>
<td colspan="2" width="30%" align="left" style="border:1px solid black"><b>Rs.(In Words)&nbsp;&nbsp;</b>
<%=cnvrt.convertNumber(rnd.real(mm.precesion(paying.toString(),2)))%> &nbsp;
   <%if(!rnd.fraction(mm.precesion(paying.toString(),2)).equals("0")){%>and&nbsp;<%=cnvrt.convertNumber(rnd.fraction(mm.precesion(paying.toString(),2)))%>&nbsp;paise Only<%}%>

</td></tr>

</table>
<tr><td colspan="3" align="right"><br></td></tr>
<tr><td colspan="3" align="right"><br></td></tr>
<tr><td colspan="3" align="right">For: Queen's Sr. Sec.School</td></tr>
</td></tr></table>
</div>
</form>
</td></tr></table>
</td></tr></table>
</body>
</html>

<%}catch(Exception e){}%>