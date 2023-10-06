package com.kanini.loanproduct.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RepaymentsDto {

    private int id;
    private String paymentMethod;
    private String repaymentOnEvery;
    private long installmentMinValue;
    private long installmentMaxValue;
    private long dueDefaultValue;
    private long due_min_value;
    private long dueMaxValue;

}
