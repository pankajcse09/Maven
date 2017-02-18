<%-- 
    Document   : expenses
    Created on : Mar 22, 2013, 6:01:06 PM
    Author     : kapil
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        </head> 
        <body>
 

        <div>
       <table width="130" class="t" rules="column">                  
            <tr><td><a href="<%=request.getContextPath()%>/Enter_All_Expenses.do"><input type="button" value="Enter Expenses" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/UpdateAllExpense1.do"><input type="button" value="Update Expenses" style="width:182px"></a></td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/Report2.do"><input type="button" value="Expenses Report" style="width:182px"></a></td></tr>
            
        </table>
           </div>
     
    </body>
</html>
