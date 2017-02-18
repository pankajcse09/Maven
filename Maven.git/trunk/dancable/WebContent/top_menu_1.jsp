<%-- 
    Document   : top_menu_1
    Created on : Jun 20, 2013, 3:58:11 PM
    Author     : kapil
--%>


        <style>
            .fnt{
                font-size: 14px;
                color: white;
                font-weight: 600;
            }
        </style>
    
 
       
        <table style="padding-left: 35px;" id="nav" border="0" cellspacing="0" cellpadding="0" width="770" height="60" valign="top">
            <tr align="center">
                <td width="30"><a class="menu_link" href="<%=request.getContextPath()%>/fm_home.do" id="link1" onclick="chngeCo(this)">HOME</a></td>
                <td class="fnt" width="10">|</td>
                <td width="25"><a class="menu_link" href="<%=request.getContextPath()%>/subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail" id="link2" onclick="chngeCo(this)">CD</a></td>
                <td class="fnt" width="10">|</td>
                <td width="25"><a class="menu_link" href="<%=request.getContextPath()%>/dvd.do?id=3&pa=a&pr=1&method=view_ItemDetail" id="link3">DVD</a></td>
                <td class="fnt" width="10">|</td>
                <td width="90"><a class="menu_link" href="#" id="link4">PRINTED MUSIC</a></td>
                <td class="fnt" width="10">|</td>
                <% if(session.getAttribute("loginid")!=null&&session.getAttribute("loginid")!="guest"){
%>
<td width="80"><a href="<%=request.getContextPath()%>/my_account.do"  class="menu_link" id="link5">MY ACCOUNT</a></td>
<%}
else{ %>
                <td width="80"><a class="menu_link" href="<%=request.getContextPath()%>/myaccount.do" id="link5">MY ACCOUNT</a></td>
                <%}%>
                <td class="fnt" width="10">|</td>
                <td width="20"><a class="menu_link" href="#" id="link6">CART</a></td>
                <td class="fnt" width="10">|</td>
                <td width="50"><a class="menu_link" href="#" id="link7">CHECKOUT</a></td>
                <td class="fnt" width="10">|</td>
                <td width="60" style="padding-right: 15px;"><a class="menu_link" href="#" id="link8">CONTACT US</a></td>
            </tr>
        </table>
    
