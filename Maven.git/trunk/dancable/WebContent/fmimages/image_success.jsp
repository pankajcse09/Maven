<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="java.awt.image.RenderedImage"%>
<%@page import="java.awt.image.*"%>
<%@page import="java.awt.Image.*"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import=" java.sql.Connection"%>
<%@page import ="java.sql.PreparedStatement"%>
<%@page import=" java.sql.ResultSet"%>
<%@page import=" java.sql.SQLException"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import ="oracle.jdbc.driver.OracleResultSet"%>
<%@page import ="oracle.sql.BLOB"%>
<%@page language="java"%>
<%@page import="java.util.ArrayList"%>
<%@page import="moreimg.img_bean"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
    <body>
<%
Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;
PreparedStatement ps1=null;
ResultSet rs1=null;
byte[] imgData=null;
int row=0;
  img_bean be=new img_bean();
%>
    
    
    
    <%
  
    //response.setContentType("image/jpg");
   
   //String title=(String)request.getAttribute("title");
   //out.println(title);
   //String area=(String)request.getAttribute("area");
   ArrayList filename=new ArrayList();
   filename =(ArrayList)request.getAttribute("imgsname");
   be=(img_bean)request.getAttribute("pagedetails");   

for(int j=0;j<filename.size();j++)
{
        
 String name=(String)filename.get(j);
  
 String p="/myfiledata/"+name;
 
   
  String a=getServletContext().getRealPath("/Imge/"+name);
   
    
    
   
    
      File src = new File(p);
       


      File des= new File(a);

      InputStream in = new FileInputStream(src);
  
      OutputStream ou = new FileOutputStream(des);
 

   
    try{
  boolean exists = des.exists();
   
if (!exists)
{

  des.createNewFile();
  
  
  
 
 byte[] buf = new byte[5000 * 1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            ou.write(buf, 0, len);
        }
        in.close();
        ou.close();
}else{
      
 byte[] buf = new byte[5024];
        int len;
        while ((len = in.read(buf)) > 0) {
            ou.write(buf, 0, len);
        }
        in.close();
        ou.close();
 

}
    
  request.setAttribute("pgdetail",be);
  out.println("be"+be);
    request.setAttribute("suc","Your Image is updated");
 RequestDispatcher rd=request.getRequestDispatcher("/fmimages/pic_interface.jsp");
  rd.forward(request,response);
    }
        catch(Exception fe)
{
            out.println(fe.getMessage());
}
   
  


}
 
 
  
  
  
  

%>
  
  
  
  
   
    
    </body>
</html>


