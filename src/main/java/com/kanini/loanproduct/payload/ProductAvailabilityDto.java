package com.kanini.loanproduct.payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductAvailabilityDto {

    private int id;
    private String productAvailable;
    private String branches;
}
