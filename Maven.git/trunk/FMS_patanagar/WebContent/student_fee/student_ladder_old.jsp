<%-- 
    Document   : student_ladder
    Created on : May 10, 2014, 12:27:24 PM
    Author     : kapil
--%>

<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
MyMeth mm=new MyMeth();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar=(ArrayList)seo.getDataArray2();
ArrayList ar1=(ArrayList)seo.getDataArray();
ArrayList ar2=(ArrayList)seo.getDataArray1();
HashMap hm=(HashMap)seo.getDataMap();
HashMap hm1=(HashMap)seo.getDataMap1();
HashMap hm2=(HashMap)seo.getDataMap2();

//double tt=0.0;
String icar="";
String gate="";
icar=seo.getIcar();
gate=seo.getGate();
//if(request.getParameter("icar")!=null)
        //       {
   // icar=(String)request.getParameter("icar");
//}
//if(request.getParameter("gate")!=null)
  //             {
 //   gate=(String)request.getParameter("gate");
//}
ArrayList degreelist=new ArrayList();
  JavaBean de=new JavaBean();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
  
 SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String ddate="";
try{
    ddate=(String)sde.format(dt1);
    DecimalFormat df = new DecimalFormat("0.00");
%>
<html>
    <head>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>Student Ladder</title>
    </head>
<body onload="focusField('regist_no');" bgcolor="#999933">
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
         
         <% 
         double regis_fee=0.0;
          
         %>
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr>
  <td valign="top" align="left" colspan="2"> 
<form name="f1" method="post" action="<%=request.getContextPath()%>/genCmn_FeeScroll.do?method=gen_CmnFeeScrol" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Generate Student Ladder</font></td></tr></table>
<table width="35%" align="center">
 <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select></td>
<td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font><br>
    <input type="text" name="stud_id">
<td valign="bottom"><input type="submit" value="Generate"></td></tr>    
</table>  
</form>
<hr color="maroon">
<table width="100%" align="center"><tr>
<td width="100%" align="left" valign="top"><a href="javascript:printStudLadder('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<div id="printit">  
<table align="center" cellspacing="0" cellpadding="0" valign="top" border="0">
    <tr><td align="center" colspan="2">  
       <b><span style="font-size:16px">G.B. Pant University of Agriculture & Technology, Pantnagar (U.S. Nagar)</span></b></td>
    </tr>
    <tr><td align="center" colspan="2">  
       <span style="font-size:16px">Student Ladder</span></td>
    </tr>
    <tr><td colspan="2"><table>
                <tr>
                    <td><b>Student Name: </b>........ &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>Student Id: </b>........ &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>Program: </b>......... &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>College: </b>....... &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>Hostel: </b>........ &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>Room No.: </b>....... &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><table>
                            <tr><td><b>Period of amount release: </b>........<b>To: </b>........</td></tr>
                            <tr><td><b>Cell Advisor: </b>........<b>To: </b>........</td></tr>
                        </table>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><table>
                            <tr><td><b>Order No.: </b>.......</td></tr>
                            <tr><td><b>Order No.: </b>.......</td></tr>
                        </table>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td><table>
                            <tr><td><b>Date: </b>.......</td></tr>
                            <tr><td><b>Date: </b>.......</td></tr>
                        </table>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                </tr>
            </table></td></tr>
    <tr>
        <td valign="top"><table border="1" style="border-collapse: collapse;">
                            <tr height="177">
                                <td valign="top" colspan="7">
                                    <ul style="list-style: none;margin:0;padding: 0;">
                                        <li><b>Reference on previous ladder: </b>.........</li>
                                        <li><ol>
                                                <li><b>Food Advance: </b>.........</li>
                                                <li><b>Security Amount: </b>.........</li>
                                                <li><b>Security of Tour Amount: </b>.........</li>
                                                <li><b>Adjustable Advance: </b>.........</li>
                                            </ol></li>
                                    </ul>
                                </td>
                                <td valign="top" colspan="2"><b>Signature of Assistant</b></td>
                                <td valign="top"></td>
                                <td valign="top" colspan="2"><b>Signature of Accountant</b></td>  
                                <td valign="top" colspan="8"></td>
                            </tr>
                    <tr>
                        <td valign="top" rowspan="2"><b>Month</b></td>
                        <td valign="top"></td>
                        <td valign="top" colspan="10"><b>University Fund</b></td>
                        <td valign="top" colspan="5"><b>Student Welfare</b></td>
                        <td valign="top" colspan="3"><b>Food Service</b></td>
                    </tr>
                    <tr>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Security Amount</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Annual Due</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Adjustable Advance</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Half Yearly Due</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Admission/<br>Re-admission Fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Tuition Fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Electic/<br>Fan/<br>Water Fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Room Rent</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Tour Fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Caution Fine</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Miscellaneous</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Half Yearly Fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Student Society Fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Magazine fee</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Student Aid Fund</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Miscellaneous</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Food Advance</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Monthly Food Due</span></td>
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Miscellaneous</span></td>
                    </tr>
                </table></td>
    <!-- second cell  -->         
            <td valign="top">
               <table border="1" style="border-collapse: collapse;">
                   <tr><td colspan="12">Adjustment of Balanced Due/ Description of Refund</td></tr>
                            <tr>
                                <td valign="top" colspan="3">
                                    <ol>
                                         <li><b>Food Advance: </b>.........</li>
                                          <li><b>Security Amount: </b>.........</li>
                                           <li><b>Security of Tour Amount: </b>.........</li>
                                          <li><b>Adjustable Advance: </b>.........</li>
                                     </ol>
                                </td>
                                <td valign="top"><b>Net Amount(rs.)</b><br>......<br>.....</td>
                                <td valign="top"><b>Adjustment(rs.)<br></b>......<br>.....</td>
                                <td valign="top" colspan="2"><b>Total Refund Amount(rs.)</b><br>......<br>.....</td>  
                                <td valign="top" colspan="2"><b>Signature of Assistant Accountant</b><br>......<br>.....</td>
                                <td valign="top" colspan="2"><b>Signature of Accountant</b><br>......<br>.....</td>
                                <td valign="top"><b>Accounting Officer</b><br>......<br>.....</td>
                                <td valign="top"></td>
                            </tr>
                    <tr height="86">
                        <td valign="top"><b>Total Previous Remaining</b></td>
                        <td valign="top"><b>Current Liability</b></td>
                        <td valign="top"><b>Total Sum</b></td>
                        <td valign="top"><b>Signature of Assistant Accountant</b></td>
                        <td valign="top"><b>Date of Fee Submission</b></td>
                        <td valign="top"><b>Cash/Bank Deposit</b></td>
                        <td valign="top"><b>Total Deposited Amount</b></td>
                        <td valign="top"><b>Assistant Accountant/Accountant Signature</b></td>
                        <td valign="top"><b>Less<br> (-)</b></td>
                        <td valign="top"><b>More<br>(+)</b></td>
                        <td valign="top"></td>
                        <td valign="top" colspan="2"><b>Instructions</b></td>
                      </tr>
                    
                </table> 
            </td>
    </tr>
</table>
</div>
    <table width="100%" align="center"><tr>

<td width="100%" align="left" valign="top"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>

