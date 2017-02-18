/*
 * Edit_itemlist_value.java
 *
 * Created on August 26, 2008, 4:47 AM
 */

package Main_category;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mc_operat.Item_func;
/**
 *
 * @author arjun
 * @version
 */
public class Edit_itemlist_value extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int itemlistid=(Integer.parseInt(request.getParameter("itemlist_id")));
        String col_type=request.getParameter("col_type");
        
        String list_value=request.getParameter("list");
        Item_func ifunc = new Item_func();
        ifunc.list_value(itemlistid,list_value,col_type);
        out.println(itemlistid);
        out.println(col_type);
         out.println(list_value);
        
        
        
        
        
        out.close();
    }
    
    
}
