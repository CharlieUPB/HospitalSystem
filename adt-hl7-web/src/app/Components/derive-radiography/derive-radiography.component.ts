import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {GenericMessage} from '../../../models/ADT/GenericMessage'
import {Msh} from '../../../models/ADT/Msh'
import {In1} from '../../../models/ADT/In1'
import {Obr} from '../../../models/ADT/Obr'
import {Obx} from '../../../models/ADT/Obx'
import {Orc} from '../../../models/ADT/Orc'
import {Pid} from '../../../models/ADT/Pid'
import {Pv1} from '../../../models/ADT/Pv1'
import { Gender, Decesased, MaritalStatus } from '../../../models/Domain'
import {ApiService} from '../../api.service'

@Component({
  selector: 'app-derive-radiography',
  templateUrl: './derive-radiography.component.html',
  styleUrls: ['./derive-radiography.component.css']
})
export class DeriveRadiographyComponent implements OnInit {
  formPatient : FormGroup;
  sender : string;
  receiver :  string;
  //ms : Msh = {sendingApplication: this.sender, receivingApplication : this.receiver};
  msh : Msh = {sendingApplication : "",receivingApplication: ""};
  in : In1 = {ID: "", insuranceCompName: "",insuranceExpDate: ""};
  obr : Obr = {ID: "", entityIdentifier: "", nameSpaceID: "", diagnostic: ""};
  obx : Obx={ID: "", diagnostic: ""};
  orc : Orc={ID: "",diagnostic: "", orcOrderControl: "",placerGroupNumber: ""};
  pid : Pid={CI: "",name: "",lastName: "",birthDate: "",gender:null,phoneNumber: "",phoneBusiness: "",address: "",deathIndicator: null,maritalStatus: null,nationality: "",city: ""};
  pv1 : Pv1={ID: "",attendingDoctorName: "",attendingDoctorLastName: "",patientClass: "",admitDateYear: null,admitDateMonth: null,admitDateDay: null,admitDateHour: null,admitDateMin: null};
  msg :  GenericMessage={Msh: null,In1: null,Obr: null,Obx: null,Orc: null,Pid: null,Pv1: null, Evn: "O01"};
  genderSelected : number;
  deceasedSelected : Decesased;
  maritalStatusSelected : MaritalStatus;
  constructor(
    private ApiService : ApiService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.createPatientForm();
  }

  createPatientForm() {
    this.formPatient = this.fb.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: [''],
      address: ['', Validators.required],
      deceased: [''],
      maritalStatus: ['', Validators.required],
      nationality: ['', Validators.required],
      city: ['', Validators.required],
      phone: ['', Validators.required],
      cellphone: ['', Validators.required],
      ci: ['', Validators.required],
      patientClass: ['', Validators.required],
      birthDate: ['', Validators.required],
      
      pvid: ['', Validators.required],
      attendingDoctorName: ['', Validators.required],
      attendingLastDoctorName: ['', Validators.required],
      admitDateYear: ['', Validators.required],
      admitDateMonth: ['', Validators.required],
      admitDateDay: ['', Validators.required],
      admitDateHour: ['', Validators.required],
      admitDateMin: ['', Validators.required],
      
      inid: ['', Validators.required],
      insuranceCompName: ['', Validators.required],
      insuranceExpDate: ['', Validators.required],
      parent: ['', Validators.required],

      obxid: ['', Validators.required],
      obxdiagnostic: ['', Validators.required],

      obrid: ['', Validators.required],
      obrnamespaceid: ['', Validators.required],
      obrentityidentifier: ['', Validators.required],
      obrdiagnostic: ['', Validators.required],

      orcid: ['', Validators.required],
      orcdiagnostic: ['', Validators.required],
      orcordercontrol: ['', Validators.required],
      orcplacergroupnumber: ['', Validators.required]
    });
  }

  selectedGenderOption(event: any) {
    this.genderSelected = event.value;
  }

  selectedDeceasedOption(event: any) {
    this.deceasedSelected = event.value;
  }

  selectedMaritalStatusOption(event: any) {
    this.maritalStatusSelected = event.value;
  }

  onSubmit(formPatient) {
    this.msh.receivingApplication = "RIS";
    this.msh.sendingApplication = "HIS";

    this.pid.CI = formPatient.ci;
    this.pid.address = formPatient.address;
    this.pid.birthDate = formPatient.birthDate;
    this.pid.city = formPatient.city;
    this.pid.deathIndicator = this.deceasedSelected;
    this.pid.gender = this.genderSelected;
    this.pid.lastName = formPatient.lastName;
    this.pid.maritalStatus = this.maritalStatusSelected;
    this.pid.name = formPatient.name;
    this.pid.nationality = formPatient.nationality;
    this.pid.phoneBusiness = formPatient.cellphone;
    this.pid.phoneNumber = formPatient.phone;

    this.in.ID = formPatient.inid;
    this.in.insuranceCompName = formPatient.insuranceCompName;
    this.in.insuranceExpDate = formPatient.insuranceExpDate;

    this.pv1.ID = formPatient.pvid;
    this.pv1.admitDateDay = formPatient.admitDateDay;
    this.pv1.admitDateHour = formPatient.admitDateHour;
    this.pv1.admitDateMin = formPatient.admitDateMin;
    this.pv1.admitDateMonth = formPatient.admitDateMonth;
    this.pv1.admitDateYear = formPatient.admitDateYear;

    this.msg.Msh = this.msh;
    this.msg.Obr = this.obr;
    this.msg.Obx = this.obx;
    this.msg.Orc = this.orc;
    this.msg.Pid = this.pid;
    this.msg.Pv1 = this.pv1;
    this.msg.In1 = this.in;

    this.obx.ID = formPatient.obxid;
    this.obx.diagnostic = formPatient.obxdiagnostic;

    this.obr.ID = formPatient.obrid;
    this.obr.diagnostic = formPatient.obrdiagnostic;
    this.obr.entityIdentifier = formPatient.obrentityidentifier;
    this.obr.nameSpaceID = formPatient.obrnamespaceid;

    this.orc.ID = formPatient.orcid;
    this.orc.diagnostic = formPatient.orcdiagnostic;
    this.orc.orcOrderControl = formPatient.orcordercontrol;
    this.orc.placerGroupNumber = formPatient.orcplacergroupnumber;

    this.ApiService.createORM_O01(this.msg);

  }
}
