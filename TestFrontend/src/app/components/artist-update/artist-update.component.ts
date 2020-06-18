import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { first } from "rxjs/operators";

import { ArtistService } from "../../service/artist.service";
import { Artist } from 'src/app/model/artist.model';
import { Country } from 'src/app/model/country.model';

@Component({
  selector: 'artist-update',
  templateUrl: './artist-update.component.html',
  styleUrls: ['./artist-update.component.css']
})

export class ArtistUpdateComponent {

  updateForm: FormGroup;
  countries: Country[];

  constructor(private formBuilder: FormBuilder, private router: Router,
    private artistService: ArtistService) { }

  ngOnInit() {
    let artistId = localStorage.getItem("updateArtistId");
    if (!artistId) {
      alert("Invalid artist.");
      this.onCancel();
      return;
    }
    this.updateForm = this.formBuilder.group({
      id: [],
      nameNative: ['', Validators.required],
      nameRomanized: [],
      country: this.formBuilder.group({
        id: [],
        name: ['', Validators.required]
      })
    });
    this.artistService.getCountries()
      .subscribe(
        (datum: Country[]) => { this.countries = datum; },
        error => { alert(error); });
    this.artistService.getArtistById(+artistId)
      .subscribe((artist: Artist) => {
        this.updateForm.setValue(artist)
      })
  }

  onAccept() {
    this.artistService.updateArtist(this.updateForm.value)
      .pipe(first())
      .subscribe(
        datum => { this.goBack();  },
        error => { alert(error); });
  }

  onCancel() {
    this.goBack();
  }

  goBack() {
    this.router.navigate(["artist-index"]);
  }
}
