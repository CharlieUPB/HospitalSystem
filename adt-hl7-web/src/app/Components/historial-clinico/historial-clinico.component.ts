import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';
import { Diagnostic, Patient, MedicalStaff } from 'src/models/Domain';

@Component({
  selector: 'app-historial-clinico',
  templateUrl: './historial-clinico.component.html',
  styleUrls: ['./historial-clinico.component.css']
})
export class HistorialClinicoComponent implements OnInit {

  private sub: any;
  patientCI: number;
  diagnostics: Diagnostic[];
  patient: Patient;

  constructor(private route: ActivatedRoute, private service: ApiService, ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.patientCI = +params['id']; // (+) converts string 'id' to a number
   });
   this.service.getDiagnosticsByPatientCI(this.patientCI).subscribe((response: Diagnostic[]) => {
     this.diagnostics = response;
     if(this.diagnostics.length > 0) {
       this.patient = this.diagnostics[0].patient;
     }
   })
  }

}
