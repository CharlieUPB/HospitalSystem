import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponentComponent } from './Components/navbar-component/navbar-component.component';
import { InicioComponentComponent } from './Components/inicio-component/inicio-component.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponentComponent,
    InicioComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
