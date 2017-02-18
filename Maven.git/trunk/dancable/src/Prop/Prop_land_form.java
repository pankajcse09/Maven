/*
 * Prop_land_form.java
 *
 * Created on October 1, 2008, 12:32 AM
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

public class Prop_land_form extends org.apache.struts.action.ActionForm {
    
   private FormFile prop_file;
     private String location ="";
     private String property="";
  private String rent="";
 private double price=0.0;
  private String condition="";
   private String area="";
   private int prop_id=0;
    private String edit="";
      private String save="";
  private  String desc="";
    private String filename="";

    public FormFile getProp_file() {
        return prop_file;
    }

    public void setProp_file(FormFile prop_file) {
        this.prop_file = prop_file;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getProp_id() {
        return prop_id;
    }

    public void setProp_id(int prop_id) {
        this.prop_id = prop_id;
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
   
    public ActionErrors validate(ActionMapping mapping,HttpServletRequest request)
    {
    ActionErrors errors=new ActionErrors();
    if((location==null)||location.length()==0)
    {
    errors.add("location",new ActionMessage("errors.location.required"));
    
    }
   
     if((rent==null)||rent.length()==0)
    {
    errors.add("rent",new ActionMessage("errors.rent.required"));
    
    }
    
    

    
     if((condition==null)||condition.length()==0)
    {
    errors.add("condition",new ActionMessage("errors.condition.required"));
    
    }
    
    
    if((area==null)||area.length()==0)
    {
    errors.add("area",new ActionMessage("errors.area.required"));
    
    }

    
    
    
    return errors;
    }
       
}
