/*
 * Imd_home_Action.java
 *
 * Created on May 21, 2010, 1:16 PM
 */

package moreimg;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mc_operat.Mc_funct;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author arjun
 * @version
 */

public class Imd_home_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
      
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
        ArrayList discountlist=new ArrayList();
        ArrayList evdstrm=new ArrayList();
        
        function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content(page_name);
        evdstrm=(ArrayList)fd.select_streamContent("evdstrm");
        
        String p="1";
        if(request.getParameter("pr")!=null)
        {
            p=(String)request.getParameter("pr");
        }
        HashMap hm=new HashMap();
         Mc_funct func=new Mc_funct(); 
         
         hm=(HashMap)func.get_newRelItem(p);
//         out.println(hm);
        request.setAttribute("hmap",hm); 
        request.setAttribute("currentpage",new Integer(p).toString());
            
        request.setAttribute("homelist",homelist);
        request.setAttribute("page_name",page_name);
        request.setAttribute("evdstrm",evdstrm);
     
         return mapping.findForward(page_name);
//         return mapping.findForward("");
    } 
}
