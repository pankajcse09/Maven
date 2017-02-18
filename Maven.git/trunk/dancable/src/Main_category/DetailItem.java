/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_category;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import moreimg.function_int_foodmart;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import streams.ToDBFile;

/**
 *
 * @author kapil
 */
public class DetailItem extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session =request.getSession();
            if(session.getAttribute("loginid")==null){
            session.setAttribute("loginid","guest");
        session.setAttribute("password","guest");
   }
            
        PrintWriter out=response.getWriter();
        ArrayList detail =new ArrayList();
        ArrayList itmstrm =new ArrayList();
        ArrayList relatedItems =new ArrayList();
        int id=0;
        int chk=0;
        String usernm="";
     if(session.getAttribute("loginid")!=null)
     {
         usernm=(String)session.getAttribute("loginid");
     }
        
        id=Integer.parseInt((String)request.getParameter("id"));
        String ch=(String)request.getParameter("ch");
        
        function_int_foodmart fd=new function_int_foodmart();
        ToDBFile tdb=new ToDBFile();
//        detail=(ArrayList)fd.discount_item_detail(id);
        chk=fd.checkItemInWishlist(usernm, id);
        relatedItems=fd.get_relatedItems(id);
        itmstrm=tdb.gat_ItemAudioSapmle(id);
        
         request.setAttribute("detail", detail);
         request.setAttribute("relatedItems", relatedItems);
         request.setAttribute("itmstrm", itmstrm);
         request.setAttribute("check", Integer.toString(chk));
        return mapping.findForward(SUCCESS);
    }
}
