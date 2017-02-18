package Intelmind.Display;

import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.text.*;
import Intelmind.Beans.*;
import Intelmind.Upload.*;

public class DisplayData {
    
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
    
    /**
     * Creates a new instance of DisplayData
     */
    public DisplayData() {
    } 
    
    public EquipBean dispOperDataSing(EquipBean eb){
    Connection con=null;    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{ 
    String qr1="select * from operator_daily_data where rid='"+eb.getRowId()+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+eb.getDated()+"','%d/%m/%Y')";  
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){  
    eb.setRowId(rs.getString("rid"));
    eb.setOperator(rs.getString("operator"));
    eb.setEquipId(rs.getString("equip_id"));
    eb.setProjectName(rs.getString("project_name"));
    eb.setWorkingHrs(rs.getString("working_hrs"));
    eb.setOvertimeHrs(rs.getString("overtime_hrs")); 
    eb.setGatePass(rs.getString("gate_pass"));
    eb.setTimeIn(rs.getString("time_in"));
    eb.setTimeOut(rs.getString("time_out"));
    eb.setStatus(rs.getString("status"));
    eb.setComments(rs.getString("comments"));
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
    return eb;
    }
    
    public int upCardStatusData(EquipBean eb){
    int count=0;    
    Date dt=new Date();   
    SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm"); 
    String timeout=sdf2.format(dt);
    Connection con=null;    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}    
    try{
    String qr2="select count(*) as cnt from operator_daily_data where rid="+eb.getRowId()+" and status='OPEN'"; 
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    rs2.next();
    count=rs2.getInt("cnt");
    if(count!=0){   
    String qr1="update operator_daily_data set time_out='"+timeout+"',status='CLOSED',working_hrs='"+eb.getWorkingHrs()+"',overtime_hrs='"+eb.getOvertimeHrs()+"',comments='"+eb.getComments()+"' where rid="+eb.getRowId();
    psmt1=con.prepareStatement(qr1);
    psmt1.executeUpdate();
    }
    }catch(SQLException se){count=-1;}
    finally{
    try{
    if(rs2!=null){rs2.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt1!=null){psmt1.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return count;
    } 
    
    public ArrayList dispOperData(EquipBean eb2){
    Connection con=null;    
    ArrayList ar=new ArrayList(); 
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{ 
    String qr1="select * from operator_daily_data where str_to_date(dated,'%d/%m/%Y')=str_to_date('"+eb2.getDated()+"','%d/%m/%Y')";  
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){  
    EquipBean eb=new EquipBean();        
    eb.setRowId(rs.getString("rid"));
    eb.setDated(rs.getString("dated"));
    eb.setOperator(rs.getString("operator"));
    eb.setEquipId(rs.getString("equip_id"));
    eb.setProjectName(rs.getString("project_name"));
    eb.setWorkingHrs(rs.getString("working_hrs"));
    eb.setOvertimeHrs(rs.getString("overtime_hrs")); 
    eb.setGatePass(rs.getString("gate_pass"));
    eb.setTimeIn(rs.getString("time_in"));
    eb.setTimeOut(rs.getString("time_out"));
    eb.setStatus(rs.getString("status"));
    eb.setComments(rs.getString("comments"));
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
    
    public ArrayList dispProjectWiseData(String proj){
    Connection con=null;  
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){} 
    try{
    psmt1=con.prepareStatement("select * from eq_equip_details where equip_id in (select equip_id from eq_jobcard where project='"+proj+"' and str_to_date(date_in,'%d/%m/%Y')=str_to_date(date_format(current_date,'%d/%m/%Y'),'%d/%m/%Y'))");
    rs1=psmt1.executeQuery();
    while(rs1.next()){
    EquipBean eb=new EquipBean();    
    eb.setEquipId(rs1.getString("equip_id"));
    eb.setPlateNo(rs1.getString("plate_no"));
    eb.setEquipChasis(rs1.getString("equip_chasis"));
    eb.setEquipType(rs1.getString("equip_type"));    
    eb.setNewUsed(rs1.getString("new_used"));
    eb.setOwnedRented(rs1.getString("owned_rented"));
    eb.setCategory(rs1.getString("category"));
    eb.setLicenseType(rs1.getString("license_type"));
    ar.add(eb);
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
    
    public ArrayList dispOperMonthlyData(EquipBean eb2){
    Connection con=null;    
    ArrayList ar=new ArrayList(); 
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    for(int i=1;i<=31;i++){   
    EquipBean eb=new EquipBean(); 
    eb.setDay(new Integer(i).toString());
    String qr1="select * from operator_daily_data where operator='"+eb2.getOperator()+"' and month(str_to_date(dated,'%d/%m/%Y'))="+eb2.getMonth()+" and year(str_to_date(dated,'%d/%m/%Y'))="+eb2.getYear()+" and day(str_to_date(dated,'%d/%m/%Y'))="+i;  
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){     
    eb.setRowId(rs.getString("rid"));
    eb.setDated(rs.getString("dated"));
    eb.setOperator(rs.getString("operator"));
    eb.setEquipId(rs.getString("equip_id"));
    eb.setProjectName(rs.getString("project_name"));
    eb.setWorkingHrs(rs.getString("working_hrs"));
    eb.setOvertimeHrs(rs.getString("overtime_hrs"));    
    }
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
    
    public ArrayList projectList(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from project where status<>'COMPLETED'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    EquipBean eb=new EquipBean();    
    eb.setProjectNo(rs.getString("ProjectID"));
    eb.setProjectName(rs.getString("pname"));
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
    
//    public ArrayList dispDocListData(String eqid){
//    Connection con=null;
//    ArrayList ar=new ArrayList();
//    try{
//    Dataconnectivity dc=new Dataconnectivity();
//    con=(Connection)dc.Dataconnect();
//    }
//    catch(Exception e){}       
//    try{
//    String qr1="select * from equip_docs where equip_id='"+eqid+"'";   
//    psmt=con.prepareStatement(qr1);
//    rs=psmt.executeQuery();
//    while(rs.next()){
//    UploadBean ub=new UploadBean();  
//    ub.setDocId(rs.getString("doc_id"));
//    ub.setDated(rs.getString("up_date"));
//    ub.setDocName(rs.getString("doc_name"));
//    ub.setEquipId(rs.getString("equip_id"));
//    ub.setFileName(rs.getString("file_name"));
//    ar.add(ub);
//    }
//    }catch(SQLException se){}
//    finally{
//    try{
//    if(rs!=null){rs.close();}
//    if(psmt!=null){psmt.close();}
//    if(con!=null){con.close();}
//    }
//    catch(SQLException se){}
//    }
//    return ar;
//    }
    
    public HashMap dispEquipListData2(String p){   
       Connection con=null; 
         int ins=25;
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
   String qr2="select count(*) as cnt from eq_equip_details";
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
     String qr1="select * from eq_equip_details order by convert(equip_id,unsigned)";
     psmt=con.prepareStatement(qr1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     rs=psmt.executeQuery();
     rs.absolute(startIndex);
  for(count = startIndex; count < increment; count++){ 
    EquipBean eb=new EquipBean();    
    eb.setEquipId(rs.getString("equip_id"));
    eb.setPlateNo(rs.getString("plate_no"));
    eb.setEquipName(rs.getString("equip_name"));
    eb.setEquipType(rs.getString("equip_type"));
    eb.setEquipMake(rs.getString("equip_make"));
    eb.setEquipModel(rs.getString("equip_model"));
    eb.setLicenseType(rs.getString("equip_license"));
    eb.setEquipChasis(rs.getString("equip_chasis"));
    eb.setVendor(rs.getString("vendor"));
    eb.setKmsPerLitre(rs.getDouble("kms_litre"));
    eb.setNewUsed(rs.getString("new_used"));
    eb.setAssetEquip(rs.getString("asset_equip"));
    eb.setCategory(rs.getString("category"));
    eb.setStatus(rs.getString("status"));
    eb.setModelYear(rs.getString("model_year"));
    eb.setPuchaseDate(rs.getString("purchase_date"));
    eb.setPurchasePrice(rs.getDouble("purchase_price"));
    eb.setEquipSerialNo(rs.getString("equip_serial_no"));
    eb.setVendor(rs.getString("vendor"));
    qr2="select * from eq_equip_insurance_det where equip_id='"+eb.getEquipId()+"' order by rid desc";
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    if(rs2.next()){
    eb.setInsurancePolicy(rs2.getString("insur_policy"));
    eb.setInsuranceComp(rs2.getString("insur_company"));
    eb.setExpiryDate(rs2.getString("expiry_date"));   
    eb.setPolicyType(rs2.getString("policy_type"));
    }
    ar.add(eb);
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
                
    public ArrayList dispEquipListData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    String qr2="";
    String qr3="";
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}  
    Date dat=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    String dt=sdf.format(dat);
    try{
    String qr1="select * from eq_equip_details order by convert(equip_id,unsigned)";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    EquipBean eb=new EquipBean();    
    eb.setEquipId(rs.getString("equip_id"));
    eb.setPlateNo(rs.getString("plate_no"));
    eb.setEquipName(rs.getString("equip_name"));
    eb.setEquipType(rs.getString("equip_type"));
    eb.setEquipMake(rs.getString("equip_make"));
    eb.setEquipModel(rs.getString("equip_model"));
    eb.setLicenseType(rs.getString("equip_license"));
    eb.setEquipChasis(rs.getString("equip_chasis"));
    eb.setVendor(rs.getString("vendor"));
    eb.setKmsPerLitre(rs.getDouble("kms_litre"));
    eb.setNewUsed(rs.getString("new_used"));
    eb.setAssetEquip(rs.getString("asset_equip"));
    eb.setCategory(rs.getString("category"));
    eb.setStatus(rs.getString("status"));
    eb.setModelYear(rs.getString("model_year"));
    eb.setPuchaseDate(rs.getString("purchase_date"));
    eb.setPurchasePrice(rs.getDouble("purchase_price"));
    eb.setEquipSerialNo(rs.getString("equip_serial_no"));   
    eb.setVendor(rs.getString("vendor"));
    qr2="select * from eq_equip_insurance_det where equip_id='"+eb.getEquipId()+"' order by rid desc";
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    if(rs2.next()){
    eb.setInsurancePolicy(rs2.getString("insur_policy"));
    eb.setInsuranceComp(rs2.getString("insur_company"));
    eb.setExpiryDate(rs2.getString("expiry_date"));   
    eb.setPolicyType(rs2.getString("policy_type"));
    }
    qr3="select * from operator_daily_data where equip_id='"+eb.getEquipId()+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+dt+"','%d/%m/%Y')";
    psmt3=con.prepareStatement(qr3);
    rs3=psmt3.executeQuery();
    if(rs3.next()){
    eb.setDated(rs3.getString("dated"));
    eb.setOperator(rs3.getString("operator"));
    eb.setProjectName(rs3.getString("project_name"));
    }
    ar.add(eb);
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(rs2!=null){rs2.close();}
    if(rs3!=null){rs3.close();}
    if(psmt!=null){psmt.close();}
    if(psmt2!=null){psmt2.close();}
    if(psmt3!=null){psmt3.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return ar;
    }         
    
    public ArrayList allEmployeeList(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from hrms_employee";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    EmpBean eb=new EmpBean();    
    eb.setEmp_id(rs.getString("EMP_ID"));
    eb.setEmp_f_name(rs.getString("EMP_F_NAME"));
    eb.setEmp_m_name(rs.getString("EMP_M_NAME"));
    eb.setEmp_l_name(rs.getString("EMP_L_NAME"));
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
    
    public ArrayList dispDefectData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_defect_type";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    ProcessBean pb=new ProcessBean();    
    pb.setDefectCode(rs.getString("defect_code"));
    pb.setDefectDesc(rs.getString("defect_desc"));
    ar.add(pb);
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
    
    public ArrayList dispRepairData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_repair_type";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    ProcessBean pb=new ProcessBean();    
    pb.setRepairCode(rs.getString("repair_code"));
    pb.setRepairDesc(rs.getString("repair_desc"));
    ar.add(pb);
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
    
    public ArrayList dispEquipTypeData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_equip_type";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    EquipBean eb=new EquipBean();    
    eb.setEquipTypeCode(rs.getString("type_code"));
    eb.setEquipType(rs.getString("equip_type"));
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
    
    public ArrayList dispCategoryData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_category";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    CategoryBean cb=new CategoryBean();    
    cb.setCatCode(rs.getString("cat_code"));
    cb.setCatName(rs.getString("cat_name"));
    ar.add(cb);
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
    
    public ArrayList dispPartiesData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}           
    try{
    String qr1="select * from eq_parties_details";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    PartyBean pb=new PartyBean();    
    pb.setPartyCode(rs.getString("code"));
    pb.setName(rs.getString("name"));
    pb.setArabicName(rs.getString("arb_name"));
    pb.setShortName(rs.getString("shortname"));
    pb.setCategory(rs.getString("category"));
    pb.setContact(rs.getString("contact"));
    pb.setAddress(rs.getString("address"));
    pb.setEmail(rs.getString("email"));
    pb.setTelephone(rs.getString("telephone"));
    pb.setMobile(rs.getString("mobile"));
    pb.setFax(rs.getString("fax"));
    pb.setPager(rs.getString("pager"));
    pb.setRemarks(rs.getString("remarks"));
    ar.add(pb);
    }
    }catch(SQLException se){}  
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }catch(SQLException se){}    
    }
    return ar;
    }
    
    public ArrayList dispLocData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_store_location";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    StoreBean sb=new StoreBean();    
    sb.setLocCode(rs.getString("code"));
    sb.setName(rs.getString("name"));
    ar.add(sb);
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
    
    public ArrayList dispServiceData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_service_type";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){
    ProcessBean pb=new ProcessBean();    
    pb.setServiceCode(rs.getString("serv_code"));
    pb.setServiceDesc(rs.getString("serv_desc"));
    ar.add(pb);
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
    
    public ArrayList dispEquipsData(){
    Connection con=null;
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}     
//    try{
//    String qr1="";     
//    }catch(SQLException se){}  
//    finally{
//    try{
//    if(rs!=null){rs.close();}
//    if(psmt!=null){psmt.close();}
//    if(con!=null){con.close();}
//    }
//    catch(SQLException se){}
//    }
    return ar;
    }
    
    public EquipBean dispEquipDetData(String by,String databy){
    Connection con=null;
    EquipBean eb=new EquipBean();
    MyMethods mm=new MyMethods();
    if(by.equals("EQUIP_ID")){
    by="equip_id";    
    }
     if(by.equals("PLATE_NO")){
     by="plate_no";   
    }
     if(by.equals("CHASIS_NO")){
     by="equip_chasis";   
    }
    try{
    eb=(EquipBean)mm.allEquipData(by,databy,eb);    
    }catch(Exception e){}
    return eb;
    }   
    
    public JobCardBean dispJcardDetData(JobCardBean jcb){
    Connection con=null;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}     
    try{
    String qr1="select * from eq_jobcard where jobcard='"+jcb.getJobCard()+"'"; 
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    jcb.setDoc(rs.getString("doc"));
    jcb.setDateIn(rs.getString("date_in"));
    jcb.setJobCard(rs.getString("jobcard"));
    jcb.setTypeIE(rs.getString("type_ie"));
    jcb.setGatePass(rs.getString("gate_pass"));
    jcb.setTimeIn(rs.getString("time_in"));
    jcb.setServType(rs.getString("service_type"));
    jcb.setLocation(rs.getString("location"));
    jcb.setEquipId(rs.getString("equip_id"));
    jcb.setPlateNo(rs.getString("plate_no"));
    jcb.setEquipType(rs.getString("equip_type"));
    jcb.setProject(rs.getString("project"));
    jcb.setOperator(rs.getString("operator"));
    jcb.setOperTitle(rs.getString("operator_title"));
    jcb.setServLevel(rs.getString("service_level"));
    jcb.setKmHm(rs.getString("km_hm"));
    jcb.setPreventMain(rs.getString("prevenmain"));
    jcb.setClosedStatus(rs.getString("closed_status"));
    jcb.setClosedDate(rs.getString("closed_date"));
    jcb.setDateOut(rs.getString("date_out"));
    jcb.setTimeOut(rs.getString("time_out"));
    jcb.setIdleActive(rs.getString("idle_active"));
    jcb.setDownTime(rs.getString("down_time"));
    jcb.setNxtServAfter(rs.getString("nxt_serv_after"));
    jcb.setNxtServDue(rs.getString("nxt_serv_due"));
    jcb.setNxtServType(rs.getString("nxt_serv_type"));
    jcb.setPrevServType1(rs.getString("prev_serv_type1"));
    jcb.setPrevServType2(rs.getString("prev_serv_type2"));
    jcb.setPrevServType3(rs.getString("prev_serv_type3"));
    jcb.setServLoc(rs.getString("serv_location"));
    jcb.setRemarks(rs.getString("remarks"));
    }else{
    jcb.setJobCard("");    
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
    return jcb;
    }  
    
    public ProcessBean dispProcessDetData(ProcessBean pb){
    Connection con=null;
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}    
    List ar2=new ArrayList();
    try{
    String qr1="select * from eq_equip_defects where jobcard='"+pb.getJobCard()+"'"; 
    psmt1=con.prepareStatement(qr1);
    rs1=psmt1.executeQuery();
    if(rs1.next()){
    pb.setDefectCode(rs1.getString("code"));    
    pb.setDefReported(rs1.getString("def_reported"));
    pb.setDefSummary(rs1.getString("def_summary"));
    }
    String qr2="select * from eq_equip_repairs where jobcard='"+pb.getJobCard()+"'"; 
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    if(rs2.next()){
    pb.setRepairCode(rs2.getString("code"));
    pb.setRepReported(rs2.getString("rep_reported"));
    pb.setRepSummary(rs2.getString("rep_summary"));
    }
    String qr3="select * from eq_issue_material where jobcard='"+pb.getJobCard()+"'"; 
    psmt3=con.prepareStatement(qr3);
    rs3=psmt3.executeQuery();
    while(rs3.next()){
    ProcessBean pb2=new ProcessBean();    
    pb2.setItem(rs3.getString("item"));    
    pb2.setUnits(rs3.getInt("units"));
    ar2.add(pb2);
    }
    pb.setDataArray2(ar2);
    String qr4="select * from eq_labour_cost where jobcard='"+pb.getJobCard()+"'"; 
    psmt4=con.prepareStatement(qr4);
    rs4=psmt4.executeQuery();
    if(rs4.next()){
    pb.setEmpCode(rs4.getString("emp_code"));
    pb.setEmpName(rs4.getString("emp_name"));
    pb.setFromDate(rs4.getString("date_from"));
    pb.setToDate(rs4.getString("date_to"));
    pb.setBasicPay(rs4.getDouble("basic_pay"));
    pb.setHrsWorked(rs4.getDouble("hrs_worked"));
    pb.setRate(rs4.getDouble("rate"));
    pb.setTotalAmount2(rs4.getDouble("total_amount"));
    pb.setOverhead(rs4.getDouble("overhead"));
    pb.setNetAmount(rs4.getDouble("net_amount"));
    }
    }catch(SQLException se){}  
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
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return pb;
    } 
    
    public ArrayList dispEquipOperData(String by,String databy){
    Connection con=null;
    EquipBean eb=new EquipBean();
    MyMethods mm=new MyMethods();
    if(by.equals("EQUIP_ID")){
    by="equip_id";    
    }
     if(by.equals("PLATE_NO")){
     by="plate_no";   
    }
     if(by.equals("CHASIS_NO")){
     by="equip_chasis";   
    }
    ArrayList ar=(ArrayList)mm.allEquipOperData(by,databy);    
    return ar;
    }  
    
    public ArrayList dispEquipJobcardData(String by,String databy){
    Connection con=null;
    EquipBean eb=new EquipBean();
    MyMethods mm=new MyMethods();
    if(by.equals("EQUIP_ID")){
    by="equip_id";    
    }
     if(by.equals("PLATE_NO")){
     by="plate_no";   
    }
     if(by.equals("CHASIS_NO")){
     by="equip_chasis";   
    }
    ArrayList ar=(ArrayList)mm.allEquipJobcardData(by,databy);    
    return ar;
    }  
    
    public EquipBean retEquipDetData(String equipid){
    Connection con=null;
    EquipBean eb=new EquipBean();
    MyMethods mm=new MyMethods();
    try{
    eb=(EquipBean)mm.allEquipData("equip_id",equipid,eb);    
    }catch(Exception e){}
    return eb;
    } 
    
    public ProjectBean retProjectDetData(String pname){
    Connection con=null;
    ProjectBean pb=new ProjectBean(); 
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from project where pname='"+pname+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){       
    pb.setProjectId(rs.getString("ProjectID"));
    pb.setProjectName(rs.getString("pname"));
    pb.setArea(rs.getString("parea"));
    pb.setClient(rs.getString("pclient"));
    pb.setClientAddress(rs.getString("pclientadd"));
    pb.setDated(rs.getString("pdate"));
    pb.setDuration(rs.getString("pduration"));
    pb.setExpectComplete(rs.getString("expDateofcomplete"));
    pb.setLeader(rs.getString("plead"));
    pb.setLocation(rs.getString("plocation"));
    pb.setManager(rs.getString("pmgr"));
    pb.setSite(rs.getString("psite"));
    pb.setStatus(rs.getString("status"));
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
    return pb;
    } 
    
    public String empNameById(String id){
    Connection con=null;
    String name="";
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from hrms_employee where EMP_ID='"+id+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){        
    name=rs.getString("EMP_F_NAME")+" "+rs.getString("EMP_M_NAME")+" "+rs.getString("EMP_L_NAME");
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
    
    public EmpBean retEmpDetData(String eid){
    Connection con=null;
    EmpBean eb=new EmpBean();
    eb.setEmp_id(eid);
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from hrms_employee where EMP_ID='"+eid+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){      
    eb.setEmpName(rs.getString("EMP_F_NAME")+" "+rs.getString("EMP_M_NAME")+" "+rs.getString("EMP_L_NAME"));
    eb.setLevel_id(rs.getString("LEVEL_ID"));
    eb.setDept_id(rs.getString("DEPT_ID"));
    eb.setAddress_1(rs.getString("ADDRESS_1"));
    eb.setAddress_2(rs.getString("ADDRESS_2"));
    eb.setCity(rs.getString("CITY"));
    eb.setCivilid(rs.getString("civilid"));
    eb.setCivilidexp(rs.getString("civilidexp"));
    eb.setDob(rs.getString("DOB"));
    eb.setDojoin(rs.getString("DOJOIN"));
    eb.setNationality(rs.getString("NATIONALITY"));
    eb.setPass_no(rs.getString("pass_no"));    
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
    return eb;
    } 
    
    public ArrayList empDocLinksData(String eid){
    Connection con=null;
    ArrayList ar=new ArrayList();    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from pfile where pname='"+eid+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){    
    EmpBean emp=new EmpBean();    
    emp.setPname(rs.getString("pname"));
    emp.setPdate(rs.getString("pdate"));
    emp.setPfile(rs.getString("pfile"));
    ar.add(emp);
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
    
    public ProcessBean retMaterListData(ProcessBean pb){
    Connection con=null;    
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}       
    try{
    String qr1="select * from eq_issue_material where jobcard='"+pb.getJobCard()+"'";   
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    while(rs.next()){     
    ProcessBean pb2=new ProcessBean();   
    pb2.setRowId(rs.getString("rid"));
    pb2.setItem(rs.getString("item"));
    pb2.setUnits(rs.getInt("units"));
    pb2.setStatus(rs.getString("status"));
    ar.add(pb2);
    }
    pb.setDataArray(ar);
    }catch(SQLException se){}
    finally{
    try{
    if(rs!=null){rs.close();}
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }
    catch(SQLException se){}
    }
    return pb;
    } 
    
    public ProcessBean dispInspectionData(ProcessBean pb){
    Connection con=null;    
    ArrayList ar=new ArrayList();    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}  
    try{
    String qr1="select * from eq_equip_inspection where plate_no='"+pb.getPlateNo()+"' and convert(date_format(str_to_date(date_of_insp,'%d/%m/%Y'),'%m'),unsigned)="+pb.getMonth()+" and date_format(str_to_date(date_of_insp,'%d/%m/%Y'),'%Y')='"+pb.getYear()+"'"; 
    psmt1=con.prepareStatement(qr1);
    rs1=psmt1.executeQuery();
    while(rs1.next()){
    ProcessBean pb2=new ProcessBean();    
    pb2.setRowId(rs1.getString("rid"));   
    pb2.setPlateNo(rs1.getString("plate_no"));
    pb2.setInspectDate(rs1.getString("date_of_insp"));
    pb2.setBrandName(rs1.getString("brandname"));
    pb2.setLocation(rs1.getString("location"));
    pb2.setHourMeter(rs1.getString("hourmeter"));
    pb2.setInspectBy(rs1.getString("insp_by"));
    ar.add(pb2);
    } 
    pb.setDataArray(ar);
    }catch(SQLException se){} 
    finally{
     try{
     if(rs1!=null){rs1.close();}  
     if(psmt1!=null){psmt1.close();} 
     if(con!=null){con.close();}      
     }catch(SQLException se){}    
    }
    return pb;    
    }
    
    public ProcessBean dispInspectDetData(ProcessBean pb){
    Connection con=null;    
    ArrayList ar=new ArrayList();    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}  
    try{
    String qr1="select * from eq_equip_inspection where plate_no='"+pb.getPlateNo()+"' and str_to_date(date_of_insp,'%d/%m/%Y')=str_to_date('"+pb.getInspectDate()+"','%d/%m/%Y')";   
    String qr2="select * from eq_inspection_data where plate_no='"+pb.getPlateNo()+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+pb.getInspectDate()+"','%d/%m/%Y')";   
    psmt1=con.prepareStatement(qr1);    
    rs1=psmt1.executeQuery();    
    if(rs1.next()){
    pb.setRowId(rs1.getString("rid"));  
    pb.setBrandName(rs1.getString("brandname"));
    pb.setLocation(rs1.getString("location"));
    pb.setHourMeter(rs1.getString("hourmeter"));
    pb.setInspectBy(rs1.getString("insp_by"));
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    while(rs2.next()){
    ProcessBean pb2=new ProcessBean();    
    pb2.setRowId(rs2.getString("rid"));
    pb2.setDirective(rs2.getString("directive"));
    pb2.setStatus(rs2.getString("status"));
    pb2.setRemarks(rs2.getString("remarks"));
    ar.add(pb2);
    }   
    pb.setDataArray(ar);
    }      
    }catch(SQLException se){} 
    finally{
     try{
     if(rs1!=null){rs1.close();}  
     if(rs2!=null){rs2.close();} 
     if(psmt1!=null){psmt1.close();} 
     if(psmt2!=null){psmt2.close();} 
     if(con!=null){con.close();}      
     }catch(SQLException se){}    
    }
    return pb;    
    }
    
    public ProcessBean dispMonInspectData(ProcessBean pb){
    Connection con=null;    
    ArrayList ar=new ArrayList();    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}  
    try{
    String qr1="select * from mon_eq_equip_inspection where plate_no='"+pb.getPlateNo()+"' and date_format(str_to_date(month_year,'%m/%Y'),'%Y')='"+pb.getYear()+"'";   
    psmt1=con.prepareStatement(qr1);
    rs1=psmt1.executeQuery();
    while(rs1.next()){
    ProcessBean pb2=new ProcessBean();    
    pb2.setRowId(rs1.getString("rid"));   
    pb2.setPlateNo(rs1.getString("plate_no"));
    pb2.setInspectDate(rs1.getString("date_of_insp"));
    pb2.setBrandName(rs1.getString("brandname"));
    pb2.setLocation(rs1.getString("location"));
    pb2.setHourMeter(rs1.getString("hourmeter"));
    pb2.setInspectBy(rs1.getString("insp_by"));
    pb2.setMonthYear(rs1.getString("month_year"));
    ar.add(pb2);
    } 
    pb.setDataArray(ar);
    }catch(SQLException se){} 
    finally{
     try{
     if(rs1!=null){rs1.close();}  
     if(psmt1!=null){psmt1.close();} 
     if(con!=null){con.close();}      
     }catch(SQLException se){}    
    }
    return pb;    
    }
    
    public ProcessBean dispMonInspectDetData(ProcessBean pb){
    Connection con=null;    
    ArrayList ar=new ArrayList();    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    }
    catch(Exception e){}  
    try{
    String qr1="select * from mon_eq_equip_inspection where plate_no='"+pb.getPlateNo()+"' and str_to_date(month_year,'%m/%Y')=str_to_date('"+pb.getMonthYear()+"','%m/%Y')";   
    String qr2="select * from mon_eq_inspection_data where plate_no='"+pb.getPlateNo()+"' and str_to_date(month_year,'%m/%Y')=str_to_date('"+pb.getMonthYear()+"','%m/%Y')";   
    psmt1=con.prepareStatement(qr1);    
    rs1=psmt1.executeQuery();    
    if(rs1.next()){
    pb.setRowId(rs1.getString("rid"));  
    pb.setBrandName(rs1.getString("brandname"));
    pb.setLocation(rs1.getString("location"));
    pb.setHourMeter(rs1.getString("hourmeter"));
    pb.setInspectBy(rs1.getString("insp_by"));
    pb.setInspectDate(rs1.getString("date_of_insp"));
    pb.setMonthYear(rs1.getString("month_year"));
    psmt2=con.prepareStatement(qr2);
    rs2=psmt2.executeQuery();
    while(rs2.next()){
    ProcessBean pb2=new ProcessBean();    
    pb2.setRowId(rs2.getString("rid"));
    pb2.setDirective(rs2.getString("directive"));
    pb2.setStatus(rs2.getString("status"));
    pb2.setRemarks(rs2.getString("remarks"));
    pb2.setMonthYear(rs2.getString("month_year"));
    ar.add(pb2);
    }   
    pb.setDataArray(ar);
    }      
    }catch(SQLException se){} 
    finally{
     try{
     if(rs1!=null){rs1.close();}  
     if(rs2!=null){rs2.close();} 
     if(psmt1!=null){psmt1.close();} 
     if(psmt2!=null){psmt2.close();} 
     if(con!=null){con.close();}      
     }catch(SQLException se){}    
    }
    return pb;    
    }
    
 }
