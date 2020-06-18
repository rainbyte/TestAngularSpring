package io.github.rainbyte.testspring.controller;

import java.util.List;

import io.github.rainbyte.testspring.dto.ArtistDTO;
import io.github.rainbyte.testspring.service.ArtistService;
import io.github.rainbyte.testspring.utils.AppException;
import io.github.rainbyte.testspring.utils.ResponseWrapper;
import io.github.rainbyte.testspring.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.github.rainbyte.testspring.utils.ResponseWrapper.responseFailure;
import static io.github.rainbyte.testspring.utils.ResponseWrapper.responseSuccess;

@RestController
@RequestMapping("/artists")
class ArtistController {

    @Autowired
    private ArtistService artistService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<ResponseWrapper<List<ArtistDTO>>> findAll() {
        return responseSuccess(artistService.findAll());
    }

    @CrossOrigin
    @GetMapping("/{artistId}")
    public ResponseEntity<ResponseWrapper<ArtistDTO>> getArtist(@PathVariable int artistId) {
        try {
            ArtistDTO artist = artistService.findById(artistId);
            Validation.checkNull(artist, "Artist not found");
            return responseSuccess(artist);
        } catch (AppException e) {
            return responseFailure(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<ResponseWrapper<ArtistDTO>> addArtist(@RequestBody ArtistDTO artist) {
        try {
            Validation.checkString(artist.getNameNative(), "NativeName should not be empty");
            Validation.checkNull(artist.getCountry(), "Country should not be empty");
            Validation.checkString(artist.getCountry().getName(), "Country name is invalid");
            artist.setId(0);
            artistService.save(artist);
            return responseSuccess(artist);
        } catch (AppException e) {
            return responseFailure(e.getMessage());
        }
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<ResponseWrapper<ArtistDTO>> updateArtist(@RequestBody ArtistDTO artist) {
        try {
            Validation.checkNull(artist, "Artist is invalid");
            artistService.save(artist);
            return responseSuccess(artist);
        } catch (AppException e) {
            return responseFailure(e.getMessage());
        }
    }

    @CrossOrigin
    @DeleteMapping("/{artistId}")
    public ResponseEntity<ResponseWrapper<String>> deleteArtist(@PathVariable int artistId) {
        try {
            ArtistDTO artist = artistService.findById(artistId);
            Validation.checkNull(artist, "Artist not found - id " + artistId);
            artistService.deleteById(artistId);
            return responseSuccess("Deleted user - id " + artistId);
        } catch (AppException e) {
            return responseFailure(e.getMessage());
        }
    }
}