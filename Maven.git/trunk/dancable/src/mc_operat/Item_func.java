/*
 * Item_func.java
 *
 * Created on August 25, 2008, 4:04 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mc_operat;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import com.myapp.struts.Dataconnectivity;
import mc_bean.mc_prop;
import mc_bean.item_list;
/**
 *
 * @author arjun
 */
public class Item_func {
    
  static Connection con = null;
  
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    ArrayList arr;
   
   
    
    static
    {
        Dataconnectivity dcc = new Dataconnectivity();
        con = (Connection)dcc.Dataconnect();
    }
    
    public void  item_value(int itemid,String value,String col_type)
    {
    
        
    String sql="update item set "+col_type+"=? where item_id='"+itemid+"'";
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,value.trim());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
    
    
    //  insert list_value
    
    public void  list_value(int listid,String value,String col_type)
    {
    String types="";
        
        String col= "select "+col_type+" from item_list";
        try {
            pstmt =con.prepareStatement(col);
            rs=pstmt.executeQuery();
            ResultSetMetaData md=rs.getMetaData();
            int nocol=md.getColumnCount();
         types=  md.getColumnTypeName(nocol);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    String sql="update item_list set "+col_type+"=? where list_id='"+listid+"'";
    
    
    
    
        try {
            pstmt=con.prepareStatement(sql);
            
            
            if(types.equalsIgnoreCase("varchar"))
            {
            pstmt.setString(1,value.trim());
            }
             if(types.equalsIgnoreCase("integer"))
            {
            pstmt.setInt(1,Integer.parseInt(value.trim()));
            }
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
    
    
    public void  itemupdate_value(int itemid,String value,String col_type)
    {
    String types="";
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        String col= "select "+col_type+" from item";
        try {
            pstmt =con.prepareStatement(col);
            rs=pstmt.executeQuery();
            ResultSetMetaData md=rs.getMetaData();
            int nocol=md.getColumnCount();
         types=  md.getColumnTypeName(nocol);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    String sql="update item set "+col_type+"=?,modified_time=? where item_id='"+itemid+"'";
    
    
    
    
        try {
            pstmt=con.prepareStatement(sql);
            
            
            if(types.equalsIgnoreCase("varchar"))
            {
            pstmt.setString(1,value.trim());
              pstmt.setTimestamp(2,timestamp);
            }
             if(types.equalsIgnoreCase("integer"))
            {
            pstmt.setInt(1,Integer.parseInt(value.trim()));
             pstmt.setTimestamp(2,timestamp);
            }
           
              if(types.equalsIgnoreCase("double"))
            {
            pstmt.setDouble(1,Double.parseDouble(value.trim()));
             pstmt.setTimestamp(2,timestamp);
            }
              
              
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
    
    // insert itemlist
    
    
    public void add_listitem(int unit,String color,int item_id)
 {
  Timestamp timestamp=new Timestamp(System.currentTimeMillis());
String sql="insert into item_list(unit,color,create_time,item_id)values(?,?,?,?)";
        try {
            pstmt=con.prepareStatement(sql);
          
           pstmt.setInt(1,unit);
            pstmt.setString(2,color);
           pstmt.setTimestamp(3,timestamp);
           pstmt.setInt(4,item_id);
           
            pstmt.executeUpdate();
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    
 
 }
    
    // item _list _view _desc
    
     public ArrayList itemlist_desc(int itl_id)
    {
    String sql="select unit,color,list_id from item_list where item_id='"+itl_id+"'";
    ArrayList itemlist=new ArrayList();
        try {
            
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
        item_list il=new item_list();
        il.setUnit(rs.getInt("unit"));
            il.setColor(rs.getString("color"));
             il.setList_id(rs.getInt("list_id"));
            itemlist.add(il);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return itemlist;
    
    
    }
     
     public void  del_itemlist(ArrayList itemlistid)
    {
  
    ArrayList itemlist=new ArrayList();
        try {
            
            for(int li=0;li<itemlistid.size();li++)
            {
              String id=(String)itemlistid.get(li);
                  String sql="delete from  item_list where list_id='"+id+"'";
            pstmt=con.prepareStatement(sql);
          pstmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
   
    
    
    }
     
     
     
     
     
     // select item value
     public String sel_listValue(String coltype,int listid)
    {
 String value=null;
String sql="select "+coltype+" from item_list where list_id='"+listid+"'";
   
        try {
            
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
       item_list vmc=new item_list();
        if(coltype.equalsIgnoreCase("unit"))
        {
       vmc.setUnit(rs.getInt(coltype));
      
      value= new Integer(vmc.getUnit()).toString();
        }
        
     if(coltype.equalsIgnoreCase("color"))
     {
        
        vmc.setColor(rs.getString(coltype));
        value=(String)vmc.getColor();
     }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return value;
    
    
    }
    // edit item list
     
     public ArrayList itemlist_desc_edit(int itemlist_id)
    {
    String sql="select color,unit,list_id from item_list where list_id='"+itemlist_id+"'";
    ArrayList itemedit_list=new ArrayList();
        try {
            
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
           item_list litem=new item_list();
           litem.setUnit(rs.getInt("unit"));
           litem.setColor(rs.getString("color"));
            litem.setList_id(rs.getInt("list_id"));
           itemedit_list.add(litem);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return itemedit_list;
    
    
    }
     
//save rule...
     
     
     
     
     //end save rule
     
    public static void main(String arg[])
{

Item_func ad = new Item_func();
//ad.list_value();

}
     
}
 





