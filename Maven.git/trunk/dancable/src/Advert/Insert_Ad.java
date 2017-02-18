/*
 * Insert_Ad.java
 *
 * Created on November 28, 2008, 9:43 PM
 */

package Advert;

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
import prop_bean.prop_be;
import prop_bean.prop_operate;
/**
 *
 * @author arjun
 * @version
 */

public class Insert_Ad extends Action {
    
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
    String filename="";
   String save="";
   String fn="";
     String edit="";
     int adid=0;
     String pag="";
   boolean tr=false;
   prop_operate op =new prop_operate();
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          ad_form cr=(ad_form)form;
          PrintWriter out=response.getWriter();
        FormFile crfile = cr.getAd_file();
        
        ad_bean ad =new ad_bean();
        ad.setDesc(cr.getDesc());
        ad.setHead(cr.getHead());
        ad.setLink(cr.getLink());
        ad.setPag(cr.getPag());
        save=cr.getSave();
        edit=cr.getEdit();
         if(request.getParameter("fn")!=null)
        {
      fn=request.getParameter("fn");
      out.println("edit"+edit);
      out.println("myfile"+fn);
        }
        filename = crfile.getFileName();
        out.println("filename"+filename);
        
        
        
        //edit
        
         if(edit.equalsIgnoreCase("edit"))
            {

            
       if(fn.equals("")&&crfile.getFileName().equals(""))
       {
       filename=fn;
         out.println("fn"+filename);
             ad.setFilename(filename);
       }
       
       if(filename.equals(""))
       {
       filename=fn;
       out.println("fn"+filename);
           ad.setFilename(filename);
       }
     if(!crfile.getFileName().equals(""));
       {
        
         out.println("arjun"+filename);
            ad.setFilename(filename);
       }
       
      
        
        
        
       }
        //edit
        
        if(edit.equalsIgnoreCase("edit"))
  {
         adid=Integer.parseInt(request.getParameter("adid"));
         pag=request.getParameter("pag");
         out.println(adid);
           
          tr=op.update_adImage(ad,adid);
          request.setAttribute("pag",pag);
            request.setAttribute("edit",edit);
   
  }
        
         if(save.equalsIgnoreCase("save"))
            {

            
       
               ad.setFilename(filename);
            tr=op.insert_adImage(ad);
             request.setAttribute("save",save);
       
           } 
           
          // out.println(ad);
         //  tr=op.insert_adImage(ad);
           
 if(tr==true)
  {
  
  if(!crfile.getFileName().equals("") || !filename.equals(""))
      { 
      
          String dir="/ads";
        File f = new File(dir + File.separator + filename);
        try{
        InputStream stream =crfile.getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1)
{
bos.write(buffer, 0, bytesRead);
bos.close();

stream.close();

 //return mapping.findForward("");
}         
            
}
        catch(FileNotFoundException fnfe)
        
{
}
        catch (IOException ioe) {
            
}
  
 
  
  
  }
       crfile.destroy();
       request.setAttribute("cr_detail",ad);
      
       return mapping.findForward(SUCCESS); 
     
 }     
        
         
        return mapping.findForward("");
        
    }
}
