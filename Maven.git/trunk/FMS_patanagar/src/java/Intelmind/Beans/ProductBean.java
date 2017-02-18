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
public class ProductBean {
    
    /** Creates a new instance of StoreBean */
    public ProductBean(){
    }
    
    private String prodCode="";
    private String oemNo="";
    private String prodName="";
    private String dated="";
    private String batchNo="";
    private String shelfNo="";
    private String binNo="";
    private String brand="";
    private String costCode="";
    private String majorCatCode="";
    private String basicUnit="";
    private String masterPack="";
    private String sellPrice="";
    private String itemType="";
    private String cost="";
    private String rol="";
    private String opStock="";
    private String clStock="";
    private String remarks="";

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getOemNo() {
        return oemNo;
    }

    public void setOemNo(String oemNo) {
        this.oemNo = oemNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    public String getBinNo() {
        return binNo;
    }

    public void setBinNo(String binNo) {
        this.binNo = binNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCostCode() {
        return costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public String getMajorCatCode() {
        return majorCatCode;
    }

    public void setMajorCatCode(String majorCatCode) {
        this.majorCatCode = majorCatCode;
    }

    public String getBasicUnit() {
        return basicUnit;
    }

    public void setBasicUnit(String basicUnit) {
        this.basicUnit = basicUnit;
    }

    public String getMasterPack() {
        return masterPack;
    }

    public void setMasterPack(String masterPack) {
        this.masterPack = masterPack;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getOpStock() {
        return opStock;
    }

    public void setOpStock(String opStock) {
        this.opStock = opStock;
    }

    public String getClStock() {
        return clStock;
    }

    public void setClStock(String clStock) {
        this.clStock = clStock;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public ProductBean removeNull(ProductBean pb){
        
    if(pb.getBasicUnit()==null || pb.getBasicUnit().equals("null")){pb.setBasicUnit("");}   
    if(pb.getBatchNo()==null || pb.getBatchNo().equals("null")){pb.setBatchNo("");}  
    if(pb.getBinNo()==null || pb.getBinNo().equals("null")){pb.setBinNo("");}    
    if(pb.getBrand()==null || pb.getBrand().equals("null")){pb.setBrand("");}    
    if(pb.getClStock()==null || pb.getClStock().equals("null")){pb.setClStock("");}    
    if(pb.getCost()==null || pb.getCost().equals("null")){pb.setCost("");}    
    if(pb.getCostCode()==null || pb.getCostCode().equals("null")){pb.setCostCode("");}    
    if(pb.getDated()==null || pb.getDated().equals("null")){pb.setDated("");}    
    if(pb.getItemType()==null || pb.getItemType().equals("null")){pb.setItemType("");}    
    if(pb.getMajorCatCode()==null || pb.getMajorCatCode().equals("null")){pb.setMajorCatCode("");}    
    if(pb.getMasterPack()==null || pb.getMasterPack().equals("null")){pb.setMasterPack("");}    
    if(pb.getOemNo()==null || pb.getOemNo().equals("null")){pb.setOemNo("");}   
    
    if(pb.getOpStock()==null || pb.getOpStock().equals("null")){pb.setOpStock("");}    
    if(pb.getProdCode()==null || pb.getProdCode().equals("null")){pb.setProdCode("");}    
    if(pb.getProdName()==null || pb.getProdName().equals("null")){pb.setProdName("");}    
    if(pb.getRemarks()==null || pb.getRemarks().equals("null")){pb.setRemarks("");}    
    if(pb.getRol()==null || pb.getRol().equals("null")){pb.setRol("");} 
    if(pb.getSellPrice()==null || pb.getSellPrice().equals("null")){pb.setSellPrice("");}   
    if(pb.getShelfNo()==null || pb.getShelfNo().equals("null")){pb.setShelfNo("");}    
    return pb;    
    } 
    
}
