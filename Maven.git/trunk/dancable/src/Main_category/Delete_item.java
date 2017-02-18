/*
 * Delete_item.java
 *
 * Created on August 27, 2008, 1:00 AM
 */

package Main_category;

import java.io.*;
import java.net.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import mc_operat.Mc_funct;
import mc_bean.item_list;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author arjun
 * @version
 */
public class Delete_item extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
 public ActionForward Delete_item(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception { 
      PrintWriter out= response.getWriter();
       List ar1=new ArrayList();
          List ar2=new ArrayList();
       String id=(String)request.getParameter("did");     
 
         
       ar2.add(id);
         // out.println(ar1) ;
                    
                 
                 Mc_funct del = new Mc_funct();
                            
              del.del_item(ar2);
      out.println("Item deleted.") ;                     
     
         return mapping.findForward("");
    }
    
}