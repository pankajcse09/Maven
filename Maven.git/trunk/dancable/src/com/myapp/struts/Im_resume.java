 /*
 * Im_resume.java
 *
 * Created on June 23, 2008, 12:30 PM
 */

  package com.myapp.struts;

  import javax.servlet.http.HttpServletRequest;
 import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author piyushrastogi
 * @version
 */

public class Im_resume extends org.apache.struts.action.ActionForm {
    
   private FormFile res_file;
    
    
    
    
   
    public Im_resume() {
        super();
        // TODO Auto-generated constructor stub
    }

    public FormFile getRes_file() {
        return res_file;
    }

    public void setRes_file(FormFile res_file) {
        this.res_file = res_file;
    }
   
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
ActionErrors errors = new ActionErrors();
    if (res_file.getFileSize() > 5000) {
        
        
        errors.add("res_file", new ActionMessage("error.uploadFile.tooBig"));
    }


return errors;
}

    
    
}
