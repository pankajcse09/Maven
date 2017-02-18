<%-- 
    Document   : fundtransfer
    Created on : Jun 12, 2014, 11:05:56 AM
    Author     : kapil
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<!DOCTYPE html>


<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    ArrayList ar=new ArrayList();
    ArrayList ar2=new ArrayList();
    ArrayList ar3=new ArrayList();
    ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
    
   ar3.add("MEDICALAIM PREMIUM"); 
   ar3.add("STUDENT WELFARE DUES");
   ar3.add("COLLEGE OF AGRIBUSINESS DUES");
   ar3.add("FOOD SERVICE");
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
//ArrayList ar3=(ArrayList)seo.getDataArray();
String hd_cat="";
String hd_categ="";
if(request.getAttribute("hd_cat")!=null){
hd_cat=(String)request.getAttribute("hd_cat");   
}

if(request.getAttribute("hd_categ")!=null){
hd_categ=(String)request.getAttribute("hd_categ");   
}
try{
    DecimalFormat df = new DecimalFormat("0.00");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/JSF/jquery.min.js"></script>
<title>Fund Transfer</title>
<script language="javascript">
    function fund_transfer(a,b,c,d,e)
        {
            var url="<%=request.getContextPath()%>/PantReports/fund_transfer.jsp";
             url=url+"?b="+b+"&c="+c+"&d="+d+"&e="+e;   
            $.get( url, function( response ) {
                document.getElementById(a).innerHTML="<font style='color:red'>"+response+"</font>"; // server response
            });
        }
        
   function chkSubmittedAmount(a)
   {
       var b=document.f2.amount.value;
       //alert(parseFloat(b));
       //alert(a);
       if(parseFloat(b)>parseFloat(a)){
           alert("Amount should not be greater than remaining amount of fund.");
           document.f2.amount.focus();
           return false;
       }
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

.bt{background-color: green;
    color: #333333;}
         </style> 
    
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Reports/Fee Reports</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<table>
    <tr><td style="padding-left: 390px"><font color="darkblue" size="3"><u><b>Fund Transfer</b></u></font></td></tr> 
</table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/DispTotalHeadCatFee.do?method=totalHeadCatFee">
<table width="80%" align="center" border="1" style="border-collapse:collapse">
<tr><td width="30%"><font style="font-size:12;font-weight:bold">Session</font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
<select name="session_sem">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession_sem()%>"><%=seo.getSession_sem()%></option>
<%}%> 
<%for(int i=0;i<ar4.size();i++){
if(ar4.get(i).equals(seo.getSession_sem())){continue;}
%>    
<option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>    
<%}%>
</select>
    </td>     
<td ><font style="font-size:12;font-weight:bold">Funds</font><br>
<select name="heads_cat">
<%if(!seo.getHeads_cat().equals("")){%>
<option value="<%=seo.getHeads_cat()%>"><%=seo.getHeads_cat()%></option>
<%}%>  

<%for(int i=0;i<ar3.size();i++){
if(ar3.get(i).equals(seo.getHeads_cat())){continue;}
%>    
<option value="<%=ar3.get(i)%>"><%=ar3.get(i)%></option>    
<%}%>
</select></td>
<td >

<input type="submit" value="Submit"></td></tr></table>
</form>
<table width="80%" align="center" border="1" style="border-collapse:collapse" style="padding-top: 20px">
<tr><td width="30%"><font style="font-size:15;color:darkblue"><b>Session</b></font></td>
<td><font style="font-size:12"><b><%=seo.getSession()%> -<%=seo.getSession_sem()%></b></font></td></tr>
<tr><td width="30%"><font style="font-size:15;color:darkblue"><b>Funds</b></font></td>
    <td><font style="font-size:12"><b><%if(!hd_categ.equals("")){%><%=hd_categ%>/<%}%><%=seo.getHeads_cat()%></b></font></td></tr>
<tr><td width="30%"><font style="font-size:15;color:darkblue"><b>Total Fee(in Rs.)</b></font></td>
<td><font style="font-size:12"><b><%=df.format(seo.getFeeTotal())%></b></font></td></tr>  
</table>
<%
ArrayList heads_cat=seo.getDataArray2();
ArrayList heads_count=seo.getDataArray1();
ArrayList heads=seo.getDataArray3();
ArrayList transferlist=seo.getDataArray9();
HashMap hm=seo.getDataMap3();
SchoolEO se=null;
double tt1=0;
//out.println(ftrn);
%>
<%if(heads_cat.size()!=0&&hm.size()!=0){%>
<table width="100%" align="center">
    <tr><td align="right"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
    </tr></table>
    <div id="printit">
    <table width="100%">
       <tr><td align="center" valign="top"><b>FEE SUMMARY OF <i><%=seo.getHeads_cat()%></i> FOR THE SESSION <%=seo.getSession()%> -<%=seo.getSession_sem()%></b></td>
           <td align="center" valign="top"><b>FUND TRANSFER DETAILS OF <i><%=seo.getHeads_cat()%></i></b></td>
    </tr> 
        <tr>
            <td width="55%" align="center" valign="top">    
<table width="100%" border="1" style="border-collapse: collapse" align="left">
    <tr>
        <td><b>PARTICULARS</b></td>
        <td align="right"><b>
                <%if(!hd_categ.equals("")){%><%=hd_categ%><%}else{%>
                <%=hd_cat%> <%}%></b></td>
    </tr>
    <%for(int j=0;j<heads.size();j++)
    {%>
    <tr><td><%=heads.get(j)%></td>
        <%
            tt1=tt1+Double.parseDouble(hm.get(heads.get(j)).toString()); 
        %>
            <td align="right"><%=hm.get(heads.get(j))%> </td></tr>
     <%}%>
    <tr><td><b>TOTAL</b></td>
        <td align="right"><b><%=df.format(tt1)%></b></td>
    </tr>
</table>
            </td>
            <td width="45%" align="center" valign="top">
                <table width="100%" border="1" style="border-collapse: collapse">
                    <tr><td><b>Sr. No.</b></td><td><b>Transfer Date</b></td><td align="right"><b>Amount</b></td></tr>
                    <%
                    double ttref=0;
                    if(transferlist.size()!=0)
                      {
                        for(int i=0;i<transferlist.size();i++)
                         {
                            se=(SchoolEO)transferlist.get(i);
                            ttref=ttref+se.getTransfered_fund();
                        %>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=sdf1.format(se.getDeposite_date())%></td>
                            <td align="right"><%=df.format(se.getTransfered_fund())%></td>
                        </tr>
                        <%}
                        tt1=tt1-ttref;
%>
                    <tr><td colspan="2" align="right"><b>Total Transfered</b></td><td align="right"><%=df.format(ttref)%></td></tr>
                    <tr><td colspan="2" align="right"><b>Total Remaining</b></td><td align="right"><%=df.format(tt1)%></td></tr>
                        <%}%>
                </table>  
            </td>
        </tr></table>       
        </div>
<%if(urb.getUr_create().equals(s)){%>                       
 <form name="f2" action="<%=request.getContextPath()%>/fundtransfer.do?method=fund_transfer" method="post" onsubmit="return chkSubmittedAmount('<%=tt1%>')">
  <table border="1" width="40%" align="center" style="border-collapse: collapse">
        <tr><td colspan="2" align="center" height="30"><b>Fund Transfer</b></td></tr>
        <tr><td><b>Fund</b></td><td><%if(!hd_categ.equals("")){%><%=hd_categ%>/<%}%><%=seo.getHeads_cat()%><input type="hidden" name="heads_cat" value="<%=hd_cat%>"></td></tr>
        <tr><td><b>Amount</b></td><td><input type="text" name="amount"><input type="hidden" name="tt" value="<%=tt1%>"></td></tr>
        <input type="hidden" name="session" value="<%=seo.getSession()%>"><input type="hidden" name="session_sem" value="<%=seo.getSession_sem()%>">
        <tr><td colspan="2" align="center"><input type="submit" name="transfer" value="Transfer"></td></tr>
    </table>       
        </form>
        <%}%>
<%}%>
    
        
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e)
{
    //System.out.println("kp: "+e.getMessage());
}%>
