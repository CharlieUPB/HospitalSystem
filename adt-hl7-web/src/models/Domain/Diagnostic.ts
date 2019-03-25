import { Patient, MedicalStaff } from './';

export interface Diagnostic {
    codDiagnostic: number;
    patient : Patient;
    doctor: MedicalStaff;
    description: string;
}