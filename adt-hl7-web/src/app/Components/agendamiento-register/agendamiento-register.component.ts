import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-agendamiento-register',
  templateUrl: './agendamiento-register.component.html',
  styleUrls: ['./agendamiento-register.component.css']
})
export class AgendamientoRegisterComponent implements OnInit {
  formSchedule : FormGroup;

  constructor(
    private fb: FormBuilder
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
      parent: ['', Validators.required]
    });
  }

  onSubmit(formPatient) {

  }
}
