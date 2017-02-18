/*
 * Copyright 2014 kapil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package Fee;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import static org.apache.catalina.connector.InputBuffer.DEFAULT_BUFFER_SIZE;

/**
 *
 * @author kapil
 */

public class ViewFile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewFile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewFile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletConfig config= getServletConfig();
        String folder= config.getInitParameter("folder");
        
        String filename=request.getParameter("fl");
        String dir=getServletContext().getRealPath(folder)+"/"+filename;
        BufferedInputStream buf = null;
        File f=new File(dir);
        try {
            
         FileInputStream input = new FileInputStream(f);   
          buf = new BufferedInputStream(input);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int inputStreamLength = 0;
        int length = 0;
        while ((length = buf.read(buffer)) > 0) {
            inputStreamLength += length;
            baos.write(buffer, 0, length);
        }

        
String mimeType = getServletContext().getMimeType(filename);
//System.out.println("mimetype: "+mimeType);
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.reset();
            httpResponse.setHeader("Content-Type", mimeType);
            httpResponse.setHeader("Content-Length", String.valueOf((int)f.length()));
            httpResponse.setHeader("Content-Disposition", "inline; filename=" + filename );
        }

        response.getOutputStream().write(baos.toByteArray(), 0, (int)f.length());

        //finally
        response.getOutputStream().flush();

        //clear
        baos = null;
    } finally {
        // TODO Auto-generated catch block
        close(response.getOutputStream());
        close(buf);
    }
}
private void close(Closeable resource) throws IOException {
    if (resource != null) {
        resource.close();
    }    
}


    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
