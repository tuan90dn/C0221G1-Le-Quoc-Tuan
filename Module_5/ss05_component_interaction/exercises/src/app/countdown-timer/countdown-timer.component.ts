import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.scss']
})
export class CountdownTimerComponent implements OnInit, OnChanges {
  @Input()
  seconds = 11;
  @Output()
  finish = new EventEmitter<boolean>();
  intervalId = 0;
  message = '';
  remainingTime: number;
  constructor() { }

  ngOnInit(): void {
    this.remainingTime = this.seconds;
  }
  ngOnChanges(changes: SimpleChanges) {
    if ('seconds' in changes) {
      let v = changes.seconds.currentValue;
      v = typeof v === 'undefined' ? 11 : v;
      const vFixed = Number(v);
      this.seconds = Number.isNaN(vFixed) ? 11 : vFixed;
    }
  }

  clearTime() {
    clearInterval(this.intervalId);
  }

  start() {
    this.countdown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  stop() {
    this.clearTime();
  }

  reset() {
    this.clearTime();
    this.remainingTime = this.seconds;
  }

  private countdown() {
    this.clearTime();
    this.intervalId = window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.clearTime();
        this.finish.emit(true);
      }
    }, 1000);
    // this.intervalId = window.setInterval(() => {
    //   this.remainingTime -= 1;
    //   if (this.remainingTime === 0) {
    //     this.message = 'Blast off!';
    //     this.clearTimer();
    //     this.finish.emit(true);
    //   } else {
    //     this.message = `T-${this.remainingTime} seconds and counting`;
    //   }
    // }, 1000);

  }
}
