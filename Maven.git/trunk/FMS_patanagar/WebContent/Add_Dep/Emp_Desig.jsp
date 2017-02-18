<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%response.setHeader("Cache-Control","no-cache");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gbpuat...</title>
        
       
        
    </head>
    <body bgcolor=#dcdcdc>

    <form method="post" action="Emp_Desig">
        
        <table align="center">
            <tr>
                <td>
                    
                
                
                
                
                <b>Enter Emp Desig</b><input type="text" name="desig" size="30"><p><p><p>
                </td>
            </tr>
            <tr><td>*TeachingStaff<input type=radio name=prof_es  value="ts"></td></tr>
<tr><td> *NonTeachingStaff<input type='radio' name=prof_es value='nts'></td></tr>
            <tr><td align="center"><input type="submit" value="ADD DESIG"></td></tr>
            <tr><td>
             
         <%
            String depdata="";
if((String)request.getAttribute("dep_success")!=null)
{
 depdata=(String)request.getAttribute("dep_success");
}
%>
<font color="red" size=3><%=depdata%></font>
         </td></tr>
     
            </table>
        
        </form>
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>
