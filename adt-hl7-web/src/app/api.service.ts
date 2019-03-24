import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Schedule, Patient, PatientHistory } from '../models/Domain';
import { Observable } from 'rxjs';
import { GenericMessage } from '../models/ADT';

interface parseResult {
  data: string;
}

interface mshSegment {
  mshControlID: string;
  mshSendingApplication: string;
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {


  apiURL: string = 'http://localhost:7000/api/v1';


  constructor(private httpClient: HttpClient) { }

  public getScheduleAll(): Observable<Schedule[]> {
    return this.httpClient.get<Schedule[]>(`${this.apiURL}/schedules/`);
  }
  public getScheduleByCI(CI: number): Observable<Schedule[]> {
    return this.httpClient.get<Schedule[]>(`${this.apiURL}/schedules/${CI}`);
    
  }

  public getScheduleByDate(date: string): Observable<Schedule[]> {
    return this.httpClient.get<Schedule[]>(`${this.apiURL}/schedules/${date}`);
  }

  public getPatientHistoryAll(): Observable<PatientHistory[]> {
    return this.httpClient.get<PatientHistory[]>(`${this.apiURL}/patientHistories/`);
  }

  public getPatientHistoryByCI(CI: number): Observable<PatientHistory[]> {
    return this.httpClient.get<PatientHistory[]>(`${this.apiURL}/patientHistories/${CI}`);
  }

  public createADT_A01(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a01`,message);
  }
  public createADT_A02(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a02`,message);
  }
  public createADT_A03(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a03`,message);
  }
  public createADT_A04(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a04`,message);
  }
  public createADT_A05(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a05`,message);
  }
  public createADT_A08(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a08`,message);
  }
  public createADT_A11(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a11`,message);
  }
  public createADT_A12(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a12`,message);
  }
  public createADT_A13(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/adt/a13`,message);
  }
  
  public createOML_O21(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/oml/oml-o21`,message);
  }
  
  public createORM_O01(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/orm/orm-o01`,message);
  }
  
  public createRDE_O11(message: GenericMessage): Observable<parseResult> {
    return this.httpClient.post<parseResult>(`${this.apiURL}/rde/rde-o11`,message);
  }

  public getACKID(hl7message: any): Observable<mshSegment> {
    return this.httpClient.post<mshSegment>(`${this.apiURL}/ack/`,hl7message);
  }
  
}
