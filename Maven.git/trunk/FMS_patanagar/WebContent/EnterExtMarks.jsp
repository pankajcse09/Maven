<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>   
<%@page import="schedule.Compartment"%>  
<%! 
      Connection con=null;
      PreparedStatement psmt1=null;     
      ResultSet rs1=null;
      PreparedStatement psmt2=null;     
      ResultSet rs2=null;
      PreparedStatement psmt3=null;     
      ResultSet rs3=null;
      PreparedStatement psmt4=null;     
      ResultSet rs4=null;
      Statement stmt1=null;
      ResultSet r1=null;
      Statement stmt5=null;     
      ResultSet rs5=null;
      //Statement psmt6=null;     
      //ResultSet rs6=null;
   %>  
    <%       
      int th=0;
      int pr=0;
      String th1="";
      String pr1="";
      int startIndex= Integer.parseInt(request.getParameter("pr")); 
      int count = 0;
      int increment = 1;      
      int numRows=startIndex+11;
      int in=0;       
      Compartment cp=new Compartment();
      String cd="";
      String qc="";
      String qr2="";  
      String sm1="";  
      String qr4=""; 
      String qr3=""; 
      String cit="";
      String stid="";
      String tit=""; 
      HashMap hm1=new HashMap();
      HashMap hm2=new HashMap();
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ArrayList ar4=new ArrayList();
      ArrayList ar5=new ArrayList();     
      ArrayList ar6=new ArrayList();
      ArrayList ar7=new ArrayList(); 
      //ArrayList compar=new ArrayList();
      String yr=(String)request.getParameter("yrs");
      String sm=(String)request.getParameter("sem");      
      String et=(String)request.getParameter("emxtyp");
      String dg=(String)request.getParameter("deg");       
      if(request.getParameter("cid")!=null){
      cd=(String)request.getParameter("cid");
      }
       sm1=(new Integer(Integer.parseInt(sm)-1)).toString();       
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
       catch(Exception e){
       out.println("<h4>Database Connection Problem</h4>");
       out.println("<h5>" + e.getMessage() + "</h5>");
          } 
         try{     
           String qr1="select id from ex_course_detail where sessions='"+yr+"' and title='"+cd+"'";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
           ar3.add(rs1.getString("id"));
           }  
           if(!cd.equals("") && cd!=null){ 
           for(int j=0;j<ar3.size();j++){    
           String qr5="select theory,practical from coursemarks where sessions='"+yr+"' and course_id='"+ar3.get(j)+"' order by updatedate";
           stmt5=con.createStatement();
           rs5=stmt5.executeQuery(qr5);
           while(rs5.next()){
           if(!rs5.getString("theory").equals("NA")){
           ar6.add(ar3.get(j));   
           }    
           hm1.put(ar3.get(j),rs5.getString("theory")); 
           if(!rs5.getString("practical").equals("NA")){
           ar7.add(ar3.get(j));    
           }
           hm2.put(ar3.get(j),rs5.getString("practical")); 
           }
           }             
          /** try{
           if(!th1.equals("NA") && !th1.equals("")){
           th=Integer.parseInt(th1);  
           }
           if(!pr1.equals("NA") && !pr1.equals("")){
           pr=Integer.parseInt(pr1);
           }
           }
           catch(NumberFormatException ne){ 
               out.println(ne.getMessage());
           }*/
           }                       
           if(Integer.parseInt(sm)%2==0 && et.equals("EXTERNAL")){  
           qc="select count(distinct studid) as cnt from addmarks where permission='y' and years='"+yr+"' and (semester='"+sm+"' or semester='"+sm1+"') and degree='"+dg+"' and course_id='"+cd+"' and studid not in (select studid from extmarks where course_id='"+cd+"' and degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"')";         
           qr2="select studid from studinfo stinf where sem='"+sm+"' and sessions='"+yr+"' and degree='"+dg+"' order by studid";    
           qr3="select distinct title from ex_course_detail where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and sessions='"+yr+"'";           
           qr4="select distinct(studid) from extmarks where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"' and course_id='"+cd+"'"; 
           } 
           else if(Integer.parseInt(sm)%2==0 && et.equals("EXTPRACTICAL")){  
           qc="select count(distinct studid) as cnt from addmarks where permission='y' and years='"+yr+"' and (semester='"+sm+"' or semester='"+sm1+"') and degree='"+dg+"' and course_id='"+cd+"' and studid not in (select studid from extmarks where course_id='"+cd+"' and degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"')";         
           qr2="select stinf.studid from studinfo stinf where sem='"+sm+"' and sessions='"+yr+"' and degree='"+dg+"' order by stinf.studid";    
           qr3="select distinct title from ex_course_detail where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and sessions='"+yr+"'";           
           qr4="select distinct(studid) from extprmarks where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"' and course_id='"+cd+"'"; 
           }
           else{
            request.setAttribute("msg","Invalid Selection");
            RequestDispatcher rd=request.getRequestDispatcher("/SelectInfo.jsp?pn=p");
            rd.forward(request,response);
              }            
           psmt3=con.prepareStatement(qr3);
           rs3=psmt3.executeQuery(); 
           while(rs3.next()){
           ar4.add(rs3.getString("title"));
            }           
           stmt1=con.createStatement();
           r1=stmt1.executeQuery(qc);    
           r1.next(); 
           in=r1.getInt("cnt");            
           psmt2 = con.prepareStatement(qr2,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);           
           rs2=psmt2.executeQuery();            
           
           int remain = in % 10;
           if(startIndex+10<=numRows) {
           increment = startIndex + 10;
           }
           else{
           increment = startIndex + remain;
             }                
           while(rs2.next()){
           ar2.add(rs2.getString("studid"));    
           }
           in=ar2.size();
           remain = in % 10;
           if(startIndex+10<=numRows) {
           increment = startIndex + 10;
           }
           else{
           increment = startIndex + remain;
             }          
            psmt4=con.prepareStatement(qr4);
            rs4=psmt4.executeQuery();             
            while(rs4.next()){                 
            ar5.add(rs4.getString("studid"));                 
           }           
         }
          catch(SQLException se){
          out.println(se.getMessage());              
          } 
          finally{
          try{
           if(r1!=null){r1.close();}   
           if(rs1!=null){rs1.close();}  
           if(rs2!=null){rs2.close();} 
           if(rs3!=null){rs3.close();} 
           if(rs4!=null){rs4.close();} 
           if(rs5!=null){rs5.close();} 
           if(stmt1!=null){stmt1.close();} 
           if(psmt1!=null){psmt1.close();}                     
           if(psmt2!=null){psmt2.close();}                        
           if(psmt3!=null){psmt3.close();}   
           if(psmt4!=null){psmt4.close();} 
           if(stmt5!=null){stmt5.close();} 
           if(con!=null){con.close();}
           }
          catch(SQLException se){
              out.println(se.getMessage());
          }
      } 
%>
    <html>
    <head>  
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></script>           
         <script language="javascript" src="/Exam/resolution.js"></script>        
     <script language="javascript"></script>
    </head>
    <body>  
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td align="center">
<table width="100%"><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">
<tr><td valign=top><jsp:include page="/CommonLinks.jsp"/></td></tr>
<tr><td valign="top">
    <table width="100%" height="500" border="1" valign="top"><tr>
    <td width="20%" valign="top">
     <form method="post" action="<%=request.getContextPath()%>/EnterExtMarks.jsp?pr=<%=startIndex%>">
     <input type="hidden" name="yrs" value="<%=yr%>">      
     <input type="hidden" name="sem" value="<%=sm%>">
     <input type="hidden" name="emxtyp" value="<%=et%>">
     <input type="hidden" name="deg" value="<%=dg%>">     
      <table align="center" border="1">
      <tr><td>Course</td><td align="right"><select name="cid">
            <%
            if(cd!=null && !cd.equals("")){
            %>
                <option value="<%=cd%>"><%=cd%>
                <% 
                  }
                   for(int i=0;i<ar4.size();i++){
                %>                  
                <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%>
                <%}%>
            </select></td></tr>             
            <tr><td align="right" colspan="2"><input type="submit" value="submit"></td></tr>
        </table>        
     </form>   
    </td>
    <td width="60%" valign="top">
    <hr color="green">
    <center><table border="0" width="100%" valign="top">
    <tr><td align="left" valign="top"><b>Degree:</b><%=dg%></td>
    <td align="left"><b>Session:</b><%=yr%></td>    
    <td align="left"><b>Semester:</b><%=sm%></td></tr>
    <tr><td align="left"><b><%=et%></b></td><td align="left"><b>Course:</b><%=cd%></td></tr>
    </table></center>
     <hr color="green">
     <form name="f1" method="post" action="EntExtMarks?pr=<%=startIndex%>">
     <input type="hidden" name="yrs" value="<%=yr%>"> 
     <input type="hidden" name="sem" value="<%=sm%>">
     <input type="hidden" name="emxtyp" value="<%=et%>">
     <input type="hidden" name="deg" value="<%=dg%>">
     <input type="hidden" name="cid" value="<%=cd%>">   
     <table align="center" border="1" valign="top">             
          <%
         if(et.equals("EXTERNAL")){
         %>
         <tr><td width="15%">StudentID</td>
         <%
          for(int m=0;m<ar6.size();m++){           
          if(!hm1.get(ar6.get(m)).toString().equals("NA")){  
         %>
         <td width="15%"><%=ar6.get(m)%>(<%=hm1.get(ar6.get(m))%>)<input type="hidden" name="cr<%=m%>" value="<%=ar6.get(m)%>"></td>
         <%
          }}
          for(int i=startIndex-1;i<increment-1;i++){   
              if(i>=ar2.size()){
                 break;
              } 
         %>    
        <tr><td><%=ar2.get(i)%><input type="hidden" name="ro<%=i%>" value="<%=ar2.get(i)%>"></td>
        <%           
          for(int j=0;j<ar6.size();j++){
          if(!hm1.get(ar6.get(j)).toString().equals("NA")){               
         %>
        <td>
        <input type="text" name="<%=ar2.get(i)%>_<%=ar6.get(j)%>" size="8">
        <%
        if(hm2.get(ar6.get(j)).toString().equals("NA")){%>
        <input type="hidden" name="em_<%=ar2.get(i)%>_<%=ar6.get(j)%>" value="-1" size="8">
          <%}%>
          </td>
        <%}}
           }}
           if(et.equals("EXTPRACTICAL")){
         %>
         <tr><td width="15%">StudentID</td>
         <%
          for(int m=0;m<ar7.size();m++){
          if(!hm2.get(ar7.get(m)).toString().equals("NA")){  
         %>
         <td width="15%"><%=ar7.get(m)%>(<%=hm2.get(ar7.get(m))%>)<input type="hidden" name="cr<%=m%>" value="<%=ar7.get(m)%>"></td>
         <%
          }}
          for(int i=startIndex-1;i<increment-1;i++){   
              if(i>=ar2.size()){
                 break;
              } 
         %>    
        <tr><td><%=ar2.get(i)%><input type="hidden" name="ro<%=i%>" value="<%=ar2.get(i)%>"></td>
        <%           
          for(int j=0;j<ar7.size();j++){
          if(!hm2.get(ar7.get(j)).toString().equals("NA")){ 
         %>
        <td><input type="text" name="<%=ar2.get(i)%>_<%=ar7.get(j)%>" size="8">
         <%
        if(hm1.get(ar7.get(j)).toString().equals("NA")){%>
        <input type="hidden" name="em_<%=ar2.get(i)%>_<%=ar7.get(j)%>" value="-1" size="8">
          <%}%>
        </td>
        <%
          }}
           }}
       %>
           <tr><td align="right" colspan="6"><input type="submit" value="submit"></td></tr>                   
        </table>   
        <table><tr><td>
        <font size='1' color='black'>Displaying Records:</font> 
 <% 
     try{        
if(startIndex + 10 <= in){
%>
<font size='1' color='black'>
<%=startIndex%> - <%= increment - 1%>
</font>
<%
}
else{
%>
<font size='1' color='black'>
<%=startIndex%> - <%=in%>
</font>
<%
}
if(startIndex != 1){
%> 
<a href="<%=request.getContextPath()%>/EnterExtMarks.jsp?deg=<%=dg%>&cid=<%=cd%>&pr=<%=startIndex-10%>&yrs=<%=yr%>&sem=<%=sm%>&emxtyp=<%=et%>"><font size='1' color='black'>Previous</font></a>
<%
}
increment += 10;

if(startIndex + 10 <=in){    
%> 
<a href="<%=request.getContextPath()%>/EnterExtMarks.jsp?deg=<%=dg%>&cid=<%=cd%>&pr=<%=startIndex+10%>&yrs=<%=yr%>&sem=<%=sm%>&emxtyp=<%=et%>"><font size='1' color='black'>Next</font></a>
<%
}
}
    catch(Exception exc){
    if(startIndex != 1) {
%>
</td></tr></table>
<table><tr><td><font size='1' color='black'>Displaying Records:</font><font size='1' color='black'>
<%= " " + startIndex %> - <%=in%>
</font><a href="<%=request.getContextPath()%>/EnterExtMarks.jsp?deg=<%=dg%>&cid=<%=cd%>&pr=<%=startIndex-10%>&yrs=<%=yr%>&sem=<%=sm%>&emxtyp=<%=et%>"><font size='1' color='black'>Previous</font></a></td></tr></table>
<%
   }
}       
%>
    </td></tr></table>
     </form>
        <%
    if((String)request.getAttribute("result")!=null)
out.println("<center><font color='red'><b>"+(String)request.getAttribute("result")+"</b></font></center>");
%>
    </td>
    <td width="20%" valign="top">
    <!--<a href="/ShowExtMarks.jsp"><font color="blue">Show Records</font></a><br>-->
    <!--<a href="/UpdateExtMarks.jsp"><font color="blue">Update</font></a>-->   
    </td></tr></table>  
    </td></tr></table>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
    </body>
</html>
