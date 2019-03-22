import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-patient-register-component',
  templateUrl: './patient-register-component.component.html',
  styleUrls: ['./patient-register-component.component.css']
})
export class PatientRegisterComponentComponent implements OnInit {
  formPatient : FormGroup;


  constructor(
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
      parent: ['', Validators.required]
    });
  }

  onSubmit(formPatient) {

  }

}
