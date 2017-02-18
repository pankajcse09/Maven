<%-- 
    Document   : promo
    Created on : Jan 22, 2014, 1:34:18 PM
    Author     : kapil
--%>

<%@page import="file.PromoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>T Salon Management</title>
        
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js">
</script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
    <script language="javascript">
        function genPromo()
        {
            document.forms[0].action="<%=request.getContextPath()%>/generate_promo.do?method=generatePromo";
            document.forms[0].method="post";
            document.forms[0].submit();
        }
        
        function sendTo(prc,prp,prv)
        {
            document.f1.promo_code.value=prc;
            document.f1.promo_pin.value=prp;
            document.f1.pr_value.value=prv;
        }
        
        function validate(){ 
            if(document.f1.promo_code.value==""){    
                alert("Promotional code field should not be blank.");
                document.f1.promo_code.focus();
                return false;        
            }
            if(document.f1.promo_pin.value==""){    
                alert("Promotional pin field should not be blank.");
                document.f1.promo_pin.focus();
                return false;        
            }
            if(document.f1.pr_value.value==""){    
                alert("Promotional amount field should not be blank.");
                document.f1.pr_value.focus();
                return false;        
            }
            else if(document.f1.pr_value.value=="0.0"){    
                alert("Promotional amount should not be zero.");
                document.f1.pr_value.focus();
                return false;
                }
           else if(document.f1.pr_value.value=="0"){    
                alert("Promotional amount should not be zero.");
                document.f1.pr_value.focus();
                return false;
                } 
           var value = Number(document.f1.pr_value.value);
            if (Math.floor(value) == value) {
                    
                } else {
                    alert("Enter only numerical value.");
                }     
            if(document.f1.cusEmail.value==""){    
                alert("Email Id field should not be blank.");
                document.f1.cusEmail.focus();
                return false;        
            }
         }
    </script>
</head>
    <body background="white"  height="100%" style="background-repeat:repeat-y; background-position: left top;" >
        <%
        ArrayList al=new ArrayList();
        PromoBean pb=null;
        String promo_code="";
        String promo_pin="";
        if(request.getAttribute("list")!=null)
        {
            al=(ArrayList)request.getAttribute("list");
        }
        if(request.getAttribute("promo_code")!=null)
        {
            promo_code=(String)request.getAttribute("promo_code");
        }
        if(request.getAttribute("promo_pin")!=null)
        {
            promo_pin=(String)request.getAttribute("promo_pin");
        }
        %>
<table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0" valign="top"> 
          <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>
         
          <tr><td height="450" valign="top" align="left">
       <table border="1" width="100%"  ALIGN="CENTER" bgcolor="#ffffff" valign="top">
                <tr>

<td VALIGN="TOP" width="25%">
                    <table>
       <tr><td>Useful Links</td></tr>
     <tr><td><a href="emp_reg_form.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Employee Registration Form</a></td></tr> 
     <tr> <td><a href="EditRegistration.do?method=editRegist" style="text-decoration:none;font-size:15px;color:#7D0E0E">View/Edit Profile</a></td></tr> 
      <tr><td><a href="view_users.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Users</a></td></tr>
      <tr><td><a href="promo.do?method=allPromo" style="text-decoration:none;font-size:15px;color:#7D0E0E"> Promotional Code</a></td></tr>
  <tr>  <td><a href="view_feedback.do" style="text-decoration:none;font-size:15px;color:#7D0E0E"> View Feedback</a></td></tr>
<tr>  <td><a href="view_newsemail.do" style="text-decoration:none;font-size:15px;color:#7D0E0E"> Newsletter Email</a></td></tr>
     <tr><td><a href="user_view_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Registerd User Orders</a></td></tr>    
 <tr><td><a href="all_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Guest Orders</a></td></tr>
       <tr><td><a href="view_range_order.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Registerd User Order Date Wise </a></td></tr> 
<tr><td><a href="guest_datewise.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Guest User Order Date Wise</a></td></tr> 
<tr><td><a href="get_invoice.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Invoice</a></td></tr>
 <tr><td><a href="update_web.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Update Website</a></td></tr> 
    
    <!--<tr><td><a href="gotocms.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Content Management System</a></td></tr>-->
 
    </table>
                </td>
                
  <td valign="top"  width="75%" bgcolor="#ffffff">              
 <TABLE  BGCOLOR="white" borderColor=#000000 cellSpacing=0 cellPadding=0 width="100%" align=left border="0">
        <TBODY>
        <TR>
<TD valign=top align="left" height=230>
<!--2--><TABLE cellSpacing=0 cellPadding=0 width="100%" align="left" border="0" bordercolor="blue">
        <TBODY>
        
        
        
 <!--text start from here-->   
 <tr>
<td width="100%" align="left" valign="top">       
<table width="100%" border="0" cellpadding="0" cellspacing="5">
    <tr><td colspan="0" width="50%" align="center">
    <font style="font-weight:bold;color:#444444;font-size: 20px;"><u>Promotional Code</u></font>
        </td></tr>
<tr><td colspan="0" width="70%">
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="left">   
    <tr><td valign="top">
<form name="f">           
   <table>
    <tr><td align="left"> 
    <font style="font-weight:bold;color:#444444;font-size: 16px;">Generate promotional code and send to customer.</font>
        </td></tr>
    <tr><td>Promotional Code: <%=promo_code%></td></tr>
    <tr><td>Promotional Pin: <%=promo_pin%></td></tr>
    <tr><td align="left"><input type="button" value="Generate" onclick="genPromo()"></td></tr>
            </table>
</form>
</td>
            <td>
 <form name="f1" action="<%=request.getContextPath()%>/sendPromoTo.do?method=sending_promo" method="post" onsubmit="return validate()">               
   <table>
    <tr><td align="left"> 
    <font style="font-weight:bold;color:#444444;font-size: 16px;">Send the generated promotional code to customer.</font>
        </td></tr>
    <tr><td>Promotional Code: <input type="text" name="promo_code" id="promo_code" value="<%=promo_code%>"></td></tr>
    <tr><td>Promotional Pin: &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="promo_pin" id="promo_pin" value="<%=promo_pin%>"></td></tr>
    <tr><td>Enter Amount: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="pr_value" id="pr_value"></td></tr>
    <tr><td>Email Id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="cusEmail" value=""></td></tr>
    <tr><td align="left"><input type="Submit" value="Send"></td></tr>
            </table>
 </form>
            </td>      
    </table>
        
 </tr>
 <%if(request.getAttribute("msg")!=null){%>
 <tr><td align="center"><%=request.getAttribute("msg")%></td></tr>
 <%}%>
 <tr><td><hr></td></tr>
 <% if(al.size()!=0)
 {%>
  <tr><td colspan="0" width="100%">
<table width="90%" border="1" cellpadding="0" cellspacing="0" align="left" style="border-collapse: collapse">   
    <tr>
        <td><b>Promo Code</b></td><td><b>Promo Pin</b></td><td><b>Promo Amount</b></td>
        <td><b>Generated On</b></td><td><b>Expired On</b></td><td><b>Sent To</b></td>
        <td><b>Status</b></td><td><b>Send</b></td>
    </tr>
  <% for(int i=0;i<al.size();i++)
    {
        pb=(PromoBean)al.get(i);
        %>
        <tr style="line-height: 30px">
            <td><%=pb.getPromo_code()%></td><td><%=pb.getPromo_pin()%></td><td><%=pb.getPr_value()%></td>
            <td><%=pb.getGenerate_on()%></td><td><%=pb.getExpiry_on()%></td>
            <td>
                <%if(pb.getSend_to()!=null){%>
                <%=pb.getSend_to()%>
            <%}else{%>
            ---
            <%}%>
            </td>
            <td><%=pb.getStatus()%></td>
            <td align="center">
                <%if(pb.getStatus().equals("Available")){%>
                <span style="cursor: pointer;color: red;text-decoration: underline" onclick="sendTo('<%=pb.getPromo_code()%>','<%=pb.getPromo_pin()%>','<%=pb.getPr_value()%>')">Send</span>
            <%}else{%>
            Sent
            <%}%>
            </td>
        </tr>    
        
   <% }
 }%>
</table></td></tr>  
</table></td>
  <!--text end from here-->  
 </tr>
        </TBODY></TABLE></TD></TR></TBODY></TABLE>
          </td>
                
                
                
                </tr>
                </table>
              </td></tr></table>
<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
     </div>

    </body>
</html>
