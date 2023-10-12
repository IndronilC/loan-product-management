package com.kanini.loanproduct.service;

import com.kanini.loanproduct.entity.ProductInformation;
import com.kanini.loanproduct.payload.ProductInformationDto;

import java.util.List;

public interface ProductInformationService {

    List<ProductInformationDto> getAllDetails();

    public void createProduct(ProductInformationDto productInformationDto);
    public void deleteProduct(int productId);

    public ProductInformation updateProduct(ProductInformation productInformation,int productId);
}
