package io.github.rainbyte.testspring.controller;

import java.util.List;

import io.github.rainbyte.testspring.dto.ArtistDTO;
import io.github.rainbyte.testspring.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.github.rainbyte.testspring.entity.Artist;

@RestController
@RequestMapping("/artists")
class ArtistController {

    @Autowired
    private ArtistService artistService;

    @CrossOrigin
    @GetMapping
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{artistId}")
    public Artist getArtist(@PathVariable int artistId) {
        return artistService.findById(artistId);
    }

    @CrossOrigin
    @PostMapping
    public ArtistDTO addArtist(@RequestBody ArtistDTO artist) {
        artist.setId(0);
        artistService.save(artist);
        return artist;
    }

    @CrossOrigin
    @PutMapping
    public ArtistDTO updateArtist(@RequestBody ArtistDTO artist) {
        artistService.save(artist);
        return artist;
    }

    @CrossOrigin
    @DeleteMapping("/{artistId}")
    public String deleteArtist(@PathVariable int artistId) {
        Artist artist = artistService.findById(artistId);
        if(artist == null) {
            throw new RuntimeException("Artist not found - id " + artistId);
        }
        artistService.deleteById(artistId);
        return "Deleted user - id "+ artistId;
    }
}