/*
 * Catitem_Action.java
 *
 * Created on May 13, 2010, 5:16 PM
 */

package Main_category;

import com.myapp.struts.Upload_File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import mc_operat.Mc_funct;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
/**
 *
 * @author arjun
 * @version
 */

public class Catitem_Action extends Action {
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out=response.getWriter();
     SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
     java.util.Date dt=new java.util.Date();
        Catitem_Actionform fd =(Catitem_Actionform)form;
        item_bean be=new item_bean();
         ArrayList myFiles =(ArrayList)fd.getUploads();
        
        
        String filename="";
        String Samplefilename="";
        String title="";
        int subcat_id=0;
//        String directory[]={"audio_sample","music_image"};
StringBuffer sb;
SecureRandom random = new SecureRandom();
        FormFile myFile;
        File f;
   for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      sb=new StringBuffer("");
       sb=sdf.format(dt, sb, new FieldPosition(sb.length()));
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
       try{
           filename    = myFile.getFileName();
   if(!filename.equals("")&&filename!=null){
     filename=sb.toString()+"_"+filename;
      sb=null;
        byte[] fileData    = myFile.getFileData();
        
           String dir=getServlet().getServletContext().getRealPath("music_image/"+filename);
           f = new File(dir);
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
        }catch(FileNotFoundException fnfe)
{
                out.println("Ex: "+fnfe.getMessage());  
                   myFile.destroy();
              }
       }
           }catch(Exception ee){}

        }
        }
    myFiles.clear();
    myFiles =(ArrayList)fd.getSamples();
    
 for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      sb=new StringBuffer("");
       sb=sdf.format(dt, sb, new FieldPosition(sb.length()));
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
       try{
           Samplefilename= myFile.getFileName();
      if(!Samplefilename.equals("")&&Samplefilename!=null){
        byte[] fileData    = myFile.getFileData();
        
        
        try
        {
        title=Samplefilename.substring(0, Samplefilename.lastIndexOf('.'));
        }catch(Exception eee){}
        Samplefilename=sb.toString()+"_"+Samplefilename;
      sb=null;
           String dir=getServlet().getServletContext().getRealPath("audio_sample/"+Samplefilename);
           f = new File(dir);
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
        }catch(FileNotFoundException fnfe)
{
                out.println("Ex: "+fnfe.getMessage());  
                   myFile.destroy();
              }
       }
           }catch(Exception ee){}

        }
        }
 myFiles.clear();
    
        be.setBrand(fd.getBrand());
        be.setFilename(filename);
        be.setSampleTitle(title);
        be.setSampleFileName(Samplefilename);
        be.setPrice(fd.getPrice());
        be.setProd_id(fd.getProd_id());
        be.setSize(fd.getSize());
        be.setType("regular");
        be.setStatus(fd.getStatus());
        be.setSubcat_id(fd.getSubcat_id());
        be.setMarketprice(fd.getMarketprice());
        be.setDiscount(fd.getDiscount());
        be.setDiscountdetail(fd.getDiscountdetail());
        be.setDetail(fd.getDetail());
        be.setUnit(fd.getUnit());
        be.setRelated_items(fd.getRelated_items());
//        out.println(fd.getSubcat_id());
        
        Mc_funct add_attr=new Mc_funct(); 
       add_attr.add_attrib(be);
//        return mapping.findForward(SUCCESS);
        out.println("All details of the item are stored.");
        return mapping.findForward("");
    }
}
