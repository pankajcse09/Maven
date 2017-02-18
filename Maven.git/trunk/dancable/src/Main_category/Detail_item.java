/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main_category;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import moreimg.function_int_foodmart;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import streams.ToDBFile;

/**
 *
 * @author arjun
 */
public class Detail_item extends org.apache.struts.action.Action {
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        ArrayList detail =new ArrayList();
        ArrayList itmstrm =new ArrayList();
        ArrayList relatedItems =new ArrayList();
        int id=0;
        int chk=0;
        String usernm="";
        String aa="price";
     if(session.getAttribute("loginid")!=null)
     {
         usernm=(String)session.getAttribute("loginid");
     }
if(usernm.equals(""))
             {
                 String msg="Your Session is expired. Please either login again or contine shopping without login!!!";
            RequestDispatcher rd1=request.getRequestDispatcher("/Registration/Customer_Regis_Form_1.jsp?msg="+msg); 
            rd1.forward(request,response);
            }
     try{
        id=Integer.parseInt((String)request.getParameter("id"));
        String catid = request.getParameter("catid");
       // System.out.println(catid);
        session.setAttribute("catid", catid);
        } catch (NumberFormatException ex) {
            System.out.println("Redirect: An exception occured in formating item id to integer due to the change in url on browser. URL is redirected to login page.");
            RequestDispatcher rd1=request.getRequestDispatcher("/myaccount.do"); 
                 rd1.forward(request,response); 
        }
     
     session.setAttribute("itemid", id);
        function_int_foodmart fd=new function_int_foodmart();
        ToDBFile tdb=new ToDBFile();
        item_bean ad=fd.discount_item_detail(id,aa);
        if(ad.getSubcat_id()==0){
            request.setAttribute("vc", "No product found for the id- "+id);
            return mapping.findForward("notexist");
        }
        detail.add(ad);
        chk=fd.checkItemInWishlist(usernm, id);
        relatedItems=fd.get_relatedItems(id);
        itmstrm=tdb.gat_ItemAudioSapmle(id);
        
        ArrayList wrtnsample =new ArrayList();
        wrtnsample=tdb.get_ItemWrtnSapmle(id);
         request.setAttribute("detail", detail);
         request.setAttribute("relatedItems", relatedItems);
         request.setAttribute("itmstrm", itmstrm);
         request.setAttribute("wrtnsample", wrtnsample);
         request.setAttribute("check", Integer.toString(chk));
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
}
