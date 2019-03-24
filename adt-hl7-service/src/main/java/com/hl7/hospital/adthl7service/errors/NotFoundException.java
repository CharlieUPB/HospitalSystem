package com.hl7.hospital.adthl7service.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="The requested resource could not be found.")
public class NotFoundException extends RuntimeException {}
