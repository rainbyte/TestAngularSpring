package io.github.rainbyte.testspring.dto;

public class AlbumDTO implements GenericDTO {
    private int id;
    private String nameNative;
    private String nameRomaji;
    private int artistId;
    private int year;

    public AlbumDTO(int id, String nameNative, String nameRomaji, int artistId, int year) {
        this.id = id;
        this.nameNative = nameNative;
        this.nameRomaji = nameRomaji;
        this.artistId = artistId;
        this.year = year;
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
