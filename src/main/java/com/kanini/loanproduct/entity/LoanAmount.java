package com.kanini.loanproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false, exclude = {"productInformation"})
@ToString(exclude={"productInformation"})
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
    @MapsId
    @JsonBackReference
    private ProductInformation productInformation;
}

