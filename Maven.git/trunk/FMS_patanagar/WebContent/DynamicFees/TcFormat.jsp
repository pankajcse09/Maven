<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*,ActionClass.*,Beans.*"%>
<!DOCTYPE html>
<% 
    MyMeth mm=new MyMeth();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt=new java.util.Date();
    String dat=sdf.format(dt);
    
TcBean tb=new TcBean();  
if(request.getAttribute("jbean")!=null){
tb=(TcBean)request.getAttribute("jbean");   
}
try{%>
<html>
    <head>
    <style type="text/css">
    .font{font-size:25;font-weight:bold;font-family:Aarti}    
    .font2{font-size:16;font-weight:bold;font-family:Aarti} 
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script type="text/javascript" src="calendarDateInput.js"></script>  
    
          <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
          <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>        
    <script language="javascript" src="<%=request.getContextPath()%>/printData.js"></script>
    <title>Transfer Certificate</title>
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

    <form name="f1" method="post" action="<%=request.getContextPath()%>/RetStudTcData.do?method=tcDataByEnrolNo">
    <table width="50%" align="center"><tr><td><font style="font-size:16;color:darkblue"><b>Admin No.</b></font><input type="text" name="adminno" value="<%=tb.getAdminNo()%>">
    <input type="submit" value="Submit"></td></tr></table>    
    </form>   
<table width="80%" align="center" border="0">
<tr><td colspan="2" align="center" valign="top"><font style="font-size:14;font-weight:bold;color:yellow"><u>Issued No. of TC's to Enroll No. <%=tb.getEnrolNo()%></u></font>&nbsp;<b>:</b>&nbsp;<font style="font-size:14;color:blue"><b><u><%=mm.retCounter(tb)%></u></b></font></td></tr>    
<tr><td width="50%" valign="top"><a href="<%=request.getContextPath()%>/IncrementCounter.do?method=addCounterAct&eno=<%=tb.getAdminNo()%>"><font color="blue" size="2"><u><b>COUNTER INCREMENT</b></u></font></a></td>
<td width="50%" align="right" valign="top"><a href="javascript:printTcCc('printit')"><font color="blue" size="2"><u><b>PRINT</b></u></font></a></td></tr>
</table>
    <hr color="darkblue">
    <div id="printit">
  <table width="620" height="860" align="center" border="1" style="border-collapse:collapse" bgcolor="white" bordercolor="white" background="<%=request.getContextPath()%>/image/HLD_BIGLOGO2.jpg" >
    <tr><td  width="100%" valign="top" > 
    <table width="100%" align="center"  bgcolor="green" background="<%=request.getContextPath()%>/image/HLD_BIGLOGO.jpg">
    <tr><td colspan="2" align="center"><font style="font-size:35;font-weight:bold;font-family:Aarti">ema.baI. rajak Iya snaatak aooottar mahaivaValaya</font></td></tr>
    <tr><td colspan="2" align="center"><font style="font-size:30;font-weight:bold;font-family:Aarti">hlWanaI (naOnaItaala) {ttaraKaND</font></td></tr>
    
    </table>
    
    <table width="100%" align="center">
        
   
     
    <tr><td>&nbsp;</td></tr>
    <tr><td align="left"><font style="font-size:18;font-weight:bold;font-family:Aarti">k` maaMk</font><u>&nbsp;&nbsp;&nbsp;<%=tb.getRid()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td><td width="50%" align="center" bgcolor="black"><font class="font"><font color="white" style="font-size:27;font-weight:bold;font-family:Aarti">sqaanaantarNa pa`maaNaàpa~a</font></td><td align="right"><font style="font-size:18;font-weight:bold;font-family:Aarti">idnaaMk</font><u>&nbsp;&nbsp;&nbsp;<%=dat%>&nbsp;&nbsp</u></td></tr>
  
      <tr><td>&nbsp;</td></tr>

  
    <table width="100%" align="center" ><tr><td align="left"><font style="font-size:18;font-weight:bold;font-family:Aarti">naamaaMk na saM0</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getEnrolNo()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr></table>    
    <table width="100%" align="center" >
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">1) naama</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">2) janma itaiqa</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getDob()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u><font style="font-size:16;font-weight:bold;font-family:Aarti">(Ca~a paMijak a ko &nbsp;&nbsp;Anausaar)</font></td></tr><tr>&nbsp;</tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">3) ipataa k a naama E`aI </font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getFname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr><tr><td>&nbsp;</td></tr>
<tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">4) maataa k a naama  E`aImataI </font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getMname()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr><tr><td>&nbsp;</td></tr>
    
<tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">5) mahaivaValaya maoM pa`voaSa k a vaYa-</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getEntYear()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">6) mahaivaValaya maoM AQyayana k I AvaiQa</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getStudYear()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u><font style="font-size:16;font-weight:bold;font-family:Aarti">vaYa-</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getStudMonth()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u><font style="font-size:16;font-weight:bold;font-family:Aarti">maah</font></td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">7) Aintama parIXaaà</font></td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">A) k Xaa</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getLastClass()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">ba) parIXaaf laà{ttaINa-óAnauttaINa-óraok a gayaa</font></td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">sa) {ttaINa- E`aoNaI</font>________________<font style="font-size:16;font-weight:bold;font-family:Aarti">d) vaYa-</font>______________</td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">8) sqaanaantarNa k a k arNa</font><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tb.getMigrReason()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
  
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">9) AByaui> (yaid k ao[- hao)</font>______________________________</td></tr><tr><td>&nbsp;</td></tr>
    <tr><td width="100%"><font style="font-size:16;font-weight:bold;font-family:Aarti">maorI jaanak arI mao</font><font style="font-size:16;font-weight:bold;font-family:Aarti">&nbsp;[nak a cair~a evaM
    AacarNa AcCa hO| [nako &nbsp; Wara mahaivaValaya ko &nbsp;&nbsp;samasta&nbsp;doyaaoM k a Baugataana k r idyaa gayaa hO|</font></td></tr>      
    </table>
    <table width="100%" align="center" >
    <tr><td align="left" width="20%">&nbsp;</td></tr>
    
      <tr><td align="left" width="20%">&nbsp;</td></tr>
  
     
    <tr><td align="left" valign="top" width="20%"><font style="font-size:16;font-weight:bold;font-family:Aarti">hstaaXar ilaipak</font></td>
    
     
   
       
   <td width="100%" align="center"><table  width="100%" align="center" border="0"><tr><td width="20%" align="center"></td><td width="45%" align="center"><font style="font-size:16;font-weight:bold;font-family:Aarti">pa`acaaya-<br>ema.baI.rajak Iya snaatak aooottar mahaivaValaya<br>hlWanaI (naOnaItaala)</font></td></tr></table></td></tr>
    </table>    
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