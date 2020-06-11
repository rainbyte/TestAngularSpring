import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ArtistService } from './service/artist.service';
import { ArtistCreateComponent } from './components/artist-create/artist-create.component';
import { ArtistIndexComponent } from './components/artist-index/artist-index.component';
import { ArtistUpdateComponent } from './components/artist-update/artist-update.component';
import { routing } from './app.routing';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    ArtistCreateComponent,
    ArtistIndexComponent,
    ArtistUpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    routing
  ],
  providers: [ArtistService],
  bootstrap: [AppComponent]
})

export class AppModule { }
