/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinepayment;

import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kapil
 */
public class WindowCreattionDB {
PreparedStatement ps=null;
PreparedStatement ps1=null;
PreparedStatement ps2=null;
ResultSet rs=null;
ResultSet rs1=null;    
ResultSet rs2=null; 
Connection con=null;
private static Logger logger=Logger.getLogger(WindowCreattionDB.class.getName());

public int saveOnlineWindowData(OnlinePaymentWindow onlinePaymentWindow) throws Exception{
    int cn=0;
    try
    {
        System.out.println("from: "+new java.sql.Date(onlinePaymentWindow.getFrom().getTime()));
        Dataconnectivity dc=new Dataconnectivity();
       con=(Connection)dc.Dataconnect();
       String qry="insert into online_payment_window(session,session_sem,degree,from_date,to_date,createdby,created_date) values(?,?,?,?,?,?,?)";
       ps=con.prepareStatement(qry);
       ps.setString(1, onlinePaymentWindow.getSession());
       ps.setString(2, onlinePaymentWindow.getSession_sem());
       ps.setString(3, onlinePaymentWindow.getDegree());
       ps.setDate(4, new java.sql.Date(onlinePaymentWindow.getFrom().getTime()));
       ps.setDate(5, new java.sql.Date(onlinePaymentWindow.getTo().getTime()));
       ps.setString(6, onlinePaymentWindow.getCreatedBy());
       ps.setDate(7, new java.sql.Date(onlinePaymentWindow.getCreatedDate().getTime()));
       cn=ps.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
        logger.log(Level.SEVERE,"Exception in saving data into online_payment_window in WindowCreattionDB at saveOnlineWindowData",e);
    }
    finally{
        if(ps!=null)ps.close();
        if(con!=null)con.close();
    }
    return cn;
}

public List<OnlinePaymentWindow> getOnlinePaymentWindowList()throws Exception{
    List<OnlinePaymentWindow> list=new ArrayList<OnlinePaymentWindow>();
    try
    {
        Dataconnectivity dc=new Dataconnectivity();
        OnlinePaymentWindow onlinePaymentWindow=null;
       con=(Connection)dc.Dataconnect();
       String qry="select * from online_payment_window";
       ps=con.prepareStatement(qry);
       rs=ps.executeQuery();
       while(rs.next()){
           onlinePaymentWindow=new OnlinePaymentWindow();
           onlinePaymentWindow.setRowid(rs.getInt("rowid"));
           onlinePaymentWindow.setSession(rs.getString("session"));
           onlinePaymentWindow.setSession_sem(rs.getString("session_sem"));
           onlinePaymentWindow.setDegree(rs.getString("degree"));
           onlinePaymentWindow.setFrom(rs.getDate("from_date"));
           onlinePaymentWindow.setTo(rs.getDate("to_date"));
           onlinePaymentWindow.setCreatedBy(rs.getString("createdby"));
           onlinePaymentWindow.setCreatedDate(rs.getDate("created_date"));
           onlinePaymentWindow.setUpdatedBy(rs.getString("updatedby"));
           onlinePaymentWindow.setUpdatedDate(rs.getDate("updated_date"));
           list.add(onlinePaymentWindow);
           onlinePaymentWindow=null;
       }
    }catch(Exception e){
        logger.log(Level.SEVERE,"Exception in fatching all data from online_payment_window in WindowCreattionDB at getWindowCreattionDBList",e);
    }
    finally{
        if(rs!=null)rs.close();
        if(ps!=null)ps.close();
        if(con!=null)con.close();
    }
    return list;
}

public boolean checkOnlineWindowData(String session, String degree) throws Exception{
    boolean cn=false;
    try
    {
        Dataconnectivity dc=new Dataconnectivity();
       con=(Connection)dc.Dataconnect();
       String qry="select * from online_payment_window where session=? and degree=?";
       ps=con.prepareStatement(qry);
       ps.setString(1, session);
       ps.setString(2, degree);
       rs=ps.executeQuery();
       if(rs.next())
           cn=true;
    }catch(Exception e){
        e.printStackTrace();
        logger.log(Level.SEVERE,"Exception in checking data from online_payment_window in WindowCreattionDB at saveOnlineWindowData",e);
    }
    finally{
        if(rs!=null)rs.close();
        if(ps!=null)ps.close();
        if(con!=null)con.close();
    }
    return cn;
}

public OnlinePaymentWindow getOnlinePaymentWindow(String session, String degree, String session_sem)throws Exception{
    OnlinePaymentWindow onlinePaymentWindow=null;
    try
    {
        Dataconnectivity dc=new Dataconnectivity();
        
       con=(Connection)dc.Dataconnect();
       String qry="select * from online_payment_window where session=? and session_sem=? and degree=?";
       ps=con.prepareStatement(qry);
       ps.setString(1, session);
       ps.setString(2, session_sem);
       ps.setString(3, degree);
       rs=ps.executeQuery();
       if(rs.next()){
           onlinePaymentWindow=new OnlinePaymentWindow();
           onlinePaymentWindow.setRowid(rs.getInt("rowid"));
           onlinePaymentWindow.setSession(rs.getString("session"));
           onlinePaymentWindow.setSession_sem(rs.getString("session_sem"));
           onlinePaymentWindow.setDegree(rs.getString("degree"));
           onlinePaymentWindow.setFrom(rs.getDate("from_date"));
           onlinePaymentWindow.setTo(rs.getDate("to_date"));
           onlinePaymentWindow.setCreatedBy(rs.getString("createdby"));
           onlinePaymentWindow.setCreatedDate(rs.getDate("created_date"));
           onlinePaymentWindow.setUpdatedBy(rs.getString("updatedby"));
           onlinePaymentWindow.setUpdatedDate(rs.getDate("updated_date"));
       }
    }catch(Exception e){
        logger.log(Level.SEVERE,"Exception in fatching all data from online_payment_window in WindowCreattionDB at getWindowCreattionDBList",e);
    }
    finally{
        if(rs!=null)rs.close();
        if(ps!=null)ps.close();
        if(con!=null)con.close();
    }
    return onlinePaymentWindow;
}

public OnlinePaymentWindow getOnlinePaymentWindow(int rowid)throws Exception{
    OnlinePaymentWindow onlinePaymentWindow=null;
    try
    {
        Dataconnectivity dc=new Dataconnectivity();
        
       con=(Connection)dc.Dataconnect();
       String qry="select * from online_payment_window where rowid=?";
       ps=con.prepareStatement(qry);
       ps.setInt(1, rowid);
       rs=ps.executeQuery();
       if(rs.next()){
           onlinePaymentWindow=new OnlinePaymentWindow();
           onlinePaymentWindow.setRowid(rs.getInt("rowid"));
           onlinePaymentWindow.setSession(rs.getString("session"));
           onlinePaymentWindow.setSession_sem(rs.getString("session_sem"));
           onlinePaymentWindow.setDegree(rs.getString("degree"));
           onlinePaymentWindow.setFrom(rs.getDate("from_date"));
           onlinePaymentWindow.setTo(rs.getDate("to_date"));
           onlinePaymentWindow.setCreatedBy(rs.getString("createdby"));
           onlinePaymentWindow.setCreatedDate(rs.getDate("created_date"));
           onlinePaymentWindow.setUpdatedBy(rs.getString("updatedby"));
           onlinePaymentWindow.setUpdatedDate(rs.getDate("updated_date"));
       }
    }catch(Exception e){
        logger.log(Level.SEVERE,"Exception in fatching all data from online_payment_window in WindowCreattionDB at getWindowCreattionDBList",e);
    }
    finally{
        if(rs!=null)rs.close();
        if(ps!=null)ps.close();
        if(con!=null)con.close();
    }
    return onlinePaymentWindow;
}

public int updateOnlineWindowData(OnlinePaymentWindow onlinePaymentWindow) throws Exception{
    int cn=0;
    try
    {
        Dataconnectivity dc=new Dataconnectivity();
       con=(Connection)dc.Dataconnect();
       String qry="update online_payment_window set session=?,session_sem=?,from_date=?,to_date=?,updatedby=?,updated_date=? where rowid=? and degree=?";
       ps=con.prepareStatement(qry);
       ps.setString(1, onlinePaymentWindow.getSession());
       ps.setString(2, onlinePaymentWindow.getSession_sem());       
       ps.setDate(3, new java.sql.Date(onlinePaymentWindow.getFrom().getTime()));
       ps.setDate(4, new java.sql.Date(onlinePaymentWindow.getTo().getTime()));
       ps.setString(5, onlinePaymentWindow.getUpdatedBy());
       ps.setDate(6, new java.sql.Date(onlinePaymentWindow.getUpdatedDate().getTime()));
       ps.setInt(7, onlinePaymentWindow.getRowid());
       ps.setString(8, onlinePaymentWindow.getDegree());
       cn=ps.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
        logger.log(Level.SEVERE,"Exception in updating data into online_payment_window in WindowCreattionDB at updateOnlineWindowData",e);
    }
    finally{
        if(ps!=null)ps.close();
        if(con!=null)con.close();
    }
    return cn;
}

}
