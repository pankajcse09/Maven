/*
 * Mc_funct.java
 *
 * Created on August 8, 2008, 2:31 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mc_operat;
import Main_category.item_bean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import com.myapp.struts.Dataconnectivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mc_bean.mc_prop;
/**
 *
 * @author arjun
 */
public class Mc_funct {
   Connection con = null;
  
  PreparedStatement pstmt = null;
   PreparedStatement psmt2 = null;
 PreparedStatement psmt = null;
 
  ResultSet rs = null;
   ResultSet rs2 = null;
    ArrayList arr;
   
   
public HashMap get_Item_PageWise(String p,int sc_id){   
   
         int ins=12;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item where sc_id="+sc_id;
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select item_id,brand,price,down_price,marketprice,filename,prod_id from item where sc_id="+sc_id;
             psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             rs=psmt.executeQuery();
             rs.absolute(startIndex);
             for(count = startIndex; count < increment; count++){ 
              mc_prop item=new mc_prop();
              item.setItem_id(rs.getInt("item_id"));
              item.setBrand(rs.getString("brand"));
              item.setPrice(rs.getDouble("price"));
              item.setMarketprice(rs.getDouble("marketprice"));
              item.setFilename(rs.getString("filename"));
              item.setProd_id(rs.getString("prod_id"));
              item.setDown_price(rs.getDouble("down_price"));
              ar.add(item);  
          // hs.add(rs.getString("comp_name"));
           rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 

    
public HashMap get_Item_Page_Wise(String p,int sc_id){   
   
         int ins=8;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item where sc_id="+sc_id;
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select item_id,brand,price,marketprice,filename,prod_id from item where sc_id="+sc_id;
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
}    

public HashMap get_newRelItem(String p){   
   
         int ins=2;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item where type='new'";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select item_id,brand,price,marketprice,filename,prod_id from item where type='new'";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 

    
public HashMap get_Item_RetailStore(String p){   
   
         int ins=15;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select item_id,brand,price,marketprice,filename,prod_id from item";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 
   
       public HashMap get_Item_Boy_PageWise(String p){   
   
         int ins=16;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select * from item where sc_id IN ( select sub_cat_id FROM cms_cat JOIN sub_cat ON cms_cat.cms_cat_id=sub_cat.c_id WHERE cms_cat='men' and mc='fashion')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 
  
     
    public HashMap get_Accessories_Men_PageWise(String p){   
   
         int ins=16;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select * from item where sc_id IN ( select sub_cat_id FROM cms_cat JOIN sub_cat ON cms_cat.cms_cat_id=sub_cat.c_id WHERE cms_cat='men'and mc='accessories')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 
   
    public HashMap get_Accessories_Women_PageWise(String p){   
   
         int ins=16;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select * from item where sc_id IN ( select sub_cat_id FROM cms_cat JOIN sub_cat ON cms_cat.cms_cat_id=sub_cat.c_id WHERE cms_cat='women' and mc='accessories')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 
    
    
       public HashMap get_Item_Women_PageWise(String p){   
   
         int ins=16;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+ins+1;
         String ds="";
         String pre="";    
         String nxt=""; 
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from item";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}
else{
increment = startIndex + remain;
}
     String qr1="select * from item where sc_id IN ( select sub_cat_id FROM cms_cat JOIN sub_cat ON cms_cat.cms_cat_id=sub_cat.c_id WHERE cms_cat='women' and mc='fashion')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    mc_prop item=new mc_prop();
    item.setItem_id(rs.getInt("item_id"));
    item.setBrand(rs.getString("brand"));
  item.setPrice(rs.getDouble("price"));
  item.setMarketprice(rs.getDouble("marketprice"));
  item.setFilename(rs.getString("filename"));
  item.setProd_id(rs.getString("prod_id"));
  ar.add(item);  
  // hs.add(rs.getString("comp_name"));
  rs.next();
 } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-ins).toString();
//}  
 } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(rs2!=null){rs2.close();}   
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   if(startIndex + ins <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-ins).toString();
}
increment +=ins; 
if(startIndex + ins <=in){    
nxt=new Integer(startIndex+ins).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;       
  } 
   
  
    
    
    
    
    
    
    public void  del_item(List itemid)throws Exception
    {
  
   
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            for(int li=0;li<itemid.size();li++)
            {
              String id=(String)itemid.get(li);
                  String sql="delete from  item where item_id="+Integer.parseInt(id);
                 
            pstmt=con.prepareStatement(sql);
          pstmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    }
    
    }  
    
    
    public ArrayList as_prodid(int prodid,int subcatid,java.util.Date fd,java.util.Date td)throws Exception
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//("dd-MM-yyyy");  

   System.out.println(fd);
        String sd="";
        try {
            sd = sdf.format(fd);
        } finally {
        }
    
   System.out.println(sd);
        java.util.Date dd = null;
        try {
            dd = sdf.parse(sd);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    
 
    java.sql.Date f= new java.sql.Date(dd.getTime());
     java.sql.Date t= new java.sql.Date(td.getTime());
    String sql="select brand,size,prod_id,create_time,item_id from item where prod_id="+prodid+" and sc_id="+subcatid+" and date(create_time) between '"+f+"' and '"+t+"'";
    
   
    ArrayList item_list=new ArrayList();
        try {
            
            Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    


            
       pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
           while(rs.next())
            {
            
            mc_prop item=new mc_prop();
            System.out.println(rs.getString("brand"));
             System.out.println(rs.getInt("size"));
             System.out.println(rs.getInt("prod_id"));
             System.out.println(rs.getTimestamp("create_time"));
             
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
            item.setT(rs.getTimestamp("create_time"));
              item.setItem_id(rs.getInt("item_id"));
           item_list.add(item);
            }
           
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    
}
    return item_list;
    
    
    }
     public ArrayList search_prodid(int prodid,int subcatid)throws Exception
    {
    String sql="select brand,size,prod_id,create_time,item_id from item where prod_id="+prodid+" and sc_id="+subcatid;
    ArrayList item_list=new ArrayList();
        try {
            Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

       pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
           while(rs.next())
            {
            
            mc_prop item=new mc_prop();
            System.out.println(rs.getString("brand"));
             System.out.println(rs.getInt("size"));
             System.out.println(rs.getInt("prod_id"));
             System.out.println(rs.getTimestamp("create_time"));
             
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
            item.setT(rs.getTimestamp("create_time"));
              item.setItem_id(rs.getInt("item_id"));
           item_list.add(item);
            }
           
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return item_list;
    
    
    }
     
     }
     public ArrayList as_item(String brand,int scid,java.util.Date fd,java.util.Date td,double price)throws Exception
    {
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//("dd-MM-yyyy");  

   System.out.println(fd);
        String sd="";
        try {
            sd = sdf.format(fd);
        } finally {
        }
    
   System.out.println(sd);
        java.util.Date dd = null;
        try {
            dd = sdf.parse(sd);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    
 
    java.sql.Date f= new java.sql.Date(dd.getTime());
     java.sql.Date t= new java.sql.Date(td.getTime());
    System.out.println("sqlDate"+f);
    String sql="select brand,size,price,prod_id,create_time,item_id from item where brand='"+brand+"' and sc_id="+scid+" and date(create_time) between '"+f+"' and '"+t+"' and price="+price;
   
    ArrayList item_list=new ArrayList();
        try {
            Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

       pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
           while(rs.next())
            {
            
            mc_prop item=new mc_prop();
            System.out.println(rs.getString("brand"));
             System.out.println(rs.getInt("size"));
             System.out.println(rs.getInt("prod_id"));
             System.out.println(rs.getTimestamp("create_time"));
             
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setPrice(rs.getDouble("price"));
             item.setProd_id(rs.getString("prod_id"));
            item.setT(rs.getTimestamp("create_time"));
            item.setItem_id(rs.getInt("item_id"));
           item_list.add(item);
            }
           
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return item_list;
    
    
    }
     
    
    
    
     public ArrayList search_item(String brand,int scid)throws Exception
    {
    String sql="select brand,size,prod_id,create_time,item_id from item where brand='"+brand+"' and sc_id="+scid;
    ArrayList item_list=new ArrayList();
        try {
            Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

       pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
           while(rs.next())
            {
            
            mc_prop item=new mc_prop();
            System.out.println(rs.getString("brand"));
             System.out.println(rs.getInt("size"));
             System.out.println(rs.getInt("prod_id"));
             System.out.println(rs.getTimestamp("create_time"));
             
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
            item.setT(rs.getTimestamp("create_time"));
            item.setItem_id(rs.getInt("item_id"));
           item_list.add(item);
            }
           
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return item_list;
    
    
    }
     
    
     public ArrayList search_item_brand()throws Exception
    {
    String sql="select brand,size,price,prod_id,create_time from item";
    ArrayList item_list=new ArrayList();
        try {
            Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

       pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
           
            ResultSetMetaData mt=rs.getMetaData();
            int nocol=mt.getColumnCount();
            for(int i=1;i<nocol+1;i++)
            {
            item_list.add(mt.getColumnName(i));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return item_list;
    
    
    }
     
    
    /** Creates a new instance of Mc_funct */
   
  
  public void  insert_Category(mc_prop prop)throws Exception
    {
    
    String sql="insert into cms_main(main_category)values(?)";
        try {
            Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,prop.getMc().trim());
            pstmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    
    
    }
  
  
   public void  insert_SubCat(mc_prop prop)throws Exception
    {
    
    String sql="insert into sub_cat(sub_cat,c_id)values(?,?)";
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,prop.getSub_cat().trim());
            pstmt.setInt(2,prop.getC_id());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    
    }
   }
   
    public ArrayList sel_mc()throws Exception
    {
    
    String sql="select main_category,mc_id from cms_main order by main_category";
    ArrayList mclist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop vmc=new mc_prop();
            vmc.setMc(rs.getString("main_category"));
            vmc.setMc_id(rs.getInt("mc_id"));
            mclist.add(vmc);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return mclist;
    
    
    }
    }
    // select value for update
    
     public String sel_Value(String coltype,int item_id)throws Exception
    {
    String value="";
String sql="select "+coltype+" from item where item_id='"+item_id+"'";
   
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop vmc=new mc_prop();
              vmc.setBrand(rs.getString(coltype).toString());
        value= vmc.getBrand();
           
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return value;
    
    
    }
    
    //
    
    public ArrayList sel_cat(int mc_id)throws Exception
    {
    String sql="select cms_cat,cms_cat_id from cms_cat where mc_id='"+mc_id+"'";
    ArrayList catlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop cat=new mc_prop();
          cat.setCat(rs.getString("cms_cat"));
         cat.setC_id(rs.getInt("cms_cat_id"));
            catlist.add(cat);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return catlist;
    
    
    }
    
    
    
    public mc_prop sel_cat_id(int id)throws Exception
    {
    String sql="select c_id from sub_cat where sub_cat_id='"+id+"'";
    ArrayList catlist=new ArrayList();
       mc_prop cat=new mc_prop();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
             con=(Connection)cour_con.Dataconnect();    
             System.out.println("connection: "+con);
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
             cat.setC_id(rs.getInt("c_id"));     
            }      
           } 
         catch (SQLException ex) {
            System.out.println("Ex Msg: "+ex.getMessage());
            ex.printStackTrace();
          }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return cat;
    
    
    }
    
     public mc_prop sel_catsubcat_nav(int cid,int scid)throws Exception
    {
    String sql="select sub_cat,cms_cat FROM sub_cat JOIN cms_cat ON c_id=cms_cat_id where c_id='"+cid+"' and sub_cat_id='"+scid+"'";
    ArrayList catlist=new ArrayList();
       mc_prop cat=new mc_prop();
       
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
         
       cat.setSub_cat(rs.getString("sub_cat"));
       cat.setCat(rs.getString("cms_cat"));
       
           
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return cat;
    
    
    }
    
     
      public mc_prop sel_cat_nav(int cid)throws Exception
    {
    String sql="select cms_cat FROM cms_cat  where cms_cat_id='"+cid+"'";
    ArrayList catlist=new ArrayList();
       mc_prop cat=new mc_prop();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
             con=(Connection)cour_con.Dataconnect();    
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
             cat.setCat(rs.getString("cms_cat"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return cat;
    
    
    }
    
     
    
     public ArrayList sel_ringcat_all()throws Exception
    {
    String sql="select cms_cat,cms_cat_id from cms_cat";
    ArrayList catlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop cat=new mc_prop();
          cat.setCat(rs.getString("cms_cat"));
         cat.setC_id(rs.getInt("cms_cat_id"));
            catlist.add(cat);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return catlist;
    
    
    }
    
    
    
    
    
    
     public ArrayList sel_cat_all()throws Exception
    {
    String sql="select main_category,mc_id from cms_main";
    ArrayList catlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop cat=new mc_prop();
          cat.setMc(rs.getString("main_category"));
         cat.setMc_id(rs.getInt("mc_id"));
            catlist.add(cat);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return catlist;
    
     }
    }
    
    
     public ArrayList item_desc_edit(int item_id)throws Exception
    {
    String sql="select status,brand,size,price,prod_id,item_id,create_time,filename from item where item_id='"+item_id+"'";
    ArrayList itemedit_list=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop item=new mc_prop();
          item.setStatus(rs.getString("status"));
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setPrice(rs.getDouble("price"));
             item.setProd_id(rs.getString("prod_id"));
             item.setItem_id(rs.getInt("item_id"));
             item.setT(rs.getTimestamp("create_time"));
             item.setFilename(rs.getString("filename"));           
             itemedit_list.add(item);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return itemedit_list;
    
    
    }
    
    
 public ArrayList item_desc(int sc_id)throws Exception
    {
    String sql="select * from item where sc_id='"+sc_id+"' and type='regular'";
    ArrayList itemlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop item=new mc_prop();
              item.setStatus(rs.getString("status"));
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
             item.setPrice(rs.getDouble("price"));
             item.setT(rs.getTimestamp("create_time"));
             item.setItem_id(rs.getInt("item_id"));
               item.setMt(rs.getTimestamp("modified_time"));
               item.setFilename(rs.getString("filename"));
               item.setMarketprice(rs.getDouble("marketprice"));
               item.setDiscount(rs.getDouble("discount"));
               item.setDiscountdetail(rs.getString("discountdetail"));
                item.setDetail(rs.getString("detail"));
                 item.setUnit(rs.getString("unit"));
               item.setSampleFileName(rs.getString("audio_sample"));
               item.setTitle(rs.getString("title"));
               item.setPromo(rs.getString("promo"));
                 item.setPromo_discount(rs.getDouble("promo_discount"));
                 item.setPromo_discountdetail(rs.getString("promo_discountdetail"));
                 item.setRelated_items(rs.getString("related_items"));
            itemlist.add(item);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return itemlist;
    
    
    }
 
 public ArrayList newRlitem_desc(int sc_id)throws Exception
    {
    String sql="select * from item where sc_id='"+sc_id+"' and type='new'";
    ArrayList itemlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop item=new mc_prop();
              item.setStatus(rs.getString("status"));
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
             item.setPrice(rs.getDouble("price"));
             item.setT(rs.getTimestamp("create_time"));
             item.setItem_id(rs.getInt("item_id"));
               item.setMt(rs.getTimestamp("modified_time"));
               item.setFilename(rs.getString("filename"));
               item.setSampleFileName(rs.getString("audio_sample"));
               item.setMarketprice(rs.getDouble("marketprice"));
               item.setDiscount(rs.getDouble("discount"));
               item.setDiscountdetail(rs.getString("discountdetail"));
                item.setDetail(rs.getString("detail"));
                 item.setUnit(rs.getString("unit"));
                 item.setTitle(rs.getString("title"));
               item.setRelated_items(rs.getString("related_items"));
               
            itemlist.add(item);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return itemlist;
    
    
    }
    
public ArrayList item_desc_All(int sc_id)throws Exception
    {
    String sql="select * from item where sc_id='"+sc_id+"'";
    ArrayList itemlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            mc_prop item=new mc_prop();
              item.setStatus(rs.getString("status"));
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
             item.setPrice(rs.getDouble("price"));
             item.setT(rs.getTimestamp("create_time"));
             item.setItem_id(rs.getInt("item_id"));
               item.setMt(rs.getTimestamp("modified_time"));
               item.setFilename(rs.getString("filename"));
               item.setMarketprice(rs.getDouble("marketprice"));
               item.setDiscount(rs.getDouble("discount"));
               item.setDiscountdetail(rs.getString("discountdetail"));
                item.setDetail(rs.getString("detail"));
                 item.setUnit(rs.getString("unit"));
               item.setSampleFileName(rs.getString("audio_sample"));
               item.setTitle(rs.getString("title"));
               item.setPromo(rs.getString("promo"));
                 item.setPromo_discount(rs.getDouble("promo_discount"));
                 item.setPromo_discountdetail(rs.getString("promo_discountdetail"));
                 item.setRelated_items(rs.getString("related_items"));
                 item.setCover_content(rs.getString("cover_content"));
            itemlist.add(item);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return itemlist;
    
    
    }
    
     
     
     
      public mc_prop item_detail(int itemid)throws Exception
    {
    String sql="select * from item where item_id="+itemid;
    ArrayList itemlist=new ArrayList();
       mc_prop item=new mc_prop();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
         
              item.setStatus(rs.getString("status"));
            item.setBrand(rs.getString("brand"));
             item.setSize(rs.getInt("size"));
             item.setProd_id(rs.getString("prod_id"));
             item.setPrice(rs.getDouble("price"));
             item.setT(rs.getTimestamp("create_time"));
             item.setItem_id(rs.getInt("item_id"));
               item.setMt(rs.getTimestamp("modified_time"));
               item.setFilename(rs.getString("filename"));
               item.setMarketprice(rs.getDouble("marketprice"));
               item.setDiscount(rs.getDouble("discount"));
               item.setDiscountdetail(rs.getString("discountdetail"));
                item.setDetail(rs.getString("detail"));
                 item.setUnit(rs.getString("unit"));
                 item.setItem_id(rs.getInt("item_id"));
               item.setRelated_items(rs.getString("related_items"));
           
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return item;
    
    
    }
    
     
     
   
    
    
    
    
    
    public ArrayList sel_sub_cat(int c_id)throws Exception
    {
    String sql="select sub_cat,sub_cat_id from sub_cat where c_id="+c_id;
    ArrayList sub_catlist=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {            
            mc_prop cat=new mc_prop();
          cat.setSub_cat(rs.getString("sub_cat"));
           cat.setSubcat_id(rs.getInt("sub_cat_id"));
            sub_catlist.add(cat);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return sub_catlist;
    
    
    }
// return_item_list_column
    
    
    
     public ArrayList sel_item_col()throws Exception
    {
    String sql="select unit,color from item_list";
    ArrayList item_list_col=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

           rs=pstmt.executeQuery(sql);
            ResultSetMetaData mt=rs.getMetaData();
            int nocol=mt.getColumnCount();
            for(int i=1;i<nocol+1;i++)
            {
            item_list_col.add(mt.getColumnName(i));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return item_list_col;
    
    
    }
    
    
    
    
    
    
    // end here
    
    
public ArrayList sel_col()throws Exception
    {
    String sql="select status,brand,size,price,prod_id,create_time,modified_time from item";
    ArrayList col_list=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
            ResultSetMetaData mt=rs.getMetaData();
            int nocol=mt.getColumnCount();
            for(int i=1;i<nocol+1;i++)
            {
            col_list.add(mt.getColumnName(i));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
    return col_list;
    
    
    }
    
    // select item_col_rule
     
     
      public ArrayList sel_col_rule()throws Exception
    {
    String sql="select brand,size from item";
    ArrayList col_list=new ArrayList();
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

           rs=pstmt.executeQuery(sql);
            ResultSetMetaData mt=rs.getMetaData();
            int nocol=mt.getColumnCount();
            for(int i=1;i<nocol+1;i++)
            {
            col_list.add(mt.getColumnName(i));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return col_list;
     }
    
    }
     
     
    
     
     
   //insert Attribute
     
public void add_attrib(item_bean be)throws Exception
 {
  Timestamp timestamp=new Timestamp(System.currentTimeMillis());
   Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

String sql="insert into item(brand,prod_id,size,create_time,sc_id,price,status,filename,marketprice,discount,discountdetail,detail,unit,audio_sample,"
        + "title,type,related_items,cover_content)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,be.getBrand());
           pstmt.setString(2,be.getProd_id());
            pstmt.setString(3,be.getSize());
           pstmt.setTimestamp(4,timestamp);
           pstmt.setInt(5,be.getSubcat_id());
           pstmt.setDouble(6,be.getPrice());
             pstmt.setString(7,be.getStatus());
            pstmt.setString(8,be.getFilename());
            pstmt.setDouble(9,be.getMarketprice());
            pstmt.setDouble(10,be.getDiscount());
            pstmt.setString(11,be.getDiscountdetail());
            pstmt.setString(12,be.getDetail());          
            pstmt.setString(13,be.getUnit());
            pstmt.setString(14,be.getSampleFileName());
            pstmt.setString(15,be.getSampleTitle());
            pstmt.setString(16,be.getType());
            pstmt.setString(17, be.getRelated_items());
            pstmt.setString(18, "");
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
  finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
  }
 }
     //end_Attribute

   //insert NewRelease
     
public void add_newRelease(item_bean be)throws Exception
 {
  Timestamp timestamp=new Timestamp(System.currentTimeMillis());
   Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

String sql="insert into new_release(brand,prod_id,size,create_time,sc_id,price,status,filename,marketprice,discount,discountdetail,detail,unit,audio_sample)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,be.getBrand());
           pstmt.setString(2,be.getProd_id());
            pstmt.setString(3,be.getSize());
           pstmt.setTimestamp(4,timestamp);
           pstmt.setInt(5,be.getSubcat_id());
           pstmt.setDouble(6,be.getPrice());
             pstmt.setString(7,be.getStatus());
            pstmt.setString(8,be.getFilename());
            pstmt.setDouble(9,be.getMarketprice());
            pstmt.setDouble(10,be.getDiscount());
            pstmt.setString(11,be.getDiscountdetail());
            pstmt.setString(12,be.getDetail());          
            pstmt.setString(13,be.getUnit());
            pstmt.setString(14,be.getSampleFileName());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
  finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
  }
 }
     //end_NewRelease
  
 public void Insert_Category(mc_prop cat_data)throws Exception
 {
 
String sql="insert into cms_cat(cms_cat,mc,mc_id)values(?,?,?)";
        try { Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,cat_data.getCat().trim());
            pstmt.setString(2,cat_data.getMc());
            pstmt.setInt(3,cat_data.getMc_id());
           
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
  finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
 }
 }
 

public ArrayList sel_main_cat()throws Exception
    {
    String sql="select * from cms_main";
    ArrayList mclist=new ArrayList();
    mc_prop mcp=null;
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    
            pstmt=con.prepareStatement(sql);
           rs=pstmt.executeQuery();
           
            while(rs.next())
            {
            mcp=new mc_prop();
            mcp.setMc(rs.getString("main_category"));
            mcp.setMc_id(rs.getInt("mc_id"));
            
            mclist.add(mcp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return mclist;
     }
    
    }
      
public ArrayList sel_cat(String mc)throws Exception
    {
    String sql="select * from cms_cat where mc=?";
    ArrayList mclist=new ArrayList();
    mc_prop mcp=null;
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, mc);
           rs=pstmt.executeQuery();
           
            while(rs.next())
            {
            mcp=new mc_prop();
            mcp.setCat(rs.getString("cms_cat"));
            mcp.setC_id(rs.getInt("cms_cat_id"));
            mcp.setMc(rs.getString("mc"));
            mcp.setMc_id(rs.getInt("mc_id"));
            
            mclist.add(mcp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return mclist;
     }
    
    }

// New By Kapil

public void upadatePromoOfItem(mc_prop mc)throws Exception
{
    String sql="update item set promo=?,promo_discount=?,promo_discountdetail=? where item_id=?";
    try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    

            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, mc.getPromo());
            pstmt.setDouble(2, mc.getPromo_discount());
            pstmt.setString(3, mc.getPromo_discountdetail());
            pstmt.setInt(4, mc.getItem_id());
            pstmt.executeUpdate();
    }catch(Exception e){}
    finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }

}
public ArrayList sel_catByType(String mc)throws Exception
    {
    String sql="select * from cms_cat where mc=? and type='Book Music'";
    ArrayList mclist=new ArrayList();
    mc_prop mcp=null;
        try {
             Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();    
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, mc);
           rs=pstmt.executeQuery();
           
            while(rs.next())
            {
            mcp=new mc_prop();
            mcp.setCat(rs.getString("cms_cat"));
            mcp.setC_id(rs.getInt("cms_cat_id"));
            mcp.setMc(rs.getString("mc"));
            mcp.setMc_id(rs.getInt("mc_id"));
            
            mclist.add(mcp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
    
    return mclist;
     }
    
    }


  public static void main(String arg[])
  {
  Mc_funct mc=new  Mc_funct() ;
  ArrayList aa=new ArrayList();
   java.util.Date g=new java.util.Date("2008/08/27");
  java.util.Date h=new java.util.Date("2008/08/27");
        
        try {
            aa = (ArrayList) mc.as_item("hp", 3, g, h, 33);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 System.out.println(aa);
  
  
  }
  }
    
    

