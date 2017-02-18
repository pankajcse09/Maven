<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ page import="java.util.*,java.sql.*,schedule.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<%@page import="Beans.JavaBean"%>
<!DOCTYPE html>
 <%response.setHeader("Cache-Control","no-cache");%>
 
<%
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean1")!=null){
seo=(SchoolEO)request.getAttribute("jbean1");   
}
    
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

   
   JavaBean de=new JavaBean();
   ArrayList degreelist=new ArrayList();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
%>
        
  <%      
     ArrayList ar1=new ArrayList();
     ArrayList ar2=new ArrayList();
     ArrayList ar3=new ArrayList();   
     HashMap hm1=new HashMap();
     HashMap hm2=new HashMap();   
     HashMap hm3=new HashMap();
     String ssn="";
     String clas="";
     JavaBeanExam jb=new JavaBeanExam();
     if(request.getAttribute("jbean")!=null){
     jb=(JavaBeanExam)request.getAttribute("jbean");    
     }
     MyMethods mm=new MyMethods();  
     ar1=(ArrayList)mm.allClasses();
  %>
<html>
    <head>
    <script language="javascript" src="<%=request.getContextPath()%>/CheckNumericData.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
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
  document.forms[0].action="<%=request.getContextPath()%>/Rd.do?method=Rd";
  document.forms[0].submit();
  }
  
  function validate(){
if(document.f1.elements["fee_type"].value=="select"){
alert("Select Fee Type");
document.f1.elements["fee_type"].focus();
return false;
 }
 if(document.f1.elements["dues_type"].value=="select"){
alert("Select Dues Type");
document.f1.elements["dues_type"].focus();
return false;
 }
 
if(document.f1.elements["feehead"].value==""){
alert("Enter Fee Heads");
document.f1.elements["feehead"].focus();
return false;
 }
if(document.f1.elements["stud_type"].checked=false){
alert("Is this heads for day scholar.");
document.f1.elements["stud_type"].focus();
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
    height: 447px;
    left:300px;
}
         </style> 
    
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
<table style="padding-left: 380px">
      <tr><td><center><font color="darkblue" size="4"><u><b>Enter Fee Heads</b></u></font></center></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 350px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/SubmitFeeHead.do?method=subFeeHeadAct" onsubmit="return validate();">
<table align="center">
<%if(request.getAttribute("msg")!=null){%>  
<tr><td colspan="2"><font color="red"><%=request.getAttribute("msg")%></font></td></tr>
<%}%>     



     
    
 <!--   <tr><td><font style="font-size:12;color:white"><b>Select Degree</b></font></td><td>
<select name="degree" onBlur="retBlock();">
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
</td></tr>  -->  


<!--<tr><td><font style="font-size:12;color:white"><b>Select Branch</b></font></td><td>
<select name="branch">
    <option value="select one">select one</option>
    <%for(int i=0;i<BranchList.size();i++){
jbb=(JavaBean)BranchList.get(i);
%>
<option value="<%=jbb.getBranch()%>"><%=jbb.getBranch()%></option>
<%}%>
    


</select>   
</td></tr> -->   

<!--<tr><td><font style="font-size:12;color:white"><b>Semster</b></font></td><td>
<select name="semester">

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

</select>   
</td></tr>    -->
<!--<tr><td valign="top" class="tdcolor">Session</td>
    <td>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select></td></tr>-->
<tr><td class="tdcolor">Fee Type</td><td><select name="fee_type">
            <option value="select">Select</option>
<option value="Annual Fee">Annual Fee</option>  
<option value="Once At Admission">Once At Admission</option>   
<option value="Semester Fee">Semester Fee</option> 
</select></td></tr>
<tr><td class="tdcolor">Heads Category</td><td><select name="dues_type">
            <option value="select">Select</option>
<option value="none">None</option>  
<option value="UNIVERSITY DUES">UNIVERSITY DUES</option>   
<option value="STUDENT WELFARE DUES">STUDENT WELFARE DUES</option> 
<option value="COLLEGE OF AGRIBUSINESS DUES">COLLEGE OF AGRIBUSINESS DUES</option> 
<option value="FOOD SERVICE">FOOD SERVICE</option> 
</select></td></tr>

<!--<tr><td class="tdcolor">Fee Head</td><td><input type="text" name="feehead" value="<%=jb.getFeeHead()%>"></td></tr>-->
<tr><td class="tdcolor">Fee Head</td><td><input type="text" name="feehead" value=""></td></tr>
<tr><td><span class="tdcolor">Day Scholar</span></td>
    <td><input type="radio" name="stud_type" value="YES">Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="stud_type" value="NO">No</td></tr>
<!--<tr><td><span class="tdcolor">Staff & Day Scholar</span></td>
    <td><input type="radio" name="stud_type" value="Day Scholar , Staff">
    </td></tr>
<tr><td><span class="tdcolor">None of both</span></td>
    <td><input type="radio" name="stud_type" value="No">
    </td></tr>-->
<tr><td class="tdcolor">Head Type</td><td><select name="head_type">
<option value="GENERAL">GENERAL</option>  
<!--<option value="TREASURY">TREASURY</option>   -->
</select></td></tr>
<!--<tr><td class="tdcolor">Head A/c No.</td><td><input type="text" name="head_ac" value="<%=jb.getHeadAc()%>"></td></tr>-->
<tr><td></td><td colspan="1" align="left"><input type="submit" value="Submit"></td></tr>
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

