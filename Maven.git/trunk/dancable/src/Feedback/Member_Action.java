/*
 * Member_Action.java
 *
 * Created on February 16, 2011, 4:01 PM
 */

package Feedback;
import com.myapp.struts.Im_ResumeUtilty;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author intelmind
 * @version
 */

public class Member_Action extends Action {
    
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
         PrintWriter out=response.getWriter();
         Member_ActionForm fed=( Member_ActionForm)form;
         feedbean fdbean=new feedbean();
    
  
          fdbean.setDob(fed.getDob());
         fdbean.setName(fed.getName());
        fdbean.setAddress(fed.getAddress());
        fdbean.setContactno(fed.getContactno());
        fdbean.setEmailid(fed.getEmailid());
        fdbean.setSub(fed.getSub());
    
        

       Im_ResumeUtilty dd=new Im_ResumeUtilty();
        boolean tr= dd.memberform_db(fdbean);
  
     request.setAttribute("msg","Your Details are saved Successfully!");
        return mapping.findForward(SUCCESS);
        
    }
}
