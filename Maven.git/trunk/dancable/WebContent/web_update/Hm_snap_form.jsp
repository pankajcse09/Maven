<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<HTML>
<HEAD>     
  <title>Danceables</title>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1251">
 <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<script type="text/javascript" src="jquery.min.js"></script>
<script language="JavaScript">    
 function forPlaylist(a,chk){ 
     var id=document.playlist.elements["rwid_"+a].value;
     var url="<%=request.getContextPath()%>/web_update/evdPlaylist.jsp";
url=url+"?id="+id+"&chkplay="+chk+"&i="+a;
$.get( url, function( response ) {
    document.getElementById("replace_"+a).innerHTML=response; // server response
 });
}

function delete_file(a,strmAt)
{
     document.playlist.method="POST";
     document.playlist.action="<%=request.getContextPath()%>/delete_evd_audio.do?v="+a+"&strmAtDate="+strmAt+"&method=removeEvd_audio";
     document.playlist.submit();
}
</script>
</HEAD>
<BODY style="margin-left:80;margin-right:80;margin-top:5" >
    <style>
        .filedetail{border: 1px solid #A9A9A0;height: 30px}
        .filedetail .dlt{position:absolute;z-index: 1;left:200px;margin-bottom: 5px;}
    </style>
    <%String gal="";
if(request.getAttribute("pagename")!=null)
{
  gal=(String)request.getAttribute("pagename");

}else{
gal=(String)request.getParameter("gal");
}
ArrayList strmlist=new ArrayList();
if(request.getAttribute("listAtDate")!=null){
    strmlist=(ArrayList)request.getAttribute("listAtDate");
}else{
function_int_foodmart fd=new function_int_foodmart();
strmlist=fd.select_allEvdstreamContent("evdstrm");
}

String strmAt="";
if(request.getAttribute("strmAtDate")!=null)
{
 strmAt=(String)request.getAttribute("strmAtDate");
}
%>

<!--maintable-->
<table width="100%"  border="0" height="100" >

<TR><TD valign="top" colspan="2"><%@ include file="/Registration/top_design_1.jsp"%></TD></TR>

<%
if(request.getAttribute("msg")!=null){%>
   <TR><TD valign=top colspan="2"><font style="font-size:17;color:red"><%=request.getAttribute("msg")%></font></TD></TR>
     
        
<%}
%>

<TR>
<TD WIDTH=100%  ALIGN="center" height="100" colspan="2">

<!--5nd table-->
  <form  action="evdStream.do?method=evdSt" enctype="multipart/form-data" method="post">
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="100" bordercolor="black">
  <tr> 
    <td>Enter Date</td> 
    <td colspan="2"><script>DateInput('strmdate', true, 'dd/mm/yyyy')</script></td>
    </tr>
    <tr> 
    <td>Upload Stream</td> 
    <td ><input type="file" name="uploads[0]" size="35" /></td>
    <td ><input type="file" name="uploads[1]" size="35" /></td> 
    </tr> 
    <tr> 
    <td colspan="4" align="center"> 
    <!--<input type="hidden" name="gal" value="<%=gal%>">-->
    <input type="hidden" name="galid" value="evdstrm">
    <input type="submit" name="save" value="Upload Stream "> 
    </td> 
    </tr>   
    <tr><td>
    </td></tr>
   
</table><!--5nd table-->
</form>
             
		
	</td></TR>
<tr><td WIDTH=80% colspan="2"><hr WIDTH=100% align="left"></td></tr>
<tr><td WIDTH=80% colspan="2" align="center"><b><u>Search Stream Datewise</u></b></td></tr>
<tr><td>
        <form  action="streamOn.do?method=streamAt" method="post">
        <div style="text-align: justify">
            <div style="float:left">Enter date:</div> <div style="float:left"><script>DateInput('chkstrm', true, 'dd/mm/yyyy')</script></div>
                    <div><input type="submit" value="search"></div>
        </div>
        </form>
    </td>
    <td align="right">
        
    </td></tr>
<TR>
<TD WIDTH=80%  ALIGN="center" height="100" colspan="2">
<div style="width:80%;">  
    <div style="border: 1px solid #A9A9A0;height: 40px">
                <div style="float:left;width:50px;"><b>File</b></div>
                <div style="float:left;width:320px;text-align: left;margin-left: 30px;"><b>File Title</b></div>
                <div style="float:left;width:200px;text-align: left;"><b>Stream Date</b></div>
            </div>
     <div style="clear: both"></div>
  <form name="playlist">   
    <%if(strmlist.size()!=0)
    {
        for(int i=0;i<strmlist.size();i++)
        {
            img_bean ad=(img_bean)strmlist.get(i);
            %>
            <div class="filedetail">
               <div style="float:left;width:50px;">
                   <span title="<%=ad.getSampleFileName()%>">
                    <img src="./images/musicicon.png" width="30"></span></div>
                <div style="float:left;width:350px;text-align: left;"><%=ad.getSampleTitle()%></div>
                <div style="float:left;width:200px;text-align: left;"><%=ad.getDate()%></div>
                <input type="hidden" name="rwid_<%=i%>" value="<%=ad.getHead_id()%>">
                <div id="replace_<%=i%>" style="float:left;">
                <div style="float:left;width:200px;text-align: left;">
                    <%if(ad.getStatus().equals("inplaylist")){%>
                    <input type="button" value="Remove from playlist" onclick="forPlaylist('<%=i%>','<%="removed"%>')">
                    <%}else{%>
                       <input type="button" value="Add into playlist" onclick="forPlaylist('<%=i%>','<%="inplaylist"%>')">
                    <%}%>
                </div>
                </div>
                <div style="float:left;width:140px;text-align: right;">
                    <span title="Delete File" onclick="delete_file('<%=ad.getHead_id()%>','<%=strmAt%>')"><img src="./images/delete.png"></span></div>
            </div>
                <div style="clear: both"></div>
<%}}%>
</form>
</div></TD></TR>
</table>
</BODY>
</HTML>