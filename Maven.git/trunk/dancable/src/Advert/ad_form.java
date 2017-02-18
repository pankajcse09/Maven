/*
 * ad_form.java
 *
 * Created on November 28, 2008, 9:34 PM
 */

package Advert;

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

public class ad_form extends org.apache.struts.action.ActionForm {
      private String save="";
      private String edit="";
     private FormFile ad_file;
     private  String head="";
     private String desc="";
     private String link="";
     private int ad_id=0;
       private String pag="";
       private String delete="";
       private String continue1="";

    public FormFile getAd_file() {
        return ad_file;
    }

    public void setAd_file(FormFile ad_file) {
        this.ad_file = ad_file;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getPag() {
        return pag;
    }

    public void setPag(String pag) {
        this.pag = pag;
    }

    public String getContinue1() {
        return continue1;
    }

    public void setContinue1(String continue1) {
        this.continue1 = continue1;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
}
