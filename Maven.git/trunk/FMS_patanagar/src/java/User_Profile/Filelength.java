/*
 * Filelength.java
 *
 * Created on February 2, 2008, 5:45 PM
 */

package User_Profile;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sonal
 * @version
 */
public class Filelength extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
     int maxSize=5*1024*1024;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
      
        
        String type = request.getContentType();
    if (type == null || 
        !type.toLowerCase().startsWith("multipart/form-data")) {
      throw new IOException("Posted content type isn't multipart/form-data");
    }

    // Check the content length to prevent denial of service attacks
    int length = request.getContentLength();
   
 //out.println(length);
           
  
   if(length > maxSize)
           {
        String aa="file limit excceded";
    request.setAttribute("largefile",aa);
    RequestDispatcher rd=request.getRequestDispatcher("/College_Files/College_File.jsp");
    rd.forward(request,response);
    
  }      
           else
           {
           
          RequestDispatcher rd=getServletContext().getNamedDispatcher("sndfle");
                  // RequestDispatcher("/College_Files/College_File.jsp");
    rd.forward(request,response);
           
           }    
        
        
        
        out.close();
    }
    
    
   
   
}
