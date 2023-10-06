package com.kanini.loanproduct.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterestRateDto {


    private int id;
    private String loanAmount;
    private String interestFrequency;
    private String accrueInterestAfterMaturity;
    private String interestType;
    private String interestRate;
    private long defaultValue;
    private long minValue;
    private String daysInYear;
    private String interestCalculation;
}
