package Intelmind.Upload;

import Intelmind.Beans.*;
import Intelmind.Display.*;
import com.myapp.struts.Dataconnectivity;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
import org.apache.struts.upload.FormFile;

public class DownloadFile {
    
    /**
     * Creates a new instance of UploadFile
     */
    public DownloadFile(){}
    
    public void download(UploadBean ub,FormFile myFile,String filePath){
//    try{   
//     File file = new File("/code.conventions.pdf");
//
//            //prepare input stream
//            BufferedInputStream in =new BufferedInputStream(new FileInputStream(file));
//
//            //prepare output stream
//            BufferedOutputStream out =new BufferedOutputStream(response.getOutputStream());
//
//            //start reading and writing data
//            byte[] buf = new byte[4 * 1024];
//            int bytesRead;
//            while ((bytesRead = in.read(buf)) != -1) {
//            out.write(buf, 0, bytesRead);
//            }
//            in.close();
//            out.close();
//     }
//     catch(FileNotFoundException fe){}
//    catch(IOException ioe){}
//   //Set file name to the request object     
//    return 0;
    }
    
}
