package io.github.rainbyte.testspring.dao;

import io.github.rainbyte.testspring.entity.Artist;
import io.github.rainbyte.testspring.repo.ArtistRepo;
import io.github.rainbyte.testspring.repo.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDAO implements GenericDAO<Artist> {
    @Autowired
    private ArtistRepo artistRepo;

    @Override
    public GenericRepo<Artist> getRepo() {
        return artistRepo;
    }
}
