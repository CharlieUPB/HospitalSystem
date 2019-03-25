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
import { ParseResult, ADT, EVENT_TOPICS, DataToConfirm } from 'src/models/ADT';
import { MatDialog } from '@angular/material';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-patient-register-component',
  templateUrl: './patient-register-component.component.html',
  styleUrls: ['./patient-register-component.component.css']
})
export class PatientRegisterComponentComponent implements OnInit {
  formPatient : FormGroup;
  private sub: any;
  id: number;
  titleText: string = "Registrar Paciente";
  msh : Msh = {sendingApplication : "",receivingApplication: ""};
  in : In1 = {ID: "", insuranceCompName: "",insuranceExpDate: ""};
  obr : Obr = {ID: "", entityIdentifier: "", nameSpaceID: "", diagnostic: ""};
  obx : Obx={ID: "", diagnostic: ""};
  orc : Orc={ID: "",diagnostic: "", orcOrderControl: "",placerGroupNumber: ""};
  pid : Pid={CI: "",name: "",lastName: "",birthDate: "",gender:null,phoneNumber: "",phoneBusiness: "",address: "",deathIndicator: null,maritalStatus: null,nationality: "",city: ""};
  pv1 : Pv1={ID: "",attendingDoctorName: "",attendingDoctorLastName: "",patientClass: "",admitDateYear: null,admitDateMonth: null,admitDateDay: null,admitDateHour: null,admitDateMin: null};
  msg :  GenericMessage={Msh: null,In1: null,Obr: null,Obx: null,Orc: null,Pid: null,Pv1: null, Evn: null};
  genderSelected : number;
  deceasedSelected : Decesased;
  maritalStatusSelected : MaritalStatus;
  hl7Message: string = "";

  constructor(
    private ApiService : ApiService,
    private fb: FormBuilder,
    public dialog: MatDialog,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      if(this.id) {
        this.titleText = "Actualizar informacion de Paciente";
      }
    });
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
      
      insuranceCompName: ['', Validators.required],
      insuranceExpDate: ['', Validators.required],
      parent: ['', Validators.required]
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

    this.msh.receivingApplication = "any";
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

    this.in.insuranceCompName = formPatient.insuranceCompName;
    this.in.insuranceExpDate = formPatient.insuranceExpDate;

    this.msg.Msh = this.msh;
    this.msg.Obr = this.obr;
    this.msg.Obx = this.obx;
    this.msg.Orc = this.orc;
    this.msg.Pid = this.pid;
    this.msg.Pv1 = this.pv1;
    this.msg.In1 = this.in;

    if(this.id) {
      this.msg.Evn = "A08";
      this.ApiService.createADT_A08(this.msg).subscribe((data: ParseResult) => {
        this.hl7Message = data.data;
        let dataToConfirmModal : DataToConfirm = {
          event: "ADT-A08",
          hl7Message: this.hl7Message,
        };
        const dialogRef = this.dialog.open(ConfirmModalComponent, {
          width: '380px',
          data: dataToConfirmModal,
          });
      });
    } else {
      this.msg.Evn = "A04";
      this.ApiService.createADT_A04(this.msg).subscribe((data: ParseResult) => {
        this.hl7Message = data.data;
        let dataToConfirmModal : DataToConfirm = {
          event: "ADT-A04",
          hl7Message: this.hl7Message,
        };
        const dialogRef = this.dialog.open(ConfirmModalComponent, {
          width: '380px',
          data: dataToConfirmModal,
          });
      });
    }

    

  }

}
