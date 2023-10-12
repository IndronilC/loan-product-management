package com.kanini.loanproduct.controller;

import com.kanini.loanproduct.entity.ProductInformation;
import com.kanini.loanproduct.payload.ProductInformationDto;
import com.kanini.loanproduct.service.ProductInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanProduct")
@Slf4j
public class LoanProductController {

    @Autowired
    private ProductInformationService productInformationService;

    @GetMapping("/products")
    public List<ProductInformationDto> getAllDetails() {
        return productInformationService.getAllDetails();
    }


    @PostMapping("/createproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductInformationDto productInformationDto) {
        log.info("createProduct called in Service");
        productInformationService.createProduct(productInformationDto);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable int productId) {
        productInformationService.deleteProduct(productId);
    }

    @PutMapping("/updateproduct/{productId}")
    public ProductInformation updateProduct(@RequestBody ProductInformation productInformation, @PathVariable int productId) {
        return productInformationService.updateProduct(productInformation, productId);
    }
}
