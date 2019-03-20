import { Patient } from './';
import { ADT } from '../ADT'

export interface PatientHistory {
    cod: string;
    patient: Patient;
    adtCode: ADT;
    details: string;
}   