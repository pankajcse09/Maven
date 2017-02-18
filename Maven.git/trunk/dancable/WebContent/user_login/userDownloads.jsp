<%-- 
    Document   : userDownloads
    Created on : Jan 17, 2014, 1:52:44 PM
    Author     : kapil
--%>

<%@page import="java.io.File"%>
<%@page import="streams.ToDBFile"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.util.zip.ZipOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="ActionClass.Common"%>
<%@page import="java.util.HashMap"%>
<%
String key="";
String order_id="";
if(request.getParameter("key")!=null)
{
    key=(String)request.getParameter("key");
}
if(request.getParameter("dt")!=null)
{
    order_id=(String)request.getParameter("dt");
}
Common comLogin = new Common();
       //String user=comLogin.jumbleData(key);
String user=key;
       String or=comLogin.jumbleData(order_id);
String msg="";
String usermail="";
ArrayList al=new ArrayList();
ArrayList audio=new ArrayList();
HashMap hm=new HashMap();
item_bean ib=new item_bean();
item_bean ab=new item_bean();

if(request.getAttribute("msg")!=null)
{
    msg=(String)request.getAttribute("msg");
}
if(request.getAttribute("usermail")!=null)
{
    usermail=(String)request.getAttribute("usermail");
}
if(request.getAttribute("list")!=null)
{
    al=(ArrayList)request.getAttribute("list");
}
if(request.getAttribute("audiomap")!=null)
{
    hm=(HashMap)request.getAttribute("audiomap");
}
String odid="";
if(request.getAttribute("order_id")!=null){
    odid=(String)request.getAttribute("order_id");
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Downloading Page</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
         
                 
</head>
    <body>
       <table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <div id="topdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                               </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                </td>
            </tr>
             <tr>
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="800" valign="top" style="background-repeat: no-repeat">
                    <table border="0" width="75%" align="center" valign="top">
                        <tr><td align="center"><b>Welcome: <%=usermail%></b></td></tr>
                        <tr><td height="10"></td></tr>
                        <tr><td><font style="font-size:15px;color:#575351"><b>Files For Download</b></font></td></tr>
                        <tr align="left" valign="top">
                            <td height="100">
                                <table>
                                    <%if(!msg.equals(""))
                                    {%>
                                    <tr><td><%=msg%></td></tr>
                                    <%}%>
                                    <%
                                    ToDBFile tdb=new ToDBFile();
                                    String dir=getServletContext().getRealPath("/downloadaudio");
                                    for(int i=0;i<al.size();i++)
                                    {
                                        ib=(item_bean)al.get(i);
                                        String brandOr=tdb.removeAllSpCh(ib.getBrand());
                                        brandOr=tdb.removeSpace(brandOr);
                                        String zipName=brandOr+"-"+odid+".zip";
                                        
                                       
                                            FileOutputStream fos = new FileOutputStream(dir+File.separator+zipName);
                                            ZipOutputStream zos = new ZipOutputStream(fos);
                                   %>
                                   <tr><td><b><%=ib.getBrand()%></b></td></tr>
                                   <%
                                        audio=(ArrayList)hm.get(ib.getBrand());
                                        for(int j=0;j<audio.size();j++)
                                        {
                                            ab=(item_bean)audio.get(j);
                                            tdb.addToZipFile(dir,ab.getAudioFileName(), zos);
                                   %>
                                   <tr>
                                       <td><a href="<%=request.getContextPath()%>/customerDownload?o=<%=or%>&id=<%=ab.getRowid()%>&k=<%=user%>" target="_blank"><%=ab.getAudioFileName()%></a></td>
                                </tr>
                                <%}
                                        zos.closeEntry();
                                        zos.close();
                                      tdb.saveZipFile(odid,user,zipName);  
                                      ab=tdb.retZipFileDetail(zipName,odid);
                                %>
                                <tr><td height="10" valign="middle"> Or Download All Files. Click on Zip to download all files 
                                        <a href="<%=request.getContextPath()%>/zipDownload?o=<%=or%>&id=<%=ab.getRwid()%>" target="_blank"><%=ab.getFilename()%></a>
                                    </td></tr>
                                <tr><td height="10"></td></tr>
                                    <%}%>
                                </table>
                            </td>
                        </tr>
                      <tr><td colspan="3"><%@include file="/footer.jsp"%></td></tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>