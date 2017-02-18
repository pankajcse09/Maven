<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="prop_bean.prop_operate"%>
<%@page import="prop_bean.prop_be"%>
<%@page language="java"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <script language="javascript">
            
            
            function sel_crid(){
document.selid.method="POST";

document.selid.action="sel_crid.do?sel_crid=new";

document.selid.submit();
}
        </script>
            
    </head>
    
    <body>
<html:errors/>
  <%!
          ArrayList app_list=new ArrayList();
           ArrayList cr_list=new ArrayList();
  prop_operate po=new prop_operate();
  prop_be pb=new prop_be();
  String cr="";
  int id=0;
  


%>
    <% 
cr=request.getParameter("cr");
//out.println(cr);
if(request.getParameter("cr")!=null)
{

    app_list= (ArrayList)po.Edit_fetch_cr(cr);
%>
     <table width="50%"  bgcolor="white">
     <form name="selid">
     <%
    
             if(!app_list.isEmpty())
    {
    
     %>
   
     <tr><td>Select PropertyID:<select name="pid" onchange="sel_crid()">
          <% if(request.getParameter("pid")==null)
          {
          %>
           <option value="SelectID">SelectID</option>
           <%}%>
          <% if(request.getParameter("pid")!=null)
          {%>
           <option value="<%=request.getParameter("pid")%>"><%=request.getParameter("pid")%></option>
          
          <%}%>
   <% 
    for(int t=0;t<app_list.size();t++)
    {
   pb=(prop_be)app_list.get(t);
  id=pb.getProp_id();
     %>




    
          <option value="<%=id%>"><%=id%></option>
      
        
   <%}
   %>
   
       
      </select>
      
      <input type="hidden" name="cr" value="<%=cr%>">
        <input type="hidden" name="pid" value="<%=id%>">
      
 <input type="submit" name="del" value="Delete" onclick="sel_crid()"> </td></tr>
      </form>
       <% }%>    
 </table>

    <%if(request.getParameter("del")!=null)
{
//out.println("hi"+(String)request.getParameter("del"));

//out.println("hi"+(String)request.getParameter("pid"));
po.del_fetch_crid(Integer.parseInt(request.getParameter("pid")));
out.println("Property is Deleted succesfully! Please Select another PropertyID");
%>
  <%}%> 
   <%
if(request.getParameter("pid")!=null)
{

int pid=Integer.parseInt(request.getParameter("pid"));
cr=request.getParameter("cr");
out.println(pid);
cr_list= (ArrayList)po.Edit_fetch_crid(pid);
 //out.println(cr_list);


%>
   
     
     <%
    
             if(!cr_list.isEmpty())
    {
    
    String bedroom="";
    String area="";
    String cond="";
    double price=0.0;
    String location="";
    String filename=null;
    String mt="";
   String desc="";
     String imag="";
   
    //out.println(sellist);
    
    for(int t=0;t<cr_list.size();t++)
    {
   pb=(prop_be)cr_list.get(t);
   location=pb.getLocation();
   area=pb.getArea();
   cond=pb.getCondition();
   bedroom=pb.getBed();
   price=pb.getPrice();
   mt=pb.getRent();
   desc=pb.getDesc();

   filename=pb.getFilename();
 //  out.println(filename);
 imag=request.getContextPath()+"/Imge/"+filename;
    //out.println(imag);
     %>


 <table bgcolor="white" cellpadding="0" cellspacing="0">
      <tr><td ><font color="red">* These Fields Are Mandatory</font></td></tr>
      </table>
       <table width="50%" border="1" bgcolor="white">
            
<html:form action="prop_cr_ed" enctype="multipart/form-data">
    
     <tr><td rowspan="6" width="20%"><img  border="0" src="<%=imag%>" width="153" height="130"></td><td width="10%"><font color="red">*</font>Location:</td><td> <html:text property="location" value="<%=location%>"></html:text></td></tr>
      <tr><td width="10%"><font color="red">*</font>Area</td><td><html:text property="area" value="<%=area%>"></html:text></td></tr>
      
      
      <tr><td width="10%"><font color="red">*</font>Condition</td>
<td><html:select property="condition">
         <html:option value="<%=cond%>"><%=cond%></html:option>
         <html:option value="un"> Un-furnished</html:option>
        <html:option value="semi">Semi-furnished </html:option>
        <html:option value="full">fully-furnished </html:option>
        </html:select></td>
      
      </tr>
      <tr><td width="0"><font color="red">*</font>Mode of Transaction<td width="0"> Rent<html:radio property="rent"   value="rent"  ></html:radio>
  Sell<html:radio property="rent" value="sell"></html:radio></td></tr>
       <tr><td width="10%"><font color="red">*</font>BedRoom</td><td><html:text property="bed" value="<%=bedroom%>"></html:text></td></tr>
       <tr><td width="10%"><font color="red">*</font>Price</td><td> <html:text property="price" value="<%=new Double(price).toString()%>"></html:text></td></tr>
      <tr><td colspan="3"><hr color="red"></td></tr>
      
      <tr><td>Description</td><td colspan="2"> <html:textarea property="desc" cols="60" rows="10" value="<%=desc%>"></html:textarea>    </td></tr> 
      
     
       
       <table><tr><td>Change Property Image</td><td><html:file property="prop_file" size="44"/></td>
<td align="center"><html:submit value="edit" property="edit"></html:submit></td>
  
       </tr></table>
<input type="hidden" name="app_id" value="<%=pid%>">
<input type="hidden" name="cr" value="<%=cr%>">
<input type="hidden" name="fn" value="<%=filename%>">

     </html:form> 
       </table>
   <%}
     
     }%>    
       
         <%}}%>

   
    </body>
</html>
