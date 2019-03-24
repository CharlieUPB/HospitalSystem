import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {MatDialogModule} from '@angular/material';


import { AppComponent } from './app.component';
import { NavbarComponentComponent } from './Components/navbar-component/navbar-component.component';
import { InicioComponentComponent } from './Components/inicio-component/inicio-component.component';
import { PatientRegisterComponentComponent } from './Components/patient-register-component/patient-register-component.component';
import {Routing} from '../app-routing.module';
import { DoctorRegisterComponent } from './Components/doctor-register/doctor-register.component';
import { AgendamientoRegisterComponent } from './Components/agendamiento-register/agendamiento-register.component';
import { HistorialClinicoComponent } from './Components/historial-clinico/historial-clinico.component';

import { Observable } from 'rxjs';

import {
  IMqttMessage,
  MqttModule,
  IMqttServiceOptions
} from 'ngx-mqtt';

export const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
  hostname: 'localhost',
  port: 3000,
  path: '/mqtt'
};

@NgModule({
  declarations: [
    AppComponent,

    NavbarComponentComponent,
    InicioComponentComponent

    PatientRegisterComponentComponent,
    DoctorRegisterComponent,
    AgendamientoRegisterComponent,
    HistorialClinicoComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MqttModule.forRoot(MQTT_SERVICE_OPTIONS),
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatSelectModule,
    MatRadioModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatDialogModule,
    Routing

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
