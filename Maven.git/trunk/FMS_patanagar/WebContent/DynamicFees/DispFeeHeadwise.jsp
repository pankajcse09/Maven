<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<!DOCTYPE html>
<%!  
 Connection con=null; 
 PreparedStatement psmt1=null; 
 PreparedStatement psmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
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
      String qry="select rowid,heads,field_name from feeheads order by heads";
      psmt1=con.prepareStatement(qry);
      rs1=psmt1.executeQuery();   
      while(rs1.next()){      
      ar.add(rs1.getString("heads"));
      ar2.add(rs1.getString("field_name"));
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
String hd="";
if(request.getAttribute("hd")!=null){
hd=(String)request.getAttribute("hd");   
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<title>JSP Page</title>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Reports/Fee Reports</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">

<form name="f1" method="post" action="<%=request.getContextPath()%>/DispTotalHeadFee.do?method=totalHeadFee">
<table width="50%" align="center" border="1" style="border-collapse:collapse">
<tr><td width="25%"><font style="font-size:12;font-weight:bold">Session</font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select></td>     
<td width="75%"><font style="font-size:12;font-weight:bold">Heads</font><br>
<select name="heads">
<%if(seo.getHeads().equals("")){%>
<option value="">Select</option>
<%}else{%>
<option value="<%=hd%>"><%=seo.getHeads()%></option>
<%}%>  

<%for(int i=0;i<ar.size();i++){
if(ar.get(i).equals(seo.getHeads())){continue;}
%>    
<option value="<%=ar.get(i)%>/<%=ar2.get(i)%>"><%=ar.get(i)%></option>    
<%}%>
</select>
<input type="submit" value="Submit"></td></tr></table>
</form>
<table width="50%" align="center" border="1" style="border-collapse:collapse" style="padding-top: 20px">
<tr><td width="50%"><font style="font-size:15;color:darkblue"><b>Session</b></font></td>
<td><font style="font-size:12"><b><%=seo.getSession()%></b></font></td></tr>
<td width="50%"><font style="font-size:15;color:darkblue"><b>Head</b></font></td>
<td><font style="font-size:12"><b><%=seo.getHeads()%></b></font></td></tr>
<td width="50%"><font style="font-size:15;color:darkblue"><b>Total Fee(in Rs.)</b></font></td>
<td><font style="font-size:12"><b><%=seo.getFeeTotal()%></b></font></td></tr>  
</table>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
