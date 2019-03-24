import { Gender, Decesased, MaritalStatus } from '../Domain/'

export interface Pid {
   CI: string;
   name: string;
   lastName: string;
   birthDate: string;
   gender: Gender;
   phoneNumber: string;
   phoneBusiness: string;
   address: string;
   deathIndicator: Decesased;
   maritalStatus: MaritalStatus;
   nationality: string;
   city: string;
}