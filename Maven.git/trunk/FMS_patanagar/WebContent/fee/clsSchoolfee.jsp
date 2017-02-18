<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import ="AO.*"%> 
<%@page import ="EO.SchoolEO"%>

<%@page import ="java.util.ArrayList"%>


<%ClsWSchoolFee rp=new ClsWSchoolFee();%>
<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
   <script language="javascript">
       
 function chkvalidate()
{
if(document.update.syear.value=="")
{
alert("Please Enter Staring Year of Session");
document.update.syear.focus();
return false;
}
if(document.update.eyear.value=="")
{
alert("Please Enter Ending Year of Session");
document.update.eyear.focus();
return false;
}
}
   </script>
    
    </head>
    <body>
    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Day Report</u></font></center></td></tr></table>
   
<form  method="post" action="<%=request.getContextPath()%>/clwsfreprt.do" onsubmit="return chkvalidate()">
<table>
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color=red size="2">Please enter the following details</font></td></tr>
<tr><td><b>Class:</b><select name="classes">
    <option value="">-Select-</option>      
 <%
    
    Connection cnn=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    String cls="";
    String route="";
try{
                        
             DataConnection dc1=new DataConnection();
             cnn=(Connection)dc1.Dataconnect();
             String sq="select class from classes";
             stmt2=cnn.createStatement();
             rs2=stmt2.executeQuery(sq);
             while(rs2.next())
             {
             cls=(String)rs2.getString("class"); 
%>
<option value="<%=cls%>"><%=cls%></option>
<%}}catch(SQLException e){}
stmt2=null;
rs2=null;
%>
</select>

<b>Section:</b><select name="section">
                        <option value="">-Select-</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="F">F</option>
                        <option value="G">G</option>
                        <option value="H">H</option>
                        <option value="I">I</option>
                        <option value="J">J</option>
                        <option value="K">K</option></td>
                       
</tr>
  <tr>  <td><b>Session:</b><select name="syear">
 
           <option value="">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select>
     <select name="eyear"> -
 
           <option value="">select</option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select></td>
</tr>
</td><td><input type="submit" value="Display"></td></tr> 
</table>
<hr>
</form>
<form name="update" action="<%=request.getContextPath()%>/editacdet.do?enter=enter" method="post" onsubmit="return chkvalidate()">

 <table align="center" cellpadding="0" cellspacing="15" >
            <thead width=100%>
        
                <tr>
         <th align="left"><B>NO.</B></th><th align="center"><B>SR.NO.</B></th>
         <th align="center"><B>NAME</B></th><th align="center"><B>JULY</B></th>
         <th align="center"><B>AUGUST</B></th><th align="center"><B>SEPTEMBER</B></th>
         <th align="center"><B>OCTOBER</B></th><th align="center"><B>NOVEMBER</B></th>
         <th align="center"><B>DECEMBER</B></th>
         <th align="center"><B>JANUARY</B></th><th align="center"><B>FEBRUARY</B></th>
         <th align="center"><B>MARCH</B></th><th align="center"><B>REMARK</B></th>
              </tr>
     <TR><TH></TH><TH></TH><TH></TH><TH>Date|Amt.</TH><TH>Date|Amt.</TH><TH>Date|Amt.</TH>
      <TH>Date|Amt.</TH><TH>Date|Amt.</TH><TH>Date|Amt.</TH><TH>Date|Amt.</TH><TH>Date|Amt.</TH>
      <TH>Date|Amt.</TH>
            </thead>
           <tbody>   
   
<%String syear=request.getParameter("syear");
      String eyear=request.getParameter("eyear");
      String classes=request.getParameter("classes");
      String section=request.getParameter("section");
      ArrayList studnt=new ArrayList();
      ArrayList mn=new ArrayList();
      ArrayList mnname=new ArrayList();


    Connection cn=null;
    Statement stmt3=null;
    ResultSet rs3=null;
    Statement stmt=null;
    ResultSet rs=null;
    EO.SchoolEO aa1=null;
    int fn1=0;
    int am1=0;
    int k=0;
     EO.SchoolEO gt=null;
      EO.SchoolEO gt1=null;
try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     try
        {
         String qry="select srnum,sname from studacaddetail where classes='"+classes+"' and section='"+section+"' and syear='"+syear+"' and eyear='"+eyear+"'"; 
       
         stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
         
          while(rs3.next())
          {
                gt=new EO.SchoolEO();
               
               gt.setSrnum(rs3.getString("srnum"));
               gt.setSname(rs3.getString("sname"));
               
               String srnum=gt.getSrnum();
               String sname=gt.getSname();
            
               studnt.add(gt);
           
          }
        
      String qry1="select mntnum,mnt from allmonth";
    
          stmt=cn.createStatement();
          rs=stmt.executeQuery(qry1);  
          while(rs.next())
          {
              
          String mntnum=rs.getString("mntnum");
          String mnt=rs.getString("mnt");
          mn.add(mntnum);
          mnname.add(mnt);
          
          
          }   
    /*      stmt=null;
          rs=null;
           String qryt="select mnt from allmonth";
    
          stmt=cn.createStatement();
          rs=stmt.executeQuery(qryt);  
          while(rs.next())
          {
          gt1=new EO.SchoolEO();
            gt1.setMonth(rs.getString("mnt"));
          
          }   
       */ 
          
          for(int l=0;l<studnt.size();l++)
          {
              gt=(EO.SchoolEO)studnt.get(l);
              String srn=gt.getSrnum();
           //  out.println("srn"+srn);
          for(int kk=0;kk<mn.size();kk++)
          {
          String mon=mn.get(kk).toString();
          //   out.println("mon"+mon);
       //   aa1=rp.feeResult(mon,srn,classes,section,syear,eyear);
       //   out.println("aa1"+aa1);
          }
          
          }
          
//aa1=rp.feeResult(mn,srnum,classes,section,syear,eyear);
// fn1=rp.returnFine(mntnum,srnum,classes,section,syear,eyear); 


//int total1=fn1+aa1.getAdmission()+aa1.getWelfare()+aa1.getExam()+aa1.getTution()+aa1.getComputer()+aa1.getScience()+aa1.getGames()+aa1.getLib()+aa1.getOther()+aa1.getRedm()+am1; 
//int total2=fn2+aa2.getAdmission()+aa2.getWelfare()+aa2.getExam()+aa2.getTution()+aa2.getComputer()+aa2.getScience()+aa2.getGames()+aa2.getLib()+aa2.getOther()+aa2.getRedm()+am2; 

%>
    
             <tr>
               <td align="left"></td>
               <td align="left"></td><td align="left"></td>
           </tr>
     
 <%}catch(SQLException e)
       {}%>
            </tbody>
        </table>
        
        
        
        
        <table border="1">
          
        <tr><td></td><td></td><td></td> <% 
           
       
       for (int ii=0;ii<mn.size();ii++){
        %>
<td colspan=2 align=center><%=mnname.get(ii)%></td>
      <%     } %>

        </tr>   
        
        <tr><td>No.</td><td>Srno</td><td>Name</td><% 
           
       
       for (int ii=0;ii<mn.size();ii++){
        %>
<td>Date</td><td>Amount</td>
      <%     } %>

        </tr>   
        
      <% 
            for (int i=0;i<studnt.size();i++){
gt=(EO.SchoolEO)studnt.get(i);

%>
  
        <tr><td><%=++k%></td><td><%=gt.getSrnum()%></td><td><%=gt.getSname()%></td>
        
 <%  
 String srnm=gt.getSrnum();
 
  String qryt="select mnt from allmonth";
    
          stmt=cn.createStatement();
          rs=stmt.executeQuery(qryt);  
          while(rs.next())
          {
          String mntnm=rs.getString("mnt");
       
 // for (int ii=0;ii<mn.size();ii++){
    
    aa1=rp.feeResult(mntnm,srnm,classes,section,syear,eyear);
 %>
<td><%=aa1.getFeesubdate()%></td><td><%=aa1.getTfee()%></td>
      <%   } %>      
 
        
   
        
        </tr>
  
    <%}%>  
           
            </table>
</form>
    </td></tr></table>
  
    <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>          
    </body>
</html>
