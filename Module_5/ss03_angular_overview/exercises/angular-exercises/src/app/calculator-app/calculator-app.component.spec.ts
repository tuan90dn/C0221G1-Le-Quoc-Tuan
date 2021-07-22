import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatorAppComponent } from './calculator-app.component';

describe('CalculatorAppComponent', () => {
  let component: CalculatorAppComponent;
  let fixture: ComponentFixture<CalculatorAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalculatorAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatorAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
