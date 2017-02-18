
package com.myapp.struts;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kapil
 */


public class ZipDeletingSchedular implements Runnable{
    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    String path;
    File file;
    
    public ZipDeletingSchedular(String path){
        this.path=path;
    }
    @Override
    public void run() {
        java.util.Date crDate=new java.util.Date();
        java.util.Date dwnDate;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=dc.Dataconnect();
        }catch(Exception e){}
        String qr="select audiofordwnd_id,zip_name,downloaded_time from customer_downloads_zip where file_on_server='yes'";
        try{
            System.out.println("Run at "+crDate);
//            System.out.println("Query "+qr);
            ps=con.prepareStatement(qr);
            rs=ps.executeQuery();
            while(rs.next()){
                dwnDate=rs.getTimestamp("downloaded_time");
                if(dwnDate!=null){
                    long diffHours=(crDate.getTime()-dwnDate.getTime())/(60 * 60 * 1000);
//                    System.out.println("diffHours: "+diffHours);
                    if(diffHours>=18){
                        file=new File(path,rs.getString("zip_name"));
//                        System.out.println(file.getAbsolutePath());
                        if(file.exists()){
                            file.delete();
//                            System.out.println("File "+rs.getString("zip_name")+" deleted.");
                        }
                        String qr1="update customer_downloads_zip set del_time_from_server=?,file_on_server=? where audiofordwnd_id=?";
                        ps1=con.prepareStatement(qr1);
                        ps1.setTimestamp(1, new java.sql.Timestamp(crDate.getTime()));
                        ps1.setString(2, "deleted");
                        ps1.setInt(3, rs.getInt("audiofordwnd_id"));
                        ps1.executeUpdate();
                        try{
                            if(ps1!=null){ps1.close();}
                        }catch(Exception ee){}
                     }
                }
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(ps!=null){ps.close();}
                if(con!=null){con.close();}
            }catch(Exception ee){}
        }
    }
    
}
