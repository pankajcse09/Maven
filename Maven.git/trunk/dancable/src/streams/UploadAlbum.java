/*
 * Copyright 2014 kapil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author kapil
 */
public class UploadAlbum extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
public ActionForward uploadWrittenMusic(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
                String pagename="";
                String scid="";
                pagename=(String)request.getParameter("galid");
                scid=(String)request.getParameter("scid");
                
                StreamActionForm fd =(StreamActionForm)form;
                ToDBFile tdb=new ToDBFile();
        if(!fd.getTp().equals("sm")&&!fd.getTp().equals("nsm"))
        {
            request.setAttribute("msguploaded", "Some internal error occured. Please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                request.setAttribute("tp",fd.getTp());
                return mapping.findForward(SUCCESS);
        }

 if(fd.getUploads1().getFileSize()!=0)
        {
            StreamBean sb=new StreamBean();
            String fl=fd.getUploads1().getFileName();
            fl=tdb.addAutoGenNumToFilename(fl);
            sb.setFilename(fl);
            sb.setTitle(fd.getTitle1());
            sb.setTp(fd.getTp());
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading file "+fd.getUploads1().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                request.setAttribute("tp",fd.getTp());
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads1().getFileData();
       
       InputStream st= fd.getUploads1().getInputStream();
       String dir="";
       if(fd.getTp().equals("sm"))
        {
       dir=getServlet().getServletContext().getRealPath("/moremusic_samples/"+sb.getFilename());   //"/myfiledata";
        }
       else{
           dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());
       }
       //String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
       
//         String dir="/home/azansysc/public_html/jewelry/"+fileName;
       File f = new File(dir);        
        try{
        InputStream stream =fd.getUploads1().getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.flush();
}
bos.close();
stream.close();
tdb.insert_written_Music(sb);
    }
  catch(FileNotFoundException fnfe){System.out.println("Exp1: "+fnfe.getMessage());}
  catch (IOException ioe) {System.out.println("Exp2: "+ioe.getMessage());}
        catch(Exception e){System.out.println("Exp3: "+e.getMessage());}
      fd.getUploads1().destroy();
   }
 
 if(fd.getUploads2().getFileSize()!=0)
        {
            StreamBean sb=new StreamBean();
            String fl=fd.getUploads2().getFileName();
            fl=tdb.addAutoGenNumToFilename(fl);
            sb.setFilename(fl);
            sb.setTitle(fd.getTitle2());
            sb.setTp(fd.getTp());
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading file "+fd.getUploads2().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                request.setAttribute("tp",fd.getTp());
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads2().getFileData();
       
       InputStream st= fd.getUploads2().getInputStream();
       
       String dir="";
       if(fd.getTp().equals("sm"))
        {
       dir=getServlet().getServletContext().getRealPath("/moremusic_samples/"+sb.getFilename());   //"/myfiledata";
        }
       else{
           dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());
       }
   
       //String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
       
//         String dir="/home/azansysc/public_html/jewelry/"+fileName;
       File f = new File(dir);        
        try{
        InputStream stream =fd.getUploads2().getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.flush();
}
bos.close();
stream.close();
tdb.insert_written_Music(sb);
    }
  catch(FileNotFoundException fnfe){}
  catch (IOException ioe) {}
      fd.getUploads2().destroy();
   }
 
 if(fd.getUploads3().getFileSize()!=0)
        {
            StreamBean sb=new StreamBean();
            String fl=fd.getUploads3().getFileName();
            fl=tdb.addAutoGenNumToFilename(fl);
            sb.setFilename(fl);
            sb.setTitle(fd.getTitle3());
            sb.setTp(fd.getTp());
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading file "+fd.getUploads3().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                request.setAttribute("tp",fd.getTp());
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads3().getFileData();
       
       InputStream st= fd.getUploads3().getInputStream();
       
       String dir="";
       if(fd.getTp().equals("sm"))
        {
       dir=getServlet().getServletContext().getRealPath("/moremusic_samples/"+sb.getFilename());   //"/myfiledata";
        }
       else{
           dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());
       }
   
       //String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
       
//         String dir="/home/azansysc/public_html/jewelry/"+fileName;
       File f = new File(dir);        
        try{
        InputStream stream =fd.getUploads3().getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.flush();
}
bos.close();
stream.close();
tdb.insert_written_Music(sb);
    }
  catch(FileNotFoundException fnfe){}
  catch (IOException ioe) {}
      fd.getUploads3().destroy();
   }
                request.setAttribute("msguploaded", "Your Files are Uploaded Successfully!");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                request.setAttribute("tp",fd.getTp());
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward viewWrtnSamples(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList filelist=new ArrayList();
        int id=0;
        int scid=0;
        try {
            
            id=Integer.parseInt((String)request.getParameter("galid"));
            scid=Integer.parseInt((String)request.getParameter("scid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        
        
        ToDBFile tdb= new  ToDBFile();
        filelist=(ArrayList)tdb.get_ItemWrtnSapmle(id);
        
        request.setAttribute("tp","sm");
        request.setAttribute("filelist",filelist);
        return mapping.findForward(SUCCESS);
      
        
    }
 
public ActionForward up_contentFile(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
                String pagename="";
                String scid="";
                pagename=(String)request.getParameter("galid");
                scid=(String)request.getParameter("scid");
                
                ContentFileForm fd =(ContentFileForm)form;
                ToDBFile tdb=new ToDBFile();
  
        
 if(fd.getUploads1().getFileSize()!=0)
        {
            
            StreamBean sb=new StreamBean();
            String fl=tdb.removeSpace(fd.getUploads1().getFileName());
            
            sb.setFilename(fl);
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading Content file "+fd.getUploads1().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads1().getFileData();
       
       InputStream st= fd.getUploads1().getInputStream();
       String dir="";
       
       dir=getServlet().getServletContext().getRealPath("/music_image/"+sb.getFilename());   //"/myfiledata";
       System.out.println("dir: "+dir);
        
       //String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
       
//         String dir="/home/azansysc/public_html/jewelry/"+fileName;
       File f = new File(dir);        
        try{
        InputStream stream =fd.getUploads1().getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.flush();
}
bos.close();
stream.close();
tdb.insert_content_file(sb);
    }
  catch(FileNotFoundException fnfe){System.out.println("Exp1: "+fnfe.getMessage());}
  catch (IOException ioe) {System.out.println("Exp2: "+ioe.getMessage());}
        catch(Exception e){System.out.println("Exp3: "+e.getMessage());}
      fd.getUploads1().destroy();
   }
 
 
                request.setAttribute("msguploaded", "Content File is Uploaded Successfully!");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
               
        return mapping.findForward(SUCCESS);
    }

public ActionForward viewcontetnfile(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList filelist=new ArrayList();
        int id=0;
        int scid=0;
        try {
            
            id=Integer.parseInt((String)request.getParameter("galid"));
            scid=Integer.parseInt((String)request.getParameter("scid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        
        
        ToDBFile tdb= new  ToDBFile();
        filelist=(ArrayList)tdb.get_contentfile(id);
        
        request.setAttribute("filelist",filelist);
        return mapping.findForward(SUCCESS);
      
        
    }
 

}
