/*
 * View_user_order.java
 *
 * Created on May 26, 2010, 12:10 PM
 */

package ActionClass;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

public class All_order extends Action {
    
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
       
JavaBean1 uid= new JavaBean1();
ArrayList profile_list=new ArrayList();
LoginDataObject ld= new LoginDataObject();
String name="";
String loginid="";
String id="";
//profile_list=ld.select_Profile();

 PrintWriter out=response.getWriter(); 
         String p="";
         p=(String)request.getParameter("pr");
         HashMap hm=new HashMap();
         boolean bn=false;
            String dates="";
         java.util.Date now = new java.util.Date();
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         dates=sdf.format(now);
         hm=(HashMap)ld._login(p,now); 
         request.setAttribute("hmap",hm);   
         request.setAttribute("today",dates);  
         out.println(hm);
        // return mapping.findForward("");


 return mapping.findForward(SUCCESS);
        
    }
}
