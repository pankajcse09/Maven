<%-- 
    Document   : counscelling_fee
    Created on : Jul 2, 2013, 11:34:38 AM
    Author     : kapil
--%>



<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
ArrayList banklist=new ArrayList();
String check="";
String rcptno="";
if(request.getAttribute("chk")!=null)
       {
    check=(String)request.getAttribute("chk");
}
if(request.getAttribute("rcno")!=null)
       {
    rcptno=(String)request.getAttribute("rcno");
}
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
ArrayList al=new ArrayList();
if(request.getAttribute("list")!=null){
    al=(ArrayList)request.getAttribute("list");
  }
ArrayList ar=(ArrayList)seo.getDataArray2();
HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;
try{
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
<title>Counselling Fee</title>
<script language="javascript">
 function enrollStud(){
 document.f2.method="post";
 document.f2.action="<%=request.getContextPath()%>/Enr_Stud.do?method=genIdCard";
 document.f2.submit();
 }
 function genIdCard(){
 var ssn=document.f1.elements["session"].value;
 var rno=document.f1.elements["regist_no"].value; 
 window.open('<%=request.getContextPath()%>/Disp_IdCard.do?method=retIdCardAct&rn='+rno+'&ssn='+ssn,'trace','height=230,width=350,toolbar=no,scrollbars=yes,resizable=no');
 }
 function focusField(a){
 document.f1.elements[a].focus();
 }
 
 function cal_tot(){
      //alert(documnet.f2.elements["feetotal"].value);
     var reg=document.f2.elements["reg_fee"].value;
     var sem=document.f2.elements["sem_totfee"].value;
     
     var fn=document.f2.elements["fine"].value;
     //alert(fn);
     document.f2.elements["feetotal"].value=parseFloat(sem)+parseFloat(fn)-parseFloat(reg);
     //document.f2.elements["feetotal"].value=fn+sem;
     //alert('documnet.f2.elements["feetotal"].value');
}
function validate()
{
    
        if(document.f1.elements["regist_no"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["regist_no"].focus();
            return false;
        }
        return true;
}

function validate1()
{
    var session_sem=document.f2.elements["session_sem"];
    var dd1=document.f2.elements["dd_1"].value;
    var bank1=document.f2.elements["bnk_1"].value;
        if(session_sem.value=="")
        {
            alert("Please Session Semester");
            session_sem.focus();
            return false;
        }
        if(document.f2.elements["dd_1"].value=="")
        {
            alert("Please Draft no for 1");
           document.f2.elements["dd_1"].focus();
            return false;
        }
        if(document.f2.elements["damnt_1"].value=="")
        {
            alert("Please Amount for 1");
           document.f2.elements["damnt_1"].focus();
            return false;
        }
        if(document.f2.elements["bnk_1"].value=="")
        {
            alert("Please Bank name for 1");
           document.f2.elements["bnk_1"].focus();
            return false;
        }
        
        var dd2=document.f2.elements["dd_2"].value;
        var bank2=document.f2.elements["bnk_2"].value;
        if(document.f2.elements["dd_2"].value.length!=0)
        {
            if(document.f2.elements["damnt_2"].value=="")
            {
                alert("Please Amount Cash Receipt for 2");
                document.f2.elements["damnt_2"].focus();
                return false;
            }
            if(document.f2.elements["bnk_2"].value=="")
            {
                alert("Please Bank name Cash Receipt for 2");
                document.f2.elements["bnk_2"].focus();
                return false;
            }
            else
            {
                if(bank1==bank2&&dd1==dd2){
                    alert("Draft number can not be same for the same bank "+bank1);
                    document.f2.elements["dd_2"].focus();
                    return false;
                }
        }
        }
      return true;
}
</script>
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int month = cal.get(Calendar.MONTH);

        String[] ssn_sm=new String[2];
        if(month>=0&&month<4){ 
            ssn_sm[0]="II";
            ssn_sm[1]="I";
        }
        if(month>=4&&month<=11){ 
            ssn_sm[0]="I";
            ssn_sm[1]="II";
        }
     %>
         
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 
            <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
<form name="f1" method="post" action="<%=request.getContextPath()%>/couns.do?method=retCounsDetail" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top"><font color="darkred" size="3">Counselling Fee</font></td></tr></table>
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
<td valign="top"><font style="font-size:12;color:white"><b>Roll No</b></font><br>
<input type="text" name="regist_no" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="Show"></td></tr>    
</table>  
</form>
<hr color="maroon">
<%if(request.getAttribute("msg1")!=null){%>
<font color="yellow" size="3"><b><%=request.getAttribute("msg1")%></b></font>
<%}%>
<form name="f2" method="post" action="<%=request.getContextPath()%>/addcouns.do?method=entCounsFee" onsubmit="return validate1()">
<% if(!check.equals(""))
       {
    banklist=(ArrayList)seo.getDataArray();
%>
<table width="80%" ><tr><td>
                         <td align="center"><font color="yellow" size="3">
                             <% if(request.getAttribute("msg")!=null){%>
                             <%=request.getAttribute("msg")%></font>
                         <%}%></td>
                     </tr></table>
<table border="1" style="border-collapse: collapse" align="center" width="80%">
    <tr><td>
<table>
    <tr><td colspan="3"><font style="font-size: 16px"><b>Student Details</b></font></td>
        <td><font style="font-size: 14px"><b>Receipt no.&nbsp;<%=rcptno%></b></td></tr><input type="hidden" name="rcptno" value="<%=rcptno%>">
    <tr><td colspan="1">Session:</td><td colspan="2"><%=seo.getSession()%>
            <select name="session_sem" id="session_sem">
                <%for(int i=0;i<ssn_sm.length;i++){%>   
                    <option value="<%=ssn_sm[i]%>"><%=ssn_sm[i]%></option>
                <%}%>
                <option value="">Session Semester</option>
             </select>
        </td></tr><input type="hidden" name="session" value="<%=seo.getSession()%>">
    <tr><td colspan="1">Roll no.:</td><td colspan="2"><%=seo.getSrnum()%></td></tr><input type="hidden" name="regist_no" value="<%=seo.getSrnum()%>">
    <tr><td colspan="1">Student Name:</td><td colspan="2"><%=seo.getSname()%></td></tr><input type="hidden" name="sname" value="<%=seo.getSname()%>">
    <tr><td colspan="1">Father Name:</td><td colspan="2"><%=seo.getFname()%></td></tr><input type="hidden" name="fname" value="<%=seo.getFname()%>">
    <tr><td colspan="1">Category Code:</td><td colspan="2"><%=seo.getCategory()%></td></tr><input type="hidden" name="category" value="<%=seo.getCategory()%>">
    <!--<tr><td colspan="1">DOB:</td><td colspan="2"><%=seo.getDob()%></td></tr><input type="hidden" name="dob" value="<%=seo.getDob()%>">-->
    <tr><td colspan="1">Gender:</td><td colspan="2"><%=seo.getGender()%></td></tr><input type="hidden" name="gender" value="<%=seo.getGender()%>">
    <tr><td colspan="5"></td></tr>
    <tr><td colspan="5"></td></tr>
    <tr><td colspan="5"><font style="font-size: 16px"><b>Counselling Fee Details</b></font></td></tr>
    
       <tr align="center"><td></td><td><b>DD no</b></td><td><b>Date<font color="red">(dd/mm/yyyy)</font></b></td><td><b>Amount</b></td><td><b>Bank</b></td></tr>
     <% for(int j=0;j<al.size();j++)
     {
         seo=(SchoolEO)al.get(j);
    %>
       <tr><td><b>#</b></td><td><input type="text" value="<%=seo.getDdno()%>" disabled></td>
           <td style="padding-right: 10px"><input type="text" value="<%=seo.getDdate()%>" disabled></td>
           <td><input type="text" value="<%=seo.getDdamount()%>" disabled></td><td><input type="text" value="<%=seo.getBankname()%>" disabled></td>
                            </tr> 
       <%}%>
       <% for(int j=0;j<2;j++){%>
                            <tr><td><b>Cash Receipt #<%=j+1%></b></td><td><input type="text" name="dd_<%=j+1%>" value=""></td><td style="padding-right: 10px"><script>DateInput('dddate_<%=j+1%>',true,'dd/mm/yyyy')</script><!--<input type="text" name="dddate_<%=j+1%>" value="">--></td>
                                <td><input type="text" name="damnt_<%=j+1%>" value=""></td><td><% if(banklist.size()!=0){%>
            <select name="bnk_<%=j+1%>">
                <option value="">select</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select>
        <%}%></td>
                            </tr>
                            <%}%>
</table>  
        </td></tr>
    <tr><td align="center"><input type="submit" value="Submit"></td></tr>
</table>
<%}%>
</form>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>


