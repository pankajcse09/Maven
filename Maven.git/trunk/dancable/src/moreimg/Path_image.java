/*
 * Path_image.java
 *
 * Created on April 13, 2012, 1:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package moreimg;

/**
 *
 * @author user
 */
public class Path_image {
    
    /** Creates a new instance of Path_image */
    public Path_image() {
    }
    
    private String gallery="/home/cbsh/public_html/gallery";
    
    private String data_image="/Home/cbsh/public_html/data_image";
    
    
    private String gallery_url="http://www.cbsh.com/gallery";
    
    private String data_image_url="http://www.cbsh.com/data_image";
    
    
    

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getData_image() {
        return data_image;
    }

    public void setData_image(String data_image) {
        this.data_image = data_image;
    }

    public String getGallery_url() {
        return gallery_url;
    }

    public void setGallery_url(String gallery_url) {
        this.gallery_url = gallery_url;
    }

    public String getData_image_url() {
        return data_image_url;
    }

    public void setData_image_url(String data_image_url) {
        this.data_image_url = data_image_url;
    }
    
    
    
}
