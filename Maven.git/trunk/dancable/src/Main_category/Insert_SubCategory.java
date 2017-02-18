/*
 * Insert_SubCategory.java
 *
 * Created on August 12, 2008, 10:36 PM
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

public class Insert_SubCategory extends Action {
    
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
        DynaActionForm sub_cat=(DynaActionForm)form;
        Mc_funct subcat_func =new Mc_funct();
        mc_prop subcat_prop= new mc_prop();
        subcat_prop.setSub_cat(sub_cat.get("subcat").toString());
        subcat_prop.setC_id(Integer.parseInt(sub_cat.get("cat_id").toString()));
        subcat_func.insert_SubCat(subcat_prop);
        request.setAttribute("subcat_detail",subcat_prop);
        request.setAttribute("msg","Data Saved");
        return mapping.findForward(SUCCESS);
        
    }
}
