<%-- 
    Document   : view_contentfile
    Created on : May 21, 2014, 1:30:35 PM
    Author     : kapil
--%>

<%@page import="Main_category.item_bean"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<%=request.getContextPath()%>/jquery.min.js"></script>
        <title>View Content File</title>
    </head>
    <body>
        <style>
.hilight a{
    text-decoration: none;
    font-family: Helvetica, Verdana;
    font-size: .8em;
    color: #C9D900;
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
    width: 170px;
    height: 100px;
 position: absolute;
 font-family: Verdana, Geneva, sans-serif;
 color: #FFF;
 top: 20px;
 left: 10px;
 z-index: 1;
 text-align: center;
 border-radius: 5px 5px;
}
.innerhilight{padding-top: 20px;}

#dlt
{
    border: 0px solid red;
    text-align: center;
}
#dlt a{color: red;text-decoration: none;}
.innerhilight span{margin: 5px 5px;}
</style>
<table border="0">
    <tr><td align="center"><b> 
  View Content File</b></td></tr>
      </table>
    <%   
        
    item_bean prodetail= new item_bean();  
         ArrayList filelist=new ArrayList();
    if(request.getAttribute("filelist")!=null)
{
  filelist=(ArrayList)request.getAttribute("filelist");
   //out.println(images);
}
      %>
      <%if(request.getAttribute("msg")!=null){%>
      <table border="0">
          <tr><td><%=request.getAttribute("msg")%></td></tr>
      </table>
      <%}%>
      <div id="replace">
      <table>
          <tr>
   <%for(int i=0;i<filelist.size();i++){
prodetail=(item_bean)filelist.get(i);
if(!prodetail.getCover_content().equals("")){
%>
<td style="border: 1px solid #A9A9A0" width="200">
    <div class = "promo">
    <span title="<%=prodetail.getCover_content()%>">
        <a href='<%=request.getContextPath()%>/viewfile?fl=<%=prodetail.getCover_content()%>' target="_blank">
        <img src="./images/pdf.png" title="" alt=""/>
        </a>
    </span><br>
    <%=prodetail.getCover_content()%><br>
    
    </div>
    <div id="dlt">
<a href="delete_content_file.do?id=<%=prodetail.getItem_id()%>&method=delcontentFile&fl=<%=prodetail.getCover_content()%>">Delete File
</a>
    </div>
</td>
<%}}%>
          </tr>
</table>
      </div>   
    </body>
</html>

