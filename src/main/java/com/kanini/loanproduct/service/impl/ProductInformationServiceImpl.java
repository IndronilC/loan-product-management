package com.kanini.loanproduct.service.impl;

import com.kanini.loanproduct.entity.*;
import com.kanini.loanproduct.payload.ProductInformationDto;
import com.kanini.loanproduct.repository.ProductAvailabilityRepo;
import com.kanini.loanproduct.repository.ProductInformationRepo;
import com.kanini.loanproduct.service.ProductInformationService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductInformationRepo productInformationRepo;
    @Autowired
    private ProductAvailabilityRepo productAvailabilityRepo;
    @Autowired
    private ModelMapper modelMapper;

    //    public List<ProductInformation> getAllDetails() {
//        List<ProductInformation> productInformations = null;
//        productInformations = productInformationRepo.findAll();
//        log.info("Loan Product Details Has Been Executed Successfully");
//        return productInformations;
//    }
//
//
//    @Transactional
//    public void createProduct(ProductInformation productInformation) {
//        ProductAvailability productAvailability = productInformation.getProductAvailability();
//        AccountSettings accountSettings = productInformation.getAccountSettings();
//        InterestRate interestRate = productInformation.getInterestRate();
//        LoanAmount loanAmount = productInformation.getLoanAmount();
//        Repayments repayments = productInformation.getRepayments();
//        productAvailability.setProductInformation(productInformation);
//        accountSettings.setProductInformation(productInformation);
//        interestRate.setProductInformation(productInformation);
//        loanAmount.setProductInformation(productInformation);
//        repayments.setProductInformation(productInformation);
//        productInformationRepo.save(productInformation);
//        log.info("Loan product Details Has Been Created Successfully");
//
//    }
//
//    public void deleteProduct(int productId) {
//        ProductInformation productInformation = productInformationRepo.findById(productId).orElse(null);
//        productInformationRepo.delete(productInformation);
//        log.info("Loan Product Details Has Been Deleted Successfully ");
//    }
//
//    @Transactional
//    public ProductInformation updateProduct(ProductInformation productInformation, int productId) {
//        ProductInformation existProductInformation = productInformationRepo.findById(productId).orElse(null);
//        existProductInformation.setProductId(productId);
//        existProductInformation.setProductName(productInformation.getProductName());
//        existProductInformation.setProductType(productInformation.getProductType());
//        existProductInformation.setProductCategory(productInformation.getProductType());
//        existProductInformation.setProductDescription(productInformation.getProductDescription());
//        existProductInformation.setStatus(productInformation.getStatus());
//        existProductInformation.setProductAvailability(productInformation.getProductAvailability());
//        existProductInformation.setAccountSettings(productInformation.getAccountSettings());
//        existProductInformation.setInterestRate(productInformation.getInterestRate());
//        existProductInformation.setRepayments(productInformation.getRepayments());
//        existProductInformation.setLoanAmount(productInformation.getLoanAmount());
//        ProductAvailability productAvailability = productInformation.getProductAvailability();
//        AccountSettings accountSettings = productInformation.getAccountSettings();
//        InterestRate interestRate = productInformation.getInterestRate();
//        LoanAmount loanAmount = productInformation.getLoanAmount();
//        Repayments repayments = productInformation.getRepayments();
//        productAvailability.setProductInformation(productInformation);
//        accountSettings.setProductInformation(productInformation);
//        interestRate.setProductInformation(productInformation);
//        loanAmount.setProductInformation(productInformation);
//        repayments.setProductInformation(productInformation);
//        log.info("Loan product Details Has Been Updated Successfully");
//        return productInformationRepo.save(existProductInformation);
//    }
    public List<ProductInformationDto> getAllDetails() {
        List<ProductInformation> productInformations = productInformationRepo.findAll();
        List<ProductInformationDto> productInformationDtos = productInformations.stream().map(productInformation ->
                productInformationToProductInformationDto(productInformation)).collect(Collectors.toList());
        log.info("Loan Product Details Has Been Executed Successfully");
        return productInformationDtos;
    }

    public ProductInformation productInformationDtoToProductInformation(ProductInformationDto productInformationDto) {
        ProductInformation productDetails = this.modelMapper.map(productInformationDto, ProductInformation.class);
        return productDetails;
    }

    public ProductInformationDto productInformationToProductInformationDto(ProductInformation productInformation) {
        ProductInformationDto productDtoDetails = this.modelMapper.map(productInformation, ProductInformationDto.class);
        return productDtoDetails;
    }

    @Transactional
    public void createProduct(ProductInformationDto productInformationDto) {
        ProductInformation productInformation = productInformationDtoToProductInformation(productInformationDto);
        ProductAvailability productAvailability = productInformation.getProductAvailability();
        setProductInformatinToChildEntities(productInformation, productAvailability);
        productInformationRepo.save(productInformation);
        log.info("Loan product Details Has Been Created Successfully");

    }

    private void setProductInformatinToChildEntities(ProductInformation productInformation, ProductAvailability productAvailability) {
        productAvailability.setProductInformation(productInformation);
        LoanAmount loanAmount = productInformation.getLoanAmount();
        loanAmount.setProductInformation(productInformation);
        AccountSettings accountSettings= productInformation.getAccountSettings();
        accountSettings.setProductInformation(productInformation);
        InterestRate interestRate= productInformation.getInterestRate();
        interestRate.setProductInformation(productInformation);
        Repayments repayments= productInformation.getRepayments();
        repayments.setProductInformation(productInformation);
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
