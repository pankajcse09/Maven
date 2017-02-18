/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import moreimg.*;
//import sun.net.smtp.SmtpClient;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
/**
//import java.util.Date;
//import javax.servlet.http.*;
//import javax.servlet.*;
/**
 *
 * @author compaq
 */
public class CaptchaAction extends Action {

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
        int n=0;
        String msg="";
        String page_name="";
        PrintWriter out=response.getWriter();
         page_name=request.getParameter("name");  
         ArrayList homelist =new ArrayList();
         
         function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content(page_name);
            
        request.setAttribute("homelist",homelist);
        request.setAttribute("page_name",page_name);
        String emailadd=request.getParameter("email");
        ArrayList chkemail=fd.email_get();
        //out.println(chkemail.size());
        
        //Boolean isResponseCorrect = Boolean.FALSE;
			HttpSession sess = request.getSession();
			String parm = request.getParameter("j_captcha_response");
			String c= (String)sess.getAttribute("dns_security_code") ;
                        //out.println(parm+c);
        
        for(int i=0;i<chkemail.size();i++)
        {
            String email=(String)chkemail.get(i);
            //out.println(email);
//        if(email.equals(""))
//        {
//          fd.email_Add(emailadd);  
//        }
        if(email.equals(emailadd))
        {
            n=n+1;
        }
        //out.println(n);
        }
        if(emailadd.equals(""))
        {
          request.setAttribute("msg","Please enter your email address first!");  
        }
        else if(parm.equals(""))
        {
            request.setAttribute("email_id",emailadd);
          request.setAttribute("msg","Please enter the code!");
        }
        
        else if(!(parm.equals(c)))
        {
            request.setAttribute("email_id",emailadd);
            request.setAttribute("msg","Mismatch Code! Please try again!");
            //return mapping.findForward("error");
	}
        else if(n==1)
        {
            request.setAttribute("msg", "Your email-address is already present!");
        }
        else
        {
          fd.email_Add(emailadd);  
          
           try { 
            Properties props=new Properties();
            
           //smtp.gmail.com
          //  String host = "www.myluque.com"; 
         // properties.setProperty(smtp, host); 

            props.put("mail.transport.protocol","smtp");
           // props.put("mail.transport.protocol","smtp");
           // props.put("mail.smtp.host","localhost");
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
           
           
           msg="Welcome to the Alessio Jewelry email list.Once your email has been validated, you will be receiving newsletters about our products and promotions regularly";
      
      msg1.setFrom(new InternetAddress("theminorsofrichmond@azansys.com"));
            
            
            
            InternetAddress[] addre = {new InternetAddress(emailadd)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Alessio Newsletter Verificati?on");
            msg1.setSentDate(new Date());
            msg1.setText(msg);
            Transport.send(msg1,msg1.getAllRecipients());  
      
        }catch(Exception e) 
{ 
out.println("ERROR SENDING EMAIL:"+e); 
} 
          request.setAttribute("msg","Your email address successfully Registerd");
        }
       // out.println(chk);
        
        
                        
//                        if(parm.equals("")){
//                            request.setAttribute("msg","Please enter the code!");
//                        }
//                        else if(!(parm.equals(c))){
//			request.setAttribute("msg","Invalid Code! Please try again!");
//			//return mapping.findForward("error");
//		}else{
//                            request.setAttribute("msg","Your email address successfuly received");
//                       
//                      }
   //return mapping.findForward("");
                       return mapping.findForward(page_name);
    }
}

