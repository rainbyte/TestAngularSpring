package io.github.rainbyte.testspring.service;

import java.util.List;

import io.github.rainbyte.testspring.dao.ArtistDAO;
import io.github.rainbyte.testspring.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistDAO artistDAO;

    @Override
    public List<Artist> findAll() {
        return artistDAO.findAll();
    }

    @Override
    public Artist findById(int id) {
        return artistDAO.findById(id);
    }

    @Override
    public void save(Artist artist) {
        artistDAO.save(artist);
    }

    @Override
    public void deleteById(int id) {
        artistDAO.deleteById(id);
    }
}