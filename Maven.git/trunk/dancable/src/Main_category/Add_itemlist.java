/*
 * Add_itemlist.java
 *
 * Created on August 25, 2008, 11:24 PM
 */

package Main_category;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mc_operat.Item_func;
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
public class Add_itemlist extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       Enumeration enu = request.getParameterNames();
         ArrayList para_name=new ArrayList();
           ArrayList para_value=new ArrayList();
         HashMap par_name=new HashMap();
        while (enu.hasMoreElements())
        {
             
              String name = (String) enu.nextElement();
              String values[] = request.getParameterValues(name);
                  if (values != null) 
                     {
                             for (int i = 0; i < values.length; i++) 
                          {
                              //out.println(name + values[i]);
                                 
                               par_name.put(name,values[i]) ;
                              
                           }
                     }
        }
         
         Set set= par_name.entrySet();
         Iterator i=set.iterator();
         while(i.hasNext())
         {
         
         
         Map.Entry me =(Map.Entry)i.next();
         para_value.add(me.getValue());
  
 
         }
         ArrayList item = new ArrayList();
         for(int j=0;j<para_value.size();j++)
         {
      item.add(para_value.get(j));
       out.println(item);
         }
//        
      out.println("java page");
 
//      for(int k=0;k<item.size();k++)
//         {
//     
//       out.println(item.get(k));
//         }
//      
      int item_id=Integer.parseInt(item.get(0).toString());
        
       int unit=Integer.parseInt(item.get(2).toString());
      
String color=(String)item.get(1);
         
        Item_func item_insert=new Item_func(); 
         
         item_insert.add_listitem(unit,color,item_id);
        
        
         RequestDispatcher  rd  = request.getRequestDispatcher("/category/Add_itemlist.jsp"); 
         rd.forward(request,response); 
        
        
        
        
        out.close();
    }
   
}
