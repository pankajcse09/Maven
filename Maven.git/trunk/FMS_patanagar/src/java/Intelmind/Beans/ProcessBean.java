/*
 * StoreBean.java
 *
 * Created on October 20, 2009, 12:55 PM
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

public class ProcessBean {
    
    /** Creates a new instance of StoreBean */
    public ProcessBean(){
    }    
    private int month=0;
    private String year="";
    private String monthYear="";
    private String brandName="";
    private String location="";
    private String plateNo="";
    private String inspectDate="";
    private String inspectBy="";
    private String hourMeter="";
    private String directive="";
    private String remarks="";
    
    private String status="";
    private String rowId="";
    private String item="";
    private String dated="";
    private String serviceCode="";
    private String serviceDesc="";
    
    private String defectCode="";
    private String defectDesc="";
    private String defReported="";
    private String defSummary="";     
    
    private String repairCode="";
    private String repairDesc="";
    private String repReported="";
    private String repSummary=""; 
    
    private String empCode=""; 
    private String empName=""; 
    private String fromDate=""; 
    private String toDate=""; 
    private double basicPay=0.0; 
    private double hrsWorked=0.0; 
    private double rate=0.0; 
    private double totalAmount=0.0; 
    private double totalAmount2=0.0; 
    private double overhead=0.0; 
    private double netAmount=0.0; 
 
    private String jobCard=""; 
    private String issueNo=""; 
    private String description="";     
    private int units=0; 
    private double unitPrice=0.0; 
    private double amount=0.0; 
    private String otherWorks=""; 
    private double otherAmount=0.0; 
    private ArrayList dataArray=new ArrayList();
    private List dataArray2=new ArrayList();
    
    public String getDefectCode() {
        return defectCode;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public String getDefectDesc() {
        return defectDesc;
    }

    public void setDefectDesc(String defectDesc) {
        this.defectDesc = defectDesc;
    }

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode;
    }

    public String getRepairDesc() {
        return repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getDefReported() {
        return defReported;
    }

    public void setDefReported(String defReported) {
        this.defReported = defReported;
    }

    public String getDefSummary() {
        return defSummary;
    }

    public void setDefSummary(String defSummary) {
        this.defSummary = defSummary;
    }

    public String getRepReported() {
        return repReported;
    }

    public void setRepReported(String repReported) {
        this.repReported = repReported;
    }

    public String getRepSummary() {
        return repSummary;
    }

    public void setRepSummary(String repSummary) {
        this.repSummary = repSummary;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getHrsWorked() {
        return hrsWorked;
    }

    public void setHrsWorked(double hrsWorked) {
        this.hrsWorked = hrsWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getOverhead() {
        return overhead;
    }

    public void setOverhead(double overhead) {
        this.overhead = overhead;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public String getJobCard() {
        return jobCard;
    }

    public void setJobCard(String jobCard) {
        this.jobCard = jobCard;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(double otherAmount) {
        this.otherAmount = otherAmount;
    }

    public String getOtherWorks() {
        return otherWorks;
    }

    public void setOtherWorks(String otherWorks) {
        this.otherWorks = otherWorks;
    }

    public double getTotalAmount2() {
        return totalAmount2;
    }

    public void setTotalAmount2(double totalAmount2) {
        this.totalAmount2 = totalAmount2;
    }
    
    public ProcessBean removeNull(ProcessBean pb){
    //if(pb.getAmount()==0.0){pb.setAmount(0.0);}   
    //if(pb.getBasicPay()==0.0){pb.setBasicPay(0.0);}        
    if(pb.getDated()==null || pb.getDated().equals("null")){pb.setDated("");}        
    if(pb.getDefReported()==null || pb.getDefReported().equals("null")){pb.setDefReported("");}        
    if(pb.getDefSummary()==null || pb.getDefSummary().equals("null")){pb.setDefSummary("");}        
    if(pb.getDefectCode()==null || pb.getDefectCode().equals("null")){pb.setDefectCode("");}        
    if(pb.getDefectDesc()==null || pb.getDefectDesc().equals("null")){pb.setDefectDesc("");}        
    if(pb.getDescription()==null || pb.getDescription().equals("null")){pb.setDescription("");}        
    if(pb.getEmpCode()==null || pb.getEmpCode().equals("null")){pb.setEmpCode("");}        
    if(pb.getEmpName()==null || pb.getEmpName().equals("null")){pb.setEmpName("");}        
    if(pb.getFromDate()==null || pb.getFromDate().equals("null")){pb.setFromDate("");}        
    if(pb.getHrsWorked()==0.0){pb.setHrsWorked(0.0);}        
    if(pb.getIssueNo()==null){pb.setIssueNo("");}        
    if(pb.getJobCard()==null){pb.setJobCard("");}        
    if(pb.getNetAmount()==0.0){pb.setNetAmount(0.0);}        
    if(pb.getOtherAmount()==0.0){pb.setOtherAmount(0.0);}        
    if(pb.getOtherWorks()==null || pb.getOtherWorks().equals("null")){pb.setOtherWorks("");}        
    if(pb.getOverhead()==0.0){pb.setOverhead(0.0);}        
    if(pb.getRate()==0.0){pb.setRate(0.0);}        
    if(pb.getRepReported()==null || pb.getRepReported().equals("null")){pb.setRepReported("");}        
    if(pb.getRepSummary()==null || pb.getRepSummary().equals("null")){pb.setRepSummary("");}        
    if(pb.getRepairCode()==null || pb.getRepairCode().equals("null")){pb.setRepairCode("");}        
    if(pb.getRepairDesc()==null || pb.getRepairDesc().equals("null")){pb.setRepairDesc("");}        
    if(pb.getServiceCode()==null || pb.getServiceCode().equals("null")){pb.setServiceCode("");}        
    if(pb.getServiceDesc()==null || pb.getServiceDesc().equals("null")){pb.setServiceDesc("");}    
    if(pb.getToDate()==null || pb.getToDate().equals("null")){pb.setToDate("");}   
    if(pb.getTotalAmount()==0.0){pb.setTotalAmount(0.0);}   
    if(pb.getTotalAmount2()==0.0){pb.setTotalAmount2(0.0);}   
    if(pb.getUnitPrice()==0.0){pb.setUnitPrice(0.0);}   
    if(pb.getUnits()==0){pb.setUnits(0);}   
    return pb;    
    }    

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
    if(item==null || item.equals("null")){item="";}     
        this.item = item;
    }

    public ArrayList getDataArray() {
        return dataArray;
    }

    public void setDataArray(ArrayList dataArray) {
        this.dataArray = dataArray;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
    this.units = units;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status==null || status.equals("null")){status="";}
        this.status = status;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if(brandName==null || brandName.equals("null")){brandName="";}
        this.brandName = brandName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if(location==null || location.equals("null")){location="";}
        this.location = location;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        if(plateNo==null || plateNo.equals("null")){plateNo="";}
        this.plateNo = plateNo;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        if(inspectDate==null || inspectDate.equals("null")){inspectDate="";}
        this.inspectDate = inspectDate;
    }

    public String getInspectBy(){
        return inspectBy;
    }

    public void setInspectBy(String inspectBy) {
        if(inspectBy==null || inspectBy.equals("null")){inspectBy="";}
        this.inspectBy = inspectBy;
    }

    public String getHourMeter() {
        return hourMeter;
    }

    public void setHourMeter(String hourMeter) {
        if(hourMeter==null || hourMeter.equals("null")){hourMeter="";}
        this.hourMeter = hourMeter;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        if(directive==null || directive.equals("null")){directive="";}
        this.directive = directive;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        if(remarks==null || remarks.equals("null")){remarks="";}
        this.remarks = remarks;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List getDataArray2() {
        return dataArray2;
    }

    public void setDataArray2(List dataArray2) {
        this.dataArray2 = dataArray2;
    }

}
