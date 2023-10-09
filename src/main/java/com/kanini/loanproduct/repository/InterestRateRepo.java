package com.kanini.loanproduct.repository;

import com.kanini.loanproduct.entity.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRateRepo extends JpaRepository<InterestRate,Integer>{
}
