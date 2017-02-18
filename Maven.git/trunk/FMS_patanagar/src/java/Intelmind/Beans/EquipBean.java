/*
 * EquipBean.java
 *
 * Created on October 17, 2009, 3:28 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Intelmind.Beans;

/**
 *
 * @author Intelmind
 */
import java.util.*;

public class EquipBean {
    
    /**
     * Creates a new instance of EquipBean
     */
    public EquipBean() {
    }
    private ArrayList dataArray=new ArrayList();
    private String comments="";
    private String gatePass="";
    private String timeIn="";
    private String timeOut="";
    private String rowId="";
    private String by="";
    private String dataBy="";
    private String category="";
    private String licenseType="";
    private String fromDate="";
    private String toDate="";
    private String ownedRented="";
    private String vendor="";
    private String rentedFrom="";
    private String equipTypeCode="";
    private String equipName="";
    private String equipId="";
    private String plateNo="";
    private double kmsPerLitre=0.0;
    private String equipType="";
    private String newUsed="";
    private String assetEquip="";
    private String status="";
    private String equipMake="";
    private String equipModel="";
    private String modelYear="";
    private String equipSerialNo="";
    private String equipLicense="";
    private String equipChasis="";
    private String puchaseDate="";
    private double purchasePrice=0.0;
    private String currentLoc="";
    private String engineMake="";
    private String engineModel="";
    private String engineShape="";
    private String engineSerial="";
    private String transMake="";
    private String mechDetails="";       
    private double capacity=0.0;
    private String fuelType="";
    private String operator="";
    private String title="";        
    private String serviceLoc="";
    private String projectNo="";
    private double rentMonth=0.0;
    private double rentHour=0.0;       
    private String prevService1="";       
    private String prevService2="";
    private String lastServiceOn="";        
    private String nextServiceDue="";       
    private String type1="";
    private String type2="";        
    private String type3="";        
    private String type4="";        
    private String insurancePolicy="";
    private String insuranceComp="";
    private String policyType="";
    private String expiryDate="";   
    private String projectName="";
    private String workingHrs="";
    private String overtimeHrs="";
    private String dated="";
    private String month="";
    private String year="";
    private String day="";
    
    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public double getKmsPerLitre() {
        return kmsPerLitre;
    }

    public void setKmsPerLitre(double kmsPerLitre) {
        this.kmsPerLitre = kmsPerLitre;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        if(equipType==null || equipType.equals("null")){equipType="";} 
        this.equipType = equipType;
    }

    public String getNewUsed() {
        return newUsed;
    }

    public void setNewUsed(String newUsed) {
        this.newUsed = newUsed;
    }

    public String getAssetEquip() {
        return assetEquip;
    }

    public void setAssetEquip(String assetEquip) {
        this.assetEquip = assetEquip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEquipMake() {
        return equipMake;
    }

    public void setEquipMake(String equipMake) {
        this.equipMake = equipMake;
    }

    public String getEquipModel() {
        return equipModel;
    }

    public void setEquipModel(String equipModel) {
        this.equipModel = equipModel;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getEquipSerialNo() {
        return equipSerialNo;
    }

    public void setEquipSerialNo(String equipSerialNo) {
        this.equipSerialNo = equipSerialNo;
    }

    public String getEquipLicense() {
        return equipLicense;
    }

    public void setEquipLicense(String equipLicense) {
        this.equipLicense = equipLicense;
    }

    public String getEquipChasis() {
        return equipChasis;
    }

    public void setEquipChasis(String equipChasis) {
        this.equipChasis = equipChasis;
    }

    public String getPuchaseDate() {
        return puchaseDate;
    }

    public void setPuchaseDate(String puchaseDate) {
        this.puchaseDate = puchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(String currentLoc) {
        this.currentLoc = currentLoc;
    }

    public String getEngineMake() {
        return engineMake;
    }

    public void setEngineMake(String engineMake) {
        this.engineMake = engineMake;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getEngineShape() {
        return engineShape;
    }

    public void setEngineShape(String engineShape) {
        this.engineShape = engineShape;
    }

    public String getEngineSerial() {
        return engineSerial;
    }

    public void setEngineSerial(String engineSerial) {
        this.engineSerial = engineSerial;
    }

    public String getTransMake() {
        return transMake;
    }

    public void setTransMake(String transMake) {
        this.transMake = transMake;
    }

    public String getMechDetails() {
        return mechDetails;
    }

    public void setMechDetails(String mechDetails) {
        this.mechDetails = mechDetails;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getServiceLoc() {
        return serviceLoc;
    }

    public void setServiceLoc(String serviceLoc) {
        this.serviceLoc = serviceLoc;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public double getRentMonth() {
        return rentMonth;
    }

    public void setRentMonth(double rentMonth) {
        this.rentMonth = rentMonth;
    }

    public double getRentHour() {
        return rentHour;
    }

    public void setRentHour(double rentHour) {
        this.rentHour = rentHour;
    }

    public String getPrevService1() {
        return prevService1;
    }

    public void setPrevService1(String prevService1) {
        this.prevService1 = prevService1;
    }

    public String getPrevService2() {
        return prevService2;
    }

    public void setPrevService2(String prevService2) {
        this.prevService2 = prevService2;
    }

    public String getLastServiceOn() {
        return lastServiceOn;
    }

    public void setLastServiceOn(String lastServiceOn) {
        this.lastServiceOn = lastServiceOn;
    }

    public String getNextServiceDue() {
        return nextServiceDue;
    }

    public void setNextServiceDue(String nextServiceDue) {
        this.nextServiceDue = nextServiceDue;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public String getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(String insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getInsuranceComp() {
        return insuranceComp;
    }

    public void setInsuranceComp(String insuranceComp) {
        this.insuranceComp = insuranceComp;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getEquipTypeCode() {
        return equipTypeCode;
    }

    public void setEquipTypeCode(String equipTypeCode) {
        this.equipTypeCode = equipTypeCode;
    }

    public String getRentedFrom() {
        return rentedFrom;
    }

    public void setRentedFrom(String rentedFrom) {
        this.rentedFrom = rentedFrom;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOwnedRented() {
        return ownedRented;
    }

    public void setOwnedRented(String ownedRented) {
        if(ownedRented==null || ownedRented.equals("null")){ownedRented="";}
        this.ownedRented = ownedRented;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    public String getDataBy() {
        return dataBy;
    }

    public void setDataBy(String dataBy) {
        this.dataBy = dataBy;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public ArrayList getDataArray() {
        return dataArray;
    }

    public void setDataArray(ArrayList dataArray) {
        this.dataArray = dataArray;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getWorkingHrs() {
        return workingHrs;
    }

    public void setWorkingHrs(String workingHrs) {
        if(workingHrs==null || workingHrs.equals("null")){workingHrs="";} 
        this.workingHrs = workingHrs;
    }

    public String getOvertimeHrs() {
        return overtimeHrs;
    }

    public void setOvertimeHrs(String overtimeHrs) {
        if(overtimeHrs==null || overtimeHrs.equals("null")){overtimeHrs="";} 
        this.overtimeHrs = overtimeHrs;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }
    
    public EquipBean removeNull(EquipBean eb){
    if(eb.getAssetEquip()==null || eb.getAssetEquip().equals("null")){eb.setAssetEquip("");}   
    //if(eb.getCapacity()==0.0){eb.setCapacity(0.0);}   
    if(eb.getCategory()==null || eb.getCategory().equals("null")){eb.setCategory("");}   
    if(eb.getCurrentLoc()==null || eb.getCurrentLoc().equals("null")){eb.setCurrentLoc("");}   
    if(eb.getEngineMake()==null || eb.getEngineMake().equals("null")){eb.setEngineMake("");}   
    if(eb.getEngineModel()==null || eb.getEngineModel().equals("null")){eb.setEngineModel("");}   
    if(eb.getEngineSerial()==null || eb.getEngineSerial().equals("null")){eb.setEngineSerial("");}   
    if(eb.getEngineShape()==null || eb.getEngineShape().equals("null")){eb.setEngineShape("");}   
    if(eb.getEquipChasis()==null || eb.getEquipChasis().equals("null")){eb.setEquipChasis("");}   
    if(eb.getEquipId()==null || eb.getEquipId().equals("null")){eb.setEquipId("");}   
    if(eb.getEquipLicense()==null || eb.getEquipLicense().equals("null")){eb.setEquipLicense("");}   
    if(eb.getEquipMake()==null || eb.getEquipMake().equals("null")){eb.setEquipMake("");}   
    if(eb.getEquipModel()==null || eb.getEquipModel().equals("null")){eb.setEquipModel("");}   
    if(eb.getEquipName()==null || eb.getEquipName().equals("null")){eb.setEquipName("");}   
    if(eb.getEquipSerialNo()==null || eb.getEquipSerialNo().equals("null")){eb.setEquipSerialNo("");}   
    if(eb.getEquipType()==null || eb.getEquipType().equals("null")){eb.setEquipType("");}   
    if(eb.getEquipTypeCode()==null || eb.getEquipTypeCode().equals("null")){eb.setEquipTypeCode("");}   
    if(eb.getExpiryDate()==null || eb.getExpiryDate().equals("null")){eb.setExpiryDate("");}   
    if(eb.getFromDate()==null || eb.getFromDate().equals("null")){eb.setFromDate("");}   
    if(eb.getFuelType()==null || eb.getFuelType().equals("null")){eb.setFuelType("");}   
    if(eb.getInsuranceComp()==null || eb.getInsuranceComp().equals("null")){eb.setInsuranceComp("");}   
    if(eb.getInsurancePolicy()==null || eb.getInsurancePolicy().equals("null")){eb.setInsurancePolicy("");}   
    //if(eb.getKmsPerLitre()==0.0){eb.setKmsPerLitre(0.0);}   
    if(eb.getLastServiceOn()==null || eb.getLastServiceOn().equals("null")){eb.setLastServiceOn("");}   
    if(eb.getLicenseType()==null || eb.getLicenseType().equals("null")){eb.setLicenseType("");}   
    if(eb.getMechDetails()==null || eb.getMechDetails().equals("null")){eb.setMechDetails("");}   
    if(eb.getModelYear()==null || eb.getModelYear().equals("null")){eb.setModelYear("");}   
    if(eb.getNewUsed()==null || eb.getNewUsed().equals("null")){eb.setNewUsed("");}   
    if(eb.getNextServiceDue()==null || eb.getNextServiceDue().equals("null")){eb.setNextServiceDue("");}   
    if(eb.getOperator()==null || eb.getOperator().equals("null")){eb.setOperator("");}   
    if(eb.getOwnedRented()==null || eb.getOwnedRented().equals("null")){eb.setOwnedRented("");}   
    if(eb.getPlateNo()==null || eb.getPlateNo().equals("null")){eb.setPlateNo("");}   
    if(eb.getPolicyType()==null || eb.getPolicyType().equals("null")){eb.setPolicyType("");}   
    if(eb.getPrevService1()==null || eb.getPrevService1().equals("null")){eb.setPrevService1("");}   
    if(eb.getPrevService2()==null || eb.getPrevService2().equals("null")){eb.setPrevService2("");}   
    if(eb.getProjectNo()==null || eb.getProjectNo().equals("null")){eb.setProjectNo("");}   
    if(eb.getPuchaseDate()==null || eb.getPuchaseDate().equals("null")){eb.setPuchaseDate("");}  
    
    //if(eb.getPurchasePrice()==0.0){eb.setPurchasePrice(0.0);}     
    //if(eb.getRentHour()==0.0){eb.setRentHour(0.0);}   
    //if(eb.getRentMonth()==0.0){eb.setRentMonth(0.0);}   
    
    if(eb.getRentedFrom()==null || eb.getRentedFrom().equals("null")){eb.setRentedFrom("");}   
    if(eb.getServiceLoc()==null || eb.getServiceLoc().equals("null")){eb.setServiceLoc("");}   
    if(eb.getStatus()==null || eb.getStatus().equals("null")){eb.setStatus("");}   
    if(eb.getTitle()==null || eb.getTitle().equals("null")){eb.setTitle("");}   
    if(eb.getToDate()==null || eb.getToDate().equals("null")){eb.setToDate("");}   
    if(eb.getTransMake()==null || eb.getTransMake().equals("null")){eb.setTransMake("");}   
    if(eb.getType1()==null || eb.getType1().equals("null")){eb.setType1("");}   
    if(eb.getType2()==null || eb.getType2().equals("null")){eb.setType2("");}   
    if(eb.getType3()==null || eb.getType3().equals("null")){eb.setType3("");}   
    if(eb.getType4()==null || eb.getType4().equals("null")){eb.setType4("");}   
    if(eb.getVendor()==null || eb.getVendor().equals("null")){eb.setVendor("");}   
    if(eb.getProjectName()==null || eb.getProjectName().equals("null")){eb.setProjectName("");}  
    if(eb.getWorkingHrs()==null || eb.getWorkingHrs().equals("null")){eb.setWorkingHrs("");}  
    if(eb.getOvertimeHrs()==null || eb.getOvertimeHrs().equals("null")){eb.setOvertimeHrs("");}  
    if(eb.getDated()==null || eb.getDated().equals("null")){eb.setDated("");}  
    return eb;    
    } 

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getGatePass() {
        return gatePass;
    }

    public void setGatePass(String gatePass) {
        if(gatePass==null || gatePass.equals("null")){gatePass="";}
        this.gatePass = gatePass;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        if(timeIn==null || timeIn.equals("null")){timeIn="";}
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut){
        if(timeOut==null || timeOut.equals("null")){timeOut="";}
        this.timeOut = timeOut;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if(comments==null || comments.equals("null")){comments="";} 
        this.comments = comments;
    }
}
