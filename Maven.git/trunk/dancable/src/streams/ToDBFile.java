/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package streams;

import Main_category.item_bean;
import com.myapp.struts.Dataconnectivity;
import com.myapp.struts.Im_Projects_DataHold;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import moreimg.img_bean;

/**
 *
 * @author kapil
 */
public class ToDBFile {
    Connection con = null;
         PreparedStatement ps = null;
          ResultSet rs = null;
          
public void  insert_ItemMore_Sample(String filename,String pagename,String scid,String tiltle)throws Exception 
    {
         
    String platylist="inplaylist";
//    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into moreaudio_samples(audiofile,itemid,sc_id,playlist,title)values(?,?,?,?,?)";
            ps=con.prepareStatement(sqlString);
             ps.setString(1,filename);
             ps.setInt(2,Integer.parseInt(pagename));
          ps.setInt(3,Integer.parseInt(scid));
            ps.setString(4,platylist);
             ps.setString(5,tiltle);
     ps.executeUpdate();
      
      
    }

      
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
     }

 public ArrayList gal_ItemAudioSapmle(int id)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select title,audiofile,id,playlist from moreaudio_samples where itemid="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  prodetail.setTitle(rs.getString("title"));
    prodetail.setFilename(rs.getString("audiofile"));
    prodetail.setId(rs.getInt("id"));
   prodetail.setIsPlaylist(rs.getString("playlist"));
   
    product_list.add(prodetail);
    
  }
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return product_list;
    
    }
 
public ArrayList gat_ItemAudioSapmle(int id)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select title,audiofile,id,playlist from moreaudio_samples where itemid="+id+" and playlist='inplaylist'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  prodetail.setTitle(rs.getString("title"));
    prodetail.setFilename(rs.getString("audiofile"));
    prodetail.setId(rs.getInt("id"));
   prodetail.setIsPlaylist(rs.getString("playlist"));
   
    product_list.add(prodetail);
  }
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return product_list;
    
    }
  
 
 public String retCoverImage(int id)throws Exception
    {
    
    String imagename="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select filename from item where item_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        imagename=rs.getString("filename");
    }
  }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return imagename;
    
    }
     
 public String retMoreImagefilename(int id)throws Exception
    {
    
    String imagename="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select image from itemimage where id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        imagename=rs.getString("image");
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return imagename;
    
    }
 
public void updateCoverImage(String cvimg,int itemid)throws Exception
 {
     try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
    
     String sqlString ="update item set filename='"+cvimg+"' where item_id="+itemid;
            ps=con.prepareStatement(sqlString);
//             ps.setString(1,cvimg);
//             ps.setInt(2,itemid);
          
     ps.executeUpdate();
     }catch(Exception e){System.out.println("Update Item: "+e.getMessage());}
     
     try{
         if ( ps != null ) {ps.close();}
         String sqlString1 ="update imd_cart set filename='"+cvimg+"' where item_id="+itemid;
         String sqlString2 ="update imd_cart_order set filename='"+cvimg+"' where item_id="+itemid;
         String sqlString3 ="update mywishlist set filename='"+cvimg+"' where item_id="+itemid;
         ps=con.prepareStatement(sqlString1);
            ps.executeUpdate();
            if ( ps != null ) {ps.close();}
            
            ps=con.prepareStatement(sqlString2);
            ps.executeUpdate();
            if ( ps != null ) {ps.close();}
            
            ps=con.prepareStatement(sqlString3);
            ps.executeUpdate();
      }catch(Exception e){System.out.println("Update Item: "+e.getMessage());}
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
 }

public void updateNextCoverImage(String nxtimg,int rwid)throws Exception
 {
     try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
    
     String sqlString ="update itemimage set image=? where id=?";
            ps=con.prepareStatement(sqlString);
             ps.setString(1,nxtimg);
             ps.setInt(2,rwid);
          
     ps.executeUpdate();
     }catch(Exception e){{System.out.println("Update Item Image: "+e.getMessage());}}
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
 }

public void addRemoveAudioInPlaylist(String pl,int rwid)throws Exception
 {
     try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
    
     String sqlString ="update moreaudio_samples set playlist=? where id=?";
            ps=con.prepareStatement(sqlString);
             ps.setString(1,pl);
             ps.setInt(2,rwid);
          
     ps.executeUpdate();
     }catch(Exception e){{System.out.println("Update Item Audio: "+e.getMessage());}}
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
 }

public String retMoreAudiofilename(int id)throws Exception 
    {
    
    String audiofile="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select audiofile from moreaudio_samples where id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        audiofile=rs.getString("audiofile");
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return audiofile;
    
    }

public ArrayList gat_everyDayAudioOnDate(String date,String page)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Date stdt=null;
    try{
    stdt=new java.sql.Date(sde.parse(sde.format(sdf.parse(date))).getTime());
    }
    catch(Exception e){}
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from everyday_stream where pagename='"+page+"' and stream_date='"+stdt+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   img_bean ad=new img_bean();
   ad.setPage_name(rs.getString("pagename"));   
   ad.setSampleFileName(rs.getString("filename"));
   ad.setSampleTitle(rs.getString("title"));
   ad.setDate(sdf.format(rs.getDate("stream_date")));
   ad.setStatus(rs.getString("status"));
   ad.setHead_id(rs.getInt("rwid"));
    product_list.add(ad);
    }
    
    
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return product_list;
    
    }

public String retUpdateEvdAudioStatus(int id,String upd)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="update everyday_stream set status='"+upd+"' where rwid="+id;
    pstmt=conn.prepareStatement(pro_title);
    pstmt.executeUpdate();
    
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
     return upd;
    
    }
public String retEvdAudiofilename(int id)throws Exception
    {
    
    String audiofile="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select filename from everyday_stream where rwid="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        audiofile=rs.getString("filename");
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return audiofile;
    
    }

public int checkDownloadAvailability(String order_id,String user)throws Exception
{
    int count=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    String chk="select count(download) as cnt from imd_cart_order where user_id='"+user+"' and order_id='"+order_id+"' and download='0'";
//    System.out.println("check: "+chk);
    pstmt=conn.prepareStatement(chk);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        count=rs.getInt("cnt");
    }
    if(count==0)
    {
        count=1;
    }
    else
    {
        count=0;
    }
        
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
      }
    return count;
}

public HashMap gat_userDownloadingFile(String order_id,String user)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList al=new ArrayList();
    
    HashMap hm=new HashMap();
    item_bean ad=null;
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
    String pro_title="select item_id,sc_id,brand from imd_cart_order left join sub_cat on sc_id=sub_cat_id where user_id='"+user+"' "
            + "and order_id='"+order_id+"' and download='0' and shp_charge_status='no'";
//    System.out.println("Query1: "+pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        ArrayList audiolist=new ArrayList();
        ad=new item_bean();
        ad.setItem_id(rs.getInt("item_id"));
        ad.setSubcat_id(rs.getInt("sc_id"));
        ad.setBrand(rs.getString("brand"));
        al.add(ad);
        
        try{
        String qr="select title,audio_name,rwid from audiofordwnd where sc_id='"+rs.getInt("sc_id")+"' and item_id='"+rs.getInt("item_id")+"'"; 
//        System.out.println("Query2: "+qr);
        pstmt1=conn.prepareStatement(qr);
        rs1=pstmt1.executeQuery();
        while(rs1.next())
        {
            item_bean ib=new item_bean();
            ib.setRowid(rs1.getLong("rwid"));
            ib.setAudioFileName(rs1.getString("audio_name"));
            ib.setTitle(rs1.getString("title"));
            audiolist.add(ib);
        }
        hm.put(rs.getString("brand"), audiolist);
        audiolist=(ArrayList)hm.get(rs.getString("brand"));
        //audiolist.clear();
        }catch(Exception ee){}
        finally{
        if ( rs1 != null ) {rs1.close();}
        if ( pstmt1 != null ) {pstmt1.close();}
        }
        
        
    }
    hm.put("orderlist", al);
   String update="update imd_cart_order set download='1' where user_id='"+user+"' and order_id='"+order_id+"'";
//        System.out.println("Query: "+update);
        pstmt1=conn.prepareStatement(update);
        pstmt1.executeUpdate();
        if ( pstmt1 != null ) {pstmt1.close();} 
    
    }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
         if ( rs1 != null ) {rs1.close();}
        if ( pstmt1 != null ) {pstmt1.close();}
        if ( conn != null ) {conn.close();}
     }
    return hm;
    
    }

public void addToZipFile(String path,String fileName, ZipOutputStream zos){
//System.out.println("complete file path: "+path+File.separator+fileName);
//		System.out.println("Writing '" + fileName + "' to zip file");
try{
		File file = new File(path+File.separator+fileName);
                if(file.exists()){
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) > 0) {
			zos.write(bytes, 0, length);
		}

//		zos.closeEntry();
		fis.close();
                }
}
 catch (FileNotFoundException e) {
         e.printStackTrace();
   } catch (IOException e) {
         e.printStackTrace();
       }
}


public void  insert_Dwn_Music(StreamBean sb)throws Exception 
    {
         
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
     
      String sqlString ="insert into audiofordwnd(title,item_id,sc_id,audio_name,add_date)values(?,?,?,?,?)";
            ps=con.prepareStatement(sqlString);
             ps.setString(1,sb.getTitle());
             ps.setInt(2,sb.getItem_id());
          ps.setInt(3,sb.getSc_id());
            ps.setString(4,sb.getFilename());
             ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
     ps.executeUpdate();
      
      
    }
catch(Exception e){System.out.println("Exp: "+e.getMessage());}
      
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
     }

public ArrayList get_ItemAudioFileToDownload(int id)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select title,audio_name,rwid from audiofordwnd where item_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  prodetail.setTitle(rs.getString("title"));
    prodetail.setFilename(rs.getString("audio_name"));
    prodetail.setRowid(rs.getLong("rwid"));
   
   
    product_list.add(prodetail);
    
  }
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return product_list;
    
    }
 
public String retDwnAudiofilename(long id)throws Exception
    {
    
    String audiofile="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select audio_name from audiofordwnd where rwid="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        audiofile=rs.getString("audio_name");
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return audiofile;
    
    }

public int get_userTotalDownloadingFile(String order_id,String user)
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    
    int count=0;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
    String pro_title="select item_id,sc_id,brand from imd_cart_order where user_id='"+user+"' and order_id='"+order_id+"'";
//     System.out.println("Query: "+pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        try{
        String qr="select count(*) as cnt from audiofordwnd where sc_id='"+rs.getInt("sc_id")+"' and item_id='"+rs.getInt("item_id")+"'"; 
//        System.out.println("Query: "+qr);
        pstmt1=conn.prepareStatement(qr);
        rs1=pstmt1.executeQuery();
        while(rs1.next())
        {
            count=count+rs1.getInt("cnt");
        }
//System.out.println("count: "+count);
        }catch(Exception ee){System.out.println("Exx: "+ee.getMessage());}
        finally{
        if ( rs1 != null ) {rs1.close();}
        if ( pstmt1 != null ) {pstmt1.close();}
        }
        
    }
   }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally {
         try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
         if ( rs1 != null ) {rs1.close();}
        if ( pstmt1 != null ) {pstmt1.close();}
        if ( conn != null ) {conn.close();}
         }catch(Exception ee){}
         }
     
    return count;
    
    }

public int checkTotalUserDownloads(String order_id,String user)
{
    int count=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    String chk="select total_download_files as cnt from imd_cart_order where user_id='"+user+"' and order_id='"+order_id+"'";
//    System.out.println("chk: "+chk);
    pstmt=conn.prepareStatement(chk);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        count=rs.getInt("cnt");
    }
    
        
    }catch(Exception e){}
    finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
    return count;
}

public item_bean get_AudioFileToDownload(long id)
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=new item_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select audio_name,rwid,item_id,sc_id from audiofordwnd where rwid="+id;
//    System.out.println("FileQuery: "+pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        ib.setRowid(rs.getLong("rwid"));
        ib.setFilename(rs.getString("audio_name"));
        ib.setItem_id(rs.getInt("item_id"));
        ib.setSubcat_id(rs.getInt("sc_id"));
  }
    }catch(Exception e){}
    finally {
         try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
     }
    return ib;
    
    }

public int checkIn_CustomerDownloads(long id,String od,String chk,String table)
{
    int count=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    String qr="";
    if(chk.equals("completed"))
    {
        qr="select count(*) as cn from "+table+" where order_id=? and audiofordwnd_id=? and file_downloading='completed'";
    }
    else{
        qr="select count(*) as cn from "+table+" where order_id=? and audiofordwnd_id=?";
    }
//    System.out.println("chk: "+chk);
    pstmt=conn.prepareStatement(qr);
    pstmt.setString(1, od);
    pstmt.setLong(2, id);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        count=rs.getInt("cn");
    }
    
        
    }catch(Exception e){}
    finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
    return count;
}

public void insertInto_customer_downloads(item_bean ib)
{
    Timestamp timestamp=new Timestamp(new java.sql.Date(new java.util.Date().getTime()).getTime());
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
        Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
        String sqlString ="insert into customer_downloads(audiofordwnd_id,item_id,sc_id,filename,download_on,user_id,order_id)values(?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sqlString);
             pstmt.setLong(1,ib.getRowid());
             pstmt.setInt(2,ib.getItem_id());
          pstmt.setInt(3,ib.getSubcat_id());
            pstmt.setString(4,ib.getFilename());
             pstmt.setTimestamp(5, timestamp);
             pstmt.setString(6,ib.getUser_id());
             pstmt.setString(7,ib.getOrder_id());
     pstmt.executeUpdate();
    } catch(Exception e){System.out.println("Expp: "+e.getMessage());}
    finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
}

public void update_inserted_customer_downloads(item_bean ib)
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
        Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
        String sqlString ="update customer_downloads set file_downloading=? where audiofordwnd_id=?";
            pstmt=conn.prepareStatement(sqlString);
             pstmt.setString(1,"Completed");
             pstmt.setLong(2,ib.getRowid());
          
     pstmt.executeUpdate();
    } catch(Exception e){}
    finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
}

public void  insert_written_Music(StreamBean sb)throws Exception 
    {
         
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
     String sqlString="";
     if(sb.getTp().equals("sm"))
        {
       sqlString ="insert into written_sample(title,item_id,sc_id,file_name,add_date)values(?,?,?,?,?)";
        }
       else{
           sqlString ="insert into audiofordwnd(title,item_id,sc_id,audio_name,add_date)values(?,?,?,?,?)";
       }
      
            ps=con.prepareStatement(sqlString);
             ps.setString(1,sb.getTitle());
             ps.setInt(2,sb.getItem_id());
          ps.setInt(3,sb.getSc_id());
            ps.setString(4,sb.getFilename());
             ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
     ps.executeUpdate();
      
      
    }
catch(Exception e){System.out.println("Exp: "+e.getMessage());}
      
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
     }

public ArrayList get_ItemWrtnSapmle(int id)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select title,file_name,rwid from written_sample where item_id="+id;
//    System.out.println("query: "+pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  prodetail.setTitle(rs.getString("title"));
    prodetail.setFilename(rs.getString("file_name"));
    prodetail.setRowid(rs.getLong("rwid"));
  
    product_list.add(prodetail);
    
  }
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return product_list;
    
    }

public String retWrtnSamplefilename(long id)throws Exception 
    {
    
    String file_name="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select file_name from written_sample where rwid="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        file_name=rs.getString("file_name");
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return file_name;
    
    }

public item_bean search_order(String order_id)throws Exception
  {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select prod_id,shiiping_charge,brand,user_id,filename,item_id,price,quantity,total,order_date,prod_id,size from imd_cart_order"
            + " where order_id=?";
    pstmt=conn.prepareStatement(pro_title);
    pstmt.setString(1, order_id);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
    det.setProd_id(rs.getString("prod_id"));
    det.setBrand(rs.getString("brand"));
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));    
    det.setPrice(rs.getDouble("price"));    
    det.setQuantity(rs.getInt("quantity"));
    det.setSubtotal(rs.getDouble("total"));
    det.setCartdate(rs.getDate("order_date"));
    det.setUser_id(rs.getString("user_id"));
    det.setProd_id(rs.getString("prod_id"));
    det.setSize(rs.getString("size"));
    det.setShip_charge(rs.getDouble("shiiping_charge"));

    item_list.add(det);
    }
    itmb.setDataArray(item_list);
       
    String qr="select user_id,order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status from imd_cart_order"
            + " where order_id=?";
    pst=conn.prepareStatement(qr);
    pst.setString(1, order_id);
    rs1=pst.executeQuery();
    if(rs1.next())
    {
        item_bean ib=new item_bean();
        ib.setUser_id(rs1.getString("user_id"));
     ib.setOrder_date(rs1.getDate("order_date"));
     ib.setShip_charge(rs1.getDouble("shiiping_charge"));
//     System.out.println("Ship: "+rs1.getDouble("shiiping_charge"));
     ib.setOrder_id(rs1.getString("order_id"));
     ib.setInvoice_no(rs1.getString("invoice_no"));
     ib.setBill_f_name(rs1.getString("bill_cusName"));
     ib.setBill_phone(rs1.getString("bill_mobileno"));
     ib.setBill_street(rs1.getString("bill_street"));
     ib.setBill_city(rs1.getString("bill_city"));
     ib.setBill_state(rs1.getString("bill_state"));
     ib.setBill_country(rs1.getString("bill_country"));
     ib.setBill_zip(rs1.getString("bill_pincode"));
     ib.setShip_f_name(rs1.getString("bill_cusName"));
     ib.setShip_phone(rs1.getString("bill_mobileno"));
     ib.setShip_street(rs1.getString("bill_street"));
     ib.setShip_city(rs1.getString("bill_city"));
     ib.setShip_state(rs1.getString("bill_state"));
     ib.setShip_country(rs1.getString("bill_country"));
     ib.setShip_zip(rs1.getString("bill_pincode"));
     ib.setStatus(rs1.getString("shp_status"));
     item_list1.add(ib);
    }
    itmb.setDataArray1(item_list1);
    
    }catch(Exception e){
    
    
    }
    
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
    return itmb;
    
    }
public int chekResendlink(String user_id,String order_id)throws Exception
{
    int cn=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String qr="Select resend_link from imd_cart_order where user_id=? and order_id=? group by order_id";
    pstmt=conn.prepareStatement(qr);
    pstmt.setString(1, user_id);
    pstmt.setString(2, order_id);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        cn=rs.getInt("resend_link");
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
    }
    return cn;
}
public void updateResendlink(String user_id,String order_id,int cn)throws Exception
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String qr="update imd_cart_order set resend_link=? where user_id=? and order_id=?";
    pstmt=conn.prepareStatement(qr);
    pstmt.setInt(1, cn+1);
    pstmt.setString(2, user_id);
    pstmt.setString(3, order_id);
    pstmt.executeUpdate();
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
    }
}
public void updateDownloadFeildsForDwnloads(String user_id,String order_id)throws Exception
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String qr="update imd_cart_order set download=? where user_id=? and order_id=?";
    pstmt=conn.prepareStatement(qr);
    pstmt.setInt(1, 0);
    pstmt.setString(2, user_id);
    pstmt.setString(3, order_id);
    pstmt.executeUpdate();
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
    }
}

public void  insert_content_file(StreamBean sb)throws Exception 
    {
         
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
     String sqlString="";
     
       sqlString ="update item set cover_content=? where item_id=?";
            ps=con.prepareStatement(sqlString);
             ps.setString(1,sb.getFilename());
             ps.setInt(2,sb.getItem_id());
          
     ps.executeUpdate();
      
      
    }
catch(Exception e){System.out.println("Exp: "+e.getMessage());}
      
finally {
    if ( rs != null ) {rs.close();}
    if ( ps != null ) {ps.close();}
    if ( con != null ) {con.close();}
 }
     }
public ArrayList get_contentfile(int id)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select cover_content,item_id from item where item_id="+id;
//    System.out.println("query: "+pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
    item_bean ib=new item_bean();
    ib.setCover_content(rs.getString("cover_content"));
    ib.setItem_id(rs.getInt("item_id"));
    product_list.add(ib);
    
  }
    }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return product_list;   
 }

public void saveZipFile(String order_id,String user_id,String filename)throws Exception
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String qr="insert into customer_downloads_zip(order_id,user_id,zip_name,zip_date,file_downloading,click_count,file_on_server) values(?,?,?,?,?,?,?)";
    pstmt=conn.prepareStatement(qr);
    pstmt.setString(1, order_id); 
    pstmt.setString(2, user_id);
    pstmt.setString(3, filename);
    pstmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
    pstmt.setString(5, "Uncomplete");
    pstmt.setInt(6, 0);
    pstmt.setString(7, "yes");
    pstmt.executeUpdate();
   }catch(Exception e){System.out.println("Excc: "+e.getMessage());}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
    }
}

public item_bean retZipFileDetail(String filename,String order_id){
    item_bean ib=new item_bean();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
     try{
       Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from customer_downloads_zip where zip_name='"+filename+"' and order_id='"+order_id+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        ib.setRwid(rs.getInt("audiofordwnd_id"));
        ib.setFilename(rs.getString("zip_name"));
        ib.setCount(rs.getInt("click_count"));
    }
    }catch(Exception e){}
   finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
    return ib;
}

public item_bean retZipFileDetail(int id,String order_id){
    item_bean ib=new item_bean();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
     try{
       Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from customer_downloads_zip where order_id='"+order_id+"' and audiofordwnd_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        ib.setRwid(rs.getInt("audiofordwnd_id"));
        ib.setFilename(rs.getString("zip_name"));
        ib.setCount(rs.getInt("click_count"));
    }
    }catch(Exception e){}
    finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
    return ib;
}

public void update_inserted_customer_downloads_zip(item_bean ib)
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
        Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
        String sqlString ="update customer_downloads_zip set file_downloading=?,click_count=?,downloaded_time=? where audiofordwnd_id=?";
            pstmt=conn.prepareStatement(sqlString);
             pstmt.setString(1,"Completed");
             pstmt.setInt(2,ib.getCount()+1);
             pstmt.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
             pstmt.setInt(4,ib.getRwid());
          
     pstmt.executeUpdate();
    } catch(Exception e){}
    finally {
        try{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
        }catch(Exception ee){}
      }
}

public String removeSpace(String s)
	{
            s=s.trim();
		char ch[]=s.toCharArray();
		int i=0;
		int k=0;
		int sp=0;
		for(int j=0;j<ch.length;j++)
		{
			while(i<=ch.length-1&&(ch[i]==' '||ch[i]==','))
			{
                            if(ch[i]==','){
                                k--;
                                sp++;
                            }
                            else
                                ch[k]='_';
                            i++;
                            k++;
//			  sp++;
                            
			}
			while(i<=ch.length-1&&ch[i]!=' '&&ch[i]!=',')
			{
				ch[k]=ch[i];
				i++;
				k++;
			}
			
			j=i-1;
//                        System.out.println("j"+j);
		}
		char ch1[]=new char[ch.length];
		for(int j=0;j<ch1.length-sp;j++)
		{
			ch1[j]=ch[j];
		}

		String st=new String(ch1);
		return st;
	}
public String removeAllSpCh(String s){
    s = s.replaceAll("[^a-zA-Z0-9\\s]", "");
    return s;
}
public String addAutoGenNumToFilename(String filename){
    Random randomGenerator = new Random();
    String ext=filename.substring(filename.indexOf("."), filename.length());
    filename=filename.substring(0, filename.indexOf("."));
    filename=this.removeAllSpCh(filename);
    filename=this.removeSpace(filename);
    StringBuffer sb=new StringBuffer("");
      int randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(filename);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      sb=sb.append(ext);
//      System.out.println(filename);
//      System.out.println(ext);
//      System.out.println(sb);
    return sb.toString();
}

public static void main(String arg[])
{
    ToDBFile tdb=new ToDBFile();
    System.out.println("Kapil: "+tdb.removeAllSpCh("I'll Be Seeing You"));
//    tdb.addAutoGenNumToFilename(tdb.removeSpace("04 Introduction to Assemble.mp3"));
    System.out.println(new java.util.Date());
}

    
}
