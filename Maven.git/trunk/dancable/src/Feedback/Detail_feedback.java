/*
 * Detail_feedback.java
 *
 * Created on December 1, 2008, 1:05 PM
 */

package Feedback;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author arjun
 * @version
 */
public class Detail_feedback extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
 public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
       
        
        
        
        
String filename="";
String id="";


filename=request.getParameter("para");
//out.println("filename"+filename);




 ServletOutputStream ou = response.getOutputStream();
        

        response.setContentType("application/octat-stream");
       
        
        
     
        String path1="/feedback/"+filename;
     File dir = new File(path1);
       

         response.addHeader("Content-Disposition","filename=\""+ filename + "\"");
       ServletContext ctx=getServletContext();
      
       //response.setContentType("application/octat-stream");
       //String aaa=ctx.getRealPath( path1);
     String abc=ctx.getMimeType(path1);

       FileInputStream fis = null;
  try {
       
    fis = new FileInputStream(dir);
    byte[] buf = new byte[4 * 1024];  // 4K buffer
    int bytesRead;
    while ((bytesRead = fis.read(buf)) != -1) {
      ou.write(buf, 0, bytesRead);
    }
  }
  
   catch(FileNotFoundException ff)
  {
  
  ou.println("File Not Available");
  
  }
  finally {
    if (fis != null) fis.close();
  }

        

        ou.close();
    }
    
   
}
