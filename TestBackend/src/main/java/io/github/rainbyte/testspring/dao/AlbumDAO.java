package io.github.rainbyte.testspring.dao;

import io.github.rainbyte.testspring.entity.Album;
import io.github.rainbyte.testspring.repo.AlbumRepo;
import io.github.rainbyte.testspring.repo.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class AlbumDAO implements GenericDAO<Album> {

    @Autowired
    private AlbumRepo albumRepo;

    @Override
    public GenericRepo<Album> getRepo() {
        return albumRepo;
    }

    public Collection<Album> findByArtistId(int artistId) {
        return albumRepo.findByArtistId(artistId);
    }
}
