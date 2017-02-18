/*
 * prop_operate.java
 *
 * Created on September 29, 2008, 9:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package prop_bean;
import Advert.ad_bean;
import com.myapp.struts.Dataconnectivity;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.*;
/**
 *
 * @author arjun
 */
public class prop_operate {
    
    /** Creates a new instance of prop_operate */
    public prop_operate() {
    }
    
 
    
    
    
    
     public ad_bean fetch_head_id(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
      ad_bean ad=new ad_bean();
      prop_operate op=new prop_operate();
      int idd=0;
     try{
    Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();    
    String pro_title="select prop_id,page_name from prop_cr where prop_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {  
 ad.setAd_id(rs.getInt("prop_id"));  
 ad.setPag(rs.getString("page_name"));
    
    }
    
    
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
    return ad;
    
    }
    
    
    
    public  boolean update_adImage(ad_bean cr,int adid)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
   
      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

  String sqlString ="update ads set ad_head=?,ad_desc=?,ad_link=?,ad_file=? where ad_id="+adid;

             stmt=conn.prepareStatement(sqlString);
              stmt.setString(1,cr.getHead());
              stmt.setString(2,cr.getDesc());
              stmt.setString(3,cr.getLink());
              stmt.setString(4,cr.getFilename());
             
            
            
      
     stmt.executeUpdate();
      
      
    }
         catch(Exception e)
         {
             
             
             
             
         }
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
     return true;
     
     }
    
    
    public ArrayList fetch_ad_detail(int ad_id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from ads where ad_id='"+ad_id+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   ad_bean ad=new ad_bean();
   ad.setHead(rs.getString("ad_head"));
   ad.setDesc(rs.getString("ad_desc"));
   ad.setLink(rs.getString("ad_link"));
   ad.setFilename(rs.getString("ad_file"));
   ad.setAd_id(rs.getInt("ad_id"));
    
  ad_list.add(ad);
    
    }
    
    
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
    return ad_list;
    
    }
    
    
    
    public ArrayList fetch_head_ad(String pag)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select ad_head,ad_id from ads where pag='"+pag+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   ad_bean ad=new ad_bean();
   ad.setHead(rs.getString("ad_head"));
   ad.setAd_id(rs.getInt("ad_id"));
    
  ad_list.add(ad);
    
    }
    
    
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
    return ad_list;
    
    }
    
     public boolean  insert_adImage(ad_bean cr)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into ads(ad_head,ad_desc,ad_link,ad_file,pag)values(?,?,?,?,?)";
    
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,cr.getHead());
             stmt.setString(2,cr.getDesc());
             stmt.setString(3,cr.getLink());
            stmt.setString(4,cr.getFilename());
              stmt.setString(5,cr.getPag());
               stmt.executeUpdate();
      
      
    }

      
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
      return true;
     }
    
    
    
    
     public void del_fetch_land(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  prop_land where prop_id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    finally {

      

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
    
    
    }
    
    
    
    public void del_fetch_crid(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  prop_cr where prop_id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    finally {

      if ( rs != null ) {

        rs.close();
      }

      

      if ( conn != null ) {

        conn.close();
      }
    
    
}
    
    
    }
    
    
    
    
    
    public ArrayList fetch_land_det(String rent)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,descr,rent,price,cond,area,filename,prop_id from prop_land where rent='"+rent+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
  
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setDesc(rs.getString("descr"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
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
    return product_list;
    
    }
    
    
     public ArrayList fetch_cr_det(String rent)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,descr,rent,price,cond,area,bed,filename,prop_id from prop_cr where rent='"+rent+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
   sell.setBed(rs.getString("bed"));
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setDesc(rs.getString("descr"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
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
    
    return product_list;
    
    }
    
    
    //Edit _fetch_land
    
    
     public ArrayList Edit_fetch_landid(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,descr,rent,price,cond,area,filename,prop_id from prop_land where prop_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
  
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setDesc(rs.getString("descr"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
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
    return product_list;
    
    }
    
    
    
     public ArrayList Edit_fetch_land(String land)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,property,rent,price,cond,area,filename,prop_id from prop_land where rent='"+land+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
   
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setProperty(rs.getString("property"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
    }catch(Exception e){
    
    
    }
    
    
    return product_list;
    
    }
    
    
    
    
    
    //edit fetchcr by id
     public ArrayList Edit_fetch_crid(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,descr,rent,price,cond,area,bed,filename,prop_id from prop_cr where prop_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
   sell.setBed(rs.getString("bed"));
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setDesc(rs.getString("descr"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
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
    
    return product_list;
    
    }
    //edit_fetch_cr
    
    
    public ArrayList Edit_fetch_cr(String cr)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,property,rent,price,cond,area,bed,filename,prop_id from prop_cr where rent='"+cr+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
   sell.setBed(rs.getString("bed"));
   sell.setCondition(rs.getString("bed"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setProperty(rs.getString("property"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
    }catch(Exception e){
    
    
    }
    
    
    return product_list;
    
    }
    
    
     public  boolean update_Owner_img(String filename,int id,int file_id)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    



   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    

      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

  String sqlString ="update prop_own_image set prop_own_image=? where ow_id="+id+ " and img_id="+file_id;

             stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,filename);
            
             
            
      
     stmt.executeUpdate();
      
      
    }
         catch(Exception e)
         {
             
             
             
             
         }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
} 
     return true;
     
     }
    
    
    
    
    
    
    
    
     public  boolean update_Owner_prop(owner ow)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String ownername="";
String location="";
String plan="";
String spec="";
String amen="";
String contact="";
String aboutus="";
int prop_id=0;
int owner_id=0;
String filename="";
   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    prop_id=ow.getPid();
      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

  String sqlString ="update prop_owner set contactus=?,aboutus=?,location=?,floorplans=?,specification=?,amenities=?,ownerid=?,name=?,status=? where p_id="+prop_id;

             stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,ow.getContactus());
             stmt.setString(2,ow.getAboutus());
             stmt.setString(3,ow.getLocation());
             stmt.setString(4,ow.getPlan());
             stmt.setString(5,ow.getSpecific());
             stmt.setString(6,ow.getAmen());
             stmt.setInt(7,ow.getOwnerid());
             stmt.setString(8,ow.getName());
             stmt.setString(9,"pub");
            
      
     stmt.executeUpdate();
      
      
    }
         catch(Exception e)
         {
           
             
         }
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
     return true;
     
     }
    
    
    
    
     public ArrayList fetch_image(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select prop_own_image,img_id from prop_own_image where ow_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
owner ow_iamge=new owner();
 
    ow_iamge.setFilename(rs.getString("prop_own_image"));
    ow_iamge.setImg_id(rs.getInt("img_id"));
    product_list.add(ow_iamge);
    
    }
    
    
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
    return product_list;
    
    }
    
    
    public boolean  insert_owner_Image(prop_be cr,int id)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into prop_own_image(prop_own_image,ow_id)values(?,?)";
    
            stmt=conn.prepareStatement(sqlString);
             
                stmt.setString(1,cr.getFilename());
                stmt.setInt(2,id);
                
               stmt.executeUpdate();
      
      
    }

      
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
      return true;
     }
    
    
     public ArrayList fetch_land(String rent)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,descr,rent,price,cond,area,filename,prop_id from prop_land where rent='"+rent+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
  
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setDesc(rs.getString("descr"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
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
    return product_list;
    
    }
    
    
    
    
     public ArrayList fetch_owner()throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList owner_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_owner order by p_id desc";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
     owner ow=new  owner();
   if(rs.next())
    {
   
    ow.setName(rs.getString("name"));
   ow.setAboutus(rs.getString("aboutus"));
   ow.setAmen(rs.getString("amenities"));
   ow.setContactus(rs.getString("contactus"));
   ow.setLocation(rs.getString("location"));
   ow.setOwnerid(rs.getInt("ownerid"));
   ow.setPid(rs.getInt("p_id"));
   ow.setPlan(rs.getString("floorplans"));
   ow.setSpecific(rs.getString("specification"));
   
    owner_list.add(ow);
    
    }
    
    
    }catch(Exception e){
    
    
    } finally {

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
    
    return owner_list;
    
    }
    
     public ArrayList fetch_owner_list(String status)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList owner_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_owner where status='"+status+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
  
 while(rs.next())
    {
      owner ow=new  owner();
    ow.setName(rs.getString("name"));
   ow.setAboutus(rs.getString("aboutus"));
   ow.setAmen(rs.getString("amenities"));
   ow.setContactus(rs.getString("contactus"));
   ow.setLocation(rs.getString("location"));
   ow.setOwnerid(rs.getInt("ownerid"));
   ow.setPid(rs.getInt("p_id"));
   ow.setPlan(rs.getString("floorplans"));
   ow.setSpecific(rs.getString("specification"));
   
    owner_list.add(ow);
    
    }
    
    
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
    return owner_list;
    
    }
    
     
     public ArrayList owner_list_id(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList owner_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_owner where p_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
   owner ow=new  owner();
while(rs.next())
    {
     
    ow.setName(rs.getString("name"));
   ow.setAboutus(rs.getString("aboutus"));
   ow.setAmen(rs.getString("amenities"));
   ow.setContactus(rs.getString("contactus"));
   ow.setLocation(rs.getString("location"));
   ow.setOwnerid(rs.getInt("ownerid"));
   ow.setPid(rs.getInt("p_id"));
   ow.setPlan(rs.getString("floorplans"));
   ow.setSpecific(rs.getString("specification"));
   
    owner_list.add(ow);
    
    }
    
    
    }catch(Exception e){
    
    
    }
    
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if (pstmt != null ) {

        pstmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
    return owner_list;
    
    }
    
    
     
    public boolean  insert_owner(owner ow)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into prop_owner(contactus,aboutus,location,floorplans,specification,amenities,ownerid,name,status)values(?,?,?,?,?,?,?,?,?)";
    
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,ow.getContactus());
             stmt.setString(2,ow.getAboutus());
             stmt.setString(3,ow.getLocation());
             stmt.setString(4,ow.getPlan());
             stmt.setString(5,ow.getSpecific());
             stmt.setString(6,ow.getAmen());
             stmt.setInt(7,ow.getOwnerid());
             stmt.setString(8,ow.getName());
               stmt.setString(9,"pend");
             
           
               stmt.executeUpdate();
      
      
    }
catch(Exception e)
{

}
      
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
      return true;
     }
    
    
     public ArrayList fetch_cr(String rent)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select location,descr,rent,price,cond,area,bed,filename,prop_id from prop_cr where rent='"+rent+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    prop_be sell=new prop_be() ;
   sell.setArea(rs.getString("area"));
   sell.setBed(rs.getString("bed"));
   sell.setCondition(rs.getString("cond"));
   sell.setFilename(rs.getString("filename"));
   sell.setLocation(rs.getString("location"));
   sell.setPrice(rs.getDouble("price"));
   sell.setProp_id(rs.getInt("prop_id"));
   sell.setDesc(rs.getString("descr"));
   sell.setRent(rs.getString("rent"));
    
    product_list.add(sell);
    
    }
    
    
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
    return product_list;
    
    }
    
    
    public boolean  insert_crImage(prop_be cr)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into prop_cr(location,descr,filename,page_name)values(?,?,?,?)";    
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,cr.getLocation());             
               stmt.setString(2,cr.getDesc());             
                stmt.setString(3,cr.getFilename());
                stmt.setString(4,cr.getPage_name());
               stmt.executeUpdate();
      
      
    }

      
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
      return true;
     }
    
    
    public boolean  insert_Detail_Image(prop_be cr)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
      String sqlString ="insert into proj_detail(proj_head,proj_detail,filename,page_name,head_id)values(?,?,?,?,?)";    
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,cr.getLocation());             
               stmt.setString(2,cr.getDesc());             
                stmt.setString(3,cr.getFilename());
                stmt.setString(4,cr.getPage_name());
                stmt.setInt(5,cr.getProp_id());
               stmt.executeUpdate();
      
      
    }

      
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
      return true;
     }
    
    
    public boolean  insert_landImage(prop_be cr)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into prop_land(location,descr,rent,price,cond,area,filename)values(?,?,?,?,?,?,?)";
    
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,cr.getLocation());
             
             stmt.setString(2,cr.getDesc());
              stmt.setString(3,cr.getRent());
              
             stmt.setDouble(4,cr.getPrice());
             stmt.setString(5,cr.getCondition());
             stmt.setString(6,cr.getArea());
               
                stmt.setString(7,cr.getFilename());
                
               stmt.executeUpdate();
      
      
    }

      
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
      return true;
     }
    
    
     public  boolean update_crImage(prop_be cr,int app_id)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
   
      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

  String sqlString ="update prop_cr set location=?,descr=?,rent=?,price=?,cond=?,area=?,bed=?,filename=? where prop_id="+app_id;

             stmt=conn.prepareStatement(sqlString);
              stmt.setString(1,cr.getLocation());
             
             stmt.setString(2,cr.getDesc());
              stmt.setString(3,cr.getRent());
              
             stmt.setDouble(4,cr.getPrice());
             stmt.setString(5,cr.getCondition());
             stmt.setString(6,cr.getArea());
                 stmt.setString(7,cr.getBed());
                stmt.setString(8,cr.getFilename());
            
      
     stmt.executeUpdate();
      
      
    }
         catch(Exception e)
         {
             
             
             
             
         }
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
     return true;
     
     }
    
     public  boolean update_landImage(prop_be cr,int land_id)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
   
  

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
   
     

  String sqlString ="update prop_land set location=?,descr=?,rent=?,price=?,cond=?,area=?,filename=? where prop_id="+land_id;

             stmt=conn.prepareStatement(sqlString);
              stmt.setString(1,cr.getLocation());
             
             stmt.setString(2,cr.getDesc());
              stmt.setString(3,cr.getRent());
              
             stmt.setDouble(4,cr.getPrice());
             stmt.setString(5,cr.getCondition());
             stmt.setString(6,cr.getArea());
               
                stmt.setString(7,cr.getFilename());
            
      
     stmt.executeUpdate();
      
      
    }
         catch(Exception e)
         {
             
             
             
             
         }
      finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( stmt != null ) {

        stmt.close();
      }

      if ( conn != null ) {

        conn.close();
      }
    
    
}
     return true;
     
     }
    
     public static void main(String args[])
     {
   prop_operate  a= new prop_operate();
   ArrayList aa= new   ArrayList();
        try {
    
       int r=12;
           aa=(ArrayList)a.fetch_image(r);
          System.out.println(aa);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
    // a.chk_Available(2,1);
     
     }
    
}
