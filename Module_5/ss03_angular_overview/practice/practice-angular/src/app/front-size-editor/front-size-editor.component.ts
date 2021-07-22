import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-front-size-editor',
  templateUrl: './front-size-editor.component.html',
  styleUrls: ['./front-size-editor.component.scss']
})
export class FrontSizeEditorComponent implements OnInit {
  fontSize = 14;
  constructor() { }

  ngOnInit(): void {
  }
  changeFontSizeValue(fontSize) {
    this.fontSize = fontSize;
  }

}
