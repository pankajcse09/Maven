/*
 * View_Range_Order.java
 *
 * Created on June 7, 2010, 5:37 PM
 */

package ActionClass;

import Main_category.item_bean;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

public class View_Range_Order extends DispatchAction {
    
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
    public ActionForward get_orderDetailCustomer(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         function_int_foodmart fu=new function_int_foodmart(); 
        String tid=(String)request.getParameter("tid");
        ArrayList cart_list=new ArrayList();
         //String dates="";
       /// java.util.Date now = new java.util.Date();
         //   SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         //  dates=sdf.format(now);
           
         cart_list=(ArrayList)fu.get_customer_tid_Details(tid);
         request.setAttribute("cart_list",cart_list);
        
        
        
        
        return mapping.findForward(SUCCESS);
        
    }
    
    public ActionForward get_orderCustomerList(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LoginDataObject lj=new LoginDataObject();
        ArrayList customer=new ArrayList();
           String frodate="";
            String todate="";
            String order_id="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frdate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String loginid=request.getParameter("userid");
        order_id=request.getParameter("odid");
//         fd=new Date(sdf.parse(frodate).getTime());
//            td=new Date(sdf.parse(todate).getTime());  
              function_int_foodmart fu=new function_int_foodmart();    
              item_bean be=new item_bean();
          be=(item_bean)fu.get_customer_order_date(loginid,order_id);        
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("item_list",be);    
         return mapping.findForward(SUCCESS);
        
    }
 
  public ActionForward get_orderList(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LoginDataObject lj=new LoginDataObject();
        HashMap hm=new HashMap();
        ArrayList customer=new ArrayList();
          ArrayList al=new ArrayList();
           String frodate="";
            String todate="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frodate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String loginid=request.getParameter("emailid");
         fd=new Date(sdf.parse(frodate).getTime());
            td=new Date(sdf.parse(todate).getTime());  
              function_int_foodmart fu=new function_int_foodmart();    
              item_bean be=new item_bean();
              
        int page = 1;
        int recordsPerPage = 2;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
              
          al=(ArrayList)lj.get_cust_order_date(loginid,fd,td,(page-1)*recordsPerPage,recordsPerPage);    
          
          int noOfRecords = lj.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", Integer.toString(noOfPages));
        request.setAttribute("currentPage", Integer.toString(page));
        
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("item_list",be);    
        request.setAttribute("al",al);
         return mapping.findForward(SUCCESS);
        
    }
       
    
    public ActionForward OrderList(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        LoginDataObject lj=new LoginDataObject();
        ArrayList orderlist=new ArrayList();
           String frodate="";
            String todate="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frodate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        try{
         fd=new Date(sdf.parse(frodate).getTime());
            td=new Date(sdf.parse(todate).getTime());  
        }catch(Exception e)
        {
//            System.out.println("Saini: "+e.getMessage());
            request.setAttribute("msg","Please select both the dates and then click on submit button.");
            return mapping.findForward(SUCCESS);
        }
             
   function_int_foodmart fu=new function_int_foodmart();       
        int page = 1;
        int recordsPerPage = 50;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));           
        orderlist=(ArrayList)fu.get_orderList(fd,td,(page-1)*recordsPerPage,recordsPerPage);    
          
          int noOfRecords = fu.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", Integer.toString(noOfPages));
        request.setAttribute("currentPage", Integer.toString(page));   
         out.println("noOfPages: "+noOfPages);
         
       //   out.println(td);
//        out.println(orderlist);
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("orderlist",orderlist);    
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
        
    }
    
  public ActionForward order_Det(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
         ArrayList cart_list=new ArrayList();

              String orderid="";

              ArrayList orderlist=new ArrayList();
            orderid=(String)request.getParameter("orderid");
//            String orderdate=(String)request.getParameter("dt");

         function_int_foodmart fu=new function_int_foodmart();
         int cn=fu.chkInvoice(orderid);
         if(cn==0)
         {
         String invoiceno=fu.genInvoiceNo();
//          out.println("invoiceno: "+invoiceno);
          fu.updateInviceOfOrder(invoiceno, orderid);
         }
        item_bean be=new item_bean();

         be=(item_bean)fu.order_ID_date(orderid);
         
//java.util.Date date= new java.util.Date();
//Timestamp ts_now = new Timestamp(date.getTime());
//out.println("ts_now: "+ts_now);
        request.setAttribute("item_list",be);
       // out.println("cartlist"+cart_list);
         request.setAttribute("orderlist",orderlist);
        request.setAttribute("orderid",orderid);
//        request.setAttribute("invoiceno",invoiceno);
//        return mapping.findForward("");
   return mapping.findForward(SUCCESS);
        
    }
 
  public ActionForward packSlip(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        String orderid=(String)request.getParameter("orderid");

         function_int_foodmart fu=new function_int_foodmart();
         
        item_bean be=new item_bean();

         be=(item_bean)fu.packSlipOrderDetails(orderid);
         
        request.setAttribute("item_list",be);
        request.setAttribute("orderid",orderid);
   return mapping.findForward(SUCCESS);
        
    }
       
    public ActionForward Customer_CartList(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LoginDataObject lj=new LoginDataObject();
        ArrayList customer=new ArrayList();
           String frodate="";
            String todate="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frodate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         fd=new Date(sdf.parse(frodate).getTime());
            td=new Date(sdf.parse(todate).getTime());  
              function_int_foodmart fu=new function_int_foodmart();        
        customer=(ArrayList)lj.select_Profile_customer(fd,td);      
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("customer",customer);    
         return mapping.findForward(SUCCESS);
        
    }
    
    public ActionForward CustomerList(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LoginDataObject lj=new LoginDataObject();
        ArrayList customer=new ArrayList();
           String frodate="";
            String todate="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frodate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         fd=new Date(sdf.parse(frodate).getTime());
            td=new Date(sdf.parse(todate).getTime());  
              function_int_foodmart fu=new function_int_foodmart();        
        customer=(ArrayList)lj.select_Profile_customer(fd,td);        
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("customer",customer);    
         return mapping.findForward(SUCCESS);
        
    }
    
    public ActionForward get_item_daterange(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
         ArrayList cart_list=new ArrayList();
         String dates="";
        java.util.Date now = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            java.util.Date td = new java.util.Date();
              String userid="";
            String frodate="";
            String todate="";
            String order_id="";
            userid=(String)request.getParameter("userid");
            frodate=(String)request.getParameter("fd");
       todate=(String)request.getParameter("td");
       order_id=(String)request.getParameter("odid");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         fd=new Date(sdf.parse(frodate).getTime());
        td=new Date(sdf.parse(todate).getTime());  
         function_int_foodmart fu=new function_int_foodmart();
        LoginDataObject lj=new LoginDataObject();
        item_bean be=new item_bean();
          be=(item_bean)fu.get_cart_ID_date(userid,fd,td,order_id);
//        request.setAttribute("cart_list",cart_list);
       
         request.setAttribute("item_list",be);
        request.setAttribute("userid",userid);
       //  return mapping.findForward("");
      return mapping.findForward(SUCCESS);
        
    }
    
      public ActionForward gues_get_item_daterange(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
         ArrayList cart_list=new ArrayList();
         String dates="";
        java.util.Date now = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            java.util.Date td = new java.util.Date();
              String userid="";
            String frodate="";
            String todate="";
            String order_id="";
            userid=(String)request.getParameter("userid");
            frodate=(String)request.getParameter("fd");
       todate=(String)request.getParameter("td");
       order_id=(String)request.getParameter("odid");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         fd=new Date(sdf.parse(frodate).getTime());
        td=new Date(sdf.parse(todate).getTime());  
        out.println(fd+"_"+td);
         function_int_foodmart fu=new function_int_foodmart();
        LoginDataObject lj=new LoginDataObject();
        item_bean be=new item_bean();
     be=(item_bean)fu.gues_get_cart_ID_date(userid,fd,td,order_id);
        request.setAttribute("item_list",be);
       // out.println("cartlist"+cart_list);
        
        request.setAttribute("userid",userid);
       //   return mapping.findForward("");
     return mapping.findForward(SUCCESS);
        
    }
    public ActionForward guest_datewiseCustomerList(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LoginDataObject lj=new LoginDataObject();
        ArrayList customer=new ArrayList();
           String frodate="";
            String todate="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frodate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         fd=new Date(sdf.parse(frodate).getTime());
            td=new Date(sdf.parse(todate).getTime());  
              function_int_foodmart fu=new function_int_foodmart();        
        customer=(ArrayList)lj.select_Guest_loginid(fd,td);        
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("customer",customer);    
         return mapping.findForward(SUCCESS);
        
    }
    
      public ActionForward update_Status(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
         ArrayList status_list=new ArrayList();
         ArrayList cartid_list=new ArrayList();
          function_int_foodmart fu=new function_int_foodmart();
         ArrayList len=new ArrayList();
   
          Enumeration en = request.getParameterNames();
              while (en.hasMoreElements())
        {             
              String name = (String)en.nextElement();
              //String values[] = request.getParameterValues(name);
                 
              if(name.substring(0,6).equals("status")){
                        len.add(name);
              }
              }
          
          
          
    for(int i=0;i<len.size();i++)
    {    
        status_list.add((String)request.getParameter("status"+i));              
    }
            
            
            
            
    
      for(int ii=0;ii<len.size();ii++)
    {
    
        cartid_list.add((String)request.getParameter("orderid"+ii));              
    }    
      for(int k=0;k<len.size();k++)
            {
                   out.println("status"+k+"."+(String)status_list.get(k));
                out.println("cartid"+k+"."+(String)cartid_list.get(k));
                   
                   
     fu.update_Status_Order((String)status_list.get(k),Integer.parseInt(cartid_list.get(k).toString()));           
           
            }
     return mapping.findForward(SUCCESS);
      
}
      
      public ActionForward search_by_user(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
         ArrayList cart_list=new ArrayList();
         String user_search=(String)request.getParameter("search_user");
           
         function_int_foodmart fu=new function_int_foodmart();
        LoginDataObject lj=new LoginDataObject();
        cart_list=fu.get_orders_by_user(user_search);
     //cart_list=(ArrayList)fu.get_cart_ID_date(userid,fd,td);
        request.setAttribute("cart_list",cart_list);
        out.println("cartlist: "+cart_list.size());
          //return mapping.findForward("");
      return mapping.findForward(SUCCESS);
        
    }
      
      public ActionForward search_user(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       ArrayList profile_list=new ArrayList();
         ArrayList cart_list=new ArrayList();
         JavaBean1 jb=new JavaBean1();
          LoginDataObject dob=new LoginDataObject(); 
         String user_email=(String)request.getParameter("userid");
         user_email=user_email.trim();
          jb=(JavaBean1)dob.editCustomerRegistData(user_email);          
        request.setAttribute("jbean",jb); 
        
          //return mapping.findForward("");
      return mapping.findForward(SUCCESS);
        
    }
public ActionForward calAm(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        LoginDataObject lj=new LoginDataObject();
        double amount=0.0;
        String frodate="";
            String todate="";
            java.util.Date td = new java.util.Date();
           java.util.Date fd = new java.util.Date();
            frodate=(String)request.getParameter("frodate");
       todate=(String)request.getParameter("todate");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         fd=new Date(sdf.parse(frodate).getTime());
            td=new Date(sdf.parse(todate).getTime());  
//            out.println(td);
             amount=lj.retTotAmountDateWise(fd,td);
        request.setAttribute("fdate",frodate);
        request.setAttribute("tdate",todate);
        request.setAttribute("amount",Double.toString(amount));    
         return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
        
    }      
            
      
}
