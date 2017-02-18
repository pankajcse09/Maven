/*
 * getItemImage.java
 *
 * Created on October 26, 2012, 5:20 PM
 */

package Main_category;

import com.myapp.struts.Im_Proj_DataUtility;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author user
 * @version
 */

public class getItemImage extends Action {
    
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
        ArrayList images=new ArrayList();
        int id=0;
        try {
            
            id=Integer.parseInt((String)request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        
        String filename="";
        Im_Proj_DataUtility im=new Im_Proj_DataUtility();
//        images=(ArrayList)im.gal_ItemImage(id);
        filename=(String)im.gal_Itemfilename(id);
         request.setAttribute("filename",filename);
        request.setAttribute("images",images);
        return mapping.findForward(SUCCESS);
        
    }
}
