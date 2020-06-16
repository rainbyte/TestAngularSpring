package io.github.rainbyte.testspring.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.rainbyte.testspring.entity.Artist;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistRepo implements GenericRepo<Artist> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Class<Artist> toEntityClass() {
        return Artist.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}