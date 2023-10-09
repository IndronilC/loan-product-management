package com.kanini.loanproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false, exclude = {"productInformation"})
@ToString(exclude={"productInformation"})
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
    @MapsId
    @JsonBackReference
    private ProductInformation productInformation;
}
