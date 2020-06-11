import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import { Artist } from "../model/artist.model";

@Injectable()
export class ArtistService {
  constructor(private http: HttpClient) {}

  baseUrl: string = 'http://localhost:8080/myapp/artists';

  getArtists() {
    return this.http.get<Artist[]>(this.baseUrl);
  }

  getArtistById(id: number) {
    return this.http.get<Artist>(this.baseUrl + '/' + id);
  }

  createArtist(artist: Artist) {
    return this.http.post(this.baseUrl, artist);
  }

  updateArtist(artist: Artist) {
    return this.http.put(this.baseUrl + '/' + artist.id, artist);
  }

  deleteArtist(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}
