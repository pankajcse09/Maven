/*
 * ProjectShared_Display.java
 *
 * Created on February 5, 2008, 11:36 AM
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
public class ProjectShared_Display extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         ServletOutputStream out = response.getOutputStream();
       // response.setContentType("text/html;charset=UTF-8");
         response.setContentType("application/octat-stream");
       
        
        
        String a=request.getParameter("para");
        String path1="/sharedproject/"+a;
     File dir = new File(path1);
       

         response.addHeader("Content-Disposition","filename=\""+ a + "\"");
       ServletContext ctx=getServletContext();
      
       //response.setContentType("application/octat-stream");
       //String aaa=ctx.getRealPath( path1);
     String abc=ctx.getMimeType(path1);

       FileInputStream fis = null;
  try {
       
    fis = new FileInputStream(dir);
    byte[] buf = new byte[5 * 1024];  // 4K buffer
    int bytesRead;
    while ((bytesRead = fis.read(buf)) != -1) {
      out.write(buf, 0, bytesRead);
    }
  }
  finally {
    if (fis != null) fis.close();
  }
      
    }
        }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
   
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    
    /** Returns a short description of the servlet.
     */
    
    // </editor-fold>

       