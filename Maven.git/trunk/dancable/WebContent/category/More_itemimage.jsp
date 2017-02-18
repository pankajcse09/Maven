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

<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="200" bordercolor="black">
    <form  action="gal_img.do" enctype="multipart/form-data" method="post">
    <tr> 
    <td>Upload Document</td> </tr>
     <%if(request.getAttribute("msguploaded")!=null)
      
  {
     %>
  <tr><td><font color="red">Your Images are Uploaded Successfully!</font></td></tr>
<%}%>
    <tr><td><input type="file" name="uploads[0]" size="35" /></td></tr>
    
      <tr><td><input type="file" name="uploads[1]" size="35" /></td></tr> 
    
      <tr>  <td><input type="file" name="uploads[2]" size="35" /></td>   </tr> 
    </tr> 
    
    <tr> 
    <td  align="center"> 
    <input type="hidden" name="galid" value="<%=galid%>">
    <input type="hidden" name="scid" value="<%=scid%>">
    <input type="submit" name="save" value="Upload Images "> 
    </td> 
    </tr>   
    <tr><td>
    </td></tr>
</form>   
</table><!--5nd table-->
    
    
    </body>
</html>
