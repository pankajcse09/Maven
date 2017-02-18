/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Role;

import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kapil
 */
public class UserRoleDB {

Connection con=null;    
PreparedStatement ps=null;
PreparedStatement ps1=null;

ResultSet rs=null;
ResultSet rs1=null; 

public void save_Rules(List level,HashMap role) {
String s="";
try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
User_role_bean user_role=new User_role_bean();
try {
        String q="insert into user_roles(ur_level,ur_create,ur_view,ur_delete,ur_update) values(?,?,?,?,?)";
        ps=con.prepareStatement(q);
               for(int i=0;i<level.size();i++){ 
                    s=(String)level.get(i);      
                    user_role=(User_role_bean)role.get(s);
                    ps.setString(1, user_role.getUr_level()); 
                    ps.setString(2, user_role.getUr_create());
                    ps.setString(3, user_role.getUr_read());
                    ps.setString(4, user_role.getUr_delete());
                    ps.setString(5, user_role.getUr_update());
                    ps.addBatch();
               }
           ps.executeBatch();    
}catch(Exception e){}  
 finally{
    try{
        if(ps!=null){ps.close();}
        if(con!=null){con.close();}
    }catch(Exception ee){}
}                 
}

public int checkRoleTable(){
    int chk=0;
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    try {
            String q="select count(*) as cnt from user_roles";
            ps=con.prepareStatement(q);
            rs=ps.executeQuery();
            if(rs.next()){
             chk=rs.getInt("cnt");   
            }
}catch(Exception e){}  
 finally{
    try{
        if(ps!=null){ps.close();}
        if(con!=null){con.close();}
    }catch(Exception ee){}
}
    return chk;
}

public List getRole() {
List rolelist=new ArrayList();
User_role_bean ur;
try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
try {
    String q="select * from user_roles";
    ps=con.prepareStatement(q);
    rs=ps.executeQuery();
    while(rs.next()){
        ur=new User_role_bean();
        ur.setUr_level(rs.getString("ur_level"));
        ur.setUr_create(rs.getString("ur_create"));
        ur.setUr_read(rs.getString("ur_view"));
        ur.setUr_delete(rs.getString("ur_delete"));
        ur.setUr_update(rs.getString("ur_update"));
        ur.setId(rs.getInt("id"));
        rolelist.add(ur);
    }
} catch (Exception e) {}
finally{
    try{
        if(rs!=null){rs.close();}
        if(ps!=null){ps.close();}
        if(con!=null){con.close();}
    }catch(Exception ee){}
}
return rolelist;

}  

public void update_Role_Save(List level,HashMap role) {
String s="";
try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
try {
    User_role_bean user_role;
     String q="update user_roles set ur_create=?,ur_view=?,ur_delete=?,ur_update=? where id=?";
               ps=con.prepareStatement(q);
               for(int i=0;i<level.size();i++){ 
                    s=(String)level.get(i);      
                    user_role=(User_role_bean)role.get(s);
                    ps.setString(1, user_role.getUr_create());
                    ps.setString(2, user_role.getUr_read());
                    ps.setString(3, user_role.getUr_delete());
                    ps.setString(4, user_role.getUr_update());
                    ps.setInt(5, Integer.parseInt(s));
                    ps.addBatch();
               }
           ps.executeBatch(); 
} catch (Exception e) {}
finally{
    try{
        if(rs!=null){rs.close();}
        if(ps!=null){ps.close();}
        if(con!=null){con.close();}
    }catch(Exception ee){}
}
}  

public User_role_bean selUserRoleAuth(String role) {
User_role_bean ur=new User_role_bean();
try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
try {
    String q="select * from user_roles where ur_level=?";
    ps=con.prepareStatement(q);
    ps.setString(1, role);
    rs=ps.executeQuery();
    if(rs.next()){
        ur.setUr_create(rs.getString("ur_create"));
        ur.setUr_read(rs.getString("ur_view"));
        ur.setUr_delete(rs.getString("ur_delete"));
        ur.setUr_update(rs.getString("ur_update"));
     }
} catch (Exception e) {}
finally{
    try{
        if(rs!=null){rs.close();}
        if(ps!=null){ps.close();}
        if(con!=null){con.close();}
    }catch(Exception ee){}
}
return ur;
}  

}