package ActionClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.*;
import ActionClass.*;
//import sun.net.smtp.SmtpClient;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
/**
 *
 * @author kanchan
 */

public class MyActions extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success"; 
     private final static String fail = "fail"; 
        public ActionForward editRegist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean1 jb=new JavaBean1();    
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String login="";   
        if(session.getAttribute("loginid")!=null){
        login=(String)session.getAttribute("loginid");
        }   
        LoginDataObject dob=new LoginDataObject();        
        jb=(JavaBean1)dob.editRegistData(login);          
        request.setAttribute("jbean",jb);
        return mapping.findForward(SUCCESS);    
        }
        
        public ActionForward editCustomerRegist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean1 jb=new JavaBean1();    
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String login="";   
        if(session.getAttribute("loginid")!=null){
        login=(String)session.getAttribute("loginid");
        }   
        LoginDataObject dob=new LoginDataObject();        
        jb=(JavaBean1)dob.editCustomerRegistData(login);          
        request.setAttribute("jbean",jb);
        return mapping.findForward(SUCCESS);    
        }
    
        
        
         public ActionForward viewCustomerRegist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean1 jb=new JavaBean1();    
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String login="";   
        if(session.getAttribute("loginid")!=null){
        login=(String)session.getAttribute("loginid");
        }   
        LoginDataObject dob=new LoginDataObject();        
        jb=(JavaBean1)dob.editCustomerRegistData(login);          
        request.setAttribute("jbean",jb);
        return mapping.findForward(SUCCESS);    
        }
    
        
       public ActionForward logout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        session.removeAttribute("loginid");
        session.removeAttribute("password");
        session.invalidate();             
        return mapping.findForward(SUCCESS);    
       }
       
       
        public ActionForward customer_logout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        session.removeAttribute("loginid");
        session.removeAttribute("password");
        //session.removeAttribute("password");
        session.invalidate();             
        return mapping.findForward(SUCCESS);    
       }
       
       
    
         public ActionForward authenticate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        String customer="customer";
        HttpSession session=(HttpSession)request.getSession();
        //session.setMaxInactiveInterval(30);
        String usertype="";
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();       
        String loginid=(String)request.getParameter("loginid");
        String passwd=(String)request.getParameter("password");                    
        jb.setLoginid(loginid);
        jb.setPassword(passwd);     
    
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.authenticateData(jb);   
        request.setAttribute("jbean",jb);
        String msg="failure"; 
     
        if(bn==1)
        {
        session.setAttribute("loginid",loginid);
        session.setAttribute("password",passwd);
        usertype=dob.select_user_type(jb);
        out.println("usertype"+usertype);
        if(usertype.equalsIgnoreCase("emp"))
        {
             msg="emp";   
        
        }else{
           
          msg="customer";  
      
        }
        }
        else{
         request.setAttribute("msg","enter the correct username and password");   
         msg="failure";   
        }   
       // return mapping.findForward("");
   return mapping.findForward(msg);
    }
         
         
           public ActionForward customer_Authenticate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        String customer="customer";
        PrintWriter out=response.getWriter();    
        HttpSession session=(HttpSession)request.getSession();
        if(session!=null)
        {
        request.getSession(false).invalidate();
        session=(HttpSession)request.getSession(true);
        }
//        out.println(session);
        //session.setMaxInactiveInterval(30);
        String usertype="";
        String loginid="";
        String passwd="";
        String ch="";
        JavaBean1 jb=new JavaBean1();
          if(request.getParameter("emailid")!=null){
        loginid=(String)request.getParameter("emailid");
          }
          if(request.getParameter("password")!=null){
        passwd=(String)request.getParameter("password");   
          }
          
         if(request.getParameter("check")!=null){
              ch=(String)request.getParameter("check");
              if(ch.equals("login")){
                  ch="failure";
              }
              else
              {
                 ch="failure1"; 
              }
          }
          
        jb.setLoginid(loginid);
        jb.setPassword(passwd);     
    //out.println(jb.getLoginid());
    //out.println();
        String msg="failure";
        if(!loginid.equals("Username Or Email")||!passwd.equals("********"))
        {
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.customer_AuthenticateData(jb);   
//        out.println("bn: "+bn+"<br>");
        request.setAttribute("jbean",jb);
         
     
        if(bn==1)
        {
        session.setAttribute("loginid",loginid);
        session.setAttribute("password",passwd);
        usertype=dob.customer_select_user_type(jb);
//        out.println("usertype"+usertype);
        if(usertype.equalsIgnoreCase("customer"))
        {
             msg="customer";   
        
        }else{
           
          msg="emp";
          
        }
        }
        else{
         request.setAttribute("msg","Enter the correct Emailid and password!");   
         msg=ch;   
        }
        }
        else
        {
          request.setAttribute("msg","Enter the Emailid and password!");   
         msg=ch;  
        }
//        out.println("msg: "+msg);
//      return mapping.findForward("");
  return mapping.findForward(msg);
    }
         
        public ActionForward editUserAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        boolean bn=false;
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("loginid");
        String passw=(String)request.getParameter("password");
        String secques=(String)request.getParameter("secretques");
        String secans=(String)request.getParameter("secretans");    
          String last_name=(String)request.getParameter("last_name");   
          String homeaddress=(String)request.getParameter("homeaddress");   
           String homeaddress2=(String)request.getParameter("homeaddress2");   
           String city=(String)request.getParameter("city");   
           String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
           String telno=(String)request.getParameter("telno");   
            String mobileno=(String)request.getParameter("mobileno");   
        jb.setName(name);
        jb.setLoginid(loginid);
        jb.setPassword(passw);
        jb.setSecretques(secques);
        jb.setSecretans(secans);        
          jb.setHomeaddress(homeaddress);
        jb.setHomeaddress2(homeaddress2);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setTelno(telno);
        jb.setMobileno(mobileno);
        jb.setLast_name(last_name);
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.editUserData(jb);   
        request.setAttribute("jbean",jb);     
        if(bn==true){
        request.setAttribute("msg","Data Updated");    
        }
        return mapping.findForward(SUCCESS);        
        } 
    
        
          public ActionForward registUpdate_Customer(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        boolean bn=false;
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("email");
        String passw=(String)request.getParameter("password");
          String last_name=(String)request.getParameter("last_name");   
          String homeaddress=(String)request.getParameter("homeaddress");   
        //   String homeaddress2=(String)request.getParameter("homeaddress2");   
           String city=(String)request.getParameter("city");   
           String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
         //  String telno=(String)request.getParameter("telno");   
            String mobileno=(String)request.getParameter("mobileno");   
        jb.setName(name);
        jb.setLoginid(loginid);
        jb.setPassword(passw);
         jb.setEmail_id(loginid);
       
          jb.setHomeaddress(homeaddress);
       
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setMobileno(mobileno);
        jb.setLast_name(last_name);
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.editCustomerData(jb);   
        request.setAttribute("jbean",jb);  
        out.println(loginid);
        if(bn==true){
        request.setAttribute("msg","Data Updated");    
        }
       return mapping.findForward(SUCCESS);
       //  return mapping.findForward("");
        } 
    
        
        public ActionForward registUserAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        ArrayList userdetail=new ArrayList();
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("loginid");
        String passw=(String)request.getParameter("password");
        String secques=(String)request.getParameter("secretques");
        String secans=(String)request.getParameter("secretans");    
        String dep=(String)request.getParameter("dep");   
         String dep_id=(String)request.getParameter("dep_id");   
          String design=(String)request.getParameter("design");   
          
           String last_name=(String)request.getParameter("last_name");   
          String homeaddress=(String)request.getParameter("homeaddress");   
           String homeaddress2=(String)request.getParameter("homeaddress2");   
           String city=(String)request.getParameter("city");   
           String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
           String telno=(String)request.getParameter("telno");   
            String mobileno=(String)request.getParameter("mobileno");   
          
           
        jb.setName(name);
        jb.setLoginid(loginid);
        jb.setPassword(passw);
        jb.setSecretques(secques);
        jb.setSecretans(secans);     
        jb.setDep(dep);
        jb.setDep_id(dep_id);
        jb.setDes(design);
        jb.setHomeaddress(homeaddress);
        jb.setHomeaddress2(homeaddress2);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setTelno(telno);
        jb.setMobileno(mobileno);
        jb.setLast_name(last_name);
        jb.setUser_type("customer");
        
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.registUserData(jb);   
        request.setAttribute("jbean",jb);     
        if(bn==0){
          userdetail=dob.select_user();  
            
        request.setAttribute("msg","Data Submitted");
        request.setAttribute("userdetail",userdetail);   
        return mapping.findForward(SUCCESS);     
        }
        else{
        request.setAttribute("msg","Login ID Already Exists"); 
         return mapping.findForward(fail);   
        }
         
        } 
       
        
       public ActionForward pendReg(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
       {  
JavaBean1 uid= new JavaBean1();
ArrayList loginlist=new ArrayList();
ArrayList userdetail= new ArrayList();
LoginDataObject ld= new LoginDataObject();

loginlist=(ArrayList)ld.select_Userid();           
request.setAttribute("loginlist",loginlist);
return mapping.findForward("success");   
       }
       
       
       
       
        public ActionForward Request_Detail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
       {  
JavaBean1 uid= new JavaBean1();
ArrayList loginlist=new ArrayList();
LoginDataObject ld= new LoginDataObject();

int c_id=0;
        try {            
            
            c_id=Integer.parseInt((String)request.getParameter("c_id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }


uid=(JavaBean1)ld.detail_user(c_id);

loginlist=(ArrayList)ld.select_Userid();           
request.setAttribute("loginlist",loginlist);
request.setAttribute("userdetail",uid);
return mapping.findForward("success");   
       }
       
       
       
         public ActionForward registUserAction_Emp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        ArrayList userdetail=new ArrayList();
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("loginid");
        String emailid=(String)request.getParameter("emailid");
        String passw=(String)request.getParameter("password");
        String secques=(String)request.getParameter("secretques");
        String secans=(String)request.getParameter("secretans");    
        String dep=(String)request.getParameter("dep");   
         String dep_id=(String)request.getParameter("dep_id");   
          String design=(String)request.getParameter("design");   
          
           String last_name=(String)request.getParameter("last_name");   
          String homeaddress=(String)request.getParameter("homeaddress");   
           String homeaddress2=(String)request.getParameter("homeaddress2");   
           String city=(String)request.getParameter("city");   
           String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
           String telno=(String)request.getParameter("telno");   
            String mobileno=(String)request.getParameter("mobileno");             
           
        jb.setName(name);
        jb.setLoginid(loginid);
        //jb.setEmailid(emailid);
        jb.setPassword(passw);
        jb.setSecretques(secques);
        jb.setSecretans(secans);     
        jb.setDep(dep);
        jb.setDep_id(dep_id);
        jb.setDes(design);
        jb.setHomeaddress(homeaddress);
        jb.setHomeaddress2(homeaddress2);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setTelno(telno);
        jb.setMobileno(mobileno);
        jb.setLast_name(last_name);
        jb.setUser_type("emp");
        
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.registUserData_Emp(jb);   
        request.setAttribute("jbean",jb);     
        if(bn==0){
          userdetail=dob.select_user();  
            
        request.setAttribute("msg","Data Submitted");
        request.setAttribute("userdetail",userdetail);   
        return mapping.findForward(SUCCESS);     
        }
        else{
        request.setAttribute("msg","Login ID Already Exists"); 
         return mapping.findForward(fail);   
        }
         
        } 
        
          public ActionForward getPassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        ArrayList userdetail=new ArrayList();
        JavaBean1 jb=new JavaBean1();
        JavaBean1 jb1=new JavaBean1();
        PrintWriter out=response.getWriter();
        
        String email_id=(String)request.getParameter("emailid");
       
       
        out.println(email_id);
        
        jb.setEmail_id(email_id);
        
            LoginDataObject dob=new LoginDataObject();        
        bn=dob.chkloginPassword(email_id);   
        
        if(bn==0){
          request.setAttribute("msg","Please Enter Correcr Emailid");             

        }else{
        
        jb1=(JavaBean1)dob.loginPassword(email_id);
       // out.println("heekk"+jb1.getEmail_id());
        //out.println(jb1.getPassword());
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
           
           
            String msg="Please check the Login Details";
      
      msg1.setFrom(new InternetAddress("theminorsofrichmond@azansys.com"));
            
            
            
            InternetAddress[] addre = {new InternetAddress(jb1.getEmail_id())};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Login Details");
            msg1.setSentDate(new Date());
            msg1.setText(msg+"\r\n"+"Loginid:"+jb1.getEmail_id()+"\r\n"+"Password:"+jb1.getPassword());
            Transport.send(msg1,msg1.getAllRecipients());  
      
        }catch(Exception e) 
{ 
out.println("ERROR SENDING EMAIL:"+e); 
} 
            
        request.setAttribute("msg","Login Detail has been sent to your Email id");
        
        } 
        out.println(bn);
        
    //  return mapping.findForward("");
       return mapping.findForward("success");
          }
         
         
        public ActionForward registUserAction_Customer(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        ArrayList userdetail=new ArrayList();
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String last_name=(String)request.getParameter("last_name"); 
        String email_id=(String)request.getParameter("emailid");       
        String passw=(String)request.getParameter("password");
         String mobileno=(String)request.getParameter("mobileno");   
           String homeaddress=(String)request.getParameter("homeaddress");  
            String city=(String)request.getParameter("city");   
             String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
        
        jb.setName(name);
       
        jb.setPassword(passw);     
        jb.setHomeaddress(homeaddress);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setMobileno(mobileno);
        jb.setLast_name(last_name);
        jb.setUser_type("customer");
        jb.setEmail_id(email_id);
        jb.setLoginid("loginid");
//        out.println(email_id);
         LoginDataObject dob=new LoginDataObject();        
        bn=dob.registUserData_Customer(jb);   
        request.setAttribute("jbean",jb);     
        if(bn==0){
          userdetail=dob.select_user();  
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
                    return new PasswordAuthentication("sales@danceables.com","dance123"); // username and the password
                }
 });

           // Transport transport;
        //    transport = session.getTransport("smtp");
    //transport.connect("mail.azansys.com","arjun@azansys.com","helloarjun");

              MimeMessage msg1 = new MimeMessage(session);
              Common comLogin = new Common();
//              String user=comLogin.jumbleData(jb.getEmail_id());
              String user=jb.getEmail_id();
            //Set message attributes
           
//           System.out.println("'http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/customer_reg_form.do?key="+user+"'");
            StringBuffer msg=new StringBuffer("<table><tr><td>***** Please DO NOT REPLY to this automated message. *****<br><br>");
            msg=msg.append("Please click on the following link to verify your account. This link is valid for 5 days.<br>");
            msg=msg.append("<a target=\"_blank\" href='http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/activation.do?method=activate&key="+user+"'>Account Verification Link</a><br><br>");
            msg=msg.append("Loginid: "+jb.getEmail_id()+"<br>"+"Password: "+passw+"<br><br>");
            msg=msg.append("<b>Account Verification Link does not work?</b><br>");
            msg=msg.append("If you are unable to click on the link above, you can complete your email address verificaiton by copying and pasting the following URL into your browser:<br><br>");
            msg=msg.append("<a target=\"_blank\" href='http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/activation.do?method=activate&key="+user+"'>http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/activation.do?method=activate&key="+user+"</a></td></tr></table>");
      msg1.setFrom(new InternetAddress("sales@danceables.com"));
            
            
            InternetAddress[] addre = {new InternetAddress(jb.getEmail_id())};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Login Details");
            msg1.setSentDate(new Date());
            msg1.setContent(msg.toString(), "text/html; charset=utf-8");
            Transport.send(msg1,msg1.getAllRecipients());  
      
        }catch(Exception e) 
{ 
System.out.println("ERROR SENDING EMAIL:"+e); 
} 
            
        request.setAttribute("msg1","Login Detail has been sent to your Email id");
        request.setAttribute("userdetail",userdetail);   
       return mapping.findForward(SUCCESS);  
        //return mapping.findForward("");  
        }
        else{
        request.setAttribute("msg1","Email ID Already Exists"); 
         return mapping.findForward(SUCCESS);
       //  return mapping.findForward("");  
        }
         
        } 
        
public ActionForward activate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {                
        PrintWriter out=response.getWriter();    
        ArrayList ar=new ArrayList();
        String userid=request.getParameter("key");
        Common comLogin = new Common();
//        userid=comLogin.unJumbleData(userid);
//        System.out.println("User: "+userid);
        
        LoginDataObject dob=new LoginDataObject();        
           int cn=dob.activateUserAccount(userid);
           if(cn==0)
           {
               request.setAttribute("msg","Your account is now activated. Please use your registered email id to login."); 
               return mapping.findForward(SUCCESS);
           }
           else{
               request.setAttribute("msg1","Your link is now expired. Please register again."); 
               return mapping.findForward("failure");
           }
               
        }       
        
        
          public ActionForward delLoginAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {                
        PrintWriter out=response.getWriter();    
        ArrayList ar=new ArrayList();
        boolean bn=false;
        LoginDataObject dob=new LoginDataObject();        
        ar=(ArrayList)dob.loginData();           
        request.setAttribute("arr",ar);        
        return mapping.findForward(SUCCESS);        
        }       
          
        public ActionForward delLogin(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {   
        boolean bn=false;    
        PrintWriter out=response.getWriter();    
        ArrayList ar=new ArrayList();
        String id=(String)request.getParameter("para");
        LoginDataObject dob=new LoginDataObject();     
       // bn=dob.delLoginData(id);
        ar=(ArrayList)dob.loginData();           
        request.setAttribute("arr",ar);  
        request.setAttribute("msg","Login ID Deleted");
        return mapping.findForward(SUCCESS);        
        }     
        
}