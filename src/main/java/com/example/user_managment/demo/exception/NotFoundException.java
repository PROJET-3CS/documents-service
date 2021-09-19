package com.example.user_managment.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Document not found")
public class NotFoundException extends RuntimeException {
    
}
