import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import { Artist } from "../model/artist.model";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Country } from '../model/country.model';

class RawResponse<T> {
  datum: T;
  error: string;
}

@Injectable()
export class ArtistService {
  constructor(private http: HttpClient) {}

  baseUrl: string = 'http://localhost:8080/myapp/artists';

  getArtists(): Observable<Artist[]> {
    return this.http.get(this.baseUrl)
      .pipe<Artist[]>(
        map((resp: RawResponse<Artist[]>) => resp.datum));
  }

  getArtistById(id: number) {
    return this.http.get(this.baseUrl + '/' + id)
      .pipe<Artist>(
        map((resp: RawResponse<Artist>) => resp.datum));
}

  createArtist(artist: Artist) {
    return this.http.post(this.baseUrl, artist);
  }

  updateArtist(artist: Artist) {
    return this.http.put(this.baseUrl + '/' + artist.id, artist);
  }

  deleteArtist(id: number): Observable<string> {
    return this.http.delete(this.baseUrl + '/' + id, {responseType: "text"});
  }

  getCountries(): Observable<Country[]> {
    return this.http.get(this.baseUrl + '/countries')
      .pipe<Country[]>(
        map((resp: RawResponse<Country[]>) => resp.datum));
    }
  }
