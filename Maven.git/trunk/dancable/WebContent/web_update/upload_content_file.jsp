<%-- 
    Document   : upload_content_file
    Created on : May 20, 2014, 4:44:26 PM
    Author     : kapil
--%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Content File</title>
    </head>
    <body>
        <%String galid="";
String scid="";
String prod_id="";
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

if(request.getParameter("prod_id")!=null)
{
  prod_id=(String)request.getParameter("prod_id");
}else{
if(request.getAttribute("prod_id")!=null)
{
  prod_id=(String)request.getAttribute("prod_id");
}
}
%>
<table WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="200" bordercolor="black">
    <tr><td><table>
    <html:form  action="up_contentFile.do?method=up_contentFile" enctype="multipart/form-data" method="post">
    <tr> 
        <td><b>
                Upload Content File for <i><%=prod_id%></i>
                </b></td> </tr>
     <%if(request.getAttribute("msguploaded")!=null)
      
  {
     %>
  <tr><td><font color="red"><%=request.getAttribute("msguploaded")%></font></td></tr>
<%}%>
    <tr>
        <td>
            <html:messages id="err_name" property="file1"><font style="color:red"><bean:write name="err_name" /></font></html:messages>
            <html:file property="uploads1" size="35" /></td></tr>
     
    
   <tr><td>
           <html:hidden property="galid" value="<%=galid%>"/>
    <html:hidden property="scid" value="<%=scid%>"/>
    <input type="hidden" name="prod_id" value="<%=prod_id%>">
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
