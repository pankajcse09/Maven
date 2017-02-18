/*
 * Gallery_Image_Action.java
 *
 * Created on November 5, 2008, 11:01 AM
 */

package moreimg;

//import com.myapp.struts.Im_Proj_DataUtility;
//import com.myapp.struts.Upload_File;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
//import org.apache.struts.upload.DiskFile;
import org.apache.struts.upload.CommonsMultipartRequestHandler;
import java.io.PrintWriter;
import java.io.*;
public class MoreImage_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String galsuc = "galsuc";
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList homelist=new ArrayList();
        
        PrintWriter out=response.getWriter();
     function_int_foodmart im= new function_int_foodmart();
        image_form fd =(image_form)form;
        ArrayList list_filename=new ArrayList();
         img_bean be=new img_bean();
        String page_name="";
         int page_id=0;        
        page_name=(String)request.getParameter("page_name");
        page_id=Integer.parseInt((String)request.getParameter("page_id"));
        
        be.setPage_id(page_id);
        be.setPage_name(page_name);        
        ArrayList myFiles =(ArrayList)fd.getUploads();
        
        
        
        
        

      
         //  File savedFile = new File(request.getSgetServletContext().getRealPath("/"));

        
        for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        String fileName    = myFile.getFileName();
        int fileSize       = myFile.getFileSize();
      
        
      
        if(!fileName.equals(""))
        {
         im.insert_gal_Image(fileName,be);
         list_filename.add(fileName);
          byte[] fileData    = myFile.getFileData();
          InputStream st= myFile.getInputStream();
           try {
      
                    String location="/home/aksfashi/public_html/data_image/"+fileName;
   

                    Upload_File up=new Upload_File ();
                    up.upload_feedback(location,st);
                        
                   myFile.destroy();
                } catch(Exception e)
                {
                }
        }
    
   } 
} 

        
       


       
       
     

    homelist=(ArrayList)im.select_content(page_name);       
      
       request.setAttribute("homelist",homelist);
       request.setAttribute("pagename",page_name);
      
        
       request.setAttribute("imgsname",list_filename);
     request.setAttribute("pagedetails",be);
 return mapping.findForward("success");
 
 
 
 
// return mapping.findForward("");
        
    }
}
