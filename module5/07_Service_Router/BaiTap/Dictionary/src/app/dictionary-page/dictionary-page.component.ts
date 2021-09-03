import {Component, OnInit} from '@angular/core';
import {DictionaryService} from "../../services/dictionary.service";
import {IWord} from "../../models/dictionary";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  constructor(private _dictionary: DictionaryService) {
  }

  listWord: IWord[] = this._dictionary.getAll();

  ngOnInit(): void {
  }

}
