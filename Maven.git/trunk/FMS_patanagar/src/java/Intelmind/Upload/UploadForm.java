package Intelmind.Upload;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm{
    
    private FormFile filename;
    private String session="";
    private String adminNo="";
//  private String equipId="";
//  private String docName="";

  /**
   * @return Returns the theFile.
   */
  public FormFile getFilename() {
    return filename;
  }
  /**
   * @param theFile The FormFile to set.
   */
  public void setFilename(FormFile filename) {
    this.filename = filename;
  }

//    public String getEquipId() {
//        return equipId;
//    }
//
//    public void setEquipId(String equipId){
//        this.equipId = equipId;
//    }

//    public String getDocName() {
//    return docName;
//    }
//
//    public void setDocName(String docName) {
//    this.docName = docName;
//    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }
    
} 