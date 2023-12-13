package com.nitesh.personal_expense_wallet.repository;
import com.nitesh.personal_expense_wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findById(@NonNull Long id);
}
