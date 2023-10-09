package com.kanini.loanproduct.service;

import com.kanini.loanproduct.entity.ProductInformation;

import java.util.List;

public interface ProductInformationService {

    List<ProductInformation> getAllDetails();

    public void createProduct(ProductInformation productInformation);
}
