package io.github.rainbyte.testspring.service;

import io.github.rainbyte.testspring.dao.ArtistDAO;
import io.github.rainbyte.testspring.dao.GenericDAO;
import io.github.rainbyte.testspring.dto.ArtistDTO;
import io.github.rainbyte.testspring.dto.CountryDTO;
import io.github.rainbyte.testspring.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ArtistService implements GenericService<Artist, ArtistDTO> {

    @Autowired
    private ArtistDAO artistDAO;

    @Autowired
    private CountryService countryService;

    @Override
    public GenericDAO<Artist> getDAO() {
        return artistDAO;
    }

    @Override
    public ArtistDTO toDTO(Artist artist) {
        CountryDTO countryDTO = countryService.findById(artist.getCountry());
        return (countryDTO != null)
            ? new ArtistDTO(artist.getId(), artist.getNameNative(), artist.getNameRomanized(), countryDTO)
            : null;
    }

    @Override
    public Artist toEntity(ArtistDTO dto) {
        return new Artist(dto.getId(), dto.getNameNative(), dto.getNameRomanized(), dto.getCountry().getId());
    }
}