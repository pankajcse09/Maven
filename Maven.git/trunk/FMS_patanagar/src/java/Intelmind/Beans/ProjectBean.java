package Intelmind.Beans;

/**
 *
 * @author Intelmind
 */
public class ProjectBean {
    
    /** Creates a new instance of PartyBean */
    public ProjectBean(){
    }
    
    private String projectId="";
    private String projectName="";
    private String manager="";
    private String leader="";
    private String area="";
    private String site="";
    private String dated="";        
    private String duration="";
    private String client="";
    private String clientAddress="";
    private String location="";
    private String expectComplete="";
    private String contact="";
    private String status="";

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId){
        if(projectId.equals("")){projectId="";}
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        if(projectName.equals("")){projectName="";}
        this.projectName = projectName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        if(manager.equals("")){manager="";}
        this.manager = manager;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        if(leader.equals("")){leader="";}
        this.leader = leader;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if(area.equals("")){area="";}
        this.area = area;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        if(site.equals("")){site="";}
        this.site = site;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        if(dated.equals("")){dated="";}
        this.dated = dated;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        if(duration.equals("")){duration="";}
        this.duration = duration;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        if(client.equals("")){client="";}
        this.client = client;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        if(clientAddress.equals("")){clientAddress="";}
        this.clientAddress = clientAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if(location.equals("")){location="";}
        this.location = location;
    }

    public String getExpectComplete() {
        return expectComplete;
    }

    public void setExpectComplete(String expectComplete) {
        if(expectComplete.equals("")){expectComplete="";}
        this.expectComplete = expectComplete;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        if(contact.equals("")){contact="";}
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status.equals("")){status="";}
        this.status = status;
    }

}
