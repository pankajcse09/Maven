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

public class Home_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "home";
    private final static String ABOUTUS = "aboutus";
    private final static String  glance="glance";
    private final static String news = "news";  
    private final static String vision = "vision";  
     private final static String message= "message";  
      private final static String objectives= "objectives";  
     private final static String focus= "focus";  
     private final static String history= "history";  
     private final static String awards= "awards";  
     private final static String awk= "awk";  
     private final static String organogram="organogram";  
     private final static String presence="presence";  
      
      
         
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
        ArrayList qualitylist=new ArrayList();
        ArrayList advert=new ArrayList();
         ArrayList blog=new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();        
        homelist=(ArrayList)fd.select_content(page_name);       
//      out.println(page_name);
       request.setAttribute("homelist",homelist);
       request.setAttribute("pagename",page_name);
      

return mapping.findForward("common");
//         return mapping.findForward("");
    } 
}
