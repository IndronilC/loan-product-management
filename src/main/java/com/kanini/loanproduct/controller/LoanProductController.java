package com.kanini.loanproduct.controller;

import com.kanini.loanproduct.entity.ProductInformation;
import com.kanini.loanproduct.service.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanProduct")
public class LoanProductController {

    @Autowired
    private ProductInformationService productInformationService;

    @GetMapping("/products")
    public List<ProductInformation> getAllDetails() {
        return productInformationService.getAllDetails();
    }


    @PostMapping("/createproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductInformation productInformation) {
        productInformationService.createProduct(productInformation);
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
