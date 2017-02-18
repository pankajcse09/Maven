<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>
<%@page import ="java.util.HashSet,schedule.GetTotal,schedule.MyMethods"%>
 
     <%!
      Connection con=null;
      PreparedStatement psmt1=null;
      PreparedStatement psmt2=null;
      PreparedStatement psmt3=null;  
      PreparedStatement psmt4=null;
      PreparedStatement psmt5=null;
      ResultSet rs1=null;
      ResultSet rs2=null;
      ResultSet rs3=null;      
      ResultSet rs4=null;
      ResultSet rs5=null;
   %>
   <% 
           ArrayList ar=new ArrayList();
           GetTotal gt=new GetTotal();
           HashMap cpt=new HashMap();
           HashMap tit=new HashMap();     
           HashMap mid=new HashMap();
           HashMap end=new HashMap();     
           HashMap prac=new HashMap();        
           MyMethods mm=new MyMethods();
           String cid2="";
           String fn="";   
           String mn="";
           String ln="";
           String ha1="";
           String ha2="";
           String ct="";
           String stat="";
           String cn="";
           
           String dg=""; 
           String bh=""; 
           String yr=""; 
           String sm=""; 
           String ssn=""; 
           String gen=""; 
           String fnm="";
           String mnm="";
           String adv="";
           String en_id="";  
           
            String login="";
            if(session.getAttribute("logintype")!=null){
            login=(String)session.getAttribute("logintype"); 
            }            
            if(session.getAttribute("studid")!=null){
            en_id=(String)session.getAttribute("studid"); 
            }           
            HashSet yrr=new HashSet();            
            if(request.getParameter("studid")!=null && !request.getParameter("studid").equals("")){
            en_id=(String)request.getParameter("studid");
            }            
            if(request.getParameter("sem")!=null && !request.getParameter("sem").equals("")){
            sm=(String)request.getParameter("sem");
            }
            if(request.getParameter("year")!=null && !request.getParameter("year").equals("")){
            yr=(String)request.getParameter("year");
            }              
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
          catch (Exception e) {
          out.println("<h4>Database Connection Problem.</h4>");
          out.println("<h5>" + e.getMessage() + "</h5>");
          }           
          try{ 
              try{
           String qr2="select initcap(sfname),initcap(smname),initcap(slname),initcap(shomeadd1),stdhomead2,scty,stustate,stdcoun,sdntdeg,sentyear,stdgender,initcap(fname),initcap(mname),initcap(sadvisior) from ex_studnt_reg where stid='"+en_id+"'";
           psmt1=con.prepareStatement(qr2);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
           fn=(String)rs1.getString(1);   
           mn=(String)rs1.getString(2);
           if(mn==null){
           mn="";
           }
           ln=(String)rs1.getString(3);
           ha1=(String)rs1.getString(4);
           ha2=(String)rs1.getString(5);
           if(ha2==null){
           ha2="";
           }
           ct=(String)rs1.getString(6);
           stat=(String)rs1.getString(7);
           cn=(String)rs1.getString(8);
           dg=(String)rs1.getString(9);   
           String eyr=(String)rs1.getString(10);
           int in1=eyr.lastIndexOf("/");
           int in2=eyr.length();
           bh=eyr.substring(in1+1,in2);
           String gn=(String)rs1.getString(11);
           fnm=(String)rs1.getString(12);
           mnm=(String)rs1.getString(13);
           adv=(String)rs1.getString(14);
           if(gn.equals("F")){
            gen="Km.";   
           }
           else{
            gen="Mr.";
           }
           }
           String qr1="select sessions from studinfo where studid='"+en_id+"' and sem='"+sm+"'";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){          
           yrr.add(rs1.getString("sessions"));    
           }                
           String qr4="select id,initcap(ctitle) from ex_course_detail where semester='"+sm+"' and sessions='"+yr+"' order by id";
           psmt4=con.prepareStatement(qr4);
           rs4=psmt4.executeQuery();
           while(rs4.next()){    
           ar.add(rs4.getString(1));     
           tit.put(rs4.getString(1),rs4.getString(2));                      
           }  
            String qr5="select course_id,midterm,endterm,intpractical,attendance,extra from addmarks where semester='"+sm+"' and years='"+yr+"' and studid='"+en_id+"'";
           psmt5=con.prepareStatement(qr5);
           rs5=psmt5.executeQuery();
           while(rs5.next()){   
           mid.put(rs5.getString(1),new Double(rs5.getDouble(2)));
           end.put(rs5.getString(1),new Double(rs5.getDouble(3)));
           prac.put(rs5.getString(1),new Double(rs5.getDouble(4)));
           cpt.put(rs5.getString(1),rs5.getString(5));            
           }           
           }
          catch(SQLException se){
          out.println(se.getMessage());            
          }  
      finally{
          try{
           if(rs1!=null){rs1.close();}
           if(rs2!=null){rs2.close();}
           //if(rs3!=null){rs3.close();}
           if(rs4!=null){rs4.close();}
           if(rs5!=null){rs5.close();}
           if(psmt1!=null){psmt1.close();}      
           if(psmt2!=null){psmt2.close();}
           //if(psmt3!=null){psmt3.close();}
           if(psmt4!=null){psmt4.close();}
           if(psmt5!=null){psmt5.close();}
           if(con!=null){con.close();}
          }
          catch(SQLException se){
          out.println(se.getMessage());
          }
      }
        }
        catch(NullPointerException ne){} 
   %>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
 <title>Home</title>
 <style type="text/css">.table1{border-collapse: collapse}</style>
<base target="_parent"><link rel="stylesheet" type="text/css" href="/Exam/mystyle1.css">
<meta name="Microsoft Border" content="tlb, default">
<link rel="stylesheet"  href="/Exam/menu.css">
<script language="javascript" src="/Exam/menu.js"></script>
<script language="javascript" src="/Exam/resolution.js"></script>
        <title>Add New Course</title>
        <script language="javascript">            
         function submitform(){
         document.f1.method="POST";
         document.f1.action="<%=request.getContextPath()%>/Reports/ProgressReport.jsp"; 
         document.f1.submit();
         }
        </script>
        <script language="javascript">
function Clickheretoprint()
{ 
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
  disp_setting+="scrollbars=yes,width=650, height=600, left=100, top=25"; 
  var content_vlue = document.getElementById("printit").innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><style type="text/css">.table1{border-collapse: collapse}</style>'); 
   docprint.document.write('</head><body onLoad="self.print()"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); }
</script>
        </head>        
   <body bgcolor="white" onload="semester()"> 
    <table width="100%" border="0" align="center"><tr> 
    <%
    if(login.equals("e")){ 
    %>          
    <td width="50%" align="left" valign="top"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td>
    <%}%>
    <td align="right" width="50%" valign="top"><a href="<%=request.getContextPath()%>/MainPage.jsp"><font color="#455A8B"><u>Back</u></font></a></td></tr></table>
   <table width="100%" height="450" border="1" align="center" class="table1"><tr><td width="100%" valign="top" height="450"> 
   <table width="100%" border="0" align="center"><tr><td width="100%" valign="top">
   <form name="f1" method="post" action="<%=request.getContextPath()%>/Reports/ProgressReport.jsp">
   <table width="100%" border="1" align="center"><tr>
    <%
    if(login.equals("e")){ 
    %> 
   <td valign="top" width="35%" align="center">Student ID<input type="text" name="studid" value="<%=en_id%>"></td>
   <%}%>
   <td valign="top" width="35%" align="left">Semester<select name="sem" onchange="submitform()">
      <%
     if(sm.equals("") || sm==null || sm.equals("null")){
    %>   
   <option value="">Select</option>    
   <%}   
    if(!sm.equals("") && sm!=null && !sm.equals("null")){
    %>   
   <option value="<%=sm%>"><%=sm%></option>    
   <%}
    try{       
    for(int k=1;k<=10;k++){
    if(!sm.equals("")){   
    if(k==Integer.parseInt(sm)){
     continue;    
    }}           
   %>
   <option value="<%=k%>"><%=k%></option>
   <%}}
   catch(NumberFormatException nfe){
   out.println(nfe.getMessage());    
   }
   %>
   </select></td>
 <td valign="top" width="35%" align="left">Session
   <select name="year">
   <%
   String gg="";
   Iterator ir=yrr.iterator();
   while(ir.hasNext()){
    gg=ir.next().toString();
   %>   
    <option value="<%=gg%>"><%=gg%></option>
   <%}%>   
   </select></td>      
   <td><input type="submit" value="submit"></td>
   </tr></table>    
   </form>
   </td></tr></table>
 <% 
if(!en_id.equals("") && request.getParameter("sem")!=null && request.getParameter("year")!=null){
%>
<div id="printit">
<table width="100%" valign="top" border=1 align="center" class="table1">
    <tr><td valign="top" width="50%"><b>    
 To,<br>
 &nbsp;&nbsp;&nbsp;<%=fn%>&nbsp;<%=mn%>&nbsp;<%=ln%><br>
 &nbsp;&nbsp;&nbsp;<%=ha1%>,<%=ha2%><%=ct%><br>
 &nbsp;&nbsp;&nbsp;<%=stat%>,<%=cn%>
    </b></td>
    <td valign="top" width="50%"><b>From:&nbsp;Dean<br>College of Veterinary & Animal Sciences</b></td></tr>    
</table>  
<table align="center" width="80%" border="0"><tr><td height="50" valign="top"></td></tr><tr><td align="center" valign="top"><font size="2"><b>COLLEGE OF VETERINARY AND ANIMAL SCIENCES<br>
G.B.PANT UNIVERSITY OF AGRICULTURE & TECHNOLOGY<br>
PANTNAGAR-263145,DISTRICT-UDHAM SINGH NAGAR(UTTARAKHAND)<b></font></td></tr></table>
<center><img src="<%=request.getContextPath()%>/image/logomail.jpg" width="58" height="56"></center>
<table align="center" width="60%" valign="top"><tr><td height="5" valign="top" align="center"></td></tr><tr><td valign="top" align="center"><u><b>PROGRESS REPORT CARD</b></u></td></tr>
<tr><td height="5" valign="top" align="center"></td></tr>
<tr><td valign="top" align="center"><b>B.V.Sc. & A.H. Degree Programme</b></td></tr>
<tr><td height="5" valign="top" align="center"></td></tr>
<tr><td valign="top"align="center"><b>Batch:&nbsp;&nbsp;<u><%=bh%></u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u><%=mm.inRoman((Integer.parseInt(sm)+1)/2)%></u>&nbsp;Year&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u><%=mm.semester(Integer.parseInt(sm))%></u>&nbsp;Semester,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u><%=yr%></u></b></td></tr>
<tr><td height="5"></td></tr>
</table>
<table align="center" width="100%" border="0" class="table1">
<tr><td align="left" valign="top" width="40%"><font size="2">Name:<b><u>&nbsp;<%=fn%>&nbsp;<%=mn%>&nbsp;<%=ln%></u></b></font></td><td align="center" valign="top" width="15%"><font size="2">ID No:&nbsp;<b><u><%=en_id%></u></b></font></td><td align="right" valign="top" width="45%"><font size="2">Father's Name:<b><u>Sri&nbsp;<%=fnm%></u></b></font></td></tr>    
<tr><td colspan="3" height="10" valign="top" align="center"></td></tr>
</table>
<table width="100%" border="1" rules="cols" class="table1"><tr><td valign="middle" rowspan="2" align="center" width="12%" style="border:1px solid"><font size="2"><b>Course&nbsp;No.</b></font></td><td valign="middle" rowspan="2" align="center" width="44%" style="border:1px solid"><font size="2"><b>Title of the Course</b></font></td>
<td colspan="4" align="center" valign="middle" width="10%" style="border:1px solid"><font size="2"><b>Marks Obtained</b></font></td><td rowspan="2" align="center" valign="middle" width="10%" style="border:1px solid"><font size="2"><b>Attendance(%)</b></font></td></tr>
<tr><td align="center" valign="middle" width="12%" style="border:1px solid"><font size="2"><b>Mid Term<br>Exam(15)</b></font></td><td align="center" valign="middle" width="12%" style="border:1px solid"><font size="2"><b>End Term<br>Exam(15)</b></font></td>
<td align="center" valign="middle" width="10%" style="border:1px solid"><font size="2"><b>Practical<br>(20)</b></font></td><td align="center" valign="middle" width="10%" style="border:1px solid"><font size="2"><b>Total<br>(50)</b></font></td></tr>
<%
   String cd="";
   String atn="";
   String ti="";
   String md="";
   String md1="";
   String ed="";
   String ed1="";
   String prc="";
   String prc1="";
   double tot=0.0;
   try{
for(int i=0;i<ar.size();i++){
cd=ar.get(i).toString();
cid2=gt.starId(cd,yr);
atn=cpt.get(cd).toString();
ti=tit.get(cd).toString();
md=mid.get(cd).toString();
md1=md;
if(md.equals("0.0")){
md="Absent";  
md1="0";
}
if(md.equals("-1.0")){
md="--";  
md1="0";
}
if(!md.equals("Absent") && !md.equals("--")){
md=mm.precesion(new Double(md).toString(),2);    
}
ed=end.get(cd).toString();
ed1=ed;
if(ed.equals("0.0")){
ed="Absent";  
ed1="0";
}
if(ed.equals("-1.0")){
ed="--";  
ed1="0";
}
if(!ed.equals("Absent") && !ed.equals("--")){
ed=mm.precesion(new Double(ed).toString(),2);    
}
prc=prac.get(cd).toString();
prc1=prc;
if(prc.equals("0.0")){
prc="Absent";  
prc1="0";
}
if(prc.equals("-1.0")){
prc="--";  
prc1="0";
}
if(!prc.equals("Absent") && !prc.equals("--")){
prc=mm.precesion(new Double(prc).toString(),2);    
}
if(md.equals("--") && ed.equals("--") && prc.equals("--")){
continue;    
}
tot=Double.parseDouble(md1)+Double.parseDouble(ed1)+Double.parseDouble(prc1);
%>
<tr><td align="center" valign="middle" width="18%" height="5"><font size="2"><b><%=cid2%></b></font></td><td align="left" valign="middle" width="42%" height="5"><font size="2"><%=ti%></font></td><td align="center" valign="middle"><font size="2"><%=md%></font></td><td align="center" valign="middle" height="5"><font size="2"><%=ed%></font></td><td align="center" valign="middle" height="5"><font size="2"><%=prc%></font></td><td align="center" valign="middle" height="5"><font size="2"><%=mm.precesion(new Double(tot).toString(),2)%></font></td><td align="center" valign="middle" height="5"><%=mm.precesion(new Double(atn).toString(),2)%></td></tr>
<%
  }
 }
   catch(NullPointerException ne){}
%>
</table>
<table width="100%" align="center"><tr><td width="50%" valign="top"><font size="1">* Theory having Maximum Marks 50</font></td><td width="50%" align="right" valign="top"><font size="1">** Practical Paper having Maximum Marks 50</font></td></tr></table>
<hr>
<table width="100%" align="center" height="50"><td valign="top" width="35%" height="50"><table><tr><td><font size="2"><b>Evaluation:</b></font></td><td align="left"><font size="1">Fail - Below 50%</font></td></tr><tr><td></td><td><font size="1">Pass-50-59.99%</font></td></tr></table></td><td valign="top" width="35%" height="50"><font size="1">II Division - 60.00-67.49%
<br>I Division - 67.50-77.49%<br>I Division with Distinction- 77.50% and above</font></td><td valign="top" align="right" width="30%" height="50"><font size="1"><b>Minimum Attendance: 85%</b></font></td></table>
<hr>
<table align="center" height="50" width="100%"><tr><td width="100%" valign="top" height="50"><b>Advisor's Remark:</b><br><font size="2"><%=adv%></font></td></tr></table>
<hr>
<table align="center" height="50" width="100%"><tr><td valign="top" height="50" width="100%"><b>Dean's Remark:</b></td></tr></table>
<hr>
<table align="center" height="20" width="100%"><tr><td valign="top" height="20" width="50%">Prepared by:</td><td valign="top" height="20" width="50%">Checked by:</td></tr></table>
</div>
<%}%>
</td></tr></table>
</body>
</html>
