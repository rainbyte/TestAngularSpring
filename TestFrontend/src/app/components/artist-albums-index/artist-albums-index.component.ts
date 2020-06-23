import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

import { Album } from 'src/app/model/album.model';
import { Artist } from 'src/app/model/artist.model';

import { ArtistService } from 'src/app/service/artist.service';

@Component({
  selector: 'artist-albums-index',
  templateUrl: './artist-albums-index.component.html',
  styleUrls: ['./artist-albums-index.component.css']
})

export class ArtistAlbumsIndexComponent implements OnInit {
  albums: Album[];

  constructor(private router: Router, private artistService: ArtistService) { }

  ngOnInit() {
    let artistId = localStorage.getItem("albumsArtistId");
    if (!artistId) {
      alert("Invalid artist.");
      this.goBack();
      return;
    }
    this.artistService.getArtistById(+artistId)
      .subscribe((artist: Artist) => {
        this.albums = artist.albums;
        console.log(this.albums);
      });
  }

  goBack() {
    this.router.navigate(["artist-index"]);
  }
}
