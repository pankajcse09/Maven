/*
 * rule_funct.java
 *
 * Created on August 28, 2008, 4:01 AM
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
import mc_bean.rule_prop;

/**
 *
 * @author arjun
 */
public class rule_funct {
    
    /** Creates a new instance of rule_funct */
    public rule_funct() {
    }
    
    static Connection con = null;
  
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    ArrayList arr;
   
   
    
    static
    {
        Dataconnectivity dcc = new Dataconnectivity();
        con = (Connection)dcc.Dataconnect();
    }
    
    
     public void  insert_rule(rule_prop prop)
    {
    
    String sql="insert into cms_rule(cms_rule)values(?)";
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,prop.getRule().trim());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
     
     //
//     for(int li=0;li<itemid.size();li++)
//            {
//              String id=(String)itemid.get(li);
//                  String sql="delete from  item where item_id='"+id+"'";
//            pstmt=con.prepareStatement(sql);
//          pstmt.executeUpdate();
     
     public void  insert_rule_desc(int mcat,int cat,String rule_name,ArrayList subcatid)
    {
    
    
        try {
            for(int li=0;li<subcatid.size();li++)
             
            { 
                String sql="insert into rule_desc(maincat_id,cat_id,rule,subcat_id)values(?,?,?,?)";
                 pstmt=con.prepareStatement(sql);
                pstmt.setInt(1,mcat);
                pstmt.setInt(2,cat);
                 pstmt.setString(3,rule_name);
               pstmt.setInt(4,Integer.parseInt(subcatid.get(li).toString()));
                
            
          pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
     
      public ArrayList sel_rule()
    {
    
    String sql="select cms_rule from cms_rule";
    ArrayList listrule=new ArrayList();
        try {
            
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            rule_prop rp=new rule_prop();
           rp.setRule(rs.getString("cms_rule"));
           
         listrule.add(rp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return listrule;
    
    
    }
      
      public ArrayList sel_rule_def(String rulename)
    {
    
    String sql="select cms_rule from cms_rule where cms_rule='"+rulename+"'";
    ArrayList listrule=new ArrayList();
        try {
            
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            rule_prop rp=new rule_prop();
           rp.setRule(rs.getString("cms_rule"));
           
         listrule.add(rp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return listrule;
    
    
    }
      
     
     // sel_rule_subcat
      public ArrayList sel_rule_subcat(String rulname)
    {
    
    String sql="select sub_cat,sub_cat_id from sub_cat sc join rule_desc rd on sc.sub_cat_id=rd.subcat_id where rd.rule='"+rulname+"'";


    ArrayList lrs=new ArrayList();
        try {
            
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            
            rule_prop rp=new rule_prop();
           rp.setSubcat(rs.getString("sub_cat"));
           rp.setSuc_cat_id(rs.getInt("sub_cat_id"));
         lrs.add(rp);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    return lrs;
    
    
    }
     
     
}
