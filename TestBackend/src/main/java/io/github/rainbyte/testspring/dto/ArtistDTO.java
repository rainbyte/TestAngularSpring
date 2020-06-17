package io.github.rainbyte.testspring.dto;

public class ArtistDTO implements GenericDTO {
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
