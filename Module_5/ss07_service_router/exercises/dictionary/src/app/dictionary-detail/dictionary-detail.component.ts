import {Component, OnDestroy, OnInit} from '@angular/core';
import {IWord} from '../model/iword';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.scss']
})
export class DictionaryDetailComponent implements OnInit, OnDestroy {
  sub: Subscription;
  word: IWord;
  constructor(private activatedRoute: ActivatedRoute,
              private dictionaryServiceService: DictionaryServiceService) { }

  ngOnInit() {
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get('word');
      const mean = this.dictionaryServiceService.search(word);
      this.word = {word, mean};
    } ) ;
  }
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }


}
