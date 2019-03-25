import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';
import { MedicalStaff, Patient, Schedule } from 'src/models/Domain';
import { EVENT_TOPICS, Msh, In1, Obr, Obx, Orc, Pid, Pv1, GenericMessage, ParseResult, DataToConfirm } from 'src/models/ADT';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-doctor-work-station',
  templateUrl: './doctor-work-station.component.html',
  styleUrls: ['./doctor-work-station.component.css']
})
export class DoctorWorkStationComponent implements OnInit {

  patient: Patient;
  doctor: MedicalStaff;
  scheduleID: number;
  schedule: Schedule;
  sub: any;
  doctorText: string;
  patientInfo: string;
  hl7message: string;
  msh : Msh = {sendingApplication : "HIS",receivingApplication: "any"};
  in : In1 = {ID: "", insuranceCompName: "",insuranceExpDate: ""};
  obr : Obr = {ID: "", entityIdentifier: "", nameSpaceID: "", diagnostic: ""};
  obx : Obx={ID: "", diagnostic: ""};
  orc : Orc={ID: "",diagnostic: "", orcOrderControl: "",placerGroupNumber: ""};
  pid : Pid={CI: "",name: "",lastName: "",birthDate: "",gender:null,phoneNumber: "",phoneBusiness: "",address: "",deathIndicator: null,maritalStatus: null,nationality: "",city: ""};
  pv1 : Pv1={ID: "",attendingDoctorName: "",attendingDoctorLastName: "",patientClass: "",admitDateYear: null,admitDateMonth: null,admitDateDay: null,admitDateHour: null,admitDateMin: null};
  msg :  GenericMessage={Msh: null,In1: null,Obr: null,Obx: null,Orc: null,Pid: null,Pv1: null , Evn: null};

  constructor(private route: ActivatedRoute, private service: ApiService, public dialog: MatDialog) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.scheduleID = +params['scheduleID']; // (+) converts string 'id' to a number
   });

   this.service.getScheduleByID(this.scheduleID).subscribe((result: Schedule) => {
    this.schedule = result;
    this.patient = this.schedule.codPatient;
    this.doctor = this.schedule.codDoctor;
   });

  }

  handleSendEvent(topic: EVENT_TOPICS) {
    console.log("El topoico que me enviaron es "  + topic);
    console.log("El id del pacient es" + this.patient.ci);

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
    
    switch(topic) {
      case "ADT-A02":
        this.msg.Evn = "A02";
        this.service.createADT_A02(this.msg).subscribe((data: ParseResult) => {
          this.hl7message = data.data;
          let dataToConfirmModal : DataToConfirm = {
            event: "ADT-A02",
            hl7Message: this.hl7message,
          };
          const dialogRef = this.dialog.open(ConfirmModalComponent, {
            width: '380px',
            data: dataToConfirmModal,
            });
        });
      break;
      case "OML-O21":
        this.msg.Evn = "O21";
        this.service.createOML_O21(this.msg).subscribe((data: ParseResult) => {
          this.hl7message = data.data;
          let dataToConfirmModal : DataToConfirm = {
            event: "OML-O21",
            hl7Message: this.hl7message,
          };
          const dialogRef = this.dialog.open(ConfirmModalComponent, {
            width: '380px',
            data: dataToConfirmModal,
            });
        });
      break;
      case "RDE-O11":
        this.msg.Evn = "O11";
        this.service.createRDE_O11(this.msg).subscribe((data: ParseResult) => {
          this.hl7message = data.data;
          let dataToConfirmModal : DataToConfirm = {
            event: "RDE-O11",
            hl7Message: this.hl7message,
          };
          const dialogRef = this.dialog.open(ConfirmModalComponent, {
            width: '380px',
            data: dataToConfirmModal,
            });
        });
      break;
    }
  } 

}
