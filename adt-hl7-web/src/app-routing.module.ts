import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import {PatientRegisterComponentComponent} from './app/Components/patient-register-component/patient-register-component.component'
import { AppComponent } from './app/app.component';
import {DoctorRegisterComponent} from './app/Components/doctor-register/doctor-register.component'
import {AgendamientoRegisterComponent} from './app/Components/agendamiento-register/agendamiento-register.component'
import {HistorialClinicoComponent} from './app/Components/historial-clinico/historial-clinico.component'
import {DeriveRadiographyComponent} from './app/Components/derive-radiography/derive-radiography.component'
import {DeriveLaboratoryComponent} from './app/Components/derive-laboratory/derive-laboratory.component'
import {DerivePharmacyComponent} from './app/Components/derive-pharmacy/derive-pharmacy.component'
import { PatientEventHistoryComponent } from './app/Components/patient-event-history/patient-event-history.component';
import { InicioComponentComponent } from './app/Components/inicio-component/inicio-component.component';

const routes: Routes = [
  { path: 'registerpatient', component: PatientRegisterComponentComponent },
  { path: 'registerdoctor', component: DoctorRegisterComponent },
  { path: 'registerscheduling', component: AgendamientoRegisterComponent },
  { path: 'clinicalhistory', component: HistorialClinicoComponent},
  { path: 'deriveradiography', component: DeriveRadiographyComponent},
  { path: 'derivelaboratory', component: DeriveLaboratoryComponent},
  { path: 'derivepharmacy', component: DerivePharmacyComponent},  
  { path: 'clinicalhistory/:id', component: HistorialClinicoComponent},
  { path: 'eventHistory/:id' , component: PatientEventHistoryComponent},
  {path: 'home', component: InicioComponentComponent},
  { path: '', component: InicioComponentComponent }
];
export const Routing = RouterModule.forRoot(routes);
export class AppRoutingModule { }
