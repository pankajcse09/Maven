/*
 * Im_Proj_DataUtility.java
 *
 * Created on June 12, 2008, 11:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.struts;
import Search.Search_bean;
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
 * @author Rock
 */
public class Im_Proj_DataUtility {
    
    /** Creates a new instance of Im_Proj_DataUtility */
    public Im_Proj_DataUtility() {
    }
    //
      public ArrayList Searchitem_list(String code) throws SQLException {
         
         Connection conn = null;
         PreparedStatement pstmt = null;
          ResultSet rs = null;
 
       String sql ="select filename from  item where searchkey LIKE '%ring%'";

        
        ArrayList item_list = new ArrayList();
        try
        {
              Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {     
                Search_bean rb=new Search_bean();
              rb.setName(rs.getString("filename"));
                
          
            item_list.add(rb);
            }
              

        }
 catch(SQLException e){
    
    
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
    
return item_list;

}  
 
     public ArrayList itemlist(String code) throws SQLException {
         
         Connection conn = null;
         PreparedStatement pstmt = null;
          ResultSet rs = null;
 
       String sql ="select filename from item  WHERE searchkey like '"+code+"%'";

        
        ArrayList item_list = new ArrayList();
        try
        {
              Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {     
                Search_bean rb=new Search_bean();
              rb.setName(rs.getString("filename"));
                
          
            item_list.add(rb);
            }
              

        }
 catch(SQLException e){
    
    
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
    
return item_list;

}  
 
     public ArrayList moreitemlist(String code) throws SQLException {
         
         Connection conn = null;
         PreparedStatement pstmt = null;
          ResultSet rs = null;
 
       String sql ="select image from itemimage  WHERE search like '"+code+"%'";

        
        ArrayList item_list = new ArrayList();
        try
        {
              Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {     
                Search_bean rb=new Search_bean();
              rb.setName(rs.getString("image"));
                
          
            item_list.add(rb);
            }
              

        }
 catch(SQLException e){
    
    
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
    
return item_list;

}  
  
     
     
     
     
     
      public ArrayList Searchitem_namea(int id) throws SQLException {
         
         Connection conn = null;
         PreparedStatement pstmt = null;
          ResultSet rs = null;
 
       String sql ="select image from itemimage  WHERE itemid="+id;

        
        ArrayList item_list = new ArrayList();
        try
        {
              Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {     
                Search_bean rb=new Search_bean();
              rb.setName(rs.getString("image"));
                
          
            item_list.add(rb);
            }
              

        }
 catch(SQLException e){
    
    
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
    
return item_list;

}  
 
     
    
      public  Search_bean Searchitem_subcat(int id) throws SQLException {
      
        
         ArrayList subcatid_list=new ArrayList();
         Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 
       String sql ="select item_id,filename FROM item JOIN sub_cat ON sub_cat.sub_cat_id= item.sc_id  where sub_cat_id= '"+id+"'";

         Search_bean rb=new Search_bean();
        
        ArrayList item_list = new ArrayList();
        try
        {
             Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {    
                  
                
             rb.setId(rs.getInt("item_id"));
             rb.setName(rs.getString("filename"));
                
         
           
            }
              

        }
 catch(SQLException e){
    
    
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
    
return rb;

}  
 
    
    
     public  ArrayList Searchitem_Categ(String code) throws SQLException {
      
        
         ArrayList subcatid_list=new ArrayList();
         Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 
       String sql ="select sub_cat_id FROM sub_cat JOIN cms_cat ON cms_cat.cms_cat_id=sub_cat.c_id where cms_cat like '"+code+"%'";

 int id=0;
        
        ArrayList item_list = new ArrayList();
        try
        {
             Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {    
                  Search_bean rb=new Search_bean();
                
             rb.setId(rs.getInt("sub_cat_id"));
           
                
          subcatid_list.add(rb);
           
            }
              

        }
 catch(SQLException e){
    
    
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
    
return subcatid_list;

}  
 
    
    
    
    
    public ArrayList Searchitem_Code(int id) throws SQLException {
         
         Connection conn = null;
         PreparedStatement pstmt = null;
          ResultSet rs = null;
 
       String sql ="select image from itemimage  WHERE itemid="+id;

        
        ArrayList item_list = new ArrayList();
        try
        {
              Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {     
                Search_bean rb=new Search_bean();
              rb.setName(rs.getString("image"));
                
          
            item_list.add(rb);
            }
              

        }
 catch(SQLException e){
    
    
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
    
return item_list;

}  
 
      
      
    public  Search_bean Searchitem_id(String code) throws SQLException {
       Search_bean rb=new Search_bean();
         Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 
       String sql ="select item_id,filename from item where brand='"+code+"'";

 int id=0;
        
        ArrayList item_list = new ArrayList();
        try
        {
             Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
            pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {     
                
             rb.setId(rs.getInt("item_id"));
             rb.setName(rs.getString("filename"));
                
          
           
            }
              

        }
 catch(SQLException e){
    
    
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
    
return rb;

}  
 
     public ArrayList gal_ItemImage(int id,int scid)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select image,id from itemimage where itemid="+id+" and sc_id="+scid;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  
    prodetail.setFilename(rs.getString("image"));
    prodetail.setId(rs.getInt("id"));
   
   
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
     
     
     
     
     
      public String gal_Itemfilename(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
    String filename="";
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select filename from item where item_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    
  
    filename=(String)rs.getString("filename");
    
    
    }
    
    
    }catch(Exception e){}
    
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
    return filename;
    
    }
     
     
public static int  insert_everydayStreams(String filename,String strmdate,String pagename,String title)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int cn=0;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Date stdt=null;
    try{
    stdt=new java.sql.Date(sde.parse(sde.format(sdf.parse(strmdate))).getTime());
    }
    catch(Exception e){cn=1;return cn;}
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String sqlString ="SELECT max(stream_date) as stream_date from everyday_stream";
     stmt=conn.prepareStatement(sqlString);
     rs=stmt.executeQuery();
     if(rs.next())
     {
       String sqlString1 ="update everyday_stream set status='removed' where status='inplaylist' and stream_date='"+rs.getDate("stream_date")+"' and stream_date<>'"+stdt+"'";
       System.out.println("Query: "+sqlString1);
       stmt=null;
      stmt=conn.prepareStatement(sqlString1);
      stmt.executeUpdate();
         }
      stmt=null;

      String sqlString2 ="insert into everyday_stream(filename,stream_date,pagename,title,status)values(?,?,?,?,?)";
            stmt=conn.prepareStatement(sqlString2);
             stmt.setString(1,filename);
             stmt.setDate(2, stdt);
             stmt.setString(3,pagename);
             stmt.setString(4,title);
             stmt.setString(5,"inplaylist");
          stmt.executeUpdate();
    }catch(Exception e){}
finally {
    if ( rs != null ) {rs.close();}
    if ( stmt != null ) {stmt.close();}
    if ( conn != null ) {conn.close();}
    }
         return cn;
     }
    
   public static void  insert_ItemMore_Image(String filename,String pagename,String scid)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into itemimage(image,itemid,sc_id)values(?,?,?)";
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,filename);
             stmt.setInt(2,Integer.parseInt(pagename));
          stmt.setInt(3,Integer.parseInt(scid));
            
             
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
     }
       
      public static void  insert_gal_Image(String filename,String pagename)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into gal_img(gallery,page)values(?,?)";
            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,filename);
          stmt.setString(2,pagename);
          
            
             
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
     }
        
          
     
    
       public  void  edit_gal(String fn,int id)throws Exception 
               
    {
              
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

      String sqlString ="update gal_img set gallery=? where id='"+id+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,fn);
             
      
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
     
     }
         public ArrayList gal_Image(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select gallery,id,page from gal_img where page='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  
    prodetail.setFilename(rs.getString("gallery"));
    prodetail.setF_id(rs.getInt("id"));
    prodetail.setText(rs.getString("page"));
   
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
    
       
       
    public ArrayList gal_view_Image(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select gallery,id,page from gal_img where page='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
  
    prodetail.setFilename(rs.getString("gallery"));
    prodetail.setF_id(rs.getInt("id"));
    prodetail.setText(rs.getString("page"));
   
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
    
    
    
    
    
   
          
          
          
     public  boolean update_Head_tit_Detail(String hd,String tit,int det_id,int head_id)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    



   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    

      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

  String sqlString ="update proj_detail set proj_head=?,proj_detail=? where detail_id="+det_id+ " and head_id="+head_id;

             stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,hd);
            
              stmt.setString(2,tit);
            
      
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
    
    
    
   
    
     
    //temperature -month
    
    
    
     public ArrayList fetch_Image(String hm)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select hm,filename,file_id,area from hm_image where hm='"+hm+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
    prodetail.setTitle(rs.getString("hm"));
    prodetail.setFilename(rs.getString("filename"));
    prodetail.setF_id(rs.getInt("file_id"));
    prodetail.setArea(rs.getString("area"));
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
    
    
       
    
    
    
    
    
    

    
    
    
    
    
    
    //chk_Availabile
    
    
     public void  delete_Title(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  im_proj where pro_id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            
            
        } catch (SQLException ex) {
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
    
 
    
  
    
    
    
    
   
    
     public  ArrayList  display_Detail(int head_id)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Common_data getdataus = null;
    ArrayList detail_list=new ArrayList();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select proj_head,proj_detail from proj_detail where head_id='"+head_id+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
            Im_Projects_DataHold protitle= new Im_Projects_DataHold();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          
                protitle.setTitle(rs.getString("proj_head"));
                protitle.setText(rs.getString("proj_detail"));
                
            
             detail_list.add(protitle);
         
          
       }
          }catch(Exception e){}
    
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
     return detail_list;
   } 
        
 
    
     public  void  updateData(Im_Projects_DataHold h_t,int id)throws Exception 
    {
   
   

        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());

         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
      //update stdnt_req_course set approve=?,disapprove=? where studnt_id='"+studnt_id[i]+"' and c_id='"+c_id+"'";

      String sqlString ="update im_proj set proj_title=?,proj_text=? where pro_id='"+id+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,h_t.getTitle());
              stmt.setString(2,h_t.getText());
             //stmt.setTimestamp(2,timestamp);
      
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
     
     
     }
    
    
    
    
    
    
    
    
    public ArrayList fetch_Title(String hm)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select proj_title,proj_text,pro_id from im_proj where proj='"+hm+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
    prodetail.setTitle(rs.getString("proj_title"));
    prodetail.setText(rs.getString("proj_text"));
    prodetail.setId(rs.getInt("pro_id"));
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
    
    // edit function
    
    
     public ArrayList edit_Title(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select proj_title,proj_text from im_proj where pro_id='"+id+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
    prodetail.setTitle(rs.getString("proj_title"));
    prodetail.setText(rs.getString("proj_text"));
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
    
     public ArrayList edit_Title_Detail(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList product_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select proj_head,proj_detail,detail_id,head_id from proj_detail where head_id='"+id+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
    Im_Projects_DataHold prodetail= new Im_Projects_DataHold();
    
    prodetail.setTitle(rs.getString("proj_detail"));
    prodetail.setText(rs.getString("proj_head"));
    prodetail.setDet_head_id(rs.getInt("head_id"));
     prodetail.setDet_id(rs.getInt("detail_id"));
    
    product_list.add(prodetail);
    
    }
    
    
    }catch(Exception e){}
    
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
    
    
    
    
    
     public  ArrayList  display(String hm)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Common_data getdataus = null;
    ArrayList title_list=new ArrayList();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select proj_title,pro_id from im_proj where proj='"+hm+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
            Im_Projects_DataHold protitle= new Im_Projects_DataHold();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          
                protitle.setTitle(rs.getString("proj_title"));
               protitle.setId(rs.getInt("pro_id"));
              title_list.add(protitle);
         
          
       }
          }catch(Exception e){}
    
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
     return title_list;
   } 
    
 
             
             
             
    
    
    
     public static void  insertData(Im_Projects_DataHold utdata,String page)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into im_proj(proj_title,proj_text,proj,time_stamp)values(?,?,?,?)";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,utdata.getTitle());
             stmt.setString(2,utdata.getText());
               stmt.setString(3,page);
             stmt.setTimestamp(4,timestamp);
             
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
     }
     
     ///////////insert_detail
     
     
     ///insert image
     
       public static void  insert_Image(String hm,String area,String filename)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into hm_image(hm,area,filename)values(?,?,?)";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,hm);
          
             stmt.setString(2,area);
                  stmt.setString(3,filename);
             
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
     }
     
     
     
     
    
     public static void  insert_detail(Im_Projects_DataHold utdata,int id)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into proj_detail(proj_head,proj_detail,head_id)values(?,?,?)";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,utdata.getTitle());
             stmt.setString(2,utdata.getText());
               stmt.setInt(3,id);
             
             
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
     }
     
     public static void main(String args[])
     {
     Im_Proj_DataUtility  a= new Im_Proj_DataUtility ();
     //java.util.Date g=new java.util.Date("2008/09/24");
        try {
           //a.cust_Reg(g);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     
    // a.chk_Available(2,1);
     
     }
     
     
     
}
