import { Patient, MedicalStaff } from './';

export interface Diagnostic {
    codDiagnostic: number;
    patient : Patient;
    medicalStaff: MedicalStaff;
    description: string;
}