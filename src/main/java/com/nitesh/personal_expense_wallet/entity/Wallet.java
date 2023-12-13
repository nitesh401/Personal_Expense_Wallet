package com.nitesh.personal_expense_wallet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 2, max = 20)
    private String name;

    @Size(min = 9, max = 18)
    private String accountNumber;

    @Size(max = 80)
    private String description;

    @Min(1)
    @Max(3)
    private Integer priority; // set priority for high low medium

    private Double currentBalance;

    @PrePersist
    public void setBalance() {
        this.currentBalance = 0.0;
    }
}

