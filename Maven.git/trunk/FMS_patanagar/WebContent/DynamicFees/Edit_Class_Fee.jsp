<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<%@page import="Beans.JavaBean"%>

<!DOCTYPE html>
<%!  
 Connection con=null; 
 PreparedStatement psmt1=null; 
 PreparedStatement psmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
%>
<% 
   
   JavaBean jb=new JavaBean();
     JavaBean jbb=new JavaBean();
     JavaBean deg=new JavaBean();
     ArrayList BranchList=new ArrayList();

  if(request.getAttribute("branchlist")!=null)
   {
   BranchList=(ArrayList)request.getAttribute("branchlist");
    }
      if(request.getAttribute("degreebean")!=null){
    deg=(JavaBean)request.getAttribute("degreebean");
    }
     
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    
    
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    ArrayList ar=new ArrayList();
    ArrayList ar2=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){} 
  try{   
      String qry="select rowid,sessions,classes,heads from feeheads order by heads";
      psmt1=con.prepareStatement(qry);
      rs1=psmt1.executeQuery();   
      while(rs1.next()){      
      ar.add(rs1.getString("heads"));
      }
   String sq2="select class from classes";
   psmt2=con.prepareStatement(sq2);
   rs2=psmt2.executeQuery();
   while(rs2.next()){ 
   ar2.add(rs2.getString("class"));
   } 
   }catch(SQLException se){}
   finally{
       try{
         //if(rs1!=null){rs1.close();}  
         if(rs2!=null){rs2.close();}  
         //if(psmt1!=null){psmt1.close();}
         if(psmt2!=null){psmt2.close();}
         if(con!=null){con.close();}
       }
       catch(SQLException se){}
   }
   
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar3=(ArrayList)seo.getDataArray();
ArrayList ar4=(ArrayList)seo.getDataArray2();
HashMap hm=(HashMap)seo.getDataMap();

JavaBean de=new JavaBean();
   ArrayList degreelist=new ArrayList();
if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
try{
%>
<html>
<head>

<title>JSP Page</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript">
               
               function retBlock(){
  document.forms[0].method="post";
  document.forms[0].action="<%=request.getContextPath()%>/Re.do?method=Re";
  document.forms[0].submit();
  }
  </script>
<script language="JavaScript">    
 
function classType(){
document.f1.method="post";
document.f1.action="<%=request.getContextPath()%>/Course_Type2.do?method=typeAction2";
document.f1.submit();
}

function retriveFee(){
document.f1.method="post";
document.f1.action="<%=request.getContextPath()%>/Course_Type2.do?method=retFeeCourses";
document.f1.submit();
}

function validate(){
if(document.f1.elements["session"].value==""){
alert("Enter Session");
document.f1.elements["session"].focus();
return false;
 }
if(document.f1.elements["classes"].value==""){
alert("Select Class");
document.f1.elements["classes"].focus();
return false;
 }
if(document.f1.elements["type"].value==""){
alert("Select Type");
document.f1.elements["type"].focus();
return false;
 }
return true;
}
</script>        
</head>
<body bgcolor="#999933">
    <style>
             input[type=button] {
                 cursor: pointer;
    
    background-color: #A89263;
    color: #333333;
    padding: 2px 6px 2px 6px;
    border-top: 1px solid #CCCCCC;
    border-right: 1px solid #333333;
    border-bottom: 1px solid #333333;
    border-left: 1px solid #CCCCCC;
   }
   
   input[type=button]:hover {
       background-color: #EEEEEE;
   }
   
   input[type=button]:visited {
       background-color: green;
       padding: 0px 0px 0px 0px;
   }
   
   
         </style>   
         <% String sess="";
             String degr="";
             String bran="";
             String dura="";
             
         if(request.getAttribute("session")!=null){
             sess=(String)request.getAttribute("session");
             }
             if(request.getAttribute("duration")!=null){
             dura=(String)request.getAttribute("duration");
             }
             if(request.getParameter("degree")!=null){
             degr=(String)request.getParameter("degree");
                         }
             if(request.getAttribute("branch")!=null){
             bran=(String)request.getAttribute("branch");
                         }
        %>
         
<table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
           <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                     
                <tr><td>
<table style="padding-left: 350px">
<tr><td  valign="top" colspan="100%" align="center"><font style="font-size:18;font-weight:bold;color:darkblue">View/Edit Fee for Class</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px"> 
<form name="f1" method="post" action="<%=request.getContextPath()%>/Course_Type2.do?method=editClassFee" onsubmit="return validate();">
       
<hr color="darkblue">
<table  align="center" border="0" style="border-collapse:collapse" width="500">
<tr><td class="tdcolor"><font style="font-size:12;font-weight:bold;color:black">Session</font></td>
<td><select name="session">
        <% if(sess.equals("")){%>
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
<%} else{%>
<option value="<%=sess%>"><%=sess%></option>
<%if(!seo.getSession().equals(prev)&&!prev.equals(sess)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)&&!next.equals(sess)){%> 
<option value="<%=next%>"><%=next%></option>

<%}}%>
</select></td> </tr>   

<tr>   <td><font style="font-size:12;color:black"><b>Select Degree</b></font></td><td>
<select name="degree">
    <%if(deg.getDegree().equals("")){%>  
    <option value="select one">select one</option>
    <%}%>
    <%if(!deg.getDegree().equals("")){%>    
<option value="<%=deg.getDegree()%>"><%=deg.getDegree()%></option> 
<%}%>
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(deg.getDegree())){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
</select>   
</td> </tr>   
 <!--<tr>   <td><font style="font-size:12;color:black"><b>Select Branch</b></font></td>

<td>
<select name="branch">
    <% if(bran.equals("")){%>
    <option value="select one">select one</option>
    <%}else{%>
    <option value="<%=bran%>"><%=bran%></option>
    <%}%>
    <%for(int i=0;i<BranchList.size();i++){
jbb=(JavaBean)BranchList.get(i);
if(!bran.equalsIgnoreCase(jbb.getBranch())){
%>
<option value="<%=jbb.getBranch()%>"><%=jbb.getBranch()%></option>
<%}}%>
    


</select>   
</td> </tr>   -->
<!-- <tr>   <td><font style="font-size:12;color:black"><b>Select Course Semster/Yearly</b></font></td>

<td>
<select name="duration">
    <% if(!dura.equals("")){%>
       <option value="<%=dura%>"><%=dura%></option>     
    <%}%>
   <option value="I Semester">I Semester</option>
<option value="II Semester">II Semester</option>
<option value="III Semester">III Semester</option>
<option value="IV Semester">IV Semester</option>
<option value="V Semester">V Semester</option>
<option value="VI Semester">VI Semester</option>
<option value="VII Semester">VII Semester</option>
<option value="VIII Semester">VIII Semester</option>
<option value="IX Semester">IX Semester</option>
<option value="X Semester">X Semester</option>

<option value="One Year">One Year</option>

<option value="Two Year">Two Year</option>

<option value="Three Year">Three Year</option>

<option value="Four Year">Four Year</option>


<option value="Five Year">Five Year</option>



</select>   
</td> </tr>   -->

<!-- <tr>   <td class="tdcolor"><font style="font-size:12;font-weight:bold;color:black">Type</font></td>
<td>
<select name="type">
<%if(!seo.getType().equals("")){%>    
<option value="<%=seo.getType()%>"><%=seo.getType()%></option>
<%}if(!seo.getType().equals("NON PRAC")){%>   
<option value="NON PRAC">NON PRAC</option>
<%}if(!seo.getType().equals("ONE PRAC")){%>  
<option value="ONE PRAC">ONE PRAC</option>
<%}if(!seo.getType().equals("TWO PRAC")){%> 
<option value="TWO PRAC">TWO PRAC</option>
<%}if(!seo.getType().equals("THREE PRAC")){%> 
<option value="THREE PRAC">THREE PRAC</option>
<%}%> 
</select></td> </tr>  --> 
 <tr>   <td class="tdcolor" width="50%"><font style="font-size:12;font-weight:bold;color:black">Gender</font></td>
<td width="50%"><select name="gender">
<%if(!seo.getGender().equals("")){%>
<option value="<%=seo.getGender()%>"><%=seo.getGender()%></option>   
<%}if(!seo.getGender().equals("COMMON")){%>
<option value="COMMON">COMMON</option>  
 <%}%>
 <!--<%if(!seo.getGender().equals("MALE")){%>
<option value="MALE">MALE</option>  
<%}if(!seo.getGender().equals("FEMALE")){%>
<option value="FEMALE">FEMALE</option>  
<%}%>-->
</select></td>
<td><input type="button" value="Retrive" onclick="retriveFee();" style="background-color: #EEEEEE; padding: 2px 6px 2px 6px;"></td></tr> 
</table>
<hr color="darkblue">
<%if(request.getAttribute("msg")!=null){%>  
<table width="30%" align="center" ><tr><td width="100%" align="center"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>
<%}%>
<%if(ar4.size()!=0){%>
<table width="100%" align="center" border="0" style="border-collapse:collapse">
<%for(int i=0;i<ar4.size();i++){%>
<tr><td width="50%" class="tdcolor" align="right"><font style="font-size:12;font-weight:bold"><%=ar4.get(i).toString().toUpperCase()%></font>
        <input type="hidden" name="hd_<%=i%>" value="<%=ar4.get(i)%>"></td>
<td width="50%" ><input type="text" name="fe_<%=i%>" value="<%=hm.get(ar4.get(i))%>" onkeypress="return checkNumeric();"></td></tr>
<%}if(urb.getUr_update().equals(s)){%>
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
<%}%>
</table>  
<%}%>
</form>
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>
