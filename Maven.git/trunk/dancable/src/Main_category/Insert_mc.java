/*
 * Insert_mc.java
 *
 * Created on August 8, 2008, 2:22 AM
 */

package Main_category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mc_bean.mc_prop;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.io.PrintWriter;
import mc_operat.Mc_funct;
/**
 *
 * @author arjun
 * @version
 */

public class Insert_mc extends Action {
    
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
        
         DynaActionForm ins_mc=(DynaActionForm)form;
        
        String act= (String)ins_mc.get("save");
        PrintWriter out=response.getWriter();
        out.println(act);
        Mc_funct ins =new Mc_funct();
        mc_prop  mcprop =new mc_prop();
        mcprop.setMc((String)ins_mc.get("mc"));
        
        ins.insert_Category(mcprop);
        
     
        request.setAttribute("msg","your Category Create Successfully!");
        return mapping.findForward("success");
        
    }
}
