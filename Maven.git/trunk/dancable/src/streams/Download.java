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

import ActionClass.Common;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author kapil
 */
public class Download extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward downloadfiles(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        String usermail=request.getParameter("key");
        String order_id=request.getParameter("dt");
//        String o
        Common comLogin = new Common();
        //usermail=comLogin.unJumbleData(usermail);
        order_id=comLogin.unJumbleData(order_id);
        
//        java.util.Date ord=null;
//        java.sql.Date sord=null;
//        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
//        try{
//            ord=sdf.parse(date);
//            date=sde.format(ord);
//            ord=sde.parse(date);
//            sord=new java.sql.Date(ord.getTime());
////            out.println("Sql date "+sord+"<br>");
//        }catch(Exception e){
//        out.println("please copying and pasting the following URL from your mail into your browser.");
//        return mapping.findForward("");
//        }
        ToDBFile tdb=new ToDBFile();
        HashMap hm=new HashMap();
        ArrayList al=new ArrayList();
        int count=tdb.checkDownloadAvailability(order_id, usermail);
//        System.out.println("count: "+count);
        if(count==0)
        {
            hm=tdb.gat_userDownloadingFile(order_id, usermail);
            al=(ArrayList)hm.get("orderlist");
            request.setAttribute("list", al);
            request.setAttribute("audiomap", hm);
            request.setAttribute("usermail", usermail);
            request.setAttribute("order_id", order_id);
//            out.println("count "+count+"<br>");
        }
        else
        {
            request.setAttribute("usermail", usermail);
            request.setAttribute("msg", "You have used this links. If you could not download all the files using the link then you can make request to resend the link from contact us page.");
        }
        
//        out.println(usermail+" "+date+"<br>");
        
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward upDwnMusic(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
                String pagename="";
                String scid="";
                pagename=(String)request.getParameter("galid");
                scid=(String)request.getParameter("scid");
                
                StreamActionForm fd =(StreamActionForm)form;
                ToDBFile tdb=new ToDBFile();
                
 if(fd.getUploads1().getFileSize()!=0)
        {
            StreamBean sb=new StreamBean();
            String fl=fd.getUploads1().getFileName();
            fl=tdb.addAutoGenNumToFilename(fl);
            sb.setFilename(fl);
            sb.setTitle(fd.getTitle1());
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading file "+fd.getUploads1().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads1().getFileData();
              
       String dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());   //"/myfiledata";
//              dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());
       //String dir="/home/aksfashi/public_html/gallery/"+pagename+"_"+fileName;
       
//         String dir="/home/azansysc/public_html/jewelry/"+fileName;
       File f = new File(dir);        
        try{
        InputStream stream =fd.getUploads1().getInputStream();
        OutputStream bos = new FileOutputStream(f);
        System.out.println("Dir: "+dir);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.flush();
}
bos.close();
stream.close();
tdb.insert_Dwn_Music(sb);
request.setAttribute("msguploaded1", "File "+sb.getTitle()+" is Uploaded Successfully!");
    }
  catch(FileNotFoundException fnfe){request.setAttribute("err1", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
  catch (IOException ioe) {request.setAttribute("err1", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
        catch(Exception e){request.setAttribute("err1", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
      fd.getUploads1().destroy();
   }
 
 if(fd.getUploads2().getFileSize()!=0)
        {
            StreamBean sb=new StreamBean();
            String fl=fd.getUploads2().getFileName();
            fl=tdb.addAutoGenNumToFilename(fl);
            sb.setFilename(fl);
            sb.setTitle(fd.getTitle2());
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading file "+fd.getUploads2().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads2().getFileData();
       
       InputStream st= fd.getUploads2().getInputStream();
       
       String dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());   //"/myfiledata";
   
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
tdb.insert_Dwn_Music(sb);
request.setAttribute("msguploaded2", "File "+sb.getTitle()+" is Uploaded Successfully!");
    }
  catch(FileNotFoundException fnfe){request.setAttribute("err2", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
  catch (IOException ioe) {request.setAttribute("err2", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
        catch(Exception e){request.setAttribute("err2", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
      fd.getUploads2().destroy();
   }
 
 if(fd.getUploads3().getFileSize()!=0)
        {
            StreamBean sb=new StreamBean();
            String fl=fd.getUploads3().getFileName();
            fl=tdb.addAutoGenNumToFilename(fl);
            sb.setFilename(fl);
            sb.setTitle(fd.getTitle3());
            try{
            sb.setSc_id(Integer.parseInt(scid));
            sb.setItem_id(Integer.parseInt(pagename));
            }catch(Exception e)
            {
                request.setAttribute("msguploaded", "There is some error in uploading file "+fd.getUploads3().getFileName()+". please contact with your vendor.");
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
                return mapping.findForward(SUCCESS);
            }
        
        byte[] fileData    = fd.getUploads3().getFileData();
       
       InputStream st= fd.getUploads3().getInputStream();
       
       String dir=getServlet().getServletContext().getRealPath("/downloadaudio/"+sb.getFilename());   //"/myfiledata";
   
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
tdb.insert_Dwn_Music(sb);
request.setAttribute("msguploaded3", "File "+sb.getTitle()+" is Uploaded Successfully!");
    }
  catch(FileNotFoundException fnfe){request.setAttribute("err3", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
  catch (IOException ioe) {request.setAttribute("err3", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
        catch(Exception e){request.setAttribute("err3", "File "+sb.getTitle()+" is not Uploaded. Please try again.");}
      fd.getUploads3().destroy();
   }
                
                request.setAttribute("galid",pagename);
                request.setAttribute("scid",scid);
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward viewDwMusic(ActionMapping mapping, ActionForm form,
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
        audios=(ArrayList)tdb.get_ItemAudioFileToDownload(id);
        
        request.setAttribute("tp","nsm");
        request.setAttribute("audios",audios);
        request.setAttribute("filelist",audios);
        return mapping.findForward(SUCCESS);
      
        
    }
public ActionForward resendDnlink(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String mail=request.getParameter("user");
        String od=request.getParameter("order_id");
        String link=request.getParameter("link");
        
        try{
       Properties props=new Properties();
       props.put("mail.transport.protocol","smtp");
       props.put("mail.smtp.host","mail.danceables.com");
       props.put("mail.smtp.auth", "true");
       props.put("mail.stmp.port","25");
           
            //Session sess = Session.getInstance(props);
            Session sess=Session.getInstance(props,new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sales@danceables.com","dance123"); // username and the password
                }
 });
               
       MimeMessage msg1=new MimeMessage(sess);     
       Common comLogin = new Common();
       String user=comLogin.jumbleData(mail);
       String dt=comLogin.jumbleData(od);
       
       StringBuffer msg=new StringBuffer("<table><tr><td>***** Please DO NOT REPLY to this automated message. *****<br><br>");
       msg=msg.append("Please click on the following link to download your files. If you not able to download after click on the link then copying and pasting the following URL into your browser.<br>");
       msg=msg.append("<b>This is one time download link.</b><br>");
       msg=msg.append("<a target=\"_blank\" href='"+link+"'>");
       msg=msg.append(link+"</a></td></tr></table>");
       
       msg1.setFrom(new InternetAddress("sales@danceables.com"));
       //out.println("mail: "+mail);
       InternetAddress[] addre = {new InternetAddress(mail)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Resend Downloading Details");
            msg1.setSentDate(new Date());
            msg1.setContent(msg.toString(), "text/html; charset=utf-8");
            Transport.send(msg1,msg1.getAllRecipients());
       
   ToDBFile tdb= new  ToDBFile(); 
   int resend_count=tdb.chekResendlink(mail, od);
   tdb.updateDownloadFeildsForDwnloads(mail, od);
   tdb.updateResendlink(mail, od, resend_count);
  }  catch(Exception e)
  {
      System.out.println("Ex: "+e.getMessage());
      request.setAttribute("msg1","some error occured in sending mail. please try again...");
      return mapping.findForward(SUCCESS);
  }
        
request.setAttribute("msg","Link has been send.");
return mapping.findForward(SUCCESS);
}



}
