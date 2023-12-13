package com.nitesh.personal_expense_wallet.controller;

import com.nitesh.personal_expense_wallet.entity.Wallet;
import com.nitesh.personal_expense_wallet.service.ValidationErrorService;
import com.nitesh.personal_expense_wallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletControllerImpl implements WalletController{
    private final WalletService walletService;
    private final ValidationErrorService validationService;

    @Autowired
    public WalletControllerImpl(WalletService walletService, ValidationErrorService validationService) {
        this.walletService = walletService;
        this.validationService = validationService;
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(walletService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.getById(id), HttpStatus.OK);
    }
    @Override
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result) {
        ResponseEntity<?> errors = validationService.validate(result);
        if (errors != null) return errors;

        Wallet walletSaved = walletService.createOrUpdate(wallet);
        return new ResponseEntity<>(walletSaved, HttpStatus.CREATED);
    }
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Wallet wallet, BindingResult result) {
        ResponseEntity<?> errors = validationService.validate(result);
        if (errors != null) return errors;

        wallet.setId(id);
        Wallet walletSaved = walletService.createOrUpdate(wallet);
        return new ResponseEntity<>(walletSaved, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        walletService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
