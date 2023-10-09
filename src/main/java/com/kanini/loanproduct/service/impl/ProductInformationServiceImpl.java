package com.kanini.loanproduct.service.impl;

import com.kanini.loanproduct.entity.ProductAvailability;
import com.kanini.loanproduct.entity.ProductInformation;
import com.kanini.loanproduct.repository.ProductAvailabilityRepo;
import com.kanini.loanproduct.repository.ProductInformationRepo;
import com.kanini.loanproduct.service.ProductInformationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductInformationRepo productInformationRepo;
    @Autowired
    private ProductAvailabilityRepo productAvailabilityRepo;

    public List<ProductInformation> getAllDetails() {
        List<ProductInformation> productInformations = null;
        productInformations = productInformationRepo.findAll();
        return productInformations;
    }

    @Transactional
    public void createProduct(ProductInformation productInformation) {
        ProductAvailability productAvailability = productInformation.getProductAvailability();
        productAvailability.setProductInformation(productInformation);
        productInformationRepo.save(productInformation);

    }

}
