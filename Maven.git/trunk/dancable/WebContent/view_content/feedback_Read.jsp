 <%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.Im_ResumeUtilty"%>
<%@page import="Feedback.feedbean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Danceable Management</title>
  <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
</head>

<body background="white"  height="100%" style="background-repeat:repeat-y; background-position: left top;" >
    <%!
Im_ResumeUtilty rp=new Im_ResumeUtilty();
ArrayList detail= new ArrayList();
feedbean dd=new feedbean();
%>
<%
int pageP = 1;
        int recordsPerPage = 25;
        if(request.getParameter("page") != null)
            pageP = Integer.parseInt(request.getParameter("page"));
detail=(ArrayList)rp.view_Feedback((pageP-1)*recordsPerPage,recordsPerPage);
//out.println("detail"+detail);
int noOfRecords = rp.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
%>
<div id="conta" align="center">
         <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0" valign="top"> 
          <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>
          <tr><td height="450" valign="top" align="left">
       <table border="1" width="100%"  ALIGN="CENTER" bgcolor="#ffffff" valign="top">
                <tr>

<td VALIGN="TOP" width="25%">
                   <%@ include file="/jsp/admin_left_menu.jsp" %> 
                </td>


<td valign="top"  width="100%" bgcolor="#ffffff">
      <table width="100%"> 
          <tr><td>
        <table align="right" cellspacing="5" cellpadding="5"><tr>
           <%if(noOfPages>=1){%>
        <td>
                <%if(pageP>1){%>
                 <a href="./view_feedback.do?page=<%=pageP-1%>">
                     <strong>Previous</strong>
                     </a>
                 <%}%>
        </td>
        <td>
                 <%if(pageP<noOfPages){%>
                 <a href="./view_feedback.do?page=<%=pageP+1%>">
                     <strong>Next</strong>
                          </a>
                 <%}%>
        </td>
                 <%}%>
            </tr></table>
         </td></tr>       
<tr>
     <td>
  <table border="1" width=100% style="border-collapse: collapse">
       
  <%
if(!detail.isEmpty())
{
        
  %>
   <h3>List of FeedBack Detail...</h3>
  <tr>
  <td width="15%"><b>Name</b></td>
    <td width="15%"><b>EmailId:</b></td>
      <td width="10%"><b>Contact no.</b></td>
        <!--<td width=""> Correspondence Address</td>-->
<td width="10%"><b>Subject</b></td>
<td width="50%"><b>Message</b></td>
<td width="50%"><b>Timestamp</b></td>

    </tr> 
  <%
//out.println((ArrayList)request.getAttribute("customer"));

for(int i=0;i<detail.size();i++)
{
dd=(feedbean)detail.get(i);
//out.println("filename"+dd.getName());

  %>
  <tr>
<td><b><%=dd.getName()%></b></td><td><%=dd.getEmailid()%></td><td><%=dd.getContactno()%></td>
<!--<td><%=dd.getAddress()%></td>-->
<td><%=dd.getSub()%></td><td><%=dd.getMsg()%></td>
<td><%=dd.getEmailRegisDate()%></td>
</tr>
  
  <%
} 
    
}


%>
      
           
    </table> 
  
     </td>
        
        </tr>
 <tr><td>
        <table align="right" cellspacing="5" cellpadding="5"><tr>
           <%if(noOfPages>=1){%>
        <td>
                <%if(pageP>1){%>
                 <a href="./view_feedback.do?page=<%=pageP-1%>">
                     <strong>Previous</strong>
                     </a>
                 <%}%>
        </td>
        <td>
                 <%if(pageP<noOfPages){%>
                 <a href="./view_feedback.do?page=<%=pageP+1%>">
                     <strong>Next</strong>
                          </a>
                 <%}%>
        </td>
                 <%}%>
            </tr></table>
         </td></tr>       
          
      
   
   </table>
  
    
</td>
                
                
                
                </tr>
                </table>
              </td></tr></table>
<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
     </div>

    </body>
</html>