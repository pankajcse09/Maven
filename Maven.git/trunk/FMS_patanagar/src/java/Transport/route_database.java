/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

/**
 *
 * @author kapil
 */
import java.sql.*;
import Beans.*;
import com.myapp.struts.Dataconnectivity;
import java.util.*;

public class route_database {
    
    public ArrayList add_temp_route(Rt_bean rtb)
    {
        ArrayList al=new ArrayList();
        Rt_bean rtb1=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=dc.Dataconnect();
        }catch(Exception e){System.out.println(e);}
        
        try{
            String str="insert into route_temp(route,place,fare)values(?,?,?)";
            pstm=conn.prepareStatement(str);
            pstm.setString(1,rtb.getRoute());
            pstm.setString(2, rtb.getPlace());
            pstm.setDouble(3,rtb.getFare());
            
            pstm.executeUpdate();
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            }catch(Exception e){}
        }
        
        try{
            String sqr="select * from route_temp";
            pstm=conn.prepareStatement(sqr);
            rs=pstm.executeQuery();
            while(rs.next())
            {
               rtb1=new Rt_bean();
               rtb1.setRoute(rs.getString("route"));
               rtb1.setPlace(rs.getString("place"));
               rtb1.setFare(rs.getDouble("fare"));
               
               al.add(rtb1);
            }
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
    public ArrayList get_temp_route()
    {
        ArrayList al=new ArrayList();
        Rt_bean rtb1=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=dc.Dataconnect();
        }catch(Exception e){System.out.println(e);}
        
        try{
            String sqr="select * from route_temp";
            pstm=conn.prepareStatement(sqr);
            rs=pstm.executeQuery();
            while(rs.next())
            {
               rtb1=new Rt_bean();
               rtb1.setRoute(rs.getString("route"));
               rtb1.setPlace(rs.getString("place"));
               rtb1.setFare(rs.getDouble("fare"));
               
               al.add(rtb1);
            }
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
    public ArrayList add_into_route()
    {
        ArrayList al=new ArrayList();
        Rt_bean rtb1=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=dc.Dataconnect();
        }catch(Exception e){System.out.println(e);}
        
        try{
            String str="insert into route (route,place,fare) select route,place,fare from route_temp";
            pstm=conn.prepareStatement(str);
            
            pstm.executeUpdate();
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            
            }catch(Exception e){}
        }
        
        try{
         String del="delete from route_temp";
              pstm=conn.prepareStatement(del);
              pstm.executeUpdate();
            }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
    public ArrayList get_from_route()
    {
        ArrayList al=new ArrayList();
        Rt_bean rtb1=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=dc.Dataconnect();
        }catch(Exception e){System.out.println(e);}
        
        try{
            String str="select * from route";
            pstm=conn.prepareStatement(str);
            rs=pstm.executeQuery();
            while(rs.next())
            {
                rtb1=new Rt_bean();
                rtb1.setRoute(rs.getString("route"));
                rtb1.setPlace(rs.getString("place"));
                rtb1.setFare(rs.getDouble("fare"));
                rtb1.setId(rs.getInt("rwid"));
                
                al.add(rtb1);
            }
            
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
    public ArrayList del_route_byId(int id)
    {
        ArrayList al=new ArrayList();
        Rt_bean rtb1=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=dc.Dataconnect();
        }catch(Exception e){System.out.println(e);}
        
        try{
            String sqr="delete from route where rwid="+id;
            pstm=conn.prepareStatement(sqr);
            pstm.executeUpdate();
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            
            }catch(Exception e){}
        }
        
        try{
            String str="select * from route";
            pstm=conn.prepareStatement(str);
            rs=pstm.executeQuery();
            while(rs.next())
            {
                rtb1=new Rt_bean();
                rtb1.setRoute(rs.getString("route"));
                rtb1.setPlace(rs.getString("place"));
                rtb1.setFare(rs.getDouble("fare"));
                rtb1.setId(rs.getInt("rwid"));
                
                al.add(rtb1);
            }
            
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
    public ArrayList updating_rt(Rt_bean rtb)
    {
        ArrayList al=new ArrayList();
        Rt_bean rtb1=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=dc.Dataconnect();
        }catch(Exception e){System.out.println(e);}
        
        try{
            String str="update route set route=?, place=?, fare=? where rwid="+rtb.getId();
            pstm=conn.prepareStatement(str);
            pstm.setString(1,rtb.getRoute());
            pstm.setString(2, rtb.getPlace());
            pstm.setDouble(3,rtb.getFare());
            
            pstm.executeUpdate();
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            }catch(Exception e){}
        }
        
        try{
            String str="select * from route";
            pstm=conn.prepareStatement(str);
            rs=pstm.executeQuery();
            while(rs.next())
            {
                rtb1=new Rt_bean();
                rtb1.setRoute(rs.getString("route"));
                rtb1.setPlace(rs.getString("place"));
                rtb1.setFare(rs.getDouble("fare"));
                rtb1.setId(rs.getInt("rwid"));
                
                al.add(rtb1);
            }
            
        }catch(Exception ee){System.out.println(ee);}
        finally{
            try{
            if(rs!=null){rs.close();}
            if(pstm!=null){pstm.close();}
            if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
}
