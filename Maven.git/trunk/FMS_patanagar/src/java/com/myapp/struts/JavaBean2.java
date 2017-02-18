package com.myapp.struts;

/**
 *
 * @author kanchan
 */
public class JavaBean2 {
    
    /** Creates a new instance of JavaBean2 */
    public JavaBean2() {
    }
    private String dated="";    
    private String compname="";
    private String amtdat="";
    private double amttopay=0.0;
    private double baltopay=0.0;
    private double amtpaid=0.0;
    private double baddebth=0.0;
    private double balance=0.0;
    private String reason="";
    private double tds=0.0;

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getAmtdat() {
        return amtdat;
    }

    public void setAmtdat(String amtdat) {
        this.amtdat = amtdat;
    }

    public double getAmttopay() {
        return amttopay;
    }

    public void setAmttopay(double amttopay) {
        this.amttopay = amttopay;
    }

    public double getBaltopay() {
        return baltopay;
    }

    public void setBaltopay(double baltopay) {
        this.baltopay = baltopay;
    }

    public double getAmtpaid() {
        return amtpaid;
    }

    public void setAmtpaid(double amtpaid) {
        this.amtpaid = amtpaid;
    }

    public double getBaddebth() {
        return baddebth;
    }

    public void setBaddebth(double baddebth) {
        this.baddebth = baddebth;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getTds() {
        return tds;
    }

    public void setTds(double tds) {
        this.tds = tds;
    }
    
    
}
