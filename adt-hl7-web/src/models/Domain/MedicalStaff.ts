import { Gender , Diagnostic, Schedule } from './'

export interface MedicalStaff {
    cod: number;
    name: string;
    lastName: string;
    gender: Gender;
    specality: string;
    diagnostics: Diagnostic[];
    schedules: Schedule[];
}