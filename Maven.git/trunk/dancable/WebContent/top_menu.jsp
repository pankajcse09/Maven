<%
    String loginchk="";
    if(session.getAttribute("loginid")!=null){
        loginchk=(String)session.getAttribute("loginid");
    }
//    out.println("Check Login Session: "+loginchk); 
    %>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/drop_down.css" />
        <table id="nav" border="0" cellspacing="0" cellpadding="0" class="topmenu_tb">
            <tr align="center" class="transBack">
                <td width="30"><a class="menu_link" href="<%=request.getContextPath()%>/fm_home.do?name=home" id="link1" onclick="chngeCo(this)">HOME</a></td>
                <td class="fnt" width="10">|</td>
                <td width="25"><a class="menu_link" href="<%=request.getContextPath()%>/subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail" id="link2" onclick="chngeCo(this)">CD</a></td>
                <td class="fnt" width="10">|</td>
                <td width="25"><a class="menu_link" href="<%=request.getContextPath()%>/dvd.do?id=3&pa=a&pr=1&method=view_ItemDetail" id="link3">DVD</a></td>
                <td class="fnt" width="10">|</td>
                <td width="90"><a class="menu_link" href="<%=request.getContextPath()%>/prmusic.do?id=4&id1=5&pa=a&pr=1&pr1=1&method=view_Item_Detail" id="link4">PRINTED MUSIC</a></td>
                <td class="fnt" width="10">|</td>
                <% if(loginchk!=null&&!loginchk.equals("guest")&&!loginchk.equals("")){
%>
<td width="80"><a href="<%=request.getContextPath()%>/my_account.do"  class="menu_link" id="link5">MY ACCOUNT</a></td>
<%}
else{ %>
                <td width="80"><a class="menu_link" href="<%=request.getContextPath()%>/myaccount.do" id="link5">MY ACCOUNT</a></td>
                <%}%>
                <td class="fnt" width="10">|</td>
                <td width="20"><a class="menu_link" href="<%=request.getContextPath()%>/chekout_cart.do?method=checkout_cart" id="link6">CART</a></td>
                <td class="fnt" width="10">|</td>
                <td width="50"><a class="menu_link" href="<%=request.getContextPath()%>/chkout.do" id="link7">CHECKOUT</a></td>
                <td class="fnt" width="10">|</td>
                <td width="60" style="padding-right: 15px;"><a class="menu_link" href="<%=request.getContextPath()%>/fm_home.do?name=contactus" id="link8">CONTACT US</a></td>
            </tr>
        </table>
   