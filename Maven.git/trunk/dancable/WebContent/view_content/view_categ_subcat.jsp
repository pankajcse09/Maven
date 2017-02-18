
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="mc_bean.mc_prop"%>
<%@page import="mc_operat.Mc_funct"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>





<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cms</title>
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/category/outline.css">
      
<script language="javascript" src="<%=request.getContextPath()%>/category/outline.js"></script>
<script language="javascript">
   
   function subcat(cat,id)
    {
    window.open('./category/Add_item.jsp?cat='+cat+'&id='+id+'',
'welcome','width=300,height=200,status=yes')
  
} 
    
</script>


    
    
    

    </head>
    
    <body bgcolor="#dcdcdc" onLoad="outlineInit()">
    
    <% String catname="";
    String sub_catname="";
       int mc_id=0; 
      Mc_funct listcat=new Mc_funct();
        mc_prop categ=new mc_prop();
  int r_id=1;
  String mc="sdds";
  ArrayList catlist=new ArrayList();
%>

    <%
    %>
  
    <table>
      <tr><td align="left"><table>
        
      <form name="f1">  
          
       
        
   <tr><td align="left" class="btnav"><ul class="outline">
  <%

catlist=(ArrayList)listcat.sel_cat_all();
for(int kk=0;kk<catlist.size();kk++)
{
    categ=(mc_prop)catlist.get(kk);


        %>
<li><%=categ.getMc()%>

<ul>
    
   
    <% 
    ArrayList cat_list=(ArrayList)listcat.sel_cat(categ.getMc_id());
    if(cat_list!=null)
    {
   
    for(int j=0;j<cat_list.size();j++)
   {
    
    categ= (mc_prop)cat_list.get(j);
    catname=categ.getCat();
    int cat_id= categ.getC_id();
    %>
    
     <li  ondblclick="subcat('<%=catname%>','<%=cat_id%>')"><%=catname%>
    
     
     
    <ul>     
         <%
            int sub_id=0;
  ArrayList sub_cat_list=(ArrayList)listcat.sel_sub_cat(cat_id);
  
   if(sub_cat_list!=null)
    {
        for(int k=0;k<sub_cat_list.size();k++)
   {
    
    categ= (mc_prop)sub_cat_list.get(k);
    sub_catname=categ.getSub_cat();
    sub_id=categ.getSubcat_id();
  
   
        
         %>
         <li>
         
         
    <font color="blue"><A href="<%=request.getContextPath()%>/get_item.do?method=get_ItemDetail&sub_cat=<%=sub_catname%>&subcat_id=<%=sub_id%>" target="itemdet"><%=sub_catname%></font></A>
         
        <ul>
            
           
            
       </ul>
         
         
         </li>
         
     
     
     <%}}%>
      </ul>
     
     </li>
    <%
    
    }
    }
    
    %>
    
    
    
    
    
    
    
    
   
</ul>
    
</li>
<%}%>
</ul>
 
   </td></tr>
   
   </form>
   
    </table>
   
    </td></tr>
    
   <tr><td align="right">
   <table>
  
   
       <form  method="post" action="add_categ.do?req=add_cat">
   <tr><td>



       <input type="hidden" name="cat" value="<%=mc%>">
      <input type="hidden" name="id" value="<%=r_id%>">
   


   </td></tr>
   
   
   
   
    </form>
    
    </table>
    </td></tr>
    
   
  
   <%

if(request.getParameter("req")!=null)
{

%>
   <%
String root_id=request.getParameter("id");
String root_cat=request.getParameter("cat");


   %>


 
   
     <tr><td>
    <table>
  
    <html:form action="root_edit"  method="post">
       
   <tr><td>

Enter Main Category<html:text property="maincat" size="12" ></html:text>
<html:hidden property="rc" value="<%=root_cat%>"/> 
      
<html:hidden property="rc_id" value="<%=root_id%>"/>
      


   </td></tr>
   <tr><td><html:submit value="SAVE CATEGORY" property="save" styleClass="bb" /><td>


    </td></tr>
    </table>   </td></tr>
    </html:form>
    
    
  <%}%>
   
  <%
if(request.getAttribute("suc")!=null)
  {%>
   <tr><td>
  <table align="center">
      <tr><td valign="bottom"><font size="4" color="#000080">Category Added Successfully</td></tr>
  </table>
          </td></tr>
  <%
}
%>
    </table>
    </body>
</html>
