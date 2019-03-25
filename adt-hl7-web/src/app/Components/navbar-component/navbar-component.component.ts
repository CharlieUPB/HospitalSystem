import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatDialog } from '@angular/material';
import { MqttService, IMqttMessage } from 'ngx-mqtt';
import { Subscription } from 'rxjs';
import { ApiService } from 'src/app/api.service';
import { MshSegment } from 'src/models/ADT';
import { PatientCIModalComponent } from '../patient-cimodal/patient-cimodal.component';

@Component({
  selector: 'app-navbar-component',
  templateUrl: './navbar-component.component.html',
  styleUrls: ['./navbar-component.component.css']
})
export class NavbarComponentComponent implements OnInit {

  private subscription: Subscription;
  message: string;

  constructor( public dialog: MatDialog ,private service: ApiService, private snackBar: MatSnackBar, private _mqttService: MqttService) {
    this.subscription = this._mqttService.observe('ACK').subscribe((message: IMqttMessage) => {
        this.openSnackBar("Acknowledgment recibido");
        this.message = message.payload.toString();
        this.service.getACKID({data: this.message}).subscribe((data: MshSegment) => {
          this.unsafePublish("ACK_RCV", `${data.mshControlID}-${data.ackType}`);
        });
    });
   }

  ngOnInit() {
  }

  public unsafePublish(topic: string, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 0, retain: true});
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, "Aceptar", {
      duration: 3000,
    });
  }
  
  openPatientCIModal() {
    const dialogRef = this.dialog.open(PatientCIModalComponent, {
      width: '350px'
    });
  }

}
