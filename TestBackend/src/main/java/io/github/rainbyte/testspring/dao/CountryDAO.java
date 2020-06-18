package io.github.rainbyte.testspring.dao;

import io.github.rainbyte.testspring.entity.Country;
import io.github.rainbyte.testspring.repo.CountryRepo;
import io.github.rainbyte.testspring.repo.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAO implements GenericDAO<Country> {
    @Autowired
    private CountryRepo countryRepo;

    @Override
    public GenericRepo<Country> getRepo() {
        return countryRepo;
    }
}
