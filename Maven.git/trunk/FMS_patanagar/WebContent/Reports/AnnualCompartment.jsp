<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>
<%@page import="schedule.Round,schedule.GetTotal,schedule.Compartment,schedule.MyMethods"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">   
     <%!
      Connection con=null;
      PreparedStatement psmt1=null;
      PreparedStatement psmt2=null;
      PreparedStatement psmt3=null;  
      PreparedStatement psmt4=null;
      PreparedStatement psmt5=null;
      PreparedStatement psmt6=null;
      PreparedStatement psm1=null;
      PreparedStatement psmt7=null;
      PreparedStatement psmt8=null;
      PreparedStatement psmt9=null;
  
      ResultSet rs1=null;
      ResultSet rs2=null;
      ResultSet rs3=null;      
      ResultSet rs4=null;
      ResultSet rs5=null;
      ResultSet rs6=null;
      ResultSet r1=null;
      ResultSet rs7=null;
      ResultSet rs8=null;
      ResultSet rs9=null;
   %>
   <%       
            MyMethods mm=new MyMethods();
            String login="";
            if(session.getAttribute("logintype")!=null){
            login=(String)session.getAttribute("logintype"); 
            }
           GetTotal gt=new GetTotal(); 
           Round rr=new Round();   
           String qr7="";
           String cid="";
           String sm1="";  
           double com=0.0;
           String com1="";
           String stus="";
           ArrayList car=new ArrayList();
           ArrayList tc=new ArrayList();
           ArrayList ar4=new ArrayList();
           ArrayList ar2=new ArrayList();
           ArrayList ar1=new ArrayList();
           ArrayList ar=new ArrayList();
           HashMap cpt=new HashMap();
           HashMap tit=new HashMap();     
           HashMap totcd=new HashMap(); 
           HashMap intrn=new HashMap();
           HashMap ext=new HashMap();     
           HashMap inprc=new HashMap();
           HashMap exprc=new HashMap();
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
           int yr2=0;
           int yr1=0; 
           int yrs=0;
           HashSet yrr=new HashSet();
           
            if(session.getAttribute("studid")!=null){
            en_id=(String)session.getAttribute("studid"); 
            }
           
           if(request.getParameter("studid")!=null && !request.getParameter("studid").equals("")){
           en_id=(String)request.getParameter("studid");
           
            }             
           if(request.getParameter("year")!=null && !request.getParameter("year").equals("")){
            yr=(String)request.getParameter("year");
             try{
            yrs=Integer.parseInt(yr);
             }
            catch(NumberFormatException ne){}
            }
           if(request.getParameter("session")!=null && !request.getParameter("session").equals("")){
            ssn=(String)request.getParameter("session");
            }
         try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
          catch (Exception e) {
          out.println("<h4>Database Connection Problem.</h4>");
          out.println("<h5>" + e.getMessage() + "</h5>");
          }  
          Compartment comp=new Compartment();           
          try{ 
              try{
           String qr2="select initcap(sfname),initcap(smname),initcap(slname),shomeadd1,stdhomead2,scty,stustate,stdcoun,sdntdeg,sentyear,stdgender,fname,mname,sadvisior from ex_studnt_reg where stid='"+en_id+"'";
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
           String qr1="select sessions from studinfo where studid='"+en_id+"' and currentyr='"+yr+"'";
           psmt2=con.prepareStatement(qr1);
           rs2=psmt2.executeQuery();
           while(rs2.next()){
           sm=(String)rs2.getString("sessions");  
           yrr.add(sm);  
           }  
           if(!yr.equals("") && yr!=null){
           yr2=Integer.parseInt(yr)*2;
           yr1=yr2-1; 
           }          
           if(yr.equals("1")){
           String qr41="select distinct(title) from ex_course_detail where (semester='"+yr1+"' or semester='"+yr2+"') and sessions='"+ssn+"' and title<>'Work Programme'";
           psmt4=con.prepareStatement(qr41);
           rs4=psmt4.executeQuery();
           while(rs4.next()){            
           ar2.add(rs4.getString("title"));                   
           }           
           String qr42="select distinct(title) from ex_course_detail where (semester='"+yr1+"' or semester='"+yr2+"') and sessions='"+ssn+"' and title='Work Programme'";
           psmt9=con.prepareStatement(qr42);
           rs9=psmt9.executeQuery();
           while(rs9.next()){            
           ar2.add(rs9.getString("title"));                   
           }}        
           if(yr.equals("5")){
           String qr41="select distinct(title) from ex_course_detail where (semester='"+yr1+"' or semester='"+yr2+"') and sessions='"+ssn+"' and title<>'National Service Scheme'";
           psmt4=con.prepareStatement(qr41);
           rs4=psmt4.executeQuery();
           while(rs4.next()){            
           ar2.add(rs4.getString("title"));                   
           }           
           String qr42="select distinct(title) from ex_course_detail where (semester='"+yr1+"' or semester='"+yr2+"') and sessions='"+ssn+"' and title='National Service Scheme'";
           psmt9=con.prepareStatement(qr42);
           rs9=psmt9.executeQuery();
           while(rs9.next()){            
           ar2.add(rs9.getString("title"));                   
           }}
           if(yr.equals("2") || yr.equals("3") || yr.equals("4")){
           String qr4="select distinct(title) from ex_course_detail where (semester='"+yr1+"' or semester='"+yr2+"') and sessions='"+ssn+"'";
           psmt4=con.prepareStatement(qr4);
           rs4=psmt4.executeQuery();
           while(rs4.next()){            
           ar2.add(rs4.getString("title"));                   
           }
           }
           }
           catch(SQLException se){
           out.println(se.getMessage());  }          
           finally{
           try{           
           if(rs1!=null){rs1.close();}
           if(rs2!=null){rs2.close();}
           if(rs3!=null){rs3.close();}
           if(rs4!=null){rs4.close();}         
           if(rs9!=null){rs8.close();}  
           if(psmt1!=null){psmt1.close();}      
           if(psmt2!=null){psmt2.close();}
           if(psmt3!=null){psmt3.close();}
           if(psmt4!=null){psmt4.close();}  
           if(psmt9!=null){psmt8.close();} 
           }
          catch(SQLException se){
          out.println(se.getMessage());
           }
          }
         }
        catch(Exception ne){} 
   %>
<html>
    <head>
<style type="text/css">
.t{border-collapse:collapse}   
</style>
<base target="_parent"><link rel="stylesheet" type="text/css" href="/Exam/mystyle1.css">
<meta name="Microsoft Border" content="tlb, default">
<link rel="stylesheet"  href="<%=request.getContextPath()%>/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>  
  <script language="javascript">            
         function submitform(){
         document.f1.method="POST";
         document.f1.action="<%=request.getContextPath()%>/Reports/AnnualCompartment.jsp"; 
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
   docprint.document.write('<html><head><style type="text/css">.t{border-collapse: collapse}</style>'); 
   docprint.document.write('</head><body onLoad="self.print()"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
}
</script>
</head>        
   <body bgcolor="white" onload="semester()"> 
   <table width="90%" align="center" border="0"><tr>
   <%
    if(login.equals("e")){ 
    %> 
  <td width="50%" align="left"><a href="javascript:Clickheretoprint()"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td>
   <%}%>
  <td align="right"><a href="<%=request.getContextPath()%>/MainPage.jsp"><font color="#455A8B"><u>Back</u></font></a></td></tr></table>
  <table width="90%" height="500" valign="top" border="1" align="center" class="t"><tr><td valign="top">  
   <table width="100%" valign="top" border="0" align="center"><tr><td valign="top">
   <form name="f1" method="post" action="<%=request.getContextPath()%>/Reports/AnnualCompartment.jsp">
   <table width="100%" valign="top" border="1" align="center" class="t"><tr>
   <%
    if(login.equals("e")){ 
    %> 
   <td valign="top" width="35%" align="left">Student ID<input type="text" name="studid" value="<%=en_id%>"></td>
   <%}%>
   <td valign="top" width="35%" align="left">Year<select name="year" onchange="submitform()">
     <%
       if(yr.equals("") || yr==null || yr.equals("null")){
    %>   
   <option value="">Select</option>    
   <%}  
    if(!yr.equals("") && yr!=null && !yr.equals("null")){
    %>   
   <option value="<%=yr%>"><%=yr%></option>    
   <%}
    try{       
    for(int k=1;k<=5;k++){
    if(!yr.equals("")){   
    if(k==Integer.parseInt(yr)){
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
   <td valign="top" width="35%" align="left">Session<select name="session">
   <%
   String y="";   
   Iterator ir=yrr.iterator();   
   while(ir.hasNext()){
   y=ir.next().toString();    
   %>
   <option value="<%=y%>"><%=y%></option>
   <%}%>
   </select></td>    
   <td align="left"><input type="submit" value="submit"></td>
   </tr></table></form>
   </td></tr></table>
<% 
if(!en_id.equals("") && request.getParameter("year")!=null && request.getParameter("session")!=null){
%>           
<div id="printit">   
<table width="100%" align="center" class="t"><tr><td align="center" valign="top"><font size="1">G.B.PANT UNIVERSITY OF AGRICULTURE & TECHNOLOGY PANTNAGAR, U.S NAGAR(UTTRAKHAND)</font></td></tr></table> 
<center><font size="1"><u>OFFICE OF THE REGISTRAR</u></font></center>
<table width="100%" align="center"><tr><td width="100%" align="center" valign="middle"><img src="<%=request.getContextPath()%>/image/logomail.jpg" width="58" height="56"></td></tr></table>
<center><font size="2"><b>GRADE SHEET FOR <%=mm.inWords(yrs)%> PROFESSIONAL B.V.Sc. & A.H. ANNUAL EXAMINATION <%=ssn%></b></font></center>
<table width="100%" valign="top" border="1" class="t">
<tr><td colspan="3" width="30%"><font size="1">Name:&nbsp;<%=fn%>&nbsp;<%=mn%>&nbsp;<%=ln%></font></td><td colspan="2" width="20%" align="left"><font size="1">ID No:&nbsp;<%=en_id%></font></td><td colspan="3" width="30%" align="left"><font size="1">Programme:&nbsp;B.V.Sc.& A.H.</font></td><td colspan="2" width="20%" align="right"><font size="1">Batch:&nbsp;<%=bh%></font></td></tr>    
<tr><td rowspan="3" width="10%" align="center"><font size="1">Paper&nbsp;Code</font></td><td rowspan="3" width="10%" align="center"><font size="1">Credits&nbsp;Hrs.</font></td><td colspan="4" width="40%" align="center"><font size="1">Marks Obtained</font></td><td rowspan="3" width="10%" align="center"><font size="1">Total(100)</font></td><td rowspan="3" width="10%" valign="middle" align="center"><font size="1">Grade Point<br>(10 Point basis)</font></td><td rowspan="3" width="10%" align="center"><font size="1">Points Secured</font></td><td rowspan="3" width="10%" align="center"><font size="1">Points Earned</font></td></tr>
<tr><td width="20%" colspan="2" align="center">Internal</td><td width="20%" colspan="2" align="center">External</td></tr>
<tr><td width="10%" align="center"><font size="1">Theory<br>(30)</font></td><td width="10%" align="center"><font size="1">Practical<br>(20)</font></td><td width="10%" align="center"><font size="1">Theory<br>(30)</font></td><td width="10%" align="center"><font size="1">Practical<br>(20)</font></td></tr>
</td></tr>
<%
String qr5="";
String qr6="";
String qr8="";
int tct=0;
double mie=0.0;
String mie1="";
double inp=0.0;
String inp1="";
double extn=0.0;
String extn1="";
double extp=0.0;
String extp1="";
double extra=0.0;
String extra1="";
double me=0.0;   
double tt=0.0;
double gd=0.0;
double ps=0.0;
double ps1=0.0;
ArrayList arc=new ArrayList();
String cid1="";
String tc1="";
double dd=0.0;
String ss="";
String cid2="";
try{
for(int i=0;i<ar2.size();i++){ 
 ss=(String)ar2.get(i);   
%>
<tr><td><tr><td colspan="9" width="100%" align="left"><font size="2"><%=ar2.get(i)%>(Credits-<%=comp.credits1(en_id,ss,yr,ssn)%>)</font></td><td align="center"><font size="2"><%=mm.precesion(new Double(rr.roundoff(comp.points1(en_id,ss,yr,ssn))).toString(),3)%></font></td></tr>
<%  
cid="select id,totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and title='"+ar2.get(i)+"' order by TO_NUMBER(substr(id,5,5))";
        psm1=con.prepareStatement(cid); 
        r1=psm1.executeQuery();               
        while(r1.next()){  
        cid1=r1.getString("id"); 
        cid2=comp.starId1(cid1);
        tc1=r1.getString("totalcredit"); 
        tct=tct+Integer.parseInt(tc1);
qr5="select midterm,endterm,intpractical,extra from addmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt5=con.prepareStatement(qr5);
rs5=psmt5.executeQuery();
while(rs5.next()){
if(rs5.getDouble("midterm")!=-1.0 && rs5.getDouble("endterm")!=-1.0){   
mie=rs5.getDouble("midterm")+rs5.getDouble("endterm"); 
mie1=(new Double(mie)).toString();
}
else{
mie=0;    
mie1="--";    
}
if(rs5.getDouble("intpractical")!=-1){
inp=rs5.getDouble("intpractical");
inp1=(new Double(inp)).toString();
}
else{
inp=0;    
inp1="--";  
}
if(rs5.getDouble("extra")!=-1){
extra=rs5.getDouble("extra");
//extraar.put(ar2.get(i),new Double(extra));
extra1=(new Double(extra)).toString();
}
else{
extra=0.0;
extra1="--";
}
if(rs5.getDouble("extra")==-1){
qr6="select external from extmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and semester='"+yr2+"' and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt6=con.prepareStatement(qr6);
rs6=psmt6.executeQuery();
 while(rs6.next()){
 if(rs6.getDouble("external")!=-1.0){   
 extn=rs6.getDouble("external");
 extn1=(new Double(extn)).toString();  
 }
 else{
 extn=0;
 extn1="--";
 } 
 }
 qr8="select extpractical,status from extprmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and semester='"+yr2+"' and degree='B.V.Sc. and A.H. Degree Programme'";           
 psmt8=con.prepareStatement(qr8);
 rs8=psmt8.executeQuery();
 while(rs8.next()){ 
 if(rs8.getDouble("extpractical")!=-1.0){
 extp=rs8.getDouble("extpractical"); 
 extp1=(new Double(extp)).toString();  
 }
 else{
 extp=0;
 extp1="--";
 }
stus=rs8.getString("status"); 
 
  if(rs8.getString("status").equals("P")){
  tt=Math.ceil(mie+inp+extn+extp);   
   gd=((double)tt)/10;
 ps=gd*Double.parseDouble(tc1);
 ps1=ps1+ps; 
%>
<tr><td width="15%" align="center"><font size="2"><%=cid2%></font></td><td width="9%" align="center"><font size="2"><%=r1.getString("totalcredit")%></font></td><td width="9%" align="center"><font size="2"><%=mm.precesion(mie1,2)%></font></td><td width="9%" align="center"><font size="2"><%=mm.precesion(inp1,2)%></font></td><td width="9%" align="center"><font size="2"><%=mm.precesion(extn1,2)%></font></td><td width="9%" align="center"><font size="2"><%=mm.precesion(extp1,2)%></font></td><td width="10%" align="center"><font size="2"><%=mm.precesion(new Double(tt).toString(),2)%></font></td><td width="10%" align="center"><font size="2"><%=mm.precesion(new Double(rr.roundoff(gd)).toString(),3)%></font></td><td width="10%" align="center"><font size="2"><%=mm.precesion(new Double(rr.roundoff(ps)).toString(),3)%></font></td><td width="10%" align="center">&nbsp;</td></tr>
<%
  }
 if(rs8.getString("status").equals("F")){
qr7="select compartment from compmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and semester='"+yr2+"' and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt7=con.prepareStatement(qr7);
rs7=psmt7.executeQuery();  
while(rs7.next()){    
com=rs7.getInt("compartment"); 
com1=(new Double(com)).toString();
}   
   tt=Math.ceil(mie+inp+com+extp);   
   gd=((double)tt)/10;
 ps=gd*Double.parseDouble(tc1);
 ps1=ps1+ps; 
%>
<tr><td width="15%" align="center"><font size="1"><%=cid2%></font></td><td width="9%" align="center"><font size="1"><%=r1.getString("totalcredit")%></font></td><td width="9%" align="center"><font size="1"><%=mm.precesion(mie1,3)%></font></td><td width="9%" align="center"><font size="1"><%=mm.precesion(inp1,2)%></font></td><td width="9%" align="center"><font size="1"><%=mm.precesion(com1,2)%></font></td><td width="9%" align="center"><font size="1"><%=mm.precesion(extp1,2)%></font></td><td width="10%" align="center"><font size="1"><%=mm.precesion(new Double(tt).toString(),2)%></font></td><td width="10%" align="center"><font size="1"><%=mm.precesion(new Double(rr.roundoff(gd)).toString(),3)%></font></td><td width="10%" align="center"><font size="1"><%=mm.precesion(new Double(rr.roundoff(ps)).toString(),3)%></font></td><td width="10%" align="center">&nbsp;</td></tr>
<%
 }
 }
}
else{
tt=Math.ceil(extra); 
gd=((double)tt)/10;
ps=gd*Double.parseDouble(tc1);
ps1=ps1+ps;%>
<tr><td width="15%" align="left"><font size="2"><%=cid2%></font></td><td width="9%" align="center"><font size="2"><%=r1.getString("totalcredit")%></font></td><td width="9%" align="center" colspan="4">&nbsp;</td><td width="10%" align="center"><font size="2"><%=mm.precesion(new Double(tt).toString(),2)%></font></td><td width="10%" align="center"><font size="2"><%=mm.precesion(new Double(rr.roundoff(gd)).toString(),3)%></font></td><td width="10%" align="center"><font size="2"><%=mm.precesion(new Double(rr.roundoff(ps)).toString(),3)%></font></td><td width="10%" align="center">&nbsp;</td></tr>
<%}
}
}     
}
}
catch(Exception e){
    out.println(e.getMessage());
}
finally{
 try{
  if(r1!=null){r1.close();}
  if(rs5!=null){rs5.close();}
  if(rs6!=null){rs6.close();}
  if(rs7!=null){rs7.close();}
  if(rs8!=null){rs8.close();}
  if(psm1!=null){psm1.close();}      
  if(psmt5!=null){psmt5.close();} 
  if(psmt6!=null){psmt6.close();} 
  if(psmt7!=null){psmt7.close();}
  if(psmt8!=null){psmt8.close();}
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
 out.println(se.getMessage());
 }
}
%>
</table>
<table width="100%"><tr><td width="50%" valign="top"><font size="1">* Theory having Maximum Marks 50</font></td><td width="50%" align="right" valign="top"><font size="1">** Practical Paper having Maximum Marks 50</font></td></tr></table><br>
<table width="100%"><tr><td valign="top"><font size="1">CURRENT: Total Credits:&nbsp;<u><%=tct%></u></font></td><td valign="top"><font size="1">Total Points Earned:&nbsp;<u><%=mm.precesion(new Double(rr.roundoff(ps1)).toString(),3)%></u></font></td><td valign="top"><font size="1">GPA:&nbsp;<u><%=rr.roundoff((ps1/tct))%></u></font></td></tr></table><br>
<table width="100%" height="50"><tr><td valign="top" height="10"><font size="1">RESULT:&nbsp;1.<%=gt.result1(en_id,yr,ssn)%>&nbsp;<u><%=mm.precesion(new Double(rr.roundoff(ps1/tct)).toString(),3)%></u>/10.00</font></td></tr>
<tr><td height="40"></td></tr></table><br>
<table width="100%"><tr><td valign="bottom"><font size="1">Prepared By</font></td><td valign="bottom"><font size="1">Checked By</font></td><td valign="bottom"><font size="1">Assistant Registration(Examination)</font></td><td valign="bottom"><font size="1">Deputy Registrar(Examination)</font></td></tr></table>
</td></tr></table>
<%}%>
</div>
</body>
</html>
