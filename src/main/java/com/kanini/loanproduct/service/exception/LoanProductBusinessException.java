package com.kanini.loanproduct.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanProductBusinessException extends RuntimeException {
    private String message;
    private Throwable cause;

}
