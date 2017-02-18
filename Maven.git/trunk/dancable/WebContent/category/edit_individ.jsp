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
    function addvalue(){
document.forms[0].method="POST";

document.forms[0].action="Edit_item_value";

document.forms[0].submit();
}
</script>
    <body>

    <h1>JSP Page</h1>
    <%
String itemvalue="";
Mc_funct itvalue=new Mc_funct();
String col_type=request.getParameter("type");
int  item_id=(Integer.parseInt(request.getParameter("id")));
out.println(col_type);
out.println(item_id);
   %>
    
   <%



String val=(String)itvalue.sel_Value(col_type,item_id);

//out.println(val);



%>

<form>
   <textarea name="item" rows="10" cols="15"><%=val%></textarea>
   <input type="hidden" name="col_type" value="<%=col_type%>">
    <input type="hidden" name="item_id" value="<%=item_id%>">
    
  <input type="submit" value="savechanges" onclick="addvalue()">
   </form>
    
    
   
   
   
   
   
   
   
   
   
   
    </body>
</html>
