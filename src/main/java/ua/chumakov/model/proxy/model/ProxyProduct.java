package ua.chumakov.model.proxy.model;

import java.io.Serializable;

/**
 * Created by vesa-pk on 02.10.2017.
 */
public class ProxyProduct implements Serializable{
    private int id;
    private int xmlId;
    private double price;
    private String url;
    private String picture;
    private String name;
    private String vendor;
    private String vendorCode;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXmlId() {
        return xmlId;
    }

    public void setXmlId(int xmlId) {
        this.xmlId = xmlId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
