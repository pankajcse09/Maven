<%-- 
    Document   : feeprocess
    Created on : May 28, 2014, 5:09:13 PM
    Author     : kapil
--%>

<%@page import="Fee.FeeMath"%>
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
FeeMath fm=new FeeMath();
ArrayList bnklist=fm.bankList();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList list=new ArrayList();
if(request.getAttribute("list")!=null)
    list=(ArrayList)request.getAttribute("list");
SchoolEO seo1=null;  

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
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>Process Fee</title>
<script language="JavaScript">     
function validate(){
    if(document.f1.elements["session_sem"].value==""){
alert("Please select semester of this session.");
document.f1.elements["session_sem"].focus();
return false;
 }
    if(document.f1.elements["stud_id"].value==""){
alert("Enter Student Id");
document.f1.elements["stud_id"].focus();
return false;
 }

if(document.f1.elements["famount"].value==""){
alert("Enter Amount");
document.f1.elements["famount"].focus();
return false;
 }

return true;
}

function generateFine(a,b,c)
{
    window.open('<%=request.getContextPath()%>/student_fee/slip.jsp?stud_id='+b+'&ssn='+a+'&ssnm='+c,'trace','width=600,height=400,toolbar=no,scrollbars=yes,resizable=no');
}
</script> 
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
         
         <% 
         double regis_fee=0.0;
          
    String bnk="";
    if(request.getAttribute("bnk")!=null)
               {
        bnk=(String)request.getAttribute("bnk");
    }
    ArrayList banklist=new ArrayList();
    if(request.getAttribute("bnklist")!=null)
               {
        banklist=(ArrayList)request.getAttribute("bnklist");
    }
    ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
    %>
         
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
<!--<form name="f1" method="post" action="<%=request.getContextPath()%>/feeprocess.do?method=feeprocessing" onsubmit="return validate()">-->
 <form name="f1" method="post" action="<%=request.getContextPath()%>/feeprocess.do?method=Fee_Processing" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Process Fee</font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    <%if(request.getAttribute("msg")!=null){%>
        <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
            <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
        </table>
    <%}%>
<table width="35%" align="center">
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
 <select name="session_sem">
    <%
    if(!seo.getSession_sem().equals("")){%>
    <option value="<%=seo.getSession_sem()%>"><%=seo.getSession_sem()%></option>
    <%}%>
    <option value="">select</option>
    <%for(int i=0;i<ar4.size();i++)
    {
if(!seo.getSession_sem().equals(ar4.get(i).toString())){
%>
    <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>
    <%}}%>
</select> 
        </td></tr>
   <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td>
       <td><input type="text" name="stud_id" value="" size="10"><input type="submit" name="submit" value="Check"></td></tr>
  <%if(urb.getUr_create().equals(s)){%>      
    <tr><td align="left"><font style="font-size:12" color="white"><b>Bank</b></font></td>
        <td> <select name="bnk_name">
                <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td></tr>
    <!--<tr><td valign="top"><font style="font-size:12;color:white"><b>Transaction ID</b></font></td>
        <td><input type="text" name="tran_id" value="<%=seo.getTransaction_id()%>"></td></tr>-->
    <tr><td align="left"><font style="font-size:12" color="white"><b>Deposit Date</b></font></td>
                <td align="left"><script>DateInput('date1',true,'dd/mm/yyyy')</script></td></tr>
    <tr><td></td><td><input type="submit" name="submit" value="Process"></td></tr>
  <%}%>  
   </table>  
</form>
    <hr color="maroon">
   
    
    <%if(request.getAttribute("msg1")!=null){%>
    <table width="90%" align="center">
           <tr><td align="left" widht="100%"><font color="yellow" size="2"><%=request.getAttribute("msg1")%></font></td></tr>
      </table>
    <%}%>
    <%if(!seo.getStud_id().equals("")){%>
    <table width="90%" align="center" border="1" style="border-collapse: collapse;">
        <tr>
        <%
        double total_amount=0;
        for(int k=0;k<list.size();k++)
          {
             seo1=(SchoolEO)list.get(k); 
             ArrayList heads=(ArrayList)seo1.getDataArray();
             HashMap hm=(HashMap)seo1.getDataMap();
             double tt=seo1.getFeeTotal();
            %>  
            <td><table>
                    <tr><td colspan="2"><b>Fee Scroll (<%=seo.getSession()%> -<%=seo.getSession_sem()%>)</b></td></tr>
        <tr><td width="40%"><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr>
        <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td></tr>
        <tr><td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <%if(k==0)
        {
            tt=seo.getFine()+tt;
        %>
        <tr><td align="left"><b>Fine</b></td><td> <%=seo.getFine()%></td></tr>
        <%}
        total_amount=total_amount+tt;
     %>
        <tr><td><b>Total Fee Submitted</b></td><td><%=df.format(tt)%></td></tr>
         <%if(heads.size()!=0){%> 
         <tr><td align="left"><b>Deposit Date</b></td><td align="left"><%=sde.format(seo1.getDeposite_date())%></td></tr>
         <%if(!seo1.getBankname().equals("")){%>
        <tr><td align="left"><b>Bank</b></td><td> <%=seo1.getBankname()%></td></tr>
        <%}%>
        <tr><td colspan="2"><hr></td></tr>
        <tr><td colspan="2">
               <table width="90%">
                  <%for(int i=0;i<heads.size();i++){%>
                  <tr><td align="left"><%=heads.get(i)%></td><td align="right"><%=df.format(Double.parseDouble(hm.get(heads.get(i)).toString()))%></td></tr>
                  <%}%>
                  <tr><td align="left">PROGRAMME FEE</td><td align="right"><%=df.format(seo1.getPamount())%></td></tr>
                  <tr><td align="left">Extra</td><td align="right"><%=df.format(seo1.getEamount())%></td></tr>
                  <tr><td colspan="2"><hr></td></tr>
                  <tr><td align="left"><b>Total</b></td><td align="right"><%=df.format(seo1.getFeeTotal())%></td></tr>
                </table>
            </td></tr>
        <%}%>
        </table></td>
             <%}%>   
        </tr>
     </table>
<%if(urb.getUr_create().equals(s)){%>            
                <%if(seo.getCounter()!=2&&seo.getTot_days()==0){
                    session.setAttribute("total_amount", Double.toString(total_amount));
    %>
                <form name="f1" method="post" action="<%=request.getContextPath()%>/provideNodues.do?method=noduesProcessing">
                <table width="35%" align="center">
                    <input type="hidden" name="session" value="<%=seo.getSession()%>">
                    <input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
                    <input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
                    <tr><td align="right" widht="100%"><input type="submit" name="nodues" value="No Dues"></td></tr>
                </table>
                </form>
                    <%}%>
                
                <%if(seo.getTot_days()>0)
                {
                    double fine=0;
                    if(seo.getTot_days()==1)
                        fine=seo.getMin_fine();
                    else{ 
                        fine=seo.getMin_fine()+(seo.getTot_days()-1)*seo.getPfine();
                        if(fine>seo.getMax_fine())
                            fine=seo.getMax_fine();
                      }
                %>
                <form name="f2" method="post" action="<%=request.getContextPath()%>/processLateFine.do?method=lateFineProcessing">
                <table width="35%" align="center">
                    <tr><td colspan="2" height="10"></td></tr>
                    <tr><td colspan="2">
                            <table width="100%"><tr>
                                    <td><b>Process Fine On Late Fee Submission</b></td>
                                    <td align="right">
                                        <span style="color: blue;cursor: pointer" onclick="generateFine('<%=seo.getSession()%>','<%=seo.getStud_id()%>','<%=seo.getSession_sem()%>')">
                                            Generate Fine</span>
                                    </td>
                                </tr></table>
                                    </td></tr>
                    <input type="hidden" name="session" value="<%=seo.getSession()%>">
                    <input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
                    <input type="hidden" name="deposit_date" value="<%=seo.getDeposite_date()%>">
                    <input type="hidden" name="last_date" value="<%=seo.getLastdate()%>">
                    <tr><td><font style="font-size:12" color="white"><b>Student Id</b></font></td>
                        <td><input type="text" name="stud_id" value="<%=seo.getStud_id()%>" readonly></td></tr>
                    <tr><td><font style="font-size:12" color="white"><b>Fine</b></font></td>
                        <td><input type="text" name="latefine" value="<%=fine%>"></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Bank</b></font></td>
                        <td><select name="bank">
                <% for(int i=0;i<bnklist.size();i++){%>
               <option value="<%=bnklist.get(i)%>"><%=bnklist.get(i)%></option>
               <%}%>
            </select></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Receipt No</b></font></td>
                        <td><input type="text" name="receipt"></td></tr>
                    <tr><td align="left"><font style="font-size:12" color="white"><b>Deposit Date</b></font></td>
                <td align="left"><script>DateInput('date2',true,'dd/mm/yyyy')</script></td></tr>
                    <tr><td align="center" colspan="2"><input type="submit" name="fine" value="Process Fine"></td></tr>
                </table>
                </form>
                <%}%>
                <%if(seo.getCounter()!=0&&seo.getCounter()!=1){%>
                <table width="35%" align="center"><tr><td align="right">
                  <a href="<%=request.getContextPath()%>/fineafN.do?method=finePr&stud_id=<%=seo.getStud_id()%>&session=<%=seo.getSession()%>&ses=<%=seo.getSession_sem()%>">Fine</a>
                        </td></tr></table>
                <%}%>
                <%}%>
             <%}%>   
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>
