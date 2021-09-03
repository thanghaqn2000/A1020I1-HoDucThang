import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IWord} from "../../models/dictionary";
import {DictionaryService} from "../../services/dictionary.service";
@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  key!: string;
  word!: IWord;

  constructor(private activeRouter: ActivatedRoute,private service:DictionaryService) {
  }

  ngOnInit(): void {
    this.activeRouter.paramMap.subscribe((param) => {
      // @ts-ignore
      this.key = param.get('key');
      // @ts-ignore
      this.word=this.service.getWord(this.key);
      console.log(this.word);
    })
  }

}
