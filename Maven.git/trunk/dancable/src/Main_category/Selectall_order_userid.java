/*
 * Select_order_userid.java
 *
 * Created on May 28, 2010, 12:58 PM
 */

package Main_category;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author arjun
 * @version
 */

public class Selectall_order_userid extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
   
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         String order_id="";
         function_int_foodmart fu=new function_int_foodmart(); 
        String userid=(String)request.getParameter("userid");
        order_id=(String)request.getParameter("odid");
        ArrayList cart_list=new ArrayList();
        item_bean itmbe=new item_bean();
         String dates="";
        java.util.Date now = new java.util.Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
           dates=sdf.format(now);
           
         itmbe=(item_bean)fu.all_get_cart_ID(userid,now,order_id);
//         request.setAttribute("cart_list",cart_list);
          request.setAttribute("item_list",itmbe);
         request.setAttribute("userid",userid);
        
        
        
        return mapping.findForward(SUCCESS);
        
    }
}
