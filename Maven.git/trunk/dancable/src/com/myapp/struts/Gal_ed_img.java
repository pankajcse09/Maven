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
public class Gal_ed_img extends Action {
    
    /* forward name="success" path="" */
    private final static String galedit = "galedit";
    
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
        
        
        int id=Integer.parseInt(request.getParameter("id"));
        
        String pagename="";
        ArrayList myFiles =(ArrayList)fd.getUploads();
        
        
        
        pagename=(String)request.getParameter("pagename");
        

      
         //  File savedFile = new File(request.getSgetServletContext().getRealPath("/"));

        
        for(int j=0;j<myFiles.size();j++){ 
  
      
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        String fileName    = myFile.getFileName();
        int fileSize       = myFile.getFileSize();
        
        
      
        if(myFile.getFileSize()!=0)
        {
         im.edit_gal(pagename+"_"+fileName,id);
         list_filename.add(fileName);
        
       // out.println(fileName);
        
    byte[] fileData    = myFile.getFileData();
//     out.println(fileData);
  
//        for(int i=0;i<fileData.length;i++){
//            out.print(fileData[i]);
//        }
//        
       InputStream st= myFile.getInputStream();
      //String dir=getServlet().getServletContext().getRealPath("/gallery/"+pagename+"_"+fileName); 
      String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
//"/myfiledata";
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
        
       


       
       
     

        out.println(list_filename);
      request.setAttribute("suc","Your Image is updated");
      request.setAttribute("pagename",pagename);
      
 return mapping.findForward(galedit);
 
 
 
 
 
    //return mapping.findForward("");
        
    }
}
