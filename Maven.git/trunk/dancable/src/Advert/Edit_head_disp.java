/*
 * Edit_head_disp.java
 *
 * Created on December 1, 2008, 10:20 PM
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
import prop_bean.prop_operate;
/**
 *
 * @author arjun
 * @version
 */

public class Edit_head_disp extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
     private final static String forward = "forward";
    
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
         PrintWriter out=response.getWriter();
         prop_operate op=new  prop_operate();
       ad_form head=(ad_form)form;
         ArrayList det= new ArrayList();
       int ad_id=head.getAd_id();
       out.println("id"+ad_id);
         String cont=head.getContinue1();
         out.println(head.getContinue1());
         String pag=request.getParameter("pag");
         if(cont.equalsIgnoreCase("Continue"))
         {
         
           det=(ArrayList)op.fetch_ad_detail(ad_id);
           
           
           out.println(det);
           request.setAttribute("id",new Integer(ad_id).toString());
           request.setAttribute("details",det);
             request.setAttribute("pag",pag);
        
           return mapping.findForward(forward);
         
         }
         
         
        return mapping.findForward(SUCCESS);
        
    }
}
