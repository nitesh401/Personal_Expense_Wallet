package com.nitesh.personal_expense_wallet.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

class ValidationErrorServiceTest {
    ValidationErrorService validationErrorService = new ValidationErrorService();
    @Test
    void testValidate() {
        ResponseEntity<?> result = validationErrorService.validate(null);
        Assertions.assertNotNull(result);
    }



}
