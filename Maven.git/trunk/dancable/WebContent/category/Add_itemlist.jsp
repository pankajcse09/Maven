<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="mc_bean.mc_prop"%>
<%@page import ="mc_bean.item_list"%>
<%@page import="mc_operat.Mc_funct"%>
<%@page import="mc_operat.Item_func"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
    <script language="javascript">
       
 var thedata;
var newwin;
var thenumber;
function edit(textarea) 
{
alert(textarea);
if (textarea == 0)
{
alert(textarea);
thedata = document.exampleform.unit.value
thenumber = 0

}
 if (textarea == 1)
{ 
thedata = document.exampleform.size.value
thenumber = 1
}

if (textarea == 2)
{ 
thedata = document.exampleform.prod_id.value
thenumber = 2
}
newwin = window.open("o.jsp","","width=300,height=200,resizable")
}  
        
        function addRow(){
document.forms[0].method="POST";

document.forms[0].action="new_list.do?row=list";

document.forms[0].submit();
}

function saveintemp(){
document.forms[0].method="POST";
document.forms[0].action="Add_itemlist";
document.forms[0].submit();
}

function edit_item()
    {
   
   document.forms[0].method="POST";
document.forms[0].action="update_list_item.do";
document.forms[0].submit();
} 

function del_item()
    {
   
   document.forms[0].method="POST";
document.forms[0].action="del_list_item";
document.forms[0].submit();
} 
    </script>
    <body bgcolor="#dcdcdc">

   <%String item_id=request.getParameter("list");
  Mc_funct itemcol= new Mc_funct();
   item_list pro_view= new  item_list();
  Item_func col= new Item_func();
   ArrayList col_list = new ArrayList();

   %>
   
 

<%

if(item_id!=null)
{

//out.println(item_id);
ArrayList item_col=new ArrayList();

%>
<form name="exampleform">
<table border="1" class="it"><tr><td>Edit</td>
<%
 
      item_col=(ArrayList)itemcol.sel_item_col();
      for(int i=0;i<item_col.size();i++)
      {
      
     %>
      
     <td><font size="2"> <%=item_col.get(i)%></font></td>
     
     <%
      }
     %>
      
</tr>
 


<%// view from table

                 ArrayList view_itemlist=(ArrayList)col.itemlist_desc((Integer.parseInt(item_id)));
                 if(view_itemlist!=null)
                 {
                   
                // out.println(view_itemlist);
                 int li_id=0;
                 for(int v=0;v<view_itemlist.size();v++)
                 {
                
                
                  pro_view=(item_list)view_itemlist.get(v);
                   li_id=pro_view.getList_id();
                   // out.println(li_id);
                 
                     %>
                     <tr>  
                         <td><input type="checkbox" name="chkh" value="<%=li_id%>"></td>
       <td><input type="text" class="ts" size="3" value="<%=pro_view.getUnit()%>"></td>
 
                  <td><input type="text" class="ts" size="3" value="<%=pro_view.getColor()%>"></td> 

                      </tr> 
                     
                     
               <%  }
                 
                 }

              %>



<%
if(request.getParameter("row")!=null)
{

%>
<tr> <td></td>
            <%for(int leng=0;leng<item_col.size()-1;leng++)
       {%>
           
       
       
     <td><input type="text" class="ts" name="<%=item_col.get(leng)%>" size="3"  onclick="edit(<%=leng%>)"></td>
      
      <%}%><td><input type="text"  class="ts" size="3" name="color" onblur="saveintemp()"></td>
</tr>
<%


}


%>


</table>
<p><input type="button" class="ite" value="AddList" onclick="addRow();">  
<input type="button" class="ite" value="Update" onclick="edit_item();"> 
<input type="button" class="ite" value="Delete" onclick="del_item();"> 
</p> 
<input type="hidden" name="list" value="<%=item_id%>">

</form>

<%
}



  %>
    
    
    </body>
</html>
