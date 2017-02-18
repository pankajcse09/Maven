/*
 * SignOut.java
 *
 * Created on November 8, 2007, 10:52 AM
 */

package com.myapp.struts;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author IntelMind
 * @version
 */
public class SignOut extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        session.removeAttribute("forwardname");
        session.removeAttribute("forwardcollege");
        //session.setMaxInactiveInterval(5);
        session.invalidate();
        
        
        //response.sendRedirect("/Exam/index.jsp");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet SignOut</title>");
        out.println("</head>");
        out.println("<body onload = document.frm.submit()>");
        out.println("<form name=frm method=post action=/Exam >");
        out.println(" </form>");
       
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
}
