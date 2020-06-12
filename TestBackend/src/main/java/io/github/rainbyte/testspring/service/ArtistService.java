package io.github.rainbyte.testspring.service;

import io.github.rainbyte.testspring.dao.ArtistDAO;
import io.github.rainbyte.testspring.dao.GenericDAO;
import io.github.rainbyte.testspring.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ArtistService implements GenericService<Artist> {

    @Autowired
    private ArtistDAO artistDAO;

    @Override
    public GenericDAO<Artist> getDAO() {
        return artistDAO;
    }
}