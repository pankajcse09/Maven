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

HashMap hm=(HashMap)seo.getDataMap();
//double tt=0.0;

ArrayList al3=new ArrayList();
  SchoolEO seo3=new SchoolEO();
    if(request.getAttribute("list1")!=null)
   {
   al3=(ArrayList)request.getAttribute("list1");
    }

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
            alert("Please Draft no  Cash Receipt 1");
           document.f2.elements["dd_1"].focus();
            return false;
        }
        if(document.f2.elements["damnt_1"].value=="")
        {
            alert("Please Amount Cash Receipt 1");
           document.f2.elements["damnt_1"].focus();
            return false;
        }
        if(document.f2.elements["bnk_1"].value=="")
        {
            alert("Please Bank name Cash Receipt 1");
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
        else{
            if(bank1==bank2&&dd1==dd2){
                    alert("Draft number can not be same for the same bank "+bank2);
                    document.f2.elements["dd_2"].focus();
                    return false;
                }
        }
        }
        
        var dd3=document.f2.elements["dd_3"].value;
        var bank3=document.f2.elements["bnk_3"].value;
        if(document.f2.elements["dd_3"].value.length!=0)
        {
            if(document.f2.elements["damnt_3"].value=="")
        {
            alert("Please Amount Cash Receipt for 3");
           document.f2.elements["damnt_3"].focus();
            return false;
        }
            if(document.f2.elements["bnk_3"].value=="")
        {
            alert("Please Bank name for Cash Receipt 3");
           document.f2.elements["bnk_3"].focus();
            return false;
        }
         else{
             if((bank2==bank3&&dd2==dd3)||(bank1==bank3&&dd1==dd3)){
                    alert("Draft number can not be same for the same bank "+bank3);
                    document.f2.elements["dd_3"].focus();
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
    SchoolEO seo2=new SchoolEO(); 
    ArrayList al=new ArrayList();
     ArrayList al1=new ArrayList();
    if(request.getAttribute("list")!=null){
al=(ArrayList)request.getAttribute("list");
if(al.size()!=0){ 
seo1=(SchoolEO)al.get(al.size()-1);
seo2=(SchoolEO)al.get(0);
}
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/getStuProDraft.do?method=getStudentProgDraft" onsubmit="return validate()">
    <table width="70%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top"><font color="darkred" size="3">Edit Programme Fee</font></td></tr></table>
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
ArrayList banklist=new ArrayList();
if(request.getAttribute("bnklist")!=null)
       {
    banklist=(ArrayList)request.getAttribute("bnklist");
}

%>
<table width="90%" align="center"><tr><td align="left">
         <font color="yellow" size="3"><u><b><%=msg%></b></u></font></td>
     </tr></table>
     <% if(al.size()!=0&&edit.equals("edit")){%>
<form name="f2" method="post" action="<%=request.getContextPath()%>/updateStuProDraft.do?method=updateStuProgDraft" onsubmit="return validate1();">
<table width="90%"><tr><td align="center">
      <font color="yellow" size="2"><u><b>Update Programme Fee Detail</b></u></font></td>
       <!-- <td align="right"><a href="#"><font color="yellow" size="3"><u><b>Edit</b></u></font></a></td>-->
    </tr></table>
                 
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
                <tr><td style="font-size: 12px"><b>Session</b>:</td><td style="font-size: 12px"><%=seo2.getSession()%>
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
                    <td style="font-size: 12px"><b>Roll no.</b>:</td><td style="font-size: 12px"><%=seo2.getSrnum()%></td>
                <td style="font-size: 12px"><b>Category Code</b>:</td><td style="font-size: 12px"><%=seo2.getCategory()%></td></tr>
    
    <tr><td style="font-size: 12px"><b>Student Name</b>:</td><td style="font-size: 12px"><%=seo2.getSname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Father Name</b>:</td><td style="font-size: 12px"><%=seo2.getFname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Gender</b>:</td><td style="font-size: 12px"><%=seo2.getGender()%></td></tr>
    <input type="hidden" name="session" value="<%=seo2.getSession()%>">
    <input type="hidden" name="srnum" value="<%=seo2.getSrnum()%>">
 
    <!--<tr><td>DOB:</td><td><%=seo.getDob()%></td></tr>-->
    <tr></tr></table>
        </td>
    </tr>
    
    <% if(al.size()!=0){ seo1=(SchoolEO)al.get(1); }%>   
        <tr>
        <td width="100%" valign="top">
            <table width="100%" valign="top">
                <tr><td colspan="2" align="center" style="font-size: 12px"><font><b>Programme FEE DETAILS</b></font>
                    <input type="hidden" name="or_session_sem" value="<%=seo1.getSession_sem()%>"> 
                    </td></tr>
                <tr><td width="30%">Receipt No: &nbsp;<%=seo1.getFeeReceipt()%></td><td>Date: &nbsp;<%=seo1.getDateofadd()%></td></tr>
            </table>
<table width="100%" align="center" border="1" style="border-collapse:collapse;border:1px solid black" valign="top">
    
    
    
    <tr><td style="font-size: 12px"><b>Sr No.</b></td><td style="font-size: 12px"><b>Demand Draft No(s)</b></td><td style="font-size: 12px"><b>Issuing Bank</b></td>
        <td style="font-size: 12px"><b>Date</b></td><td style="font-size: 12px"><b>Amount(Rs.)</b></td></tr>
    
     <tr align="center"><td></td><td><b>Demand Draft No(s)</b></td><td><b>Date<font color="red">(dd/mm/yyyy)</font></b></td>
         <td><b>Amount</b></td><td><b>Issuing Bank</b></td></tr>
     
     <% for(int j=1;j<al.size();j++){
         seo1=(SchoolEO)al.get(j);
    %>
     <tr><td><b>Sr No.&nbsp;<%=j%></b></td><td><input type="text" name="dd_<%=j%>" value="<%=seo1.getDdno()%>"></td>
                <td style="padding-right: 10px"><input type="text" name="dddate_<%=j%>" value="<%=seo1.getDdate()%>"></td>
                 <td><input type="text" name="damnt_<%=j%>" value="<%=seo1.getDdamount()%>"></td>
                 <td>
                     <% if(banklist.size()!=0){%>
            <select name="bnk_<%=j%>">
                <option value="<%=seo1.getBankname()%>"><%=seo1.getBankname()%></option>
               <% for(int i=0;i<banklist.size();i++){
                   SchoolEO sco=(SchoolEO)banklist.get(i);
               if(!seo1.getBankname().equals(sco.getBankname())) {
    %>
               <option value="<%=sco.getBankname()%>"><%=sco.getBankname()%></option>
               <%}}%>
            </select>
        <%}%>
               </tr><input type="hidden" name="rwid_<%=j%>" value="<%=seo1.getRwid()%>">
                 
                            <%}%>
                            <input type="hidden" name="row" value="<%=al.size()-1%>">
                            
 <tr><td colspan="5" align="center"><input type="submit" name="Update"></td></tr>
</table>  
        </td></tr>
</table>
             
<%}%>
   
       
 </form>
<%}%>
 <hr>
<!------   View   ----->


<% if(al3.size()!=0){%>


<table width="90%"><tr><td align="left">
         <a href="javascript:Clicktoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
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
                     
<% seo1=(SchoolEO)al3.get(0); %>   
<table align="center" width="100%" valign="top" style="padding-bottom: 0px">
    <tr>
        <td valign="top">
            <table><tr><td colspan="2" style="font-size: 14px"><font><b>Student Details</b></font></td>
                <td colspan="4" style="font-size: 14px" align="left"><b>Course Name&nbsp;<%=seo2.getDegree()%></b></td></tr>
                
                <tr><td style="font-size: 12px"><b>Fee Receipt No.</b>:</td><td><b><%=seo1.getFeeReceipt()%></b>&nbsp;&nbsp;</td>
                    <td style="font-size: 12px"><b>Roll no.</b>:</td><td style="font-size: 12px"><%=seo2.getSrnum()%></td>
                <td style="font-size: 12px"><b>Category Code</b>:</td><td style="font-size: 12px"><%=seo2.getCategory()%></td></tr>
    
    <tr><td style="font-size: 12px"><b>Student Name</b>:</td><td style="font-size: 12px"><%=seo2.getSname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Father Name</b>:</td><td style="font-size: 12px"><%=seo2.getFname()%>&nbsp;&nbsp;</td>
        <td style="font-size: 12px"><b>Gender</b>:</td><td style="font-size: 12px"><%=seo2.getGender()%></td></tr>
    
    <!--<tr><td>DOB:</td><td><%=seo.getDob()%></td></tr>-->
    <tr></tr></table>
        </td>
    </tr>

   
</table>
             

               
    <%
    ArrayList ar=new ArrayList();
ArrayList ar1=new ArrayList();
ArrayList ar2=new ArrayList();
ArrayList ar3=new ArrayList();
ArrayList ar4=new ArrayList();

    seo3=(SchoolEO)al3.get(0);
    ar=seo3.getDataArray();
    ar1=seo3.getDataArray1();
    ar2=seo3.getDataArray2();
    ar3=seo3.getDataArray3();
    ar4=seo3.getDataArray4();
    
%>
          <% for(int i=0;i<ar.size();i++)
          {
      if(ar4.get(i).toString().equals("counselling"))
             {
%>    
           <table width="80%" align="center" valign="top">
                   <tr><td><font style="font-size: 14px"><b>Advance:</b></font></td></tr>
                   <tr>
                       <td>
                           <table border="1" style="border-collapse: collapse" width="80%">
                               <tr><td><b>DD No</b></td><td><b>DD Date</b></td><td><b>Bank</b></td><td><b>Amount</b></td></tr>
                               
     
                            <tr>
                                   <td><%=ar.get(i)%></td>
                                   <td><%=ar1.get(i)%></td>
                                   <td><%=ar2.get(i)%></td>
                                   <td><%=ar3.get(i)%></td>
                               </tr>
                              
                           </table>
                       </td>
                   </tr>
               </table>
                                <%}}%>
                  <table width="80%" align="center">
                   <tr><td><font style="font-size: 14px"><b>Total Fee:</b></font></td></tr>
                   <tr>
                       <td>
                           <table border="1" style="border-collapse: collapse" width="80%">
                               <tr><td><b>DD No</b></td><td><b>DD Date</b></td><td><b>Bank</b></td><td><b>Amount</b></td></tr>
                             
      <% for(int i=0;i<ar.size();i++)
          {
      if(ar4.get(i).toString().equals("addmission fee"))
             {
%>
                            <tr>
                                   <td><%=ar.get(i)%></td>
                                   <td><%=ar1.get(i)%></td>
                                   <td><%=ar2.get(i)%></td>
                                   <td><%=ar3.get(i)%></td>
                               </tr>
                               <%}}%>
                           </table>
                       </td>
                   </tr>
               </table> 
     <table width="80%" align="center">
                 <tr><td style="font-size: 12px"><b>Received the above Bank Draft</b></td></tr>
                  <tr><td height="22"></td></tr>
                  <tr><td style="font-size: 12px"><b>For Comptroller</b></td></tr>
                  <tr><td height="1"></td></tr>
                  <tr><td style="font-size: 10px"><%=rtrndt%></td></tr>
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
<%}catch(Exception e){out.println("<b><font color='yellow'>Fee is Not Submitted</b></font>");}%>




