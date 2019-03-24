import { Patient } from './';
import { ADT } from '../ADT'

export interface PatientHistory {
    cod: string;
    patient: Patient;
    adtCode: ADT;
    mshID: string;
    details: string;
    eventDate: string;
    eventTime: string;
}   