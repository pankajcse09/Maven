<%-- 
    Document   : hostel_sidemenu
    Created on : Mar 2, 2015, 8:58:54 PM
    Author     : kapil
--%>

<%@page import="User_Role.User_role_bean"%>
<%
User_role_bean urbb=(User_role_bean)session.getAttribute("user_auth");
String schk="yes";
%>
       <table class="t" rules="column"> 
           <tr><td valign="top" style="padding-left: 5px;" align="left">
                   <font color="green" style="font-family:Times New Roman" size="4"><strong>Hostel</strong></font></td></tr>
     
        <%if(urbb.getUr_create().equals(schk)){%>       
            <tr><td><a href="<%=request.getContextPath()%>/hos_a.do">
                        <input type="button" value="Hostel Assign" style="width:185px"></a></td></tr>
         <tr><td><a href="<%=request.getContextPath()%>/mfp.do">
                        <input type="button" value="Monthly Food Payment" style="width:185px"></a></td></tr>
            <%}%>
         <%if(urbb.getUr_update().equals(schk)){%>       
            <tr><td><a href="<%=request.getContextPath()%>/emfp.do">
                 <input type="button" value="Edit Monthly Food Payment" style="width:185px"></a></td></tr>
            <%}%>
            <tr><td><a href="<%=request.getContextPath()%>/h_pfBill.do">
                 <input type="button" value="Check Posted Food Bill" style="width:185px"></a></td></tr>
          </table>
      
           
