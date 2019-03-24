package com.hl7.hospital.adthl7service.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason="The body of the request couldn't be parsed to hl7.")
public class ParsingException extends RuntimeException {}
