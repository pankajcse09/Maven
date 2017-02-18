/*
 * Gallery_Image_Action.java
 *
 * Created on November 5, 2008, 11:01 AM
 */

 package com.myapp.struts;

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
public class Gallery_Image_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String galsuc = "galsuc";
    
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
        Im_Proj_DataUtility im= new  Im_Proj_DataUtility();
        File_db fd =( File_db)form;
        ArrayList list_filename=new ArrayList();
        
        String pagename="";
                
                pagename=(String)request.getParameter("gal");
        
        
        
        ArrayList myFiles =(ArrayList)fd.getUploads();
        
    
        for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        StringBuffer fileName    = new  StringBuffer(myFile.getFileName());
        int fileSize       = myFile.getFileSize();
      
        
      
        if(myFile.getFileSize()!=0)
        {
         im.insert_gal_Image(pagename+"_"+fileName,pagename);
         list_filename.add(fileName);
       
      
        out.println("filename"+fileName);
        
    byte[] fileData    = myFile.getFileData();
       
       InputStream st= myFile.getInputStream();
       
      // String dir=getServlet().getServletContext().getRealPath("/gallery/"+pagename+"_"+fileName);   //"/myfiledata";
   
       String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
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

         }
       


       
       
     

        out.println(list_filename);
         request.setAttribute("msg","your Image are Uploaded!");
       request.setAttribute("imgsname",list_filename);
       request.setAttribute("pagename",pagename);
    
return mapping.findForward(galsuc);
 
 
 
 
 
// return mapping.findForward("");
        
    }
}
