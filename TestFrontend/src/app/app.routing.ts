import { RouterModule, Routes } from "@angular/router";

import { ArtistCreateComponent } from "./components/artist-create/artist-create.component";
import { ArtistIndexComponent } from "./components/artist-index/artist-index.component";
import { ArtistUpdateComponent } from "./components/artist-update/artist-update.component";

const routes: Routes = [
  { path: "artist-index", component: ArtistIndexComponent },
  { path: "artist-create", component: ArtistCreateComponent },
  { path: "artist-update", component: ArtistUpdateComponent },
  { path: "", component: ArtistIndexComponent }
];

export const routing = RouterModule.forRoot(routes);
