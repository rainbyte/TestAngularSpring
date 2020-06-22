package io.github.rainbyte.testspring.dto;

import java.util.Collection;
import java.util.HashSet;

public class ArtistDTO implements GenericDTO {
    private int id;
    private String nameNative;
    private String nameRomanized;
    private CountryDTO country;
    private Collection<AlbumDTO> albums;

    public ArtistDTO(int id, String nameNative, String nameRomanized, CountryDTO country) {
        this.id = id;
        this.nameNative = nameNative;
        this.nameRomanized = nameRomanized;
        this.country = country;
        this.albums = new HashSet<>();
    }

    public ArtistDTO(int id, String nameNative, String nameRomanized, CountryDTO country, Collection<AlbumDTO> albums) {
        this(id, nameNative, nameRomanized, country);
        this.addAlbums(albums);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public Collection<AlbumDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(Collection<AlbumDTO> albums) {
        this.albums = albums;
    }

    public void addAlbums(Collection<AlbumDTO> albums) {
        this.albums.addAll(albums);
    }
}
