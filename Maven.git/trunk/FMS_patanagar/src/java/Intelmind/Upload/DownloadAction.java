package Intelmind.Upload;

import javax.servlet.*;
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

public class DownloadAction extends Action{
    
    
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{           
            //set content-type to binary stream
            response.setContentType("application/octet-stream");
            
            String fname=request.getParameter("fname");           
            
            String path = getServlet().getServletContext().getRealPath("/")+"Documents\\License\\";
            path=path+fname;
            try{
            File file = new File(path);
            int length = 0;    
        ServletOutputStream op=response.getOutputStream();
        String mimetype = getServlet().getServletContext().getMimeType(fname);
      
        //
        //  Set the response and go!
        //
        //
        response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
        response.setContentLength( (int)file.length() );
        response.setHeader( "Content-Disposition", "attachment; filename=\"" + fname + "\"" );

        //
        //  Stream to the requester.
        //
        byte[] bbuf = new byte[2000];
        DataInputStream in = new DataInputStream(new FileInputStream(file));

        while ((in != null) && ((length = in.read(bbuf)) != -1))
        {
            op.write(bbuf,0,length);
        }
        in.close();
        op.flush();
        op.close();
        }catch(FileNotFoundException fe){}
        return mapping.findForward("");
      }  

}
