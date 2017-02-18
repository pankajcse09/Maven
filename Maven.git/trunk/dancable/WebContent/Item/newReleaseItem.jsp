<%-- 
    Document   : newReleaseItem
    Created on : Oct 29, 2013, 1:22:59 PM
    Author     : kapil
--%>


<%@page import="mc_operat.round_funct"%>
<%@page import="mc_bean.mc_prop"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mc_operat.Mc_funct"%>
<%@page import="java.util.HashMap"%>
<% 
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    String p=request.getParameter("pr");
    //String en="A-5025";
    HashMap hm=new HashMap();
         Mc_funct func=new Mc_funct(); 
         
         hm=(HashMap)func.get_newRelItem(p);
         
         ArrayList ar=new ArrayList();
         
         mc_prop  itembe=new mc_prop();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;  
  

  
  //out.println("arjun"+hm);
  ar=(ArrayList)hm.get("arr");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  //out.println(nxt);
  stindex=hm.get("stindex").toString(); 
  
  try{
   k=Integer.parseInt(stindex);   
  }
  catch(NumberFormatException ne){}
%>
<table style="padding-top: 20px" cellspacing="0" cellpadding="0" border="0" width="100%">
<tr><td colspan="2"><img src="<%=request.getContextPath()%>/images/homepage/new release.png"></td></tr>
                                                                                             
  <%
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
     
         <td style="padding-bottom: 30px" width="50%" align="center">
             <font style="color:black;font-size:10px; font-weight: 600;"><%=itembe.getBrand()%><br>
            
<IMG SRC="./music_image/<%=itembe.getFilename()%>" width="120" height="120" border="0"><br>

<font style="color:black;font-size:12px; font-weight: 600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>
<font style="color:black;font-size:12px; font-weight: 600;">Price: &nbsp$<%=rf.round_toTwo(itembe.getPrice())%></font><br>
<a href="detailItem.do?id=<%=itembe.getItem_id()%>&ch=nr"><img  src="<%=request.getContextPath()%>/images/click-here-button.png" border="0" width="90"></a></font>

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
      
             <tr><td colspan="2" align="right"><font style="font-size:12px;color:black"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <span onclick="showRelItem('<%=pre%>')" style="cursor: pointer"><font size='1' color='black'>Previous</font></span>
    <%}
    if(!nxt.equals("")){%>
   <span onclick="showRelItem('<%=nxt%>')" style="cursor: pointer"><font size='1' color='black'>Next</font></span>
   <%}%>
   </td></tr>
    </table>
