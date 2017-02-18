/*
 * Add_attr.java
 *
 * Created on August 14, 2008, 3:31 AM
 */

package Main_category;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import mc_operat.Mc_funct;
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
public class Add_attr extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         out.println("hello");
         Enumeration enuma = request.getParameterNames();
         ArrayList para_name=new ArrayList();
           ArrayList para_value=new ArrayList();
         HashMap par_name=new HashMap();
        while (enuma.hasMoreElements())
        {
             
              String name = (String) enuma.nextElement();
              String values[] = request.getParameterValues(name);
                  if (values != null) 
                     {
                             for (int i = 0; i < values.length; i++) 
                          {
                              out.println(name + values[i]);
                                 
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
         String item[] = new String[para_value.size()];
         for(int j=0;j<para_value.size();j++)
         {
         item[j]=(String)para_value.get(j);
         
         }
         out.println("0"+item[0]+"<br>");
         out.println("1"+item[1]+"<br>");
          out.println("2"+item[2]+"<br>");
           out.println("3"+item[3]+"<br>");
            out.println("4"+item[4]+"<br>");
        // out.println("5"+item[5]);
          out.println("6"+item[6]);
      out.println("java page");
        
//        int subcat_id=(Integer.parseInt(request.getParameter("subcat_id")));
//        String brand=(String)request.getParameter("brand");
//        int size=(Integer.parseInt(request.getParameter("size")));
//         int p_id=(Integer.parseInt(request.getParameter("p_id")));
           
           int subcat_id=(Integer.parseInt(item[0]));
        String brand=(String)item[1];
     double price=(Double.parseDouble(item[2]));
       int size=(Integer.parseInt(item[3])); 
     String status=(String)item[4];
       
         int p_id=(Integer.parseInt(item[6])); 
        // out.println(p_id);
         Mc_funct add_attr=new Mc_funct(); 
        // add_attr.add_attrib(brand,p_id,size,subcat_id,price,status);
        
        
         RequestDispatcher  rd  = request.getRequestDispatcher("/category/Attribute.jsp?subcat_id="+subcat_id); 
      rd.forward(request,response); 
         out.close();
    }
    
   
}
