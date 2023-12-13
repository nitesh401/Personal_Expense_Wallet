package com.nitesh.personal_expense_wallet.controller;

import com.nitesh.personal_expense_wallet.entity.Wallet;
import com.nitesh.personal_expense_wallet.service.ValidationErrorService;
import com.nitesh.personal_expense_wallet.service.WalletService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

class WalletControllerImplTest {
    @Mock
    WalletService walletService;
    @Mock
    ValidationErrorService validationService;
    @InjectMocks
    WalletControllerImpl walletControllerImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(walletService.getAll()).thenReturn(List.of(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0))));

        ResponseEntity<?> result = walletControllerImpl.getAll();
        Assertions.assertNotNull( result);
    }

    @Test
    void testGetById() {
        when(walletService.getById(anyLong())).thenReturn(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0)));

        ResponseEntity<?> result = walletControllerImpl.getById(Long.valueOf(1));
        Assertions.assertNotNull( result);
    }

    @Test
    void testCreate() {
        when(walletService.createOrUpdate(any())).thenReturn(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0)));
        when(validationService.validate(any())).thenReturn(null);

        ResponseEntity<?> result = walletControllerImpl.create(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0)), null);
        Assertions.assertNotNull( result);
    }

    @Test
    void testUpdate() {
        when(walletService.createOrUpdate(any())).thenReturn(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0)));
        when(validationService.validate(any())).thenReturn(null);
        ResponseEntity<?> result = walletControllerImpl.update(Long.valueOf(1), new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0)), null);
        Assertions.assertNotNull( result);
    }

    @Test
    void testDelete() {
        ResponseEntity<?> result = walletControllerImpl.delete(Long.valueOf(1));
        Assertions.assertNotNull( result);
    }
}
