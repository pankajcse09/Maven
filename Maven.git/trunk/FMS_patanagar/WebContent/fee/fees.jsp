<%-- 
    Document   : fees
    Created on : Mar 22, 2013, 6:00:46 PM
    Author     : kapil
--%>
     <%@page import="User_Role.User_role_bean"%>
<%
User_role_bean urb=(User_role_bean)session.getAttribute("user_auth");
String s="yes";
%>
       <table class="t" rules="column"> 
           <tr><td valign="top" style="padding-left: 5px;" align="left">
                   <font color="green" style="font-family:Times New Roman" size="4"><strong>New Student</strong></font></td></tr>
           <%if(urb.getUr_create().equals(s)){%> 
            <tr><td><a href="<%=request.getContextPath()%>/counsellingFee_ToPay.do">
                        <input type="button" value="Submit Counselling Fee" style="width:185px"></a></td></tr>
            <%}%>
            <tr><td><a href="<%=request.getContextPath()%>/viewcounsellingFee.do">
                        <input type="button" value="View/Print Counselling Fee" style="width:185px"></a></td></tr>
          <%if(urb.getUr_update().equals(s)){%>   
             <tr><td><a href="<%=request.getContextPath()%>/editcounsellingFee.do">
                         <input type="button" value="Edit Counselling Fee" style="width:185px"></a></td></tr>
             <%}%>
          <%if(urb.getUr_create().equals(s)){%> 
            <tr><td><a href="<%=request.getContextPath()%>/refundCounsFee.do">
                        <input type="button" value="Refund" style="width:185px"></a></td></tr>
            
            <tr><td><a href="<%=request.getContextPath()%>/Fee_ToPay.do?method=Branchpage">
                        <input type="button" value="Submit Student Fee" style="width:185px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/stud_id.do">
                        <input type="button" value="Enter Student ID" style="width:185px"></a></td></tr>
            <%}%>
         <%if(urb.getUr_update().equals(s)){%>     
             <tr><td><a href="<%=request.getContextPath()%>/editStudProgFee.do">
                         <input type="button" value="Edit Programme Fee" style="width:185px"></a></td></tr>
             <tr><td><a href="<%=request.getContextPath()%>/editStudId.do">
                         <input type="button" value="Edit Student Id" style="width:185px"></a></td></tr>
             <tr><td><a href="<%=request.getContextPath()%>/ediStud.do">
                        <input type="button" value="Edit Student Details" style="width:185px"></a></td></tr>
             <%}%>  
              <%if(urb.getUr_update().equals(s)||urb.getUr_create().equals(s)){%>  
             <tr><td><a href="<%=request.getContextPath()%>/feeScroll.do">
                         <input type="button" value="Generate Fee Scroll" style="width:185px"></a></td></tr>
            <%}%>
             <%if(urb.getUr_create().equals(s)){%> 
            <tr><td><a href="<%=request.getContextPath()%>/student_fee/spstudent.jsp">
                        <input type="button" value="NRI Student" style="width:185px"></a></td></tr>
            
            <%}%>
            <tr><td><a href="<%=request.getContextPath()%>/student_fee/NewAdminNodues.jsp">
                        <input type="button" value="New Admission No Dues" style="width:185px"></a></td></tr>
            <!--<tr><td><a href="<%=request.getContextPath()%>/add_fee.do"><input type="button" value="Fee of Degree Change" style="width:185px"></a></td></tr>-->
            
             <!--<tr><td><a href="<%=request.getContextPath()%>/FeeReceipt_ToPay.do"><input type="button" value="Generate Fee Receipt" style="width:153px"></a></td></tr>-->
         <%if(urb.getUr_update().equals(s)||urb.getUr_create().equals(s)){%>      
            <tr><td height="20" valign="bottom"><hr></td></tr>
            <tr><td style="padding-left: 5px;" align="left">
                    <font color="green" style="font-family:Times New Roman" size="4"><strong>Enter Date </strong></font></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/enterDate.do?method=bankList">
                        <input type="button" value="Enter Bank Date of Draft" style="width:185px"></a></td></tr>
            <%}%>
            <tr><td><hr></td></tr>
            
            <tr><td valign="bottom" style="padding-left: 5px;" align="left" height="20">
                    <font color="green" style="font-family:Times New Roman" size="4"><strong>Old Student</strong></font></td></tr>
         <%if(urb.getUr_create().equals(s)){%>       
            <tr><td><a href="<%=request.getContextPath()%>/feeScrollExcel.do?method=Branchpage">
                        <input type="button" value="Fee Scroll PDF" style="width:185px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/genCmnFeeScroll.do?method=Branchpage">
                        <input type="button" value="Common Fee Scroll PDF" style="width:185px"></a></td></tr>
            <%}%>
            <%if(urb.getUr_create().equals(s)){%>     
            <tr><td><a href="<%=request.getContextPath()%>/manualfeePdf.do">
                        <input type="button" value="Fee Manipulation For PDF" style="width:185px"></a></td></tr>
            <%}%>
            <!--<tr><td><a href="<%=request.getContextPath()%>/fine.do">
                        <input type="button" value="Fine" style="width:185px"></a></td></tr>-->
            <tr><td><a href="<%=request.getContextPath()%>/fee_process.do?method=bankList">
                        <input type="button" value="Process Fee" style="width:185px"></a></td></tr>
            <%if(urb.getUr_create().equals(s)){%>     
            <tr><td><a href="<%=request.getContextPath()%>/manualfee.do">
                        <input type="button" value="Manual Entry/Edit Fee" style="width:185px"></a></td></tr>
            <%}%>
            <tr><td><a href="<%=request.getContextPath()%>/noduesedstudent.do">
                        <input type="button" value="Noduesed Student List" style="width:185px"></a></td></tr>
            <%if(urb.getUr_create().equals(s)){%>     
            <tr><td><a href="<%=request.getContextPath()%>/nodue.do">
                        <input type="button" value="Final No Dues" style="width:185px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/othercollege.do">
                        <input type="button" value="Other College Amount" style="width:185px"></a></td></tr>
            <%}%>     
            <tr><td><hr></td></tr>
            <tr><td valign="bottom" style="padding-left: 5px;" align="left" height="20">
                    <font color="green" style="font-family:Times New Roman" size="4"><strong>Hostel</strong></font></td></tr>
            <%if(urb.getUr_create().equals(s)){%>       
            <tr><td><a href="<%=request.getContextPath()%>/hos_a.do">
                        <input type="button" value="Hostel Assign" style="width:185px"></a></td></tr>
         <tr><td><a href="<%=request.getContextPath()%>/mfp.do">
                        <input type="button" value="Monthly Food Payment" style="width:185px"></a></td></tr>
            <%}%>
         <%if(urb.getUr_update().equals(s)){%>       
            <tr><td><a href="<%=request.getContextPath()%>/emfp.do">
                 <input type="button" value="Edit Monthly Food Payment" style="width:185px"></a></td></tr>
            <%}%>
            <tr><td><a href="<%=request.getContextPath()%>/h_pfBill.do">
                 <input type="button" value="Check Posted Food Bill" style="width:185px"></a></td></tr>
            <tr><td><hr></td></tr>
            <tr><td valign="bottom" style="padding-left: 5px;" align="left" height="20">
                    <font color="green" style="font-family:Times New Roman" size="4"><strong>Transfer</strong></font></td></tr>
            <%if(urb.getUr_create().equals(s)){%> 
            <tr><td><a href="<%=request.getContextPath()%>/student_fee/TransferStudent.jsp">
                        <input type="button" value="Transfer Student" style="width:185px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/sfatrans.do">
                        <input type="button" value="Transfer Self Finance Amount" style="width:185px"></a></td></tr>
            <%}%>
          </table>
      
           