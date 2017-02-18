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

package streams;

import ActionClass.Common;
import Main_category.item_bean;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kapil
 */
public class CustomerDownloads extends HttpServlet {
private static final int BYTES_DOWNLOAD = 1024;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CustomerDownloads</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CustomerDownloads at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {
//            out.close();
//        }
//    }

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
        
        String user_id=request.getParameter("k");
        String order_id=request.getParameter("o");
        Common comLogin = new Common();
//       user_id=comLogin.unJumbleData(user_id);
//       user_id=comLogin.unJumbleData(user_id);
       order_id=comLogin.unJumbleData(order_id);
       order_id=comLogin.unJumbleData(order_id);
//       out.println(user_id);
//       out.println("<br>");
//       out.println(order_id);
        long id=0;
        try{
        if(request.getParameter("id")!=null)
        {
            id=Long.parseLong(request.getParameter("id").toString());
        }
        }catch(Exception e)
        {
            PrintWriter out=response.getWriter();
            out.println("Please do not change the id in url.");
            out.close();
        }
        finally
        {
//            
        }
        String chk="completed";
        ToDBFile tdb=new ToDBFile();
        int chkDownload=tdb.checkIn_CustomerDownloads(id,order_id,chk,"customer_downloads");
//        System.out.println("chkDownload: "+chkDownload);
        if(chkDownload==0)
        {
            item_bean ib=tdb.get_AudioFileToDownload(id);
            ib.setUser_id(user_id);
            ib.setOrder_id(order_id);
            chk="uncomplete";
            int chkDwnld=tdb.checkIn_CustomerDownloads(id,order_id,chk,"customer_downloads");
            if(chkDwnld==0)
            {
                tdb.insertInto_customer_downloads(ib);
            }

            try {
                String path=getServletContext().getRealPath("/downloadaudio")  + File.separator;
               File file= new File(path,ib.getFilename());
//               System.out.println("path: "+file.getPath());
//               System.out.println("Bytes: "+file.exists());
               if(file.exists()){
               String s="attachment;filename="+ib.getFilename();
//                String s="attachment;filename="+ib.getFilename();
//                System.out.println("filename: "+s);
            ServletContext context  = getServletContext();
            String mimetype = context.getMimeType(path);

    // sets response content type
    if (mimetype == null) {
        mimetype = "application/octet-stream";
    }
    response.setContentType(mimetype);
    response.setContentLength((int)file.length());
    response.setHeader("Content-Disposition",s);
    
                InputStream is = new FileInputStream(file);

                byte[] bytes = new byte[2000 * 1024];
                int read=0;
                ServletOutputStream os = response.getOutputStream();
                while((read = is.read(bytes))!= -1){
		os.write(bytes, 0, read);
                System.out.println("Read: "+read);
	}
//                os.write(fileData);  // write out the file we want to save.
                os.flush();
                os.close(); // close the output stream writer
                is.close();
    tdb.update_inserted_customer_downloads(ib);
               }
               else{
                    RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
                    request.setAttribute("vc", ib.getFilename()+" file is not exist on the server. Please contact administrator or write about this "
                            + "inconvenience through our contact us page.");
                    rd1.forward(request,response);
               }
            }
            catch(Exception m) {
                System.out.println("kapil: "+m);
            }
        }	
        else{
            PrintWriter out=response.getWriter();
            out.println("You have already downloaded this file. If there was any error during download, please contact administrator "
                    + "or write the detail message including order id using our "
                    + "feedback form on contact us page. Sorry for any inconvenience ");
            out.close();
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
        doGet(request, response);
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
