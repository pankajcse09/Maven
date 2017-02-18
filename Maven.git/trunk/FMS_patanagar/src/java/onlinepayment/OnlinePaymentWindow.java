/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinepayment;

/**
 *
 * @author kapil
 */
public class OnlinePaymentWindow {
    private int rowid;
    private String session;
    private String session_sem;
    private String degree;
    private java.util.Date from;
    private java.util.Date to;
    private String createdBy;
    private String updatedBy;
    private java.util.Date createdDate;
    private java.util.Date updatedDate;      

    /**
     * @return the rowid
     */
    public int getRowid() {
        return rowid;
    }

    /**
     * @param rowid the rowid to set
     */
    public void setRowid(int rowid) {
        this.rowid = rowid;
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
     * @return the degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @param degree the degree to set
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * @return the from
     */
    public java.util.Date getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(java.util.Date from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public java.util.Date getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(java.util.Date to) {
        this.to = to;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the createdDate
     */
    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updatedDate
     */
    public java.util.Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
