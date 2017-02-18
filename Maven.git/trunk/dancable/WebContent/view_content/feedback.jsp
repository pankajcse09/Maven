<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>ALESSIO</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js">
</script>

  </head>
    
<%   String page_name="";
   ArrayList directordesk=new ArrayList();
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
 ArrayList advert=new ArrayList();
 ArrayList blog=new ArrayList();
 ArrayList inmemory=new ArrayList();
 ArrayList news=new ArrayList();
 ArrayList pd=new ArrayList();
 ArrayList contactus=new ArrayList();
  ArrayList homelist=new ArrayList();
  ArrayList gwm=new ArrayList();

 if(request.getAttribute("page_name")!=null)
{
page_name=(String)request.getAttribute("page_name");
//out.println(homelist);
}
  if(request.getAttribute("homelist")!=null)
{
homelist=(ArrayList)request.getAttribute("homelist");
//out.println("arjun"+homelist);
}
%>


  <body  background="<%=request.getContextPath()%>/Diamond/Background.png"  height="100%" style="background-repeat:repeat-y; background-position: center top;">
    
<div id="conta">
<div id="header">
<div class="appointment">
<a href="#"><img class="img" src="./Diamond/appointment.png" border="0"></a></img>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="mailto:bill@theminorsofrichmond.com?subject=make an appointment!"><img class="img" src="./Diamond/appointment1.png" border="0"></a></img><br>
             &nbsp;&nbsp;&nbsp;&nbsp;<a href="./fm_home.do?name=press"><img class="img" src="./Diamond/Ad-Icon.png" border="0"></a></img>
</div>
<div class="searc">
<a href="#"><img class="img" src="./Diamond/Search.png" border="0"></a></img>
</div>
<div class="pno">
<a href="#"><img class="img" src="./Diamond/pno.png" border="0"></a></img>
</div>
<div class="logo_img">
<a href="<%=request.getContextPath()%>/fm_home.do?name=home"><img  src="./Diamond/Logo.png" border="0"></a></img>
</div></div>
<div id="headerb">
<%@include file="/headmenu.jsp"%>
</div>  
<div class="clear"></div>
<div id="body">
<div id="slidebar"> 
<img  src="./Diamond/slidebar.png" border="0"></img>
</div> 

<div class="body"> 
<table border="0" width="455" align="center">
<TR><td cellpadding="90" valign="top" width="450" >
<TABLE  align="center" border="0">
    <html:errors/>
    <html:form action="myfeedback">
          <tr><td colspan="2" height="10" align="center"><font color="red" size="2">If you have questions, comments or feedback, please feel free to contact us by completing the on-line form below.</font><br>
          <font color="red" size="2">* Fields are Manatory</font></td></tr>
     
         <tr><td width="100"><font color="red" size="2">*</font> <font color="darkblue" size="2">Your Name:</td><td align="left"><html:text property="name" size="39"/></td></tr>
        <tr><td width="100"><font color="red" size="2">*</font> <font color="darkblue" size="2">Your EmailID:</td><td align="left"><html:text property="emailid" size="39"/></td></tr>
        <tr><td width="100"><font color="red" size="2">*</font><font color="darkblue" size="2">your Contact:</td><td align="left"><html:text property="contactno" size="39"/></td></tr>
         <tr><td width="100"><font color="red" size="2">*</font><font color="darkblue" size="2">Your Address:</font></td><td align="left"><html:text property="address" size="39"/></td></tr>
       
        <tr><td width="100"><font color="red" size="2">*</font><font color="darkblue" size="2">Subject:</font></td><td align="left"><html:text property="sub" size="39"/></td></tr>
        
        <tr><td width="100"><font color="red" size="2">*</font><font color="darkblue" size="2">Message:</font></td><td align="left"><html:textarea property="msg" rows="8" cols="30"/></td></tr>
<tr><td width="100"></td><td align="left"><html:submit /></td></tr>
           <%if(request.getAttribute("fedup")!=null)

   {
   out.println("<font color='red'>");
   out.println((String)request.getAttribute("fedup"));
   out.println("</font>");
   }
%>
           </html:form>  
  </table>   
   </td>
    </TR> 
       </table>
        
    </div>
    
   <div class="clear"></div>
</div> </div>
  
  
<div class="clear"></div>
<div id="footer">
<table  border="0"> 
<img src="./Diamond/bottomstrip.png"/>     
<tr><td>  <table class="tablefoot" border="0">
<tr><td>  SITEMAP | STORES |<A href="./privacy.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey"> PRIVACY POLICY </a> | <A href="./privacy.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey">TERMS & CONDITIONS </a>|<a href="./fm_home.do?name=company" STYLE="TEXT-DECORATION: NONE"><font color="grey">ABOUT US</a>  </td></tr>   
<tr><td align="center">  MINORS OF RICHMOND 2012. ALL RIGHTS RESERVED  </td></tr>   </table>             
</td></tr>
</table>
</div>
  </div>
      
        
</body>
</html>
