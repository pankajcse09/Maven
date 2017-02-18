package com.myapp.struts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DataObject2 {   
    
    static PreparedStatement psmt=null; 
    static PreparedStatement psmt1=null;
    static PreparedStatement psmt2=null; 
    static PreparedStatement psmt3=null; 
    static PreparedStatement psmt4=null; 
    static ResultSet rs=null;  
    static ResultSet rs1=null; 
    static ResultSet rs2=null;    
    static ResultSet rs3=null; 
    static ResultSet rs4=null;
  
    /** Creates a new instance of DataObject2 */
    public DataObject2() {
    }
  /////////////////////////////////////////////////////////////////////////////////////  
   public boolean deleteAllExpense(String pr){ 
       Connection con=null;
        try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
  try{    
  String qr1="delete from all_expenses where id="+pr;    
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
   public HashMap allExpUpdate1(String p,String dt1,String dt2){   
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
   String qr2="select count(*) as cnt from all_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
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
     String qr1="select id,dated,detail,amount,empname from all_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setDetails(rs.getString("detail")); 
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setEmpname(rs.getString("empname"));
  ar.add(jb1);   
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
   public ArrayList allExpUpdate2(String id1){
       Connection con=null;
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
   String id=id1;
   ArrayList ar=new ArrayList();
  String qr1="select id,dated,detail,amount,empname from all_expenses where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
   jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setDetails(rs.getString("detail")); 
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setEmpname(rs.getString("empname"));
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
   public boolean allExpUpdate3(JavaBean jb1){  
     Connection con=null;
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String det=jb1.getDetails();  
  double amt=jb1.getAmount();
  String ename=jb1.getEmpname();
  String qr1="update all_expenses set dated=?,detail=?,amount=?,empname=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);    
  psmt.setString(2,det);
  psmt.setDouble(3,amt);
  psmt.setString(4,ename);
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
  /////////////////////////////////////////////////////////////////////////////////////  
   public HashMap fuelExpUpdate1(String p,String dt1,String dt2){  
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
   String qr2="select count(*) as cnt from fuel_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
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
     String qr1="select id,dated,start_km,end_km,total_km,amount,vehicle_no from fuel_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";    
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setStartkm(rs.getDouble("start_km")); 
  jb1.setEndkm(rs.getDouble("end_km"));
  jb1.setTotalkm(rs.getDouble("total_km"));
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setVehno(rs.getString("vehicle_no"));
  ar.add(jb1);  
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
   public boolean deleteFuelExpense(String pr){  
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
//  ArrayList ar=new ArrayList();  
  try{    
  String qr1="delete from fuel_expenses where id="+pr;    
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
   public ArrayList fuelExpUpdate2(String id1){
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
   String id=id1;
   ArrayList ar=new ArrayList();
  String qr1="select id,dated,start_km,end_km,total_km,amount,vehicle_no from fuel_expenses where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setStartkm(rs.getDouble("start_km")); 
  jb1.setEndkm(rs.getDouble("end_km"));
  jb1.setTotalkm(rs.getDouble("total_km"));
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setVehno(rs.getString("vehicle_no"));
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
   public boolean fuelExpUpdate3(JavaBean jb1){  
     Connection con=null;
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String vehno=jb1.getVehno();  
  double skm=jb1.getStartkm();
  double ekm=jb1.getEndkm();
  double tkm=jb1.getTotalkm();
  double amt=jb1.getAmount();  
  String qr1="update fuel_expenses set dated=?,vehicle_no=?,start_km=?,end_km=?,total_km=?,amount=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);    
  psmt.setString(2,vehno);
  psmt.setDouble(3,skm);
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
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return true;
  }  
 //////////////////////////////////////////////////////////////////////////////  
   public ArrayList expenses(String dt1,String dt2){
      Connection con=null;
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   ArrayList ar=new ArrayList();
  String qr1="select id,dated,detail,amount,empname from all_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setDetails(rs.getString("detail")); 
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setEmpname(rs.getString("empname"));
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
   
    public ArrayList vehicleFuel(String dt1,String dt2){
      Connection con=null;
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
   ArrayList ar=new ArrayList();
  String qr1="select id,dated,vehicle_no,start_km,end_km,total_km,amount from fuel_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
         // "dated>='"+dt1+"' and dated<='"+dt2+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setVehno(rs.getString("vehicle_no")); 
  jb1.setStartkm(rs.getDouble("start_km"));
  jb1.setEndkm(rs.getDouble("end_km"));
  jb1.setTotalkm(rs.getDouble("total_km"));
  jb1.setAmount(rs.getDouble("amount"));
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
  public String totalCash(String dt1,String dt2){
   Connection con=null;
   double amt=0.0;   
   double tamt=0.0;   
   String totamt="";
  try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }   
   String qr1="select amount from customerbilldata where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";   
   try{
   psmt=con.prepareStatement(qr1);
   rs=psmt.executeQuery();
   while(rs.next()){
   amt=rs.getDouble("amount");    
   tamt=tamt+amt;
   }  
   totamt=new Double(tamt).toString();
   }
   catch(SQLException se){}
   return totamt;
  }           
   public HashMap cashReport(String p,String dt1,String dt2){
      Connection con=null;
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
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(*) as cnt from customerbilldata where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
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
     String qr1="select bid,cnno,dated,amount from customerbilldata where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
 for(count = startIndex; count < increment; count++){ 
 JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("bid"));  
  jb1.setCnno(rs.getString("cnno")); 
  jb1.setDated(rs.getString("dated"));  
  jb1.setAmount(rs.getDouble("amount"));
  ar.add(jb1);  
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
 
  public boolean consignIssued(JavaBean jb,long ton){   
     Connection con=null;
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
     try{
      long fno=0;
      String qr3="select fromno as fromn from balancedconsign where fromno="+jb.getFromno();
      psmt3=con.prepareStatement(qr3);
      rs=psmt3.executeQuery();
      while(rs.next()){
      fno=rs.getLong("fromn");      
      }   
      String qr1="insert into issuedconsign(dated,empname,fromno,tono)values(?,?,?,?)";   
      psmt=con.prepareStatement(qr1);
      psmt.setString(1,jb.getDated());
      psmt.setString(2,jb.getEmpname());   
      psmt.setLong(3,jb.getFromno());
      psmt.setLong(4,jb.getTono());
      psmt.executeUpdate();      
      
      String qr5="insert into issuedbalance(dated,empname,fromno,tono)values(?,?,?,?)";   
      psmt4=con.prepareStatement(qr5);
      psmt4.setString(1,jb.getDated());
      psmt4.setString(2,jb.getEmpname());  
      psmt4.setLong(3,jb.getFromno());
      psmt4.setLong(4,jb.getTono());
      psmt4.executeUpdate();
     
      if(jb.getTono()<ton){
      String qr2="update balancedconsign set fromno=? where fromno="+fno;
      psmt2=con.prepareStatement(qr2);     
      psmt2.setLong(1,1+jb.getTono());     
      psmt2.executeUpdate(); 
      }
      else{
      String qr4="delete from balancedconsign where fromno="+fno;
      psmt2=con.prepareStatement(qr4);     
      psmt2.executeUpdate();    
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
     return true;   
 }  
  
  public HashMap consignData(String p){
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
   String qr2="select count(*) as cnt from balancedconsign";           
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
     String qr1="select id,dated,series,fromno,tono from balancedconsign order by fromno";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setSeries(rs.getString("series"));
  jb1.setFromno(rs.getLong("fromno")); 
  jb1.setTono(rs.getLong("tono"));
  ar.add(jb1);  
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
  
    public HashMap issuedConsignData(String p,String dt1,String dt2){
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
   String qr2="select count(*) as cnt from issuedconsign where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
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
     String qr1="select id,dated,empname,series,fromno,tono from issuedconsign where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setEmpname(rs.getString("empname"));
  jb1.setSeries(rs.getString("series"));
  jb1.setFromno(rs.getLong("fromno")); 
  jb1.setTono(rs.getLong("tono"));
  ar.add(jb1);
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
    
  public HashMap allConsignData(String p,String dt1,String dt2){
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
   String qr2="select count(*) as cnt from consignment where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
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
    String qr1="select id,dated,series,fromno,tono from consignment where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setSeries(rs.getString("series"));
  jb1.setFromno(rs.getLong("fromno")); 
  jb1.setTono(rs.getLong("tono"));
  ar.add(jb1);  
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
      
 public boolean paymentDetails(JavaBean2 jb,String dt1,String dt2){
     Connection con=null;
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
  String dt="";
  String qr1="insert into companytopay(dated,companyname,amtpaidtill,amounttopay,baltopay,amountpaid,baddebth,balance,badreason)values(?,?,?,?,?,?,?,?,?)";
  try{
   psmt=con.prepareStatement(qr1);    
   psmt.setString(1,jb.getDated());
   psmt.setString(2,jb.getCompname());
   psmt.setString(3,jb.getAmtdat());
   psmt.setDouble(4,jb.getAmttopay());
   psmt.setDouble(5,jb.getBaltopay());
   psmt.setDouble(6,jb.getAmtpaid());
   psmt.setDouble(7,jb.getBaddebth());
   psmt.setDouble(8,jb.getBalance());
   psmt.setString(9,jb.getReason());
   psmt.executeUpdate();  
   
   String qr2="select dated from companybill where companyname='"+jb.getCompname()+"' and (str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y'))";
   psmt2=con.prepareStatement(qr2);
   rs=psmt2.executeQuery();
   while(rs.next()){
   dt=rs.getString("dated");       
   String qr3="update companybill set status='paid' where companyname='"+jb.getCompname()+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+dt+"','%d/%m/%Y')";
   psmt3=con.prepareStatement(qr3);   
   psmt3.executeUpdate();
   }
  }   
  catch(SQLException se){}
   finally{
   try{
    if(psmt!=null){psmt.close();}    
    if(psmt2!=null){psmt2.close();}    
    if(psmt3!=null){psmt3.close();} 
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
 return true;    
 }   
 
 public ArrayList trackConsignNo(String cno){      
    Connection con=null;
     long frno=0;
     long tono=0;
     long cnno=0;
        try {
          cnno=Long.parseLong(cno);
         }catch(NumberFormatException ex) {}
          try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
  ArrayList ar=new ArrayList();
  JavaBean jb1=new JavaBean(); 
  String qr1="select * from issuedconsign";
   try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  frno=rs.getLong("fromno");
  tono=rs.getLong("tono");
  if((cnno>frno && cnno<tono) || (cnno==frno) || (cnno==tono)){
  jb1.setId(rs.getString("id"));  
  jb1.setDated(rs.getString("dated")); 
  jb1.setEmpname(rs.getString("empname"));
  jb1.setCnno(cno);
  ar.add(jb1);
  break;    
  }
  else{
  continue;    
  }  
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
 
 public JavaBean trackData(String cno){
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
  JavaBean jb1=new JavaBean(); 
  String qr2="select * from companybill where cnno='"+cno+"'";
  String qr3="select * from receiverdata where cnno='"+cno+"'";
  try{
  psmt2=con.prepareStatement(qr2);
  rs2=psmt2.executeQuery();
  if(rs2.next()){
  jb1.setId(rs2.getString("id"));    
  jb1.setBy(rs2.getString("bby")); 
  jb1.setDated(rs2.getString("dated")); 
  jb1.setCompname(rs2.getString("companyname")); 
  jb1.setCnno(rs2.getString("cnno"));
  jb1.setZone(rs2.getString("zone"));
  jb1.setWeight(rs2.getDouble("weight"));
  jb1.setDest(rs2.getString("destination"));  
  jb1.setAmount(rs2.getDouble("amount"));
  //jb1.setStax(rs2.getDouble("staxamt"));
  jb1.setFcharge(rs2.getDouble("fuelcharge"));   
  jb1.setMode(rs2.getString("mode"));
  jb1.setCourierId(rs2.getString("courierid"));
  jb1.setNondoc(rs2.getDouble("non_doc"));
  jb1.setDe_status(rs2.getString("del_status"));
  jb1.setReason(rs2.getString("reason"));
  psmt3=con.prepareStatement(qr3);
  rs3=psmt3.executeQuery();
  jb1.setConsignee(rs3.getString("consignee"));
  jb1.setAddress1(rs3.getString("address1"));
  jb1.setAddress2(rs3.getString("address2"));
  jb1.setCity(rs3.getString("city"));
  jb1.setCountry(rs3.getString("country"));
  jb1.setTelephone(rs3.getString("telephone"));
  jb1.setFax(rs3.getString("fax"));
  }
  } 
  catch(SQLException se){}  
   finally{
   try{
    if(rs!=null){rs.close();}       
    if(rs2!=null){rs2.close();}  
//  if(rs3!=null){rs3.close();}   
    if(rs4!=null){rs4.close();}    
    if(psmt!=null){psmt.close();} 
    if(psmt2!=null){psmt2.close();} 
//  if(psmt3!=null){psmt3.close();} 
    if(psmt4!=null){psmt4.close();}       
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
  return jb1; 
 }
 /////////////////////////////////////////////////////////////////
    
 public boolean upTax(double tx){    
   Connection con=null;
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="update govtservicetax set servicetax=?"; 
  try{
   psmt=con.prepareStatement(qr1);
   psmt.setDouble(1,tx);
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
 
 ///////////////////////////////////////////////////////////////////
 
   public JavaBean allZonesToPay(String by){
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
  String qr1="select distinct destination from destination";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  ar.add(rs.getString("destination"));    
  }
  jb.setZones(ar);
  jb.setBy(by);
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
   
   public JavaBean ratesToPay(String by,String dest,double wt){
   JavaBean jb=new JavaBean();
  AmountField af=new AmountField();
  double amt=af.amtField(by,dest,wt);
  jb.setAmount(amt);
   return jb;
   } 
 
   public int toPayCod(JavaBean jb1){    
       Connection con=null;
   String dat=jb1.getDated();
   String cno=jb1.getCnno();
   String pname=jb1.getPartyname();
   double wt=jb1.getWeight();            
   String dest=jb1.getDest();
   double topay=jb1.getTopay();
   double cod=jb1.getCod();
   String recptno=jb1.getRecptno();
   double collctn=jb1.getCollection();    
   String by=jb1.getBy();
   String zone=jb1.getZone();
  
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  int count=0,c1=0,c2=0,c3=0,c4=0; 
    String qr1="select count(cnno) as cnt from customerbilldata where cnno='"+cno+"'";
  String qr2="select count(cnno) as cnt from companybill where cnno='"+cno+"'";
  String qr3="select count(ccno) as cnt from comptopay_cod where ccno='"+cno+"'";
  String qr5="select count(ccno) as cnt from topay_cod where ccno='"+cno+"'";
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
  String qr="insert into topay_cod(dated,ccno,partyname,weight,destination,topayamt,codamt,receiptno,collection,bby,zone)values(?,?,?,?,?,?,?,?,?,?,?)";
  psmt=con.prepareStatement(qr);
  if(c1==0 && c2==0 && c3==0 && c4==0){
  psmt.setString(1,dat);
  psmt.setString(2,cno);
  psmt.setString(3,pname);
  psmt.setDouble(4,wt);
  psmt.setString(5,dest);
  psmt.setDouble(6,topay);
  psmt.setDouble(7,cod);
  psmt.setString(8,recptno);
  psmt.setDouble(9,collctn);  
  psmt.setString(10,by);  
  psmt.setString(11,zone);  
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
    if(rs4!=null){rs4.close();} 
    if(psmt1!=null){psmt1.close();} 
    if(psmt2!=null){psmt2.close();} 
    if(psmt3!=null){psmt3.close();} 
    if(psmt4!=null){psmt4.close();}    
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   return count;    
   } 
   //////////////////////////////////////////////////////////////////////
   
  public boolean updateToPayData(JavaBean jb1){  
      Connection con=null;
          try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
    boolean bn=false;   
    String qr1="update topay_cod set partyname=?,weight=?,destination=?,topayamt=?,codamt=?,receiptno=?,collection=?,bby=?,zone=? where id="+jb1.getId();
    try{
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb1.getPartyname());     
     psmt.setDouble(2,jb1.getWeight()); 
     psmt.setString(3,jb1.getDest()); 
     psmt.setDouble(4,jb1.getTopay()); 
     psmt.setDouble(5,jb1.getCod()); 
     psmt.setString(6,jb1.getRecptno()); 
     psmt.setDouble(7,jb1.getCollection()); 
     psmt.setString(8,jb1.getBy()); 
     psmt.setString(9,jb1.getZone()); 
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
  
  public int deleteToPayData(JavaBean jb1){  
      Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }   
     JavaBean jb=new JavaBean();       
     int count=0;  
     
     try{
     String qr2="select ccno from topay_cod where id="+jb1.getId();      
     psmt=con.prepareStatement(qr2);
     rs=psmt.executeQuery();
     if(rs.next()){
     jb.setCnno(rs.getString("ccno"));  
     }  
     
     String qr1="delete from topay_cod where id="+jb1.getId();    
     psmt1=con.prepareStatement(qr1);
     psmt1.executeUpdate();
     
     String qr4="select * from issuedconsign where convert(substr('"+jb.getCnno()+"',2,9),unsigned) between fromno and tono and series=substr('"+jb.getCnno()+"',1,1)";
     psmt3=con.prepareStatement(qr4);
     rs3=psmt3.executeQuery();
     if(rs3.next()){
     jb.setDated(rs3.getString("dated"));
     jb.setEmpname(rs3.getString("empname"));
     jb.setSeries(rs3.getString("series"));
     }
     
     String qr3="insert into issuedbalance(dated,empname,series,fromno,tono)values(?,?,?,?,?)";      
     psmt2=con.prepareStatement(qr3);
     psmt2.setString(1,jb.getDated());
     psmt2.setString(2,jb.getEmpname());
     psmt2.setString(3,jb.getSeries());
     psmt2.setString(4,jb.getCnno().substring(1));
     psmt2.setString(5,jb.getCnno().substring(1));     
     psmt2.executeUpdate();
     }
     catch(SQLException se){count=-1;}
     finally{
   try{    
    if(rs!=null){rs.close();}    
    if(rs3!=null){rs3.close();}   
    if(psmt!=null){psmt.close();}     
    if(psmt1!=null){psmt1.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt3!=null){psmt3.close();}
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return count;
   } 
  
   public boolean updateCompToPayData(JavaBean jb1){  
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
    boolean bn=false;   
    String qr1="update comptopay_cod set partyname=?,weight=?,destination=?,topayamt=?,codamt=?,receiptno=?,collection=?,bby=?,zone=?,companyname=? where id="+jb1.getId();
    try{
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb1.getPartyname());     
     psmt.setDouble(2,jb1.getWeight()); 
     psmt.setString(3,jb1.getDest()); 
     psmt.setDouble(4,jb1.getTopay()); 
     psmt.setDouble(5,jb1.getCod()); 
     psmt.setString(6,jb1.getRecptno()); 
     psmt.setDouble(7,jb1.getCollection()); 
     psmt.setString(8,jb1.getBy()); 
     psmt.setString(9,jb1.getZone()); 
     psmt.setString(10,jb1.getCompname());
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
   
  public int deleteCompToPayData(JavaBean jb1){  
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }   
     JavaBean jb=new JavaBean();       
     int count=0;  
     
     try{
     String qr2="select ccno from comptopay_cod where id="+jb1.getId();      
     psmt=con.prepareStatement(qr2);
     rs=psmt.executeQuery();
     if(rs.next()){
     jb.setCnno(rs.getString("ccno"));  
     }  
     
     String qr1="delete from comptopay_cod where id="+jb1.getId();    
     psmt1=con.prepareStatement(qr1);
     psmt1.executeUpdate();
     
     String qr4="select * from issuedconsign where convert(substr('"+jb.getCnno()+"',2,9),unsigned) between fromno and tono and series=substr('"+jb.getCnno()+"',1,1)";
     psmt3=con.prepareStatement(qr4);
     rs3=psmt3.executeQuery();
     if(rs3.next()){
     jb.setDated(rs3.getString("dated"));
     jb.setEmpname(rs3.getString("empname"));
     jb.setSeries(rs3.getString("series"));
     }
     
     String qr3="insert into issuedbalance(dated,empname,series,fromno,tono)values(?,?,?,?,?)";      
     psmt2=con.prepareStatement(qr3);
     psmt2.setString(1,jb.getDated());
     psmt2.setString(2,jb.getEmpname());
     psmt2.setString(3,jb.getSeries());
     psmt2.setString(4,jb.getCnno().substring(1));
     psmt2.setString(5,jb.getCnno().substring(1));     
     psmt2.executeUpdate();
     }
     catch(SQLException se){count=-1;}
     finally{
   try{    
    if(rs!=null){rs.close();}    
    if(rs3!=null){rs3.close();}   
    if(psmt!=null){psmt.close();}     
    if(psmt1!=null){psmt1.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt3!=null){psmt3.close();}
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return count;
   } 
  
 public int addComp(JavaBean jb1){  
 Connection con=null;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    int in=0;
    String qr="select count(comp_name) as cnt from companydetails where comp_name='"+jb1.getCompname()+"' or customerno='"+jb1.getCustomerNo()+"'";    
    String qr1="insert into companydetails(comp_name,comp_address,comp_phno1,comp_phno2,actype,customerno,city,state,country,zipcode)values(?,?,?,?,?,?,?,?,?,?)";
    try{
     psmt2=con.prepareStatement(qr); 
     rs2=psmt2.executeQuery();
     rs2.next();
     in=rs2.getInt("cnt");
     if(in==0){
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb1.getCompname());     
     psmt.setString(2,jb1.getCompadd());  
     psmt.setString(3,jb1.getPhno1()); 
     psmt.setString(4,jb1.getPhno2()); 
     psmt.setString(5,jb1.getActype()); 
     psmt.setString(6,jb1.getCustomerNo()); 
     psmt.setString(7,jb1.getCity()); 
     psmt.setString(8,jb1.getState()); 
     psmt.setString(9,jb1.getCountry()); 
     psmt.setString(10,jb1.getZipcode()); 
     psmt.executeUpdate();
     }
     }
     catch(SQLException se){}
     finally{
     try{   
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
    } 
   catch(SQLException se){}
   }
    return in;
   } 
    
  public HashMap updateCompDetails(String p){   
       Connection con=null;
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
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   ArrayList ar=new ArrayList();  
   HashMap hm=new HashMap();
   HashSet hs=new HashSet();
   try{
   String qr2="select count(comp_name) as cnt from companydetails";
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
     String qr1="select * from companydetails";  
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
for(count = startIndex; count < increment; count++){ 
     JavaBean jb1=new JavaBean();    
     jb1.setId(rs.getString("id"));    
     jb1.setCustomerNo(rs.getString("customerno"));
     jb1.setCompname(rs.getString("comp_name"));     
     jb1.setCompadd(rs.getString("comp_address")); 
     jb1.setCompadd2(rs.getString("comp_address2")); 
     jb1.setPhno1(rs.getString("comp_phno1")); 
     jb1.setPhno2(rs.getString("comp_phno2"));    
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
  
    public JavaBean updateCompDetails2(String pr){       
    Connection con=null;
    JavaBean jb1=new JavaBean();   
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
    String qr1="select * from companydetails where id="+pr;
    try{
     psmt=con.prepareStatement(qr1);
     rs=psmt.executeQuery();
     while(rs.next()){ 
     jb1.setId(rs.getString("id"));   
     jb1.setCustomerNo(rs.getString("customerno")); 
     jb1.setCompname(rs.getString("comp_name"));     
     jb1.setCompadd(rs.getString("comp_address")); 
     jb1.setCity(rs.getString("city"));
     jb1.setState(rs.getString("state"));
     jb1.setCountry(rs.getString("country"));
     jb1.setZipcode(rs.getString("zipcode"));
     jb1.setPhno1(rs.getString("comp_phno1")); 
     jb1.setPhno2(rs.getString("comp_phno2"));
     jb1.setActype(rs.getString("actype"));
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
    return jb1;
   }
    
    public boolean deleteCompDetails(String pr){  
Connection con=null;
try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
    String qr1="delete from companydetails where id="+pr;
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
    
    public boolean updateComp(JavaBean jb1){  
    Connection con=null;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){} 
//  String qr2="select count(*) as cnt from companydetails where customerno='"+jb1.getCustomerNo()+"'";
    String qr1="update companydetails set comp_name=?,comp_address=?,comp_phno1=?,comp_phno2=?,actype=?,customerno=?,city=?,state=?,country=?,zipcode=? where id="+jb1.getId();
     try{
     int count=0;   
//   psmt2=con.prepareStatement(qr2);      
//   rs2=psmt.executeQuery();
//   rs2.next();
//   count=rs2.getInt("cnt");  
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb1.getCompname());     
     psmt.setString(2,jb1.getCompadd());   
     psmt.setString(3,jb1.getPhno1()); 
     psmt.setString(4,jb1.getPhno2()); 
     psmt.setString(5,jb1.getActype());
     psmt.setString(6,jb1.getCustomerNo());
     psmt.setString(7,jb1.getCity());
     psmt.setString(8,jb1.getState());
     psmt.setString(9,jb1.getCountry());
     psmt.setString(10,jb1.getZipcode());
     psmt.executeUpdate();
     }
     catch(SQLException se){}
     finally{
    try{    
//  if(rs2!=null){rs2.close();}    
//  if(psmt2!=null){psmt2.close();}      
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
    } 
   catch(SQLException se){}
   }
    return true;
   } 
       
  public JavaBean generateBill(JavaBean jb1,String dt1,String dt2){  
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
    JavaBean jb=new JavaBean();    
    long bno=1000; 
    String qr1="select billno from generatedbill where companyname='"+jb1.getCompname()+"' and str_to_date(fromdate,'%d/%m/%Y')=str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date(todate,'%d/%m/%Y')=str_to_date('"+dt2+"','%d/%m/%Y')";
    try{
     psmt=con.prepareStatement(qr1);
     rs=psmt.executeQuery();
     if(rs.next()){
     jb.setBillno(rs.getLong("billno"));  
     jb.setCompname(jb1.getCompname());  
     }
     else{
     String qr2="select billno from generatedbill where billno=(select max(billno) from generatedbill)";
     psmt2=con.prepareStatement(qr2);
     rs2=psmt2.executeQuery();
     if(rs2.next()){
     bno=rs2.getLong("billno");   
     }
     bno++;
     String qr3="insert into generatedbill(fromdate,todate,companyname,billno)values(?,?,?,?)";
     psmt3=con.prepareStatement(qr3);
     psmt3.setString(1,dt1);
     psmt3.setString(2,dt2);
     psmt3.setString(3,jb1.getCompname());
     psmt3.setLong(4,bno);     
     psmt3.executeUpdate();   
     jb.setBillno(bno);  
     jb.setCompname(jb1.getCompname()); 
     }
     }
     catch(SQLException se){}
     finally{
   try{
    if(rs!=null){rs.close();}    
    if(psmt!=null){psmt.close();} 
    if(rs2!=null){rs2.close();}    
    if(psmt2!=null){psmt2.close();}      
    if(psmt3!=null){psmt3.close();} 
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return jb;
   } 
  
  public int airwaySeriesSubmit(JavaBean jb){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
  int count=0;
  long from=0;
  long to=0;
     String qr3="select fromno,tono from airwayseries order by fromno desc";
     String qr1="insert into airwayseries(dated,fromno,tono)values(?,?,?)";
     String qr2="insert into balairwayseries(dated,fromno,tono)values(?,?,?)";
     try{  
      psmt3=con.prepareStatement(qr3);  
      rs3=psmt3.executeQuery();
      while(rs3.next()){  
      from=rs3.getLong("fromno");
      to=rs3.getLong("tono");
      if((from>jb.getFromno() && from>jb.getTono()) || (to<jb.getFromno() && to<jb.getTono())){
      continue;
      }else{
      count=1;    
      break;
      }
      } 
      if(count==0){
      psmt=con.prepareStatement(qr1);    
      psmt.setString(1,jb.getDated());   
      psmt.setLong(2,jb.getFromno());
      psmt.setLong(3,jb.getTono());
      psmt.executeUpdate();         
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,jb.getDated());
      psmt2.setLong(2,jb.getFromno());
      psmt2.setLong(3,jb.getTono());
      psmt2.executeUpdate(); 
      }
      }
     catch(SQLException se){count=-1;}
      finally{
   try{
    if(rs3!=null){rs3.close();}     
    if(psmt3!=null){psmt3.close();}
    if(psmt!=null){psmt.close();}
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
   return count;   
  }  
  
  public int consignSubmit(JavaBean jb){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  int count=0;
  long from=0;
  long to=0;
     String qr3="select fromno,tono from consignment order by fromno desc";
     String qr1="insert into consignment(dated,fromno,tono)values(?,?,?)";
     String qr2="insert into balancedconsign(dated,fromno,tono)values(?,?,?)";
     try{  
      psmt3=con.prepareStatement(qr3);  
      rs3=psmt3.executeQuery();
      while(rs3.next()){  
      from=rs3.getLong("fromno");
      to=rs3.getLong("tono");
      if((from>jb.getFromno() && from>jb.getTono()) || (to<jb.getFromno() && to<jb.getTono())){
      continue;
      }else{
      count=1;    
      break;
      }
      } 
      if(count==0){
      psmt=con.prepareStatement(qr1);    
      psmt.setString(1,jb.getDated());   
      psmt.setLong(2,jb.getFromno());
      psmt.setLong(3,jb.getTono());
      psmt.executeUpdate();         
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,jb.getDated());
      psmt2.setLong(2,jb.getFromno());
      psmt2.setLong(3,jb.getTono());
      psmt2.executeUpdate(); 
      }
      }
     catch(SQLException se){count=-1;}
      finally{
   try{
    if(rs3!=null){rs3.close();}     
    if(psmt3!=null){psmt3.close();}
    if(psmt!=null){psmt.close();}
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
     return count;   
  }  
  
   public int addZonesData(JavaBean jb1){  
 Connection con=null;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }   
    int in=0;
    String qr="select count(zone) as cnt from allzones where zone='"+jb1.getZone()+"'";    
    String qr1="insert into allzones(zone)values(?)";
    try{
     psmt2=con.prepareStatement(qr); 
     rs2=psmt2.executeQuery();
     rs2.next();
     in=rs2.getInt("cnt");
     if(in==0){
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb1.getZone());     
     psmt.executeUpdate();
     }
     }
     catch(SQLException se){}
     finally{
   try{   
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return in;
   } 
  
 public ArrayList dispZonesData(){  
 Connection con=null;
 ArrayList ar=new ArrayList(); 
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="select * from allzones";    
    try{  
     psmt=con.prepareStatement(qr);
     rs=psmt.executeQuery();
     while(rs.next()){
     JavaBean jb=new JavaBean();     
     jb.setId(rs.getString("rid"));
     jb.setZone(rs.getString("zone"));
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
 
 public int delZoneData(String rid){  
 Connection con=null;
 ArrayList ar=new ArrayList(); 
 int count=0;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="delete from allzones where rid="+rid;    
    try{  
     psmt=con.prepareStatement(qr);
     psmt.executeUpdate();
     }
     catch(SQLException se){count=-1;}
     finally{
   try{   
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return count;
   } 
 
 public int addModeData(JavaBean jb1){  
 Connection con=null;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    int in=0;
    String qr="select count(mode) as cnt from allmodes where mode='"+jb1.getMode()+"'";    
    String qr1="insert into allmodes(mode)values(?)";
    try{
     psmt2=con.prepareStatement(qr); 
     rs2=psmt2.executeQuery();
     rs2.next();
     in=rs2.getInt("cnt");
     if(in==0){
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb1.getMode());     
     psmt.executeUpdate();
     }
     }
     catch(SQLException se){}
     finally{
   try{   
    if(rs2!=null){rs2.close();}     
    if(psmt2!=null){psmt2.close();}      
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return in;
   } 
 
 public int courierIdData(JavaBean jb){  
 Connection con=null;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    int in=0;
    String qr="select count(courierid) as cnt from empcourierid where courierid='"+jb.getCourierId()+"'";    
    String qr1="insert into empcourierid(empname,courierid)values(?,?)";
    try{
     psmt2=con.prepareStatement(qr); 
     rs2=psmt2.executeQuery();
     rs2.next();
     in=rs2.getInt("cnt");
     if(in==0){
     psmt=con.prepareStatement(qr1);
     psmt.setString(1,jb.getEmpname());  
     psmt.setString(2,jb.getCourierId());  
     psmt.executeUpdate();
     }
     }
     catch(SQLException se){}
     finally{
   try{   
    if(rs2!=null){rs2.close();}     
    if(psmt2!=null){psmt2.close();}      
    if(psmt!=null){psmt.close();}    
    if(con!=null){con.close();}        
   } 
   catch(SQLException se){}
   }
    return in;
   } 
 
  public static void main(String[] a){
  JavaBean jb=new JavaBean();
  DataObject2 dobj=new DataObject2();
  }
       
}

