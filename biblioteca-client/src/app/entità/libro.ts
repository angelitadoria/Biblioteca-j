import { Autore } from "./autore";
import { CasaEditrice } from "./casa-editrice";
import { PosizioneScaffale } from "./posizione-scaffale";

export class Libro {
    id: number;
    codice: string;
    titolo: string;
    anno: number;
    genere: string;
    autori: Autore[] = [];
    casaEditrice: CasaEditrice;
    posizioneScaffale: PosizioneScaffale;

}