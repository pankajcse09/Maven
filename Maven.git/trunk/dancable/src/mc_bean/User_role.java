/*
 * User_role.java
 *
 * Created on October 20, 2008, 10:39 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mc_bean;

import java.util.ArrayList;

/**
 *
 * @author arjun
 */
public class User_role {
    
    /** Creates a new instance of User_role */
    public User_role() {
    }
   
   private  String userid="";
 private  String ro_edit="";
private String ro_create="";
 private String ro_read="";

private String ro_del="";

 private int  roleid=0;
private String mc="";
 private int  mc_id=0;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRo_edit() {
        return ro_edit;
    }

    public void setRo_edit(String ro_edit) {
        this.ro_edit = ro_edit;
    }

    public String getRo_create() {
        return ro_create;
    }

    public void setRo_create(String ro_create) {
        this.ro_create = ro_create;
    }

    public String getRo_read() {
        return ro_read;
    }

    public void setRo_read(String ro_read) {
        this.ro_read = ro_read;
    }

    public String getRo_del() {
        return ro_del;
    }

    public void setRo_del(String ro_del) {
        this.ro_del = ro_del;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public int getMc_id() {
        return mc_id;
    }

    public void setMc_id(int mc_id) {
        this.mc_id = mc_id;
    }

   
    
}

   