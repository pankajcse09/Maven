/*
 * Cms_category.java
 *
 * Created on August 10, 2008, 11:41 PM
 */

package Main_category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.io.PrintWriter;
import mc_operat.Mc_funct;
import mc_bean.mc_prop;
/**
 *
 * @author arjun
 * @version
 */

public class Cms_category extends Action {
    
    /* forward name="success" path="" */
    private final static String suc = "success";
    
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
         DynaActionForm cms_cat=(DynaActionForm)form;
         Mc_funct ins =new Mc_funct();
        mc_prop  mcprop =new mc_prop();
        //mcprop.setMc((String)cms_cat.get("rc"));
        //mcprop.setMc_id(Integer.parseInt(cms_cat.get("rc_id").toString()));
        out.println(Integer.parseInt(cms_cat.get("rc_id").toString()));
        
   mcprop.setMc_id(Integer.parseInt(cms_cat.get("rc_id").toString()));
       mcprop.setMc(cms_cat.get("rc").toString());
    mcprop.setCat(cms_cat.get("maincat").toString());
   ins.Insert_Category(mcprop);
        
      request.setAttribute("suc","Category Added Successfully");
       // request.setAttribute("id",new Integer(id).toString());
        
        return mapping.findForward(suc);
        //return mapping.findForward("");
    }
}
