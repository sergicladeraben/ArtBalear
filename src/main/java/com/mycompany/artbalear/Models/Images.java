
package com.mycompany.artbalear.Models;


public class Images {
 private int id;
 private String url;

    public Images(int id, String url) {
        this.id = id;
        this.url = url;
    }
 
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Images{" + "id=" + id + ", url=" + url + '}';
    }
 
 
}
