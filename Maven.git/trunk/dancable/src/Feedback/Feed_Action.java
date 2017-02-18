 /*
 * Feed_Action.java
 *
 * Created on November 25, 2008, 10:38 PM
 */

package Feedback;

import com.myapp.struts.Im_ResumeUtilty;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
//import sun.net.smtp.SmtpClient;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
/**
 *
 * @author arjun
 * @version
 */

public class Feed_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
     private final static String suc = "fedfor";
   
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
        
        String page_name="contactus";
                ArrayList homelist =new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content("contactus");
            
        request.setAttribute("homelist",homelist);
        request.setAttribute("page_name",page_name);

        
       PrintWriter out=response.getWriter();
         Feed_ActionForm fed=(Feed_ActionForm)form;
         feedbean fdbean=new feedbean();
      //  FormFile fed_file = fed.getFeed_file();       
        String sub="";
            
        String msg="";
              
      //  String contentType = fed_file.getContentType();
     //   String fileName    = fed_file.getFileName();
       // int fileSize       = fed_file.getFileSize();
        ActionErrors errors = new ActionErrors();
        String name="";
                
         String emailid="";
        
        String contactno="";
               // PrintWriter out=response.getWriter();
        String address="";
          msg=request.getParameter("msg");
            sub=request.getParameter("sub");
               name=request.getParameter("name");
                emailid=request.getParameter("emailid");
                 contactno=request.getParameter("contactno");
                   
        fdbean.setName(name);
        fdbean.setAddress(address);
        fdbean.setContactno(contactno);
        fdbean.setEmailid(emailid);
        fdbean.setSub(sub);
        fdbean.setMsg(msg);
       //String from="anbarasu_83@yahoo.com"; 
String to=emailid; 
        try { 
            Properties props=new Properties();
            
           //smtp.gmail.com
          //  String host = "www.myluque.com"; 
         // properties.setProperty(smtp, host); 

            props.put("mail.transport.protocol","smtp");
           // props.put("mail.transport.protocol","smtp");
           // props.put("mail.smtp.host","localhost");
            props.put("mail.smtp.host","mail.danceables.com");
             props.put("mail.smtp.auth", "true");
            props.put("mail.stmp.port","25");
           
            Session session = Session.getInstance(props);
            session=Session.getDefaultInstance(props,new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("feedback@danceables.com","admin123"); // username and the password
                }
 });

           // Transport transport;
        //    transport = session.getTransport("smtp");
    //transport.connect("mail.azansys.com","arjun@azansys.com","helloarjun");

              Message msg1 = new MimeMessage(session);

            //Set message attributes
            msg1.setFrom(new InternetAddress("feedback@danceables.com"));
            InternetAddress[] addre = {new InternetAddress(emailid)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject(sub);
            msg1.setSentDate(new Date());
            msg1.setText(msg);
      Transport.send(msg1,msg1.getAllRecipients());
      
      MimeMessage msg2=new MimeMessage(session); 
       msg2.setFrom(new InternetAddress("feedback@danceables.com"));
       InternetAddress[] addre2 = {new InternetAddress("stevenvmitchell@gmail.com")};
       msg2.setRecipients(Message.RecipientType.TO, addre2);
       msg2.setSubject("Customer Feedback");
       msg2.setSentDate(new Date());
       msg2.setText(msg);
       Transport.send(msg2,msg2.getAllRecipients());
        }catch(Exception e) 
{ 
out.println("ERROR SENDING EMAIL:"+e); 
} 

        
        
         //errors.add(ActionErrors.GLOBAL_ERROR,
        //new ActionError("errors.database.error"));
        
 //InputStream file_ctnt=  fed_file.getInputStream();
       Im_ResumeUtilty dd=new Im_ResumeUtilty();
     boolean tr= dd.fed_db("",fdbean);
    // out.println(tr);
   //  out.println("contentType"+contentType);
     
     
     
   

   
    


   
    
         
         
//         
//         if(tr==true)
//         {
//  
//      
//       String dir=getServlet().getServletContext().getRealPath("/fb_file/"+fileName); 
//        File f = new File(dir);
//        try{
//        InputStream stream =fed_file.getInputStream();
//        OutputStream bos = new FileOutputStream(f);
//        int bytesRead = 0;
//byte[] buffer = new byte[5000 * 1024];
//while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
//bos.write(buffer, 0, bytesRead);
//bos.close();
//
//stream.close();
//}
//           
//            
//}
//        catch(FileNotFoundException fnfe)
//{
//}
//        catch (IOException ioe) {
//}
// fed_file.destroy();
//       
//         
//         
//         
//         
//    
//     //  return mapping.findForward("");
//     
//    
//         }
    request.setAttribute("fedup","Your FeedBack  has been sent Sucessfully!");
//    return mapping.findForward("");
     return mapping.findForward(suc);
       
    
        
        
    }
}
