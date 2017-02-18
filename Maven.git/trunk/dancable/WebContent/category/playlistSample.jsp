<%-- 
    Document   : playlistSample
    Created on : Dec 24, 2013, 1:49:50 PM
    Author     : kapil
--%>

<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page import="java.util.ArrayList"%>
<%@page import="streams.ToDBFile"%>
<% 
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    String chkplay=request.getParameter("chkplay");
    int galid=0;
    int id=0;
    try{
        galid=Integer.parseInt(request.getParameter("galid").toString());
        id=Integer.parseInt(request.getParameter("en").toString());
       }catch(Exception e){}
    ToDBFile tdb=new ToDBFile();
    ArrayList audiolist=new ArrayList();
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    tdb.addRemoveAudioInPlaylist(chkplay,id);
    audiolist=tdb.gal_ItemAudioSapmle(galid);
    
    %>
    
    <table>
          <tr>
   <%for(int i=0;i<audiolist.size();i++){
prodetail=(Im_Projects_DataHold)audiolist.get(i);

%>
<td style="border: 1px solid #A9A9A0" width="200">
    <div class = "promo">
    <span title="<%=prodetail.getFilename()%>"><img src="./images/musicicon.png" title="" alt=""/></span><br>
    <%=prodetail.getTitle()%><br>
    <div class="hilight">
        <%if(prodetail.getIsPlaylist().equals("inplaylist")){%>
    <div class="innerhilight">
        <span>This audio sample is in playlist.</span><br>
<a href="#" onclick="forPlaylist('<%=prodetail.getId()%>','<%=galid%>','removed')">Remove from playlist</a>
    </div>
    <%}else{%>
    <div class="innerhilight">
        <span>This audio sample is not in playlist.</span><br>
<a href="#" onclick="forPlaylist('<%=prodetail.getId()%>','<%=galid%>','inplaylist')">Add in playlist</a>
    </div>
    <%}%>
    </div>
    </div>
    <div id="dlt">
<a href="delete_more_itemimage.do?id=<%=prodetail.getId()%>">Delete Audio Sample
</a>
    </div>
</td>
<%}%>
          </tr>
</table>