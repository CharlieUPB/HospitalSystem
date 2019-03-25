import {EVENT_TOPICS } from ".";
import { MedicalStaff } from '../Domain';

export interface DataToConfirm {
    event?: EVENT_TOPICS,
    hl7Message?: string;
    medical?: MedicalStaff;
}