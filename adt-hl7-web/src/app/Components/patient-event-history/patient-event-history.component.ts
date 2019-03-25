import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { PatientHistory } from 'src/models/Domain';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';
import { Subscription, BehaviorSubject } from 'rxjs';
import { MqttService, IMqttMessage } from 'ngx-mqtt';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-patient-event-history',
  templateUrl: './patient-event-history.component.html',
  styleUrls: ['./patient-event-history.component.css']
})
export class PatientEventHistoryComponent implements OnInit, OnDestroy {


  displayedColumns: string[] = ['MSHID', 'ADT Code', 'Details', 'Event Date', 'Event Time' , 'Acknowledge'];
  id: number;
  private sub: any;
  histories: PatientHistory[];
  dataSource = new MatTableDataSource(this.histories);

  // mqtt
  private subscription: Subscription;
  public message: string;

  constructor(private route: ActivatedRoute, private service: ApiService, private _mqttService: MqttService) {
    this.subscription = this._mqttService.observe('ACK').subscribe((message: IMqttMessage) => {
      this.service.getPatientHistoryByCI(this.id).subscribe((data: PatientHistory[]) => {
        this.histories = [...data];
        this.sortTable();
        this.dataSource = new MatTableDataSource(this.histories);
        this.message = message.payload.toString();
        setTimeout(() => {
          this.service.getACKID({data: this.message}).subscribe((data) => {
            this.histories.forEach((history: PatientHistory) => {
              if(history.mshID === data.mshControlID) {
                history.acked = true;
                history.ackType = data.ackType;
                this.unsafePublish("ACK_RCV", `${data.mshControlID}-${data.ackType}`);
              }
            })
          });
      }, 3000);
      });
      
    });
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
   });
   this.service.getPatientHistoryByCI(this.id).subscribe((data: PatientHistory[]) => {
    this.histories = data;
    this.sortTable();
    this.dataSource = new MatTableDataSource(this.histories);
   });
  }

  private sortTable() {
    this.histories.sort((a: PatientHistory, b: PatientHistory) => {
      return (this.getDate(a.eventDate,a.eventTime)).getTime() - (this.getDate(b.eventDate,b.eventTime)).getTime();
    });
    this.histories.reverse();
  }

  public unsafePublish(topic: string, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 0, retain: true});
  }

  //This will cast "2010-03-12" and "10:30:00" strings to Date objects
  private getDate(stringDate: string, stringTime: string): Date {
    let splitedDate = stringDate.split("-");
    let splitedTime = stringTime.split(":");
    return new Date(+splitedDate[0],+splitedDate[1],+splitedDate[2], +splitedTime[0], +splitedTime[1]);
  }
  
  public ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
