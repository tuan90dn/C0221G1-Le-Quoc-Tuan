import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorAppComponent } from './calculator-app/calculator-app.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import {FormsModule} from '@angular/forms';
import { GradientComponent } from './gradient/gradient.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorAppComponent,
    ColorPickerComponent,
    GradientComponent,
    NavbarComponent
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
