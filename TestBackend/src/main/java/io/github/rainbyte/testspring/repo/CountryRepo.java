package io.github.rainbyte.testspring.repo;

import io.github.rainbyte.testspring.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CountryRepo implements GenericRepo<Country> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Class<Country> toEntityClass() {
        return Country.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
