


package Delete_content;
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
public class Delete_Function{
    
    /** Creates a new instance of prop_operate */
    public Delete_Function() {
    }
    

    
    
public boolean del_content(int id) throws SQLException
 {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
    boolean tr=false;
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  prop_cr where prop_id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
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
    return tr;
    
    }
    
    
     public boolean del_Read_More(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
    boolean tr=false;
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  proj_detail where proj_id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
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
    return tr;
    
    }
    
public boolean del_moreImg(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
    boolean tr=false;
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from  itemimage where id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
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
    return tr;
    
    }
        
 
public boolean del_moreSample(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
    boolean tr=false;
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from moreaudio_samples where id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
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
    return tr;
    
    }
      
public boolean del_EvdAudio(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
    boolean tr=false;
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from everyday_stream where rwid="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
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
    return tr;
    
    }
         
public boolean del_File(long id,String tablename) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList itemlist=new ArrayList();
    boolean tr=false;
        try {
            
          
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    
             
                  String sql="delete from "+tablename+" where rwid="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
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
    return tr;
    
    }
    
public boolean del_ContentFile(int id) throws SQLException
    {
   Connection conn = null;
    PreparedStatement pstmt = null;
    
    boolean tr=false;
        try {
            
Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
    String sql="update item set cover_content='' where item_id="+id;
            pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
            tr=true;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    finally {
        if ( pstmt != null ) {pstmt.close();}
        if ( conn != null ) {conn.close();}
 }
    return tr;
    
    }
    
     
}
