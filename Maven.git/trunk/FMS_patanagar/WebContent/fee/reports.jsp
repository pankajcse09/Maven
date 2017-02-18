<%-- 
    Document   : reports
    Created on : Mar 22, 2013, 6:01:17 PM
    Author     : kapil
--%>
<%@page import="User_Role.User_role_bean"%>
<%
User_role_bean urb=(User_role_bean)session.getAttribute("user_auth");
String s="yes";
String role=(String)session.getAttribute("userrole");
%>
         <!-- <table width="180" class="t" rules="column" border="0">
            <tr><td><a href="<%=request.getContextPath()%>/Sub_List_Classwise.do"><input type="button" value="Classwise Subject List" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/Disp_StudSub.do"><input type="button" value="Display Student Subject" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/DispFeeHeadwise.do"><input type="button" value="Display Fee Headwise" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/clsd.do"><input type="button" value="Classwise Stud. Detail" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/CcFormat.do"><input type="button" value="Character Certificate" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/TcFormat.do"><input type="button" value="Transfer Certificate" style="width:182px"></a></td></tr>
            </table> -->
         
         <table width="180" class="t" rules="column" border="0">
            <!-- <tr><td><a href="<%=request.getContextPath()%>/DispFeeHeadwise.do">
                         <input type="button" value="Display Fee Headwise" style="width:182px"></a></td></tr>-->
             <tr><td><a href="<%=request.getContextPath()%>/PantReports/fundwisereport.jsp">
                         <input type="button" value="Display Fee Fundwise" style="width:195px"></a></td></tr>
             <tr><td><a href="<%=request.getContextPath()%>/PantReports/fundtransfer.jsp">
                         <input type="button" value="Fund Transfer" style="width:195px"></a></td></tr>
            <!--<tr><td><a href="<%=request.getContextPath()%>/dateWise_amount.do">
                        <input type="button" value="Datewise Total Amount" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/totBankwise_amount.do?method=bankList">
                        <input type="button" value="Bankwise Total Amount" style="width:182px"></a></td></tr>-->
             <tr><td><a href="<%=request.getContextPath()%>/totBankwise_amount.do?method=bankList">
                        <input type="button" value="Date & Bankwise Fee Draft" style="width:195px"></a></td></tr>
            <!--<tr><td><a href="<%=request.getContextPath()%>/totDatewise_adv.do">
                        <input type="button" value="Datewise Total Advance" style="width:195px"></a></td></tr>
             <tr><td><a href="<%=request.getContextPath()%>/totBankwise_adv.do?method=bankList">
                         <input type="button" value="Bankwise Total Advance" style="width:195px"></a></td></tr>-->
             <tr><td><a href="<%=request.getContextPath()%>/totBankwise_adv.do?method=bankList">
                         <input type="button" value="Date & Bankwise Advance" style="width:195px"></a></td></tr>
             
             <tr><td><a href="<%=request.getContextPath()%>/totalDrRef.do">
                        <input type="button" value="Total Draft Refunded" style="width:195px"></a></td></tr>
             
            <!--<tr><td><a href="<%=request.getContextPath()%>/totalAmountRec.do?method=totalReceived">
                        <input type="button" value="Toatl Amount Received" style="width:195px"></a></td></tr>-->
             <tr><td><a href="<%=request.getContextPath()%>/allreceived.do?method=bankList">
                        <input type="button" value="Total Amount Received" style="width:195px"></a></td></tr>
             
             <tr><td><a href="<%=request.getContextPath()%>/bnkam.do?method=bankList">
                        <input type="button" value="Bank Amount" style="width:195px"></a></td></tr>
             
             <tr><td><a href="<%=request.getContextPath()%>/lfine.do">
                        <input type="button" value="Late Fee Fine" style="width:195px"></a></td></tr>
       <%if(urb.getUr_create().equals(s)){%>      
            <tr><td><a href="<%=request.getContextPath()%>/advDraftToBn.do?method=bankList">
                        <input type="button" value="Update Advance Draft" style="width:195px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/amDraftToBn.do?method=bankList">
                        <input type="button" value="Update Amount Draft" style="width:195px"></a></td></tr>
        <%}%>    
            
            
            <!--<tr><td><a href="<%=request.getContextPath()%>/clsd.do"><input type="button" value="Classwise Stud. Detail" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/CcFormat.do"><input type="button" value="Character Certificate" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/TcFormat.do"><input type="button" value="Transfer Certificate" style="width:182px"></a></td></tr>-->
            
           <!-- <tr><td><a href="<%=request.getContextPath()%>/stddt.do">
                        <input type="button" value="Individual Student Details" style="width:182px"></a></td></tr>-->
            
            
            <tr><td valign="bottom" style="padding-left: 5px;" align="left" height="50">
                    <font color="green" style="font-family:Times New Roman" size="4"><strong>Student Record Management </strong></font></td></tr>
           <!-- <tr><td><a href="<%=request.getContextPath()%>/stddt.do">
                        <input type="button" value="Individual Student Details" style="width:182px"></a></td></tr>-->
            <tr><td><a href="<%=request.getContextPath()%>/ttsd.do">
                        <input type="button" value="Student List Programwise" style="width:195px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/ttregsd.do">
                        <input type="button" value="Registered Student List" style="width:195px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/trsd.do">
                        <input type="button" value="Transfered Student" style="width:195px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/ndsd.do">
                        <input type="button" value="Noduesed Students" style="width:195px"></a></td></tr>
           <!-- <tr><td><a href="<%=request.getContextPath()%>/stddtwise.do">
                        <input type="button" value="Student List datewise" style="width:182px"></a></td></tr>-->
         <tr><td><a href="<%=request.getContextPath()%>/stud_record.do">
                        <input type="button" value="Student Record" style="width:195px"></a></td></tr>
         <tr><td><a href="<%=request.getContextPath()%>/noduesedExcel.do">
                        <input type="button" value="Noduesed Excel Data" style="width:195px"></a></td></tr>
         
         
         <tr><td><a href="<%=request.getContextPath()%>/monthlyFoodReport.do">
                        <input type="button" value="Monthly Food Amount" style="width:195px"></a></td></tr>
         </table>
        