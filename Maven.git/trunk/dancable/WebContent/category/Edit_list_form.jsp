<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="mc_bean.item_list"%>
<%@page import="mc_operat.Mc_funct"%>
<%@page import="mc_operat.Item_func"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import=" java.util.Enumeration"%>
<%@page import ="java.util.HashMap"%>
 <%@page import=" java.util.Set"%>
 <%@page import=" java.util.Iterator"%>
 <%@page import ="java.util.Map"%>
 <%@page import ="java.sql.Timestamp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cms1</title>
        
    </head>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
    <script language="javascript">
        function edit(type,listid){
        




mywindow=window.open("./updatelist_item.do?type="+type+"&id="+listid,"Supplier","width=300,height=200,resizable");
            mywindow.moveTo(0,0);
           
          
}
    
 
        
        </script>
    <body bgcolor="#dcdcdc">

   <%
String list_id=request.getParameter("chkh");
if(list_id!=null)
{
//out.println(list_id);

Item_func ed_item= new Item_func();
item_list itemlistview= new item_list();

 Enumeration en = request.getParameterNames();
 
 
         ArrayList para_name=new ArrayList();
           ArrayList itemlistid=new ArrayList();
         HashMap par_name=new HashMap();
        while (en.hasMoreElements())
        {
             
              String name = (String) en.nextElement();
              String values[] = request.getParameterValues(name);
                  if (values != null) 
                     {       if(name.equals("chkh"))
                             {
                             for (int i = 0; i < values.length; i++) 
                          {
                              //out.println(name + values[i]);
                                 
                               par_name.put(name,values[i]) ;
                               itemlistid.add(values[i]);
                             
                           }
                              
                             }
                     }
        }
%>
    <%
//out.println(list_id);

%>
<%

Mc_funct col=new Mc_funct();
   
   ArrayList col_list = new ArrayList();
  col_list=(ArrayList)col.sel_item_col();
  
         Timestamp time=new Timestamp(System.currentTimeMillis());
   %>

<form  name="display">

<table border="1" class="it">
    
    <tr>
       <%String colname="";
       for(int leng=0;leng<col_list.size();leng++)
       {
 colname=col_list.get(leng).toString();


%>
           
       <td><font size="2"><%=colname%></font></td>
      
      <%}%></tr>
     <%
for(int j=0;j<itemlistid.size();j++)
     {



      ArrayList viewlist=(ArrayList)ed_item.itemlist_desc_edit(Integer.parseInt(itemlistid.get(j).toString()));
      //out.println(viewlist);
       itemlistview=(item_list)viewlist.get(0);
%>

     
    
     
<tr><td><input type="text" name="unit" class="ts"  value="<%=itemlistview.getUnit()%>" size="3" onclick="edit('unit','<%=itemlistview.getList_id()%>')"></td>
<td><input type="text" name="size"  class="ts" size="3" value="<%=itemlistview.getColor()%>" onclick="edit('color','<%=itemlistview.getList_id()%>')"></td>

</tr>

<%}

%>
    
   
    </table>
   </form>
    <%}%>
    </body>
</html>
