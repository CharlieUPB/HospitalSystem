import { Patient , MedicalStaff} from './';

export interface Schedule {
    cod: number;
    codPatient: Patient;
    codDoctor: MedicalStaff;
    date: string;
    hour: string;
}