package com.myapp.struts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DataObject {       
    /** Creates a new instance of DataObject */    
    static PreparedStatement psmt=null; 
    static PreparedStatement psmt1=null; 
    static PreparedStatement psmt2=null; 
    static PreparedStatement psmt3=null; 
    static PreparedStatement psmt4=null; 
    static PreparedStatement psmt5=null; 
    static ResultSet rs=null;
    static ResultSet rs1=null;
    static ResultSet rs2=null;
    static ResultSet rs3=null;
    static ResultSet rs4=null;
    static ResultSet rs5=null;
    public DataObject(){}
    
  public int compTarrif(JavaBean jb1){  
  Connection con=null;    
  int count=0;    
  String dt=jb1.getDated();
  String cname=jb1.getCompname();
  String zn=jb1.getZone();
  double wt15=jb1.getWt1_5();
  double adwt5=jb1.getAdwt5();  
  double nondoc=jb1.getNondoc();  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr="select count(*) as cnt from comptarrifrate where companyname='"+cname+"' and zone='"+zn+"'";
  String qr1="insert into comptarrifrate(dated,zone,companyname,weight1_5,addweight5,non_doc)values(?,?,?,?,?,?)";
  try{
  psmt1=con.prepareStatement(qr);    
  rs1=psmt1.executeQuery();
  rs1.next();
  count=rs1.getInt("cnt");
  psmt=con.prepareStatement(qr1);
  if(count==0){
  psmt.setString(1,dt);  
  psmt.setString(2,zn);  
  psmt.setString(3,cname); 
  psmt.setDouble(4,wt15);
  psmt.setDouble(5,adwt5);
  psmt.setDouble(6,nondoc);    
  psmt.executeUpdate();
  }
  }
  catch(SQLException se){} 
   finally{
   try{
    if(rs1!=null){rs1.close();}
    if(psmt1!=null){psmt1.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return count;
  } 
  public int compAirCargo(JavaBean jb1){  
    Connection con=null;    
  int count=0;    
  String dt=jb1.getDated();
  String cname=jb1.getCompname();
  String zn=jb1.getZone();
  double wt15=jb1.getWt1_5();
  double adwt5=jb1.getAdwt5();  
  double nondoc=jb1.getNondoc();  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr="select count(*) as cnt from compaircargo where companyname='"+cname+"' and zone='"+zn+"'";
  String qr1="insert into compaircargo(dated,zone,companyname,weight1_5,addweight5,non_doc)values(?,?,?,?,?,?)";
  try{
  psmt1=con.prepareStatement(qr);    
  rs1=psmt1.executeQuery();
  rs1.next();
  count=rs1.getInt("cnt");
  psmt=con.prepareStatement(qr1);
  if(count==0){
  psmt.setString(1,dt);  
  psmt.setString(2,zn);  
  psmt.setString(3,cname); 
  psmt.setDouble(4,wt15);
  psmt.setDouble(5,adwt5);
  psmt.setDouble(6,nondoc);    
  psmt.executeUpdate();
  }
  }
  catch(SQLException se){} 
   finally{
   try{
    if(rs1!=null){rs1.close();}
    if(psmt1!=null){psmt1.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return count;  
  } 
  
  public boolean cheque(String st,String st1){    
  Connection con=null;     
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="update cheque_details set status=? where id="+st;  
  try{    
  psmt=con.prepareStatement(qr1); 
  psmt.setString(1,st1);
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
  
  public HashMap chequeStatus(String p){   
         Connection con=null;
         int inc=10;
         int startIndex=1;
         int count = 0;
         try{
         startIndex=Integer.parseInt(p); 
         }
         catch(NumberFormatException ne){}          
         int increment = 1;
         int in=0; 
         int numRows=startIndex+inc+1;
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
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from cheque_details";    
   psmt2=con.prepareStatement(qr2);
   rs2=psmt2.executeQuery();
   rs2.next(); 
   in=rs2.getInt("cnt");
   int remain = numRows % inc;
   if(startIndex + inc <= numRows){
   increment = startIndex + inc;
   }
   else{
   increment = startIndex + remain;
   }
     String qr1="select id,dated,chequeno,amount,bankname,companyname,status from cheque_details"; 
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
  JavaBean jb=new JavaBean();
  jb.setId(rs.getString("id"));
  jb.setDated(rs.getString("dated"));
  jb.setChequeno(rs.getString("chequeno"));  
  jb.setAmount(rs.getDouble("amount"));
  jb.setBankname(rs.getString("bankname"));
  jb.setCompname(rs.getString("companyname"));  
  jb.setStatus(rs.getString("status"));
  ar.add(jb);  
  rs.next();
  } 
 }
catch(SQLException se){   
//if(startIndex != 1){
//ds=startIndex+"-"+in;        
//pn=new Integer(startIndex-inc).toString();
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
   if(startIndex + inc <= in){
ds=startIndex+"-"+(increment - 1);
}
else{
ds=startIndex+"-"+in;
}
if(startIndex != 1){
pre=new Integer(startIndex-inc).toString();
}
increment +=inc; 
if(startIndex + inc <=in){    
nxt=new Integer(startIndex+inc).toString();
}
   hm.put("arr",ar); 
   hm.put("fromto",ds);
   hm.put("previous",pre);
   hm.put("next",nxt);
   hm.put("stindex",new Integer(startIndex)); 
   return hm;   
    }    
    
   public boolean chequeDetails(JavaBean jb1){    
   Connection con=null;    
   String dat=jb1.getDated();
   String chqno=jb1.getChequeno();
   String bnknm=jb1.getBankname();
   double amt=jb1.getAmount();     
   String cname=jb1.getCompname();    
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="insert into cheque_details(chequeno,bankname,amount,companyname,dated,status,cleardate)values(?,?,?,?,?,?,?)";
  try{
  psmt=con.prepareStatement(qr1);  
  psmt.setString(1,chqno);
  psmt.setString(2,bnknm);
  psmt.setDouble(3,amt);
  psmt.setString(4,cname);
  psmt.setString(5,dat);
  psmt.setString(6,"pending");
  psmt.setString(7,"NC");
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
    
   public boolean allExpense(JavaBean jb1){   
  Connection con=null;     
  String dt=jb1.getDated();
  String det=jb1.getDetails();
  double amt=jb1.getAmount();
  String empn=jb1.getEmpname();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="insert into all_expenses(dated,detail,amount,empname)values(?,?,?,?)";
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);   
  psmt.setString(2,det); 
  psmt.setDouble(3,amt);
  psmt.setString(4,empn); 
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
    
  public boolean fuelExpense(JavaBean jb1){  
  Connection con=null;    
  String dt=jb1.getDated();
  String vno=jb1.getVehno();
  double stkm=jb1.getStartkm();
  double ekm=jb1.getEndkm();
  double tkm=jb1.getTotalkm();
  double amt=jb1.getFuelamt();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="insert into fuel_expenses(dated,vehicle_no,start_km,end_km,total_km,amount)values(?,?,?,?,?,?)";
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);
  psmt.setString(2,vno);
  psmt.setDouble(3,stkm);
  psmt.setDouble(4,ekm);
  psmt.setDouble(5,tkm);
  psmt.setDouble(6,amt);
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
    /////////////////////////////////////////////////////////////////////////////////// 
  public HashMap compSurface1(String p){   
      Connection con=null;
         int ins=10;
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
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from compsurfacecargo";
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
     String qr1="select id,dated,companyname,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from compsurfacecargo";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated")); 
  jb1.setCompname(rs.getString("companyname")); 
  jb1.setZone(rs.getString("zone"));
  jb1.setWt15(rs.getDouble("wt1_5kg"));
  jb1.setWt525(rs.getDouble("wt5_25kg"));
  jb1.setWt2550(rs.getDouble("wt25_50kg"));
  jb1.setWt50100(rs.getDouble("wt50_100kg"));
  jb1.setAbove100(rs.getDouble("wtabove100kg"));
  ar.add(jb1);  
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
   public ArrayList compSurface2(String id1){
       Connection con=null; 
   String id=id1;
   ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,companyname,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from compsurfacecargo where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated"));  
  jb1.setCompname(rs.getString("companyname")); 
  jb1.setZone(rs.getString("zone"));
  jb1.setWt15(rs.getDouble("wt1_5kg"));
  jb1.setWt525(rs.getDouble("wt5_25kg"));
  jb1.setWt2550(rs.getDouble("wt25_50kg"));
  jb1.setWt50100(rs.getDouble("wt50_100kg"));
  jb1.setAbove100(rs.getDouble("wtabove100kg"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
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
   public boolean compSurface3(JavaBean jb1){  
       Connection con=null; 
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String cname=jb1.getCompname();
  String zn=jb1.getZone();
  double wt1=jb1.getWt15();
  double wt2=jb1.getWt525();
  double wt3=jb1.getWt2550();  
  double wt4=jb1.getWt50100(); 
  double wt5=jb1.getAbove100(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="update compsurfacecargo set dated=?,zone=?,wt1_5kg=?,wt5_25kg=?,wt25_50kg=?,wt50_100kg=?,wtabove100kg=?,companyname=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);  
  psmt.setString(2,zn);
  psmt.setDouble(3,wt1);
  psmt.setDouble(4,wt2);
  psmt.setDouble(5,wt3);  
  psmt.setDouble(6,wt4);
  psmt.setDouble(7,wt5);
  psmt.setString(8,cname);
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
   public boolean deleteCompSurface(String id){
       Connection con=null; 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="delete from compsurfacecargo where id="+id;
  try{
  psmt=con.prepareStatement(qr1);  
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
   /////////////////////////////////////////////////////////////////////////////////////  
   public HashMap compAir1(String p){   
       Connection con=null; 
         int ins=10;
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
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from compaircargo";
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
     String qr1="select id,companyname,zone,weight1_5,addweight5,non_doc from compaircargo";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
    JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setCompname(rs.getString("companyname")); 
  jb1.setZone(rs.getString("zone"));
  jb1.setWt1_5(rs.getDouble("weight1_5"));
  jb1.setAdwt5(rs.getDouble("addweight5"));
  jb1.setNondoc(rs.getDouble("non_doc"));
  ar.add(jb1);   
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
   public JavaBean compAir2(String id1){
   Connection con=null; 
   JavaBean jb1=new JavaBean();  
   String id=id1;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
  String qr1="select id,companyname,zone,weight1_5,addweight5,non_doc from compaircargo where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){ 
  jb1.setId(rs.getString("id"));  
  jb1.setCompname(rs.getString("companyname")); 
  jb1.setZone(rs.getString("zone"));
  jb1.setWt1_5(rs.getDouble("weight1_5"));
  jb1.setAdwt5(rs.getDouble("addweight5"));
  jb1.setNondoc(rs.getDouble("non_doc"));
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}  
    if(con!=null){con.close();}      
   } 
   catch(SQLException se){}
   }
  return jb1; 
 }      
   public boolean compAir3(JavaBean jb1){  
       Connection con=null; 
  String id1=jb1.getId();   
  String cname=jb1.getCompname();
  String zn=jb1.getZone();
  double wt1=jb1.getWt1_5();
  double wt2=jb1.getAdwt5();
  double wt3=jb1.getNondoc();  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="update compaircargo set companyname=?,zone=?,weight1_5=?,addweight5=?,non_doc=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,cname);
  psmt.setString(2,zn); 
  psmt.setDouble(3,wt1);
  psmt.setDouble(4,wt2);
  psmt.setDouble(5,wt3);  
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
   public boolean deleteCompAir(String id){
       Connection con=null; 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="delete from compaircargo where id="+id;
  try{
  psmt=con.prepareStatement(qr1);  
  psmt.executeUpdate();
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true; 
 }
 //////////////////////////////////////////////////////////////////////////////////////    
   public HashMap compTarrif1(String p){   
       Connection con=null; 
         int ins=10;
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
   String qr2="select count(*) as cnt from comptarrifrate";
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
     String qr1="select id,companyname,zone,weight1_5,addweight5,non_doc from comptarrifrate";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setCompname(rs.getString("companyname")); 
  jb1.setZone(rs.getString("zone"));
  jb1.setWt1_5(rs.getDouble("weight1_5"));
  jb1.setAdwt5(rs.getDouble("addweight5"));
  jb1.setNondoc(rs.getDouble("non_doc"));
  ar.add(jb1);  
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
   public JavaBean compTarrif2(String id1){
   Connection con=null; 
   JavaBean jb1=new JavaBean(); 
   String id=id1;
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,companyname,zone,weight1_5,addweight5,non_doc from comptarrifrate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){  
  jb1.setId(rs.getString("id")); 
  jb1.setCompname(rs.getString("companyname"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt1_5(rs.getDouble("weight1_5"));
  jb1.setAdwt5(rs.getDouble("addweight5"));
  jb1.setNondoc(rs.getDouble("non_doc"));
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return jb1; 
 } 
   public boolean compTarrif3(JavaBean jb1){  
  Connection con=null; 
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String cname=jb1.getCompname();
  String zn=jb1.getZone();
  double wt1=jb1.getWt1_5();
  double wt2=jb1.getAdwt5();
  double wt3=jb1.getNondoc();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="update comptarrifrate set companyname=?,zone=?,weight1_5=?,addweight5=?,non_doc=? where id='"+id1+"'";
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,cname); 
  psmt.setString(2,zn);
  psmt.setDouble(3,wt1); 
  psmt.setDouble(4,wt2);  
  psmt.setDouble(5,wt3);  
  psmt.executeUpdate();
  }
  catch(SQLException se){}  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true;
  }  
   public boolean deleteCompTarrif(String id){
       Connection con=null; 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="delete from comptarrifrate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);  
  psmt.executeUpdate();
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true; 
 }
 ////////////////////////////////////////////////////////////////////////////////////// 
   public boolean updateBusRate(JavaBean jb1){  
       Connection con=null; 
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String zn=jb1.getZone();
  double wt1=jb1.getWt100();
  double wt2=jb1.getWt250();
  double wt5=jb1.getWt500();
  double adwt5=jb1.getAdwt500();  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="update busrate set dated=?,zone=?,weight250=?,weight500=?,addweight500=?,weight100=? where id='"+id1+"'";
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);  
  psmt.setString(2,zn);
  psmt.setDouble(3,wt2);
  psmt.setDouble(4,wt5);
  psmt.setDouble(5,adwt5);  
  psmt.setDouble(6,wt1); 
  psmt.executeUpdate();
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true;
  }   
   public ArrayList getBusRate(){ 
       Connection con=null; 
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,zone,weight100,weight250,weight500,addweight500 from busrate";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt100(rs.getDouble("weight100"));
  jb1.setWt250(rs.getDouble("weight250"));
  jb1.setWt500(rs.getDouble("weight500"));
  jb1.setAdwt500(rs.getDouble("addweight500"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  } 
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return ar;
  } 
   public ArrayList getData(String id1){
   Connection con=null; 
   String id=id1;
   ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,zone,weight100,weight250,weight500,addweight500 from busrate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id")); 
  jb1.setDated(rs.getString("dated"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt100(rs.getDouble("weight100"));
  jb1.setWt250(rs.getDouble("weight250"));
  jb1.setWt500(rs.getDouble("weight500"));
  jb1.setAdwt500(rs.getDouble("addweight500"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return ar; 
 }
 /////////////////////////////////////////////////////////////////////////////////////  
   public ArrayList airCargo(){   
       Connection con=null; 
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from aircargorate";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt15(rs.getDouble("wt1_5kg"));
  jb1.setWt525(rs.getDouble("wt5_25kg"));
  jb1.setWt2550(rs.getDouble("wt25_50kg"));
  jb1.setWt50100(rs.getDouble("wt50_100kg"));
  jb1.setAbove100(rs.getDouble("wtabove100kg"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  } 
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return ar;
  }      
     public boolean deleteAirData(String id){
         Connection con=null; 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="delete from aircargorate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);  
  psmt.executeUpdate();
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true; 
 }
     
     public boolean deleteSurfaceData(String id){
         Connection con=null; 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="delete from surfacecargorate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);  
  psmt.executeUpdate();
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true; 
 }
     
   public boolean deleteTarrifData(String id){
   Connection con=null; 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="delete from busrate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);  
  psmt.executeUpdate();
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true; 
 }
   
   public ArrayList showAirData(String id1){
       Connection con=null; 
   String id=id1;
   ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from aircargorate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt15(rs.getDouble("wt1_5kg"));
  jb1.setWt525(rs.getDouble("wt5_25kg"));
  jb1.setWt2550(rs.getDouble("wt25_50kg"));
  jb1.setWt50100(rs.getDouble("wt50_100kg"));
  jb1.setAbove100(rs.getDouble("wtabove100kg"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return ar; 
 }      
   public boolean updateAirRate(JavaBean jb1){  
       Connection con=null; 
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String zn=jb1.getZone();
  double wt1=jb1.getWt15();
  double wt2=jb1.getWt525();
  double wt3=jb1.getWt2550();  
  double wt4=jb1.getWt50100(); 
  double wt5=jb1.getAbove100(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="update aircargorate set dated=?,zone=?,wt1_5kg=?,wt5_25kg=?,wt25_50kg=?,wt50_100kg=?,wtabove100kg=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);  
  psmt.setString(2,zn);
  psmt.setDouble(3,wt1);
  psmt.setDouble(4,wt2);
  psmt.setDouble(5,wt3);  
  psmt.setDouble(6,wt4);
  psmt.setDouble(7,wt5);
  psmt.executeUpdate();
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true;
  }    
  /////////////////////////////////////////////////////////////////////////////////// 
  public ArrayList surfaceCargo(){  
      Connection con=null; 
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from surfacecargorate";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt15(rs.getDouble("wt1_5kg"));
  jb1.setWt525(rs.getDouble("wt5_25kg"));
  jb1.setWt2550(rs.getDouble("wt25_50kg"));
  jb1.setWt50100(rs.getDouble("wt50_100kg"));
  jb1.setAbove100(rs.getDouble("wtabove100kg"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  } 
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return ar;
  }      
   public ArrayList showSurfaceData(String id1){
       Connection con=null; 
   String id=id1;
   ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select id,dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from surfacecargorate where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated"));  
  jb1.setZone(rs.getString("zone"));
  jb1.setWt15(rs.getDouble("wt1_5kg"));
  jb1.setWt525(rs.getDouble("wt5_25kg"));
  jb1.setWt2550(rs.getDouble("wt25_50kg"));
  jb1.setWt50100(rs.getDouble("wt50_100kg"));
  jb1.setAbove100(rs.getDouble("wtabove100kg"));
  ar.add(jb1);
  }
  }  
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return ar; 
 }      
   public boolean updateSurfaceRate(JavaBean jb1){  
       Connection con=null; 
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String zn=jb1.getZone();
  double wt1=jb1.getWt15();
  double wt2=jb1.getWt525();
  double wt3=jb1.getWt2550();  
  double wt4=jb1.getWt50100(); 
  double wt5=jb1.getAbove100(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="update surfacecargorate set dated=?,zone=?,wt1_5kg=?,wt5_25kg=?,wt25_50kg=?,wt50_100kg=?,wtabove100kg=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);  
  psmt.setString(2,zn);
  psmt.setDouble(3,wt1);
  psmt.setDouble(4,wt2);
  psmt.setDouble(5,wt3);  
  psmt.setDouble(6,wt4);
  psmt.setDouble(7,wt5);
  psmt.executeUpdate();
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true;
  }      
  ///////////////////////////////////////////////////////////////////////////////////  
  public JavaBean rates(String b,String dest,double wt){ 
      Connection con=null; 
  JavaBean jb=new JavaBean();  
  AmountField af=new AmountField();
  String by="";
  if(b.equals("Domestic")){by="busrate";}   
  if(b.equals("Surface Cargo")){by="surfacecargorate";} 
  if(b.equals("Air Cargo")){by="aircargorate";}  
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String zn="";
  String qr1="select zone from destination where destination='"+dest+"' and companyname='ALL'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  zn=rs.getString("zone");    
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
  double amt=af.amtField(by,zn,wt);
  jb.setAmount(amt);
  jb.setZone(zn);
  return jb;
  } 
  public JavaBean modrates(String b,String zn,double wt){ 
  JavaBean jb=new JavaBean();  
  AmountField af=new AmountField();
  String by="";
  if(b.equals("Domestic")){by="busrate";}   
  if(b.equals("Surface Cargo")){by="surfacecargorate";} 
  if(b.equals("Air Cargo")){by="aircargorate";}  
  double amt=af.amtField(by,zn,wt);
  jb.setAmount(amt);
  jb.setZone(zn);
  return jb;
  } 
  public JavaBean crates(JavaBean jb){ 
  Connection con=null;   
  MyMethods mm=new MyMethods();
  AmountField af=new AmountField();
  String by="";
  if(jb.getBy().equals("Domestic")){by="comptarrifrate";}    
  if(jb.getBy().equals("Air Cargo")){by="compaircargo";} 
  //if(jb.getBy().equals("Surface Cargo")){by="compsurfacecargo";} 
  jb.setTable(by);
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
  String zn="";
 // zn=mm.zoneByDest(jb.getDest());
 // jb.setZone(zn);
  double amt=af.camtField(jb);
  jb.setAmount(amt);
  return jb;
    }  
  public JavaBean cmodrates(JavaBean jb){  
  MyMethods mm=new MyMethods();
  AmountField af=new AmountField();
  String by=jb.getBy();
  if(jb.getBy().equals("Domestic")){jb.setBy("comptarrifrate");}   
  if(jb.getBy().equals("Air Cargo")){jb.setBy("compaircargo");} 
  double amt=af.camtField(jb);
  jb.setBy(by);
  jb.setAmount(amt); 
  return jb;
  } 
  public JavaBean allZones(String b){ 
  Connection con=null; 
  JavaBean jb=new JavaBean();
  ArrayList ar=new ArrayList();
  String by=""; 
//   if(b.equals("Domestic")){by="busrate";}   
//   if(b.equals("Surface Cargo")){by="aircargorate";}   
//   if(b.equals("Air Cargo")){by="surfacecargorate";}
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="select distinct destination from destination";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  ar.add(rs.getString("destination"));    
  }
  jb.setZones(ar);
  jb.setBy(b);
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }
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
  
  public JavaBean callZones(String cn,String b){ 
      Connection con=null; 
  JavaBean jb=new JavaBean();
  ArrayList ar=new ArrayList(); 
   String by=""; 
//   if(b.equals("Domestic")){by="comptarrifrate";}   
//   if(b.equals("Surface Cargo")){by="compaircargo";}   
//   if(b.equals("Air Cargo")){by="compsurfacecargo";}
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="select distinct destination from destination";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  ar.add(rs.getString("destination"));    
  }
  jb.setCompname(cn);
  jb.setZones(ar);
  jb.setBy(b);
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }
   finally{
   try{
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return jb;
    }
  
  public int submitSingle(JavaBean jb1){  
      Connection con=null; 
  String dt=jb1.getDated();
  String cno=jb1.getCnno();
  String zn=jb1.getZone();
  double wt=jb1.getWeight();
  String by=jb1.getBy();
  String dest=jb1.getDest();  
  double amt=jb1.getAmount(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  int count=0,c1=0,c2=0,c3=0;
  String qr1="select count(cnno) as cnt from customerbilldata where cnno='"+cno+"'";
  String qr2="select count(cnno) as cnt from companybill where cnno='"+cno+"'";
  String qr3="select count(ccno) as cnt from comptopay_cod where ccno='"+cno+"'";
  try{
  psmt1=con.prepareStatement(qr1);
  rs1=psmt1.executeQuery();
  rs1.next();
  c1=rs1.getInt("cnt");  
  psmt2=con.prepareStatement(qr2);
  rs2=psmt2.executeQuery();
  rs2.next();
  c2=rs2.getInt("cnt");  
  psmt3=con.prepareStatement(qr3);
  rs3=psmt3.executeQuery();
  rs3.next();
  c3=rs3.getInt("cnt");
  count=c1+c2+c3; 
  String qr4="insert into customerbilldata(bby,dated,cnno,zone,weight,destination,amount)values(?,?,?,?,?,?,?)";
   psmt=con.prepareStatement(qr4);
   if(c1==0 && c2==0 && c3==0){
   psmt.setString(1,by);
   psmt.setString(2,dt);
   psmt.setString(3,cno);
   psmt.setString(4,zn);
   psmt.setDouble(5,wt);
   psmt.setString(6,dest);
   psmt.setDouble(7,amt);
   psmt.executeUpdate();
   }
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }  
   finally{
   try{
    if(rs1!=null){rs1.close();}    
    if(rs2!=null){rs2.close();} 
    if(rs3!=null){rs3.close();} 
    if(psmt1!=null){psmt1.close();} 
    if(psmt2!=null){psmt2.close();} 
    if(psmt3!=null){psmt3.close();} 
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return count; 
  //by+" "+dt+" "+cno+" "+zn+" "+wt+" "+dest+" "+amt;
    }
  public int subCompBill(JavaBean jb1){ 
  Connection con=null;      
  MyMethods mm=new MyMethods();    
  AmountField af=new AmountField();
  String cn=jb1.getCompname();    
  String dt=jb1.getDated();
  String cno=jb1.getCnno();
  String zn=jb1.getZone();
  double wt=jb1.getWeight();
  String by=jb1.getBy();
  String dest=jb1.getDest();  
  double amt=jb1.getAmount(); 
  double stax=0.0;
  //stax=mm.serviceTax(amt);
  double fcharge=0.0;
 // fcharge=mm.fuelCharge(cn,amt);
  //fcharge=mm.fuelCharge(jb1);
  double compcharge=0.0;
  compcharge=af.superCharge(cn,by,zn,wt);
  //compcharge=af.superCharge(jb1);
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
  int count=0,c1=0,c2=0,c3=0,c4=0;
  String qr1="select count(cnno) as cnt from customerbilldata where cnno='"+jb1.getCnno()+"'";
  String qr2="select count(cnno) as cnt from companybill where cnno='"+jb1.getCnno()+"'";
  String qr3="select count(ccno) as cnt from comptopay_cod where ccno='"+jb1.getCnno()+"'";
  String qr5="select count(ccno) as cnt from topay_cod where ccno='"+jb1.getCnno()+"'";
  try{
  psmt1=con.prepareStatement(qr1);
  rs1=psmt1.executeQuery();
  rs1.next();
  c1=rs1.getInt("cnt");  
  psmt2=con.prepareStatement(qr2);
  rs2=psmt2.executeQuery();
  rs2.next();
  c2=rs2.getInt("cnt");  
  psmt3=con.prepareStatement(qr3);
  rs3=psmt3.executeQuery();
  rs3.next();
  c3=rs3.getInt("cnt");
  psmt4=con.prepareStatement(qr5);
  rs4=psmt4.executeQuery();
  rs4.next();
  c4=rs4.getInt("cnt");
   count=c1+c2+c3+c4;
   String qr6="insert into receiverdetail(cnno,consignee,address1,address2,city,country,telephone,fax)values(?,?,?,?,?,?,?,?)";
   String qr4="insert into companybill(bby,dated,cnno,zone,weight,destination,amount,companyname,staxamt,status,fuelcharge,paytocompany,mode,courierid,non_doc,del_status,reason,type,airwayno)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   psmt5=con.prepareStatement(qr6);
   psmt=con.prepareStatement(qr4);
   if(c1==0 && c2==0 && c3==0 && c4==0){
   psmt5.setString(1,jb1.getCnno());
   psmt5.setString(2,jb1.getConsignee());
   psmt5.setString(3,jb1.getAddress1());
   psmt5.setString(4,jb1.getAddress2());
   psmt5.setString(5,jb1.getCity());
   psmt5.setString(6,jb1.getCountry());
   psmt5.setString(7,jb1.getTelephone());
   psmt5.setString(8,jb1.getFax());
   psmt5.executeUpdate();
   psmt.setString(1,jb1.getBy());
   psmt.setString(2,jb1.getDated());
   psmt.setString(3,jb1.getCnno());
   psmt.setString(4,jb1.getZone());
   psmt.setDouble(5,jb1.getWeight());
   psmt.setString(6,jb1.getDest());
   psmt.setDouble(7,jb1.getAmount());
   psmt.setString(8,jb1.getCompname());
   psmt.setDouble(9,jb1.getStax());
   psmt.setString(10,"unpaid");
   psmt.setDouble(11,fcharge);
   psmt.setDouble(12,compcharge);
   psmt.setString(13,jb1.getMode());
   psmt.setString(14,jb1.getCourierId());
   psmt.setDouble(15,jb1.getNondoc());
   psmt.setString(16,"PENDING");
   psmt.setString(17,"NEW");
   psmt.setString(18,jb1.getType());
   psmt.setString(19,jb1.getAirwayNo());
   psmt.executeUpdate();
   }
  }
  catch(SQLException se){}  
   finally{
   try{
    if(rs1!=null){rs1.close();}  
    if(rs2!=null){rs2.close();} 
    if(rs3!=null){rs3.close();} 
    if(rs4!=null){rs4.close();} 
    if(rs5!=null){rs5.close();} 
    if(psmt1!=null){psmt1.close();} 
    if(psmt2!=null){psmt2.close();} 
    if(psmt3!=null){psmt3.close();} 
    if(psmt4!=null){psmt4.close();} 
    if(psmt!=null){psmt.close();} 
    if(psmt5!=null){psmt5.close();} 
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return count; 
   }   
  
   public JavaBean relianceZones(String cn,String b){ 
       Connection con=null; 
  JavaBean jb=new JavaBean();
  ArrayList ar=new ArrayList(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="select distinct zone from reliancesurfacerate where companyname='RELIANCE'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  ar.add(rs.getString("zone"));    
  }
  jb.setCompname(cn);
  jb.setZones(ar);
  jb.setBy(b);
  }
  catch(SQLException se){
  System.out.println(se.getMessage());    
  }
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
   
  public JavaBean relianceRates(String cname,String b,String zn,double wt){ 
  JavaBean jb=new JavaBean();  
  AmountField af=new AmountField();
  String by="";
  double amt=0.0;
  amt=af.relianceAmtField(cname,zn,wt);
  jb.setAmount(amt);
  return jb;
    }  
 ///////////////////////////////////////////////////////////////////////////////////// 
//  public int compSurfaceCargo(JavaBean jb1){  
//  Connection con=null;    
//  int count=0;
//  String dt=jb1.getDated();
//  String cname=jb1.getCompname();
//  String zn=jb1.getZone();
//  double wt1=jb1.getWt15();
//  double wt2=jb1.getWt525();
//  double wt3=jb1.getWt2550();  
//  double wt4=jb1.getWt50100();
//  double wt5=jb1.getAbove100();  
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }
//  catch(Exception e){
//  System.out.println(e.getMessage());    
//  }
//  String qr="select count(*) as cnt from compsurfacecargo where companyname='"+cname+"' and zone='"+zn+"'";
//  String qr1="insert into compsurfacecargo(dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg,companyname)values(?,?,?,?,?,?,?,?)";
//  try{
//  psmt1=con.prepareStatement(qr);    
//  rs1=psmt1.executeQuery();
//  rs1.next();
//  count=rs1.getInt("cnt");    
//  psmt=con.prepareStatement(qr1);
//  if(count==0){
//  psmt.setString(1,dt);  
//  psmt.setString(2,zn);
//  psmt.setDouble(3,wt1);
//  psmt.setDouble(4,wt2);
//  psmt.setDouble(5,wt3);  
//  psmt.setDouble(6,wt4);
//  psmt.setDouble(7,wt5);
//  psmt.setString(8,cname);
//  psmt.executeUpdate();
//  }
//  }
//  catch(SQLException se){
//  System.out.println(se.getMessage());    
//  }  
//   finally{
//   try{
//    if(rs1!=null){rs1.close();}
//    if(psmt1!=null){psmt1.close();}   
//    if(psmt!=null){psmt.close();}    
//    if(con!=null){con.close();}        
//   } 
//   catch(SQLException se){}
//   }
//  return count;
//  }    
//  public boolean busRate(JavaBean jb1){  
//  Connection con=null;    
//  String dt=jb1.getDated();
//  String zn=jb1.getZone();
//  double wt1=jb1.getWt100();
//  double wt2=jb1.getWt250();
//  double wt5=jb1.getWt500();
//  double adwt5=jb1.getAdwt500();  
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }
//  catch(Exception e){
//  System.out.println(e.getMessage());    
//  }
//  String qr1="insert into busrate(dated,zone,weight250,weight500,addweight500,weight100)values(?,?,?,?,?,?)";
//  try{
//  psmt=con.prepareStatement(qr1);
//  psmt.setString(1,dt);  
//  psmt.setString(2,zn);
//  psmt.setDouble(3,wt2);
//  psmt.setDouble(4,wt5);
//  psmt.setDouble(5,adwt5);  
//  psmt.setDouble(6,wt1); 
//  psmt.executeUpdate();
//  }
//  catch(SQLException se){
//  System.out.println(se.getMessage());    
//  }  
//   finally{
//   try{
//    if(psmt!=null){psmt.close();}  
//    if(con!=null){con.close();}      
//   } 
//   catch(SQLException se){}
//   }
//  return true;
//  } 
//  public boolean airCargoRate(JavaBean jb1){  
//  Connection con=null;    
//  String dt=jb1.getDated();
//  String zn=jb1.getZone();
//  double wt1=jb1.getWt15();
//  double wt2=jb1.getWt525();
//  double wt3=jb1.getWt2550();  
//  double wt4=jb1.getWt50100();
//  double wt5=jb1.getAbove100();        
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }
//  catch(Exception e){
//  System.out.println(e.getMessage());    
//  }
//  String qr1="insert into aircargorate(dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg)values(?,?,?,?,?,?,?)";
//  try{
//  psmt=con.prepareStatement(qr1);
//  psmt.setString(1,dt);  
//  psmt.setString(2,zn);
//  psmt.setDouble(3,wt1);
//  psmt.setDouble(4,wt2);
//  psmt.setDouble(5,wt3);  
//  psmt.setDouble(6,wt4);
//  psmt.setDouble(7,wt5); 
//  psmt.executeUpdate();
//  }
//  catch(SQLException se){
//  System.out.println(se.getMessage());    
//  }  
//   finally{
//   try{  
//    if(psmt!=null){psmt.close();}  
//    if(con!=null){con.close();}      
//   } 
//   catch(SQLException se){}
//   }
//  return true;
//  }   
//  public boolean surfaceCargoRate(JavaBean jb1){  
//  Connection con=null;    
//  String dt=jb1.getDated();
//  String zn=jb1.getZone();
//  double wt1=jb1.getWt15();
//  double wt2=jb1.getWt525();
//  double wt3=jb1.getWt2550();  
//  double wt4=jb1.getWt50100();
//  double wt5=jb1.getAbove100();  
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }
//  catch(Exception e){
//  System.out.println(e.getMessage());    
//  }
//  String qr1="insert into surfacecargorate(dated,zone,wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg)values(?,?,?,?,?,?,?)";
//  try{
//  psmt=con.prepareStatement(qr1);
//  psmt.setString(1,dt);  
//  psmt.setString(2,zn);
//  psmt.setDouble(3,wt1);
//  psmt.setDouble(4,wt2);
//  psmt.setDouble(5,wt3);  
//  psmt.setDouble(6,wt4);
//  psmt.setDouble(7,wt5);  
//  psmt.executeUpdate();
//  }
//  catch(SQLException se){
//  System.out.println(se.getMessage());    
//  }  
//   finally{
//   try{
//    if(psmt!=null){psmt.close();}  
//    if(con!=null){con.close();}      
//   } 
//   catch(SQLException se){}
//   }
//  return true;
//  }  
  
}


