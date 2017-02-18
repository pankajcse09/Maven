<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>School Management System</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>          
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <script language="javascript">     
function chkvalidate(){
if(document.feest.classes.value==""){
alert("Please Enter Class");
document.feest.classes.focus();
return false;
}
if(document.feest.section.value=="")
{
alert("Please Enter Section");
document.feest.section.focus();
return false;
}
if(document.feest.status.value=="")
{
alert("Please Enter Status");
document.feest.status.focus();
return false;
}
if(document.feest.address.value=="")
{
alert("Please Enter Your Permanent Address");
document.feest.address.focus();
return false;
}
  if(document.feest.mobile.value==""){
          alert("Please Enter Valid Mobile Number");
          document.feest.mobile.focus();
          return false;
          }
          else{
          var k=validint(17);
          if(k==false){return false;}
          }
          if(document.feest.mobile.value.length!=10){
          alert("Mobile Number should be of 10 Digits");
          document.feest.mobile.focus();
          return false;
          }

}
     </script>

 </script>
    </head>
    <body>
    <table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">
<tr><td><%@include file="topmain.jsp"%></td></tr>
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Enter Old Student Record</u></font></center></td></tr></table>
<form  method="post" action="stdrec.do?disprec=disprec">
<table>
<%if((String)request.getAttribute("sub")!=null)
out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color="red" size="2">Please enter the Registration Number</font></td></tr>
<tr><td>Registration Number:<input type="text" size="20" name="regisnumber" value=""></td>
<td><input type="submit" value="Display"></td></tr>   
  
</table>
<table width="100%"><tr><td><hr></td></tr></table>
    </form>
    
 <%       
     if((String)request.getAttribute("existnum")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("existnum")+"</b></font>"); %>
  
  <% if((String)request.getAttribute("msg")!=null)
               out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>");
   %> 
   <form action="osregis.do?insrec=insrec" method="post" name="feest" onsubmit="return chkvalidate()">
<table>
       <%
      
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    String dt="";
    String Styear="";
    int Eyear=0;
   int Syear=0;
try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         
           String sql="select DATE_FORMAT(current_date,'%d-%m-%Y')as date";
             
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sql);
    
                 
        while(rs.next())
        {
            dt=(String)rs.getString("date"); 
        }  
                String sql1="select DATE_FORMAT(current_date,'%Y')as year";
             
             stmt1=cn.createStatement();
             rs1=stmt1.executeQuery(sql1);
    
                 
        while(rs1.next())
        { 
                 Styear=(String)rs1.getString("year"); 
        }
              Syear = Integer.parseInt(Styear);    
            Eyear=Syear+1; 
  } catch(Exception e){}    
   
%> 
 <% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 

SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
   
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>
 <input type="hidden" name="Syear" value="<%=Syear%>"></td>      
  <input type="hidden" name="Eyear" value="<%=Eyear%>"></td>    
<td>Registration Number:</td><td><%=seo.getRegisnum()%></td><td width="15"></td></td>
<input type="hidden" name="regisnum" value="<%=seo.getRegisnum()%>">
<tr><td>Starting Date of Session:</td><td><script>DateInput('sesdate', true, 'dd/mm/yyyy')</script></td></tr>

            </table>               
                
         <table height=15 width="100%"><tr><td><hr></td></tr></table>
   <table align="right" width="100%" cellpadding="1" cellspacing="0">          
  <table align="right" width="100%" cellpadding="1" cellspacing="0">
<tr><td>Student Name:</td><td><%=seo.getSname()%></td></tr>
<input type="hidden" name="sname" value="<%=seo.getSname()%>">
<tr><td>Class:</td><td><input type="text" name="classes" value="<%=seo.getClasses()%>">
Section:<input type="text" name="section" size="5" value="<%=seo.getSection()%>"></td></tr>
<tr><td>Student Status :</td><td><select name="status">
                        <option value="<%=seo.getStatus()%>"><%=seo.getStatus()%></option>
                        <option value=""></option>
                        <option value="UniversityWards">University Wards</option>
                        <option value="SchoolWards">School Wards</option>
                        <option value="OtherWards">Other Wards</option>
                        </select></td></tr></tr>
<tr><td>Gender:</td><td><%=seo.getGender()%></td></tr>
<input type="hidden" name="gender" value="<%=seo.getGender()%>" >
<tr><td>Date of Birth:</td><td><%=seo.getDob()%></td></tr>
<input type="hidden" name="dob" value=<%=seo.getDob()%>>
<tr><td>Father's Name:</td><td><%=seo.getFname()%></td></tr>
<input type="hidden" name="fname" value="<%=seo.getFname()%>">
<tr><td>Mother's Name:</td><td><%=seo.getMname()%></td></tr>
<input type="hidden" name="mname" value="<%=seo.getMname()%>" >
<tr><td>Address:</td><td><textarea rows="5" cols="16" name="address" ><%=seo.getAddress()%></textarea></td></tr>
<tr>
<td>Residence Number:</td><td><input type="text" name="rnum" value="<%=seo.getRnum()%>">
&nbsp;&nbsp;
Mobile Number:&nbsp;&nbsp;+91<input type="text" name="mobile" value="<%=seo.getMobile()%>"></td>
</tr>
<tr><td>Fax Number:</td><td><input type="text" name="fax" value="<%=seo.getFax()%>"></td></tr>

<tr><td height="15"></td></tr>
<tr><td></td><td><input type="submit" value="Register"></td></tr>
  </table>
       </td></tr></table>
       <%
   } }
   }catch(Exception e)
       {}%>   
       
   </form> 
   </td></tr></table>
    </body>
</html>
