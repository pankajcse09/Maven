<%@ page import="java.sql.*" %> 
<html>
<head>
<style>
A:hover {text-decoration: none;   
    border: 0px;
   font-size:14pt;
    color: #2d2b2b; }
</style>

<link rel="stylesheet" type="text/css" href="datepicker.css"/>


<script type="text/javascript">
function showEmp(emp_value)
{ 
	if(document.getElementById("emp_id").value!="-1")
	{
 xmlHttp=GetXmlHttpObject()
if (xmlHttp==null)
 {
 alert ("Browser does not support HTTP Request");
 return
 }
var url="AjaxTest2.jsp"
url=url+"?emp_id="+emp_value

xmlHttp.onreadystatechange=stateChanged 
xmlHttp.open("GET",url,true)
xmlHttp.send(null)

	}
	else
	{
		 alert("Please Select Employee Id");
	}
}

function stateChanged() 
{ 
	document.getElementById("ename").value ="";
	document.getElementById("emp_id").value ="";
        document.getElementById("emp_age").value ="";
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
 { 
	
  var showdata = xmlHttp.responseText; 
    var strar = showdata.split(":");
	if(strar.length==1)
	 {
		 	document.getElementById("emp_id").focus();
		  alert("Please Select Employee Id");
		  document.getElementById("ename").value =" ";
	document.getElementById("emp_id").value =" ";

	 }
	 else if(strar.length>1)
	 {
	var strname = strar[1];
	document.getElementById("emp_id").value= strar[3];
	document.getElementById("ename").value= strar[1];
        document.getElementById("emp_age").value= strar[2];
	 }
	
 } 
}

function GetXmlHttpObject()
{
var xmlHttp=null;
try
 {
 // Firefox, Opera 8.0+, Safari
 xmlHttp=new XMLHttpRequest();
 }
catch (e)
 {
 //Internet Explorer
 try
  {
  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }
 catch (e)
  {
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
 }
return xmlHttp;
}
</script>

</head>
<body>
<form name="employee">
<br><br>
<table border="0" width="400px" align="center" bgcolor="#CDFFFF">
<div id="mydiv"></div>
   <tr><td><b>Select Employee Id</b></td><td> 
	   
<%
Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "user_register";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "root";

    int sumcount=0; 
	Statement st;
    try {
      Class.forName(driver).newInstance();
	 
      conn = DriverManager.getConnection(url+dbName,userName,password);
     // out.println(conn);
      
	    String query = "select * from employee_details";
	
       st = conn.createStatement();
	   ResultSet  rs = st.executeQuery(query);
           %>	
  <select name="semp_id" onchange="showEmp(this.value);">
	   <option value="-1">Select</option> 
	   <%
	  while(rs.next())
		{
		  %>
		  
		   <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option> 
			
  <%
		}
  %>
   </select>   
  <%
     
	}
	catch (Exception e) {
      e.printStackTrace();
    }
	
%>

</td></tr>
<tr><td><b>Employee ID:</b></td><td>
<input  type="text" name="emp_id" id="emp_id" value=""></td></tr>
<tr><td><b>Employee Name:</b></td><td>
<input  type="text" name="emp_name" id="ename" value=""></td></tr>
<tr><td ><b>Employee Age:</b></td><td>
<input  type="text" name="emp_age" id="emp_age" value=""></td></tr>
</table>
</form>    
<table border="0" width="100%" align="center">
<br>
<br>
</table>
</body>
</html>
