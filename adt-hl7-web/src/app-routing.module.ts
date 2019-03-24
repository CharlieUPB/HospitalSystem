import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import {PatientRegisterComponentComponent} from './app/Components/patient-register-component/patient-register-component.component'
import { AppComponent } from './app/app.component';
import {DoctorRegisterComponent} from './app/Components/doctor-register/doctor-register.component'
import {AgendamientoRegisterComponent} from './app/Components/agendamiento-register/agendamiento-register.component'
import {HistorialClinicoComponent} from './app/Components/historial-clinico/historial-clinico.component'

const routes: Routes = [
  { path: 'registerpatient', component: PatientRegisterComponentComponent },
  { path: 'registerdoctor', component: DoctorRegisterComponent },
  { path: 'registerscheduling', component: AgendamientoRegisterComponent },
  { path: 'clinicalhistory', component: HistorialClinicoComponent},
  { path: '', component: AppComponent }
];
export const Routing = RouterModule.forRoot(routes);
export class AppRoutingModule { }
