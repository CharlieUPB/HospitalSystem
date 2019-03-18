package com.hl7.hospital.adthl7service.errors;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="You requested to the wrong parser endpoint.")
public class BadRequestError extends RuntimeException {}
