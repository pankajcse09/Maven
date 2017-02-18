/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kapil
 */
public class CommonFunctionality {
    PreparedStatement psmt=null;
    ResultSet rs=null;
    
    public String getSessionFromBatch(String batch){
        if(batch==null)
            return null;
        if(batch.length()<4)
            return null;
        try{
            return batch+"-"+(Integer.parseInt(batch)+1);
        }catch(Exception e){
            return null;
        }
    }
    
    public double getDoubleFormString(String amount){
        if(amount==null){
            return 0;
        }
        if(amount.length()==0){
            return 0;
        }
        try{
            return Double.parseDouble(amount);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int checkFeeDataInFeeStructure(String session,String degree,Connection con){
        int count=0;
       try{         
           
        String qr1="select count(*) as cnt from suraj_feechartdynam where session='"+session+"' and degree='"+degree+"'";
 //       System.out.println(qr1);
        psmt=con.prepareStatement(qr1);
        rs=psmt.executeQuery();
        if(rs.next())
            count=rs.getInt("cnt"); 
        }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(psmt!=null){psmt.close();}          
       }   
      catch(SQLException se){}
        return count;
    }
    }
    
public HashMap retFeeDataFromFeeStructure(String session,String degree,Connection con){
       HashMap hm=new HashMap();
       String qr1="select distinct heads,fee from suraj_feechartdynam where session='"+session+"' and degree='"+degree+"'";
 //      System.out.println(qr1);
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){
        hm.put(rs.getString("heads"),rs.getString("fee"));
      } 
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();}  
       }   
       catch(SQLException se){}
      } 
     return hm;   
}

public HashMap retFeeDataFromFee_Student_Detail(String session,String session_sem,String stud_id,ArrayList heads,ArrayList fields,Connection con){
       HashMap hm=new HashMap();
       StringBuilder sb=new StringBuilder("select session");
               for(int i=0;i<fields.size();i++){
                   sb=sb.append(",");
                sb=sb.append(fields.get(i));
              }
//               sb=sb.append(" from stud_fee_detail where stud_id='"+stud_id+"' and session='"+session+"' and session_sem='"+session_sem+"'");
               sb=sb.append(" from stud_fee_detail where stud_id=? and session=? and session_sem=?");
 //System.out.println(sb);              
               
     try{
      psmt=con.prepareStatement(sb.toString());
      psmt.setString(1, stud_id);
      psmt.setString(2, session);
      psmt.setString(3, session_sem);
      rs=psmt.executeQuery();
      if(rs.next()){
          for(int i=0;i<fields.size();i++){
            hm.put(heads.get(i), rs.getString(fields.get(i).toString()));
          }
      } 
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();}  
       }   
       catch(SQLException se){}
      } 
     return hm;   
}

public String getStringFromString(String val){
    if(null==val)
        return "";
    if(val.length()==0)
        return "";
    return val.trim();
}

public int getIntFromString(String value){
    if(value==null)
        return 0;
    if(value.length()==0)
        return 0;
    try{
        return Integer.parseInt(value);
    }catch(Exception e){
        return 0;
    }
}

public Double getDoubleFromDouble(Double amount){
    if(amount==null)
        return 0d;
    else
        return amount;
}
}
