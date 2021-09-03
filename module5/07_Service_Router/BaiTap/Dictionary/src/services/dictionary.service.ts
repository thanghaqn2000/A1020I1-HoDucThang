import {Injectable} from '@angular/core';
import {IWord, words} from "../models/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  listWord: IWord[] = words;

  getAll() {
    return this.listWord;
  }

  getWord(keyDetail:string){
      return this.listWord.find(x=>x.key==keyDetail)
  }

  constructor() {
  }
}
