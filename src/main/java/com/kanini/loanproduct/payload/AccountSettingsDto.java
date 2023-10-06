package com.kanini.loanproduct.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AccountSettingsDto {

    private int id;
    private String idType;
    private String template;
    private int startingFrom;
    private String accountState;
}
