package ua.chumakov.model.proxy.model;

import ua.chumakov.model.Brand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by vesa-pk on 19.09.2017.
 */
public class ProxyBrandModel implements Serializable{
    private int id;
    private String title;
    private double purchasePrice;
    private double sellingPrice;
    private List<String> brands;
    private String notation;

    public ProxyBrandModel(int id, String title, double purchasePrice, double sellingPrice, String notation) {
        this.id = id;
        this.title = title;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.notation = notation;
    }

    public ProxyBrandModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public void setTitleBrend(Set<Brand> titleBrend){

        brands = new ArrayList<>();
        for (Brand brand: titleBrend) {
            brands.add(brand.getTitle());
        }
    }
}
