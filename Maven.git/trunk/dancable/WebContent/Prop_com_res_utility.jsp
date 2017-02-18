<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%//@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%//@page import="com.myapp.struts.Display_Data_hold"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<%//@page import="prop_bean.prop_operate"%>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" src="./validation.js"></script>
          
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <title>Danceables Management</title>
        <script language="javascript">
        function validate(){    
        var bn=validformno(0,6);
        if(bn==false){
         return false; 
        }
         return true;
        }
        function changlang(le){

if(le=='hi')
{
alert(le);
document.write('<style>.fontlang { font-family:Aarti; }</style>');  

}
if(le=='ei')
{
alert(le);
document.write("<link rel='stylesheet' type='text/css' href='fontcss/demo_en_DEF.css' />"); 
                
}
         }
        </script>
        
    </head>
    <body style="margin-left:80;margin-right:80;margin-top:5">
   <!--maintable-->
<table width="100%" height="100%" bgcolor="lightyellow"  >
    
    

     <TR><TD vAlign=top colspan="2" ><%@ include file="./Registration/top_design_1.jsp" %></TD></TR>
   




<tr><td colspan="0" width="100%">
 <!--5nd table-->   
 
 
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
<tr><td colspan="2"><font color="red">* These Fields Are Mandatory</font></td></tr>

         
        <html:errors/>
    <html:form action="prop_cr" enctype="multipart/form-data" onsubmit="return validate();">
     
        <%
        String page_name="";
        if(request.getParameter("page_name")!=null){
        page_name=(String)request.getParameter("page_name");%>
        <%}%>
       <!--<tr><td>Hindi<input type="radio" name="li" value="hi" onclick="changlang('hi');"/>English
<input type="radio" name="li" value="ei" onclick="changlang('ei');"/></td></tr>-->
        <tr><td><font color="red">*</font><font style="font-size:14;font-weight:bold;color:BLACK" >Heading/Name</font></td><td>
  
       <html:textarea property="location" rows="5" cols="80"  styleClass="fontlang"></html:textarea>
        </td></tr>  
   
        <tr><td><font color="red">*</font><font style="font-size:14;font-weight:bold;color:BLACK">Description</font></td><td> <html:textarea property="desc" rows="8" cols="80"></html:textarea> </td></tr> 

<tr><td><font style="font-size:12;font-weight:bold;color:BLACK">Select the Image Upload</font></td><td><html:file property="prop_file" size="75"/></td></tr>

<tr><td colspan="2" align="center"><html:submit value="save" property="save"></html:submit></td></tr>
<input type="hidden" name="page_name" value="<%=page_name%>">
</html:form> 
<tr><td colspan="2">

        <%if(request.getAttribute("suc")!=null)
        {
            String page_id=request.getParameter("page_name");
        %>
    <tr><td><font style="font-size:12;font-weight:bold;color:red"><%=request.getAttribute("suc")%>
</td></tr>
    
      
      
       <%}%>
        
        
        
       
     
        </td></tr>
        </table>
        </td></tr>
          <TR><TD vAlign=top colspan="2" ><%//@ include file="./jsp/hrms_footer.jsp" %></TD></TR>
   </table>
      
</BODY>
</HTML>