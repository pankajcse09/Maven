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

<%
       MyMethods mm=new MyMethods(); 
       Converter cnvrt=new Converter();
    Round rnd=new Round();
    
ArrayList ar1=new ArrayList();
HashMap hm1=new HashMap();

String name=(String)request.getAttribute("empname");
String date1=(String)request.getAttribute("datee");
String particular=(String)request.getAttribute("dete");
Double amtt1=(Double)request.getAttribute("amtt");
int k=1;
%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expenses Bill</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script type="text/javascript" src="calendarDateInput.js"></script>  
     <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
    <script language="JavaScript">

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
    <body>
    
<!--1--><table width="50%" class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="" border="0">
<form name="11">
<tr><td valign="top">  
<table width="100%">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
</table> 
</td></tr>
<td width="" align="right" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td>
<tr><td><div id="printit">
<table width="65%" align="center" cellpadding="0" cellspacing="0" border="0">
<tr><td valign="top">
<table width="100%" align="right" border="0" bordercolor="">              
<tr><td align="center"><b><font color="white">SL.No.</font></b></td>
<td align="right" colspan="2"><b>Date:</b><%=date1%></td></tr>                    
<tr><td align="left" colspan="3"><b>Paid By:</b><u><%=name%></td></tr>
</table></td></tr>
<tr><td valign="top">
<table width=100% align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td align="center" width="5%" style="border:1px solid black"><b>S.L.</b></td>       
<td align="left" width="65%" style="border:1px solid black"><B>PARTICULARS</B></td>
<td align="left" width="30%" style="border:1px solid black"><b>AMOUNT</b></td></tr>  
<tr><td width="5%" style="border:1px solid black"><b></b><%=k++%></td>
<td align="left" width="65%" style="border:1px solid black"><b></b><%=particular%></td>
<td align="left" width="30%" style="border:1px solid black"><%=amtt1%></td></tr>
<tr><td align="left" width="5%" style="border:1px solid black"></td>
<td align="right" width="65%" style="border:1px solid black"><b>TOTAL:</b></td>
<td align="center" style="border:1px solid black"><%=amtt1%></td></tr>    
<tr><td align="left" width="5%" style="border:1px solid black"></td>
<td colspan="2" width="30%" align="left" style="border:1px solid black"><b>Rs.(In Words)&nbsp;&nbsp;</b>
   <%=cnvrt.convertNumber(rnd.real(mm.precesion(amtt1.toString(),2)))%> &nbsp;
   <%if(!rnd.fraction(mm.precesion(amtt1.toString(),2)).equals("0")){%>and&nbsp;<%=cnvrt.convertNumber(rnd.fraction(mm.precesion(amtt1.toString(),2)))%>&nbsp;paise Only<%}%>
   </td></tr>
</table>
</td></tr>
</div>
</table>
</form>
</td></tr></table>
</td></tr></table>
</body>
</html>

    
    
    