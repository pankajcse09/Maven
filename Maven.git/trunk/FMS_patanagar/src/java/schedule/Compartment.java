package schedule;

 import java.io.*;
 import java.sql.*;
 import com.myapp.struts.Dataconnectivity;
 import java.util.*;

public class Compartment {
    
    public Compartment(){
    }
    static Connection con=null;  
    public ArrayList selectId(String yr1,String sm1,String dg1,String cd1){  
     try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }  
   Compartment cm=new Compartment(); 
   PreparedStatement psmt1=null;     
   ResultSet rs1=null;   
   PreparedStatement psmt2=null;  
   PreparedStatement psmt3=null; 
   ResultSet rs2=null; 
   ResultSet rs3=null; 
   int a12=0;   
   String qr5=""; 
   String qr6=""; 
   String qr7=""; 
   String yr=yr1; 
   String sm=sm1; 
   String dg=dg1; 
   String cd=cd1; 
   ArrayList ar1=new ArrayList();
   ArrayList ar2=new ArrayList();
   ArrayList ar3=new ArrayList();
   ArrayList ar4=new ArrayList();
   ArrayList ar5=new ArrayList();
   ArrayList ar6=new ArrayList();
   ArrayList ar7=new ArrayList();
   ArrayList stid=new ArrayList();
   sm1=(new Integer(Integer.parseInt(sm)-1)).toString();   
   qr5="select studid,midterm,endterm,intpractical,permission from addmarks where years='"+yr+"' and (semester='"+sm+"' or semester='"+sm1+"') and degree='"+dg+"' and course_id='"+cd+"' and studid not in (select studid from compmarks where course_id='"+cd+"' and degree='"+dg+"' and (semester='"+sm+"' or semester='"+sm1+"') and years='"+yr+"') order by studid"; 
   try{
   psmt1=con.prepareStatement(qr5);
   rs1=psmt1.executeQuery();
   while(rs1.next()){
   ar1.add(rs1.getString("studid"));    
   ar2.add(rs1.getString("midterm"));
   ar3.add(rs1.getString("endterm"));
   ar4.add(rs1.getString("intpractical"));
   ar5.add(rs1.getString("permission"));   
   }   
   for(int j=0;j<ar1.size();j++){
   qr6="select external from extmarks where years='"+yr+"' and semester='"+sm+"' and degree='"+dg+"' and course_id='"+cd+"' and studid='"+ar1.get(j)+"'"; 
   psmt2=con.prepareStatement(qr6);
   rs2=psmt2.executeQuery();
   while(rs2.next()){
   ar6.add(rs2.getString("external"));      
   }
   }
   for(int j=0;j<ar1.size();j++){
   qr7="select extpractical from extprmarks where years='"+yr+"' and semester='"+sm+"' and degree='"+dg+"' and course_id='"+cd+"' and studid='"+ar1.get(j)+"'"; 
   psmt3=con.prepareStatement(qr7);
   rs3=psmt3.executeQuery();
   while(rs3.next()){
   ar7.add(rs3.getString("extpractical"));    
   }
   }
   }
   catch(SQLException se){
   System.out.println(se.getMessage());    
   }
   finally{
       try{        
         if(rs1!=null){
          rs1.close();   
         }
         if(rs2!=null){
          rs2.close();   
         }
           if(rs3!=null){
          rs3.close();   
         }
          if(psmt1!=null){
             psmt1.close();
         }  
           if(psmt2!=null){
             psmt2.close();
         } 
            if(psmt3!=null){
             psmt3.close();
         } 
         if(con!=null){
         con.close();    
         }
       }
       catch(SQLException se){
       System.out.println(se.getMessage());
       }
   }
   String a1="";      
   double a2=0.0,a3=0.0,a4=0.0,a6=0.0,a7=0.0,sum=0.0;
   String a5="";
   try{
   for(int i=0;i<ar1.size();i++){
   a1=ar1.get(i).toString(); 
   a12=cm.select(a1,yr,sm,dg);
   a2=Double.parseDouble(ar2.get(i).toString());
   a3=Double.parseDouble(ar3.get(i).toString());
   a4=Double.parseDouble(ar4.get(i).toString());
   a5=ar5.get(i).toString();
   a6=Double.parseDouble(ar6.get(i).toString());
   a7=Double.parseDouble(ar7.get(i).toString());
   sum=a2+a3+a4+a6+a7;
   if(a12<3 && sum<50 && a5.equals("y")){
   stid.add(a1);    
   }
   }
   }
   catch(IndexOutOfBoundsException be){
   System.out.println(be.getMessage());    
   }
   return stid;   
  }    
   public int select(String a,String yr1,String sm1,String dg1){
   PreparedStatement psmt4=null;   
   ResultSet rs4=null;
   try{
   Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
   int tt=0;
   int count=0;
   String qr2="";
   String a2=a;
   String yr2=yr1;
   String sm2=sm1;
   String dg2=dg1;      
   String sm3=(new Integer(Integer.parseInt(sm2)-1)).toString(); 
   qr2="select count(status) as cont from extprmarks where status='F' and studid='"+a2+"' and years='"+yr2+"' and semester='"+sm2+"' and degree='"+dg2+"'"; 
  try{    
   psmt4=con.prepareStatement(qr2);
   rs4=psmt4.executeQuery();
   if(rs4.next()){
   count=rs4.getInt("cont");   
   }        
    }
   catch(SQLException se){
   System.out.println(se.getMessage());    
   }  
    finally{
       try{       
         if(rs4!=null){
          rs4.close();   
         }          
           if(psmt4!=null){
             psmt4.close();
         }      
         if(con!=null){con.close();}
       }
       catch(SQLException se){
       System.out.println(se.getMessage());
       }
   }
   return count;   
   }    
  public String checkStatus1(String dg1,String yr1,String sm11,String stid1,String cs1,double jk11){
   String dg=dg1;
   String yr=yr1;
   String sm=sm11;
   String stid=stid1;
   String cs=cs1;  
   double jk1=jk11;
   String ch="";   
   int sm1=0;
   int sm2=0;
   double mid=0.0;
   double end=0.0;
   double inp=0.0;
   double ext=0.0;
   double exp=0.0;
   double tot=0.0;
   PreparedStatement psmt3=null;  
   PreparedStatement psmt4=null;    
   ResultSet rs3=null; 
   ResultSet rs4=null;   
     try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }    
            sm1=Integer.parseInt(sm)-1;
            sm2=Integer.parseInt(sm);          
   String qr1="select midterm,endterm,intpractical from addmarks where studid='"+stid+"' and years='"+yr+"' and (semester='"+sm1+"' or semester='"+sm2+"') and degree='"+dg+"' and course_id='"+cs+"'"; 
   try{
   psmt3=con.prepareStatement(qr1);
   rs3=psmt3.executeQuery();
   while(rs3.next()){   
   mid=rs3.getDouble("midterm");
   end=rs3.getDouble("endterm");
   inp=rs3.getDouble("intpractical");
   }
   String qr2="select extpractical from extprmarks where studid='"+stid+"' and years='"+yr+"' and semester='"+sm2+"' and degree='"+dg+"' and course_id='"+cs+"'"; 
   psmt4=con.prepareStatement(qr2);
   rs4=psmt4.executeQuery();
   while(rs4.next()){   
   exp=rs4.getDouble("extpractical");
   }
   //String qrs="select adm.midterm as mid,adm.endterm as end,adm.intpractical as inpr,exm.extpractical as expr from addmarks adm join extmarks exm on adm.studid=exm.studid and adm.course_id=exm.course_id where adm.studid='"+stid+"' and adm.degree='"+dg+"' and adm.years='"+yr+"' and adm.semester='"+sm+"' and adm.course_id='"+cs+"' and exm.studid='"+stid+"' and exm.degree='"+dg+"' and exm.years='"+yr+"' and exm.semester='"+sm1+"' and exm.course_id='"+cs+"' exm.status='F'"; 
 
     if(mid==-1){
         mid=0.0;
     }
     if(end==-1){
         end=0.0;
     }
     if(inp==-1){
      inp=0.0;   
     }     
     if(exp==-1){
      exp=0.0;   
     }
   }
   catch(SQLException se){
       System.out.println(se.getMessage());
   }
            finally{
       try{        
         if(rs3!=null){
          rs3.close();   
         }       
         if(rs4!=null){
          rs4.close();   
         }        
          if(psmt3!=null){
             psmt3.close();             
         } 
          if(psmt4!=null){
             psmt4.close();             
         }   
         if(con!=null){con.close();}
       }
       catch(SQLException se){
       System.out.println(se.getMessage());
       }
     }
     tot=mid+end+inp+exp+jk1;
     if(tot>=50){
     ch="P";    
     }
     else{
      ch="F";   
     }
      return ch;
  }
  
   public int credits1(String st1,String cst,String y,String ssn) throws IOException{                
      PreparedStatement psm1=null;        
      ResultSet r1=null;   
          try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
int tct=0;
String cid1="";
String tc1="";
String en_id=st1;
String cit=cst;  
Round rr=new Round();   
String cid=""; 
String yr=y;
int yr1=0;
int yr2=0;
if(!yr.equals("") && yr!=null){
yr2=Integer.parseInt(yr)*2;
 yr1=yr2-1; 
}           
 try{ 
   try{            
cid="select id,totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and title='"+cit+"'";
        psm1=con.prepareStatement(cid); 
        r1=psm1.executeQuery();                  
        while(r1.next()){  
        cid1=r1.getString("id");        
        tc1=r1.getString("totalcredit"); 
        tct=tct+Integer.parseInt(tc1); 
}     
}
catch(Exception e){
    System.out.println(e.getMessage());
}
finally{
 try{     
  if(r1!=null){r1.close();}                  
  if(psm1!=null){psm1.close();}  
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}        
  }
        catch(NullPointerException ne){}  
        return tct;
    }   

   public double points1(String st1,String cst,String y,String sn) throws IOException{   
        
      PreparedStatement psm1=null;
      PreparedStatement psmt5=null;
      PreparedStatement psmt6=null; 
      PreparedStatement psmt7=null;
      PreparedStatement psmt8=null;
      ResultSet r1=null;      
      ResultSet rs5=null;
      ResultSet rs6=null;     
      ResultSet rs7=null;
      ResultSet rs8=null;
        try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
      String qr7="";
      String qr8="";
      double com=0;
      String com1="";
      String stus="";
      String ssn=sn;
      String qr5="";     
      String qr6="";
      String yr=y;
      int yr1=0;
      int yr2=0;
       if(!yr.equals("") && yr!=null){
       yr2=Integer.parseInt(yr)*2;
       yr1=yr2-1; 
       }
double tct=0.0;
double mie=0.0;
double inp=0.0;
double extn=0.0;
double extp=0.0;
double extra=0.0;
double me=0.0;   
double tt=0.0;
double gd=0.0;
double ps=0.0;
double ps1=0.0;
String cid1="";
String tc1="";
double dd=0.0;
      String en_id=st1;
      String cit=cst;  
          Round rr=new Round();   
           String cid="";
           String sm1="";                      
          try{ 
              try{            
cid="select id,totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and title='"+cit+"'";
        psm1=con.prepareStatement(cid); 
        r1=psm1.executeQuery();                  
        while(r1.next()){  
        cid1=r1.getString("id");        
        tc1=r1.getString("totalcredit"); 
        tct=tct+Double.parseDouble(tc1);   
qr5="select midterm,endterm,intpractical,extra from addmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt5=con.prepareStatement(qr5);
rs5=psmt5.executeQuery();
while(rs5.next())
{
if(rs5.getDouble("midterm")!=-1 && rs5.getDouble("endterm")!=-1){   
mie=rs5.getDouble("midterm")+rs5.getDouble("endterm"); 
}
else{
mie=0.0;    
}
if(rs5.getDouble("intpractical")!=-1){
inp=rs5.getDouble("intpractical");
}
else{
inp=0.0; 
} 
if(rs5.getDouble("extra")!=-1){
extra=rs5.getDouble("extra");
}
else{
extra=0.0;
} 
if(rs5.getDouble("extra")==-1){ 
qr8="select extpractical,status from extprmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";            
qr6="select external from extmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt6=con.prepareStatement(qr6);
rs6=psmt6.executeQuery();
 while(rs6.next()){    
 if(rs6.getDouble("external")!=-1){   
 extn=rs6.getDouble("external");  
 }
 else{
 extn=0;
 }
 }
 psmt8=con.prepareStatement(qr8);
 rs8=psmt8.executeQuery();
 while(rs8.next()){    
 if(rs8.getDouble("extpractical")!=-1){
 extp=rs8.getDouble("extpractical");  
 }
 else{
 extp=0;
 }
  if(rs8.getString("status").equals("P")){
 tt=Math.ceil(mie+inp+extn+extp);   
 gd=((double)tt)/10;
 ps=gd*Double.parseDouble(tc1);
 ps1=rr.roundoff(ps1+ps);
  }
  if(rs8.getString("status").equals("F")){
qr7="select compartment from compmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and semester='"+yr2+"' and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt7=con.prepareStatement(qr7);
rs7=psmt7.executeQuery();  
while(rs7.next()){    
com=rs7.getDouble("compartment"); 
com1=(new Double(com)).toString();
}    
 tt=Math.ceil(mie+inp+com+extp);   
 gd=((double)tt)/10;
 ps=gd*Double.parseDouble(tc1);
 ps1=ps1+ps; 
 }
}
}
else{
tt=Math.ceil(extra); 
gd=((double)tt)/10;
ps=gd*Double.parseDouble(tc1);
ps1=ps1+ps;
} 
}
}     
}
catch(Exception e){
    System.out.println(e.getMessage());
}
finally{
 try{      
  if(r1!=null){r1.close();}    
  if(rs5!=null){rs5.close();}   
  if(rs6!=null){rs6.close();}  
  if(rs7!=null){rs7.close();}   
  if(rs8!=null){rs8.close();} 
  if(psm1!=null){psm1.close();}  
  if(psmt5!=null){psmt5.close();} 
  if(psmt6!=null){psmt6.close();} 
   if(psmt7!=null){psmt7.close();} 
  if(psmt8!=null){psmt8.close();} 
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}        
  }
        catch(NullPointerException ne){}  
        return ps1;
    }   
    
   public String starId1(String cd){
     PreparedStatement psmt1=null; 
     ResultSet rs1=null; 
         try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
     String cs=cd; 
     String s="";
     String th="";
     String pr="";
     String qr="select course_id,theory,practical from coursemarks where course_id='"+cs+"' order by updatedate desc";
     try{
     psmt1=con.prepareStatement(qr);
     rs1=psmt1.executeQuery();
     if(rs1.next()==true){
     th=rs1.getString("theory");
     pr=rs1.getString("practical");
     }
     if(th.equals("50") && pr.equals("NA")){
      s=cs+"*";   
     }
     else{
     if(th.equals("NA") && pr.equals("50")){
     s=cs+"**";    
     }
     else{
      s=cs;   
     }
     }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());    
     }
     finally{
 try{        
  if(rs1!=null){rs1.close();}                
  if(psmt1!=null){psmt1.close();} 
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}
     return s;
   } 
}

/**
  public int select(String a,String yr1,String sm1,String dg1){
   PreparedStatement psmt3=null;
   PreparedStatement psmt4=null;
   ResultSet rs3=null;
   ResultSet rs4=null;   
   int tt=0;
   int count=0;
   String a2=a;
   String yr2=yr1;
   String sm2=sm1;
   String dg2=dg1;   
   String sm3=(new Integer(Integer.parseInt(sm2)-1)).toString(); 
   ArrayList ar8=new ArrayList();
   ArrayList ar9=new ArrayList();
   ArrayList ar10=new ArrayList();
   ArrayList ar11=new ArrayList();
   ArrayList ar12=new ArrayList();
   ArrayList ar13=new ArrayList();   
   String qr1="select course_id,midterm,endterm,intpractical from addmarks where studid='"+a2+"' and years='"+yr2+"' and (semester='"+sm2+"' or semester='"+sm3+"') and degree='"+dg2+"'"; 
   try{
   psmt3=con.prepareStatement(qr1);
   rs3=psmt3.executeQuery();
   while(rs3.next()){
   ar8.add(rs3.getString("course_id"));
   ar9.add(rs3.getString("midterm"));
   ar10.add(rs3.getString("endterm"));
   ar11.add(rs3.getString("intpractical"));
   }
   String qr2="";
   for(int i=0;i<ar8.size();i++){
   qr2="select external,extpractical from extmarks where studid='"+a2+"' and years='"+yr2+"' and (semester='"+sm2+"' or semester='"+sm3+"') and degree='"+dg2+"'"; 
   psmt4=con.prepareStatement(qr2);
   rs4=psmt4.executeQuery();
   while(rs4.next()){
   ar12.add(rs4.getString("external"));
   ar13.add(rs4.getString("extpractical"));
   }
   }     
    }
   catch(SQLException se){
   System.out.println(se.getMessage());    
   }  
    finally{
       try{        
         if(rs3!=null){
          rs3.close();   
         }
         if(rs4!=null){
          rs4.close();   
         }
          if(psmt3!=null){
             psmt3.close();
         }  
           if(psmt4!=null){
             psmt4.close();
         }        
       }
       catch(SQLException se){
       System.out.println(se.getMessage());
       }
   }
    try{
   for(int j=0;j<ar8.size();j++){
   tt=Integer.parseInt(ar9.get(j).toString())+Integer.parseInt(ar10.get(j).toString())+Integer.parseInt(ar11.get(j).toString())+Integer.parseInt(ar12.get(j).toString())+Integer.parseInt(ar13.get(j).toString());    
   if(tt<50){
    count++;   
   }  
   } 
   }
   catch(IndexOutOfBoundsException be){
   System.out.println(be.getMessage());    
   }
   return count;
  } 
   **/
