import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { PatientCIModalComponent } from '../patient-cimodal/patient-cimodal.component';

@Component({
  selector: 'app-inicio-component',
  templateUrl: './inicio-component.component.html',
  styleUrls: ['./inicio-component.component.css']
})
export class InicioComponentComponent implements OnInit {

  constructor(private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
  }

  goToPatients() {
    this.router.navigateByUrl('/patients');
  }
  goToDoctors() {
    this.router.navigateByUrl('/doctors');
  }
  openPatientCIModal() {
    const dialogRef = this.dialog.open(PatientCIModalComponent, {
      width: '350px'
    });
  }

}
