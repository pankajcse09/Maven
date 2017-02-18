/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.ArrayList;

import moreimg.function_int_foodmart;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author kapil
 */
public class wishlist extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward add_to_mywishlist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int itemid=0;
        String aa="";
        PrintWriter out=response.getWriter();
        itemid=Integer.parseInt((String)request.getParameter("itemid"));
        
        HttpSession session=(HttpSession)request.getSession(false);
        String emailid=(String)session.getAttribute("loginid");
        
        item_bean ib=new item_bean();
        function_int_foodmart fd=new function_int_foodmart();
        if(emailid!=null&&!emailid.equals("guest"))
        {
            ib=fd.discount_item_detail(itemid,aa);
            fd.addto_mywishlist(itemid, emailid,ib);
        }
        else{
       
        }
       
       
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward retrieve_wishlist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String st="";
        String wish="wish";
        HttpSession session=(HttpSession)request.getSession(false);
        String emailid=(String)session.getAttribute("loginid");
        ArrayList list=new ArrayList();
        PrintWriter out=response.getWriter();
        item_bean ib=new item_bean();
        function_int_foodmart fd=new function_int_foodmart();
        if(emailid!=null&&!emailid.equals("guest")){
        list=fd.get_wishlist(emailid);
        st="success";
        }
        else
        {
            st="failure";
        }
        //out.println(list.size());
        request.setAttribute("wishlist", list);
        request.setAttribute("wish", wish);
        
        
        return mapping.findForward(st);
        //return mapping.findForward("");
    }
    
    public ActionForward remove(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String st="";
        String wish="wish";
        
        HttpSession session=(HttpSession)request.getSession(false);
        String emailid=(String)session.getAttribute("loginid");
        
        int id=0;
        id=Integer.parseInt((String)request.getParameter("id"));
        
        ArrayList list=new ArrayList();
        PrintWriter out=response.getWriter();
        item_bean ib=new item_bean();
        function_int_foodmart fd=new function_int_foodmart();
        
        
        if(emailid!=null&&!emailid.equals("guest")){
        list=fd.remove_item_from_wishlist(emailid,id);
        st="success";
        }
        else
        {
            st="failure";
        }
        out.println(list.size());
        request.setAttribute("wishlist", list);
        request.setAttribute("wish", wish);
        
        
        return mapping.findForward(st);
        //return mapping.findForward("");
    }
}
