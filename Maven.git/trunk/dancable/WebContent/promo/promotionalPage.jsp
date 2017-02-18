

<%@page import="mc_bean.mc_prop"%>
<%@page import="Main_category.item_bean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T Salon Management</title>
        <script language="javascript">
            function validate(){ 
            if(document.f1.unit.value==""){    
                alert("Please Enter unit.");
                document.f1.unit.focus();
                return false;        
            }
        }
 function promoPageImage(cat,id)
    {
        window.open('./promo/uploadPromoPageImages.jsp?cat='+cat+'&id='+id+'',
'welcome','width=500,height=500,status=yes')
  
} 
        </script>
    </head>
     <body style="margin-left:80;margin-right:80;margin-top:5">
         <%
             ArrayList pr_page=new ArrayList();
            if(request.getAttribute("pr_page")!=null)
                {
                    pr_page=(ArrayList)request.getAttribute("pr_page");
                }
             
             %>
         <div id="conta">
<table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp"%></TD></TR>
    <tr><td valign="top" width="100%" align="center"><table cellspacing="0" cellpadding="0" border="1" width="80%">
    <tr><td width="25%" valign="top">
     <table>
      <tr><td width="200"><a href="create_mc.do">Create Main Category</a></td></tr>
    <tr><td width="200"><a href="productUnit.do?type=view">Enter All Unit</a></td></tr>
    <tr><td width="200"><a href="fwd.do">Content Management System</a></td></tr>
    <tr><td width="200"><a href="promoPage.do?method=promo_page">Promotional Page</a></td></tr>
      </table>
         </td>      
    <td width="75%">
        <table width="100%">
            <tr><td align="center"><b>Promotional Pages</b></td></tr>
            </table>
            <table border="1" style="border-collapse: collapse;" width="90%" align="center">
                <% if(pr_page.size()!=0)
                {%>
                <tr><td><b>Sr No.</b></td><td><b>Unit</b></td><td><b>Link Image</b></td><td><b>Header Image</b></td><td><b>Add Detail</b></td></tr> 
                <% for(int i=0;i<pr_page.size();i++)
                    {
                       mc_prop  subcat_prop= (mc_prop)pr_page.get(i);
                    %>
                    <tr><td width="5%"><%=i+1%></td><td width="21%"><%=subcat_prop.getSub_cat()%></td>
                        <td width="32%" align="center" valign="middle">
                            <%if(!subcat_prop.getLink_image().equals("")){%>
                            <img src="./web_images/<%=subcat_prop.getLink_image()%>" width="80%">
                            <%}%>
                        </td>
                        <td width="32%" align="center" valign="middle">
                            <%if(!subcat_prop.getHeader_image().equals("")){%>
                            <img src="./web_images/<%=subcat_prop.getHeader_image()%>" width="80%">
                            <%}%>
                        </td>
                        <td width="10%">
                            <%if(subcat_prop.getLink_image().equals("")&&subcat_prop.getHeader_image().equals("")){%>
                            <span onclick="promoPageImage('<%=subcat_prop.getSub_cat()%>','<%=subcat_prop.getSubcat_id()%>')" style="cursor: pointer;text-decoration: underline;color: red;">add detail</span>
                        <%}%>
                        </td>
                    </tr>
                    <%}}%>
            </table>
                </td></tr>
                    </table></td></tr>
            
    <tr><td><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
</table>
    </div>
    </body>
</html>
