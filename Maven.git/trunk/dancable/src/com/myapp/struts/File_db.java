/*
 * NewStrutsActionForm.java
 *
 * Created on May 8, 2008, 11:48 AM
 */

  package com.myapp.struts;

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

public class File_db extends org.apache.struts.action.ActionForm {
    
  

    /**
     * @return
     */
   
    public File_db() {
        super();
        // TODO Auto-generated constructor stub
    }
    private ArrayList uploads= new ArrayList();
    private String strmdate="";
    
public ArrayList getUploads() { return this.uploads; } 

public void setUploads(int index, FormFile formFile){ 
   this.uploads.add(formFile); 
} 


    /**
     * @return the strmdate
     */
    public String getStrmdate() {
        return strmdate;
    }

    /**
     * @param strmdate the strmdate to set
     */
    public void setStrmdate(String strmdate) {
        this.strmdate = strmdate;
    }

   

    


  
 
       
   
}
