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

  constructor(private router: Router, private artistService: ArtistService) { }

  ngOnInit() {
    this.artistService.getArtists()
      .subscribe(artists => {
        this.artists = artists;
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
}
