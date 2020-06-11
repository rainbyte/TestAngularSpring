import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";

import { ArtistService } from "../../service/artist.service";
import { Artist } from 'src/app/model/artist.model';

@Component({
  selector: 'artist-create',
  templateUrl: './artist-create.component.html',
  styleUrls: ['./artist-create.component.css']
})

export class ArtistCreateComponent {
  createForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private artistService: ArtistService) { }

  ngOnInit() {
    this.createForm = this.formBuilder.group({
      id: [],
      nameNative: ['', Validators.required],
      nameRomanized: [],
      country: ['', Validators.required]
    });
  }

  onAccept() {
    this.artistService.createArtist(this.createForm.value)
      .subscribe(
        datum => { this.goBack();  },
        error => { alert(error); });
  }

  cancel() {
    this.router.navigate(["artist-index"]);
  }

  goBack() {
    this.router.navigate(["artist-index"]);
  }
}
