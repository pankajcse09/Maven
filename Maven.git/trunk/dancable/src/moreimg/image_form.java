/*
 * NewStrutsActionForm.java
 *
 * Created on May 8, 2008, 11:48 AM
 */

package moreimg;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author piyushrastogi
 * @version
 */

public class image_form extends org.apache.struts.action.ActionForm {
    
  

    /**
     * @return
     */
   
    public image_form() {
        super();
        // TODO Auto-generated constructor stub
    }
    private ArrayList uploads= new ArrayList(); 
    
     private FormFile file1;
      private FormFile ad_file;
public ArrayList getUploads() { return this.uploads; } 

public void setUploads(int index, FormFile formFile){ 
   this.uploads.add(formFile); 
} 

    public FormFile getFile1() {
        return file1;
    }

    public void setFile1(FormFile file1) {
        this.file1 = file1;
    }

   

       
   
}
