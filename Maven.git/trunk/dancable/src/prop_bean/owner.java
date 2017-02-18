/*
 * owner.java
 *
 * Created on September 30, 2008, 5:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package prop_bean;

/**
 *
 * @author arjun
 */
public class owner {
    
    /** Creates a new instance of owner */
    public owner() {
    }
     private String  name="";
    private String  contactus="";
     private String  aboutus="";
      private String  location="";
       private String  plan="";
        private String specific ="";
         private String  amen="";
         private int ownerid=0;
         private int pid=0;
          private String filename="";
        private int img_id=0;

    public String getContactus() {
        return contactus;
    }

    public void setContactus(String contactus) {
        this.contactus = contactus;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public String getAmen() {
        return amen;
    }

    public void setAmen(String amen) {
        this.amen = amen;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
    
}
