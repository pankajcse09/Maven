<%-- 
    Document   : printed_music
    Created on : Jun 24, 2013, 4:18:35 PM
    Author     : kapil
--%>

<%@page import="mc_operat.round_funct"%>
<%@page import="mc_bean.mc_prop"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Printed Music</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
    </head>
    <body>
           <%
    
         ArrayList ar=new ArrayList();
         ArrayList ar1=new ArrayList();
         HashMap hm=new HashMap();
         HashMap hm1=new HashMap();
  HashSet hs=new HashSet();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;
String ft1="";
  String pre1="";
  String nxt1="";
  String stindex1="";
  int k1=0;     
  
  int id=0;
  int id1=0;
   
  try {
      if(request.getAttribute("id")!=null){
 id=Integer.parseInt((String)request.getAttribute("id"));
 }
       if(request.getAttribute("id1")!=null){
 id1=Integer.parseInt((String)request.getAttribute("id1"));
 }
  } catch (NumberFormatException ex) {
         ex.printStackTrace();
      }
 
   String pa="";
    if(request.getAttribute("pa")!=null){
   pa=(String)request.getAttribute("pa");
    }
  if(request.getAttribute("hmap")!=null){
  hm=(HashMap)request.getAttribute("hmap");  
  //out.println("arjun"+hm);
  ar=(ArrayList)hm.get("arr");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  //out.println(nxt);
  stindex=hm.get("stindex").toString(); 
  }
   if(request.getAttribute("hmap1")!=null){
  hm1=(HashMap)request.getAttribute("hmap1");  
  //out.println("arjun"+hm);
  ar1=(ArrayList)hm1.get("arr");  
  ft1=(String)hm1.get("fromto");
  pre1=(String)hm1.get("previous");
  nxt1=(String)hm1.get("next");  
  //out.println(nxt);
  //stindex1=hm1.get("stindex").toString(); 
  }
  try{
   k=Integer.parseInt(stindex); 
//k1=Integer.parseInt(stindex1);    
  }
  catch(NumberFormatException ne){}
 
   
    
     String unit="";
  String status="";
   String brand="";
    String prod_id="";
   double price=0.0;
   String size="";    
   int subcat_id=0;
   String filename="";  
     String detail="";
    double marketprice=0.0;
      double discount=0.0;
       String discountdetail="";
      String image="";
   int itemid=0;
     mc_prop  itembe=new mc_prop();
      ArrayList itemlist=new ArrayList();
      String nav="";
  if(request.getAttribute("nav")!=null)
{

nav=(String)request.getAttribute("nav");
//out.println(homelist);
}
    
     %>
        <table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <div id="topdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                               </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                </td>
            </tr>
            <tr>
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat" border="">
                    <table class="cel1" style="padding-left: 0px" border="0" align="center" cellspacing="0" cellpadding="0">
                        <tr><td width="950"><img src="images/homepage/ballet-class-music-image.png" width="99%" height="410"></td></tr>
                        <tr>
                            <td width="950">
                                <table border="0" width="100%"> 
                                    <tr>
                <td class="chang" align="left" style="padding-left: 80px">
                    <!--<a class="b" href="subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail">BALLET CLASS MUSIC</a>-->
                    <span class="prmus">BALLET CLASS MUSIC</span>
                </td>
            
                        </tr>
                        <tr>
                <td style="padding-left: 0px" width="100%">
                    <table border="0" celpadding="0" cellspacing="0" width="100%">
                          
<%
String catid=(String)session.getAttribute("scid");
   // out.println(catid);
    round_funct rf=new round_funct();
      int count1=0;
       for (int c=0; c<ar.size(); c++)
       {    
     %>
     <tr>
     <% int count=0;
         for (int m=count1; m<ar.size(); m++)
       {
            
         itembe=(mc_prop)ar.get(m);
     %>
     
         <td style="padding-top: 30px;" width="370" align="left">
             <table><tr>
                     <td>
 <a href="detail_item.do?id=<%=itembe.getItem_id()%>">            
<IMG SRC="<%=request.getContextPath()%>/music_image/<%=itembe.getFilename()%>" width="120" height="150" border="0"></a>
                     </td>
                     <td valign="top">
<font style="color:#3EAAAA;font-size:13px;"><%=itembe.getBrand()%><br>
<font style="color:black;font-size:14px; font-weight: 600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>
<font style="color:black;font-size:14px; font-weight: 600;">Price: &nbsp$<%=rf.round_toTwo(itembe.getPrice())%></font><br>
 <!-- <font style="color:black;font-size:14px; font-weight: 600;">Quantity in Basket:&nbsp<br>-->
<a href="detail_item.do?id=<%=itembe.getItem_id()%>"><img  src="<%=request.getContextPath()%>/images/more.png" border="0" width="90"></a></font>
                     </td></tr></table>
         </td>
         <!--<td width="55"></td>-->
             
        <% 
        count++;
          count1++;
         if(count>1){break;}
          
      
         }
         
     %>
     </tr>
     <%
        
       }
     
    %>    
      
             <tr><td colspan="5" align="right"><font style="font-size:12px;color:black"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <%if(!pre1.equals("")){%>
    <a href="prmusic.do?method=view_Item_Detail&pr=<%=pre%>&pr1=<%=pre1%>&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
    <%} else{%>
    <a href="prmusic.do?method=view_Item_Detail&pr=<%=pre%>&pr1=1&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
    <%} }
    if(!nxt.equals("")){%>
    <% if(!nxt1.equals("")){%>
   <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>"><font size='1' color='black'>Next</font></a> -->
   <a href="prmusic.do?method=view_Item_Detail&pr=<%=nxt%>&pr1=<%=nxt1%>&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
   <%} else{%>
   <a href="prmusic.do?method=view_Item_Detail&pr=<%=nxt%>&pr1=1&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
   <%}}%>
   </td></tr>          
   </table>
                </td>
                        </tr>
                  
            
                        <tr><td height="50"></td></tr>

                        <tr>
                           
                <td class="chang" align="left" style="padding-left: 80px">
                    <!--<a class="b" href="subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail">BALLET SCORE</a>-->
                    <span class="prmus">BALLET SCORE</span>
                </td>
            
                        </tr>
                        <tr>
                <td style="padding-left: 0px" width="100%">
                    <table border="0" celpadding="0" cellspacing="0" width="100%">
                          
                          <%
      int count2=0;
       for (int c=0; c<ar1.size(); c++)
       {    
     %>
     <tr>
     <% int count=0;
         for (int m=count2; m<ar1.size(); m++)
       {
            
         itembe=(mc_prop)ar1.get(m);
     %>
     
         <td style="padding-top: 30px;" width="370" align="left">
             <table><tr>
                     <td>
             
<IMG SRC="<%=request.getContextPath()%>/music_image/<%=itembe.getFilename()%>" width="120" height="150" border="0">
                     </td>
                     <td valign="top">
<font style="color:#3EAAAA;font-size:13px;"><%=itembe.getBrand()%><br>
<font style="color:black;font-size:14px; font-weight: 600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>
<font style="color:black;font-size:14px; font-weight: 600;">Price: &nbsp$<%=itembe.getPrice()%></font><br>
  <!--<font style="color:black;font-size:14px; font-weight: 600;">Quantity in Basket:&nbsp<br>-->
<a href="detail_item.do?id=<%=itembe.getItem_id()%>"><img  src="<%=request.getContextPath()%>/images/click-here-button.png" border="0" width="90"></a></font>
                     </td></tr></table>
         </td>
         <!--<td width="55"></td>-->
             
        <% 
        count++;
          count2++;
         if(count>1){break;}
          
      
         }
         
     %>
     </tr>
     <%
        
       }
     
    %>    
      
             <tr><td colspan="5" align="right"><font style="font-size:12px;color:black"><b>Displaying Records:&nbsp;<%=ft1%></b></font>
    <%if(!pre1.equals("")){%>
    <%if(!pre.equals("")){%>
    <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>"><font size='1' color='black'>Previous</font></a> -->
    <a href="prmusic.do?method=view_Item_Detail&pr=<%=pre%>&pr1=<%=pre1%>&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
     <%} else{%>
    <a href="prmusic.do?method=view_Item_Detail&pr=1&pr1=<%=pre1%>&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
    <%}}
    if(!nxt1.equals("")){%>
     <% if(!nxt1.equals("")){%>
   <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>"><font size='1' color='black'>Next</font></a> -->
   <a href="prmusic.do?method=view_Item_Detail&pr=<%=nxt%>&pr1=<%=nxt1%>&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
    <%} else{%>
   <a href="prmusic.do?method=view_Item_Detail&pr=1&pr1=<%=nxt1%>&id=<%=id%>&id1=<%=id1%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
   <%}}%>
   </td></tr>          
   </table>
                </td>
                        </tr>
                   
            
                    </table></td></tr>

  <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>                      
                    </table></td></tr>
                  
        </table>
    </body>
</html>

