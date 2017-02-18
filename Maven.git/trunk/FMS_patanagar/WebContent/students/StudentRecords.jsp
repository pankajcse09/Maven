<%-- 
    Document   : StudentRecords
    Created on : Nov 4, 2014, 6:13:52 PM
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
ArrayList ar=(ArrayList)seo.getDataArray();
ArrayList heads=(ArrayList)seo.getDataArray();
ArrayList fee=(ArrayList)seo.getDataArray2();
ArrayList heads_cat=(ArrayList)seo.getDataArray3();
HashMap foodmap=(HashMap)seo.getDataMap1();
HashMap feemap=(HashMap)seo.getDataMap2();
HashMap datemap=(HashMap)seo.getDataMap3();
JavaBean jb=new JavaBean();
ArrayList headscat_count=new ArrayList();
  if(request.getAttribute("headscat_count")!=null){
headscat_count=(ArrayList)request.getAttribute("headscat_count");   
}
int cn=0;
for(int i=0;i<headscat_count.size();i++)
                           {
                            jb=(JavaBean)headscat_count.get(i);
                            cn=cn+jb.getCount();
                    }
String ss[]={"July","August","September","October","November","December","January","February","March","April","May","June"};
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
<title>Student Record</title>
    </head>
<body onload="focusField('stud_id');" bgcolor="#999933">
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
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/topdesign.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr>
  <td valign="top" align="left" colspan="2"> 
<form name="f1" method="post" action="<%=request.getContextPath()%>/studentRecord.do?method=genStudentLadder" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top">
                <font color="darkred" size="3">Student Record</font></td></tr></table>
<table align="left">
 <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font><br>
<select name="session">
<%
int ss1=0;
for(int i=0;i<=7;i++)
{
    ss1=Syear-i;
    %>
<option value="<%=ss1%>-<%=ss1+1%>"><%=ss1%>-<%=ss1+1%></option>
<%}%>
</select></td>
<td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font><br>
    <input type="text" name="stud_id">
<td valign="bottom"><input type="submit" value="Generate"></td></tr>    
</table>  
</form>

<table width="100%" align="center">
    <tr><td><hr color="maroon"></td></tr>
    <tr>
<td width="100%" align="left" valign="top"><a href="javascript:printStudLadder('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
</tr></table>
<div id="printit">  
<table align="center" cellspacing="0" cellpadding="0" valign="top" border="0">
    <tr><td align="center" colspan="2">  
       <b><span style="font-size:16px">G.B. Pant University of Agriculture & Technology, Pantnagar (U.S. Nagar)</span></b></td>
    </tr>
    <tr><td align="center" colspan="2">  
       <span style="font-size:16px">Student Record</span></td>
    </tr>
    <tr><td colspan="2"><table>
                <tr>
                    <td><b>Student Name: </b><%=seo.getSname()%> &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>Student Id: </b><%=seo.getStud_id()%> &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><b>Program: </b><%=seo.getDegree()%> &nbsp;&nbsp;&nbsp;&nbsp;</td>
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
    <%if(!seo.getStud_id().equals("")&&feemap.size()!=0){%> 
    <tr>
        <td valign="top"><table border="1" style="border-collapse: collapse;">
                            <tr height="177">
                                <td colspan="<%=cn+3%>" width="100%"><table width="60%"><tr>
                                <td valign="top" colspan="7" width="40%">
                                    <p> <span style="font-size:16px"><b>Session: <%=request.getParameter("session")%></b></span><br></p>
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
                                <td valign="top" colspan="2" width="30%"><b>Signature of Assistant</b></td>
                                <!--<td valign="top"></td>-->
                                <td valign="top" colspan="2" width="30%"><b>Signature of Accountant</b></td>  
                               <!-- <td valign="top" colspan="8"></td>-->
                                        </tr></table></td>
                            </tr>
                    <tr height="35">
                        <td valign="top" rowspan="2"><b>Month</b></td>
                        <td valign="top"></td>
                        <%for(int i=0;i<headscat_count.size();i++)
                           {
                            jb=(JavaBean)headscat_count.get(i);
                            %>
                        <td valign="top" align="center" colspan="<%=jb.getCount()%>"><b><%=jb.getHeads_cat()%></b></td>
                        <%}%>
                    </tr>
                    <tr height="70">
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Security Amount</span></td>
                        <%for(int i=0;i<heads.size();i++)
                           {
                            %>
                        <td valign="top"><span style="font-size:12px;font-weight: bold"><%=heads.get(i)%></span></td>
                        <%}%>
                        <!--<td valign="top"><span style="font-size:12px;font-weight: bold">Security Amount</span></td>
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
                        <td valign="top"><span style="font-size:12px;font-weight: bold">Miscellaneous</span></td>-->
                    </tr>
               <%
               
               int count=seo.getCounter();
               ArrayList ttlist[]=new ArrayList[ss.length];
               Double tt[]=new Double[ss.length];
               double tempsum=0.0;
               try{
               for(int i=0;i<ss.length;i++)
                {
                    tempsum=0.0;
                %>
                <tr>
                    <td height="20"><b><%=ss[i]%></b></td>
                    <td height="20"></td>
                    <%for(int j=0;j<heads.size();j++)
                        {
                            if(count>i){
                               if(!heads.get(j).equals("MONTHLY FOOD BILL")){
                                 //ttlist[i].add(feemap.get(heads.get(j)));  
                                   tempsum=tempsum+Double.parseDouble(feemap.get(heads.get(j)).toString());
                               %>
                               <td height="20"><%=feemap.get(heads.get(j))%> </td> 
                               <%}else{%>
                               <td>
                                   <%if(foodmap.get(ss[i])!=null){
                                       //ttlist[i].add(foodmap.get(s[i]));
                                       tempsum=tempsum+Double.parseDouble(foodmap.get(ss[i]).toString());
                                   out.println(df.format(foodmap.get(ss[i])));}%></td>
                               <%}%>
                      <%}else
                        {
                        if(!heads.get(j).equals("MONTHLY FOOD BILL")){ 
                       // ttlist[i].add(new Double(0)); 
                        %>  
                      <td height="20"> </td> 
                      <%}else{%>
                               <td>
                                   <%if(foodmap.get(ss[i])!=null){
                                   //  ttlist[i].add(foodmap.get(s[i]));
                                   tempsum=tempsum+Double.parseDouble(foodmap.get(ss[i]).toString());    
                                   out.println(df.format(foodmap.get(ss[i])));}%>
                               </td>
                               <%}%>
                      <%}}
                    tt[i]=tempsum;
                        %>
                </tr>
                <%}
}catch(Exception e)
{
    System.out.println("Ex: "+e.getMessage());
}                  
%>
                <tr height="25">
                    <td><b>Total</b></td>
                    <td></td>
                    <%
                    double sum=0.0;
                    for(int j=0;j<heads.size();j++)
                        {
                            
                               if(!heads.get(j).equals("MONTHLY FOOD BILL")){
                                %>
                               <td><%=feemap.get(heads.get(j))%> </td> 
                               <%}else{%>
                               <td>
                                   <%
                                   for(int i=0;i<ss.length;i++){
                                   if(foodmap.get(ss[i])!=null){
                                       sum=sum+Double.parseDouble(foodmap.get(ss[i]).toString());
                                   }%>
                               <%}%>
                               <%=df.format(sum)%>
                               </td>
                      <%}}%>
                </tr>
                </table></td>
    <!-- second cell  -->         
            <td valign="top">
               <table border="1" style="border-collapse: collapse;">
                   <tr><td colspan="12"><b>Adjustment of Balanced Due/ Description of Refund</b></td></tr>
                            <tr>
                                <td valign="top" colspan="3" height="155">
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
                    <tr height="105">
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
                    <%
                    double ttsum=0.0;
               for(int i=0;i<ss.length;i++)
                {
                    ttsum=ttsum+tt[i];
                %>
                <tr>
                    <%if(i==0){%>
                    <td height="20" align="right">0.00</td>
                    <%}else{%>
                    <td height="20" align="right"></td>
                    <%}%>
                    <td height="20" align="right"></td>
                    <td height="20" align="right"><%=df.format(tt[i])%></td>
                    <td height="20" align="right"></td>
                    <td height="20" align="right">
                     <%if(datemap.get(ss[i])!=null){%>
                        <%=sde.format((java.util.Date)datemap.get(ss[i]))%> 
                    <%}else{%>
                    
                    <%}%>
                    </td>
                    <td height="20" align="right"></td>
                    <td height="20" align="right"><%=df.format(tt[i])%></td>
                    <td height="20" align="right"></td>
                    <td height="20" align="right"></td>
                    <td height="20" align="right"></td>
                    <td height="20" align="right"></td>
                    <td height="20" align="right"></td>
                </tr>
                <%}%>
                <tr height="25">
                    <td align="right"></td>
                    <td align="right"></td>
                    <td align="right"><%=df.format(ttsum)%></td>
                    <td align="right"></td>
                    <td align="right"></td>
                    <td align="right"></td>
                    <td align="right"><%=df.format(ttsum)%></td>
                    <td align="right"></td>
                    <td align="right"></td>
                    <td align="right"></td>
                    <td align="right"></td>
                    <td align="right"></td>
                </tr>
                </table> 
            </td>
    </tr>
    <%}else{%>
    <tr><td><font style="color: yellow;font-weight: bold">Fee details is not found for the session <%=seo.getSession()%></font></td></tr>
    <%}%>
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


