package com.kanini.loanproduct.controller;

import com.kanini.loanproduct.entity.ProductAvailability;
import com.kanini.loanproduct.entity.ProductInformation;
import com.kanini.loanproduct.service.ProductInformationService;
import com.kanini.loanproduct.service.impl.ProductInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanproduct")
public class LoanProductController {

    @Autowired
    private ProductInformationService productInformationService;

    @GetMapping("/productdetails")
    public List<ProductInformation>getAllDetails(){
        return productInformationService.getAllDetails();
    }

    @PostMapping("/createproduct")
    public ResponseEntity<ProductInformation> createProductWithAvailability(
            @RequestBody ProductInformation productInformation,
            @RequestBody ProductAvailability productAvailability)
    {
       // productInformationService.createProductWithAvailability(productInformation,productAvailability);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
