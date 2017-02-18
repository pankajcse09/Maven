<%-- 
    Document   : lastdate_entry
    Created on : Apr 23, 2013, 4:42:33 PM
    Author     : kapil
--%>

<%@page import="ActionClass.MyMeth"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<%@page import="Beans.JavaBean"%>

<!DOCTYPE html>
<script language="javascript">
               
               function retBlock(){
  document.forms[0].method="post";
  document.forms[0].action="<%=request.getContextPath()%>/Rc.do?method=Rc";
  document.forms[0].submit();
  }
  </script>
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
     JavaBean be=new JavaBean();
     SchoolEO so=new SchoolEO();
        ArrayList BranchList=new ArrayList();

   ArrayList SubList=new ArrayList();
    if(request.getAttribute("degreebean")!=null){
    deg=(JavaBean)request.getAttribute("degreebean");
    }


   if(request.getAttribute("branchlist")!=null)
   {
   BranchList=(ArrayList)request.getAttribute("branchlist");
    }
   
   if(request.getAttribute("sublist")!=null)
   {
   SubList=(ArrayList)request.getAttribute("sublist");
 //  out.println(SubList);
    }
   if(request.getAttribute("jb")!=null){
    deg=(JavaBean)request.getAttribute("jb");
    }
MyMeth fun=new MyMeth();
     ArrayList    degreelist=(ArrayList)fun.Degree_list();
     JavaBean de=null;
%>
         
<% 
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
      String qry="select rowid,heads from feeheads order by heads";
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
         if(rs1!=null){rs1.close();}  
         if(rs2!=null){rs2.close();}  
         if(psmt1!=null){psmt1.close();}
         if(psmt2!=null){psmt2.close();}
         if(con!=null){con.close();}
       }
       catch(SQLException se){}
       }
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
//ArrayList ar3=(ArrayList)seo.getDataArray();
ArrayList ar4=new ArrayList();
    ar4.add("I");
    ar4.add("II");
try{
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Last Date Of Fee Submission</title>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<script language="JavaScript">     
function classType(a){
document.f1.method="post";
document.f1.action="<%=request.getContextPath()%>/Course_Type.do?method=typeAction2";
document.f1.submit();
}

function validate(){
    if(document.f1.elements["min_fine"].value==""){
alert("Please Enter First Day Fine");
document.f1.elements["min_fine"].focus();
return false;
 }

if(document.f1.elements["pday_fine"].value==""){
alert("Please Enter Per Day Fine");
document.f1.elements["pday_fine"].focus();
return false;
 }
 if(document.f1.elements["max_fine"].value==""){
alert("Please Enter Maximum Fine");
document.f1.elements["max_fine"].focus();
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
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 947px;
    left:300px;
}
         </style>   
         
         <% String sess="";
         if(request.getAttribute("session")!=null){
             sess=(String)request.getAttribute("session");
         }%>
        
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
    <tr><td colspan="2" align="center"><font style="font-size:16;font-weight:bold;color:darkblue">Enter Last Date Of Fee Submission</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/EnterLateFee.do?method=lateFeeDetail" onsubmit="return validate();">
<table  align="center" border="1" style="border-collapse:collapse" width="500" bordercolor="black">
<%if(request.getAttribute("msg")!=null){%>  
<tr><td colspan="2"><font color="yellow"><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
<!--<tr><td width="50%"><font style="font-size:12;font-weight:bold" color="black">Session</font></td>
<td width="50%"><select name="session" style="width: 110px">
        
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select>
<select name="session_sem">
<%if(!seo.getSession_sem().equals("")){%>   
<option value="<%=seo.getSession_sem()%>"><%=seo.getSession_sem()%></option>
<%}%> 
<%for(int i=0;i<ar4.size();i++){
if(ar4.get(i).equals(seo.getSession_sem())){continue;}
%>    
<option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>    
<%}%>
</select>
</td></tr>   

-->
     

<tr><td valign="top"><font style="font-size:12;color:black"><b>Programme</b></font></td>
    <td><select name="degree">
    <option value="">Select</option>
<%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}%>
</select></td></tr>
<tr><td><font style="font-size:12;color:black"><b>First Day Fine</b></font></td>
       <td><input type="text" name="min_fine"></td></tr>
<tr><td><font style="font-size:12;color:black"><b>Per Day Fine</b></font></td>
       <td><input type="text" name="pday_fine"></td></tr>
<tr><td><font style="font-size:12;color:black"><b>Maximum Fine</b></font></td>
       <td><input type="text" name="max_fine"></td></tr>
<tr><td><font style="font-size:12;color:black"><b>Last Date</b></font></td>
       <td><script>DateInput('l_date',true,'dd/mm/yyyy')</script></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
</table>
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
