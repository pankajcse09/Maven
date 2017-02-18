 /*
 * Im_Resume_Action.java
 *
 * Created on June 23, 2008, 12:47 PM
 */

 package com.myapp.struts;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.action.ActionForward;

 import org.apache.struts.upload.FormFile;
 import java.io.PrintWriter;
 import java.io.*;

 import java.io.IOException;
 import javax.servlet.ServletException;
 import org.apache.struts.action.ActionErrors;
 import org.apache.struts.action.ActionError;
 import org.apache.struts.action.ActionMessage;
/**
 *
 * @author piyushrastogi
 * @version
 */

public class Im_Resume_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
     private final static String suc = "resfor";

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
         Im_resume resu=(Im_resume)form;
        FormFile res_file = resu.getRes_file();
        
        
        String contentType = res_file.getContentType();
        String fileName    = res_file.getFileName();
         int fileSize       = res_file.getFileSize();
        ActionErrors errors = new ActionErrors();
        
         //errors.add(ActionErrors.GLOBAL_ERROR,
        //new ActionError("errors.database.error"));
        
 InputStream file_ctnt=  res_file.getInputStream();
       Im_ResumeUtilty dd=new Im_ResumeUtilty();
     boolean tr= dd.res_db(fileName);
     
     
     
   

   
    


   
    
         
         
         
         if(tr==true)
         {
         
         
         
         
         
         
         String dir="/resume";
        File f = new File(dir + File.separator + fileName);
        try{
        InputStream stream =res_file.getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.close();

stream.close();
}
           
            
}
        catch(FileNotFoundException fnfe)
{
}
        catch (IOException ioe) {
}
res_file.destroy();
       
         
         
         
         
     request.setAttribute("resup","Your Resume  has been Uploaded Sucessfully");
      return mapping.findForward(suc);
     
    
         }
   
       
    
        return mapping.findForward("");
    

       
        
    }
}
