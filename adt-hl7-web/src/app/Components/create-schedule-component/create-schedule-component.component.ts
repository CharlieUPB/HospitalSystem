import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { FormControl } from '@angular/forms';


export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-create-schedule-component',
  templateUrl: './create-schedule-component.component.html',
  styleUrls: ['./create-schedule-component.component.css']
})
export class CreateScheduleComponentComponent implements OnInit {

  date = new FormControl(new Date());
  day = this.date.value.getDate();
  month = this.date.value.getMonth();
  year = this.date.value.getFullYear();
  hour = this.date.value.getHours();
  minute = this.date.value.getMinutes();
  serializedDate = new FormControl((new Date()).toISOString());

  constructor(public dialogRef: MatDialogRef<CreateScheduleComponentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }

    onNoClick(): void {
      this.dialogRef.close();
    }
       
  ngOnInit() {
  }

}
