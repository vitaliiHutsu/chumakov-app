package ua.chumakov.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.chumakov.validation.CategoryValidTitleAnnotation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by vesa-pk on 06.09.2017.
 */
@Entity
public class Category implements Serializable, Comparable<Category>{
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min = 1)
    @CategoryValidTitleAnnotation
    private String title;
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

//    --------------- var by xml --------------------
    @Column(unique = true)
    private int xmlId;
    private int xmlParentId;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getXmlId() {
        return xmlId;
    }

    public void setXmlId(int xmlId) {
        this.xmlId = xmlId;
    }

    public int getXmlParentId() {
        return xmlParentId;
    }

    public void setXmlParentId(int xmlParentId) {
        this.xmlParentId = xmlParentId;
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


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(Category o) {
        return this.title.toUpperCase().compareTo(o.getTitle().toUpperCase());
    }
}
