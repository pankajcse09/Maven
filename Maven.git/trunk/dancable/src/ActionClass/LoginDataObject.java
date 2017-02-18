package ActionClass;

import java.sql.*;
import java.util.*;
import com.myapp.struts.Dataconnectivity;
import ActionClass.*;
import java.util.*;
public class LoginDataObject{
    
static Connection con=null;
static PreparedStatement psmt=null;
static PreparedStatement psmt1=null;
static PreparedStatement psmt2=null;
static ResultSet rs=null;
static ResultSet rs1=null;
private int noOfRecords;


public HashMap _login(String p,java.util.Date now){  
        java.sql.Date fd=new java.sql.Date(now.getTime());
         
        Connection con=null;
         PreparedStatement psmt2 = null;
    ResultSet rs2 = null;
         int ins=20;
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
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   //ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
  ArrayList hs=new ArrayList();
   try{
       
       
   String qr2="select count(distinct order_id) as cnt from imd_cart_order where user_type='g' and order_date between '"+fd+"' and '"+fd+"' group by user_id";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}else{
increment = startIndex + remain;
}
   String qr1="select * from imd_cart_order where user_type='g' and order_date between '"+fd+"' and '"+fd+"' group by order_id";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
          JavaBean1 rb= new  JavaBean1();
         
          rb.setEmail_id(rs.getString("user_id"));
         rb.setOrder_id(rs.getString("order_id"));
          hs.add(rb);
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
   
    if(rs2!=null){rs2.close();}   
  
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
   hm.put("hset",hs); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex));
   return hm;             
     }


public  ArrayList select_Guest_loginid(java.util.Date frodate,java.util.Date todate)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
     java.sql.Date fd= new java.sql.Date(frodate.getTime());
      java.sql.Date td= new java.sql.Date(todate.getTime());
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select user_id, order_date,order_id from imd_cart_order  where user_type='g' and order_date between '"+fd+"' and '"+td+"' group by order_id order by order_date desc";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
         rb.setLoginid(rs.getString("user_id"));
       
rb.setOrder_date(rs.getDate("order_date"));
          rb.setOrder_id(rs.getString("order_id"));
  
          
           user_id.add(rb);
         
          
       }
          }catch(Exception e){}
     return user_id;
   } 

public HashMap select_Profile_login_date(String p,java.util.Date fromdate){  
    
     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
        Connection con=null;
         PreparedStatement psmt2 = null;
    ResultSet rs2 = null;
         int ins=20;
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
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   //ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
  ArrayList hs=new ArrayList();
   try{
    String qr2="select count(distinct order_id)as cnt from registrationtable join imd_cart_order on registrationtable.email_id=imd_cart_order.user_id where imd_cart_order.user_type='r' and  registrationtable.status='p' and order_date between '"+fd+"' and '"+fd+"'";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}else{
increment = startIndex + remain;
}
   String qr1="select * from registrationtable join imd_cart_order on registrationtable.email_id=imd_cart_order.user_id  where imd_cart_order.user_type='r' and  registrationtable.status='p' and order_date between '"+fd+"' and '"+fd+"' group by order_id";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
          JavaBean1 rb= new  JavaBean1();
          rb.setName(rs.getString("name"));
          rb.setEmail_id(rs.getString("registrationtable.email_id"));
          rb.setLast_name(rs.getString("registrationtable.last_name"));
          rb.setId(rs.getString("registrationtable.id"));
          rb.setLoginid(rs.getString("registrationtable.loginid"));
          rb.setHomeaddress(rs.getString("registrationtable.homeaddress"));
          rb.setMobileno(rs.getString("registrationtable.mobileno"));
          rb.setCity(rs.getString("registrationtable.city"));
          rb.setCountry(rs.getString("registrationtable.country"));
          rb.setPincode(rs.getString("registrationtable.pincode"));
//          rb.setOrder_date(rs.getDate("order_date"));
          rb.setOrder_id(rs.getString("order_id"));
          hs.add(rb);
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
   
    if(rs2!=null){rs2.close();}   
  
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
   hm.put("hset",hs); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex));
   return hm;             
}
    

public  ArrayList select_Profile_customer(java.util.Date frodate,java.util.Date todate)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
     java.sql.Date fd= new java.sql.Date(frodate.getTime());
      java.sql.Date td= new java.sql.Date(todate.getTime());
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
 String st="select user_id, order_date,order_id from imd_cart_order join registrationtable reg on imd_cart_order.user_id=reg.email_id "
         + "where imd_cart_order.user_type='r' and order_date between '"+fd+"' and '"+td+"' group by order_id order by order_date desc";
  
    //  String st="select id,name,loginid from registrationtable where status='d' and user_type='customer'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
         
         
          rb.setLoginid(rs.getString("user_id"));
          rb.setOrder_date(rs.getDate("order_date"));
          rb.setOrder_id(rs.getString("order_id"));
          //System.out.println("hello: "+rb.getOrder_date());
           user_id.add(rb);
         
          
       }
          }catch(Exception e){System.out.println("hello: "+e.getMessage());}
     return user_id;
   } 
    
    

public  ArrayList app_link(int appid)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList loginlist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select link_name from cms_link join link_auth on cms_link.app_id=link_auth.app_id where link_auth.app_id="+appid;
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
      role_bean rb= new role_bean();
         
         
      rb.setLn(rs.getString("link_name"));
       
  
          
          loginlist.add(rb);
         
          
       }
          }catch(Exception e){}
     return     loginlist;
   } 


// String sql="select sub_cat,sub_cat_id from sub_cat sc join rule_desc rd on sc.sub_cat_id=rd.subcat_id where rd.rule='"+rulname+"'";



public  ArrayList app_logid(String loginid)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList loginlist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select app_name,cms_app.app_id from cms_app join link_auth on cms_app.app_id=link_auth.app_id where link_auth.login_id='"+loginid+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
      role_bean rb= new role_bean();
         
         
        rb.setApp(rs.getString("app_name"));
        rb.setApp_id(rs.getInt("app_id"));
       
  
          
          loginlist.add(rb);
         
          
       }
          }catch(Exception e){}
     return     loginlist;
   } 


public  ArrayList all_login(String loginid)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList loginlist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select loginid,name,dep,design,dep_id from registrationtable where loginid='"+loginid+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        

      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
         
         
        
         
       rb.setLoginid(rs.getString("loginid"));
          rb.setName(rs.getString("name"));
          rb.setDep(rs.getString("dep"));
          rb.setDes(rs.getString("design"));
          rb.setDep_id(rs.getString("dep_id"));
       
  
          
          loginlist.add(rb);
         
          
       }
          }catch(Exception e){}
     return     loginlist;
   } 

public  ArrayList search_loginid(String logid)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList loginlist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select loginid from registrationtable where loginid like upper('"+logid+"%') or loginid like lower('"+logid+"%')"; 
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
         
         
        
          rb.setLoginid(rs.getString("loginid"));
       
  
          
          loginlist.add(rb);
         
          
       }
          }catch(Exception e){}
     return     loginlist;
   } 



public  ArrayList select_loginid(String dep,String des)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList loginlist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select loginid from registrationtable where dep='"+dep+"' and design='"+des+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
         
         
        
          rb.setLoginid(rs.getString("loginid"));
       
  
          
          loginlist.add(rb);
         
          
       }
          }catch(Exception e){}
     return     loginlist;
   } 



public  ArrayList select_design(String dep)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList designlist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select design from registrationtable where dep='"+dep+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
         
         
        
          rb.setDes(rs.getString("design"));
       
  
          
           designlist.add(rb);
         
          
       }
          }catch(Exception e){}
     return    designlist;
   } 





public  ArrayList select_dep()throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList deplist=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select dep from registrationtable where status='d'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
         
         
        
          rb.setDep(rs.getString("dep"));
       
  
          
          deplist.add(rb);
         
          
       }
          }catch(Exception e){}
     return   deplist;
   } 
public  ArrayList select_loginid()throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select id,loginid from registrationtable where status='d'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          rb.setId(new Integer(rs.getInt("id")).toString());
        
          rb.setLoginid(rs.getString("loginid"));
       
  
          
           user_id.add(rb);
         
          
       }
          }catch(Exception e){}
     return user_id;
   } 
    

public boolean admin_Profile_edit(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
     
      
   String qr1="update registrationtable set dep=?,design=?,name=?,loginid=?,admin=?,center=?,publish=?,preview=?,dep_id=? where id='"+Integer.parseInt(jb.getId())+"'";    
  try{     
   psmt=con.prepareStatement(qr1);     
   psmt.setString(1,jb.getDep());  
   psmt.setString(2,jb.getDes());
   psmt.setString(3,jb.getName());
   psmt.setString(4,jb.getLoginid());
   psmt.setString(5,jb.getAdmin());
   psmt.setString(6,jb.getCenter());
   psmt.setString(7,jb.getPublish());
   psmt.setString(8,jb.getPreview());
   psmt.setString(9,jb.getDep_id());
   psmt.executeUpdate();  
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return true;  
 }
    

public  ArrayList select_Profile_id(int id)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select id,name,loginid,dep,design,dep_id from registrationtable where id='"+id+"'";    
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          rb.setId(new Integer(rs.getInt("id")).toString());
          rb.setName(rs.getString("name"));
          rb.setLoginid(rs.getString("loginid"));
          rb.setDep(rs.getString("dep"));
          rb.setDep_id(rs.getString("dep_id"));
          rb.setDes(rs.getString("design"));
       
  
          
           user_id.add(rb);
         
          
       }
          }catch(Exception e){}
     return user_id;
   } 
    


public  String select_user_type(JavaBean1 jb)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
   String usertype="";
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select id,name,loginid,user_type from registrationtable where loginid='"+jb.getLoginid()+"'";    
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
      
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
         
         usertype=rs.getString("user_type");
       
  
          
         
         
          
       }
          }catch(Exception e){}
     return usertype;
   } 
    



public  String customer_select_user_type(JavaBean1 jb)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
   String usertype="";
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select id,name,email_id,user_type from registrationtable where email_id='"+jb.getLoginid()+"'";    
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
      
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
         
         usertype=rs.getString("user_type");
       
  
          
         
         
          
       }
          }catch(Exception e){}
     return usertype;
   } 
    

public boolean Profile_edit(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="update registrationtable set name=?,password=?,secretques=?,secretans=? where loginid='"+id+"'";    
  try{     
   psmt=con.prepareStatement(qr1);     
   psmt.setString(1,jb.getName());  
   psmt.setString(2,passwd);
   psmt.setString(3,jb.getSecretques());
   psmt.setString(4,jb.getSecretans());
   psmt.executeUpdate();  
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return true;  
 }
    


public void  Profile_del(String userid)
    {
    
       
   
   
     
            
       try{
            String sql="update registrationtable set status=? where id='"+userid+"'";
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
            psmt=con.prepareStatement(sql);
            psmt.setString(1,"del");
            psmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }





public  ArrayList select_Profile()throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select id,name,loginid from registrationtable where status='d'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          rb.setId(new Integer(rs.getInt("id")).toString());
          rb.setName(rs.getString("name"));
          rb.setLoginid(rs.getString("loginid"));
       
  
          
           user_id.add(rb);
         
          
       }
          }catch(Exception e){}
     return user_id;
   } 
    


 public HashMap select_Profile_login(String p){  
        Connection con=null;
         PreparedStatement psmt2 = null;
    ResultSet rs2 = null;
         int ins=20;
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
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   //ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
  ArrayList hs=new ArrayList();
   try{
       
       
   String qr2="select count(id)as cnt from registrationtable where status='p'";
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % ins;
if(startIndex + ins <= numRows){
increment = startIndex + ins;
}else{
increment = startIndex + remain;
}
   String qr1="select * from registrationtable where status='p'";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
          JavaBean1 rb= new  JavaBean1();
          rb.setName(rs.getString("name"));
          rb.setEmail_id(rs.getString("email_id"));
          rb.setLast_name(rs.getString("last_name"));
          rb.setId(rs.getString("id"));
          rb.setLoginid(rs.getString("loginid"));
          rb.setHomeaddress(rs.getString("homeaddress"));
          rb.setMobileno(rs.getString("mobileno"));
          rb.setCity(rs.getString("city"));
          rb.setCountry(rs.getString("country"));
          rb.setPincode(rs.getString("pincode"));
          hs.add(rb);
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
   
    if(rs2!=null){rs2.close();}   
  
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
   hm.put("hset",hs); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex));
   return hm;             
     }



public void  reg_update(String userid)
    {
    
       
   
   
     
            
       try{
            String sql="update registrationtable set status=? where id='"+userid+"'";
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    con=(Connection)cour_con.Dataconnect();
            psmt=con.prepareStatement(sql);
            psmt.setString(1,"d");
            psmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }


public  JavaBean1 detail_user(int uid)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 rb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select * from registrationtable where id='"+uid+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
      
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          rb.setId(new Integer(rs.getInt("id")).toString());
          rb.setLoginid(rs.getString("loginid"));
          rb.setName(rs.getString("name"));
          rb.setDep_id(rs.getString("dep_id"));
          rb.setDep(rs.getString("dep"));
          rb.setDes(rs.getString("design"));
       
  
          
          
         
          
       }
          }catch(Exception e){}
     return rb;
   } 
    
public  JavaBean1 detail_Address(String emailid)throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 rb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select * from registrationtable where email_id='"+emailid+"'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
      
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          rb.setId(new Integer(rs.getInt("id")).toString());
         
          rb.setName(rs.getString("name"));
          rb.setLast_name(rs.getString("last_name"));
          rb.setHomeaddress(rs.getString("homeaddress"));
          rb.setCity(rs.getString("city"));
          rb.setState(rs.getString("state"));
          rb.setPincode(rs.getString("pincode"));
          rb.setCountry(rs.getString("country"));
          rb.setMobileno(rs.getString("mobileno"));
         
          
       }
          }catch(Exception e){}
     return rb;
   } 
 public  ArrayList select_Userid()throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select id from registrationtable where status='p'";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       while(rs.next())
       {
       JavaBean1 rb= new  JavaBean1();
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
          rb.setId(new Integer(rs.getInt("id")).toString());
       
  
          
           user_id.add(rb);
         
          
       }
          }catch(Exception e){}
     return user_id;
   } 
    

 public  ArrayList select_user()throws Exception 
    
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
  JavaBean1 getdataus = null;
    ArrayList cust_list=new ArrayList();
    String pass="";
    Common cmn=new Common();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select * from registrationtable order by id desc";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
 JavaBean1 rb= new JavaBean1();
    if(rs.next())
       {
          
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
        rb.setId(new Integer(rs.getInt("id")).toString());
        rb.setLoginid(rs.getString("loginid"));
        rb.setName(rs.getString("name"));
  pass=cmn.decrypt(rs.getString("password"));
         rb.setPassword(pass);
         rb.setSecretans(rs.getString("secretans"));
         rb.setSecretques(rs.getString("secretques"));
         rb.setDep(rs.getString("dep"));
         rb.setDep_id(rs.getString("dep_id"));
         rb.setDes(rs.getString("design"));
               
         cust_list.add(rb);
         
          
       }
          }catch(Exception e){}
     return cust_list;
   } 
        


public  JavaBean1 editRegistData(String id){  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   String dcpass="";
   Common cmn=new Common();
   JavaBean1 jb=new JavaBean1();   
   String qr1="select * from registrationtable where loginid='"+id+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();
        if(rs.next()){            
        jb.setId(rs.getString("id"));
        jb.setName(rs.getString("name"));        
        jb.setLoginid(rs.getString("loginid"));
        dcpass=cmn.decrypt(rs.getString("password"));
        jb.setPassword(dcpass);        
        jb.setSecretques(rs.getString("secretques"));
        jb.setSecretans(rs.getString("secretans"));
        jb.setHomeaddress(rs.getString("homeaddress"));
        jb.setHomeaddress2(rs.getString("homeaddress2"));
        jb.setCity(rs.getString("city"));
        jb.setState(rs.getString("state"));
        jb.setPincode(rs.getString("pincode"));
        jb.setCountry(rs.getString("country"));
        jb.setTelno(rs.getString("telno"));
        jb.setMobileno(rs.getString("mobileno"));
        jb.setLast_name(rs.getString("last_name"));
        }
   }
   catch(SQLException se){}
   finally{
      try{
         if(rs!=null){rs.close();} 
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
      catch(SQLException se){}      
   }
   return jb;    
   } 
  
  
  public  JavaBean1 editCustomerRegistData(String id){  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   String dcpass="";
   Common cmn=new Common();
   JavaBean1 jb=new JavaBean1();   
   String qr1="select * from registrationtable where email_id='"+id+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();
        if(rs.next()){            
        jb.setId(rs.getString("id"));
        jb.setName(rs.getString("name"));        
        //jb.setLoginid(rs.getString("loginid"));
        jb.setEmail_id(rs.getString("email_id"));
        dcpass=cmn.decrypt(rs.getString("password"));
        jb.setPassword(dcpass);        
      //  jb.setSecretques(rs.getString("secretques"));
      //  jb.setSecretans(rs.getString("secretans"));
        jb.setHomeaddress(rs.getString("homeaddress"));
       // jb.setHomeaddress2(rs.getString("homeaddress2"));
        jb.setCity(rs.getString("city"));
        jb.setState(rs.getString("state"));
        jb.setPincode(rs.getString("pincode"));
        jb.setCountry(rs.getString("country"));
        //jb.setTelno(rs.getString("telno"));
        jb.setMobileno(rs.getString("mobileno"));
        jb.setLast_name(rs.getString("last_name"));
        }
   }
   catch(SQLException se){}
   finally{
      try{
         if(rs!=null){rs.close();} 
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
      catch(SQLException se){}      
   }
   return jb;    
   } 
  
  
  
  
  public int authenticateData(JavaBean1 jb){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  int count=0;
  Common comLogin = new Common(); 
  String usnme=jb.getLoginid();
  String passwd=jb.getPassword();
         usnme=usnme.trim();
         passwd = passwd.trim();           
        String qu="select * from registrationtable where status='d'";        
        try{
       psmt=con.prepareStatement(qu);     
       rs=psmt.executeQuery();
      
              while(rs.next()){                             
                                String  duname=(String)rs.getString("loginid");
                                duname=duname.trim();
                                String  apasswd=(String)rs.getString("password");
                                apasswd=apasswd.trim();
                                String dpasswd = (String)comLogin.decrypt(apasswd);
                                dpasswd=dpasswd.trim();     
            
                                if(duname.equals(usnme) && dpasswd.equals(passwd))                                                    
                                            {
                                            count=1;
                                             break;
                                            }                                
                              }   
          }
     
     catch(SQLException e){}
     finally { 
                  try{ 
                   if(rs!=null){rs.close(); }
                   if(psmt!=null){psmt.close();}
                   if(con!=null){con.close();}                                     
                    }
                  catch(SQLException e){}                  
         }  
    return count;
    }

  public int customer_AuthenticateData(JavaBean1 jb){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  int count=0;
  Common comLogin = new Common(); 
  String usnme=jb.getLoginid();
  String passwd=jb.getPassword();
         usnme=usnme.trim();
         passwd = passwd.trim();           
        String qu="select * from registrationtable where status='p'";        
        try{
       psmt=con.prepareStatement(qu);     
       rs=psmt.executeQuery();
      
              while(rs.next()){                             
                                String  duname=(String)rs.getString("email_id");
                                duname=duname.trim();
                                String  apasswd=(String)rs.getString("password");
                                apasswd=apasswd.trim();
                                String dpasswd = (String)comLogin.decrypt(apasswd);
                                dpasswd=dpasswd.trim();     
            
                                if(duname.equals(usnme) && dpasswd.equals(passwd))                                                    
                                            {
                                            count=1;
                                             break;
                                            }                                
                              }   
          }
     
     catch(SQLException e){}
     finally { 
                  try{ 
                   if(rs!=null){rs.close(); }
                   if(psmt!=null){psmt.close();}
                   if(con!=null){con.close();}                                     
                    }
                  catch(SQLException e){}                  
         }  
    return count;
    }

   public int registUserData_Emp(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   int count=0;
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   String qr="select count(loginid) as cnt from registrationtable where loginid='"+id+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   count=rs1.getInt("cnt");
   }
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}     
     }   
    catch(SQLException se){}
    }
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="insert into registrationtable(name,loginid,password,secretques," +
           "secretans,status,dep_id,dep,design,homeaddress,homeaddress2,city,state,pincode,country,telno,mobileno,last_name,user_type,email_id" +
           ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
  try{     
   psmt=con.prepareStatement(qr1);  
   if(count==0){
   psmt.setString(1,jb.getName());
   psmt.setString(2,jb.getLoginid());
   psmt.setString(3,passwd);
   psmt.setString(4,jb.getSecretques());
   psmt.setString(5,jb.getSecretans());
   psmt.setString(6,"d");
   psmt.setString(7,jb.getDep_id());
   psmt.setString(8,jb.getDep());
   psmt.setString(9,jb.getDes());
   psmt.setString(10,jb.getHomeaddress());
   psmt.setString(11,jb.getHomeaddress2());
   psmt.setString(12,jb.getCity());
   psmt.setString(13,jb.getState());
   psmt.setString(14,jb.getPincode());
   psmt.setString(15,jb.getCountry());
   psmt.setString(16,jb.getTelno());
   psmt.setString(17,jb.getMobileno());   
   
    psmt.setString(18,jb.getLast_name());   
    psmt.setString(19,jb.getUser_type());
    psmt.setString(20,jb.getEmail_id());
  
   psmt.executeUpdate();
   }
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return count;  
 }
//   public int registUserData_Customer(JavaBean1 jb){ 
//   try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }
//  catch(Exception e){
//  System.out.println(e.getMessage());    
//  }  
//   int count=0;
//   String id=jb.getEmail_id();   
//   String passwd1=jb.getPassword();  
//   String qr="select count(email_id) as cnt from registrationtable where email_id='"+id+"'";
//   try{
//   psmt1=con.prepareStatement(qr);   
//   rs1=psmt1.executeQuery();
//   if(rs1.next()){
//   count=rs1.getInt("cnt");
//   }
//   }
//   catch(SQLException se){}
//   finally{
//    try{
//    if(rs1!=null){rs1.close();}     
//    if(psmt1!=null){psmt1.close();}     
//     }   
//    catch(SQLException se){}
//    }
//   Common comLogin = new Common();   
//   String passwd =(String)comLogin.encrypt(passwd1);
//   passwd=passwd.trim();      
//   String qr1="insert into registrationtable(name,loginid,password,secretques," +
//           "secretans,status,dep_id,dep,design,homeaddress,homeaddress2,city,state,pincode,country,telno,mobileno,last_name,user_type" +
//           ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
//  try{     
//   psmt=con.prepareStatement(qr1);  
//   if(count==0){
//   psmt.setString(1,jb.getName());
//   psmt.setString(2,jb.getLoginid());
//   psmt.setString(3,passwd);
//   psmt.setString(4,jb.getSecretques());
//   psmt.setString(5,jb.getSecretans());
//   psmt.setString(6,"p");
//   psmt.setString(7,jb.getDep_id());
//   psmt.setString(8,jb.getDep());
//   psmt.setString(9,jb.getDes());
//   psmt.setString(10,jb.getHomeaddress());
//   psmt.setString(11,jb.getHomeaddress2());
//   psmt.setString(12,jb.getCity());
//   psmt.setString(13,jb.getState());
//   psmt.setString(14,jb.getPincode());
//   psmt.setString(15,jb.getCountry());
//   psmt.setString(16,jb.getTelno());
//   psmt.setString(17,jb.getMobileno());   
//   
//    psmt.setString(18,jb.getLast_name());   
//    psmt.setString(19,jb.getUser_type());
//  
//   psmt.executeUpdate();
//   }
//   }  
//   catch(SQLException se){
//   System.out.println(se.getMessage());   
//    } 
//      finally{
//       try{
//         if(psmt!=null){psmt.close();}  
//         if(con!=null){con.close();}  
//       }   
//       catch(SQLException se){}
//      }   
//  return count;  
// }
   public int registUserData_Customer(JavaBean1 jb)throws Exception{ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   int count=0;
   String id=jb.getEmail_id();   
   String passwd1=jb.getPassword();  
   String qr="select count(email_id) as cnt from registrationtable where email_id='"+id+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   count=rs1.getInt("cnt");
   }
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}     
     }   
    catch(SQLException se){}
    }
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
//   String qr1="insert into registrationtable(name,password,status," +
//           "homeaddress,city,state,pincode,country,mobileno,last_name,user_type,email_id,activation" +
//           ")values(?,?,?,?,?,?,?,?,?,?,?,?,?)";    
    String qr1="insert into registrationTemp(name,password,status," +
           "homeaddress,city,state,pincode,country,mobileno,last_name,user_type,email_id,activation,reg_date" +
           ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
  
  try{     
      if(count==0){
   psmt=con.prepareStatement(qr1);  
   
   psmt.setString(1,jb.getName());  
   psmt.setString(2,passwd);  
   psmt.setString(3,"p");   
   psmt.setString(4,jb.getHomeaddress());  
   psmt.setString(5,jb.getCity());
   psmt.setString(6,jb.getState());
   psmt.setString(7,jb.getPincode());
   psmt.setString(8,jb.getCountry());   
   psmt.setString(9,jb.getMobileno());     
    psmt.setString(10,jb.getLast_name());   
    psmt.setString(11,jb.getUser_type());
    psmt.setString(12,jb.getEmail_id());
    psmt.setString(13,"pending");
    psmt.setDate(14, new java.sql.Date(new java.util.Date().getTime()));
  
   psmt.executeUpdate();
   }
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return count;  
 }
  
   public int activateUserAccount(String emailid)throws Exception{ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   int count=0;
   int id=0;
   java.util.Date current=new java.util.Date();
   java.util.Date reg_date=null;
   String qr="select id,reg_date from registrationTemp where email_id='"+emailid+"'";
//   System.out.println("Query: "+qr);
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   reg_date=rs1.getDate("reg_date");
   id=rs1.getInt("id");
   
   int days=(int)(current.getTime()-reg_date.getTime())/(1000*60*60*24);
   if(days<=5){
          String qr1="insert into registrationtable(name,password,status," +
           "homeaddress,city,state,pincode,country,mobileno,last_name,user_type,email_id,reg_date" +
           ") select name,password,status," +
           "homeaddress,city,state,pincode,country,mobileno,last_name,user_type,email_id,reg_date" +
           " from registrationTemp where email_id='"+emailid+"'";
   psmt=con.prepareStatement(qr1);  
   psmt.executeUpdate();
   
   String qr2="delete from registrationTemp where id="+id;
   psmt2=con.prepareStatement(qr2);  
   psmt2.executeUpdate();
   }
      else{
          String qr2="delete from registrationTemp where id="+id;
   psmt2=con.prepareStatement(qr2);  
   psmt2.executeUpdate();
   count=1;
      }
   }
   else{
       count=1;
   }
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt!=null){psmt.close();}  
    if(psmt1!=null){psmt1.close();}
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();}     
     }   
    catch(SQLException se){}
    }
//   System.out.println("Current date: "+current.getTime());
//   System.out.println("reg date: "+reg_date.getTime());
   
//        System.out.println("days: "+days);
   
    
  return count;  
 }
  
  
  public int registUserData(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   int count=0;
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   String qr="select count(email_id) as cnt from registrationtable where email_id='"+id+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   count=rs1.getInt("cnt");
   }
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}     
     }   
    catch(SQLException se){}
    }
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="insert into registrationtable(name,loginid,password,secretques," +
           "secretans,status,dep_id,dep,design,homeaddress,homeaddress2,city,state,pincode,country,telno,mobileno,last_name,user_type" +
           ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
  try{     
   psmt=con.prepareStatement(qr1);  
   if(count==0){
   psmt.setString(1,jb.getName());
   psmt.setString(2,jb.getLoginid());
   psmt.setString(3,passwd);
   psmt.setString(4,jb.getSecretques());
   psmt.setString(5,jb.getSecretans());
   psmt.setString(6,"p");
   psmt.setString(7,jb.getDep_id());
   psmt.setString(8,jb.getDep());
   psmt.setString(9,jb.getDes());
   psmt.setString(10,jb.getHomeaddress());
   psmt.setString(11,jb.getHomeaddress2());
   psmt.setString(12,jb.getCity());
   psmt.setString(13,jb.getState());
   psmt.setString(14,jb.getPincode());
   psmt.setString(15,jb.getCountry());
   psmt.setString(16,jb.getTelno());
   psmt.setString(17,jb.getMobileno());   
   
    psmt.setString(18,jb.getLast_name());   
    psmt.setString(19,jb.getUser_type());
  
   psmt.executeUpdate();
   }
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return count;  
 }
    
  public boolean editUserData(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="update registrationtable set name=?,password=?,secretques=?,secretans=?,last_name=?,homeaddress=?,homeaddress2=?" +
           ",city=?,state=?,pincode=?,country=?,telno=?,mobileno=? where loginid='"+id+"'";    
  try{     
   psmt=con.prepareStatement(qr1);     
   psmt.setString(1,jb.getName());  
   psmt.setString(2,passwd);
   psmt.setString(3,jb.getSecretques());
   psmt.setString(4,jb.getSecretans());
   psmt.setString(5,jb.getLast_name());
   psmt.setString(6,jb.getHomeaddress());
   psmt.setString(7,jb.getHomeaddress2());
   psmt.setString(8,jb.getCity());
   psmt.setString(9,jb.getState());
   psmt.setString(10,jb.getPincode());
   psmt.setString(11,jb.getCountry());
   psmt.setString(12,jb.getTelno());
   psmt.setString(13,jb.getMobileno());
   
   
   
   
   
   
   psmt.executeUpdate();  
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return true;  
 }
  
  
    
  public boolean editCustomerData(JavaBean1 jb)throws Exception{ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="update registrationtable set name=?,password=?,last_name=?,homeaddress=?" +
           ",city=?,state=?,pincode=?,country=?,mobileno=? where email_id='"+id+"'";    
  try{     
   psmt=con.prepareStatement(qr1);     
   psmt.setString(1,jb.getName());  
   psmt.setString(2,passwd);
    psmt.setString(3,jb.getLast_name());
   psmt.setString(4,jb.getHomeaddress());
   
   psmt.setString(5,jb.getCity());
   psmt.setString(6,jb.getState());
   psmt.setString(7,jb.getPincode());
   psmt.setString(8,jb.getCountry());
  
   psmt.setString(9,jb.getMobileno());
   
   
   
   
   
   
   psmt.executeUpdate();  
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return true;  
 }
  
  
  public int chkloginPassword(String emailid){  
          JavaBean1 jb=new JavaBean1();  
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
          
          int count=0;
  
   String qr="select count(email_id) as cnt from registrationtable where email_id='"+emailid+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   count=rs1.getInt("cnt");
   }
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}   
     if(con!=null){con.close();}  
     }   
    catch(SQLException se){}
    }
   
  
  
      
    return count; 
     }
     
  
  
     public JavaBean1 loginPassword(String emailid)throws Exception{  
          JavaBean1 jb=new JavaBean1();  
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
          
        
   
  
   String qr1="select email_id,password  from registrationtable where email_id='"+emailid+"'";  
    Common comLogin = new Common();   
   
   try{
       
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();
        while(rs.next()){
          
       jb.setEmail_id(rs.getString("email_id"));
        jb.setPassword(comLogin.decrypt(rs.getString("password")));
        
        }
      
   }
   catch(SQLException se){}
   finally{
      try{
         if(rs!=null){rs.close();} 
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}      
   }
      
    return jb; 
     }
     
     
     
  public ArrayList loginData(){  
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
   ArrayList ar=new ArrayList();
   String qr1="select id,name,loginid from registrationtable";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();
        while(rs.next()){
        JavaBean1 jb=new JavaBean1();     
        jb.setId(rs.getString("id"));
        jb.setName(rs.getString("name"));
        jb.setLoginid(rs.getString("loginid"));
        ar.add(jb);
        }
   }
   catch(SQLException se){}
   finally{
      try{
         if(rs!=null){rs.close();} 
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}      
   }
   return ar;    
   } 
  
  public boolean delLoginData(int  id){  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
  String qr1="delete from registrationtable where id='"+id+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        psmt.executeUpdate();       
      }
   catch(SQLException se){}
   finally{
      try{        
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}      
   }
   return true;    
   }
  
public ArrayList get_cust_order_date(String loginid,java.util.Date fromdate,java.util.Date todate,int offset,int noOfRecords){  
    
     java.sql.Date fd= new java.sql.Date(fromdate.getTime());
     java.sql.Date td= new java.sql.Date(todate.getTime());
        Connection con=null;
         try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   //ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
  ArrayList hs=new ArrayList();
   try{
    
   String qr1="select SQL_CALC_FOUND_ROWS * from registrationtable join imd_cart_order on registrationtable.email_id=imd_cart_order.user_id  where"
           + " imd_cart_order.user_type='r' and  registrationtable.status='p' and imd_cart_order.user_id='"+loginid+"' and"
           + " order_date between '"+fd+"' and '"+td+"' group by order_id limit " + offset +"," + noOfRecords;
//   System.out.println(qr1);
     psmt=con.prepareStatement(qr1);
     rs=psmt.executeQuery();
    
while(rs.next()){ 
          JavaBean1 rb= new  JavaBean1();
          rb.setName(rs.getString("name"));
          rb.setEmail_id(rs.getString("registrationtable.email_id"));
          rb.setLast_name(rs.getString("registrationtable.last_name"));
          rb.setId(rs.getString("registrationtable.id"));
          rb.setLoginid(rs.getString("registrationtable.loginid"));
          rb.setHomeaddress(rs.getString("registrationtable.homeaddress"));
          rb.setMobileno(rs.getString("registrationtable.mobileno"));
          rb.setCity(rs.getString("registrationtable.city"));
          rb.setCountry(rs.getString("registrationtable.country"));
          rb.setPincode(rs.getString("registrationtable.pincode"));
//          rb.setOrder_date(rs.getDate("order_date"));
          rb.setOrder_id(rs.getString("order_id"));
          hs.add(rb);
          
     } 
rs.close();
 
    rs = psmt.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);   
     
 }
catch(SQLException se){   } 
   finally{
   try{
    if(rs!=null){rs.close();}   
    if(psmt2!=null){psmt2.close();}   
    if(con!=null){con.close();}        
  
   }catch(SQLException se){ }
   }
   return hs;             
}

public  double retTotAmountDateWise(java.util.Date frodate,java.util.Date todate)throws Exception 
   {
       double am=0.0;
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
 JavaBean1 getdataus = null;
    ArrayList user_id=new ArrayList();
    JavaBean1 jb= new JavaBean1();
   //Common_data da=null;
    
     java.sql.Date fd= new java.sql.Date(frodate.getTime());
      java.sql.Date td= new java.sql.Date(todate.getTime());
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="SELECT sum(shp.sm) as shp_charge,sum(shp.total) as total from(select shiiping_charge as sm,sum(total) as total,order_date from imd_cart_order where order_date BETWEEN '"+fd+"' and '"+td+"' group by order_id) as shp";
//      System.out.println("SELECT sum(shp.sm) as shp_charge,sum(shp.total) as total from(select shiiping_charge as sm,total,order_date from imd_cart_order where order_date BETWEEN '"+fd+"' and '"+td+"' group by order_id) as shp");
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
      
       if(rs.next())
       {
           am=rs.getDouble("total")+rs.getDouble("shp_charge");
       }
          }catch(Exception e){}
     return am;
   } 

public int getNoOfRecords() {
        return noOfRecords;
    }
  
 public static void main(String args[])
 {
     JavaBean1 jb=new JavaBean1();
    
     
 LoginDataObject ldb=new  LoginDataObject ();
        try {
            jb=ldb.loginPassword("arjunpapolamca@gmail.com");
            System.out.println("rjun"+jb.getPassword());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
 
 }
         
}
