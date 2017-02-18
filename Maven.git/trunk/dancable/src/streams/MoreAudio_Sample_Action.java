/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package streams;

import com.myapp.struts.File_db;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author kapil
 */
public class MoreAudio_Sample_Action extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String galsuc = "galsuc";
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward viewSamples(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList audios=new ArrayList();
        int id=0;
        int scid=0;
        try {
            
            id=Integer.parseInt((String)request.getParameter("galid"));
            scid=Integer.parseInt((String)request.getParameter("scid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        
        
        ToDBFile tdb= new  ToDBFile();
        audios=(ArrayList)tdb.gal_ItemAudioSapmle(id);
        
        
        request.setAttribute("audios",audios);
        return mapping.findForward(SUCCESS);
      
        
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward inMrStrm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
//        SimpleDateFormat sde=new SimpleDateFormat("dd");
        java.util.Date dt=new java.util.Date();
        PrintWriter out=response.getWriter();
        ToDBFile tdb= new  ToDBFile();
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
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      FormFile myFile =(FormFile)myFiles.get(j) ; 
      
       String contentType = myFile.getContentType();
        String fileName    = (String)myFile.getFileName();
        String title="";
        try
        {
        title=fileName.substring(0, fileName.lastIndexOf('.'));
        }catch(Exception eee){}
        
//        out.println("SUB: "+title);
        int fileSize       = myFile.getFileSize();
      
        fileName=sb.toString()+"_"+fileName;
      sb=null;
      
    if(myFile.getFileSize()!=0)
        {
         tdb.insert_ItemMore_Sample(fileName,pagename,scid,title);
         list_filename.add(fileName);
       
      
       // out.println("filename"+fileName);
        
        byte[] fileData    = myFile.getFileData();
       
       InputStream st= myFile.getInputStream();
       
       String dir=getServlet().getServletContext().getRealPath("/moremusic_samples/"+fileName);   //"/myfiledata";
   
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
catch(FileNotFoundException fnfe){}
  catch (IOException ioe) {}
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
