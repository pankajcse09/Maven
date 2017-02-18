package com.myapp.struts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MyMethods {   
    
    static Connection con=null;
    static PreparedStatement psmt=null; 
    static PreparedStatement psmt1=null; 
    static PreparedStatement psmt2=null; 
    static ResultSet rs=null;  
    static ResultSet rs1=null; 
    static ResultSet rs2=null;  
      
    /** Creates a new instance of MyMethods */
      public MyMethods() {} 
    /////
      
      public JavaBean compData(JavaBean jb){
  Connection con=null;
  try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
   String qr1="select * from companydetails where comp_name='"+jb.getCompname()+"'";
   try{
     psmt=con.prepareStatement(qr1);
     rs=psmt.executeQuery();
     if(rs.next()){     
     jb.setCompname(rs.getString("comp_name"));
     jb.setAddress1(rs.getString("comp_address"));
     jb.setPhno1(rs.getString("comp_phno1"));
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
      
      
      
   public String precesion(String st,int n){
   String pno=st;
   int d=0;
   int in1=0;
   int in2=0;
   String st1="";
   String st2="";
   in1=st.indexOf(".");
   in2=st.length();
   st1=st.substring(0,in1);
   st2="."+st.substring(in1+1,in2);
   try{
   d=(int)(Double.parseDouble(st2)*pow(10,n));
   }
   catch(NumberFormatException ne){}
   if(d<pow(10,n-1)){
   pno=st;    
   }
   else{
    pno=st1+"."+d;     
   }    
   return pno;    
   }    
 
   public int pow(int no,int p){
   int np=1;    
   for(int i=1;i<=p;i++){
   np=np*no;    
   }    
   return np;
   }
   
     ///////////////////////////////////////////////////////////////////////////
   public ArrayList fromNo(){
   Connection con=null;
   try{  
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
   ArrayList ar=new ArrayList();
   long fno=0;
     try{
//      String qr3="select min(fromno) as fromn from balancedconsign where series='"+sno+"'";
//      psmt1=con.prepareStatement(qr3);
//      rs1=psmt1.executeQuery();
//      while(rs1.next()){
//      fno=rs1.getLong("fromn");    
//      }
    String qr1="select fromno from balancedconsign order by fromno";  
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
     JavaBean jb=new JavaBean();    
     jb.setFromno(rs.getLong("fromno")); 
     //jb.setTono(rs.getLong("tono"));
     ar.add(jb);
    }
   }
   catch(SQLException se){}
      finally{
   try{     
    //if(rs1!=null){rs1.close();}      
    if(rs!=null){rs.close();}
    //if(psmt1!=null){psmt1.close();} 
    if(psmt!=null){psmt.close();}   
    if(con!=null){con.close();}         
   } 
   catch(SQLException se){}
   }
   return ar;     
   }
   
   
   
   
   /////////////////////////
   
    public HashMap toPayCodData(String p,String dt1,String dt2){
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
   String qr2="select count(*) as cnt from topay_cod where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
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
  String qr1="select * from topay_cod where str_to_date(dated,'%d/%m/%y') between str_to_date('"+dt1+"','%d/%m/%y') and str_to_date('"+dt2+"','%d/%m/%y')";
  psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
  rs=psmt.executeQuery();
  rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){    
   JavaBean jb=new JavaBean();   
   jb.setId(rs.getString("id"));  
   jb.setDated(rs.getString("dated"));
   jb.setCnno(rs.getString("ccno"));
   jb.setPartyname(rs.getString("partyname"));
   jb.setWeight(rs.getDouble("weight"));
   jb.setDest(rs.getString("destination"));
   jb.setTopay(rs.getDouble("topayamt"));
   jb.setCod(rs.getDouble("codamt"));
   jb.setRecptno(rs.getString("receiptno"));
   jb.setCollection(rs.getDouble("collection"));
   jb.setBy(rs.getString("bby"));
   jb.setZone(rs.getString("zone"));
   ar.add(jb);
   rs.next();
    }
    }
  catch(SQLException se){
   System.out.println(se.getMessage());   
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
}

