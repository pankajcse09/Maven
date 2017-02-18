/*
 * Get_Item_DispatchAction.java
 *
 * Created on May 19, 2010, 11:07 AM
 */

package moreimg;

import ActionClass.JavaBean1;
import ActionClass.LoginDataObject;
import Main_category.CountryBean;
import Main_category.item_bean;
import com.paypal.platform.sdk.core.CallerServices;
import com.paypal.sdk.profiles.APIProfile;
import com.paypal.sdk.profiles.ProfileFactory;
import com.paypal.sdk.services.NVPCallerServices;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.net.URL;


import java.util.*;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mc_bean.mc_prop;
import mc_operat.Mc_funct;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

/**
 *
 * @author arjun
 * @version
 */

public class Get_Item_DispatchAction extends DispatchAction {
    
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
    
   public ActionForward ourproduct(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String page_name="";
        
  
        PrintWriter out=response.getWriter();
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content("ourproduct");      
        
        request.setAttribute("homelist",homelist);
     
       
        return mapping.findForward("ourproduct");
    
        
    } 
     
      public ActionForward chkOut(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String page_name="";
        
  
        PrintWriter out=response.getWriter();
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content("ourproduct");      
        
        request.setAttribute("homelist",homelist);
     
       
        return mapping.findForward("chkout");
    
        
    } 
     
     
     
    public ActionForward get_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int sc_id=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
        try {
       
            sc_id=Integer.parseInt((String)request.getParameter("subcat_id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         
        item_bean be=new item_bean();
        function_int_foodmart fu=new function_int_foodmart(); 
        itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
        out.println(itemlist);
        
        request.setAttribute("itemlist",itemlist);
        return mapping.findForward(SUCCESS);
        
    }
    
    
    
public ActionForward view_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            HttpSession session =request.getSession();
            if(session.getAttribute("loginid")==null){
            session.setAttribute("loginid","guest");
        session.setAttribute("password","guest");
   }
         
        int sc_id=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
         String para="";
         
         para=request.getParameter("pa");
         String mc="";
         String sc="";
          mc_prop cat=new mc_prop();
          mc_prop cata=new mc_prop();
          
          Mc_funct func=new Mc_funct(); 
        try {
       
            sc_id=Integer.parseInt((String)request.getParameter("id"));
            String scid = request.getParameter("id");
            session.setAttribute("scid",scid); 
        } catch (NumberFormatException ex) {
            System.out.println("Redirect: An exception occured for cd and dvd here due to the changes made in the url on browser. URL is redirected to home page.");
            RequestDispatcher rd1=request.getRequestDispatcher("/fm_home.do?name=home"); 
                 rd1.forward(request,response); 
//            ex.printStackTrace();
        }
          
          String nav="";
          
         if(para.equalsIgnoreCase("b"))
         {
         cat=(mc_prop)func.sel_cat_id(sc_id);
         
         cata=(mc_prop)func.sel_catsubcat_nav(cat.getC_id(),sc_id);
         nav=cata.getCat()+"/"+cata.getSub_cat();
         }
          
            if(para.equalsIgnoreCase("a"))
         {
         cat=(mc_prop)func.sel_cat_id(sc_id);
         
         cata=(mc_prop)func.sel_cat_nav(cat.getC_id());
         nav=cata.getCat();
         }
         
         
          String p=request.getParameter("pr");            
         HashMap hm=new HashMap();  
         
        hm=(HashMap)func.get_Item_PageWise(p,sc_id);
        request.setAttribute("hmap",hm); 
        
        request.setAttribute("nav",nav); 
//        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        
         request.setAttribute("currentpage",new Integer(p).toString());
         request.setAttribute("id",new Integer(sc_id).toString());
         request.setAttribute("pa",para);
         
        // return mapping.findForward("");
       return mapping.findForward("viewitem");
        
    }
       
public ActionForward view_Item_Detail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession session =request.getSession();
            if(session.getAttribute("loginid")==null){
            session.setAttribute("loginid","guest");
        session.setAttribute("password","guest");
   }
         
        int sc_id=0;
        int sc_id1=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
         String para="";
         
         para=request.getParameter("pa");
         String mc="";
         String sc="";
          mc_prop cat=new mc_prop();
          mc_prop cata=new mc_prop();
          
          Mc_funct func=new Mc_funct(); 
        try {
            if(request.getParameter("id")!=null){
            sc_id=Integer.parseInt((String)request.getParameter("id"));
            String scid = request.getParameter("id");
            session.setAttribute("scid",scid);
            }
            if(request.getParameter("id1")!=null){
            sc_id1=Integer.parseInt((String)request.getParameter("id1"));
            }
        } catch (NumberFormatException ex) {
            System.out.println("Redirect: An exception occured for printed music page here due to the changes made in the url on browser. URL is redirected to home page.");
            RequestDispatcher rd1=request.getRequestDispatcher("/fm_home.do?name=home"); 
                 rd1.forward(request,response); 
            ex.printStackTrace();
        }
          
          String nav="";
          
         if(para.equalsIgnoreCase("b"))
         {
         cat=(mc_prop)func.sel_cat_id(sc_id);
         
         cata=(mc_prop)func.sel_catsubcat_nav(cat.getC_id(),sc_id);
         nav=cata.getCat()+"/"+cata.getSub_cat();
         }
          
            if(para.equalsIgnoreCase("a"))
         {
         cat=(mc_prop)func.sel_cat_id(sc_id);
         
         cata=(mc_prop)func.sel_cat_nav(cat.getC_id());
         nav=cata.getCat();
         }
         
         
          String p=request.getParameter("pr"); 
          String p1=request.getParameter("pr1"); 
         HashMap hm=new HashMap(); 
         HashMap hm1=new HashMap();
         
         if(sc_id!=0){
        hm=(HashMap)func.get_Item_Page_Wise(p,sc_id);
         }
         if(sc_id1!=0){
        hm1=(HashMap)func.get_Item_Page_Wise(p1,sc_id1);
         }
        request.setAttribute("hmap",hm); 
        request.setAttribute("hmap1",hm1); 
        request.setAttribute("nav",nav); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        
         request.setAttribute("currentpage",new Integer(p).toString());
         request.setAttribute("id",new Integer(sc_id).toString());
         request.setAttribute("id1",new Integer(sc_id1).toString());
         request.setAttribute("pa",para);
         
        // return mapping.findForward("");
       return mapping.findForward("viewitem");
        
    }       
   
      
       
        public ActionForward Retail_Store_Detail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        int sc_id=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
         String para="";
         
         Mc_funct func=new Mc_funct(); 
        
          String p=request.getParameter("pr");            
         HashMap hm=new HashMap();  
         
        hm=(HashMap)func.get_Item_RetailStore(p);
        request.setAttribute("hmap",hm);  
        item_bean be=new item_bean();
      function_int_foodmart fu=new function_int_foodmart(); 
      itemlist=(ArrayList)fu.get_RetailStore_Desc();
        
      // out.println(itemlist);
        
        request.setAttribute("itemlist",itemlist);
        
        
          
        // return mapping.findForward("");
       return mapping.findForward("success");
        
    }
       
       
     public ActionForward Accessories_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        int sc_id=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
        try {
       
            sc_id=Integer.parseInt((String)request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
          String p=request.getParameter("pr");            
         HashMap hm=new HashMap();         
           
       
         Mc_funct func=new Mc_funct(); 
        hm=(HashMap)func.get_Item_PageWise(p,sc_id);
         request.setAttribute("hmap",hm); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        return mapping.findForward("viewitem");
        
    }
     
     
     public ActionForward Collection_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        int sc_id=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
        try {
       
            sc_id=Integer.parseInt((String)request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
          String p=request.getParameter("pr");            
         HashMap hm=new HashMap();         
           
       
         Mc_funct func=new Mc_funct(); 
        hm=(HashMap)func.get_Item_PageWise(p,sc_id);
         request.setAttribute("hmap",hm); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        return mapping.findForward("viewitem");
        
    }
     
     
      public ActionForward Boys_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        String pr="";
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
      
       
            pr=(String)request.getParameter("pr");
       
                    
         HashMap hm=new HashMap();                     
         Mc_funct func=new Mc_funct(); 
        hm=(HashMap)func.get_Item_Boy_PageWise(pr);
         request.setAttribute("hmap",hm); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        return mapping.findForward("viewitem");
        
    }
    
   
      
        public ActionForward Women_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        String pr="";
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
      
       
            pr=(String)request.getParameter("pr");
       
                    
         HashMap hm=new HashMap();                     
         Mc_funct func=new Mc_funct(); 
        hm=(HashMap)func.get_Item_Women_PageWise(pr);
         request.setAttribute("hmap",hm); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        return mapping.findForward("viewitem");
        
    }
    
    public ActionForward Accessories_Boys_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        String pr="";
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
      
       
            pr=(String)request.getParameter("pr");
       
                    
         HashMap hm=new HashMap();                     
         Mc_funct func=new Mc_funct(); 
        hm=(HashMap)func.get_Accessories_Men_PageWise(pr);
         request.setAttribute("hmap",hm); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        return mapping.findForward("viewitem");
        
    }
    
   
      
        public ActionForward Accessories_Women_ItemDetail(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        String pr="";
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
      
       
            pr=(String)request.getParameter("pr");
       
                    
         HashMap hm=new HashMap();                     
         Mc_funct func=new Mc_funct(); 
        hm=(HashMap)func.get_Accessories_Women_PageWise(pr);
         request.setAttribute("hmap",hm); 
        item_bean be=new item_bean();
      //  function_int_foodmart fu=new function_int_foodmart(); 
      //  itemlist=(ArrayList)fu.get_Item_Desc(sc_id);
        
      //   out.println(itemlist);
        
       // request.setAttribute("itemlist",itemlist);
        return mapping.findForward("viewitem");
        
    }
    
      
     public ActionForward get_perItem(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int sc_id=0;
        int itemid=0;
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
         HttpSession session =request.getSession();
         String loginid="";
         String passwd="";
         int avail=0;
         if(session.getAttribute("loginid")==null){
            session.setAttribute("loginid","guest");
        session.setAttribute("password","guest");
   
         }else{
        loginid=(String)session.getAttribute("loginid");
       
   
         }
         
        try {
       
           itemid=Integer.parseInt((String)request.getParameter("itemid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         
        item_bean be=new item_bean();
        function_int_foodmart fu=new function_int_foodmart(); 
        String size="";
        itemlist=(ArrayList)fu.get_Item_Single(itemid);
        for(int k=0;k<itemlist.size();k++)
        {
        be=(item_bean)itemlist.get(k);
        size=be.getSize();
        avail=be.getAvailability();
        }
        
        out.println(size);
        int length = size.length();
        out.println(itemlist);      
         char s= size.charAt(0);      
      char e= size.charAt(length - 1);
      


 int starta=Character.getNumericValue(s); 
int enda=Character.getNumericValue(e); 
//out.println(starta);
//.println(enda);

        request.setAttribute("itemlist",itemlist);
        request.setAttribute("starta",starta);
        request.setAttribute("enda",enda);
        request.setAttribute("avail",Integer.toString(avail));
        
                
                
       // return mapping.findForward("");
        
        return mapping.findForward(SUCCESS);
        
    }
     
     public ActionForward create_cart(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int scid=0;
        int itemid=0;
        int quantity=0;
        double promo_value=0.0;
        String username="";
        String prod_id="";
        String promo_code="";
        String cat_price="";
        String cat="";
        HttpSession session=request.getSession(false);
        if(session.getAttribute("loginid")!=null){
            username= (String)session.getAttribute("loginid");
        }
        if(username.equals(""))
             {
                 String msg="Your Session is expired. Please either login again or contine shopping without login!!!";
                 try{
                session.invalidate();
            }catch(IllegalStateException e){}
            request.setAttribute("wish", "Session is expired. Please starts shopping again.");
            return mapping.findForward("expire");
          }
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
         ArrayList cart_list= new ArrayList();
        try {
       
            itemid=Integer.parseInt((String)request.getParameter("itemid"));
            //String ref = request.getParameter("refresh");
            cat_price =  request.getParameter("cat_price");
            session.setAttribute("cat_price",cat_price);
            cat = request.getParameter("cat");
            String sessionCat="";
            if(session.getAttribute("cat")!=null){
                sessionCat=(String)session.getAttribute("cat");
            }
            if(!sessionCat.equalsIgnoreCase("shipping request"))
                session.setAttribute("cat",cat);
            //System.out.println(cat);
            scid=Integer.parseInt((String)request.getParameter("scid"));
            quantity=Integer.parseInt((String)request.getParameter("quantity"));
            prod_id=(String)request.getParameter("prod_id");
           promo_code=(String)request.getParameter("promo_code");
           //brand=URIUtil.decode(brand);
        } catch (NumberFormatException ex) {
            System.out.println("Redirect: An exception occured in creating cart because of direct pasting url on browser. URL is redirected to login page.");
            RequestDispatcher rd1=request.getRequestDispatcher("/myaccount.do"); 
                 rd1.forward(request,response); 
//            ex.printStackTrace();
        }

         function_int_foodmart fif=new function_int_foodmart();    
             if(session.getAttribute("promo_val")==null){
        if(promo_code!=null&&promo_code!=""){
           
          promo_value=fif.get_promo_rate(promo_code);
            session.setAttribute("promo_val", Double.toString(promo_value));
            session.setAttribute("promo_c", promo_code);
        }
             }

  ArrayList shplist=fif.retCountryShpCharge();
request.setAttribute("shplist",shplist);       
          
             //HttpSession session=request.getSession(false);
             
            if((ArrayList)session.getAttribute("cart_list")!=null)
            {
                 
            cart_list=(ArrayList)session.getAttribute("cart_list");
            
            }
            
           
        item_bean ad=fif.discount_item_detail(itemid,cat_price); 
        if(ad.getSubcat_id()==0){
            request.setAttribute("vc", "No product found for the id- "+itemid);
            return mapping.findForward("notexist");
        }
        if(username.equals("guest")){
            item_bean be=new item_bean();
            be.setItem_id(itemid);
            be.setSubcat_id(ad.getSubcat_id());
            be.setPrice(ad.getPrice());
            be.setQuantity(quantity);
            be.setSubtotal(be.getPrice()*quantity);
            be.setTotal(be.getPrice()*quantity);
            be.setUsername(username);
            be.setFilename(ad.getFilename());
            be.setSize(ad.getSize());
            be.setCart_id(cart_list.size()+1);
            be.setProd_id(ad.getProd_id());
            be.setBrand(ad.getBrand());
            be.setCat_id(ad.getCat_id());
            LoginDataObject lb=new LoginDataObject();
            JavaBean1 jb=new JavaBean1();
       
     //     function_int_foodmart fu=new function_int_foodmart(); 
       //   fu.create_temp_cart(be);
        
     //     jb=(JavaBean1)lb.detail_Address(username);
            cart_list.add(be);
            session.setAttribute("cart_list",cart_list);
            request.setAttribute("addressdetail",jb);
            request.setAttribute("promo_value",Double.toString(promo_value));
            request.setAttribute("promo_code",promo_code);
        }
        else{
            item_bean be=new item_bean();
            be.setItem_id(itemid);
            be.setSubcat_id(ad.getSubcat_id());
            be.setPrice(ad.getPrice());
            be.setQuantity(quantity);
            be.setSubtotal(be.getPrice()*quantity);
            be.setTotal(be.getPrice()*quantity);
            be.setUsername(username);
            be.setFilename(ad.getFilename());
            be.setSize(ad.getSize());
            be.setProd_id(ad.getProd_id());
            be.setBrand(ad.getBrand());
            be.setCat_id(ad.getCat_id());
            function_int_foodmart fu=new function_int_foodmart(); 
            fu.create_cart(be);
            fu.remove_item_from_wishlist(username,itemid);
            LoginDataObject lb=new LoginDataObject();
            JavaBean1 jb=new JavaBean1();
            jb=(JavaBean1)lb.detail_Address(username);
            cart_list=(ArrayList)fu.get_cart_despatch(username);
//          session.setAttribute("reg_user_cart_list",cart_list);
            request.setAttribute("cart_list",cart_list);
            request.setAttribute("addressdetail",jb);
            request.setAttribute("promo_value",Double.toString(promo_value));
            request.setAttribute("promo_code",promo_code);
        }
              
        String shpStatus=fif.retCatShipChargeStatus(cart_list);
        request.setAttribute("shpStatus",shpStatus);
        //return mapping.findForward("");
     return mapping.findForward(SUCCESS);
        
    }
     

public ActionForward checkout_cart(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        double promo_value=0.0;
        
       String promo_code="";
        HttpSession session=request.getSession(false);
        String username= "";
        if(session.getAttribute("loginid")!=null){
            username= (String)session.getAttribute("loginid");
        }
        if(username.equals(""))
        {
            String msg="Your Session is expired. Please either login again or contine shopping without login!!!";
            try{
                session.invalidate();
            }catch(IllegalStateException e){}
            request.setAttribute("wish", msg);
         return mapping.findForward("expire");
        }
        
         PrintWriter out=response.getWriter();
         ArrayList itemlist=new ArrayList();
         ArrayList cart_list=new ArrayList();
      
        
        
            function_int_foodmart fif=new function_int_foodmart();  
             if(session.getAttribute("promo_val")==null){
                if(promo_code!=null&&promo_code!=""){
                    promo_value=fif.get_promo_rate(promo_code);
                    session.setAttribute("promo_val", Double.toString(promo_value));
                    session.setAttribute("promo_c", promo_code);
                }
             }
            ArrayList shplist=fif.retCountryShpCharge();
//          System.out.println("shplist:" +shplist.size());
            request.setAttribute("shplist",shplist);             
        
          if((ArrayList)session.getAttribute("cart_list")!=null)
            {
                cart_list=(ArrayList)session.getAttribute("cart_list");
            }
//        
            if(username.equals("guest"))
            {
                item_bean be=new item_bean();
                be.setUsername(username);
                LoginDataObject lb=new LoginDataObject();
                JavaBean1 jb=new JavaBean1();
       
                session.setAttribute("cart_list",cart_list);
                request.setAttribute("addressdetail",jb);
                request.setAttribute("promo_value",Double.toString(promo_value));
                request.setAttribute("promo_code",promo_code);
            }            
            else{       
                LoginDataObject lb=new LoginDataObject();
                JavaBean1 jb=new JavaBean1();
                jb=(JavaBean1)lb.detail_Address(username);
                cart_list=(ArrayList)fif.get_cart_despatch(username);
//              session.setAttribute("reg_user_cart_list",cart_list);
        
                request.setAttribute("cart_list",cart_list);
                request.setAttribute("addressdetail",jb);
                request.setAttribute("promo_value",Double.toString(promo_value));
                request.setAttribute("promo_code",promo_code);
            }
         String shpStatus=fif.retCatShipChargeStatus(cart_list);
         request.setAttribute("shpStatus",shpStatus);
//        return mapping.findForward("");
     return mapping.findForward(SUCCESS);
        
    }     
      
      
//       public ActionForward shop_cart(ActionMapping mapping, ActionForm  form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        int scid=0;
//        int itemid=0;
//        double price=0.0;
//        int quantity=0;
//        double total=0.0;
//        String username="";
//        String filename="";
//        String size="";
//        String prod_id="";
//        
//        
//         PrintWriter out=response.getWriter();
//         ArrayList itemlist=new ArrayList();
//         ArrayList cart_list= new ArrayList();
//       
//         
//          HttpSession session =request.getSession();
//           if(session.getAttribute("loginid")==null){
//            session.setAttribute("loginid","guest");
//        session.setAttribute("password","guest");
//        username=(String)session.getAttribute("loginid");
//       
//   
//         }else{
//        username=(String)session.getAttribute("loginid");
//       
//   
//         }
//            if(username.equals("guest"))
//            {
//                item_bean be=new item_bean();
//       
//        function_int_foodmart fu=new function_int_foodmart(); 
//       JavaBean1 jb=new JavaBean1();
//        LoginDataObject lb=new LoginDataObject();       
//        cart_list=(ArrayList)fu.get_temp_cart_despatch(username);
//       request.setAttribute("cart_list",cart_list);
//         request.setAttribute("addressdetail",jb);
//            }else{
//            
//            
//        item_bean be=new item_bean();
//       
//        function_int_foodmart fu=new function_int_foodmart(); 
//        
//        LoginDataObject lb=new LoginDataObject();
//       JavaBean1 jb=new JavaBean1();
//       jb=(JavaBean1)lb.detail_Address(username);
//        cart_list=(ArrayList)fu.get_cart_despatch(username);
//       request.setAttribute("cart_list",cart_list);
//         request.setAttribute("addressdetail",jb);
//            }
//             
//        // out.println(jb.getHomeaddress());
//      // out.println("cart_list"+cart_list);
//       // return mapping.findForward("");
//     return mapping.findForward(SUCCESS);
//        
//    }
      
      
      
     public ActionForward placeOrder(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int scid=0;
        int itemid=0;
        double price=0.0;
        int quantity=0;
        double total=0.0;
        String username="";
        String filename="";        
        PrintWriter out=response.getWriter();
        ArrayList itemlist=new ArrayList();
        ArrayList cart_list= new ArrayList();
      
         Enumeration enu = request.getParameterNames();         
           ArrayList para_value=new ArrayList();
         HashMap par_name=new HashMap();
         ArrayList orderlist=new ArrayList();
         ArrayList homelist=new ArrayList();
         
       function_int_foodmart fd=new function_int_foodmart();
         
        homelist=(ArrayList)fd.select_content("ourproduct");      
        
      
     
       String values[] = request.getParameterValues("cartid");
                  if (values != null) 
                     {
                             for (int i = 0; i < values.length; i++) 
                          {
                              para_value.add(values[i]);
                              
                           }
                     }
 
        
        for(int j=0;j<para_value.size();j++)
        {
        
      orderlist.add(fd.take_order(Integer.parseInt(para_value.get(j).toString())));
        }
         
        
       for(int k=0;k<orderlist.size();k++)
       {
       fd.create_order((item_bean)orderlist.get(k));
       
       }
       
         request.setAttribute("homelist",homelist);
     
      return mapping.findForward(SUCCESS);
        
    }
     
      public ActionForward saveUpdateAct(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session=request.getSession(false);
        String page_name="";  
        String bb= (String)session.getAttribute("cat_price");
        PrintWriter out=response.getWriter();
        List ar1=new ArrayList();
        List ar2=new ArrayList();
        List ar3=new ArrayList();      
        System.out.println(bb);
        String username= "";
        if(session.getAttribute("loginid")!=null){
            username= (String)session.getAttribute("loginid");
        }
        if(username.equals("")){
            try{
                session.invalidate();
            }catch(IllegalStateException e){}
            request.setAttribute("wish", "Session is expired. Please starts shopping again.");
         return mapping.findForward("expire");
        }
        Enumeration en=(Enumeration)request.getParameterNames();     
        ArrayList cart_list=new ArrayList();
        
        int k=0;
        while(en.hasMoreElements()){
          try{  String pname=(String)en.nextElement();
            System.out.println("Pname: "+pname);
            if(pname.substring(0,5).equals("itemi")){
                ar1.add(request.getParameter("itemid"+k));
                ar2.add(request.getParameter("cartid"+k));    
                ar3.add(request.getParameter("quantity"+k));  
                k++;
            }
            }catch(Exception e){e.getMessage();}
        }
        
//      System.out.println("Username: "+username);
        function_int_foodmart fd=new function_int_foodmart();
        if(username.equals("guest"))
        {
            if((ArrayList)session.getAttribute("cart_list")!=null)
            {
              cart_list=(ArrayList)session.getAttribute("cart_list");
            }
            try{
                int itmid=0;
            for(int j=0;j<cart_list.size();j++){
                itmid=Integer.parseInt(ar1.get(j).toString());
                item_bean ad=fd.discount_item_detail(itmid,bb); 
                System.out.println(ad);
                if(ad.getSubcat_id()==0){
                    request.setAttribute("vc", "No product found for the id- "+itmid);
                    return mapping.findForward("notexist");
                }
                item_bean be=(item_bean)cart_list.get(j);
                be.setQuantity(Integer.parseInt(ar3.get(j).toString()));
                be.setSubtotal(be.getQuantity()*ad.getPrice());
                
//                be=(item_bean)cart_list.get(j);
                session.setAttribute("cart_list",cart_list);
            }
            }catch(Exception e){} 
        }
        else if(!username.equals("guest")&&!username.equals(""))
        {
            int bn=fd.saveUpData(ar2,ar3); 
            cart_list=(ArrayList)fd.get_cart_despatch(username);
            request.setAttribute("cart_list",cart_list);
            LoginDataObject lb=new LoginDataObject();
            JavaBean1 jb=new JavaBean1();
            jb=(JavaBean1)lb.detail_Address(username);
            request.setAttribute("addressdetail",jb);
        }
        
         String shpStatus=fd.retCatShipChargeStatus(cart_list);
         request.setAttribute("shpStatus",shpStatus);     
    return mapping.findForward("success");
  } 
     


    public ActionForward gotoReview(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession session=request.getSession(false);
        String username= "";
        if(session.getAttribute("loginid")!=null){
            username= (String)session.getAttribute("loginid");
        }
        if(username.equals("")){
            try{
                session.invalidate();
            }catch(IllegalStateException e){}
            request.setAttribute("wish", "Session is expired. Please starts shopping again.");
         return mapping.findForward("expire");
        }
         function_int_foodmart fd=new function_int_foodmart();
        String kind="";
        String shpwhr="";
        String page_name="";  
          
      String ship_f_name="";
  String ship_l_name="";
   String ship_street="";
   String ship_city="";
   String ship_state="";
   String ship_zip="";
   String ship_country="";
  String ship_phone="";
   String ship_a_phone="";
   String ship_method="";
  
   String bill_f_name="";
   String bill_l_name="";
   String bill_street="";
   String bill_city="";
   String bill_state="";
   String bill_zip="";
   String bill_country="";
   String bill_phone="";
   String bill_a_phone="";
   String bill_method="";
   String aa= "";
   if(request.getParameter("kinds")!=null)
   {
       kind=(String)request.getParameter("kinds");
   }
   if(request.getParameter("shpwhr")!=null)
   {
       shpwhr=(String)request.getParameter("shpwhr");
   }
   if(!kind.equals("download request")&&!kind.equals("shipping request"))
   {
       RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
       request.setAttribute("msg", "Error in sending values.");
                 rd1.forward(request,response); 
   }
   if(!shpwhr.equals("domastic")&&!shpwhr.equals("international"))
   {
       RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
       request.setAttribute("msg", "Error in sending values.");
                 rd1.forward(request,response); 
   }
   
  item_bean ship_bill=new item_bean();
  double shipping_charge=0.0;
  List ar1=new ArrayList();
  List ar2=new ArrayList();
  List ar3=new ArrayList();
  item_bean ad,be;
  Enumeration en=(Enumeration)request.getParameterNames();     
        ArrayList cart_list=new ArrayList();
        int k=0;
        while(en.hasMoreElements()){
         String pname=(String)en.nextElement();
//         System.out.println(pname);
         if(pname.substring(0,1).equals("itemi")){
            ar1.add(request.getParameter("itemid"+k));
            ar2.add(request.getParameter("cartid"+k));    
            ar3.add(request.getParameter("quantity"+k));  
            k++;
         }
        }

        if(username.equals("guest"))
        {
            if((ArrayList)session.getAttribute("cart_list")!=null)
            {
              cart_list=(ArrayList)session.getAttribute("cart_list");
            }
            try{
                int itmid=0;
                for(int j=0;j<cart_list.size();j++){
                    itmid=Integer.parseInt(ar1.get(j).toString());
                    ad=fd.discount_item_detail(itmid,aa); 
                    if(ad.getSubcat_id()==0){
                        request.setAttribute("vc", "No product found for the id- "+itmid);
                        return mapping.findForward("notexist");
                    }
                    be=(item_bean)cart_list.get(j);
                    be.setQuantity(Integer.parseInt(ar3.get(j).toString()));
                    be.setSubtotal(be.getQuantity()*ad.getPrice());
                    
//                  be=(item_bean)cart_list.get(j);
                    session.setAttribute("cart_list",cart_list);
                }
            }catch(Exception e){} 
        }
        else if(!username.equals("guest")&&!username.equals(""))
        {
            int bn=fd.saveUpData(ar2,ar3); 
            cart_list=(ArrayList)fd.get_cart_despatch(username);            
            session.setAttribute("reg_user_cart_list",cart_list);
            request.setAttribute("cart_list",cart_list);            
        }
  CountryBean cb=null;
    if(!kind.equals("download request")){
       ship_f_name=(String)request.getParameter("ship_f_name");  
     ship_l_name=(String)request.getParameter("ship_l_name");  
    ship_street=(String)request.getParameter("ship_street");  
    ship_city=(String)request.getParameter("ship_city");  
    ship_state=(String)request.getParameter("ship_state");  
    ship_zip=(String)request.getParameter("ship_zip");  
    ship_country=(String)request.getParameter("ship_country");  
   ship_phone=(String)request.getParameter("ship_phone");  
    ship_a_phone=(String)request.getParameter("ship_a_phone");  
    ship_method=(String)request.getParameter("ship_method");  
    
    ship_bill.setShip_f_name(ship_f_name);
    ship_bill.setShip_l_name(ship_l_name);
    ship_bill.setShip_street(ship_street);
    ship_bill.setShip_city(ship_city);
    
    ship_bill.setShip_zip(ship_zip);
    
    ship_bill.setShip_phone(ship_phone);
    ship_bill.setShip_a_phone(ship_a_phone);
    ship_bill.setShip_method(ship_method);
    
    
    int countryCode=-1;
    if(ship_country.equals("United States")||ship_country.equals("Canada")){
        ship_bill.setShip_country(ship_country);
    }
    else{
        try{
            countryCode=Integer.parseInt(ship_country);
            cb=fd.getShpChargeOfCountry(countryCode);
            ship_bill.setShip_country(cb.getCountry());
        }
        catch(Exception e){
            RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
            request.setAttribute("vc", "Please only select country from dropdown for shipping address. Dont not change in it.");
            rd1.forward(request,response); 
        }
    }
    
    try{
        ship_bill.setShip_state(fd.getStates(Integer.parseInt(ship_state)));
     }catch(Exception e){
        ship_bill.setShip_state(ship_state);
    }
    
        if(ship_method==null)
         {
             RequestDispatcher rd1=request.getRequestDispatcher("/myaccount.do"); 
                 rd1.forward(request,response); 
         }

       String shpStatus=fd.retCatShipChargeStatus(cart_list); 
         if(cb!=null){
 // for Authorized            
             shipping_charge=cb.getShippingCharge();
             if(shipping_charge==0)
             {
                 RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
                 request.setAttribute("vc", "Please only select country from dropdown. Dont not change in it.");
                 rd1.forward(request,response); 
             }
         }
         else if(shpStatus.equals("yes")){
             ship_method="flatzone:USPS Media Mail";
            shipping_charge=5.00;
         }
//         else if(ship_method.equals("shipprod:Worldwide")){
//             shipping_charge=18.45;
//         }
         else if(shpStatus.equals("no")){
            ship_method="sortship:Free Ground Shipping"; 
            shipping_charge=0.00;
         }
//         else{
//             ship_method="flatzone:USPS Media Mail";
//             shipping_charge=5.00;
//         }
         request.setAttribute("shp_req", "yes");
    }
    else if(kind.equals("download request")){
        String shpStatus=fd.retCatShipChargeStatus(cart_list);
//        System.out.println("shpStatus: "+shpStatus);
        if(shpStatus.equals("yes")){
            ship_method=(String)request.getParameter("ship_method");
        if(shpwhr.equals("international")){
            bill_country=(String)request.getParameter("bill_country");  
            cb=fd.getShpChargeOfCountry(Integer.parseInt(bill_country));
            shipping_charge=cb.getShippingCharge();
             if(shipping_charge==0)
             {
                 RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
                 request.setAttribute("vc", "Please only select country from dropdown. Dont not change in it.");
                 rd1.forward(request,response); 
             }
             request.setAttribute("shp_req", "yes");
        }
        else if(shpStatus.equals("yes")){
            ship_method="flatzone:USPS Media Mail";
             shipping_charge=5.00;
             request.setAttribute("shp_req", "yes");
         }
//         else if(ship_method.equals("shipprod:Worldwide")){
//             shipping_charge=18.45;
//         }
         else if(shpStatus.equals("no")){
             ship_method="sortship:Free Ground Shipping";
             shipping_charge=0.00;
             request.setAttribute("shp_req", "no");
         }
        ship_method="";
        }
        else{
            request.setAttribute("shp_req", "no");
        }
    }
     bill_f_name=(String)request.getParameter("bill_f_name");  
     bill_l_name=(String)request.getParameter("bill_l_name");  
    bill_street=(String)request.getParameter("bill_street");  
    bill_city=(String)request.getParameter("bill_city");  
    bill_state=(String)request.getParameter("bill_state");  
    bill_zip=(String)request.getParameter("bill_zip");  
    bill_country=(String)request.getParameter("bill_country");  
    bill_phone=(String)request.getParameter("bill_phone");  
    bill_a_phone=(String)request.getParameter("bill_a_phone");  
    //bill_method=(String)request.getParameter("bill_method");  
    
    
    int countryCode=-1;
    if(bill_country.equals("United States")||bill_country.equals("Canada")){
        ship_bill.setBill_country(bill_country);
    }
    else{
        try{
            countryCode=Integer.parseInt(bill_country);
            cb=fd.getShpChargeOfCountry(countryCode);
            ship_bill.setBill_country(cb.getCountryCode());
            ship_bill.setBill_country2(cb.getCountry());
        }
        catch(Exception e){
            RequestDispatcher rd1=request.getRequestDispatcher("/er.do"); 
            request.setAttribute("vc", "Please only select country from dropdown for billing address. Dont not change in it.");
            rd1.forward(request,response); 
        }
    }
    ship_bill.setBill_f_name(bill_f_name);
    ship_bill.setBill_l_name(bill_l_name);
    ship_bill.setBill_street(bill_street);
    ship_bill.setBill_city(bill_city);
    
    try{
        ship_bill.setBill_state(fd.getStates(Integer.parseInt(bill_state)));
    }catch(Exception e){
        ship_bill.setBill_state("52");
        ship_bill.setBill_state2(bill_state);
    }
    
    ship_bill.setBill_zip(bill_zip);
    ship_bill.setBill_phone(bill_phone);
    ship_bill.setBill_a_phone(bill_a_phone);
    ship_bill.setBill_method(ship_method);
    
    ship_bill.setKind(kind);
    ship_bill.setShipmentTo(shpwhr);
    
//    session.setAttribute("kindOfPurchase", kind);
    
        session.setAttribute("shipping_charge", shipping_charge);
        session.setAttribute("user_address", ship_bill);
        request.setAttribute("ship_bill",ship_bill);
        request.setAttribute("ar2",ar2);
        request.setAttribute("shipping_charge", Double.toString(shipping_charge));
      
//         return mapping.findForward("");
    
   return mapping.findForward("success");
  } 
     

 public ActionForward ExpressCheckout(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     

    //PrintWriter out=response.getWriter();
    // PaymentActionCodeType paymentAction = PaymentActionCodeType.Sale;

        NVPCallerServices caller = new NVPCallerServices();
        APIProfile profile = ProfileFactory.createSignatureAPIProfile();
	profile.setAPIUsername("arjuns_1355991663_biz@gmail.com");
	profile.setAPIPassword("seller123");
	profile.setSignature("AuyqreR3.dLoui1im852szQ9zTkHAMM1EtyHK76wlFt5kBlGLLfBs0Zy");
	profile.setEnvironment("sandbox");
        
	caller.setAPIProfile(profile);
       // NVPCodec encoder = new NVPCodec();
         //PaymentActionCodeType paymentAction = PaymentActionCodeType.Sale;
           //out.println(caller);
        //String token = setExpressCheckoutService.setExpressCheckout("arjuns_1355991663_biz@gmail.com","200.0","USD", "http://localhost:8080/alessio/paypalResponse.jsp","http://localhost:8080/alessio/paypalResponse.jsp");
			
        URL url = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_xclick");

        HttpsURLConnection uc = (HttpsURLConnection)url.openConnection();
      
       uc.setDoOutput(true);
		uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		PrintWriter pw = new PrintWriter(uc.getOutputStream());
		//pw.println(str);
		pw.close();

		//Read response
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String res = in.readLine();
		in.close();
                
       SetExpressCheckoutRequestType pprequest = new SetExpressCheckoutRequestType();
		pprequest.setVersion("63.0");
             
		
		SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

		
		
  return mapping.findForward("");
   //return mapping.findForward("success");
    
        
    } 
 
 
  public ActionForward removeShopitem(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession session=request.getSession(false);
       String username= "";
        if(session.getAttribute("loginid")!=null){
            username= (String)session.getAttribute("loginid");
        }
        if(username.equals("")){
            try{
                session.invalidate();
            }catch(IllegalStateException e){}
            request.setAttribute("wish", "Session is expired. Please starts shopping again.");
         return mapping.findForward("expire");
        }
       String page_name="";  
      String ship_f_name="";
  String ship_l_name="";
   String ship_street="";
   String ship_city="";
   String ship_state="";
   String ship_zip="";
   String ship_country="";
  String ship_phone="";
   String ship_a_phone="";
   String ship_method="";
  
   String bill_f_name="";
   String bill_l_name="";
   String bill_street="";
   String bill_city="";
   String bill_state="";
   String bill_zip="";
   String bill_country="";
   String bill_phone="";
   String bill_a_phone="";
   String bill_method="";
  item_bean ship_bill=new item_bean();
  item_bean itb=new item_bean();
  PrintWriter out=response.getWriter();
  int id=0;
        try {
            
            id=Integer.parseInt((String)request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
 // out.println(id);
    if ((String)request.getParameter("ship_f_name")!= "")
    {
       ship_f_name=(String)request.getParameter("ship_f_name");  
       
      
    }
  if ((String)request.getParameter("ship_l_name") != null)
    {
     ship_l_name=(String)request.getParameter("ship_l_name"); 
  }
  if ((String)request.getParameter("ship_street") != null)
    {
    ship_street=(String)request.getParameter("ship_street");  
  }
  if ((String)request.getParameter("ship_city") != null)
    {
    ship_city=(String)request.getParameter("ship_city"); 
  }
  if ((String)request.getParameter("ship_state") != null)
    {
    ship_state=(String)request.getParameter("ship_state");  
  }
   if ((String)request.getParameter("ship_zip") != null)
    { ship_zip=(String)request.getParameter("ship_zip");  
   }
   if ((String)request.getParameter("ship_country") != null)
    { ship_country=(String)request.getParameter("ship_country");  
   }
  if ((String)request.getParameter("ship_phone") != null)
    { ship_phone=(String)request.getParameter("ship_phone");  
      
  }
   if ((String)request.getParameter("ship_a_phone") != null)
    { ship_a_phone=(String)request.getParameter("ship_a_phone");  
   }
    if ((String)request.getParameter("ship_method") != null)
    {ship_method=(String)request.getParameter("ship_method");  
    }
     bill_f_name=(String)request.getParameter("bill_f_name");  
     bill_l_name=(String)request.getParameter("bill_l_name");  
    bill_street=(String)request.getParameter("bill_street");  
    bill_city=(String)request.getParameter("bill_city");  
    bill_state=(String)request.getParameter("bill_state");  
    bill_zip=(String)request.getParameter("bill_zip");  
    bill_country=(String)request.getParameter("bill_country");  
    bill_phone=(String)request.getParameter("bill_phone");  
    bill_a_phone=(String)request.getParameter("bill_a_phone");  
    bill_method=(String)request.getParameter("bill_method");  
    ship_bill.setShip_f_name(ship_f_name);
    
    ship_bill.setShip_l_name(ship_l_name);
    ship_bill.setShip_street(ship_street);
    ship_bill.setShip_city(ship_city);
    ship_bill.setShip_state(ship_state);
    ship_bill.setShip_zip(ship_zip);
    ship_bill.setShip_country(ship_country);
    ship_bill.setShip_phone(ship_phone);
    ship_bill.setShip_a_phone(ship_a_phone);
    ship_bill.setShip_method(ship_method);
    
    ship_bill.setBill_f_name(bill_f_name);
    ship_bill.setBill_l_name(bill_l_name);
    ship_bill.setBill_street(bill_street);
    ship_bill.setBill_city(bill_city);
    ship_bill.setBill_state(bill_state);
    ship_bill.setBill_zip(bill_zip);
    ship_bill.setBill_country(bill_country);
    ship_bill.setBill_phone(bill_phone);
    ship_bill.setBill_a_phone(bill_a_phone);
    ship_bill.setBill_method(ship_method);
    
        
        List ar1=new ArrayList();
        List ar2=new ArrayList();
        Map hm1=new HashMap();
        Map hm2=new HashMap();
        Map hm3=new HashMap();       
         Map hm4=new HashMap();   
        function_int_foodmart fu=new function_int_foodmart(); 
        ArrayList cart_list=new ArrayList();
        if(!username.equals("guest")){         
            fu.delete_shop_cart_id(id);
            cart_list=(ArrayList)fu.get_cart_despatch(username);
            request.setAttribute("cart_list",cart_list);
            LoginDataObject lb=new LoginDataObject();
            JavaBean1 jb=new JavaBean1();
            jb=(JavaBean1)lb.detail_Address(username);
            request.setAttribute("addressdetail",jb);
        }
        else{
            cart_list=(ArrayList)session.getAttribute("cart_list");
            for(int i=0; i<cart_list.size(); i++){
               itb=(item_bean)cart_list.get(i);
               if(id==itb.getItem_id()){
                   cart_list.remove(itb);
               }
            }
            session.removeAttribute("cart_list");
            session.setAttribute("cart_list", cart_list);
        }
        request.setAttribute("ship_bill",ship_bill);
        
          
String shpStatus=fu.retCatShipChargeStatus(cart_list);
         request.setAttribute("shpStatus",shpStatus); 
//return mapping.findForward("");
return mapping.findForward("success");
    
  }
 
 }




