package io.github.rainbyte.testspring.service;

import java.util.List;

import io.github.rainbyte.testspring.entity.Artist;

public interface ArtistService {
    List<Artist> findAll();
    Artist findById(int id);
    void save(Artist artist);
    void deleteById(int id);
}