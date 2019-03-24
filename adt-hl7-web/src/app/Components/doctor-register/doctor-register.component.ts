import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-doctor-register',
  templateUrl: './doctor-register.component.html',
  styleUrls: ['./doctor-register.component.css']
})
export class DoctorRegisterComponent implements OnInit {

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
      speciality  : ['', Validators.required],
      parent: ['', Validators.required]
    });
  }

  onSubmit(formPatient) {

  }

}
