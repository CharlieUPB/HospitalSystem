import { In1, Msh, Obr , Obx, Orc, Pid, Pv1, ADT} from './'

export interface GenericMessage {
    Msh: Msh;
    In1: In1;
    Obr: Obr;
    Obx: Obx;
    Orc: Orc;
    Pid: Pid;
    Pv1: Pv1;
    Evn: ADT;
}