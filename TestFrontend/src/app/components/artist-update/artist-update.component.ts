import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { first } from "rxjs/operators";

import { ArtistService } from "../../service/artist.service";
import { Artist } from 'src/app/model/artist.model';

@Component({
  selector: 'artist-update',
  templateUrl: './artist-update.component.html',
  styleUrls: ['./artist-update.component.css']
})

export class ArtistUpdateComponent {

  artist: Artist;
  updateForm: FormGroup;

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
      country: ['', Validators.required]
    });
    this.artistService.getArtistById(+artistId)
      .subscribe(this.updateForm.setValue)
  }

  onAccept() {
    this.artistService.updateArtist(this.updateForm.value)
      .pipe(first())
      .subscribe(
        datum => { this.goBack;  },
        error => { alert(error); });
  }

  onCancel() {
    this.goBack();
  }

  goBack() {
    this.router.navigate(["artist-index"]);
  }
}
