
package Main_category;

/**
 *
 * @author kapil
 */


public class CountryBean {
    private int id=0;
    private String country="";
    private String countryCode="";
    private String state="";
    private int code=0;
    private double shippingCharge=0.0;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the shippingCharge
     */
    public double getShippingCharge() {
        return shippingCharge;
    }

    /**
     * @param shippingCharge the shippingCharge to set
     */
    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }
}
