package ActionClass;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 *
 * @author kanchan
 */
public class Backup extends DispatchAction{ 
public ActionForward exportData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {       
//String path="c:/Backup/back.sql";  
//String path=(String)request.getRealPath("/backup/");           
//path=path+"/backup.cmd";    
PrintWriter out=response.getWriter();
Runtime rt = Runtime.getRuntime();
try{ 
Process proc=rt.exec("C:/backup.cmd"); 
}
catch(Exception e){out.println("error");}
return mapping.findForward("success");
} 

public ActionForward importData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{   
//String path="c:/Backup/back.sql"; 
//String path=(String)request.getRealPath("/backup/"); 
//path=path+"/backup.cmd"; 
Runtime rt = Runtime.getRuntime();
try { 
Process proc=rt.exec("C:/import.cmd");
}
catch (Exception e){} 
return mapping.findForward("success");
}
} 

