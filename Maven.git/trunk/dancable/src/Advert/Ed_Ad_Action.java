/*
 * Ed_Ad_Action.java
 *
 * Created on December 1, 2008, 9:41 PM
 */

package Advert;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import Advert.ad_bean;
import prop_bean.prop_operate;
/**
 *
 * @author arjun
 * @version
 */

public class Ed_Ad_Action extends Action {
    
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
        PrintWriter out =response.getWriter();
        String pag=request.getParameter("hm");
        prop_operate po= new prop_operate();
        ArrayList headlist= new ArrayList();
        headlist =(ArrayList)po.fetch_head_ad(pag);
        request.setAttribute("headlist",headlist);
        request.setAttribute("pag",pag);
        out.println("page"+pag);
        
        //return mapping.findForward("");
        return mapping.findForward(SUCCESS);
        
    }
}
