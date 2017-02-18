<%-- 
    Document   : editCounselligFee
    Created on : Jul 11, 2013, 12:17:55 AM
    Author     : kapil
--%>



<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<% 
ArrayList banklist=new ArrayList();
String check="";
if(request.getAttribute("chk")!=null)
       {
    check=(String)request.getAttribute("chk");
}
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
MyMeth mm=new MyMeth();
SchoolEO seo=new SchoolEO();
  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}

ArrayList ar=(ArrayList)seo.getDataArray2();
HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;
try{
%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>FMS</title>
<script language="javascript">

 function focusField(a){
 document.f1.elements[a].focus();
 }
 
 function cal_tot(){
      //alert(documnet.f2.elements["feetotal"].value);
     var reg=document.f2.elements["reg_fee"].value;
     var sem=document.f2.elements["sem_totfee"].value;
     
     var fn=document.f2.elements["fine"].value;
     //alert(fn);
     document.f2.elements["feetotal"].value=parseFloat(sem)+parseFloat(fn)-parseFloat(reg);
     //document.f2.elements["feetotal"].value=fn+sem;
     //alert('documnet.f2.elements["feetotal"].value');
}

function validate()
{
    var session_sem=document.f1.elements["session_sem"];
        if(session_sem.value=="")
        {
            alert("Please Session Semester");
            session_sem.focus();
            return false;
        }
        if(document.f1.elements["srnum"].value=="")
        {
            alert("Please Enter Roll no");
           document.f1.elements["srnum"].focus();
            return false;
        }
        return true;
}

function validate1()
{
    var session_sem=document.f2.elements["session_sem"];
        if(session_sem.value=="")
        {
            alert("Please Session Semester");
            session_sem.focus();
            return false;
        }
    var dd1=document.f2.elements["dd_1"].value;
    var bank1=document.f2.elements["bnk_1"].value;
        if(document.f2.elements["dd_1"].value=="")
        {
            alert("Please Draft no for 1");
           document.f2.elements["dd_1"].focus();
            return false;
        }
        if(document.f2.elements["damnt_1"].value=="")
        {
            alert("Please Amount for 1");
           document.f2.elements["damnt_1"].focus();
            return false;
        }
        if(document.f2.elements["bnk_1"].value=="")
        {
            alert("Please Bank name for 1");
           document.f2.elements["bnk_1"].focus();
            return false;
        }
        
        var dd2=document.f2.elements["dd_2"].value;
        var bank2=document.f2.elements["bnk_2"].value;
        if(document.f2.elements["dd_2"].value.length!=0)
        {
            if(document.f2.elements["damnt_2"].value=="")
            {
                alert("Please Amount Cash Receipt for 2");
                document.f2.elements["damnt_2"].focus();
                return false;
            }
            if(document.f2.elements["bnk_2"].value=="")
            {
                alert("Please Bank name Cash Receipt for 2");
                document.f2.elements["bnk_2"].focus();
                return false;
            }
            else
            {
                if(bank1==bank2&&dd1==dd2){
                    alert("Draft number can not be same for the same bank "+bank1);
                    document.f2.elements["dd_2"].focus();
                    return false;
                }
        }
        }
      return true;
}
</script>

<script language="JavaScript">
      function Clickheretoprint()
{ 
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
  disp_setting+="scrollbars=yes,width=750, height=650, left=100, top=15"; 
  var content_vlue = document.getElementById("printit").innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><title></title>'); 
   docprint.document.write('</head><body onLoad="self.print();window.close();"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
}  
  
 </script>
</head>
<body onload="focusField('srnum');" bgcolor="#999933">
    <% 
    SchoolEO seo1=new SchoolEO(); 
    ArrayList al=new ArrayList();
    if(request.getAttribute("list")!=null){
al=(ArrayList)request.getAttribute("list");
if(al.size()!=0){ 
seo1=(SchoolEO)al.get(al.size()-1);}
}
    %>
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
         
         <% 
         String edit="";
         String view="";
         if(request.getAttribute("edit")!=null)
       {
    edit=(String)request.getAttribute("edit");
}
         if(request.getAttribute("view")!=null)
       {
    view=(String)request.getAttribute("view");
}
         
         SimpleDateFormat sde=new SimpleDateFormat("EEEEEEEE, d MMMMMMMMM, yyyy");
          java.util.Date rtdt=new java.util.Date();
          String rtrndt="";
          try{
          rtrndt=sde.format(rtdt);
                   }catch(Exception ee){}
         double regis_fee=0.0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int month = cal.get(Calendar.MONTH);

        String[] ssn_sm=new String[2];
        if(month>=0&&month<4){ 
            ssn_sm[0]="II";
            ssn_sm[1]="I";
        }
        if(month>=4&&month<=11){ 
            ssn_sm[0]="I";
            ssn_sm[1]="II";
        }
         %>
         
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
                 <form name="f1" method="post" action="<%=request.getContextPath()%>/getCounsFeeRc.do?method=retCounsFeeRc" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top"><font color="darkred" size="3">Edit Counselling Fee</font></td></tr></table>
<table width="35%" align="center">
 <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
     <select name="session_sem" id="session_sem">
                <%for(int i=0;i<ssn_sm.length;i++){%>   
                    <option value="<%=ssn_sm[i]%>"><%=ssn_sm[i]%></option>
                <%}%>
                <option value="">Session Semester</option>
             </select>
     </td>
<td valign="top"><font style="font-size:12;color:white"><b>Roll No</b></font><br>
<input type="text" name="srnum" value="<%=seo.getRegistNo()%>" size="10">
<input type="submit" value="View"></td></tr>    
</table>  
</form>
<hr color="maroon">

<!----    Edit   ----->
<% String msg="";
if(request.getAttribute("msg")!=null)
       {
    msg=(String)request.getAttribute("msg");
}
banklist=(ArrayList)seo.getDataArray();
%>
<table width="90%" align="center"><tr><td align="left">
         <font color="yellow" size="3"><u><b><%=msg%></b></u></font></td>
     </tr></table>
 <form name="f2" method="post" action="<%=request.getContextPath()%>/updateCounsFeeDt.do?method=updCounsFeeDt" onsubmit="return validate1();">
<% if(al.size()!=0&&edit.equals("edit")){%>
<table width="90%"><tr><td align="center">
      <font color="yellow" size="2"><u><b>Update Advance Fee Detail</b></u></font></td>
       <!-- <td align="right"><a href="#"><font color="yellow" size="3"><u><b>Edit</b></u></font></a></td>-->
    </tr></table>
                 <div id="printit">
                     <% for(int k=0;k<1;k++){%>
                     <table width="100%" valign="top" border="0">
                         <tr><td valign="top">
                                 <img src="<%=request.getContextPath()%>/image/pant_logo.png" width="90" height="90"> 
                             </td>
                             <td valign="top" style="padding-top: 5px"><table>
                         <tr><td align="center"><font size="4"><b>Govind Ballabh Pant University of Agriculture & Technology </b></font></td></tr>
                         <tr><td align="center"><font size="4"><b>Pantnagar- 263145(Uttarakhand) <b></font></td></tr>
                                         </table>
                             <table style="padding-left: 120px;padding-top: 5px">
                         <tr><td align="center"><font size="3">OFFICE OF THE COMPTROLLER</font></td></tr>
                         <tr><td align="center"><font size="3">STATEMENT OF ACCOUNT </font></td></tr>
                     </table>
                             </td></tr>
                     </table>
                     

<table align="center" width="100%" valign="top" style="padding-bottom: 20px">
    <tr>
        <td valign="top">
            <table><tr><td colspan="4" style="font-size: 14px"><font><b>Student Details</b></font></td></tr>
                <tr><td style="font-size: 12px"><b>Session</b>:</td><td style="font-size: 12px"><%=seo.getSession()%>
                 <select name="session_sem" id="session_sem">
                 <option value="<%=seo1.getSession_sem()%>"><%=seo1.getSession_sem()%></option>
                <%for(int i=0;i<ssn_sm.length;i++)
                {
                    if(!ssn_sm[i].equals(seo1.getSession_sem())){
                %>                  
                    <option value="<%=ssn_sm[i]%>"><%=ssn_sm[i]%></option>
                <%}}%>
                <option value="">Session Semester</option>
             </select>
                        &nbsp;&nbsp;</td>
                    <td style="font-size: 12px"><b>Roll no.</b>:</td><td style="font-size: 12px"><%=seo.getSrnum()%></td>
                <td style="font-size: 12px"><b>Category Code</b>:</td><td style="font-size: 12px"><%=seo.getCategory()%></td></tr>
    
    <tr><td style="font-size: 12px"><b>Student Name</b>:</td><td style="font-size: 12px"><%=seo.getSname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Father Name</b>:</td><td style="font-size: 12px"><%=seo.getFname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Gender</b>:</td><td style="font-size: 12px"><%=seo.getGender()%></td></tr>
    <input type="hidden" name="session" value="<%=seo.getSession()%>">
    <input type="hidden" name="srnum" value="<%=seo.getSrnum()%>">
    <input type="hidden" name="rows" value="<%=al.size()%>">
    <!--<tr><td>DOB:</td><td><%=seo.getDob()%></td></tr>-->
    <tr></tr></table>
        </td>
    </tr>
    
           
        <tr>
        <td width="100%" valign="top">
            <table width="100%" valign="top">
                <tr><td colspan="2" align="center" style="font-size: 12px"><font><b>ADVANCE FEE DETAILS</b></font></td></tr>
                <tr><td width="30%">Receipt No: &nbsp;<%=seo1.getFeeReceipt()%></td><td>Date: &nbsp;<%=seo1.getDateofadd()%></td></tr>
            </table>
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black" valign="top">
    
    
    
    <!--<tr><td style="font-size: 12px"><b>Sr No.</b></td><td style="font-size: 12px"><b>Demand Draft No(s)</b></td><td style="font-size: 12px"><b>Issuing Bank</b></td>
        <td style="font-size: 12px"><b>Date</b></td><td style="font-size: 12px"><b>Amount(Rs.)</b></td></tr>-->
    
     <tr align="center"><td>Sr No.</td><td><b>Demand Draft No(s)</b></td><td><b>Date<font color="darkred">(dd/mm/yyyy)</font></b></td>
         <td><b>Amount</b></td><td><b>Issuing Bank</b></td><td><b>&nbsp;&nbsp;</b></td></tr>
     <% for(int j=0;j<al.size();j++){
         seo1=(SchoolEO)al.get(j);
    %>
     <tr align="center">
         <td><b>Sr No.&nbsp;<%=j+1%></b></td><td><input type="text" name="dd_<%=j+1%>" value="<%=seo1.getDdno()%>"></td>
                <td style="padding-right: 10px"><input type="text" name="dddate_<%=j+1%>" value="<%=seo1.getDdate()%>"></td>
                 <td><input type="text" name="damnt_<%=j+1%>" value="<%=seo1.getDdamount()%>"></td>
                 <td>
                     <% if(banklist.size()!=0){%>
            <select name="bnk_<%=j+1%>">
                <option value="<%=seo1.getBankname()%>"><%=seo1.getBankname()%></option>
               <% for(int i=0;i<banklist.size();i++){
               if(!seo1.getBankname().equals(banklist.get(i).toString())) {
    %>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}}%>
            </select>
        <%}%>
                 </td>
                 <td>
                     <!--<a href="<%=request.getContextPath()%>/deleteAdvDr.do?method=delAdvDr&id=<%=seo1.getRwid()%>">delete</a>-->
                 </td>
               </tr><input type="hidden" name="rwid_<%=j+1%>" value="<%=seo1.getRwid()%>">
                            <%}%>
 <tr><td colspan="5" align="center"><input type="submit" name="Update"></td></tr>
</table>  
        </td></tr>
</table>
             
<%}%>
   </div>
       <%}%>
 </form>

<!------   View   ----->


<% if(al.size()!=0&&view.equals("view")){%>
<table width="90%"><tr><td align="left">
         <a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
       <!-- <td align="right"><a href="#"><font color="yellow" size="3"><u><b>Edit</b></u></font></a></td>-->
    </tr></table>
                 <div id="printit">
                     <% for(int k=0;k<2;k++){%>
                     <table width="100%" valign="top" border="0">
                         <tr><td valign="top">
                                 <img src="<%=request.getContextPath()%>/image/pant_logo.png" width="90" height="90"> 
                             </td>
                             <td valign="top" style="padding-top: 5px"><table>
                         <tr><td align="center"><font size="4"><b>Govind Ballabh Pant University of Agriculture & Technology </b></font></td></tr>
                         <tr><td align="center"><font size="4"><b>Pantnagar- 263145(Uttarakhand) <b></font></td></tr>
                                         </table>
                             <table style="padding-left: 120px;padding-top: 5px">
                         <tr><td align="center"><font size="3">OFFICE OF THE COMPTROLLER</font></td></tr>
                         <tr><td align="center"><font size="3">STATEMENT OF ACCOUNT </font></td></tr>
                     </table>
                             </td></tr>
                     </table>
                     

<table align="center" width="100%" valign="top" style="padding-bottom: 20px">
    <tr>
        <td valign="top">
            <table><tr><td colspan="4" style="font-size: 14px"><font><b>Student Details</b></font></td></tr>
                <tr><td style="font-size: 12px"><b>Session</b>:</td><td style="font-size: 12px"><%=seo.getSession()%>
                        <%if(!seo1.getSession_sem().equals("")){%>
                            - <%=seo1.getSession_sem()%>
                        <%}%>
                        &nbsp;&nbsp;</td>
                    <td style="font-size: 12px"><b>Roll no.</b>:</td><td style="font-size: 12px"><%=seo.getSrnum()%></td>
                <td style="font-size: 12px"><b>Category Code</b>:</td><td style="font-size: 12px"><%=seo.getCategory()%></td></tr>
    
    <tr><td style="font-size: 12px"><b>Student Name</b>:</td><td style="font-size: 12px"><%=seo.getSname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Father Name</b>:</td><td style="font-size: 12px"><%=seo.getFname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Gender</b>:</td><td style="font-size: 12px"><%=seo.getGender()%></td></tr>
    
    <!--<tr><td>DOB:</td><td><%=seo.getDob()%></td></tr>-->
    <tr></tr></table>
        </td>
    </tr>
    
           
        <tr>
        <td width="100%" valign="top">
            <table width="100%" valign="top">
                <tr><td colspan="2" align="center" style="font-size: 12px"><font><b>ADVANCE FEE DETAILS</b></font></td></tr>
                <tr><td width="30%">Receipt No: &nbsp;<%=seo1.getFeeReceipt()%></td><td>Date: &nbsp;<%=seo1.getDateofadd()%></td></tr>
            </table>
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black" valign="top">
    
    
    
    <tr><td style="font-size: 12px"><b>Sr No.</b></td><td style="font-size: 12px"><b>Demand Draft No(s)</b></td><td style="font-size: 12px"><b>Issuing Bank</b></td>
        <td style="font-size: 12px"><b>Date</b></td><td style="font-size: 12px"><b>Amount(Rs.)</b></td></tr>
    <tr>
    <% int i=0;
    double tot=0.0;
%>
<td><table>
        <% while(i<al.size()){%>
        <tr><td style="font-size: 12px"><%=i+1%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdno()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getBankname()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdate()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
    <td><table>
        <% while(i<al.size()){
             seo1=(SchoolEO)al.get(i);
             tot=tot+seo1.getDdamount();
        %>
        <tr><td style="font-size: 12px"><%=seo1.getDdamount()%></td></tr>
        <% i++;}
    i=0;
    %>
    </table></td>
</tr>
<tr><td colspan="4" align="right" style="font-size: 12px"><b>Total</b></td><td style="font-size: 12px"><b><%=tot%></b></td></tr>
</table>  
        </td></tr>
   <tr><td width="80%" style="padding-top: 0px" valign="top">
             <table valign="top">
                 <tr><td style="font-size: 12px"><b>Received the above Bank Draft</b></td></tr>
                  <tr><td height="25"></td></tr>
                  <tr><td style="font-size: 12px"><b>For Comptroller</b></td></tr>
                  <tr><td height="3"></td></tr>
                  <tr><td style="font-size: 10px"><%=rtrndt%></td></tr>
             </table>
         </td></tr>
   
</table>
             <% if(k<1){%>
                  <hr width="100%" color="black">
<%}}%>
                 </div>
                 <%}%>
                  
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>




