package com.nitesh.personal_expense_wallet.service;

import com.nitesh.personal_expense_wallet.entity.Wallet;
import com.nitesh.personal_expense_wallet.exception.WalletNotFoundException;
import com.nitesh.personal_expense_wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet getById(Long id) {
        return walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found with id: " + id));
    }

    @Override
    public Wallet createOrUpdate(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void delete(Long id) {
        walletRepository.deleteById(id);
    }
}
