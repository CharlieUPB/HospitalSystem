package com.hl7.hospital.adthl7service.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="You dont have permission to access this resource.")
public class ForbiddenError extends RuntimeException {}
