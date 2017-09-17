package ua.chumakov.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by vesa-pk on 30.08.2017.
 */
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 1, message = "Поле не должно быть пустым")
    private String name;
    private String titleCompany;
    @Size(min = 1, message = "Поле не должно быть пустым")
    private String phone;
    private String email;
    private String skype;
    @Column(length = 500)
    private String notation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sales_clients",
            joinColumns = @JoinColumn(name = "sale_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"))
    private Set<Sale> sales;

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleCompany() {
        return titleCompany;
    }

    public void setTitleCompany(String titleCompany) {
        this.titleCompany = titleCompany;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", titleCompany:'" + titleCompany + '\'' +
                ", phone:'" + phone + '\'' +
                ", email:'" + email + '\'' +
                ", skype:'" + skype + '\'' +
                ", notation:'" + notation + '\'' +
                ", sale:" + sales +
                '}';
    }
}
