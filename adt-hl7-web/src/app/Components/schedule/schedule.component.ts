import { Component, OnInit, Inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { CreateScheduleComponentComponent } from '../create-schedule-component/create-schedule-component.component';


export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  animal: string;
  name: string;
  
  monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
  dayNames = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
  
  date = new FormControl(new Date());
  day = this.date.value.getDate();
  dayName = this.dayNames[this.date.value.getDay()];
  month = this.monthNames[this.date.value.getMonth()];
  year = this.date.value.getFullYear();
  hour = this.date.value.getHours();
  minute = this.date.value.getMinutes();
  serializedDate = new FormControl((new Date()).toISOString());


  constructor(public dialog: MatDialog) { }
  

  ngOnInit() {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreateScheduleComponentComponent, {
      width: '350px',
      data: {name: this.name, animal: this.animal}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }

}
