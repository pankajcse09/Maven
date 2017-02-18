/*
 * Imd_home_Action.java
 *
 * Created on May 21, 2010, 1:16 PM
 */

package moreimg;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author arjun
 * @version
 */

public class Imd_home_edit_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
      private final static String ABOUTUS = "aboutus";
       private final static String rates = "rates";
        private final static String organizedby = "organizedby";
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String page_name="";
        
       page_name=request.getParameter("name");      
        PrintWriter out=response.getWriter();
        ArrayList homelist =new ArrayList();
       ArrayList advert=new ArrayList();
               ArrayList blog=new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content(page_name);
         advert=(ArrayList)fd.select_content("advert");     
          blog=(ArrayList)fd.select_content("blog");     
       // out.println(homelist);
        request.setAttribute("advert",advert);
        request.setAttribute("blog",blog);
        request.setAttribute("homelist",homelist); 
         request.setAttribute("pagename",page_name); 
       
        
        return mapping.findForward(SUCCESS);
      
      
         
    } 
}
