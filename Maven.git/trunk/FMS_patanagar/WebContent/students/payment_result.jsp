<%-- 
    Document   : payment_result
    Created on : Oct 21, 2014, 1:20:12 PM
    Author     : kapil
--%>

<%@page import="pant.common.CommonFunctionality"%>
<%@page import="onlinepayment.PaymentDetailBean"%>
<%@page import="onlinepayment.PaymentDB"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="ActionClass.Common"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="Fee.FeeMath"%>
<%@page import="java.util.Random"%>
<%@ include file="fdgg-util_sha2.jsp" %>
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
        <title>Payment Response</title>
    </head> 
    
    <%
java.util.Date dt=new java.util.Date();    
DecimalFormat df = new DecimalFormat("0.00");
SchoolEO seo=new SchoolEO();  
if(session.getAttribute("seobean")!=null){
    session.removeAttribute("seobean");   
}

String stud_email=request.getParameter("email");
String stud_id=request.getParameter("udf1");
String ssn=request.getParameter("udf2");
String session_sem=request.getParameter("udf3");
String trIdByGateway=request.getParameter("mihpayid");
String status=request.getParameter("status");
String transaction_id=request.getParameter("txnid");
String gatewayKey=request.getParameter("key");
String amount=request.getParameter("amount");
String fname=request.getParameter("firstname");
String lname=request.getParameter("lastname");
String productinfo=request.getParameter("productinfo");
String mobile=request.getParameter("phone");
String hash=request.getParameter("hash");

CommonFunctionality cFun=new CommonFunctionality();
StringBuffer sb=new StringBuffer();
             sb=sb.append(fname.toUpperCase());
             sb=sb.append(" ");
             sb=sb.append(cFun.getStringFromString(lname).toUpperCase());
             
PaymentDetailBean paymentDetailBean=new PaymentDetailBean();
paymentDetailBean.setSession(ssn);
paymentDetailBean.setSession_sem(session_sem);
paymentDetailBean.setStud_id(stud_id);
paymentDetailBean.setTrIdByGateway(trIdByGateway);
paymentDetailBean.setTransactionId(transaction_id);
paymentDetailBean.setGatewayStatus(status);
paymentDetailBean.setPayeeName(sb.toString().trim());
paymentDetailBean.setEmail(stud_email);
paymentDetailBean.setMobile(mobile);
paymentDetailBean.setAmount(cFun.getDoubleFormString(amount));
paymentDetailBean.setDate(dt);

seo.setStud_id(stud_id);
FeeMath fm=new FeeMath();
PaymentDB pdb=new PaymentDB();
SchoolEO seo1=fm.getStudentDetails(seo);

String temp_session=ssn;
String temp_ssn_sem=session_sem;
String prev_session="";
if(session_sem.equals("I")){
            String f=temp_session.substring(0, temp_session.indexOf("-"));
                String l=temp_session.substring(temp_session.indexOf("-")+1, temp_session.length());
                prev_session=(Integer.parseInt(f)-1)+"-"+(Integer.parseInt(l)-1);
            temp_ssn_sem="II";
        }
        else{
            prev_session=ssn;
            temp_ssn_sem="I";
        }

seo1.setSession(prev_session);
seo1.setSession_sem(temp_ssn_sem);

//                seo1=pdb.retStudScrollFrom_stud_fee_detailForOnline(seo1); // this is used to get the fee details for online payment from stud_fee_detail table
             //  #######    now this block code is used to fetch the fee details for online payment from stud_fee_detail_excel table ######         
                    seo1.setDeposite_date(new java.util.Date());
                    seo1.setSession(ssn);
                    seo1.setSession_sem(session_sem);
                    pdb.calFineOnLateFeeSubmForOnline(seo1);
                    if(seo1.getTot_days()>0)
                              {
                                  double fine=0;
                                  if(seo1.getTot_days()==1)
                                      fine=seo1.getMin_fine();
                                  else{ 
                                      fine=seo1.getMin_fine()+(seo1.getTot_days()-1)*seo1.getPfine();
                                      if(fine>seo1.getMax_fine())
                                          fine=seo1.getMax_fine();
                                    }
                        seo1.setFine(fine);
                    }
                    seo1=fm.ret_stud_fee_detail_excel(seo1);
                  //  seo1.setDataArray(seo1.getDataArray2());
                  //  seo1.setDataMap(seo1.getDataMap1());
             //  #######    block code end     ######            
                    
                 /*   this is used to get the fee details for online payment from stud_fee_detail table
                   seo1.setSession(ssn);
                    seo1.setSession_sem(session_sem);
                    */
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
    <font style="font-size:15;color:black;font-weight:bold">Online Fee Payment Response</font></td>
                         <td align="right" valign="bottom"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></td>
                     </tr>
                     <tr><td width="100%" valign="bottom" align="center" height="30" colspan="2">
    <font style="font-size:15;color:black;font-weight:bold">
        Your payment is received online. Here Is your scroll. Please take printout of it.</font></td></tr>
                 </table>


<table width="80%" align="center"><tr><td>


<%
SimpleDateFormat sde1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");        
double tot_amount=seo1.getFeeTotal();
 tot_amount=seo1.getFine()+tot_amount;
     
     %>  
<table width="100%" align="center"><tr><td><hr></td></tr></table>
<table width="70%" border="0" align="center">
<tr><td valign="top" width="70%">
        <table width="100%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')">
                <font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
        <div id="printit">
      <table border="0" width="100%">
          
       
        <%
             
             seo1.setDeposite_date(dt);
             seo1.setFeeReceipt(fm.genFeeRecptNo());
             seo1.setBankname("PNB");
             seo1.setTransaction_id(transaction_id);
             seo1.setLoginName(sb.toString().trim()+"/onlinepayment");
             seo1.setMobile(mobile);
             int n= pdb.studentFeeSubmission(seo1,application); 
             //System.out.println("value of n: "+n);        
             if(n>0){        
                    fm.deleteLongRow(seo1.getRwid(), "stud_fee_detail_excel", "rwid");
                    paymentDetailBean.setAppStatus("success");
                 }
              else{
                    paymentDetailBean.setAppStatus("Fee is not processed through application");
                   }
             pdb.storeStudOnlinepayDetails(paymentDetailBean);
             seo1.setDataArray(seo1.getDataArray2());
             seo1.setDataMap(seo1.getDataMap1());
             ArrayList heads=(ArrayList)seo1.getDataArray();
             
             HashMap hm=(HashMap)seo1.getDataMap();
             seo1.setDataArray(seo1.getDataArray1());
             seo1.setDataMap(seo1.getDataMap2());
             seo1.setDeposite_date(dt);
             seo1.setFeeReceipt(fm.genFeeRecptNo());
             seo1.setBankname("PNB");
             seo1.setTransaction_id(transaction_id);
           //  seo1.setLoginName((String)session.getAttribute("name"));
             
            
   //          fm.subFeeHeadwise(seo1, seo1);
   //          fm.submitfeeData(seo1);
   //          fm.latefineprocess(seo1,dt);
            %>  
            <%if(n>0&&n<200){%>
                <tr><td align="center"><b>Your payment is received successfully.</b></td></tr>
             <%}else if(n==200){%>
                <tr><td align="center"><b>Your fee is already processed. If amount is debited from your bank account then please take a printout of this page and show in the comptroller office for cross check.</b></td></tr>
             <%}else {%>
                <tr><td align="center"><b>There is some error in saving the fee details. Please take a printout of this page and show in the comptroller office.</b></td></tr>
             <%}%>
           <tr><td><table width="70%">
                    <tr><td colspan="2"><b>Fee Scroll for(<%=seo1.getSession()%> -<%=seo1.getSession_sem()%>)</b></td></tr>
                    <tr><td width="40%"><b>Transaction Id: </b></td><td><%=transaction_id%></td></tr>
        <tr><td width="40%"><b>Student Id: </b></td><td><%=seo1.getStud_id()%></td></tr>
        <tr><td><b>Student Name: </b></td><td><%=seo1.getSname()%></td></tr>
        <tr><td><b>Programme: </b></td><td><%=seo1.getDegree()%></td></tr>
        <tr><td><b>Batch: </b></td><td><%=seo1.getBatch()%></td></tr>
        <tr><td><b>Email: </b></td><td><%=stud_email%></td></tr>
        <tr><td><b>Total Fee Submitted</b></td><td><%=df.format(tot_amount)%></td></tr>
         <%if(hm!=null&&heads.size()!=0){%> 
         <tr><td align="left"><b>Deposit Date</b></td><td align="left"><%=sde1.format(seo1.getDeposite_date())%></td></tr>
        <tr><td colspan="2"><hr></td></tr>
        <tr><td colspan="2">
               <table width="90%">
                  <%for(int i=0;i<heads.size();i++){%>
                  <tr><td align="left"><%=heads.get(i)%></td><td align="right"><%=df.format(Double.parseDouble(hm.get(heads.get(i)).toString()))%></td></tr>
                  <%}%>
                  <tr><td align="left">PROGRAMME FEE</td><td align="right"><%=df.format(seo1.getPamount())%></td></tr>
                  <tr><td align="left">Fine</td><td align="right"><%=df.format(seo1.getFine())%></td></tr>
                  <tr><td colspan="2"><hr></td></tr>
                  <tr><td align="left"><b>Total</b></td><td align="right"><%=df.format(tot_amount)%></td></tr>
                </table>
            </td></tr>
        <%}%>
        </table></td></tr>                    
</table>
        </div>   
    </td></tr>
 </table>
<%          
if(session.getAttribute("payment_id")!=null){
    session.removeAttribute("payment_id");
}     
  try{
       Properties props=new Properties();
       props.put("mail.transport.protocol","smtp");
       props.put("mail.smtp.host","mail.azansys.com");
       props.put("mail.smtp.auth", "true");
       props.put("mail.stmp.port","25");
           
            //Session sess = Session.getInstance(props);
            Session sess=Session.getInstance(props,new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("kapil.saini@azansys.com","kapil1990saini"); // username and the password
                }
 });
               //order_id="10320938545";
       MimeMessage msg1=new MimeMessage(sess);     
       Common comLogin = new Common();
       //String user=comLogin.jumbleData(mail);
       
       
       
       StringBuffer msg=new StringBuffer("<table><tr><td>***** Please DO NOT REPLY to this automated message. *****<br><br>");
       msg=msg.append("<b>Your Payment No.: </b>"+transaction_id+"<br>");
       msg=msg.append("<b>Sesion: </b>"+seo1.getSession()+"-"+seo1.getSession_sem()+"<br>");
       msg=msg.append("<b>Student Id: </b>"+seo1.getStud_id()+"<br>");
       msg=msg.append("<b>Student Name: </b>"+seo1.getSname()+"<br>");
       msg=msg.append("<b>Programme: </b>"+seo1.getDegree()+"<br>");
       msg=msg.append("<b>Amount Paid: </b>"+df.format(tot_amount)+"<br><br>");
       
       msg1.setFrom(new InternetAddress("kapil.saini@azansys.com"));
       //out.println("mail: "+mail);
       InternetAddress[] addre = {new InternetAddress(stud_email)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Your Payment Details");
            msg1.setSentDate(new Date());
            msg1.setContent(msg.toString(), "text/html; charset=utf-8");
            Transport.send(msg1,msg1.getAllRecipients());
       
  }  catch(Exception e)
  {
      out.println("ERROR SENDING EMAIL:"+e); 
  }
%>   

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

