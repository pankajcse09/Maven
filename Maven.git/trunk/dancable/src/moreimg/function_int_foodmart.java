/*
 * prop_operate.java
 *
 * Created on September 29, 2008, 9:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package moreimg;

import Main_category.CountryBean;
import Main_category.item_bean;
import moreimg.img_bean;
import com.myapp.struts.Dataconnectivity;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.*;
import mc_bean.mc_prop;
/**
 *
 * @author arjun
 */
public class function_int_foodmart {   
    private int noOfRecords;
     public ArrayList get_customer_tid_Details(String tid)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
    // java.sql.Date fd= new java.sql.Date(fromdate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select order_id,filename,item_id,price,quantity,total,cart_date,name,size,prod_id from imd_cart join registrationtable reg on imd_cart.user_id=reg.email_id where order_id='"+tid+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
   
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));    
    det.setPrice(rs.getDouble("price"));    
    det.setQuantity(rs.getInt("quantity"));
    det.setSubtotal(rs.getDouble("total"));
    det.setCartdate(rs.getDate("cart_date"));
    det.setUsername(rs.getString("name"));
    det.setTrans_id(rs.getString("order_id"));
    det.setSize(rs.getString("size"));
    det.setProd_id(rs.getString("prod_id"));
 
    item_list.add(det);
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
    return item_list;
    
    }
    
 
       public item_bean get_customer_order_date(String userid,String order_id)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean(); 
//     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
//     java.sql.Date td=new java.sql.Date(todate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
   // System.out.println("fd: "+fd);
    String pro_title="select prod_id,order_date,shiiping_charge,order_id,invoice_no,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country from imd_cart_order join registrationtable reg on imd_cart_order.user_id=reg.email_id where user_id=? and order_id=?";
    pstmt=conn.prepareStatement(pro_title);
    pstmt.setString(1, userid);
    pstmt.setString(2, order_id);
//    pstmt.setDate(3, fd);
//    pstmt.setDate(4,td);
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
//   det.setOrder_date(rs.getDate("order_date"));
//     det.setOrder_id(rs.getString("order_id"));
//     det.setInvoice_no(rs.getString("invoice_no"));
//     det.setBill_f_name(rs.getString("bill_cusName"));
//     det.setBill_phone(rs.getString("bill_mobileno"));
//     det.setBill_street(rs.getString("bill_street"));
//     det.setBill_city(rs.getString("bill_city"));
//     det.setBill_state(rs.getString("bill_state"));
//     det.setBill_country(rs.getString("bill_country"));
//     det.setBill_zip(rs.getString("bill_pincode"));
//     det.setShip_f_name(rs.getString("bill_cusName"));
//     det.setShip_phone(rs.getString("bill_mobileno"));
//     det.setShip_street(rs.getString("bill_street"));
//     det.setShip_city(rs.getString("bill_city"));
//     det.setShip_state(rs.getString("bill_state"));
//     det.setShip_country(rs.getString("bill_country"));
//     det.setShip_zip(rs.getString("bill_pincode"));
    item_list.add(det);
    }
    itmb.setDataArray(item_list);
    
     
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country from imd_cart_order join registrationtable reg on imd_cart_order.user_id=reg.email_id where user_id=? and order_id=?";
    pst=conn.prepareStatement(qr);
    pst=conn.prepareStatement(qr);
  pst.setString(1, userid);
    pst.setString(2, order_id);
//    pst.setDate(3, fd);
//    pst.setDate(4,td);
    rs1=pst.executeQuery();
    if(rs1.next())
    {
    item_bean ib=new item_bean();
     ib.setOrder_date(rs1.getDate("order_date"));
     ib.setShip_charge(rs1.getDouble("shiiping_charge"));
   //  System.out.println("Ship: "+rs1.getDouble("shiiping_charge"));
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
   
     
  
      public  void  update_Status_Order(String status,int cartid)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update imd_cart_order set status=? where order_id="+cartid;

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,status);
            
            
      
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
    
     public ArrayList get_RetailStore_Desc()throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from item";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
    det.setBrand(rs.getString("brand"));
    det.setDetail(rs.getString("detail"));
    det.setDiscount(rs.getDouble("discount"));
    det.setDiscountdetail(rs.getString("discountdetail"));
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));
    det.setMarketprice(rs.getDouble("marketprice"));
    det.setPrice(rs.getDouble("price"));
    det.setProd_id(rs.getString("prod_id"));
    det.setSize(rs.getString("size"));
    det.setStatus(rs.getString("status"));
    det.setSubcat_id(rs.getInt("sc_id"));
    det.setUnit(rs.getString("unit"));
    
    
    item_list.add(det);
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
    return item_list;
    
    }
     
      public ArrayList get_Item_Desc(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from item where sc_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
    det.setBrand(rs.getString("brand"));
    det.setDetail(rs.getString("detail"));
    det.setDiscount(rs.getDouble("discount"));
    det.setDiscountdetail(rs.getString("discountdetail"));
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));
    det.setMarketprice(rs.getDouble("marketprice"));
    det.setPrice(rs.getDouble("price"));
    det.setProd_id(rs.getString("prod_id"));
    det.setSize(rs.getString("size"));
    det.setStatus(rs.getString("status"));
    det.setSubcat_id(rs.getInt("sc_id"));
    det.setUnit(rs.getString("unit"));
    
    
    item_list.add(det);
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
    return item_list;
    
    }
     
     
     
     
        public ArrayList get_Item_Single(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from item where item_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
    det.setBrand(rs.getString("brand"));
    det.setDetail(rs.getString("detail"));
    det.setDiscount(rs.getDouble("discount"));
    det.setDiscountdetail(rs.getString("discountdetail"));
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));
    det.setMarketprice(rs.getDouble("marketprice"));
    det.setPrice(rs.getDouble("price"));
    det.setProd_id(rs.getString("prod_id"));
    det.setSize(rs.getString("size"));
    det.setStatus(rs.getString("status"));
    det.setSubcat_id(rs.getInt("sc_id"));
    det.setUnit(rs.getString("unit"));
    det.setCart_id(rs.getInt("item_id"));
    det.setAvailability(rs.getInt("availability"));
    
    item_list.add(det);
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
    return item_list;
    
    }
        public void create_cart(item_bean be) throws SQLException
                 {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into imd_cart(user_id,quantity,item_id,sc_id,cart_date,status,size,prod_id,user_type)values(?,?,?,?,?,?,?,?,?)";
        stmt=conn.prepareStatement(sqlString);
        stmt.setString(1,be.getUsername());
        stmt.setInt(2,be.getQuantity());
        stmt.setInt(3,be.getItem_id());
        stmt.setInt(4,be.getSubcat_id());
        stmt.setTimestamp(5,timestamp);
        stmt.setString(6,"p");
        stmt.setString(7,be.getSize());
        stmt.setString(8,be.getProd_id());
        stmt.setString(9,"r");     
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
        
public void create_temp_cart(item_bean be) throws SQLException
    {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into imd_temp_cart(user_id,filename,price,quantity,total,item_id,sc_id,cart_date,status,size,prod_id)values(?,?,?,?,?,?,?,?,?,?,?)";
        stmt=conn.prepareStatement(sqlString);
        stmt.setString(1,be.getUsername());
        stmt.setString(2,be.getFilename());
        stmt.setDouble(3,be.getPrice());
        stmt.setInt(4,be.getQuantity());
        stmt.setDouble(5,be.getTotal());
        stmt.setInt(6,be.getItem_id());
        stmt.setInt(7,be.getSubcat_id());
        stmt.setTimestamp(8,timestamp);
            stmt.setString(9,"p");
            stmt.setString(10,be.getSize());
            stmt.setString(11,be.getProd_id());
            
             
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
        
        
public ArrayList get_cart_despatch(String userid)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
    String aa= "";
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from imd_cart where user_id='"+userid+"' and user_type='r'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=this.discount_item_detail(rs.getInt("item_id"),aa); 
     det.setUser_id(rs.getString("user_id"));
     det.setItem_id(rs.getInt("item_id"));    
     det.setQuantity(rs.getInt("quantity"));
     det.setCart_id(rs.getInt("cart_id"));
     det.setCartdate(rs.getDate("cart_date"));
     det.setSubtotal(det.getQuantity()*det.getPrice());
     item_list.add(det);
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
    return item_list;
    
    }
        
        public ArrayList get_temp_cart_despatch(String userid)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
  
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from imd_temp_cart where user_id='"+userid+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));    
    det.setPrice(rs.getDouble("price"));    
    det.setQuantity(rs.getInt("quantity"));
    det.setSubtotal(rs.getDouble("total"));
    det.setCart_id(rs.getInt("cart_id"));
    det.setSize(rs.getString("size"));
    det.setProd_id(rs.getString("prod_id"));
    item_list.add(det);
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
    return item_list;
    
    }
        
        
        
                public item_bean take_order(int cartid)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
  item_bean det=new item_bean(); 
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();    
    String pro_title="select * from imd_cart where cart_id='"+cartid+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));    
    det.setPrice(rs.getDouble("price"));    
    det.setQuantity(rs.getInt("quantity"));
    det.setSubtotal(rs.getDouble("total"));
    det.setCart_id(rs.getInt("cart_id"));
    det.setSubcat_id(rs.getInt("sc_id"));
    det.setUsername(rs.getString("user_id"));
    det.setCartdate(rs.getDate("cart_date"));
    
    item_list.add(det);
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
    return det;
    
    }
                
                 public void create_order(item_bean be) throws SQLException
                 {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    java.util.Date todaydate =new java.util.Date();
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     

      String sqlString ="insert into imd_cart_order(user_id,filename,price,quantity,total,item_id,sc_id,cart_date,cart_id,status)values(?,?,?,?,?,?,?,?,?,?)";
        stmt=conn.prepareStatement(sqlString);
        stmt.setString(1,be.getUsername());
        stmt.setString(2,be.getFilename());
        stmt.setDouble(3,be.getPrice());
        stmt.setInt(4,be.getQuantity());
        stmt.setDouble(5,be.getSubtotal());
        stmt.setInt(6,be.getItem_id());
        stmt.setInt(7,be.getSubcat_id());
       stmt.setDate(8,new java.sql.Date(todaydate.getTime()));
       stmt.setInt(9,be.getCart_id());
         stmt.setString(10,"NOT DELIVERED");
        
             
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
                 
public int saveUpData(List ar2,List ar3)throws Exception{       
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    //Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    int count=0;
    try {
    Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();    
    String sqlString ="update imd_cart set quantity=? where cart_id=?";
    stmt=conn.prepareStatement(sqlString);
    for(int i=0;i<ar2.size();i++){
            stmt.setInt(1,Integer.parseInt(ar3.get(i).toString()));
            stmt.setInt(2,Integer.parseInt(ar2.get(i).toString()));
            stmt.addBatch();
         }
    stmt.executeBatch();
         }catch(Exception e){
         System.out.println("Exception in Update Item Quantity: "+e.getMessage());}
     finally {
      if ( rs != null ) {rs.close();}
      if ( stmt != null ) {stmt.close();}
      if ( conn != null ) {conn.close();}
     }
     return count;     
     }              
    
                
   
public  item_bean discount_item_detail(int id,String para)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ad=new item_bean();

     try{

           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

    String pro_title="select discount,discountdetail,prod_id,size,unit,detail,item_id,brand,"+para+",marketprice,filename,sc_id,sub_cat,c_id,audio_sample,"
            + "detail,title,cover_content,down_price from item join sub_cat on sub_cat_id=sc_id where item_id="+id;

//System.out.println(pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
      ad.setBrand(rs.getString("brand"));
    ad.setPrice(rs.getDouble(para));
    ad.setMarketprice(rs.getDouble("marketprice"));
    ad.setFilename(rs.getString("filename"));
    ad.setSubcat_id(rs.getInt("sc_id"));
    ad.setSubcat_name(rs.getString("sub_cat"));
   ad.setItem_id(rs.getInt("item_id"));
 ad.setDetail(rs.getString("detail"));
 ad.setProd_id(rs.getString("prod_id"));
 ad.setSize(rs.getString("size"));
 ad.setUnit(rs.getString("unit"));
 ad.setDiscount(rs.getDouble("discount"));
 ad.setDiscountdetail(rs.getString("discountdetail"));
 ad.setSampleFileName(rs.getString("audio_sample"));
 ad.setDetail(rs.getString("detail"));
 ad.setSampleTitle(rs.getString("title"));
 ad.setCover_content(rs.getString("cover_content"));
 ad.setCat_id(rs.getInt("c_id"));
  ad.setDownprice(rs.getDouble("down_price"));
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
    return ad;

}

public  ArrayList discount_itemDetail(int id)throws Exception
    {


    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();

     try{

           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

    String pro_title="select discount,discountdetail,prod_id,size,unit,detail,item_id,brand,price,marketprice,filename,sc_id,sub_cat,audio_sample,detail from new_release join sub_cat on sub_cat_id=sc_id where item_id="+id;


    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        item_bean ad=new item_bean();

    ad.setBrand(rs.getString("brand"));
    ad.setPrice(rs.getDouble("price"));
    ad.setMarketprice(rs.getDouble("marketprice"));
    ad.setFilename(rs.getString("filename"));
    ad.setSubcat_id(rs.getInt("sc_id"));
    ad.setSubcat_name(rs.getString("sub_cat"));
   ad.setItem_id(rs.getInt("item_id"));
 ad.setDetail(rs.getString("detail"));
 ad.setProd_id(rs.getString("prod_id"));
 ad.setSize(rs.getString("size"));
 ad.setUnit(rs.getString("unit"));
 ad.setDiscount(rs.getDouble("discount"));
 ad.setDiscountdetail(rs.getString("discountdetail"));
 ad.setSampleFileName(rs.getString("audio_sample"));
 ad.setDetail(rs.getString("detail"));
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
        
        
public  void  update_item_details(item_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update item set status=?,brand=?,size=?,unit=?,marketprice=?,discount=?,discountdetail=?,price=?,detail=?,prod_id=?,"
              + "modified_time=?,related_items=? where item_id="+be.getItem_id();
        stmt=conn.prepareStatement(sqlString);
         stmt.setString(1,be.getStatus());
         stmt.setString(2,be.getBrand());
         stmt.setString(3,be.getSize());
         stmt.setString(4,be.getUnit());
         stmt.setDouble(5,be.getMarketprice());
          stmt.setDouble(6,be.getDiscount());
          stmt.setString(7,be.getDiscountdetail());          
          stmt.setDouble(8,be.getPrice());
            stmt.setString(9,be.getDetail());     
            stmt.setString(10,be.getProd_id());
            stmt.setTimestamp(11,timestamp);
            stmt.setString(12, be.getRelated_items());
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
    
  public item_bean get_cart_ID(String userid,java.util.Date fromdate,String order_id)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean(); 
     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
   // System.out.println("fd: "+fd);
    String pro_title="select prod_id,shiiping_charge,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size from imd_cart_order where user_id=? and user_type='r' and order_id=? and order_date between ? and ?";
    pstmt=conn.prepareStatement(pro_title);
    pstmt.setString(1, userid);
    pstmt.setString(2, order_id);
    pstmt.setDate(3, fd);
    pstmt.setDate(4,fd);
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
//   det.setOrder_date(rs.getDate("order_date"));
//     det.setOrder_id(rs.getString("order_id"));
//     det.setInvoice_no(rs.getString("invoice_no"));
//     det.setBill_f_name(rs.getString("bill_cusName"));
//     det.setBill_phone(rs.getString("bill_mobileno"));
//     det.setBill_street(rs.getString("bill_street"));
//     det.setBill_city(rs.getString("bill_city"));
//     det.setBill_state(rs.getString("bill_state"));
//     det.setBill_country(rs.getString("bill_country"));
//     det.setBill_zip(rs.getString("bill_pincode"));
//     det.setShip_f_name(rs.getString("bill_cusName"));
//     det.setShip_phone(rs.getString("bill_mobileno"));
//     det.setShip_street(rs.getString("bill_street"));
//     det.setShip_city(rs.getString("bill_city"));
//     det.setShip_state(rs.getString("bill_state"));
//     det.setShip_country(rs.getString("bill_country"));
//     det.setShip_zip(rs.getString("bill_pincode"));
    item_list.add(det);
    }
    itmb.setDataArray(item_list);
    
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status"
            + " from imd_cart_order where user_id=? and user_type='r' and order_id=? and order_date between ? and ?";
    pst=conn.prepareStatement(qr);
  pst.setString(1, userid);
    pst.setString(2, order_id);
    pst.setDate(3, fd);
    pst.setDate(4,fd);
    rs1=pst.executeQuery();
    while(rs1.next())
    {
     item_bean ib=new item_bean();
     ib.setShip_charge(rs1.getDouble("shiiping_charge"));
   ib.setOrder_date(rs1.getDate("order_date"));
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
  
public item_bean all_get_cart_ID(String userid,java.util.Date fromdate,String order_id)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean();
     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select prod_id,shiiping_charge,brand,user_id,filename,item_id,price,quantity,total,order_date,prod_id,size from imd_cart_order"
            + " where user_id=? and order_id=? and order_date between ? and ?";
    pstmt=conn.prepareStatement(pro_title);
    pstmt.setString(1, userid);
    pstmt.setString(2, order_id);
    pstmt.setDate(3, fd);
    pstmt.setDate(4,fd);
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
//   det.setOrder_date(rs.getDate("order_date"));
//     det.setOrder_id(rs.getString("order_id"));
//     det.setInvoice_no(rs.getString("invoice_no"));
//     det.setBill_f_name(rs.getString("bill_cusName"));
//     det.setBill_phone(rs.getString("bill_mobileno"));
//     det.setBill_street(rs.getString("bill_street"));
//     det.setBill_city(rs.getString("bill_city"));
//     det.setBill_state(rs.getString("bill_state"));
//     det.setBill_country(rs.getString("bill_country"));
//     det.setBill_zip(rs.getString("bill_pincode"));
//     det.setShip_f_name(rs.getString("bill_cusName"));
//     det.setShip_phone(rs.getString("bill_mobileno"));
//     det.setShip_street(rs.getString("bill_street"));
//     det.setShip_city(rs.getString("bill_city"));
//     det.setShip_state(rs.getString("bill_state"));
//     det.setShip_country(rs.getString("bill_country"));
//     det.setShip_zip(rs.getString("bill_pincode"));
   
    item_list.add(det);
    }
    itmb.setDataArray(item_list);
       
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status from imd_cart_order"
            + " where user_id=? and order_id=? and order_date between ? and ?";
    pst=conn.prepareStatement(qr);
   pst.setString(1, userid);
    pst.setString(2, order_id);
    pst.setDate(3, fd);
    pst.setDate(4,fd);
    rs1=pst.executeQuery();
    if(rs1.next())
    {
  item_bean ib=new item_bean();
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
           
             public  boolean Read_More(int id)throws Exception
    {
    
    boolean read=false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from proj_detail where head_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
  if(rs.next())
    {
  read=true;
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
    return read;
    
    }
    
      public  ArrayList search_item(String search,int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select detail,unit,item_id,brand,price,marketprice,filename,sc_id,sub_cat from item join sub_cat on sub_cat_id=sc_id where brand like '"+search+"%' and sc_id="+id;


    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        item_bean ad=new item_bean();
  
    ad.setBrand(rs.getString("brand"));
    ad.setPrice(rs.getDouble("price"));
    ad.setMarketprice(rs.getDouble("marketprice"));
    ad.setFilename(rs.getString("filename"));
    ad.setSubcat_id(rs.getInt("sc_id"));
    ad.setSubcat_name(rs.getString("sub_cat"));
   ad.setItem_id(rs.getInt("item_id"));
   ad.setUnit(rs.getString("unit"));
   ad.setDetail(rs.getString("detail"));
   
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
               public  img_bean select_head_detail(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
      img_bean ad=new img_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_cr where prop_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
 
  ad.setHead(rs.getString("location"));
  ad.setHead_id(rs.getInt("prop_id"));
  ad.setPage_name(rs.getString("page_name"));
  
   
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
                      public  img_bean select_desc_detail(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
      img_bean ad=new img_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_cr where prop_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
 
  ad.setDesc(rs.getString("descr"));
  
   ad.setHead_id(rs.getInt("prop_id"));
  ad.setPage_name(rs.getString("page_name"));
  
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
                           public  img_bean select_head_more(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
      img_bean ad=new img_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from proj_detail where proj_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
 
 ad.setHead(rs.getString("proj_head"));
  
   ad.setHead_id(rs.getInt("proj_id"));
   ad.setPage_name(rs.getString("page_name"));
  
   
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
            
                                 public  void  update_last_content(img_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update prop_cr set descr=? where prop_id='"+be.getHead_id()+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,be.getDesc());
            
            
      
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
                                 
                                 
                                 
                                       public  void  update_descdetail_content(img_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update proj_detail set proj_detail=? where proj_id='"+be.getHead_id()+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,be.getDesc());
            
            
      
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
                                  
      
           
       public  img_bean select_desc_more(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
      img_bean ad=new img_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from proj_detail where proj_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
 
    ad.setDesc(rs.getString("proj_detail"));
  
   ad.setHead_id(rs.getInt("proj_id"));
   ad.setPage_name(rs.getString("page_name"));
  
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
            
                                       public  void  update_head_content(img_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update prop_cr set location=? where prop_id='"+be.getHead_id()+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,be.getHead());
            
            
      
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
    
public  ArrayList select_content_edit(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_cr where page_name='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        img_bean ad=new img_bean();
   ad.setPage_name(rs.getString("page_name"));   
   ad.setPage_id(rs.getInt("prop_id"));
   ad.setFilename(rs.getString("filename"));
   ad.setHead(rs.getString("location"));
   ad.setDesc(rs.getString("descr"));
  
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
                                            
                                                 public  void  update_desc_more(img_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update proj_detail set proj_detail=? where proj_id='"+be.getHead_id()+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,be.getDesc());
            
            
      
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
  
                                                public  ArrayList select_quality_edit(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_cr where page_name='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        img_bean ad=new img_bean();
   ad.setPage_name(rs.getString("page_name"));   
   ad.setPage_id(rs.getInt("prop_id"));
   ad.setFilename(rs.getString("filename"));
   ad.setHead(rs.getString("location"));
   ad.setDesc(rs.getString("descr"));
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
                                                 public  void  update_desc_content(img_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update prop_cr set descr=? where prop_id='"+be.getHead_id()+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,be.getDesc());
            
            
      
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
                         public  void  update_head_more(img_bean be)throws Exception 
    {
   
        
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    
      String sqlString ="update proj_detail set proj_head=? where proj_id='"+be.getHead_id()+"'";

            stmt=conn.prepareStatement(sqlString);
             stmt.setString(1,be.getHead());
            
            
      
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
    
   public static void  insert_gal_Image(String filename,img_bean be)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
     
      

      String sqlString ="insert into more_image(page_name,page_id,filename)values(?,?,?)";
        stmt=conn.prepareStatement(sqlString);
        stmt.setString(1,be.getPage_name());
        stmt.setInt(2,be.getPage_id());
        stmt.setString(3,filename);
          
            
             
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
     public  void  update_more_Image(String filename,int id)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
  String sqlString ="update more_image set filename=? where file_id="+id;
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
     
     
     }
    
    
     public  void  update_Image(String filename,int id)throws Exception 
    {
         Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
         try {
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
  String sqlString ="update prop_cr set filename=? where prop_id="+id;
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
     
     
     }
        public  img_bean fetch_img_detail(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    img_bean ad=new img_bean();
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select prop_id,page_name from prop_cr where prop_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   ad.setPage_name(rs.getString("page_name"));   
   ad.setPage_id(rs.getInt("prop_id"));
    
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
    
public  ArrayList select_content_detail(int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from proj_detail where head_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   img_bean ad=new img_bean();
  ad.setHead(rs.getString("proj_head"));
  ad.setDesc(rs.getString("proj_detail"));
  ad.setDetail_id(rs.getInt("proj_id"));
  ad.setHead_id(rs.getInt("head_id"));
  ad.setFilename(rs.getString("filename"));
  ad.setPage_name(rs.getString("page_name"));
  
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
           public  ArrayList select_moreimg(String page,int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from more_image where page_name='"+page+"' and page_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        img_bean ad=new img_bean();
  
   ad.setPage_id(rs.getInt("file_id"));
   ad.setFilename(rs.getString("filename"));
  
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
           
  public  ArrayList select_content(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_cr where page_name='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        img_bean ad=new img_bean();
   ad.setPage_name(rs.getString("page_name"));   
   ad.setPage_id(rs.getInt("prop_id"));
   ad.setFilename(rs.getString("filename"));
   ad.setHead(rs.getString("location"));
   ad.setDesc(rs.getString("descr"));
  
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


        public  ArrayList select_quality(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from prop_cr where page_name='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        img_bean ad=new img_bean();
   ad.setPage_name(rs.getString("page_name"));   
   ad.setPage_id(rs.getInt("prop_id"));
   ad.setFilename(rs.getString("filename"));
   ad.setHead(rs.getString("location"));
   ad.setDesc(rs.getString("descr"));
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




   public  ArrayList select_discount_item()throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select unit,item_id,brand,price,marketprice,filename,sc_id,sub_cat from item join sub_cat on sub_cat_id=sc_id where discount>0";


    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        item_bean ad=new item_bean();
  
    ad.setBrand(rs.getString("brand"));
    ad.setPrice(rs.getDouble("price"));
    ad.setMarketprice(rs.getDouble("marketprice"));
    ad.setFilename(rs.getString("filename"));
    ad.setSubcat_id(rs.getInt("sc_id"));
    ad.setSubcat_name(rs.getString("sub_cat"));
   ad.setItem_id(rs.getInt("item_id"));
   ad.setUnit(rs.getString("unit"));
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
            
    public void email_Add(String emailadd)throws Exception
   {
       
       Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String email="insert into email_add(emailaddress)values(?)";


    pstmt=conn.prepareStatement(email);
    pstmt.setString(1,emailadd);
            
            
      
     pstmt.executeUpdate();
    
    
    
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
  }
   
   public ArrayList email_get()throws Exception
   {
       ArrayList al=new ArrayList();
       String emailadd="";
       
       
       Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String emailid="select * from email_add";


    pstmt=conn.prepareStatement(emailid);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
        al.add(rs.getString("emailaddress"));
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
       
   return(al);
   }
    public void  delete_shop_cart_id(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  imd_cart where cart_id="+id;
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
    
public void addto_mywishlist(int itemid, String userid,item_bean ib)throws Exception
   {
       
       Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
       Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String email="insert into mywishlist(user_id,item_id,prod_id)values(?,?,?)";
    pstmt=conn.prepareStatement(email);
    pstmt.setString(1,userid);
    pstmt.setInt(2,ib.getItem_id());
    pstmt.setString(3,ib.getProd_id());
      
    pstmt.executeUpdate();
   }catch(Exception e){
    System.out.println("EX.: "+e.getMessage());
    }
   finally {
        if(rs!=null ){rs.close();}
        if(pstmt!=null){pstmt.close();}
        if(conn!=null){conn.close();}
    }
  }

public int checkItemInWishlist(String email,int itemid)throws Exception
{
    int chk=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select count(*) as cn from mywishlist where user_id='"+email+"' and item_id="+itemid;

    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
       chk=rs.getInt("cn");
    }
  }catch(Exception e){}
    finally {
    if ( rs != null ) {rs.close(); }
    if ( pstmt != null ) {pstmt.close();}
    if ( conn != null ) {conn.close();}
   }
    return chk;
}

public  ArrayList get_relatedItems(int id)throws Exception
    {
//    int sc_id=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
//    String pro_title="select sc_id from item where item_id="+id;    old style
    String pro_title="select related_items from item where item_id="+id;
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    if(rs.next())
    {
//        sc_id=rs.getInt("sc_id");
//        String qr="select * from item where item_id in (select max(item_id) as item_id from item where sc_id='"+sc_id+"' and item_id<'"+id+"'"
//                + " UNION (select min(item_id) as item_id from item where sc_id='"+sc_id+"' and item_id>'"+id+"'))";     old style
        
        String rel_items=rs.getString("related_items");
        String items[]=rel_items.split(",");
        for(int i=0;i<items.length;i++){
            String qr="select * from item where prod_id=?";
        pstmt1=conn.prepareStatement(qr);
        pstmt1.setString(1, items[i].trim());
        rs1=pstmt1.executeQuery();
        if(rs1.next())
        {
            mc_prop item=new mc_prop();
            item.setItem_id(rs1.getInt("item_id"));
            item.setBrand(rs1.getString("brand"));
            item.setPrice(rs1.getDouble("price"));
            item.setMarketprice(rs1.getDouble("marketprice"));
            item.setFilename(rs1.getString("filename"));
            item.setProd_id(rs1.getString("prod_id"));
          ad_list.add(item);  
        }
        }
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( rs1 != null ) {rs1.close();}
        if ( pstmt1 != null ) {pstmt1.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return ad_list;
    
    } 
     
  public  ArrayList get_wishlist(String email)throws Exception
    {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    String aa= "";
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from mywishlist where user_id='"+email+"'";


    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     ad_list.add(this.discount_item_detail(rs.getInt("item_id"),aa));
    }
   }catch(Exception e){}
    finally {
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
     }
    return ad_list;
    
    } 
  
  public  ArrayList remove_item_from_wishlist(String email, int id)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="DELETE from mywishlist where user_id='"+email+"' and item_id="+id;


    pstmt=conn.prepareStatement(pro_title);
    pstmt.executeUpdate();
     }
     catch(Exception e){}
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }
    }
    
    ad_list=this.get_wishlist(email);
    return ad_list;
} 
  
  public double get_promo_rate(String promo)throws Exception{
      double promo_rate=0.0;
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=new item_bean();
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="select pr_value from promotional_code where promo_code='"+promo+"'";
        pstmt=conn.prepareStatement(sqlqry);
        rs=pstmt.executeQuery();
        
        while(rs.next()){
            
            promo_rate=rs.getDouble("pr_value");
        }
    }
    catch(Exception e){}
    finally{
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
      //promo_rate=ib.getPromo_value();
      return promo_rate;
  }
  
  public ArrayList get_orders_by_user(String userid)throws Exception{
      ArrayList al_list=new ArrayList();
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=new item_bean();
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="select order_id,cart_id,filename,item_id,price,quantity,total,cart_date,name,imd_cart.status,size,prod_id from imd_cart join registrationtable reg on imd_cart.user_id=reg.email_id where user_id='"+userid+"'";
        pstmt=conn.prepareStatement(sqlqry);
        rs=pstmt.executeQuery();
        
        while(rs.next()){
            
            item_bean det=new item_bean();    
    det.setFilename(rs.getString("filename"));
    det.setItem_id(rs.getInt("item_id"));    
    det.setPrice(rs.getDouble("price"));    
    det.setQuantity(rs.getInt("quantity"));
    det.setSubtotal(rs.getDouble("total"));
    det.setCartdate(rs.getDate("cart_date"));
    det.setUsername(rs.getString("name"));
    det.setCart_id(rs.getInt("cart_id"));
//    det.setOrder_id(rs.getInt("order_id"));
    det.setStatus(rs.getString("status"));
    det.setSize(rs.getString("size"));
    det.setProd_id(rs.getString("prod_id"));
    
    al_list.add(det);
        }
    }
    catch(Exception e){}
    finally{
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
      //promo_rate=ib.getPromo_value();
      return al_list;
  }
  
  
public ArrayList get_orderList(java.util.Date fromdate,java.util.Date todate,int offset,int noOfRecords)throws Exception
  {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList item_list=new ArrayList();
    java.sql.Date fd=new java.sql.Date(fromdate.getTime());
     java.sql.Date td=new java.sql.Date(todate.getTime());
    
    
       try{
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select SQL_CALC_FOUND_ROWS user_id,bill_cusName,order_id,shp_status,invoice_no,order_date,invoice_date,order_date from imd_cart_order"
            + " where order_date between '"+fd+"' and '"+td+"' group by order_id order by order_date desc limit " + offset +"," + noOfRecords;
    System.out.println(pro_title);
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
   
  det.setOrder_id(rs.getString("order_id"));
    det.setUser_id(rs.getString("user_id"));
    det.setUsername(rs.getString("bill_cusName"));
    det.setStatus(rs.getString("shp_status"));
    det.setInvoice_no(rs.getString("invoice_no"));
    det.setOrder_date(rs.getDate("order_date"));
    det.setInvoice_date(rs.getDate("invoice_date"));
    det.setOrder_date(rs.getDate("order_date"));
    item_list.add(det);
    }
   rs.close();
 
    rs = pstmt.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);  
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
    return item_list;
    
    }


public item_bean order_ID_date(String orderid)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean(); 
//     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
//      java.sql.Date td= new java.sql.Date(todate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
   // System.out.println("fd: "+fd);
  //  String pro_title="select shiiping_charge,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size from imd_cart_order  where user_id='"+userid+"' and order_date between '"+fd+"' and '"+td+"'";
  String pro_title="select shiiping_charge,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size from imd_cart_order"
          + " where order_id='"+orderid+"'";
 
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
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
    
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,invoice_date from imd_cart_order"
            + " where order_id=?";
    pst=conn.prepareStatement(qr);
    pst.setString(1,orderid);
//    pst.setDate(2, fd);
//    pst.setDate(3, fd);
    rs1=pst.executeQuery();
    if(rs1.next())
    {
     item_bean ib=new item_bean();
     ib.setOrder_date(rs1.getDate("order_date"));
     ib.setShip_charge(rs1.getDouble("shiiping_charge"));
   //  System.out.println("Ship: "+rs1.getDouble("shiiping_charge"));
     ib.setOrder_id(rs1.getString("order_id"));
     ib.setInvoice_no(rs1.getString("invoice_no"));
     ib.setBill_f_name(rs1.getString("bill_cusName"));
     ib.setBill_phone(rs1.getString("bill_mobileno"));
     ib.setBill_street(rs1.getString("bill_street"));
     ib.setBill_city(rs1.getString("bill_city"));
     ib.setBill_state(rs1.getString("bill_state"));
     ib.setBill_country(rs1.getString("bill_country"));
     ib.setBill_zip(rs1.getString("bill_pincode"));
     
     ib.setShip_f_name(rs1.getString("ship_cusName"));
     ib.setShip_phone(rs1.getString("ship_mobileno"));
     ib.setShip_street(rs1.getString("ship_street"));
     ib.setShip_city(rs1.getString("ship_city"));
     ib.setShip_state(rs1.getString("ship_state"));
     ib.setShip_country(rs1.getString("ship_country"));
     ib.setShip_zip(rs1.getString("ship_pincode"));
     ib.setInvoice_date(rs1.getDate("invoice_date"));
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

public item_bean packSlipOrderDetails(String orderid)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean(); 
//     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
//      java.sql.Date td= new java.sql.Date(todate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
   // System.out.println("fd: "+fd);
  //  String pro_title="select shiiping_charge,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size from imd_cart_order  where user_id='"+userid+"' and order_date between '"+fd+"' and '"+td+"'";
  String pro_title="select shiiping_charge,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size,sc_id,request_type"
          + " from imd_cart_order where order_id='"+orderid+"'";
 
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
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
   if(rs.getString("request_type").equals("download request")){
    String shpStatus=chkCatForShippingCharge(rs.getInt("sc_id"),"sub_cat_id");
    if(shpStatus.equals("yes"))
        item_list.add(det);
    }
   else
       item_list.add(det);
    }
    itmb.setDataArray(item_list);
    
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,invoice_date from imd_cart_order"
            + " where order_id=?";
    pst=conn.prepareStatement(qr);
    pst.setString(1,orderid);
//    pst.setDate(2, fd);
//    pst.setDate(3, fd);
    rs1=pst.executeQuery();
    if(rs1.next())
    {
     item_bean ib=new item_bean();
     ib.setOrder_date(rs1.getDate("order_date"));
     ib.setShip_charge(rs1.getDouble("shiiping_charge"));
   //  System.out.println("Ship: "+rs1.getDouble("shiiping_charge"));
     ib.setOrder_id(rs1.getString("order_id"));
     ib.setInvoice_no(rs1.getString("invoice_no"));
     ib.setBill_f_name(rs1.getString("bill_cusName"));
     ib.setBill_phone(rs1.getString("bill_mobileno"));
     ib.setBill_street(rs1.getString("bill_street"));
     ib.setBill_city(rs1.getString("bill_city"));
     ib.setBill_state(rs1.getString("bill_state"));
     ib.setBill_country(rs1.getString("bill_country"));
     ib.setBill_zip(rs1.getString("bill_pincode"));
     
     ib.setShip_f_name(rs1.getString("ship_cusName"));
     ib.setShip_phone(rs1.getString("ship_mobileno"));
     ib.setShip_street(rs1.getString("ship_street"));
     ib.setShip_city(rs1.getString("ship_city"));
     ib.setShip_state(rs1.getString("ship_state"));
     ib.setShip_country(rs1.getString("ship_country"));
     ib.setShip_zip(rs1.getString("ship_pincode"));
     ib.setInvoice_date(rs1.getDate("invoice_date"));
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

public item_bean get_cart_ID_date(String userid,java.util.Date fromdate,java.util.Date todate, String order_id)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean(); 
     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
      java.sql.Date td= new java.sql.Date(todate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
   // System.out.println("fd: "+fd);
    String pro_title="select shiiping_charge,prod_id,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size from imd_cart_order where user_id=? and user_type='r' and order_id=? and order_date between ? and ?";
//    System.out.println(pro_title);
    pstmt=conn.prepareStatement(pro_title);
    pstmt.setString(1, userid);
    pstmt.setString(2, order_id);
    pstmt.setDate(3, fd);
    pstmt.setDate(4,td);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
     item_bean det=new item_bean(); 
   det.setBrand(rs.getString("brand"));
   det.setProd_id(rs.getString("prod_id"));
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
//   det.setOrder_date(rs.getDate("order_date"));
//     det.setOrder_id(rs.getString("order_id"));
//     det.setInvoice_no(rs.getString("invoice_no"));
//     det.setBill_f_name(rs.getString("bill_cusName"));
//     det.setBill_phone(rs.getString("bill_mobileno"));
//     det.setBill_street(rs.getString("bill_street"));
//     det.setBill_city(rs.getString("bill_city"));
//     det.setBill_state(rs.getString("bill_state"));
//     det.setBill_country(rs.getString("bill_country"));
//     det.setBill_zip(rs.getString("bill_pincode"));
//     det.setShip_f_name(rs.getString("bill_cusName"));
//     det.setShip_phone(rs.getString("bill_mobileno"));
//     det.setShip_street(rs.getString("bill_street"));
//     det.setShip_city(rs.getString("bill_city"));
//     det.setShip_state(rs.getString("bill_state"));
//     det.setShip_country(rs.getString("bill_country"));
//     det.setShip_zip(rs.getString("bill_pincode"));
    item_list.add(det);
    }
    itmb.setDataArray(item_list);
    
    
    
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status from imd_cart_order"
            + " join registrationtable reg on imd_cart_order.user_id=reg.email_id where user_id=? and order_id=? and order_date between ? and ?";
    pst=conn.prepareStatement(qr);
     pst.setString(1, userid);
    pst.setString(2, order_id);
    pst.setDate(3, fd);
    pst.setDate(4,td);
    rs1=pst.executeQuery();
    while(rs1.next())
    {
      item_bean ib=new item_bean();
//       ib.setShip_charge(rs1.getDouble("shiiping_charge"));
   ib.setOrder_date(rs1.getDate("order_date"));
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


public item_bean gues_get_cart_ID_date(String userid,java.util.Date fromdate,java.util.Date todate,String order_id)throws Exception
    {
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ArrayList item_list=new ArrayList();
    ArrayList item_list1=new ArrayList();
    item_bean itmb=new item_bean(); 
     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
      java.sql.Date td= new java.sql.Date(todate.getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
   // System.out.println("fd: "+fd);
    String pro_title="select prod_id,shiiping_charge,brand,filename,item_id,price,quantity,total,order_date,user_id,prod_id,size,bill_cusName,"
            + "bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,"
            + "ship_state,ship_country from imd_cart_order  where user_id=? and order_id=? and order_date between ? and ?";
    pstmt=conn.prepareStatement(pro_title);
    pstmt.setString(1, userid);
    pstmt.setString(2, order_id);
    pstmt.setDate(3, fd);
    pstmt.setDate(4,td);
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
//   det.setOrder_date(rs.getDate("order_date"));
//     det.setOrder_id(rs.getString("order_id"));
//     det.setInvoice_no(rs.getString("invoice_no"));
//     det.setBill_f_name(rs.getString("bill_cusName"));
//     det.setBill_phone(rs.getString("bill_mobileno"));
//     det.setBill_street(rs.getString("bill_street"));
//     det.setBill_city(rs.getString("bill_city"));
//     det.setBill_state(rs.getString("bill_state"));
//     det.setBill_country(rs.getString("bill_country"));
//     det.setBill_zip(rs.getString("bill_pincode"));
//     det.setShip_f_name(rs.getString("bill_cusName"));
//     det.setShip_phone(rs.getString("bill_mobileno"));
//     det.setShip_street(rs.getString("bill_street"));
//     det.setShip_city(rs.getString("bill_city"));
//     det.setShip_state(rs.getString("bill_state"));
//     det.setShip_country(rs.getString("bill_country"));
//     det.setShip_zip(rs.getString("bill_pincode"));
    item_list.add(det);
    }
    itmb.setDataArray(item_list);
    
  
    String qr="select order_date,shiiping_charge,order_id,invoice_no,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,"
            + "bill_country,ship_cusName,ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status from imd_cart_order"
            + " where user_id=? and order_id=? and order_date between ? and ? group by order_id";
    pst=conn.prepareStatement(qr);
    pst.setString(1, userid);
    pst.setString(2, order_id);
    pst.setDate(3, fd);
    pst.setDate(4,td);
    rs1=pst.executeQuery();
    if(rs1.next())
    {
       item_bean ib=new item_bean();
     ib.setOrder_date(rs1.getDate("order_date"));
     ib.setShip_charge(rs1.getDouble("shiiping_charge"));
   //  System.out.println("Ship: "+rs1.getDouble("shiiping_charge"));
     ib.setOrder_id(rs1.getString("order_id"));
     ib.setInvoice_no(rs1.getString("invoice_no"));
     ib.setBill_f_name(rs1.getString("bill_cusName"));
     ib.setBill_phone(rs1.getString("bill_mobileno"));
     ib.setBill_street(rs1.getString("bill_street"));
     ib.setBill_city(rs1.getString("bill_city"));
     ib.setBill_state(rs1.getString("bill_state"));
     ib.setBill_country(rs1.getString("bill_country"));
     ib.setBill_zip(rs1.getString("bill_pincode"));
     
     ib.setShip_f_name(rs1.getString("ship_cusName"));
     ib.setShip_phone(rs1.getString("ship_mobileno"));
     ib.setShip_street(rs1.getString("ship_street"));
     ib.setShip_city(rs1.getString("ship_city"));
     ib.setShip_state(rs1.getString("ship_state"));
     ib.setShip_country(rs1.getString("ship_country"));
     ib.setShip_zip(rs1.getString("ship_pincode"));
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

 public  ArrayList select_streamContent(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    java.sql.Date stdt=new java.sql.Date(new java.util.Date().getTime());
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from everyday_stream where pagename='"+page+"' and status='inplaylist'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   img_bean ad=new img_bean();
   ad.setPage_name(rs.getString("pagename"));   
   ad.setSampleFileName(rs.getString("filename"));
   ad.setSampleTitle(rs.getString("title"));
   
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

public  ArrayList select_allEvdstreamContent(String page)throws Exception
    {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList ad_list=new ArrayList();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
     try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
    String pro_title="select * from everyday_stream where pagename='"+page+"'";
    pstmt=conn.prepareStatement(pro_title);
    rs=pstmt.executeQuery();
    while(rs.next())
    {
   img_bean ad=new img_bean();
   ad.setHead_id(rs.getInt("rwid"));
   ad.setPage_name(rs.getString("pagename"));   
   ad.setSampleFileName(rs.getString("filename"));
   ad.setSampleTitle(rs.getString("title"));
   ad.setDate(sdf.format(rs.getDate("stream_date")));
   ad.setStatus(rs.getString("status"));
    ad_list.add(ad);
    }
    
    
    }catch(Exception e){
    
    System.out.println("Hello: "+e.getMessage());
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

public void det_user_cart(String userid)throws Exception{
      ArrayList al_list=new ArrayList();
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=new item_bean();
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="delete from imd_cart where user_id=?";
        pstmt=conn.prepareStatement(sqlqry);
        pstmt.setString(1, userid);
        pstmt.executeUpdate();
        
    }
    catch(Exception e){}
    finally{
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
      //promo_rate=ib.getPromo_value();
     
  }
   
 public void insert_imd_cart_order(ArrayList usr_cart,item_bean address,String order_id,double shp)throws Exception{
      ArrayList al_list=new ArrayList();
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=null;
    java.util.Date ordt=new java.util.Date();
    String shpStatus=this.retCatShipChargeStatus(usr_cart);
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="insert into imd_cart_order(user_id,filename,price,quantity,total,item_id,sc_id,cart_id,cart_date,order_id,status,prod_id,size,"
                + "brand,order_date,shiiping_charge,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,bill_country,ship_cusName,"
                + "ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status,user_type,shipment,request_type,pay_mode)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//       System.out.println("Hello Size: "+usr_cart.size());
        if(usr_cart.size()!=0){
             pstmt=conn.prepareStatement(sqlqry);
            for(int i=0;i<usr_cart.size();i++)
            {
                ib=(item_bean)usr_cart.get(i);
                pstmt.setString(1, ib.getUser_id());
                pstmt.setString(2, ib.getFilename());
                pstmt.setDouble(3, ib.getPrice());
                pstmt.setDouble(4, ib.getQuantity());
                pstmt.setDouble(5, ib.getSubtotal());
                pstmt.setInt(6, ib.getItem_id());
                pstmt.setInt(7, ib.getSubcat_id());
                pstmt.setInt(8, ib.getCart_id());
                if(ib.getCartdate()!=null){
                pstmt.setDate(9, new java.sql.Date(ib.getCartdate().getTime()));
                }else
                {
                    pstmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));
                }
                pstmt.setString(10, order_id);
                pstmt.setString(11, "purchased");
                pstmt.setString(12, ib.getProd_id());
                pstmt.setString(13, ib.getSize());
                 pstmt.setString(14, ib.getBrand());
                 pstmt.setDate(15, new java.sql.Date(ordt.getTime()));
                 pstmt.setDouble(16, shp);
                 pstmt.setString(17, address.getBill_f_name()+" "+address.getBill_l_name());
                 pstmt.setString(18, address.getBill_phone());
                 pstmt.setString(19, address.getBill_street());
                 pstmt.setString(20, address.getBill_city());
                 pstmt.setString(21, address.getBill_zip());
                 pstmt.setString(22, address.getBill_state());
                 pstmt.setString(23, address.getBill_country());
                 if(!address.getKind().equals("download request"))
                 {
                 pstmt.setString(24, address.getShip_f_name()+" "+address.getShip_l_name());
                 pstmt.setString(25, address.getShip_phone());
                 pstmt.setString(26, address.getShip_street());
                 pstmt.setString(27, address.getShip_city());
                 pstmt.setString(28, address.getShip_zip());
                 pstmt.setString(29, address.getShip_state());
                 pstmt.setString(30, address.getShip_country());
                 pstmt.setString(31, "NO");
                 }
                 else{
                   pstmt.setString(24, "NA");
                 pstmt.setString(25, "NA");
                 pstmt.setString(26, "NA");
                 pstmt.setString(27, "NA");
                 pstmt.setString(28, "NA");
                 pstmt.setString(29, "NA");
                 pstmt.setString(30, "NA");
                 if(shpStatus.equals("yes"))
                     pstmt.setString(31, "NO"); 
                 else
                    pstmt.setString(31, "Not Required");  
                 }
                 pstmt.setString(32, "r");
                 pstmt.setString(33, address.getShipmentTo());
                 pstmt.setString(34, address.getKind());
                 pstmt.setString(35, address.getType());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }
    catch(Exception e){System.out.println("Registered User Purchase: "+e.getMessage());}
    finally{
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
      //promo_rate=ib.getPromo_value();
     
  }



public void insert_imd_cart_order_guest(ArrayList usr_cart,String guest_mail,item_bean address,String order_id,double shp)throws Exception
{
      ArrayList al_list=new ArrayList();
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=null;
    java.util.Date ordt=new java.util.Date();
    String shpStatus=this.retCatShipChargeStatus(usr_cart);
    System.out.println("shpStatus: "+shpStatus);
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="insert into imd_cart_order(user_id,filename,price,quantity,total,item_id,sc_id,cart_id,cart_date,order_id,status,prod_id,size,"
                + "brand,order_date,shiiping_charge,bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,bill_country,ship_cusName,"
                + "ship_mobileno,ship_street,ship_city,ship_pincode,ship_state,ship_country,shp_status,user_type,shipment,request_type,pay_mode)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//       System.out.println("Hello Size: "+usr_cart.size());
        if(usr_cart.size()!=0){
             pstmt=conn.prepareStatement(sqlqry);
            for(int i=0;i<usr_cart.size();i++)
            {
                ib=(item_bean)usr_cart.get(i);
                pstmt.setString(1, guest_mail);
                pstmt.setString(2, ib.getFilename());
                pstmt.setDouble(3, ib.getPrice());
                pstmt.setDouble(4, ib.getQuantity());
                pstmt.setDouble(5, ib.getSubtotal());
                pstmt.setInt(6, ib.getItem_id());
                pstmt.setInt(7, ib.getSubcat_id());
                pstmt.setInt(8, ib.getCart_id());
                if(ib.getCartdate()!=null){
                pstmt.setDate(9, new java.sql.Date(ib.getCartdate().getTime()));
                }else
                {
                    pstmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));
                }
                pstmt.setString(10, order_id);
                pstmt.setString(11, "purchased");
                pstmt.setString(12, ib.getProd_id());
                pstmt.setString(13, ib.getSize());
                 pstmt.setString(14, ib.getBrand());
                 pstmt.setDate(15, new java.sql.Date(ordt.getTime()));
                 pstmt.setDouble(16, shp);
                 pstmt.setString(17, address.getBill_f_name()+" "+address.getBill_l_name());
                 pstmt.setString(18, address.getBill_phone());
                 pstmt.setString(19, address.getBill_street());
                 pstmt.setString(20, address.getBill_city());
                 pstmt.setString(21, address.getBill_zip());
                 pstmt.setString(22, address.getBill_state());
                 pstmt.setString(23, address.getBill_country());
                 if(!address.getKind().equals("download request"))
                 {
                 pstmt.setString(24, address.getShip_f_name()+" "+address.getShip_l_name());
                 pstmt.setString(25, address.getShip_phone());
                 pstmt.setString(26, address.getShip_street());
                 pstmt.setString(27, address.getShip_city());
                 pstmt.setString(28, address.getShip_zip());
                 pstmt.setString(29, address.getShip_state());
                 pstmt.setString(30, address.getShip_country());
                 pstmt.setString(31, "NO");
                 }
                 else{
                   pstmt.setString(24, "NA");
                 pstmt.setString(25, "NA");
                 pstmt.setString(26, "NA");
                 pstmt.setString(27, "NA");
                 pstmt.setString(28, "NA");
                 pstmt.setString(29, "NA");
                 pstmt.setString(30, "NA");
                 if(shpStatus.equals("yes"))
                     pstmt.setString(31, "NO"); 
                 else
                    pstmt.setString(31, "Not Required");  
                 }
                 pstmt.setString(32, "g");
                 pstmt.setString(33, address.getShipmentTo());
                 pstmt.setString(34, address.getKind());
                 pstmt.setString(35, address.getType());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }
    catch(Exception e){System.out.println("Guest Purchase: "+e.getMessage());}
    finally{
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
      //promo_rate=ib.getPromo_value();
     
  }


public int checkQuestOrderIdInTemp(String table,String orderid)throws Exception{
    int cn=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        String qr="select count(*) as cn from "+table+" where order_id='"+orderid+"'";
//        System.out.println("qry: "+qr);
        pstmt=conn.prepareStatement(qr);
//        pstmt.setString(1, orderid);
        rs=pstmt.executeQuery();
        if(rs.next())
            cn=rs.getInt("cn");
    }catch(Exception e){System.out.println("Guest Purchase: "+e.getMessage());}
    finally{
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
    return cn;
}
public void insert_imd_cart_guest_temp(ArrayList usr_cart,String guest_mail,item_bean address,String order_id,double shp)throws Exception
{
      ArrayList al_list=new ArrayList();
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=null;
    java.util.Date ordt=new java.util.Date();
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="insert into imd_cart(user_id,filename,quantity,item_id,sc_id,cart_date,order_id,prod_id,brand,shiiping_charge,"
                + "bill_cusName,bill_mobileno,bill_street,bill_city,bill_pincode,bill_state,bill_country,ship_cusName,ship_mobileno,ship_street,"
                + "ship_city,ship_pincode,ship_state,ship_country,user_type,shipment,request_type)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?)";
//       System.out.println("Hello Size: "+usr_cart.size());
        if(usr_cart.size()!=0){
             pstmt=conn.prepareStatement(sqlqry);
            for(int i=0;i<usr_cart.size();i++)
            {
                ib=(item_bean)usr_cart.get(i);
                pstmt.setString(1, guest_mail);
                pstmt.setString(2, ib.getFilename());
                pstmt.setDouble(3, ib.getQuantity());
                pstmt.setInt(4, ib.getItem_id());
                pstmt.setInt(5, ib.getSubcat_id());
                pstmt.setDate(6, new java.sql.Date(new java.util.Date().getTime()));                
                pstmt.setString(7, order_id);
                pstmt.setString(8, ib.getProd_id());
                 pstmt.setString(9, ib.getBrand());
                 pstmt.setDouble(10, shp);
                 pstmt.setString(11, address.getBill_f_name()+" "+address.getBill_l_name());
                 pstmt.setString(12, address.getBill_phone());
                 pstmt.setString(13, address.getBill_street());
                 pstmt.setString(14, address.getBill_city());
                 pstmt.setString(15, address.getBill_zip());
                 pstmt.setString(16, address.getBill_state());
                 pstmt.setString(17, address.getBill_country());
                 if(!address.getKind().equals("download request"))
                 {
                 pstmt.setString(18, address.getShip_f_name()+" "+address.getShip_l_name());
                 pstmt.setString(19, address.getShip_phone());
                 pstmt.setString(20, address.getShip_street());
                 pstmt.setString(21, address.getShip_city());
                 pstmt.setString(22, address.getShip_zip());
                 pstmt.setString(23, address.getShip_state());
                 pstmt.setString(24, address.getShip_country());
                 }
                 else{
                   pstmt.setString(18, "NA");
                 pstmt.setString(19, "NA");
                 pstmt.setString(20, "NA");
                 pstmt.setString(21, "NA");
                 pstmt.setString(22, "NA");
                 pstmt.setString(23, "NA");
                 pstmt.setString(24, "NA");  
                 }
                 pstmt.setString(25, "g");
                 pstmt.setString(26, address.getShipmentTo());
                 pstmt.setString(27, address.getKind());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }
    catch(Exception e){System.out.println("Guest : "+e.getMessage());}
    finally{
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
      //promo_rate=ib.getPromo_value();
     
  }

public void del_guest_ord_from_imd_cart(String order_id)throws Exception{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    item_bean ib=new item_bean();
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sqlqry="delete from imd_cart where order_id=?";
        pstmt=conn.prepareStatement(sqlqry);
        pstmt.setString(1, order_id);
        pstmt.executeUpdate();
        
    }
    catch(Exception e){}
    finally{
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
}

public void updateInviceOfOrder(String invoice,String orderid)throws Exception
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    java.util.Date dt=new java.util.Date();
    java.sql.Date sdt=new java.sql.Date(dt.getTime());
     
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
        
        String sr="update imd_cart_order set invoice_no=?,invoice_date=?,shp_status=? where order_id=?";
        pstmt=conn.prepareStatement(sr);
        pstmt.setString(1,invoice);
        pstmt.setDate(2, sdt);
        pstmt.setString(3,"Shipped");
        pstmt.setString(4,orderid);
        pstmt.executeUpdate();
        
    }catch(Exception e){}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
}


public int chkInvoice(String orderid)throws Exception
{
    int cn=0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    
    try{
        String qr="select count(invoice_no) as cn from imd_cart_order where order_id=?";
        pstmt=conn.prepareStatement(qr);
        pstmt.setString(1, orderid);
        rs=pstmt.executeQuery();
        if(rs.next())
        {
            cn=rs.getInt("cn");
        }
        
        
    }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return cn;
}
public String genInvoiceNo()throws Exception
{
    String preOrderId="";
    String orderId="";
    String dateFun="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    dateFun=this.genDate();
//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date dt=new java.util.Date();
    java.sql.Date sdt=new java.sql.Date(dt.getTime());
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    
    try{
        String qr="select invoice_no from imd_cart_order where invoice_date='"+sdt+"' and rwid=(select max(rwid) as rwid from imd_cart_order where invoice_date='"+sdt+"')";
//        System.out.println("Query: "+qr);
        pstmt=conn.prepareStatement(qr);
        rs=pstmt.executeQuery();
        if(rs.next())
        {
            if(rs.getString("invoice_no")!=null&&!rs.getString("invoice_no").equals(""))
            {
           preOrderId=rs.getString("invoice_no");
           preOrderId=preOrderId.substring(dateFun.length(), preOrderId.length());
//           System.out.println("preOrderIdSub: "+preOrderId);
           orderId=dateFun+(Integer.parseInt(preOrderId)+1);
//           System.out.println("Kapil: "+orderId);
            }
            else{
                orderId=dateFun+"100001";
            }
        }
        else{
            orderId=dateFun+"100001";
//            System.out.println("Saini: "+orderId);
        }
        
    }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return orderId;
}
public String genOdrerId()throws Exception
{
    String preOrderId="";
    String orderId="";
    String dateFun="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    dateFun=this.genDate();
    java.util.Date dt=new java.util.Date();
    java.sql.Date sdt=new java.sql.Date(dt.getTime());
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    
    try{
        String qr="select order_id from imd_cart_order where order_date='"+sdt+"' and rwid=(select max(rwid) as rwid from imd_cart_order where order_date='"+sdt+"')";
        pstmt=conn.prepareStatement(qr);
        rs=pstmt.executeQuery();
        if(rs.next())
        {
           preOrderId=rs.getString("order_id");
           preOrderId=preOrderId.substring(dateFun.length(), preOrderId.length());
//           System.out.println("preOrderIdSub: "+preOrderId);
           orderId=dateFun+(Integer.parseInt(preOrderId)+1);
//           System.out.println("Kapil: "+orderId);
        }
        else{
            orderId=dateFun+"100001";
//            System.out.println("Saini: "+orderId);
        }
        
    }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return orderId;
}

public String genDate()
{
    java.util.Date dt=new java.util.Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    String df=sdf.format(dt);
//    System.out.println(df);
    return df;
}

public ArrayList retCountryStates()throws Exception
{
    ArrayList al=new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    CountryBean cb=null;
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    try{
        String qr="select * from statesofcountry";
        pstmt=conn.prepareStatement(qr);
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            cb=new CountryBean();
            cb.setState(rs.getString("states"));
            cb.setCode(rs.getInt("st_code"));
            al.add(cb);
        }
        
        }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return al;
}

public ArrayList retCountryShpCharge()throws Exception
{
    ArrayList al=new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    CountryBean cb=null;
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    try{
        String qr="select * from shpcharge_forcountry";
        pstmt=conn.prepareStatement(qr);
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            cb=new CountryBean();
            cb.setCountry(rs.getString("country"));
            cb.setCountryCode(rs.getString("country_code"));
            cb.setCode(rs.getInt("code"));
            cb.setShippingCharge(rs.getDouble("shp_charge"));
            al.add(cb);
        }
        
        }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return al;
}

public CountryBean getShpChargeOfCountry(int code)throws Exception
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    CountryBean cb=new CountryBean();
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    try{
        String qr="select * from shpcharge_forcountry where code=?";
        pstmt=conn.prepareStatement(qr);
        pstmt.setInt(1, code);
        rs=pstmt.executeQuery();
        if(rs.next())
        {
            cb.setCountry(rs.getString("country"));
            cb.setCountryCode(rs.getString("country_code"));
            cb.setCode(rs.getInt("code"));
            cb.setShippingCharge(rs.getDouble("shp_charge"));
        }
        
        }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return cb;
}

public String retCatShipChargeStatus(ArrayList cart_list){
    String shpStatus="";
    item_bean be;
//    System.out.println("cart_list.size(): "+cart_list.size());
//    Integer[] c_ids=new Integer[cart_list.size()];
    for(int j=0;j<cart_list.size();j++){
               be=(item_bean)cart_list.get(j);
//               c_ids[j]=be.getCat_id();
               try{
                    shpStatus=this.chkCatForShippingCharge(be.getCat_id(),"c_id");
               }catch(Exception e){}
               if(shpStatus.equals("yes"))
                        break;
            }
//    Set<Integer> set = new HashSet<Integer>(Arrays.asList(c_ids));
//            for (Integer temp : set){
//        	String chk=fd.chkCatForShippingCharge(temp,"c_id");
//                if(chk.equals("yes")){
//                    shipping_charge=5.00;
//                    break;
//                }
//            }
    return shpStatus;
}
public String chkCatForShippingCharge(int id,String field)throws Exception{
    String chk="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    try{
        String qr="select shp_charge_status from sub_cat where "+field+"="+id;
        System.out.println("query: "+qr);
        pstmt=conn.prepareStatement(qr);
//        pstmt.setInt(1, id);
        rs=pstmt.executeQuery();
        if(rs.next())
        {
            chk=rs.getString("shp_charge_status");
        }
        
        }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return chk;
}
public String getStates(int st_caode)throws Exception{
    String state="";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
        Dataconnectivity dcn=new Dataconnectivity();
        conn=(Connection)dcn.Dataconnect();
    }catch(Exception e){}
    try{
        String qr="select * from statesofcountry where st_code=?";
        pstmt=conn.prepareStatement(qr);
        pstmt.setInt(1, st_caode);
        rs=pstmt.executeQuery();
        if(rs.next())
        {
            state=rs.getString("states");
        }
        
        }catch(Exception e){ System.out.println("Ex: "+e.getMessage());}
    finally{
        if ( rs != null ) {rs.close();}
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();} 
    }
    return state;
}
public int getNoOfRecords() {
        return noOfRecords;
    }

public static void splitString(String s){
    String st[]=s.split(",");
    System.out.println(st[0]);
}

public static void main(String ar[])
{
    try{
    //genOdrerId();
        splitString("kapil,saini");
    }catch(Exception e){}
}
  
}  