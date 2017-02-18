/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinepayment;

import java.io.Serializable;

/**
 *
 * @author kapil
 */
public class PaymentDetailBean implements Serializable{

    private Long rowid;
    private String email;
    private String stud_id;
    private String session;
    private String session_sem;
    private String trIdByGateway;
    private String transactionId;
    private Double amount;
    private String payeeName;
    private String mobile;
    private java.util.Date date;
    private String gatewayStatus;
    private String appStatus;

    /**
     * @return the rowid
     */
    public Long getRowid() {
        return rowid;
    }

    /**
     * @param rowid the rowid to set
     */
    public void setRowid(Long rowid) {
        this.rowid = rowid;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the stud_id
     */
    public String getStud_id() {
        return stud_id;
    }

    /**
     * @param stud_id the stud_id to set
     */
    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    /**
     * @return the session
     */
    public String getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * @return the session_sem
     */
    public String getSession_sem() {
        return session_sem;
    }

    /**
     * @param session_sem the session_sem to set
     */
    public void setSession_sem(String session_sem) {
        this.session_sem = session_sem;
    }

    /**
     * @return the trIdByGateway
     */
    public String getTrIdByGateway() {
        return trIdByGateway;
    }

    /**
     * @param trIdByGateway the trIdByGateway to set
     */
    public void setTrIdByGateway(String trIdByGateway) {
        this.trIdByGateway = trIdByGateway;
    }

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the payeeName
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * @param payeeName the payeeName to set
     */
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the date
     */
    public java.util.Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

    /**
     * @return the gatewayStatus
     */
    public String getGatewayStatus() {
        return gatewayStatus;
    }

    /**
     * @param gatewayStatus the gatewayStatus to set
     */
    public void setGatewayStatus(String gatewayStatus) {
        this.gatewayStatus = gatewayStatus;
    }

    /**
     * @return the appStatus
     */
    public String getAppStatus() {
        return appStatus;
    }

    /**
     * @param appStatus the appStatus to set
     */
    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }
}
