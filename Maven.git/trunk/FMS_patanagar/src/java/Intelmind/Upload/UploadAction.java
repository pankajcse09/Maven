package Intelmind.Upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import java.io.*;
import java.util.*;
import Intelmind.Beans.*;
import Intelmind.Display.*;

public class UploadAction extends Action
{
  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{
    PrintWriter out=response.getWriter();
      UploadForm myForm=(UploadForm)form;      
      UploadBean ub=new UploadBean();

        // Process the FormFile      
        String ssn=myForm.getSession();
        String adminno=myForm.getAdminNo(); 
          
        ub.setSession(ssn);
        ub.setAdminNo(adminno);
            
    String path=getServlet().getServletContext().getRealPath("/");    
    File f=new File(path+"/StudPics/"+ub.getSession()+"/"+ub.getAdminNo());    
    if(!f.exists()){    
    f.mkdirs();   
    }
    FormFile myFile = myForm.getFilename();   
    if(myFile.getFileSize()>0){ 
    String filePath = getServlet().getServletContext().getRealPath("/")+"StudPics\\"+ub.getSession()+"\\"+ub.getAdminNo();//+myForm.getPname();
 
    UploadFile upfile=new UploadFile();
   int count=upfile.checkAdminNo(ub);
   if(count!=0){       
   int bn=upfile.uploadPics(ub,myFile,filePath);   
   //Set file name to the request object
   request.setAttribute("fileName",myFile.getFileName());
   if(bn==0){
   request.setAttribute("msg","File has been Uploaded!"); 
   }else{
   request.setAttribute("msg","Document Name or File Name Already Exists");     
   }
   }else{
   request.setAttribute("msg","No Such Admission No. Available");      
   }
   }else{
   request.setAttribute("msg","Upload Valid File Name");      
   }   
 return mapping.findForward("upload");
  }
} 