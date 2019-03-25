import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { Patient } from 'src/models/Domain';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[] = [];


  constructor(private service: ApiService, private router: Router) { }

  ngOnInit() {
    this.service.getPatientAll().subscribe((data: Patient[]) => {
      this.patients = data;
    });
  }

  goToEventHistory(patientCI: string) {
    this.router.navigateByUrl( `/eventHistory/${patientCI}`);
  }

  goToPatientUpdate(patientCI: string) {
    this.router.navigateByUrl( `/registerpatient/${patientCI}`);
  }
  
  openPatientRegistry() {
    this.router.navigateByUrl( `/registerpatient`);
  }

}
