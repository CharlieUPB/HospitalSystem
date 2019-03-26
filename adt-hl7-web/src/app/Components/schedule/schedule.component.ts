import { Component, OnInit, Inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatTableDataSource } from '@angular/material';
import { CreateScheduleComponentComponent } from '../create-schedule-component/create-schedule-component.component';
import { Schedule } from 'src/models/Domain';
import { ApiService } from 'src/app/api.service';
import * as moment  from 'moment';
import { AgendamientoRegisterComponent } from '../agendamiento-register/agendamiento-register.component';


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  citas: Schedule[];

  monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
  dayNames = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
  
  date = new FormControl(new Date());
  parsedDate: string;
  dataSource = new MatTableDataSource(this.citas);
  day: string;
  month: string;
  year: string;

  constructor(public dialog: MatDialog, private service: ApiService) { }
  

  ngOnInit() {
    this.parsedDate = moment(this.date.value).format('DD/MM/YYYY')
    let splited = this.parsedDate.split('/');
    this.day = splited[0];
    this.month = splited[1];
    this.year = splited[2];
    console.log(`${this.day} ${this.month} ${this.year}`);
    this.service.getScheduleByDate(`${this.year}${this.month}${this.day}`).subscribe((data: Schedule[]) => {
      this.citas = data;
      this.dataSource = new MatTableDataSource(this.citas);
    });
  }

  loadSchedules() {
    this.parsedDate = moment(this.date.value).format('DD/MM/YYYY')
    let splited = this.parsedDate.split('/');
    this.day = splited[0];
    this.month = splited[1];
    this.year = splited[2];
    console.log(`${this.day} ${this.month} ${this.year}`);
    this.service.getScheduleByDate(`${this.year}${this.month}${this.day}`).subscribe((data: Schedule[]) => {
      this.citas = data;
      this.dataSource = new MatTableDataSource(this.citas);
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AgendamientoRegisterComponent, {
      width: '350px',
    });
  }

}
