import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-cimodal',
  templateUrl: './patient-cimodal.component.html',
  styleUrls: ['./patient-cimodal.component.css']
})
export class PatientCIModalComponent implements OnInit {

  CI: string;

  constructor(private router: Router, public dialogRef: MatDialogRef<PatientCIModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string) { }

  ngOnInit() {
  }

  onOkClick() {
    this.dialogRef.close();
    if(this.data === "reportes") {
      this.router.navigateByUrl( `/eventHistory/${this.CI}`);
    } else if (this.data === "diagnosticos") {
      this.router.navigateByUrl( `/clinicalhistory/${this.CI}`);
    }
    
  }

}
