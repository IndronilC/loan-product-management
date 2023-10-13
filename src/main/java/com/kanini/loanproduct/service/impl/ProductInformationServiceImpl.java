package com.kanini.loanproduct.service.impl;

import com.kanini.loanproduct.entity.*;
import com.kanini.loanproduct.payload.ProductInformationDto;
import com.kanini.loanproduct.repository.ProductAvailabilityRepo;
import com.kanini.loanproduct.repository.ProductInformationRepo;
import com.kanini.loanproduct.service.ProductInformationService;
import com.kanini.loanproduct.service.exception.LoanProductBusinessException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductInformationRepo productInformationRepo;
    @Autowired
    private ModelMapper modelMapper;


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
        AccountSettings accountSettings = productInformation.getAccountSettings();
        accountSettings.setProductInformation(productInformation);
        InterestRate interestRate = productInformation.getInterestRate();
        interestRate.setProductInformation(productInformation);
        Repayments repayments = productInformation.getRepayments();
        repayments.setProductInformation(productInformation);
    }

    public void deleteProduct(int productId) {
        ProductInformation productInformation = productInformationRepo.findById(productId).orElse(null);
        productInformationRepo.delete(productInformation);
        log.info("Loan Product Details Has Been Deleted Successfully ");
    }

    /**
     * <p>This method <code>updateProduct</code> has been refactored to ensure that the
     * current code follows the Java 8 nuances to call the
     * <code>productInformationRepo.findById(productId)</code></p> method and the code of this
     * method has modularization to gain horizontal and vertical readability along with
     * distribution of responsibility through the
     * <code>private void setLoadProductRelationship(ProductInformation productInformation)</code>
     * and <code>private void setLoadProductRelationship(ProductInformation productInformation)</code>
     */
    @Transactional
    public ProductInformation updateProduct(ProductInformation productInformation, int productId) {
        Optional<ProductInformation> existProductInformationData = Optional.ofNullable(productInformationRepo.findById(productId)
                .orElseThrow(() -> new LoanProductBusinessException("Loan Product Not Found", new NullPointerException())));
        ProductInformation existProductInformation = getProductInformation
                (productInformation, productId, existProductInformationData);
        log.info("Loan product Details Has Been Updated Successfully");
        return productInformationRepo.save(existProductInformation);
    }
    private ProductInformation getProductInformation(
            ProductInformation productInformation,
            int productId,
            Optional<ProductInformation> existProductInformationData) {
        ProductInformation existProductInformation = null;
        if (existProductInformationData.isPresent() && !Objects.isNull(productInformation)) {
            existProductInformation = getUpdateProductInformation(productInformation, existProductInformationData);
        }
        return existProductInformation;
    }

    private ProductInformation getUpdateProductInformation(
            ProductInformation productInformation,
            Optional<ProductInformation> existProductInformationData) {
        ProductInformation existProductInformation;
        existProductInformation = existProductInformationData.get();
        existProductInformation.setProductId(productInformation.getProductId());
        existProductInformation.setProductName(productInformation.getProductName());
        existProductInformation.setProductType(productInformation.getProductType());
        existProductInformation.setProductCategory(productInformation.getProductCategory());
        existProductInformation.setProductDescription(productInformation.getProductDescription());
        existProductInformation.setStatus(productInformation.getStatus());
        updateProductAvailability(productInformation, existProductInformation);
        updateAccountSettings(productInformation, existProductInformation);
        updateInterestRate(productInformation, existProductInformation);
        updateRepayments(productInformation, existProductInformation);
        updateLoanPayments(productInformation, existProductInformation);
        return existProductInformation;
    }

    private void updateLoanPayments(
            ProductInformation productInformation,
            ProductInformation existProductInformation) {
        if(Objects.nonNull(productInformation.getLoanAmount())){
            existProductInformation.setLoanAmount(productInformation.getLoanAmount());
            productInformation.getLoanAmount().setProductInformation(existProductInformation);
        }
    }

    private void updateRepayments(
            ProductInformation productInformation,
            ProductInformation existProductInformation) {
        if(Objects.nonNull(productInformation.getRepayments())) {
            existProductInformation.setRepayments(productInformation.getRepayments());
            productInformation.getRepayments().setProductInformation(existProductInformation);
        }
    }

    private void updateInterestRate(
            ProductInformation productInformation,
            ProductInformation existProductInformation) {
        if(Objects.nonNull(productInformation.getInterestRate())){
            existProductInformation.setInterestRate(productInformation.getInterestRate());
            productInformation.getInterestRate().setProductInformation(existProductInformation);
        }
    }

    private void updateAccountSettings(
            ProductInformation productInformation,
            ProductInformation existProductInformation) {
        if(Objects.nonNull(productInformation.getAccountSettings())){
           existProductInformation.setAccountSettings(productInformation.getAccountSettings());
           productInformation.getAccountSettings().setProductInformation(existProductInformation);
        }
    }

    private void updateProductAvailability(
            ProductInformation productInformation,
            ProductInformation existProductInformation) {
        if(Objects.nonNull(productInformation.getProductAvailability())){
            existProductInformation.setProductAvailability(productInformation.getProductAvailability());
            productInformation.getProductAvailability().setProductInformation(existProductInformation);
        }
    }
}
