package com.nitesh.personal_expense_wallet.service;

import com.nitesh.personal_expense_wallet.entity.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> getAll();

    Wallet getById(Long id);

    Wallet createOrUpdate(Wallet wallet);

    void delete(Long id);
}
