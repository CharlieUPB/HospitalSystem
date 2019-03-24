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
import { MatListModule } from '@angular/material';
import { MatCardModule, MatChipsModule, MatTableModule } from '@angular/material';


import { AppComponent } from './app.component';
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
import { PatientEventHistoryComponent } from './Components/patient-event-history/patient-event-history.component';

export const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
  hostname: 'localhost',
  port: 3000,
  path: '/mqtt'
};

@NgModule({
  declarations: [
    AppComponent,
    PatientRegisterComponentComponent,
    DoctorRegisterComponent,
    AgendamientoRegisterComponent,
    HistorialClinicoComponent,
    PatientEventHistoryComponent
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
    MatListModule,
    MatCardModule,
    MatChipsModule,
    MatTableModule,
    Routing

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
