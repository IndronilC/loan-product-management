package com.kanini.loanproduct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name="loan_amount")

public class LoanAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;

    @Column(name="default_value")
    private  long defaultValue;

    @Column(name="min_value")
    private long minValue;

    @Column(name="max_value")
    private long maxValue;

    @Column (name="tranches")
    private long tranches;

    @Column(name="account_management")
    private String accountManagement;

    @OneToOne
    @JoinColumn(name="product_id")
    private ProductInformation productInformation;
}

