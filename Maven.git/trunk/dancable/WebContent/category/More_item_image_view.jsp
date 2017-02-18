<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page import="com.myapp.struts.Im_Proj_DataUtility"%>
<%@page language="java"%>
<%@page import="java.io.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery.min.js"></script>
        <title>Danceables</title>
        
        <script language="JavaScript">    
 function makeCover(en,cn,scid){ 
     var url="<%=request.getContextPath()%>/category/coverImage.jsp";
url=url+"?en="+en+"&cn="+cn+"&scid="+scid;
$.get( url, function( response ) {
    document.getElementById("replace").innerHTML=response; // server response
    //alert(response);
});
//location.reload();
}    

</script>
    </head>
    <body>
<style>
.hilight a{
    text-decoration: none;
    font-family: Helvetica, Verdana;
    font-size: .8em;
    color: #FFF;
    z-index: 200;
    border: 0px solid red;
}
.hilight a:hover{
    text-decoration: underline;
}

.promo {
    position: relative;
}
.promo img {
    z-index: 1;
}
.promo:hover .hilight {
    display:block;
 }

.hilight {
    display: none;
    background-color: rgba(0,0,0,0.50);
    width: 130px;
    height: 70px;
 position: absolute;
 font-family: Verdana, Geneva, sans-serif;
 color: #FFF;
 top: 70px;
 left: 10px;
 z-index: 1;
 text-align: center;
}
.innerhilight{padding-top: 20px;}

#dlt
{
    border: 0px solid red;
    text-align: center;
}
#dlt a{color: red;text-decoration: none;}
</style>
    <%   
        String it=(String)request.getParameter("galid");
        String scid=(String)request.getParameter("scid");
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();  
         ArrayList images=new ArrayList();
    if(request.getAttribute("images")!=null)
{
  images=(ArrayList)request.getAttribute("images");
   //out.println(images);
}
      %>
      <%if(request.getAttribute("msg")!=null){%>
      <table border="0">
          <tr><td><%=request.getAttribute("msg")%></td></tr>
      </table>
      <%}%>
      <div id="replace">
      <table border="0">
          <tr>
   <%for(int i=0;i<images.size();i++){
prodetail=(Im_Projects_DataHold)images.get(i);

%>
<td style="margin:5px 5px; padding: 5px 10px;">
    <div class = "promo">
        <span title="<%=prodetail.getFilename()%>"><img src="./moremusic_images/<%=prodetail.getFilename()%>" title="" alt="" width="150"/></span><br>
<div class="hilight">
    <div class="innerhilight">
<a href="#" onclick="makeCover('<%=prodetail.getId()%>','<%=it%>','<%=scid%>')">Make primary image
</a>
    </div>
    </div>
    </div>
<div id="dlt">
    <a href="delete_more_itemimage.do?id=<%=prodetail.getId()%>&galid=<%=it%>&scid=<%=scid%>&method=delMore_itemimage">Delete Image
</a>
</div>
</td>
<%}%>
          </tr>
</table>
      </div>    
    </body>
</html>
