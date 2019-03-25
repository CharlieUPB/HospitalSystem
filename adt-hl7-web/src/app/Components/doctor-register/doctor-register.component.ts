import { Component, OnInit, Inject } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Gender, MedicalStaff } from '../../../models/Domain';
import { DataToConfirm } from 'src/models/ADT';
import { MatDialog } from '@angular/material';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';

@Component({
  selector: 'app-doctor-register',
  templateUrl: './doctor-register.component.html',
  styleUrls: ['./doctor-register.component.css']
})
export class DoctorRegisterComponent implements OnInit {
  doctor : MedicalStaff = {cod: null,name: null,lastName: null,gender: null,specality: null};
  formDoctor : FormGroup;
  genderSelected: Gender;


  constructor(
    private fb: FormBuilder,
    public dialog: MatDialog
    ) { }

  

  ngOnInit() {
    this.createPatientForm();
  }
  createPatientForm() {
    this.formDoctor = this.fb.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: [''],
      speciality  : ['', Validators.required]
    });
  }

  selectedGenderOption(event: any) {
    this.genderSelected = event.value;
  }

  onSubmit(formDoctor) {
    this.doctor.name = formDoctor.name;
    this.doctor.lastName = formDoctor.lastName;
    this.doctor.specality = formDoctor.speciality;
    this.doctor.gender = this.genderSelected;

    let dataToConfirmModal : DataToConfirm = {
      medical: this.doctor,
    };

    const dialogRef = this.dialog.open(ConfirmModalComponent, {
      width: '380px',
      data: dataToConfirmModal,
      });

  }

}
