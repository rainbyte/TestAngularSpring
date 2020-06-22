package io.github.rainbyte.testspring.service;

import io.github.rainbyte.testspring.dao.AlbumDAO;
import io.github.rainbyte.testspring.dao.GenericDAO;
import io.github.rainbyte.testspring.dto.AlbumDTO;
import io.github.rainbyte.testspring.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AlbumService implements GenericService<Album, AlbumDTO> {

    @Autowired
    private AlbumDAO albumDAO;

    @Autowired
    private ArtistService artistService;

    @Override
    public GenericDAO<Album> getDAO() {
        return albumDAO;
    }

    @Override
    public AlbumDTO toDTO(Album album) {
        return new AlbumDTO(album.getId(), album.getNameNative(), album.getNameRomaji(), album.getArtistId(), album.getYear());
    }

    @Override
    public Album toEntity(AlbumDTO dto) {
        return new Album(dto.getId(), dto.getNameNative(), dto.getNameRomaji(), dto.getArtistId(), dto.getYear());
    }

    public Collection<AlbumDTO> findByArtistId(int artistId) {
        return albumDAO.findByArtistId(artistId).stream().map(this::toDTO).collect(Collectors.toSet());
    }
}
