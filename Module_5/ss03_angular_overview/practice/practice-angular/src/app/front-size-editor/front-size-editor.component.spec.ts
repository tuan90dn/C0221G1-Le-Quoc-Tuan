import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontSizeEditorComponent } from './front-size-editor.component';

describe('FrontSizeEditorComponent', () => {
  let component: FrontSizeEditorComponent;
  let fixture: ComponentFixture<FrontSizeEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FrontSizeEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FrontSizeEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
