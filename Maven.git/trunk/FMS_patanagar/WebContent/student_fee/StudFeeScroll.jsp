<%-- 
    Document   : StudFeeScroll
    Created on : Jul 11, 2013, 11:37:57 PM
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
if(request.getAttribute("chk")!=null)
       {
    check=(String)request.getAttribute("chk");
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
<title>FMS</title>
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
    if(document.f1.elements["session_sem"].value==""){
alert("Please select semester of this session.");
document.f1.elements["session_sem"].focus();
return false;
 }
        if(document.f1.elements["regist_no"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["regist_no"].focus();
            return false;
        }
        return true;
}
</script>

<script language="JavaScript">
      function Clickheretoprint()
{ 
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
  disp_setting+="scrollbars=yes,width=750, height=650, left=100, top=15"; 
  var content_vlue = document.getElementById("printit").innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><title></title>'); 
   docprint.document.write('</head><body onLoad="self.print();window.close();"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
}  
  
 </script>
</head>
<body onload="focusField('stud_id');" bgcolor="#999933">
    <% 
    SchoolEO seo1=new SchoolEO(); 
    ArrayList al=new ArrayList();
    if(request.getAttribute("list")!=null){
al=(ArrayList)request.getAttribute("list");
if(al.size()!=0){ 
seo1=(SchoolEO)al.get(al.size()-1);}
}
    %>
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
         SimpleDateFormat sde=new SimpleDateFormat("EEEEEEEE, d MMMMMMMMM, yyyy");
          java.util.Date rtdt=new java.util.Date();
          String rtrndt="";
          try{
          rtrndt=sde.format(rtdt);
                   }catch(Exception ee){}
         double regis_fee=0.0;
         ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
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
  <form name="f1" method="post" action="<%=request.getContextPath()%>/genStudFeeScroll.do?method=gen_studFeeScroll" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top">
                <font color="darkred" size="3">Generate Student Fee Scroll</font></td></tr></table>
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
     </td>
<td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font><br>
<input type="text" name="stud_id" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="Generate"></td></tr>    
</table>  
</form>
<hr color="maroon">
<% String msg="";
if(request.getAttribute("msg")!=null)
       {
    msg=(String)request.getAttribute("msg");
}
%>
<table width="90%" align="center"><tr><td align="left">
         <font color="yellow" size="2"><u><b><%=msg%></b></u></font></td>
     </tr></table>
                 
                  
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>




