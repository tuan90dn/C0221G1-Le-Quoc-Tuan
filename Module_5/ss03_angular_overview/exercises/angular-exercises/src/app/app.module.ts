import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorAppComponent } from './calculator-app/calculator-app.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import {FormsModule} from '@angular/forms';
import { TestComponent } from './test/test.component';


@NgModule({
  declarations: [
    AppComponent,
    CalculatorAppComponent,
    ColorPickerComponent,
    TestComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
