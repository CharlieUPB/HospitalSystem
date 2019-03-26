import { Component, OnInit, Inject } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { PatientCIModalComponent } from '../patient-cimodal/patient-cimodal.component';
import { ApiService } from 'src/app/api.service';
import { Schedule, MedicalStaff, Patient } from 'src/models/Domain';
import { Msh, In1, Obr, Obx, Orc, Pid, Pv1, GenericMessage, ParseResult, EVENT_TOPICS } from 'src/models/ADT';
import { MqttService } from 'ngx-mqtt';

@Component({
  selector: 'app-agendamiento-register',
  templateUrl: './agendamiento-register.component.html',
  styleUrls: ['./agendamiento-register.component.css']
})
export class AgendamientoRegisterComponent implements OnInit {
  formSchedule : FormGroup;
  citaMedica: Schedule;
  ci: string;
  codDoctor: string;
  parsedDate: string;
  date: string;
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

  constructor(
    private _mqttService: MqttService,
    private service: ApiService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<PatientCIModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string
  ) { }

  ngOnInit() {
    this.createScheduleForm();
  }

  createScheduleForm() {
    this.formSchedule = this.fb.group({
      codPatient: ['', Validators.required],
      codDoctor: ['', Validators.required],
      date: [''],
      hour: ['', Validators.required],
      min: ['', Validators.required],
      parent: ['', Validators.required]
    });
  }

  onSubmit(formPatient) {
    this.ci = formPatient.codPatient;
    this.codDoctor = formPatient.codDoctor;
    this.date = formPatient.date;
    let splited = this.date.split('/');
    this.hour = formPatient.hour;
    this.min = formPatient.min;
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
        this.pv1.admitDateDay = +splited[0];
        this.pv1.admitDateMonth = +splited[1];
        this.pv1.admitDateYear = +splited[2];
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
    this.dialogRef.close();
  }
  
  public unsafePublish(topic: EVENT_TOPICS, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 0, retain: true});
  }
}
