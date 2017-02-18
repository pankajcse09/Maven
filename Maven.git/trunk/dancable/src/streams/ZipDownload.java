
package streams;

import ActionClass.Common;
import Main_category.item_bean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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


public class ZipDownload extends HttpServlet {

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
            out.println("<title>Servlet ZipDownload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ZipDownload at " + request.getContextPath() + "</h1>");
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

        String order_id=request.getParameter("o");
        Common comLogin = new Common();
       order_id=comLogin.unJumbleData(order_id);
       order_id=comLogin.unJumbleData(order_id);
        int id=0;
        try{
        if(request.getParameter("id")!=null)
        {
            id=Integer.parseInt(request.getParameter("id").toString());
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
        int chkDownload=tdb.checkIn_CustomerDownloads(id,order_id,chk,"customer_downloads_zip");
//        System.out.println("chkDownload: "+chkDownload);
        if(chkDownload==0)
        {
            item_bean ib=tdb.retZipFileDetail(id,order_id);
            ib.setOrder_id(order_id);
            ib.setRowid(ib.getRwid());

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
    tdb.update_inserted_customer_downloads_zip(ib);
               }
               else{
                    RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
                    request.setAttribute("vc", ib.getFilename()+" file is not exist on the server. Please contact administrator or write about this "
                            + "inconvenience through our contact us page.");
                    rd1.forward(request,response);
               }
            }
            catch(FileNotFoundException fe) {
                PrintWriter out=response.getWriter();
                out.println("file is not exist on the server. Please contact administrator or write about this inconvenience through our contact us page.");
                out.close();
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
