<%-- 
    Document   : applyPromoAjax
    Created on : Jan 22, 2014, 6:26:30 PM
    Author     : kapil
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="file.PromoBean"%>
<%@page import="file.PromoDB"%>
<%
    String prc=(String)request.getParameter("en");
    String prp=(String)request.getParameter("cn");
    double total=Double.parseDouble(request.getParameter("fta").toString());
    
    
    NumberFormat formatter = new DecimalFormat("#0.00");
    
    PromoBean pb=new PromoBean();
    pb.setPromo_code(prc);
    pb.setPromo_pin(prp);
    PromoDB pdb=new PromoDB();
    int cn=pdb.checkPromoAt(pb);
    if(cn==0){
        %>
        
        <table align="left" bgcolor="white" width="75%" style="padding-top: 20px">
      <tr><td align="center" colspan="2">
              <font style="font-weight: bold;color:#4D4D4D;">Apply Promotional Code</font>
          </td></tr>
      <tr><td align="center" colspan="2">
              <font style="color:#AE1E04;">You have entered wrong Promotional Code and Promotional Pin.</font>
          </td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Code:</font></td>
          <td><input type="text" name="promo_code" id="prc"></td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Pin:</font></td>
          <td><input type="text" name="promo_pin" id="prp"></td></tr>
      <tr>
          <td align="center" colspan="2"><span><input type="button" value="Apply" onclick="applyPromo()"></span></td></tr>
      <input type="hidden" name="card-amount" id="itemAmount" value="<%=formatter.format(total)%>" />
  </table>
    <%}else if(cn==-1)
    {%>
      <table align="left" bgcolor="white" width="75%" style="padding-top: 20px">
      <tr><td align="center" colspan="2">
              <font style="font-weight: bold;color:#4D4D4D;">Apply Promotional Code</font>
          </td></tr>
      <tr><td align="center" colspan="2">
              <font style="color:#AE1E04;">You have already used this Promotional Code and Promotional Pin.</font>
          </td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Code:</font></td>
          <td><input type="text" name="promo_code" id="prc"></td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Pin:</font></td>
          <td><input type="text" name="promo_pin" id="prp"></td></tr>
      <tr>
          <td align="center" colspan="2"><span><input type="button" value="Apply" onclick="applyPromo()"></span></td></tr>
      <input type="hidden" name="card-amount" id="itemAmount" value="<%=formatter.format(total)%>" />
  </table>  
    <%} else{
    PromoBean pbb=pdb.retStoredPromoDate(pb);
    %>
<table align="left" bgcolor="white" width="75%" style="padding-top: 20px">
      <tr><td align="center" colspan="2">
              <font style="font-weight: bold;color:#4D4D4D;">Promotional Code</font>
          </td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Code:</font></td>
          <td><%=prc%></td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Pin:</font></td>
          <td><%=prp%></td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:13px">Promotional Amount:</font></td>
          <td><%=pbb.getPr_value()%></td></tr>
      <tr>
          <td><font STYLE="font-weight:bold;color:#AE1E04;font-size:15px">Total Amount:</font></td>
          <td><b><%=formatter.format(total-pbb.getPr_value())%></b></td></tr>
      <input type="hidden" name="card-amount" id="itemAmount" value="<%=formatter.format(total-pbb.getPr_value())%>" />
  </table> 
<%
    session.setAttribute("promoBean", pbb);
   // session.setAttribute("promostatus", "applied");
    }%>