/*
 * More_Images.java
 *
 * Created on May 12, 2010, 11:33 AM
 */

package moreimg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
/**
 *
 * @author arjun
 * @version
 */

public class More_Images extends DispatchAction{
    
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
    public ActionForward More_Images(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();   
        int id=0;
        
     id=Integer.parseInt((String)request.getParameter("id"));
        img_bean be=new img_bean();
        function_int_foodmart fu=new function_int_foodmart();       
        be=fu.fetch_img_detail(id);
        request.setAttribute("pgdetail",be);
        return mapping.findForward(SUCCESS);
        
    }
    
    
    
     public ActionForward Edit_Images(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList homelist=new ArrayList();
          ArrayList advert=new ArrayList();
               ArrayList blog=new ArrayList();
        
         PrintWriter out=response.getWriter();   
         int id=0;         
         String pagename="";
         id=Integer.parseInt((String)request.getParameter("id"));
         pagename=(String)request.getParameter("pagename");
         img_bean be=new img_bean();
         function_int_foodmart fu=new function_int_foodmart();     
          advert=(ArrayList)fu.select_content("advert");     
          blog=(ArrayList)fu.select_content("blog");     
          image_form fd =(image_form)form;
         ArrayList myFiles =(ArrayList)fd.getUploads();
       for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        String fileName    = myFile.getFileName();
        int fileSize       = myFile.getFileSize();
      
        
      out.println("fileName"+fileName);
        if(!fileName.equals(""))
        {
         fu.update_Image(fileName,id);        
        }
           
    byte[] fileData    = myFile.getFileData();
 
    InputStream st= myFile.getInputStream();
     
     
 
       String dir=getServlet().getServletContext().getRealPath("/Imge/"+fileName);   //"/myfiledata";
        File f = new File(dir);
        try{
        InputStream stream =myFile.getInputStream();
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
      myFile.destroy();
   } 
}   homelist=(ArrayList)fu.select_content(pagename);
 request.setAttribute("pagename",pagename); 
        request.setAttribute("advert",advert);
        request.setAttribute("blog",blog);
        
        request.setAttribute("homelist",homelist);
     
        return mapping.findForward(SUCCESS);
        
    }

public ActionForward Edit_more_Images(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList homelist=new ArrayList();
         ArrayList qualitylist=new ArrayList();
         ArrayList discountlist=new ArrayList();
        
       ArrayList advert=new ArrayList();
               ArrayList blog=new ArrayList();
        
         PrintWriter out=response.getWriter();   
         int id=0;         
         String pagename="";    
         id=Integer.parseInt((String)request.getParameter("id"));
         pagename=(String)request.getParameter("pagename");
         img_bean be=new img_bean();
         function_int_foodmart fu=new function_int_foodmart();  
         homelist=(ArrayList)fu.select_content(pagename);
          image_form fd =(image_form)form;
         ArrayList myFiles =(ArrayList)fd.getUploads();
       for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        String fileName    = myFile.getFileName();
        int fileSize       = myFile.getFileSize();
      
        
      out.println("fileName"+fileName);
        if(!fileName.equals(""))
        {
         fu.update_more_Image(fileName,id);        
        }
           
    byte[] fileData    = myFile.getFileData();
 
    InputStream st= myFile.getInputStream();
     
     
 
       String dir=getServlet().getServletContext().getRealPath("/Imge/"+fileName);   //"/myfiledata";
        File f = new File(dir);
        try{
        InputStream stream =myFile.getInputStream();
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
      myFile.destroy();
   } 
}  
         
         
         
         homelist=(ArrayList)fu.select_content(pagename);
    request.setAttribute("pagename",pagename); 
        request.setAttribute("advert",advert);
        request.setAttribute("blog",blog);
        return mapping.findForward(SUCCESS);
        
    }



}
