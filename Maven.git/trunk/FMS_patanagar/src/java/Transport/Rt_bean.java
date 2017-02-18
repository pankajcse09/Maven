/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

/**
 *
 * @author kapil
 */
public class Rt_bean {
    private String route="";
    private String place="";
    private double fare=0.0;
    int id=0;
    
    public String getRoute(){
        return route;
    }
    public void setRoute(String route){
        this.route=route;
    }
    
    public String getPlace(){
        return place;
    }
    public void setPlace(String place){
        this.place=place;
    }
    
    public double getFare(){
        return fare;
    }
    public void setFare(double fare){
        this.fare=fare;
    }  
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
}
