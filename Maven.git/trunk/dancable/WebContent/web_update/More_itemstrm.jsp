<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
    <body>
<%String galid="";
String strdate="";
if(request.getParameter("galid")!=null)
{
  galid=(String)request.getParameter("galid");
  

}else{

if(request.getAttribute("galid")!=null)
{
  galid=(String)request.getAttribute("galid");
  

}
}
if(request.getAttribute("strmdate")!=null)
{
  strdate=(String)request.getAttribute("strmdate");
 }
%>

<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="200" bordercolor="black">
    <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp"%></TD></TR>


<TR>
<TD WIDTH=100%  ALIGN="center" height="100">
      <form  action="evdStream.do?method=evdSt" enctype="multipart/form-data" method="post">
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="400" bordercolor="black">
    
     <%if(request.getAttribute("msguploaded")!=null)
      
  {
     %>
  <tr><td><font color="red">Files are Uploaded Successfully!</font></td></tr>
<%}%>
  <tr> 
    <td>Upload More Stream For Date <%=strdate%></td> </tr>
    <tr><td><input type="file" name="uploads[0]" size="35" /></td></tr>
    
      <tr><td><input type="file" name="uploads[1]" size="35" /></td></tr> 
    
      <tr>  <td><input type="file" name="uploads[2]" size="35" /></td>   </tr> 
    </tr> 
    
    <tr> 
    <td  align="center"> 
    <input type="hidden" name="galid" value="<%=galid%>">
    <input type="hidden" name="strmdate" value="<%=strdate%>">
    <input type="submit" name="save" value="Upload Images "> 
    </td> 
    </tr>   
    <tr><td>
    </td></tr>
 
</table><!--5nd table-->
   </form>
             
		
	</td></TR>
      
</table> 
    
    </body>
</html>
