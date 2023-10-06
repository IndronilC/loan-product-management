package com.kanini.loanproduct.repository;

import com.kanini.loanproduct.entity.ProductAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAvailabilityRepo extends JpaRepository<ProductAvailability,Integer> {
}
