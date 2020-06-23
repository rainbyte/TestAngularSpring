import { Album } from './album.model';
import { Country } from './country.model';

export class Artist {
  id: number;
  nameNative: string;
  nameRomanized: string;
  country: Country;
  albums: Album[];
}
