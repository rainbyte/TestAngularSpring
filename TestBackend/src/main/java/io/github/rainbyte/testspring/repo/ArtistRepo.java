package io.github.rainbyte.testspring.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
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

    @Override
    public List<Artist> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Artist> query =
            currentSession.createQuery("FROM Artist", Artist.class);
        return query.getResultList();
    }

    @Override
    public Artist findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Artist.class, id);
    }

    @Override
    public void save(Artist artist) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(artist);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Artist> query =
            currentSession.createQuery("DELETE FROM Artist WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}