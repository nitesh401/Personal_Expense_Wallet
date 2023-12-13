package com.nitesh.personal_expense_wallet.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationErrorService {

    public ResponseEntity<?> validate(BindingResult result) {
        if (result != null && result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(new ErrorResponse("Validation failed", errors), HttpStatus.BAD_REQUEST);
        } else {
            // Handle the case where result is null
            // For example, you might log a warning or return a different ResponseEntity
            return new ResponseEntity<>("Validation result is null", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Custom ErrorResponse class
    public static class ErrorResponse {
        private final String message;
        private final Map<String, String> errors;

        public ErrorResponse(String message, Map<String, String> errors) {
            this.message = message;
            this.errors = errors;
        }

        public String getMessage() {
            return message;
        }

        public Map<String, String> getErrors() {
            return errors;
        }
    }
}
