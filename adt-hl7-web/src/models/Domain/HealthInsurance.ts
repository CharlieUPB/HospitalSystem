import { Patient } from './'

export interface HealthInsurance {
    cod: number;
    nameOrganization: string;
    vecDate: Date;
    patient: Patient;
}