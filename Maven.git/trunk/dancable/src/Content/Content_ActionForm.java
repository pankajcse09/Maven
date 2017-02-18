/*
 * C_Rform.java
 *
 * Created on September 29, 2008, 1:28 PM
 */

package Content;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;


public class Content_ActionForm extends org.apache.struts.action.ActionForm {
    private String page_name="";    
     private FormFile prop_file;
     private String location ="";
     private String property="";
  private String rent="";
 private double price=0.0;
  private String condition="";
   private String area="";
   private int prop_id=0;
   private String bed="";
    private String filename="";
   private String edit="";
    private String del="";
      private String save="";
   private String desc="";
   
   
   
    public FormFile getProp_file() {
        return prop_file;
    }

    public void setProp_file(FormFile prop_file) {
        this.prop_file = prop_file;
    }

  

   

   
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
      public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }
    public ActionErrors validate(ActionMapping mapping,HttpServletRequest request)
    {
    ActionErrors errors=new ActionErrors();
    if((location==null)||location.length()==0)
    {
    errors.add("location",new ActionMessage("errors.location.required"));
    
    }
   
    
    
    
    
    
  

    
    
    
    return errors;
    }

    public String getPage_name() {
        return page_name;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
    
    
}
