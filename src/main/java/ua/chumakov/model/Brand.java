package ua.chumakov.model;

import ua.chumakov.validation.BrandValidTitleAnnotation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Brand implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @BrandValidTitleAnnotation
    private String title;
    private String notation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "brand_and_brand_model",
            joinColumns = @JoinColumn(name = "brand_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "brand_model_id", referencedColumnName = "id"))
    private Set<BrandModel> brandModels;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "brand_and_provider",
            joinColumns = @JoinColumn(name = "brand_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "id"))
    private Set<Provider> providers;

    public Set<Provider> getProviders() {
        return providers;
    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }

    public Set<BrandModel> getBrandModels() {
        return brandModels;
    }

    public void setBrandModels(Set<BrandModel> brandModels) {
        this.brandModels = brandModels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
