/*
 * Content_Action.java
 *
 * Created on June 1, 2010, 5:05 PM
 */

package Content;

import Advert.ad_bean;
import Prop.C_Rform;
import com.myapp.struts.Upload_File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import prop_bean.prop_be;
import prop_bean.prop_operate;
/**
 *
 * @author arjun
 * @version
 */

public class Content_Action extends DispatchAction {
    
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
    public ActionForward content_insert(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       Content_ActionForm cr=(Content_ActionForm)form;
       prop_be be=new prop_be();
       String filename="";
       boolean tr=false;
       PrintWriter out=response.getWriter();
        int id=0;
        try {
             
            id=Integer.parseInt((String)request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
       
       out.println(id);
       ad_bean ad=new ad_bean();
       prop_operate op=new prop_operate();
         ad=(ad_bean)op.fetch_head_id(id);             
       FormFile crfile = cr.getProp_file();
         be.setPage_name(ad.getPag());       
        be.setLocation(cr.getLocation());
        be.setDesc(cr.getDesc());        
       filename=crfile.getFileName();
       be.setFilename(filename);
       be.setProp_id(ad.getAd_id());
        try {
                tr=op.insert_Detail_Image(be);
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
       
        
        if(tr==true)
  {
  
          
  if(!crfile.getFileName().equals("") || !filename.equals(""))
      { 
         //String dir=getServlet().getServletContext().getRealPath("/Detail_Imge/"+filename);   
 InputStream st= crfile.getInputStream();

        
         try {
      
//                    String location="/home/aksfashi/public_html/data_image/"+filename;
                    String location=getServlet().getServletContext().getRealPath("/web_images/"+filename);   

                    Upload_File up=new Upload_File ();
                    up.upload_feedback(location,st);
                        
                    
                } catch(Exception e)
                {
                }
  crfile.destroy();
  } 
      
    
//  RequestDispatcher rd=request.getRequestDispatcher("/Content_Detail/Content_Form.jsp?page_name="+page_id);
//  rd.forward(request,response);
 } 
       // }
       
     request.setAttribute("msg","Content Detail is updated");
   request.setAttribute("suc",new Integer(ad.getAd_id()).toString());
  
     //   return mapping.findForward("");
     return mapping.findForward(SUCCESS);
        
    }
}
