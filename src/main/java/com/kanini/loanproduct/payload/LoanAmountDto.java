package com.kanini.loanproduct.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoanAmountDto {
    private int id;
    private  long defaultValue;
    private long minValue;
    private long maxValue;
    private long tranches;
    private String accountManagement;
}
