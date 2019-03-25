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

import { FormsModule } from "@angular/forms";

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {MatDialogModule} from '@angular/material';
import { MatListModule } from '@angular/material';
import { MatCardModule, MatChipsModule, MatTableModule, MatToolbarModule, MatSnackBarModule} from '@angular/material';
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
  ],
  entryComponents: [CreateScheduleComponentComponent],
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
    NgxMaterialTimepickerModule
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
  entryComponents: [
    ConfirmModalComponent,
    PatientCIModalComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
