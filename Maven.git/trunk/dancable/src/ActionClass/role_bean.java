/*
 * role_bean.java
 *
 * Created on November 17, 2008, 3:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ActionClass;

/**
 *
 * @author arjun
 */
public class role_bean {
    
    /** Creates a new instance of role_bean */
    public role_bean() {
    }
    private String app="";
    private int app_id=0;
    private String lc=""; 
    private String ln="";
    private int  lid=0;
    private String app_status="";

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getApp_status() {
        return app_status;
    }

    public void setApp_status(String app_status) {
        this.app_status = app_status;
    }
  
}
