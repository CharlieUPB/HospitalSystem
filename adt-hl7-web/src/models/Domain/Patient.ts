export interface Patient {
    cod : number;
	name: string;
	lastName: string;
	gender: Gender ;
	birthDate: Date;
	phone: string;
	cellPhone: string;
	address: string;
	deceased: Decesased;
	maritalStatus: MaritalStatus;
	nationality: string;
	city: string;
}

export enum Gender {
    male,
    female,
    other,
}

export type Decesased = "YES" | "NO";

export type MaritalStatus = "Separated" | "Divorced" | "Married"
							| "Single" | "Widowed"