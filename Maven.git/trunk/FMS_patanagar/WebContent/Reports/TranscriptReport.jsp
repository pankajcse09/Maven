<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet"%>
<%@page import="com.myapp.struts.Dataconnectivity,java.util.*,java.text.*"%>
<%@page import="schedule.CourseArray,schedule.Round,schedule.MyMethods"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">   
     <%!
      Connection con=null;
      PreparedStatement psmt1=null;      
      ResultSet rs1=null;     
   %>
   <%      
            String login="";
            if(session.getAttribute("logintype")!=null){
            login=(String)session.getAttribute("logintype"); 
            }
           Round rr=new Round();
           HashMap clist=new HashMap();
           HashMap tcn=new HashMap();
           HashMap tch=new HashMap();
           CourseArray cry=new CourseArray(); 
           SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
           SimpleDateFormat sdf=new SimpleDateFormat("dd,MMMM,yyyy");            
           MyMethods mm=new MyMethods();          
           ArrayList ar=new ArrayList();
           ArrayList ar1=new ArrayList();
           //HashSet tar=new HashSet();
           ArrayList tar=new ArrayList();
           HashSet tar1=new HashSet();
           HashMap cpt=new HashMap();
           HashMap tit=new HashMap();  
           HashMap tit1=new HashMap();  
           HashMap tocrd=new HashMap();
           HashMap tocrd1=new HashMap();
           HashMap mid=new HashMap();
           HashMap end=new HashMap();     
           HashMap inprac=new HashMap();
           HashMap ext=new HashMap();     
           HashMap exprac=new HashMap();
           ArrayList cst=new ArrayList();
           ArrayList cst2=new ArrayList();
           String gnno="";
           String fn="";   
           String mn="";
           String ln="";
           String ha1="";
           String ha2="";
           String ct="";
           String stat="";
           String cn="";
           String linst="";
           String dg=""; 
           String bh=""; 
           String yr=""; 
           String sm=""; 
           String ssn=""; 
           String gen=""; 
           String fnm="";
           String mnm="";
           String adv="";
           String sdeg="";
           String en_id="";
           String adin="";
           int crd=0;
           int crd1=0;
           int cont=0;
           
            if(session.getAttribute("studid")!=null){
            en_id=(String)session.getAttribute("studid"); 
            }
            if(request.getParameter("studid")!=null && !request.getParameter("studid").equals("")){
            en_id=(String)request.getParameter("studid");
            }
            if(!en_id.equals("")){
            gnno=(String)mm.generateno(en_id);
            }
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
          catch (Exception e) {
          out.println("<h4>Database Connection Problem.</h4>");
          out.println("<h5>" + e.getMessage() + "</h5>");
          }            
          if(request.getParameter("studid")!=null && !request.getParameter("studid").equals("")){      
          try{ 
              try{
           String qr2="select initcap(sfname),initcap(smname),initcap(slname),initcap(shomeadd1),stdhomead2,scty,stustate,stdcoun,sdntdeg,sentyear,stdgender,initcap(fname),initcap(mname),initcap(sadvisior),sdntdeg,initcap(last_attend) from ex_studnt_reg where stid='"+en_id+"'";
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
           Date dt1=sdf1.parse(eyr);
           String df=sdf.format(dt1);           
           int in1=df.indexOf(",");
           int in2=df.length();
           bh=df.substring(in1+1,in2);           
           String gn=(String)rs1.getString(11);
           fnm=(String)rs1.getString(12);
           mnm=(String)rs1.getString(13);
           adv=(String)rs1.getString(14);
           sdeg=(String)rs1.getString(15);
           linst=(String)rs1.getString(16);
           if(gn.equals("F")){
            gen="Km.";   
           }
           else{
            gen="Mr.";
           }
           }            
           }
          catch(SQLException se){
          out.println(se.getMessage());            
          }  
      finally{
          try{
           if(rs1!=null){rs1.close();}          
           if(psmt1!=null){psmt1.close();}           
           if(con!=null){con.close();}
          }
          catch(SQLException se){
              out.println(se.getMessage());
          }
         }        
        }          
      catch(NullPointerException ne){} 
          }    
   %>
<html>
    <head>
<style type="text/css">.table1{border-collapse: collapse}</style>     
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
 <title>Home</title>
<base target="_parent"><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mystyle1.css">
<meta name="Microsoft Border" content="tlb, default">
<link rel="stylesheet"  href="<%=request.getContextPath()%>/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
  <title>Transcript Report</title>
  <script language="javascript">
   function Clickheretoprint()
  { 
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
  disp_setting+="scrollbars=yes,width=650, height=600, left=100, top=25"; 
  var content_vlue = document.getElementById("printit").innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><style type="text/css">.table1{border-collapse:collapse}</style>'); 
   docprint.document.write('</head><body onLoad="self.print()"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); }
  </script>
  </head>        
   <body bgcolor="white">  
  <table width="100%" height="550" valign="top" border=1 align="center"><tr><td valign="top">
  <table width="100%"><tr>
   <%
    if(login.equals("e")){ 
    %> 
  <td width="50%" align="left"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td>
   <%}%>
  <td align="right" width="50%"><a href="<%=request.getContextPath()%>/MainPage.jsp"><font color="blue"><u>back</u></font></a></td></tr></table>
  <table width="100%" valign="top" border=1 align="center"><tr><td valign="top">
   <form method="post" action="<%=request.getContextPath()%>/Reports/TranscriptReport.jsp">
   <table width="100%" valign="top" border=1 align="center"><tr>
   <td valign="top" align="left">
   <%
    if(login.equals("e")){ 
    %> 
   Student ID<input type="text" name="studid" value="<%=en_id%>">
   <%}%>
   <input type="submit" value="submit"></td>
   </tr></table>    
   </form>
   </td></tr></table>  
 <div id="printit">   
<table align="center" width="100%" border="0"><tr><td width="7%" rowspan="2" align="center"><img src="<%=request.getContextPath()%>/image/logomail.jpg" width="58" height="56"></td>
<td align="center" valign="top" width="73%"><font size="1"><b>
GOVIND BALLABH PANT UNIVERSITY OF AGRICULTURE & TECHNOLOGY<br>
PANTNAGAR-263145,UDHAM SINGH NAGAR,UTTRAKHAND(INDIA)</b></font>
<br><font size="1"><b><u>OFFICE OF THE REGISTRAR</u></b></font></td><td align="center" width="20%" valign="top"><font size="1"><b>U.G. TRANSCRIPT</b></font><br><br><font size="1">No.&nbsp;R/DIC/<%=gnno%>/</font></td></tr></table>
 <%
    if(!en_id.equals("")){          
   %>   
<table width="100%" border="1" class="table1"><tr><td width="100%" height="75">
<table width="100%" class="table1" height="75"><tr><td width="100%" align="left">
<table width="100%" height="25" border="0" class="table1">
<tr><td valign="middle" width="25%" align="left"><font size="1">Name:<b><%=fn%>&nbsp;<%=mn%>&nbsp;<%=ln%></b></font></td><td valign="middle" width="12%"><font size="1">ID No:&nbsp;<b><%=en_id%></b></font></td><td valign="middle" width="36%"><font size="1">Father's Name:<b>Sri&nbsp;<%=fnm%></b></font></td><td valign="middle" width="29%"><font size="1">Mother's Name:<b>Smt&nbsp;<%=mnm%></b></font></td></tr></table>
<table width="100%" height="25" border="0"><tr><td align="left" valign="middle" width="41%"><font size="1"><b>Name of College:</b>College of Veterinary & Animal Sciences</font></td><td valign="middle" width="59%"><font size="1"><b>Degree Program:</b>Bachelor of Veterinary Science & Animal Husbandry(B.V.Sc.& A.H.)</font></td></tr></table>
<table width="100%" height="25" border="0"><tr><td width="20%" valign="middle"><font size="1"><b>Admitted In:</b>&nbsp;<%=bh%></font></td><td width="25%" valign="middle"><font size="1"><b>Completed In:</b>&nbsp;<%=cry.completed(en_id,bh)%></font></td><td width="55%" valign="middle"><font size="1"><b>Last Institution Attended:</b>&nbsp;<%=linst%></font></td></tr></table>
</td></tr></table>
</td></tr></table>
<table width="100%" border="1" class="table1" rules="cols">    
<%
   double tcp=0.0;
   int tch1=0;
   double gp=0.0;
   double tgp=0.0;
   double avgp=0.0;
   String inwrd="";
   String ss="";
   String msn="";
  for(int m=1;m<=5;m++){    
  inwrd=cry.toWords(m);    
  ss=(new Integer(m)).toString();   
 msn=cry.maxSession(en_id,ss);
 ar=cry.selectId(ss,msn);
 tar=cry.selectTitle(ss,msn);
 tit=cry.idTitle(ss,msn);  
 tocrd=cry.idCredit(ss,msn);
 crd=cry.totCredit(ss,msn); 
 tch1=tch1+crd;
 
 double tpe=0.0;  
 String sm1=(new Integer(m*2)).toString();
 String sm2=(new Integer(m*2-1)).toString();
 String ctit="";  
 Iterator ir2=tar.iterator();
 while(ir2.hasNext()){
 ctit=ir2.next().toString();  
 cst=cry.course(ctit,sm1,sm2,msn);  
 tpe=tpe+cry.pointsEarned(en_id,cst,sm1,sm2,sdeg,msn,tocrd); 
 gp=rr.roundoff(tpe/crd);
 }
%>
<tr><td width="100%" valign="middle" colspan="5" style="border:1px solid"><font size="1"><b><%=inwrd%>&nbsp;PROFESSIONAL&nbsp;&nbsp;&nbsp;<%=cry.sessions(en_id,ss)%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Credits&nbsp;<u><%=crd%></u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Points&nbsp;<u><%=mm.precesion1(new Double(rr.roundoff(tpe)).toString(),3)%></u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GPA&nbsp;<u><%=gp%></u></font></td></tr>
<tr><td width="5%" align="center" valign="middle" style="border:1px solid"><font size="1"><b>S.No.</b></font></td><td width="20%" align="left" valign="middle" style="border:1px solid">&nbsp;&nbsp;<font size="1"><b>Course No.</b></font></td><td width="45%" align="left" valign="middle" style="border:1px solid">&nbsp;&nbsp;<font size="1"><b>Title of the Paper</b></font></td><td width="15%" align="right" valign="middle" style="border:1px solid"><font size="1"><b>Credit Hours</b></font>&nbsp;&nbsp;</td><td width="15%" align="center" valign="middle" style="border:1px solid"><font size="1"><b>Points Earned</b></font></td></tr>
<%
 cont=0;    
 Iterator ir1=tar.iterator();
 while(ir1.hasNext()){
 ctit=ir1.next().toString();  
 cst=cry.course(ctit,sm1,sm2,msn);  
%>
<tr><td width="5%" align="center" valign="middle"><font size="1"><%=++cont%></font></td><td width="20%" align="left" valign="middle">&nbsp;&nbsp;<font size="1"><%=cry.courseNo(cst,en_id)%></font></td><td width="45%" align="left" valign="middle">&nbsp;&nbsp;<font size="1"><%=ctit%></font></td><td width="15%" align="right" valign="middle"><font size="1"><%=cry.creditHours(cst,sm1,sm2,msn)%></font>&nbsp;&nbsp;</td><td width="15%" align="center" valign="middle"><font size="1"><%=mm.precesion(new Double(cry.pointsEarned(en_id,cst,sm1,sm2,sdeg,msn,tocrd)).toString(),3)%></font></td></tr>
<%}
  tcp=tcp+tpe;
  tgp=tgp+gp;  
  }
avgp=rr.roundoff(tgp/5);
%>
<tr><td width="5%" align="center" valign="middle"><font size="1"><%=++cont%></font></td><td colspan="2" width="65%" valign="middle"><font size="1"><%=cry.internship(en_id)%></font></td><td width="15%" align="center" valign="middle"><font size="1">--</font></td><td width="15%" align="center"><font size="1">--</font></td></tr>
</table>
<table width="100%" border="1" class="table1"><tr><td width="100%">
<table width="100%"><tr><td width="100%">
<table width="100%"><tr><td valign="top" width=40%" align="left"><font size="1"><b>*Passed with COMPARTMENT in the Paper</b></font></td><td width="30%" align="center"><font size="1"><b>Grand Total of Credit Hours:&nbsp;&nbsp;<u><%=tch1%></u></b></font></td><td width="30%" align="right"><font size="1"><b>Grand Total of Credit Points:&nbsp;&nbsp;<u><%=mm.precesion(new Double(rr.roundoff(tcp)).toString(),3)%></u></b></font></td></tr></table>
</td></tr><tr><td width="100%">
<table width="100%"><tr><td valign="top" width="60%" align="left"><font size="1"><b>Over All Grade Point Average(OGPA):&nbsp;&nbsp;<u><%=mm.precesion(new Double(avgp).toString(),3)%></u>&nbsp;/&nbsp;<u>10.000</u></b></font></td><td width="40%" align="right"><font size="1"><b>Percentage of Marks:&nbsp;&nbsp;<u><%=mm.precesion(new Double(rr.roundoff(avgp*10)).toString(),3)%></u></b></font></td></tr></table>
</td></tr></table>
<table width="100%"><tr><td align="left"><font size="2"><b>RESULT:&nbsp;<u>PASSED FIRST DIVISION with DISTINCTION</u></b></font></td><td align="right"><font size="2"><b>CONDUCT:&nbsp;<u>Satisfactory</u></b></font></td></tr></table>
<table width="100%" height="40" border="0"><tr><td valign="bottom" height="30"><font size="1"><b>DATE:</b></font></td><td height="30" valign="bottom"><font size="1"><b>Prepared by</b></font></td><td height="30" valign="bottom"><font size="1"><b>Checked by</b></font></td><td height="30" valign="bottom"><font size="1"><b>Assistant Registrar</b></font></td><td height="30" valign="bottom"><font size="1"><b>Deputy Registrar</b></font></td></tr></table>
</td></tr></table>
<%}%> <%//cry.result(avgp)%><%//cry.conduct(avgp)%>
 </div>
</td></tr></table>
</body>
</html>