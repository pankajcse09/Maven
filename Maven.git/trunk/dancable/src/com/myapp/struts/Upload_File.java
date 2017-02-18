/*
 * Upload_File.java
 *
 * Created on August 22, 2011, 3:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.struts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 *
 * @author user
 */
public class Upload_File {
    
    /** Creates a new instance of Upload_File */
    public Upload_File() {
    }
    
    public void upload_feedback(String location,InputStream stream)
    {
    File f = new File(location);
        try{
      
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.close();

stream.close();
bos.flush();
bos.close();
}
           
            
}
        catch(FileNotFoundException fnfe)
{
}
        catch (IOException ioe) {
}

    
    }
}
