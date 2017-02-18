
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>AKSFASHIONNEWS</title>
 <LINK href="<%=request.getContextPath()%>/view_content/item_style.css" type="text/css" rel="STYLESHEET">
<SCRIPT src="<%=request.getContextPath()%>/view_content/item_script.js" type="text/javascript"></SCRIPT>

</head>
<body>
    <%     
String catname="";
Mc_funct listcat=new Mc_funct();
 mc_prop newcateg=new mc_prop();
        mc_prop categ=new mc_prop();
  String sub_catname="";
  ArrayList catlist=new ArrayList();

catlist=(ArrayList)listcat.sel_cat_all();

%>
<ul class="menu" id="menu">
	<li><a href="#" class="menulink">Browse Items</a>
		<ul>
			<% 
                                    for(int kk=0;kk<catlist.size();kk++)
                                 {
                                   categ=(mc_prop)catlist.get(kk);%>

					<li class="topline"><a href="#" class="sub"><%=categ.getMc()%></a>
					
					<ul>
                                             <%ArrayList cat_list=(ArrayList)listcat.sel_cat(categ.getMc_id());
                                             int cat_id=0;%>
                                            <%  for(int j=0;j<cat_list.size();j++)
                                             {
    
                                                 categ= (mc_prop)cat_list.get(j);
                                               catname=categ.getCat();
                                             cat_id= categ.getC_id();
                                             %>
                                            <li class="topline"><a href="#"><%=catname%></a>
                                            
                                                <%int sub_id=0;
                                                ArrayList sub_cat_list2=(ArrayList)listcat.sel_sub_cat(cat_id);%>
                                            <ul>
                                                
                                                <%
   for(int k=0;k<sub_cat_list2.size();k++)
   {
    
    newcateg= (mc_prop)sub_cat_list2.get(k);
  sub_catname=newcateg.getSub_cat();
 sub_id=newcateg.getSubcat_id();
  
   
        
         %>
                                             <li class="topline"><A  href="subcatdet_col.do?id=<%=sub_id%>&pr=1&method=Collection_ItemDetail"><%=sub_catname%></A></li>
       
                                                <%}%>
                                                
                                            </ul>
                                            
                                            
                                            </li>
                                             <%}%>
					</ul>
					
					</li>
					
					
	               <%}%>
					
	
	
                                 
                                    
                            
            
      
			</ul>
			
	</li>
	
	
</ul>

<script type="text/javascript">
	var menu=new menu.dd("menu");
	menu.init("menu","menuhover");
</script>
</body>
</html>