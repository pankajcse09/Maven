/*
 * Item_Cart.java
 *
 * Created on July 29, 2013, 1:55 PM
 */

package ActionClass;

import Main_category.item_bean;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author kapil
 * @version
 */

public class Item_Cart extends Action {
    
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
        ArrayList detail =new ArrayList();
         HttpSession session=request.getSession(false);
         ArrayList cart_list= new ArrayList();
         String username="";
         if(session.getAttribute("loginid")!=null)
         {
             username=(String)session.getAttribute("loginid");
         }
         out.println(username);
        int id=0;
        int quan=0;
         item_bean ad=new item_bean();
        id=Integer.parseInt((String)request.getParameter("itemid"));
        quan=Integer.parseInt((String)request.getParameter("quan"));
        
        function_int_foodmart fd=new function_int_foodmart();
        //detail=(ArrayList)fd.discount_item_detail(id);
        
        
        int scid=0;
        int itemid=0;
        double price=0.0;
        int quantity=0;
        double total=0.0;
        double promo_value=0.0;
     
        String filename="";
        String size="";
        String prod_id="";
        String promo_code="";
        String brand="";
        
        if(detail.size()!=0)
        {
            ad=(item_bean)detail.get(0);
            ad.setQuantity(quan);
            ad.setSize(ad.getUnit());
            ad.setUsername(username);
        }
        
            if((ArrayList)session.getAttribute("cart_list")!=null)
            {
                 
            cart_list=(ArrayList)session.getAttribute("cart_list");
            
            }
             
            if(username.equals("guest"))
            {
              
            ad.setTotal(ad.getPrice()*quan);
       ad.setSubtotal(ad.getPrice()*quan);
        ad.setCart_id(cart_list.size()+1);
        
       
        LoginDataObject lb=new LoginDataObject();
       JavaBean1 jb=new JavaBean1();
       
     // function_int_foodmart fu=new function_int_foodmart(); 
       // fu.create_temp_cart(be);
        
     //  jb=(JavaBean1)lb.detail_Address(username);
        cart_list.add(ad);
       session.setAttribute("cart_list",cart_list);
         request.setAttribute("addressdetail",jb);
         request.setAttribute("promo_value",Double.toString(promo_value));
         request.setAttribute("promo_code",promo_code);

            }else{
            
            
       ad.setTotal(ad.getPrice()*quan);
        function_int_foodmart fu=new function_int_foodmart(); 
        fu.create_cart(ad);
        LoginDataObject lb=new LoginDataObject();
       JavaBean1 jb=new JavaBean1();
       jb=(JavaBean1)lb.detail_Address(username);
        cart_list=(ArrayList)fu.get_cart_despatch(username);
        session.setAttribute("reg_user_cart_list",cart_list);
       request.setAttribute("cart_list",cart_list);
         request.setAttribute("addressdetail",jb);
         request.setAttribute("promo_value",Double.toString(promo_value));
         request.setAttribute("promo_code",promo_code);

            }
        
         
         
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    
        
    }
}
