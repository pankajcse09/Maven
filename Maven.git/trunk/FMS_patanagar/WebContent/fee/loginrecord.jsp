<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="com.myapp.struts.DataConnection"%>

<%! Connection cn=null;
Statement stmt=null;
ResultSet rs=null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <table width="800" cellpadding="0" cellspacing="0"  bgcolor="#CCCCCC" align="center" height=450 border=1><tr><td valign="top">
 <table align="center"><tr><td><font size=5>Login Record</font></td></tr>
 </table></td></tr>
  <tr><td valign="top">
 <table width="50%" cellpadding="1" cellspacing="1" align="center" border=1>
 <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>
        <tr><td><b>User Name</b></td>
            <td><b>User Type</b></td>
            <td><b>Date</b></td>
            <td><b>Time</b></td>
        </tr>


<%
String username="";
String type="";
String dt="";
String tm="";

try
{
    DataConnection dc=new DataConnection();
    cn=(Connection)dc.Dataconnect();
}catch(Exception e)
{out.println(e.getMessage());}

try
{
    String sql="Select * from loginrecord order by rowid desc";
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
              username=rs.getString("username");  
              type=rs.getString("type");  
              dt=rs.getString("dt");  
              tm=rs.getString("time");  
              
%>
<tr><td><%=username%></td>
<td><%=type%></td>
<td><%=dt%></td>
<td><%=tm%></td>
</tr>

<%
            }
}catch(SQLException e)
{out.println(e.getMessage());}

%>

    </table>
  </td></tr>
<tr><td valign="top"><table align="center"><tr><td align=center>
<a href="delrecord.jsp"></a></td></tr></table></td></tr>
   
    </table>

    </body>
</html>
