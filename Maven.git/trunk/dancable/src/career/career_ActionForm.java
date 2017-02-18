/*
 * Feed_ActionForm.java
 *
 * Created on November 25, 2008, 10:32 PM
 */

package career;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author arjun
 * @version
 */

public class career_ActionForm extends org.apache.struts.action.ActionForm {
    
    
     private  String name="";
     private String emailid="";
     private String contactno="";
     private String address="";
            
    

   private  String msg="";
            
    private FormFile feed_file;
   

    public FormFile getFeed_file() {
        return feed_file;
    }

    public void setFeed_file(FormFile feed_file) {
        this.feed_file = feed_file;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
      public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
ActionErrors errors = new ActionErrors();
    

     if((msg==null)||msg.length()==0)
    {
    errors.add("msg",new ActionMessage("errors.msg.required"));
    
    }



return errors;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

     

}
