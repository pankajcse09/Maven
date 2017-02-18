<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="java.util.ArrayList" %>
<%@page import ="mc_operat.Mc_funct" %>
<%@page import ="mc_bean.mc_prop" %>


<%

Mc_funct  mc =new Mc_funct();
ArrayList mc_list=new ArrayList();
mc_list =(ArrayList)mc.sel_mc();

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cms</title>
        <style type="text/css"> 
          

  
        </style>
         <link rel="stylesheet" type="text/css"  href="../mymenu.css">
<link rel="stylesheet" type="text/css"  href="../category/outline.css">
        
       
          
<script language="javascript" src="../category/outline.js">
   
</script>
<script language="javascript">
    function brs()
{
    mywindow=window.open("../cbr.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
          
}
function gotorule()
    {
   mywindow=window.open("../gotorule.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
   
} 
function gotorole()
    {
   mywindow=window.open("../gotorole.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
   
} 

function gotosearch()
    {
   mywindow=window.open("../gotosearch.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
   
} 

function gotoas()
    {
   mywindow=window.open("../gotoadvance.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
   
} 

function gotoreg()
    {
   mywindow=window.open("../gotoreg.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
   
} 
function pendreg()
    {
   mywindow=window.open("../pendreg.do","Supplier","width=800,height=600,menubar=yes,status=yes,location=yes,toolbar=yes,scrollbars=yes,resizable=yes");
            mywindow.moveTo(0,0);
   
}

</script>
    </head>
    <body  bgcolor="#dcdcdc" onLoad="outlineInit()">
     <h1>cms</h1>
    
  <%
if(mc_list !=null)
   {

//out.println(cat_list);
%> 


<table class="st" border="0" >
<tr><td align="left"><font size="3" color="#000080"><b>Root Category</b></font></td></tr>
<tr><td align="left" class="btnav"><ul class="outline">

  <%
    mc_prop prop = new mc_prop();
   for(int i=0;i<mc_list.size();i++)
   {
    
    
prop=(mc_prop)mc_list.get(i);
String main_cat=prop.getMc();
int id= prop.getMc_id();
%>

 <li title="select Main Category"><font color="blue"><A href="../dyana_add_cat.do?cat=<%=main_cat%>&id=<%=id%>"target="dyana" ><%=main_cat%></font></A>

 </li>
 <ul >
     
     
     </ul>
 


<%}%></ul>
</td></tr>
</table>
<table align="left">
<form name="f">
    
    
</form>
</table>



<%}%>


    
    </body>
</html>
