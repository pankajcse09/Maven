/*
 * Edit_item.java
 *
 * Created on June 9, 2010, 12:21 PM
 */

package Main_category;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mc_bean.mc_prop;
import mc_operat.Mc_funct;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
/**
 *
 * @author arjun
 * @version
 */

public class Edit_item extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
  
    public ActionForward Edit_item(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {        
        PrintWriter out=response.getWriter();
         int   itemid=0;
       itemid=Integer.parseInt((String)request.getParameter("item_id"));
//       out.println("itemid"+itemid);
        ArrayList itemlist=new ArrayList();
        Mc_funct mc=new Mc_funct();
        mc_prop item=new mc_prop();
       item=(mc_prop)mc.item_detail(itemid);
//       out.println(item);
       request.setAttribute("item",item);
      
        return mapping.findForward(SUCCESS);
        
    }

public ActionForward save_update_item(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {        
        PrintWriter out=response.getWriter();
         int   itemid=0;
         String brand="";
         String prodid="";
        String size="";
  
     String detail="";
      double marketprice=0.0;
       double discount=0.0;
        
         String discountdetail="";
          
      String unit="";
          String status="";
          
          
 String filename="";
 String rel_items="";
  
  
  
    String cond="";
  String cond1="";
  double price=0.0;
       itemid=Integer.parseInt((String)request.getParameter("itemid"));
      brand=(String)request.getParameter("brand");
      size=(String)request.getParameter("size");
      status=(String)request.getParameter("status");
       unit=(String)request.getParameter("unit");
        discountdetail=(String)request.getParameter("discountdetail");
        detail=(String)request.getParameter("detail");    
     prodid=(String)request.getParameter("prodid");
       rel_items=(String)request.getParameter("related_items");
     
            marketprice=Double.parseDouble((String)request.getParameter("marketprice"));
            discount=Double.parseDouble((String)request.getParameter("discount"));      
            price=Double.parseDouble((String)request.getParameter("price"));
      
       
//         out.println("itemid"+itemid);
        ArrayList itemlist=new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();
        
         item_bean be=new item_bean();
         be.setStatus(status);
         be.setBrand(brand);    
         be.setSize(size);
         be.setUnit(unit);
        be.setMarketprice(marketprice);
         be.setDiscount(discount);
           be.setDiscountdetail(discountdetail);
        be.setPrice(price);
          be.setDetail(detail);
        be.setProd_id(prodid);
        be.setItem_id(itemid);
        be.setRelated_items(rel_items);
           
        fd.update_item_details(be);
        mc_prop item=new mc_prop();
        Mc_funct mc=new Mc_funct();
        item=(mc_prop)mc.item_detail(itemid);
//       out.println(item);
       request.setAttribute("item",item);
        
        request.setAttribute("msg", "Item is updated.");
        return mapping.findForward(SUCCESS);
        
    }


}
