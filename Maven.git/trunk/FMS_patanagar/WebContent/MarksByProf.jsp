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
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ArrayList ar4=new ArrayList();
      ArrayList ar5=new ArrayList();     
      //ArrayList compar=new ArrayList();
      String yr=(String)request.getParameter("yrs");
      String sm=(String)request.getParameter("sem");      
      String et=(String)request.getParameter("emxtyp");
      String dg=(String)request.getParameter("deg");         
      if(request.getParameter("cid")!=null){
      cd=(String)request.getParameter("cid");
      }
      String eid="";
      if(session.getAttribute("emp_id")!=null){
      eid=(String)session.getAttribute("emp_id");    
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
           if(!cd.equals("") && cd!=null){  
           String qr5="select theory,practical from coursemarks where course_id='"+cd+"' order by updatedate";
           stmt5=con.createStatement();
           rs5=stmt5.executeQuery(qr5);
           if(rs5.next()==true){
           th1=rs5.getString("theory"); 
           pr1=rs5.getString("practical");                       
           }             
           try{
           if(!th1.equals("NA") && !th1.equals("")){
           th=Integer.parseInt(th1);  
           }
           if(!pr1.equals("NA") && !pr1.equals("")){
           pr=Integer.parseInt(pr1);
           }
           }
           catch(NumberFormatException ne){ 
               out.println(ne.getMessage());
           }
           }
           String qr1="select title from course_detail where id='"+cd+"'";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
           tit=(String)rs1.getString("title");
           }  
           if(cd!=null && !cd.equals("")){
           cit=cd+"("+tit+")";
           }                        
             if(et.equals("INTERNAL") ){              
            qc="select count(distinct stinf.studid) as cnt from studinfo stinf where sem='"+sm+"' and sessions='"+yr+"' and degree='"+dg+"' and studid not in (select distinct studid from addmarks am where course_id='"+cd+"' and degree='"+dg+"' and semester='"+sm+"' and years='"+yr+"')";   
            qr2="select stinf.studid from studinfo stinf where sem='"+sm+"' and sessions='"+yr+"' and degree='"+dg+"' and studid not in (select distinct studid from addmarks am where course_id='"+cd+"' and degree='"+dg+"' and semester='"+sm+"' and years='"+yr+"') order by stinf.studid";    
            qr3="select distinct id,title from ex_course_detail where degree='"+dg+"' and semester='"+sm+"' and sessions='"+yr+"' and id in (select course_id from ex_assigncourses where sessions='"+yr+"' and prof_id='"+eid+"')";
            qr4="select distinct studid from addmarks where degree='"+dg+"' and semester='"+sm+"' and years='"+yr+"' and course_id='"+cd+"'"; 
            }           
           else{
           if(Integer.parseInt(sm)%2==0 && et.equals("EXTERNAL")){  
           qc="select count(distinct studid) as cnt from addmarks where permission='y' and years='"+yr+"' and (semester='"+sm+"' or semester='"+sm1+"') and degree='"+dg+"' and course_id='"+cd+"' and studid not in (select studid from extmarks where course_id='"+cd+"' and degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"')";         
           qr2="select studid from addmarks where permission='y' and years='"+yr+"' and (semester='"+sm+"' or semester='"+sm1+"') and degree='"+dg+"' and course_id='"+cd+"' and studid not in (select studid from extmarks where course_id='"+cd+"' and degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"') order by studid";     
           qr3="select distinct id,title from ex_course_detail where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and sessions='"+yr+"' and id in (select course_id from ex_assigncourses where sessions='"+yr+"' and prof_id='"+eid+"')";           
           qr4="select distinct(studid) from extmarks where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"' and course_id='"+cd+"'"; 
           }          
           else{
           if(Integer.parseInt(sm)%2==0 && et.equals("COMPARTMENT")){               
           ar2=cp.selectId(yr,sm,dg,cd);            
           qr3="select id,title from ex_course_detail where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and sessions='"+yr+"' and id in (select course_id from ex_assigncourses where sessions='"+yr+"' and prof_id='"+eid+"')";
           qr4="select distinct(studid) from compmarks where degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"' and course_id='"+cd+"'"; 
           }
           else{
            request.setAttribute("msg","Invalid Selection");
            RequestDispatcher rd=request.getRequestDispatcher("/SelectInfo.jsp?pn=p");
            rd.forward(request,response);
              }
           }
           }
           psmt3=con.prepareStatement(qr3);
           rs3=psmt3.executeQuery(); 
           while(rs3.next()){
            ar3.add(rs3.getString("id"));           
            ar4.add(rs3.getString("title"));
            }           
           if(!et.equals("COMPARTMENT")){   
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
           }  
           else{
           in=ar2.size();
           int remain = in % 10;
           if(startIndex+10<=numRows) {
           increment = startIndex + 10;
           }
           else{
           increment = startIndex + remain;
             } 
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
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>        
     <script language="javascript"></script>
    </head>
    <body>     
<table width="100%" cellpadding="0" cellspacing="0" bgcolor="#455A8B"><tr><td>
<table width="100%" ><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">
<tr><td valign=top><jsp:include page="/CommonLinks.jsp"/></td></tr>
<tr><td valign="top">
    <table width="100%" height="500" border="1" valign="top"><tr><td width="20%" valign="top">
     <form method="post" action="<%=request.getContextPath()%>/MarksByProf.jsp?pr=<%=startIndex%>">
     <input type="hidden" name="yrs" value="<%=yr%>"> 
     <input type="hidden" name="sem" value="<%=sm%>">
     <input type="hidden" name="emxtyp" value="<%=et%>">
     <input type="hidden" name="deg" value="<%=dg%>">     
      <table align="center" border="1">               
        <tr><td>Course ID</td><td align="right"><select name="cid">
            <%
            if(cd!=null && !cd.equals("")){
            %>
                <option value="<%=cd%>"><%=cd%>
                <% 
                  }
                   for(int i=0;i<ar3.size();i++){
                %>                  
                <option value="<%=ar3.get(i)%>"><%=ar3.get(i)%>(<%=ar4.get(i)%>)
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
    <td align="left"><b>Year:</b><%=yr%></td>
    <td align="left"><b>Semester:</b><%=sm%></td></tr>
    <tr><td align="left"><b><%=et%></b></td><td align="left" colspan="2"><b>Course:</b><%=cit%></td></tr>
    </table></center>
     <hr color="green">
     <form name="f1" method="post" action="ProfEntMarks?pr=<%=startIndex%>">
     <input type="hidden" name="yrs" value="<%=yr%>"> 
     <input type="hidden" name="sem" value="<%=sm%>">
     <input type="hidden" name="emxtyp" value="<%=et%>">
     <input type="hidden" name="deg" value="<%=dg%>">
     <input type="hidden" name="cid" value="<%=cd%>">      
     <table align="center" border="1" valign="top">  
          <%
        if(et.equals("INTERNAL")){
        %>   
        <tr><td width="15%" valign="middle">StudentID</td>
        <%
        if(!th1.equals("NA")){
        %>        
        <td width="15%" valign="middle">MidTerm(<%=th/2%>)</td>
        <%}
        if(!th1.equals("NA")){
        %>
        <td width="15%" valign="middle">EndTerm(<%=th/2%>)</td>
        <%}
        if(!pr1.equals("NA")){
        %>
        <td width="15%" valign="middle">Internal<br>Practical(<%=pr%>)</td>
        <%}%>
        <td width="15%" valign="middle">Attendance(%)</td></tr>
        <%       
         for(int i=startIndex-1;i<increment-1;i++){   
              if(i>=ar2.size()){
                 break;
              } 
         %>          
        <tr><td><%=ar2.get(i)%><input type="hidden" name="ro<%=i%>" value="<%=ar2.get(i)%>" size="12"></td>
        <%
        if(!th1.equals("NA")){
        %> 
        <td><input type="text" name="mi<%=i%>" size="8"></td>
        <%}
        if(!th1.equals("NA")){
        %>
        <td><input type="text" name="en<%=i%>" size="8"></td>
        <%}
        if(!pr1.equals("NA")){
        %>
        <td><input type="text" name="in<%=i%>" size="8"></td>
        <%}%>
        <td><input type="text" name="at<%=i%>" size="8"></td></tr>
        <%        
         }
        }
        if(et.equals("EXTERNAL")){
         %>
         <tr><td width="15%">StudentID</td>
         <%
         if(!th1.equals("NA")){
         %>
         <td width="15%">External(<%=th%>)</td>
         <%}
         if(!pr1.equals("NA")){
         %>
         <td width="15%">External<br>Practical(<%=pr%>)</td></tr>
        <% }      
         for(int i=startIndex-1;i<increment-1;i++){   
              if(i>=ar2.size()){
                 break;
              } 
         %>    
        <tr><td><%=ar2.get(i)%><input type="hidden" name="ro<%=i%>" value="<%=ar2.get(i)%>"></td>
        <%
         if(!th1.equals("NA")){
         %>
        <td><input type="text" name="ex<%=i%>" size="8"></td>
        <%}
         if(!pr1.equals("NA")){
         %>
        <td><input type="text" name="ep<%=i%>" size="8"></td></tr>
        <% }
          }}
         if(et.equals("COMPARTMENT")){
         %>
         <tr><td width="15%">StudentID</td>
         <%
         if(!th1.equals("NA")){
         %>
         <td width="15%">Compartment(<%=th%>)</td></tr>
        <% }      
         for(int i=startIndex-1;i<increment-1;i++){   
              if(i>=ar2.size()){
                 break;
              } 
         %>  
        <tr><td><%=ar2.get(i)%><input type="hidden" name="ro<%=i%>" value="<%=ar2.get(i)%>"></td>
        <%
         if(!th1.equals("NA")){
         %>
        <td><input type="text" name="cm<%=i%>" size="8"></td></tr>
        <%}
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
<a href="<%=request.getContextPath()%>/MarksByProf.jsp?deg=<%=dg%>&cid=<%=cd%>&pr=<%=startIndex-10%>&yrs=<%=yr%>&sem=<%=sm%>&emxtyp=<%=et%>"><font size='1' color='black'>Previous</font></a>
<%
}
increment += 10;

if(startIndex + 10 <=in){    
%> 
<a href="<%=request.getContextPath()%>/MarksByProf.jsp?deg=<%=dg%>&cid=<%=cd%>&pr=<%=startIndex+10%>&yrs=<%=yr%>&sem=<%=sm%>&emxtyp=<%=et%>"><font size='1' color='black'>Next</font></a>
<%
}
}
catch(Exception exc){
    if(startIndex != 1) {
%>
</td></tr></table>
<table><tr><td><font size='1' color='black'>Displaying Records:</font><font size='1' color='black'>
<%= " " + startIndex %> - <%=in%>
</font><a href="<%=request.getContextPath()%>/MarksByProf.jsp?deg=<%=dg%>&cid=<%=cd%>&pr=<%=startIndex-10%>&yrs=<%=yr%>&sem=<%=sm%>&emxtyp=<%=et%>"><font size='1' color='black'>Previous</font></a></td></tr></table>
<%
   }
}       
%>    
     </form>
     </td></tr></table>
        <%
    if((String)request.getAttribute("result")!=null)
out.println("<center><font color='red'><b>"+(String)request.getAttribute("result")+"</b></font></center>");
%>
    </td>
    <td width="20%" valign="top">
           <table align="center" border="1">               
           <tr><td valign="top"><b>Marks entered for Stud.ID</b></td></tr>
                <% 
                   for(int m=0;m<ar5.size();m++){
                %>                  
                <tr><td align="right" valign="top"><%=ar5.get(m)%></td></tr>
                <%}%>
       </table>
    </td></tr></table>    
   </td></tr></table>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
</body>
</html>