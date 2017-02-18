<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>School Management System</title>
          <script type="text/javascript" src="calendarDateInput.js"></script>  
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
          <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
          <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>          
 <script language="javascript">
               
               function chkvalidate()
{
if(document.formfee.damount.value==""){
          alert("Please Enter the Amount ");
          document.formfee.damount.focus();
          return false;
          }
          else{         
          var k=validformint(1,20);
          if(k==false){return false;}
          }
                    
          if(document.formfee.paid.value==""){
          alert("Please Enter the amount paying ");
          document.formfee.paid.focus();
          return false;
          }
          else{          
          var k=validformint(1,32);
          if(k==false){return false;}
          }
          
}
 
               function calfee()
               {
               var cfine=document.formfee.curfine.value;
               var pfine=document.formfee.pfine.value;
               var pendamount=document.formfee.pamount.value;
               var fees=document.formfee.fee.value;
               var eamount=document.formfee.eamount.value;
      var tfee=document.formfee.tfee.value;
               var addmore=0;
               if(document.formfee.addmore.value!="")
               {
addmore=document.formfee.addmore.value;
}else{
addmore=0;
}
var afee=document.formfee.fee.value;
               var act=document.formfee.act.value;
               if(document.formfee.act.value=='add')
               {
               var atfee=(parseInt(tfee)+parseInt(addmore));
               document.formfee.tfee.value=parseInt(atfee);
                var afee=0;
               if((parseInt(addmore)+parseInt(fees))!="")
               {
                afee=(parseInt(addmore)+parseInt(fees));
                }else{
                afee=0;
                }
               document.formfee.fee.value=parseInt(afee);
               document.formfee.addmore.value=0;
               }    
    
     else if(document.formfee.act.value=='sub')
               {
               var atfee=(parseInt(tfee)-parseInt(addmore));
               document.formfee.tfee.value=parseInt(atfee);
                var afee=0;
               if((parseInt(fees)-parseInt(addmore))!="")
               {
                afee=(parseInt(fees)-parseInt(addmore));
                }else{
                afee=0;
                }
               document.formfee.fee.value=parseInt(afee);
               document.formfee.addmore.value=0;
               }    
               
               
               var conc=0;
               if(document.formfee.conc.value!="")
               {
conc=document.formfee.conc.value;
}else{
conc=0;
}
               var cfee=0;
               if(document.formfee.compfee.value!="")
               {
cfee=document.formfee.compfee.value;
}else{
cfee=0;
}
              
               var paying=0;
               if(document.formfee.paid.value!="")
               {
paying=document.formfee.paid.value;
}else{
paying=0;
}
               var feam=document.formfee.finalEamount.value;
               var fdam=document.formfee.finalDamount.value;
             
               var totalfee=((parseInt(cfee)+parseInt(cfine)+parseInt(pfine)+parseInt(pendamount)+parseInt(afee))-(parseInt(eamount)+parseInt(conc)));
               document.formfee.finalfee.value=parseInt(totalfee);
               
               
               if(parseInt(paying)>parseInt(totalfee))
               {
               var efee=parseInt(paying)-parseInt(totalfee);
               
               var dfee=0;
              
               document.formfee.finalEamount.value=parseInt(efee);
               document.formfee.finalDamount.value=parseInt(dfee);
               
               }
               else
               {
               var dfee=parseInt(totalfee)-parseInt(paying);
               var efee=0;             
               
               document.formfee.finalDamount.value=parseInt(dfee);
               document.formfee.finalEamount.value=parseInt(efee);
              
               }
               }
               
           </script>   
    </head>
    <body onload="calfee()">
    <% 
	//String sessionid = session.getId();
	String  uid=(String)session.getAttribute("username");
        String  ut=(String)session.getAttribute("usertype");
	
	if(uid == null)
	{
		response.sendRedirect("logout.jsp");
		return;
	}

     session.putValue("uid",uid);
%>
 <table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">
<tr><td><% if(ut.equals("Admin")){%>
<%@include file="topmain.jsp"%>

<%} else if(ut.equals("Super")){%>
<%@include file="Supertopmain.jsp"%>
<%}%>
</td></tr>
  
<table width=100% cellpadding="0" cellspacing="0"><tr><td valign=top>
<% if(ut.equals("Admin")){%>
<%@include file="schooldropmenu.jsp"%>

<%} else if(ut.equals("Super")){%>
<%@include file="Superschooldrop.jsp"%>
<%}%>
</td></tr></table>
   </td></tr>
 <tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Submit Fee</u></font></center></td></tr></table>
<form  method="post" action="dispfee.do?dis=disp&stat=single">
<table width="100%">
 <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
     <%       
     if((String)request.getAttribute("notpaid")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("notpaid")+"</b></font>"); %>
    

<tr><td><font color="red" size="2">Please enter the Registration Number</font></td></tr>
<tr>
 
          <%
      
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    String cdate="";
    
try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         
           String sql="select DATE_FORMAT(current_date,'%d/%m/%Y')as date";
             
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sql);
    
                 
        while(rs.next())
        {
            cdate=(String)rs.getString("date"); 
        }  
} catch(Exception e){}%>  
  <input type="hidden" name="cdate" value="<%=cdate%>">
<td>Registration Number:<input type="text" size="20" name="regisnumber" value="">
<table>
    <tr><td height="5"></td></tr>
 <tr>
<td align="left">Fee to be submitted FromDate :</td>
<td align="left"><script>DateInput('fromdate', true, 'dd/mm/yyyy')</script></td>
<td width="10"></td>
<td align="left">ToDate :</td>
<td align="left"> <script>DateInput('todate', true, 'dd/mm/yyyy')</script> </td>

  </tr> 
  <tr><td height="5"></td></tr>
<tr><td>
<input type="submit" value="Display">
</td></tr>
  
</table>

</tr>  
</table>
</form>   
  
   <form action="feesub.do" method="post" name="formfee" onsubmit="return chkvalidate()">
       
       <%  String fromdate= (String)request.getParameter("fromdate"); 
           String todate= (String)request.getParameter("todate");   
           String regnum= (String)request.getParameter("regisnumber");   
           String curdate= (String)request.getParameter("cdate");    
           String month= (String)request.getAttribute("month");     
           String fee= (String)request.getAttribute("fee");     
           String lfsubdate= (String)request.getAttribute("fsubdate");  
        
      Integer totalfee=(Integer)request.getAttribute("Totalfee"); 
      Integer eamount=(Integer)request.getAttribute("eamount"); 
      Integer pamount=(Integer)request.getAttribute("pamount"); 
      Integer lstdate=(Integer)request.getAttribute("lstdate");
      Integer pday=(Integer)request.getAttribute("pday");
      Integer finestatus=(Integer)request.getAttribute("finestatus");
      Integer lastrecfine=(Integer)request.getAttribute("lastrecfine");
      Integer due=(Integer)request.getAttribute("due");
      Integer total=(Integer)request.getAttribute("total");
      Integer bouncepaying=(Integer)request.getAttribute("bouncepaying");
      Integer nom=(Integer)request.getAttribute("nom");

    %>
      
      <input type="hidden" name="regnum" value="<%=regnum%>">
      <input type="hidden" name="tdate" value="<%=todate%>">
      <input type="hidden" name="fdate" value="<%=fromdate%>">
      <input type="hidden" name="nom" value="<%=nom%>">
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("array");
 
SchoolEO seo=null;
  %>
  <% if(request.getAttribute("array")!=null)
 {%>           
  
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>

  <table width="70%" cellpadding="0" cellspacing="0" border="1" align="center">
       <tr><td>     
            <table width="100%" cellpadding="1" cellspacing="0"  align="center">
                <tr>
                <tr><td height=4></td></tr>
  
<td>Registration Number:</td><td><%=seo.getRegisnum()%></td><td width="15"></td>
<input type="hidden" name="regisnum" value="<%=seo.getRegisnum()%>">
<tr><td>Date:</td><td><%=curdate%></td></tr>
<input type="hidden" name="cdate" value="<%=curdate%>">
<input type="hidden" name="Syear" value="<%=seo.getSyear()%>">
<input type="hidden" name="Eyear" value="<%=seo.getEyear()%>">
            </table>   </td></tr>
             <tr><td>
         <table height=15 width="100%"><tr><td></td></tr></table></td></tr>
   <tr><td>         
  <table align="left" width="90%" cellpadding="1" cellspacing="0">
    
 <tr><td height="10"></td></tr> 
<tr><td>Student Name:</td><td><input type="text" name="sname" value="<%=seo.getSname()%>"></td></tr>
<tr><td>Class:</td><td><input type="text" name="classes" value="<%=seo.getClasses()%>"></td>
<td>Section:</td><td><input type="text" size="6" name="section" value="<%=seo.getSection()%>"></td></tr>
<tr><td>Status:</td><td><input type="text" name="status" value="<%=seo.getStatus()%>"></td></tr>
<tr><td>Sibling studying in this school</td><td><input type="text" name="sib" value="<%=seo.getSib()%>"></td></tr>
<tr><td>Amount to be paid :</td><td><input type="text" name="tfee" value="<%=totalfee%>" onblur="calfee()"></td>
<td><select name="act"  onchange="calfee()">
    <option value="">select action</option>
<option value="add">+</option>
                   <option value="sub">-</option>
</select></td><td>
<input type="text" size="6" name="addmore" value="0" onblur="calfee()">
</td></tr>
<%if(pday.intValue()>lstdate.intValue())     
         {
%>
     <tr><td>fine:</td><td><input type="text" name="curfine" value="<%=finestatus%>" onblur="calfee()"></td></tr>
   <%      }
         else
         {
   %>
 <tr><td>fine:</td><td><input type="text" name="curfine" value="0" onblur="calfee()"></td></tr>
        <%
         }  %>

<tr><td>Concession:</td><td><input type="text" name="conc" value="0" onblur="calfee()"></td></tr>         
<tr><td>Computer Fee(for 11th and 12th):</td><td><input type="text" name="compfee" value="0" onblur="calfee()"></td></tr>
<tr><td>Bank Draft Number:</td><td><input type="text" name="dnum" value=""></td></tr>
<tr><td>Cash/Draft Amount:</td><td><input type="text" name="damount" value=""></td></tr>
<tr><td>Dated:</td><td><script>DateInput('ddate', true, 'dd/mm/yyyy')</script></td></tr>
<tr><td>Drawn On ( Name of Bank ):</td><td><input type="text" name="bankname" value=""></td></tr>
  </table></td></tr>

  <tr><td>
 <table align="left" width="78%" cellpadding="1" cellspacing="0">
<tr><td height="5"></td></tr>

<tr><td height="5"><b>LAST RECORDS</b></td></tr>
<tr><td height="5"></td></tr>
<tr><td>Last Fee Paid On</td><td><input type="text" name="lfsubdate" value="<%=lfsubdate%>" ></td></tr>
<tr><td>Previous Fine:</td><td><input type="text" name="pfine" value="<%=lastrecfine%>" onblur="calfee()"></td></tr>
<tr><td>Extra Amount:</td><td><input type="text" name="eamount" value="<%=eamount%>" onblur="calfee()"></td></tr>
<tr><td>Pending Amount :</td><td><input type="text" name="pamount" value="<%=pamount%>" onblur="calfee()"></td></tr>

  </td></tr></table>
</td></tr>
<tr><td><table align="left" width="100%">
<tr><td><font color="red" size="2">* Total Fee=(Current fine + Previous Fine + Pending Amount + Fee+ Computer Fee)-(Extra Amount + Concession)</font></td></tr>
</table></td></tr>
<tr><td><table align="left" width="80%" cellpadding="1" cellspacing="0">
    
<tr><td> Fee:</td><td><input type="text" name="fee" value="<%=total%>" onblur="calfee()"></td></tr>
<tr><td>Total Fee:</td><td><input type="text" name="finalfee" value="" onblur="calfee()" ></td></tr>
<tr><td>Amount Paying:</td><td><input type="text" name="paid" value="" onblur="calfee()" ></td></tr>
<tr><td>Extra amount:</td><td><input type="text" name="finalEamount" value="" onblur="calfee()"></td></tr>
<tr><td>Due amount:</td><td><input type="text" name="finalDamount" value="" onblur="calfee()"></td></tr>
   
<tr><td></td><td><input type="submit" value="Submit"></td></tr>

</table></td></tr>
</table>     
       <%
   } }
   }catch(Exception e)
       {}%>
       
   </form> 
</td></tr></table>
    </body>
</html>
