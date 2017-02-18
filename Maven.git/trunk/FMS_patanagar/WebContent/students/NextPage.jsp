<%-- 
    Document   : dancable_Review_Order_connect2
    Created on : Oct 6, 2014, 12:07:27 PM
    Author     : kapil
--%>


<%@page import="java.util.Random"%>
<%@include file="util_sha256.jsp" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.*,java.util.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<HTML> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
        <title>Online Fee Payment</title>
    </head> 
    
    <%
    SimpleDateFormat sde=new SimpleDateFormat("yyyy");
    SimpleDateFormat sde1=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String Styear=sde.format(dt1);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    
DecimalFormat df = new DecimalFormat("0.00");
SchoolEO seo=new SchoolEO();  
if(session.getAttribute("seobean")!=null){
seo=(SchoolEO)session.getAttribute("seobean");   
}
//System.out.println("Stud_id: "+seo.getStud_id());
%>

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
<tr><td bgcolor="#FFFFCC" align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_payment.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
           
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
                 <table width="100%" align="center">
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">Online Fee Payment</font></td>
                         <td align="right" valign="bottom"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></td>
                     </tr>
                 </table>


<table width="80%" align="center"><tr><td>
<%if(seo.getCounter()==2){%>

<%
double tot_amount=seo.getFeeTotal();
 tot_amount=seo.getFine()+tot_amount;   
Random randomGenerator = new Random();
    SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
    java.util.Date dt=new java.util.Date();
    String orderId="";
    StringBuffer sb=new StringBuffer("TR");
    try{
    sb=sb.append(sdf.format(dt));
    sb=sb.append(Integer.toString(randomGenerator.nextInt(10000)));
    }catch(Exception e){
        int randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
    }
    orderId=sb.toString();
session.setAttribute("payment_id", orderId);
session.setAttribute("seobean", seo);
//out.println("order_id: "+session.getAttribute("order_id"));
  String fname=request.getParameter("fname");
  String lname=request.getParameter("lname");
  String email_ad=request.getParameter("email_ad");
  String mobile=request.getParameter("mob");
        String x_amount       = Double.toString(tot_amount);
     %>  
     <%
        String key=getTestKey();
        String salt=getTestSalt();
        
      //  String key=getLiveKey();
      //  String salt=getLiveSalt();
    //    System.out.println("key: "+key);
        String productinfo=fname+"-"+seo.getStud_id();
        StringBuffer hashString=new StringBuffer();
        hashString=hashString.append(key);
        hashString=hashString.append("|");
        hashString=hashString.append(orderId);
        hashString=hashString.append("|");
        hashString=hashString.append(x_amount);
        hashString=hashString.append("|");
        hashString=hashString.append(productinfo);
        hashString=hashString.append("|");
        hashString=hashString.append(fname);
        hashString=hashString.append("|");
        hashString=hashString.append(email_ad);
        hashString=hashString.append("|");
        hashString=hashString.append(seo.getStud_id()); //udf1
        hashString=hashString.append("|");
        hashString=hashString.append(seo.getSession());  //udf2
        hashString=hashString.append("|");
        hashString=hashString.append(seo.getSession_sem());  //udf3
        for(int i=0;i<7;i++){
            hashString=hashString.append("|");
            hashString=hashString.append("");
        }
        hashString=hashString.append("|");
        hashString=hashString.append(salt);
        //out.println("hashString: "+hashString);
        //out.print("<br>");
        String hash=hashCal("SHA-512",hashString.toString());
        //out.println("Hash: "+hash);
     %>
     <table width="100%" align="center"><tr><td><hr></td></tr></table>
		
<!--<form name="mainform" method="post" action="https://test.payu.in/_payment" onsubmit="return validate1()">-->
<form name="mainform" method="post" action="<%=request.getContextPath()%>/paymentresult.do">
    <input type="hidden" name="firstname" value="<%=fname%>" />
<input type="hidden" name="lastname" value="<%=lname%>" />
<input type="hidden" name="surl" value="http://localhost:8085/FMS_Pantnagar/students/payment_result.jsp" />
<input type="hidden" name="phone" value="<%=mobile%>" />
<input type="hidden" name="key" value="<%=key%>" />
<input type="hidden" name="hash" value = "<%=hash%>" />
<input type="hidden" name="curl" value="http://localhost:8085/FMS_Pantnagar/payment.do" />
<input type="hidden" name="furl" value="http://localhost:8085/FMS_Pantnagar/students/error.jsp" />
<input type="hidden" name="txnid" value="<%=orderId%>" />
<input type="hidden" name="productinfo" value="<%=productinfo%>" />
<input type="hidden" name="amount" value="<%=x_amount%>" />
<input type="hidden" name="email" value="<%=email_ad%>" />
<input type="hidden" name="pg" value="DC" />
<input type="hidden" name="drop_category" value="EMI,CASH" />
<input type="hidden" name="udf1" value="<%=seo.getStud_id()%>">
<input type="hidden" name="udf2" value="<%=seo.getSession()%>">
<input type="hidden" name="udf3" value="<%=seo.getSession_sem()%>">
<table width="100%" border="0" align="center">                 
<tr>
					
<td valign="top" width="100%">
      <table border="0" width="100%">
       <tr>
        <%
             ArrayList heads=(ArrayList)seo.getDataArray();
             HashMap hm=(HashMap)seo.getDataMap();
             
            %>  
            <td><table width="70%">
                    <tr><td colspan="2"><b>Fee Scroll for(<%=seo.getSession()%> -<%=seo.getSession_sem()%>)</b></td></tr>
        <tr><td width="40%"><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr>
        <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td></tr>
        <tr><td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <tr><td><b>Fee To Pay</b></td><td><%=df.format(tot_amount)%></td></tr>
        <tr><td><b>Date</b></td><td><%=sde1.format(seo.getDeposite_date())%></td></tr>
         <%if(hm!=null&&heads.size()!=0){%> 
         
        <tr><td colspan="2"><hr></td></tr>
        <tr><td colspan="2">
               <table width="90%">
                  <%for(int i=0;i<heads.size();i++){%>
                  <tr><td align="left"><%=heads.get(i)%></td><td align="right"><%=df.format(Double.parseDouble(hm.get(heads.get(i)).toString()))%></td></tr>
                  <%}%>
                  <tr><td align="left">PROGRAMME FEE</td><td align="right"><%=df.format(seo.getPamount())%></td></tr>
                  <tr><td align="left">Fine</td><td align="right"><%=df.format(seo.getFine())%></td></tr>
                  <tr><td colspan="2"><hr></td></tr>
                  <tr><td align="left"><b>Total</b></td><td align="right"><%=df.format(seo.getFeeTotal()+seo.getFine())%></td></tr>
                </table>
            </td></tr>
        <%}%>
        </table></td>
        <td valign="top">
            <table>
                <tr><td><b>Name</b></td><td><%=fname+" "+lname%></td></tr>
                <tr><td><b>Email</b></td><td><%=email_ad%></td></tr>
                <tr><td><b>Mobile Number</b></td><td><%=mobile%></td></tr>
                <tr><td colspan="2"><input type="submit" value="Continue to Secure Payment Form" id="button"></td></tr>
            </table>
        </td>     
        </tr>                    
</table></td></tr>

 </table>
     </form>
<%}%>
        </td>
        <td>
           <table>
               
                                                                                                                                          
             
              </table> 
        </td>
    </tr></table>
<table>
   <tr><td height="20"></td></tr> 
</table>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
