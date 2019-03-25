import { Patient , MedicalStaff} from './';

export interface Schedule {
    cod: number;
    codPatient: Patient;
    codMedicalStaff: MedicalStaff;
    date: string;
    hour: string;
}