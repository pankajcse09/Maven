/*
 * Reg_Confirm.java
 *
 * Created on November 10, 2008, 4:10 PM
 */

package ActionClass;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import ActionClass.LoginDataObject;
/**
 *
 * @author arjun
 * @version
 */

public class Reg_Confirm extends Action {
    
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
        ArrayList loginlist=new ArrayList();

   LoginDataObject up=new  LoginDataObject();
   String uid=(String)request.getParameter("requid");
   loginlist=(ArrayList)up.select_Userid();           
request.setAttribute("loginlist",loginlist);
   out.println(uid);
   up.reg_update(uid);       
  return mapping.findForward(SUCCESS);
        
    }
}
