<%-- 
    Document   : coverImage
    Created on : Dec 19, 2013, 3:22:30 PM
    Author     : kapil
--%>

<%@page import="com.myapp.struts.Im_Proj_DataUtility"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="streams.ToDBFile"%>
<% 
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    String en=request.getParameter("en");
    String cn=request.getParameter("cn");
    int itemid=0;
    int id=0;
    int scid=0;
    try{
        itemid=Integer.parseInt(cn);
        id=Integer.parseInt(en);
        scid=Integer.parseInt(request.getParameter("scid").toString());
    }catch(Exception e){}
    //out.println(en+" "+cn);
    //en="5";
    //cn="31";
    
    InputStream stream;
    OutputStream bos;
    ToDBFile tdb=new ToDBFile();
    String curntCover=tdb.retCoverImage(itemid);
    //out.println("Current "+curntCover);
    String nextCover=tdb.retMoreImagefilename(id);
    //out.println("Next "+nextCover);
    
    //String nextCover="124317u6ddqnddfahpoi1f2l6q7hvrku_pre_image_2.png";
    //out.println(" "+getServletContext().getRealPath("music_image/"+nextCover));
    File nxFile=new File(getServletContext().getRealPath("moremusic_images/"+nextCover));
    File cvrFile=new File(getServletContext().getRealPath("music_image/"+nextCover));
    try{
        stream =new FileInputStream(nxFile);
      bos = new FileOutputStream(cvrFile);
       
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
}
bos.close();
stream.close();

tdb.updateCoverImage(nextCover,itemid);

nxFile.delete();
        }catch(FileNotFoundException fnfe){
                out.println("Ex: "+fnfe.getMessage());  
               }
           catch(Exception ee){
               out.println("Message: "+ee.getMessage());
           cvrFile.delete();
           }
    nxFile=null;
   cvrFile=null;
   cvrFile=new File(getServletContext().getRealPath("music_image/"+curntCover));
   nxFile=new File(getServletContext().getRealPath("moremusic_images/"+curntCover));
   try{
        stream =new FileInputStream(cvrFile);
      bos = new FileOutputStream(nxFile);
       
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
}
bos.close();
stream.close();

tdb.updateNextCoverImage(curntCover,id);
cvrFile.delete();
        }catch(FileNotFoundException fnfe){
                out.println("Ex: "+fnfe.getMessage());  
               }
           catch(Exception ee){
           nxFile.delete();
           }
 nxFile=null;
   cvrFile=null;
    %>

        <%   
        String it=(String)request.getParameter("galid");
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();  
         ArrayList images=new ArrayList();
         Im_Proj_DataUtility im=new Im_Proj_DataUtility();
        images=(ArrayList)im.gal_ItemImage(itemid,scid);
        curntCover=tdb.retCoverImage(itemid);
      %>
    <table border="0">
          <tr>
   
<td style="margin:5px 5px; padding: 5px 10px;">
    <div>Now This is the cover image</div>
        <img src="./music_image/<%=curntCover%>" title="" alt="" width="150"/><br>



</td>

</table>
  
