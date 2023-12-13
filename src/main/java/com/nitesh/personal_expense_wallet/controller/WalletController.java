package com.nitesh.personal_expense_wallet.controller;

import com.nitesh.personal_expense_wallet.entity.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface WalletController {
    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> create(Wallet wallet,BindingResult result);

    ResponseEntity<?> update(Long id, Wallet wallet, BindingResult result);

    ResponseEntity<?> delete(Long id);
}
