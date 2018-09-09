package com.sda.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private String city;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> bookSet;

    public Publisher(String name, String adress, String city) {
        this.name = name;
        this.adress = adress;
        this.city = city;
    }

    public Publisher() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
