package io.github.rainbyte.testspring.dto;

import io.github.rainbyte.testspring.entity.Artist;

public class ArtistDTO implements GenericDTO<Artist> {
    private int id;
    private String nameNative;
    private String nameRomanized;
    private String country;

    public ArtistDTO(int id, String nameNative, String nameRomanized, String country) {
        this.id = id;
        this.nameNative = nameNative;
        this.nameRomanized = nameRomanized;
        this.country = country;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ArtistDTO fromEntity(Artist artist) {
        return new ArtistDTO(artist.getId(), artist.getNameNative(), artist.getNameRomanized(), artist.getCountry());
    }

    @Override
    public Artist toEntity() {
        return new Artist(id, nameNative, nameRomanized, country);
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
