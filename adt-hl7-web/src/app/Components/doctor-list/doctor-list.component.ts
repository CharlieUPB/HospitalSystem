import { Component, OnInit } from '@angular/core';
import { MedicalStaff } from 'src/models/Domain';
import { ApiService } from 'src/app/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  doctors: MedicalStaff[];

  constructor(private service: ApiService, private router: Router) { }

  ngOnInit() {
    this.service.getMedicalAll().subscribe((data: MedicalStaff[]) => {
      this.doctors = data;
    })
  }

  openDoctorRegistry() {
    this.router.navigateByUrl( `/registerdoctor`);
  }

}
