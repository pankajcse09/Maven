<%-- 
    Document   : programmefee
    Created on : Jun 6, 2014, 9:46:09 AM
    Author     : kapil
--%>

<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<%
ArrayList al=new ArrayList();
if(request.getAttribute("list")!=null)
       {
    al=(ArrayList)request.getAttribute("list");
}
SchoolEO seo1=new SchoolEO(); 

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

ArrayList degreelist=new ArrayList();
  JavaBean de=new JavaBean();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
try{
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>College Management System</title>
<script language="javascript">
       function validate()
        {
    
        if(document.f1.elements["degree"].value=="select one")
        {
            alert("Please select one degree");
           document.f1.elements["degree"].focus();
            return false;
        }
        if(document.f1.elements["amount"].value=="")
        {
            alert("Please Enter Programme Fee.");
           document.f1.elements["amount"].focus();
            return false;
        }
        return true;
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
        <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
<%if(urb.getUr_create().equals(s)){%>                     
                <tr><td>
<table style="padding-left: 400px">
<tr><td align="center"><font style="font-size:14px;font-weight:bold;color:darkblue">Enter Self Finance Amount of Programme</font></td></tr>    
</table></td></tr>
                <tr><td style="padding-left: 200px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/programmefee.do?method=programme_fee" onsubmit="return validate();">
<table  align="center" border="1" style="border-collapse:collapse" width="500">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2" align="center"><font style="font-size:12;font-weight:bold;color:red"><%=request.getAttribute("msg")%></font></td></tr>
<%}%>    
<tr><td valign="top"><font style="font-size:12;font-weight:bold"><b>Batch</b></font></td>
    <td><select name="batch">
<%if(!seo.getBatch().equals("")){%>   
<option value="<%=seo.getBatch()%>"><%=seo.getBatch()%></option>
<%}for(int i=0;i<=7;i++)
{
    if(!seo.getBatch().equals(Syear-i)){
        %>
<option value="<%=Syear-i%>"><%=Syear-i%></option>
<%}}%>
</select></td></tr>
<tr>
    <td valign="top"><font style="font-size:12px;font-weight:bold"><b>Degree</b></font></td>
    <td><select name="degree">
<%if(seo.getDegree().equals("")){%>  
    <option value="select one">select one</option>
    <%}%>
    <%if(!seo.getDegree().equals("")){%>    
<option value="<%=seo.getDegree()%>"><%=seo.getDegree()%></option> 
<%}%>
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(seo.getDegree())){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
</select></td>
</tr>
<tr><td width="40%"><font style="font-size:12px;font-weight:bold">Self Finance Amount</font></td>
    <td width="60%"><input type="text" name="amount" value=""></td></tr>    
<tr><td colspan="2" align="center"><input type="submit" name="submit" value="Submit"></td></tr>  
</table>    
</form>
<hr color="maroon"> 
                    </td></tr>
                <%}%>
<tr><td align="center" height="40" valign="bottom"><font style="font-size:14px;font-weight:bold;color:darkblue">View Self Finance Amount of Programme</font></td></tr>                  
<tr><td style="padding-left: 200px">                   
<table align="center" border="1" style="border-collapse:collapse" width="600">
    <tr align="center">
        <td><b>Sr no.</b></td><td><b>Batch</b></td><td><b>Programme</b></td><td><b>Self Finance Amount</b></td><td></td>
    </tr>
    <% if(al.size()!=0){
        for(int i=0;i<al.size();i++){
        seo1=(SchoolEO)al.get(i);
    %>
        <tr align="center">
            <td><%=i+1%></td>
            <td><%=seo1.getBatch()%></td>
            <td><%=seo1.getDegree()%></td>
            <td><%=seo1.getPamount()%></td>
            <td>
              <%if(urb.getUr_delete().equals(s)){%>   
                <a href="<%=request.getContextPath()%>/delProgrammeFee.do?method=delProgFee&id=<%=seo1.getRowid()%>">Delete</a>
            <%}%>
            </td>
        </tr>
        <%}}%>
</table>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>
