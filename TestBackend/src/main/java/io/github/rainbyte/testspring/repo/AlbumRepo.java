package io.github.rainbyte.testspring.repo;

import io.github.rainbyte.testspring.entity.Album;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class AlbumRepo implements GenericRepo<Album> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Class<Album> toEntityClass() {
        return Album.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Collection<Album> findByArtistId(int artistId) {
        Query<Album> query = getSession().createQuery(
                "FROM " + toEntityClass().getName() + " WHERE artist_id=:artist_id");
        query.setParameter("artist_id", artistId);
        return query.getResultList();
    }
}
