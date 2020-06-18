package io.github.rainbyte.testspring.entity;

import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public final class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    private Country() { }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
