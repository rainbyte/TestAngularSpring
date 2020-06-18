package io.github.rainbyte.testspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name_native")
    private String nameNative;

    @Column(name="name_romanized")
    private String nameRomanized;

    @Column(name="country")
    private int country;

    public Artist() {}

    public Artist(int id, String nameNative, String nameRomanized, int country) {
        this.id = id;
        this.nameNative = nameNative;
        this.nameRomanized = nameRomanized;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameNative() {
        return nameNative;
    }

    public void setNameNative(String nameNative) {
        this.nameNative = nameNative;
    }

    public String getNameRomanized() {
        return nameRomanized;
    }

    public void setNameRomanized(String nameRomanized) {
        this.nameRomanized = nameRomanized;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}