/*
 * status_app.java
 *
 * Created on December 26, 2008, 11:30 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mc_bean;

/**
 *
 * @author arjun
 */
public class status_app {
    
    /** Creates a new instance of status_app */
    public status_app() {
    }
    private String appname="";
    private String appstat="";
    private int appid=0;

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppstat() {
        return appstat;
    }

    public void setAppstat(String appstat) {
        this.appstat = appstat;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }
    
}
