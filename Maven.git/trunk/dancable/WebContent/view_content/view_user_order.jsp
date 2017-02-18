


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="ActionClass.JavaBean1"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Danceables</title>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
<script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
window.open(url,'jewelry','width=433,height=450,menubar=no,scrollbars=yes,resizable=1');
    
}




 

</script> 

    </head>
      

    <body>
        
 
<%
     SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
  HashMap hm=new HashMap();
 ArrayList hs=new ArrayList();
 String today="";
 if(request.getAttribute("today")!=null)
 {
     today=(String)request.getAttribute("today");
 }
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;
  JavaBean1 rb= new  JavaBean1();
  if(request.getAttribute("hmap")!=null){
  hm=(HashMap)request.getAttribute("hmap");  
  hs=(ArrayList)hm.get("hset");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  stindex=hm.get("stindex").toString(); 
  }
  try{
   k=Integer.parseInt(stindex);   
  }
  catch(NumberFormatException ne){}
  %>
   <%String usernam= (String)session.getAttribute("loginid");
   

%>
   <div id="conta">
	
      <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    
   <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>   
         <tr><td height="450" valign="top">      
                <table width="100%" border="0" cellpadding="0" >
        
 <tr><td colspan="0" width="50%" bgcolor="#ffffff">
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
    <tr><td align="right"><font color="maroon" size="4">Welcome&nbsp;</font><font color="darkblue" size="4">'<%=usernam%>'</font></td></tr>
    
    <tr><td  bgcolor="">  
    <table width="100%" align="center"><tr><td width="100%" align="center" colspan="2"><font color="darkblue" size="3"><b>List Of All Registered Users</b></font></td></tr></table>
     <table width="100%" align="center">  <tr><td>Date: <%=today%></td><td><font style="font-size:12"><b>Displaying Records:&nbsp;<%=ft%></b></font></table>
    <table  width="100%" align="center" height="330" cellpadding="0" cellspacing="0"><tr><td valign="top" colspan="2">   
    <table  width="100%" align="center" cellpadding="0" cellspacing="0" border="1" class="t">
  
    <%if(!pre.equals("")){%>
    <a href="CompaniesPagewise.do?method=companiesList&pr=<%=pre%>"><font style="font-size:12;color:blue">Previous</font></a>
    <%}
    if(!nxt.equals("")){
    %>
   <a href="CompaniesPagewise.do?method=companiesList&pr=<%=nxt%>"><font style="font-size:12;color:blue">Next</font></a>
   <%}%>
   </td></tr>     
    <tr><td valign="top" align="center"><FONT STYLE="font-weight:bold;color:blue;font-size:15px">SNo.</b></font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Email ID:</b></font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Name</font></td>
<!--<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Address</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">City</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">State</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Country</font></td>-->

    <td><FONT STYLE="font-weight:bold;color:red;font-size:17px">View Today Order</font></td>
    </tr>    
     <%
     for(int m=0;m<hs.size();m++){  
       rb=(JavaBean1)hs.get(m);
     %>    
    <tr><td align="center"><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=k++%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getEmail_id()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getName()%>&nbsp; <%=rb.getLast_name()%></font></td>
<!--<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getHomeaddress()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getCity()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getState()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getCountry()%></font></td>-->



    
    <td width="20%"><font style="font-size:12"><a href="select_order_userid.do?userid=<%=rb.getEmail_id()%>&odid=<%=rb.getOrder_id()%>">view</a></font></td>
    </tr>
    <%}%> 
    <tr><td colspan="2"><font style="font-size:12"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="CompaniesPagewise.do?method=companiesList&pr=<%=pre%>"><font style="font-size:12;color:blue">Previous</font></a>
    <%}
    if(!nxt.equals("")){
    %>
   <a href="CompaniesPagewise.do?method=companiesList&pr=<%=nxt%>"><font style="font-size:12;color:blue">Next</font></a>
   <%}%>
   </td></tr> 
   </tr>
</table></td>
  <!--text end from here-->  
 </tr>
 </table></td>
 </tr>
  </table>
     </td></tr>
   </table>
      <tr><td vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>  
</div>
    
    
    </body>
</html>

