package com.kanini.loanproduct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Table(name="repayments")
public class Repayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column (name="repayment_on_every")
    private String repaymentOnEvery;

    @Column(name="installment_min_value")
    private long installmentMinValue;

    @Column(name = "installment_max_value")
    private long installmentMaxValue;

    @Column(name="due_default_value")
    private long dueDefaultValue;

    @Column(name="due_min_value")
    private long due_min_value;

    @Column(name="due_max_value")
    private long dueMaxValue;

    @OneToOne
    @JoinColumn(name="product_id")
    private ProductInformation productInformation;
}
