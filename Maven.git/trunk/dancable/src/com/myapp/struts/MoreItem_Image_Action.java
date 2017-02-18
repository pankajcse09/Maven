/*
 * Gallery_Image_Action.java
 *
 * Created on November 5, 2008, 11:01 AM
 */

 package com.myapp.struts;

import com.myapp.struts.File_db;
import com.myapp.struts.Im_Proj_DataUtility;
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
import static java.lang.Math.random;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Random;
 import java.security.SecureRandom;
public class MoreItem_Image_Action extends Action {
    
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
        
        SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
//        SimpleDateFormat sde=new SimpleDateFormat("dd");
        java.util.Date dt=new java.util.Date();
        PrintWriter out=response.getWriter();
        Im_Proj_DataUtility im= new  Im_Proj_DataUtility();
        File_db fd =( File_db)form;
        ArrayList list_filename=new ArrayList();
        
        String pagename="";
                String scid="";
                pagename=(String)request.getParameter("galid");
                scid=(String)request.getParameter("scid");
        
        
        ArrayList myFiles =(ArrayList)fd.getUploads();
        
        StringBuffer sb;
        SecureRandom random = new SecureRandom();
        
        
        for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
       sb=new StringBuffer("");
       sb=sdf.format(dt, sb, new FieldPosition(sb.length()));
//       sb=sde.format(dt, sb, new FieldPosition(sb.length()));
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        String fileName    = (String)myFile.getFileName();
        int fileSize       = myFile.getFileSize();
      
        fileName=sb.toString()+"_"+fileName;
      sb=null;
      
        if(myFile.getFileSize()!=0)
        {
         im.insert_ItemMore_Image(fileName,pagename,scid);
         list_filename.add(fileName);
       
      
       // out.println("filename"+fileName);
        
    byte[] fileData    = myFile.getFileData();
       
       InputStream st= myFile.getInputStream();
       
       String dir=getServlet().getServletContext().getRealPath("/moremusic_images/"+fileName);   //"/myfiledata";
   
       //String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
       
//         String dir="/home/azansysc/public_html/jewelry/"+fileName;
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
       


       
       
     

       
         request.setAttribute("msguploaded","msguploaded");
      
       request.setAttribute("galid",pagename);
    request.setAttribute("scid",scid);
return mapping.findForward(galsuc);
 
 
 
 
 
// return mapping.findForward("");
        
    }
}
