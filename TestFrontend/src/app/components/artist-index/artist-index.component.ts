import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

import { Artist } from "../../model/artist.model";
import { ArtistService } from "../../service/artist.service";

@Component({
  selector: 'artist-index',
  templateUrl: './artist-index.component.html',
  styleUrls: ['./artist-index.component.css']
})

export class ArtistIndexComponent implements OnInit {
  artists: Artist[];
  artistsRaw: Artist[];

  constructor(private router: Router, private artistService: ArtistService) { }

  ngOnInit() {
    this.artistService.getArtists()
      .subscribe(artists => {
        this.artistsRaw = artists;
        this.filterArtists(null);
      })
  }

  createArtist() {
    this.router.navigate(["artist-create"]);
  }

  updateArtist(artist: Artist) {
    localStorage.removeItem("updateArtistId");
    localStorage.setItem("updateArtistId", artist.id.toString());
    this.router.navigate(["artist-update"]);
  }

  deleteArtist(artist: Artist) {
    this.artistService.deleteArtist(artist.id)
      .subscribe(data => {
        this.artists = this.artists.filter(x => x !== artist);
      });
  }

  viewAlbums(artist: Artist) {
    localStorage.removeItem("albumsArtistId");
    localStorage.setItem("albumsArtistId", artist.id.toString());
    this.router.navigate(["artist-albums-index"]);
  }

  filterArtists(searchString) {
    if (searchString === null || searchString === "") {
      this.artists = this.artistsRaw;
    } else {
      this.artists = this.artistsRaw.filter(artist => {
        const searchNorm = searchString.toLowerCase();
        const nativeNorm = artist.nameNative.toLowerCase();
        const romajiNorm = artist.nameRomanized.toLowerCase();
        return nativeNorm.includes(searchNorm) || romajiNorm.includes(searchNorm);
      })
    }
  }
}
