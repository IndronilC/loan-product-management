package com.kanini.loanproduct.repository;

import com.kanini.loanproduct.entity.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInformationRepo extends JpaRepository<ProductInformation,Integer> {
}
