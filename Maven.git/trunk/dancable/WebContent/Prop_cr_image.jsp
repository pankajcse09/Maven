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


<%@page import="prop_bean.prop_be"%>

<%@page language="java"%>
<%@page import="java.util.ArrayList"%>

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
<%!

byte[] imgData=null;
int row=0;
 prop_be  be=new prop_be();
 String filename="";
 
 String page_name="";
%>
    
    
    
    <%
  
    //response.setContentType("image/jpg");
   prop_be be =new prop_be();
be=(prop_be)request.getAttribute("cr_detail");
page_name=be.getPage_name().toString();
   //out.println(title);
   //String area=(String)request.getAttribute("area");
   
  
  


 if(request.getAttribute("edit")!=null)
    {
      String cr=(String)request.getAttribute("cr_type");
    request.setAttribute("suc","Your Data is updated");
    out.println(cr);
RequestDispatcher rd=request.getRequestDispatcher("/Prop_Edit_Cr.jsp?cr="+cr);
rd.forward(request,response);
    
    }
  
   if(request.getAttribute("edit")==null)
    {
    
    request.setAttribute("suc","Your Data is updated");
  RequestDispatcher rd=request.getRequestDispatcher("/Prop_com_res_utility.jsp?page_name="+page_name);
  rd.forward(request,response);
  
  
  
    
    }
 
  
  
  
  

%>
  
  
  
  
   
    
    </body>
</html>


