<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*,Beans.*"%>
<!DOCTYPE html>
<% 
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt=new java.util.Date();
    String dat=sdf.format(dt);
    
CcBean cb=new CcBean();  
if(request.getAttribute("jbean")!=null){
cb=(CcBean)request.getAttribute("jbean");   
}
try{%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script type="text/javascript" src="calendarDateInput.js"></script>  
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
          <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
          <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/printData.js"></script>
    <title>Character Certificate</title>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Reports/Classwise Stud. Detail</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td style="padding-left: 160px">   
    <form name="f1" method="post" action="<%=request.getContextPath()%>/RetStudData.do?method=dataByEnrolNo">
    <table width="50%" align="center"><tr><td><font style="font-size:16;color:darkblue"><b>Admin No.</b></font><input type="text" name="adminno" value="">
    <input type="submit" value="Submit"></td></tr></table>    
    </form>   
<table width="100%" align="center"><tr>
<td width="100%" align="right" valign="top"><a href="javascript:printTcCc('printit')"><font color="blue" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
    <hr color="darkblue">
    <div id="printit">
    <table width="620" height="800" align="center" border="0" style="border-collapse:collapse" bgcolor="white" bordercolor="yellow" background="<%=request.getContextPath()%>/image/HLD_BIGLOGO2.jpg">
    <tr><td width="100%" valign="top">    
    <table width="100%" align="center" border="0" bordercolor="red"><tr><td width="100%" align="center" valign="top"> 
    <table width="100%" align="center" border="0" bordercolor="green">
    <tr><td colspan="2" align="center"><font style="font-size:35;font-weight:bold;font-family:Aarti">ema.baI. rajak Iya snaatak aooottar mahaivaValaya</font></td></tr>
    <tr><td colspan="2" align="center"><font style="font-size:30;font-weight:bold;font-family:Aarti">hlWanaI (naOnaItaala)</font></td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td>&nbsp;</td></tr>
    </table>
    <table width="100%" align="center" border="0" bordercolor="blue">
    <tr><td align="left" valign="middle"><font style="font-size:16;font-weight:bold;font-family:Aarti">k` maaMk</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cb.getRid()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td><td width="40%" align="center" valign="middle" bgcolor="black"><font color="white" style="font-size:25;font-weight:bold;font-family:Aarti">cair~a pa`maaNaàpa~a</font></td><td align="right"><font style="font-size:16;font-weight:bold;font-family:Aarti">idnaaMk</font>&nbsp;&nbsp;<u><%=dat%></u></td></tr>
    </table>
    <table width="100%" height="50" align="center" border="0"><tr><td>&nbsp;</td></tr></table>
    
    
    <table width="100%" height="380" align="center" border="0"><tr><td width="100%" align="left">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font style="font-size:16;font-weight:bold;font-family:Aarti">pa`maaiNata ik yaa jaataa hO ik</font><u>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<%=cb.getName()%>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;



</u></td></tr>

    <tr><td width="100%" align="left"><font style="font-size:16;font-weight:bold;font-family:Aarti">pau~aópau~aI E`aI</font><u>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;
<%=cb.getFname()%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


    </u>
    &nbsp;&nbsp;<font style="font-size:16;font-weight:bold;font-family:Aarti">sa~a</font>
<u>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<%=cb.getFrom()%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;



</u>&nbsp;&nbsp;
    <font style="font-size:16;font-weight:bold;font-family:Aarti">sao</font></td></tr>
    <tr><td width="100%" align="left">
&nbsp;&nbsp;<u>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%=cb.getTo()%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</u>&nbsp;&nbsp;
<font style="font-size:16;font-weight:bold;font-family:Aarti">tak&nbsp;&nbsp;  [sa mahaivaValaya k I k Xaa</font>&nbsp;&nbsp;<u>
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
<%=cb.getClasses()%>
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
</u>&nbsp;&nbsp;
<font style="font-size:16;font-weight:bold;font-family:Aarti">ko &nbsp;saMsqaagata</font></td>
<tr><td>&nbsp;<!--<font style="font-size:16;font-weight:bold;font-family:Aarti">saMsqaagata</font>-->
   <font style="font-size:16;font-weight:bold;font-family:Aarti">Ca~a ó Ca~aa rho ó rhI hMO | AQyayana AvaiQa maoM [nak a cair~a AcCa evaM AacarNa {ttama &nbsp;rha hO|</font></td></tr>
<!--<tr><td><font style="font-size:16;font-weight:bold;font-family:Aarti">rha hO|</font>--></td></tr>
    <tr><td width="100%" align="left"><font style="font-size:16;font-weight:bold;font-family:Aarti">maOM [nako &nbsp; {jjvala BaivaYya k I k amanaa k rtaaók rtaI h^MU|</font></td></tr></table>    
    </table>
    <table width="100%" align="center" border="0">
    <tr><td  height="40"></td></tr>    
    <tr><td width="50%"></td><td width="50%" align="right">
    <table width="100%" align="right" border="0"><tr><td width="100%" align="center">
       <font style="font-size:18;font-weight:bold;font-family:Aarti">pa`acaaya-<br>ema.baI.rajak Iya snaatak aooottar mahaivaValaya<br>hlWanaI (naOnaItaala)</font></td></tr></table>      
    </td></tr></table>
    </td></tr></table>
    </div>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>