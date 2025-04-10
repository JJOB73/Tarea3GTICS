package com.example.tareaclase3.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private String id;

    private String countryName;

    public Country() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
}

