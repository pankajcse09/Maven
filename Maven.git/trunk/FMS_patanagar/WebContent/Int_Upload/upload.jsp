<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<%@page import="AO.*,EO.*,java.text.*,java.util.*"%>
<% 
    SchoolEO seo=new SchoolEO();  
    int Syear=0;
    String prev="";
    String next="";
    try{
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String dat=sdf.format(dt);
    String Styear=sdf2.format(dt);
    Syear=Integer.parseInt(Styear);    
    prev=(Syear-1)+"-"+Syear;
    next=Syear+"-"+(Syear+1);
    }catch(Exception e){}
 %>
<html:html>
<head>
 <style type="text/css">  
 .body{margin-top:0;margin-left:80;margin-right:80"} 
 .font{font-size:10;color:darkblue;font-weight:bold} 
 .font2{font-size:8;color:red;font-weight:bold} 
 .text{width:120;height:15}
</style>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/validation.js"></script> 
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckDate.js"></script> 
    <script language="javascript">
     function toAllUpper(a){
     document.f1.elements[a].value=document.f1.elements[a].value.toUpperCase();   
     }   
  
     function validateForm(){
     if(document.forms[0].elements[0].value==""){
     alert("Select Session");     
     return false;
     }
     if(document.forms[0].elements[1].value==""){
     alert("Enter Admission Form No.");     
     return false;
     }
     if(document.forms[0].elements[2].value==""){
     alert("Select File to Upload");     
     return false;
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
                
                <tr><td style="padding-left: 200px">
<html:form action="/UploadAction" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
<table width="500" align="center">
<tr><td align="center" colspan="2"><font style="font-size:14;color:yellow;font-weight:bold">Select the File to Upload</font></td></tr>
<tr><td align="left" colspan="2"><font color="red"><html:errors/></font></td></tr>
</table>
<table width="500" align="center" border="1" style="border-collapse:collapse">
<%if(request.getAttribute("msg")!=null){%>    
<tr><td align="center" colspan="2"><font style="font-size:11;color:red;font-weight:bold"><%=request.getAttribute("msg")%></font></td></tr>  
<%}%>  
<tr><td align="left"><font style="font-size:11;color:black;font-weight:bold">Session</font></td>
<td align="left">
<html:select property="session">
 <%if(!seo.getSession().equals("")){%>   
<html:option value="<%=seo.getSession()%>"><%=seo.getSession()%></html:option>
<%}if(!seo.getSession().equals(prev)){%> 
<html:option value="<%=prev%>"><%=prev%></html:option>
<%}if(!seo.getSession().equals(next)){%> 
<html:option value="<%=next%>"><%=next%></html:option>
<%}%>
</html:select>    
</td></tr>

<tr><td align="left"><font style="font-size:11;color:black;font-weight:bold">Admin. Form No.</font></td>
<td align="left"><html:text property="adminNo" value=""/></td></tr>

<tr><td align="left"><font style="font-size:11;color:black;font-weight:bold">File Path</font></td>
<td align="left"><html:file property="filename"/></td></tr>

<tr><td align="center" colspan="2"><html:submit>Upload File</html:submit></td></tr>
</table>
</html:form> 
  </td></tr></table>
</td></tr> 

</table>
     </td></tr>
 <tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr></table>
</body>
</html:html>

