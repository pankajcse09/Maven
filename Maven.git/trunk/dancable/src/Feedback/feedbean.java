 /*
 * feedbean.java
 *
 * Created on November 25, 2008, 10:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Feedback;

/**
 *
 * @author arjun
 */
 public class feedbean {
    
    /** Creates a new instance of feedbean */
    public feedbean() {
    }
    
     private String dob="";
     private String emailid="";
     private String contactno="";
     private String address="";
    private String msg="";    
    private String sub="";
      private String name="";
       private int id=0;
       
       private String filename="";
       
       private java.util.Date emailRegisDate=null;
       

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the emailRegisDate
     */
    public java.util.Date getEmailRegisDate() {
        return emailRegisDate;
    }

    /**
     * @param emailRegisDate the emailRegisDate to set
     */
    public void setEmailRegisDate(java.util.Date emailRegisDate) {
        this.emailRegisDate = emailRegisDate;
    }
    
    
    
    
}
