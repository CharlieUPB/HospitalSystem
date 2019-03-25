import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Schedule, Patient, PatientHistory, MedicalStaff, Diagnostic } from '../models/Domain';
import { Observable } from 'rxjs';
import { GenericMessage } from '../models/ADT';
import { ParseResult, MshSegment } from '../models/ADT/'


@Injectable({
  providedIn: 'root'
})
export class ApiService {


  apiURL: string = 'http://localhost:7000/api/v1';


  constructor(private httpClient: HttpClient) { }

  //Schedules

  public getScheduleAll(): Observable<Schedule[]> {
    return this.httpClient.get<Schedule[]>(`${this.apiURL}/schedules/`);
  }

  public getScheduleByID(id: number): Observable<Schedule> {
    return this.httpClient.get<Schedule>(`${this.apiURL}/schedules/${id}`);
  }

  public getScheduleByDate(date: string): Observable<Schedule[]> {
    return this.httpClient.get<Schedule[]>(`${this.apiURL}/schedules/date/${date}`);
  }

  //Patients

  public getPatientAll(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(`${this.apiURL}/patients/`);
  }

  //Medicals

  public getMedicalAll(): Observable<MedicalStaff[]> {
    return this.httpClient.get<MedicalStaff[]>(`${this.apiURL}/medicalStaff/`);
  }

  public addMedical(med: MedicalStaff): Observable<MedicalStaff> {
    return this.httpClient.post<MedicalStaff>(`${this.apiURL}/medicalStaff/`,med);
  }

  public getMedicalByID(id: number): Observable<MedicalStaff> {
    return this.httpClient.get<MedicalStaff>(`${this.apiURL}/medicalStaff/${id}`);
  }

  //Patient Event History

  public getPatientHistoryAll(): Observable<PatientHistory[]> {
    return this.httpClient.get<PatientHistory[]>(`${this.apiURL}/patientHistories/`);
  }

  public getPatientHistoryByCI(CI: number): Observable<PatientHistory[]> {
    return this.httpClient.get<PatientHistory[]>(`${this.apiURL}/patientHistories/${CI}`);
  }

  //Diagnostics 

  public getDiagnosticsByPatientCI(CI: number): Observable<Diagnostic[]> {
    return this.httpClient.get<Diagnostic[]>(`${this.apiURL}/diagnostics/patient/${CI}`);
  }

  //ADTS

  public createADT_A01(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a01`,message);
  }
  public createADT_A02(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a02`,message);
  }
  public createADT_A03(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a03`,message);
  }
  public createADT_A04(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a04`,message);
  }
  public createADT_A05(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a05`,message);
  }
  public createADT_A08(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a08`,message);
  }
  public createADT_A11(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a11`,message);
  }
  public createADT_A12(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a12`,message);
  }
  public createADT_A13(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/adt/a13`,message);
  }
  
  public createOML_O21(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/oml/oml-o21`,message);
  }
  
  public createORM_O01(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/orm/orm-o01`,message);
  }
  
  public createRDE_O11(message: GenericMessage): Observable<ParseResult> {
    return this.httpClient.post<ParseResult>(`${this.apiURL}/rde/rde-o11`,message);
  }

  public getACKID(hl7message: any): Observable<MshSegment> {
    return this.httpClient.post<MshSegment>(`${this.apiURL}/ack/`,hl7message);
  }
  
}
