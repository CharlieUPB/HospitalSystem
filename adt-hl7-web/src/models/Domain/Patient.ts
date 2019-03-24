import { HealthInsurance } from './HealthInsurance';

export interface Patient {
    cod : number;
	name: string;
	lastName: string;
	gender: Gender ;
	birthDate: Date;
	phone: string | null;
	cellPhone: string | null;
	address: string | null;
	deceased: Decesased;
	maritalStatus: MaritalStatus | null;
	nationality: string;
	city: string;
	codSecure: HealthInsurance;
	CI: number;
}

export enum Gender {
    female,
    male,
    other,
}

export type Decesased = "YES" | "NO";

export type MaritalStatus = "Separated" | "Divorced" | "Married"
							| "Single" | "Widowed"