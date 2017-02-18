<%-- 
    Document   : written_files_up
    Created on : Apr 8, 2014, 4:55:25 PM
    Author     : kapil
--%>
<% 
    String tp="";
    if(request.getParameter("tp")!=null)
    {
        tp=(String)request.getParameter("tp");
    }
else{

if(request.getAttribute("tp")!=null)
{
  tp=(String)request.getAttribute("tp");
  

}
}
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%if(tp.equals("sm")){%>
        <title>Upload Sample Written Music File</title>
        <%}else{%>
        <title>Upload Written Music File</title>
        <%}%>
    </head>
    <body>
        <%String galid="";
String scid="";

if(request.getParameter("galid")!=null)
{
  galid=(String)request.getParameter("galid");
  

}else{

if(request.getAttribute("galid")!=null)
{
  galid=(String)request.getAttribute("galid");
  

}
}

if(request.getParameter("scid")!=null)
{
  scid=(String)request.getParameter("scid");
  

}else{

if(request.getAttribute("scid")!=null)
{
  scid=(String)request.getAttribute("scid");
  

}
}
%>
<table WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="200" bordercolor="black">
    <tr><td><table>
    <html:form  action="up_wrtnMusic.do?method=uploadWrittenMusic" enctype="multipart/form-data" method="post">
    <tr> 
        <td><b>
                <%if(tp.equals("sm")){%>
        Upload Sample Written Music File
        <%}else{%>
        Upload Written Music File
        <%}%>
                </b></td> </tr>
     <%if(request.getAttribute("msguploaded")!=null)
      
  {
     %>
  <tr><td><font color="red"><%=request.getAttribute("msguploaded")%></font></td></tr>
<%}%>
    <tr><td>
            <html:messages id="err_name" property="name1"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
            Title:<html:text property="title1" size="35" /></td>
        <td>
            <html:messages id="err_name" property="file1"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
            <html:file property="uploads1" size="35" /></td></tr>
    
      <tr><td>
              <html:messages id="err_name" property="name2"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
              Title:<html:text property="title2" size="35" /></td>
          <td>
              <html:messages id="err_name" property="file2"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
              <html:file property="uploads2" size="35" /></td></tr> 
    
      <tr><td>
              <html:messages id="err_name" property="name3"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
              Title:<html:text property="title3" size="35" /></td> 
          <td>
              <html:messages id="err_name" property="file3"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
              <html:file property="uploads3" size="35" /></td>   </tr> 
     
    
   <tr><td>
           <html:hidden property="galid" value="<%=galid%>"/>
    <html:hidden property="scid" value="<%=scid%>"/>
    <html:hidden property="tp" value="<%=tp%>"/>
    </td></tr>
    
    
     <tr> <td  align="center"> 
    <html:submit property="save" value="Upload Samples "/> 
    </td> 
    </tr>   
    
</html:form>   
            </table></td></tr>
</table>
    </body>
</html>

