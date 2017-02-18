<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>

<%@page import="java.io.*"%>
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

    <h1>JSP Page</h1>
    
    <%
    String filename="";
String id="";


filename=request.getParameter("para");
//out.println("filename"+filename);




 ServletOutputStream ou = response.getOutputStream();
        

        response.setContentType("application/octat-stream");
       
     
     String path1=application.getRealPath("/")+"/fb_file/"+filename;
     File dir = new File(path1);
       

         response.addHeader("Content-Disposition","filename=\""+ filename + "\"");
       ServletContext ctx=getServletContext();
      
       //response.setContentType("application/octat-stream");
       //String aaa=ctx.getRealPath( path1);
     String abc=ctx.getMimeType(path1);

       FileInputStream fis = null;
  try {
       
    fis = new FileInputStream(dir);
    byte[] buf = new byte[4 * 1024];  // 4K buffer
    int bytesRead;
    while ((bytesRead = fis.read(buf)) != -1) {
      ou.write(buf, 0, bytesRead);
    }
  }
  
   catch(FileNotFoundException ff)
  {
  
  ou.println("File Not Available");
  
  }
  finally {
    if (fis != null) fis.close();
  }

        ou.close();

    %>
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>
