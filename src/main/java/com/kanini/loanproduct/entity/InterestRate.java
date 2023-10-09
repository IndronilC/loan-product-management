package com.kanini.loanproduct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="interest_rate")
public class InterestRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="loan_amount")
    private String loanAmount;

    @Column(name="interest_frequency")
    private String interestFrequency;

    @Column(name = "accrue_interest_after_maturity")
    private String accrueInterestAfterMaturity;

    @Column (name="interest_type")
    private String interestType;

    @Column (name="interest_rate")
    private String interestRate;

    @Column (name="default_value")
    private long defaultValue;

    @Column (name="min_value")
    private long minValue;

    @Column (name="days_in_year")
    private String daysInYear;

    @Column (name="interest_calculation")
    private String interestCalculation;

    @OneToOne
    @JoinColumn(name="product_id")
    private ProductInformation productInformation;
}
