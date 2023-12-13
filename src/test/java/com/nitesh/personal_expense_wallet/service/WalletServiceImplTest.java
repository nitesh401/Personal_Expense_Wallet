package com.nitesh.personal_expense_wallet.service;

import com.nitesh.personal_expense_wallet.entity.Wallet;
import com.nitesh.personal_expense_wallet.exception.WalletNotFoundException;
import com.nitesh.personal_expense_wallet.repository.WalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class WalletServiceImplTest {
    @Mock
    WalletRepository walletRepository;

    @InjectMocks
    WalletServiceImpl walletServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Assuming walletRepository.getAll() returns a list of Wallets
        when(walletRepository.findAll()).thenReturn(List.of(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0))));

        List<Wallet> result = walletServiceImpl.getAll();
        Assertions.assertEquals(List.of(new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0))), result);
    }

    @Test
    void testGetByIdNotFound() {
        // Mocking the findById method to return an empty Optional
        when(walletRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Calling the getById method of walletServiceImpl and expecting a WalletNotFoundException
        WalletNotFoundException exception = Assertions.assertThrows(WalletNotFoundException.class, () -> walletServiceImpl.getById(1L));

        // Asserting the exception message
        Assertions.assertEquals("Wallet not found with id: 1", exception.getMessage());
    }


    @Test
    void testCreateOrUpdate() {
        Wallet wallet = new Wallet(Long.valueOf(1), "name", "accountNumber", "description", Integer.valueOf(0), Double.valueOf(0));
        when(walletRepository.save(wallet)).thenReturn(wallet);

        Wallet result = walletServiceImpl.createOrUpdate(wallet);
        Assertions.assertEquals(wallet, result);
    }


    @Test
    void testDelete() {
        walletServiceImpl.delete(Long.valueOf(1));
    }
}
