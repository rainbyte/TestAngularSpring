package io.github.rainbyte.testspring.dao;

import java.util.List;

import io.github.rainbyte.testspring.entity.Artist;

public interface ArtistDAO {
    List<Artist> findAll();
    Artist findById(int id);
    void save(Artist artist);
    void deleteById(int id);
}