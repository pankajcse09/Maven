<%@page import="streams.ToDBFile"%>
<%
    int id=Integer.parseInt(request.getParameter("id").toString());
    String chkplay=(String)request.getParameter("chkplay");
    String i=(String)request.getParameter("i");
    
    ToDBFile tdb=new ToDBFile();
    String chk=tdb.retUpdateEvdAudioStatus(id, chkplay);
    %>
<div style="float:left;width:200px;text-align: left;">
                    <%if(chk.equals("inplaylist")){%>
                    <input type="button" value="Remove from playlist" onclick="forPlaylist('<%=i%>','<%="removed"%>')">
                    <%}else{%>
                    <input type="button" value="Add into playlist" onclick="forPlaylist('<%=i%>','<%="inplaylist"%>')">
                    <%}%>
                </div>