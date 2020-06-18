export class Country {
  id: number;
  name: string;

  public toString = () : string => {
    return `${this.id}. ${this.name}`;
  }
}
