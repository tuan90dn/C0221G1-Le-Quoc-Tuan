import { Component, OnInit } from '@angular/core';
import {IWord} from '../model/iword';
import {DictionaryServiceService} from '../service/dictionary-service.service';

@Component({
  selector: 'app-dictionay-page',
  templateUrl: './dictionay-page.component.html',
  styleUrls: ['./dictionay-page.component.scss']
})
export class DictionayPageComponent implements OnInit {
  words: IWord[];
  constructor(private dictionaryServiceService: DictionaryServiceService) { }
  // searchWord(word: string) {
  //   const mean = this.dictionaryServiceService.search(word);
  //   this.word = {word, mean};
  // }
  ngOnInit(): void {
    this.words = this.dictionaryServiceService.getWords();
  }

}
