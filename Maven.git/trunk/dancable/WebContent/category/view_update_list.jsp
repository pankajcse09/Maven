<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="mc_bean.item_list"%>
<%@page import="mc_operat.Item_func"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
    <script language="javascript">
    function addlistvalue(){
document.forms[0].method="POST";

document.forms[0].action="Edit_itemlist_value";

document.forms[0].submit();
}
</script>
    <body>

    <h1>JSP Page</h1>
    <%
String itemlistvalue="";
Item_func itvalue=new Item_func();
String col_type=request.getParameter("type");
int  itemlist_id=(Integer.parseInt(request.getParameter("id")));
out.println(col_type);
out.println(itemlist_id);
   %>
    
   <%



String val=(String)itvalue.sel_listValue(col_type,itemlist_id);

out.println(val);



%>

<form>
   <textarea name="list" rows="10" cols="15"><%=val%></textarea>
   <input type="hidden" name="col_type" value="<%=col_type%>">
    <input type="hidden" name="itemlist_id" value="<%=itemlist_id%>">
  <input type="submit" value="savechanges" onclick="addlistvalue()">
   </form>
    
    
   
   
   
   
   
   
   
   
   
   
    </body>
</html>
