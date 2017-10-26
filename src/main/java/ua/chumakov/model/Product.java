package ua.chumakov.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //    @Column(unique = true)
    private int xmlId;
    private double price;
    private String url;
    @Lob
    @Column(length = 512)
    private String picture;
    private String name;
    private String vendor;
    private String vendorCode;
    @Lob
    @Column(length = 512)
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", xmlId=" + xmlId +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
