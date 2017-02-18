/*
 * del_list_item.java
 *
 * Created on August 26, 2008, 11:31 PM
 */

package Main_category;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mc_operat.Item_func;
import mc_bean.item_list;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author arjun
 * @version
 */
public class del_list_item extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
   public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
        String list_id=request.getParameter("chkh");
//out.println(list_id);

Item_func ed_item= new Item_func();
item_list itemlistview= new item_list();

 Enumeration en = request.getParameterNames();
 
 
         ArrayList para_name=new ArrayList();
           ArrayList itemlistid=new ArrayList();
         HashMap par_name=new HashMap();
        while (en.hasMoreElements())
        {
             
              String name = (String) en.nextElement();
              String values[] = request.getParameterValues(name);
                  if (values != null) 
                     {       if(name.equals("chkh"))
                             {
                             for (int i = 0; i < values.length; i++) 
                          {
                              out.println(name + values[i]);
                                 
                               par_name.put(name,values[i]) ;
                               itemlistid.add(values[i]);
                             
                           }
                             
                             
                              Item_func del = new Item_func();
                              
                                del.del_itemlist(itemlistid);
                             }
                     }
        }

  
//out.println(list_id);
       
        out.close();
    }
    
    
   
}
