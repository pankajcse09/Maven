package com.myapp.struts;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import com.myapp.struts.Dataconnectivity;

public class AmountField {    

    static PreparedStatement psmt=null; 
    static ResultSet rs=null;
    /** Creates a new instance of AmountField */
  public AmountField() {
    }    
  public double amtField(String by1,String zn1,double wt1){      
  AmountField amf=new AmountField();
  double amt=0.0;
  if(by1.equals("busrate")){
  amt=amf.calcbus(zn1,wt1);    
  }
  if(by1.equals("aircargorate")){
  amt=amf.calcair(zn1,wt1);     
  }
   if(by1.equals("surfacecargorate")){
   amt=amf.calcsurf(zn1,wt1);    
  }
  return amt;
  }    

  public double calcbus(String zn,double wt1){
      Connection con=null;
  double cb=0.0;
  double w100=0.0;
  double w250=0.0;
  double w500=0.0;
  double aw500=0.0;
  double wg=0.0;
  int in=0;
  double wt=wt1*1000;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
    String qr1="select weight100,weight250,weight500,addweight500 from busrate where zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w100=rs.getDouble("weight100");    
  w250=rs.getDouble("weight250");
  w500=rs.getDouble("weight500");
  aw500=rs.getDouble("addweight500");
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
  if(wt<=100){
  cb=w100;
  }
  if(wt>100 && wt<=250){
  cb=w250;
  }  
  if(wt>250 && wt<=500){
  cb=w500;
  }
  if(wt>500){ 
  wg=wt-500;    
  in=(int)(wg/500);
  if(wg%500>0){
  cb=w500+(in*aw500)+aw500; 
  }
  else{
  cb=w500+(in*aw500); 
  }       
  }
  return cb;
  }
  
  public double calcair(String zn,double wt){
      Connection con=null;
  double ca=0.0;
  double w1=0.0;
  double w2=0.0;
  double w3=0.0;
  double w4=0.0;
  double w5=0.0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="select wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from aircargorate where zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w1=rs.getDouble("wt1_5kg");
  w2=rs.getDouble("wt5_25kg");
  w3=rs.getDouble("wt25_50kg");
  w4=rs.getDouble("wt50_100kg");
  w5=rs.getDouble("wtabove100kg");
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
  if(wt<=5){
   ca=Math.ceil(wt)*w1;   
  }
  if(wt>5 && wt<=25){
   ca=Math.ceil(wt)*w2;   
  }
  if(wt>25 && wt<=50){
   ca=Math.ceil(wt)*w3;   
  }
  if(wt>50 && wt<=100){
  ca=Math.ceil(wt)*w4;    
  }
  if(wt>100){
  ca=Math.ceil(wt)*w5;    
  }
  return ca;
  }
  
  public double calcsurf(String zn,double wt){
      Connection con=null;
  double cs=0.0;
  double w1=0.0;
  double w2=0.0;
  double w3=0.0;
  double w4=0.0;
  double w5=0.0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="select wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from surfacecargorate where zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w1=rs.getDouble("wt1_5kg");
  w2=rs.getDouble("wt5_25kg");
  w3=rs.getDouble("wt25_50kg");
  w4=rs.getDouble("wt50_100kg");
  w5=rs.getDouble("wtabove100kg");
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
  if(wt<=5){
   cs=Math.ceil(wt)*w1;   
  }
  if(wt>5 && wt<=25){
   cs=Math.ceil(wt)*w2;   
  }
  if(wt>25 && wt<=50){
   cs=Math.ceil(wt)*w3;   
  }
  if(wt>50 && wt<=100){
  cs=Math.ceil(wt)*w4;    
  }
  if(wt>100){
  cs=Math.ceil(wt)*w5;    
  }
  return cs;
  }
  
  public double camtField(JavaBean jb){      
  AmountField amf=new AmountField();
  double amt=0.0;
  if(jb.getTable().equals("comptarrifrate")){
  amt=amf.ccalcbus(jb);    
  }
  if(jb.getTable().equals("compaircargo")){
  amt=amf.ccalcair(jb);     
  }
  return amt;
  } 
  
  public double ccalcbus(JavaBean jb){
  Connection con=null;
  double cb=0.0;
  double wt15=0.0;
  double awt5=0.0;
  double wg=0.0;
  int in=0;
  double wt=jb.getWeight()*1000;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select weight1_5,addweight5 from comptarrifrate where companyname='"+jb.getCompname()+"' and zone='"+jb.getZone()+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  wt15=rs.getDouble("weight1_5");   
  awt5=rs.getDouble("addweight5");
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
  if(wt<=500){
  cb=wt15;
  }
  if(wt>500){ 
  wg=wt-500;    
  in=(int)(wg/500);
  if(wg%500>0){
  cb=wt15+(in*awt5)+awt5; 
  }
  else{
  cb=wt15+(in*awt5); 
  }       
  }
  return cb;
  }
  
  public double ccalcair(JavaBean jb){ 
  Connection con=null;
  double cb=0.0;
  double wt15=0.0;
  double awt5=0.0;
  double wg=0.0;
  int in=0;
  double wt=jb.getWeight()*1000;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String qr1="select weight1_5,addweight5 from compaircargo where companyname='"+jb.getCompname()+"' and zone='"+jb.getZone()+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  wt15=rs.getDouble("weight1_5");   
  awt5=rs.getDouble("addweight5");
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
   
  if(wt<=500){
  cb=wt15;
  }
  if(wt>500){ 
  wg=wt-500;    
  in=(int)(wg/500);
  if(wg%500>0){
  cb=wt15+(in*awt5)+awt5; 
  }
  else{
  cb=wt15+(in*awt5); 
  }       
  }
  return cb;
  }  
  
  public double ccalcsurf(JavaBean jb){
  Connection con=null;
  double cs=0.0;
  double w1=0.0;
  double w2=0.0;
  double w3=0.0;
  double w4=0.0;
  double w5=0.0;
//    try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }
//  catch(Exception e){
//  System.out.println(e.getMessage());    
//  } 
//  String qr1="select wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from compsurfacecargo where companyname='"+jb.getCompname()+"' and zone='"+jb.getZone()+"'";
//  try{
//  psmt=con.prepareStatement(qr1);
//  rs=psmt.executeQuery();
//  if(rs.next()){
//  w1=rs.getDouble("wt1_5kg");
//  w2=rs.getDouble("wt5_25kg");
//  w3=rs.getDouble("wt25_50kg");
//  w4=rs.getDouble("wt50_100kg");
//  w5=rs.getDouble("wtabove100kg");
//  }
//      }
//  catch(SQLException se){
//  System.out.println(se.getMessage());    
//  }  
//   finally{
//   try{
//    if(rs!=null){rs.close();}
//    if(psmt!=null){psmt.close();}    
//    if(con!=null){con.close();}        
//   } 
//   catch(SQLException se){}
//   }
//  if(wt<=5){
//   cs=Math.ceil(wt)*w1;   
//  }
//  if(wt>5 && wt<=25){
//   cs=Math.ceil(wt)*w2;   
//  }
//  if(wt>25 && wt<=50){
//   cs=Math.ceil(wt)*w3;   
//  }
//  if(wt>50 && wt<=100){
//  cs=Math.ceil(wt)*w4;    
//  }
//  if(wt>100){
//  cs=Math.ceil(wt)*w5;    
//  }
  return cs;
  }
  
  public double relianceAmtField(String cn,String zn,double wt){ 
      Connection con=null;
  double cs=0.0;
  double w1=0.0;
  double w2=0.0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="select wt1_6kg,wtabove6kg from reliancesurfacerate where companyname='"+cn+"' and zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w1=rs.getDouble("wt1_6kg");
  w2=rs.getDouble("wtabove6kg");
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
  if(wt<=6){
   cs=w1;   
  }
  else{
  cs=w1+Math.ceil(wt-6)*w2;    
  }
  return cs;
  }  
  
  public double superCharge(String cn,String by1,String zn1,double wt1){      
  AmountField amf=new AmountField();
  double amt=0.0;
  if(by1.equals("Domestic")){
  amt=amf.superBusCharge(cn,zn1,wt1);    
  }
  if(by1.equals("Air Cargo")){
  amt=amf.superAirCharge(cn,zn1,wt1);     
  }
  if(by1.equals("Surface Cargo")){
  amt=amf.superSurfaceCharge(cn,zn1,wt1);    
  }
  return amt;
  } 
  
  public double superBusCharge(String cn,String zn,double wt1){
      Connection con=null;
  double cb=0.0;
  double w100=0.0;
  double w250=0.0;
  double w500=0.0;
  double aw250=0.0;
  double aw500=0.0;
  double aw=0.0;
  int w=0;
  double wg=0.0;
  int in=0;
  double wt=wt1*1000;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
    String qr1="select weight100,weight250,weight500,addweight250,addweight500 from supertarrifrate where companyname='"+cn+"' and zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w100=rs.getDouble("weight100");   
  w250=rs.getDouble("weight250");
  w500=rs.getDouble("weight500");
  aw250=rs.getDouble("addweight250");
  aw500=rs.getDouble("addweight500");
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
  if(aw250>0.0){
   w=250;
   aw=aw250;      
  }  
  else{
   w=500;
   aw=aw500;      
  }   
  if(wt<=100){
  cb=w100;
  }
  if(wt>100 && wt<=250){
  cb=w250;
  }  
  if(wt>250 && wt<=500){
  cb=w500;
  }
  if(wt>500){ 
  wg=wt-500;    
  in=(int)(wg/w);
  if(wg%w>0){
  cb=w500+(in*aw)+aw; 
  }
  else{
  cb=w500+(in*aw); 
  }       
  }
  return cb;
  }
  
  public double superAirCharge(String cn,String zn,double wt){
      Connection con=null;
  double ca=0.0;
  double w1=0.0;
  double w2=0.0;
  double w3=0.0;
  double w4=0.0;
  double w5=0.0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="select wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from superaircargo where companyname='"+cn+"' and zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w1=rs.getDouble("wt1_5kg");
  w2=rs.getDouble("wt5_25kg");
  w3=rs.getDouble("wt25_50kg");
  w4=rs.getDouble("wt50_100kg");
  w5=rs.getDouble("wtabove100kg");
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
  if(wt<=5){
   ca=Math.ceil(wt)*w1;   
  }
  if(wt>5 && wt<=25){
   ca=Math.ceil(wt)*w2;   
  }
  if(wt>25 && wt<=50){
   ca=wt*w3;   
  }
  if(wt>50 && wt<=100){
  ca=Math.ceil(wt)*w4;    
  }
  if(wt>100){
  ca=Math.ceil(wt)*w5;    
  }
  return ca;
  }
  
  public double superSurfaceCharge(String cn,String zn,double wt){
      Connection con=null;
  double cs=0.0;
  double w1=0.0;
  double w2=0.0;
  double w3=0.0;
  double w4=0.0;
  double w5=0.0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="select wt1_5kg,wt5_25kg,wt25_50kg,wt50_100kg,wtabove100kg from supersurfacecargo where companyname='"+cn+"' and zone='"+zn+"'";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  if(rs.next()){
  w1=rs.getDouble("wt1_5kg");
  w2=rs.getDouble("wt5_25kg");
  w3=rs.getDouble("wt25_50kg");
  w4=rs.getDouble("wt50_100kg");
  w5=rs.getDouble("wtabove100kg");
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
  if(wt<=5){
   cs=Math.ceil(wt)*w1;   
  }
  if(wt>5 && wt<=25){
   cs=Math.ceil(wt)*w2;   
  }
  if(wt>25 && wt<=50){
   cs=Math.ceil(wt)*w3;   
  }
  if(wt>50 && wt<=100){
  cs=Math.ceil(wt)*w4;    
  }
  if(wt>100){
  cs=Math.ceil(wt)*w5;    
  }
  return cs;
  }
  
  public static void main(String a[]){      
  AmountField af=new AmountField();    
  JavaBean jb=new JavaBean();
  }
}
