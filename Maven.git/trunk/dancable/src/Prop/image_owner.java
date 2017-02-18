/*
 * image_owner.java
 *
 * Created on October 1, 2008, 5:51 AM
 */

package Prop;

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

public class image_owner extends org.apache.struts.action.ActionForm {
     private FormFile prop_file;

    public FormFile getProp_file() {
        return prop_file;
    }

    public void setProp_file(FormFile prop_file) {
        this.prop_file = prop_file;
    }
  
}
