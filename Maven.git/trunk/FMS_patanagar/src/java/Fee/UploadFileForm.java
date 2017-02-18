/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author kapil
 */
public class UploadFileForm extends org.apache.struts.action.ActionForm {
    
    private String session="";
    private String batch="";
    private String degree="";
    private FormFile uploads1;

    public UploadFileForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the session
     */
    public String getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @param degree the degree to set
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * @return the uploads1
     */
    public FormFile getUploads1() {
        return uploads1;
    }

    /**
     * @param uploads1 the uploads1 to set
     */
    public void setUploads1(FormFile uploads1) {
        this.uploads1 = uploads1;
    }

}
