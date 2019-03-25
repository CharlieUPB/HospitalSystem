import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatSnackBar } from '@angular/material';
import { MqttService } from 'ngx-mqtt';
import { EVENT_TOPICS, DataToConfirm } from 'src/models/ADT';
import { ApiService } from 'src/app/api.service';
import { MedicalStaff } from 'src/models/Domain';
import { Router } from '@angular/router';

@Component({
  selector: 'app-confirm-modal',
  templateUrl: './confirm-modal.component.html',
  styleUrls: ['./confirm-modal.component.css']
})
export class ConfirmModalComponent implements OnInit {

  constructor(private router: Router, private snackBar: MatSnackBar, private service : ApiService, private _mqttService: MqttService, public dialogRef: MatDialogRef<ConfirmModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DataToConfirm ) { }

  ngOnInit() {
  }

  onOkClick() {
    if(this.data.medical) { // We are just adding a med
      this.service.addMedical(this.data.medical).subscribe((data: MedicalStaff) => {
        let snackBarRef = this.openSnackBar("Doctor agregado!");
        snackBarRef.onAction().subscribe(()=> {
          this.router.navigateByUrl('/doctors');
        });
      })
    } else { // Our job is to trigger an HL7 Event
      this.unsafePublish(this.data.event,this.data.hl7Message);
    }
    
    this.dialogRef.close();
  }

  onCancelClick() {
    this.dialogRef.close();
  }

  openSnackBar(message: string) {
    return this.snackBar.open(message, "Aceptar", {
      duration: 3000,
    });
  }

  public unsafePublish(topic: EVENT_TOPICS, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 0, retain: true});
  }

}
