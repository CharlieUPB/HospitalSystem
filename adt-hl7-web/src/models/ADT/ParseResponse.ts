export interface ParseResult {
  data: string;
}

//Used to get ACK information.

export interface MshSegment {
  mshControlID: string;
  ackType: string;
}