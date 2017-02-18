 /*
 * Feed_Action.java
 *
 * Created on November 25, 2008, 10:38 PM
 */

package career;

import Feedback.feedbean;
import com.myapp.struts.Im_ResumeUtilty;
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
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
/**
 *
 * @author arjun
 * @version
 */

public class career_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
     private final static String suc = "fedfor";
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
      career_ActionForm fed=(career_ActionForm)form;
         careerbean fdbean=new careerbean();
        FormFile fed_file = fed.getFeed_file();       
        String sub="";
            
        String msg="";
              
        String contentType = fed_file.getContentType();
        String fileName    = fed_file.getFileName();
        int fileSize       = fed_file.getFileSize();
        ActionErrors errors = new ActionErrors();
        String name="";
                
         String emailid="";
        
        String contactno="";
                
        String address="";
          msg=request.getParameter("msg");
          
               name=request.getParameter("name");
                emailid=request.getParameter("emailid");
                 contactno=request.getParameter("contactno");
                   address=request.getParameter("address");
       
        fdbean.setName(name);
        fdbean.setAddress(address);
        fdbean.setContactno(contactno);
        fdbean.setEmailid(emailid);
      
        fdbean.setMsg(msg);
         //errors.add(ActionErrors.GLOBAL_ERROR,
        //new ActionError("errors.database.error"));
        
 InputStream file_ctnt=  fed_file.getInputStream();
       Im_ResumeUtilty dd=new Im_ResumeUtilty();
     boolean tr= dd.fed_db_career(fileName,fdbean);
     out.println(tr);
     out.println("contentType"+contentType);
     
     
     
   

   
    


   
    
         
         
         
         if(tr==true)
         {
    
         
      String dir=getServlet().getServletContext().getRealPath("/cr_file/"+fileName); 
        File f = new File(dir);
        try{
        InputStream stream =fed_file.getInputStream();
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
 fed_file.destroy();
       
         
         
         
         
     request.setAttribute("fedup","Your Resume  has been Uploaded Sucessfully!");
      return mapping.findForward(suc);
     //  return mapping.findForward("");
     
    
         }
   
       
    
        return mapping.findForward("");
        
    }
}
