
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<html>
<head>
    <title></title>

</head>
<body style="margin-left:20;margin-right:20">
<%ArrayList contentlist=new ArrayList();
img_bean imgbe=new img_bean();
item_bean itembe=new item_bean();
ArrayList discountlist=new ArrayList();
img_bean picbe=new img_bean();
String fn1="";
String fn2="";
String fn3="";
String fn4="";
ArrayList qualitylist=new ArrayList();
String  page_id="";
 function_int_foodmart fd=new function_int_foodmart();
if(request.getAttribute("contentlist")!=null)
{

contentlist=(ArrayList)request.getAttribute("contentlist");
//out.println(homelist);
}

%>
<table width="100%" height="550" border="0">
    <TR><TD vAlign=top align=left colSpan=2 height="155"><%@include file="/header.jsp"%></TD></TR>  
<tr><td colspan="2" height="45"><%@include file="/menu.jsp"%></td></tr>  
  
<tr><td width="20%" height="70%" valign="top"><%@include file="/view_content/Browse_item.jsp"%></td>
<td width="80%" height="75%" valign="top">


                  
           
 
                  <TABLE height=160 cellSpacing=5 cellPadding=0 width=200 
                  align=right border=0>
                    <TBODY>
                    <TR>
                      <TD vAlign=top align=left><IMG height=173 
                        src="<%=request.getContextPath()%>/images/career.jpg" 
                  width=200></TD></TR></TBODY></TABLE>
                  <P><SPAN class=style4><SPAN class=style9>If you wish to make 
                  your career in our company and feel proud of being part of our 
                  </SPAN></SPAN><SPAN class=style4><SPAN class=style9>success, 
                  Please submit your resume with the following details:- 
                  </SPAN></SPAN>
                  
    

           <TABLE cellSpacing=5 cellPadding=0 width=80% align=center border="0">
                <html:errors/>
    <html:form action="mycareer" enctype="multipart/form-data">
         <tr><td>Name:</td><td><html:text property="name" size="40"/></td></tr>
        <tr><td>Email ID:</td><td><html:text property="emailid" size="40"/></td></tr>
        <tr><td>Contact No.:</td><td><html:text property="contactno" size="40"/></td></tr>
        <tr><td>Post Applied For:</td><td><html:text property="address" size="40"/></td></tr>
       
        
        <tr><td>Why do you want to join retail Sector:</td><td><html:textarea property="msg" rows="10" cols="33"/></td></tr>

<tr><td>File Upload</td><td><html:file property="feed_file" size="44" /></font><td align="center"><html:submit /></td></td></tr>



    </html:form>
            
            
              <%if(request.getAttribute("fedup")!=null)

   {
   out.println("<font color='red'>");
   out.println((String)request.getAttribute("fedup"));
   out.println("</font>");
   }
%>


</table>




</td>
</tr>


<tr><td colspan="2" width="100%" align="center" bgColor=#b7b7b7><%@include file="/footer.jsp"%></td></tr>
</table>
</body>

</html>