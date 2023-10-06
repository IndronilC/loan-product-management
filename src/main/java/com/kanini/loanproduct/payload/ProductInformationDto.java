package com.kanini.loanproduct.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductInformationDto {

    private int productId;
    private String productName;
    private String productCategory;
    private String productType;
    private String productDescription;
    private Boolean status;
    LocalDate lastModified= LocalDateTime.now().toLocalDate();
}
