import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Schedule, Patient, MedicalStaff } from 'src/models/Domain';
import * as moment from 'moment';
import { Msh, In1, Obr, Obx, Orc, Pid, Pv1, GenericMessage, ParseResult, DataToConfirm, EVENT_TOPICS } from 'src/models/ADT';
import { ApiService } from 'src/app/api.service';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';
import { MqttService } from 'ngx-mqtt';


export interface DialogData {
  
}

@Component({
  selector: 'app-create-schedule-component',
  templateUrl: './create-schedule-component.component.html',
  styleUrls: ['./create-schedule-component.component.css']
})
export class CreateScheduleComponentComponent implements OnInit {

  date = new FormControl(new Date());
  formSchedule: FormGroup;

  citaMedica: Schedule;
  ci: string;
  codDoctor: string;
  parsedDate: string;

  day:string;
  month:string;
  year:string;
  hour: string;
  min: string;

  patient: Patient;
  doctor: MedicalStaff;

  hl7message: string;
  msh : Msh = {sendingApplication : "HIS",receivingApplication: "any"};
  in : In1 = {ID: "", insuranceCompName: "",insuranceExpDate: ""};
  obr : Obr = {ID: "", entityIdentifier: "", nameSpaceID: "", diagnostic: ""};
  obx : Obx={ID: "", diagnostic: ""};
  orc : Orc={ID: "",diagnostic: "", orcOrderControl: "",placerGroupNumber: ""};
  pid : Pid={CI: "",name: "",lastName: "",birthDate: "",gender:null,phoneNumber: "",phoneBusiness: "",address: "",deathIndicator: null,maritalStatus: null,nationality: "",city: ""};
  pv1 : Pv1={ID: "",attendingDoctorName: "",attendingDoctorLastName: "",patientClass: "",admitDateYear: null,admitDateMonth: null,admitDateDay: null,admitDateHour: null,admitDateMin: null};
  msg :  GenericMessage={Msh: null,In1: null,Obr: null,Obx: null,Orc: null,Pid: null,Pv1: null , Evn: null};



  constructor(private fb: FormBuilder,private _mqttService: MqttService, public dialog: MatDialog,private service: ApiService ,public dialogRef: MatDialogRef<CreateScheduleComponentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }
       
  ngOnInit() {
    this.createScheduleForm();
    this.parsedDate = moment(this.date.value).format('DD/MM/YYYY')
    let splited = this.parsedDate.split('/');
    this.day = splited[0];
    this.month = splited[1];
    this.year = splited[2];
    console.log(`${this.day} ${this.month} ${this.year}`);
    console.log(`HORA ES: ${this.hour}`);
  }

  
  createScheduleForm() {
    this.formSchedule = this.fb.group({
      ci: ['', Validators.required],
      codDoctor: ['', Validators.required],
      Date: [''],
      hour  : ['', Validators.required],
      min: ['', Validators.required],
    });
  }

  dateChanged() {
    this.parsedDate = moment(this.date.value).format('DD/MM/YYYY')
    let splited = this.parsedDate.split('/');
    this.day = splited[0];
    this.month = splited[1];
    this.year = splited[2];
    console.log(`${this.day} ${this.month} ${this.year}`);
    console.log(`HORA ES: ${this.hour}`);
  }

  onSave() {
    
    this.service.getPatientByCI(this.ci).subscribe((response: Patient) => {
      this.patient = response;
      this.service.getMedicalByID(this.codDoctor).subscribe((resp: MedicalStaff) => {
        this.doctor = resp;
        this.pid.CI = String(this.patient.ci);
        this.pid.address = this.patient.address;
        this.pid.birthDate = this.patient.birthDate;
        this.pid.city = this.patient.city;
        this.pid.deathIndicator = this.patient.deceased;
        this.pid.gender = this.patient.gender;
        this.pid.lastName = this.patient.lastName;
        this.pid.maritalStatus = this.patient.maritalStatus;
        this.pid.name = this.patient.name;
        this.pid.nationality = this.patient.nationality;
        this.pid.phoneBusiness = this.patient.cellPhone;
        this.pid.phoneNumber = this.patient.phone;

        this.pv1.ID = String(this.doctor.cod);
        this.pv1.admitDateDay = +this.day;
        this.pv1.admitDateMonth = +this.month;
        this.pv1.admitDateYear = +this.year;
        this.pv1.admitDateHour = +this.hour;
        this.pv1.admitDateMin = +this.min;

        this.in.insuranceCompName = this.patient.codSecure.nameOrganization;
        this.in.insuranceExpDate = this.patient.codSecure.vecDate;

        this.msg.Pv1 = this.pv1;
        this.msg.In1 = this.in;
        this.msg.Msh = this.msh;
        this.msg.Obr = this.obr;
        this.msg.Obx = this.obx;
        this.msg.Orc = this.orc;
        this.msg.Pid = this.pid;
        this.msg.Pv1 = this.pv1;
        this.msg.Evn = "A05";
        this.service.createADT_A05(this.msg).subscribe((data: ParseResult) => {
        this.hl7message = data.data;
        this.unsafePublish("ADT-A05",this.hl7message);
        this.dialogRef.close();
      });
      });
    });
  }

  
  public unsafePublish(topic: EVENT_TOPICS, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 0, retain: true});
  }

}
