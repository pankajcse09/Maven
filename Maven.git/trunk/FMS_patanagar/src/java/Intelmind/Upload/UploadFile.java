package Intelmind.Upload;

import Intelmind.Beans.*;
import Intelmind.Display.*;
import com.myapp.struts.Dataconnectivity;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
import org.apache.struts.upload.FormFile;

public class UploadFile {
    
    /**
     * Creates a new instance of UploadFile
     */
    public UploadFile(){}       
    
    static PreparedStatement psmt=null; 
    static PreparedStatement psmt2=null; 
    static PreparedStatement psmt3=null; 
    static ResultSet rs=null;
    static ResultSet rs2=null;
    static ResultSet rs3=null;
    
    public int checkAdminNo(UploadBean ub){
    Connection con=null; 
    int count=0;
    try{ 
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect(); 
    }catch(Exception e){} 
    String qr2="select count(*) as cnt from studentregis where session='"+ub.getSession()+"' and srnum='"+ub.getAdminNo()+"'";
    try{
    psmt2=con.prepareStatement(qr2);   
    rs2=psmt2.executeQuery();
    rs2.next();
    count=rs2.getInt("cnt");
    }catch(SQLException se){}
    finally{
    try{
    if(rs2!=null){rs2.close();} 
    if(psmt2!=null){psmt2.close();} 
    if(con!=null){con.close();} 
    }catch(SQLException se){}
    }
    return count;
    }
    
    public int uploadPics(UploadBean ub,FormFile myFile,String filePath){     
    Connection con=null; 
    int count=0;
    String fileName = myFile.getFileName();    
 
    try{   
    String contentType = myFile.getContentType();
       //Get the file name        
        //int fileSize = myFile.getFileSize();
        byte[] fileData = myFile.getFileData();
    //Get the servers upload directory real path name
    
    /* Save file on the server */
    if(!fileName.equals("")){  
        //System.out.println("Server path:" +filePath);
        //Create file
        File fileToCreate = new File(filePath, ub.getAdminNo()+".jpg");
        //If file does not exists create file 
        if(fileToCreate.exists()){
        fileToCreate.delete();    
        }             
          FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
          fileOutStream.write(myFile.getFileData());
          fileOutStream.flush();
          fileOutStream.close();       
     }     
    }catch(FileNotFoundException fe){}
     catch(IOException ioe){}
    
   //Set file name to the request object     
    return count;
    }
    
}
