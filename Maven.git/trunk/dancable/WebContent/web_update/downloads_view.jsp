<%-- 
    Document   : downloads_view
    Created on : Mar 18, 2014, 1:53:21 PM
    Author     : kapil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<%=request.getContextPath()%>/jquery.min.js"></script>
        <title>Downloading Files</title>
                
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

    <%   
        String galid=(String)request.getParameter("galid");
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();  
         ArrayList audiolist=new ArrayList();
    if(request.getAttribute("audios")!=null)
{
  audiolist=(ArrayList)request.getAttribute("audios");
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
          <%
    
      int count1=0;
      int n=audiolist.size();
       for (int c=0; c<n; c++)
       {    
     %>
     <tr>
              
   <% int count=0;
   for(int m=count1; m<n; m++){
prodetail=(Im_Projects_DataHold)audiolist.get(m);

%>
<td style="border: 1px solid #A9A9A0" width="200">
    <div class = "promo">
    <span title="<%=prodetail.getFilename()%>"><img src="./images/musicicon.png" title="" alt=""/></span><br>
    <%=prodetail.getTitle()%><br>
    
    </div>
    <div id="dlt">
<a href="delete_Dwn_itemFile.do?id=<%=prodetail.getRowid()%>&galid=<%=galid%>&method=delDwn_itemFile">Delete File
</a>
    </div>
</td>
<% 
        count++;
          count1++;
         if(count>6){break;}
          
      
         }
         
     %>
     </tr>
     <%
        
       }
     
    %> 
</table>
      </div>   
    </body>
</html>