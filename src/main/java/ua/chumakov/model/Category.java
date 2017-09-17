package ua.chumakov.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.chumakov.validation.CategoryValidTitleAnnotation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by vesa-pk on 06.09.2017.
 */
@Entity
public class Category implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @Size(min = 1)
    @CategoryValidTitleAnnotation
    private String title;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<BrandModel> brandModels;

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

    public Set<BrandModel> getBrandModels() {
        return brandModels;
    }

    public void setBrandModels(Set<BrandModel> brandModels) {
        this.brandModels = brandModels;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
