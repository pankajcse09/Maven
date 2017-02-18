/*
 * C_Raction.java
 *
 * Created on September 29, 2008, 5:35 AM
 */

package Prop_action;

import com.myapp.struts.Upload_File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
import Prop.C_Rform;
import prop_bean.prop_be;
import prop_bean.prop_operate;
/**
 *
 * @author arjun
 * @version
 */

public class C_Raction extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "crimage";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    String filename="";
     String edit="";
     String save="";
     String del="";
     String fn="";
     boolean tr=false;
     int app_id=0;
     String cr_type="";
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          prop_operate op=new prop_operate();
         PrintWriter out=response.getWriter();
          prop_be be=new prop_be();
         C_Rform cr=(C_Rform)form;
        FormFile crfile = cr.getProp_file();
        String page_name="";
        page_name=request.getParameter("page_name");        
       be.setPage_name(page_name);             
     
         if(request.getParameter("fn")!=null)
        {
           fn=request.getParameter("fn");
        }
   
      
        be.setLocation(cr.getLocation());
        be.setDesc(cr.getDesc());        
        
        save=cr.getSave().toString();
        edit =cr.getEdit();
//       out.println(cr.getLocation());
//       out.println(cr.getDesc());
//       out.println("save"+save);
       filename=crfile.getFileName();
       be.setFilename(filename);
       
        out.println("filename"+crfile.getFileName());

      
  if(save.equalsIgnoreCase("save"))
  {
            try {
                tr=op.insert_crImage(be);
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
  }
     
   
           
  if(tr==true)
  {
  
          
   InputStream st= crfile.getInputStream();
    
  if(crfile.getFileSize()!=0)
      { 
                try {
      //                    String location="/home/aksfashi/public_html/data_image/"+filename;
                    String location=getServlet().getServletContext().getRealPath("/web_images")+"/"+filename;
   

                    Upload_File up=new Upload_File ();
                    up.upload_feedback(location,st);
                        
                    crfile.destroy();
                } catch(Exception e)
                {
                }
      
 } 
      request.setAttribute("cr_detail",be);
return mapping.findForward(SUCCESS); 
       
  }   
     
        return mapping.findForward("");
        
    }
       
}

      