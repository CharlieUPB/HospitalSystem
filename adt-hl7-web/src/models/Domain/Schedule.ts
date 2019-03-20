import { Patient , MedicalStaff} from './';

export interface Schedule {
    cod: number;
    patient: Patient;
    medicalStaff: MedicalStaff;
    date: Date;
    hour: Date;
}