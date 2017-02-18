/*
 * Gallery_Image_Action.java
 *
 * Created on November 5, 2008, 11:01 AM
 */

 package streams;

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
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import org.apache.struts.actions.DispatchAction;
public class EverydayStreams extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String galsuc = "galsuc";
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
    public ActionForward evdSt(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
        java.util.Date dt=new java.util.Date();
        PrintWriter out=response.getWriter();
        Im_Proj_DataUtility im= new  Im_Proj_DataUtility();
        File_db fd =( File_db)form;
        ArrayList list_filename=new ArrayList();
        
        String pagename="";
        String strmdate=fd.getStrmdate();
                
                pagename=(String)request.getParameter("galid");
//        out.println("filename: "+pagename);
        StringBuffer sb;
        SecureRandom random = new SecureRandom();
        ArrayList myFiles =(ArrayList)fd.getUploads();
        int chk=0;
    
        for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      sb=new StringBuffer("");
       sb=sdf.format(dt, sb, new FieldPosition(sb.length()));
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
        String fileName    = (String)myFile.getFileName();
        int fileSize       = myFile.getFileSize();
      
        String title="";
        try
        {
        title=fileName.substring(0, fileName.lastIndexOf('.'));
        }catch(Exception eee){}
      
        if(myFile.getFileSize()!=0)
        {
         
         fileName=sb.toString()+"_"+fileName;
        sb=null;
         list_filename.add(fileName);
//            out.println("filename"+fileName);
        
    byte[] fileData    = myFile.getFileData();
       
       InputStream st= myFile.getInputStream();
       
       String dir=getServlet().getServletContext().getRealPath("/everyday_stream/"+fileName);   //"/myfiledata";
   
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
try{
chk=im.insert_everydayStreams(fileName,strmdate,pagename,title);
}catch(Exception eee){f.delete();}
         
         if(chk==1)
         {
             request.setAttribute("msg","Some error occure in storing the data in database. Please try again or contect with vender.");
                request.setAttribute("galid",pagename);
                return mapping.findForward("error");
         }           
 }
        catch(FileNotFoundException fnfe){f.delete();}
        catch (IOException ioe) {f.delete();}
      myFile.destroy();
      
   } 
} 

         }
        
     request.setAttribute("msguploaded","msguploaded");
      request.setAttribute("strmdate",strmdate);
       request.setAttribute("galid",pagename);
    
    return mapping.findForward(galsuc);
// return mapping.findForward("");
        
    }
    
public ActionForward streamAt(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            String strmAtDate=(String)request.getParameter("chkstrm");
            ToDBFile tdb=new ToDBFile();
            ArrayList strmlistAtDate=new ArrayList();
            strmlistAtDate=tdb.gat_everyDayAudioOnDate(strmAtDate, "evdstrm");
    
            request.setAttribute("listAtDate",strmlistAtDate);
            request.setAttribute("strmAtDate",strmAtDate);
            return mapping.findForward(SUCCESS);
    } 
 
}
