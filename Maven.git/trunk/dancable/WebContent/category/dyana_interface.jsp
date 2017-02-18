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
<%@page import="java.sql.Timestamp"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
    <script language="javascript">
        
        function viewtab(mcid)
        {

newwin = window.open("./table_desc/View_tables.jsp?mcid="+mcid,"","width=700,height=500,resizable")


        }
        function chk(a,b)
        {
        var ch=eval('document.tabe.'+a+'.checked');
        if(ch==1){
        eval('document.tabe.'+b+'.checked=1');
        }       
       }
        function chk1(a,b)
        {
        var ch=eval('document.tabe.'+b+'.checked');
        if(ch==0){
        eval('document.tabe.'+a+'.checked=0');
        }       
       }
      </script>
    <body bgcolor="#dcdcdc">
    
   
     <%String id=request.getParameter("id");
if(request.getParameter("id")!=null)
{
out.println(id);
%>
   <table border="1">
       
       <form name="tabe" action="<%=request.getContextPath()%>/ins_tab.do" method="post">
      <tr><td>Enter Table Name:</td><td><input type="text" name="tabname"></td></tr> 
      
    
       <tr><td width="4%">Field Name</td><td width="4%">Datatype</td>
<td width="4%">Length</td><td width="1%">PK</td><td  width="3%">Not Null</td>
<td width="2%">Auto Inc</td></tr>


  <%for(int k=0;k<10;k++)
      {%>
<tr><td><input type="text" name="cn<%=k%>"></td>
<td><select size="1" name="ty<%=k%>">
    <option value="select">select</option>
<option value="bigint">bigint</option><option value="binary">binary</option>
<option value="bit">bit</option><option value="blob">blob</option>
<option value="bool">bool</option><option value="boolean">boolean</option>
<option value="char">char</option><option value="date">date</option>
<option value="datetime">datetime</option><option value="decimal">decimal</option>
<option value="double">double</option><option value="enum">enum</option>
<option value="float">float</option><option value="int">int</option>
<option value="longblob">longblob</option>
<option value="longtext">longtext</option>
<option value="mediumblob">mediumblob</option>
<option value="mediumint">mediumint</option>
<option value="mediumtext">mediumtext</option>
<option value="numeric">numeric</option>
<option value="real">real</option>
<option value="set">set</option>
<option value="smallint">smallint</option>
<option value="text">text</option>
<option value="time">time</option>
<option value="timestamp">timestamp</option>
<option value="tinyblob">tinyblob</option>
<option value="tinyint">tinyint</option>
<option value="tinytext">tinytext</option>
<option value="datetime">datetime</option>
<option value="varbinary">varbinary</option>
<option value="varchar">varchar</option>
<option value="year">year</option>




</select>
</td>

<td><select  name="le<%=k%>">
    <option value="select">select</option>
    <%for(int i=0;i<10000;i++){%>
    
 <option value="<%=i%>"><%=i%></option>
<%}%>
</td>

<td><input type="checkbox" name="pk<%=k%>" value="yes" onclick="chk('pk<%=k%>','nn<%=k%>')"></td>
<td><input type="checkbox" name="nn<%=k%>" value="yes" onclick="chk1('pk<%=k%>','nn<%=k%>')"></td>
<td><input type="checkbox" name="ai<%=k%>"></td>
</tr>
<%}%>
<input type="hidden" name="id" value="<%=id%>">

  </table>
  <table>
<tr><td><input type="submit" name="ct" value="Create Table"></td></tr>
       </table>
   
  
   
   </form>
       
     <table>
     <form name="">
    <tr><td>
    <input type="button" value="View Tables" onclick="viewtab(<%=id%>)">
</td>  </tr>
         
         
         </form>
         
     </table>  
        <%}%>
   </body>
   
   </html>
 