import { Injectable } from '@angular/core';
import {IWord} from '../model/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  words: IWord[] = [
    {word: 'i', mean: 'anh'},
    {word: 'love', mean: 'yêu'},
    {word: 'you', mean: 'em'},
  ];
  // @ts-ignore
  search(word: string): string {
    if (!word) {
      return '';
    }
    const w = this.words.find(item => item.word === word.toLowerCase());
    if (w) {
      return w.mean;
    }
    return 'Not Found!';
  }
  getWords() {
    return this.words;
  }

  constructor() { }
}
