import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'exercises';
  rating;
  success = '';
  finishCountDown() {
    this.success = 'Boom!!!';
  }

  ratingChange($event: number) {
    this.rating = $event;
  }
}
