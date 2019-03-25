import { Patient } from './';
import { ADT } from '../ADT'

export interface PatientHistory {
    cod: string;
    patientPH: Patient;
    adtCode: ADT;
    mshID: string;
    details: string;
    eventDate: string;
    eventTime: string;
    acked: boolean;
    ackType: string;
}   