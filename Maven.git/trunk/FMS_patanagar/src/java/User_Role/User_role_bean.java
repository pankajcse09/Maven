/*
 * User_role__dao.java
 *
 * Created on October 15, 2010, 2:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package User_Role;

import java.io.Serializable;

/**
 *
 * @author NEW
 */
public class User_role_bean implements Serializable{
    
    /** Creates a new instance of User_role__dao */
    public User_role_bean() {
    }
    
    
   private  int id=0;
   
   private String ur_read="";
   private String ur_delete="";
   private String ur_update="";
   private String ur_create="";
   private String ur_level="";
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUr_read() {
        
        return ur_read;
    }

    public void setUr_read(String ur_read) {
         if(ur_read==null || ur_read.equals("null")){ur_read="";}
        this.ur_read = ur_read;
    }

    public String getUr_delete() {
        return ur_delete;
    }

    public void setUr_delete(String ur_delete) {
          if(ur_delete==null || ur_delete.equals("null")){ur_delete="";}
        this.ur_delete = ur_delete;
    }

    public String getUr_update() {
        return ur_update;
    }

    public void setUr_update(String ur_update) {
         if(ur_update==null || ur_update.equals("null")){ur_update="";}
        this.ur_update = ur_update;
    }

    public String getUr_create() {
        return ur_create;
    }

    public void setUr_create(String ur_create) {
         if(ur_create==null || ur_create.equals("null")){ur_create="";}
        this.ur_create = ur_create;
    }

    public String getUr_level() {
        return ur_level;
    }

    public void setUr_level(String ur_level) {
           if(ur_level==null || ur_level.equals("null")){ur_level="";}
        this.ur_level = ur_level;
    }
   
   
   
    
}
