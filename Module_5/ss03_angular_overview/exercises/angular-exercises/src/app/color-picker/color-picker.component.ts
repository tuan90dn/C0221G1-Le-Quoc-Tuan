import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.scss']
})
export class ColorPickerComponent implements OnInit {
  horizontal = '5';
  vertical = '5';
  blur = '5';
  spread = '5';
  color = 'red';
  constructor() { }

  ngOnInit(): void {
  }

}
