<%-- 
    Document   : checking
    Created on : Oct 9, 2014, 2:12:47 PM
    Author     : kapil
--%>

<%
    String user=(String)session.getAttribute("loginid");
    if(user==null){
        //RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
        //request.setAttribute("msg", "Your session is timeout.");
        //rd1.forward(request,response); 
        out.println("eop");
    }
    else{
        out.println("ttr");
    }
    %>