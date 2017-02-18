/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moreimg;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author kapil
 */
public class Send_Mail extends org.apache.struts.action.Action {

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
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String fr_email="";
        String path="";
        fr_email=(String)request.getParameter("fr_email");
        path=(String)request.getParameter("path");
        String sub="Check This Beautiful Item...";
        
        
        PrintWriter out=response.getWriter();
        out.println(fr_email);
        out.println(path);
        try { 
            Properties props=new Properties();
            
           //smtp.gmail.com
          //  String host = "www.myluque.com"; 
         // properties.setProperty(smtp, host); 

            props.put("mail.transport.protocol","smtp");          
            props.put("mail.smtp.host","mail.azansys.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.stmp.port","587");
           
            Session session = Session.getInstance(props);
            session=Session.getDefaultInstance(props,new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("theminorsofrichmond@azansys.com","intelmind123"); // username and the password
                }
 });

           // Transport transport;
        //    transport = session.getTransport("smtp");
    //transport.connect("mail.azansys.com","arjun@azansys.com","helloarjun");

              Message msg1 = new MimeMessage(session);

            //Set message attributes
            msg1.setFrom(new InternetAddress("theminorsofrichmond@azansys.com"));
            InternetAddress[] addre = {new InternetAddress(fr_email)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject(sub);
            msg1.setSentDate(new Date());
            msg1.setText(path);
      Transport.send(msg1,msg1.getAllRecipients());
        }catch(Exception e) 
{ 
out.println("ERROR SENDING EMAIL:"+e); 
} 
        
        return mapping.findForward(SUCCESS);
        //return mapping.findForward("");
    }
}
