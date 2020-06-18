package io.github.rainbyte.testspring.service;

import io.github.rainbyte.testspring.dao.CountryDAO;
import io.github.rainbyte.testspring.dao.GenericDAO;
import io.github.rainbyte.testspring.dto.CountryDTO;
import io.github.rainbyte.testspring.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements GenericService<Country, CountryDTO> {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public GenericDAO<Country> getDAO() {
        return countryDAO;
    }

    @Override
    public CountryDTO toDTO(Country country) {
        return new CountryDTO(country.getId(), country.getName());
    }

    @Override
    public Country toEntity(CountryDTO dto) {
        return new Country(dto.getId(), dto.getName());
    }
}
