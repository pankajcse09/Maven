package Intelmind.Display;

import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.*;
import Intelmind.Beans.*;
import java.text.*;

public class MyMethods {
    
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
    
    /** Creates a new instance of MyMethods */
    public MyMethods() {
    }
    
    public ArrayList plateNoList(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{ 
    psmt1=con.prepareStatement("select plate_no from eq_equip_details");  
    rs1=psmt1.executeQuery();    
    while(rs1.next()){ 
    ar.add(rs1.getString("plate_no"));
    }
    }catch(SQLException se){} 
    finally{
    try{
    if(rs1!=null){rs1.close();}
    if(psmt1!=null){psmt1.close();}
    if(con!=null){con.close();}
    }catch(SQLException se){}    
    }
    return ar;
    }
    
    public ArrayList retColumns(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{ 
    psmt1=con.prepareStatement("select * from eq_equip_details");  
    rs1=psmt1.executeQuery();
    ResultSetMetaData rmd=(ResultSetMetaData)rs1.getMetaData();
    int cc=rmd.getColumnCount();
    for(int i=1;i<cc;i++){
    String cname=rmd.getColumnName(i);
    ar.add(cname);
    }
    }catch(SQLException se){} 
    finally{
    try{
    if(rs1!=null){rs1.close();}
    if(psmt1!=null){psmt1.close();}
    if(con!=null){con.close();}
    }catch(SQLException se){}    
    }
    return ar;
    }
    
    public HashMap monthList(){
  HashMap mp=new HashMap();
  mp.put(new Integer(1),"JANUARY");
  mp.put(new Integer(2),"FEBRUARY");
  mp.put(new Integer(3),"MARCH");
  mp.put(new Integer(4),"APRIL");
  mp.put(new Integer(5),"MAY");
  mp.put(new Integer(6),"JUNE");
  mp.put(new Integer(7),"JULY");
  mp.put(new Integer(8),"AUGUST");
  mp.put(new Integer(9),"SEPTEMBER");
  mp.put(new Integer(10),"OCTOBER");
  mp.put(new Integer(11),"NOVEMBER");
  mp.put(new Integer(12),"DECEMBER");
  return mp;
  } 
    
    public String nextGatePass(){
    Date dat=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
    String gp=sdf.format(dat); 
    return gp;
    } 
    
    public JobCardBean nextJobCard(){
    Connection con=null;
    JobCardBean jb=new JobCardBean();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{        
    String start="";    
    String qr2="select jobcard from eq_start_jobcard";  
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    if(rs2.next()){
    start=rs2.getString("jobcard");
    }else{
    start="1";    
    }
    String qr1="select max(convert(jobcard,unsigned)) as jcard from eq_jobcard";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    start=new Long(rs.getLong("jcard")+1).toString();      
    }
    jb.setJobCard(start);    
    }catch(SQLException se){}  
    finally{
    try{
    if(rs2!=null){rs2.close();}
    if(rs!=null){rs.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return jb;
    } 
    
    public EquipBean retEquipData(EquipBean eb){
    Connection con=null;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{        
    String qr1="select * from eq_equip_details where equip_id='"+eb.getEquipId()+"'";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    eb.setOwnedRented(rs.getString("owned_rented"));    
    eb.setEquipId(rs.getString("equip_id"));    
    eb.setPlateNo(rs.getString("plate_no"));
    eb.setKmsPerLitre(rs.getDouble("kms_litre"));
    eb.setEquipType(rs.getString("equip_type"));
    eb.setNewUsed(rs.getString("new_used"));
    eb.setAssetEquip(rs.getString("asset_equip"));
    eb.setStatus(rs.getString("status"));
    eb.setEquipName(rs.getString("equip_name"));
    eb.setEquipMake(rs.getString("equip_make"));
    eb.setEquipModel(rs.getString("equip_model"));
    eb.setModelYear(rs.getString("model_year"));
    eb.setEquipSerialNo(rs.getString("equip_serial_no"));
    eb.setEquipLicense(rs.getString("equip_license"));
    eb.setEquipChasis(rs.getString("equip_chasis"));
    eb.setPuchaseDate(rs.getString("purchase_date"));
    eb.setPurchasePrice(rs.getDouble("purchase_price"));
    eb.setCurrentLoc(rs.getString("current_loc"));
    eb.setCategory(rs.getString("category"));
    eb.setRentedFrom(rs.getString("rented_from"));
    eb.setRentMonth(rs.getDouble("rent_month"));
    eb.setRentHour(rs.getDouble("rent_hour"));
    }else{
    eb.setEquipId("");    
    }
    String qr2="select * from eq_equip_engine_det where equip_id='"+eb.getEquipId()+"'";   
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery(); 
    
    if(rs2.next()){
    eb.setEngineMake(rs2.getString("engine_make"));
    eb.setEngineModel(rs2.getString("engine_model"));
    eb.setEngineShape(rs2.getString("engine_shape"));
    eb.setEngineSerial(rs2.getString("engine_serial"));
    eb.setTransMake(rs2.getString("trans_make"));
    eb.setMechDetails(rs2.getString("mech_detail"));
    eb.setCapacity(rs2.getDouble("capacity"));
    eb.setFuelType(rs2.getString("fuel_type"));
    }
    String qr3="select * from eq_equip_operator_det where equip_id='"+eb.getEquipId()+"' order by str_to_date(from_date,'%d/%m/%Y') desc"; 
    psmt3=con.prepareStatement(qr3);
    rs3=psmt3.executeQuery();
    if(rs3.next()){
    eb.setRowId(rs3.getString("rid"));    
    eb.setFromDate(rs3.getString("from_date"));    
    eb.setOperator(rs3.getString("operator"));
    eb.setTitle(rs3.getString("title"));
    eb.setServiceLoc(rs3.getString("service_loc"));
    eb.setProjectNo(rs3.getString("project_no"));  
    eb.setPrevService1(rs3.getString("prev_service1"));
    eb.setPrevService2(rs3.getString("prev_service2"));
    eb.setLastServiceOn(rs3.getString("last_service"));
    eb.setNextServiceDue(rs3.getString("next_service"));
    eb.setType1(rs3.getString("type1"));
    eb.setType2(rs3.getString("type2"));
    eb.setType3(rs3.getString("type3"));
    eb.setType4(rs3.getString("type4"));
    eb.setToDate(rs3.getString("to_date"));
    }
    String qr4="select * from eq_equip_insurance_det where equip_id='"+eb.getEquipId()+"' order by rid desc"; 
    psmt4=con.prepareStatement(qr4);
    rs4=psmt4.executeQuery();
    if(rs4.next()){
    eb.setInsurancePolicy(rs4.getString("insur_policy"));
    eb.setInsuranceComp(rs4.getString("insur_company"));
    eb.setPolicyType(rs4.getString("policy_type"));
    eb.setExpiryDate(rs4.getString("expiry_date"));
    }    
    }catch(SQLException se){}  
    finally{
    try{
    if(rs!=null){rs.close();}
    if(rs2!=null){rs2.close();}
    if(rs3!=null){rs3.close();}
    if(rs4!=null){rs4.close();}
    if(psmt!=null){psmt.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt3!=null){psmt3.close();}
    if(psmt4!=null){psmt4.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return eb;
    } 
    
    public EquipBean nextEquipId(){
    Connection con=null;
    EquipBean eb=new EquipBean();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{        
    String start="";    
    String qr2="select equip_id from eq_start_equipid";  
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    if(rs2.next()){
    start=rs2.getString("equip_id");
    }else{
    start="1";    
    }
    String qr1="select max(convert(equip_id,unsigned)) as eq_id from eq_equip_details";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    start=new Long(rs.getLong("eq_id")+1).toString();      
    }
    eb.setEquipId(start);    
    }catch(SQLException se){}  
    finally{
    try{
    if(rs2!=null){rs2.close();}
    if(rs!=null){rs.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return eb;
    } 
    
    public JobCardBean equipJobcardData(JobCardBean jcb){
    Connection con=null;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{        
    String qr1="select * from eq_equip_details where equip_id='"+jcb.getEquipId()+"'";
    String qr2="select * from operator_daily_data where equip_id='"+jcb.getEquipId()+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+jcb.getDateIn()+"','%d/%m/%Y')";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    if(rs.next()){
    jcb.setPlateNo(rs.getString("plate_no"));
    jcb.setEquipType(rs.getString("equip_type"));
    }
    if(rs2.next()){
    jcb.setProject(rs2.getString("project_name"));       
    jcb.setOperator(rs2.getString("operator"));
    }else{
    jcb.setProject("");       
    jcb.setOperator("");    
    }
    }catch(SQLException se){}  
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
    return jcb;
    } 
    
    public EquipBean allEquipData(String by,String databy,EquipBean eb){
    Connection con=null;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    Date dat=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    String dt=sdf.format(dat);
    try{        
    String qr1="select * from eq_equip_details where "+by+"='"+databy+"'";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    eb.setOwnedRented(rs.getString("owned_rented"));    
    eb.setEquipId(rs.getString("equip_id"));    
    eb.setPlateNo(rs.getString("plate_no"));
    eb.setKmsPerLitre(rs.getDouble("kms_litre"));
    eb.setEquipType(rs.getString("equip_type"));
    eb.setNewUsed(rs.getString("new_used"));
    eb.setAssetEquip(rs.getString("asset_equip"));
    eb.setStatus(rs.getString("status"));
    eb.setEquipName(rs.getString("equip_name"));
    eb.setEquipMake(rs.getString("equip_make"));
    eb.setEquipModel(rs.getString("equip_model"));
    eb.setModelYear(rs.getString("model_year"));
    eb.setEquipSerialNo(rs.getString("equip_serial_no"));
    eb.setEquipLicense(rs.getString("equip_license"));
    eb.setEquipChasis(rs.getString("equip_chasis"));
    eb.setPuchaseDate(rs.getString("purchase_date"));
    eb.setPurchasePrice(rs.getDouble("purchase_price"));
    eb.setCurrentLoc(rs.getString("current_loc"));
    eb.setCategory(rs.getString("category"));
    eb.setRentedFrom(rs.getString("rented_from"));
    eb.setRentMonth(rs.getDouble("rent_month"));
    eb.setRentHour(rs.getDouble("rent_hour"));
    eb.setVendor(rs.getString("vendor"));
    }else{
    eb.setEquipId("");    
    }
    String qr2="select * from eq_equip_engine_det where equip_id='"+eb.getEquipId()+"'";   
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery(); 
    
    if(rs2.next()){
    eb.setEngineMake(rs2.getString("engine_make"));
    eb.setEngineModel(rs2.getString("engine_model"));
    eb.setEngineShape(rs2.getString("engine_shape"));
    eb.setEngineSerial(rs2.getString("engine_serial"));
    eb.setTransMake(rs2.getString("trans_make"));
    eb.setMechDetails(rs2.getString("mech_detail"));
    eb.setCapacity(rs2.getDouble("capacity"));
    eb.setFuelType(rs2.getString("fuel_type"));
    }
    String qr3="select * from eq_equip_operator_det where equip_id='"+eb.getEquipId()+"' order by str_to_date(from_date,'%d/%m/%Y') desc"; 
    psmt3=con.prepareStatement(qr3);
    rs3=psmt3.executeQuery();
    if(rs3.next()){
    eb.setRowId(rs3.getString("rid"));    
    eb.setPrevService1(rs3.getString("prev_service1"));
    eb.setPrevService2(rs3.getString("prev_service2"));
    eb.setLastServiceOn(rs3.getString("last_service"));
    eb.setNextServiceDue(rs3.getString("next_service"));
    eb.setType1(rs3.getString("type1"));
    eb.setType2(rs3.getString("type2"));
    eb.setType3(rs3.getString("type3"));
    eb.setType4(rs3.getString("type4"));
    }
    String qr4="select * from eq_equip_insurance_det where equip_id='"+eb.getEquipId()+"' order by rid desc"; 
    psmt4=con.prepareStatement(qr4);
    rs4=psmt4.executeQuery();
    if(rs4.next()){
    eb.setInsurancePolicy(rs4.getString("insur_policy"));
    eb.setInsuranceComp(rs4.getString("insur_company"));
    eb.setPolicyType(rs4.getString("policy_type"));
    eb.setExpiryDate(rs4.getString("expiry_date"));
    }   
    
    String qr5="select * from operator_daily_data where equip_id='"+eb.getEquipId()+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+dt+"','%d/%m/%Y')"; 
    psmt5=con.prepareStatement(qr5);
    rs5=psmt5.executeQuery();
    if(rs5.next()){
    eb.setDated(rs5.getString("dated"));    
    eb.setOperator(rs5.getString("operator"));
    eb.setProjectName(rs5.getString("project_name"));
    }
    }catch(SQLException se){}  
    finally{
    try{
    if(rs!=null){rs.close();}
    if(rs2!=null){rs2.close();}
    if(rs3!=null){rs3.close();}
    if(rs4!=null){rs4.close();}
    if(rs5!=null){rs5.close();}
    if(psmt!=null){psmt.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt3!=null){psmt3.close();}
    if(psmt4!=null){psmt4.close();}
    if(psmt5!=null){psmt5.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return eb;
    } 
    
    public ArrayList allEquipOperData(String by,String databy){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{        
    String qr1="select * from eq_equip_operator_det where equip_id=(select equip_id from eq_equip_details where "+by+"='"+databy+"') order by str_to_date(from_date,'%d/%m/%Y') desc";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    EquipBean eb=new EquipBean();    
    eb.setEquipId(rs.getString("equip_id"));    
    eb.setFromDate(rs.getString("from_date"));
    eb.setOperator(rs.getString("operator"));
    eb.setTitle(rs.getString("title"));
    eb.setServiceLoc(rs.getString("service_loc"));
    eb.setProjectNo(rs.getString("project_no"));
    ar.add(eb);
    }
    }catch(SQLException se){}  
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
    
    public ArrayList allEquipJobcardData(String by,String databy){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}
    try{        
    String qr1="select * from eq_jobcard where equip_id=(select equip_id from eq_equip_details where "+by+"='"+databy+"')";
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    JobCardBean jcb=new JobCardBean();    
    jcb.setEquipId(rs.getString("equip_id"));    
    jcb.setJobCard(rs.getString("jobcard"));
    ar.add(jcb);
    }
    }catch(SQLException se){}  
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
    
    public String locByCode(String id){
    Connection con=null;
    String name="";
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_store_location where code='"+id+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){        
    name=rs.getString("name");
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return name;
    } 
    
    public String serviceByCode(String id){
    Connection con=null;
    String service="";
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_service_type where serv_code='"+id+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){        
    service=rs.getString("serv_desc");
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return service;
    }
    
    public double totWorkHrs(EquipBean eb){
    Connection con=null;
    double sm=0.0;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select sum(working_hrs) as sm from operator_daily_data where operator='"+eb.getOperator()+"' and month(str_to_date(dated,'%d/%m/%Y'))="+eb.getMonth()+" and year(str_to_date(dated,'%d/%m/%Y'))="+eb.getYear();  
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){        
    sm=rs.getDouble("sm");
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return sm;
    } 
    
    public double totOtHrs(EquipBean eb){
    Connection con=null;
    double sm=0.0;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select sum(overtime_hrs) as sm from operator_daily_data where operator='"+eb.getOperator()+"' and month(str_to_date(dated,'%d/%m/%Y'))="+eb.getMonth()+" and year(str_to_date(dated,'%d/%m/%Y'))="+eb.getYear();  
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){        
    sm=rs.getDouble("sm");
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return sm;
    }   
    
    public String operatorById(String en){
    Connection con=null;
    String name="";
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from hrms_employee where emp_id='"+en+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){        
    name=rs.getString("emp_f_name")+" "+rs.getString("emp_m_name")+" "+rs.getString("emp_l_name");    
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return name;
    } 
    
    public static void main(String a[]){
//    MyMethods mm=new MyMethods();
//    JobCardBean jb=(JobCardBean)mm.nextJobCard();
//    System.out.println("hello:"+jb.getJobCard());
    }   
   
    
}
