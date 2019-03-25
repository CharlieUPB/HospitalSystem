import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';

import { ScheduleComponent } from './Components/schedule/schedule.component';
import { MatFormFieldModule, 
        MatAutocompleteModule,
        MatBadgeModule,
        MatBottomSheetModule,
        MatButtonModule,
        MatButtonToggleModule,
        MatCardModule,
        MatCheckboxModule,
        MatChipsModule,
        MatDatepickerModule,
        MatDialogModule,
        MatDividerModule,
        MatExpansionModule,
        MatGridListModule,
        MatIconModule,
        MatInputModule,
        MatListModule,
        MatMenuModule,
        MatNativeDateModule,
        MatPaginatorModule,
        MatProgressBarModule,
        MatProgressSpinnerModule,
        MatRadioModule,
        MatRippleModule,
        MatSelectModule,
        MatSidenavModule,
        MatSliderModule,
        MatSlideToggleModule,
        MatSnackBarModule,
        MatSortModule,
        MatStepperModule,
        MatTableModule,
        MatTabsModule,
        MatToolbarModule,
        MatTooltipModule,
        MatTreeModule, } from "@angular/material";

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { NavbarComponentComponent } from './Components/navbar-component/navbar-component.component';
import { InicioComponentComponent } from './Components/inicio-component/inicio-component.component';
import { PatientRegisterComponentComponent } from './Components/patient-register-component/patient-register-component.component';
import {Routing} from '../app-routing.module';
import { DoctorRegisterComponent } from './Components/doctor-register/doctor-register.component';
import { AgendamientoRegisterComponent } from './Components/agendamiento-register/agendamiento-register.component';
import { HistorialClinicoComponent } from './Components/historial-clinico/historial-clinico.component';
import { DerivePharmacyComponent } from './Components/derive-pharmacy/derive-pharmacy.component';
import { DeriveRadiographyComponent } from './Components/derive-radiography/derive-radiography.component';
import { DeriveLaboratoryComponent } from './Components/derive-laboratory/derive-laboratory.component';
import { PatientEventHistoryComponent } from './Components/patient-event-history/patient-event-history.component';
import { PatientListComponent } from './Components/patient-list/patient-list.component';
import { DoctorListComponent} from './Components/doctor-list/doctor-list.component';
import { CreateScheduleComponentComponent } from './Components/create-schedule-component/create-schedule-component.component';

import { Observable } from 'rxjs';

import {
  IMqttMessage,
  MqttModule,
  IMqttServiceOptions
} from 'ngx-mqtt';
import { ConfirmModalComponent } from './Components/confirm-modal/confirm-modal.component';
import { PatientCIModalComponent } from './Components/patient-cimodal/patient-cimodal.component';
import { DoctorWorkStationComponent } from './Components/doctor-work-station/doctor-work-station.component';

export const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
  hostname: 'localhost',
  port: 3000,
  path: '/mqtt'
};


@NgModule({
  declarations: [
    AppComponent,

    ScheduleComponent,
    CreateScheduleComponentComponent,
    NavbarComponentComponent,
    InicioComponentComponent,
    PatientListComponent,
    PatientRegisterComponentComponent,
    DoctorRegisterComponent,
    AgendamientoRegisterComponent,
    HistorialClinicoComponent,
    DerivePharmacyComponent,
    DeriveRadiographyComponent,
    DeriveLaboratoryComponent,
    PatientEventHistoryComponent,
    HistorialClinicoComponent,
    DoctorListComponent,
    ConfirmModalComponent,
    PatientCIModalComponent,
    DoctorWorkStationComponent,
  ],
  entryComponents: [
    CreateScheduleComponentComponent,
    ConfirmModalComponent,
    PatientCIModalComponent],
  imports: [
    BrowserModule,
    MatGridListModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    FormsModule,
    MatDialogModule,
    NgxMaterialTimepickerModule,
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
    MatListModule,
    MatCardModule,
    MatChipsModule,
    MatTableModule,
    MatToolbarModule,
    MatSnackBarModule,
    Routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
