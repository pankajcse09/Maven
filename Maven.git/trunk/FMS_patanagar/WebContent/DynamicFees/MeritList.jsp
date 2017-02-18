<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*,EO.*"%>

<% 
    Connection cn=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    
    int srnum=0;
    int srnum1=0;
    String classes="";
    String Eyear="";
    int Syear=0;
    String sesdate="";
    String prev="";
    String next="";
    SchoolEO seo=new SchoolEO();   
    //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    //String dat=sdf.format(dt);
    String Styear=sdf2.format(dt);
    Syear=Integer.parseInt(Styear);    
    Eyear=new Integer(Syear+1).toString(); 
    prev=(Syear-1)+"-"+Syear;
    next=Syear+"-"+(Syear+1);
    seo.setSyear(Styear);
    seo.setEyear(Eyear);
    
    try{                   
     DataConnection dc=new DataConnection();
     cn=(Connection)dc.Dataconnect();
    }catch(Exception e){}
  
    ArrayList ar2=new ArrayList();
try{
           String sq="select class from classes";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sq);
             while(rs2.next()){
             ar2.add(rs2.getString("class")); 
 }
}catch(SQLException e){}
 
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
//ArrayList ar=(ArrayList)seo.getDataArray();
   
ArrayList ar=new ArrayList();  
if(request.getAttribute("arr")!=null){
ar=(ArrayList)request.getAttribute("arr");    
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
</head>
<body>
<table width="100%" align="center"><tr><td width="100%" align="center"><font style="font-size:18;font-weight:bold">Merit List</font></td></tr></table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/MeritAction.do?method=meritAct">
<table width="100%" align="center"><tr>
<td><font style="font-size:12;font-weight:bold;color:darkblue">Session:</font>
<select name="session">
 <%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}%>
</select></td>
<td><font style="font-size:12;font-weight:bold;color:darkblue">PG/UG/DIPLOMA:</font><select name="standard">    
<%if(seo.getStandard().equals("")){%>
<option value="">SELECT</option>   
<%}else{%>
<option value="<%=seo.getStandard()%>"><%=seo.getStandard()%></option>   
<%}if(!seo.getStandard().equals("PG")){%>  
<option value="PG">PG</option>  
<%}if(!seo.getStandard().equals("UG")){%> 
<option value="UG">UG</option> 
<%}if(!seo.getStandard().equals("DIPLOMA")){%> 
<option value="DIPLOMA">DIPLOMA</option>   
<%}%>
</select></td>
<td><font style="font-size:12;font-weight:bold;color:darkblue">Category</font>
<select name="category">
<option value="GENERAL">GENERAL</option>   
<option value="SC/ST">SC/ST</option> 
<option value="OBC">OBC</option> 
</select></td>
<td><font style="font-size:12;font-weight:bold;color:darkblue">(%)</font><select name="percent">
<option value="INTERMEDIATE">INTERMEDIATE</option> 
<option value="HIGHSCHOOL">HIGHSCHOOL</option>     
</select></td>
<td><font style="font-size:12;font-weight:bold;color:darkblue">No. of Stud</font>
<input type="text" name="num_stud" value="" size="8">
<input type="submit" value="Submit"></td></tr></table>
<hr color="blue">
<table width="100%" align="center">
<%for(int i=0;i<ar.size();i++){%>    
<tr><td></td><td></td><td></td><td></td></tr>    
<%}%>
</table>
</form>
</body>
</html>
