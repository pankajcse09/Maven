<%-- 
    Document   : Bank_Entry
    Created on : Jul 2, 2013, 12:15:12 PM
    Author     : kapil
--%>

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
try{
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Name</title>
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
<tr><td align="center"><font style="font-size:14px;font-weight:bold;color:darkblue">Enter Bank Name</font></td></tr>    
</table></td></tr>
                <tr><td style="padding-left: 200px">                       
<form name="f1" method="post" action="<%=request.getContextPath()%>/bank.do?method=bankAct">
<table  align="center" border="1" style="border-collapse:collapse" width="500">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2" align="center"><font style="font-size:12;font-weight:bold;color:red"><%=request.getAttribute("msg")%></font></td></tr>
<%}%>    
<tr><td width="40%"><font style="font-size:12px;font-weight:bold">Bank Name</font></td><td width="60%"><input type="text" name="bnk" value=""></td></tr>    
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>  
</table>    
</form>
<hr color="maroon"> 
                    </td></tr>
<%}%>
<tr><td align="center" height="40" valign="bottom"><font style="font-size:14px;font-weight:bold;color:darkblue">View Bank Name</font></td></tr>                  
<tr><td style="padding-left: 200px">    
<table align="center" border="1" style="border-collapse:collapse" width="600">
    <tr align="center">
        <td>Sr no.</td><td>Bank name</td><td></td>
    </tr>
    <% if(al.size()!=0){
        for(int i=0;i<al.size();i++){
        seo1=(SchoolEO)al.get(i);
    %>
        <tr align="center">
            <td><%=i+1%></td>
            <td><%=seo1.getBankname()%></td>
            <td>
                <%if(urb.getUr_delete().equals(s)){%> 
                <a href="<%=request.getContextPath()%>/delBankname.do?method=delbn&id=<%=seo1.getRowid()%>">Delete</a>
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