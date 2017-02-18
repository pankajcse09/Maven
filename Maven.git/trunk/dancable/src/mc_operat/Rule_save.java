

package mc_operat;

import com.myapp.struts.Dataconnectivity;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import mc_bean.User_role;
import mc_bean.item_list;
import mc_bean.mc_prop;

public class Rule_save
{

    public Rule_save()
    {
    }

    
    public boolean del_role(String userid)
    {
  
   
        try {
            
           
             
                  String sql="delete from  user_role where userid='"+userid+"'";
            pstmt=con.prepareStatement(sql);
          pstmt.executeUpdate();
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
   return true;
    
    
    }   
     
    
    
    
    
    
     public void  update_role(int mcid,String cr,String rd,String de,String up,String user)
    {
    
        
    String sql="update user_role set mc_id=?,role_create=?,role_read=?,role_delete=?,role_update=? where userid='"+user+"'";
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,mcid);
            pstmt.setString(2,cr);
            pstmt.setString(3,rd);
            pstmt.setString(4,de);
            pstmt.setString(5,up);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
    public ArrayList select_rolea_id(String userid)
    {
        String sql = "select mc_id,main_category from cms_main where mc_id not in (select ur.mc_id from cms_main cm join user_role ur on cm.mc_id=ur.mc_id where userid='"+userid+"')";
               
 ArrayList role_list = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
           User_role role= new User_role();
              
           
            role.setMc(rs.getString("main_category"));
           role.setMc_id(rs.getInt("mc_id"));
            
               
                
              role_list.add(role);
            }
System.out.println(role_list);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return role_list;
    }
    
    public ArrayList select_user_id()
    {
        String sql = "select distinct userid from user_role";
 ArrayList user_list = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
           User_role role= new User_role();
              
            role.setUserid(rs.getString("userid"));
            
            
               
                
              user_list.add(role);
            }
System.out.println(user_list);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return user_list;
    }
    
    
    
     public ArrayList select_role_id(String userid)
    {
        String sql = "select main_category,ur.mc_id,role_create,role_read,role_delete,role_update,role_id from cms_main cm join user_role ur on cm.mc_id=ur.mc_id where userid='"+userid+"' order by main_category";
 ArrayList role_list = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
           User_role role= new User_role();
              
            role.setRo_create(rs.getString("role_create"));
            role.setRo_read(rs.getString("role_read"));
            role.setRo_del(rs.getString("role_delete"));
            role.setRo_edit(rs.getString("role_update"));
            
            role.setMc(rs.getString("main_category"));
            role.setRoleid(rs.getInt("role_id"));
            role.setMc_id(rs.getInt("mc_id"));
            
               
                
              role_list.add(role);
            }
System.out.println(role_list);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return role_list;
    }
    
    
    
    
    
    
    
    
    
    
     public void insert_role(int rid,String cr,String rd,String up,String de,String user)throws Exception
    {
        String sql = "insert into user_role(mc_id,role_create,role_read,role_update,role_delete,userid)values(?,?,?,?,?,?)";
        try
        {
            pstmt = con.prepareStatement(sql);
           
            pstmt.setInt(1,rid);
            pstmt.setString(2,cr);
             pstmt.setString(3,rd);
               pstmt.setString(4,up);
                 pstmt.setString(5,de);
              pstmt.setString(6,user);
             
            pstmt.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    //delete rule
    
    public void  del_rule(String rulename)
    {
  
   
        try {
            
           
             
                  String sql="delete from  cms_rule where cms_rule='"+rulename+"'";
            pstmt=con.prepareStatement(sql);
          pstmt.executeUpdate();
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
   
    
    
    }   
     public boolean chkid(int chkid)
    {
        boolean a = false;
        String sql = "select create_id from rulesave where create_id='"+chkid+"'";
        ArrayList rule_name = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
        
       if(rs.next()==true)
       {
        a=true;
       
       
       }else{
           a=false;
       }
        
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            
            
        }
    
       return a;
    }
    
     public ArrayList select_create_id(String rule)
    {
        String sql = "select rule,create_id from rule_desc where rule='"+rule+"'";
        ArrayList rule_name = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
                item_list litem = new item_list();
                litem.setRule(rs.getString("rule"));
                litem.setCreate_id(rs.getInt("create_id"));
                
                rule_name.add(litem);
            }

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rule_name;
    }
    
    
     public ArrayList select_rulename()
    {
        String sql = "select rule,create_id from rule_desc";
        ArrayList rule_name = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
                item_list litem = new item_list();
                litem.setRule(rs.getString("rule"));
                litem.setCreate_id(rs.getInt("create_id"));
                
                rule_name.add(litem);
            }

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rule_name;
    }
    
    //view rule name specific
     
     
     
      public ArrayList view_rulename(String rulename)
    {
        String sql = "select cms_main.main_category,cms_cat.cms_cat,sub_cat.sub_cat,item.brand,item.size,rulesave.cond,rulesave.cond_a" +
                " from item,cms_main,cms_cat,rulesave,sub_cat where rule='"+rulename+"' and rulesave.maincat_id=cms_main.mc_id and rulesave.cat_id=cms_cat.cms_cat_id " +
                "and rulesave.subcat_id=sub_cat.sub_cat_id and rulesave.item_id=item.item_id ";

           

        ArrayList rule_name = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
                mc_prop lirule = new mc_prop();
                lirule.setMc(rs.getString("main_category"));
                lirule.setCat(rs.getString("cms_cat"));
                lirule.setSub_cat(rs.getString("sub_cat"));
                lirule.setBrand(rs.getString("brand"));
                lirule.setSize(rs.getInt("size"));
                lirule.setCond(rs.getString("cond"));
                lirule.setCond1(rs.getString("cond_a"));
                
               
                
                rule_name.add(lirule);
                System.out.println(lirule);
            }

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rule_name;
    }
    
    
    //view rule name from desc
      
      
      public ArrayList view_rulename_desc(String rulename)
    {
        String sql = "select cms_main.main_category,cms_cat.cms_cat,sub_cat.sub_cat" +
                " from cms_main,cms_cat,rule_desc,sub_cat where rule='"+rulename+"' and rule_desc.maincat_id=cms_main.mc_id and rule_desc.cat_id=cms_cat.cms_cat_id " +
                "and rule_desc.subcat_id=sub_cat.sub_cat_id";

           

        ArrayList rule_name = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery(); 
       while(rs.next())
      
            {
            
                mc_prop lirule = new mc_prop();
                lirule.setMc(rs.getString("main_category"));
                lirule.setCat(rs.getString("cms_cat"));
                lirule.setSub_cat(rs.getString("sub_cat"));
                
                
               
                
                rule_name.add(lirule);
                System.out.println(lirule);
            }

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rule_name;
    }
    
    
    
    public void insert_item_save_rule(item_list it)
    {
        String sql = "insert into rulesave(rule,create_id,maincat_id,cat_id,subcat_id,item_id,brand,size,cond,cond_a)values(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, it.getRule());
            pstmt.setInt(2, it.getCreate_id());
            pstmt.setInt(3, it.getMaincat_id());
            pstmt.setInt(4, it.getCat_id());
            pstmt.setInt(5, it.getSubcat_id());
            pstmt.setInt(6, it.getItem_id());
            pstmt.setString(7, it.getBrand());
            pstmt.setInt(8, it.getSize());
             pstmt.setString(9, it.getCond());
              pstmt.setString(10, it.getCond1());
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public ArrayList item_save_rule(String subcat_id, String attr, String cond, String param, String attr_a, String cond_a, String param_a)
    {
        String sql = "select rule_desc.rule,rule_desc.maincat_id,rule_desc.cat_id,rule_desc.create_id,rule_desc.subcat_id,brand,size,item_id from item join rule_desc on rule_desc.subcat_id=item.sc_id where (rule_desc.subcat_id='" + subcat_id + "') and (" + attr + "" + cond + "'" + param + "' and " + attr_a + "" + cond_a + "'" + param_a + "')";
        ArrayList rule_list = new ArrayList();
        try
        {
            pstmt = con.prepareStatement(sql);
           rs = pstmt.executeQuery(); 
           while(rs.next())
          
            {
              
                item_list litem = new item_list();
                litem.setBrand(rs.getString("brand"));
                litem.setSize(rs.getInt("size"));
                litem.setItem_id(rs.getInt("item_id"));
                litem.setSubcat_id(rs.getInt("subcat_id"));
                litem.setCat_id(rs.getInt("cat_id"));
                litem.setMaincat_id(rs.getInt("maincat_id"));
                litem.setCreate_id(rs.getInt("create_id"));
                litem.setRule(rs.getString("rule"));
                litem.setCond(cond);
                litem.setCond1(cond_a);
                rule_list.add(litem);
                 System.out.println(rule_list);
            }

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rule_list;
    }

    public static void main(String arg[])
    {
        
      //  view_rulename ad = new view_rulename("hh");
        
     Rule_save ad = new Rule_save();
     ad.select_role_id("kanchan");
   //ad.item_save_rule("4", "brand", "=", "dell", "size", "=", "12");
     //ad.view_rulename("hh");
    }

    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    ArrayList arr;

    static 
    {
        Dataconnectivity dcc = new Dataconnectivity();
        con = dcc.Dataconnect();
    }
}