import { Component, OnInit, Inject } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatTableDataSource } from '@angular/material';
import { CreateScheduleComponentComponent } from '../create-schedule-component/create-schedule-component.component';
import { Schedule } from 'src/models/Domain';
import { ApiService } from 'src/app/api.service';


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
  day = this.date.value.getDate();
  dayName = this.dayNames[this.date.value.getDay()];
  month = this.monthNames[this.date.value.getMonth()];
  year = this.date.value.getFullYear();
  hour = this.date.value.getHours();
  minute = this.date.value.getMinutes();
  serializedDate = new FormControl((new Date()).toISOString());


  constructor(public dialog: MatDialog, private service: ApiService) { }
  

  ngOnInit() {
    this.service.getScheduleByDate(`${this.year}${this.date.value.getMonth + 1}${this.day}`).subscribe((data: Schedule[]) => {
      this.citas = data;
    });
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


  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
