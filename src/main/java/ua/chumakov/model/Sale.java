package ua.chumakov.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by vesa-pk on 30.08.2017.
 */
@Entity
public class Sale implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_and_user_id")
    private User user;
    @ManyToMany(mappedBy = "sales")
    private Set<Client> clients;

    @ManyToMany(mappedBy = "sales")
    private Set<BrandModel> brandModels;

    public Set<BrandModel> getBrandModels() {
        return brandModels;
    }

    public void setBrandModels(Set<BrandModel> brandModels) {
        this.brandModels = brandModels;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
