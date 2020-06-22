package io.github.rainbyte.testspring.entity;

import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name_native")
    private String nameNative;

    @Column(name="name_romaji")
    private String nameRomaji;

    @Column(name="artist_id")
    private int artistId;

    @Column(name="year")
    private int year;

    public Album() {}

    public Album(int id, String nameNative, String nameRomaji, int year, int artistId) {
        this.id = id;
        this.nameNative = nameNative;
        this.nameRomaji = nameRomaji;
        this.year = year;
        this.artistId = artistId;
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

    public String getNameRomaji() {
        return nameRomaji;
    }

    public void setNameRomaji(String nameRomaji) {
        this.nameRomaji = nameRomaji;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
