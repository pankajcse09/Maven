<%-- 
    Document   : item_view
    Created on : May 29, 2013, 3:38:42 PM
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
        <title>Danceables</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
         <style type="text/css">
         .marquee {position:relative;
     overflow:hidden;
     width:500px;
     height:22px;
     border:solid black 1px;
     }
.marquee span {white-space:nowrap;}
         </style>
    </head>
    <body>
           <%
    
         ArrayList ar=new ArrayList();
         HashMap hm=new HashMap();
  HashSet hs=new HashSet();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;  
  
  int id=0;
   if(request.getAttribute("id")!=null){
  try {
 id=Integer.parseInt((String)request.getAttribute("id"));
  } catch (NumberFormatException ex) {
         ex.printStackTrace();
      }
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
  try{
   k=Integer.parseInt(stindex);   
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
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat">
                    <table class="cel1" style="padding-left: 0px" width="100%">
                        
                        <tr>
                            <td>
                                <table border="0" width="100%">
                        <tr>
                            <td valign="top" width="20%" style="padding-left: 50px">
                            
                    <table>
                        <tr>
                <td onclick="chang(this)" align="center">
                    <a href="subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail"><img src="images/homepage/CD-for-ballet-hover.png" width="200"></a>
                </td>
            </tr>
             <tr>
                <td class="chng" align="center" id="cl">
                    <a class="b" href="subcatdett.do?id=2&pa=a&pr=1&method=view_ItemDetail"><img src="images/homepage/cd-for-pre-ballet-normal.png" width="200"></a>
                </td>
            </tr>
                    </table> 
                </td>
                
                <td style="padding-left: 40px" width="80%">
                    <table border="0" celpadding="0" cellspacing="0" width="88%" align="left">
                        
                        <tr><td colspan="4"><img src="images/homepage/cd-for-ballet-image.png" width="100%"></td></tr>
                        <tr><td colspan="4" style=" font-size: 20px; color:green; background-color: yellow; font-weight: bold;"><marquee scrolldelay="200" width="">Special Discount on Downloads. Please See!</marquee> </td></tr>
                        
<%
try{ 
    String catid=(String)session.getAttribute("scid");
   // out.println(catid);
}catch(Exception e){e.getMessage();}
    round_funct rf=new round_funct();
      int count1=0;
      int n=ar.size();
       for (int c=0; c<n; c++)
       {    
     %>
                        <tr>
     <% int count=0;
         for (int m=count1; m<n; m++)
       {
            
         itembe=(mc_prop)ar.get(m);
     %>
     
         <td style="padding-bottom: 30px" width="22%" align="center">
             <font style="color:black;font-size:12px; font-family: Arial; font-weight: 600;"><%=itembe.getBrand()%><br>
      <a href="detail_item.do?id=<%=itembe.getItem_id()%>">       
<IMG SRC="./music_image/<%=itembe.getFilename()%>" width="120" height="120" border="0"></a><br>

<font style="color:olivedrab; font-size:11px; font-family: Arial; font-weight:600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>
<font style="color:black; font-size:11px; font-family: Arial; font-weight:600;">Shipment: &nbsp$<%=rf.round_toTwo(itembe.getPrice())%></font><br>
<font style="color:black; font-size:11px; font-family: Arial; font-weight:600;">Download: &nbsp$<%=rf.round_toTwo(itembe.getDown_price())%></font><br>
   <!--<font style="color:black;font-size:12px; font-weight: 600;">Quantity in Basket:&nbsp<br>-->
<a href="detail_item.do?id=<%=itembe.getItem_id()%>"><img  src="<%=request.getContextPath()%>/images/more.png" border="0" width="90"></a></font>

         </td>
         <!--<td width="55"></td>-->
             
        <% 
        count++;
          count1++;
         if(count>3){break;}
          
      
         }
         
     %>
     </tr>
     <%
        
       }
     
    %>    
      
             <tr><td colspan="5" align="right"><font style="font-size:12px;color:black"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>"><font size='1' color='black'>Previous</font></a> -->
    <a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>"><font size='1' color='black'>Next</font></a> -->
   <a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
   <%}%>
   </td></tr>          
   </table>
                </td>
                        </tr>
                        </table></td></tr>
       <tr> <td><%@include file="/footer.jsp"%></td></tr>  
                    </table>
                </td>
            </tr>
                  
        </table>
    </body>
</html>
