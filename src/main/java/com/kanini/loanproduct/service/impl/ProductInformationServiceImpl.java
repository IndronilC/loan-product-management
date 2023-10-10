package com.kanini.loanproduct.service.impl;

import com.kanini.loanproduct.entity.*;
import com.kanini.loanproduct.repository.ProductAvailabilityRepo;
import com.kanini.loanproduct.repository.ProductInformationRepo;
import com.kanini.loanproduct.service.ProductInformationService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductInformationRepo productInformationRepo;
    @Autowired
    private ProductAvailabilityRepo productAvailabilityRepo;

    public List<ProductInformation> getAllDetails() {
        List<ProductInformation> productInformations = null;
        productInformations = productInformationRepo.findAll();
        log.info("Loan Product Details Has Been Executed Successfully");
        return productInformations;
    }


    @Transactional
    public void createProduct(ProductInformation productInformation) {
        ProductAvailability productAvailability = productInformation.getProductAvailability();
        AccountSettings accountSettings = productInformation.getAccountSettings();
        InterestRate interestRate = productInformation.getInterestRate();
        LoanAmount loanAmount = productInformation.getLoanAmount();
        Repayments repayments = productInformation.getRepayments();
        productAvailability.setProductInformation(productInformation);
        accountSettings.setProductInformation(productInformation);
        interestRate.setProductInformation(productInformation);
        loanAmount.setProductInformation(productInformation);
        repayments.setProductInformation(productInformation);
        productInformationRepo.save(productInformation);
        log.info("Loan product Details Has Been Created Successfully");

    }

    public void deleteProduct(int productId) {
        ProductInformation productInformation = productInformationRepo.findById(productId).orElse(null);
        productInformationRepo.delete(productInformation);
        log.info("Loan Product Details Has Been Deleted Successfully ");
    }

    @Transactional
    public ProductInformation updateProduct(ProductInformation productInformation, int productId) {
        ProductInformation existProductInformation = productInformationRepo.findById(productId).orElse(null);
        existProductInformation.setProductId(productId);
        existProductInformation.setProductName(productInformation.getProductName());
        existProductInformation.setProductType(productInformation.getProductType());
        existProductInformation.setProductCategory(productInformation.getProductType());
        existProductInformation.setProductDescription(productInformation.getProductDescription());
        existProductInformation.setStatus(productInformation.getStatus());
        existProductInformation.setProductAvailability(productInformation.getProductAvailability());
        existProductInformation.setAccountSettings(productInformation.getAccountSettings());
        existProductInformation.setInterestRate(productInformation.getInterestRate());
        existProductInformation.setRepayments(productInformation.getRepayments());
        existProductInformation.setLoanAmount(productInformation.getLoanAmount());
        ProductAvailability productAvailability = productInformation.getProductAvailability();
        AccountSettings accountSettings = productInformation.getAccountSettings();
        InterestRate interestRate = productInformation.getInterestRate();
        LoanAmount loanAmount = productInformation.getLoanAmount();
        Repayments repayments = productInformation.getRepayments();
        productAvailability.setProductInformation(productInformation);
        accountSettings.setProductInformation(productInformation);
        interestRate.setProductInformation(productInformation);
        loanAmount.setProductInformation(productInformation);
        repayments.setProductInformation(productInformation);
        log.info("Loan product Details Has Been Updated Successfully");
        return productInformationRepo.save(existProductInformation);
    }
}
