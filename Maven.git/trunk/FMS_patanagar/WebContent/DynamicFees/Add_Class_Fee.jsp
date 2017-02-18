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
  function retBlockF(){
  document.forms[0].method="post";
  document.forms[0].action="<%=request.getContextPath()%>/Add_Class_Fee.do?method=Branchpage";
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
    
    String degree="";
    if(request.getParameter("degree")!=null){
        degree=request.getParameter("degree");
    }
    String sess="";
         if(request.getAttribute("session")!=null){
             sess=(String)request.getAttribute("session");
         }
       else{
        if(request.getParameter("session")!=null){
            sess=request.getParameter("session");
               }
       }
    String sslast="";
    try{
        int lt=sess.lastIndexOf("-");
        String s1=sess.substring(0,lt);
        String s2=sess.substring(lt+1, sess.length());
        sslast=(Integer.parseInt(s1)-1)+"-"+(Integer.parseInt(s2)-1);
    }catch(Exception e){}
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
     else{
       deg.setDegree(degree);
     }
   
   JavaBean de=new JavaBean();
   ArrayList degreelist=new ArrayList();
if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }

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
    ArrayList al=new ArrayList();
    HashMap hm=new HashMap();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){} 
    
   try{   
       String qry="";
       if(!degree.equals("")){
           qry="select rowid,feeheads.heads,fee from feeheads left join suraj_feechartdynam on feeheads.heads=suraj_feechartdynam.heads"
 + " where suraj_feechartdynam.degree='"+degree+"' and session='"+sslast+"' order by heads";
           //System.out.println(qry);
           psmt1=con.prepareStatement(qry);
      rs1=psmt1.executeQuery();   
      while(rs1.next()){      
      ar.add(rs1.getString("heads"));
      hm.put(rs1.getString("heads"), rs1.getString("fee"));
     } 
      rs1.close();  
      qry="select heads from feeheads where heads not in (select distinct heads from suraj_feechartdynam)";
      psmt1=con.prepareStatement(qry);
      rs1=psmt1.executeQuery();   
      while(rs1.next()){      
      al.add(rs1.getString("heads"));
      } 
       }
       else
         {
      qry="select rowid,heads from feeheads order by heads";
      psmt1=con.prepareStatement(qry);
      rs1=psmt1.executeQuery();   
      while(rs1.next()){      
      ar.add(rs1.getString("heads"));
      } 
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
try{
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Course Fee</title>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<script language="JavaScript">     
function classType(a){
document.f1.method="post";
document.f1.action="<%=request.getContextPath()%>/Course_Type.do?method=typeAction2";
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
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 947px;
    left:300px;
}
         </style>   
         
         <% %>
        
<table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left">
         <font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                     
                <tr><td>
<table style="padding-left: 350px">
    <tr><td colspan="2" align="center"><font style="font-size:16;font-weight:bold;color:darkblue">Enter Fee for Courses Semester Wise</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/SubmitClassFee.do?method=subClassFee" onsubmit="return validate();">
<table  align="center" border="1" style="border-collapse:collapse" width="500" bordercolor="black">
<%if(request.getAttribute("msg")!=null){%>  
<tr><td colspan="2"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
<tr><td width="50%"><font style="font-size:12;font-weight:bold" color="black">Session</font></td>
<!--<td width="50%"><select name="session">
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
</select></td>-->
<td width="50%"><select name="session">
<option value="<%=next%>"><%=next%></option>
</select></td>
</tr>    


     
    
    <tr><td><font style="font-size:12;color:black"><b>Select Degree</b></font></td><td>
<!--<select name="degree" onBlur="retBlock();">-->
<select name="degree" onblur="retBlockF()">
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
</td></tr>    


<!--<tr><td><font style="font-size:12;color:black"><b>Select Branch</b></font></td><td>
<select name="branch" style="width: 200px">
    <option value="select one">select one</option>
    <%for(int i=0;i<BranchList.size();i++){
jbb=(JavaBean)BranchList.get(i);
%>
<option value="<%=jbb.getBranch()%>"><%=jbb.getBranch()%></option>
<%}%>
    


</select>   
</td></tr>  


<tr><td><font style="font-size:12;color:black"><b>Select Course Semster/Yearly</b></font></td><td>
<select name="duration">
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
</td></tr>    -->  


<!--<tr><td width="50%"><font style="font-size:12;font-weight:bold" color="black">Practical Type</font></td>
<td width="50%"><select name="type">
<option value="">Select</option>    
<option value="NON PRAC">NON PRAC</option>
<option value="ONE PRAC">ONE PRAC</option>
<option value="TWO PRAC">TWO PRAC</option>
<option value="THREE PRAC">THREE PRAC</option>
</select></td></tr> -->
<tr><td width="50%"><font style="font-size:12;font-weight:bold" color="black">Gender</font></td>
<td width="50%"><select name="gender">
<option value="COMMON">COMMON</option>   
<!--<option value="MALE">MALE</option>  
<option value="FEMALE">FEMALE</option>  -->
</select></td></tr>
</table>
<table  align="center" border="1" style="border-collapse:collapse" width="500" bordercolor="black">
<%
int i=0;
for(i=0;i<ar.size();i++){%>
<tr><td width="50%"><font style="font-size:12;font-weight:bold" color="black"><%=ar.get(i).toString().toUpperCase()%></font>
<input type="hidden" name="hd_<%=i%>" value="<%=ar.get(i)%>"></td>
    <td width="50%">
       <% if(hm.get(ar.get(i))!=null){%>
        <input type="text" name="fe_<%=i%>" value="<%=hm.get(ar.get(i))%>" onkeypress="return checkNumeric();">
        <%}else{%>
            <input type="text" name="fe_<%=i%>" value="" onkeypress="return checkNumeric();">
            <%}%>
    </td></tr>
<%}%>
<%if(al.size()!=0){
    for(int j=0;j<al.size();j++)
               {
%>
<tr><td width="50%"><font style="font-size:12;font-weight:bold" color="black"><%=al.get(j).toString().toUpperCase()%></font>
<input type="hidden" name="hd_<%=i%>" value="<%=al.get(j)%>"></td>
    <td width="50%"><input type="text" name="fe_<%=i%>" onkeypress="return checkNumeric();"></td></tr>
<%
i=i+1;
    }}%>
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