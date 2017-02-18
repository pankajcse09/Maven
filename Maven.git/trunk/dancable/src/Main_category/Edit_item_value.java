/*
 * Edit_item_value.java
 *
 * Created on August 25, 2008, 3:18 AM
 */

package Main_category;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mc_operat.Item_func;

/**
 *
 * @author arjun
 * @version
 */
public class Edit_item_value extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int itemid=(Integer.parseInt(request.getParameter("item_id")));
        String col_type=request.getParameter("col_type");
        String item_value=request.getParameter("item");
        Item_func ifunc = new Item_func();
        ifunc.itemupdate_value(itemid,item_value,col_type);
        out.println(itemid);
        out.println(col_type);
         out.println(item_value);
         
         
         
         
         
        out.close();
    }
    
  
}
